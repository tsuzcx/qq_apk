package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.database.MemoriesFeedIdListEntry;
import com.tencent.biz.qqstory.database.MemoriesYearNodeEntry;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.database.StoryVideoListEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.DataSortedComparator;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MemoryManager
  implements IManager
{
  protected OneObjectCacheList<String, VideoCollectionItem> a = new OneObjectCacheList(300);
  protected OneObjectCacheList<String, MemoryInfoEntry> b = new OneObjectCacheList(300);
  protected VideoCollectionItem.DataSortedComparator c = new VideoCollectionItem.DataSortedComparator();
  
  protected static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public MemoryInfoEntry a(MemoryInfoEntry paramMemoryInfoEntry)
  {
    c(paramMemoryInfoEntry.unionId);
    paramMemoryInfoEntry = (MemoryInfoEntry)this.b.a(paramMemoryInfoEntry.unionId, paramMemoryInfoEntry);
    MemoryInfoEntry localMemoryInfoEntry = new MemoryInfoEntry();
    localMemoryInfoEntry.copy(paramMemoryInfoEntry);
    d().d().createEntityManager().persistOrReplace(localMemoryInfoEntry);
    return localMemoryInfoEntry;
  }
  
  public VideoCollectionItem a(@NonNull VideoCollectionItem paramVideoCollectionItem)
  {
    a(paramVideoCollectionItem.key);
    paramVideoCollectionItem = (VideoCollectionItem)this.a.a(paramVideoCollectionItem.key, paramVideoCollectionItem);
    EntityManager localEntityManager = d().d().createEntityManager();
    if (localEntityManager.update(paramVideoCollectionItem.convertTo())) {
      a(localEntityManager, paramVideoCollectionItem.key, paramVideoCollectionItem.videoVidList, true);
    }
    return paramVideoCollectionItem;
  }
  
  @Nullable
  public VideoCollectionItem a(String paramString)
  {
    AssertUtils.checkNotNull(paramString);
    StoryManager localStoryManager = null;
    if (paramString == null) {
      return null;
    }
    Object localObject1 = (VideoCollectionItem)this.a.a(paramString);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = d().d().createEntityManager();
    Object localObject2 = a((EntityManager)localObject1, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramString });
    paramString = localStoryManager;
    if (localObject2 != null)
    {
      if (((List)localObject2).size() == 0) {
        return null;
      }
      paramString = new VideoCollectionItem((VideoCollectionEntry)((List)localObject2).get(0));
      localObject1 = a((EntityManager)localObject1, StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), paramString.key });
      if (localObject1 != null)
      {
        localStoryManager = (StoryManager)SuperManager.a(5);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((StoryVideoListEntry)((Iterator)localObject1).next()).vid;
          StoryVideoItem localStoryVideoItem = localStoryManager.a((String)localObject2);
          paramString.videoVidList.add(localObject2);
          paramString.collectionVideoUIItemList.add(new VideoCollectionItem.FakeVideoUIItem((String)localObject2, localStoryVideoItem));
        }
      }
      this.a.a(paramString.key, paramString);
    }
    return paramString;
  }
  
  public ArrayList<String> a(String paramString, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = d().d().createEntityManager().query(VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), true, VideoCollectionEntry.getUinSelectionNoArgs(), new String[] { paramString }, null, null, "dbIndex asc", null);
    if (paramString != null)
    {
      if (paramString.size() == 0) {
        return localArrayList;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)paramString.next();
        if (localVideoCollectionEntry.collectionType == 1)
        {
          localArrayList.add(localVideoCollectionEntry.key);
          paramArrayList.add(localVideoCollectionEntry.feedId);
        }
      }
    }
    return localArrayList;
  }
  
  public List<VideoCollectionItem> a(String paramString, VideoCollectionItem paramVideoCollectionItem, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = d().d().createEntityManager();
    String str1 = VideoCollectionEntry.getQueryListSql();
    long l;
    if (paramVideoCollectionItem == null) {
      l = -1L;
    } else {
      l = paramVideoCollectionItem.dbIndex;
    }
    paramVideoCollectionItem = VideoCollectionEntry.class.getSimpleName();
    String str2 = VideoCollectionEntry.getQueryListSql();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    paramString = localEntityManager.query(VideoCollectionEntry.class, paramVideoCollectionItem, true, str2, new String[] { paramString, String.valueOf(l) }, null, null, "dbIndex asc", (String)localObject);
    if (paramString == null) {
      return localArrayList;
    }
    SLog.a("MemoryManager", "query sql = %s , resultCount = %d", str1, Integer.valueOf(paramString.size()));
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      paramVideoCollectionItem = a(((VideoCollectionEntry)paramString.next()).key);
      if (paramVideoCollectionItem != null) {
        a(localArrayList, paramVideoCollectionItem);
      }
    }
    return localArrayList;
  }
  
  public void a() {}
  
  protected void a(EntityManager paramEntityManager, String paramString, List<String> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = new StoryVideoListEntry();
      ((StoryVideoListEntry)localObject).setStatus(1001);
      paramEntityManager.remove((Entity)localObject, StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), paramString });
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
      localStoryVideoListEntry.listType = 5;
      localStoryVideoListEntry.collectionKey = paramString;
      localStoryVideoListEntry.vid = ((String)localObject);
      paramEntityManager.persistOrReplace(localStoryVideoListEntry);
    }
  }
  
  protected void a(List<VideoCollectionItem> paramList, VideoCollectionItem paramVideoCollectionItem)
  {
    if (paramList.indexOf(paramVideoCollectionItem) > 0)
    {
      SLog.b("MemoryManager", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
      return;
    }
    int i = Collections.binarySearch(paramList, paramVideoCollectionItem, this.c);
    if (i < 0) {
      paramList.add(-i - 1, paramVideoCollectionItem);
    }
  }
  
  public void a(List<VideoCollectionItem> paramList, String paramString, boolean paramBoolean)
  {
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    EntityManager localEntityManager = d().d().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      if (paramBoolean)
      {
        localObject1 = a(localEntityManager, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getUinSelectionNoArgs(), new String[] { paramString });
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (VideoCollectionEntry)((Iterator)localObject1).next();
            ((VideoCollectionEntry)localObject2).setStatus(1001);
            localEntityManager.remove((Entity)localObject2);
          }
        }
      }
      Object localObject2 = c(DateCollectionListPageLoader.b(paramString));
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new MemoryInfoEntry(paramString);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString = (VideoCollectionItem)paramList.next();
        long l = ((MemoryInfoEntry)localObject1).maxCollectionIndex + 1L;
        ((MemoryInfoEntry)localObject1).maxCollectionIndex = l;
        paramString.dbIndex = l;
        paramString = (VideoCollectionItem)this.a.a(paramString.key, paramString);
        paramString.videoItemList = localStoryManager.a(paramString.videoItemList);
        a(localEntityManager, paramString.key, paramString.videoVidList, true);
        a(paramString.key);
        localEntityManager.persistOrReplace(((VideoCollectionItem)this.a.a(paramString.key, paramString)).convertTo());
      }
      localEntityTransaction.commit();
      a((MemoryInfoEntry)localObject1);
      localEntityTransaction.end();
      return;
    }
    finally
    {
      localEntityTransaction.end();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(List<MomeriesYearNode> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().d().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    try
    {
      localEntityManager.drop(MemoriesFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localEntityManager.persistOrReplace(((MomeriesYearNode)paramList.next()).convertTo());
      }
      localEntityManager.getTransaction().commit();
      localEntityManager.getTransaction().end();
      return;
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public List<String> b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.videoVidList;
    }
    return new ArrayList();
  }
  
  public void b()
  {
    this.a.a(20);
  }
  
  public void b(VideoCollectionItem paramVideoCollectionItem)
  {
    EntityManager localEntityManager = d().d().createEntityManager();
    paramVideoCollectionItem = a(localEntityManager, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramVideoCollectionItem.key });
    if (paramVideoCollectionItem != null)
    {
      paramVideoCollectionItem = paramVideoCollectionItem.iterator();
      while (paramVideoCollectionItem.hasNext())
      {
        VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)paramVideoCollectionItem.next();
        localVideoCollectionEntry.setStatus(1001);
        localEntityManager.remove(localVideoCollectionEntry);
      }
    }
  }
  
  public void b(List<ShareGroupCollectionItem> paramList, String paramString, boolean paramBoolean)
  {
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    ShareGroupManager localShareGroupManager = (ShareGroupManager)SuperManager.a(7);
    EntityManager localEntityManager = d().d().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      if (paramBoolean)
      {
        paramString = a(localEntityManager, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), "unionId=? and collectionType=?", new String[] { paramString, String.valueOf(4) });
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)paramString.next();
            localVideoCollectionEntry.setStatus(1001);
            localEntityManager.remove(localVideoCollectionEntry);
          }
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString = (ShareGroupCollectionItem)paramList.next();
        paramString = (ShareGroupCollectionItem)this.a.a(paramString.key, paramString);
        paramString.shareGroupItem = localShareGroupManager.a(paramString.shareGroupItem);
        paramString.videoItemList = localStoryManager.a(paramString.videoItemList);
        a(localEntityManager, paramString.key, paramString.videoVidList, true);
        localEntityManager.persistOrReplace(paramString.convertTo());
      }
      localEntityTransaction.commit();
      localEntityTransaction.end();
      return;
    }
    finally
    {
      localEntityTransaction.end();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public MemoryInfoEntry c(String paramString)
  {
    MemoryInfoEntry localMemoryInfoEntry = (MemoryInfoEntry)this.b.a(paramString);
    if (localMemoryInfoEntry != null) {
      return localMemoryInfoEntry;
    }
    paramString = a(d().d().createEntityManager(), MemoryInfoEntry.class, MemoryInfoEntry.class.getSimpleName(), MemoryInfoEntry.getUnionIdSelectionNoArg(), new String[] { String.valueOf(paramString) });
    if ((paramString != null) && (paramString.size() != 0))
    {
      paramString = (MemoryInfoEntry)paramString.get(0);
      this.b.a(paramString.unionId, paramString);
      return paramString;
    }
    return null;
  }
  
  public List<MomeriesYearNode> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = StoryManager.a(QQStoryContext.a().d().createEntityManager(), MemoriesYearNodeEntry.class, MemoriesYearNodeEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MemoriesYearNodeEntry localMemoriesYearNodeEntry = (MemoriesYearNodeEntry)((Iterator)localObject).next();
      MomeriesYearNode localMomeriesYearNode = new MomeriesYearNode();
      localMomeriesYearNode.convertFrom(localMemoriesYearNodeEntry);
      localArrayList.add(localMomeriesYearNode);
    }
    return localArrayList;
  }
  
  protected QQStoryContext d()
  {
    return QQStoryContext.a();
  }
  
  public List<ShareGroupCollectionItem> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(d().d().createEntityManager(), VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), "unionId=? and collectionType=?", new String[] { paramString, String.valueOf(4) });
    if (paramString == null) {
      return localArrayList;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      ShareGroupCollectionItem localShareGroupCollectionItem = e(((VideoCollectionEntry)paramString.next()).key);
      if (localShareGroupCollectionItem != null) {
        localArrayList.add(localShareGroupCollectionItem);
      }
    }
    return localArrayList;
  }
  
  public ShareGroupCollectionItem e(String paramString)
  {
    AssertUtils.checkNotNull(paramString);
    if (paramString == null) {
      return null;
    }
    Object localObject = (ShareGroupCollectionItem)this.a.a(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = d().d().createEntityManager();
    paramString = a((EntityManager)localObject, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramString });
    if (paramString != null)
    {
      if (paramString.size() == 0) {
        return null;
      }
      ShareGroupCollectionItem localShareGroupCollectionItem = new ShareGroupCollectionItem((VideoCollectionEntry)paramString.get(0));
      paramString = ((ShareGroupManager)SuperManager.a(7)).a(localShareGroupCollectionItem.groupId);
      if (paramString == null) {
        return null;
      }
      localShareGroupCollectionItem.shareGroupItem = paramString;
      paramString = a((EntityManager)localObject, StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), localShareGroupCollectionItem.key });
      if (paramString != null)
      {
        StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          StoryVideoListEntry localStoryVideoListEntry = (StoryVideoListEntry)localIterator.next();
          localObject = localStoryManager.a(localStoryVideoListEntry.vid);
          paramString = (String)localObject;
          if (localObject == null)
          {
            paramString = new StoryVideoItem();
            paramString.mVid = localStoryVideoListEntry.vid;
          }
          localShareGroupCollectionItem.videoVidList.add(localStoryVideoListEntry.vid);
          localShareGroupCollectionItem.videoItemList.add(paramString);
        }
      }
      this.a.a(localShareGroupCollectionItem.key, localShareGroupCollectionItem);
      return localShareGroupCollectionItem;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.MemoryManager
 * JD-Core Version:    0.7.0.1
 */