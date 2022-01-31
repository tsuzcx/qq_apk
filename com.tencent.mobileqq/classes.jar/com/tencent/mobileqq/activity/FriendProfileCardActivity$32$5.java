package com.tencent.mobileqq.activity;

import aaur;
import ajjy;
import atwx;
import bbmy;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendProfileCardActivity$32$5
  implements Runnable
{
  public FriendProfileCardActivity$32$5(aaur paramaaur) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.a.app.getManager(11);
    if (!localPhoneContactManagerImp.a(this.a.a.a.a.k, this.a.a.a.a.a))
    {
      this.a.a.n = true;
      if (localPhoneContactManagerImp.b(this.a.a.a.a.k, this.a.a.a.a.a))
      {
        bbmy.a(this.a.a.getApplicationContext(), 2, ajjy.a(2131639108), 0).a();
        return;
      }
      bbmy.a(this.a.a.getApplicationContext(), 1, ajjy.a(2131639138), 0).a();
      return;
    }
    bbmy.a(this.a.a.getApplicationContext(), ajjy.a(2131639098), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.32.5
 * JD-Core Version:    0.7.0.1
 */