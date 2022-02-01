package com.tencent.imsdk.group;

import java.io.Serializable;

public class GroupMemberInfoChangeItem
  implements Serializable
{
  private long shutUpTime;
  private String userID;
  
  public long getShutUpTime()
  {
    return this.shutUpTime;
  }
  
  public String getUserID()
  {
    return this.userID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupMemberInfoChangeItem
 * JD-Core Version:    0.7.0.1
 */