package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class FeedCommentLikeLego$1$1
  extends OnSimpleShareListener
{
  FeedCommentLikeLego$1$1(FeedCommentLikeLego.1 param1) {}
  
  public void a()
  {
    super.a();
    FeedCommentLikeLego.a(this.a.a, null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StoryReportor.a("home_page", "suc_share", 1, paramInt, new String[] { StoryReportor.b(this.a.a.a) + "", StoryReportor.a(this.a.a.a) + "", this.a.a.a.feedId });
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    StoryReportor.a("home_page", "share_chanel", 1, paramInt, new String[] { StoryReportor.b(this.a.a.a) + "", StoryReportor.a(this.a.a.a) + "", this.a.a.a.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLikeLego.1.1
 * JD-Core Version:    0.7.0.1
 */