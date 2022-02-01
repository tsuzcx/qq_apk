package com.tencent.luggage.wxa.as;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class c$1
  implements View.OnClickListener
{
  c$1(c paramc, boolean paramBoolean, com.tencent.luggage.wxa.az.b paramb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    boolean bool = c.a(this.d).a(this.a);
    if (this.a) {
      c.a(this.d, this.b, this.c);
    } else if (bool) {
      c.b(this.d, this.b, this.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.as.c.1
 * JD-Core Version:    0.7.0.1
 */