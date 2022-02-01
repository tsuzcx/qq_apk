package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.luggage.wxa.qz.o;
import kotlin.jvm.functions.Function0;

class AppBrandUILoadingSplash$2
  implements Runnable
{
  AppBrandUILoadingSplash$2(AppBrandUILoadingSplash paramAppBrandUILoadingSplash, ViewParent paramViewParent, Function0 paramFunction0) {}
  
  public void run()
  {
    o.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, remove splash");
    this.c.setVisibility(8);
    ((ViewGroup)this.a).removeView(this.c);
    Function0 localFunction0 = this.b;
    if (localFunction0 != null) {
      localFunction0.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.2
 * JD-Core Version:    0.7.0.1
 */