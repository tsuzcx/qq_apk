package com.tencent.mobileqq.activity;

import ajjy;
import android.os.Handler;
import android.widget.Button;

class RegisterSendUpSms$2
  implements Runnable
{
  RegisterSendUpSms$2(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void run()
  {
    if (RegisterSendUpSms.a(this.this$0) == 1)
    {
      RegisterSendUpSms.a(this.this$0).setText(ajjy.a(2131647545));
      RegisterSendUpSms.a(this.this$0).setEnabled(true);
      RegisterSendUpSms.a(this.this$0).setClickable(true);
      RegisterSendUpSms.a(this.this$0, 0);
      RegisterSendUpSms.b(this.this$0, 10);
      return;
    }
    RegisterSendUpSms.b(this.this$0);
    RegisterSendUpSms.a(this.this$0).setText(ajjy.a(2131647543) + "(" + RegisterSendUpSms.a(this.this$0) + "s)");
    this.this$0.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms.2
 * JD-Core Version:    0.7.0.1
 */