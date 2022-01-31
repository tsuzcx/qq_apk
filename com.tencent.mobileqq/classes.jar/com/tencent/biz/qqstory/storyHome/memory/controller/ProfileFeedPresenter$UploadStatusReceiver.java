package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ProfileFeedPresenter$UploadStatusReceiver
  extends QQUIEventReceiver
{
  public ProfileFeedPresenter$UploadStatusReceiver(ProfileFeedPresenter paramProfileFeedPresenter)
  {
    super(paramProfileFeedPresenter);
  }
  
  public void a(@NonNull ProfileFeedPresenter paramProfileFeedPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if (paramStoryVideoPublishStatusEvent.errorInfo.isSuccess())
    {
      if (!paramStoryVideoPublishStatusEvent.a()) {
        break label25;
      }
      SLog.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramStoryVideoPublishStatusEvent.c())
        {
          SLog.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramStoryVideoPublishStatusEvent.toString());
          return;
        }
      } while (!paramStoryVideoPublishStatusEvent.b());
      SLog.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramStoryVideoPublishStatusEvent.toString());
    } while (paramStoryVideoPublishStatusEvent.b == null);
    ProfileFeedPresenter.a(paramProfileFeedPresenter, true);
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.UploadStatusReceiver
 * JD-Core Version:    0.7.0.1
 */