package com.tencent.mobileqq.activity.contacts.alphabet;

import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class AlphabetFriendFragment$MyProfileCardObserver
  extends ProfileCardObserver
{
  private AlphabetFriendFragment$MyProfileCardObserver(AlphabetFriendFragment paramAlphabetFriendFragment) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.d(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment.MyProfileCardObserver
 * JD-Core Version:    0.7.0.1
 */