package com.tencent.imsdk.relationship;

public class ReceiveMessageOptInfo
{
  private String userID;
  private int userReceiveMessageOpt;
  
  public int getC2CReceiveMessageOpt()
  {
    return this.userReceiveMessageOpt;
  }
  
  public String getUserID()
  {
    return this.userID;
  }
  
  public void setC2CReceiveMessageOpt(int paramInt)
  {
    this.userReceiveMessageOpt = paramInt;
  }
  
  public void setUserID(String paramString)
  {
    this.userID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.ReceiveMessageOptInfo
 * JD-Core Version:    0.7.0.1
 */