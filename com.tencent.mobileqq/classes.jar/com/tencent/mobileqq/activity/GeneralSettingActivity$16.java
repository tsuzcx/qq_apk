package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class GeneralSettingActivity$16
  implements CompoundButton.OnCheckedChangeListener
{
  GeneralSettingActivity$16(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = this.a.a.a().isChecked();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(this.a.app, false, null);
    int j = SimpleUIUtil.f();
    int i;
    if ((bool1) && (bool2))
    {
      i = SimpleUIUtil.c;
    }
    else
    {
      i = j;
      if (bool1)
      {
        i = j;
        if (ThemeUtil.isNowThemeIsNight(this.a.app, false, SimpleUIUtil.a(j))) {
          i = SimpleUIUtil.g();
        }
      }
    }
    if (paramBoolean)
    {
      String str = SimpleUIUtil.a(i);
      if (!DarkModeManager.a(this.a, str, new GeneralSettingActivity.16.1(this, paramCompoundButton, bool1, i))) {
        GeneralSettingActivity.a(this.a, paramCompoundButton, true, bool1, i);
      }
    }
    else
    {
      GeneralSettingActivity.a(this.a, paramCompoundButton, false, bool1, i);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.16
 * JD-Core Version:    0.7.0.1
 */