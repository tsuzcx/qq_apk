package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;

public class TroopView$MyTroopMngObserver
  extends TroopMngObserver
{
  protected TroopView$MyTroopMngObserver(TroopView paramTroopView) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6)
    {
      if (paramInt2 == 0) {
        this.a.l();
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0) {
        this.a.l();
      }
    }
    else if ((paramInt1 == 9) && (paramInt2 == 0)) {
      this.a.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.MyTroopMngObserver
 * JD-Core Version:    0.7.0.1
 */