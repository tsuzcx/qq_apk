package com.dataline.activities;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LiteAdvanceActivity$3
  implements CompoundButton.OnCheckedChangeListener
{
  LiteAdvanceActivity$3(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.d(this.a, paramBoolean);
    LiteAdvanceActivity.b(this.a, LiteAdvanceActivity.b(this.a));
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity.3
 * JD-Core Version:    0.7.0.1
 */