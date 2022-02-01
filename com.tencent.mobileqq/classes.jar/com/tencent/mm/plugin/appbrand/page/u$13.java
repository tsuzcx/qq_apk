package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;

class u$13
  implements Runnable
{
  u$13(u paramu, int paramInt) {}
  
  public void run()
  {
    if (this.b.ah() == null) {
      return;
    }
    this.b.ah().setForegroundColor(this.a);
    this.b.h(e.a.a(this.a).name());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.13
 * JD-Core Version:    0.7.0.1
 */