package com.qflutter.vistaimage;

import android.util.Log;

public final class VistaImageLog
{
  private static IVistaImageLog logImpl;
  
  static void d(String paramString1, String paramString2)
  {
    IVistaImageLog localIVistaImageLog = logImpl;
    if (localIVistaImageLog != null)
    {
      localIVistaImageLog.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  static void e(String paramString1, String paramString2)
  {
    IVistaImageLog localIVistaImageLog = logImpl;
    if (localIVistaImageLog != null)
    {
      localIVistaImageLog.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IVistaImageLog localIVistaImageLog = logImpl;
    if (localIVistaImageLog != null)
    {
      localIVistaImageLog.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  static void i(String paramString1, String paramString2)
  {
    IVistaImageLog localIVistaImageLog = logImpl;
    if (localIVistaImageLog != null)
    {
      localIVistaImageLog.i(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void init(IVistaImageLog paramIVistaImageLog)
  {
    logImpl = paramIVistaImageLog;
  }
  
  static boolean isColorLevel()
  {
    IVistaImageLog localIVistaImageLog = logImpl;
    if (localIVistaImageLog != null) {
      return localIVistaImageLog.isColorLevel();
    }
    return true;
  }
  
  static void w(String paramString1, String paramString2)
  {
    IVistaImageLog localIVistaImageLog = logImpl;
    if (localIVistaImageLog != null)
    {
      localIVistaImageLog.w(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IVistaImageLog localIVistaImageLog = logImpl;
    if (localIVistaImageLog != null)
    {
      localIVistaImageLog.w(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageLog
 * JD-Core Version:    0.7.0.1
 */