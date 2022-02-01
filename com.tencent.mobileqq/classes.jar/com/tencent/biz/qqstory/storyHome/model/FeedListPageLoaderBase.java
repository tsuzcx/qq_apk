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
  protected FeedListPageLoaderBase.FeedIdListCache g = new FeedListPageLoaderBase.FeedIdListCache();
  protected FeedListPageLoaderBase.OnFeedItemPageLoadListener<T> h;
  public BasicLocation i;
  private Stream<T> j;
  
  public FeedListPageLoaderBase() {}
  
  public FeedListPageLoaderBase(@NonNull FeedListPageLoaderBase.OnFeedItemPageLoadListener<T> paramOnFeedItemPageLoadListener)
  {
    this.h = paramOnFeedItemPageLoadListener;
    AssertUtils.checkNotNull(this.h);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  protected abstract JobSegment<Integer, FeedListPageLoaderBase.GetFeedIdListResult> a(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache);
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.g.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  protected abstract T b(ErrorMessage paramErrorMessage);
  
  public void b(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache)
  {
    this.g = paramFeedIdListCache;
    SLog.a("Q.qqstory.home.position", "restore last time cache:%s", paramFeedIdListCache);
  }
  
  public void c()
  {
    super.c();
    d();
  }
  
  protected abstract JobSegment<FeedListPageLoaderBase.GetFeedIdListResult, T> e();
  
  protected abstract T f();
  
  public FeedListPageLoaderBase.FeedIdListCache g()
  {
    return this.g;
  }
  
  public T h()
  {
    return f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase
 * JD-Core Version:    0.7.0.1
 */