package com.tencent.luggage.wxa.bp;

import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.jx.az;
import com.tencent.luggage.wxa.ox.b;
import com.tencent.luggage.wxa.pd.k;
import com.tencent.mm.plugin.appbrand.jsruntime.h;

class a$1
  implements h
{
  a$1(a parama) {}
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = (c)this.a.y();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((c)localObject).getJsRuntime();
    }
    if (localObject == null) {
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", new Object[] { paramString1, paramString2 });
    az.a((com.tencent.mm.plugin.appbrand.jsruntime.o)localObject, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { k.a(paramString1), k.a(paramString2) }), 0);
    b.a().a("WeAppLaunch", paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.a.1
 * JD-Core Version:    0.7.0.1
 */