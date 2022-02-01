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
  
  protected HomeFeedData a()
  {
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    List localList = localFeedManager.b();
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
  
  public JobSegment<FeedListPageLoaderBase.GetFeedIdListResult, HomeFeedData> a()
  {
    return new HomeFeedAllInfoPullSegment();
  }
  
  public JobSegment<Integer, FeedListPageLoaderBase.GetFeedIdListResult> a(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache)
  {
    return new TroopAssistantFeedListPageLoader.FeedIdPullSegment(paramFeedIdListCache);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    ((FeedManager)SuperManager.a(11)).b(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopAssistantFeedListPageLoader
 * JD-Core Version:    0.7.0.1
 */