package com.tencent.luggage.setting.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.preference.Preference;
import com.tencent.luggage.wxa.di.d;
import com.tencent.luggage.wxa.qw.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.weui.base.preference.IPreferenceScreen;

class WxaSettingActivity$3
  implements DialogInterface.OnCancelListener
{
  WxaSettingActivity$3(WxaSettingActivity paramWxaSettingActivity, n paramn, Preference paramPreference, IPreferenceScreen paramIPreferenceScreen) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    o.e("Luggage.STANDALONE.WxaSettingActivity", "on cancel click!");
    this.a.c = 1;
    ((d)this.b).setChecked(true);
    this.c.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */