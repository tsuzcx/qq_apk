package com.tencent.mm.plugin.appbrand.page;

import java.util.LinkedList;

class o$8
  implements o.c
{
  private boolean e = false;
  private boolean f = false;
  
  o$8(o paramo, bg parambg, m paramm1, m paramm2) {}
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void run()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    if (this.d.getPageCount() == 0) {
      return;
    }
    synchronized (o.g(this.d))
    {
      m localm1 = (m)o.c(this.d).peekFirst();
      boolean bool1 = bh.c(this.a);
      ??? = null;
      if (bool1) {
        o.a(this.d, localm1, null);
      }
      bool1 = this.f ^ true;
      boolean bool2 = bh.b(this.a);
      Object localObject3 = this.d.getAppId();
      m localm2 = this.b;
      if (localm2 != null) {
        ??? = com.tencent.luggage.util.m.b(localm2.getCurrentUrl());
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "navigateToNext$navigateTask.run(), before switch page, appId[%s], out[%s] in[%s] animate[%b] close[%b] type[%s]", new Object[] { localObject3, ???, com.tencent.luggage.util.m.b(this.c.getCurrentUrl()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), this.a });
      ??? = o.a(this.d, localm1, bool1, bool2);
      localObject3 = o.a(this.d, this.c, bool1);
      o.a(this.d, this.a, localm1, this.c, new o.g(localObject3, ???));
      this.d.a(localm1, this.c, this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.8
 * JD-Core Version:    0.7.0.1
 */