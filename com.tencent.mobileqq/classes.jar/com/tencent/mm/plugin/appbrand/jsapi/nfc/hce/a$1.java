package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.qz.o;
import java.util.TimerTask;

class a$1
  extends TimerTask
{
  a$1(a parama) {}
  
  public void run()
  {
    o.d("MicroMsg.HCEActivityMgr", "alvinluo loop check NFC switch currentCount: %d", new Object[] { Integer.valueOf(a.a(this.a)) });
    a.b(this.a);
    l.a(new a.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.1
 * JD-Core Version:    0.7.0.1
 */