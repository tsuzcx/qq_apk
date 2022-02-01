package com.tencent.mobileqq.activity;

import afap;
import bglp;
import bgpa;

public class RegisterBaseActivity$2
  implements Runnable
{
  RegisterBaseActivity$2(RegisterBaseActivity paramRegisterBaseActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    bgpa localbgpa = bglp.a(this.this$0, 230);
    localbgpa.setTitle(this.a);
    localbgpa.setMessage(this.b);
    localbgpa.setPositiveButton(2131718286, new afap(this));
    localbgpa.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */