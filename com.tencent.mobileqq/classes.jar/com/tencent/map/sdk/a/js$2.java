package com.tencent.map.sdk.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class js$2
  implements View.OnClickListener
{
  js$2(js paramjs) {}
  
  public final void onClick(View paramView)
  {
    this.a.f.az.b.c.b(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.js.2
 * JD-Core Version:    0.7.0.1
 */