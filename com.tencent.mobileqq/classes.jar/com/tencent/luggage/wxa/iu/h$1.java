package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.n.a;
import com.tencent.mm.plugin.appbrand.jsruntime.n.b;

class h$1
  implements n.a
{
  h$1(h paramh, String paramString) {}
  
  public void a(String paramString, n.b paramb)
  {
    o.d("MicroMsg.AppBrandService", "injectConfig end by AddonDirectEvaluation, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramb.b - paramb.a), Integer.valueOf(this.b.getComponentId()) });
    h.a(this.b, new h.a(null));
    h.a.a(h.a(this.b), this.a);
    h.a.a(h.a(this.b), paramb.a);
    h.a.b(h.a(this.b), paramb.b);
    h.a.a(h.a(this.b), paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.h.1
 * JD-Core Version:    0.7.0.1
 */