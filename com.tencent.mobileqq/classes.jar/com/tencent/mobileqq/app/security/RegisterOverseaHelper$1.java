package com.tencent.mobileqq.app.security;

import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;

class RegisterOverseaHelper$1
  implements Runnable
{
  RegisterOverseaHelper$1(RegisterOverseaHelper paramRegisterOverseaHelper, String paramString, RegisterNewBaseActivity paramRegisterNewBaseActivity) {}
  
  public void run()
  {
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleIframe captchaURL: ");
      localStringBuilder.append(this.a);
      QLog.d("RegisterOverseaHelper", 4, localStringBuilder.toString());
    }
    RegisterOverseaHelper.a(this.this$0, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.security.RegisterOverseaHelper.1
 * JD-Core Version:    0.7.0.1
 */