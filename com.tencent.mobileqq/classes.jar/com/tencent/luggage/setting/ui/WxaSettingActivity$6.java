package com.tencent.luggage.setting.ui;

import com.tencent.luggage.wxa.qw.je;
import com.tencent.luggage.wxa.qw.lh;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;

class WxaSettingActivity$6
  implements b<Boolean, lh>
{
  WxaSettingActivity$6(WxaSettingActivity paramWxaSettingActivity) {}
  
  public Boolean a(lh paramlh)
  {
    boolean bool = false;
    o.d("Luggage.STANDALONE.WxaSettingActivity", "wxaAppGetAuthInfoResp:%s", new Object[] { paramlh });
    if (paramlh == null)
    {
      WxaSettingActivity.c(this.a, true);
      o.b("Luggage.STANDALONE.WxaSettingActivity", "WxaAppGetAuthInfoReq failed, response is null!");
    }
    else
    {
      int i = paramlh.a.a;
      String str = paramlh.a.b;
      if (i == 0)
      {
        this.a.d = paramlh.b;
        paramlh = this.a;
        WxaSettingActivity.d(paramlh, WxaSettingActivity.a(paramlh.d));
        bool = true;
      }
      else
      {
        WxaSettingActivity.c(this.a, true);
        o.b("Luggage.STANDALONE.WxaSettingActivity", "WxaAppGetAuthInfoReq error %s", new Object[] { str });
      }
    }
    paramlh = this.a;
    paramlh.b = true;
    WxaSettingActivity.a(paramlh, paramlh.d, WxaSettingActivity.a(this.a));
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.6
 * JD-Core Version:    0.7.0.1
 */