package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendApplication;
import com.tencent.imsdk.relationship.FriendApplicationResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class V2TIMFriendApplicationResult
{
  private FriendApplicationResult friendApplicationResult;
  private List<V2TIMFriendApplication> v2TIMFriendApplicationList = new ArrayList();
  
  public List<V2TIMFriendApplication> getFriendApplicationList()
  {
    return this.v2TIMFriendApplicationList;
  }
  
  public int getUnreadCount()
  {
    return this.friendApplicationResult.getUnreadCount();
  }
  
  protected void setFriendApplicationResult(FriendApplicationResult paramFriendApplicationResult)
  {
    this.v2TIMFriendApplicationList.clear();
    Iterator localIterator = paramFriendApplicationResult.getFriendApplicationList().iterator();
    while (localIterator.hasNext())
    {
      FriendApplication localFriendApplication = (FriendApplication)localIterator.next();
      V2TIMFriendApplication localV2TIMFriendApplication = new V2TIMFriendApplication();
      localV2TIMFriendApplication.setFriendApplication(localFriendApplication);
      this.v2TIMFriendApplicationList.add(localV2TIMFriendApplication);
    }
    this.friendApplicationResult = paramFriendApplicationResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendApplicationResult
 * JD-Core Version:    0.7.0.1
 */