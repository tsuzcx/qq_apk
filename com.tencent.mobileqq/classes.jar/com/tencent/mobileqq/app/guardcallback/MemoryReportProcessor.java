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
  private void b(boolean paramBoolean)
  {
    Object localObject = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager;
    if (localObject == null) {
      return;
    }
    long l = MemoryManager.a(Process.myPid());
    int[] arrayOfInt = ((GuardManager)localObject).a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
    double d = arrayOfInt[0];
    Double.isNaN(d);
    localHashMap.put("resumeCount", String.valueOf(d * 1.0D / 15.0D));
    d = arrayOfInt[1];
    Double.isNaN(d);
    localHashMap.put("msgCount", String.valueOf(d * 1.0D / 15.0D));
    localHashMap.put("activeLevel", String.valueOf(((GuardManager)localObject).a()));
    if (paramBoolean) {
      localObject = "actLiteActive";
    } else {
      localObject = "actFullActive";
    }
    a((String)localObject, localHashMap);
  }
  
  public void G_()
  {
    if ((StartService.a) && ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))) {
      MemoryManager.a().a(BaseApplicationImpl.sApplication, ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).getNotifyActivityClass(), 10);
    }
  }
  
  public void H_() {}
  
  public void a(long paramLong)
  {
    GuardManager localGuardManager = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager;
    if (localGuardManager == null) {
      return;
    }
    int i = GuardConfig.a().a(MemoryManager.a(Process.myPid()));
    int j = localGuardManager.a();
    if ((paramLong < GuardConfig.a().b[(i + j)] / 12000) && (paramLong == 1L))
    {
      MemoryManager.a().a(1L);
      MemoryManager.a().a("BG_GUARD");
    }
  }
  
  protected void a(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    paramHashMap.put("config", GuardConfig.a().jdField_a_of_type_JavaLangString);
    localStatisticCollector.collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(long paramLong)
  {
    GuardManager localGuardManager = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager;
    if (localGuardManager == null) {
      return;
    }
    if (paramLong >= localGuardManager.a()) {
      b(true);
    }
  }
  
  public void c(long paramLong)
  {
    Object localObject = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager;
    if (localObject == null) {
      return;
    }
    float f2 = MemoryManager.a().a();
    float f1;
    if (MagnifierSDK.a().a().d > 0.0F) {
      f1 = MagnifierSDK.a().a().d;
    } else {
      f1 = 0.95F;
    }
    if ((f2 >= f1) && (MagnifierSDK.a().a().b) && (((GuardManager)localObject).jdField_a_of_type_JavaLangString == null))
    {
      MemoryManager.a().a(2L);
      System.exit(-1);
    }
    if (paramLong == GuardManager.c * 50 - 1)
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
        ((StringBuilder)localObject).append(GuardManager.c);
        QLog.d("GuardManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.MemoryReportProcessor
 * JD-Core Version:    0.7.0.1
 */