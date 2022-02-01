package com.tencent.mobileqq.activity.contacts.friend;

import android.os.Bundle;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.qphone.base.util.QLog;

class FriendFragment$MyFriendObserver
  extends FriendObserver
{
  private FriendFragment$MyFriendObserver(FriendFragment paramFriendFragment) {}
  
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
      QLog.d("contacts.fragment.FriendFragment", 2, paramString.toString());
    }
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment.MyFriendObserver
 * JD-Core Version:    0.7.0.1
 */