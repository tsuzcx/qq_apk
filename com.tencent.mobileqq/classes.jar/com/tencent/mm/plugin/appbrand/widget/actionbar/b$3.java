package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class b$3
  implements View.OnClickListener
{
  b$3(b paramb) {}
  
  public void onClick(View paramView)
  {
    if ((b.a(this.a) != null) && (!b.a(this.a).a(paramView))) {
      this.a.m.a(this.a.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.3
 * JD-Core Version:    0.7.0.1
 */