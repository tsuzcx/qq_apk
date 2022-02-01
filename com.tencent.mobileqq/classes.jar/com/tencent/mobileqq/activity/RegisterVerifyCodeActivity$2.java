package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.widget.VerifyCodeView;
import mqq.os.MqqHandler;

class RegisterVerifyCodeActivity$2
  extends MqqHandler
{
  RegisterVerifyCodeActivity$2(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 106)
    {
      if (i != 108) {
        return;
      }
      RegisterVerifyCodeActivity.a(this.a).setCode("");
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.2
 * JD-Core Version:    0.7.0.1
 */