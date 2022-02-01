package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMConversationListener
{
  public void onConversationChanged(List<V2TIMConversation> paramList) {}
  
  public void onNewConversation(List<V2TIMConversation> paramList) {}
  
  public void onSyncServerFailed() {}
  
  public void onSyncServerFinish() {}
  
  public void onSyncServerStart() {}
  
  public void onTotalUnreadMessageCountChanged(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMConversationListener
 * JD-Core Version:    0.7.0.1
 */