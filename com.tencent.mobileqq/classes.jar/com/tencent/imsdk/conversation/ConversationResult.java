package com.tencent.imsdk.conversation;

import java.util.ArrayList;
import java.util.List;

public class ConversationResult
{
  private List<Conversation> conversationList = new ArrayList();
  private boolean isFinish;
  private long nextSeq;
  
  protected void addConversation(Conversation paramConversation)
  {
    this.conversationList.add(paramConversation);
  }
  
  public List<Conversation> getConversationList()
  {
    return this.conversationList;
  }
  
  public long getNextSeq()
  {
    return this.nextSeq;
  }
  
  public boolean isFinish()
  {
    return this.isFinish;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.conversation.ConversationResult
 * JD-Core Version:    0.7.0.1
 */