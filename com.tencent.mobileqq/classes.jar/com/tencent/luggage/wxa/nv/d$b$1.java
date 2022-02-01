package com.tencent.luggage.wxa.nv;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$b$1
  implements View.OnClickListener
{
  d$b$1(d.b paramb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (d.b.a(this.b) != null) {
      d.b.a(this.b).a(paramView, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nv.d.b.1
 * JD-Core Version:    0.7.0.1
 */