package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMFriendshipManagerImpl$28
  implements V2TIMValueCallback<List<FriendGroup>>
{
  V2TIMFriendshipManagerImpl$28(V2TIMFriendshipManagerImpl paramV2TIMFriendshipManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<FriendGroup> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FriendGroup localFriendGroup = (FriendGroup)paramList.next();
      V2TIMFriendGroup localV2TIMFriendGroup = new V2TIMFriendGroup();
      localV2TIMFriendGroup.setFriendGroup(localFriendGroup);
      localArrayList.add(localV2TIMFriendGroup);
    }
    this.val$callback.onSuccess(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.28
 * JD-Core Version:    0.7.0.1
 */