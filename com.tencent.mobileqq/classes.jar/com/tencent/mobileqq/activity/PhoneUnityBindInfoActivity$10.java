package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class PhoneUnityBindInfoActivity$10
  extends ContactBindObserver
{
  PhoneUnityBindInfoActivity$10(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  protected void onCancelBind(boolean paramBoolean)
  {
    super.onCancelBind(paramBoolean);
    PhoneUnityBindInfoActivity.access$1900(this.a);
    this.a.app.unRegistObserver(this);
    PhoneUnityBindInfoActivity.access$900(this.a);
    if (paramBoolean) {
      this.a.resetContactSwitch(false);
    } else {
      this.a.resetContactSwitch(true);
    }
    PhoneUnityBindInfoActivity.access$1200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.10
 * JD-Core Version:    0.7.0.1
 */