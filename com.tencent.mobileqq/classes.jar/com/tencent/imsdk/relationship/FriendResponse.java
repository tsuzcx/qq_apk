package com.tencent.imsdk.relationship;

public class FriendResponse
{
  public static final int RESPONSE_AGREE = 1;
  public static final int RESPONSE_AGREE_AND_ADD = 2;
  public static final int RESPONSE_REJECT = 3;
  private String remark;
  private int responseType;
  private String userID;
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public void setResponseType(int paramInt)
  {
    this.responseType = paramInt;
  }
  
  public void setUserID(String paramString)
  {
    this.userID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.FriendResponse
 * JD-Core Version:    0.7.0.1
 */