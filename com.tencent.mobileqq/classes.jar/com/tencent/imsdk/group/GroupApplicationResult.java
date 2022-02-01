package com.tencent.imsdk.group;

import java.util.List;

public class GroupApplicationResult
{
  private List<GroupApplication> groupApplicationList;
  private long unreadCount;
  
  public List<GroupApplication> getGroupApplicationList()
  {
    return this.groupApplicationList;
  }
  
  public long getUnreadCount()
  {
    return this.unreadCount;
  }
  
  public void setUnreadCount(long paramLong)
  {
    this.unreadCount = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupApplicationResult
 * JD-Core Version:    0.7.0.1
 */