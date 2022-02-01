package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class PhoneInnerFrame$1
  extends ContactBindObserver
{
  PhoneInnerFrame$1(PhoneInnerFrame paramPhoneInnerFrame) {}
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.a)
    {
      this.a.getPhoneContext().a().unRegistObserver(this);
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneInnerFrame.1
 * JD-Core Version:    0.7.0.1
 */