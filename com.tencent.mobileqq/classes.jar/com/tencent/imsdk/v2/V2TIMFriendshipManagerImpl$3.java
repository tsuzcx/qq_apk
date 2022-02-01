package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendInfoResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMFriendshipManagerImpl$3
  implements V2TIMValueCallback<List<FriendInfoResult>>
{
  V2TIMFriendshipManagerImpl$3(V2TIMFriendshipManagerImpl paramV2TIMFriendshipManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<FriendInfoResult> paramList)
  {
    if (this.val$callback != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FriendInfoResult localFriendInfoResult = (FriendInfoResult)paramList.next();
        V2TIMFriendInfoResult localV2TIMFriendInfoResult = new V2TIMFriendInfoResult();
        localV2TIMFriendInfoResult.setFriendInfoResult(localFriendInfoResult);
        localArrayList.add(localV2TIMFriendInfoResult);
      }
      this.val$callback.onSuccess(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */