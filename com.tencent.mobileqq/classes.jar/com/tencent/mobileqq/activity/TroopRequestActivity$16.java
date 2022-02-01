package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;

class TroopRequestActivity$16
  extends FriendListObserver
{
  TroopRequestActivity$16(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    ThreadManager.post(new TroopRequestActivity.16.1(this, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.16
 * JD-Core Version:    0.7.0.1
 */