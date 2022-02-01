package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendOperationResult;

public class V2TIMFriendOperationResult
{
  private FriendOperationResult friendOperationResult;
  
  public int getResultCode()
  {
    return this.friendOperationResult.getResultCode();
  }
  
  public String getResultInfo()
  {
    return this.friendOperationResult.getResultInfo();
  }
  
  public String getUserID()
  {
    return this.friendOperationResult.getUserID();
  }
  
  protected void setFriendOperationResult(FriendOperationResult paramFriendOperationResult)
  {
    this.friendOperationResult = paramFriendOperationResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendOperationResult
 * JD-Core Version:    0.7.0.1
 */