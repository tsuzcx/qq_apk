package com.tencent.mobileqq.ark.debug;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkIDESettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  ArkIDESettingFragment$1(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AboutActivity.a(5);
      if (!this.a.e().equals("close")) {
        this.a.f();
      }
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("ArkDebug switch is opened and IDE debug is also open ,state=%s", new Object[] { AboutActivity.b() }));
      ((IArkEnvironment)QRoute.api(IArkEnvironment.class)).setScriptLeakCheckEnabled(true);
    }
    else
    {
      AboutActivity.a(0);
      this.a.g();
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("ArkDebug switch is closed and IDE debug is also closed,state=%s", new Object[] { AboutActivity.b() }));
      ((IArkEnvironment)QRoute.api(IArkEnvironment.class)).setScriptLeakCheckEnabled(false);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment.1
 * JD-Core Version:    0.7.0.1
 */