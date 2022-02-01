package com.tencent.mobileqq.activity;

import anrb;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

class TroopInfoActivity$6
  implements Runnable
{
  TroopInfoActivity$6(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    if (this.this$0.app != null)
    {
      ((TroopManager)this.this$0.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.this$0.a);
      anrb localanrb = (anrb)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if (localanrb != null) {
        localanrb.notifyUI(49, true, this.this$0.a.troopuin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.6
 * JD-Core Version:    0.7.0.1
 */