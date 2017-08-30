import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {

    File inFile = new File(args[0]);
    File outFile = new File(args[1]);
    Scanner scanner = new Scanner(inFile);
    BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
    if (!outFile.exists()) {
      outFile.createNewFile();
    }

    int testNum = scanner.nextInt();
    scanner.nextLine();
    for (int i = 1; i <= testNum; i++) {
      //algorithm
      char[] a=scanner.nextLine().toCharArray();
      char[] b = scanner.nextLine().toCharArray();
      System.out.println(a);

      Main m = new Main();

      boolean result = m.f(a, b, 0, 0);
      if (result) {
        bw.write("Case #" + i + ": TRUE");
      } else {
        bw.write("Case #" + i + ": FALSE");
      }
      bw.newLine();
    }

    scanner.close();
    bw.close();
  }

  public boolean f(char[] a, char[] b, int i, int j) {
    if (i > a.length - 1 && j > b.length - 1) {
      return true;
    } else if (i > a.length - 1) {
      for (int t = j; t < b.length; t++) {
        if (b[t] != '*') return false;
      }
      return true;
    } else if (j > b.length - 1) {
      for (int t = j; t < a.length; t++) {
        if (a[t] != '*') return false;
      }
      return true;
    } else {
      System.out.println(a[i] + " " + b[j]);
      if (a[i] == '*') {
        if (f(a, b, i + 1, j) || f(a, b, i + 1, j + 1) || f(a, b, i + 1, j + 2) || f(a, b, i + 1, j + 3) || f(a, b, i + 1, j + 4)) {
          return true;
        }
      } else if (b[j] == '*') {
        if (f(a, b, i, j + 1) || f(a, b, i + 1, j + 1) || f(a, b, i + 2, j + 1) || f(a, b, i + 3, j + 1) || f(a, b, i + 4, j + 1)) {
          return true;
        }
      } else {
        if (a[i] == b[j] && f(a, b, i + 1, j + 1)) {
          return true;
        } else {
          return false;
        }
      }
    }
    return false;
  }


}
