package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendCheckResult;

public class V2TIMFriendCheckResult
{
  public static final int V2TIM_FRIEND_RELATION_TYPE_BOTH_WAY = 3;
  public static final int V2TIM_FRIEND_RELATION_TYPE_IN_MY_FRIEND_LIST = 1;
  public static final int V2TIM_FRIEND_RELATION_TYPE_IN_OTHER_FRIEND_LIST = 2;
  public static final int V2TIM_FRIEND_RELATION_TYPE_NONE = 0;
  private FriendCheckResult friendCheckResult = new FriendCheckResult();
  
  public int getResultCode()
  {
    return this.friendCheckResult.getResultCode();
  }
  
  public String getResultInfo()
  {
    return this.friendCheckResult.getResultInfo();
  }
  
  public int getResultType()
  {
    return this.friendCheckResult.getRelationType();
  }
  
  public String getUserID()
  {
    return this.friendCheckResult.getUserID();
  }
  
  protected void setFriendCheckResult(FriendCheckResult paramFriendCheckResult)
  {
    this.friendCheckResult = paramFriendCheckResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendCheckResult
 * JD-Core Version:    0.7.0.1
 */