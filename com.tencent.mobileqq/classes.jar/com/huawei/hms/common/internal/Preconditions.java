package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.Looper;

public final class Preconditions
{
  public Preconditions()
  {
    throw new AssertionError("Cannot use constructor to make a new instance");
  }
  
  public static boolean a()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void checkHandlerThread(Handler paramHandler)
  {
    checkHandlerThread(paramHandler, "Must be called on the handler thread");
  }
  
  public static void checkHandlerThread(Handler paramHandler, String paramString)
  {
    if (Looper.myLooper() == paramHandler.getLooper()) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
  
  public static void checkMainThread(String paramString)
  {
    if (a()) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
  
  public static void checkNotMainThread()
  {
    if (!a()) {
      return;
    }
    throw new IllegalStateException("Must not be called on the main application thread");
  }
  
  public static <O> O checkNotNull(O paramO)
  {
    if (paramO != null) {
      return paramO;
    }
    throw new NullPointerException("must not refer to a null object");
  }
  
  public static <O> O checkNotNull(O paramO, Object paramObject)
  {
    if (paramO != null) {
      return paramO;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.Preconditions
 * JD-Core Version:    0.7.0.1
 */