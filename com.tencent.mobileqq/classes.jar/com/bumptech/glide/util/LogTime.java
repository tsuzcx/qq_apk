package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

public final class LogTime
{
  private static final double a;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    double d = 1.0D;
    if (i >= 17) {
      d = 1.0D / Math.pow(10.0D, 6.0D);
    }
    a = d;
  }
  
  public static double a(long paramLong)
  {
    double d1 = a() - paramLong;
    double d2 = a;
    Double.isNaN(d1);
    return d1 * d2;
  }
  
  @TargetApi(17)
  public static long a()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return SystemClock.elapsedRealtimeNanos();
    }
    return SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.LogTime
 * JD-Core Version:    0.7.0.1
 */