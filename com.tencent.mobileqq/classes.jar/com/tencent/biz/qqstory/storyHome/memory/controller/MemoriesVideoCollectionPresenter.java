package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.DataSortedComparator;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MemoriesVideoCollectionPresenter
  implements IEventReceiver
{
  public String a;
  public boolean b = false;
  public ErrorMessage c = null;
  public ArrayList<VideoCollectionItem> d = new ArrayList();
  public int e = -1;
  public boolean f = true;
  private VideoCollectionItem.DataSortedComparator g = new VideoCollectionItem.DataSortedComparator();
  private AtomicBoolean h = new AtomicBoolean(false);
  private MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener i;
  private MemoryDataPuller j;
  private MemoriesVideoCollectionPresenter.GetCollectListEventReceiver k;
  private MemoriesVideoCollectionPresenter.GetSimpleInfoListEventReceiver l;
  
  public MemoriesVideoCollectionPresenter(String paramString, @NonNull MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener paramVideoCollectionPresenterEventListener)
  {
    this.a = paramString;
    this.i = paramVideoCollectionPresenterEventListener;
  }
  
  private void a(VideoCollectionItem paramVideoCollectionItem)
  {
    if (this.d.indexOf(paramVideoCollectionItem) > 0)
    {
      SLog.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
      return;
    }
    int m = Collections.binarySearch(this.d, paramVideoCollectionItem, this.g);
    if (m < 0)
    {
      m = -m;
      this.d.add(m - 1, paramVideoCollectionItem);
    }
  }
  
  public void a()
  {
    this.k = new MemoriesVideoCollectionPresenter.GetCollectListEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.k);
    this.l = new MemoriesVideoCollectionPresenter.GetSimpleInfoListEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.l);
  }
  
  public void a(String paramString)
  {
    SLog.c("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request video info list.");
    this.j.a(paramString);
  }
  
  public void a(List<String> paramList)
  {
    SLog.c("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request visit count.");
    this.j.b(paramList, true);
  }
  
  public void a(List<VideoCollectionItem> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.d.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((VideoCollectionItem)paramList.next());
    }
    if ((this.d.size() > 0) && (paramBoolean2))
    {
      paramList = ((UserManager)SuperManager.a(2)).b(this.a);
      if ((paramList != null) && (!paramList.isMe()) && (!paramList.isFriend()) && (!paramList.isVip))
      {
        paramList = new VideoCollectionItem();
        paramList.collectionType = 8;
        paramList.collectionId = "";
        paramList.collectionTime = -1L;
        paramList.key = "local_desc_item";
        paramList.isEmptyFakeItem = true;
        this.d.add(paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request refresh video collection data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (this.j == null)
    {
      this.j = new MemoryDataPuller(this.a, String.valueOf(hashCode()));
      this.j.b();
    }
    if (paramBoolean)
    {
      DateCollectionListPageLoader.GetCollectionListEvent localGetCollectionListEvent = this.j.d();
      a(localGetCollectionListEvent.e, localGetCollectionListEvent.c, localGetCollectionListEvent.a);
      this.f = localGetCollectionListEvent.a;
      if (this.d.size() > 0) {
        this.b = true;
      }
      SLog.a("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "get video collection data from cache: collectionList.size() = %d.", Integer.valueOf(this.d.size()));
      return;
    }
    this.j.f();
  }
  
  public void b()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.k);
    StoryDispatcher.a().unRegisterSubscriber(this.l);
    MemoryDataPuller localMemoryDataPuller = this.j;
    if (localMemoryDataPuller != null) {
      localMemoryDataPuller.c();
    }
    this.h.set(true);
  }
  
  public void c()
  {
    SLog.c("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request load next page video collection.");
    this.j.a(d());
  }
  
  public VideoCollectionItem d()
  {
    if (this.d.size() > 0)
    {
      Object localObject = this.d;
      localObject = (VideoCollectionItem)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (((VideoCollectionItem)localObject).isEmptyFakeItem)
      {
        if (this.d.size() >= 2)
        {
          localObject = this.d;
          localObject = (VideoCollectionItem)((ArrayList)localObject).get(((ArrayList)localObject).size() - 2);
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject).collectionId)) {
            return localObject;
          }
        }
      }
      else if (!TextUtils.isEmpty(((VideoCollectionItem)localObject).collectionId)) {
        return localObject;
      }
    }
    return null;
  }
  
  public boolean isValidate()
  {
    return this.h.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter
 * JD-Core Version:    0.7.0.1
 */