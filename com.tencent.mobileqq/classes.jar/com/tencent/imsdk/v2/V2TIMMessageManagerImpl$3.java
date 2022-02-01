package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.Message;

class V2TIMMessageManagerImpl$3
  implements V2TIMValueCallback<Message>
{
  V2TIMMessageManagerImpl$3(V2TIMMessageManagerImpl paramV2TIMMessageManagerImpl, V2TIMSendCallback paramV2TIMSendCallback, V2TIMMessage paramV2TIMMessage) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMSendCallback localV2TIMSendCallback = this.val$sendCallback;
    if (localV2TIMSendCallback != null) {
      localV2TIMSendCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(Message paramMessage)
  {
    if (this.val$sendCallback != null)
    {
      this.val$v2TIMMessage.setMessage(paramMessage);
      this.val$sendCallback.onSuccess(this.val$v2TIMMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */