package com.tencent.mobileqq.activity;

import abeh;
import ajya;
import auuy;
import bcql;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendProfileCardActivity$32$7
  implements Runnable
{
  public FriendProfileCardActivity$32$7(abeh paramabeh) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.a.app.getManager(11);
    if (!localPhoneContactManagerImp.a(this.a.a.a.a.k, this.a.a.a.a.a))
    {
      this.a.a.n = true;
      if (localPhoneContactManagerImp.b(this.a.a.a.a.k, this.a.a.a.a.a))
      {
        bcql.a(this.a.a.getApplicationContext(), 2, ajya.a(2131704904), 0).a();
        return;
      }
      bcql.a(this.a.a.getApplicationContext(), 1, ajya.a(2131704934), 0).a();
      return;
    }
    bcql.a(this.a.a.getApplicationContext(), ajya.a(2131704894), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.32.7
 * JD-Core Version:    0.7.0.1
 */