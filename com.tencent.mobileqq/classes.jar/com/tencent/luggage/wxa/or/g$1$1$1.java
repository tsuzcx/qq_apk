package com.tencent.luggage.wxa.or;

import com.tencent.luggage.wxa.qz.o;
import java.util.Timer;

class g$1$1$1
  implements Runnable
{
  g$1$1$1(g.1.1 param1) {}
  
  public void run()
  {
    o.c("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
    g.b(this.a.a.b);
    if (g.c(this.a.a.b) > 3)
    {
      if (g.d(this.a.a.b) != null) {
        g.d(this.a.a.b).a();
      }
      g.e(this.a.a.b).cancel();
      return;
    }
    if (g.d(this.a.a.b) != null) {
      g.d(this.a.a.b).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.g.1.1.1
 * JD-Core Version:    0.7.0.1
 */