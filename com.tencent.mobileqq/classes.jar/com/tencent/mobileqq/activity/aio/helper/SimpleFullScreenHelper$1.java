package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SimpleFullScreenHelper$1
  implements View.OnClickListener
{
  SimpleFullScreenHelper$1(SimpleFullScreenHelper paramSimpleFullScreenHelper, int paramInt) {}
  
  public void onClick(View paramView)
  {
    SimpleFullScreenHelper.a(this.b, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SimpleFullScreenHelper.1
 * JD-Core Version:    0.7.0.1
 */