package com.tencent.imsdk.group;

public class GroupMemberInfoModifyParam
{
  private GroupMemberInfo memberInfo;
  private long modifyFlag;
  
  public GroupMemberInfo getMemberInfo()
  {
    return this.memberInfo;
  }
  
  public long getModifyFlag()
  {
    return this.modifyFlag;
  }
  
  public void setMemberInfo(GroupMemberInfo paramGroupMemberInfo)
  {
    this.memberInfo = paramGroupMemberInfo;
  }
  
  public void setModifyFlag(long paramLong)
  {
    this.modifyFlag = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupMemberInfoModifyParam
 * JD-Core Version:    0.7.0.1
 */