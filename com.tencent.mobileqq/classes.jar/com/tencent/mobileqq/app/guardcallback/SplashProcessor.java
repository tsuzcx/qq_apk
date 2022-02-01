package com.tencent.mobileqq.app.guardcallback;

import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.guardinterface.IGuardInterface;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class SplashProcessor
  implements IGuardInterface
{
  private void d(long paramLong)
  {
    GuardManager localGuardManager;
    if ((paramLong == 1L) && (SetSplash.a()))
    {
      localGuardManager = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager;
      if (localGuardManager != null) {
        break label21;
      }
    }
    label21:
    while (localGuardManager.jdField_a_of_type_JavaLangString != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("setsplash", 2, "needshowsplashtoday , kill myself");
    }
    ReportController.a(null, "CliOper", "", "", "0X800483B", "0X800483B", 0, 0, "", "", "", "");
    System.exit(-1);
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    d(paramLong);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.SplashProcessor
 * JD-Core Version:    0.7.0.1
 */