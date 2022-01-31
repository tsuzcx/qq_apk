package com.tencent.ditto.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class DittoLog
{
  public static final String defaultTag = "DITTO_UI";
  private static Log sLog;
  
  public static void d(String paramString)
  {
    d("DITTO_UI", paramString);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLog != null)
    {
      sLog.d(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString)
  {
    e("DITTO_UI", paramString);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLog != null)
    {
      sLog.e(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static Log getLog()
  {
    return sLog;
  }
  
  public static String getTraceString(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static void i(String paramString)
  {
    i("DITTO_UI", paramString);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLog != null)
    {
      sLog.i(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean isColoredLevel()
  {
    return (sLog != null) && (sLog.isColoredLevel());
  }
  
  public static void setLog(Log paramLog)
  {
    sLog = paramLog;
  }
  
  public static void v(String paramString)
  {
    v("DITTO_UI", paramString);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLog != null)
    {
      sLog.v(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString)
  {
    w("DITTO_UI", paramString);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLog != null)
    {
      sLog.w(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.utils.DittoLog
 * JD-Core Version:    0.7.0.1
 */