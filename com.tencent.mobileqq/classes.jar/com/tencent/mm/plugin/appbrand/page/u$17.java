package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;

class u$17
  implements Runnable
{
  u$17(u paramu, String paramString) {}
  
  public void run()
  {
    if (this.b.b_ == null) {
      return;
    }
    d locald = this.b.b_;
    boolean bool;
    if (e.a.a(this.a) == e.a.a) {
      bool = true;
    } else {
      bool = false;
    }
    locald.setStatusBarForegroundStyle(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.17
 * JD-Core Version:    0.7.0.1
 */