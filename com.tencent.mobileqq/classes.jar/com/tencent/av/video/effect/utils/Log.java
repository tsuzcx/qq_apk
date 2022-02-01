package com.tencent.av.video.effect.utils;

import com.tencent.av.video.effect.QavVideoEffect;

public final class Log
{
  public static void d(String paramString, Object paramObject)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.d(paramString, String.valueOf(paramObject));
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.i(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.v(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.v(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.w(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    if (QavVideoEffect.DEBUG_MODE) {
      android.util.Log.w(paramString, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.utils.Log
 * JD-Core Version:    0.7.0.1
 */