package com.tencent.biz.qqstory.storyHome.model;

import alud;
import com.tencent.biz.qqstory.model.BaseUIItem;
import uxe;

public class HotRecommendOwner
  extends BaseUIItem
  implements uxe
{
  public String mName = alud.a(2131706004);
  public long mRecommendId;
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getRelationType()
  {
    return 0;
  }
  
  public String getUnionId()
  {
    return String.valueOf(this.mRecommendId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HotRecommendOwner
 * JD-Core Version:    0.7.0.1
 */