package com.tencent.mobileqq.app.guardcallback;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ForeBackgroundSwitch;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.guardinterface.IGuardInterface;
import com.tencent.mobileqq.app.qqdaily.FrontBackReportManager;
import com.tencent.mobileqq.app.utils.BackgroundAliveTimeStatistic;
import com.tencent.mobileqq.bgprobe.BackgroundProbeManager;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.qqperf.monitor.backgroundcpu.BatteryStats;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class CommonProcessor
  implements IGuardInterface
{
  public void a()
  {
    DarkModeManager.a(null);
    FrontBackReportManager.a(1);
    QQAppInterface.getBatteryStats().c();
    ForeBackgroundSwitch.a().a(MobileQQ.processName);
    ColorNoteSmallScreenUtil.a(true);
    BackgroundAliveTimeStatistic.b();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_SCHEDULER_MANAGER);
      if (localObject != null) {
        ((PreDownloadScheduler)localObject).onAppForground();
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    FrontBackReportManager.a(2);
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (((QQAppInterface)localObject).isRunning()) {
      ((QQAppInterface)localObject).showIdleNotification(BaseApplicationImpl.sApplication, null);
    }
    ColorNoteSmallScreenUtil.a(false);
    BackgroundProbeManager.a();
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(1, 0L, 0L);
    QQAppInterface.getBatteryStats().b();
    ForeBackgroundSwitch.a().a();
    BackgroundAliveTimeStatistic.c();
    if (localObject != null)
    {
      localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_SCHEDULER_MANAGER);
      if (localObject != null) {
        ((PreDownloadScheduler)localObject).onAppBackground();
      }
    }
  }
  
  public void b(long paramLong)
  {
    Object localObject = GuardManager.a;
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramLong >= ((GuardManager)localObject).a() / 12000L) || (paramLong != 1L));
        MemoryManager.a().a("LITE_GUARD");
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } while (localObject == null);
      localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_SCHEDULER_MANAGER);
    } while (localObject == null);
    ((PreDownloadScheduler)localObject).onAppLiteStart(true);
  }
  
  public void c(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.CommonProcessor
 * JD-Core Version:    0.7.0.1
 */