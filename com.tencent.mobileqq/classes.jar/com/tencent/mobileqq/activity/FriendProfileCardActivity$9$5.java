package com.tencent.mobileqq.activity;

import adja;
import amtj;
import aymg;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class FriendProfileCardActivity$9$5
  implements Runnable
{
  public FriendProfileCardActivity$9$5(adja paramadja) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.a.app.getManager(11);
    if (!localPhoneContactManagerImp.a(this.a.a.a.a.k, this.a.a.a.a.a))
    {
      this.a.a.g = true;
      if (localPhoneContactManagerImp.b(this.a.a.a.a.k, this.a.a.a.a.a))
      {
        QQToast.a(this.a.a.getApplicationContext(), 2, amtj.a(2131704021), 0).a();
        return;
      }
      QQToast.a(this.a.a.getApplicationContext(), 1, amtj.a(2131704050), 0).a();
      return;
    }
    QQToast.a(this.a.a.getApplicationContext(), amtj.a(2131704011), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.9.5
 * JD-Core Version:    0.7.0.1
 */