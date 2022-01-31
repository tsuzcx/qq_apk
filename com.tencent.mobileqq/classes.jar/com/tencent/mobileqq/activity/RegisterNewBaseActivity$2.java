package com.tencent.mobileqq.activity;

import abyp;
import bbdj;
import bbgu;

public class RegisterNewBaseActivity$2
  implements Runnable
{
  RegisterNewBaseActivity$2(RegisterNewBaseActivity paramRegisterNewBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    bbgu localbbgu = bbdj.a(this.this$0, 230);
    localbbgu.setTitle(this.a);
    localbbgu.setMessage(this.b);
    localbbgu.setPositiveButton(2131719878, new abyp(this));
    localbbgu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */