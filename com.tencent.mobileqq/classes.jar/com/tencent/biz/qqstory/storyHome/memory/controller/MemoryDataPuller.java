package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.network.handler.UpdateCollectionViewCountHandler;
import com.tencent.biz.qqstory.network.handler.UpdateCollectionViewCountHandler.CollectionID;
import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemoryDataPuller
  implements IEventReceiver
{
  protected INetPageLoader a;
  protected MemoryDataPuller.GetCollectListEventReceiver a;
  protected Map<String, BatchHandlerListPuller> a;
  protected Set<String> a;
  protected boolean a;
  protected String b;
  protected boolean b;
  protected String c;
  
  public MemoryDataPuller(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
  }
  
  protected BatchNetHandler a(String paramString, List<String> paramList)
  {
    return new VidToSimpleInfoHandler(paramString, paramList);
  }
  
  protected INetPageLoader a()
  {
    return new DateCollectionListPageLoader(this.jdField_b_of_type_JavaLangString, this.c);
  }
  
  public DateCollectionListPageLoader.GetCollectionListEvent a()
  {
    this.jdField_b_of_type_Boolean = false;
    long l = System.currentTimeMillis();
    Object localObject = (MemoryManager)SuperManager.a(19);
    MemoryInfoEntry localMemoryInfoEntry = ((MemoryManager)localObject).a(DateCollectionListPageLoader.a(this.jdField_b_of_type_JavaLangString));
    boolean bool;
    DateCollectionListPageLoader.GetCollectionListEvent localGetCollectionListEvent;
    if ((localMemoryInfoEntry != null) && (localMemoryInfoEntry.isEnd == 1))
    {
      bool = true;
      List localList = ((MemoryManager)localObject).a(this.jdField_b_of_type_JavaLangString, null, 10L);
      localGetCollectionListEvent = new DateCollectionListPageLoader.GetCollectionListEvent(this.c, new ErrorMessage());
      localGetCollectionListEvent.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localGetCollectionListEvent.jdField_b_of_type_Boolean = true;
      localGetCollectionListEvent.c = true;
      localGetCollectionListEvent.e = true;
      localGetCollectionListEvent.jdField_a_of_type_Boolean = false;
      localGetCollectionListEvent.jdField_a_of_type_JavaUtilList = localList;
      if (localList.size() <= 0) {
        break label225;
      }
      localObject = (VideoCollectionItem)localList.get(localList.size() - 1);
      label155:
      if (localObject != null) {
        break label231;
      }
      localGetCollectionListEvent.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      label171:
      a(localList, false);
      if (!localGetCollectionListEvent.jdField_a_of_type_Boolean) {
        break label273;
      }
    }
    label273:
    for (localObject = "true";; localObject = "false")
    {
      SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req first page local data ,isEnd = %s ,spend time = %d", new Object[] { localObject, Long.valueOf(System.currentTimeMillis() - l) });
      return localGetCollectionListEvent;
      bool = false;
      break;
      label225:
      localObject = null;
      break label155;
      label231:
      if ((localMemoryInfoEntry != null) && (((VideoCollectionItem)localObject).dbIndex >= localMemoryInfoEntry.maxCollectionIndex))
      {
        localGetCollectionListEvent.jdField_a_of_type_Boolean = bool;
        this.jdField_b_of_type_Boolean = true;
        break label171;
      }
      localGetCollectionListEvent.jdField_a_of_type_Boolean = false;
      break label171;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader = a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller$GetCollectListEventReceiver = new MemoryDataPuller.GetCollectListEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller$GetCollectListEventReceiver);
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem)
  {
    Bosses.get().postJob(new MemoryDataPuller.2(this, "Q.qqstory.memories:MemoryDataPuller", paramVideoCollectionItem));
  }
  
  public void a(String paramString)
  {
    BatchHandlerListPuller localBatchHandlerListPuller = (BatchHandlerListPuller)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localBatchHandlerListPuller == null) {
      SLog.d("Q.qqstory.memories:MemoryDataPuller", String.format("cannot fount pageLoader , which collectionId is %s", new Object[] { paramString }));
    }
    while ((localBatchHandlerListPuller.b()) || (localBatchHandlerListPuller.a())) {
      return;
    }
    localBatchHandlerListPuller.b();
  }
  
  protected void a(List<String> paramList)
  {
    int i = 0;
    if (paramList.size() == 0) {}
    label185:
    for (;;)
    {
      return;
      SLog.d("Q.qqstory.memories:MemoryDataPuller", "start update view count : %s", new Object[] { paramList });
      for (;;)
      {
        if (i >= paramList.size()) {
          break label185;
        }
        int j = Math.min(paramList.size(), i + 20);
        if (i >= j) {
          break;
        }
        Object localObject = paramList.subList(i, j);
        UpdateCollectionViewCountHandler localUpdateCollectionViewCountHandler = new UpdateCollectionViewCountHandler(this.jdField_b_of_type_JavaLangString);
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          UpdateCollectionViewCountHandler.CollectionID localCollectionID = new UpdateCollectionViewCountHandler.CollectionID();
          localCollectionID.a = VideoCollectionEntry.getCollectionId(str);
          localCollectionID.b = VideoCollectionEntry.getCollectionType(str);
          if (localCollectionID.a != -1) {
            localArrayList.add(localCollectionID);
          }
        }
        localUpdateCollectionViewCountHandler.a(localArrayList);
        localUpdateCollectionViewCountHandler.a();
        i = j;
      }
    }
  }
  
  public void a(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    if (!QQStoryContext.a().a(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramList.next();
      if ((localVideoCollectionItem.collectionType == 1) && ((this.jdField_a_of_type_JavaUtilSet.add(localVideoCollectionItem.key)) || (paramBoolean))) {
        localArrayList.add(localVideoCollectionItem.key);
      }
    }
    a(localArrayList);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller$GetCollectListEventReceiver != null)
    {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller$GetCollectListEventReceiver);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller$GetCollectListEventReceiver = null;
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(String paramString)
  {
    Bosses.get().postJob(new MemoryDataPuller.3(this, "Q.qqstory.memories:MemoryDataPuller", paramString));
  }
  
  public void b(List<String> paramList, boolean paramBoolean)
  {
    if (!QQStoryContext.a().a(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((VideoCollectionEntry.getCollectionType(str) == 1) && ((this.jdField_a_of_type_JavaUtilSet.add(str)) || (paramBoolean))) {
        localArrayList.add(str);
      }
    }
    a(localArrayList);
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    Bosses.get().postJob(new MemoryDataPuller.1(this, "Q.qqstory.memories:MemoryDataPuller"));
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader.a(null, 0);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller
 * JD-Core Version:    0.7.0.1
 */