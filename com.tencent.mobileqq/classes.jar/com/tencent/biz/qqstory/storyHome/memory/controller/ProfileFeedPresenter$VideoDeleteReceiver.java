package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ProfileFeedPresenter$VideoDeleteReceiver
  extends QQUIEventReceiver<ProfileFeedPresenter, DeleteStoryVideoEvent>
{
  public ProfileFeedPresenter$VideoDeleteReceiver(ProfileFeedPresenter paramProfileFeedPresenter)
  {
    super(paramProfileFeedPresenter);
  }
  
  public void a(@NonNull ProfileFeedPresenter paramProfileFeedPresenter, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    if (paramDeleteStoryVideoEvent.g.isSuccess())
    {
      SLog.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramDeleteStoryVideoEvent.toString());
      ProfileFeedPresenter.a(paramProfileFeedPresenter, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.VideoDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */