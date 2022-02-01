package com.tencent.luggage.wxa.ky;

import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.qz.o;

class c$3
  implements f.b
{
  c$3(c paramc, e parame, a parama) {}
  
  public void b()
  {
    c.d locald = com.tencent.luggage.wxa.iu.c.i(this.a.getAppId());
    o.d("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == c.d.g)
    {
      this.b.a(2);
      return;
    }
    if (locald == c.d.c)
    {
      this.b.a(1);
      return;
    }
    this.b.a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.c.3
 * JD-Core Version:    0.7.0.1
 */