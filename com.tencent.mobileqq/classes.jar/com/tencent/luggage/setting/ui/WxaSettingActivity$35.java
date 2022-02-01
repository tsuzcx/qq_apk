package com.tencent.luggage.setting.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.Preference;
import com.tencent.luggage.wxa.qw.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.weui.base.preference.IPreferenceScreen;

class WxaSettingActivity$35
  implements DialogInterface.OnClickListener
{
  WxaSettingActivity$35(WxaSettingActivity paramWxaSettingActivity, n paramn, Preference paramPreference, IPreferenceScreen paramIPreferenceScreen) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.c = 2;
    o.e("Luggage.STANDALONE.WxaSettingActivity", "set authItem.state close");
    WxaSettingActivity.a(this.d, new WxaSettingActivity.35.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.35
 * JD-Core Version:    0.7.0.1
 */