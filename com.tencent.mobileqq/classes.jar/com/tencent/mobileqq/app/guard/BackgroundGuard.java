package com.tencent.mobileqq.app.guard;

import android.os.Process;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
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
    int j = GuardConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.b);
    long l = GuardConfig.a().b[(i + j)] / 12000;
    if (this.c >= l) {
      GuardStateScheduler.a().a(4, this.jdField_a_of_type_JavaLangString, 0);
    } else if ((this.d == 3L) || (this.d == 4L)) {
      QGuardUtils.a(false, new String[] { "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:mini", "com.tencent.mobileqq:tool", "com.tencent.mobileqq:plugins", this.jdField_a_of_type_JavaLangString });
    }
    if ((this.d != 50L) && (this.d != 51L))
    {
      c();
      d();
      return;
    }
    QGuardUtils.a(true);
    QGuardUtils.a(false, new String[0]);
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.BackgroundGuard", 2, new Object[] { "BackgroundGuard onForground: process", paramString });
    }
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
      this.c = (GuardConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.jdField_a_of_type_Array2dOfLong, this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.b, MemoryUtils.a(Process.myPid())) / 12000L - 2L);
    }
    CoreService.startCoreService(GuardConfig.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.BackgroundGuard
 * JD-Core Version:    0.7.0.1
 */