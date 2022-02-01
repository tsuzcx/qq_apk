package com.tencent.mobileqq.activity.contacts.friend;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

class FriendFragment$MyCardObserver
  extends CardObserver
{
  private FriendFragment$MyCardObserver(FriendFragment paramFriendFragment) {}
  
  public void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " contacts onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      FriendFragment.a(this.a, 1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment.MyCardObserver
 * JD-Core Version:    0.7.0.1
 */