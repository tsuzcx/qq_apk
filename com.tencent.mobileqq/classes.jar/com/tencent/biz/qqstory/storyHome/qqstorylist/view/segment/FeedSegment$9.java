package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.Rect;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;

class FeedSegment$9
  implements Runnable
{
  FeedSegment$9(FeedSegment paramFeedSegment, Rect paramRect) {}
  
  public void run()
  {
    FeedSegment.FakeFeedViewUpdateCompletedEvent localFakeFeedViewUpdateCompletedEvent = new FeedSegment.FakeFeedViewUpdateCompletedEvent(this.a.top, this.a.left, this.a.right, this.a.bottom);
    StoryDispatcher.a().dispatch(localFakeFeedViewUpdateCompletedEvent);
    SLog.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.9
 * JD-Core Version:    0.7.0.1
 */