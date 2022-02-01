package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class MemoryDataPuller$3
  extends SimpleJob<Object>
{
  MemoryDataPuller$3(MemoryDataPuller paramMemoryDataPuller, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (MemoryManager)SuperManager.a(19);
    paramVarArgs = paramJobContext.c(DateCollectionListPageLoader.b(this.b.c));
    MemoryDataPuller.GetMemoryCollectionKeyEvent localGetMemoryCollectionKeyEvent = new MemoryDataPuller.GetMemoryCollectionKeyEvent(this.b.d);
    ArrayList localArrayList = new ArrayList();
    localGetMemoryCollectionKeyEvent.a = paramJobContext.a(this.a, localArrayList);
    localGetMemoryCollectionKeyEvent.b = localArrayList;
    boolean bool = true;
    if ((paramVarArgs == null) || (paramVarArgs.isEnd != 1)) {
      bool = false;
    }
    localGetMemoryCollectionKeyEvent.c = bool;
    StoryDispatcher.a().dispatch(localGetMemoryCollectionKeyEvent);
    SLog.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localGetMemoryCollectionKeyEvent.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller.3
 * JD-Core Version:    0.7.0.1
 */