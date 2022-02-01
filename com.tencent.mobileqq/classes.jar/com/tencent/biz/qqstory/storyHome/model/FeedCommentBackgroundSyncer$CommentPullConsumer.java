package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.Producer.ConsumerBase;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class FeedCommentBackgroundSyncer$CommentPullConsumer
  extends Producer.ConsumerBase<FeedCommentSync>
{
  private Stream<CommentListPageLoader.GetFeedCommentEvent> a;
  
  public void a(FeedCommentSync paramFeedCommentSync)
  {
    this.a = Stream.of(paramFeedCommentSync).map(new ThreadOffFunction("Q.qqstory.home.data.FeedCommentBackgroundSyncer", 2)).map(new FeedCommentBackgroundSyncer.SyncAllCommentFragment(null));
    this.a.subscribe(new FeedCommentBackgroundSyncer.CommentPullConsumer.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer.CommentPullConsumer
 * JD-Core Version:    0.7.0.1
 */