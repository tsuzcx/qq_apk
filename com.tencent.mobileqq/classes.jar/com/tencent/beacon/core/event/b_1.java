package com.tencent.beacon.core.event;

import com.tencent.beacon.core.e.d;
import java.util.List;

class b
  implements Runnable
{
  b(c paramc, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    d.f(c.a(this.c, "[event] -> do sync db and upload task."), new Object[0]);
    this.c.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.b
 * JD-Core Version:    0.7.0.1
 */