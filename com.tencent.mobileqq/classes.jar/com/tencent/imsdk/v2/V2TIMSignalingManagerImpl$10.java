package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import java.util.List;

class V2TIMSignalingManagerImpl$10
  implements Runnable
{
  V2TIMSignalingManagerImpl$10(V2TIMSignalingManagerImpl paramV2TIMSignalingManagerImpl, V2TIMSignalingInfo paramV2TIMSignalingInfo, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < V2TIMSignalingManagerImpl.access$200(this.this$0).size())
    {
      V2TIMSignalingInfo localV2TIMSignalingInfo = (V2TIMSignalingInfo)V2TIMSignalingManagerImpl.access$200(this.this$0).get(i);
      if ((localV2TIMSignalingInfo.getInviteID().equals(this.val$info.getInviteID())) && (localV2TIMSignalingInfo.getInviteeList().contains(this.val$loginUser)))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("signaling receive invite but local timeout, inviteID:");
        ((StringBuilder)localObject).append(this.val$info.getInviteID());
        IMLog.i("V2TIMSigMgrImpl", ((StringBuilder)localObject).toString());
        localObject = new V2TIMSignalingInfo();
        ((V2TIMSignalingInfo)localObject).setBusinessID(1);
        ((V2TIMSignalingInfo)localObject).setInviteID(this.val$info.getInviteID());
        ((V2TIMSignalingInfo)localObject).setGroupID(this.val$info.getGroupID());
        ((V2TIMSignalingInfo)localObject).setInviter(this.val$info.getInviter());
        ((V2TIMSignalingInfo)localObject).addInvitee(this.val$loginUser);
        ((V2TIMSignalingInfo)localObject).setActionType(5);
        ((V2TIMSignalingInfo)localObject).setOnlineUserOnly(this.val$info.isOnlineUserOnly());
        V2TIMSignalingManagerImpl.access$600(this.this$0, (V2TIMSignalingInfo)localObject, new V2TIMSignalingManagerImpl.10.1(this, localV2TIMSignalingInfo, (V2TIMSignalingInfo)localObject), false);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.10
 * JD-Core Version:    0.7.0.1
 */