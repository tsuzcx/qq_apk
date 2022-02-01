package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOLongShotHelper$11
  implements View.OnClickListener
{
  AIOLongShotHelper$11(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.c(this.a, paramView);
    AIOLongShotHelper.a("0X8009DEC");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.11
 * JD-Core Version:    0.7.0.1
 */