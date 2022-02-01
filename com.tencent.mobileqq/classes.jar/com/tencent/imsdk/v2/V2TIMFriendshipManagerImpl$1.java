package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMFriendshipManagerImpl$1
  implements V2TIMValueCallback<List<FriendInfo>>
{
  V2TIMFriendshipManagerImpl$1(V2TIMFriendshipManagerImpl paramV2TIMFriendshipManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<FriendInfo> paramList)
  {
    if (this.val$callback != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FriendInfo localFriendInfo = (FriendInfo)paramList.next();
        V2TIMFriendInfo localV2TIMFriendInfo = new V2TIMFriendInfo();
        localV2TIMFriendInfo.setFriendInfo(localFriendInfo);
        localArrayList.add(localV2TIMFriendInfo);
      }
      this.val$callback.onSuccess(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */