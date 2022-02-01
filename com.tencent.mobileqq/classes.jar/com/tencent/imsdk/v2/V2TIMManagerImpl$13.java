package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMManagerImpl$13
  implements V2TIMValueCallback<List<UserInfo>>
{
  V2TIMManagerImpl$13(V2TIMManagerImpl paramV2TIMManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<UserInfo> paramList)
  {
    if (this.val$callback != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        UserInfo localUserInfo = (UserInfo)paramList.next();
        V2TIMUserFullInfo localV2TIMUserFullInfo = new V2TIMUserFullInfo();
        localV2TIMUserFullInfo.setUserInfo(localUserInfo);
        localArrayList.add(localV2TIMUserFullInfo);
      }
      this.val$callback.onSuccess(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManagerImpl.13
 * JD-Core Version:    0.7.0.1
 */