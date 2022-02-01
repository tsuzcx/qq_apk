package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.FeedEntry;
import com.tencent.biz.qqstory.database.FeedIdListEntry;
import com.tencent.biz.qqstory.database.MemoriesFeedIdListEntry;
import com.tencent.biz.qqstory.database.TroopAssistantFeedIdListEntry;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.playvideo.dataprovider.GetPollInfoHandlerWithFreqController;
import com.tencent.biz.qqstory.playvideo.preload.CacheHit;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.FeedUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class FeedManager
  implements IManager, IEventReceiver
{
  public static ThreadLocal<SimpleDateFormat> a;
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public int a;
  private long jdField_a_of_type_Long = 0L;
  private OneObjectCacheList<String, FeedItem> jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList = new OneObjectCacheList(300);
  public BasicLocation a;
  private CacheHit jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadCacheHit = new CacheHit("feeItem");
  private FeedCommentBackgroundSyncer jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer = new FeedCommentBackgroundSyncer();
  public FeedListPageLoaderBase.FeedIdListCache a;
  private FeedManager.DeleteVideoEventReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$DeleteVideoEventReceiver;
  private FeedManager.GetFeedFeatureReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$GetFeedFeatureReceiver;
  public ArrayList<StoryHomeFeed> a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public Map<String, String> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public int b;
  public FeedListPageLoaderBase.FeedIdListCache b;
  private ConcurrentHashMap<String, FeedFeatureItem> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  }
  
  public FeedManager()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private FeedEntry a(String paramString)
  {
    paramString = StoryManager.a(QQStoryContext.a().a().createEntityManager(), FeedEntry.class, FeedEntry.class.getSimpleName(), FeedEntry.queryFeedId(), new String[] { paramString });
    if ((paramString != null) && (paramString.size() == 1)) {
      return (FeedEntry)paramString.get(0);
    }
    return null;
  }
  
  private static FeedItem a(boolean paramBoolean, String paramString1, String paramString2)
  {
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    Object localObject2 = localFeedManager.a(paramString1, paramString2);
    SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "find true feedId:%s", localObject2);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = VideoListFeedItem.makeFakeFeedId(paramString1, paramString2);
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "make fake feedId:%s", localObject1);
    }
    localObject2 = localFeedManager.a((String)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramBoolean) {
        paramString1 = ShareGroupFeedItem.createFakeFeedItem(paramString1, paramString2);
      } else {
        paramString1 = GeneralFeedItem.createFakeFeedItem(paramString2);
      }
      localFeedManager.a(paramString1);
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "save fake item %s", paramString1.feedId);
      localObject1 = paramString1;
    }
    return localObject1;
  }
  
  public static GeneralFeedItem a(String paramString1, String paramString2)
  {
    paramString1 = a(false, paramString1, paramString2);
    if ((paramString1 != null) && ((paramString1 instanceof GeneralFeedItem))) {
      return (GeneralFeedItem)paramString1;
    }
    AssertUtils.checkNotNull(paramString1);
    return null;
  }
  
  public static ShareGroupFeedItem a(String paramString1, String paramString2)
  {
    paramString1 = a(true, paramString1, paramString2);
    if ((paramString1 != null) && ((paramString1 instanceof ShareGroupFeedItem))) {
      return (ShareGroupFeedItem)paramString1;
    }
    AssertUtils.fail("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
    return null;
  }
  
  public static VideoListFeedItem a(String paramString1, String paramString2)
  {
    paramString1 = a(true, paramString1, paramString2);
    if ((paramString1 != null) && ((paramString1 instanceof ShareGroupFeedItem))) {
      return (ShareGroupFeedItem)paramString1;
    }
    AssertUtils.fail("feed type wrong for shareGroupItem:%s", new Object[] { paramString1 });
    return null;
  }
  
  public static String a()
  {
    return a().format(new Date(NetConnInfoCenter.getServerTimeMillis()));
  }
  
  public static SimpleDateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat2 = (SimpleDateFormat)jdField_a_of_type_JavaLangThreadLocal.get();
    SimpleDateFormat localSimpleDateFormat1 = localSimpleDateFormat2;
    if (localSimpleDateFormat2 == null)
    {
      localSimpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");
      jdField_a_of_type_JavaLangThreadLocal.set(localSimpleDateFormat1);
    }
    return localSimpleDateFormat1;
  }
  
  private void a(BatchGetFriendStoryFeedInfoRequest paramBatchGetFriendStoryFeedInfoRequest)
  {
    SLog.a("Q.qqstory.home.data.FeedManager", "request feed item list from net, %s", paramBatchGetFriendStoryFeedInfoRequest.b);
    CmdTaskManger.a().a(paramBatchGetFriendStoryFeedInfoRequest, new FeedManager.4(this));
  }
  
  public static void b(String paramString)
  {
    Bosses.get().postLightWeightJob(new FeedManager.1(paramString), 10);
  }
  
  public static void d()
  {
    GetFeedFeatureHandler.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    GetPollInfoHandlerWithFreqController.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public FeedFeatureItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FeedFeatureItem localFeedFeatureItem = (FeedFeatureItem)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$GetFeedFeatureReceiver == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$GetFeedFeatureReceiver = new FeedManager.GetFeedFeatureReceiver(this);
      StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$GetFeedFeatureReceiver);
    }
    new GetFeedFeatureHandler(Collections.singletonList(paramString), true).a();
    SLog.a("Q.qqstory.home.data.FeedManager", "request feed feature : %s", paramString);
    return localFeedFeatureItem;
  }
  
  public FeedCommentBackgroundSyncer a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer;
  }
  
  public FeedItem a(FeedItem paramFeedItem)
  {
    SLog.a("Q.qqstory.home.data.FeedManager", "save feed item %s", paramFeedItem.feedId);
    paramFeedItem = (FeedItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramFeedItem.feedId, paramFeedItem);
    FeedEntry localFeedEntry = paramFeedItem.covertToEntry();
    QQStoryContext.a().a().createEntityManager().persistOrReplace(localFeedEntry);
    return paramFeedItem;
  }
  
  public FeedItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("feedId is null,you cant queryFeedItem:");
      paramString.append(FeedUtils.a(3));
      SLog.e("Q.qqstory.home.data.FeedManager", paramString.toString());
      return null;
    }
    FeedItem localFeedItem = (FeedItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
    Object localObject = localFeedItem;
    if (localFeedItem == null)
    {
      localObject = a(paramString);
      if (localObject == null) {
        return null;
      }
      localFeedItem = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
      if (localFeedItem == null)
      {
        paramString = new StringBuilder();
        paramString.append("这种类型目前还不支持：");
        paramString.append(((FeedEntry)localObject).type);
        SLog.e("Q.qqstory.home.data.FeedManager", paramString.toString());
        return null;
      }
      localFeedItem.covertFromEntry((FeedEntry)localObject);
      localObject = (FeedItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString, localFeedItem);
    }
    return localObject;
  }
  
  @Nullable
  public FeedItem a(@NonNull String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FeedItem localFeedItem = b(paramString);
    if (localFeedItem != null) {
      return localFeedItem;
    }
    Bosses.get().postLightWeightJob(new FeedManager.3(this, paramString, paramBoolean), 0);
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    SLog.a("Q.qqstory.home.data.FeedManager", "query my feedId unionId:%s, date:%s %s", paramString1, paramString2, this.jdField_a_of_type_JavaUtilHashMap);
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return (String)localHashMap.get(localStringBuilder.toString());
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = StoryManager.a(QQStoryContext.a().a().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((FeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public List<StoryVideoItem> a(String paramString, List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    return ((StoryManager)SuperManager.a(5)).a(paramString, 0, paramList, paramBoolean);
  }
  
  public List<FeedItem> a(List<FeedItem> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedItem localFeedItem = (FeedItem)paramList.next();
        localFeedItem = (FeedItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localFeedItem.feedId, localFeedItem);
        localEntityManager.persistOrReplace(localFeedItem.covertToEntry());
        localArrayList.add(localFeedItem);
      }
      localEntityManager.getTransaction().commit();
      localEntityManager.getTransaction().end();
      return localArrayList;
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
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$DeleteVideoEventReceiver = new FeedManager.DeleteVideoEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$DeleteVideoEventReceiver);
  }
  
  public void a(String paramString)
  {
    FeedEntry localFeedEntry = a(paramString);
    if (localFeedEntry != null)
    {
      localFeedEntry.setStatus(1001);
      QQStoryContext.a().a().createEntityManager().remove(localFeedEntry);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localHashMap.put(localStringBuilder.toString(), paramString3);
    SLog.a("Q.qqstory.home.data.FeedManager", "save my feedId %s", this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  public void a(List<FeedIdListSeqInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)paramList.next();
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localFeedIdListSeqInfo.b);
      localStringBuilder.append(localFeedIdListSeqInfo.c);
      localHashMap.put(localStringBuilder.toString(), localFeedIdListSeqInfo.a);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    try
    {
      localEntityManager.drop(FeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        FeedIdListEntry localFeedIdListEntry = new FeedIdListEntry();
        localFeedIdListEntry.feedId = str;
        localEntityManager.persistOrReplace(localFeedIdListEntry);
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
  
  public boolean a(String paramString)
  {
    FeedIdListEntry localFeedIdListEntry = new FeedIdListEntry();
    localFeedIdListEntry.feedId = paramString;
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localFeedIdListEntry.setStatus(1001);
    return localEntityManager.remove(localFeedIdListEntry, "feedId=?", new String[] { paramString });
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = StoryManager.a(QQStoryContext.a().a().createEntityManager(), FeedIdListEntry.class, FeedIdListEntry.class.getSimpleName(), null, null);
    int i = 0;
    if (localList == null) {
      return false;
    }
    boolean bool = false;
    while (i < localList.size())
    {
      FeedIdListEntry localFeedIdListEntry = (FeedIdListEntry)localList.get(i);
      if (localFeedIdListEntry.feedId.equals(paramString1))
      {
        localArrayList.add(paramString2);
        bool = true;
      }
      else
      {
        localArrayList.add(localFeedIdListEntry.feedId);
      }
      i += 1;
    }
    if (bool) {
      a(localArrayList, true);
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SLog.a("Q.qqstory.home.position", "disableAutoRefresh mIsFirstTimeUse:%b, fromOldLeba:%b, hasRedPoint:%b, mLastViewTime:%d", Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(this.jdField_a_of_type_Long));
    if ((!this.jdField_b_of_type_Boolean) && (paramBoolean1) && (!paramBoolean2) && (this.jdField_a_of_type_Long > 0L))
    {
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      long l2 = ((Long)((StoryConfigManager)SuperManager.a(10)).b("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
      SLog.a("Q.qqstory.home.position", "disableAutoRefresh duration:%d, severConfigTime:%d", Long.valueOf(l1), Long.valueOf(l2));
      if (l1 < l2)
      {
        this.jdField_a_of_type_Long = 0L;
        return true;
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    return false;
  }
  
  public FeedItem b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("feedId is null,you cant queryFeedItem:");
      paramString.append(FeedUtils.a(3));
      SLog.e("Q.qqstory.home.data.FeedManager", paramString.toString());
      return null;
    }
    return (FeedItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
  }
  
  public List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = StoryManager.a(QQStoryContext.a().a().createEntityManager(), TroopAssistantFeedIdListEntry.class, TroopAssistantFeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((TroopAssistantFeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public List<StoryHomeFeed> b(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (FeedItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(str);
      paramList = (List<String>)localObject;
      if (localObject == null)
      {
        localObject = a(str);
        if (localObject != null)
        {
          paramList = FeedItem.createFeedItemByType(((FeedEntry)localObject).type);
          if (paramList == null)
          {
            paramList = new StringBuilder();
            paramList.append("这种类型目前还不支持：");
            paramList.append(((FeedEntry)localObject).type);
            SLog.e("Q.qqstory.home.data.FeedManager", paramList.toString());
          }
          else
          {
            paramList.covertFromEntry((FeedEntry)localObject);
            this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(str, paramList);
          }
        }
      }
      else
      {
        localArrayList.add(paramList.generateAndPackageHomeFeedFromDB());
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$GetFeedFeatureReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$GetFeedFeatureReceiver);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$DeleteVideoEventReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager$DeleteVideoEventReceiver);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(@NonNull List<String> paramList)
  {
    Object localObject1 = new BatchGetFriendStoryFeedInfoRequest();
    Iterator localIterator = paramList.iterator();
    paramList = (List<String>)localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      if (a((String)localObject1) == null)
      {
        Object localObject2 = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        if ((localObject2 != null) && (Math.abs(System.currentTimeMillis() - ((Long)localObject2).longValue()) < 300000L))
        {
          SLog.a("Q.qqstory.home.data.FeedManager", "request feed item list, ignore same request %s", localObject1);
        }
        else
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, Long.valueOf(System.currentTimeMillis()));
          localObject2 = new FeedIdListSeqInfo((String)localObject1, 0, "", "");
          paramList.a.add(localObject2);
          paramList.b.add(localObject1);
          if (paramList.a.size() > 3)
          {
            a(paramList);
            paramList = new BatchGetFriendStoryFeedInfoRequest();
          }
        }
      }
    }
    if (paramList.a.size() == 0) {
      return;
    }
    a(paramList);
  }
  
  public void b(List<String> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    try
    {
      localEntityManager.getTransaction().begin();
      if (paramBoolean) {
        localEntityManager.drop(TroopAssistantFeedIdListEntry.class);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        TroopAssistantFeedIdListEntry localTroopAssistantFeedIdListEntry = new TroopAssistantFeedIdListEntry();
        localTroopAssistantFeedIdListEntry.feedId = str;
        localEntityManager.persistOrReplace(localTroopAssistantFeedIdListEntry);
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
  
  public FeedItem c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("feedId is null,you cant queryFeedItem:");
      paramString.append(FeedUtils.a(3));
      SLog.e("Q.qqstory.home.data.FeedManager", paramString.toString());
      return null;
    }
    paramString = a(paramString);
    if (paramString == null) {
      return null;
    }
    Object localObject = FeedItem.createFeedItemByType(paramString.type);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("这种类型目前还不支持：");
      ((StringBuilder)localObject).append(paramString.type);
      SLog.e("Q.qqstory.home.data.FeedManager", ((StringBuilder)localObject).toString());
      return null;
    }
    ((FeedItem)localObject).covertFromEntry(paramString);
    return localObject;
  }
  
  public List<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = StoryManager.a(QQStoryContext.a().a().createEntityManager(), MemoriesFeedIdListEntry.class, MemoriesFeedIdListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((MemoriesFeedIdListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    long l = ((Long)((StoryConfigManager)SuperManager.a(10)).b("key_disable_auto_refresh_time", Long.valueOf(60000L))).longValue();
    ThreadManager.getUIHandler().postDelayed(new FeedManager.2(this), l);
  }
  
  public void c(List<String> paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    try
    {
      localEntityManager.drop(MemoriesFeedIdListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        MemoriesFeedIdListEntry localMemoriesFeedIdListEntry = new MemoriesFeedIdListEntry();
        localMemoriesFeedIdListEntry.feedId = str;
        localEntityManager.persistOrReplace(localMemoriesFeedIdListEntry);
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
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager
 * JD-Core Version:    0.7.0.1
 */