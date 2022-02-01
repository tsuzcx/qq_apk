package com.tencent.mobileqq.activity;

import aeag;
import anvx;
import azrb;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;

public class FriendProfileCardActivity$9$5
  implements Runnable
{
  public FriendProfileCardActivity$9$5(aeag paramaeag) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (!localPhoneContactManagerImp.a(this.a.a.a.a.k, this.a.a.a.a.a))
    {
      this.a.a.g = true;
      if (localPhoneContactManagerImp.b(this.a.a.a.a.k, this.a.a.a.a.a))
      {
        QQToast.a(this.a.a.getApplicationContext(), 2, anvx.a(2131704372), 0).a();
        return;
      }
      QQToast.a(this.a.a.getApplicationContext(), 1, anvx.a(2131704401), 0).a();
      return;
    }
    QQToast.a(this.a.a.getApplicationContext(), anvx.a(2131704362), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.9.5
 * JD-Core Version:    0.7.0.1
 */