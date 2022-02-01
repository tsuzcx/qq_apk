package com.tencent.luggage.wxa.qa;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$8
  implements View.OnClickListener
{
  a$8(a parama) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.b.indexOfChild(paramView);
    this.a.a(i);
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.a.8
 * JD-Core Version:    0.7.0.1
 */