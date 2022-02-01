package com.tencent.luggage.setting.ui;

import android.os.Handler;
import android.os.Message;
import android.preference.Preference;
import android.widget.Toast;
import com.tencent.weui.base.preference.IPreferenceScreen;
import java.lang.ref.WeakReference;

class WxaSettingActivity$c
  extends Handler
{
  WeakReference<WxaSettingActivity> a;
  
  WxaSettingActivity$c(WxaSettingActivity paramWxaSettingActivity)
  {
    this.a = new WeakReference(paramWxaSettingActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      localWxaSettingActivity = (WxaSettingActivity)this.a.get();
      if (localWxaSettingActivity == null) {
        return;
      }
      paramMessage = (com.tencent.luggage.wxa.ih.c)paramMessage.obj;
      WxaSettingActivity.b(localWxaSettingActivity);
      if (paramMessage == null)
      {
        Toast.makeText(localWxaSettingActivity, localWxaSettingActivity.getString(2131886985), 1).show();
        return;
      }
      WxaSettingActivity.a(localWxaSettingActivity).a(paramMessage);
      if (WxaSettingActivity.a(localWxaSettingActivity).a())
      {
        Preference localPreference = localWxaSettingActivity.a.findPreference("preference_key_subscribe_msg");
        if (localPreference != null)
        {
          if (WxaSettingActivity.a(localWxaSettingActivity).b()) {
            paramMessage = "";
          } else {
            paramMessage = localWxaSettingActivity.getString(2131886991);
          }
          localPreference.setSummary(paramMessage);
          localWxaSettingActivity.a.notifyDataSetChanged();
        }
      }
      else
      {
        localWxaSettingActivity.a.removePreference("preference_key_subscribe_msg");
        localWxaSettingActivity.a.notifyDataSetChanged();
      }
      WxaSettingActivity.a(localWxaSettingActivity, localWxaSettingActivity.d, WxaSettingActivity.a(localWxaSettingActivity), WxaSettingActivity.a(WxaSettingActivity.c(localWxaSettingActivity), localWxaSettingActivity.d));
      return;
    }
    WxaSettingActivity localWxaSettingActivity = (WxaSettingActivity)this.a.get();
    if (localWxaSettingActivity == null) {
      return;
    }
    paramMessage = (com.tencent.luggage.wxa.eh.c)paramMessage.obj;
    localWxaSettingActivity.c = true;
    if (paramMessage == null)
    {
      WxaSettingActivity.a(localWxaSettingActivity, localWxaSettingActivity.d, null);
      return;
    }
    WxaSettingActivity.a(localWxaSettingActivity, paramMessage);
    WxaSettingActivity.a(localWxaSettingActivity, localWxaSettingActivity.d, WxaSettingActivity.a(localWxaSettingActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.c
 * JD-Core Version:    0.7.0.1
 */