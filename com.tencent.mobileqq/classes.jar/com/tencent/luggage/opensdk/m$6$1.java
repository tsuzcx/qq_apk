package com.tencent.luggage.opensdk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class m$6$1
  implements View.OnClickListener
{
  m$6$1(m.6 param6, b paramb, k paramk) {}
  
  public void onClick(View paramView)
  {
    this.a.a("fail cancel");
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.m.6.1
 * JD-Core Version:    0.7.0.1
 */