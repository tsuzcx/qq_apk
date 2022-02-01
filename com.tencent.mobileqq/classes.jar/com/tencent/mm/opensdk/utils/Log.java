package com.tencent.mm.opensdk.utils;

public class Log
{
  private static ILog logImpl;
  
  public static void d(String paramString1, String paramString2)
  {
    ILog localILog = logImpl;
    if (localILog == null)
    {
      android.util.Log.d(paramString1, paramString2);
      return;
    }
    localILog.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    ILog localILog = logImpl;
    if (localILog == null)
    {
      android.util.Log.e(paramString1, paramString2);
      return;
    }
    localILog.e(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    ILog localILog = logImpl;
    if (localILog == null)
    {
      android.util.Log.i(paramString1, paramString2);
      return;
    }
    localILog.i(paramString1, paramString2);
  }
  
  public static void setLogImpl(ILog paramILog)
  {
    logImpl = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    ILog localILog = logImpl;
    if (localILog == null)
    {
      android.util.Log.v(paramString1, paramString2);
      return;
    }
    localILog.v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    ILog localILog = logImpl;
    if (localILog == null)
    {
      android.util.Log.w(paramString1, paramString2);
      return;
    }
    localILog.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.Log
 * JD-Core Version:    0.7.0.1
 */