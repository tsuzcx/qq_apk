package com.tencent.luggage.wxa.du;

import com.tencent.luggage.wxa.jx.ba;
import com.tencent.luggage.wxa.ox.b;
import com.tencent.luggage.wxa.pd.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.h;

class a$1
  implements h
{
  a$1(a parama, g paramg) {}
  
  public void a(String paramString1, String paramString2)
  {
    o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", new Object[] { paramString1, paramString2 });
    ba.a(this.a, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { k.a(paramString1), k.a(paramString2) }), 0);
    b.a().a("WeAppLaunch", paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.a.1
 * JD-Core Version:    0.7.0.1
 */