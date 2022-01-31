package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobSegment;
import com.tribe.async.reactive.Stream;
import java.util.List;
import oda;

public abstract class FeedListPageLoaderBase
  extends INetPageLoader
{
  public BasicLocation a;
  public FeedListPageLoaderBase.FeedIdListCache a;
  protected FeedListPageLoaderBase.OnFeedItemPageLoadListener a;
  private Stream a;
  
  public FeedListPageLoaderBase()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache = new FeedListPageLoaderBase.FeedIdListCache();
  }
  
  public FeedListPageLoaderBase(@NonNull FeedListPageLoaderBase.OnFeedItemPageLoadListener paramOnFeedItemPageLoadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache = new FeedListPageLoaderBase.FeedIdListCache();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$OnFeedItemPageLoadListener = paramOnFeedItemPageLoadListener;
    AssertUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$OnFeedItemPageLoadListener);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new oda(this), 0);
  }
  
  public abstract FeedListPageLoaderBase.FeedData a();
  
  public abstract FeedListPageLoaderBase.FeedData a(ErrorMessage paramErrorMessage);
  
  public FeedListPageLoaderBase.FeedIdListCache a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache;
  }
  
  public abstract JobSegment a();
  
  public abstract JobSegment a(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache);
  
  public void a(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache = paramFeedIdListCache;
    SLog.a("Q.qqstory.home.position", "restore last time cache:%s", paramFeedIdListCache);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.a();
    d();
  }
  
  public abstract void a(List paramList, boolean paramBoolean);
  
  public FeedListPageLoaderBase.FeedData b()
  {
    return a();
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase
 * JD-Core Version:    0.7.0.1
 */