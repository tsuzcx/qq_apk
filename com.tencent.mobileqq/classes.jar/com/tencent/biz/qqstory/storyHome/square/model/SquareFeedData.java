package com.tencent.biz.qqstory.storyHome.square.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedData;
import java.util.ArrayList;
import java.util.List;

public class SquareFeedData
  extends FeedListPageLoaderBase.FeedData
{
  public List<SquareFeed> b = new ArrayList();
  public List<SquareBannerItem> c = new ArrayList();
  
  public SquareFeedData(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
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
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.square.model.SquareFeedData
 * JD-Core Version:    0.7.0.1
 */