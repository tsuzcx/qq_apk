package com.tencent.ilivesdk.avpreloadservice;

import android.util.Log;
import com.tencent.falco.base.libapi.log.LogInterface;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AVPreloadLog
{
  private static LogInterface a;
  
  private static String a(Throwable paramThrowable, String paramString)
  {
    String str2 = "generateThrowableString err";
    String str1 = str2;
    try
    {
      new ByteArrayOutputStream();
      str1 = str2;
      paramString = b(paramThrowable, paramString);
      str1 = paramString;
      paramThrowable = paramString + a(paramThrowable.getStackTrace(), "");
      return paramThrowable;
    }
    catch (IOException paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
    return str1;
  }
  
  public static String a(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramArrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
        localStringBuilder.append(paramString).append(localStackTraceElement).append("\n");
        i += 1;
      }
      paramArrayOfStackTraceElement = localStringBuilder.toString();
      return paramArrayOfStackTraceElement;
    }
    catch (Exception paramArrayOfStackTraceElement)
    {
      paramArrayOfStackTraceElement.printStackTrace();
    }
    return "generateStackTraceString err";
  }
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(LogInterface paramLogInterface)
  {
    a = paramLogInterface;
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a != null)
    {
      a.d(paramString1, paramString2, paramVarArgs);
      return;
    }
    Log.d(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    if (a != null)
    {
      a.printStackTrace(paramThrowable);
      return;
    }
    Log.e(paramString1, a(paramThrowable, paramString2));
  }
  
  public static void a(Throwable paramThrowable)
  {
    a("", paramThrowable, "");
  }
  
  private static String b(Throwable paramThrowable, String paramString)
  {
    paramString = new StringBuilder().append(paramString);
    paramString.append(": ").append(paramThrowable.getMessage()).append("\n");
    return paramString.toString();
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a != null)
    {
      a.i(paramString1, paramString2, paramVarArgs);
      return;
    }
    Log.i(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a != null)
    {
      a.e(paramString1, paramString2, paramVarArgs);
      return;
    }
    Log.e(paramString1, String.format(paramString2, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadLog
 * JD-Core Version:    0.7.0.1
 */