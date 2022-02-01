package com.tencent.luggage.wxa.gd;

import com.tencent.luggage.wxa.mi.b;
import java.util.concurrent.atomic.AtomicBoolean;

class d$29$2
  implements Runnable
{
  d$29$2(d.29 param29) {}
  
  public void run()
  {
    if (d.F(this.a.a).get()) {
      return;
    }
    if (d.g(this.a.a) != null)
    {
      d.g(this.a.a).a(d.G(this.a.a));
      if (!d.g(this.a.a).f()) {
        d.a(this.a.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d.29.2
 * JD-Core Version:    0.7.0.1
 */