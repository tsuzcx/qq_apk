package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class PhoneMatchView$1$2
  implements Runnable
{
  PhoneMatchView$1$2(PhoneMatchView.1 param1) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.this$0.a.getManager(11);
    localPhoneContactManagerImp.j();
    localPhoneContactManagerImp.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView.1.2
 * JD-Core Version:    0.7.0.1
 */