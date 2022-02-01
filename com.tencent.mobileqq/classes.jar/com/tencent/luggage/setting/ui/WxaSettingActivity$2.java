package com.tencent.luggage.setting.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.Preference;
import com.tencent.luggage.wxa.di.d;
import com.tencent.luggage.wxa.qw.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.weui.base.preference.IPreferenceScreen;

class WxaSettingActivity$2
  implements DialogInterface.OnClickListener
{
  WxaSettingActivity$2(WxaSettingActivity paramWxaSettingActivity, n paramn, Preference paramPreference, IPreferenceScreen paramIPreferenceScreen) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    o.e("Luggage.STANDALONE.WxaSettingActivity", "set authItem.state open");
    this.a.c = 1;
    ((d)this.b).setChecked(true);
    this.c.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */