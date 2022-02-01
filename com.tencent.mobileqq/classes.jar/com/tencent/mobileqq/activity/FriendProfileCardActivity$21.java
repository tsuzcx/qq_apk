package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;

class FriendProfileCardActivity$21
  implements Runnable
{
  FriendProfileCardActivity$21(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    if (this.this$0.a.a.a == 0) {
      ((LocalRedTouchManager)this.this$0.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.21
 * JD-Core Version:    0.7.0.1
 */