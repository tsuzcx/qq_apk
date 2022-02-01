package com.tencent.luggage.wxa.ln;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.ok.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class v$1$1
  implements View.OnClickListener
{
  v$1$1(v.1 param1) {}
  
  public void onClick(View paramView)
  {
    d.a(this.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.v.1.1
 * JD-Core Version:    0.7.0.1
 */