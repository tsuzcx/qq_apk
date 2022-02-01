package com.tencent.luggage.wxa.sa;

import com.tencent.luggage.wxa.sj.h;
import com.tencent.luggage.wxa.sj.i;
import com.tencent.luggage.wxa.sk.e;
import java.util.concurrent.TimeUnit;

public class a
{
  private static long a(long paramLong)
  {
    long l = System.nanoTime();
    if (paramLong >= 4611686018427387903L) {
      paramLong = 4611686018427387903L;
    }
    return l + paramLong;
  }
  
  private static long a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit == null) {
      return System.nanoTime();
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    return a(paramTimeUnit.toNanos(l));
  }
  
  public static i<?> a(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    paramLong2 = TimeUnit.NANOSECONDS.convert(paramLong2, TimeUnit.MILLISECONDS);
    long l = a(paramLong1, TimeUnit.MILLISECONDS);
    paramLong1 = paramLong2;
    if (paramBoolean) {
      paramLong1 = -paramLong2;
    }
    return new i(paramRunnable, l, paramLong1, a(paramRunnable));
  }
  
  public static i<?> a(Runnable paramRunnable, long paramLong, String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return new e(paramRunnable, a(paramLong, TimeUnit.MILLISECONDS), paramString, a(paramRunnable));
    }
    return new i(paramRunnable, a(paramLong, TimeUnit.MILLISECONDS), a(paramRunnable));
  }
  
  private static boolean a(Object paramObject)
  {
    if ((paramObject instanceof h)) {
      return ((h)paramObject).c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sa.a
 * JD-Core Version:    0.7.0.1
 */