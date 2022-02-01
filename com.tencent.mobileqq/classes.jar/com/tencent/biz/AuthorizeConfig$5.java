package com.tencent.biz;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

class AuthorizeConfig$5
  implements Runnable
{
  AuthorizeConfig$5(AuthorizeConfig paramAuthorizeConfig, TicketManager paramTicketManager, String paramString, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_MqqManagerTicketManager == null) {
        break label101;
      }
      if ((this.jdField_a_of_type_MqqManagerTicketManager.getPskey(this.jdField_a_of_type_JavaLangString, 16L, this.jdField_a_of_type_ArrayOfJavaLangString, this.this$0.a) == null) || (TextUtils.isEmpty(this.jdField_a_of_type_MqqManagerTicketManager.getSkey(this.jdField_a_of_type_JavaLangString)))) {
        break label106;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        label101:
        continue;
        label106:
        boolean bool = false;
      }
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pre hits result : ");
    localStringBuilder.append(bool);
    QLog.d("AuthorizeConfig", 1, localStringBuilder.toString());
    return;
    QLog.e("AuthorizeConfig", 1, "preload k exception ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.5
 * JD-Core Version:    0.7.0.1
 */