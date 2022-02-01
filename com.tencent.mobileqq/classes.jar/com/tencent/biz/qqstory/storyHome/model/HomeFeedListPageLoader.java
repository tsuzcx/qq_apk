package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class HomeFeedListPageLoader
  extends FeedListPageLoaderBase<HomeFeedData>
{
  public HomeFeedListPageLoader(@Nullable FeedListPageLoaderBase.OnFeedItemPageLoadListener paramOnFeedItemPageLoadListener)
  {
    super(paramOnFeedItemPageLoadListener);
  }
  
  protected HomeFeedData a(ErrorMessage paramErrorMessage)
  {
    return new HomeFeedData(paramErrorMessage);
  }
  
  protected JobSegment<Integer, FeedListPageLoaderBase.GetFeedIdListResult> a(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache)
  {
    return new HomeFeedListPageLoader.FeedIdPullSegment(paramFeedIdListCache, this.i);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((FeedManager)SuperManager.a(11)).a(paramList, paramBoolean);
  }
  
  protected HomeFeedData d()
  {
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    List localList = localFeedManager.c();
    HomeFeedData localHomeFeedData = new HomeFeedData(new ErrorMessage());
    localHomeFeedData.f = localFeedManager.b(localList);
    localHomeFeedData.b = true;
    localHomeFeedData.a = localHomeFeedData.f.isEmpty();
    return localHomeFeedData;
  }
  
  protected JobSegment<FeedListPageLoaderBase.GetFeedIdListResult, HomeFeedData> e()
  {
    return new HomeFeedAllInfoPullSegment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedListPageLoader
 * JD-Core Version:    0.7.0.1
 */