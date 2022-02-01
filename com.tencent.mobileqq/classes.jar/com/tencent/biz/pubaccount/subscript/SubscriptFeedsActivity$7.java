package com.tencent.biz.pubaccount.subscript;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;

class SubscriptFeedsActivity$7
  implements Runnable
{
  SubscriptFeedsActivity$7(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    ((IPublicAccountDataManager)this.this$0.app.getRuntimeService(IPublicAccountDataManager.class, "all")).initPublicAccountDataManager();
    TroopBarAssistantManager.a().d(this.this$0.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.7
 * JD-Core Version:    0.7.0.1
 */