package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMGroupManagerImpl$12
  implements V2TIMValueCallback<List<GroupMemberInfo>>
{
  V2TIMGroupManagerImpl$12(V2TIMGroupManagerImpl paramV2TIMGroupManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<GroupMemberInfo> paramList)
  {
    if (this.val$callback != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupMemberInfo localGroupMemberInfo = (GroupMemberInfo)paramList.next();
        V2TIMGroupMemberFullInfo localV2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
        localV2TIMGroupMemberFullInfo.setGroupMemberInfo(localGroupMemberInfo);
        localArrayList.add(localV2TIMGroupMemberFullInfo);
      }
      this.val$callback.onSuccess(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupManagerImpl.12
 * JD-Core Version:    0.7.0.1
 */