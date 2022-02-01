package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAssisSettingActivity$3
  implements CompoundButton.OnCheckedChangeListener
{
  TroopAssisSettingActivity$3(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      TroopAssistantManager.a().a(this.a.app, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */