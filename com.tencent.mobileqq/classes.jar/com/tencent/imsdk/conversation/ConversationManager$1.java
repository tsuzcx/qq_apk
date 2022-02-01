package com.tencent.imsdk.conversation;

import com.tencent.imsdk.common.IMContext;
import java.util.List;

class ConversationManager$1
  extends ConversationListener
{
  ConversationManager$1(ConversationManager paramConversationManager) {}
  
  public void onConversationChanged(List<Conversation> paramList)
  {
    IMContext.getInstance().runOnMainThread(new ConversationManager.1.5(this, paramList));
  }
  
  public void onNewConversation(List<Conversation> paramList)
  {
    IMContext.getInstance().runOnMainThread(new ConversationManager.1.4(this, paramList));
  }
  
  public void onSyncServerFailed()
  {
    IMContext.getInstance().runOnMainThread(new ConversationManager.1.3(this));
  }
  
  public void onSyncServerFinish()
  {
    IMContext.getInstance().runOnMainThread(new ConversationManager.1.2(this));
  }
  
  public void onSyncServerStart()
  {
    IMContext.getInstance().runOnMainThread(new ConversationManager.1.1(this));
  }
  
  public void onTotalUnreadMessageCountChanged(long paramLong)
  {
    IMContext.getInstance().runOnMainThread(new ConversationManager.1.6(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.conversation.ConversationManager.1
 * JD-Core Version:    0.7.0.1
 */