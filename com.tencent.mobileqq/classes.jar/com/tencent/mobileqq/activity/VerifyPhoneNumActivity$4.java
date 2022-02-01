package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.PhoneContactManager;

class VerifyPhoneNumActivity$4
  implements Runnable
{
  VerifyPhoneNumActivity$4(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    ((PhoneContactManager)this.this$0.app.getManager(QQManagerFactory.CONTACT_MANAGER)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.4
 * JD-Core Version:    0.7.0.1
 */