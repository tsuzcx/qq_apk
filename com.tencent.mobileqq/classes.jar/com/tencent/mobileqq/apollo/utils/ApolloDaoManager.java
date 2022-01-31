package com.tencent.mobileqq.apollo.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.data.ApolloGameScoreData;
import com.tencent.mobileqq.data.ApolloObtainedActionData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import zci;
import zcj;
import zck;
import zcm;
import zcn;
import zco;
import zcp;
import zcq;
import zcr;

public class ApolloDaoManager
  implements Manager
{
  private volatile int jdField_a_of_type_Int = 1;
  public QQAppInterface a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new zci(this);
  public List a;
  public ConcurrentHashMap a;
  private boolean jdField_a_of_type_Boolean = true;
  public List b;
  public ConcurrentHashMap b;
  public List c;
  public ConcurrentHashMap c;
  public List d;
  private ConcurrentHashMap d;
  public List e = Collections.synchronizedList(new ArrayList());
  public List f = Collections.synchronizedList(new ArrayList());
  public List g = Collections.synchronizedList(new ArrayList());
  public List h = Collections.synchronizedList(new ArrayList());
  public List i = Collections.synchronizedList(new ArrayList());
  public List j = Collections.synchronizedList(new ArrayList());
  public List k = Collections.synchronizedList(new ArrayList());
  public List l = Collections.synchronizedList(new ArrayList());
  private List m = Collections.synchronizedList(new ArrayList());
  
  public ApolloDaoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_d_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ApolloMsgPlayController.a().a(paramQQAppInterface);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public static List a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQAppInterface == null) {
      return localArrayList;
    }
    String str = paramQQAppInterface.c();
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.a(ApolloActionRecentData.class, false, "uin=? and sessionType=?", new String[] { str, paramString }, null, null, null, null);; paramQQAppInterface = localArrayList) {
      return paramQQAppInterface;
    }
  }
  
  private boolean a(ApolloGameRoamData paramApolloGameRoamData)
  {
    if (paramApolloGameRoamData == null) {
      return false;
    }
    Object localObject = f();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloGameData localApolloGameData = (ApolloGameData)((Iterator)localObject).next();
      if ((localApolloGameData != null) && (localApolloGameData.gameId == paramApolloGameRoamData.gameId)) {
        return true;
      }
    }
    return false;
  }
  
  private void c(ApolloActionData paramApolloActionData)
  {
    Object localObject = paramApolloActionData.keywords;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      localObject = ((String)localObject).split(",");
      int i1 = localObject.length;
      int n = 0;
      while (n < i1)
      {
        CharSequence localCharSequence = localObject[n];
        if (!TextUtils.isEmpty(localCharSequence))
        {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localCharSequence, Integer.valueOf(paramApolloActionData.actionId));
          if (localCharSequence.length() > this.jdField_a_of_type_Int) {
            this.jdField_a_of_type_Int = localCharSequence.length();
          }
        }
        n += 1;
      }
    }
  }
  
  private void h()
  {
    if (this.m != null)
    {
      Iterator localIterator;
      synchronized (this.m)
      {
        int n = (int)(System.currentTimeMillis() / 1000L);
        ArrayList localArrayList = new ArrayList();
        localIterator = this.m.iterator();
        while (localIterator.hasNext())
        {
          AioPushData localAioPushData = (AioPushData)localIterator.next();
          if ((localAioPushData != null) && ((localAioPushData.endTs <= n) || (localAioPushData.begTs >= localAioPushData.endTs))) {
            localArrayList.add(localAioPushData);
          }
        }
      }
      if (localCollection.size() > 0)
      {
        localIterator = localCollection.iterator();
        while (localIterator.hasNext()) {
          a((AioPushData)localIterator.next());
        }
        this.m.removeAll(localCollection);
      }
    }
  }
  
  private void h(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      break label13;
    }
    label13:
    while ((paramList.get(0) == null) || (((ApolloActionPackage)paramList.get(0)).packageId == 100)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[makesureGameFirst]");
    }
    Iterator localIterator = paramList.iterator();
    int n = -1;
    ApolloActionPackage localApolloActionPackage;
    while (localIterator.hasNext())
    {
      localApolloActionPackage = (ApolloActionPackage)localIterator.next();
      int i1 = n + 1;
      n = i1;
      if (localApolloActionPackage.packageId == 100) {
        n = i1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, "index:" + n);
      }
      if ((n <= 0) || (localApolloActionPackage == null)) {
        break;
      }
      paramList.remove(n);
      paramList.add(0, localApolloActionPackage);
      return;
      localApolloActionPackage = null;
    }
  }
  
  /* Error */
  private void i(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: invokeinterface 232 1 0
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   28: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +148 -> 181
    //   36: aload_3
    //   37: invokevirtual 287	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   45: new 263	java/lang/StringBuilder
    //   48: dup
    //   49: sipush 500
    //   52: invokespecial 294	java/lang/StringBuilder:<init>	(I)V
    //   55: astore 4
    //   57: aload 4
    //   59: ldc_w 296
    //   62: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: invokeinterface 156 1 0
    //   72: astore 5
    //   74: aload 5
    //   76: invokeinterface 162 1 0
    //   81: ifeq +165 -> 246
    //   84: aload 5
    //   86: invokeinterface 166 1 0
    //   91: checkcast 298	com/tencent/mobileqq/data/ApolloObtainedActionData
    //   94: astore 6
    //   96: aload_0
    //   97: aload_3
    //   98: aload 6
    //   100: invokevirtual 301	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   103: pop
    //   104: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -33 -> 74
    //   110: aload 4
    //   112: ldc_w 303
    //   115: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 6
    //   120: getfield 306	com/tencent/mobileqq/data/ApolloObtainedActionData:id	I
    //   123: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 4
    //   129: invokevirtual 307	java/lang/StringBuilder:length	()I
    //   132: sipush 500
    //   135: if_icmplt -61 -> 74
    //   138: ldc_w 256
    //   141: iconst_2
    //   142: aload 4
    //   144: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload 4
    //   152: iconst_0
    //   153: aload 4
    //   155: invokevirtual 307	java/lang/StringBuilder:length	()I
    //   158: invokevirtual 311	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: goto -88 -> 74
    //   165: astore_3
    //   166: ldc_w 256
    //   169: iconst_2
    //   170: ldc_w 313
    //   173: aload_3
    //   174: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload_2
    //   178: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   181: aload_0
    //   182: getfield 61	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:h	Ljava/util/List;
    //   185: ifnull +32 -> 217
    //   188: aload_0
    //   189: getfield 61	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:h	Ljava/util/List;
    //   192: astore_2
    //   193: aload_2
    //   194: monitorenter
    //   195: aload_0
    //   196: getfield 61	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:h	Ljava/util/List;
    //   199: invokeinterface 321 1 0
    //   204: aload_0
    //   205: getfield 61	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:h	Ljava/util/List;
    //   208: aload_1
    //   209: invokeinterface 324 2 0
    //   214: pop
    //   215: aload_2
    //   216: monitorexit
    //   217: aload_0
    //   218: getfield 65	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   221: ifnull +10 -> 231
    //   224: aload_0
    //   225: getfield 65	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   228: invokevirtual 325	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   231: aload_0
    //   232: getfield 63	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   235: ifnull -215 -> 20
    //   238: aload_0
    //   239: getfield 63	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   242: invokevirtual 325	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   245: return
    //   246: aload 4
    //   248: invokevirtual 307	java/lang/StringBuilder:length	()I
    //   251: sipush 500
    //   254: if_icmpge +35 -> 289
    //   257: aload 4
    //   259: invokevirtual 307	java/lang/StringBuilder:length	()I
    //   262: ifle +27 -> 289
    //   265: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +21 -> 289
    //   271: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +15 -> 289
    //   277: ldc_w 256
    //   280: iconst_2
    //   281: aload 4
    //   283: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_2
    //   290: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   293: aload_2
    //   294: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   297: goto -116 -> 181
    //   300: astore_1
    //   301: aload_2
    //   302: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   305: aload_1
    //   306: athrow
    //   307: astore_1
    //   308: aload_2
    //   309: monitorexit
    //   310: aload_1
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	ApolloDaoManager
    //   0	312	1	paramList	List
    //   31	67	3	localEntityManager	EntityManager
    //   165	9	3	localException	Exception
    //   55	227	4	localStringBuilder	StringBuilder
    //   72	13	5	localIterator	Iterator
    //   94	25	6	localApolloObtainedActionData	ApolloObtainedActionData
    // Exception table:
    //   from	to	target	type
    //   45	74	165	java/lang/Exception
    //   74	162	165	java/lang/Exception
    //   246	289	165	java/lang/Exception
    //   289	293	165	java/lang/Exception
    //   45	74	300	finally
    //   74	162	300	finally
    //   166	177	300	finally
    //   246	289	300	finally
    //   289	293	300	finally
    //   195	217	307	finally
    //   308	310	307	finally
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AioPushData a(String paramString, int paramInt)
  {
    Object localObject1 = null;
    if ((!TextUtils.isEmpty(paramString)) && (paramInt > 0) && (this.m != null))
    {
      Object localObject2;
      synchronized (this.m)
      {
        int n = (int)(System.currentTimeMillis() / 1000L);
        Iterator localIterator = this.m.iterator();
        if (localIterator.hasNext())
        {
          AioPushData localAioPushData = (AioPushData)localIterator.next();
          if ((localAioPushData == null) || (!localAioPushData.them.equals(paramString)) || (paramInt != localAioPushData.busId) || (localAioPushData.isShow) || (localAioPushData.endTs <= n)) {
            break label166;
          }
          if (localObject1 == null)
          {
            localObject2 = localAioPushData;
          }
          else
          {
            localObject2 = localAioPushData;
            if (localAioPushData.begTs <= ((AioPushData)localObject1).begTs) {
              break label166;
            }
          }
        }
        else
        {
          return localObject1;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        label166:
        localObject2 = localObject1;
      }
    }
    return null;
  }
  
  public ApolloActionData a(int paramInt)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = b(paramInt);
        if (localObject2 != null) {
          return localObject2;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      } while (localObject2 == null);
      localObject2 = (ApolloActionData)((EntityManager)localObject2).a(ApolloActionData.class, paramInt + "");
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloDaoManager", 2, new Object[] { "findActionById from db:", Integer.valueOf(paramInt) });
    return localObject2;
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      for (;;)
      {
        int n;
        synchronized (this.jdField_b_of_type_JavaUtilList)
        {
          n = this.jdField_b_of_type_JavaUtilList.size() - 1;
          if (n < 0) {
            break;
          }
          if (((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(n)).packageId == paramInt)
          {
            ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(n);
            return localApolloActionPackage;
          }
        }
        n -= 1;
      }
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (??? != null) {
      return (ApolloActionPackage)((EntityManager)???).a(ApolloActionPackage.class, paramInt + "");
    }
    return null;
  }
  
  public ApolloActionPush a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    Object localObject = j();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloActionPush localApolloActionPush = (ApolloActionPush)((Iterator)localObject).next();
      if ((localApolloActionPush != null) && (localApolloActionPush.mAioType == paramSessionInfo.jdField_a_of_type_Int) && (!TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (paramSessionInfo.jdField_a_of_type_JavaLangString.equals(localApolloActionPush.mSessionId + ""))) {
        return localApolloActionPush;
      }
    }
    return null;
  }
  
  public ApolloFavActionData a(long paramLong)
  {
    Object localObject4 = null;
    List localList;
    int n;
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      localList = this.jdField_d_of_type_JavaUtilList;
      n = 0;
    }
    for (;;)
    {
      Object localObject1 = localObject4;
      try
      {
        if (n < this.jdField_d_of_type_JavaUtilList.size())
        {
          if (((ApolloFavActionData)this.jdField_d_of_type_JavaUtilList.get(n)).favId != paramLong) {
            break label170;
          }
          localObject1 = (ApolloFavActionData)this.jdField_d_of_type_JavaUtilList.get(n);
        }
        return localObject1;
      }
      finally {}
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localObject3 != null) {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "find ApolloFavActionData favid=" + paramLong);
          }
        }
        for (localObject3 = (ApolloFavActionData)((EntityManager)localObject3).a(ApolloFavActionData.class, paramLong);; localObject3 = null) {
          return localObject3;
        }
      }
      return null;
      label170:
      n += 1;
    }
  }
  
  public ApolloGameData a(int paramInt)
  {
    Object localObject1;
    if (paramInt <= 0) {
      localObject1 = null;
    }
    ApolloGameData localApolloGameData2;
    do
    {
      return localObject1;
      if (this.e != null)
      {
        localObject1 = this.e;
        int n = 0;
        for (;;)
        {
          try
          {
            if (n >= this.e.size()) {
              break;
            }
            if (((ApolloGameData)this.e.get(n)).gameId == paramInt)
            {
              ApolloGameData localApolloGameData1 = (ApolloGameData)this.e.get(n);
              return localApolloGameData1;
            }
          }
          finally {}
          n += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return null;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localObject1 == null) {
        break;
      }
      localApolloGameData2 = (ApolloGameData)((EntityManager)localObject1).a(ApolloGameData.class, paramInt + "");
      localObject1 = localApolloGameData2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloDaoManager", 2, "findGameById from db");
    return localApolloGameData2;
    return null;
  }
  
  public ApolloGameData a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    List localList;
    if (this.e != null)
    {
      localList = this.e;
      int n = 0;
      for (;;)
      {
        try
        {
          if (n >= this.e.size()) {
            break;
          }
          if (paramString.equals(((ApolloGameData)this.e.get(n)).hotChatCode))
          {
            paramString = (ApolloGameData)this.e.get(n);
            return paramString;
          }
        }
        finally {}
        n += 1;
      }
    }
    return null;
  }
  
  public Pair a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "getFavPanelActionPairInfo");
    }
    List localList = d();
    Collections.sort(localList, new zcm(this));
    ArrayList localArrayList = new ArrayList(localList.size());
    int i2 = localList.size();
    int i1 = 0;
    int n = 1;
    if (i1 < i2)
    {
      Object localObject = (ApolloFavActionData)localList.get(i1);
      if (localObject == null) {
        break label190;
      }
      localObject = a(((ApolloFavActionData)localObject).acitonId);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    label190:
    for (;;)
    {
      i1 += 1;
      break;
      n = 0;
      continue;
      if (n == 0)
      {
        QLog.e("ApolloDaoManager", 1, "[getFavPanelActionPairInfo] has some action not exit and check action json");
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = false;
          ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(false, "getFavPanelActionPairInfo action not exit", 1);
        }
      }
      return new Pair(localList, localArrayList);
    }
  }
  
  public HashMap a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localHashMap.putAll(this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap);
    }
    return localHashMap;
  }
  
  public List a()
  {
    Integer localInteger = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return null;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        return this.jdField_a_of_type_JavaUtilList;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    Object localObject = ((EntityManager)localObject).a(ApolloActionData.class);
    if (QLog.isColorLevel()) {
      if (localObject != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[getActionList] db list size:", localInteger });
      return localObject;
      label90:
      localInteger = Integer.valueOf(((List)localObject).size());
    }
  }
  
  public List a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    for (;;)
    {
      int n;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        ArrayList localArrayList = new ArrayList();
        n = 0;
        if (n < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(n)).feeType == paramInt) {
            break label178;
          }
          localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(n));
          break label178;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).a(ApolloActionData.class, false, "feeType!=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label178:
      n += 1;
    }
  }
  
  public List a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.l != null) && (this.l.size() > 0))
    {
      Object localObject = new ArrayList(this.l);
      if ((paramInt > 0) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloGameRankData localApolloGameRankData = (ApolloGameRankData)((Iterator)localObject).next();
          if ((localApolloGameRankData != null) && (paramInt >= 0) && (paramString.equals(localApolloGameRankData.mFriendUin)))
          {
            localArrayList.add(localApolloGameRankData);
            paramInt -= 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public List a(SessionInfo paramSessionInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramSessionInfo == null)) {
      return null;
    }
    return c(paramSessionInfo.jdField_a_of_type_Int);
  }
  
  public List a(String paramString, int paramInt, List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.k != null) && (paramList != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      synchronized (this.k)
      {
        paramList = new ArrayList(paramList).iterator();
        n = paramInt;
        ApolloGameData localApolloGameData;
        if (paramList.hasNext())
        {
          localApolloGameData = (ApolloGameData)paramList.next();
          if (n >= -1) {}
        }
        else
        {
          return localArrayList;
        }
        Object localObject = a(localApolloGameData.gameId);
        if ((localObject == null) || (((ApolloGameData)localObject).isShow == 0)) {
          continue;
        }
        Iterator localIterator = new ArrayList(this.k).iterator();
        i1 = 0;
        paramInt = n;
        if (localIterator.hasNext())
        {
          ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)localIterator.next();
          if ((paramString.equals(localApolloGameScoreData.mUin)) && (localApolloGameData.gameId == localApolloGameScoreData.mGameId))
          {
            localArrayList.add(localApolloGameScoreData);
            n = paramInt - 1;
            paramInt = 1;
            break label306;
          }
        }
        else
        {
          n = paramInt;
          if (i1 != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "[getScoreDataByUin] append " + ((ApolloGameData)localObject).gameId);
          }
          localObject = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject).mUin = paramString;
          ((ApolloGameScoreData)localObject).mGameId = localApolloGameData.gameId;
          ((ApolloGameScoreData)localObject).mFromDb = false;
          localArrayList.add(localObject);
          n = paramInt - 1;
        }
      }
      int n = paramInt;
      paramInt = i1;
      break label306;
      return localArrayList;
      label306:
      int i1 = paramInt;
      paramInt = n;
    }
  }
  
  public List a(String arg1, String paramString2, int paramInt, List paramList)
  {
    Object localObject1 = a(???, paramInt, paramList);
    paramList = new ArrayList();
    if ((localObject1 != null) && (this.k != null)) {}
    for (;;)
    {
      synchronized (this.k)
      {
        localObject1 = ((List)localObject1).iterator();
        n = paramInt;
        ApolloGameScoreData localApolloGameScoreData1;
        if (((Iterator)localObject1).hasNext())
        {
          localApolloGameScoreData1 = (ApolloGameScoreData)((Iterator)localObject1).next();
          if (n >= -1) {}
        }
        else
        {
          return paramList;
        }
        Object localObject2 = a(localApolloGameScoreData1.mGameId);
        if ((localObject2 == null) || (((ApolloGameData)localObject2).isShow == 0)) {
          continue;
        }
        localObject2 = this.k.iterator();
        i1 = 0;
        paramInt = n;
        if (((Iterator)localObject2).hasNext())
        {
          ApolloGameScoreData localApolloGameScoreData2 = (ApolloGameScoreData)((Iterator)localObject2).next();
          if ((paramString2.equals(localApolloGameScoreData2.mUin)) && (localApolloGameScoreData1.mGameId == localApolloGameScoreData2.mGameId))
          {
            paramList.add(localApolloGameScoreData2);
            n = paramInt - 1;
            paramInt = 1;
            break label261;
          }
        }
        else
        {
          n = paramInt;
          if (i1 != 0) {
            continue;
          }
          localObject2 = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject2).mUin = paramString2;
          ((ApolloGameScoreData)localObject2).mGameId = localApolloGameScoreData1.mGameId;
          ((ApolloGameScoreData)localObject2).mFromDb = false;
          paramList.add(localObject2);
          n = paramInt - 1;
        }
      }
      int n = paramInt;
      paramInt = i1;
      break label261;
      return paramList;
      label261:
      int i1 = paramInt;
      paramInt = n;
    }
  }
  
  public ConcurrentHashMap a()
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)) {
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    Object localObject = f(0);
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)((Iterator)localObject).next();
        ApolloActionData localApolloActionData = new ApolloActionData();
        localApolloActionData.actionId = localApolloObtainedActionData.id;
        localApolloActionData.obtainedTime = localApolloObtainedActionData.beginTs;
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloActionData.actionId), localApolloActionData);
      }
    }
    return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = f();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.i("ApolloDaoManager", 1, "errInfo->gameList is null.");
      return;
    }
    for (;;)
    {
      ApolloGameData localApolloGameData;
      Object localObject2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
        localObject2 = new StringBuilder(100);
        ((StringBuilder)localObject2).append(ApolloConstant.n).append(localApolloGameData.gameId).append(File.separator).append("config.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists())
        {
          localStringBuilder.append("errInfo->game version file not exists, gameId: ").append(localApolloGameData.gameId);
          continue;
        }
        localObject2 = new JSONObject(FileUtils.b((File)localObject2)).optString("version");
      }
      catch (Exception localException)
      {
        QLog.e("ApolloDaoManager", 1, "catch errInfo:" + localException.getMessage());
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
      }
      localException.append("gId:").append(localApolloGameData.gameId).append(",ver: ").append((String)localObject2).append("===");
    }
    QLog.i("ApolloDaoManager", 1, localException.toString());
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = f();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.i("ApolloDaoManager", 1, "errInfo->gameList is null.");
      return;
    }
    for (;;)
    {
      ApolloGameData localApolloGameData;
      Object localObject2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
        if (paramInt != localApolloGameData.gameId) {
          continue;
        }
        localObject2 = new StringBuilder(100);
        ((StringBuilder)localObject2).append(ApolloConstant.n).append(localApolloGameData.gameId).append(File.separator).append("config.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists())
        {
          localStringBuilder.append("errInfo->game version file not exists, gameId: ").append(localApolloGameData.gameId);
          continue;
        }
        localObject2 = new JSONObject(FileUtils.b((File)localObject2)).optString("version");
      }
      catch (Exception localException)
      {
        QLog.e("ApolloDaoManager", 1, "catch errInfo:" + localException.getMessage());
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
      }
      localException.append("gId:").append(localApolloGameData.gameId).append(",ver: ").append((String)localObject2).append("===");
    }
    QLog.i("ApolloDaoManager", 1, localException.toString());
  }
  
  public void a(long paramLong)
  {
    if (this.g != null) {}
    EntityManager localEntityManager;
    do
    {
      synchronized (this.g)
      {
        Iterator localIterator = this.g.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionPush localApolloActionPush = (ApolloActionPush)localIterator.next();
          if ((localApolloActionPush != null) && (localApolloActionPush.mId == paramLong)) {
            this.g.remove(localApolloActionPush);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    ??? = localEntityManager.a();
    try
    {
      ((EntityTransaction)???).a();
      localEntityManager.b(" DELETE FROM ApolloActionPush WHERE mId = " + paramLong);
      ((EntityTransaction)???).c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).b();
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramBaseChatPie == null) || (paramBaseChatPie.a() == null)) {
      return;
    }
    Object localObject = (ApolloManager)paramBaseChatPie.a().getManager(152);
    boolean bool = ((ApolloManager)localObject).a(paramBaseChatPie.a().getCurrentAccountUin());
    int i1 = ((ApolloManager)localObject).a(paramBaseChatPie.a().getCurrentAccountUin());
    paramBaseChatPie = new ArrayList();
    localObject = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int n = 0;
    if (n < paramList.size())
    {
      ApolloActionData localApolloActionData = (ApolloActionData)paramList.get(n);
      if (b(localApolloActionData.actionId)) {
        paramBaseChatPie.add(localApolloActionData);
      }
      for (;;)
      {
        n += 1;
        break;
        if (!TextUtils.isEmpty(localApolloActionData.iconUrl)) {
          localArrayList1.add(localApolloActionData);
        } else if (a(localApolloActionData.actionId)) {
          ((List)localObject).add(localApolloActionData);
        } else if (localApolloActionData.feeType == 1) {
          localArrayList2.add(localApolloActionData);
        } else if (localApolloActionData.feeType == 9)
        {
          if ((bool) && (localApolloActionData.vipLevel <= i1))
          {
            localApolloActionData.obtainedTime = (localApolloActionData.version / 1000L);
            ((List)localObject).add(localApolloActionData);
          }
          else
          {
            localArrayList3.add(localApolloActionData);
          }
        }
        else {
          localArrayList3.add(localApolloActionData);
        }
      }
    }
    Collections.sort(paramBaseChatPie, new zco(this));
    Collections.sort(localArrayList1, new zcp(this));
    Collections.sort((List)localObject, new zcq(this));
    Collections.sort(localArrayList2, new zcr(this));
    Collections.sort(localArrayList3, new zcj(this));
    paramList.clear();
    paramList.addAll(paramBaseChatPie);
    paramList.addAll(localArrayList1);
    paramList.addAll((Collection)localObject);
    paramList.addAll(localArrayList2);
    paramList.addAll(localArrayList3);
  }
  
  public void a(AioPushData paramAioPushData)
  {
    if (paramAioPushData == null) {}
    for (;;)
    {
      return;
      if (this.m != null) {}
      boolean bool;
      EntityManager localEntityManager;
      synchronized (this.m)
      {
        bool = this.m.remove(paramAioPushData);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "[realDelAioPushData] from cache " + String.valueOf(bool));
        }
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.a();
        ((EntityTransaction)???).a();
      }
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int n = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (n >= 0)
        {
          if ((this.jdField_a_of_type_JavaUtilList.get(n) != null) && (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(n)).actionId == paramApolloActionData.actionId))
          {
            this.jdField_a_of_type_JavaUtilList.remove(n);
            this.jdField_a_of_type_JavaUtilList.add(n, paramApolloActionData);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).a(paramApolloActionData);
          return;
        }
        n -= 1;
      }
    }
  }
  
  public void a(ApolloActionPackage paramApolloActionPackage)
  {
    if ((paramApolloActionPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        int n = this.jdField_b_of_type_JavaUtilList.size() - 1;
        if (n >= 0)
        {
          if ((this.jdField_b_of_type_JavaUtilList.get(n) != null) && (((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(n)).packageId == paramApolloActionPackage.packageId))
          {
            this.jdField_b_of_type_JavaUtilList.remove(n);
            this.jdField_b_of_type_JavaUtilList.add(n, paramApolloActionPackage);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).a(paramApolloActionPackage);
          return;
        }
        n -= 1;
      }
    }
  }
  
  public void a(ApolloActionPush paramApolloActionPush)
  {
    if ((paramApolloActionPush == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (this.g != null) {}
    for (;;)
    {
      int n;
      Object localObject2;
      synchronized (this.g)
      {
        n = this.g.size() - 1;
        if (n >= 0)
        {
          localObject2 = (ApolloActionPush)this.g.get(n);
          if ((localObject2 != null) && (((ApolloActionPush)localObject2).mAioType == paramApolloActionPush.mAioType) && (((ApolloActionPush)localObject2).mSessionId == paramApolloActionPush.mSessionId)) {
            this.g.remove(localObject2);
          }
        }
        else
        {
          this.g.add(paramApolloActionPush);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (localObject2 == null) {
            break;
          }
          ??? = ((EntityManager)localObject2).a();
          ((EntityTransaction)???).a();
        }
      }
      n -= 1;
    }
  }
  
  public void a(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.jdField_d_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_d_of_type_JavaUtilList)
      {
        this.jdField_d_of_type_JavaUtilList.add(paramApolloFavActionData);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          continue;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.acitonId + " text=" + paramApolloFavActionData.text);
        }
        ((EntityManager)???).a(paramApolloFavActionData);
        return;
      }
    }
  }
  
  public void a(ApolloObtainedActionData paramApolloObtainedActionData)
  {
    if (paramApolloObtainedActionData == null) {}
    for (;;)
    {
      return;
      if (this.h != null) {}
      synchronized (this.h)
      {
        this.h.add(paramApolloObtainedActionData);
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          continue;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloObtainedActionData:" + paramApolloObtainedActionData.toString());
        }
        ((EntityManager)???).a(paramApolloObtainedActionData);
        return;
      }
    }
  }
  
  public void a(EntityManager paramEntityManager, List paramList)
  {
    if ((paramEntityManager != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (this.k != null)
      {
        this.k.removeAll(paramList);
        this.k.addAll(paramList);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)paramList.next();
        paramEntityManager.b(localApolloGameScoreData);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "[updateGameScore] ", localApolloGameScoreData });
        }
      }
    }
  }
  
  /* Error */
  public void a(ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +17 -> 18
    //   4: aload_1
    //   5: invokevirtual 650	java/util/ArrayList:size	()I
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield 52	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:f	Ljava/util/List;
    //   23: ifnull +113 -> 136
    //   26: aload_0
    //   27: getfield 52	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:f	Ljava/util/List;
    //   30: astore_2
    //   31: aload_2
    //   32: monitorenter
    //   33: aload_1
    //   34: invokevirtual 457	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   37: astore_3
    //   38: aload_3
    //   39: invokeinterface 162 1 0
    //   44: ifeq +90 -> 134
    //   47: aload_3
    //   48: invokeinterface 166 1 0
    //   53: checkcast 173	com/tencent/mobileqq/data/ApolloGameRoamData
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 52	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:f	Ljava/util/List;
    //   62: invokeinterface 156 1 0
    //   67: astore 5
    //   69: aload 5
    //   71: invokeinterface 162 1 0
    //   76: ifeq -38 -> 38
    //   79: aload 5
    //   81: invokeinterface 166 1 0
    //   86: checkcast 173	com/tencent/mobileqq/data/ApolloGameRoamData
    //   89: astore 6
    //   91: aload 4
    //   93: ifnull -24 -> 69
    //   96: aload 6
    //   98: ifnull -29 -> 69
    //   101: aload 6
    //   103: getfield 174	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   106: aload 4
    //   108: getfield 174	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   111: if_icmpne -42 -> 69
    //   114: aload_0
    //   115: getfield 52	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:f	Ljava/util/List;
    //   118: aload 6
    //   120: invokeinterface 556 2 0
    //   125: pop
    //   126: goto -88 -> 38
    //   129: astore_1
    //   130: aload_2
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: aload_2
    //   135: monitorexit
    //   136: aload_0
    //   137: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   140: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   143: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   146: astore_3
    //   147: aload_3
    //   148: ifnull -130 -> 18
    //   151: aload_3
    //   152: invokevirtual 287	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   155: astore_2
    //   156: aload_2
    //   157: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   160: aload_1
    //   161: invokevirtual 457	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   164: astore_1
    //   165: aload_1
    //   166: invokeinterface 162 1 0
    //   171: ifeq +61 -> 232
    //   174: aload_1
    //   175: invokeinterface 166 1 0
    //   180: checkcast 173	com/tencent/mobileqq/data/ApolloGameRoamData
    //   183: astore 4
    //   185: aload 4
    //   187: ifnull -22 -> 165
    //   190: aload_3
    //   191: new 263	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 652
    //   201: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 4
    //   206: getfield 174	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   209: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokevirtual 561	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   218: pop
    //   219: goto -54 -> 165
    //   222: astore_1
    //   223: aload_1
    //   224: invokevirtual 564	java/lang/Exception:printStackTrace	()V
    //   227: aload_2
    //   228: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   231: return
    //   232: aload_2
    //   233: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   236: aload_2
    //   237: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   240: return
    //   241: astore_1
    //   242: aload_2
    //   243: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   246: aload_1
    //   247: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	ApolloDaoManager
    //   0	248	1	paramArrayList	ArrayList
    //   30	213	2	localObject1	Object
    //   37	154	3	localObject2	Object
    //   56	149	4	localApolloGameRoamData1	ApolloGameRoamData
    //   67	13	5	localIterator	Iterator
    //   89	30	6	localApolloGameRoamData2	ApolloGameRoamData
    // Exception table:
    //   from	to	target	type
    //   33	38	129	finally
    //   38	69	129	finally
    //   69	91	129	finally
    //   101	126	129	finally
    //   130	132	129	finally
    //   134	136	129	finally
    //   156	165	222	java/lang/Exception
    //   165	185	222	java/lang/Exception
    //   190	219	222	java/lang/Exception
    //   232	236	222	java/lang/Exception
    //   156	165	241	finally
    //   165	185	241	finally
    //   190	219	241	finally
    //   223	227	241	finally
    //   232	236	241	finally
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localEntityManager != null)
      {
        ??? = localEntityManager.a();
        ((EntityTransaction)???).a();
      }
      try
      {
        localStringBuilder = new StringBuilder(500);
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          c(localApolloActionData);
          a(localEntityManager, localApolloActionData);
          if (QLog.isColorLevel())
          {
            localStringBuilder.append(" saveAction ID:").append(localApolloActionData.actionId);
            if (localStringBuilder.length() >= 500)
            {
              QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
              localStringBuilder.delete(0, localStringBuilder.length());
            }
          }
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "saveAction exception: ", localException);
        }
        ((EntityTransaction)???).b();
        while (this.jdField_a_of_type_JavaUtilList != null)
        {
          synchronized (this.jdField_a_of_type_JavaUtilList)
          {
            this.jdField_a_of_type_JavaUtilList.addAll(paramList);
            return;
          }
          if ((localStringBuilder.length() < 500) && (localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
            QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
          }
          ((EntityTransaction)???).c();
          ((EntityTransaction)???).b();
        }
      }
      finally
      {
        ((EntityTransaction)???).b();
      }
    }
  }
  
  /* Error */
  public void a(List paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: invokeinterface 232 1 0
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: new 33	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 34	java/util/ArrayList:<init>	()V
    //   28: astore 5
    //   30: aload_0
    //   31: getfield 67	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:m	Ljava/util/List;
    //   34: ifnull +277 -> 311
    //   37: aload_0
    //   38: getfield 67	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:m	Ljava/util/List;
    //   41: astore 6
    //   43: aload 6
    //   45: monitorenter
    //   46: aload_1
    //   47: invokestatic 659	java/util/Collections:sort	(Ljava/util/List;)V
    //   50: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   53: ldc2_w 216
    //   56: ldiv
    //   57: l2i
    //   58: istore_3
    //   59: aload_1
    //   60: invokeinterface 156 1 0
    //   65: astore 7
    //   67: aload 7
    //   69: invokeinterface 162 1 0
    //   74: ifeq +234 -> 308
    //   77: aload 7
    //   79: invokeinterface 166 1 0
    //   84: checkcast 219	com/tencent/mobileqq/data/AioPushData
    //   87: astore 8
    //   89: aload 8
    //   91: ifnull -24 -> 67
    //   94: aload 8
    //   96: getfield 225	com/tencent/mobileqq/data/AioPushData:begTs	I
    //   99: aload 8
    //   101: getfield 222	com/tencent/mobileqq/data/AioPushData:endTs	I
    //   104: if_icmpgt -37 -> 67
    //   107: aload 8
    //   109: getfield 222	com/tencent/mobileqq/data/AioPushData:endTs	I
    //   112: iload_3
    //   113: if_icmple -46 -> 67
    //   116: aload 8
    //   118: getfield 340	com/tencent/mobileqq/data/AioPushData:isShow	Z
    //   121: ifne -54 -> 67
    //   124: aload_0
    //   125: getfield 67	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:m	Ljava/util/List;
    //   128: aload 8
    //   130: invokeinterface 663 2 0
    //   135: istore 4
    //   137: iload 4
    //   139: iflt +67 -> 206
    //   142: aload_0
    //   143: getfield 67	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:m	Ljava/util/List;
    //   146: iload 4
    //   148: invokeinterface 244 2 0
    //   153: checkcast 219	com/tencent/mobileqq/data/AioPushData
    //   156: astore 9
    //   158: aload 9
    //   160: ifnull +27 -> 187
    //   163: aload 9
    //   165: getfield 340	com/tencent/mobileqq/data/AioPushData:isShow	Z
    //   168: ifeq +19 -> 187
    //   171: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +13 -> 187
    //   177: ldc_w 256
    //   180: iconst_2
    //   181: ldc_w 665
    //   184: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload 5
    //   189: aload 8
    //   191: invokeinterface 229 2 0
    //   196: pop
    //   197: goto -130 -> 67
    //   200: astore_1
    //   201: aload 6
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    //   206: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +31 -> 240
    //   212: ldc_w 256
    //   215: iconst_2
    //   216: new 263	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 667
    //   226: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 8
    //   231: invokevirtual 670	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: iload_2
    //   241: iconst_1
    //   242: if_icmpne +38 -> 280
    //   245: aload_0
    //   246: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: sipush 254
    //   252: invokevirtual 418	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   255: checkcast 672	com/tencent/mobileqq/app/HotChatCenterManager
    //   258: astore 9
    //   260: aload 9
    //   262: ifnull +33 -> 295
    //   265: aload 9
    //   267: aload 8
    //   269: getfield 331	com/tencent/mobileqq/data/AioPushData:them	Ljava/lang/String;
    //   272: aload 8
    //   274: getfield 675	com/tencent/mobileqq/data/AioPushData:wording	Ljava/lang/String;
    //   277: invokevirtual 678	com/tencent/mobileqq/app/HotChatCenterManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_0
    //   281: getfield 67	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:m	Ljava/util/List;
    //   284: aload 8
    //   286: invokeinterface 229 2 0
    //   291: pop
    //   292: goto -225 -> 67
    //   295: ldc_w 256
    //   298: iconst_1
    //   299: ldc_w 680
    //   302: invokestatic 414	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: goto -25 -> 280
    //   308: aload 6
    //   310: monitorexit
    //   311: aload_0
    //   312: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   315: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   318: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   321: astore 7
    //   323: aload 7
    //   325: ifnull +105 -> 430
    //   328: aload 7
    //   330: invokevirtual 287	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   333: astore 6
    //   335: aload 6
    //   337: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   340: aload 5
    //   342: invokeinterface 232 1 0
    //   347: ifle +12 -> 359
    //   350: aload_1
    //   351: aload 5
    //   353: invokeinterface 239 2 0
    //   358: pop
    //   359: aload_1
    //   360: invokeinterface 156 1 0
    //   365: astore_1
    //   366: aload_1
    //   367: invokeinterface 162 1 0
    //   372: ifeq +63 -> 435
    //   375: aload_0
    //   376: aload 7
    //   378: aload_1
    //   379: invokeinterface 166 1 0
    //   384: checkcast 219	com/tencent/mobileqq/data/AioPushData
    //   387: invokevirtual 301	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   390: pop
    //   391: goto -25 -> 366
    //   394: astore_1
    //   395: ldc_w 256
    //   398: iconst_1
    //   399: new 263	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 682
    //   409: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_1
    //   413: invokevirtual 530	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   416: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 414	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: aload 6
    //   427: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   430: aload_0
    //   431: invokespecial 684	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:h	()V
    //   434: return
    //   435: aload 6
    //   437: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   440: aload 6
    //   442: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   445: goto -15 -> 430
    //   448: astore_1
    //   449: aload 6
    //   451: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   454: aload_1
    //   455: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	ApolloDaoManager
    //   0	456	1	paramList	List
    //   0	456	2	paramInt	int
    //   58	56	3	n	int
    //   135	12	4	i1	int
    //   28	324	5	localArrayList	ArrayList
    //   41	409	6	localObject1	Object
    //   65	312	7	localObject2	Object
    //   87	198	8	localAioPushData	AioPushData
    //   156	110	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   46	67	200	finally
    //   67	89	200	finally
    //   94	137	200	finally
    //   142	158	200	finally
    //   163	187	200	finally
    //   187	197	200	finally
    //   201	204	200	finally
    //   206	240	200	finally
    //   245	260	200	finally
    //   265	280	200	finally
    //   280	292	200	finally
    //   295	305	200	finally
    //   308	311	200	finally
    //   340	359	394	java/lang/Exception
    //   359	366	394	java/lang/Exception
    //   366	391	394	java/lang/Exception
    //   435	440	394	java/lang/Exception
    //   340	359	448	finally
    //   359	366	448	finally
    //   366	391	448	finally
    //   395	425	448	finally
    //   435	440	448	finally
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    for (;;)
    {
      try
      {
        if (n < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(n);
          if (localJSONObject != null)
          {
            ApolloObtainedActionData localApolloObtainedActionData = new ApolloObtainedActionData();
            localApolloObtainedActionData.id = localJSONObject.optInt("id");
            localApolloObtainedActionData.beginTs = localJSONObject.optLong("beginTs");
            localApolloObtainedActionData.endts = localJSONObject.optLong("endts");
            localApolloObtainedActionData.way = localJSONObject.optInt("way");
            localApolloObtainedActionData.type = localJSONObject.optInt("type");
            localArrayList.add(localApolloObtainedActionData);
          }
        }
        else
        {
          g();
          i(localArrayList);
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("ApolloDaoManager", 1, "[saveApolloObtainedActionList] Exception =", paramJSONArray);
        return;
      }
      n += 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    return a().containsKey(Integer.valueOf(paramInt));
  }
  
  public boolean a(AioPushData paramAioPushData)
  {
    boolean bool = false;
    if ((paramAioPushData != null) && (this.m != null)) {
      synchronized (this.m)
      {
        if (this.m.indexOf(paramAioPushData) >= 0) {
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  public boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return paramEntityManager.a(paramEntity);
      }
    }
    QLog.d("ApolloDaoManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public ApolloActionData b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      for (;;)
      {
        int n;
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          n = this.jdField_a_of_type_JavaUtilList.size() - 1;
          if (n < 0) {
            break;
          }
          if (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(n)).actionId == paramInt)
          {
            ApolloActionData localApolloActionData = (ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(n);
            return localApolloActionData;
          }
        }
        n -= 1;
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.e("ApolloDaoManager", 2, new Object[] { "[findActionInCache] actionList no action:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public List b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    for (;;)
    {
      int n;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        ArrayList localArrayList = new ArrayList();
        n = 0;
        if (n < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(n)).isShow != 0) {
            break label170;
          }
          localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(n));
          break label170;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).a(ApolloActionData.class, false, "isShow=?", new String[] { String.valueOf(0) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label170:
      n += 1;
    }
  }
  
  public List b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    List localList = d(paramInt);
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < localList.size())
      {
        if (((ApolloActionData)localList.get(paramInt)).status == 0) {
          localArrayList.add(localList.get(paramInt));
        }
        paramInt += 1;
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return localArrayList;
      }
    }
    return null;
  }
  
  public ConcurrentHashMap b()
  {
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)) {
      return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    Object localObject = f(6);
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)((Iterator)localObject).next();
        if ((!a(localApolloObtainedActionData.id)) && (localApolloObtainedActionData.endts >= NetConnInfoCenter.getServerTime()))
        {
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionId = localApolloObtainedActionData.id;
          localApolloActionData.limitStart = localApolloObtainedActionData.beginTs;
          localApolloActionData.limitEnd = localApolloObtainedActionData.endts;
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloActionData.actionId), localApolloActionData);
        }
      }
    }
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      if (this.e != null) {}
      synchronized (this.e)
      {
        this.e.clear();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.a(ApolloGameData.class);
          if (localList != null) {
            ??? = localEntityManager.a();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).a();
      int n = 0;
      while (n < localList.size())
      {
        ApolloGameData localApolloGameData = (ApolloGameData)localList.get(n);
        if (localApolloGameData != null) {
          localEntityManager.b(localApolloGameData);
        }
        n += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      ((EntityTransaction)???).c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).b();
    }
  }
  
  /* Error */
  public void b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   12: ifnull +125 -> 137
    //   15: aload_0
    //   16: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   19: astore 7
    //   21: aload 7
    //   23: monitorenter
    //   24: iconst_1
    //   25: iload_1
    //   26: if_icmpne +165 -> 191
    //   29: aload_0
    //   30: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   33: invokeinterface 156 1 0
    //   38: astore 5
    //   40: aload 5
    //   42: invokeinterface 162 1 0
    //   47: ifeq +339 -> 386
    //   50: aload 5
    //   52: invokeinterface 166 1 0
    //   57: checkcast 246	com/tencent/mobileqq/data/ApolloActionPackage
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull -24 -> 40
    //   67: aload 6
    //   69: getfield 249	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   72: bipush 100
    //   74: if_icmpne -34 -> 40
    //   77: aload 6
    //   79: invokevirtual 765	com/tencent/mobileqq/data/ApolloActionPackage:getCopy	()Lcom/tencent/mobileqq/data/ApolloActionPackage;
    //   82: astore 6
    //   84: aload 6
    //   86: astore 5
    //   88: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +17 -> 108
    //   94: ldc_w 256
    //   97: iconst_2
    //   98: ldc_w 767
    //   101: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload 6
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   112: invokeinterface 321 1 0
    //   117: aload 5
    //   119: ifnull +15 -> 134
    //   122: aload_0
    //   123: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   126: aload 5
    //   128: invokeinterface 229 2 0
    //   133: pop
    //   134: aload 7
    //   136: monitorexit
    //   137: aload_0
    //   138: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   144: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   147: astore 6
    //   149: aload 6
    //   151: ifnull -144 -> 7
    //   154: aload 6
    //   156: invokevirtual 287	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   159: astore 5
    //   161: aload 5
    //   163: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   166: iconst_1
    //   167: iload_1
    //   168: if_icmpne +178 -> 346
    //   171: aload 6
    //   173: ldc_w 769
    //   176: invokevirtual 561	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   179: pop
    //   180: aload 5
    //   182: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   185: aload 5
    //   187: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   190: return
    //   191: iconst_2
    //   192: iload_1
    //   193: if_icmpne -59 -> 134
    //   196: iconst_m1
    //   197: istore_2
    //   198: aload_0
    //   199: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   202: invokeinterface 156 1 0
    //   207: astore 5
    //   209: iload_2
    //   210: istore 4
    //   212: aload 5
    //   214: invokeinterface 162 1 0
    //   219: ifeq +77 -> 296
    //   222: aload 5
    //   224: invokeinterface 166 1 0
    //   229: checkcast 246	com/tencent/mobileqq/data/ApolloActionPackage
    //   232: astore 6
    //   234: iload_2
    //   235: iconst_1
    //   236: iadd
    //   237: istore_3
    //   238: iload_3
    //   239: istore_2
    //   240: aload 6
    //   242: ifnull -33 -> 209
    //   245: iload_3
    //   246: istore_2
    //   247: aload 6
    //   249: getfield 249	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   252: bipush 100
    //   254: if_icmpne -45 -> 209
    //   257: iload_3
    //   258: istore 4
    //   260: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +33 -> 296
    //   266: ldc_w 256
    //   269: iconst_2
    //   270: new 263	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 771
    //   280: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload_3
    //   284: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iload_3
    //   294: istore 4
    //   296: iload 4
    //   298: ifle -164 -> 134
    //   301: aload_0
    //   302: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   305: iload 4
    //   307: invokeinterface 244 2 0
    //   312: checkcast 246	com/tencent/mobileqq/data/ApolloActionPackage
    //   315: getfield 249	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   318: bipush 100
    //   320: if_icmpne -186 -> 134
    //   323: aload_0
    //   324: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   327: iload 4
    //   329: invokeinterface 279 2 0
    //   334: pop
    //   335: goto -201 -> 134
    //   338: astore 5
    //   340: aload 7
    //   342: monitorexit
    //   343: aload 5
    //   345: athrow
    //   346: iconst_2
    //   347: iload_1
    //   348: if_icmpne -168 -> 180
    //   351: aload 6
    //   353: ldc_w 773
    //   356: invokevirtual 561	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   359: pop
    //   360: goto -180 -> 180
    //   363: astore 6
    //   365: aload 6
    //   367: invokevirtual 564	java/lang/Exception:printStackTrace	()V
    //   370: aload 5
    //   372: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   375: return
    //   376: astore 6
    //   378: aload 5
    //   380: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   383: aload 6
    //   385: athrow
    //   386: aconst_null
    //   387: astore 5
    //   389: goto -281 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	ApolloDaoManager
    //   0	392	1	paramInt	int
    //   197	50	2	n	int
    //   237	57	3	i1	int
    //   210	118	4	i2	int
    //   38	185	5	localObject1	Object
    //   338	41	5	localObject2	Object
    //   387	1	5	localObject3	Object
    //   60	292	6	localObject4	Object
    //   363	3	6	localException	Exception
    //   376	8	6	localObject5	Object
    //   19	322	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   29	40	338	finally
    //   40	62	338	finally
    //   67	84	338	finally
    //   88	104	338	finally
    //   108	117	338	finally
    //   122	134	338	finally
    //   134	137	338	finally
    //   198	209	338	finally
    //   212	234	338	finally
    //   247	257	338	finally
    //   260	293	338	finally
    //   301	335	338	finally
    //   340	343	338	finally
    //   161	166	363	java/lang/Exception
    //   171	180	363	java/lang/Exception
    //   180	185	363	java/lang/Exception
    //   351	360	363	java/lang/Exception
    //   161	166	376	finally
    //   171	180	376	finally
    //   180	185	376	finally
    //   351	360	376	finally
    //   365	370	376	finally
  }
  
  public void b(AioPushData paramAioPushData)
  {
    if ((paramAioPushData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloDaoManager", 1, "[removeAioPushData] app or data is null");
    }
    Object localObject2;
    do
    {
      return;
      if (this.m != null) {
        synchronized (this.m)
        {
          localObject2 = this.m.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            AioPushData localAioPushData = (AioPushData)((Iterator)localObject2).next();
            if (localAioPushData.equals(paramAioPushData)) {
              localAioPushData.isShow = true;
            }
          }
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localObject2 == null);
    ??? = ((EntityManager)localObject2).a();
    ((EntityTransaction)???).a();
    try
    {
      paramAioPushData.isShow = true;
      boolean bool = ((EntityManager)localObject2).a(paramAioPushData);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, "[removeAioPushData] " + String.valueOf(bool) + " # " + paramAioPushData);
      }
      ((EntityTransaction)???).c();
      return;
    }
    catch (Exception paramAioPushData)
    {
      QLog.e("ApolloDaoManager", 1, "removeAioPushData errInfo-> " + paramAioPushData.getMessage());
      return;
    }
    finally
    {
      ((EntityTransaction)???).b();
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int n = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (n >= 0)
        {
          if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(n) != null) && (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(n)).actionId == paramApolloActionData.actionId))
          {
            this.jdField_a_of_type_JavaUtilList.remove(n);
            this.jdField_a_of_type_JavaUtilList.add(n, paramApolloActionData);
          }
        }
        else
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).a(paramApolloActionData);
          return;
        }
        n -= 1;
      }
    }
  }
  
  public void b(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.jdField_d_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_d_of_type_JavaUtilList)
      {
        int n = this.jdField_d_of_type_JavaUtilList.size() - 1;
        if (n >= 0)
        {
          if (((ApolloFavActionData)this.jdField_d_of_type_JavaUtilList.get(n)).favId == paramApolloFavActionData.favId) {
            this.jdField_d_of_type_JavaUtilList.remove(n);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.toString());
          }
          ((EntityManager)???).b(paramApolloFavActionData);
          return;
        }
        n -= 1;
      }
    }
  }
  
  /* Error */
  public void b(EntityManager paramEntityManager, List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +134 -> 135
    //   4: aload_2
    //   5: ifnull +130 -> 135
    //   8: aload_2
    //   9: invokeinterface 232 1 0
    //   14: ifle +121 -> 135
    //   17: aload_0
    //   18: getfield 77	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:l	Ljava/util/List;
    //   21: ifnull +114 -> 135
    //   24: aload_0
    //   25: getfield 77	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:l	Ljava/util/List;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 77	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:l	Ljava/util/List;
    //   35: aload_2
    //   36: invokeinterface 239 2 0
    //   41: pop
    //   42: aload_0
    //   43: getfield 77	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:l	Ljava/util/List;
    //   46: aload_2
    //   47: invokeinterface 324 2 0
    //   52: pop
    //   53: aload_3
    //   54: monitorexit
    //   55: aload_2
    //   56: invokeinterface 156 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 162 1 0
    //   68: ifeq +67 -> 135
    //   71: aload_2
    //   72: invokeinterface 166 1 0
    //   77: checkcast 459	com/tencent/mobileqq/data/ApolloGameRankData
    //   80: astore_3
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 646	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   86: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq -27 -> 62
    //   92: ldc_w 256
    //   95: iconst_2
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 787
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload_3
    //   109: aastore
    //   110: invokestatic 353	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   113: goto -51 -> 62
    //   116: astore_1
    //   117: ldc_w 256
    //   120: iconst_1
    //   121: aload_1
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: ldc_w 789
    //   131: aastore
    //   132: invokestatic 792	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   135: return
    //   136: astore_1
    //   137: aload_3
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	ApolloDaoManager
    //   0	141	1	paramEntityManager	EntityManager
    //   0	141	2	paramList	List
    // Exception table:
    //   from	to	target	type
    //   24	31	116	java/lang/Throwable
    //   55	62	116	java/lang/Throwable
    //   62	113	116	java/lang/Throwable
    //   139	141	116	java/lang/Throwable
    //   31	55	136	finally
    //   137	139	136	finally
  }
  
  public void b(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] userPlayedList=", paramArrayList });
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    int i2 = paramArrayList.size();
    int i1 = 0;
    int n = 0;
    while (i1 < i2)
    {
      localObject1 = (ApolloGameRoamData)paramArrayList.get(i1);
      ((ApolloGameRoamData)localObject1).type = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] userPlayedList[", Integer.valueOf(i1), "], gameId=", Integer.valueOf(((ApolloGameRoamData)localObject1).gameId) });
      }
      if ((n != 0) || (a((ApolloGameRoamData)localObject1))) {
        break label758;
      }
      ThreadManager.post(new zck(this, (ApolloGameRoamData)localObject1), 5, null, true);
      n = 1;
      label156:
      i1 += 1;
    }
    Object localObject3 = new ArrayList();
    Object localObject1 = null;
    Object localObject2 = null;
    if (this.f != null) {}
    label768:
    label775:
    for (;;)
    {
      synchronized (this.f)
      {
        if (this.f.size() > 0)
        {
          localObject1 = new ArrayList();
          i2 = paramArrayList.size();
          n = 0;
          if (n < i2)
          {
            localObject2 = (ApolloGameRoamData)paramArrayList.get(n);
            int i3 = this.f.size();
            i1 = 0;
            if (i1 >= i3) {
              break label761;
            }
            ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)this.f.get(i1);
            if (((ApolloGameRoamData)localObject2).gameId == localApolloGameRoamData.gameId)
            {
              localApolloGameRoamData.type = 2;
              ((ArrayList)localObject3).add(localApolloGameRoamData);
              break label761;
            }
            if (i1 != i3 - 1) {
              break label768;
            }
            ((ArrayList)localObject1).add(localObject2);
            break label768;
          }
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label755;
          }
          i1 = ((ArrayList)localObject1).size();
          n = 0;
          if (n >= i1) {
            break label775;
          }
          localObject2 = (ApolloGameRoamData)((ArrayList)localObject1).get(n);
          this.f.add(n, localObject2);
          n += 1;
          continue;
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            break;
          }
          localObject2 = ((EntityManager)???).a();
          ((EntityTransaction)localObject2).a();
          if (localObject1 == null) {
            break label613;
          }
        }
      }
      try
      {
        if (((ArrayList)localObject1).size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "[saveUserPlayedGameRoamData] clear and rewrite game list");
          }
          ((EntityManager)???).b(" DELETE FROM ApolloGameRoamData ");
          if (this.f != null) {
            paramArrayList = this.f;
          }
          i1 = paramArrayList.size();
          n = 0;
          while (n < i1)
          {
            localObject1 = (ApolloGameRoamData)paramArrayList.get(n);
            localObject3 = new ApolloGameRoamData();
            ((ApolloGameRoamData)localObject3).gameId = ((ApolloGameRoamData)localObject1).gameId;
            ((ApolloGameRoamData)localObject3).type = ((ApolloGameRoamData)localObject1).type;
            a((EntityManager)???, (Entity)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] add game, id=", Integer.valueOf(((ApolloGameRoamData)localObject3).gameId), ", type=", Integer.valueOf(((ApolloGameRoamData)localObject3).type) });
            }
            n += 1;
          }
          this.f.addAll(paramArrayList);
          ((ArrayList)localObject3).addAll(paramArrayList);
          localObject1 = localObject2;
          continue;
          paramArrayList = finally;
          throw paramArrayList;
        }
        label613:
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "[saveUserPlayedGameRoamData] just update type");
        }
        paramArrayList = ((ArrayList)localObject3).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (ApolloGameRoamData)paramArrayList.next();
          a((EntityManager)???, (Entity)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] update game, id=", Integer.valueOf(((ApolloGameRoamData)localObject1).gameId), ", type=", Integer.valueOf(((ApolloGameRoamData)localObject1).type) });
          }
        }
        continue;
      }
      catch (Exception paramArrayList)
      {
        QLog.e("ApolloDaoManager", 1, "[saveUserPlayedGameRoamData] update db error=", paramArrayList);
        return;
        ((EntityTransaction)localObject2).c();
        return;
      }
      finally
      {
        ((EntityTransaction)localObject2).b();
      }
      label755:
      label758:
      break label156;
      label761:
      n += 1;
      continue;
      i1 += 1;
    }
  }
  
  public void b(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramList == null)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null)) {}
    for (;;)
    {
      int n;
      int i1;
      EntityManager localEntityManager;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        n = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (n >= 0)
        {
          i1 = paramList.size() - 1;
          if (i1 <= 0) {
            break label230;
          }
          if (((ApolloActionData)paramList.get(i1)).actionId != ((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(n)).actionId) {
            break label223;
          }
          this.jdField_a_of_type_JavaUtilList.remove(n);
          this.jdField_a_of_type_JavaUtilList.add(n, paramList.get(i1));
          break label223;
        }
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        ??? = localEntityManager.a();
      }
      try
      {
        ((EntityTransaction)???).a();
        n = 0;
        while (n < paramList.size())
        {
          a(localEntityManager, (Entity)paramList.get(n));
          n += 1;
          continue;
          paramList = finally;
          throw paramList;
        }
        ((EntityTransaction)???).c();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)???).b();
      }
      label223:
      i1 -= 1;
      continue;
      label230:
      n -= 1;
    }
  }
  
  public boolean b(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = b();
    if (localConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      if (((ApolloActionData)localConcurrentHashMap.get(Integer.valueOf(paramInt))).limitEnd >= NetConnInfoCenter.getServerTime()) {
        return true;
      }
      localConcurrentHashMap.remove(Integer.valueOf(paramInt));
      ThreadManager.post(new zcn(this, paramInt), 5, null, true);
    }
    return false;
  }
  
  public List c()
  {
    label122:
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        List localList = (List)a().second;
        int n;
        if ((localList != null) && (localList.size() > 0))
        {
          localObject1 = new ArrayList();
          n = 0;
          if (n < localList.size())
          {
            if (((ApolloActionData)localList.get(n)).status != 0) {
              break label122;
            }
            ((List)localObject1).add(localList.get(n));
            break label122;
          }
          if (localObject1 != null)
          {
            n = ((List)localObject1).size();
            if (n > 0) {
              continue;
            }
          }
        }
        localObject1 = null;
        continue;
        n += 1;
      }
      finally {}
    }
  }
  
  public List c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    do
    {
      return null;
      if ((paramInt == 0) || (paramInt == 1)) {
        localObject1 = String.valueOf(paramInt);
      }
      while ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        localObject2 = new ArrayList();
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
          {
            if ((((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(paramInt)).sessionType == Integer.parseInt((String)localObject1)) || (((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(paramInt)).sessionType == 0)) {
              ((List)localObject2).add(this.jdField_b_of_type_JavaUtilList.get(paramInt));
            }
            paramInt += 1;
            continue;
            if (paramInt == 3000)
            {
              localObject1 = String.valueOf(1);
              break;
            }
            QLog.e("ApolloDaoManager", 1, "[getPackageInfoBySession], error type:" + paramInt);
            return null;
          }
        }
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "return packageInfoBySession from cache");
          }
          h((List)localObject2);
          return localObject2;
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localObject2 == null);
    Object localObject1 = ((EntityManager)localObject2).a(ApolloActionPackage.class, false, "sessionType=? or sessionType=?", new String[] { "0", localObject1 }, null, null, null, null);
    h((List)localObject1);
    return localObject1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      QLog.i("ApolloDaoManager", 1, "removeAllAction");
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          this.jdField_a_of_type_Int = 1;
        }
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.a(ApolloActionData.class);
          if (localList != null) {
            ??? = localEntityManager.a();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).a();
      int n = 0;
      while (n < localList.size())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)localList.get(n);
        if (localApolloActionData != null) {
          localEntityManager.b(localApolloActionData);
        }
        n += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      ((EntityTransaction)???).c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).b();
    }
  }
  
  /* Error */
  public void c(EntityManager paramEntityManager, List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +124 -> 125
    //   4: aload_2
    //   5: ifnull +120 -> 125
    //   8: aload_2
    //   9: invokeinterface 232 1 0
    //   14: ifle +111 -> 125
    //   17: aload_0
    //   18: getfield 77	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:l	Ljava/util/List;
    //   21: ifnull +104 -> 125
    //   24: aload_0
    //   25: getfield 77	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:l	Ljava/util/List;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 77	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:l	Ljava/util/List;
    //   35: aload_2
    //   36: invokeinterface 239 2 0
    //   41: pop
    //   42: aload_3
    //   43: monitorexit
    //   44: aload_2
    //   45: invokeinterface 156 1 0
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 162 1 0
    //   57: ifeq +68 -> 125
    //   60: aload_2
    //   61: invokeinterface 166 1 0
    //   66: checkcast 459	com/tencent/mobileqq/data/ApolloGameRankData
    //   69: astore_3
    //   70: aload_1
    //   71: aload_3
    //   72: invokevirtual 614	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   75: pop
    //   76: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq -28 -> 51
    //   82: ldc_w 256
    //   85: iconst_2
    //   86: iconst_2
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: ldc_w 787
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_3
    //   99: aastore
    //   100: invokestatic 353	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   103: goto -52 -> 51
    //   106: astore_1
    //   107: ldc_w 256
    //   110: iconst_1
    //   111: aload_1
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 863
    //   121: aastore
    //   122: invokestatic 792	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   125: return
    //   126: astore_1
    //   127: aload_3
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ApolloDaoManager
    //   0	131	1	paramEntityManager	EntityManager
    //   0	131	2	paramList	List
    // Exception table:
    //   from	to	target	type
    //   24	31	106	java/lang/Throwable
    //   44	51	106	java/lang/Throwable
    //   51	103	106	java/lang/Throwable
    //   129	131	106	java/lang/Throwable
    //   31	44	126	finally
    //   127	129	126	finally
  }
  
  /* Error */
  public void c(ArrayList paramArrayList)
  {
    // Byte code:
    //   0: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 256
    //   9: iconst_2
    //   10: ldc_w 865
    //   13: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: invokevirtual 650	java/util/ArrayList:size	()I
    //   24: ifne +14 -> 38
    //   27: ldc_w 256
    //   30: iconst_1
    //   31: ldc_w 867
    //   34: invokestatic 870	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: ldc_w 256
    //   41: iconst_1
    //   42: new 263	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 872
    //   52: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 650	java/util/ArrayList:size	()I
    //   59: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 505	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_1
    //   69: invokevirtual 457	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   72: astore_2
    //   73: aload_2
    //   74: invokeinterface 162 1 0
    //   79: ifeq +33 -> 112
    //   82: aload_0
    //   83: aload_2
    //   84: invokeinterface 166 1 0
    //   89: checkcast 173	com/tencent/mobileqq/data/ApolloGameRoamData
    //   92: invokespecial 802	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(Lcom/tencent/mobileqq/data/ApolloGameRoamData;)Z
    //   95: ifne -22 -> 73
    //   98: new 874	zcl
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 875	zcl:<init>	(Lcom/tencent/mobileqq/apollo/utils/ApolloDaoManager;)V
    //   106: iconst_5
    //   107: aconst_null
    //   108: iconst_1
    //   109: invokestatic 810	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   112: aload_0
    //   113: getfield 52	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:f	Ljava/util/List;
    //   116: ifnull +24 -> 140
    //   119: aload_0
    //   120: getfield 52	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:f	Ljava/util/List;
    //   123: astore_2
    //   124: aload_2
    //   125: monitorenter
    //   126: aload_0
    //   127: getfield 52	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:f	Ljava/util/List;
    //   130: iconst_0
    //   131: aload_1
    //   132: invokeinterface 878 3 0
    //   137: pop
    //   138: aload_2
    //   139: monitorexit
    //   140: aload_0
    //   141: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   144: ifnull -107 -> 37
    //   147: aload_0
    //   148: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   151: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   154: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   157: astore_3
    //   158: aload_3
    //   159: ifnull -122 -> 37
    //   162: aload_3
    //   163: invokevirtual 287	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   171: new 263	java/lang/StringBuilder
    //   174: dup
    //   175: sipush 500
    //   178: invokespecial 294	java/lang/StringBuilder:<init>	(I)V
    //   181: astore 4
    //   183: aload_1
    //   184: invokevirtual 457	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   187: astore_1
    //   188: aload_1
    //   189: invokeinterface 162 1 0
    //   194: ifeq +76 -> 270
    //   197: aload_1
    //   198: invokeinterface 166 1 0
    //   203: checkcast 173	com/tencent/mobileqq/data/ApolloGameRoamData
    //   206: astore 5
    //   208: aload_0
    //   209: aload_3
    //   210: aload 5
    //   212: invokevirtual 301	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   215: pop
    //   216: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq -31 -> 188
    //   222: aload 4
    //   224: ldc_w 880
    //   227: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 5
    //   232: getfield 174	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   235: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: goto -51 -> 188
    //   242: astore_1
    //   243: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +14 -> 260
    //   249: ldc_w 256
    //   252: iconst_2
    //   253: ldc_w 882
    //   256: aload_1
    //   257: invokestatic 656	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload_2
    //   261: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   264: return
    //   265: astore_1
    //   266: aload_2
    //   267: monitorexit
    //   268: aload_1
    //   269: athrow
    //   270: aload 4
    //   272: invokevirtual 307	java/lang/StringBuilder:length	()I
    //   275: sipush 500
    //   278: if_icmpge +21 -> 299
    //   281: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +15 -> 299
    //   287: ldc_w 256
    //   290: iconst_2
    //   291: aload 4
    //   293: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_2
    //   300: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   303: aload_2
    //   304: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   307: return
    //   308: astore_1
    //   309: aload_2
    //   310: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   313: aload_1
    //   314: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	ApolloDaoManager
    //   0	315	1	paramArrayList	ArrayList
    //   72	238	2	localObject	Object
    //   157	53	3	localEntityManager	EntityManager
    //   181	111	4	localStringBuilder	StringBuilder
    //   206	25	5	localApolloGameRoamData	ApolloGameRoamData
    // Exception table:
    //   from	to	target	type
    //   171	188	242	java/lang/Exception
    //   188	239	242	java/lang/Exception
    //   270	299	242	java/lang/Exception
    //   299	303	242	java/lang/Exception
    //   126	140	265	finally
    //   266	268	265	finally
    //   171	188	308	finally
    //   188	239	308	finally
    //   243	260	308	finally
    //   270	299	308	finally
    //   299	303	308	finally
  }
  
  public void c(List paramList)
  {
    int n = 0;
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      EntityManager localEntityManager;
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if ((paramList.size() == 1) && (paramList.get(0) != null) && (((ApolloActionPackage)paramList.get(0)).packageId == 100)) {
          if (n < this.jdField_b_of_type_JavaUtilList.size())
          {
            if (((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(n)).packageId == 100)
            {
              this.jdField_b_of_type_JavaUtilList.remove(n);
              QLog.i("ApolloDaoManager", 1, "repeat game package.");
            }
          }
          else
          {
            this.jdField_b_of_type_JavaUtilList.add(0, paramList.get(0));
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "add game package.");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break;
            }
            localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
            if (localEntityManager == null) {
              break;
            }
            ??? = localEntityManager.a();
            ((EntityTransaction)???).a();
          }
        }
      }
      try
      {
        localStringBuilder = new StringBuilder(200);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)paramList.next();
          a(localEntityManager, localApolloActionPackage);
          localStringBuilder.append(" savePackage ID:").append(localApolloActionPackage.packageId);
          if (localStringBuilder.length() >= 200)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
            }
            localStringBuilder.delete(0, localStringBuilder.length());
          }
        }
      }
      catch (Exception paramList)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "saveAction exception: ", paramList);
        }
        return;
        n += 1;
        continue;
        this.jdField_b_of_type_JavaUtilList.addAll(paramList);
        continue;
        paramList = finally;
        throw paramList;
        if ((localStringBuilder.length() < 200) && (QLog.isColorLevel())) {
          QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
        }
        ((EntityTransaction)???).c();
        return;
      }
      finally
      {
        ((EntityTransaction)???).b();
      }
    }
  }
  
  public List d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (this.jdField_d_of_type_JavaUtilList != null) {
      localObject = this.jdField_d_of_type_JavaUtilList;
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return localObject;
        localObject = localArrayList;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject = localArrayList;
    } while (localEntityManager == null);
    return localEntityManager.a(ApolloFavActionData.class);
  }
  
  public List d(int paramInt)
  {
    ??? = null;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int n;
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0))
    {
      ??? = this.jdField_c_of_type_JavaUtilList;
      n = 0;
    }
    for (;;)
    {
      try
      {
        if (n < this.jdField_c_of_type_JavaUtilList.size())
        {
          if (((ApolloActionPackageData)this.jdField_c_of_type_JavaUtilList.get(n)).packageId != paramInt) {
            break label459;
          }
          localArrayList1.add(this.jdField_c_of_type_JavaUtilList.get(n));
          break label459;
        }
        if (localArrayList1 == null) {
          break label453;
        }
        paramInt = 0;
        n = 1;
        if (paramInt >= localArrayList1.size()) {
          break label399;
        }
        ??? = a(((ApolloActionPackageData)localArrayList1.get(paramInt)).acitonId);
        if (??? == null) {
          break label297;
        }
        localArrayList2.add(???);
        paramInt += 1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label180;
        }
      }
      finally {}
      return null;
      label180:
      Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localObject5 != null)
      {
        localObject5 = ((EntityManager)localObject5).a(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
        if (QLog.isColorLevel()) {
          if (localObject5 != null) {
            break label283;
          }
        }
        label283:
        for (Object localObject2 = ???;; localObject2 = Integer.valueOf(((List)localObject5).size()))
        {
          QLog.d("ApolloDaoManager", 2, new Object[] { "getActionByPackageId from db, size:", localObject2 });
          localObject2 = localObject5;
          break;
        }
        label297:
        if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0))
        {
          synchronized (this.jdField_c_of_type_JavaUtilList)
          {
            this.jdField_c_of_type_JavaUtilList.remove(((List)localObject2).get(paramInt));
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "remove paciton id=" + ((ApolloActionPackageData)((List)localObject2).get(paramInt)).acitonId);
            }
          }
          if (n == 0)
          {
            QLog.e("ApolloDaoManager", 1, "[getActionByPackageId] has some action not exit and check action json");
            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Boolean))
            {
              this.jdField_a_of_type_Boolean = false;
              ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(false, "getActionByPackageId action not exit", 1);
            }
          }
          label453:
          return localArrayList2;
        }
      }
      else
      {
        label399:
        continue;
        label459:
        n += 1;
        continue;
      }
      n = 0;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[remvoeAllGameModeData]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      if (this.i != null) {}
      EntityManager localEntityManager;
      synchronized (this.i)
      {
        this.i.clear();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.a();
      }
    }
  }
  
  /* Error */
  public void d(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 232 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 69	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:i	Ljava/util/List;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 69	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:i	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 69	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:i	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 324 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: ifnull -32 -> 13
    //   48: aload_0
    //   49: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   55: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -47 -> 13
    //   63: aload_3
    //   64: invokevirtual 287	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   72: aload_1
    //   73: invokeinterface 156 1 0
    //   78: astore_1
    //   79: aload_1
    //   80: invokeinterface 162 1 0
    //   85: ifeq +85 -> 170
    //   88: aload_1
    //   89: invokeinterface 166 1 0
    //   94: checkcast 908	com/tencent/mobileqq/data/ApolloGameModeData
    //   97: astore 4
    //   99: aload_0
    //   100: aload_3
    //   101: aload 4
    //   103: invokevirtual 301	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   106: pop
    //   107: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq -31 -> 79
    //   113: ldc_w 256
    //   116: iconst_2
    //   117: new 263	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 910
    //   127: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 4
    //   132: getfield 913	com/tencent/mobileqq/data/ApolloGameModeData:mGameMode	I
    //   135: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: goto -65 -> 79
    //   147: astore_1
    //   148: ldc_w 256
    //   151: iconst_1
    //   152: aload_1
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 792	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   160: aload_2
    //   161: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   164: return
    //   165: astore_1
    //   166: aload_2
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    //   170: aload_2
    //   171: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   174: aload_2
    //   175: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   178: return
    //   179: astore_1
    //   180: aload_2
    //   181: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   184: aload_1
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	ApolloDaoManager
    //   0	186	1	paramList	List
    //   25	156	2	localObject	Object
    //   58	43	3	localEntityManager	EntityManager
    //   97	34	4	localApolloGameModeData	com.tencent.mobileqq.data.ApolloGameModeData
    // Exception table:
    //   from	to	target	type
    //   72	79	147	java/lang/Exception
    //   79	144	147	java/lang/Exception
    //   170	174	147	java/lang/Exception
    //   28	41	165	finally
    //   166	168	165	finally
    //   72	79	179	finally
    //   79	144	179	finally
    //   148	160	179	finally
    //   170	174	179	finally
  }
  
  public List e()
  {
    ArrayList localArrayList = new ArrayList();
    List localList1;
    int n;
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      localList1 = this.jdField_d_of_type_JavaUtilList;
      n = 0;
    }
    for (;;)
    {
      try
      {
        if (n < this.jdField_d_of_type_JavaUtilList.size())
        {
          ApolloActionData localApolloActionData = a(((ApolloFavActionData)this.jdField_d_of_type_JavaUtilList.get(n)).acitonId);
          if (localApolloActionData == null) {
            break label103;
          }
          localArrayList.add(localApolloActionData);
          break label103;
        }
        return localArrayList;
      }
      finally {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloDaoManager", 2, "favActionList is null");
      return localList2;
      label103:
      n += 1;
    }
    return localList2;
  }
  
  public List e(int paramInt)
  {
    ??? = null;
    int n = 0;
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0)) {}
    List localList;
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        if (n < this.jdField_c_of_type_JavaUtilList.size())
        {
          if (((ApolloActionPackageData)this.jdField_c_of_type_JavaUtilList.get(n)).packageId != paramInt) {
            break label259;
          }
          localArrayList.add(this.jdField_c_of_type_JavaUtilList.get(n));
          break label259;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from cache, size:", Integer.valueOf(localArrayList.size()) });
        }
        return localArrayList;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localEntityManager != null) {
        localList = localEntityManager.a(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          if (localList != null) {
            break label242;
          }
        }
        for (;;)
        {
          QLog.d("ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from db, size:", ??? });
          return localList;
          label242:
          ??? = Integer.valueOf(localList.size());
        }
      }
      label259:
      n += 1;
    }
    return localList;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[removeGameRoamData]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      if (this.f != null) {}
      EntityManager localEntityManager;
      synchronized (this.f)
      {
        this.f.clear();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.a();
      }
    }
  }
  
  /* Error */
  public void e(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 232 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 46	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 46	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 46	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 324 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: ifnull -32 -> 13
    //   48: aload_0
    //   49: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   55: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -47 -> 13
    //   63: aload_3
    //   64: invokevirtual 287	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   72: new 263	java/lang/StringBuilder
    //   75: dup
    //   76: sipush 500
    //   79: invokespecial 294	java/lang/StringBuilder:<init>	(I)V
    //   82: astore 4
    //   84: aload_1
    //   85: invokeinterface 156 1 0
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 162 1 0
    //   97: ifeq +117 -> 214
    //   100: aload_1
    //   101: invokeinterface 166 1 0
    //   106: checkcast 890	com/tencent/mobileqq/data/ApolloActionPackageData
    //   109: astore 5
    //   111: aload_0
    //   112: aload_3
    //   113: aload 5
    //   115: invokevirtual 301	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   118: pop
    //   119: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +20 -> 142
    //   125: aload 4
    //   127: ldc_w 923
    //   130: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 5
    //   135: getfield 892	com/tencent/mobileqq/data/ApolloActionPackageData:acitonId	I
    //   138: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 4
    //   144: invokevirtual 307	java/lang/StringBuilder:length	()I
    //   147: sipush 500
    //   150: if_icmplt -59 -> 91
    //   153: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -65 -> 91
    //   159: ldc_w 256
    //   162: iconst_2
    //   163: aload 4
    //   165: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 4
    //   173: iconst_0
    //   174: aload 4
    //   176: invokevirtual 307	java/lang/StringBuilder:length	()I
    //   179: invokevirtual 311	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: goto -92 -> 91
    //   186: astore_1
    //   187: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +14 -> 204
    //   193: ldc_w 256
    //   196: iconst_2
    //   197: ldc_w 654
    //   200: aload_1
    //   201: invokestatic 656	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: aload_2
    //   205: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   208: return
    //   209: astore_1
    //   210: aload_2
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: aload 4
    //   216: invokevirtual 307	java/lang/StringBuilder:length	()I
    //   219: sipush 500
    //   222: if_icmpge +21 -> 243
    //   225: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +15 -> 243
    //   231: ldc_w 256
    //   234: iconst_2
    //   235: aload 4
    //   237: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   247: aload_2
    //   248: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   251: return
    //   252: astore_1
    //   253: aload_2
    //   254: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   257: aload_1
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	ApolloDaoManager
    //   0	259	1	paramList	List
    //   25	229	2	localObject	Object
    //   58	55	3	localEntityManager	EntityManager
    //   82	154	4	localStringBuilder	StringBuilder
    //   109	25	5	localApolloActionPackageData	ApolloActionPackageData
    // Exception table:
    //   from	to	target	type
    //   72	91	186	java/lang/Exception
    //   91	142	186	java/lang/Exception
    //   142	183	186	java/lang/Exception
    //   214	243	186	java/lang/Exception
    //   243	247	186	java/lang/Exception
    //   28	41	209	finally
    //   210	212	209	finally
    //   72	91	252	finally
    //   91	142	252	finally
    //   142	183	252	finally
    //   187	204	252	finally
    //   214	243	252	finally
    //   243	247	252	finally
  }
  
  public List f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return null;
      if ((this.e != null) && (this.e.size() > 0)) {
        synchronized (this.e)
        {
          ArrayList localArrayList = new ArrayList(this.e.size());
          localArrayList.addAll(this.e);
          return localArrayList;
        }
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (??? == null);
    return ((EntityManager)???).a(ApolloGameData.class);
  }
  
  public List f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.h != null) && (this.h.size() > 0))
    {
      List localList1 = this.h;
      int n = 0;
      for (;;)
      {
        try
        {
          if (n < this.h.size())
          {
            if (((ApolloObtainedActionData)this.h.get(n)).type != paramInt) {
              break label112;
            }
            localArrayList.add(this.h.get(n));
          }
        }
        finally {}
        label112:
        n += 1;
      }
    }
    return localList2;
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_JavaUtilList != null) {}
    EntityManager localEntityManager;
    do
    {
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    ??? = localEntityManager.a();
    try
    {
      ((EntityTransaction)???).a();
      localEntityManager.b(" DELETE FROM ApolloActionPackageData ");
      ((EntityTransaction)???).c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).b();
    }
  }
  
  /* Error */
  public void f(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 232 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 50	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:e	Ljava/util/List;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 50	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:e	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 50	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:e	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 324 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: ifnull -32 -> 13
    //   48: aload_0
    //   49: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   55: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -47 -> 13
    //   63: aload_3
    //   64: invokevirtual 287	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   72: aload_1
    //   73: invokeinterface 156 1 0
    //   78: astore_1
    //   79: aload_1
    //   80: invokeinterface 162 1 0
    //   85: ifeq +90 -> 175
    //   88: aload_1
    //   89: invokeinterface 166 1 0
    //   94: checkcast 168	com/tencent/mobileqq/data/ApolloGameData
    //   97: astore 4
    //   99: aload_0
    //   100: aload_3
    //   101: aload 4
    //   103: invokevirtual 301	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   106: pop
    //   107: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq -31 -> 79
    //   113: ldc_w 256
    //   116: iconst_2
    //   117: new 263	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 927
    //   127: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 4
    //   132: getfield 171	com/tencent/mobileqq/data/ApolloGameData:gameId	I
    //   135: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: goto -65 -> 79
    //   147: astore_1
    //   148: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +14 -> 165
    //   154: ldc_w 256
    //   157: iconst_2
    //   158: ldc_w 929
    //   161: aload_1
    //   162: invokestatic 656	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload_2
    //   166: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   169: return
    //   170: astore_1
    //   171: aload_2
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: aload_2
    //   176: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   179: aload_2
    //   180: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   183: return
    //   184: astore_1
    //   185: aload_2
    //   186: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	ApolloDaoManager
    //   0	191	1	paramList	List
    //   25	161	2	localObject	Object
    //   58	43	3	localEntityManager	EntityManager
    //   97	34	4	localApolloGameData	ApolloGameData
    // Exception table:
    //   from	to	target	type
    //   72	79	147	java/lang/Exception
    //   79	144	147	java/lang/Exception
    //   175	179	147	java/lang/Exception
    //   28	41	170	finally
    //   171	173	170	finally
    //   72	79	184	finally
    //   79	144	184	finally
    //   148	165	184	finally
    //   175	179	184	finally
  }
  
  public List g()
  {
    ??? = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return ???;
          if ((this.f != null) && (this.f.size() > 0)) {
            synchronized (this.f)
            {
              ArrayList localArrayList = new ArrayList(this.f.size());
              localArrayList.addAll(this.f);
              return localArrayList;
            }
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        } while (localObject3 == null);
        localObject3 = ((EntityManager)localObject3).a(ApolloGameRoamData.class);
        ??? = localObject3;
      } while (this.f == null);
      ??? = localObject3;
    } while (localObject3 == null);
    synchronized (this.f)
    {
      this.f.addAll((Collection)localObject3);
      return localObject3;
    }
  }
  
  public List g(int paramInt)
  {
    if ((this.l != null) && (paramInt >= 0))
    {
      if (paramInt >= this.l.size()) {
        return new ArrayList(this.l);
      }
      return new ArrayList(this.l.subList(0, paramInt));
    }
    return null;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      if (this.h != null) {}
      synchronized (this.h)
      {
        this.h.clear();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.a(ApolloObtainedActionData.class);
          if (localList != null) {
            ??? = localEntityManager.a();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).a();
      int n = 0;
      while (n < localList.size())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)localList.get(n);
        if (localApolloObtainedActionData != null) {
          localEntityManager.b(localApolloObtainedActionData);
        }
        n += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      ((EntityTransaction)???).c();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloDaoManager", 1, "[removeAllObtainedAction] exception: ", localException);
      return;
    }
    finally
    {
      ((EntityTransaction)???).b();
    }
  }
  
  /* Error */
  public void g(List paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 48	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   12: ifnull +90 -> 102
    //   15: aload_0
    //   16: getfield 48	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: iconst_0
    //   25: istore_2
    //   26: iload_2
    //   27: aload_1
    //   28: invokeinterface 232 1 0
    //   33: if_icmpge +66 -> 99
    //   36: aload_0
    //   37: getfield 48	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   40: invokeinterface 232 1 0
    //   45: iconst_1
    //   46: isub
    //   47: istore_3
    //   48: iload_3
    //   49: iflt +163 -> 212
    //   52: aload_0
    //   53: getfield 48	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   56: iload_3
    //   57: invokeinterface 244 2 0
    //   62: checkcast 377	com/tencent/mobileqq/data/ApolloFavActionData
    //   65: getfield 380	com/tencent/mobileqq/data/ApolloFavActionData:favId	J
    //   68: aload_1
    //   69: iload_2
    //   70: invokeinterface 244 2 0
    //   75: checkcast 377	com/tencent/mobileqq/data/ApolloFavActionData
    //   78: getfield 380	com/tencent/mobileqq/data/ApolloFavActionData:favId	J
    //   81: lcmp
    //   82: ifne +123 -> 205
    //   85: aload_0
    //   86: getfield 48	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   89: iload_3
    //   90: invokeinterface 279 2 0
    //   95: pop
    //   96: goto +109 -> 205
    //   99: aload 5
    //   101: monitorexit
    //   102: aload_0
    //   103: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   106: ifnull -99 -> 7
    //   109: aload_0
    //   110: getfield 92	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   113: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   116: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   119: astore 6
    //   121: aload 6
    //   123: invokevirtual 287	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   126: astore 5
    //   128: aload 5
    //   130: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   133: iload 4
    //   135: istore_2
    //   136: iload_2
    //   137: aload_1
    //   138: invokeinterface 232 1 0
    //   143: if_icmpge +32 -> 175
    //   146: aload 6
    //   148: aload_1
    //   149: iload_2
    //   150: invokeinterface 244 2 0
    //   155: checkcast 730	com/tencent/mobileqq/persistence/Entity
    //   158: invokevirtual 614	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   161: pop
    //   162: iload_2
    //   163: iconst_1
    //   164: iadd
    //   165: istore_2
    //   166: goto -30 -> 136
    //   169: astore_1
    //   170: aload 5
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: aload 5
    //   177: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   180: aload 5
    //   182: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   185: return
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 564	java/lang/Exception:printStackTrace	()V
    //   191: aload 5
    //   193: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   196: return
    //   197: astore_1
    //   198: aload 5
    //   200: invokevirtual 318	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   203: aload_1
    //   204: athrow
    //   205: iload_3
    //   206: iconst_1
    //   207: isub
    //   208: istore_3
    //   209: goto -161 -> 48
    //   212: iload_2
    //   213: iconst_1
    //   214: iadd
    //   215: istore_2
    //   216: goto -190 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	ApolloDaoManager
    //   0	219	1	paramList	List
    //   25	191	2	n	int
    //   47	162	3	i1	int
    //   1	133	4	i2	int
    //   19	180	5	localObject	Object
    //   119	28	6	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   26	48	169	finally
    //   52	96	169	finally
    //   99	102	169	finally
    //   170	173	169	finally
    //   128	133	186	java/lang/Exception
    //   136	162	186	java/lang/Exception
    //   175	180	186	java/lang/Exception
    //   128	133	197	finally
    //   136	162	197	finally
    //   175	180	197	finally
    //   187	191	197	finally
  }
  
  public List h()
  {
    List localList = f();
    if (localList == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no game data info");
      return null;
    }
    Object localObject = g();
    if (localObject == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no user game list");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label197;
      }
      ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)((Iterator)localObject).next();
      Iterator localIterator = localList.iterator();
      if (localIterator.hasNext())
      {
        ApolloGameData localApolloGameData = (ApolloGameData)localIterator.next();
        if ((localApolloGameData == null) || (localApolloGameRoamData == null) || (localApolloGameData.gameId != localApolloGameRoamData.gameId) || (localApolloGameData.isShow == 0) || (localApolloGameData.gameId == 1) || (localApolloGameData.gameId == 2) || (!ApolloConfigUtils.a("7.6.8", localApolloGameData.minVer, localApolloGameData.maxVer))) {
          break;
        }
        localApolloGameData.type = localApolloGameRoamData.type;
        localArrayList.add(localApolloGameData);
      }
    }
    label197:
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[getPanelGameList] panelGameList size:", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public List i()
  {
    List localList = f();
    if (localList == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no game data info");
      return null;
    }
    Object localObject = g();
    if (localObject == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no user game list");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label206;
      }
      ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)((Iterator)localObject).next();
      Iterator localIterator = localList.iterator();
      if (localIterator.hasNext())
      {
        ApolloGameData localApolloGameData = (ApolloGameData)localIterator.next();
        if ((localApolloGameData == null) || (localApolloGameRoamData == null) || (localApolloGameData.gameId != localApolloGameRoamData.gameId) || (localApolloGameData.isShow == 0) || (localApolloGameData.gameId == 1) || (localApolloGameData.gameId == 2) || (localApolloGameRoamData.type != 2) || (!ApolloConfigUtils.a("7.6.8", localApolloGameData.minVer, localApolloGameData.maxVer))) {
          break;
        }
        localApolloGameData.type = localApolloGameRoamData.type;
        localArrayList.add(localApolloGameData);
      }
    }
    label206:
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[getPanelGameList] panelGameList size:", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public List j()
  {
    ArrayList localArrayList = null;
    if ((this.g != null) && (this.g.size() > 0)) {
      synchronized (this.g)
      {
        localArrayList = new ArrayList(this.g.size());
        localArrayList.addAll(this.g);
        return localArrayList;
      }
    }
    ??? = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      ??? = localObject2;
      if (localEntityManager != null)
      {
        List localList = localEntityManager.a(ApolloActionPush.class);
        ??? = localList;
        if (this.g != null)
        {
          ??? = localList;
          if (localList != null)
          {
            ??? = localList;
            if (localList.size() > 0) {
              synchronized (this.g)
              {
                this.g.addAll(localList);
                return localList;
              }
            }
          }
        }
      }
    }
    return ???;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList = null;
    }
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      this.jdField_d_of_type_JavaUtilList.clear();
      this.jdField_d_of_type_JavaUtilList = null;
    }
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    if (this.g != null)
    {
      this.g.clear();
      this.g = null;
    }
    if (this.h != null)
    {
      this.h.clear();
      this.h = null;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.l != null)
    {
      this.l.clear();
      this.l = null;
    }
    if (this.k != null)
    {
      this.k.clear();
      this.k = null;
    }
    ApolloGameUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloDaoManager
 * JD-Core Version:    0.7.0.1
 */