package com.tencent.biz.qqstory.troop.model;

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

public class TroopAssistantFeedListPageLoader
  extends FeedListPageLoaderBase<HomeFeedData>
{
  public TroopAssistantFeedListPageLoader(@Nullable FeedListPageLoaderBase.OnFeedItemPageLoadListener paramOnFeedItemPageLoadListener)
  {
    super(paramOnFeedItemPageLoadListener);
  }
  
  protected HomeFeedData a(ErrorMessage paramErrorMessage)
  {
    return new HomeFeedData(paramErrorMessage);
  }
  
  protected JobSegment<Integer, FeedListPageLoaderBase.GetFeedIdListResult> a(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache)
  {
    return new TroopAssistantFeedListPageLoader.FeedIdPullSegment(paramFeedIdListCache);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((FeedManager)SuperManager.a(11)).b(paramList, paramBoolean);
  }
  
  protected HomeFeedData d()
  {
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    List localList = localFeedManager.d();
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
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopAssistantFeedListPageLoader
 * JD-Core Version:    0.7.0.1
 */