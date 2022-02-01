package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;

class BottomVideoInfoWidget$3
  implements Runnable
{
  BottomVideoInfoWidget$3(BottomVideoInfoWidget paramBottomVideoInfoWidget, boolean paramBoolean, LikeEntry paramLikeEntry, VideoListFeedItem paramVideoListFeedItem) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      BottomVideoInfoWidget.a(this.this$0).b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    }
    for (;;)
    {
      BottomVideoInfoWidget.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      FeedInfoChangeEvent localFeedInfoChangeEvent = new FeedInfoChangeEvent(1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      StoryDispatcher.a().dispatch(localFeedInfoChangeEvent);
      return;
      BottomVideoInfoWidget.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */