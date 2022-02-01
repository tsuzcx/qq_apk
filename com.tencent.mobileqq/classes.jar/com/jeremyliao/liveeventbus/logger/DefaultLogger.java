package com.jeremyliao.liveeventbus.logger;

import android.util.Log;
import java.util.logging.Level;

public class DefaultLogger
  implements Logger
{
  private static final String TAG = "[LiveEventBus]";
  
  public void log(Level paramLevel, String paramString)
  {
    if (paramLevel == Level.SEVERE) {
      Log.e("[LiveEventBus]", paramString);
    }
    do
    {
      return;
      if (paramLevel == Level.WARNING)
      {
        Log.w("[LiveEventBus]", paramString);
        return;
      }
      if (paramLevel == Level.INFO)
      {
        Log.i("[LiveEventBus]", paramString);
        return;
      }
      if (paramLevel == Level.CONFIG)
      {
        Log.d("[LiveEventBus]", paramString);
        return;
      }
    } while (paramLevel == Level.OFF);
    Log.v("[LiveEventBus]", paramString);
  }
  
  public void log(Level paramLevel, String paramString, Throwable paramThrowable)
  {
    if (paramLevel == Level.SEVERE) {
      Log.e("[LiveEventBus]", paramString, paramThrowable);
    }
    do
    {
      return;
      if (paramLevel == Level.WARNING)
      {
        Log.w("[LiveEventBus]", paramString, paramThrowable);
        return;
      }
      if (paramLevel == Level.INFO)
      {
        Log.i("[LiveEventBus]", paramString, paramThrowable);
        return;
      }
      if (paramLevel == Level.CONFIG)
      {
        Log.d("[LiveEventBus]", paramString, paramThrowable);
        return;
      }
    } while (paramLevel == Level.OFF);
    Log.v("[LiveEventBus]", paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.logger.DefaultLogger
 * JD-Core Version:    0.7.0.1
 */