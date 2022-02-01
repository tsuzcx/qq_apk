package com.tencent.mobileqq.activity;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class RegisterActivity$11
  extends MqqHandler
{
  RegisterActivity$11(RegisterActivity paramRegisterActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 9) {
      return;
    }
    paramMessage = (String)paramMessage.obj;
    if (!TextUtils.isEmpty(paramMessage))
    {
      RegisterActivity.b(this.a, paramMessage);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "captcha sig is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.11
 * JD-Core Version:    0.7.0.1
 */