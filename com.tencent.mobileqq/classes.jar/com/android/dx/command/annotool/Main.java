package com.android.dx.command.annotool;

import java.io.PrintStream;

public class Main
{
  public static void main(String[] paramArrayOfString)
  {
    Main.Arguments localArguments = new Main.Arguments();
    try
    {
      localArguments.parse(paramArrayOfString);
      new AnnotationLister(localArguments).process();
      return;
    }
    catch (Main.InvalidArgumentException paramArrayOfString)
    {
      System.err.println(paramArrayOfString.getMessage());
      throw new RuntimeException("usage");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.annotool.Main
 * JD-Core Version:    0.7.0.1
 */