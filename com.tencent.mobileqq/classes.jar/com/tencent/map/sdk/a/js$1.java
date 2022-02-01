package com.tencent.map.sdk.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class js$1
  implements View.OnClickListener
{
  js$1(js paramjs) {}
  
  public final void onClick(View paramView)
  {
    this.a.f.az.b.c.a(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.js.1
 * JD-Core Version:    0.7.0.1
 */