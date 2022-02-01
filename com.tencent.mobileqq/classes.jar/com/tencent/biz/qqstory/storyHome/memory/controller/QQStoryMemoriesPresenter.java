package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class QQStoryMemoriesPresenter
  implements IEventReceiver
{
  public int a;
  public String b;
  public QQUserUIItem c;
  protected QQStoryObserver d = new QQStoryMemoriesPresenter.1(this);
  private StoryMemoriesFragment e;
  private AtomicBoolean f = new AtomicBoolean(false);
  private QQStoryMemoriesPresenter.DeleteShareGroupMemberEventReceiver g;
  private QQStoryMemoriesPresenter.UpdateUserInfoEventReceiver h;
  
  public QQStoryMemoriesPresenter(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.a = paramInt;
    this.e = paramStoryMemoriesFragment;
    this.b = paramString;
  }
  
  public void a()
  {
    this.c = ((UserManager)SuperManager.a(2)).b(this.b);
    PlayModeUtils.b().addObserver(this.d);
    this.g = new QQStoryMemoriesPresenter.DeleteShareGroupMemberEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.g);
    this.h = new QQStoryMemoriesPresenter.UpdateUserInfoEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.h);
  }
  
  public void b()
  {
    PlayModeUtils.b().removeObserver(this.d);
    StoryDispatcher.a().unRegisterSubscriber(this.g);
    StoryDispatcher.a().unRegisterSubscriber(this.h);
    this.f.set(true);
  }
  
  public boolean isValidate()
  {
    return this.f.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter
 * JD-Core Version:    0.7.0.1
 */