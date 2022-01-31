package com.tencent.mobileqq.activity;

import acvg;
import alpo;
import awmk;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class FriendProfileCardActivity$32$7
  implements Runnable
{
  public FriendProfileCardActivity$32$7(acvg paramacvg) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.a.app.getManager(11);
    if (!localPhoneContactManagerImp.a(this.a.a.a.a.k, this.a.a.a.a.a))
    {
      this.a.a.n = true;
      if (localPhoneContactManagerImp.b(this.a.a.a.a.k, this.a.a.a.a.a))
      {
        QQToast.a(this.a.a.getApplicationContext(), 2, alpo.a(2131705276), 0).a();
        return;
      }
      QQToast.a(this.a.a.getApplicationContext(), 1, alpo.a(2131705306), 0).a();
      return;
    }
    QQToast.a(this.a.a.getApplicationContext(), alpo.a(2131705266), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.32.7
 * JD-Core Version:    0.7.0.1
 */