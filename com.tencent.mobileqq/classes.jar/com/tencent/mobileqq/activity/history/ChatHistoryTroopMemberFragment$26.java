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
    ((ITroopFeeHandler)this.this$0.b.getBusinessHandler(BusinessHandlerFactory.TROOP_FEE_HANDLER)).a(this.this$0.c, this.this$0.j, this.this$0.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.26
 * JD-Core Version:    0.7.0.1
 */