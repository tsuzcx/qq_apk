package com.tencent.mobileqq.ark.debug;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkIDESettingFragment$5
  implements View.OnClickListener
{
  ArkIDESettingFragment$5(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    ArkIDESettingFragment.a(this.a, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment.5
 * JD-Core Version:    0.7.0.1
 */