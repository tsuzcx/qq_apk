package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendApplicationResult;

class V2TIMFriendshipManagerImpl$12
  implements V2TIMValueCallback<FriendApplicationResult>
{
  V2TIMFriendshipManagerImpl$12(V2TIMFriendshipManagerImpl paramV2TIMFriendshipManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(FriendApplicationResult paramFriendApplicationResult)
  {
    if (this.val$callback != null)
    {
      V2TIMFriendApplicationResult localV2TIMFriendApplicationResult = new V2TIMFriendApplicationResult();
      localV2TIMFriendApplicationResult.setFriendApplicationResult(paramFriendApplicationResult);
      this.val$callback.onSuccess(localV2TIMFriendApplicationResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.12
 * JD-Core Version:    0.7.0.1
 */