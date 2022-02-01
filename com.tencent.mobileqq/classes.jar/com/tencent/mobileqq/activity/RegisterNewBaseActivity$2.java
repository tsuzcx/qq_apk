package com.tencent.mobileqq.activity;

import aetw;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class RegisterNewBaseActivity$2
  implements Runnable
{
  RegisterNewBaseActivity$2(RegisterNewBaseActivity paramRegisterNewBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(this.this$0, 230);
    localQQCustomDialog.setTitle(this.a);
    localQQCustomDialog.setMessage(this.b);
    localQQCustomDialog.setPositiveButton(2131719059, new aetw(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */