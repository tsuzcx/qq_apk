package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class u$20
  implements View.OnClickListener
{
  u$20(u paramu) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.ay()) {
      u.f(this.a).C().a(u.e(this.a), "scene_actionbar_back");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.20
 * JD-Core Version:    0.7.0.1
 */