package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import mqq.os.MqqHandler;

class TroopWithCommonFriendsFragment$7
  extends TroopBusinessObserver
{
  TroopWithCommonFriendsFragment$7(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 8) {
      this.a.a.sendEmptyMessage(1018);
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 8) {
      this.a.a.sendEmptyMessage(1016);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.7
 * JD-Core Version:    0.7.0.1
 */