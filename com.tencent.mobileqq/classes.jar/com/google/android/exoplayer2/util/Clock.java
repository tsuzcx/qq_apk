package com.google.android.exoplayer2.util;

import android.os.Handler.Callback;
import android.os.Looper;
import android.support.annotation.Nullable;

public abstract interface Clock
{
  public static final Clock DEFAULT = new SystemClock();
  
  public abstract HandlerWrapper createHandler(Looper paramLooper, @Nullable Handler.Callback paramCallback);
  
  public abstract long elapsedRealtime();
  
  public abstract void sleep(long paramLong);
  
  public abstract long uptimeMillis();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.util.Clock
 * JD-Core Version:    0.7.0.1
 */