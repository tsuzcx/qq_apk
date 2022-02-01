package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class MemoriesProfilePresenter
  implements IEventReceiver
{
  public String a;
  public QQUserUIItem b = null;
  private int c = -1;
  private int d = -1;
  private MemoriesProfilePresenter.ProfilePresenterListener e;
  private AtomicBoolean f = new AtomicBoolean(false);
  private MemoriesProfilePresenter.UpdateUserInfoEventReceiver g;
  private MemoriesProfilePresenter.GetCollectListEventReceiver h;
  private MemoriesProfilePresenter.GetShareGroupListReceiver i;
  private MemoriesProfilePresenter.GetYearNodeListReceiver j;
  private FriendListObserver k = new MemoriesProfilePresenter.1(this);
  
  public MemoriesProfilePresenter(String paramString, @NonNull MemoriesProfilePresenter.ProfilePresenterListener paramProfilePresenterListener)
  {
    this.a = paramString;
    this.e = paramProfilePresenterListener;
  }
  
  public void a()
  {
    this.g = new MemoriesProfilePresenter.UpdateUserInfoEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.g);
    PlayModeUtils.b().addObserver(this.k);
    this.h = new MemoriesProfilePresenter.GetCollectListEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.h);
    this.i = new MemoriesProfilePresenter.GetShareGroupListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.i);
    this.j = new MemoriesProfilePresenter.GetYearNodeListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.j);
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.b = ((UserManager)SuperManager.a(2)).b(this.a);
      SLog.a("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.b);
      return;
    }
    SLog.a("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.a);
    new GetUserInfoHandler().a(1, new QQUserUIItem.UserID("", this.a), String.valueOf(hashCode()), true, true);
  }
  
  public void b()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.g);
    PlayModeUtils.b().removeObserver(this.k);
    StoryDispatcher.a().unRegisterSubscriber(this.h);
    StoryDispatcher.a().unRegisterSubscriber(this.i);
    StoryDispatcher.a().unRegisterSubscriber(this.j);
    this.f.set(true);
  }
  
  public boolean isValidate()
  {
    return this.f.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter
 * JD-Core Version:    0.7.0.1
 */