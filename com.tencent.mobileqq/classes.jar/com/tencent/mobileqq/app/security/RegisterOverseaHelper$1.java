package com.tencent.mobileqq.app.security;

import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;

class RegisterOverseaHelper$1
  implements Runnable
{
  RegisterOverseaHelper$1(RegisterOverseaHelper paramRegisterOverseaHelper, String paramString, RegisterNewBaseActivity paramRegisterNewBaseActivity) {}
  
  public void run()
  {
    if (QLog.isDebugVersion()) {
      QLog.d("RegisterOverseaHelper", 4, "handleIframe captchaURL: " + this.jdField_a_of_type_JavaLangString);
    }
    RegisterOverseaHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.security.RegisterOverseaHelper.1
 * JD-Core Version:    0.7.0.1
 */