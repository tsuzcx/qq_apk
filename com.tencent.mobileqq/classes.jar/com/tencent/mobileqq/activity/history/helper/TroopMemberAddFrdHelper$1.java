package com.tencent.mobileqq.activity.history.helper;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;

class TroopMemberAddFrdHelper$1
  extends FriendListObserver
{
  TroopMemberAddFrdHelper$1(TroopMemberAddFrdHelper paramTroopMemberAddFrdHelper) {}
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a(1, paramString);
    }
  }
  
  public void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean) {
      this.a.a(1, paramString);
    }
  }
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper.1
 * JD-Core Version:    0.7.0.1
 */