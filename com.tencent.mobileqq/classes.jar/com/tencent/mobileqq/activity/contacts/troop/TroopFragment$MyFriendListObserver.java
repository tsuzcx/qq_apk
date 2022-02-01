package com.tencent.mobileqq.activity.contacts.troop;

import com.tencent.mobileqq.app.FriendListObserver;
import java.util.Map;

public class TroopFragment$MyFriendListObserver
  extends FriendListObserver
{
  protected TroopFragment$MyFriendListObserver(TroopFragment paramTroopFragment) {}
  
  public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.h();
    }
  }
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */