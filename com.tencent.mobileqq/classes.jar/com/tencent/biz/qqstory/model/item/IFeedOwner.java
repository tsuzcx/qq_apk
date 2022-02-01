package com.tencent.biz.qqstory.model.item;

public abstract interface IFeedOwner
{
  public abstract String getName();
  
  public abstract int getRelationType();
  
  public abstract String getUnionId();
  
  public abstract boolean isFriend();
  
  public abstract boolean isMe();
  
  public abstract boolean isSubscribe();
  
  public abstract boolean isSubscribeButNoFriend();
  
  public abstract boolean isVip();
  
  public abstract boolean isVipButNoFriend();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.IFeedOwner
 * JD-Core Version:    0.7.0.1
 */