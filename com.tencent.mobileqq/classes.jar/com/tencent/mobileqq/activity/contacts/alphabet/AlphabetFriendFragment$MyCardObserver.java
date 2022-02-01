package com.tencent.mobileqq.activity.contacts.alphabet;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

class AlphabetFriendFragment$MyCardObserver
  extends CardObserver
{
  private AlphabetFriendFragment$MyCardObserver(AlphabetFriendFragment paramAlphabetFriendFragment) {}
  
  public void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " contacts onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      AlphabetFriendFragment.a(this.a, 1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment.MyCardObserver
 * JD-Core Version:    0.7.0.1
 */