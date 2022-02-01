package com.tencent.luggage.wxa.du;

import com.tencent.luggage.wxa.jx.az;
import com.tencent.luggage.wxa.pd.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;

class b$1
  implements h
{
  b$1(b paramb, i parami) {}
  
  public void a(String paramString1, String paramString2)
  {
    o.b("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", new Object[] { paramString1, paramString2 });
    String str = String.format("{'message':'%s', 'stack': '%s'}", new Object[] { k.a(paramString1), k.a(paramString2) });
    az.a(this.a, "onError", str, 0);
    this.b.a(paramString1, paramString2);
    o.b("MicroMsg.AppBrand.JsRuntimeException", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.b.1
 * JD-Core Version:    0.7.0.1
 */