package com.tencent.mobileqq.activity.aio;

import NS_GROUP_COUNT.mobile_batch_get_profile_count_rsp;
import NS_GROUP_COUNT.profile_count_item;
import android.os.Bundle;
import android.support.v4.util.ArraySet;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ChatMsgRedDotInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
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
  public static int a;
  private static AIOTroopQcircleRedDotManager jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager;
  private static boolean jdField_a_of_type_Boolean = false;
  public static int b;
  public static int c;
  private static int jdField_d_of_type_Int;
  private long jdField_a_of_type_Long;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String jdField_a_of_type_JavaLangString;
  WeakReference<TroopChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private long b;
  private long c;
  private long jdField_d_of_type_Long;
  private long e;
  private long f;
  private long g;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager = null;
    jdField_d_of_type_Int = jdField_a_of_type_Int;
  }
  
  /* Error */
  private AIOTroopQcircleRedDotManager()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 42	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 44	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 46	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory	Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 48	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   19: aload_0
    //   20: ldc 50
    //   22: putfield 52	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   25: aload_0
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 46	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory	Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   31: ifnonnull +154 -> 185
    //   34: aload_0
    //   35: ldc 54
    //   37: ldc2_w 55
    //   40: invokestatic 62	cooperation/qzone/LocalMultiProcConfig:getLong	(Ljava/lang/String;J)J
    //   43: putfield 64	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_Long	J
    //   46: aload_0
    //   47: ldc 66
    //   49: ldc2_w 67
    //   52: invokestatic 62	cooperation/qzone/LocalMultiProcConfig:getLong	(Ljava/lang/String;J)J
    //   55: putfield 70	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_b_of_type_Long	J
    //   58: aload_0
    //   59: ldc 72
    //   61: ldc2_w 55
    //   64: invokestatic 62	cooperation/qzone/LocalMultiProcConfig:getLong	(Ljava/lang/String;J)J
    //   67: putfield 74	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:e	J
    //   70: aload_0
    //   71: ldc 76
    //   73: ldc2_w 77
    //   76: invokestatic 62	cooperation/qzone/LocalMultiProcConfig:getLong	(Ljava/lang/String;J)J
    //   79: putfield 80	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:f	J
    //   82: aload_0
    //   83: ldc 82
    //   85: ldc2_w 55
    //   88: invokestatic 62	cooperation/qzone/LocalMultiProcConfig:getLong	(Ljava/lang/String;J)J
    //   91: putfield 84	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_c_of_type_Long	J
    //   94: aload_0
    //   95: ldc 86
    //   97: ldc2_w 67
    //   100: invokestatic 62	cooperation/qzone/LocalMultiProcConfig:getLong	(Ljava/lang/String;J)J
    //   103: putfield 88	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_d_of_type_Long	J
    //   106: invokestatic 93	com/tencent/mobileqq/config/Config:a	()Ljava/lang/String;
    //   109: invokestatic 98	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 104	com/tencent/mobileqq/persistence/EntityManagerFactory:verifyAuthentication	()Z
    //   117: pop
    //   118: aload_0
    //   119: aload_1
    //   120: putfield 46	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory	Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 46	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory	Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   128: invokevirtual 108	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   131: putfield 44	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   134: aload_0
    //   135: aload_0
    //   136: invokespecial 111	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   139: putfield 113	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   142: invokestatic 119	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   145: invokevirtual 123	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   148: astore_1
    //   149: aload_1
    //   150: ifnull +38 -> 188
    //   153: aload_0
    //   154: aload_1
    //   155: checkcast 125	com/tencent/mobileqq/app/QQAppInterface
    //   158: invokevirtual 129	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   161: putfield 131	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:g	J
    //   164: aload_1
    //   165: checkcast 125	com/tencent/mobileqq/app/QQAppInterface
    //   168: aload_0
    //   169: invokevirtual 135	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   172: aload_0
    //   173: invokestatic 140	common/config/service/QzoneConfig:getQcircleTroopRedDotIconUrl	()Ljava/lang/String;
    //   176: putfield 52	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokestatic 143	common/config/service/QzoneConfig:isQzoneTroopUnreadAllReport	()Z
    //   182: putstatic 38	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:jdField_a_of_type_Boolean	Z
    //   185: aload_0
    //   186: monitorexit
    //   187: return
    //   188: aload_0
    //   189: ldc2_w 77
    //   192: putfield 131	com/tencent/mobileqq/activity/aio/AIOTroopQcircleRedDotManager:g	J
    //   195: goto -23 -> 172
    //   198: astore_1
    //   199: aload_0
    //   200: monitorexit
    //   201: aload_1
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	AIOTroopQcircleRedDotManager
    //   112	53	1	localObject1	Object
    //   198	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	149	198	finally
    //   153	172	198	finally
    //   172	185	198	finally
    //   185	187	198	finally
    //   188	195	198	finally
    //   199	201	198	finally
  }
  
  public static int a()
  {
    return jdField_d_of_type_Int;
  }
  
  public static AIOTroopQcircleRedDotManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager = new AIOTroopQcircleRedDotManager();
      }
      AIOTroopQcircleRedDotManager localAIOTroopQcircleRedDotManager = jdField_a_of_type_ComTencentMobileqqActivityAioAIOTroopQcircleRedDotManager;
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
  
  private ConcurrentHashMap<String, Integer> a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (localObject != null)
    {
      localObject = LocalMultiProcConfig.getString4Uin("qcircle_redpoint_grey_troop_uin", "", ((QQAppInterface)localObject).getLongAccountUin());
      if (!"".equals(localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localConcurrentHashMap.put(localObject[i], Integer.valueOf(1));
          i += 1;
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  public static void a()
  {
    jdField_d_of_type_Int = jdField_a_of_type_Int;
  }
  
  private void a(TroopChatPie paramTroopChatPie, ArrayMap<String, QzoneRedDotEntity> paramArrayMap)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface == null) || (paramArrayMap == null) || (paramArrayMap.size() == 0)) {
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
        QZLog.d("AIOTroopQcircleRedDotManager", 2, "pullQzoneRedDotFromBackend, invalid uin = " + str);
      }
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopChatPie);
    paramTroopChatPie = (AIOTroopQzoneRedDotManager)localQQAppInterface.getManager(QQManagerFactory.AIO_TROOP_QZONE_REDDOT_MANAGER);
    paramArrayMap = new QzoneTroopReddotRequest(localArrayList, null);
    paramArrayMap.a(0);
    paramTroopChatPie.a(paramArrayMap, localArrayList.size());
  }
  
  private void a(EntityManager paramEntityManager, Collection<QzoneRedDotEntity> paramCollection)
  {
    if (paramEntityManager != null) {
      paramEntityManager.getTransaction().begin();
    }
    for (;;)
    {
      QzoneRedDotEntity localQzoneRedDotEntity;
      try
      {
        paramCollection = paramCollection.iterator();
        if (paramCollection.hasNext())
        {
          localQzoneRedDotEntity = (QzoneRedDotEntity)paramCollection.next();
          paramEntityManager.persistOrReplace(localQzoneRedDotEntity);
          if (!localQzoneRedDotEntity.isShowRedDot) {
            continue;
          }
          if (!d()) {
            LpReportInfo_pf00064.report(1200, 1, 1, localQzoneRedDotEntity.uin);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramCollection)
      {
        paramCollection.printStackTrace();
        paramEntityManager.getTransaction().commit();
        paramEntityManager.getTransaction().end();
      }
      LpReportInfo_pf00064.allReport(1200, 1, 1, localQzoneRedDotEntity.uin);
    }
  }
  
  private void a(String paramString, List<ChatMessage> paramList, TroopChatPie paramTroopChatPie, ArrayMap<String, QcircleRedDotEntity> paramArrayMap)
  {
    if ((paramArrayMap == null) || (paramArrayMap.size() == 0)) {
      return;
    }
    QCircleTroopRedDotRequest localQCircleTroopRedDotRequest = new QCircleTroopRedDotRequest(paramArrayMap.keySet());
    localQCircleTroopRedDotRequest.setEnableCache(false);
    paramString = new AIOTroopQcircleRedDotManager.7(this, paramArrayMap, paramString, paramTroopChatPie, paramList);
    VSNetworkHelper.getInstance().sendRequest(localQCircleTroopRedDotRequest, paramString);
  }
  
  private void a(Set<String> paramSet)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramSet == null) || (paramSet.size() == 0) || (localQQAppInterface == null)) {
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
  
  public static boolean a()
  {
    return (QzoneConfig.isQQCircleShowTroopUnreadRedDot()) && (ReadInJoyUtils.c() == 0) && (!SimpleUIUtil.a());
  }
  
  public static void b()
  {
    if (jdField_d_of_type_Int != jdField_c_of_type_Int) {
      jdField_d_of_type_Int += 1;
    }
  }
  
  private static void b(EntityManager paramEntityManager, Entity paramEntity)
  {
    if (paramEntityManager != null) {
      paramEntityManager.getTransaction().begin();
    }
    try
    {
      paramEntityManager.persistOrReplace(paramEntity);
      paramEntityManager.getTransaction().commit();
      paramEntityManager.getTransaction().end();
      return;
    }
    catch (Exception paramEntity)
    {
      for (;;)
      {
        paramEntity.printStackTrace();
      }
    }
  }
  
  private void b(EntityManager paramEntityManager, Collection<QcircleRedDotEntity> paramCollection)
  {
    if (paramEntityManager != null)
    {
      paramEntityManager.getTransaction().begin();
      try
      {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          QcircleRedDotEntity localQcircleRedDotEntity = (QcircleRedDotEntity)paramCollection.next();
          paramEntityManager.persistOrReplace(localQcircleRedDotEntity);
          if (localQcircleRedDotEntity.isShowRedDot) {
            ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(localQcircleRedDotEntity.uin, 61, 1, 1);
          }
        }
        return;
      }
      catch (Exception paramCollection)
      {
        paramCollection.printStackTrace();
        paramEntityManager.getTransaction().commit();
        paramEntityManager.getTransaction().end();
      }
    }
  }
  
  public static boolean b()
  {
    return (QzoneConfig.isQzoneShowTroopUnreadRedDot()) && (ReadInJoyUtils.c() == 0) && (!SimpleUIUtil.a()) && (c());
  }
  
  public static boolean c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    if ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, localQQAppInterface.getLongAccountUin()) & 0x200000) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean d()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public void a(TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramList == null) || (paramTroopChatPie == null) || (paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null)) {
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
      localObject3 = (QzoneRedDotEntity)a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, QzoneRedDotEntity.class, (String)localObject2);
      long l = System.currentTimeMillis();
      if (localObject3 != null)
      {
        if (l - ((QzoneRedDotEntity)localObject3).timeStamp >= this.jdField_c_of_type_Long) {
          localArrayMap2.put(localObject2, localObject3);
        } else {
          localArrayMap1.put(localObject2, localObject3);
        }
      }
      else {
        localArrayMap2.put(localObject2, new QzoneRedDotEntity((String)localObject2, false, l, "", "https://sola.gtimg.cn/aoi/sola/20201120145856_F8zRPy6aU6.png"));
      }
    }
    a(paramTroopChatPie, localArrayMap2);
    ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.3(this, paramList, localArrayMap1, localArrayMap2, paramTroopChatPie));
  }
  
  public void a(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramList == null) || (paramTroopChatPie == null) || (paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (paramString == null) || (!a(paramString))) {
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
      localObject3 = (QcircleRedDotEntity)a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (String)localObject2);
      long l = System.currentTimeMillis();
      if (localObject3 != null)
      {
        if (l - ((QcircleRedDotEntity)localObject3).timeStamp >= this.jdField_a_of_type_Long) {
          localArrayMap2.put(localObject2, localObject3);
        } else {
          localArrayMap1.put(localObject2, localObject3);
        }
      }
      else {
        localArrayMap2.put(localObject2, new QcircleRedDotEntity((String)localObject2, false, l, ""));
      }
    }
    a(paramString, paramList, paramTroopChatPie, localArrayMap2);
    ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.1(this, paramList, localArrayMap1, localArrayMap2, paramTroopChatPie));
  }
  
  public void a(List<ChatMessage> paramList, String paramString)
  {
    if ((paramString != null) && (paramList != null))
    {
      ThreadManager.excute(new AIOTroopQcircleRedDotManager.5(this, paramString), 32, null, true);
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
    return (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString));
  }
  
  public void b(TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramList == null) || (paramTroopChatPie == null) || (paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null)) {
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
        long l = System.currentTimeMillis();
        localArrayMap.put(((ChatMessage)localObject).senderuin, new QzoneRedDotEntity(((ChatMessage)localObject).senderuin, false, l, "", "https://sola.gtimg.cn/aoi/sola/20201120145856_F8zRPy6aU6.png"));
      }
    }
    if (localArrayMap.size() >= this.jdField_d_of_type_Long) {
      a(paramTroopChatPie, localArrayMap);
    }
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.4(this, paramList, localArrayMap, bool, paramTroopChatPie));
      return;
      localIterator = localArrayMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        QzoneRedDotEntity localQzoneRedDotEntity = (QzoneRedDotEntity)a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, QzoneRedDotEntity.class, (String)localObject);
        if (localQzoneRedDotEntity != null) {
          localArrayMap.put(localObject, localQzoneRedDotEntity);
        }
      }
    }
  }
  
  public void b(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramList == null) || (paramTroopChatPie == null) || (paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (paramString == null) || (!a(paramString))) {
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
        long l = System.currentTimeMillis();
        localArrayMap.put(((ChatMessage)localObject2).senderuin, new QcircleRedDotEntity(((ChatMessage)localObject2).senderuin, false, l, ""));
      }
    }
    if (localArrayMap.size() >= this.jdField_b_of_type_Long) {
      a(paramString, paramList, paramTroopChatPie, localArrayMap);
    }
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.2(this, paramList, localArrayMap, bool, paramTroopChatPie));
      return;
      paramString = localArrayMap.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject1 = (String)paramString.next();
        localObject2 = (QcircleRedDotEntity)a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (String)localObject1);
        if (localObject2 != null) {
          localArrayMap.put(localObject1, localObject2);
        }
      }
    }
  }
  
  public void b(List<ChatMessage> paramList, String paramString)
  {
    if ((paramString != null) && (paramList != null))
    {
      ThreadManager.excute(new AIOTroopQcircleRedDotManager.6(this, paramString), 32, null, true);
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
    if (localAppRuntime != null) {}
    for (long l1 = ((QQAppInterface)localAppRuntime).getLongAccountUin(); (this.g < 0L) || (l1 < 0L); l1 = -1L) {
      return;
    }
    long l2 = System.currentTimeMillis();
    if ((this.f == -1L) || (l2 - this.f >= this.e) || (this.g != l1))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = a();
      this.g = l1;
      d(paramString, paramTroopChatPie, paramList);
      return;
    }
    a(paramString, paramTroopChatPie, paramList);
  }
  
  public void d(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QCircleTroopGreyRequest localQCircleTroopGreyRequest = null;
    QZLog.d("AIOTroopQcircleRedDotManager", 2, "first into AIO, try to pull grey info and reddot info");
    Object localObject1 = localQCircleTroopGreyRequest;
    if (localObject2 != null)
    {
      localObject2 = (TroopManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = localQCircleTroopGreyRequest;
      if (localObject2 != null) {
        localObject1 = ((TroopManager)localObject2).c();
      }
    }
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      a(paramString, paramTroopChatPie, paramList);
      return;
    }
    localQCircleTroopGreyRequest = new QCircleTroopGreyRequest((List)localObject1);
    localQCircleTroopGreyRequest.setEnableCache(false);
    paramString = new AIOTroopQcircleRedDotManager.8(this, (List)localObject1, paramString, paramTroopChatPie, paramList);
    VSNetworkHelper.getInstance().sendRequest(localQCircleTroopGreyRequest, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((!paramBoolean) || (paramBundle == null)) {}
    for (;;)
    {
      return;
      paramBundle = (JceStruct)paramBundle.getSerializable("key_response");
      if ((paramBundle instanceof mobile_batch_get_profile_count_rsp)) {}
      for (paramBundle = (mobile_batch_get_profile_count_rsp)paramBundle; paramBundle != null; paramBundle = null)
      {
        ArrayMap localArrayMap = new ArrayMap();
        long l = System.currentTimeMillis();
        Iterator localIterator = paramBundle.profileCountItems.iterator();
        if (localIterator.hasNext())
        {
          localObject = (profile_count_item)localIterator.next();
          String str = String.valueOf(((profile_count_item)localObject).uin);
          if (((profile_count_item)localObject).count > 0L) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localArrayMap.put(str, new QzoneRedDotEntity(str, paramBoolean, l, ((profile_count_item)localObject).jumpSchema, paramBundle.iconURL));
            break;
          }
        }
        this.jdField_c_of_type_Long = (paramBundle.iNextTimeout * 1000);
        this.jdField_d_of_type_Long = paramBundle.iNextUinsBufCount;
        localIterator = null;
        Object localObject = (TroopChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        paramBundle = localIterator;
        if (localObject != null)
        {
          paramBundle = localIterator;
          if (((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
          {
            paramBundle = localIterator;
            if (((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a() != null) {
              paramBundle = ((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
            }
          }
        }
        if ((paramBundle != null) && (paramBundle.size() > 0)) {
          ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.9(this, paramBundle, localArrayMap, (TroopChatPie)localObject));
        }
        a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, localArrayMap.values());
        LocalMultiProcConfig.putLong("qzone_troop_redpoint_pull_time_threshold", this.jdField_c_of_type_Long);
        LocalMultiProcConfig.putLong("qzone_troop_redpoint_pull_amount_threshold", this.jdField_d_of_type_Long);
        QZLog.d("AIOTroopQcircleRedDotManager", 2, "new qzoneTimeLimits from backend: " + this.jdField_c_of_type_Long);
        QZLog.d("AIOTroopQcircleRedDotManager", 2, "new qzoneAmountLimits from backend: " + this.jdField_d_of_type_Long);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager
 * JD-Core Version:    0.7.0.1
 */