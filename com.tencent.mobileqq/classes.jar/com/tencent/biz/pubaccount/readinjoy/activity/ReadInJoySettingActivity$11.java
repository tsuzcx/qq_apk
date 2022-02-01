package com.tencent.biz.pubaccount.readinjoy.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoySettingActivity$11
  implements CompoundButton.OnCheckedChangeListener
{
  ReadInJoySettingActivity$11(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramCompoundButton.isPressed())
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    ReadInJoySettingActivity localReadInJoySettingActivity = this.a;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      ReadInJoySettingActivity.c(localReadInJoySettingActivity, bool);
      ReadInJoySettingActivity.d(this.a, paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.11
 * JD-Core Version:    0.7.0.1
 */