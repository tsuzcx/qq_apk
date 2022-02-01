package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.ma.e.g;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class c$1
  implements View.OnClickListener
{
  c$1(c paramc, e.g paramg) {}
  
  public void onClick(View paramView)
  {
    c.a(this.b);
    e.g localg = this.a;
    if (localg != null) {
      localg.a(paramView, c.b(this.b));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.c.1
 * JD-Core Version:    0.7.0.1
 */