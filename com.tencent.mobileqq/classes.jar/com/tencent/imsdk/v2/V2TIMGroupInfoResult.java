package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupInfoGetResult;

public class V2TIMGroupInfoResult
{
  private GroupInfoGetResult groupInfoGetResult = new GroupInfoGetResult();
  
  public V2TIMGroupInfo getGroupInfo()
  {
    V2TIMGroupInfo localV2TIMGroupInfo = new V2TIMGroupInfo();
    localV2TIMGroupInfo.setGroupInfo(this.groupInfoGetResult.getGroupInfo());
    return localV2TIMGroupInfo;
  }
  
  GroupInfoGetResult getGroupInfoGetResult()
  {
    return this.groupInfoGetResult;
  }
  
  public int getResultCode()
  {
    return this.groupInfoGetResult.getErrorCode();
  }
  
  public String getResultMessage()
  {
    return this.groupInfoGetResult.getErrorMessage();
  }
  
  void setGroupInfoGetResult(GroupInfoGetResult paramGroupInfoGetResult)
  {
    this.groupInfoGetResult = paramGroupInfoGetResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupInfoResult
 * JD-Core Version:    0.7.0.1
 */