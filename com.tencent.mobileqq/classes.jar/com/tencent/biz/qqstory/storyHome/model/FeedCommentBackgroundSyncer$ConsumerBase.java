package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class FeedCommentBackgroundSyncer$ConsumerBase
  implements FeedCommentBackgroundSyncer.IConsumer
{
  private FeedCommentBackgroundSyncer.IProducer a;
  
  public void a(FeedCommentBackgroundSyncer.IProducer paramIProducer)
  {
    this.a = paramIProducer;
  }
  
  public abstract void a(Object paramObject);
  
  public void b()
  {
    Object localObject = this.a.a();
    if (localObject != null)
    {
      a(localObject);
      SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "start one consumer:%s", localObject);
      return;
    }
    SLog.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "no data return");
  }
  
  public void c()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer.ConsumerBase
 * JD-Core Version:    0.7.0.1
 */