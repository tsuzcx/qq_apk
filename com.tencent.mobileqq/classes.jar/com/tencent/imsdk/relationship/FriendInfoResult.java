package com.tencent.imsdk.relationship;

public class FriendInfoResult
{
  private int errorCode;
  private String errorMessage;
  private FriendInfo friendInfo;
  private int relationType;
  private String userID;
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public FriendInfo getFriendInfo()
  {
    return this.friendInfo;
  }
  
  public int getRelationType()
  {
    return this.relationType;
  }
  
  public String getUserID()
  {
    return this.userID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.FriendInfoResult
 * JD-Core Version:    0.7.0.1
 */