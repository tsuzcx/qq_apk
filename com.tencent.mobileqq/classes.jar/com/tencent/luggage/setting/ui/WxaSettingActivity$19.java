package com.tencent.luggage.setting.ui;

import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;

class WxaSettingActivity$19
  implements LuggageActivityHelper.ActivityResultCallback
{
  WxaSettingActivity$19(WxaSettingActivity paramWxaSettingActivity) {}
  
  public void onResult(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      paramInt = WxaSettingActivity.t(this.a);
      if ((paramIntent != null) && (paramIntent.hasExtra("key_result_state")))
      {
        paramInt = paramIntent.getIntExtra("key_result_state", paramInt);
        WxaSettingActivity.b(this.a, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.19
 * JD-Core Version:    0.7.0.1
 */