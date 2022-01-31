package com.tencent.mobileqq.activity;

import ajeu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.Common;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

final class LoginActivity$1
  implements Runnable
{
  LoginActivity$1(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b = NetConnInfoCenter.getServerTime();
    ajeu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.sApplication, false, true);
    try
    {
      Common.OnLogin(BaseApplicationImpl.sApplication, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("login", 2, "loginSuccessInit kingkong OnLogin throwable: " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity.1
 * JD-Core Version:    0.7.0.1
 */