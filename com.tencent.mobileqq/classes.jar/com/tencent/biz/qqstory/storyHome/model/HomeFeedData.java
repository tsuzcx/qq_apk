package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeFeedData
  extends FeedListPageLoaderBase.FeedData
{
  public List<StoryHomeFeed> b = new ArrayList();
  public boolean e;
  
  public HomeFeedData(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)localIterator.next();
      localStringBuilder.append("feedId:");
      localStringBuilder.append(localStoryHomeFeed.a().feedId);
      localStringBuilder.append("unionId:");
      localStringBuilder.append(localStoryHomeFeed.a().getOwner().getUnionId());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeedData{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("mFeedItems=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedData
 * JD-Core Version:    0.7.0.1
 */