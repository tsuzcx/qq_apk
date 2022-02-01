package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import java.util.List;

public class ProfileFeedPresenter$GetYearNodeListEvent
  extends BaseEvent
{
  public List<MomeriesYearNode> a;
  public boolean a;
  
  public ProfileFeedPresenter$GetYearNodeListEvent(ProfileFeedPresenter paramProfileFeedPresenter, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.GetYearNodeListEvent
 * JD-Core Version:    0.7.0.1
 */