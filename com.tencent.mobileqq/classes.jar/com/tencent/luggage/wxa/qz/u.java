package com.tencent.luggage.wxa.qz;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class u
{
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
      paramThrowable.printStackTrace(localPrintStream);
      paramThrowable = localByteArrayOutputStream.toString();
      localPrintStream.close();
      localByteArrayOutputStream.close();
      return paramThrowable;
    }
    catch (Exception paramThrowable) {}
    return "";
  }
  
  public static String a(boolean paramBoolean)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length >= 4))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i = 3;
      while (i < arrayOfStackTraceElement.length)
      {
        if ((arrayOfStackTraceElement[i].getClassName().contains("com.tencent.mm")) && (!arrayOfStackTraceElement[i].getClassName().contains("sdk.platformtools.Log")))
        {
          localStringBuilder1.append("[");
          localStringBuilder1.append(arrayOfStackTraceElement[i].getClassName().substring(15));
          localStringBuilder1.append(":");
          localStringBuilder1.append(arrayOfStackTraceElement[i].getMethodName());
          if (paramBoolean)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("(");
            localStringBuilder2.append(arrayOfStackTraceElement[i].getLineNumber());
            localStringBuilder2.append(")]");
            localStringBuilder1.append(localStringBuilder2.toString());
          }
          else
          {
            localStringBuilder1.append("]");
          }
        }
        i += 1;
      }
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  public String toString()
  {
    return a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.u
 * JD-Core Version:    0.7.0.1
 */