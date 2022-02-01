package com.tencent.mobileqq.activity.contacts.alphabet;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class AlphabetFriendFragment$MyAvatarObserver
  extends AvatarObserver
{
  private AlphabetFriendFragment$MyAvatarObserver(AlphabetFriendFragment paramAlphabetFriendFragment) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      AlphabetFriendFragment.a(this.a, 5000L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment.MyAvatarObserver
 * JD-Core Version:    0.7.0.1
 */