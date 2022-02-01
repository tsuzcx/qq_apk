package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;

public class ForwardTroopListFragment$MyTroopMngObserver
  extends TroopMngObserver
{
  protected ForwardTroopListFragment$MyTroopMngObserver(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6)
    {
      if (paramInt2 == 0) {
        this.a.a();
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0) {
        this.a.a();
      }
    }
    else if ((paramInt1 == 9) && (paramInt2 == 0)) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.MyTroopMngObserver
 * JD-Core Version:    0.7.0.1
 */