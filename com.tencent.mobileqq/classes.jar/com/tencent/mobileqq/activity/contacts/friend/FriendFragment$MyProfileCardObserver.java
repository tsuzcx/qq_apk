package com.tencent.mobileqq.activity.contacts.friend;

import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class FriendFragment$MyProfileCardObserver
  extends ProfileCardObserver
{
  private FriendFragment$MyProfileCardObserver(FriendFragment paramFriendFragment) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment.MyProfileCardObserver
 * JD-Core Version:    0.7.0.1
 */