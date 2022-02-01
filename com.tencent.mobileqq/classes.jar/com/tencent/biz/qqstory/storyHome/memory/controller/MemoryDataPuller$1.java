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
    paramVarArgs = paramJobContext.a(DateCollectionListPageLoader.a(this.a.jdField_b_of_type_JavaLangString));
    boolean bool;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    List localList = paramJobContext.a(this.a.jdField_b_of_type_JavaLangString, null, 10L);
    DateCollectionListPageLoader.GetCollectionListEvent localGetCollectionListEvent = new DateCollectionListPageLoader.GetCollectionListEvent(this.a.c, new ErrorMessage());
    localGetCollectionListEvent.jdField_b_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
    localGetCollectionListEvent.jdField_b_of_type_Boolean = true;
    localGetCollectionListEvent.c = true;
    localGetCollectionListEvent.e = true;
    localGetCollectionListEvent.jdField_a_of_type_Boolean = false;
    localGetCollectionListEvent.jdField_a_of_type_JavaUtilList = localList;
    if (localList.size() > 0) {
      paramJobContext = (VideoCollectionItem)localList.get(localList.size() - 1);
    } else {
      paramJobContext = null;
    }
    if (paramJobContext == null)
    {
      localGetCollectionListEvent.jdField_a_of_type_Boolean = true;
      this.a.jdField_b_of_type_Boolean = true;
    }
    else if ((paramVarArgs != null) && (paramJobContext.dbIndex >= paramVarArgs.maxCollectionIndex))
    {
      localGetCollectionListEvent.jdField_a_of_type_Boolean = bool;
      this.a.jdField_b_of_type_Boolean = true;
    }
    else
    {
      localGetCollectionListEvent.jdField_a_of_type_Boolean = false;
    }
    StoryDispatcher.a().dispatch(localGetCollectionListEvent);
    this.a.a(localList, false);
    if (localGetCollectionListEvent.jdField_a_of_type_Boolean) {
      paramJobContext = "true";
    } else {
      paramJobContext = "false";
    }
    SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req first page local data ,isEnd = %s ,spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
    this.a.d();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller.1
 * JD-Core Version:    0.7.0.1
 */