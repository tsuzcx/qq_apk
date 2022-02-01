package com.tencent.mm.plugin.appbrand.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.lo.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$4
  implements View.OnClickListener
{
  d$4(d paramd) {}
  
  public void onClick(View paramView)
  {
    d locald = this.a;
    Object localObject;
    if (d.c(locald) == null) {
      localObject = null;
    } else {
      localObject = d.c(this.a).currentValue();
    }
    d.a(locald, true, localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.d.4
 * JD-Core Version:    0.7.0.1
 */