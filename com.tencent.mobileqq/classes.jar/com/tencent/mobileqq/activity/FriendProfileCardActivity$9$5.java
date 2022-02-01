package com.tencent.mobileqq.activity;

import aegy;
import anni;
import azfe;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class FriendProfileCardActivity$9$5
  implements Runnable
{
  public FriendProfileCardActivity$9$5(aegy paramaegy) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.a.app.getManager(11);
    if (!localPhoneContactManagerImp.a(this.a.a.a.a.k, this.a.a.a.a.a))
    {
      this.a.a.g = true;
      if (localPhoneContactManagerImp.b(this.a.a.a.a.k, this.a.a.a.a.a))
      {
        QQToast.a(this.a.a.getApplicationContext(), 2, anni.a(2131703684), 0).a();
        return;
      }
      QQToast.a(this.a.a.getApplicationContext(), 1, anni.a(2131703714), 0).a();
      return;
    }
    QQToast.a(this.a.a.getApplicationContext(), anni.a(2131703674), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.9.5
 * JD-Core Version:    0.7.0.1
 */