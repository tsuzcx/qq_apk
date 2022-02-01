package com.huawei.hms.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public final class Checker
{
  public static void assertHandlerThread(Handler paramHandler)
  {
    assertHandlerThread(paramHandler, "Must be called on the handler thread");
  }
  
  public static void assertHandlerThread(Handler paramHandler, String paramString)
  {
    if (Looper.myLooper() != paramHandler.getLooper()) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void assertNonEmpty(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalStateException("Given String is empty or null");
    }
  }
  
  public static void assertNonEmpty(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalStateException(String.valueOf(paramString2));
    }
  }
  
  public static <T> T assertNonNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException("Null reference");
    }
    return paramT;
  }
  
  public static <T> T assertNonNull(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramString));
    }
    return paramT;
  }
  
  public static void assertNotUiThread(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void assertUiThread(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static String checkNonEmpty(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Given String is empty or null");
    }
    return paramString;
  }
  
  public static String checkNonEmpty(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException(String.valueOf(paramString2));
    }
    return paramString1;
  }
  
  public static <T> T checkNonNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException("Null reference");
    }
    return paramT;
  }
  
  public static <T> T checkNonNull(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramString));
    }
    return paramT;
  }
  
  public static int checkNonZero(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Given Integer is zero");
    }
    return paramInt;
  }
  
  public static int checkNonZero(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException(String.valueOf(paramString));
    }
    return paramInt;
  }
  
  public static long checkNotZero(long paramLong)
  {
    if (paramLong == 0L) {
      throw new IllegalArgumentException("Given Long is zero");
    }
    return paramLong;
  }
  
  public static long checkNotZero(long paramLong, String paramString)
  {
    if (paramLong == 0L) {
      throw new IllegalArgumentException(String.valueOf(paramString));
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.utils.Checker
 * JD-Core Version:    0.7.0.1
 */