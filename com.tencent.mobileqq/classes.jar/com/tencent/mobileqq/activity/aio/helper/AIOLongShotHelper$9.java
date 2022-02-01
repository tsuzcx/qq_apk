package com.tencent.mobileqq.activity.aio.helper;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOLongShotHelper$9
  implements CompoundButton.OnCheckedChangeListener
{
  AIOLongShotHelper$9(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AIOLongShotHelper.a(this.a, paramCompoundButton, paramBoolean);
    AIOLongShotHelper.a("0X8009DE8");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.9
 * JD-Core Version:    0.7.0.1
 */