package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.luggage.wxa.qz.o;
import java.util.Timer;
import java.util.TimerTask;

class a$2
  extends TimerTask
{
  a$2(a parama, e parame, d.a parama1, Timer paramTimer) {}
  
  public void run()
  {
    o.b("MicroMsg.AppBrandNetworkWcWssSocket", "connect response time out taskid:%s", new Object[] { this.a.v_() });
    this.b.a("connect response time out");
    this.a.c();
    a.b(this.d, this.a);
    cancel();
    this.c.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.a.2
 * JD-Core Version:    0.7.0.1
 */