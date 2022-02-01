package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.app.FriendListObserver;
import java.util.Map;

public class TroopDiscussionTroop$MyFriendListObserver
  extends FriendListObserver
{
  protected TroopDiscussionTroop$MyFriendListObserver(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.c();
    }
  }
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */