package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$1
  implements View.OnClickListener
{
  d$1(d paramd) {}
  
  public void onClick(View paramView)
  {
    d locald = this.a;
    if (paramView == locald) {
      d.a(locald);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.d.1
 * JD-Core Version:    0.7.0.1
 */