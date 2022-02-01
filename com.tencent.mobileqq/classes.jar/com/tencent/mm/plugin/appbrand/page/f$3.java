package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.py.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;

class f$3
  implements Runnable
{
  f$3(f paramf) {}
  
  public void run()
  {
    if (f.c(this.a)) {
      return;
    }
    u localu = this.a.getCurrentPageView();
    if (localu == null) {
      return;
    }
    b localb = localu.ah();
    if (localb == null) {
      return;
    }
    localu.X().a(localb.getTop() + localb.getMeasuredHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f.3
 * JD-Core Version:    0.7.0.1
 */