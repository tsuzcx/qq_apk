package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.ConversationResult;

class V2TIMConversationManagerImpl$2
  implements V2TIMValueCallback<ConversationResult>
{
  V2TIMConversationManagerImpl$2(V2TIMConversationManagerImpl paramV2TIMConversationManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(ConversationResult paramConversationResult)
  {
    if (this.val$callback != null)
    {
      V2TIMConversationResult localV2TIMConversationResult = new V2TIMConversationResult();
      localV2TIMConversationResult.setConversationResult(paramConversationResult);
      this.val$callback.onSuccess(localV2TIMConversationResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMConversationManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */