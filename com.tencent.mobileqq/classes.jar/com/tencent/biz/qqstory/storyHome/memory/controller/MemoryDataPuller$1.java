package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class MemoryDataPuller$1
  extends SimpleJob<Object>
{
  MemoryDataPuller$1(MemoryDataPuller paramMemoryDataPuller, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramJobContext = (MemoryManager)SuperManager.a(19);
    paramVarArgs = paramJobContext.c(DateCollectionListPageLoader.b(this.a.c));
    boolean bool;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    List localList = paramJobContext.a(this.a.c, null, 10L);
    DateCollectionListPageLoader.GetCollectionListEvent localGetCollectionListEvent = new DateCollectionListPageLoader.GetCollectionListEvent(this.a.d, new ErrorMessage());
    localGetCollectionListEvent.j = this.a.c;
    localGetCollectionListEvent.b = true;
    localGetCollectionListEvent.c = true;
    localGetCollectionListEvent.h = true;
    localGetCollectionListEvent.a = false;
    localGetCollectionListEvent.e = localList;
    if (localList.size() > 0) {
      paramJobContext = (VideoCollectionItem)localList.get(localList.size() - 1);
    } else {
      paramJobContext = null;
    }
    if (paramJobContext == null)
    {
      localGetCollectionListEvent.a = true;
      this.a.i = true;
    }
    else if ((paramVarArgs != null) && (paramJobContext.dbIndex >= paramVarArgs.maxCollectionIndex))
    {
      localGetCollectionListEvent.a = bool;
      this.a.i = true;
    }
    else
    {
      localGetCollectionListEvent.a = false;
    }
    StoryDispatcher.a().dispatch(localGetCollectionListEvent);
    this.a.a(localList, false);
    if (localGetCollectionListEvent.a) {
      paramJobContext = "true";
    } else {
      paramJobContext = "false";
    }
    SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req first page local data ,isEnd = %s ,spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
    this.a.f();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller.1
 * JD-Core Version:    0.7.0.1
 */