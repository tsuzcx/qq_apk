package com.tencent.mobileqq.activity;

import abel;
import ajyc;
import auuw;
import bcpw;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendProfileCardActivity$32$7
  implements Runnable
{
  public FriendProfileCardActivity$32$7(abel paramabel) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.a.app.getManager(11);
    if (!localPhoneContactManagerImp.a(this.a.a.a.a.k, this.a.a.a.a.a))
    {
      this.a.a.n = true;
      if (localPhoneContactManagerImp.b(this.a.a.a.a.k, this.a.a.a.a.a))
      {
        bcpw.a(this.a.a.getApplicationContext(), 2, ajyc.a(2131704893), 0).a();
        return;
      }
      bcpw.a(this.a.a.getApplicationContext(), 1, ajyc.a(2131704923), 0).a();
      return;
    }
    bcpw.a(this.a.a.getApplicationContext(), ajyc.a(2131704883), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.32.7
 * JD-Core Version:    0.7.0.1
 */