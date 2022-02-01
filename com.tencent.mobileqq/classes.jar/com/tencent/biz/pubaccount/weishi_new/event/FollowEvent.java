package com.tencent.biz.pubaccount.weishi_new.event;

public class FollowEvent
  extends WSSimpleBaseEvent
{
  private int isFollow;
  private String personId;
  
  public int getIsFollow()
  {
    return this.isFollow;
  }
  
  public String getPersonId()
  {
    return this.personId;
  }
  
  public boolean hasFollowed()
  {
    int i = this.isFollow;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void setIsFollow(int paramInt)
  {
    this.isFollow = paramInt;
  }
  
  public void setPersonId(String paramString)
  {
    this.personId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.FollowEvent
 * JD-Core Version:    0.7.0.1
 */