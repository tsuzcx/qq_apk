package com.tencent.imsdk.relationship;

import java.util.ArrayList;
import java.util.List;

public class FriendApplicationResult
{
  private List<FriendApplication> friendApplicationList = new ArrayList();
  private int unreadCount;
  
  public List<FriendApplication> getFriendApplicationList()
  {
    return this.friendApplicationList;
  }
  
  public int getUnreadCount()
  {
    return this.unreadCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.FriendApplicationResult
 * JD-Core Version:    0.7.0.1
 */