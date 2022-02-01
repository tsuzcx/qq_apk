package com.tencent.mobileqq.activity.contacts.friend;

import com.tencent.mobileqq.app.MessageObserver;

class FriendFragment$MyMessageObserver
  extends MessageObserver
{
  private FriendFragment$MyMessageObserver(FriendFragment paramFriendFragment) {}
  
  protected void onUpdateFriendsList()
  {
    if (FriendFragment.b(this.a)) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment.MyMessageObserver
 * JD-Core Version:    0.7.0.1
 */