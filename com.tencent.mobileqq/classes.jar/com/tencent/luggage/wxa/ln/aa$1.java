package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qa.a;
import com.tencent.luggage.wxa.qa.e;
import com.tencent.luggage.wxa.qa.g;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.o;

class aa$1
  implements Runnable
{
  aa$1(aa paramaa, h paramh, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject = this.a.q().C().getCurrentPage();
    if (!(localObject instanceof f))
    {
      this.a.a(this.b, this.g.b("fail:not TabBar page"));
      return;
    }
    localObject = ((f)localObject).getTabBar();
    e locale1 = ((a)localObject).a.a(this.c, new aa.1.1(this, (a)localObject), this.a, this.d);
    e locale2 = ((a)localObject).a.a(this.f, new aa.1.2(this, (a)localObject), this.a, this.d);
    ((a)localObject).a(this.d, this.e, locale1, locale2);
    this.a.a(this.b, this.g.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.aa.1
 * JD-Core Version:    0.7.0.1
 */