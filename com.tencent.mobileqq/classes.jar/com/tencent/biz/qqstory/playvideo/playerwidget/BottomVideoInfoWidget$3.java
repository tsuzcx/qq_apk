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
    if (this.a) {
      BottomVideoInfoWidget.c(this.this$0).b(this.b);
    } else {
      BottomVideoInfoWidget.c(this.this$0).a(this.b);
    }
    BottomVideoInfoWidget.d(this.this$0).a(this.c);
    FeedInfoChangeEvent localFeedInfoChangeEvent = new FeedInfoChangeEvent(1, this.c.feedId, 3, this.c);
    StoryDispatcher.a().dispatch(localFeedInfoChangeEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */