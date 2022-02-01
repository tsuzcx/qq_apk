package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.luggage.wxa.li.d;
import com.tencent.luggage.wxa.qz.o;

class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1) {}
  
  public void run()
  {
    if (a.a(this.a.a) > 10)
    {
      o.d("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", new Object[] { Integer.valueOf(10) });
      a.c(this.a.a);
      a.d(this.a.a);
      return;
    }
    if (d.d())
    {
      o.d("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
      a.c(this.a.a);
      a.a(this.a.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.1.1
 * JD-Core Version:    0.7.0.1
 */