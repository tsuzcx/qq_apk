package com.tencent.mobileqq.activity.qqsettingme;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import mqq.app.AppRuntime;

class QQSettingMeSuperMemberProcessor$6
  implements Runnable
{
  QQSettingMeSuperMemberProcessor$6(QQSettingMeSuperMemberProcessor paramQQSettingMeSuperMemberProcessor) {}
  
  public void run()
  {
    if (this.this$0.c == null) {
      return;
    }
    String str = this.this$0.c.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).setBusinessClickTimeMills(str, "vip");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor.6
 * JD-Core Version:    0.7.0.1
 */