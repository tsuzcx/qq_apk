package com.tencent.luggage.wxa.bi;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;

class a$3
  implements com.tencent.luggage.wxa.rl.b<Void, c>
{
  a$3(a parama, com.tencent.luggage.wxa.nn.a parama1, com.tencent.luggage.wxa.ew.b paramb) {}
  
  public Void a(c paramc)
  {
    if (paramc == null)
    {
      h.b().a(null);
      o.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "WxaLaunchPreconditionProcess get NULL InitConfig, with params(appId:%s versionType:%d)", new Object[] { this.a.b, Integer.valueOf(this.a.d) });
      return null;
    }
    this.a.a(paramc);
    paramc.I = com.tencent.luggage.wxa.nn.a.b(this.a.e);
    paramc.e();
    com.tencent.luggage.wxa.ro.b localb = h.c();
    a.a(this.c, paramc, this.b, this.a.f, new a.3.1(this, localb));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bi.a.3
 * JD-Core Version:    0.7.0.1
 */