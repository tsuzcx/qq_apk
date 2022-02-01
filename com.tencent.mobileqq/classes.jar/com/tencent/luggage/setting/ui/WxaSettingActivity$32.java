package com.tencent.luggage.setting.ui;

import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.qw.n;
import com.tencent.luggage.wxa.qz.o;

class WxaSettingActivity$32
  implements LuggageActivityHelper.ActivityResultCallback
{
  WxaSettingActivity$32(WxaSettingActivity paramWxaSettingActivity) {}
  
  public void onResult(int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("key_result_is_open", true)) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    int i = paramIntent.getIntExtra("key_result_selected_user_id", 0);
    boolean bool = paramIntent.getBooleanExtra("key_result_user_info_list_been_modified", false);
    if ((WxaSettingActivity.k(this.a) != i) || (WxaSettingActivity.l(this.a).c != paramInt) || (bool))
    {
      WxaSettingActivity.b(this.a, true);
      WxaSettingActivity.a(this.a, i);
      WxaSettingActivity.l(this.a).c = paramInt;
      paramIntent = new StringBuilder();
      paramIntent.append("userinfo select id");
      paramIntent.append(WxaSettingActivity.k(this.a));
      o.d("Luggage.STANDALONE.WxaSettingActivity", paramIntent.toString());
      paramIntent = new StringBuilder();
      paramIntent.append("userinfo main switch state");
      paramIntent.append(WxaSettingActivity.l(this.a).c);
      o.d("Luggage.STANDALONE.WxaSettingActivity", paramIntent.toString());
      WxaSettingActivity.a(this.a, new WxaSettingActivity.32.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.32
 * JD-Core Version:    0.7.0.1
 */