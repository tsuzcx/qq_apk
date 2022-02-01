package com.tencent.luggage.setting.ui;

import android.preference.Preference;
import com.tencent.luggage.wxa.ek.a;
import com.tencent.weui.base.preference.IPreferenceScreen;

class WxaSettingActivity$31
  implements Runnable
{
  WxaSettingActivity$31(WxaSettingActivity paramWxaSettingActivity, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject;
    WxaSettingActivity localWxaSettingActivity;
    if (WxaSettingActivity.g(this.b) == 0)
    {
      localObject = new Preference(WxaSettingActivity.h(this.b));
      ((Preference)localObject).setPersistent(false);
      if (this.a)
      {
        ((Preference)localObject).setLayoutResource(2131624205);
        localWxaSettingActivity = this.b;
        ((Preference)localObject).setTitle(localWxaSettingActivity.getString(2131886761, new Object[] { WxaSettingActivity.i(localWxaSettingActivity) }));
      }
      else
      {
        ((Preference)localObject).setLayoutResource(2131624206);
        localWxaSettingActivity = this.b;
        ((Preference)localObject).setTitle(localWxaSettingActivity.getString(2131886762, new Object[] { WxaSettingActivity.i(localWxaSettingActivity) }));
      }
      this.b.a.addPreference((Preference)localObject);
      this.b.a.notifyDataSetChanged();
      return;
    }
    if (WxaSettingActivity.g(this.b) == 1)
    {
      localObject = WxaSettingActivity.j(this.b);
      boolean bool = this.a;
      localWxaSettingActivity = this.b;
      ((a)localObject).a(bool, localWxaSettingActivity.getString(2131886761, new Object[] { WxaSettingActivity.i(localWxaSettingActivity) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.31
 * JD-Core Version:    0.7.0.1
 */