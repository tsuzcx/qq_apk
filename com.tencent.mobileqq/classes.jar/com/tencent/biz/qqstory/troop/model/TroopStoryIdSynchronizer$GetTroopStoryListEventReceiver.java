package com.tencent.biz.qqstory.troop.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetTroopStoryListHandler.GetTroopStoryListEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class TroopStoryIdSynchronizer$GetTroopStoryListEventReceiver
  extends QQUIEventReceiver<TroopStoryIdSynchronizer, GetTroopStoryListHandler.GetTroopStoryListEvent>
{
  public void a(@NonNull TroopStoryIdSynchronizer paramTroopStoryIdSynchronizer, @NonNull GetTroopStoryListHandler.GetTroopStoryListEvent paramGetTroopStoryListEvent)
  {
    if (!paramTroopStoryIdSynchronizer.j.equals(paramGetTroopStoryListEvent.l)) {
      return;
    }
    List localList = paramGetTroopStoryListEvent.e;
    if ((paramGetTroopStoryListEvent.g.isSuccess()) && (localList != null) && (!localList.isEmpty()))
    {
      paramTroopStoryIdSynchronizer.a(localList);
      paramTroopStoryIdSynchronizer.g.addAll(localList);
      paramTroopStoryIdSynchronizer.l = paramGetTroopStoryListEvent.a;
      paramTroopStoryIdSynchronizer.k = paramGetTroopStoryListEvent.h;
      paramTroopStoryIdSynchronizer.a();
    }
    paramTroopStoryIdSynchronizer.h = false;
  }
  
  public Class acceptEventClass()
  {
    return GetTroopStoryListHandler.GetTroopStoryListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryIdSynchronizer.GetTroopStoryListEventReceiver
 * JD-Core Version:    0.7.0.1
 */