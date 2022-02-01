package com.tencent.mobileqq.ark.debug;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkIDESettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  ArkIDESettingFragment$2(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.b();
      this.a.a("");
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("IDEDebug is open", new Object[0]));
    }
    else
    {
      this.a.c();
      this.a.a("close");
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("IDEDebug is close", new Object[0]));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment.2
 * JD-Core Version:    0.7.0.1
 */