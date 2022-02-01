package com.tencent.biz.qqstory.playmode.util;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BatchGetVideoInfo
{
  public ArrayList<String> a = new ArrayList();
  public BatchGetVideoInfo.IBatchGetVideoInfoCallback b;
  public int c = 0;
  public BatchGetVideoInfo.VideoLocalCacheFilter d = new BatchGetVideoInfo.1(this);
  
  public BatchGetVideoInfo(List<String> paramList)
  {
    this.a.addAll(paramList);
  }
  
  public void a()
  {
    this.a.clear();
    this.b = null;
  }
  
  public void a(BatchGetVideoInfo.IBatchGetVideoInfoCallback paramIBatchGetVideoInfoCallback)
  {
    this.b = paramIBatchGetVideoInfoCallback;
  }
  
  public void a(List<String> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.emptyList();
    }
    SLog.d("BatchGetVideoInfo", "runPuller vid list size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    paramList = BatchHandlerListPuller.a((List)localObject);
    paramList.a("BatchGetVideoInfo");
    paramList.a(new BatchGetVideoInfo.2(this, paramList));
    paramList.b();
  }
  
  public void b()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      Object localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject3 = localStoryManager.a(str);
        if (localObject3 != null)
        {
          BatchGetVideoInfo.VideoLocalCacheFilter localVideoLocalCacheFilter = this.d;
          if ((localVideoLocalCacheFilter != null) && (localVideoLocalCacheFilter.a((StoryVideoItem)localObject3)))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("TextUtils.isEmpty(video.mVideoUrl), vid:");
              ((StringBuilder)localObject3).append(str);
              QLog.i("BatchGetVideoInfo", 2, ((StringBuilder)localObject3).toString());
            }
            ((ArrayList)localObject2).add(str);
          }
          else
          {
            ((ArrayList)localObject1).add(localObject3);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("storyVideoItem != null, vid:");
            ((StringBuilder)localObject3).append(str);
            QLog.i("BatchGetVideoInfo", 2, ((StringBuilder)localObject3).toString());
          }
          ((ArrayList)localObject2).add(str);
        }
      }
      if (((ArrayList)localObject2).isEmpty())
      {
        localObject2 = this.b;
        if (localObject2 != null) {
          ((BatchGetVideoInfo.IBatchGetVideoInfoCallback)localObject2).a((ArrayList)localObject1);
        }
      }
      else
      {
        a((List)localObject2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("BatchGetVideoInfo", 2, "doBatchGetVideoInfo, vidList ==  null || vidList.isEmpty()");
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ((BatchGetVideoInfo.IBatchGetVideoInfoCallback)localObject1).a();
    }
  }
  
  public void c()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      Object localObject4 = localStoryManager.a((String)localObject3);
      if (localObject4 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("handleVidInfoBack, vid can't find storyvideoitem vid:");
          ((StringBuilder)localObject4).append((String)localObject3);
          QLog.e("BatchGetVideoInfo", 2, ((StringBuilder)localObject4).toString());
        }
        ((ArrayList)localObject2).add(localObject3);
      }
      else if (!TextUtils.isEmpty(((StoryVideoItem)localObject4).mOwnerUid))
      {
        localObject3 = ((UserManager)SuperManager.a(2)).b(((StoryVideoItem)localObject4).mOwnerUid);
        if (localObject3 == null)
        {
          if (!localArrayList1.contains(((StoryVideoItem)localObject4).mOwnerUid)) {
            localArrayList1.add(((StoryVideoItem)localObject4).mOwnerUid);
          }
        }
        else
        {
          ((StoryVideoItem)localObject4).mOwnerUid = ((QQUserUIItem)localObject3).uid;
          localArrayList2.add(localObject4);
          ((ArrayList)localObject1).add(localObject4);
        }
      }
      else
      {
        ((ArrayList)localObject1).add(localObject4);
      }
    }
    if (!((ArrayList)localObject2).isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.e("BatchGetVideoInfo", 2, "handleVidInfoBack, vid can't find storyvideoitem.");
      }
      int i = this.c;
      this.c = (i + 1);
      if (i < 3)
      {
        a((List)localObject2);
        return;
      }
      localObject1 = this.b;
      if (localObject1 != null) {
        ((BatchGetVideoInfo.IBatchGetVideoInfoCallback)localObject1).a();
      }
      return;
    }
    this.c = 0;
    if (!localArrayList2.isEmpty()) {
      localStoryManager.a(localArrayList2);
    }
    if (localArrayList1.isEmpty())
    {
      localObject2 = this.b;
      if (localObject2 != null) {
        ((BatchGetVideoInfo.IBatchGetVideoInfoCallback)localObject2).a((ArrayList)localObject1);
      }
    }
    else
    {
      localObject1 = BatchHandlerListPuller.a(localArrayList1);
      ((BatchHandlerListPuller)localObject1).a("BatchGetVideoInfo");
      ((BatchHandlerListPuller)localObject1).a(new BatchGetVideoInfo.3(this, (BatchHandlerListPuller)localObject1));
      ((BatchHandlerListPuller)localObject1).b();
    }
  }
  
  public void d()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = (StoryManager)SuperManager.a(5);
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = ((StoryManager)localObject1).a((String)localIterator.next());
      if (localStoryVideoItem == null)
      {
        SLog.d("BatchGetVideoInfo", "user -> video empty ,strange");
      }
      else
      {
        if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
        {
          Object localObject2 = ((UserManager)SuperManager.a(2)).b(localStoryVideoItem.mOwnerUid);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("unionid can't find QQUserUIItem:");
              ((StringBuilder)localObject2).append(localStoryVideoItem.mOwnerUid);
              QLog.e("BatchGetVideoInfo", 2, ((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            localStoryVideoItem.mOwnerUid = ((QQUserUIItem)localObject2).uid;
            localArrayList2.add(localStoryVideoItem);
          }
        }
        localArrayList1.add(localStoryVideoItem);
      }
    }
    if (!localArrayList2.isEmpty()) {
      ((StoryManager)localObject1).a(localArrayList2);
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ((BatchGetVideoInfo.IBatchGetVideoInfoCallback)localObject1).a(localArrayList1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo
 * JD-Core Version:    0.7.0.1
 */