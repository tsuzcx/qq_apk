package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.util.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class u$23
  implements View.OnClickListener
{
  u$23(u paramu) {}
  
  public void onClick(View paramView)
  {
    boolean bool = h.a(this.a.getContext());
    u localu = this.a;
    u.23.1 local1 = new u.23.1(this);
    int i;
    if (bool) {
      i = 100;
    } else {
      i = 0;
    }
    localu.b(local1, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.23
 * JD-Core Version:    0.7.0.1
 */