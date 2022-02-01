package com.tencent.biz.qqstory.album;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.flter.BaseAlbumFilter;
import com.tencent.biz.qqstory.album.model.GeoHashPhotoGroup;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.segment.Album2DBSegment;
import com.tencent.biz.qqstory.album.segment.AlbumSplitSegment;
import com.tencent.biz.qqstory.album.segment.GalleryScanSegment;
import com.tencent.biz.qqstory.album.segment.PreProcessSegment;
import com.tencent.biz.qqstory.album.segment.ScanInfo;
import com.tencent.biz.qqstory.album.strategy.SplitConfig.TreeGatherConfig;
import com.tencent.biz.qqstory.album.tools.GeoHashUtils.Gps;
import com.tencent.biz.qqstory.album.tools.kmeans.DateKmeans;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.model.ITrimmable;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class StoryScanManager
  extends BaseManger
  implements ITrimmable
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private StoryAlbumConfig jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig;
  private StoryConfigManager jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = null;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  
  public static String a(@NonNull List<StoryAlbum> paramList)
  {
    if (paramList.isEmpty()) {
      return "";
    }
    paramList = paramList.iterator();
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    if (paramList.hasNext())
    {
      int i1;
      int i2;
      switch (((StoryAlbum)paramList.next()).jdField_a_of_type_Int)
      {
      case 5: 
      default: 
        i1 = n;
        i2 = m;
        n = i;
        m = j;
        j = i2;
        i = i1;
      }
      for (;;)
      {
        i1 = n;
        i2 = m;
        n = i;
        m = j;
        j = i2;
        i = i1;
        break;
        i1 = j;
        i2 = i + 1;
        i = n;
        j = m;
        m = i1;
        n = i2;
        continue;
        i2 = j + 1;
        i1 = i;
        i = n;
        j = m;
        m = i2;
        n = i1;
        continue;
        k += 1;
        i1 = j;
        i2 = i;
        i = n;
        j = m;
        m = i1;
        n = i2;
        continue;
        i2 = m + 1;
        m = j;
        i1 = i;
        i = n;
        j = i2;
        n = i1;
        continue;
        i2 = n + 1;
        n = j;
        i1 = i;
        i = i2;
        j = m;
        m = n;
        n = i1;
      }
    }
    paramList = new StringBuilder("{");
    paramList.append("\"festival\":").append(i).append(",");
    paramList.append("\"birthday\":").append(j).append(",");
    paramList.append("\"frequent\":").append(k).append(",");
    paramList.append("\"unfrequent\":").append(m).append(",");
    paramList.append("\"aboard\":").append(n).append(",");
    paramList.append("}");
    return paramList.toString();
  }
  
  public static List<StoryAlbum.PicInfo> a(StoryAlbum paramStoryAlbum, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramStoryAlbum.a();
    if (localList.size() < paramInt)
    {
      localArrayList.addAll(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StoryAlbum.PicInfo)((Iterator)localObject1).next()).a(true);
      }
      paramStoryAlbum.a(localList);
      return localArrayList;
    }
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryAlbum.PicInfo)((Iterator)localObject1).next();
      if (((StoryAlbum.PicInfo)localObject2).a()) {
        ((StoryAlbum.PicInfo)localObject2).a(false);
      }
    }
    localObject1 = new DateKmeans();
    ((DateKmeans)localObject1).a(localList);
    localObject1 = ((DateKmeans)localObject1).a(paramInt, null, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      ((StoryAlbum.PicInfo)((List)localObject2).get(0)).a(true);
      localArrayList.add(((List)localObject2).get(0));
    }
    paramStoryAlbum.a(localList);
    return localArrayList;
  }
  
  public static List<GeoHashUtils.Gps> a(@NonNull HashMap<String, GeoHashPhotoGroup> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      GeoHashPhotoGroup localGeoHashPhotoGroup = (GeoHashPhotoGroup)((Map.Entry)paramHashMap.next()).getValue();
      if (localGeoHashPhotoGroup.a != null) {
        localArrayList.add(localGeoHashPhotoGroup.a);
      }
    }
    return localArrayList;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "saveScanTime lastDateAlbumTime=" + paramLong1 + " ,lastScanPictureTime=" + paramLong2);
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    localStoryConfigManager.b("key_last_pic_scan_time", Long.valueOf(paramLong2));
    localStoryConfigManager.b("key_last_date_album_time", Long.valueOf(paramLong1));
    localStoryConfigManager.b("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  private void a(ScanInfo paramScanInfo)
  {
    Object localObject1 = (StoryConfigManager)SuperManager.a(10);
    if ((TextUtils.isEmpty(paramScanInfo.a)) || (TextUtils.isEmpty(paramScanInfo.b)))
    {
      localObject2 = (String)((StoryConfigManager)localObject1).b("key_album_debug_k", "");
      localObject1 = (String)((StoryConfigManager)localObject1).b("key_album_debug_sse", "");
      SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "保存K means 的调试信息失败:" + paramScanInfo.a + " 和 " + paramScanInfo.b);
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + (String)localObject1 + " time info:" + (String)localObject2);
      return;
    }
    if (paramScanInfo.a())
    {
      ((StoryConfigManager)localObject1).b("key_album_debug_k", paramScanInfo.a);
      ((StoryConfigManager)localObject1).b("key_album_debug_sse", paramScanInfo.b);
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramScanInfo.b + " time info:" + paramScanInfo.a);
      return;
    }
    Object localObject2 = paramScanInfo.a.split(";");
    paramScanInfo = paramScanInfo.b.split(";");
    ((StoryConfigManager)localObject1).b("key_album_debug_k", localObject2[0]);
    ((StoryConfigManager)localObject1).b("key_album_debug_sse", paramScanInfo[0]);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramScanInfo[0] + " time info:" + localObject2[0]);
  }
  
  public static void a(List<StoryAlbum> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Collections.sort(paramList, new StoryScanManager.2());
  }
  
  public static void b(@NonNull List<StoryAlbum.PicInfo> paramList)
  {
    Collections.sort(paramList, new StoryScanManager.3());
  }
  
  public StoryAlbumConfig a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig;
  }
  
  public List<StoryAlbum> a()
  {
    ArrayList localArrayList = new ArrayList();
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    long l = ((Long)localStoryConfigManager.b("key_last_home_time", Long.valueOf(-1L))).longValue();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    Object localObject = StoryManager.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return localArrayList;
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject).get(0)).startTime), Long.valueOf(l) });
    if (((StoryAlbumEntry)((List)localObject).get(0)).startTime <= l) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      StoryAlbum localStoryAlbum;
      try
      {
        localStoryAlbum = StoryAlbum.a(localStoryAlbumEntry);
        if (!localStoryAlbum.c()) {
          break label241;
        }
        localArrayList.add(localStoryAlbum);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        AssertUtils.a("getNewStoryAlbum DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label241:
      SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum we find the illegal album and deleted it : " + localStoryAlbum);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (((StoryAlbum)localArrayList.get(0)).f() <= l)
    {
      localArrayList.clear();
      return localArrayList;
    }
    localStoryConfigManager.b("key_last_home_time", Long.valueOf(((StoryAlbum)localArrayList.get(0)).f()));
    return localArrayList;
  }
  
  public List<BaseAlbumFilter> a(long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.a(paramLong1, paramLong2);
  }
  
  @NonNull
  public List<StoryAlbum.PicInfo> a(Context paramContext)
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    long l = ((Long)localStoryConfigManager.b("key_story_home_scan_time", Long.valueOf(-1L))).longValue();
    paramContext = a(paramContext, Math.max(System.currentTimeMillis() / 1000L - 259200L, l));
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewScanPicList  result=" + paramContext);
    if (paramContext.size() >= 10)
    {
      localStoryConfigManager.b("key_story_home_scan_time", Long.valueOf(((StoryAlbum.PicInfo)paramContext.get(0)).b));
      return paramContext;
    }
    return null;
  }
  
  @NonNull
  public List<StoryAlbum.PicInfo> a(Context paramContext, long paramLong)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewPicList scan time = " + paramLong);
    new ArrayList();
    return new ScanTask().a(paramContext, 1L + paramLong, false, 500);
  }
  
  public void a()
  {
    ((TrimmableManager)SuperManager.a(26)).a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig = new StoryAlbumConfig();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
    case 1: 
      do
      {
        return;
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      return;
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2;
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (paramBoolean)
    {
      i = 2;
      ((TroopMemberApiClient)localObject).b(i);
      localObject = (StoryConfigManager)SuperManager.a(10);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = 1)
    {
      ((StoryConfigManager)localObject).b("sp_key_user_enable_album_scan", Integer.valueOf(i));
      return;
      i = 1;
      break;
    }
  }
  
  public boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i == 0) || (i == -1)) {
      return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.b();
    }
    return i != 1;
  }
  
  public boolean a(long paramLong)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramLong);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool, "It is not allowed to deleted the id<0");
      EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
      StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
      localStoryAlbumEntry.setId(paramLong);
      localStoryAlbumEntry.setStatus(1001);
      return localEntityManager.remove(localStoryAlbumEntry);
    }
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig != null) && (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.a()))
    {
      bool2 = true;
      if (Build.VERSION.SDK_INT < 18) {
        break label132;
      }
    }
    label132:
    for (boolean bool3 = true;; bool3 = false)
    {
      boolean bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        if (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
          bool1 = true;
        }
      }
      for (;;)
      {
        label50:
        if ((bool3) && (bool1) && (bool2)) {}
        for (boolean bool4 = true;; bool4 = false)
        {
          SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          return bool4;
          bool2 = false;
          break;
          bool1 = false;
          break label50;
        }
        bool1 = true;
      }
    }
  }
  
  public boolean a(StoryAlbum paramStoryAlbum)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramStoryAlbum);
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    paramStoryAlbum = paramStoryAlbum.a();
    paramStoryAlbum.setStatus(1001);
    return localEntityManager.update(paramStoryAlbum);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.b(paramString);
  }
  
  public boolean a(@NonNull List<StoryAlbum> paramList, boolean paramBoolean)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb albums=" + paramList.size() + " append=" + paramBoolean);
    boolean bool;
    if (!paramList.isEmpty()) {
      bool = true;
    }
    EntityManager localEntityManager;
    for (;;)
    {
      AssertUtils.a(bool, "It is not allow save the empty albums to DB ");
      localEntityManager = QQStoryContext.a().a().createEntityManager();
      localEntityManager.getTransaction().begin();
      if (!paramBoolean) {
        localEntityManager.drop(StoryAlbumEntry.class);
      }
      try
      {
        paramList = paramList.iterator();
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label226;
          }
          StoryAlbum localStoryAlbum = (StoryAlbum)paramList.next();
          localStoryAlbumEntry = localStoryAlbum.a();
          if (localStoryAlbumEntry.getId() <= 0L) {
            break;
          }
          localStoryAlbumEntry.setStatus(1001);
          if (!localEntityManager.update(localStoryAlbumEntry))
          {
            localStoryAlbumEntry.setStatus(1000);
            localEntityManager.persistOrReplace(localStoryAlbumEntry);
          }
          localStoryAlbum.a(localStoryAlbumEntry.getId());
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          StoryAlbumEntry localStoryAlbumEntry;
          SLog.c("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb exception=%s", paramList);
          return false;
          bool = false;
          break;
          localEntityManager.persistOrReplace(localStoryAlbumEntry);
        }
      }
      finally
      {
        localEntityManager.getTransaction().end();
      }
    }
    label226:
    localEntityManager.getTransaction().commit();
    localEntityManager.getTransaction().end();
    return true;
  }
  
  public List<StoryAlbum> b()
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    Object localObject = StoryManager.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      StoryAlbum localStoryAlbum;
      try
      {
        localStoryAlbum = StoryAlbum.a(localStoryAlbumEntry);
        if (!localStoryAlbum.c()) {
          break label144;
        }
        if (localStoryAlbum.c() < 2) {
          a(localStoryAlbum, 10);
        }
        localArrayList.add(localStoryAlbum);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        AssertUtils.a("DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label144:
      SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB we find the illegal album and deleted it : " + localStoryAlbum);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localEntityManager.remove(localInvalidProtocolBufferMicroException);
    }
    a(localArrayList);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB reslut=" + localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    ((TrimmableManager)SuperManager.a(26)).b(this);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
  }
  
  public boolean b(Context paramContext)
  {
    if (a(paramContext)) {
      return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.c();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.a(paramString);
  }
  
  public List<SplitConfig.TreeGatherConfig> c()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan task is running so ignore this request.");
      return;
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "start scan");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 1;
    ScanInfo localScanInfo = new ScanInfo();
    Context localContext = QQStoryContext.a().a().getBaseContext();
    Stream.of(Integer.valueOf(0)).map(new ThreadOffFunction("Q.qqstory.recommendAlbum.logic.StoryScanManager", 2)).map(new GalleryScanSegment(localContext, localScanInfo)).map(new PreProcessSegment(localScanInfo)).map(new AlbumSplitSegment(localScanInfo)).map(new Album2DBSegment(localScanInfo)).subscribe(new StoryScanManager.1(this, localScanInfo));
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.c();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryScanManager
 * JD-Core Version:    0.7.0.1
 */