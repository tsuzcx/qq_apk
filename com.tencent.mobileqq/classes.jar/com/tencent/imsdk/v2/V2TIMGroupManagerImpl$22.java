package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMGroupManagerImpl$22
  implements V2TIMValueCallback<List<GroupInfo>>
{
  V2TIMGroupManagerImpl$22(V2TIMGroupManagerImpl paramV2TIMGroupManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<GroupInfo> paramList)
  {
    if (this.val$callback != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupInfo localGroupInfo = (GroupInfo)paramList.next();
        V2TIMGroupInfo localV2TIMGroupInfo = new V2TIMGroupInfo();
        localV2TIMGroupInfo.setGroupInfo(localGroupInfo);
        localArrayList.add(localV2TIMGroupInfo);
      }
      this.val$callback.onSuccess(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupManagerImpl.22
 * JD-Core Version:    0.7.0.1
 */