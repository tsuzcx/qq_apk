package com.tencent.beacon.core.event;

import com.tencent.beacon.core.d.b;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    b.f(a.a(this.a, "[event] -> do sync db and upload task."), new Object[0]);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.event.a.1
 * JD-Core Version:    0.7.0.1
 */