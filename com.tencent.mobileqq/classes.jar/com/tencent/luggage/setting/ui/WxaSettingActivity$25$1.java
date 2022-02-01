package com.tencent.luggage.setting.ui;

import com.tencent.weui.base.preference.IPreferenceScreen;

class WxaSettingActivity$25$1
  implements Runnable
{
  WxaSettingActivity$25$1(WxaSettingActivity.25 param25, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      WxaSettingActivity.c(this.b.c, this.b.a);
    } else {
      WxaSettingActivity.c(this.b.c, this.b.b);
    }
    WxaSettingActivity.w(this.b.c);
    this.b.c.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.25.1
 * JD-Core Version:    0.7.0.1
 */