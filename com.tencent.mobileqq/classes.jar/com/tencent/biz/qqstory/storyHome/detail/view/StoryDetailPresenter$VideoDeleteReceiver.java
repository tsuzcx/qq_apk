package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;

public class StoryDetailPresenter$VideoDeleteReceiver
  extends UIBaseEventReceiver<StoryDetailPresenter, DeleteStoryVideoEvent>
{
  public StoryDetailPresenter$VideoDeleteReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    StoryDetailPresenter.a(paramStoryDetailPresenter, paramDeleteStoryVideoEvent.a, this.TAG);
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.VideoDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */