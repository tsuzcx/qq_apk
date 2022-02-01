package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class FriendProfileImageActivity$2
  implements Runnable
{
  FriendProfileImageActivity$2(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.this$0.c.h);
    if (localExtensionInfo != null) {
      ThreadManager.getUIHandler().post(new FriendProfileImageActivity.2.1(this, localExtensionInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.2
 * JD-Core Version:    0.7.0.1
 */