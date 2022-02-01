package com.tencent.falco.base.floatwindow.utils;

import android.util.Log;

public class Logger
{
  private static boolean logEnable = true;
  private static final String log_tag = "FWLogger";
  
  public static void d(Object paramObject)
  {
    d("FWLogger", paramObject.toString());
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (logEnable) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void e(Object paramObject)
  {
    e("FWLogger", paramObject.toString());
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (logEnable) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void i(Object paramObject)
  {
    i("FWLogger", paramObject.toString());
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (logEnable) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void v(Object paramObject)
  {
    v("FWLogger", paramObject.toString());
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (logEnable) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void w(Object paramObject)
  {
    w("FWLogger", paramObject.toString());
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (logEnable) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.utils.Logger
 * JD-Core Version:    0.7.0.1
 */