package com.tencent.luggage.wxa.ma;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$15
  implements View.OnClickListener
{
  a$15(a parama) {}
  
  public void onClick(View paramView)
  {
    if (a.b(this.a).b()) {
      this.a.b();
    } else {
      this.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.a.15
 * JD-Core Version:    0.7.0.1
 */