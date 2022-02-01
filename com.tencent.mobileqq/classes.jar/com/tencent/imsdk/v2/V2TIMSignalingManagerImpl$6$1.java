package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.message.Message;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class V2TIMSignalingManagerImpl$6$1
  implements V2TIMValueCallback<Message>
{
  V2TIMSignalingManagerImpl$6$1(V2TIMSignalingManagerImpl.6 param6, V2TIMSignalingInfo paramV2TIMSignalingInfo1, V2TIMSignalingInfo paramV2TIMSignalingInfo2) {}
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("signaling cancel invite failed, inviteID: ");
    localStringBuilder.append(this.this$1.val$inviteID);
    localStringBuilder.append(", code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", desc:");
    localStringBuilder.append(paramString);
    IMLog.e("V2TIMSigMgrImpl", localStringBuilder.toString());
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(Message paramMessage)
  {
    synchronized (this.this$1.this$0)
    {
      Iterator localIterator = V2TIMSignalingManagerImpl.access$500(this.this$1.this$0).iterator();
      while (localIterator.hasNext())
      {
        V2TIMSignalingListener localV2TIMSignalingListener = (V2TIMSignalingListener)localIterator.next();
        if (localV2TIMSignalingListener != null) {
          localV2TIMSignalingListener.onInvitationCancelled(this.val$cancelSignalingInfo.getInviteID(), this.val$cancelSignalingInfo.getInviter(), this.val$cancelSignalingInfo.getData());
        }
      }
      V2TIMSignalingManagerImpl.access$200(this.this$1.this$0).remove(this.val$signalingInfo);
      if (!this.val$cancelSignalingInfo.isOnlineUserOnly()) {
        V2TIMSignalingManagerImpl.access$400(this.this$1.this$0, paramMessage);
      }
      if (this.this$1.val$callback != null) {
        this.this$1.val$callback.onSuccess();
      }
      return;
    }
    for (;;)
    {
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.6.1
 * JD-Core Version:    0.7.0.1
 */