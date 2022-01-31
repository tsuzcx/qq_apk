package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class RegisterActivity$9
  extends TimerTask
{
  RegisterActivity$9(RegisterActivity paramRegisterActivity, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "reQuerySms schedule");
    }
    RegisterActivity.a(this.this$0);
    RegisterActivity.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.9
 * JD-Core Version:    0.7.0.1
 */