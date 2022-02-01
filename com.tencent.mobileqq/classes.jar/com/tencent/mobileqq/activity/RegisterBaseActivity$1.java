package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;

class RegisterBaseActivity$1
  extends Handler
{
  RegisterBaseActivity$1(RegisterBaseActivity paramRegisterBaseActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 101) {
      return;
    }
    this.a.a();
    String str = paramMessage.obj.toString();
    paramMessage = str;
    if (str == null) {
      paramMessage = this.a.getString(2131720115);
    }
    this.a.a(paramMessage, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */