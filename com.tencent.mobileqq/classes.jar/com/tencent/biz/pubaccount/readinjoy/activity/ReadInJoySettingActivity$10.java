package com.tencent.biz.pubaccount.readinjoy.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSettingUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoySettingActivity$10
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      ReadInJoyAdSettingUtil.g();
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      ReadInJoyAdSettingUtil.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.10
 * JD-Core Version:    0.7.0.1
 */