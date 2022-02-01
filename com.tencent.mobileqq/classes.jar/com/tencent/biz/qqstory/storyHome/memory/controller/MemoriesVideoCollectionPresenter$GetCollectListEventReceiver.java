package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

class MemoriesVideoCollectionPresenter$GetCollectListEventReceiver
  extends QQUIEventReceiver<MemoriesVideoCollectionPresenter, DateCollectionListPageLoader.GetCollectionListEvent>
{
  public MemoriesVideoCollectionPresenter$GetCollectListEventReceiver(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter)
  {
    super(paramMemoriesVideoCollectionPresenter);
  }
  
  public void a(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (!TextUtils.equals(String.valueOf(paramMemoriesVideoCollectionPresenter.hashCode()), paramGetCollectionListEvent.i)) {
      return;
    }
    SLog.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramGetCollectionListEvent);
    if (paramGetCollectionListEvent.g.isSuccess())
    {
      if (paramGetCollectionListEvent.f != -1) {
        paramMemoriesVideoCollectionPresenter.e = paramGetCollectionListEvent.f;
      }
      paramMemoriesVideoCollectionPresenter.b = true;
      paramMemoriesVideoCollectionPresenter.c = null;
      if (paramGetCollectionListEvent.h)
      {
        paramMemoriesVideoCollectionPresenter.a(paramGetCollectionListEvent.e, paramGetCollectionListEvent.c, paramGetCollectionListEvent.a);
        paramMemoriesVideoCollectionPresenter.f = paramGetCollectionListEvent.a;
      }
    }
    else
    {
      paramMemoriesVideoCollectionPresenter.c = paramGetCollectionListEvent.g;
    }
    MemoriesVideoCollectionPresenter.a(paramMemoriesVideoCollectionPresenter).a(paramGetCollectionListEvent.g.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter.GetCollectListEventReceiver
 * JD-Core Version:    0.7.0.1
 */