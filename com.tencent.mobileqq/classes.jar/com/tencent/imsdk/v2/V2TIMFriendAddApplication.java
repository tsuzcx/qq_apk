package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendAddApplication;

public class V2TIMFriendAddApplication
{
  private FriendAddApplication friendAddApplication = new FriendAddApplication();
  
  public V2TIMFriendAddApplication(String paramString)
  {
    this.friendAddApplication.setUserID(paramString);
    this.friendAddApplication.setAddType(2);
  }
  
  protected FriendAddApplication getFriendAddApplication()
  {
    return this.friendAddApplication;
  }
  
  public void setAddSource(String paramString)
  {
    this.friendAddApplication.setAddSource(paramString);
  }
  
  public void setAddType(int paramInt)
  {
    int i = paramInt;
    if (paramInt != 1)
    {
      i = paramInt;
      if (paramInt != 2) {
        i = 2;
      }
    }
    this.friendAddApplication.setAddType(i);
  }
  
  public void setAddWording(String paramString)
  {
    this.friendAddApplication.setAddWording(paramString);
  }
  
  public void setFriendGroup(String paramString)
  {
    this.friendAddApplication.setGroupName(paramString);
  }
  
  public void setFriendRemark(String paramString)
  {
    this.friendAddApplication.setRemark(paramString);
  }
  
  public void setUserID(String paramString)
  {
    this.friendAddApplication.setUserID(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendAddApplication
 * JD-Core Version:    0.7.0.1
 */