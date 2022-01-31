package com.tencent.beacon.core.event;

import com.tencent.beacon.core.d.b;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    b.f(h.a(this.a, "[realtime event] -> do sync upload task."), new Object[0]);
    try
    {
      this.a.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.h.1
 * JD-Core Version:    0.7.0.1
 */