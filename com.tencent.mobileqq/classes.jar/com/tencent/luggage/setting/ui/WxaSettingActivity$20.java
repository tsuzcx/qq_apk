package com.tencent.luggage.setting.ui;

import com.tencent.luggage.wxa.ek.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

class WxaSettingActivity$20
  implements Function0<Unit>
{
  WxaSettingActivity$20(WxaSettingActivity paramWxaSettingActivity) {}
  
  public Unit a()
  {
    WxaSettingActivity localWxaSettingActivity = this.a;
    WxaSettingActivity.a(localWxaSettingActivity, (a)WxaSettingActivity.p(localWxaSettingActivity).getCurrentDialog());
    if (WxaSettingActivity.j(this.a) != null)
    {
      localWxaSettingActivity = this.a;
      localWxaSettingActivity.a = WxaSettingActivity.j(localWxaSettingActivity).j();
    }
    if (WxaSettingActivity.u(this.a))
    {
      localWxaSettingActivity = this.a;
      WxaSettingActivity.b(localWxaSettingActivity, WxaSettingActivity.v(localWxaSettingActivity));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.20
 * JD-Core Version:    0.7.0.1
 */