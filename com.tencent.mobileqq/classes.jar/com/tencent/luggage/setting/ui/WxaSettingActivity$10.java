package com.tencent.luggage.setting.ui;

import com.tencent.luggage.wxa.ek.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;

class WxaSettingActivity$10
  implements j
{
  WxaSettingActivity$10(WxaSettingActivity paramWxaSettingActivity) {}
  
  public void a(i parami)
  {
    WxaSettingActivity.p(this.a).b(this);
    if (WxaSettingActivity.p(this.a).getCurrentDialog() == null)
    {
      WxaSettingActivity.d(this.a);
      WxaSettingActivity.e(this.a);
      return;
    }
    if ((WxaSettingActivity.q(this.a) != null) && (WxaSettingActivity.p(this.a) != null)) {
      WxaSettingActivity.q(this.a).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.10
 * JD-Core Version:    0.7.0.1
 */