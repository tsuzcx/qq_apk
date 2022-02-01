package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class SimpleDataProvider$VideoPublishUpdateReceiver
  extends Subscriber.SingleEventSubscriberNoRefect<StoryVideoUploadManager.StoryVideoPublishStatusEvent>
{
  SimpleDataProvider a;
  
  public SimpleDataProvider$VideoPublishUpdateReceiver(@NonNull SimpleDataProvider paramSimpleDataProvider)
  {
    this.a = paramSimpleDataProvider;
  }
  
  protected void a(@NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if ((paramStoryVideoPublishStatusEvent.d != null) && (paramStoryVideoPublishStatusEvent.c != null)) {
      SimpleDataProvider.a(this.a, paramStoryVideoPublishStatusEvent.c.mVid, paramStoryVideoPublishStatusEvent.d.mVid, paramStoryVideoPublishStatusEvent.e.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.VideoPublishUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */