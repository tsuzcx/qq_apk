package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;

public class TroopView$MyTroopModifyObserver
  extends TroopModifyObserver
{
  protected TroopView$MyTroopModifyObserver(TroopView paramTroopView) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.MyTroopModifyObserver
 * JD-Core Version:    0.7.0.1
 */