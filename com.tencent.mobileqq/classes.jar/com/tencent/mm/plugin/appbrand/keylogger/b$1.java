package com.tencent.mm.plugin.appbrand.keylogger;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.b.1
 * JD-Core Version:    0.7.0.1
 */