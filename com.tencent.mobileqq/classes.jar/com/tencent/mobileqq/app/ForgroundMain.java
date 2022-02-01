package com.tencent.mobileqq.app;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.utils.QGuardUtils;
import com.tencent.qphone.base.util.QLog;

public class ForgroundMain
  extends GuardState
{
  protected long a;
  private String a;
  protected long b;
  
  public ForgroundMain()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a()
  {
    boolean bool2 = true;
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onTick mClearTick: ", Long.valueOf(this.d), " m" });
    }
    this.jdField_a_of_type_Long += 1L;
    this.b += 1L;
    if (this.d >= 3L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString == null) {
        break label245;
      }
      bool1 = true;
      QGuardUtils.a(bool1, new String[] { "com.tencent.mobileqq:tool", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:plugins", "com.tencent.mobileqq:mini", this.jdField_a_of_type_JavaLangString });
      this.d = 0L;
      if (!bool1) {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
      }
    }
    if ((this.jdField_a_of_type_Long >= 15L) && (!((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.disable_qzone_kill.name())))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString != null)
      {
        bool1 = true;
        label183:
        QGuardUtils.a(bool1, "com.tencent.mobileqq:qzone");
        StatisticHitRateCollector.a().d(StatisticHitRateCollector.a());
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else if (this.b >= GuardManager.d) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_JavaLangString == null) {
        break label255;
      }
    }
    label245:
    label255:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QGuardUtils.a(bool1, "com.tencent.mobileqq:tool");
      QGuardUtils.a(bool1, "com.tencent.mobileqq:plugins");
      this.b = 0L;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label183;
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onForground proc: ", paramString });
    }
    if (!"com.tencent.mobileqq".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onEnter proc: ", paramString });
    }
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    CoreService.startCoreService(GuardConfig.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b();
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onBackground proc: ", paramString });
    }
    if ("com.tencent.mobileqq".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ForgroundMain
 * JD-Core Version:    0.7.0.1
 */