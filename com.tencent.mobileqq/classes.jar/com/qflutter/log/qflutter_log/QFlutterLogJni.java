package com.qflutter.log.qflutter_log;

import android.util.Log;

public class QFlutterLogJni
{
  private static volatile String sTag = "QFlutter";
  
  public static void d(String paramString)
  {
    if (QflutterLogPlugin.sLog != null)
    {
      QflutterLogPlugin.sLog.d(paramString);
      return;
    }
    Log.d(sTag, paramString);
  }
  
  public static void e(String paramString)
  {
    if (QflutterLogPlugin.sLog != null)
    {
      QflutterLogPlugin.sLog.e(paramString);
      return;
    }
    Log.e(sTag, paramString);
  }
  
  public static int getLevel()
  {
    if (QflutterLogPlugin.sLog != null) {
      return QflutterLogPlugin.sLog.getLogLevel();
    }
    return 5;
  }
  
  public static void i(String paramString)
  {
    if (QflutterLogPlugin.sLog != null)
    {
      QflutterLogPlugin.sLog.i(paramString);
      return;
    }
    Log.i(sTag, paramString);
  }
  
  public static void v(String paramString)
  {
    if (QflutterLogPlugin.sLog != null)
    {
      QflutterLogPlugin.sLog.v(paramString);
      return;
    }
    Log.v(sTag, paramString);
  }
  
  public static void w(String paramString)
  {
    if (QflutterLogPlugin.sLog != null)
    {
      QflutterLogPlugin.sLog.w(paramString);
      return;
    }
    Log.w(sTag, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.log.qflutter_log.QFlutterLogJni
 * JD-Core Version:    0.7.0.1
 */