package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMMessageManagerImpl$6
  implements V2TIMValueCallback<List<ReceiveMessageOptInfo>>
{
  V2TIMMessageManagerImpl$6(V2TIMMessageManagerImpl paramV2TIMMessageManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<ReceiveMessageOptInfo> paramList)
  {
    if (this.val$callback != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReceiveMessageOptInfo localReceiveMessageOptInfo = (ReceiveMessageOptInfo)paramList.next();
        V2TIMReceiveMessageOptInfo localV2TIMReceiveMessageOptInfo = new V2TIMReceiveMessageOptInfo();
        localV2TIMReceiveMessageOptInfo.setUserID(localReceiveMessageOptInfo.getUserID());
        localV2TIMReceiveMessageOptInfo.setC2CReceiveMessageOpt(localReceiveMessageOptInfo.getC2CReceiveMessageOpt());
        localArrayList.add(localV2TIMReceiveMessageOptInfo);
      }
      this.val$callback.onSuccess(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */