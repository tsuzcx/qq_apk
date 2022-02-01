package com.tencent.imsdk.group;

import java.util.List;

public class GroupMemberInfoResult
{
  private List<GroupMemberInfo> groupMemberInfoList;
  private long nextSeq;
  
  public List<GroupMemberInfo> getGroupMemberInfoList()
  {
    return this.groupMemberInfoList;
  }
  
  public long getNextSeq()
  {
    return this.nextSeq;
  }
  
  public void setGroupMemberInfoList(List<GroupMemberInfo> paramList)
  {
    this.groupMemberInfoList = paramList;
  }
  
  public void setNextSeq(long paramLong)
  {
    this.nextSeq = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupMemberInfoResult
 * JD-Core Version:    0.7.0.1
 */