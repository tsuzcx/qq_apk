package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.message.Message;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class V2TIMSignalingManagerImpl$5$1
  implements V2TIMValueCallback<Message>
{
  V2TIMSignalingManagerImpl$5$1(V2TIMSignalingManagerImpl.5 param5, V2TIMSignalingInfo paramV2TIMSignalingInfo, int paramInt) {}
  
  public void onError(int paramInt, String paramString)
  {
    this.val$sinfo.setActionType(this.val$originalActionType);
    synchronized (this.this$1.this$0)
    {
      Iterator localIterator = V2TIMSignalingManagerImpl.access$500(this.this$1.this$0).iterator();
      while (localIterator.hasNext())
      {
        V2TIMSignalingListener localV2TIMSignalingListener = (V2TIMSignalingListener)localIterator.next();
        if (localV2TIMSignalingListener != null) {
          localV2TIMSignalingListener.onInvitationTimeout(this.val$sinfo.getInviteID(), this.val$sinfo.getInviteeList());
        }
      }
      V2TIMSignalingManagerImpl.access$200(this.this$1.this$0).remove(this.val$sinfo);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("signaling send timeout msg failed, inviteID: ");
      ((StringBuilder)???).append(this.this$1.val$info.getInviteID());
      ((StringBuilder)???).append(", code:");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(", desc:");
      ((StringBuilder)???).append(paramString);
      IMLog.e("V2TIMSigMgrImpl", ((StringBuilder)???).toString());
      return;
    }
    for (;;)
    {
      throw paramString;
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
          localV2TIMSignalingListener.onInvitationTimeout(this.val$sinfo.getInviteID(), this.val$sinfo.getInviteeList());
        }
      }
      V2TIMSignalingManagerImpl.access$200(this.this$1.this$0).remove(this.val$sinfo);
      if (!this.val$sinfo.isOnlineUserOnly()) {
        V2TIMSignalingManagerImpl.access$400(this.this$1.this$0, paramMessage);
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
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.5.1
 * JD-Core Version:    0.7.0.1
 */