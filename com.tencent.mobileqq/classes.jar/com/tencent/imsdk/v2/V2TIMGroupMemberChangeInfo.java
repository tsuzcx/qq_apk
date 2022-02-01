package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import java.io.Serializable;

public class V2TIMGroupMemberChangeInfo
  implements Serializable
{
  private GroupMemberInfoChangeItem groupMemberInfoChangeItem = new GroupMemberInfoChangeItem();
  
  GroupMemberInfoChangeItem getGroupMemberInfoChangeItem()
  {
    return this.groupMemberInfoChangeItem;
  }
  
  public long getMuteTime()
  {
    return this.groupMemberInfoChangeItem.getShutUpTime();
  }
  
  public String getUserID()
  {
    return this.groupMemberInfoChangeItem.getUserID();
  }
  
  void setGroupMemberInfoChangeItem(GroupMemberInfoChangeItem paramGroupMemberInfoChangeItem)
  {
    this.groupMemberInfoChangeItem = paramGroupMemberInfoChangeItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupMemberChangeInfo
 * JD-Core Version:    0.7.0.1
 */