package com.tencent.mobileqq.app.guardcallback;

import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.guard.GuardConfig;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import com.tencent.qqperf.opt.clearmemory.MemoryConfigs;
import java.util.HashMap;

public class MemoryReportProcessor
  implements IGuardInterface
{
  private void a(boolean paramBoolean)
  {
    Object localObject = GuardManager.sInstance;
    if (localObject == null) {
      return;
    }
    long l = MemoryManager.a(Process.myPid());
    int[] arrayOfInt = ((GuardManager)localObject).getActiveCount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
    double d = arrayOfInt[0];
    Double.isNaN(d);
    localHashMap.put("resumeCount", String.valueOf(d * 1.0D / 15.0D));
    d = arrayOfInt[1];
    Double.isNaN(d);
    localHashMap.put("msgCount", String.valueOf(d * 1.0D / 15.0D));
    localHashMap.put("activeLevel", String.valueOf(((GuardManager)localObject).getActivateLevel()));
    if (paramBoolean) {
      localObject = "actLiteActive";
    } else {
      localObject = "actFullActive";
    }
    a((String)localObject, localHashMap);
  }
  
  protected void a(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    paramHashMap.put("config", GuardConfig.a().i);
    localStatisticCollector.collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void onApplicationBackground() {}
  
  public void onApplicationForeground()
  {
    if ((StartService.a) && ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))) {
      MemoryManager.a().a(BaseApplicationImpl.sApplication, ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).getNotifyActivityClass(), 10);
    }
  }
  
  public void onBackgroundTimeTick(long paramLong)
  {
    GuardManager localGuardManager = GuardManager.sInstance;
    if (localGuardManager == null) {
      return;
    }
    int i = GuardConfig.a().a(MemoryManager.a(Process.myPid()));
    int j = localGuardManager.getActivateLevel();
    if ((paramLong < GuardConfig.a().c[(i + j)] / 12000) && (paramLong == 1L))
    {
      MemoryManager.a().a(1L);
      MemoryManager.a().a("BG_GUARD");
    }
  }
  
  public void onBackgroundUnguardTimeTick(long paramLong)
  {
    Object localObject = GuardManager.sInstance;
    if (localObject == null) {
      return;
    }
    float f2 = MemoryManager.a().e();
    float f1;
    if (MagnifierSDK.b().j().m > 0.0F) {
      f1 = MagnifierSDK.b().j().m;
    } else {
      f1 = 0.95F;
    }
    if ((f2 >= f1) && (MagnifierSDK.b().j().i) && (((GuardManager)localObject).mFgProcess == null))
    {
      MemoryManager.a().a(2L);
      System.exit(-1);
    }
    if (paramLong == GuardManager.SUICIDE_FACTOR * 50 - 1)
    {
      paramLong = MemoryManager.a(Process.myPid());
      localObject = new HashMap();
      ((HashMap)localObject).put("qqUsedMemory", String.valueOf(paramLong / 1024L));
      ((HashMap)localObject).put("ramSize", String.valueOf(DeviceInfoUtil.a() / 1024L));
      ((HashMap)localObject).put("heapSize", String.valueOf(Runtime.getRuntime().totalMemory() / 1024L));
      ((HashMap)localObject).put("maxHeapSize", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
      a("GM_reborn", (HashMap)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("suicide to free memory! suicide_factor=");
        ((StringBuilder)localObject).append(GuardManager.SUICIDE_FACTOR);
        QLog.d("GuardManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onLiteTimeTick(long paramLong)
  {
    GuardManager localGuardManager = GuardManager.sInstance;
    if (localGuardManager == null) {
      return;
    }
    if (paramLong >= localGuardManager.getTimeout()) {
      a(true);
    }
  }
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.MemoryReportProcessor
 * JD-Core Version:    0.7.0.1
 */