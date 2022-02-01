package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMConversationManager
{
  static V2TIMConversationManager getInstance()
  {
    return V2TIMConversationManagerImpl.getInstance();
  }
  
  public abstract void deleteConversation(String paramString, V2TIMCallback paramV2TIMCallback);
  
  public abstract void getConversation(String paramString, V2TIMValueCallback<V2TIMConversation> paramV2TIMValueCallback);
  
  public abstract void getConversationList(long paramLong, int paramInt, V2TIMValueCallback<V2TIMConversationResult> paramV2TIMValueCallback);
  
  public abstract void getConversationList(List<String> paramList, V2TIMValueCallback<List<V2TIMConversation>> paramV2TIMValueCallback);
  
  public abstract void getTotalUnreadMessageCount(V2TIMValueCallback<Long> paramV2TIMValueCallback);
  
  public abstract void pinConversation(String paramString, boolean paramBoolean, V2TIMCallback paramV2TIMCallback);
  
  public abstract void setConversationDraft(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback);
  
  public abstract void setConversationListener(V2TIMConversationListener paramV2TIMConversationListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMConversationManager
 * JD-Core Version:    0.7.0.1
 */