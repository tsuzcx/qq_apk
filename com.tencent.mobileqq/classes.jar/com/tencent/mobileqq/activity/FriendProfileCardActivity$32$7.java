package com.tencent.mobileqq.activity;

import aczv;
import alud;
import awqt;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class FriendProfileCardActivity$32$7
  implements Runnable
{
  public FriendProfileCardActivity$32$7(aczv paramaczv) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.a.app.getManager(11);
    if (!localPhoneContactManagerImp.a(this.a.a.a.a.k, this.a.a.a.a.a))
    {
      this.a.a.n = true;
      if (localPhoneContactManagerImp.b(this.a.a.a.a.k, this.a.a.a.a.a))
      {
        QQToast.a(this.a.a.getApplicationContext(), 2, alud.a(2131705288), 0).a();
        return;
      }
      QQToast.a(this.a.a.getApplicationContext(), 1, alud.a(2131705318), 0).a();
      return;
    }
    QQToast.a(this.a.a.getApplicationContext(), alud.a(2131705278), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.32.7
 * JD-Core Version:    0.7.0.1
 */