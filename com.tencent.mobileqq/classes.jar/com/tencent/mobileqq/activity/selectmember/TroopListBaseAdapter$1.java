package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;

class TroopListBaseAdapter$1
  implements Runnable
{
  TroopListBaseAdapter$1(TroopListBaseAdapter paramTroopListBaseAdapter) {}
  
  public void run()
  {
    ((TroopManager)this.this$0.a.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    this.this$0.a.runOnUiThread(new TroopListBaseAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */