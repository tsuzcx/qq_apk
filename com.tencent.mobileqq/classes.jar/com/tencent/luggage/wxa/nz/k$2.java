package com.tencent.luggage.wxa.nz;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
import java.util.Timer;
import java.util.TimerTask;

class k$2
  extends TimerTask
{
  k$2(k paramk, e parame, d.a parama, Timer paramTimer) {}
  
  public void run()
  {
    o.b("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
    this.a.c();
    k.b(this.d, this.a);
    this.b.a("connect response time out");
    cancel();
    this.c.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.k.2
 * JD-Core Version:    0.7.0.1
 */