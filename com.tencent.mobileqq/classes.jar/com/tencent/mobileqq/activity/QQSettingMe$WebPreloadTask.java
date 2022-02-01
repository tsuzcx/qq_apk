package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.apollo.api.ISettingMeApolloViewController;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQSettingMe$WebPreloadTask
  implements Runnable
{
  private WeakReference<QQSettingMe> a;
  
  QQSettingMe$WebPreloadTask(QQSettingMe paramQQSettingMe)
  {
    this.a = new WeakReference(paramQQSettingMe);
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.a == null) {
          return;
        }
        QQSettingMe localQQSettingMe = (QQSettingMe)this.a.get();
        if ((localQQSettingMe == null) || (localQQSettingMe.a == null)) {
          break;
        }
        IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)localQQSettingMe.a.getRuntimeService(IWebProcessManagerService.class, "");
        if (localIWebProcessManagerService == null) {
          break;
        }
        if (((IApolloUtil)QRoute.api(IApolloUtil.class)).checkPreloadOnSettingMe(localQQSettingMe.a, QQSettingMe.a(localQQSettingMe).getView()))
        {
          i = 100;
          localIWebProcessManagerService.startWebProcess(i, new QQSettingMe.WebPreloadTask.1(this, localQQSettingMe));
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQSettingRedesign", 1, "WebPreloadTask preloadWebProcess, exception=" + MsfSdkUtils.getStackTraceString(localException));
        return;
      }
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.WebPreloadTask
 * JD-Core Version:    0.7.0.1
 */