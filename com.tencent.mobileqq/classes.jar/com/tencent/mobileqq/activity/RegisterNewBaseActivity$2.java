package com.tencent.mobileqq.activity;

import adum;
import bdgm;
import bdjz;

public class RegisterNewBaseActivity$2
  implements Runnable
{
  RegisterNewBaseActivity$2(RegisterNewBaseActivity paramRegisterNewBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(this.this$0, 230);
    localbdjz.setTitle(this.a);
    localbdjz.setMessage(this.b);
    localbdjz.setPositiveButton(2131720421, new adum(this));
    localbdjz.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */