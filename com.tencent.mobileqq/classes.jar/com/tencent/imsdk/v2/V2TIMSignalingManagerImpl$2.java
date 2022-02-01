package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.message.Message;
import java.util.List;

class V2TIMSignalingManagerImpl$2
  implements V2TIMValueCallback<Message>
{
  V2TIMSignalingManagerImpl$2(V2TIMSignalingManagerImpl paramV2TIMSignalingManagerImpl, V2TIMSignalingInfo paramV2TIMSignalingInfo, V2TIMCallback paramV2TIMCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("signaling sendSignalMessage failed code:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", desc:");
    ((StringBuilder)localObject).append(paramString);
    IMLog.e("V2TIMSigMgrImpl", ((StringBuilder)localObject).toString());
    localObject = this.val$callback;
    if (localObject != null) {
      ((V2TIMCallback)localObject).onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(Message paramMessage)
  {
    V2TIMSignalingManagerImpl.access$200(this.this$0).add(this.val$info);
    V2TIMSignalingManagerImpl.access$300(this.this$0, this.val$info);
    if (!this.val$info.isOnlineUserOnly()) {
      V2TIMSignalingManagerImpl.access$400(this.this$0, paramMessage);
    }
    paramMessage = this.val$callback;
    if (paramMessage != null) {
      paramMessage.onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */