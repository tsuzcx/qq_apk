package com.tencent.luggage.wxa.lq;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;

class c$2
  implements Runnable
{
  c$2(c paramc, h paramh, u paramu, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (!this.a.d()) {
      return;
    }
    this.b.ab().a(ak.a);
    b localb = new b(this.a.getContext());
    if (!af.c(this.c)) {
      if (af.c(this.d)) {
        localb.setMessage(this.c);
      } else {
        localb.setTitle(this.c);
      }
    }
    if (!af.c(this.d)) {
      localb.setMessage(this.d);
    }
    localb.setPositiveButton(this.e, true, new c.2.1(this));
    if (this.g) {
      localb.setNegativeButton(this.h, false, new c.2.2(this));
    }
    localb.setOnCancelListener(new c.2.3(this));
    localb.setPositiveButtonColor(this.i);
    if (this.g) {
      localb.setNegativeButtonColor(this.j);
    }
    this.a.q().ao().a(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.c.2
 * JD-Core Version:    0.7.0.1
 */