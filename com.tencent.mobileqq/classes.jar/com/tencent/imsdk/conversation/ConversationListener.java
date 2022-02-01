package com.tencent.imsdk.conversation;

import java.util.List;

public abstract class ConversationListener
{
  public void onConversationChanged(List<Conversation> paramList) {}
  
  public void onNewConversation(List<Conversation> paramList) {}
  
  public void onSyncServerFailed() {}
  
  public void onSyncServerFinish() {}
  
  public void onSyncServerStart() {}
  
  public void onTotalUnreadMessageCountChanged(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.conversation.ConversationListener
 * JD-Core Version:    0.7.0.1
 */