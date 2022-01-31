package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class PhoneMatchActivity$2$1
  implements Runnable
{
  PhoneMatchActivity$2$1(PhoneMatchActivity.2 param2) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.this$0.app.getManager(11);
    localPhoneContactManagerImp.j();
    localPhoneContactManagerImp.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity.2.1
 * JD-Core Version:    0.7.0.1
 */