package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
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
  protected OneObjectCacheList a;
  protected VideoCollectionItem.DataSortedComparator a;
  protected OneObjectCacheList b = new OneObjectCacheList(300);
  
  public MemoryManager()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList = new OneObjectCacheList(300);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$DataSortedComparator = new VideoCollectionItem.DataSortedComparator();
  }
  
  protected static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  protected QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public MemoryInfoEntry a(MemoryInfoEntry paramMemoryInfoEntry)
  {
    a(paramMemoryInfoEntry.unionId);
    paramMemoryInfoEntry = (MemoryInfoEntry)this.b.a(paramMemoryInfoEntry.unionId, paramMemoryInfoEntry);
    MemoryInfoEntry localMemoryInfoEntry = new MemoryInfoEntry();
    localMemoryInfoEntry.copy(paramMemoryInfoEntry);
    a().a().createEntityManager().b(localMemoryInfoEntry);
    return localMemoryInfoEntry;
  }
  
  public MemoryInfoEntry a(String paramString)
  {
    MemoryInfoEntry localMemoryInfoEntry = (MemoryInfoEntry)this.b.a(paramString);
    if (localMemoryInfoEntry != null) {
      return localMemoryInfoEntry;
    }
    paramString = a(a().a().createEntityManager(), MemoryInfoEntry.class, MemoryInfoEntry.class.getSimpleName(), MemoryInfoEntry.getUnionIdSelectionNoArg(), new String[] { String.valueOf(paramString) });
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    paramString = (MemoryInfoEntry)paramString.get(0);
    this.b.a(paramString.unionId, paramString);
    return paramString;
  }
  
  public VideoCollectionItem a(@NonNull VideoCollectionItem paramVideoCollectionItem)
  {
    a(paramVideoCollectionItem.key);
    paramVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramVideoCollectionItem.key, paramVideoCollectionItem);
    EntityManager localEntityManager = a().a().createEntityManager();
    if (localEntityManager.a(paramVideoCollectionItem.convertTo())) {
      a(localEntityManager, paramVideoCollectionItem.key, paramVideoCollectionItem.videoVidList, true);
    }
    return paramVideoCollectionItem;
  }
  
  @Nullable
  public VideoCollectionItem a(String paramString)
  {
    AssertUtils.a(paramString);
    if (paramString == null) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject2 = (VideoCollectionItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = a().a().createEntityManager();
    paramString = a((EntityManager)localObject1, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramString });
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    paramString = new VideoCollectionItem((VideoCollectionEntry)paramString.get(0));
    Object localObject2 = a((EntityManager)localObject1, StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), paramString.key });
    if (localObject2 != null)
    {
      localObject1 = (StoryManager)SuperManager.a(5);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((StoryVideoListEntry)((Iterator)localObject2).next()).vid;
        StoryVideoItem localStoryVideoItem = ((StoryManager)localObject1).a(str);
        paramString.videoVidList.add(str);
        paramString.collectionVideoUIItemList.add(new VideoCollectionItem.FakeVideoUIItem(str, localStoryVideoItem));
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString.key, paramString);
    return paramString;
  }
  
  public ArrayList a(String paramString, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a().a().createEntityManager().a(VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), true, VideoCollectionEntry.getUinSelectionNoArgs(), new String[] { paramString }, null, null, "dbIndex asc", null);
    if ((paramString == null) || (paramString.size() == 0)) {
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
    return localArrayList;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = StoryManager.a(QQStoryContext.a().a().createEntityManager(), MemoriesYearNodeEntry.class, MemoriesYearNodeEntry.class.getSimpleName(), null, null);
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
  
  public List a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.videoVidList;
    }
    return new ArrayList();
  }
  
  public List a(String paramString, VideoCollectionItem paramVideoCollectionItem, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = a().a().createEntityManager();
    String str1 = VideoCollectionEntry.getQueryListSql();
    if (paramVideoCollectionItem == null) {}
    for (long l = -1L;; l = paramVideoCollectionItem.dbIndex)
    {
      paramVideoCollectionItem = VideoCollectionEntry.class.getSimpleName();
      String str2 = VideoCollectionEntry.getQueryListSql();
      String str3 = "" + paramLong;
      paramString = localEntityManager.a(VideoCollectionEntry.class, paramVideoCollectionItem, true, str2, new String[] { paramString, String.valueOf(l) }, null, null, "dbIndex asc", str3);
      if (paramString != null) {
        break;
      }
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
  
  public void a(VideoCollectionItem paramVideoCollectionItem)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    paramVideoCollectionItem = a(localEntityManager, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getKeySelectionNoArgs(), new String[] { paramVideoCollectionItem.key });
    if (paramVideoCollectionItem != null)
    {
      paramVideoCollectionItem = paramVideoCollectionItem.iterator();
      while (paramVideoCollectionItem.hasNext())
      {
        VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)paramVideoCollectionItem.next();
        localVideoCollectionEntry.setStatus(1001);
        localEntityManager.b(localVideoCollectionEntry);
      }
    }
  }
  
  protected void a(EntityManager paramEntityManager, String paramString, List paramList, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = new StoryVideoListEntry();
      ((StoryVideoListEntry)localObject).setStatus(1001);
      paramEntityManager.a((Entity)localObject, StoryVideoListEntry.getCollectionSelectionNoArg(), new String[] { String.valueOf(5), paramString });
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
      localStoryVideoListEntry.listType = 5;
      localStoryVideoListEntry.collectionKey = paramString;
      localStoryVideoListEntry.vid = ((String)localObject);
      paramEntityManager.b(localStoryVideoListEntry);
    }
  }
  
  protected void a(List paramList, VideoCollectionItem paramVideoCollectionItem)
  {
    if (paramList.indexOf(paramVideoCollectionItem) > 0) {
      SLog.b("MemoryManager", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
    }
    int i;
    do
    {
      return;
      i = Collections.binarySearch(paramList, paramVideoCollectionItem, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$DataSortedComparator);
    } while (i >= 0);
    paramList.add(-i - 1, paramVideoCollectionItem);
  }
  
  public void a(List paramList, String paramString, boolean paramBoolean)
  {
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    EntityManager localEntityManager = a().a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    Object localObject;
    try
    {
      localEntityTransaction.a();
      if (paramBoolean)
      {
        localObject = a(localEntityManager, VideoCollectionEntry.class, VideoCollectionEntry.class.getSimpleName(), VideoCollectionEntry.getUinSelectionNoArgs(), new String[] { paramString });
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            VideoCollectionEntry localVideoCollectionEntry = (VideoCollectionEntry)((Iterator)localObject).next();
            localVideoCollectionEntry.setStatus(1001);
            localEntityManager.b(localVideoCollectionEntry);
          }
        }
      }
      localObject = a(DateCollectionListPageLoader.a(paramString));
    }
    finally
    {
      localEntityTransaction.b();
    }
    if (localObject == null) {}
    for (paramString = new MemoryInfoEntry(paramString);; paramString = (String)localObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (VideoCollectionItem)paramList.next();
        long l = paramString.maxCollectionIndex + 1L;
        paramString.maxCollectionIndex = l;
        ((VideoCollectionItem)localObject).dbIndex = l;
        localObject = (VideoCollectionItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(((VideoCollectionItem)localObject).key, (Copyable)localObject);
        ((VideoCollectionItem)localObject).videoItemList = localStoryManager.a(((VideoCollectionItem)localObject).videoItemList);
        a(localEntityManager, ((VideoCollectionItem)localObject).key, ((VideoCollectionItem)localObject).videoVidList, true);
        a(((VideoCollectionItem)localObject).key);
        localEntityManager.b(((VideoCollectionItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(((VideoCollectionItem)localObject).key, (Copyable)localObject)).convertTo());
      }
      localEntityTransaction.c();
      a(paramString);
      localEntityTransaction.b();
      return;
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.a().a();
    if (paramBoolean) {}
    try
    {
      localEntityManager.a(MemoriesFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localEntityManager.b(((MomeriesYearNode)paramList.next()).convertTo());
      }
    }
    finally
    {
      localEntityManager.a().b();
    }
    localEntityManager.a().b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(20);
  }
  
  public void b(List paramList, String paramString, boolean paramBoolean)
  {
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    ShareGroupManager localShareGroupManager = (ShareGroupManager)SuperManager.a(7);
    EntityManager localEntityManager = a().a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    try
    {
      localEntityTransaction.a();
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
            localEntityManager.b(localVideoCollectionEntry);
          }
        }
      }
      paramList = paramList.iterator();
    }
    finally
    {
      localEntityTransaction.b();
    }
    while (paramList.hasNext())
    {
      paramString = (ShareGroupCollectionItem)paramList.next();
      paramString = (ShareGroupCollectionItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString.key, paramString);
      paramString.shareGroupItem = localShareGroupManager.a(paramString.shareGroupItem);
      paramString.videoItemList = localStoryManager.a(paramString.videoItemList);
      a(localEntityManager, paramString.key, paramString.videoVidList, true);
      localEntityManager.b(paramString.convertTo());
    }
    localEntityTransaction.c();
    localEntityTransaction.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.MemoryManager
 * JD-Core Version:    0.7.0.1
 */