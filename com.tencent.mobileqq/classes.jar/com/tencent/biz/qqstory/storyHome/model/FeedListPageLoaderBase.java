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

public abstract class FeedListPageLoaderBase<T extends FeedListPageLoaderBase.FeedData>
  extends INetPageLoader
{
  public BasicLocation a;
  protected FeedListPageLoaderBase.FeedIdListCache a;
  protected FeedListPageLoaderBase.OnFeedItemPageLoadListener<T> a;
  private Stream<T> a;
  
  public FeedListPageLoaderBase()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache = new FeedListPageLoaderBase.FeedIdListCache();
  }
  
  public FeedListPageLoaderBase(@NonNull FeedListPageLoaderBase.OnFeedItemPageLoadListener<T> paramOnFeedItemPageLoadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache = new FeedListPageLoaderBase.FeedIdListCache();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$OnFeedItemPageLoadListener = paramOnFeedItemPageLoadListener;
    AssertUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$OnFeedItemPageLoadListener);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public FeedListPageLoaderBase.FeedIdListCache a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache;
  }
  
  protected abstract JobSegment<FeedListPageLoaderBase.GetFeedIdListResult, T> a();
  
  protected abstract JobSegment<Integer, FeedListPageLoaderBase.GetFeedIdListResult> a(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache);
  
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
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public T b()
  {
    return a();
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase
 * JD-Core Version:    0.7.0.1
 */