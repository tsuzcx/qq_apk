package com.tencent.biz.qqstory.model;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.database.OfficialRecommendEntry;
import com.tencent.biz.qqstory.database.StoryEntry;
import com.tencent.biz.qqstory.database.StoryVideoEntry;
import com.tencent.biz.qqstory.database.StoryVideoListEntry;
import com.tencent.biz.qqstory.model.item.RecommendItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList;
import com.tencent.biz.qqstory.playvideo.preload.CacheHit;
import com.tencent.biz.qqstory.storyHome.square.model.SquareFeed.FeedIdVid;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryManager
  implements IManager
{
  protected OneObjectCacheList<String, StoryVideoItem> a;
  private CacheHit a;
  public ArrayList<RecommendItem> a;
  protected OneObjectCacheList<String, StoryItem> b = new OneObjectCacheList(300);
  
  public StoryManager()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList = new OneObjectCacheList(300);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadCacheHit = new CacheHit("videoItem");
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  @Nullable
  private StoryVideoEntry a(EntityManager paramEntityManager, String paramString)
  {
    paramEntityManager = paramEntityManager.query(StoryVideoEntry.class, StoryVideoEntry.class.getSimpleName(), true, StoryVideoEntry.getVidSelectionNoArgs(), new String[] { paramString }, null, null, null, null);
    if ((paramEntityManager != null) && (paramEntityManager.size() == 1)) {
      return (StoryVideoEntry)paramEntityManager.get(0);
    }
    return null;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, paramString3, null, null);
  }
  
  private StoryItem b(String paramString, int paramInt)
  {
    paramString = a(a().a().createEntityManager(), StoryEntry.class, StoryEntry.class.getSimpleName(), StoryEntry.getUidSelectionNoArg(), new String[] { String.valueOf(paramString), String.valueOf(paramInt) });
    if ((paramString != null) && (paramString.size() != 0))
    {
      paramString = new StoryItem((StoryEntry)paramString.get(0));
      return (StoryItem)this.b.a(paramString.key, paramString);
    }
    return null;
  }
  
  public static List<String> b(List<StoryVideoItem> paramList)
  {
    if (paramList == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((StoryVideoItem)paramList.next()).mVid);
    }
    return localArrayList;
  }
  
  public int a(String paramString)
  {
    paramString = a().a().createEntityManager().query(StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), true, StoryVideoListEntry.getRecentUidSelectionNoArg(), new String[] { String.valueOf(paramString) }, null, null, null, null);
    if (paramString == null) {
      return 0;
    }
    return paramString.size();
  }
  
  public int a(String paramString1, String paramString2, String paramString3)
  {
    long l = System.currentTimeMillis();
    EntityManager localEntityManager = a().a().createEntityManager();
    Object localObject2 = localEntityManager.query(StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), true, StoryVideoListEntry.getRecentUidSelectionNoArg(), new String[] { String.valueOf(paramString2) }, null, null, null, null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    int m = ((List)localObject1).size();
    localObject2 = new ArrayList();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      StoryVideoListEntry localStoryVideoListEntry = (StoryVideoListEntry)((List)localObject1).get(i);
      if ((j == 0) && (paramString3.equals(localStoryVideoListEntry.vid)))
      {
        k = 1;
      }
      else
      {
        k = j;
        if (j != 0)
        {
          ((List)localObject2).add(localStoryVideoListEntry.vid);
          k = j;
        }
      }
      i += 1;
    }
    if (j != 0)
    {
      a(paramString2, 1, (List)localObject2, true, localEntityManager);
      i = ((List)localObject2).size();
      SLog.a(paramString1, "uin: %s new unread vid list : %s", paramString2, localObject2);
    }
    else
    {
      i = ((List)localObject1).size();
    }
    SLog.d(paramString1, "watch %s , uin: %s unread count: %d ->  %d ,use time = %d , ", new Object[] { paramString3, paramString2, Integer.valueOf(((List)localObject1).size()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    return i;
  }
  
  public StoryItem a(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      localObject = StoryItem.makeFriendKey(paramString);
    } else {
      localObject = StoryItem.makeRecentKey(paramString);
    }
    Object localObject = (StoryItem)this.b.a(localObject);
    if (localObject != null) {
      return localObject;
    }
    return b(paramString, paramInt);
  }
  
  public StoryItem a(String paramString, int paramInt, StoryItem paramStoryItem)
  {
    a(paramString, paramInt);
    paramString = (StoryItem)this.b.a(paramStoryItem.key, paramStoryItem);
    a().a().createEntityManager().persistOrReplace(paramString.cover2StoryEntry());
    return paramString;
  }
  
  public StoryVideoItem a(StoryVideoItem paramStoryVideoItem)
  {
    return a(paramStoryVideoItem.mVid, paramStoryVideoItem);
  }
  
  @Nullable
  public StoryVideoItem a(String paramString)
  {
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
    if (localStoryVideoItem != null) {
      return localStoryVideoItem;
    }
    localStoryVideoItem = c(paramString);
    if (localStoryVideoItem == null) {
      SLog.a("Q.qqstory.StoryManager", "find vid %s is null", new Object[] { paramString });
    }
    return localStoryVideoItem;
  }
  
  public StoryVideoItem a(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    a(paramString);
    paramStoryVideoItem.mVid = paramString;
    paramString = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("updateStoryVideoItem: insert new into cache ");
      paramString.append(paramStoryVideoItem);
      SLog.b("Q.qqstory.StoryManager", paramString.toString());
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateStoryVideoItem: update cache ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramStoryVideoItem);
      SLog.b("Q.qqstory.StoryManager", localStringBuilder.toString());
    }
    paramString = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramStoryVideoItem.mVid, paramStoryVideoItem);
    a().a().createEntityManager().persistOrReplace(paramString.cover2StoryEntry());
    return paramString;
  }
  
  @Nullable
  public GetStoryPlayerTagInfoRequest.TagInfoBaseVidList a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = a(paramString);
    if ((localObject != null) && (TagItem.TagInfoBase.a(((StoryVideoItem)localObject).mTagInfoBase))) {
      return new GetStoryPlayerTagInfoRequest.TagInfoBaseVidList(paramString, ((StoryVideoItem)localObject).mTagInfoBase, ((StoryVideoItem)localObject).mCompInfoBase, ((StoryVideoItem)localObject).mOALinkInfoJson);
    }
    localObject = new ArrayList(1);
    ((List)localObject).add(paramString);
    GetStoryPlayerTagInfoHandler.a((List)localObject, true);
    return null;
  }
  
  public ArrayList<RecommendItem> a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localObject1 = (ArrayList)a(a().a().createEntityManager(), OfficialRecommendEntry.class, OfficialRecommendEntry.class.getSimpleName(), "", null);
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (OfficialRecommendEntry)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilArrayList.add(new RecommendItem((OfficialRecommendEntry)localObject2));
        }
      }
    }
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject2 = (RecommendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((RecommendItem)localObject2).mIsMarkRead) {
        ((ArrayList)localObject1).add(localObject2);
      }
      i += 1;
    }
    return localObject1;
  }
  
  public List<StoryVideoItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().a().createEntityManager().query(StoryVideoEntry.class, StoryVideoEntry.class.getSimpleName(), false, StoryVideoEntry.getLocalVideo(), null, null, null, null, null);
    if (localObject == null) {
      return localArrayList;
    }
    StoryVideoUploadManager localStoryVideoUploadManager = (StoryVideoUploadManager)SuperManager.a(3);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoEntry localStoryVideoEntry = (StoryVideoEntry)((Iterator)localObject).next();
      if (StoryVideoItem.isFakeVid(localStoryVideoEntry.vid))
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoEntry.vid);
        if (localStoryVideoItem == null)
        {
          int i;
          if (localStoryVideoUploadManager.a(localStoryVideoEntry.vid)) {
            i = 1;
          } else {
            i = 3;
          }
          localStoryVideoEntry.uploadStatus = i;
          localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoEntry.vid, new StoryVideoItem(localStoryVideoEntry)));
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("queryLocalStoryVideo: find one item in cache ");
          localStringBuilder.append(localStoryVideoEntry.vid);
          localStringBuilder.append(", item ");
          localStringBuilder.append(localStoryVideoItem);
          SLog.b("Q.qqstory.StoryManager", localStringBuilder.toString());
          localArrayList.add(localStoryVideoItem);
        }
      }
    }
    return localArrayList;
  }
  
  public List<StoryVideoItem> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = a().a().createEntityManager();
    paramString = localEntityManager.query(StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), true, StoryVideoListEntry.getUserUidSelectionNoArg(), new String[] { String.valueOf(paramString) }, null, null, null, null);
    if (paramString == null) {
      return localArrayList;
    }
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      StoryVideoListEntry localStoryVideoListEntry = (StoryVideoListEntry)localIterator.next();
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoListEntry.vid);
      paramString = localStoryVideoItem;
      if (localStoryVideoItem == null)
      {
        StoryVideoEntry localStoryVideoEntry = a(localEntityManager, localStoryVideoListEntry.vid);
        paramString = localStoryVideoItem;
        if (localStoryVideoEntry != null) {
          paramString = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoListEntry.vid, new StoryVideoItem(localStoryVideoEntry));
        }
      }
      if ((paramString != null) && (!StoryVideoItem.isFakeVid(paramString.mVid))) {
        localArrayList.add(paramString);
      }
    }
    return localArrayList;
  }
  
  public List<StoryVideoItem> a(String paramString, int paramInt, List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return paramList;
    }
    EntityManager localEntityManager = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList(paramList.size());
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      Object localObject;
      if (paramBoolean)
      {
        localObject = new StoryVideoListEntry();
        ((StoryVideoListEntry)localObject).setStatus(1001);
        if (paramInt == 1) {
          localEntityManager.remove((Entity)localObject, StoryVideoListEntry.getRecentUidSelectionNoArg(), new String[] { String.valueOf(paramString) });
        } else {
          localEntityManager.remove((Entity)localObject, StoryVideoListEntry.getUserUidSelectionNoArg(), new String[] { String.valueOf(paramString) });
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (StoryVideoItem)paramList.next();
        a(((StoryVideoItem)localObject).mVid);
        localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(((StoryVideoItem)localObject).mVid, (Copyable)localObject);
        localArrayList.add(localObject);
        localEntityManager.persistOrReplace(((StoryVideoItem)localObject).cover2StoryEntry());
        StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
        localStoryVideoListEntry.unionId = paramString;
        localStoryVideoListEntry.vid = ((StoryVideoItem)localObject).mVid;
        if (paramInt == 1) {
          localStoryVideoListEntry.listType = 3;
        } else {
          localStoryVideoListEntry.listType = 0;
        }
        localEntityManager.persistOrReplace(localStoryVideoListEntry);
      }
      localEntityTransaction.commit();
      localEntityTransaction.end();
      return localArrayList;
    }
    finally
    {
      localEntityTransaction.end();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<StoryVideoItem> a(List<StoryVideoItem> paramList)
  {
    if (paramList == null) {
      return paramList;
    }
    EntityManager localEntityManager = a().a().createEntityManager();
    new ArrayList();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      paramList = a(paramList, localEntityManager);
      localEntityTransaction.commit();
      return paramList;
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
  
  public List<StoryVideoItem> a(List<StoryVideoItem> paramList, EntityManager paramEntityManager)
  {
    if (paramList == null) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      a(localStoryVideoItem.mVid);
      localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoItem.mVid, localStoryVideoItem);
      localArrayList.add(localStoryVideoItem);
      if (localStoryVideoItem.mErrorCode == 0) {
        paramEntityManager.persistOrReplace(localStoryVideoItem.cover2StoryEntry());
      }
    }
    return localArrayList;
  }
  
  public List<StoryVideoItem> a(boolean paramBoolean)
  {
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localList.get(i);
      if ((!localStoryVideoItem.isTroopLocalVideoOnly()) && ((paramBoolean) || (!localStoryVideoItem.isLocalAddShareGroupVideo()))) {
        localArrayList.add(localStoryVideoItem);
      }
      i += 1;
    }
    SLog.d("Q.qqstory.StoryManager", "load my local video count:%d, %s", new Object[] { Integer.valueOf(localList.size()), b(localList) });
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a.remove(paramString);
    EntityManager localEntityManager = a().a().createEntityManager();
    Object localObject = new StoryVideoListEntry();
    ((StoryVideoListEntry)localObject).setStatus(1001);
    localEntityManager.remove((Entity)localObject, StoryVideoListEntry.getVidSelectionNoArg(), new String[] { paramString });
    localObject = new StoryVideoEntry();
    ((StoryVideoEntry)localObject).setStatus(1001);
    localEntityManager.remove((Entity)localObject, StoryVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
  }
  
  public void a(String paramString, int paramInt)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    StoryEntry localStoryEntry = new StoryEntry();
    localStoryEntry.setStatus(1001);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.post(new StoryManager.2(this, localEntityManager, localStoryEntry, paramString, paramInt), 5, null, false);
      return;
    }
    localEntityManager.remove(localStoryEntry, StoryEntry.getUidSelectionNoArg(), new String[] { String.valueOf(paramString), String.valueOf(paramInt) });
  }
  
  public void a(String paramString, int paramInt, List<String> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    EntityManager localEntityManager = a().a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      Object localObject;
      if (paramBoolean)
      {
        localObject = new StoryVideoListEntry();
        ((StoryVideoListEntry)localObject).setStatus(1001);
        if (paramInt == 1) {
          localEntityManager.remove((Entity)localObject, StoryVideoListEntry.getRecentUidSelectionNoArg(), new String[] { String.valueOf(paramString) });
        } else if (paramInt == 0) {
          localEntityManager.remove((Entity)localObject, StoryVideoListEntry.getUserUidSelectionNoArg(), new String[] { String.valueOf(paramString) });
        } else if (paramInt == 3) {
          localEntityManager.remove((Entity)localObject, StoryVideoListEntry.getRecommendBigVSelectionNoArg(), new String[] { String.valueOf(paramString) });
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
        localStoryVideoListEntry.unionId = paramString;
        localStoryVideoListEntry.vid = ((String)localObject);
        if (paramInt == 1) {
          localStoryVideoListEntry.listType = 3;
        } else if (paramInt == 0) {
          localStoryVideoListEntry.listType = 0;
        } else if (paramInt == 3) {
          localStoryVideoListEntry.listType = 7;
        }
        localEntityManager.persistOrReplace(localStoryVideoListEntry);
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
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt, List<String> paramList, boolean paramBoolean, EntityManager paramEntityManager)
  {
    if (paramList == null) {
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = new StoryVideoListEntry();
      ((StoryVideoListEntry)localObject).setStatus(1001);
      if (paramInt == 1) {
        paramEntityManager.remove((Entity)localObject, StoryVideoListEntry.getRecentUidSelectionNoArg(), new String[] { String.valueOf(paramString) });
      } else {
        paramEntityManager.remove((Entity)localObject, StoryVideoListEntry.getUserUidSelectionNoArg(), new String[] { String.valueOf(paramString) });
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
      localStoryVideoListEntry.unionId = paramString;
      localStoryVideoListEntry.vid = ((String)localObject);
      if (paramInt == 1) {
        localStoryVideoListEntry.listType = 3;
      } else {
        localStoryVideoListEntry.listType = 0;
      }
      paramEntityManager.persistOrReplace(localStoryVideoListEntry);
    }
  }
  
  public void a(String paramString, List<SquareFeed.FeedIdVid> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    Object localObject;
    if (paramBoolean)
    {
      localObject = new StoryVideoListEntry();
      ((StoryVideoListEntry)localObject).setStatus(1001);
      localEntityManager.remove((Entity)localObject, StoryVideoListEntry.getSelectionNoArg(), new String[] { String.valueOf(8), paramString });
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (SquareFeed.FeedIdVid)paramList.next();
      StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
      localStoryVideoListEntry.unionId = paramString;
      localStoryVideoListEntry.listType = 8;
      localStoryVideoListEntry.collectionKey = ((SquareFeed.FeedIdVid)localObject).a;
      localStoryVideoListEntry.vid = ((SquareFeed.FeedIdVid)localObject).b;
      localEntityManager.persistOrReplace(localStoryVideoListEntry);
    }
  }
  
  public void a(@NonNull ArrayList<RecommendItem> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      localEntityManager.drop(OfficialRecommendEntry.class);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localEntityManager.persistOrReplace(((RecommendItem)paramArrayList.next()).cover2StoryEntry());
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
      throw paramArrayList;
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).optString("myCacheCount_Max");
      String str1 = ((JSONObject)localObject1).optString("friendCacheCount_Max");
      String str2 = ((JSONObject)localObject1).optString("myCacheCount_Normal");
      String str3 = ((JSONObject)localObject1).optString("friendCacheCount_Normal");
      String str4 = ((JSONObject)localObject1).optString("clearRate_Date");
      String str5 = ((JSONObject)localObject1).optString("preload_Count");
      localObject1 = ((JSONObject)localObject1).optString("preload_friend_count");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("myCacheCountMax = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", friendCacheCount = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(",myCacheCountNormal = ");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(",friendCacheNormal = ");
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append(",clearRateDate = ");
      ((StringBuilder)localObject2).append(str4);
      ((StringBuilder)localObject2).append(",preloadCount = ");
      ((StringBuilder)localObject2).append(str5);
      ((StringBuilder)localObject2).append(",preloadFriendCount = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      SLog.d("Q.qqstory.videoCache", ((StringBuilder)localObject2).toString());
      localObject2 = (StoryConfigManager)SuperManager.a(10);
      if (paramString != null) {
        ((StoryConfigManager)localObject2).b("StoryMyCacheCountMax", Integer.valueOf(paramString));
      }
      if (str1 != null) {
        ((StoryConfigManager)localObject2).b("StoryFriendCacheCountMax", Integer.valueOf(str1));
      }
      if (str2 != null) {
        ((StoryConfigManager)localObject2).b("StoryMyCacheCountNormal", Integer.valueOf(str2));
      }
      if (str3 != null) {
        ((StoryConfigManager)localObject2).b("StoryFriendCacheCountNormal", Integer.valueOf(str3));
      }
      if (str4 != null) {
        ((StoryConfigManager)localObject2).b("StoryClearRate", Long.valueOf(str4));
      }
      if (str5 != null) {
        ((StoryConfigManager)localObject2).b("StoryPreloadCount", Integer.valueOf(str5));
      }
      if (localObject1 != null) {
        ((StoryConfigManager)localObject2).b("StoryPreloadFriendCount", Integer.valueOf((String)localObject1));
      }
      return true;
    }
    catch (JSONException paramString)
    {
      SLog.c("Q.qqstory.videoCache", "Error on parseCacheDataAndSave()", paramString);
    }
    return false;
  }
  
  @Nullable
  @UiThread
  public StoryVideoItem b(String paramString)
  {
    AssertUtils.assertTrue(paramString.startsWith("Loading") ^ true);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isBasicInfoOK())) {
      return localStoryVideoItem;
    }
    Bosses.get().postLightWeightJob(new StoryManager.1(this, paramString), 0);
    return localStoryVideoItem;
  }
  
  public List<String> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a().a().createEntityManager().query(StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), true, StoryVideoListEntry.getUserUidSelectionNoArg(), new String[] { String.valueOf(paramString) }, null, null, null, null);
    if (paramString == null) {
      return localArrayList;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      localArrayList.add(((StoryVideoListEntry)paramString.next()).vid);
    }
    return localArrayList;
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    Bosses.get().postLightWeightJob(new StoryManager.3(this, paramString), 10);
  }
  
  @Nullable
  public StoryVideoItem c(String paramString)
  {
    paramString = a(a().a().createEntityManager(), StoryVideoEntry.class, StoryVideoEntry.class.getSimpleName(), StoryVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
    if ((paramString != null) && (paramString.size() != 0))
    {
      paramString = (StoryVideoEntry)paramString.get(0);
      StoryVideoItem localStoryVideoItem = new StoryVideoItem(paramString);
      return (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString.vid, localStoryVideoItem);
    }
    return null;
  }
  
  public List<String> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a().a().createEntityManager().query(StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), true, StoryVideoListEntry.getRecommendBigVSelectionNoArg(), new String[] { String.valueOf(paramString) }, null, null, null, null);
    if (paramString == null) {
      return localArrayList;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      localArrayList.add(((StoryVideoListEntry)paramString.next()).vid);
    }
    return localArrayList;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(0);
    this.b.a(0);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public List<StoryVideoItem> d(String paramString)
  {
    if (!QQStoryContext.a().a(paramString)) {
      return a(paramString);
    }
    List localList = a(false);
    Object localObject = a(paramString);
    paramString = new HashSet(localList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
      if (paramString.add(localStoryVideoItem)) {
        localList.add(localStoryVideoItem);
      }
    }
    return localList;
  }
  
  public List<String> e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a().a().createEntityManager().query(StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), true, StoryVideoListEntry.getRecentUidSelectionNoArg(), new String[] { String.valueOf(paramString) }, null, null, null, null);
    if (paramString == null) {
      return localArrayList;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      localArrayList.add(((StoryVideoListEntry)paramString.next()).vid);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager
 * JD-Core Version:    0.7.0.1
 */