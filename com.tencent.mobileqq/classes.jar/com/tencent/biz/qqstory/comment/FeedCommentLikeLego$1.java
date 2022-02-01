package com.tencent.biz.qqstory.comment;

import android.view.View;
import com.tencent.biz.qqstory.comment.lego.LegoEvenHandler;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FeedCommentLikeLego$1
  extends LegoEvenHandler
{
  FeedCommentLikeLego$1(FeedCommentLikeLego paramFeedCommentLikeLego) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131431070)
    {
      if (i == 2131442684) {
        QQStoryWatcherListActivity.a(this.a.j, this.a.a.feedId, 10);
      }
    }
    else
    {
      if (this.a.e == 11) {
        i = 211;
      } else if (this.a.e == 12) {
        i = 222;
      } else {
        i = 210;
      }
      StoryDetailActivity.a(this.a.j, this.a.a.feedId, i, 0);
      StoryReportor.a("home_page", "clk_reply_mini", StoryReportor.a(this.a.a), 0, new String[] { String.valueOf(StoryReportor.b(this.a.a)), StoryReportor.b(this.a.e), "", this.a.a.feedId });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLikeLego.1
 * JD-Core Version:    0.7.0.1
 */