package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class i$2
  implements View.OnClickListener
{
  i$2(i parami) {}
  
  public void onClick(View paramView)
  {
    if (i.d(this.a) != null) {
      if (i.d(this.a).hasFocus()) {
        i.h(this.a);
      } else if (i.d(this.a) == paramView) {
        i.i(this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i.2
 * JD-Core Version:    0.7.0.1
 */