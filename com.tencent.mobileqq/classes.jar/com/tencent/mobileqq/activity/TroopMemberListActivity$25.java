package com.tencent.mobileqq.activity;

import aoep;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

class TroopMemberListActivity$25
  implements Runnable
{
  TroopMemberListActivity$25(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void run()
  {
    ((aoep)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.this$0.b, this.this$0.i, this.this$0.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.25
 * JD-Core Version:    0.7.0.1
 */