package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.Producer.StoryProducer;
import java.util.List;

public class FeedCommentBackgroundSyncer
{
  private Producer.StoryProducer<FeedCommentSync> a;
  
  public void a()
  {
    try
    {
      if (this.a != null)
      {
        this.a.b();
        this.a = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<FeedCommentSync> paramList)
  {
    try
    {
      if (this.a == null) {
        this.a = new Producer.StoryProducer(new FeedCommentBackgroundSyncer.CommentPullConsumer());
      }
      this.a.a(paramList);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer
 * JD-Core Version:    0.7.0.1
 */