package com.qflutter.audio.log;

import android.util.Log;

public class LogUtils
{
  private static final String TAG = "LogUtils";
  public static ILog sLog;
  
  public static void d(String paramString1, String paramString2)
  {
    ILog localILog = sLog;
    if (localILog != null)
    {
      localILog.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    ILog localILog = sLog;
    if (localILog != null)
    {
      localILog.e(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    ILog localILog = sLog;
    if (localILog != null)
    {
      localILog.i(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void setLog(ILog paramILog)
  {
    ILog localILog = sLog;
    if (localILog != null) {
      localILog.e("LogUtils", "changing logger!");
    }
    sLog = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    ILog localILog = sLog;
    if (localILog != null)
    {
      localILog.v(paramString1, paramString2);
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    ILog localILog = sLog;
    if (localILog != null)
    {
      localILog.w(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.audio.log.LogUtils
 * JD-Core Version:    0.7.0.1
 */