package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMConversationManagerImpl$1
  extends ConversationListener
{
  V2TIMConversationManagerImpl$1(V2TIMConversationManagerImpl paramV2TIMConversationManagerImpl) {}
  
  public void onConversationChanged(List<Conversation> paramList)
  {
    if (V2TIMConversationManagerImpl.access$200(this.this$0) == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Conversation localConversation = (Conversation)paramList.next();
      V2TIMConversation localV2TIMConversation = new V2TIMConversation();
      localV2TIMConversation.setConversation(localConversation);
      localArrayList.add(localV2TIMConversation);
    }
    V2TIMConversationManagerImpl.access$200(this.this$0).onConversationChanged(localArrayList);
  }
  
  public void onNewConversation(List<Conversation> paramList)
  {
    if (V2TIMConversationManagerImpl.access$200(this.this$0) == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Conversation localConversation = (Conversation)paramList.next();
      V2TIMConversation localV2TIMConversation = new V2TIMConversation();
      localV2TIMConversation.setConversation(localConversation);
      localArrayList.add(localV2TIMConversation);
    }
    V2TIMConversationManagerImpl.access$200(this.this$0).onNewConversation(localArrayList);
  }
  
  public void onSyncServerFailed()
  {
    if (V2TIMConversationManagerImpl.access$200(this.this$0) == null) {
      return;
    }
    if (V2TIMConversationManagerImpl.access$200(this.this$0) != null) {
      V2TIMConversationManagerImpl.access$200(this.this$0).onSyncServerFailed();
    }
  }
  
  public void onSyncServerFinish()
  {
    if (V2TIMConversationManagerImpl.access$200(this.this$0) == null) {
      return;
    }
    if (V2TIMConversationManagerImpl.access$200(this.this$0) != null) {
      V2TIMConversationManagerImpl.access$200(this.this$0).onSyncServerFinish();
    }
  }
  
  public void onSyncServerStart()
  {
    if (V2TIMConversationManagerImpl.access$200(this.this$0) == null) {
      return;
    }
    if (V2TIMConversationManagerImpl.access$200(this.this$0) != null) {
      V2TIMConversationManagerImpl.access$200(this.this$0).onSyncServerStart();
    }
  }
  
  public void onTotalUnreadMessageCountChanged(long paramLong)
  {
    if (V2TIMConversationManagerImpl.access$200(this.this$0) == null) {
      return;
    }
    V2TIMConversationManagerImpl.access$200(this.this$0).onTotalUnreadMessageCountChanged(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMConversationManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */