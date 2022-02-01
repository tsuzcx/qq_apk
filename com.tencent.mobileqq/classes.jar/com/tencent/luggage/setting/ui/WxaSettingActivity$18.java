package com.tencent.luggage.setting.ui;

import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;

final class WxaSettingActivity$18
  implements LuggageActivityHelper.ActivityResultCallback
{
  WxaSettingActivity$18(WxaSettingActivity.d paramd) {}
  
  public void onResult(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      paramIntent = this.a;
      if (paramIntent != null) {
        paramIntent.a(-1, null, 0);
      }
      return;
    }
    int i = paramIntent.getIntExtra("KEY_LOCATION_AUTH_FLAG", 0);
    WxaSettingActivity.d locald = this.a;
    if (locald != null)
    {
      if ((locald instanceof WxaSettingActivity.e))
      {
        boolean bool = paramIntent.getBooleanExtra("KEY_APP_CLOSE_MENU", true);
        ((WxaSettingActivity.e)this.a).a(paramInt, paramIntent, i, bool);
        return;
      }
      locald.a(paramInt, paramIntent, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.18
 * JD-Core Version:    0.7.0.1
 */