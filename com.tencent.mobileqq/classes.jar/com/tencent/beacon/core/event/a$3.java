package com.tencent.beacon.core.event;

import com.tencent.beacon.core.d.b;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    b.f(a.a(this.a, "[event] -> do max size upload task."), new Object[0]);
    try
    {
      a.a(this.a).b(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.event.a.3
 * JD-Core Version:    0.7.0.1
 */