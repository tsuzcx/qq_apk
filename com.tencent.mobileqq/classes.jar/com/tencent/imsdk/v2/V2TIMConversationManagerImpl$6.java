package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.Conversation;

class V2TIMConversationManagerImpl$6
  implements V2TIMValueCallback<Conversation>
{
  V2TIMConversationManagerImpl$6(V2TIMConversationManagerImpl paramV2TIMConversationManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(Conversation paramConversation)
  {
    if (this.val$callback != null)
    {
      V2TIMConversation localV2TIMConversation = new V2TIMConversation();
      localV2TIMConversation.setConversation(paramConversation);
      this.val$callback.onSuccess(localV2TIMConversation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMConversationManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */