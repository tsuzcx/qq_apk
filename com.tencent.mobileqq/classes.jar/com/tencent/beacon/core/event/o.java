package com.tencent.beacon.core.event;

import com.tencent.beacon.core.e.d;

class o
  implements Runnable
{
  o(q paramq) {}
  
  public void run()
  {
    d.f(q.a(this.a, "[realtime event] -> do sync upload task."), new Object[0]);
    try
    {
      this.a.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.o
 * JD-Core Version:    0.7.0.1
 */