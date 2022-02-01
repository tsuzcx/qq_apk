package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

class QQStoryMemoriesPresenter$UpdateUserInfoEventReceiver
  extends QQUIEventReceiver<QQStoryMemoriesPresenter, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public QQStoryMemoriesPresenter$UpdateUserInfoEventReceiver(@NonNull QQStoryMemoriesPresenter paramQQStoryMemoriesPresenter)
  {
    super(paramQQStoryMemoriesPresenter);
  }
  
  public void a(@NonNull QQStoryMemoriesPresenter paramQQStoryMemoriesPresenter, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent.g.isSuccess()) && (paramUpdateUserInfoEvent.a != null) && (TextUtils.equals(paramUpdateUserInfoEvent.a.getUnionId(), paramQQStoryMemoriesPresenter.b)))
    {
      SLog.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramUpdateUserInfoEvent);
      paramQQStoryMemoriesPresenter.c = paramUpdateUserInfoEvent.a;
      QQStoryMemoriesPresenter.a(paramQQStoryMemoriesPresenter).f();
      QQStoryMemoriesPresenter.a(paramQQStoryMemoriesPresenter).d();
      QQStoryMemoriesPresenter.a(paramQQStoryMemoriesPresenter).e();
      QQStoryMemoriesPresenter.a(paramQQStoryMemoriesPresenter).b();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter.UpdateUserInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */