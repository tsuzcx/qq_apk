package com.tencent.imsdk.v2;

import java.util.List;

class V2TIMSignalingManagerImpl$11
  implements Runnable
{
  V2TIMSignalingManagerImpl$11(V2TIMSignalingManagerImpl paramV2TIMSignalingManagerImpl, V2TIMSignalingInfo paramV2TIMSignalingInfo, V2TIMCallback paramV2TIMCallback) {}
  
  public void run()
  {
    V2TIMSignalingManagerImpl.access$200(this.this$0).add(this.val$info);
    V2TIMCallback localV2TIMCallback = this.val$callback;
    if (localV2TIMCallback != null) {
      localV2TIMCallback.onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.11
 * JD-Core Version:    0.7.0.1
 */