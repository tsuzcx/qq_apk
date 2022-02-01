package com.tencent.luggage.setting.ui;

import android.widget.Toast;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;

class WxaSettingActivity$14
  implements e.a
{
  WxaSettingActivity$14(WxaSettingActivity paramWxaSettingActivity, WxaSettingActivity.b paramb) {}
  
  public void a(Object paramObject)
  {
    o.b("Luggage.STANDALONE.WxaSettingActivity", "wxaapp_modauth interrupted");
    WxaSettingActivity.b(this.b);
    paramObject = this.a;
    if (paramObject != null) {
      paramObject.a(false);
    }
    Toast.makeText(this.b.getApplicationContext(), this.b.getString(2131886985), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.14
 * JD-Core Version:    0.7.0.1
 */