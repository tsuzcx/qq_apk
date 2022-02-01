package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberInfoResult;

class V2TIMGroupManagerImpl$10
  implements V2TIMValueCallback<GroupMemberInfoResult>
{
  V2TIMGroupManagerImpl$10(V2TIMGroupManagerImpl paramV2TIMGroupManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(GroupMemberInfoResult paramGroupMemberInfoResult)
  {
    if (this.val$callback != null)
    {
      V2TIMGroupMemberInfoResult localV2TIMGroupMemberInfoResult = new V2TIMGroupMemberInfoResult();
      localV2TIMGroupMemberInfoResult.setGroupMemberInfoResult(paramGroupMemberInfoResult);
      this.val$callback.onSuccess(localV2TIMGroupMemberInfoResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupManagerImpl.10
 * JD-Core Version:    0.7.0.1
 */