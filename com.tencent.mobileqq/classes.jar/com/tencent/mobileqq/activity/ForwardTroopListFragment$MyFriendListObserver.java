package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import java.util.Map;

public class ForwardTroopListFragment$MyFriendListObserver
  extends FriendListObserver
{
  protected ForwardTroopListFragment$MyFriendListObserver(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a();
    }
  }
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */