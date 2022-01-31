package com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.FakeFeedViewUpdateCompletedEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryTakeVideoCloseAnimationActivity$FakeFeedUpdateCompletedReceiver
  extends QQUIEventReceiver
{
  public QQStoryTakeVideoCloseAnimationActivity$FakeFeedUpdateCompletedReceiver(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull FeedSegment.FakeFeedViewUpdateCompletedEvent paramFakeFeedViewUpdateCompletedEvent)
  {
    if (paramFakeFeedViewUpdateCompletedEvent != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramFakeFeedViewUpdateCompletedEvent.a, paramFakeFeedViewUpdateCompletedEvent.b, paramFakeFeedViewUpdateCompletedEvent.c, paramFakeFeedViewUpdateCompletedEvent.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedSegment.FakeFeedViewUpdateCompletedEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity.FakeFeedUpdateCompletedReceiver
 * JD-Core Version:    0.7.0.1
 */