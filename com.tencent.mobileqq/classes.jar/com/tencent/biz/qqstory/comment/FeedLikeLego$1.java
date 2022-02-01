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
    FeedCommentLikeLego localFeedCommentLikeLego;
    int i;
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_AndroidAppActivity != null))
    {
      localFeedCommentLikeLego = (FeedCommentLikeLego)this.a.a();
      if (FeedLikeLego.a(this.a) != 11) {
        break label145;
      }
      i = 211;
    }
    for (;;)
    {
      StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
      i = StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      StoryReportor.a("home_page", "clk_like_more", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), StoryReportor.a(localFeedCommentLikeLego.a), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label145:
      if (FeedLikeLego.a(this.a) == 12) {
        i = 222;
      } else {
        i = 210;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.1
 * JD-Core Version:    0.7.0.1
 */