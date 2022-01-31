package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import nwv;
import nww;

public class FeedCommentBackgroundSyncer$CommentPullConsumer
  extends FeedCommentBackgroundSyncer.ConsumerBase
{
  private Stream a;
  
  public void a()
  {
    SLog.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull consumer destroy");
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
  
  public void a(FeedCommentSync paramFeedCommentSync)
  {
    this.a = Stream.of(paramFeedCommentSync).map(new ThreadOffFunction(2)).map(new nww(null));
    this.a.subscribe(new nwv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer.CommentPullConsumer
 * JD-Core Version:    0.7.0.1
 */