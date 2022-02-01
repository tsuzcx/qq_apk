package com.tencent.luggage.wxa.ma;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$4
  implements View.OnClickListener
{
  a$4(a parama) {}
  
  public void onClick(View paramView)
  {
    a locala = this.a;
    locala.a(false, a.F(locala));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.a.4
 * JD-Core Version:    0.7.0.1
 */