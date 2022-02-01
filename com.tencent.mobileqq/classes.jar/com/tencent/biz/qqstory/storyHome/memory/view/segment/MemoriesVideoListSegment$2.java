package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class MemoriesVideoListSegment$2
  extends SimpleJob<Object>
{
  MemoriesVideoListSegment$2(MemoriesVideoListSegment paramMemoriesVideoListSegment, String paramString1, String paramString2, String paramString3, int paramInt, View paramView)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, Void... paramVarArgs)
  {
    Object localObject = (MemoryManager)SuperManager.a(19);
    paramJobContext = new ArrayList();
    paramVarArgs = ((MemoryManager)localObject).a(MemoriesVideoListSegment.a(this.e).a, paramJobContext);
    if ((paramVarArgs != null) && (paramVarArgs.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.a);
      MemoriesVideoListSegment.a(this.e).a(localArrayList);
      int i = paramVarArgs.indexOf(this.a);
      if (i == -1)
      {
        SLog.e("Q.qqstory.memories.MemoriesVideoListSegment", "onVideoItemClick but can't find item, collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.a, paramJobContext, this.b, Integer.valueOf(i), Integer.valueOf(this.c), paramVarArgs });
        return null;
      }
      localObject = ((MemoryManager)localObject).c(DateCollectionListPageLoader.b(MemoriesVideoListSegment.a(this.e).a));
      if (localObject != null) {
        int j = ((MemoryInfoEntry)localObject).isEnd;
      }
      localObject = ((UserManager)SuperManager.a(2)).b(MemoriesVideoListSegment.a(this.e).a);
      ThreadManager.getUIHandler().post(new MemoriesVideoListSegment.2.1(this, paramJobContext, i, paramVarArgs, (QQUserUIItem)localObject));
      return null;
    }
    AssertUtils.fail("data key null for unionId:%s", new Object[] { MemoriesVideoListSegment.a(this.e).a });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2
 * JD-Core Version:    0.7.0.1
 */