package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DeleteShareGroupMemberEvent;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryMemoriesPresenter$DeleteShareGroupMemberEventReceiver
  extends QQUIEventReceiver
{
  public QQStoryMemoriesPresenter$DeleteShareGroupMemberEventReceiver(@NonNull QQStoryMemoriesPresenter paramQQStoryMemoriesPresenter)
  {
    super(paramQQStoryMemoriesPresenter);
  }
  
  public void a(@NonNull QQStoryMemoriesPresenter paramQQStoryMemoriesPresenter, @NonNull DeleteShareGroupMemberEvent paramDeleteShareGroupMemberEvent)
  {
    if (paramDeleteShareGroupMemberEvent.a)
    {
      SLog.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", paramDeleteShareGroupMemberEvent);
      QQStoryMemoriesPresenter.a(paramQQStoryMemoriesPresenter).a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteShareGroupMemberEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter.DeleteShareGroupMemberEventReceiver
 * JD-Core Version:    0.7.0.1
 */