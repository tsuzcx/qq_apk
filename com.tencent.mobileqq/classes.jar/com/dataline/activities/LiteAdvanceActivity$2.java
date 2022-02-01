package com.dataline.activities;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LiteAdvanceActivity$2
  implements CompoundButton.OnCheckedChangeListener
{
  LiteAdvanceActivity$2(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.c(this.a, paramBoolean);
    LiteAdvanceActivity localLiteAdvanceActivity = this.a;
    LiteAdvanceActivity.a(localLiteAdvanceActivity, LiteAdvanceActivity.a(localLiteAdvanceActivity));
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity.2
 * JD-Core Version:    0.7.0.1
 */