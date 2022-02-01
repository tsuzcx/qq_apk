package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.GetFeedIdListResult;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.OnFeedItemPageLoadListener;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedAllInfoPullSegment;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedData;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class MemoriesFeedListPageLoader
  extends FeedListPageLoaderBase<HomeFeedData>
{
  public MemoriesFeedListPageLoader(@Nullable FeedListPageLoaderBase.OnFeedItemPageLoadListener paramOnFeedItemPageLoadListener)
  {
    super(paramOnFeedItemPageLoadListener);
  }
  
  protected HomeFeedData a()
  {
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    List localList = localFeedManager.c();
    HomeFeedData localHomeFeedData = new HomeFeedData(new ErrorMessage());
    localHomeFeedData.jdField_b_of_type_JavaUtilList = localFeedManager.b(localList);
    localHomeFeedData.jdField_b_of_type_Boolean = true;
    localHomeFeedData.a = localHomeFeedData.jdField_b_of_type_JavaUtilList.isEmpty();
    return localHomeFeedData;
  }
  
  protected HomeFeedData a(ErrorMessage paramErrorMessage)
  {
    return new HomeFeedData(paramErrorMessage);
  }
  
  protected JobSegment<FeedListPageLoaderBase.GetFeedIdListResult, HomeFeedData> a()
  {
    return new HomeFeedAllInfoPullSegment();
  }
  
  protected JobSegment<Integer, FeedListPageLoaderBase.GetFeedIdListResult> a(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache)
  {
    return new MemoriesFeedListPageLoader.FeedIdPullSegment(paramFeedIdListCache);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((FeedManager)SuperManager.a(11)).c(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesFeedListPageLoader
 * JD-Core Version:    0.7.0.1
 */