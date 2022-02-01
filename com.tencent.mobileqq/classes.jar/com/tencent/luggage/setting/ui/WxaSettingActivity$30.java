package com.tencent.luggage.setting.ui;

import com.tencent.luggage.wxa.qw.n;
import com.tencent.weui.base.preference.IPreferenceScreen;

class WxaSettingActivity$30
  implements Runnable
{
  WxaSettingActivity$30(WxaSettingActivity paramWxaSettingActivity, n paramn) {}
  
  public void run()
  {
    WxaSettingActivity localWxaSettingActivity = this.b;
    WxaSettingActivity.a(localWxaSettingActivity, WxaSettingActivity.f(localWxaSettingActivity), this.a);
    this.b.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.30
 * JD-Core Version:    0.7.0.1
 */