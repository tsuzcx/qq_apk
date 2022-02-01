package com.qflutter.vistaplayer;

import android.util.Log;

public class VistaPlayerLog
{
  private static IVistaPlayerLog logImpl;
  
  static void d(String paramString1, String paramString2)
  {
    IVistaPlayerLog localIVistaPlayerLog = logImpl;
    if (localIVistaPlayerLog != null)
    {
      localIVistaPlayerLog.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  static void e(String paramString1, String paramString2)
  {
    IVistaPlayerLog localIVistaPlayerLog = logImpl;
    if (localIVistaPlayerLog != null)
    {
      localIVistaPlayerLog.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IVistaPlayerLog localIVistaPlayerLog = logImpl;
    if (localIVistaPlayerLog != null)
    {
      localIVistaPlayerLog.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  static void i(String paramString1, String paramString2)
  {
    IVistaPlayerLog localIVistaPlayerLog = logImpl;
    if (localIVistaPlayerLog != null)
    {
      localIVistaPlayerLog.i(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void init(IVistaPlayerLog paramIVistaPlayerLog)
  {
    logImpl = paramIVistaPlayerLog;
  }
  
  public static boolean isColorLevel()
  {
    IVistaPlayerLog localIVistaPlayerLog = logImpl;
    if (localIVistaPlayerLog != null) {
      return localIVistaPlayerLog.isColorLevel();
    }
    return true;
  }
  
  static void w(String paramString1, String paramString2)
  {
    IVistaPlayerLog localIVistaPlayerLog = logImpl;
    if (localIVistaPlayerLog != null)
    {
      localIVistaPlayerLog.w(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IVistaPlayerLog localIVistaPlayerLog = logImpl;
    if (localIVistaPlayerLog != null)
    {
      localIVistaPlayerLog.w(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaplayer.VistaPlayerLog
 * JD-Core Version:    0.7.0.1
 */