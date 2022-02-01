package com.tencent.mobileqq.activity.qqsettingme;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QQSettingMeDressUpProcessor$2
  implements Runnable
{
  QQSettingMeDressUpProcessor$2(QQSettingMeDressUpProcessor paramQQSettingMeDressUpProcessor) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      Object localObject = this.this$0.a.getCurrentAccountUin();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).setBusinessClickTimeMills((String)localObject, "individuation");
      }
      localObject = this.this$0.a.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("emoticon_panel_");
      localStringBuilder.append(this.this$0.a.getCurrentAccountUin());
      ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDressUpProcessor.2
 * JD-Core Version:    0.7.0.1
 */