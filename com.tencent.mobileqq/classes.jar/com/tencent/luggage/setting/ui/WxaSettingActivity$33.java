package com.tencent.luggage.setting.ui;

import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.eh.c;

class WxaSettingActivity$33
  implements LuggageActivityHelper.ActivityResultCallback
{
  WxaSettingActivity$33(WxaSettingActivity paramWxaSettingActivity) {}
  
  public void onResult(int paramInt, Intent paramIntent)
  {
    paramIntent = (c)paramIntent.getParcelableExtra("key_biz_data");
    if (paramIntent != null)
    {
      WxaSettingActivity.b(this.a, paramIntent);
      WxaSettingActivity.m(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.33
 * JD-Core Version:    0.7.0.1
 */