package com.tencent.mobileqq.activity.contact.addfriendverifi;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class NewFriendVerificationManager$1
  extends CardObserver
{
  NewFriendVerificationManager$1(NewFriendVerificationManager paramNewFriendVerificationManager) {}
  
  public void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    NewFriendVerificationManager.a(this.a, NewFriendVerificationManager.a(this.a, paramInt));
    if ((NewFriendVerificationManager.a(this.a)) && (NewFriendVerificationManager.a(this.a) != null)) {
      this.a.b(NewFriendVerificationManager.a(this.a).getCurrentUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationManager.1
 * JD-Core Version:    0.7.0.1
 */