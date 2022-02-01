package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.apollo.drawer.ISettingMeApolloViewController;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class QQSettingMeApolloProcessor$WebPreloadTask
  implements Runnable
{
  private final WeakReference<QQSettingMeApolloProcessor> a;
  
  QQSettingMeApolloProcessor$WebPreloadTask(QQSettingMeApolloProcessor paramQQSettingMeApolloProcessor)
  {
    this.a = new WeakReference(paramQQSettingMeApolloProcessor);
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        QQSettingMeApolloProcessor localQQSettingMeApolloProcessor = (QQSettingMeApolloProcessor)this.a.get();
        if (localQQSettingMeApolloProcessor != null)
        {
          if (localQQSettingMeApolloProcessor.c == null) {
            return;
          }
          localObject = (IWebProcessManagerService)localQQSettingMeApolloProcessor.c.getRuntimeService(IWebProcessManagerService.class, "");
          if (((IApolloUtil)QRoute.api(IApolloUtil.class)).checkPreloadOnSettingMe(localQQSettingMeApolloProcessor.c, QQSettingMeApolloProcessor.a(localQQSettingMeApolloProcessor).getView()))
          {
            i = 100;
            ((IWebProcessManagerService)localObject).startWebProcess(i, new QQSettingMeApolloProcessor.WebPreloadTask.1(this));
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("WebPreloadTask preloadWebProcess, exception=");
        ((StringBuilder)localObject).append(MsfSdkUtils.getStackTraceString(localException));
        QLog.e("QQSettingRedesign", 1, ((StringBuilder)localObject).toString());
        return;
      }
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeApolloProcessor.WebPreloadTask
 * JD-Core Version:    0.7.0.1
 */