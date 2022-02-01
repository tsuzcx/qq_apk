package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.wxa.qz.o;
import java.util.TimerTask;

class i$4
  extends TimerTask
{
  i$4(i parami) {}
  
  public void run()
  {
    if ((i.a(this.a).u()) && (this.a.c()))
    {
      o.d("MicroMsg.RemoteDebugMsgMrg", "testServer");
    }
    else
    {
      this.a.b();
      long l = System.currentTimeMillis();
      if (l - i.a(this.a).p() >= 10000L) {
        this.a.j();
      }
      if ((i.a(this.a).x()) && (l - i.a(this.a).r() >= 30000L))
      {
        i locali = this.a;
        locali.a(i.a(locali).d(), 2147483647);
      }
    }
    i.c(this.a).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.i.4
 * JD-Core Version:    0.7.0.1
 */