package com.tencent.imsdk.group;

public class GroupInfoGetResult
{
  private int errorCode;
  private String errorMessage;
  private String groupID;
  private GroupInfo groupInfo;
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public String getGroupID()
  {
    return this.groupID;
  }
  
  public GroupInfo getGroupInfo()
  {
    return this.groupInfo;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorMessage(String paramString)
  {
    this.errorMessage = paramString;
  }
  
  public void setGroupID(String paramString)
  {
    this.groupID = paramString;
  }
  
  public void setGroupInfo(GroupInfo paramGroupInfo)
  {
    this.groupInfo = paramGroupInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupInfoGetResult
 * JD-Core Version:    0.7.0.1
 */