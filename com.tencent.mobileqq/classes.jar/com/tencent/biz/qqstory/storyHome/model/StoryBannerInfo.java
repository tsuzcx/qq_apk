package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.model.item.IFeedOwner;

public class StoryBannerInfo
  implements IFeedOwner
{
  public String a;
  
  public int getRelationType()
  {
    return 0;
  }
  
  public String getUnionId()
  {
    return this.a;
  }
  
  public boolean isFriend()
  {
    return false;
  }
  
  public boolean isMe()
  {
    return false;
  }
  
  public boolean isSubscribe()
  {
    return false;
  }
  
  public boolean isSubscribeButNoFriend()
  {
    return false;
  }
  
  public boolean isVip()
  {
    return false;
  }
  
  public boolean isVipButNoFriend()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.StoryBannerInfo
 * JD-Core Version:    0.7.0.1
 */