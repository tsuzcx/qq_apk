package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class V2TIMConversationResult
{
  private ConversationResult conversationResult;
  
  public List<V2TIMConversation> getConversationList()
  {
    if (this.conversationResult == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.conversationResult.getConversationList().iterator();
    while (localIterator.hasNext())
    {
      Conversation localConversation = (Conversation)localIterator.next();
      V2TIMConversation localV2TIMConversation = new V2TIMConversation();
      localV2TIMConversation.setConversation(localConversation);
      localArrayList.add(localV2TIMConversation);
    }
    return localArrayList;
  }
  
  public long getNextSeq()
  {
    ConversationResult localConversationResult = this.conversationResult;
    if (localConversationResult != null) {
      return localConversationResult.getNextSeq();
    }
    return 0L;
  }
  
  public boolean isFinished()
  {
    ConversationResult localConversationResult = this.conversationResult;
    if (localConversationResult != null) {
      return localConversationResult.isFinish();
    }
    return false;
  }
  
  void setConversationResult(ConversationResult paramConversationResult)
  {
    this.conversationResult = paramConversationResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMConversationResult
 * JD-Core Version:    0.7.0.1
 */