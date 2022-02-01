package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

class ae$1
  implements Function0<Boolean>
{
  ae$1(ae paramae, String paramString, s.f paramf) {}
  
  public Boolean a()
  {
    if (!af.c(this.a))
    {
      s.f localf = this.b;
      if (localf != null)
      {
        this.c.a(this.a, 0, localf.a, this.b.h);
        this.c.a(this.b.f);
        if ((!af.c(this.b.l)) && (this.b.f != null) && (this.b.f.size() > 0)) {
          this.c.a(this.a, "__WITHOUT_PLUGINCODE__", this.b.a, 0, this.b.l, 12);
        }
        this.c.a(this.a, this.b.a, 0, "", this.b.m);
        return Boolean.valueOf(this.c.a(this.a, 0, this.b.a, this.b.c, null));
      }
    }
    o.b("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", new Object[] { this.a, this.b });
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ae.1
 * JD-Core Version:    0.7.0.1
 */