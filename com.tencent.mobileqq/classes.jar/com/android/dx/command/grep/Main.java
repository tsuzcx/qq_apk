package com.android.dx.command.grep;

import com.android.dex.Dex;
import java.io.File;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public final class Main
{
  public static void main(String[] paramArrayOfString)
  {
    int i = 0;
    String str = paramArrayOfString[0];
    paramArrayOfString = paramArrayOfString[1];
    if (new Grep(new Dex(new File(str)), Pattern.compile(paramArrayOfString), new PrintWriter(System.out)).grep() > 0) {}
    for (;;)
    {
      System.exit(i);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.grep.Main
 * JD-Core Version:    0.7.0.1
 */