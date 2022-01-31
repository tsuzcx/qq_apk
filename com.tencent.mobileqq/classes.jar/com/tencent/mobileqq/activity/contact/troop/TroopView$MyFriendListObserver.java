package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.app.FriendListObserver;
import java.util.Map;

public class TroopView$MyFriendListObserver
  extends FriendListObserver
{
  protected TroopView$MyFriendListObserver(TroopView paramTroopView) {}
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.j();
    }
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map paramMap)
  {
    this.a.j();
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */