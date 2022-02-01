package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import mqq.os.MqqHandler;

public class DetailFeedAllInfoPuller
{
  protected boolean a = true;
  private String b;
  private DetailFeedAllInfoPuller.OnFeedItemPullListener c;
  private Stream<DetailFeedItem> d;
  private DetailFeedItem e = new DetailFeedItem();
  private boolean f = true;
  
  public DetailFeedAllInfoPuller(@NonNull String paramString, @NonNull DetailFeedAllInfoPuller.OnFeedItemPullListener paramOnFeedItemPullListener, boolean paramBoolean)
  {
    this.b = paramString;
    this.c = paramOnFeedItemPullListener;
    this.a = paramBoolean;
  }
  
  private void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    ThreadManager.getUIHandler().post(new DetailFeedAllInfoPuller.2(this, paramDetailFeedItem, paramBoolean, paramErrorMessage));
  }
  
  public void a()
  {
    Bosses.get().postLightWeightJob(new DetailFeedAllInfoPuller.1(this), 0);
  }
  
  public void b()
  {
    Stream localStream = this.d;
    if (localStream != null) {
      localStream.cancel();
    }
    this.d = Stream.of(this.b).map(new ThreadOffFunction("Q.qqstory.detail.DetailFeedAllInfoPuller", 2)).map(new DetailFeedAllInfoPuller.FeedItemPullSegment(this, this.b));
    if (this.a) {
      this.d = this.d.map(new DetailFeedAllInfoPullSegment());
    }
    this.d.subscribe(new DetailFeedAllInfoPuller.RequestFeedObserver(this));
  }
  
  public void c()
  {
    Stream localStream = this.d;
    if (localStream != null) {
      localStream.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller
 * JD-Core Version:    0.7.0.1
 */