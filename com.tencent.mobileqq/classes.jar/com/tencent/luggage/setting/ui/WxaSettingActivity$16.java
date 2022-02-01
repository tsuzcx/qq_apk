package com.tencent.luggage.setting.ui;

import com.tencent.luggage.wxa.qw.je;
import com.tencent.luggage.wxa.qw.lq;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;

class WxaSettingActivity$16
  implements b<Boolean, lq>
{
  WxaSettingActivity$16(WxaSettingActivity paramWxaSettingActivity) {}
  
  public Boolean a(lq paramlq)
  {
    if (paramlq == null)
    {
      o.b("Luggage.STANDALONE.WxaSettingActivity", "WxaAppModAuthReq failed, response is null!");
    }
    else
    {
      int i = paramlq.a.a;
      String str = paramlq.a.b;
      if (i == 0)
      {
        WxaSettingActivity.a(this.a, paramlq);
        paramlq = this.a;
        WxaSettingActivity.a(paramlq, paramlq.d);
        o.e("Luggage.STANDALONE.WxaSettingActivity", "WxaAppModAuthReq OK!");
        return Boolean.valueOf(true);
      }
      o.b("Luggage.STANDALONE.WxaSettingActivity", "WxaAppModAuthReq error %s", new Object[] { str });
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.16
 * JD-Core Version:    0.7.0.1
 */