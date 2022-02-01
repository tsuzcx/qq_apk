package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberOperationResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMGroupManagerImpl$18
  implements V2TIMValueCallback<List<GroupMemberOperationResult>>
{
  V2TIMGroupManagerImpl$18(V2TIMGroupManagerImpl paramV2TIMGroupManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<GroupMemberOperationResult> paramList)
  {
    if (this.val$callback != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupMemberOperationResult localGroupMemberOperationResult = (GroupMemberOperationResult)paramList.next();
        V2TIMGroupMemberOperationResult localV2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
        localV2TIMGroupMemberOperationResult.setGroupMemberOperationResult(localGroupMemberOperationResult);
        localArrayList.add(localV2TIMGroupMemberOperationResult);
      }
      this.val$callback.onSuccess(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupManagerImpl.18
 * JD-Core Version:    0.7.0.1
 */