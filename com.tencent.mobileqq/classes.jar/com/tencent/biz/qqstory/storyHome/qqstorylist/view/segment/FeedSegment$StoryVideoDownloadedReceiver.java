package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class FeedSegment$StoryVideoDownloadedReceiver
  extends QQUIEventReceiver
{
  public FeedSegment$StoryVideoDownloadedReceiver(@NonNull FeedSegment paramFeedSegment)
  {
    super(paramFeedSegment);
  }
  
  public void a(@NonNull FeedSegment paramFeedSegment, @NonNull FeedSegment.StoryVideoDownloadedEvent paramStoryVideoDownloadedEvent)
  {
    paramFeedSegment.a(paramStoryVideoDownloadedEvent);
  }
  
  public Class acceptEventClass()
  {
    return FeedSegment.StoryVideoDownloadedEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.StoryVideoDownloadedReceiver
 * JD-Core Version:    0.7.0.1
 */