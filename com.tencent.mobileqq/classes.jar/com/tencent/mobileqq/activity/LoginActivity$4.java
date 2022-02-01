package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class LoginActivity$4
  implements Runnable
{
  LoginActivity$4(LoginActivity paramLoginActivity, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "-->login success(finish after ls), go to AgentActivity, account:" + this.a);
    }
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity.4
 * JD-Core Version:    0.7.0.1
 */