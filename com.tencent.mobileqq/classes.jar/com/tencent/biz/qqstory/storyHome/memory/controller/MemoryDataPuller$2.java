package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class MemoryDataPuller$2
  extends SimpleJob<Object>
{
  MemoryDataPuller$2(MemoryDataPuller paramMemoryDataPuller, String paramString, VideoCollectionItem paramVideoCollectionItem)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramJobContext = (MemoryManager)SuperManager.a(19);
    MemoryInfoEntry localMemoryInfoEntry = paramJobContext.c(DateCollectionListPageLoader.b(this.b.c));
    boolean bool1;
    if ((localMemoryInfoEntry != null) && (localMemoryInfoEntry.isEnd == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.a == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (!this.b.i)
    {
      List localList = paramJobContext.a(this.b.c, this.a, 10L);
      DateCollectionListPageLoader.GetCollectionListEvent localGetCollectionListEvent = new DateCollectionListPageLoader.GetCollectionListEvent(this.b.d, new ErrorMessage());
      localGetCollectionListEvent.j = this.b.c;
      localGetCollectionListEvent.b = true;
      localGetCollectionListEvent.c = bool2;
      localGetCollectionListEvent.h = true;
      localGetCollectionListEvent.a = bool1;
      localGetCollectionListEvent.e = localList;
      if (localList.size() > 0) {
        paramVarArgs = (VideoCollectionItem)localList.get(localList.size() - 1);
      } else {
        paramVarArgs = null;
      }
      paramJobContext = "null";
      if (paramVarArgs == null)
      {
        paramVarArgs = this.b;
        paramVarArgs.i = true;
        if (bool2) {
          paramVarArgs.e.a(null, 0);
        } else {
          paramVarArgs.e.c();
        }
        paramVarArgs = this.a;
        if (paramVarArgs != null) {
          paramJobContext = paramVarArgs.key;
        }
        SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req local data ,start key: %s , not found in db , start get from net , spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
      }
      else
      {
        if ((localMemoryInfoEntry != null) && (paramVarArgs.dbIndex >= localMemoryInfoEntry.maxCollectionIndex))
        {
          localGetCollectionListEvent.a = bool1;
          this.b.i = true;
        }
        else
        {
          localGetCollectionListEvent.a = false;
        }
        StoryDispatcher.a().dispatch(localGetCollectionListEvent);
        this.b.a(localList, false);
        paramVarArgs = this.a;
        if (paramVarArgs != null) {
          paramJobContext = paramVarArgs.key;
        }
        if (localGetCollectionListEvent.a) {
          paramVarArgs = "true";
        } else {
          paramVarArgs = "false";
        }
        SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req local data ,start key: %s , isEnd = %s ,spend time = %d", new Object[] { paramJobContext, paramVarArgs, Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    else
    {
      if (bool2) {
        this.b.e.a(null, 0);
      } else {
        this.b.e.c();
      }
      SLog.d("Q.qqstory.memories:MemoryDataPuller", String.format("Req from net ,  spend time = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller.2
 * JD-Core Version:    0.7.0.1
 */