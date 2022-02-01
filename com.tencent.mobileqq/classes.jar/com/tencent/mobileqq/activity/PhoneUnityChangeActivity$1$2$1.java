package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class PhoneUnityChangeActivity$1$2$1
  extends ContactBindObserver
{
  PhoneUnityChangeActivity$1$2$1(PhoneUnityChangeActivity.1.2 param2) {}
  
  protected void onCancelBind(boolean paramBoolean)
  {
    super.onCancelBind(paramBoolean);
    PhoneUnityChangeActivity.a(this.a.a.a);
    this.a.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      ((PhoneUnityManager)this.a.a.a.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).a(null);
      this.a.a.a.setResult(4001);
      this.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity.1.2.1
 * JD-Core Version:    0.7.0.1
 */