package com.tencent.luggage.setting.ui;

import android.os.Message;
import com.tencent.luggage.wxa.eh.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

class WxaSettingActivity$7
  implements Function1<c, Unit>
{
  WxaSettingActivity$7(WxaSettingActivity paramWxaSettingActivity) {}
  
  public Unit a(c paramc)
  {
    Message.obtain(WxaSettingActivity.n(this.a), 1, paramc).sendToTarget();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */