package com.tencent.biz.qqstory.storyHome.discover.view;

import com.tencent.biz.qqstory.model.item.HotTopicInfoItem;
import com.tencent.biz.qqstory.playmode.child.DiscoverPlayMode.PlayVideoEvent;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader.GetDiscoverCardsEvent;
import java.util.List;

public abstract interface IDiscoverView
{
  public abstract void a(HotTopicInfoItem paramHotTopicInfoItem);
  
  public abstract void a(DiscoverPlayMode.PlayVideoEvent paramPlayVideoEvent);
  
  public abstract void a(CardItem paramCardItem);
  
  public abstract void a(List paramList, DiscoverPagerLoader.GetDiscoverCardsEvent paramGetDiscoverCardsEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.view.IDiscoverView
 * JD-Core Version:    0.7.0.1
 */