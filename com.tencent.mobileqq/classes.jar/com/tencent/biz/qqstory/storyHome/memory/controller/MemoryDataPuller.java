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
  protected String c;
  protected String d;
  protected INetPageLoader e;
  protected Map<String, BatchHandlerListPuller> f = new HashMap();
  protected MemoryDataPuller.GetCollectListEventReceiver g;
  protected boolean h = false;
  protected boolean i = false;
  protected Set<String> j = new HashSet();
  
  public MemoryDataPuller(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
  }
  
  protected BatchNetHandler a(String paramString, List<String> paramList)
  {
    return new VidToSimpleInfoHandler(paramString, paramList);
  }
  
  protected INetPageLoader a()
  {
    return new DateCollectionListPageLoader(this.c, this.d);
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem)
  {
    Bosses.get().postJob(new MemoryDataPuller.2(this, "Q.qqstory.memories:MemoryDataPuller", paramVideoCollectionItem));
  }
  
  public void a(String paramString)
  {
    BatchHandlerListPuller localBatchHandlerListPuller = (BatchHandlerListPuller)this.f.get(paramString);
    if (localBatchHandlerListPuller == null)
    {
      SLog.d("Q.qqstory.memories:MemoryDataPuller", String.format("cannot fount pageLoader , which collectionId is %s", new Object[] { paramString }));
      return;
    }
    if ((!localBatchHandlerListPuller.d()) && (!localBatchHandlerListPuller.c())) {
      localBatchHandlerListPuller.b();
    }
  }
  
  protected void a(List<String> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    int k = 0;
    SLog.d("Q.qqstory.memories:MemoryDataPuller", "start update view count : %s", new Object[] { paramList });
    while (k < paramList.size())
    {
      int m = Math.min(paramList.size(), k + 20);
      if (k >= m) {
        return;
      }
      Object localObject = paramList.subList(k, m);
      UpdateCollectionViewCountHandler localUpdateCollectionViewCountHandler = new UpdateCollectionViewCountHandler(this.c);
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
      k = m;
    }
  }
  
  public void a(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    if (!QQStoryContext.a().b(this.c)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramList.next();
      if ((localVideoCollectionItem.collectionType == 1) && ((this.j.add(localVideoCollectionItem.key)) || (paramBoolean))) {
        localArrayList.add(localVideoCollectionItem.key);
      }
    }
    a(localArrayList);
  }
  
  public void b()
  {
    this.h = true;
    this.e = a();
    this.g = new MemoryDataPuller.GetCollectListEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.g);
  }
  
  public void b(String paramString)
  {
    Bosses.get().postJob(new MemoryDataPuller.3(this, "Q.qqstory.memories:MemoryDataPuller", paramString));
  }
  
  public void b(List<String> paramList, boolean paramBoolean)
  {
    if (!QQStoryContext.a().b(this.c)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((VideoCollectionEntry.getCollectionType(str) == 1) && ((this.j.add(str)) || (paramBoolean))) {
        localArrayList.add(str);
      }
    }
    a(localArrayList);
  }
  
  public void c()
  {
    this.h = false;
    if (this.g != null)
    {
      StoryDispatcher.a().unRegisterSubscriber(this.g);
      this.g = null;
    }
    this.f.clear();
  }
  
  public DateCollectionListPageLoader.GetCollectionListEvent d()
  {
    this.i = false;
    long l = System.currentTimeMillis();
    Object localObject2 = (MemoryManager)SuperManager.a(19);
    MemoryInfoEntry localMemoryInfoEntry = ((MemoryManager)localObject2).c(DateCollectionListPageLoader.b(this.c));
    boolean bool;
    if ((localMemoryInfoEntry != null) && (localMemoryInfoEntry.isEnd == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject3 = this.c;
    Object localObject1 = null;
    localObject3 = ((MemoryManager)localObject2).a((String)localObject3, null, 10L);
    localObject2 = new DateCollectionListPageLoader.GetCollectionListEvent(this.d, new ErrorMessage());
    ((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).j = this.c;
    ((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).b = true;
    ((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).c = true;
    ((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).h = true;
    ((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).a = false;
    ((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).e = ((List)localObject3);
    if (((List)localObject3).size() > 0) {
      localObject1 = (VideoCollectionItem)((List)localObject3).get(((List)localObject3).size() - 1);
    }
    if (localObject1 == null)
    {
      ((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).a = true;
      this.i = true;
    }
    else if ((localMemoryInfoEntry != null) && (((VideoCollectionItem)localObject1).dbIndex >= localMemoryInfoEntry.maxCollectionIndex))
    {
      ((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).a = bool;
      this.i = true;
    }
    else
    {
      ((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).a = false;
    }
    a((List)localObject3, false);
    if (((DateCollectionListPageLoader.GetCollectionListEvent)localObject2).a) {
      localObject1 = "true";
    } else {
      localObject1 = "false";
    }
    SLog.d("Q.qqstory.memories:MemoryDataPuller", "Req first page local data ,isEnd = %s ,spend time = %d", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis() - l) });
    return localObject2;
  }
  
  public void e()
  {
    this.i = false;
    Bosses.get().postJob(new MemoryDataPuller.1(this, "Q.qqstory.memories:MemoryDataPuller"));
  }
  
  public void f()
  {
    this.i = false;
    this.e.a(null, 0);
  }
  
  public boolean isValidate()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller
 * JD-Core Version:    0.7.0.1
 */