package com.tencent.luggage.wxa.gd;

import com.tencent.luggage.wxa.mi.b;
import java.util.concurrent.atomic.AtomicBoolean;

class d$29$1$1
  implements Runnable
{
  d$29$1$1(d.29.1 param1) {}
  
  public void run()
  {
    if (!d.F(this.a.a.a).get()) {
      return;
    }
    if (d.g(this.a.a.a) != null)
    {
      d.g(this.a.a.a).a(null);
      if (!d.g(this.a.a.a).f()) {
        d.a(this.a.a.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d.29.1.1
 * JD-Core Version:    0.7.0.1
 */