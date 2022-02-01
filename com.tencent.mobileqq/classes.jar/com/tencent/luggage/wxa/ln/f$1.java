package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qa.a;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o;
import org.json.JSONObject;

class f$1
  implements Runnable
{
  f$1(f paramf, h paramh, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    m localm = this.a.q().C().getCurrentPage();
    if (!(localm instanceof com.tencent.mm.plugin.appbrand.page.f))
    {
      this.a.a(this.b, this.d.b("fail:not TabBar page"));
      return;
    }
    ((com.tencent.mm.plugin.appbrand.page.f)localm).getTabBar().a(this.c.optBoolean("animation", true));
    this.a.a(this.b, this.d.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.f.1
 * JD-Core Version:    0.7.0.1
 */