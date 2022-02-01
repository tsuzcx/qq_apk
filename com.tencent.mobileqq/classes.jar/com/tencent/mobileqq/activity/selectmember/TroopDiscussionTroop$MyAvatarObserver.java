package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

public class TroopDiscussionTroop$MyAvatarObserver
  extends AvatarObserver
{
  protected TroopDiscussionTroop$MyAvatarObserver(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop.MyAvatarObserver
 * JD-Core Version:    0.7.0.1
 */