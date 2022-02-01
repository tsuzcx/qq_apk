package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.dd.e;
import com.tencent.luggage.wxa.dd.g;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.mm.plugin.appbrand.keylogger.d;

class r$1
  implements b<c, c>
{
  r$1(r paramr, String paramString, long paramLong) {}
  
  public c a(c paramc)
  {
    o.d("Luggage.Standalone.WxaLaunchPreconditionProcess", "fill mmUserId, hash:%d, config:%s", new Object[] { Integer.valueOf(this.c.hashCode()), paramc });
    if (paramc != null)
    {
      Object localObject;
      if (com.tencent.luggage.wxa.dd.i.a.g()) {
        localObject = new com.tencent.luggage.wxa.dc.i(com.tencent.luggage.wxa.dd.i.a.f().c());
      } else {
        localObject = new e(com.tencent.luggage.wxa.dd.i.a.c());
      }
      paramc.a = ((com.tencent.luggage.wxa.dx.a)localObject);
      if (paramc.d()) {
        d.a(this.a, com.tencent.luggage.wxa.oy.a.d, "", this.b, af.d());
      } else {
        d.a(this.a, com.tencent.luggage.wxa.oy.a.c, "", this.b, af.d());
      }
      d.b(this.a, com.tencent.luggage.wxa.oy.a.b);
      return paramc;
    }
    d.c(this.a, com.tencent.luggage.wxa.oy.a.b);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.r.1
 * JD-Core Version:    0.7.0.1
 */