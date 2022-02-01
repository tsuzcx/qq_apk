package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import java.util.List;

class V2TIMSignalingManagerImpl$5
  implements Runnable
{
  V2TIMSignalingManagerImpl$5(V2TIMSignalingManagerImpl paramV2TIMSignalingManagerImpl, V2TIMSignalingInfo paramV2TIMSignalingInfo) {}
  
  public void run()
  {
    int i = 0;
    while (i < V2TIMSignalingManagerImpl.access$200(this.this$0).size())
    {
      V2TIMSignalingInfo localV2TIMSignalingInfo = (V2TIMSignalingInfo)V2TIMSignalingManagerImpl.access$200(this.this$0).get(i);
      if ((localV2TIMSignalingInfo.getInviteID().equals(this.val$info.getInviteID())) && (localV2TIMSignalingInfo.getInviteeList().size() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("signaling invite local timeout inviteID:");
        localStringBuilder.append(this.val$info.getInviteID());
        localStringBuilder.append(", inviteeList:");
        localStringBuilder.append(localV2TIMSignalingInfo.getInviteeList());
        IMLog.i("V2TIMSigMgrImpl", localStringBuilder.toString());
        i = localV2TIMSignalingInfo.getActionType();
        localV2TIMSignalingInfo.setActionType(5);
        localV2TIMSignalingInfo.setOfflinePushInfo(null);
        V2TIMSignalingManagerImpl.access$600(this.this$0, localV2TIMSignalingInfo, new V2TIMSignalingManagerImpl.5.1(this, localV2TIMSignalingInfo, i), true);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */