package com.tencent.mobileqq.activity;

import afjw;
import bhlq;
import bhpc;

public class RegisterBaseActivity$2
  implements Runnable
{
  RegisterBaseActivity$2(RegisterBaseActivity paramRegisterBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    bhpc localbhpc = bhlq.a(this.this$0, 230);
    localbhpc.setTitle(this.a);
    localbhpc.setMessage(this.b);
    localbhpc.setPositiveButton(2131718422, new afjw(this));
    localbhpc.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */