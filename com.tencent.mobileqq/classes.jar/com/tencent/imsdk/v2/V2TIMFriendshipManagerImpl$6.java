package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendOperationResult;

class V2TIMFriendshipManagerImpl$6
  implements V2TIMValueCallback<FriendOperationResult>
{
  V2TIMFriendshipManagerImpl$6(V2TIMFriendshipManagerImpl paramV2TIMFriendshipManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(FriendOperationResult paramFriendOperationResult)
  {
    if (this.val$callback != null)
    {
      V2TIMFriendOperationResult localV2TIMFriendOperationResult = new V2TIMFriendOperationResult();
      localV2TIMFriendOperationResult.setFriendOperationResult(paramFriendOperationResult);
      this.val$callback.onSuccess(localV2TIMFriendOperationResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */