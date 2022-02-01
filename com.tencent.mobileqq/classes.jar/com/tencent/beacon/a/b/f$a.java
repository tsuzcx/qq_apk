package com.tencent.beacon.a.b;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class f$a
{
  private final Runnable a;
  private final long b;
  private final long c;
  private final TimeUnit d;
  private Future<?> e;
  
  f$a(Future<?> paramFuture, Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    this.e = paramFuture;
    this.a = paramRunnable;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramTimeUnit;
  }
  
  boolean a()
  {
    return this.e.isCancelled();
  }
  
  boolean a(boolean paramBoolean)
  {
    return this.e.cancel(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */