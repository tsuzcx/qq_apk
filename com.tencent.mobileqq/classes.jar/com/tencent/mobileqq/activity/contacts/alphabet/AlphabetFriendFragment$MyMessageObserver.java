package com.tencent.mobileqq.activity.contacts.alphabet;

import com.tencent.mobileqq.app.MessageObserver;

class AlphabetFriendFragment$MyMessageObserver
  extends MessageObserver
{
  private AlphabetFriendFragment$MyMessageObserver(AlphabetFriendFragment paramAlphabetFriendFragment) {}
  
  protected void onUpdateFriendsList()
  {
    if (AlphabetFriendFragment.d(this.a)) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment.MyMessageObserver
 * JD-Core Version:    0.7.0.1
 */