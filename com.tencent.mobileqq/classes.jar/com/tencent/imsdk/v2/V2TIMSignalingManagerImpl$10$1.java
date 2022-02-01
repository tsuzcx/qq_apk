package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.message.Message;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class V2TIMSignalingManagerImpl$10$1
  implements V2TIMValueCallback<Message>
{
  V2TIMSignalingManagerImpl$10$1(V2TIMSignalingManagerImpl.10 param10, V2TIMSignalingInfo paramV2TIMSignalingInfo1, V2TIMSignalingInfo paramV2TIMSignalingInfo2) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMSignalingManagerImpl.access$200(this.this$1.this$0).remove(this.val$sinfo);
    synchronized (this.this$1.this$0)
    {
      Iterator localIterator = V2TIMSignalingManagerImpl.access$500(this.this$1.this$0).iterator();
      while (localIterator.hasNext())
      {
        V2TIMSignalingListener localV2TIMSignalingListener = (V2TIMSignalingListener)localIterator.next();
        if (localV2TIMSignalingListener != null) {
          localV2TIMSignalingListener.onInvitationTimeout(this.val$timeoutInfo.getInviteID(), this.val$timeoutInfo.getInviteeList());
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("signaling send timeout msg failed, inviteID:");
      ((StringBuilder)???).append(this.val$timeoutInfo.getInviteID());
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
  
  public void onSuccess(Message arg1)
  {
    V2TIMSignalingManagerImpl.access$400(this.this$1.this$0, ???);
    V2TIMSignalingManagerImpl.access$200(this.this$1.this$0).remove(this.val$sinfo);
    synchronized (this.this$1.this$0)
    {
      Iterator localIterator = V2TIMSignalingManagerImpl.access$500(this.this$1.this$0).iterator();
      while (localIterator.hasNext())
      {
        V2TIMSignalingListener localV2TIMSignalingListener = (V2TIMSignalingListener)localIterator.next();
        if (localV2TIMSignalingListener != null) {
          localV2TIMSignalingListener.onInvitationTimeout(this.val$timeoutInfo.getInviteID(), this.val$timeoutInfo.getInviteeList());
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.10.1
 * JD-Core Version:    0.7.0.1
 */