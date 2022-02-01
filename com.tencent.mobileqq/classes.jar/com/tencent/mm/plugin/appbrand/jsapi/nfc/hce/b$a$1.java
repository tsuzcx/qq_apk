package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.luggage.wxa.qz.o;

class b$a$1
  implements Runnable
{
  b$a$1(b.a parama) {}
  
  public void run()
  {
    o.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService timer check, timeLimit: %d, hasCommandNotResponded: %b", new Object[] { Integer.valueOf(b.b(this.a.a)), Boolean.valueOf(b.c(this.a.a)) });
    b.c(this.a.a, true);
    b.a(this.a.a, b.c(), true, b.d(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b.a.1
 * JD-Core Version:    0.7.0.1
 */