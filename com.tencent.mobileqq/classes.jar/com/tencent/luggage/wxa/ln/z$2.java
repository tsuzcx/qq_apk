package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qa.a;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o;

class z$2
  implements Runnable
{
  z$2(z paramz, h paramh, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    m localm = this.a.q().C().getCurrentPage();
    if (!(localm instanceof f))
    {
      this.a.a(this.b, this.h.b("fail:not TabBar page"));
      return;
    }
    ((f)localm).getTabBar().a(this.c, this.d, this.e, this.f, this.g);
    this.a.a(this.b, this.h.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.z.2
 * JD-Core Version:    0.7.0.1
 */