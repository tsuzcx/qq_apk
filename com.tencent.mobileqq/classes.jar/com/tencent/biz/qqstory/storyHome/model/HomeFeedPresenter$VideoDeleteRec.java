package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;

public class HomeFeedPresenter$VideoDeleteRec
  extends UIBaseEventReceiver<HomeFeedPresenter, DeleteStoryVideoEvent>
{
  public HomeFeedPresenter$VideoDeleteRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramDeleteStoryVideoEvent);
    HomeFeedPresenter.a(paramHomeFeedPresenter, paramDeleteStoryVideoEvent.a);
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.VideoDeleteRec
 * JD-Core Version:    0.7.0.1
 */