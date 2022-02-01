package com.tencent.biz.qqstory.comment;

import android.view.View;
import com.tencent.biz.qqstory.comment.lego.LegoEvenHandler;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FeedLikeLego$1
  extends LegoEvenHandler
{
  FeedLikeLego$1(FeedLikeLego paramFeedLikeLego) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.c) && (this.a.d != null))
    {
      FeedCommentLikeLego localFeedCommentLikeLego = (FeedCommentLikeLego)this.a.m();
      if (FeedLikeLego.a(this.a) == 11) {
        i = 211;
      } else if (FeedLikeLego.a(this.a) == 12) {
        i = 222;
      } else {
        i = 210;
      }
      StoryDetailActivity.a(this.a.d, this.a.b.feedId, i, 0);
      int i = StoryReportor.b(this.a.b);
      StoryReportor.a("home_page", "clk_like_more", StoryReportor.a(this.a.b), 0, new String[] { String.valueOf(i), StoryReportor.b(localFeedCommentLikeLego.e), "", this.a.b.feedId });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.1
 * JD-Core Version:    0.7.0.1
 */