package com.tencent.luggage.setting.ui;

import android.preference.Preference;
import com.tencent.luggage.wxa.di.d;
import com.tencent.luggage.wxa.qw.n;
import com.tencent.weui.base.preference.IPreferenceScreen;

class WxaSettingActivity$8
  implements Runnable
{
  WxaSettingActivity$8(WxaSettingActivity paramWxaSettingActivity, boolean paramBoolean1, Preference paramPreference, boolean paramBoolean2, n paramn, IPreferenceScreen paramIPreferenceScreen) {}
  
  public void run()
  {
    boolean bool = this.a;
    int i = 2;
    if (bool)
    {
      ((d)this.b).setChecked(this.c);
      localn = this.d;
      if (this.c) {
        i = 1;
      }
      localn.c = i;
      this.e.notifyDataSetChanged();
      return;
    }
    ((d)this.b).setChecked(this.c ^ true);
    n localn = this.d;
    if (!this.c) {
      i = 1;
    }
    localn.c = i;
    this.e.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */