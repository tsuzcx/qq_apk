package com.tencent.beacon.core.event;

import com.tencent.beacon.core.d.b;

final class f$1
  implements Runnable
{
  f$1(f paramf) {}
  
  public final void run()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.event.f.1
 * JD-Core Version:    0.7.0.1
 */