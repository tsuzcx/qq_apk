package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class v$1
  implements View.OnClickListener
{
  v$1(v paramv) {}
  
  public void onClick(View paramView)
  {
    v.a(this.a);
    this.a.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.v.1
 * JD-Core Version:    0.7.0.1
 */