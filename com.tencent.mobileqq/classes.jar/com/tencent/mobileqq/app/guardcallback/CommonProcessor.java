package com.tencent.mobileqq.app.guardcallback;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ForeBackgroundSwitch;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.app.qqdaily.FrontBackReportManager;
import com.tencent.mobileqq.app.utils.BackgroundAliveTimeStatistic;
import com.tencent.mobileqq.bgprobe.BackgroundProbeManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qqperf.monitor.backgroundcpu.BatteryStats;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class CommonProcessor
  implements IGuardInterface
{
  public void G_()
  {
    DarkModeManager.a(null);
    FrontBackReportManager.a(1);
    QQAppInterface.getBatteryStats().c();
    ForeBackgroundSwitch.a().a(MobileQQ.processName);
    BackgroundAliveTimeStatistic.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).setAppOnForeground(localQQAppInterface, true);
    if ((localQQAppInterface != null) && (!TextUtils.isEmpty(localQQAppInterface.getAccount()))) {
      ((IPreDownloadController)localQQAppInterface.getRuntimeService(IPreDownloadController.class)).onAppForeground();
    }
  }
  
  public void H_()
  {
    FrontBackReportManager.a(2);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface.isRunning()) {
      localQQAppInterface.showIdleNotification(BaseApplicationImpl.sApplication, null);
    }
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).setAppOnForeground(localQQAppInterface, false);
    BackgroundProbeManager.a();
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(1, 0L, 0L);
    QQAppInterface.getBatteryStats().b();
    ForeBackgroundSwitch.a().a();
    BackgroundAliveTimeStatistic.c();
    if (!TextUtils.isEmpty(localQQAppInterface.getAccount())) {
      ((IPreDownloadController)localQQAppInterface.getRuntimeService(IPreDownloadController.class)).onAppBackground();
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b(long paramLong)
  {
    Object localObject = GuardManager.a;
    if (localObject == null) {
      return;
    }
    if ((paramLong < ((GuardManager)localObject).a() / 12000L) && (paramLong == 1L))
    {
      MemoryManager.a().a("LITE_GUARD");
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null)
      {
        localObject = (IPreDownloadController)((QQAppInterface)localObject).getRuntimeService(IPreDownloadController.class);
        if (localObject != null) {
          ((IPreDownloadController)localObject).onAppLiteStart(true);
        }
      }
    }
  }
  
  public void c(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.CommonProcessor
 * JD-Core Version:    0.7.0.1
 */