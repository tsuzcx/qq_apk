package com.tencent.beacon.a.b;

import com.tencent.beacon.base.util.c;
import java.util.concurrent.atomic.AtomicInteger;

class e
  implements Runnable
{
  e(f paramf, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (f.c().addAndGet(1) < 100) {
        d.b().a("599", "[task] run occur error!", localThrowable);
      }
      com.tencent.beacon.base.util.e.a(localThrowable.getMessage());
      c.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.b.e
 * JD-Core Version:    0.7.0.1
 */