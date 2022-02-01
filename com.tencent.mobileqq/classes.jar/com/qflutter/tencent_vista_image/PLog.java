package com.qflutter.tencent_vista_image;

import android.util.Log;

public final class PLog
{
  private static ILog logImpl;
  
  static void d(String paramString1, String paramString2)
  {
    if (logImpl != null)
    {
      logImpl.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  static void e(String paramString1, String paramString2)
  {
    if (logImpl != null)
    {
      logImpl.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (logImpl != null)
    {
      logImpl.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  static void i(String paramString1, String paramString2)
  {
    if (logImpl != null)
    {
      logImpl.i(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void init(ILog paramILog)
  {
    logImpl = paramILog;
  }
  
  static boolean isColorLevel()
  {
    if (logImpl != null) {
      return logImpl.isColorLevel();
    }
    return true;
  }
  
  static void w(String paramString1, String paramString2)
  {
    if (logImpl != null)
    {
      logImpl.w(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (logImpl != null)
    {
      logImpl.w(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.PLog
 * JD-Core Version:    0.7.0.1
 */