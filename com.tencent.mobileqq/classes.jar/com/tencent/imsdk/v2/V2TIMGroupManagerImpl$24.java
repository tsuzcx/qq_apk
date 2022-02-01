package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupApplicationResult;

class V2TIMGroupManagerImpl$24
  implements V2TIMValueCallback<GroupApplicationResult>
{
  V2TIMGroupManagerImpl$24(V2TIMGroupManagerImpl paramV2TIMGroupManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(GroupApplicationResult paramGroupApplicationResult)
  {
    if (this.val$callback != null)
    {
      V2TIMGroupApplicationResult localV2TIMGroupApplicationResult = new V2TIMGroupApplicationResult();
      localV2TIMGroupApplicationResult.setGroupApplicationResult(paramGroupApplicationResult);
      this.val$callback.onSuccess(localV2TIMGroupApplicationResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupManagerImpl.24
 * JD-Core Version:    0.7.0.1
 */