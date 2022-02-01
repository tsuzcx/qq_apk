package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;

class TroopListAdapter2$2
  extends TroopMngObserver
{
  TroopListAdapter2$2(TroopListAdapter2 paramTroopListAdapter2) {}
  
  protected void b(String paramString)
  {
    if ((this.a.a instanceof BaseActivity)) {
      ((BaseActivity)this.a.a).runOnUiThread(new TroopListAdapter2.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.2
 * JD-Core Version:    0.7.0.1
 */