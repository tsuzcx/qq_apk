package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import java.util.List;

public class ProfileFeedPresenter$GetYearNodeListEvent
  extends BaseEvent
{
  public boolean a;
  public List<MomeriesYearNode> b;
  
  public ProfileFeedPresenter$GetYearNodeListEvent(ProfileFeedPresenter paramProfileFeedPresenter, ErrorMessage paramErrorMessage)
  {
    this.g = paramErrorMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.GetYearNodeListEvent
 * JD-Core Version:    0.7.0.1
 */