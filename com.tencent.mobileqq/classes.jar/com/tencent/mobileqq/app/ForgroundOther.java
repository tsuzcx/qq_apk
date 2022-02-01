package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

public class ForgroundOther
  extends GuardState
{
  private String a;
  
  public ForgroundOther()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundOther", 2, new Object[] { "ForgroundOther: onEnter proc: ", paramString });
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    CoreService.startCoreService(GuardConfig.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.c();
  }
  
  protected void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.ForgroundOther", 2, new Object[] { "ForgroundOther: onBackground proc: ", paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ForgroundOther
 * JD-Core Version:    0.7.0.1
 */