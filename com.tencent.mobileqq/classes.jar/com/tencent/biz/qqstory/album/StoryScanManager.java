package com.tencent.biz.qqstory.album;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.flter.BaseAlbumFilter;
import com.tencent.biz.qqstory.album.model.GeoHashPhotoGroup;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
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
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
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
    while (paramList.hasNext())
    {
      int i1 = ((StoryAlbum)paramList.next()).jdField_a_of_type_Int;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 == 6) {
                m += 1;
              }
            }
            else {
              j += 1;
            }
          }
          else {
            i += 1;
          }
        }
        else {
          k += 1;
        }
      }
      else {
        n += 1;
      }
    }
    paramList = new StringBuilder("{");
    paramList.append("\"festival\":");
    paramList.append(n);
    paramList.append(",");
    paramList.append("\"birthday\":");
    paramList.append(m);
    paramList.append(",");
    paramList.append("\"frequent\":");
    paramList.append(k);
    paramList.append(",");
    paramList.append("\"unfrequent\":");
    paramList.append(j);
    paramList.append(",");
    paramList.append("\"aboard\":");
    paramList.append(i);
    paramList.append(",");
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveScanTime lastDateAlbumTime=");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" ,lastScanPictureTime=");
    ((StringBuilder)localObject).append(paramLong2);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", ((StringBuilder)localObject).toString());
    localObject = (StoryConfigManager)SuperManager.a(10);
    ((StoryConfigManager)localObject).b("key_last_pic_scan_time", Long.valueOf(paramLong2));
    ((StoryConfigManager)localObject).b("key_last_date_album_time", Long.valueOf(paramLong1));
    ((StoryConfigManager)localObject).b("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  private void a(ScanInfo paramScanInfo)
  {
    Object localObject2 = (StoryConfigManager)SuperManager.a(10);
    if ((!TextUtils.isEmpty(paramScanInfo.a)) && (!TextUtils.isEmpty(paramScanInfo.b)))
    {
      if (paramScanInfo.a())
      {
        ((StoryConfigManager)localObject2).b("key_album_debug_k", paramScanInfo.a);
        ((StoryConfigManager)localObject2).b("key_album_debug_sse", paramScanInfo.b);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sp K means debug sse info:");
        ((StringBuilder)localObject1).append(paramScanInfo.b);
        ((StringBuilder)localObject1).append(" time info:");
        ((StringBuilder)localObject1).append(paramScanInfo.a);
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", ((StringBuilder)localObject1).toString());
        return;
      }
      localObject1 = paramScanInfo.a.split(";");
      paramScanInfo = paramScanInfo.b.split(";");
      ((StoryConfigManager)localObject2).b("key_album_debug_k", localObject1[0]);
      ((StoryConfigManager)localObject2).b("key_album_debug_sse", paramScanInfo[0]);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sp K means debug sse info:");
      ((StringBuilder)localObject2).append(paramScanInfo[0]);
      ((StringBuilder)localObject2).append(" time info:");
      ((StringBuilder)localObject2).append(localObject1[0]);
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject1 = (String)((StoryConfigManager)localObject2).b("key_album_debug_k", "");
    localObject2 = (String)((StoryConfigManager)localObject2).b("key_album_debug_sse", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("保存K means 的调试信息失败:");
    localStringBuilder.append(paramScanInfo.a);
    localStringBuilder.append(" 和 ");
    localStringBuilder.append(paramScanInfo.b);
    SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", localStringBuilder.toString());
    paramScanInfo = new StringBuilder();
    paramScanInfo.append("sp K means debug sse info:");
    paramScanInfo.append((String)localObject2);
    paramScanInfo.append(" time info:");
    paramScanInfo.append((String)localObject1);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", paramScanInfo.toString());
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
    Object localObject1 = StoryManager.a(localEntityManager, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return localArrayList;
      }
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject1).get(0)).startTime), Long.valueOf(l) });
      if (((StoryAlbumEntry)((List)localObject1).get(0)).startTime <= l) {
        return localArrayList;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject1).next();
        try
        {
          localObject2 = StoryAlbum.a(localStoryAlbumEntry);
          if (((StoryAlbum)localObject2).b())
          {
            localArrayList.add(localObject2);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getNewStoryAlbum we find the illegal album and deleted it : ");
            localStringBuilder.append(localObject2);
            SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", localStringBuilder.toString());
            localStoryAlbumEntry.setStatus(1001);
            localEntityManager.remove(localStoryAlbumEntry);
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getNewStoryAlbum DB info have error:");
          ((StringBuilder)localObject2).append(localInvalidProtocolBufferMicroException);
          AssertUtils.fail(((StringBuilder)localObject2).toString(), new Object[0]);
        }
      }
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
      if (localArrayList.isEmpty()) {
        return localArrayList;
      }
      if (((StoryAlbum)localArrayList.get(0)).e() <= l)
      {
        localArrayList.clear();
        return localArrayList;
      }
      localStoryConfigManager.b("key_last_home_time", Long.valueOf(((StoryAlbum)localArrayList.get(0)).e()));
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getNewScanPicList  result=");
    localStringBuilder.append(paramContext);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getNewPicList scan time = ");
    localStringBuilder.append(paramLong);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", localStringBuilder.toString());
    new ArrayList();
    return new ScanTask().a(paramContext, paramLong + 1L, false, 500);
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
        return;
      }
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      paramInt = Build.VERSION.SDK_INT;
    }
  }
  
  public boolean a()
  {
    StoryConfigManager localStoryConfigManager = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
    boolean bool = false;
    int i = ((Integer)localStoryConfigManager.b("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i != 0) && (i != -1))
    {
      if (i != 1) {
        bool = true;
      }
      return bool;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.b();
  }
  
  public boolean a(Context paramContext)
  {
    StoryAlbumConfig localStoryAlbumConfig = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig;
    boolean bool1;
    if ((localStoryAlbumConfig != null) && (localStoryAlbumConfig.a())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 18) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0)) {
      bool3 = false;
    } else {
      bool3 = true;
    }
    boolean bool4;
    if ((bool2) && (bool3) && (bool1)) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
    return bool4;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.b(paramString);
  }
  
  /* Error */
  public boolean a(@NonNull List<StoryAlbum> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 55	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w 440
    //   12: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: aload_1
    //   18: invokeinterface 99 1 0
    //   23: invokevirtual 69	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: ldc_w 442
    //   31: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: iload_2
    //   37: invokevirtual 445	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 165
    //   43: aload_3
    //   44: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 171	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokeinterface 35 1 0
    //   56: iconst_1
    //   57: ixor
    //   58: ldc_w 447
    //   61: invokestatic 451	com/tencent/biz/qqstory/utils/AssertUtils:assertTrue	(ZLjava/lang/String;)V
    //   64: invokestatic 272	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   67: invokevirtual 275	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   70: invokevirtual 281	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   73: astore_3
    //   74: aload_3
    //   75: invokevirtual 455	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   78: invokevirtual 460	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   81: iload_2
    //   82: ifne +11 -> 93
    //   85: aload_3
    //   86: ldc_w 283
    //   89: invokevirtual 464	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   92: pop
    //   93: aload_1
    //   94: invokeinterface 41 1 0
    //   99: astore_1
    //   100: aload_1
    //   101: invokeinterface 46 1 0
    //   106: ifeq +84 -> 190
    //   109: aload_1
    //   110: invokeinterface 50 1 0
    //   115: checkcast 52	com/tencent/biz/qqstory/album/model/StoryAlbum
    //   118: astore 4
    //   120: aload 4
    //   122: invokevirtual 467	com/tencent/biz/qqstory/album/model/StoryAlbum:a	()Lcom/tencent/biz/qqstory/database/StoryAlbumEntry;
    //   125: astore 5
    //   127: aload 5
    //   129: invokevirtual 470	com/tencent/biz/qqstory/database/StoryAlbumEntry:getId	()J
    //   132: lconst_0
    //   133: lcmp
    //   134: ifle +37 -> 171
    //   137: aload 5
    //   139: sipush 1001
    //   142: invokevirtual 320	com/tencent/biz/qqstory/database/StoryAlbumEntry:setStatus	(I)V
    //   145: aload_3
    //   146: aload 5
    //   148: invokevirtual 473	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   151: ifne +26 -> 177
    //   154: aload 5
    //   156: sipush 1000
    //   159: invokevirtual 320	com/tencent/biz/qqstory/database/StoryAlbumEntry:setStatus	(I)V
    //   162: aload_3
    //   163: aload 5
    //   165: invokevirtual 477	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   168: goto +9 -> 177
    //   171: aload_3
    //   172: aload 5
    //   174: invokevirtual 477	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   177: aload 4
    //   179: aload 5
    //   181: invokevirtual 470	com/tencent/biz/qqstory/database/StoryAlbumEntry:getId	()J
    //   184: invokevirtual 480	com/tencent/biz/qqstory/album/model/StoryAlbum:a	(J)V
    //   187: goto -87 -> 100
    //   190: aload_3
    //   191: invokevirtual 455	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   194: invokevirtual 483	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   197: aload_3
    //   198: invokevirtual 455	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   201: invokevirtual 486	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   204: iconst_1
    //   205: ireturn
    //   206: astore_1
    //   207: goto +22 -> 229
    //   210: astore_1
    //   211: ldc 165
    //   213: ldc_w 488
    //   216: aload_1
    //   217: invokestatic 492	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: aload_3
    //   221: invokevirtual 455	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   224: invokevirtual 486	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   227: iconst_0
    //   228: ireturn
    //   229: aload_3
    //   230: invokevirtual 455	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   233: invokevirtual 486	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   236: goto +5 -> 241
    //   239: aload_1
    //   240: athrow
    //   241: goto -2 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	StoryScanManager
    //   0	244	1	paramList	List<StoryAlbum>
    //   0	244	2	paramBoolean	boolean
    //   7	223	3	localObject	Object
    //   118	60	4	localStoryAlbum	StoryAlbum
    //   125	55	5	localStoryAlbumEntry	StoryAlbumEntry
    // Exception table:
    //   from	to	target	type
    //   93	100	206	finally
    //   100	168	206	finally
    //   171	177	206	finally
    //   177	187	206	finally
    //   190	197	206	finally
    //   211	220	206	finally
    //   93	100	210	java/lang/Exception
    //   100	168	210	java/lang/Exception
    //   171	177	210	java/lang/Exception
    //   177	187	210	java/lang/Exception
    //   190	197	210	java/lang/Exception
  }
  
  public List<SplitConfig.TreeGatherConfig> b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.a();
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
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryScanManager
 * JD-Core Version:    0.7.0.1
 */