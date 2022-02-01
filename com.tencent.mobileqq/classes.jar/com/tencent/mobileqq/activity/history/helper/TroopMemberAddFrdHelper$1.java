package com.tencent.mobileqq.activity.history.helper;

import android.os.Bundle;
import com.tencent.mobileqq.friend.observer.FriendObserver;

class TroopMemberAddFrdHelper$1
  extends FriendObserver
{
  TroopMemberAddFrdHelper$1(TroopMemberAddFrdHelper paramTroopMemberAddFrdHelper) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a(1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper.1
 * JD-Core Version:    0.7.0.1
 */