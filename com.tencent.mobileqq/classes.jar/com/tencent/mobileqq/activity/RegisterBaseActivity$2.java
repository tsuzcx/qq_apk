package com.tencent.mobileqq.activity;

import aduf;
import bdgm;
import bdjz;

public class RegisterBaseActivity$2
  implements Runnable
{
  RegisterBaseActivity$2(RegisterBaseActivity paramRegisterBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(this.this$0, 230);
    localbdjz.setTitle(this.a);
    localbdjz.setMessage(this.b);
    localbdjz.setPositiveButton(2131720421, new aduf(this));
    localbdjz.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */