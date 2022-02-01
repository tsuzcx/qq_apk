package com.tencent.mobileqq.app.guard;

import com.tencent.mobileqq.app.CoreService;
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
    super.a();
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = true;
    if (bool1) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onTick mClearTick: ", Long.valueOf(this.d), " m" });
    }
    this.jdField_a_of_type_Long += 1L;
    this.b += 1L;
    if (this.d >= 3L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.jdField_a_of_type_JavaLangString != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QGuardUtils.a(bool1, new String[] { "com.tencent.mobileqq:tool", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:plugins", "com.tencent.mobileqq:mini", this.jdField_a_of_type_JavaLangString });
      this.d = 0L;
      GuardStateScheduler.a().a(2, this.jdField_a_of_type_JavaLangString, 0);
    }
    if ((this.jdField_a_of_type_Long >= 15L) && (!((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.disable_qzone_kill.name())))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.jdField_a_of_type_JavaLangString != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QGuardUtils.a(bool1, "com.tencent.mobileqq:qzone");
      StatisticHitRateCollector.a().d(StatisticHitRateCollector.a());
      this.jdField_a_of_type_Long = 0L;
    }
    if (this.b >= GuardManager.d)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.jdField_a_of_type_JavaLangString != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      QGuardUtils.a(bool1, "com.tencent.mobileqq:tool");
      QGuardUtils.a(bool1, "com.tencent.mobileqq:plugins");
      this.b = 0L;
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundMain", 2, new Object[] { "ForgroundMain: onForground proc: ", paramString });
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
    this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.b();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.ForgroundMain
 * JD-Core Version:    0.7.0.1
 */