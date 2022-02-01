package com.tencent.mobileqq.activity;

import afjz;
import bhlq;
import bhpc;

public class RegisterNewBaseActivity$2
  implements Runnable
{
  RegisterNewBaseActivity$2(RegisterNewBaseActivity paramRegisterNewBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    bhpc localbhpc = bhlq.a(this.this$0, 230);
    localbhpc.setTitle(this.a);
    localbhpc.setMessage(this.b);
    localbhpc.setPositiveButton(2131718422, new afjz(this));
    localbhpc.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */