package com.qflutter.superchannel;

import android.util.Log;

public class SuperChannelLog
{
  private static ISuperChannelLog logImpl;
  
  public static void d(String paramString1, String paramString2)
  {
    ISuperChannelLog localISuperChannelLog = logImpl;
    if (localISuperChannelLog != null)
    {
      localISuperChannelLog.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    ISuperChannelLog localISuperChannelLog = logImpl;
    if (localISuperChannelLog != null)
    {
      localISuperChannelLog.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ISuperChannelLog localISuperChannelLog = logImpl;
    if (localISuperChannelLog != null)
    {
      localISuperChannelLog.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    ISuperChannelLog localISuperChannelLog = logImpl;
    if (localISuperChannelLog != null)
    {
      localISuperChannelLog.i(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void init(ISuperChannelLog paramISuperChannelLog)
  {
    logImpl = paramISuperChannelLog;
  }
  
  public static boolean isColorLevel()
  {
    ISuperChannelLog localISuperChannelLog = logImpl;
    if (localISuperChannelLog != null) {
      return localISuperChannelLog.isColorLevel();
    }
    return true;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    ISuperChannelLog localISuperChannelLog = logImpl;
    if (localISuperChannelLog != null)
    {
      localISuperChannelLog.w(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ISuperChannelLog localISuperChannelLog = logImpl;
    if (localISuperChannelLog != null)
    {
      localISuperChannelLog.w(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.superchannel.SuperChannelLog
 * JD-Core Version:    0.7.0.1
 */