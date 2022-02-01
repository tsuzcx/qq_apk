package com.tencent.luggage.wxa.io;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class a
  implements b
{
  private final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor();
  
  public Future<?> a(Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    return this.a.scheduleWithFixedDelay(paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.io.a
 * JD-Core Version:    0.7.0.1
 */