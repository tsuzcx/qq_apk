package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class ProfileFeedPresenter$GetYearNodeListReceiver
  extends QQUIEventReceiver<ProfileFeedPresenter, ProfileFeedPresenter.GetYearNodeListEvent>
{
  public ProfileFeedPresenter$GetYearNodeListReceiver(ProfileFeedPresenter paramProfileFeedPresenter)
  {
    super(paramProfileFeedPresenter);
  }
  
  public void a(@NonNull ProfileFeedPresenter paramProfileFeedPresenter, @NonNull ProfileFeedPresenter.GetYearNodeListEvent paramGetYearNodeListEvent)
  {
    if (paramGetYearNodeListEvent.a)
    {
      if (paramGetYearNodeListEvent.g.isSuccess())
      {
        ProfileFeedPresenter.a(paramProfileFeedPresenter, paramGetYearNodeListEvent.b, true);
        ProfileFeedPresenter.d(paramProfileFeedPresenter).a(true);
      }
    }
    else
    {
      ProfileFeedPresenter.a(paramProfileFeedPresenter, paramGetYearNodeListEvent);
      ProfileFeedPresenter.b(paramProfileFeedPresenter).remove(ProfileFeedPresenter.d());
      ProfileFeedPresenter.c(paramProfileFeedPresenter);
    }
  }
  
  public Class acceptEventClass()
  {
    return ProfileFeedPresenter.GetYearNodeListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.GetYearNodeListReceiver
 * JD-Core Version:    0.7.0.1
 */