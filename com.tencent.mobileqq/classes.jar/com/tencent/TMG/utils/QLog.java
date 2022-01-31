package com.tencent.TMG.utils;

import android.util.Log;

public class QLog
{
  public static final int CLR = 0;
  public static final int DEBUG = 3;
  public static final int ERROR = 1;
  public static final int INFO = 2;
  public static final int USR = 1;
  public static final int VERBOSE = 4;
  private static volatile boolean useAvsdkLogger = false;
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    if (useAvsdkLogger)
    {
      writeLog(3, paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (useAvsdkLogger)
    {
      writeLog(3, paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    if (useAvsdkLogger)
    {
      writeLog(1, paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (useAvsdkLogger)
    {
      writeLog(1, paramString1, paramString2 + Log.getStackTraceString(paramException));
      return;
    }
    Log.e(paramString1, paramString2 + Log.getStackTraceString(paramException));
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    if (useAvsdkLogger)
    {
      writeLog(2, paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (useAvsdkLogger)
    {
      writeLog(2, paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static boolean isColorLevel()
  {
    return true;
  }
  
  public static void setUseAvsdkLogger(boolean paramBoolean)
  {
    useAvsdkLogger = paramBoolean;
  }
  
  public static void v(String paramString1, int paramInt, String paramString2)
  {
    if (useAvsdkLogger)
    {
      writeLog(4, paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void v(String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (useAvsdkLogger)
    {
      writeLog(4, paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    if (useAvsdkLogger)
    {
      writeLog(1, paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (useAvsdkLogger)
    {
      writeLog(1, paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static native void writeLog(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.utils.QLog
 * JD-Core Version:    0.7.0.1
 */