package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class NewMyStorySegment$StoryVideoPublishStatusReceiver
  extends QQUIEventReceiver
{
  public NewMyStorySegment$StoryVideoPublishStatusReceiver(@NonNull NewMyStorySegment paramNewMyStorySegment)
  {
    super(paramNewMyStorySegment);
  }
  
  public void a(@NonNull NewMyStorySegment paramNewMyStorySegment, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if (paramStoryVideoPublishStatusEvent.a())
    {
      SLog.b(this.TAG, "group video upload");
      return;
    }
    if (!paramStoryVideoPublishStatusEvent.b())
    {
      SLog.b(this.TAG, "ignore personal video");
      return;
    }
    paramNewMyStorySegment.a(paramStoryVideoPublishStatusEvent);
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.StoryVideoPublishStatusReceiver
 * JD-Core Version:    0.7.0.1
 */