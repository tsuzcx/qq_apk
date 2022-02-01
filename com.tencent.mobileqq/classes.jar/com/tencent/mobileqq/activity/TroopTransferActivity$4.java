package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;

class TroopTransferActivity$4
  extends FriendListObserver
{
  TroopTransferActivity$4(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = this.a.a.a(paramString);
      if (paramString != null) {
        break label28;
      }
    }
    label28:
    Friends localFriends;
    do
    {
      return;
      localFriends = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString.a);
    } while (localFriends == null);
    this.a.a(paramString, localFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.4
 * JD-Core Version:    0.7.0.1
 */