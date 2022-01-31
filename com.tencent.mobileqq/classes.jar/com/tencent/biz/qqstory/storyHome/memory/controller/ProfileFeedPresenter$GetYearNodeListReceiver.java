package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class ProfileFeedPresenter$GetYearNodeListReceiver
  extends QQUIEventReceiver
{
  public ProfileFeedPresenter$GetYearNodeListReceiver(ProfileFeedPresenter paramProfileFeedPresenter)
  {
    super(paramProfileFeedPresenter);
  }
  
  public void a(@NonNull ProfileFeedPresenter paramProfileFeedPresenter, @NonNull ProfileFeedPresenter.GetYearNodeListEvent paramGetYearNodeListEvent)
  {
    if (paramGetYearNodeListEvent.jdField_a_of_type_Boolean)
    {
      if (paramGetYearNodeListEvent.errorInfo.isSuccess())
      {
        ProfileFeedPresenter.a(paramProfileFeedPresenter, paramGetYearNodeListEvent.jdField_a_of_type_JavaUtilList, true);
        ProfileFeedPresenter.a(paramProfileFeedPresenter).a(true);
      }
      return;
    }
    ProfileFeedPresenter.a(paramProfileFeedPresenter, paramGetYearNodeListEvent);
    ProfileFeedPresenter.a(paramProfileFeedPresenter).remove(ProfileFeedPresenter.b());
    ProfileFeedPresenter.a(paramProfileFeedPresenter);
  }
  
  public Class acceptEventClass()
  {
    return ProfileFeedPresenter.GetYearNodeListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.GetYearNodeListReceiver
 * JD-Core Version:    0.7.0.1
 */