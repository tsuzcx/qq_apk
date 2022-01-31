package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.Producer.ConsumerBase;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import ocx;
import ocy;

public class FeedCommentBackgroundSyncer$CommentPullConsumer
  extends Producer.ConsumerBase
{
  private Stream a;
  
  public void a(FeedCommentSync paramFeedCommentSync)
  {
    this.a = Stream.of(paramFeedCommentSync).map(new ThreadOffFunction(2)).map(new ocy(null));
    this.a.subscribe(new ocx(this));
  }
  
  public void c()
  {
    SLog.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer.CommentPullConsumer
 * JD-Core Version:    0.7.0.1
 */