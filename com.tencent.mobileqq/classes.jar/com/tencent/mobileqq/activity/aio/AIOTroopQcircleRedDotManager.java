package com.tencent.mobileqq.activity.aio;

import NS_GROUP_COUNT.mobile_batch_get_profile_count_rsp;
import NS_GROUP_COUNT.profile_count_item;
import android.os.Bundle;
import android.support.v4.util.ArraySet;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ChatMsgRedDotInfo;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.requests.QCircleTroopGreyRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleTroopRedDotRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class AIOTroopQcircleRedDotManager
  implements BusinessObserver
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  private static AIOTroopQcircleRedDotManager e;
  private static int p = a;
  private static boolean q = false;
  WeakReference<TroopChatPie> d = null;
  private EntityManager f = null;
  private EntityManagerFactory g = null;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private ConcurrentHashMap<String, Integer> o;
  private String r = "";
  
  private AIOTroopQcircleRedDotManager()
  {
    try
    {
      if (this.g == null)
      {
        this.h = LocalMultiProcConfig.getLong("qcircle_troop_redpoint_pull_time_threshold", 90000L);
        this.i = LocalMultiProcConfig.getLong("qcircle_troop_redpoint_pull_amount_threshold", 50L);
        this.l = LocalMultiProcConfig.getLong("qcircle_troop_redpoint_grey_time_threshold", 90000L);
        this.m = LocalMultiProcConfig.getLong("qcircle_troop_redpoint_grey_last_timestamp", -1L);
        this.j = LocalMultiProcConfig.getLong("qzone_troop_redpoint_pull_time_threshold", 90000L);
        this.k = LocalMultiProcConfig.getLong("qzone_troop_redpoint_pull_amount_threshold", 50L);
        Object localObject1 = QQEntityManagerFactoryProxy.a(Config.a());
        ((EntityManagerFactory)localObject1).verifyAuthentication();
        this.g = ((EntityManagerFactory)localObject1);
        this.f = this.g.createEntityManager();
        this.o = i();
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null)
        {
          this.n = ((QQAppInterface)localObject1).getLongAccountUin();
          ((QQAppInterface)localObject1).registObserver(this);
        }
        else
        {
          this.n = -1L;
        }
        this.r = QzoneConfig.getQcircleTroopRedDotIconUrl();
        q = QzoneConfig.isQzoneTroopUnreadAllReport();
      }
      return;
    }
    finally {}
  }
  
  public static AIOTroopQcircleRedDotManager a()
  {
    try
    {
      if (e == null) {
        e = new AIOTroopQcircleRedDotManager();
      }
      AIOTroopQcircleRedDotManager localAIOTroopQcircleRedDotManager = e;
      return localAIOTroopQcircleRedDotManager;
    }
    finally {}
  }
  
  private static Entity a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString)
  {
    if (paramEntityManager != null) {
      return paramEntityManager.find(paramClass, paramString);
    }
    return null;
  }
  
  private static Entity a(EntityManager paramEntityManager, String paramString)
  {
    if (paramEntityManager != null) {
      return paramEntityManager.find(QcircleRedDotEntity.class, paramString);
    }
    return null;
  }
  
  private void a(TroopChatPie paramTroopChatPie, ArrayMap<String, QzoneRedDotEntity> paramArrayMap)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (paramArrayMap != null))
    {
      if (paramArrayMap.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayMap = paramArrayMap.keySet().iterator();
      while (paramArrayMap.hasNext())
      {
        String str = (String)paramArrayMap.next();
        try
        {
          localArrayList.add(Long.valueOf(str));
        }
        catch (Exception localException)
        {
          label79:
          StringBuilder localStringBuilder;
          break label79;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pullQzoneRedDotFromBackend, invalid uin = ");
        localStringBuilder.append(str);
        QZLog.d("AIOTroopQcircleRedDotManager", 2, localStringBuilder.toString());
      }
      this.d = new WeakReference(paramTroopChatPie);
      paramTroopChatPie = (AIOTroopQzoneRedDotManager)localQQAppInterface.getManager(QQManagerFactory.AIO_TROOP_QZONE_REDDOT_MANAGER);
      paramArrayMap = new QzoneTroopReddotRequest(localArrayList, null);
      paramArrayMap.a(0);
      paramTroopChatPie.a(paramArrayMap, localArrayList.size());
    }
  }
  
  private void a(EntityManager paramEntityManager, Collection<QzoneRedDotEntity> paramCollection)
  {
    if (paramEntityManager != null)
    {
      try
      {
        paramEntityManager.getTransaction().begin();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          QzoneRedDotEntity localQzoneRedDotEntity = (QzoneRedDotEntity)paramCollection.next();
          paramEntityManager.persistOrReplace(localQzoneRedDotEntity);
          if (localQzoneRedDotEntity.isShowRedDot) {
            if (!e()) {
              LpReportInfo_pf00064.report(1200, 1, 1, localQzoneRedDotEntity.uin);
            } else {
              LpReportInfo_pf00064.allReport(1200, 1, 1, localQzoneRedDotEntity.uin);
            }
          }
        }
        paramEntityManager.getTransaction().commit();
      }
      catch (Exception paramCollection)
      {
        paramCollection.printStackTrace();
      }
      paramEntityManager.getTransaction().end();
    }
  }
  
  private void a(String paramString, List<ChatMessage> paramList, TroopChatPie paramTroopChatPie, ArrayMap<String, QcircleRedDotEntity> paramArrayMap)
  {
    if (paramArrayMap != null)
    {
      if (paramArrayMap.size() == 0) {
        return;
      }
      QCircleTroopRedDotRequest localQCircleTroopRedDotRequest = new QCircleTroopRedDotRequest(paramArrayMap.keySet());
      localQCircleTroopRedDotRequest.setEnableCache(false);
      paramString = new AIOTroopQcircleRedDotManager.7(this, paramArrayMap, paramString, paramTroopChatPie, paramList);
      VSNetworkHelper.getInstance().sendRequest(localQCircleTroopRedDotRequest, paramString);
    }
  }
  
  private void a(Set<String> paramSet)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramSet != null) && (paramSet.size() != 0))
    {
      if (localQQAppInterface == null) {
        return;
      }
      Object localObject = new HashSet(paramSet);
      paramSet = new StringBuilder(1024);
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramSet.append((String)((Iterator)localObject).next());
        paramSet.append(',');
      }
      LocalMultiProcConfig.putString4Uin("qcircle_redpoint_grey_troop_uin", paramSet.toString(), localQQAppInterface.getLongAccountUin());
    }
  }
  
  private static void b(EntityManager paramEntityManager, Entity paramEntity)
  {
    if (paramEntityManager != null)
    {
      try
      {
        paramEntityManager.getTransaction().begin();
        paramEntityManager.persistOrReplace(paramEntity);
        paramEntityManager.getTransaction().commit();
      }
      catch (Exception paramEntity)
      {
        paramEntity.printStackTrace();
      }
      paramEntityManager.getTransaction().end();
    }
  }
  
  private void b(EntityManager paramEntityManager, Collection<QcircleRedDotEntity> paramCollection)
  {
    if (paramEntityManager != null)
    {
      try
      {
        paramEntityManager.getTransaction().begin();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          QcircleRedDotEntity localQcircleRedDotEntity = (QcircleRedDotEntity)paramCollection.next();
          paramEntityManager.persistOrReplace(localQcircleRedDotEntity);
          if (localQcircleRedDotEntity.isShowRedDot) {
            ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(localQcircleRedDotEntity.uin).setActionType(61).setSubActionType(1).setThrActionType(1));
          }
        }
        paramEntityManager.getTransaction().commit();
      }
      catch (Exception paramCollection)
      {
        paramCollection.printStackTrace();
      }
      paramEntityManager.getTransaction().end();
    }
  }
  
  public static boolean b()
  {
    return (QzoneConfig.isQQCircleShowTroopUnreadRedDot()) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getUserMode() == 0) && (!SimpleUIUtil.e());
  }
  
  public static boolean c()
  {
    return (QzoneConfig.isQzoneShowTroopUnreadRedDot()) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getUserMode() == 0) && (!SimpleUIUtil.e()) && (d());
  }
  
  public static boolean d()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = false;
    if (localQQAppInterface == null) {
      return false;
    }
    if ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, localQQAppInterface.getLongAccountUin()) & 0x200000) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean e()
  {
    return q;
  }
  
  public static void f()
  {
    p = a;
  }
  
  public static void g()
  {
    int i1 = p;
    if (i1 != c) {
      p = i1 + 1;
    }
  }
  
  public static int h()
  {
    return p;
  }
  
  private ConcurrentHashMap<String, Integer> i()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (localObject != null)
    {
      localObject = LocalMultiProcConfig.getString4Uin("qcircle_redpoint_grey_troop_uin", "", ((QQAppInterface)localObject).getLongAccountUin());
      if (!"".equals(localObject))
      {
        localObject = ((String)localObject).split(",");
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          localConcurrentHashMap.put(localObject[i1], Integer.valueOf(1));
          i1 += 1;
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  public void a(TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.f != null) && (paramList != null) && (paramTroopChatPie != null))
    {
      if (paramTroopChatPie.V == null) {
        return;
      }
      Object localObject1 = new ArraySet();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      Object localObject2 = paramList.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if ((((ChatMessage)localObject3).senderuin != null) && (!((ChatMessage)localObject3).senderuin.equals(((ChatMessage)localObject3).selfuin))) {
          ((ArraySet)localObject1).add(((ChatMessage)localObject3).senderuin);
        }
      }
      localObject1 = ((ArraySet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = (QzoneRedDotEntity)a(this.f, QzoneRedDotEntity.class, (String)localObject2);
        long l1 = System.currentTimeMillis();
        if (localObject3 != null)
        {
          if (l1 - ((QzoneRedDotEntity)localObject3).timeStamp >= this.j) {
            localArrayMap2.put(localObject2, localObject3);
          } else {
            localArrayMap1.put(localObject2, localObject3);
          }
        }
        else {
          localArrayMap2.put(localObject2, new QzoneRedDotEntity((String)localObject2, false, l1, "", "https://sola.gtimg.cn/aoi/sola/20201120145856_F8zRPy6aU6.png"));
        }
      }
      a(paramTroopChatPie, localArrayMap2);
      ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.3(this, paramList, localArrayMap1, localArrayMap2, paramTroopChatPie));
    }
  }
  
  public void a(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.f != null) && (paramList != null) && (paramTroopChatPie != null) && (paramTroopChatPie.V != null) && (paramString != null))
    {
      if (!a(paramString)) {
        return;
      }
      Object localObject1 = new ArraySet();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      Object localObject2 = paramList.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if ((((ChatMessage)localObject3).senderuin != null) && (!((ChatMessage)localObject3).senderuin.equals(((ChatMessage)localObject3).selfuin))) {
          ((ArraySet)localObject1).add(((ChatMessage)localObject3).senderuin);
        }
      }
      localObject1 = ((ArraySet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = (QcircleRedDotEntity)a(this.f, (String)localObject2);
        long l1 = System.currentTimeMillis();
        if (localObject3 != null)
        {
          if (l1 - ((QcircleRedDotEntity)localObject3).timeStamp >= this.h) {
            localArrayMap2.put(localObject2, localObject3);
          } else {
            localArrayMap1.put(localObject2, localObject3);
          }
        }
        else {
          localArrayMap2.put(localObject2, new QcircleRedDotEntity((String)localObject2, false, l1, ""));
        }
      }
      a(paramString, paramList, paramTroopChatPie, localArrayMap2);
      ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.1(this, paramList, localArrayMap1, localArrayMap2, paramTroopChatPie));
    }
  }
  
  public void a(List<ChatMessage> paramList, String paramString)
  {
    if ((paramString != null) && (paramList != null))
    {
      ThreadManager.excute(new AIOTroopQcircleRedDotManager.5(this, paramString), 160, null, true);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        if (paramString.equals(localChatMessage.senderuin)) {
          localChatMessage.getChatMsgRedDotInfo().setQcircleRedDotFlag(false);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.o;
    return (localConcurrentHashMap != null) && (localConcurrentHashMap.containsKey(paramString));
  }
  
  public void b(TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.f != null) && (paramList != null) && (paramTroopChatPie != null))
    {
      if (paramTroopChatPie.V == null) {
        return;
      }
      ArrayMap localArrayMap = new ArrayMap();
      Iterator localIterator = paramList.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (ChatMessage)localIterator.next();
        if ((((ChatMessage)localObject).senderuin != null) && (!((ChatMessage)localObject).senderuin.equals(((ChatMessage)localObject).selfuin)) && (!((ChatMessage)localObject).getChatMsgRedDotInfo().getQzoneRedDotPulledFlag()))
        {
          long l1 = System.currentTimeMillis();
          localArrayMap.put(((ChatMessage)localObject).senderuin, new QzoneRedDotEntity(((ChatMessage)localObject).senderuin, false, l1, "", "https://sola.gtimg.cn/aoi/sola/20201120145856_F8zRPy6aU6.png"));
        }
      }
      boolean bool;
      if (localArrayMap.size() >= this.k)
      {
        a(paramTroopChatPie, localArrayMap);
        bool = true;
      }
      else
      {
        localIterator = localArrayMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          QzoneRedDotEntity localQzoneRedDotEntity = (QzoneRedDotEntity)a(this.f, QzoneRedDotEntity.class, (String)localObject);
          if (localQzoneRedDotEntity != null) {
            localArrayMap.put(localObject, localQzoneRedDotEntity);
          }
        }
        bool = false;
      }
      ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.4(this, paramList, localArrayMap, bool, paramTroopChatPie));
    }
  }
  
  public void b(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.f != null) && (paramList != null) && (paramTroopChatPie != null) && (paramTroopChatPie.V != null) && (paramString != null))
    {
      if (!a(paramString)) {
        return;
      }
      ArrayMap localArrayMap = new ArrayMap();
      Object localObject1 = paramList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
        if ((((ChatMessage)localObject2).senderuin != null) && (!((ChatMessage)localObject2).senderuin.equals(((ChatMessage)localObject2).selfuin)) && (!((ChatMessage)localObject2).getChatMsgRedDotInfo().getQcircleRedDotPulledFlag()))
        {
          long l1 = System.currentTimeMillis();
          localArrayMap.put(((ChatMessage)localObject2).senderuin, new QcircleRedDotEntity(((ChatMessage)localObject2).senderuin, false, l1, ""));
        }
      }
      boolean bool;
      if (localArrayMap.size() >= this.i)
      {
        a(paramString, paramList, paramTroopChatPie, localArrayMap);
        bool = true;
      }
      else
      {
        paramString = localArrayMap.keySet().iterator();
        while (paramString.hasNext())
        {
          localObject1 = (String)paramString.next();
          localObject2 = (QcircleRedDotEntity)a(this.f, (String)localObject1);
          if (localObject2 != null) {
            localArrayMap.put(localObject1, localObject2);
          }
        }
        bool = false;
      }
      ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.2(this, paramList, localArrayMap, bool, paramTroopChatPie));
    }
  }
  
  public void b(List<ChatMessage> paramList, String paramString)
  {
    if ((paramString != null) && (paramList != null))
    {
      ThreadManager.excute(new AIOTroopQcircleRedDotManager.6(this, paramString), 160, null, true);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        if (paramString.equals(localChatMessage.senderuin)) {
          localChatMessage.getChatMsgRedDotInfo().setQzoneRedDotFlag(false);
        }
      }
    }
  }
  
  public void c(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    long l1;
    if (localAppRuntime != null) {
      l1 = ((QQAppInterface)localAppRuntime).getLongAccountUin();
    } else {
      l1 = -1L;
    }
    if (this.n >= 0L)
    {
      if (l1 < 0L) {
        return;
      }
      long l2 = System.currentTimeMillis();
      long l3 = this.m;
      if ((l3 != -1L) && (l2 - l3 < this.l) && (this.n == l1))
      {
        a(paramString, paramTroopChatPie, paramList);
        return;
      }
      this.o = i();
      this.n = l1;
      d(paramString, paramTroopChatPie, paramList);
    }
  }
  
  public void d(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QZLog.d("AIOTroopQcircleRedDotManager", 2, "first into AIO, try to pull grey info and reddot info");
    if (localObject != null)
    {
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null)
      {
        localObject = ((TroopManager)localObject).i();
        break label56;
      }
    }
    localObject = null;
    label56:
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      QCircleTroopGreyRequest localQCircleTroopGreyRequest = new QCircleTroopGreyRequest((List)localObject);
      localQCircleTroopGreyRequest.setEnableCache(false);
      paramString = new AIOTroopQcircleRedDotManager.8(this, (List)localObject, paramString, paramTroopChatPie, paramList);
      VSNetworkHelper.getInstance().sendRequest(localQCircleTroopGreyRequest, paramString);
      return;
    }
    a(paramString, paramTroopChatPie, paramList);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if (paramBundle == null) {
        return;
      }
      paramBundle = (JceStruct)paramBundle.getSerializable("key_response");
      if ((paramBundle instanceof mobile_batch_get_profile_count_rsp)) {
        paramBundle = (mobile_batch_get_profile_count_rsp)paramBundle;
      } else {
        paramBundle = null;
      }
      if (paramBundle == null) {
        return;
      }
      ArrayMap localArrayMap = new ArrayMap();
      long l1 = System.currentTimeMillis();
      Object localObject = paramBundle.profileCountItems.iterator();
      while (((Iterator)localObject).hasNext())
      {
        profile_count_item localprofile_count_item = (profile_count_item)((Iterator)localObject).next();
        String str = String.valueOf(localprofile_count_item.uin);
        if (localprofile_count_item.count > 0L) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localArrayMap.put(str, new QzoneRedDotEntity(str, paramBoolean, l1, localprofile_count_item.jumpSchema, paramBundle.iconURL));
      }
      this.j = (paramBundle.iNextTimeout * 1000);
      this.k = paramBundle.iNextUinsBufCount;
      localObject = (TroopChatPie)this.d.get();
      if ((localObject != null) && (((TroopChatPie)localObject).U != null) && (((TroopChatPie)localObject).V.a() != null)) {
        paramBundle = ((TroopChatPie)localObject).V.a();
      } else {
        paramBundle = null;
      }
      if ((paramBundle != null) && (paramBundle.size() > 0)) {
        ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.9(this, paramBundle, localArrayMap, (TroopChatPie)localObject));
      }
      ThreadManager.excute(new AIOTroopQcircleRedDotManager.10(this, localArrayMap), 160, null, true);
      LocalMultiProcConfig.putLong("qzone_troop_redpoint_pull_time_threshold", this.j);
      LocalMultiProcConfig.putLong("qzone_troop_redpoint_pull_amount_threshold", this.k);
      paramBundle = new StringBuilder();
      paramBundle.append("new qzoneTimeLimits from backend: ");
      paramBundle.append(this.j);
      QZLog.d("AIOTroopQcircleRedDotManager", 2, paramBundle.toString());
      paramBundle = new StringBuilder();
      paramBundle.append("new qzoneAmountLimits from backend: ");
      paramBundle.append(this.k);
      QZLog.d("AIOTroopQcircleRedDotManager", 2, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager
 * JD-Core Version:    0.7.0.1
 */