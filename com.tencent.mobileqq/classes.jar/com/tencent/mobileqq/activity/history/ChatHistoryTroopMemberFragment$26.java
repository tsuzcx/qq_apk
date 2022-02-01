package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopfee.api.ITroopFeeHandler;

class ChatHistoryTroopMemberFragment$26
  implements Runnable
{
  ChatHistoryTroopMemberFragment$26(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void run()
  {
    ((ITroopFeeHandler)this.this$0.bc.getBusinessHandler(BusinessHandlerFactory.TROOP_FEE_HANDLER)).a(this.this$0.w, this.this$0.aA, this.this$0.aB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.26
 * JD-Core Version:    0.7.0.1
 */