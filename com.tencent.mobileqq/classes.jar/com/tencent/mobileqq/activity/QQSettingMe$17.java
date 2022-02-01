package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import mqq.app.MobileQQ;

class QQSettingMe$17
  implements Runnable
{
  QQSettingMe$17(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      String str = this.this$0.a.getCurrentAccountUin();
      IWebProcessPreload localIWebProcessPreload = (IWebProcessPreload)QRoute.api(IWebProcessPreload.class);
      if ((!TextUtils.isEmpty(str)) && (localIWebProcessPreload != null)) {
        localIWebProcessPreload.setBusinessClickTimeMills(str, "individuation");
      }
      this.this$0.a.getApplication().getSharedPreferences("emoticon_panel_" + this.this$0.a.getCurrentAccountUin(), 0).edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.17
 * JD-Core Version:    0.7.0.1
 */