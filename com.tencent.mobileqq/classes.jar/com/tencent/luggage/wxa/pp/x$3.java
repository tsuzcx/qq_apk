package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class x$3
  implements View.OnClickListener
{
  x$3(x paramx) {}
  
  public void onClick(View paramView)
  {
    this.a.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.x.3
 * JD-Core Version:    0.7.0.1
 */