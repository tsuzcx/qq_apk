package com.tencent.mobileqq.activity.history.helper;

import com.tencent.mobileqq.app.FriendListObserver;

class TroopMemberAddFrdHelper$2
  extends FriendListObserver
{
  TroopMemberAddFrdHelper$2(TroopMemberAddFrdHelper paramTroopMemberAddFrdHelper) {}
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean) {
      this.a.a(1, paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper.2
 * JD-Core Version:    0.7.0.1
 */