package com.tencent.mobileqq.activity;

import abyi;
import bbdj;
import bbgu;

public class RegisterBaseActivity$2
  implements Runnable
{
  RegisterBaseActivity$2(RegisterBaseActivity paramRegisterBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    bbgu localbbgu = bbdj.a(this.this$0, 230);
    localbbgu.setTitle(this.a);
    localbbgu.setMessage(this.b);
    localbbgu.setPositiveButton(2131719878, new abyi(this));
    localbbgu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */