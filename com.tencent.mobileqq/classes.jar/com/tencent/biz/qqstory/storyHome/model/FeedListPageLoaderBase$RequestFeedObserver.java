package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.SimpleObserver;

public class FeedListPageLoaderBase$RequestFeedObserver
  extends SimpleObserver<T>
{
  public FeedListPageLoaderBase$RequestFeedObserver(FeedListPageLoaderBase paramFeedListPageLoaderBase) {}
  
  public void a(T paramT)
  {
    super.onNext(paramT);
    this.a.b();
    SLog.b("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data finish %s", paramT);
    paramT.d = this.a.a;
    this.a.a(paramT.e, paramT.c);
    this.a.g.b();
    this.a.h.a(paramT);
    this.a.a("Q.qqstory.home.data.FeedListPageLoaderBase");
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    paramError = (ErrorMessage)paramError;
    paramError = this.a.b(paramError);
    paramError.d = this.a.a;
    this.a.h.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.RequestFeedObserver
 * JD-Core Version:    0.7.0.1
 */