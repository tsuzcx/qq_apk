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
    MemoryInfoEntry localMemoryInfoEntry = paramJobContext.a(DateCollectionListPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_JavaLangString));
    boolean bool1;
    if ((localMemoryInfoEntry != null) && (localMemoryInfoEntry.isEnd == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_Boolean)
    {
      List localList = paramJobContext.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem, 10L);
      DateCollectionListPageLoader.GetCollectionListEvent localGetCollectionListEvent = new DateCollectionListPageLoader.GetCollectionListEvent(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.c, new ErrorMessage());
      localGetCollectionListEvent.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_JavaLangString;
      localGetCollectionListEvent.jdField_b_of_type_Boolean = true;
      localGetCollectionListEvent.c = bool2;
      localGetCollectionListEvent.e = true;
      localGetCollectionListEvent.jdField_a_of_type_Boolean = bool1;
      localGetCollectionListEvent.jdField_a_of_type_JavaUtilList = localList;
      if (localList.size() > 0) {
        paramVarArgs = (VideoCollectionItem)localList.get(localList.size() - 1);
      } else {
        paramVarArgs = null;
      }
      paramJobContext = "null";
      if (paramVarArgs == null)
      {
        paramVarArgs = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller;
        paramVarArgs.jdField_b_of_type_Boolean = true;
        if (bool2) {
          paramVarArgs.a.a(null, 0);
        } else {
          paramVarArgs.a.c();
        }
        paramVarArgs = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem;
        if (paramVarArgs != null) {
          paramJobContext = paramVarArgs.key;
        }
        SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req local data ,start key: %s , not found in db , start get from net , spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
      }
      else
      {
        if ((localMemoryInfoEntry != null) && (paramVarArgs.dbIndex >= localMemoryInfoEntry.maxCollectionIndex))
        {
          localGetCollectionListEvent.jdField_a_of_type_Boolean = bool1;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.jdField_b_of_type_Boolean = true;
        }
        else
        {
          localGetCollectionListEvent.jdField_a_of_type_Boolean = false;
        }
        StoryDispatcher.a().dispatch(localGetCollectionListEvent);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a(localList, false);
        paramVarArgs = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem;
        if (paramVarArgs != null) {
          paramJobContext = paramVarArgs.key;
        }
        if (localGetCollectionListEvent.jdField_a_of_type_Boolean) {
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
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a.a(null, 0);
      } else {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a.c();
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