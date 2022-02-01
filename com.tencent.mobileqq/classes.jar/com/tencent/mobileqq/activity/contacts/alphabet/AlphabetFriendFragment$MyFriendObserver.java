package com.tencent.mobileqq.activity.contacts.alphabet;

import android.os.Bundle;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.qphone.base.util.QLog;

class AlphabetFriendFragment$MyFriendObserver
  extends FriendObserver
{
  private AlphabetFriendFragment$MyFriendObserver(AlphabetFriendFragment paramAlphabetFriendFragment) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onUpdateAddFriend isSucess= ");
      paramString.append(paramBoolean1);
      paramString.append(",addSuccess=");
      paramString.append(paramBoolean2);
      paramString.append(" addDirect=");
      paramString.append(paramBoolean3);
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, paramString.toString());
    }
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment.MyFriendObserver
 * JD-Core Version:    0.7.0.1
 */