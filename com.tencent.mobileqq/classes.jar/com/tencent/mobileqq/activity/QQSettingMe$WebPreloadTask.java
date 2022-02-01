package com.tencent.mobileqq.activity;

import aezj;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QQSettingMe$WebPreloadTask
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
        WebProcessManager localWebProcessManager = (WebProcessManager)localQQSettingMe.a.getManager(13);
        if (localWebProcessManager == null) {
          break;
        }
        if (ApolloUtil.a(localQQSettingMe.a, QQSettingMe.a(localQQSettingMe).a))
        {
          i = 100;
          localWebProcessManager.a(i, new aezj(this, localQQSettingMe));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.WebPreloadTask
 * JD-Core Version:    0.7.0.1
 */