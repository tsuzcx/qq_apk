package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendGroup;
import java.util.List;

public class V2TIMFriendGroup
{
  private FriendGroup friendGroup = new FriendGroup();
  
  public long getFriendCount()
  {
    return this.friendGroup.getUserCount();
  }
  
  public List<String> getFriendIDList()
  {
    return this.friendGroup.getUserIDList();
  }
  
  public String getName()
  {
    return this.friendGroup.getGroupName();
  }
  
  protected void setFriendGroup(FriendGroup paramFriendGroup)
  {
    this.friendGroup = paramFriendGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendGroup
 * JD-Core Version:    0.7.0.1
 */