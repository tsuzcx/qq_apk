package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

public class TroopView$MyAvatarObserver
  extends AvatarObserver
{
  protected TroopView$MyAvatarObserver(TroopView paramTroopView) {}
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.MyAvatarObserver
 * JD-Core Version:    0.7.0.1
 */