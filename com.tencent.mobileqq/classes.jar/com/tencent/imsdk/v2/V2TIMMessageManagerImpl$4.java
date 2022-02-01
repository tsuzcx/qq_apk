package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.Message;

class V2TIMMessageManagerImpl$4
  extends IMCallback
{
  V2TIMMessageManagerImpl$4(V2TIMMessageManagerImpl paramV2TIMMessageManagerImpl, V2TIMValueCallback paramV2TIMValueCallback, V2TIMMessage paramV2TIMMessage)
  {
    super(paramV2TIMValueCallback);
  }
  
  public void fail(int paramInt, String paramString, Object paramObject)
  {
    this.val$v2TIMMessage.getMessage().update((Message)paramObject);
    super.fail(paramInt, paramString, paramObject);
  }
  
  public void success(Object paramObject)
  {
    this.val$v2TIMMessage.getMessage().update((Message)paramObject);
    super.success(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */