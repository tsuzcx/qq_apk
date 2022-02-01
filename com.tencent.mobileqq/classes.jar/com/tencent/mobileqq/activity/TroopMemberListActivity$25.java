package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.troopfee.api.ITroopFeeHandler;

class TroopMemberListActivity$25
  implements Runnable
{
  TroopMemberListActivity$25(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void run()
  {
    ((ITroopFeeHandler)this.this$0.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopFeeHandlerName())).a(this.this$0.mTroopUin, this.this$0.mTroopFeeProjectId, this.this$0.mTroopFeeEntranceType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.25
 * JD-Core Version:    0.7.0.1
 */