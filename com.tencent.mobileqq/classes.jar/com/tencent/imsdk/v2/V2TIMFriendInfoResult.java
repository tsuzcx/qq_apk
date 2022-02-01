package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendInfoResult;

public class V2TIMFriendInfoResult
{
  private FriendInfoResult friendInfoResult = new FriendInfoResult();
  
  public V2TIMFriendInfo getFriendInfo()
  {
    V2TIMFriendInfo localV2TIMFriendInfo = new V2TIMFriendInfo();
    localV2TIMFriendInfo.setFriendInfo(this.friendInfoResult.getFriendInfo());
    return localV2TIMFriendInfo;
  }
  
  public int getRelation()
  {
    return this.friendInfoResult.getRelationType();
  }
  
  public int getResultCode()
  {
    return this.friendInfoResult.getErrorCode();
  }
  
  public String getResultInfo()
  {
    return this.friendInfoResult.getErrorMessage();
  }
  
  void setFriendInfoResult(FriendInfoResult paramFriendInfoResult)
  {
    this.friendInfoResult = paramFriendInfoResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendInfoResult
 * JD-Core Version:    0.7.0.1
 */