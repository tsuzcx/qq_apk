package com.tencent.beacon.core.a;

import com.tencent.beacon.core.d.i;
import com.tencent.beacon.core.e.d;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class d$b
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramRunnable = new Thread(paramRunnable, "beacon-thread-" + this.a.getAndIncrement());
      return paramRunnable;
    }
    catch (OutOfMemoryError paramRunnable)
    {
      d.b("[task] memory not enough, create thread failed.", new Object[0]);
      i.a().a("599", "[task] BeaconThreadFactory newThread occur outOfMemoryError!");
      return null;
    }
    catch (Exception paramRunnable)
    {
      for (;;)
      {
        d.a(paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.d.b
 * JD-Core Version:    0.7.0.1
 */