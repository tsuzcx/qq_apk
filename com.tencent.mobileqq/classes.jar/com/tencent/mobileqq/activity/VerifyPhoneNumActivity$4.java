package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class VerifyPhoneNumActivity$4
  implements Runnable
{
  VerifyPhoneNumActivity$4(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    ((IPhoneContactService)this.this$0.app.getRuntimeService(IPhoneContactService.class, "")).uploadPhoneContact();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.4
 * JD-Core Version:    0.7.0.1
 */