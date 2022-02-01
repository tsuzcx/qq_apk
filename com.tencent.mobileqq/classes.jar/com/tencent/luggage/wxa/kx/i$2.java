package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;

class i$2
  implements Runnable
{
  i$2(i parami) {}
  
  public void run()
  {
    if (i.a(this.a) == null) {
      return;
    }
    long l = System.currentTimeMillis() - i.b(this.a);
    if (l < 3000L)
    {
      t.a(new i.2.1(this), 3000L - l);
      return;
    }
    i.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.i.2
 * JD-Core Version:    0.7.0.1
 */