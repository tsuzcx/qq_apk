package com.tencent.mobileqq.activity.contacts.friend;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;

class FriendFragment$1
  implements Runnable
{
  FriendFragment$1(FriendFragment paramFriendFragment) {}
  
  public void run()
  {
    ((QzoneContactsFeedManager)FriendFragment.a(this.this$0).getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment.1
 * JD-Core Version:    0.7.0.1
 */