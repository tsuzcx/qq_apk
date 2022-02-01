package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendOperationResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMFriendshipManagerImpl$34
  implements V2TIMValueCallback<List<FriendOperationResult>>
{
  V2TIMFriendshipManagerImpl$34(V2TIMFriendshipManagerImpl paramV2TIMFriendshipManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<FriendOperationResult> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FriendOperationResult localFriendOperationResult = (FriendOperationResult)paramList.next();
      V2TIMFriendOperationResult localV2TIMFriendOperationResult = new V2TIMFriendOperationResult();
      localV2TIMFriendOperationResult.setFriendOperationResult(localFriendOperationResult);
      localArrayList.add(localV2TIMFriendOperationResult);
    }
    this.val$callback.onSuccess(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.34
 * JD-Core Version:    0.7.0.1
 */