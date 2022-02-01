package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.Message;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class V2TIMSignalingManagerImpl$9
  implements V2TIMValueCallback<Message>
{
  V2TIMSignalingManagerImpl$9(V2TIMSignalingManagerImpl paramV2TIMSignalingManagerImpl, boolean paramBoolean, V2TIMSignalingInfo paramV2TIMSignalingInfo1, V2TIMSignalingInfo paramV2TIMSignalingInfo2, String paramString, V2TIMCallback paramV2TIMCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMCallback localV2TIMCallback = this.val$callback;
    if (localV2TIMCallback != null) {
      localV2TIMCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(Message paramMessage)
  {
    synchronized (this.this$0)
    {
      Iterator localIterator = V2TIMSignalingManagerImpl.access$500(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        V2TIMSignalingListener localV2TIMSignalingListener = (V2TIMSignalingListener)localIterator.next();
        if (localV2TIMSignalingListener != null) {
          if (this.val$isAccept) {
            localV2TIMSignalingListener.onInviteeAccepted(this.val$rspSignalingInfo.getInviteID(), (String)this.val$rspSignalingInfo.getInviteeList().get(0), this.val$rspSignalingInfo.getData());
          } else {
            localV2TIMSignalingListener.onInviteeRejected(this.val$rspSignalingInfo.getInviteID(), (String)this.val$rspSignalingInfo.getInviteeList().get(0), this.val$rspSignalingInfo.getData());
          }
        }
      }
      this.val$sinfo.getInviteeList().remove(this.val$loginUser);
      if (this.val$sinfo.getInviteeList().size() == 0) {
        V2TIMSignalingManagerImpl.access$200(this.this$0).remove(this.val$sinfo);
      }
      if (!this.val$rspSignalingInfo.isOnlineUserOnly()) {
        V2TIMSignalingManagerImpl.access$400(this.this$0, paramMessage);
      }
      paramMessage = this.val$callback;
      if (paramMessage != null) {
        paramMessage.onSuccess();
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
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.9
 * JD-Core Version:    0.7.0.1
 */