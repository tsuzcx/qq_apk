package com.tencent.mobileqq.activity.main;

import android.content.res.Resources;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.backgroundcpu.BatteryStats;
import com.tencent.qqperf.opt.clearmemory.MemoryConfigs;

class MainAssistObserver$3
  implements Runnable
{
  MainAssistObserver$3(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    Object localObject = this.this$0.a;
    QQAppInterface localQQAppInterface;
    if (localObject != null) {
      localQQAppInterface = ((SplashActivity)localObject).app;
    } else {
      localQQAppInterface = null;
    }
    if (localObject != null)
    {
      if (localQQAppInterface == null) {
        return;
      }
      try
      {
        AIOPanelUtiles.a(localQQAppInterface);
        MultiMsgManager.a().a(localQQAppInterface);
        localObject = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics();
        int i = ((DisplayMetrics)localObject).widthPixels;
        int j = ((DisplayMetrics)localObject).heightPixels;
        GlobalImageCache.a.setLargeSize((int)(MagnifierSDK.b().j().b * (i * j * 4)));
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyWindowShowed e=");
        localStringBuilder.append(localException);
        QLog.d("MainAssistObserver", 4, localStringBuilder.toString());
      }
      localQQAppInterface.setTalkbackSwitch();
      QQToast.canUseCustomToast();
      QQAppInterface.getBatteryStats().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.3
 * JD-Core Version:    0.7.0.1
 */