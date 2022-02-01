package com.idlefish.flutterboost;

import com.idlefish.flutterboost.log.AndroidLog;
import com.idlefish.flutterboost.log.ILog;

public class Debuger
{
  private static final Debuger DEBUG = new Debuger();
  private static final String TAG = "FlutterBoost#";
  private static ILog sLog = new AndroidLog();
  private static boolean sSafeMode = false;
  
  private static boolean canThrowError()
  {
    return (isDebug()) && (!sSafeMode);
  }
  
  public static void exception(String paramString)
  {
    if (!canThrowError())
    {
      sLog.e("FlutterBoost#", "exception", new RuntimeException(paramString));
      return;
    }
    throw new RuntimeException(paramString);
  }
  
  public static void exception(Throwable paramThrowable)
  {
    if (!canThrowError())
    {
      sLog.e("FlutterBoost#", "exception", paramThrowable);
      return;
    }
    throw new RuntimeException(paramThrowable);
  }
  
  public static boolean isDebug()
  {
    try
    {
      boolean bool = FlutterBoost.instance().platform().isDebug();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static void log(String paramString)
  {
    DEBUG.print(paramString);
  }
  
  private void print(String paramString)
  {
    if (isDebug()) {
      sLog.e("FlutterBoost#", paramString);
    }
  }
  
  public static void setLog(ILog paramILog)
  {
    if (paramILog != null) {
      sLog = paramILog;
    }
  }
  
  public static void setSafeMode(boolean paramBoolean)
  {
    sSafeMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.idlefish.flutterboost.Debuger
 * JD-Core Version:    0.7.0.1
 */