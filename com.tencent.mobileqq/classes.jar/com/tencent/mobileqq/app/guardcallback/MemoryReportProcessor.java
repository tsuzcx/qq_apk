package com.tencent.mobileqq.app.guardcallback;

import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.GuardConfig;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.guardinterface.IGuardInterface;
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
    Object localObject = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager;
    if (localObject == null) {
      return;
    }
    long l = MemoryManager.a(Process.myPid());
    int[] arrayOfInt = ((GuardManager)localObject).a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
    localHashMap.put("resumeCount", String.valueOf(arrayOfInt[0] * 1.0D / 15.0D));
    localHashMap.put("msgCount", String.valueOf(arrayOfInt[1] * 1.0D / 15.0D));
    localHashMap.put("activeLevel", String.valueOf(((GuardManager)localObject).a()));
    if (paramBoolean) {}
    for (localObject = "actLiteActive";; localObject = "actFullActive")
    {
      a((String)localObject, localHashMap);
      return;
    }
  }
  
  public void a()
  {
    if ((StartService.a) && ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))) {
      MemoryManager.a().a(BaseApplicationImpl.sApplication, NotificationActivity.class, 10);
    }
  }
  
  public void a(long paramLong)
  {
    GuardManager localGuardManager = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager;
    if (localGuardManager == null) {}
    int i;
    int j;
    do
    {
      return;
      i = GuardConfig.a().a(MemoryManager.a(Process.myPid()));
      j = localGuardManager.a();
    } while ((paramLong >= GuardConfig.a().b[(j + i)] / 12000) || (paramLong != 1L));
    MemoryManager.a().a(1L);
    MemoryManager.a().a("BG_GUARD");
  }
  
  protected void a(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    paramHashMap.put("config", GuardConfig.a().jdField_a_of_type_JavaLangString);
    localStatisticCollector.collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "");
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void b(long paramLong)
  {
    GuardManager localGuardManager = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager;
    if (localGuardManager == null) {}
    while (paramLong < localGuardManager.a()) {
      return;
    }
    b(true);
  }
  
  public void c(long paramLong)
  {
    Object localObject = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager;
    if (localObject == null) {
      return;
    }
    float f2 = MemoryManager.a().a();
    if (MagnifierSDK.a().a().d > 0.0F) {}
    for (float f1 = MagnifierSDK.a().a().d;; f1 = 0.95F)
    {
      if ((f2 >= f1) && (MagnifierSDK.a().a().b) && (((GuardManager)localObject).jdField_a_of_type_JavaLangString == null))
      {
        MemoryManager.a().a(2L);
        System.exit(-1);
      }
      if (paramLong != GuardManager.c * 50 - 1) {
        break;
      }
      paramLong = MemoryManager.a(Process.myPid());
      localObject = new HashMap();
      ((HashMap)localObject).put("qqUsedMemory", String.valueOf(paramLong / 1024L));
      ((HashMap)localObject).put("ramSize", String.valueOf(DeviceInfoUtil.a() / 1024L));
      ((HashMap)localObject).put("heapSize", String.valueOf(Runtime.getRuntime().totalMemory() / 1024L));
      ((HashMap)localObject).put("maxHeapSize", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
      a("GM_reborn", (HashMap)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GuardManager", 2, "suicide to free memory! suicide_factor=" + GuardManager.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.MemoryReportProcessor
 * JD-Core Version:    0.7.0.1
 */