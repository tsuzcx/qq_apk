package com.tencent.luggage.wxa.dm;

import com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper;
import com.tencent.luggage.wxa.bb.a.c;
import com.tencent.luggage.wxa.dn.a;
import com.tencent.luggage.wxa.jx.z;
import com.tencent.luggage.wxa.on.h;
import com.tencent.luggage.wxa.pc.m.a;
import com.tencent.luggage.wxa.pp.al.a;
import com.tencent.mm.plugin.appbrand.page.aq.a;
import com.tencent.mm.plugin.appbrand.ui.m;
import com.tencent.mm.ui.base.e;

class b$2
  implements Runnable
{
  b$2(b paramb, a.c paramc) {}
  
  public void run()
  {
    this.a.a(z.class, new FullSdkExternalToolsHelper());
    this.a.a(m.a.class, new a());
    this.a.a(aq.a.class, new al.a());
    this.a.a(e.class, new m());
    this.a.a(h.class, new b.2.1(this));
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dm.b.2
 * JD-Core Version:    0.7.0.1
 */