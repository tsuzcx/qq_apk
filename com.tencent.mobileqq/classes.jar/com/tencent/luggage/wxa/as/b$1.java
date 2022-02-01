package com.tencent.luggage.wxa.as;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class b$1
  implements View.OnClickListener
{
  b$1(b paramb, com.tencent.luggage.wxa.az.a parama) {}
  
  public void onClick(View paramView)
  {
    if (b.a(this.b) != null) {
      b.a(this.b).a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.as.b.1
 * JD-Core Version:    0.7.0.1
 */