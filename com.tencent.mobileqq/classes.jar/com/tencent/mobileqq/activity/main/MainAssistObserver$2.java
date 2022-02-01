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

class MainAssistObserver$2
  implements Runnable
{
  MainAssistObserver$2(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    Object localObject = this.this$0.a;
    if (localObject != null) {}
    for (QQAppInterface localQQAppInterface = ((SplashActivity)localObject).app; (localObject == null) || (localQQAppInterface == null); localQQAppInterface = null) {
      return;
    }
    try
    {
      AIOPanelUtiles.a(localQQAppInterface);
      MultiMsgManager.a().a(localQQAppInterface);
      localObject = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = GlobalImageCache.a;
      float f = MagnifierSDK.a().a().a;
      ((MQLruCache)localObject).setLargeSize((int)(j * i * 4 * f));
      localQQAppInterface.setTalkbackSwitch();
      QQToast.a();
      QQAppInterface.getBatteryStats().a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MainAssistObserver", 4, "notifyWindowShowed e=" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.2
 * JD-Core Version:    0.7.0.1
 */