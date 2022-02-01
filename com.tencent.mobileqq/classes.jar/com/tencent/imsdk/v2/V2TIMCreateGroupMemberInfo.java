package com.tencent.imsdk.v2;

import java.util.Map;

public class V2TIMCreateGroupMemberInfo
{
  private Map<String, byte[]> customInfo;
  private int role = 0;
  private String userID;
  
  int getRole()
  {
    return this.role;
  }
  
  String getUserID()
  {
    return this.userID;
  }
  
  public void setRole(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 200) {
      i = 0;
    }
    this.role = i;
  }
  
  public void setUserID(String paramString)
  {
    this.userID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMCreateGroupMemberInfo
 * JD-Core Version:    0.7.0.1
 */