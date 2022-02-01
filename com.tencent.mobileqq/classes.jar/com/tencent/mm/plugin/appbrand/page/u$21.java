package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class u$21
  implements View.OnClickListener
{
  u$21(u paramu) {}
  
  public void onClick(View paramView)
  {
    this.a.ad();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.21
 * JD-Core Version:    0.7.0.1
 */