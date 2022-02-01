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
    if (i != 2131364945)
    {
      if (i == 2131374514) {
        QQStoryWatcherListActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 10);
      }
    }
    else
    {
      if (this.a.jdField_a_of_type_Int == 11) {
        i = 211;
      } else if (this.a.jdField_a_of_type_Int == 12) {
        i = 222;
      } else {
        i = 210;
      }
      StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
      StoryReportor.a("home_page", "clk_reply_mini", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem)), StoryReportor.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLikeLego.1
 * JD-Core Version:    0.7.0.1
 */