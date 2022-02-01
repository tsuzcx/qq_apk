package com.tencent.mobileqq.activity;

import aecr;
import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class RegisterNewBaseActivity$2
  implements Runnable
{
  RegisterNewBaseActivity$2(RegisterNewBaseActivity paramRegisterNewBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bfur.a(this.this$0, 230);
    localQQCustomDialog.setTitle(this.a);
    localQQCustomDialog.setMessage(this.b);
    localQQCustomDialog.setPositiveButton(2131718670, new aecr(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */