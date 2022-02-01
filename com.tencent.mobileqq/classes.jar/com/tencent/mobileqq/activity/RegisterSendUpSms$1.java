package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class RegisterSendUpSms$1
  extends MqqHandler
{
  RegisterSendUpSms$1(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 107) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms.1
 * JD-Core Version:    0.7.0.1
 */