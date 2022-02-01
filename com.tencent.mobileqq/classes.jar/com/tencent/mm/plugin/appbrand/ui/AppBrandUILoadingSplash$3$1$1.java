package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;
import com.tencent.luggage.wxa.qz.o;
import kotlin.jvm.functions.Function0;

class AppBrandUILoadingSplash$3$1$1
  implements Runnable
{
  AppBrandUILoadingSplash$3$1$1(AppBrandUILoadingSplash.3.1 param1) {}
  
  public void run()
  {
    o.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, hide ends && remove splash");
    this.a.c.b.setVisibility(8);
    ((ViewGroup)this.a.b).removeView(this.a.c.b);
    if (this.a.c.a != null) {
      this.a.c.a.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.3.1.1
 * JD-Core Version:    0.7.0.1
 */