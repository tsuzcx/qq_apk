package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.jvm.functions.Function0;

class AppBrandUILoadingSplash$4
  implements View.OnClickListener
{
  AppBrandUILoadingSplash$4(AppBrandUILoadingSplash paramAppBrandUILoadingSplash) {}
  
  public void onClick(View paramView)
  {
    if (AppBrandUILoadingSplash.g(this.a) != null)
    {
      if (!this.a.a)
      {
        c.a(AppBrandUILoadingSplash.g(this.a).aa(), c.d.a);
        AppBrandUILoadingSplash.g(this.a).E();
      }
    }
    else if (AppBrandUILoadingSplash.h(this.a) != null) {
      AppBrandUILoadingSplash.h(this.a).invoke();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.4
 * JD-Core Version:    0.7.0.1
 */