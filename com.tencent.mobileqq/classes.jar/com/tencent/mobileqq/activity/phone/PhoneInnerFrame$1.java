package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class PhoneInnerFrame$1
  extends ContactBindObserver
{
  PhoneInnerFrame$1(PhoneInnerFrame paramPhoneInnerFrame) {}
  
  public void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.a)
    {
      this.a.b().a().unRegistObserver(this);
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneInnerFrame.1
 * JD-Core Version:    0.7.0.1
 */