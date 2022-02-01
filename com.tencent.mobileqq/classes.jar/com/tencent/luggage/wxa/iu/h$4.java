package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.appbrand.v8.n.b;
import com.tencent.mm.appbrand.v8.n.c;

class h$4
  implements n.b
{
  h$4(h paramh) {}
  
  public void a(String paramString, n.c paramc)
  {
    boolean bool = Boolean.parseBoolean(paramString);
    if (bool)
    {
      h.a.a(h.a(this.a), paramc.a);
      h.a.b(h.a(this.a), paramc.b);
      h.a.a(h.a(this.a), paramc);
    }
    o.d("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed end by AddonV8, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.a.getComponentId()), Long.valueOf(h.a.a(h.a(this.a)) - h.a.b(h.a(this.a))) });
    paramString = this.a;
    paramString.a(h.a.c(h.a(paramString)), h.a.b(h.a(this.a)), h.a.a(h.a(this.a)), h.a.d(h.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.h.4
 * JD-Core Version:    0.7.0.1
 */