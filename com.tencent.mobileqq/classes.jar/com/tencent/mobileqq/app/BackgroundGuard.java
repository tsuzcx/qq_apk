package com.tencent.mobileqq.app;

import android.os.Process;
import com.tencent.mobileqq.app.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.utils.MemoryUtils;
import com.tencent.mobileqq.utils.QGuardUtils;
import com.tencent.qphone.base.util.QLog;

public class BackgroundGuard
  extends GuardState
{
  private String a;
  
  public BackgroundGuard()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void c()
  {
    if ((this.d == GuardManager.e) || (this.d == GuardManager.e + 1))
    {
      if (!"com.tencent.mobileqq:qzone".equals(this.jdField_a_of_type_JavaLangString)) {
        QGuardUtils.a(false, "com.tencent.mobileqq:qzone");
      }
      QGuardUtils.a(false);
    }
  }
  
  private void d()
  {
    if ((this.d == GuardManager.d) || (this.d == GuardManager.d + 1))
    {
      if (!"com.tencent.mobileqq:tool".equals(this.jdField_a_of_type_JavaLangString)) {
        QGuardUtils.a(false, "com.tencent.mobileqq:tool");
      }
      if (!"com.tencent.mobileqq:plugins".equals(this.jdField_a_of_type_JavaLangString)) {
        QGuardUtils.a(false, "com.tencent.mobileqq:plugins");
      }
    }
  }
  
  protected void a()
  {
    super.a();
    GuardManagerCallbackDispatcher.a(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundGuard", 2, new Object[] { "BackgroundGuard onTick: mClearTick: ", Long.valueOf(this.d), " mGuardTick: ", Long.valueOf(this.c) });
    }
    int i = GuardConfig.a().a(MemoryUtils.a(Process.myPid()));
    int j = GuardConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b);
    long l = GuardConfig.a().b[(i + j)] / 12000;
    if (this.c >= l) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(5, this.jdField_a_of_type_JavaLangString);
    }
    while ((this.d == 50L) || (this.d == 51L))
    {
      QGuardUtils.a(true);
      QGuardUtils.a(false, new String[0]);
      return;
      if ((this.d == 3L) || (this.d == 4L)) {
        QGuardUtils.a(false, new String[] { "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:mini", "com.tencent.mobileqq:tool", "com.tencent.mobileqq:plugins", this.jdField_a_of_type_JavaLangString });
      }
    }
    c();
    d();
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundGuard", 2, new Object[] { "BackgroundGuard onForground: process", paramString });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
  }
  
  protected void b()
  {
    if (this.c > 2L) {
      this.c -= 2L;
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundGuard", 2, new Object[] { "BackgroundGuard enter: process: ", paramString });
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if ("fake_p_msg".equals(paramString)) {
      this.c = (GuardConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b, MemoryUtils.a(Process.myPid())) / 12000L - 2L);
    }
    CoreService.startCoreService(GuardConfig.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BackgroundGuard
 * JD-Core Version:    0.7.0.1
 */