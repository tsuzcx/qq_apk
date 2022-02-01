package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class PhoneUnityBindInfoActivity$9
  extends ContactBindObserver
{
  PhoneUnityBindInfoActivity$9(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onCancelBind(boolean paramBoolean)
  {
    super.onCancelBind(paramBoolean);
    PhoneUnityBindInfoActivity.c(this.a);
    this.a.app.unRegistObserver(this);
    PhoneUnityBindInfoActivity.b(this.a);
    if (paramBoolean) {
      this.a.a(false);
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.d(this.a);
      return;
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.9
 * JD-Core Version:    0.7.0.1
 */