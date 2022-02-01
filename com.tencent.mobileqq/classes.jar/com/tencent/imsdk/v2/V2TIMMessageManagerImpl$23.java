package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.Message;

class V2TIMMessageManagerImpl$23
  implements V2TIMValueCallback<Message>
{
  V2TIMMessageManagerImpl$23(V2TIMMessageManagerImpl paramV2TIMMessageManagerImpl, V2TIMValueCallback paramV2TIMValueCallback, V2TIMMessage paramV2TIMMessage) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(Message paramMessage)
  {
    if (this.val$callback != null)
    {
      this.val$v2TIMMessage.setMessage(paramMessage);
      this.val$callback.onSuccess(this.val$v2TIMMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageManagerImpl.23
 * JD-Core Version:    0.7.0.1
 */