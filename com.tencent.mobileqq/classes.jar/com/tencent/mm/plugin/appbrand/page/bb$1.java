package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class bb$1
  extends aa
{
  bb$1(bb parambb, u paramu)
  {
    super(paramu);
  }
  
  public void c(String paramString)
  {
    if (!bb.a(this.a)) {
      o.d("Luggage.MPWebViewRenderEngineLegacyImpl", "[perf] PageFrame[%s] ready cost %dms", new Object[] { paramString, Long.valueOf(af.b() - bb.b(this.a)) });
    }
    bb.a(this.a, true);
    super.c(paramString);
    bb.d(this.a).a(new bb.1.1(this));
  }
  
  public void d(String paramString)
  {
    if (!bb.a(this.a)) {
      o.d("Luggage.MPWebViewRenderEngineLegacyImpl", "[perf] PageFrame[%s] CommitVisible cost %dms", new Object[] { paramString, Long.valueOf(af.b() - bb.b(this.a)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bb.1
 * JD-Core Version:    0.7.0.1
 */