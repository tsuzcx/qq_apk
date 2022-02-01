package com.tencent.mobileqq.activity.contacts.friend;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class FriendFragment$MyAvatarObserver
  extends AvatarObserver
{
  private FriendFragment$MyAvatarObserver(FriendFragment paramFriendFragment) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      FriendFragment.a(this.a, 5000L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment.MyAvatarObserver
 * JD-Core Version:    0.7.0.1
 */