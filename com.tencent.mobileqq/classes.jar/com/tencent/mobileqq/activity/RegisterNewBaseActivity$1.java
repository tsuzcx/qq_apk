package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;

class RegisterNewBaseActivity$1
  extends Handler
{
  RegisterNewBaseActivity$1(RegisterNewBaseActivity paramRegisterNewBaseActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 101)
    {
      if (i != 110) {
        return;
      }
      this.a.closeDialog();
      this.a.finish();
      return;
    }
    this.a.closeDialog();
    String str = paramMessage.obj.toString();
    paramMessage = str;
    if (str == null) {
      paramMessage = this.a.getString(2131917741);
    }
    this.a.notifyToast(paramMessage, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */