package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class StoryDetailPresenter$GetUserInfoReceiver
  extends QQUIEventReceiver<StoryDetailPresenter, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public StoryDetailPresenter$GetUserInfoReceiver(@NonNull StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (StoryDetailPresenter.a(paramStoryDetailPresenter) == null)
    {
      SLog.b(this.TAG, "ignore this user info event. %s.", paramUpdateUserInfoEvent.toString());
      return;
    }
    SLog.a(this.TAG, "receive user info event. %s.", paramUpdateUserInfoEvent.toString());
    StoryDetailPresenter.a(paramStoryDetailPresenter).c();
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.GetUserInfoReceiver
 * JD-Core Version:    0.7.0.1
 */