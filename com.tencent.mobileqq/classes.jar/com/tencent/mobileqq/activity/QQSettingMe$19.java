package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;

class QQSettingMe$19
  implements Runnable
{
  QQSettingMe$19(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    String str;
    IWebProcessPreload localIWebProcessPreload;
    do
    {
      do
      {
        return;
        str = this.this$0.a.getCurrentAccountUin();
      } while (TextUtils.isEmpty(str));
      localIWebProcessPreload = (IWebProcessPreload)QRoute.api(IWebProcessPreload.class);
    } while (localIWebProcessPreload == null);
    localIWebProcessPreload.setBusinessClickTimeMills(str, "vip");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.19
 * JD-Core Version:    0.7.0.1
 */