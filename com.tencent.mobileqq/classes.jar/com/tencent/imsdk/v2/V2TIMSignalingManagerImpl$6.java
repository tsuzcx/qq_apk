package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.common.IMLog;
import java.util.List;

class V2TIMSignalingManagerImpl$6
  implements Runnable
{
  V2TIMSignalingManagerImpl$6(V2TIMSignalingManagerImpl paramV2TIMSignalingManagerImpl, V2TIMCallback paramV2TIMCallback, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject2 = V2TIMManager.getInstance().getLoginUser();
    Object localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = this.val$callback;
      if (localObject1 != null) {
        ((V2TIMCallback)localObject1).onError(6014, "not login");
      }
      IMLog.e("V2TIMSigMgrImpl", "not login");
      return;
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= V2TIMSignalingManagerImpl.access$200(this.this$0).size()) {
        break;
      }
      localObject1 = (V2TIMSignalingInfo)V2TIMSignalingManagerImpl.access$200(this.this$0).get(i);
      if (((V2TIMSignalingInfo)localObject1).getInviteID().equals(this.val$inviteID))
      {
        if (!((V2TIMSignalingInfo)localObject1).getInviter().equals(localObject2))
        {
          IMLog.e("V2TIMSigMgrImpl", "signaling cancel invite failed，the invitation is not initiated by yourself");
          localObject1 = this.val$callback;
          if (localObject1 != null) {
            ((V2TIMCallback)localObject1).onError(8011, "the invitation is not initiated by yourself");
          }
        }
        else
        {
          localObject2 = new V2TIMSignalingInfo();
          ((V2TIMSignalingInfo)localObject2).setBusinessID(1);
          ((V2TIMSignalingInfo)localObject2).setInviteID(((V2TIMSignalingInfo)localObject1).getInviteID());
          ((V2TIMSignalingInfo)localObject2).setGroupID(((V2TIMSignalingInfo)localObject1).getGroupID());
          ((V2TIMSignalingInfo)localObject2).setInviter(((V2TIMSignalingInfo)localObject1).getInviter());
          ((V2TIMSignalingInfo)localObject2).setInviteeList(((V2TIMSignalingInfo)localObject1).getInviteeList());
          ((V2TIMSignalingInfo)localObject2).setData(this.val$data);
          ((V2TIMSignalingInfo)localObject2).setOnlineUserOnly(((V2TIMSignalingInfo)localObject1).isOnlineUserOnly());
          ((V2TIMSignalingInfo)localObject2).setActionType(2);
          V2TIMSignalingManagerImpl.access$600(this.this$0, (V2TIMSignalingInfo)localObject2, new V2TIMSignalingManagerImpl.6.1(this, (V2TIMSignalingInfo)localObject2, (V2TIMSignalingInfo)localObject1), true);
        }
        j = 1;
        break;
      }
      i += 1;
    }
    if ((j == 0) && (this.val$callback != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("signaling cancel failed, inviteID is invalid or invitation has been processed inviteID:");
      ((StringBuilder)localObject1).append(this.val$inviteID);
      IMLog.e("V2TIMSigMgrImpl", ((StringBuilder)localObject1).toString());
      this.val$callback.onError(8010, "inviteID is invalid or invitation has been processed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */