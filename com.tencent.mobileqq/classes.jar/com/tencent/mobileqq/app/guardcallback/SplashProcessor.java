package com.tencent.mobileqq.app.guardcallback;

import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class SplashProcessor
  implements IGuardInterface
{
  private void d(long paramLong)
  {
    if ((paramLong == 1L) && (SetSplash.a()))
    {
      GuardManager localGuardManager = GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager;
      if (localGuardManager == null) {
        return;
      }
      if (localGuardManager.jdField_a_of_type_JavaLangString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("setsplash", 2, "needshowsplashtoday , kill myself");
        }
        ReportController.a(null, "CliOper", "", "", "0X800483B", "0X800483B", 0, 0, "", "", "", "");
        System.exit(-1);
      }
    }
  }
  
  public void G_() {}
  
  public void H_() {}
  
  public void a(long paramLong)
  {
    d(paramLong);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardcallback.SplashProcessor
 * JD-Core Version:    0.7.0.1
 */