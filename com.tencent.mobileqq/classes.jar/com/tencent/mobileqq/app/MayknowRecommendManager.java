package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import znd;
import zne;
import znf;
import zng;

public class MayknowRecommendManager
  implements Manager
{
  public static int a;
  public static long a;
  private static int jdField_b_of_type_Int = 70;
  private static int jdField_c_of_type_Int = 3;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new znf(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_a_of_type_Boolean;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private volatile boolean jdField_b_of_type_Boolean;
  private final ArrayList jdField_c_of_type_JavaUtilArrayList;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Long = 86400000L;
    jdField_a_of_type_Int = 37;
  }
  
  public MayknowRecommendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(jdField_b_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_MqqOsMqqHandler.post(new znd(this));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private ArrayList a(@NonNull ArrayList paramArrayList)
  {
    if (paramArrayList.size() == 0) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramArrayList.next();
      if (!localFriendsManager.b(localMayKnowRecommend.uin))
      {
        if (localFriendsManager.c(localMayKnowRecommend.uin)) {}
        for (int i = 1;; i = 0)
        {
          localMayKnowRecommend.friendStatus = i;
          localArrayList.add(localMayKnowRecommend);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.aq, 0, true, false);
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.msgtype = -1000;
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localMessageRecord.frienduin = AppConstants.aq;
    localMessageRecord.senderuin = AppConstants.aq;
    localMessageRecord.istroop = 0;
    localMessageRecord.msg = paramString;
    localMessageRecord.time = paramLong;
    ((ChatMessage)localMessageRecord).parse();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a("handleGetSystemMsgResp", true, 1, true, false);
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      ??? = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 3);
      if ((??? instanceof String)) {
        a((String)???);
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(MayKnowExposure.class, false, null, null, null, null, null, null);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            MayKnowExposure localMayKnowExposure = (MayKnowExposure)((Iterator)localObject1).next();
            localMayKnowExposure = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(MayKnowExposure.generateKey(localMayKnowExposure), localMayKnowExposure);
            continue;
          }
        }
        this.jdField_b_of_type_Boolean = true;
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_report_explosure_time", 0L);
        jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_report_interval", 86400000L);
        if (Math.abs(System.currentTimeMillis() - l) > jdField_a_of_type_Long)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() == 1) {
            f();
          }
        }
        else
        {
          jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_showcount", 37);
          jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_expectcount", 70);
          jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_newfriendcount", 3);
          localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(MayKnowRecommend.class, false, null, null, null, null, null, null);
          if (localObject1 != null) {
            this.jdField_a_of_type_JavaUtilArrayList = a((ArrayList)localObject1);
          }
          localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PushRecommend.class, false, null, null, null, null, null, null);
          if (localObject1 != null) {
            this.jdField_b_of_type_JavaUtilArrayList = a((ArrayList)localObject1);
          }
          localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
          ((FriendListHandler)localObject1).a(92, true, null);
          ((FriendListHandler)localObject1).a(109, true, null);
          return;
        }
      }
      finally {}
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new zne(this), 5000L);
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: invokestatic 346	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: invokestatic 351	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +48 -> 65
    //   20: ldc 255
    //   22: iconst_2
    //   23: new 353	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 354	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 356
    //   33: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 71	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: invokevirtual 361	java/util/concurrent/ConcurrentHashMap:size	()I
    //   43: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc_w 366
    //   49: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 276	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_b_of_type_Boolean	Z
    //   56: invokevirtual 369	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   59: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: getfield 71	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: invokevirtual 361	java/util/concurrent/ConcurrentHashMap:size	()I
    //   72: ifle -59 -> 13
    //   75: aload_0
    //   76: getfield 276	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_b_of_type_Boolean	Z
    //   79: ifeq -66 -> 13
    //   82: ldc 255
    //   84: monitorenter
    //   85: aload_0
    //   86: iconst_1
    //   87: putfield 377	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_Boolean	Z
    //   90: ldc 255
    //   92: monitorexit
    //   93: aload_0
    //   94: getfield 45	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   97: iconst_1
    //   98: invokevirtual 322	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   101: checkcast 324	com/tencent/mobileqq/app/FriendListHandler
    //   104: aload_0
    //   105: getfield 71	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   108: invokevirtual 380	com/tencent/mobileqq/app/FriendListHandler:a	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   111: invokestatic 351	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq -101 -> 13
    //   117: aload_0
    //   118: getfield 71	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   121: invokevirtual 384	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   124: invokeinterface 387 1 0
    //   129: astore_1
    //   130: aload_1
    //   131: invokeinterface 131 1 0
    //   136: ifeq -123 -> 13
    //   139: aload_1
    //   140: invokeinterface 135 1 0
    //   145: checkcast 389	java/util/Map$Entry
    //   148: astore_2
    //   149: ldc 255
    //   151: iconst_2
    //   152: new 353	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 354	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 391
    //   162: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_2
    //   166: invokeinterface 394 1 0
    //   171: checkcast 250	java/lang/String
    //   174: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 396
    //   180: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_2
    //   184: invokeinterface 399 1 0
    //   189: checkcast 257	com/tencent/mobileqq/data/MayKnowExposure
    //   192: getfield 402	com/tencent/mobileqq/data/MayKnowExposure:exposeCnt	I
    //   195: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc_w 404
    //   201: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_2
    //   205: invokeinterface 399 1 0
    //   210: checkcast 257	com/tencent/mobileqq/data/MayKnowExposure
    //   213: getfield 407	com/tencent/mobileqq/data/MayKnowExposure:exposeTime	I
    //   216: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: goto -95 -> 130
    //   228: astore_1
    //   229: ldc 255
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	MayknowRecommendManager
    //   129	11	1	localIterator	Iterator
    //   228	5	1	localObject	Object
    //   148	57	2	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   85	93	228	finally
    //   229	232	228	finally
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_version", 0);
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "markAllPushRecommendReaded size=" + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
    try
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
          ((PushRecommend)localMayKnowRecommend).isReaded = true;
          a(localMayKnowRecommend);
          continue;
          localObject1 = finally;
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
      localObject1.c();
    }
    finally {}
    localObject1.b();
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramString != null)
        {
          int i = Integer.valueOf(paramString.optString("reportInterval").trim()).intValue();
          if ((i <= 86400000) && (i > 0)) {
            jdField_a_of_type_Long = i;
          }
          i = Integer.valueOf(paramString.optString("showCount").trim()).intValue();
          if ((i > 0) && (i <= 100)) {
            jdField_a_of_type_Int = i;
          }
          i = Integer.valueOf(paramString.optString("totalCount").trim()).intValue();
          if ((i <= 100) && (i > 0)) {
            jdField_b_of_type_Int = i;
          }
          i = Integer.valueOf(paramString.optString("newfriendCount")).intValue();
          if (i > 0) {
            jdField_c_of_type_Int = i;
          }
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_report_interval", jdField_a_of_type_Long).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_showcount", jdField_a_of_type_Int).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_expectcount", jdField_b_of_type_Int).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_newfriendcount", jdField_c_of_type_Int).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_version", paramInt).commit();
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MayknowRecommendManager", 2, "updateConfigs error " + paramString.getMessage());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "timeInterval = " + jdField_a_of_type_Long + ",showCount=" + jdField_a_of_type_Int + ",expectCount=" + jdField_b_of_type_Int + ",newfriendCount=" + jdField_c_of_type_Int);
    }
  }
  
  public void a(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      String str;
      try
      {
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
          return;
        }
        str = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
        {
          paramMayKnowRecommend = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "recordtartExpose " + paramMayKnowRecommend.toString());
          }
          if (paramInt3 != 1) {
            paramMayKnowRecommend.exposeCnt += 1;
          }
          if ((paramMayKnowRecommend.startExploseTime != 0L) || (paramInt3 != 1)) {
            break;
          }
          paramMayKnowRecommend.startExploseTime = SystemClock.uptimeMillis();
          return;
        }
      }
      finally {}
      paramMayKnowRecommend = new MayKnowExposure(paramMayKnowRecommend.uin, paramInt1, paramInt2, paramInt3, paramMayKnowRecommend.algBuffer);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramMayKnowRecommend);
    }
  }
  
  public void a(String paramString)
  {
    int i;
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      try
      {
        Object localObject3 = new JSONObject(paramString);
        if (((JSONObject)localObject3).has("shield_sub_source_id"))
        {
          localObject3 = ((JSONObject)localObject3).getJSONArray("shield_sub_source_id");
          i = 0;
          while ((localObject3 != null) && (i < ((JSONArray)localObject3).length()))
          {
            int j = ((JSONArray)localObject3).getInt(i);
            this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
            i += 1;
          }
        }
        ??? = new StringBuilder(100);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("MayknowRecommendManager", 2, "updateShieldConfig", localException);
        }
        if (!QLog.isColorLevel()) {
          break label236;
        }
      }
      ((StringBuilder)???).append("updateShieldConfig config: ").append(paramString).append("\r\n");
      ((StringBuilder)???).append("[");
      paramString = this.jdField_c_of_type_JavaUtilArrayList;
      i = 0;
    }
    try
    {
      while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        ((StringBuilder)???).append(this.jdField_c_of_type_JavaUtilArrayList.get(i)).append(",");
        i += 1;
        continue;
        paramString = finally;
        throw paramString;
      }
      ((StringBuilder)???).append("]");
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
      label236:
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(@android.support.annotation.Nullable ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 415	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: astore_2
    //   8: aload_0
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 317	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   14: putfield 73	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: aload_2
    //   18: invokevirtual 419	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   21: aload_0
    //   22: getfield 59	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: ldc_w 583
    //   28: invokevirtual 584	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   31: pop
    //   32: aload_0
    //   33: getfield 73	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   36: invokevirtual 115	java/util/ArrayList:size	()I
    //   39: ifle +59 -> 98
    //   42: aload_0
    //   43: getfield 73	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   46: invokevirtual 125	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   49: astore_1
    //   50: aload_1
    //   51: invokeinterface 131 1 0
    //   56: ifeq +42 -> 98
    //   59: aload_0
    //   60: aload_1
    //   61: invokeinterface 135 1 0
    //   66: checkcast 137	com/tencent/mobileqq/data/MayKnowRecommend
    //   69: invokevirtual 425	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   72: pop
    //   73: goto -23 -> 50
    //   76: astore_1
    //   77: invokestatic 351	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +13 -> 93
    //   83: ldc 255
    //   85: iconst_2
    //   86: ldc_w 586
    //   89: aload_1
    //   90: invokestatic 588	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: aload_2
    //   94: invokevirtual 427	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   97: return
    //   98: aload_2
    //   99: invokevirtual 429	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   102: aload_2
    //   103: invokevirtual 427	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   106: return
    //   107: astore_1
    //   108: aload_2
    //   109: invokevirtual 427	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	MayknowRecommendManager
    //   0	114	1	paramArrayList	ArrayList
    //   7	102	2	localEntityTransaction	EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   17	50	76	java/lang/Exception
    //   50	73	76	java/lang/Exception
    //   98	102	76	java/lang/Exception
    //   17	50	107	finally
    //   50	73	107	finally
    //   77	93	107	finally
    //   98	102	107	finally
  }
  
  public void a(ArrayList paramArrayList, long paramLong)
  {
    d();
    ??? = a(paramArrayList);
    int j = 0;
    Object localObject3;
    try
    {
      localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (PushRecommend)((Iterator)localObject2).next();
        if (Math.abs(System.currentTimeMillis() - ((PushRecommend)localObject3).timestamp * 1000L) >= 15552000000L)
        {
          ((Iterator)localObject2).remove();
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject3);
        }
      }
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 200) {
        break label172;
      }
    }
    finally {}
    Object localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    label172:
    Object localObject4;
    int n;
    label484:
    int m;
    label579:
    int k;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (PushRecommend)((Iterator)localObject2).next();
      if (i >= 200)
      {
        ((Iterator)localObject2).remove();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject3);
      }
    }
    else
    {
      PushRecommend localPushRecommend;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder(512);
        ((StringBuilder)localObject2).append("handlePushRecommend|AllPushDatas : ");
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject3 = (MayKnowRecommend)paramArrayList.next();
          if ((localObject3 instanceof PushRecommend)) {
            ((StringBuilder)localObject2).append("[").append(((MayKnowRecommend)localObject3).uin).append(",").append(((PushRecommend)localObject3).subSourceId).append("],");
          } else {
            ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject3).uin).append(",");
          }
        }
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject2).toString());
        ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
        ((StringBuilder)localObject2).append("handlePushRecommend|LocalDatas in three months : ");
        paramArrayList = new StringBuilder(512);
        paramArrayList.append("handlePushRecommend|LocalDatas out three months : ");
        localObject3 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (MayKnowRecommend)((Iterator)localObject3).next();
          localPushRecommend = (PushRecommend)localObject4;
          if (Math.abs(System.currentTimeMillis() - localPushRecommend.timestamp * 1000L) <= 2592000000L) {
            ((StringBuilder)localObject2).append(localPushRecommend.uin).append(",");
          } else {
            paramArrayList.append(((MayKnowRecommend)localObject4).uin).append(",");
          }
        }
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject2).toString());
        QLog.d("MayknowRecommendManager", 2, paramArrayList.toString());
      }
      localObject2 = new ArrayList();
      i = 0;
      paramArrayList = null;
      n = 0;
      if (n < ((ArrayList)???).size())
      {
        localObject3 = (PushRecommend)((ArrayList)???).get(n);
        localObject4 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            localPushRecommend = (PushRecommend)((Iterator)localObject4).next();
            if (Math.abs(System.currentTimeMillis() - localPushRecommend.timestamp * 1000L) < 2592000000L)
            {
              if (!localPushRecommend.uin.equals(((PushRecommend)localObject3).uin)) {}
            }
            else
            {
              for (m = 0;; m = 1)
              {
                if ((m == 0) || (i >= jdField_c_of_type_Int)) {
                  break label684;
                }
                ((ArrayList)localObject2).add(localObject3);
                this.jdField_b_of_type_JavaUtilArrayList.add(localObject3);
                j = 1;
                i += 1;
                break label1279;
                if ((Math.abs(System.currentTimeMillis() - localPushRecommend.timestamp * 1000L) >= 15552000000L) || (!localPushRecommend.uin.equals(((PushRecommend)localObject3).uin))) {
                  break;
                }
                ((Iterator)localObject4).remove();
                this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localPushRecommend);
              }
              label684:
              k = j;
              if (m != 0)
              {
                k = j;
                if (((PushRecommend)localObject3).wzrySourceId > 0)
                {
                  ((ArrayList)localObject2).add(localObject3);
                  this.jdField_b_of_type_JavaUtilArrayList.add(localObject3);
                  k = 1;
                  if (QLog.isColorLevel()) {
                    if (paramArrayList == null)
                    {
                      paramArrayList = new StringBuilder(512);
                      paramArrayList.append("handlePushRecommend|wzryuinlist: ");
                      label755:
                      paramArrayList.append(((PushRecommend)localObject3).uin).append(",");
                      j = 1;
                      break label1279;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1153:
    label1288:
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        localObject3 = ((ArrayList)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (PushRecommend)((Iterator)localObject3).next();
          if (localObject4 == null) {
            continue;
          }
          if (!this.jdField_c_of_type_JavaUtilArrayList.contains(Integer.valueOf(((PushRecommend)localObject4).subSourceId))) {
            break label1288;
          }
          k = 1;
          i = k;
          if (!QLog.isDevelopLevel()) {
            break label1288;
          }
          QLog.i("MayknowRecommendManager", 4, String.format(Locale.getDefault(), "shield sub_source_id [uin: %s, nick: %s, sourceId: %s, subSourceId: %s]", new Object[] { ((PushRecommend)localObject4).uin, ((PushRecommend)localObject4).nick, Integer.valueOf(((PushRecommend)localObject4).sourceId), Integer.valueOf(((PushRecommend)localObject4).subSourceId) }));
          i = k;
          break label1288;
        }
        if (i != 0)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (PushRecommend)((Iterator)localObject2).next();
            if (localObject3 == null) {
              continue;
            }
            ((PushRecommend)localObject3).isReaded = true;
          }
        }
      }
      if ((QLog.isColorLevel()) && (paramArrayList != null)) {
        QLog.d("MayknowRecommendManager", 2, paramArrayList.toString());
      }
      paramArrayList = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramArrayList.hasNext()) {
        a((MayKnowRecommend)paramArrayList.next());
      }
      if (j != 0)
      {
        j = this.jdField_b_of_type_JavaUtilArrayList.size();
        ??? = (MayKnowRecommend)this.jdField_b_of_type_JavaUtilArrayList.get(j - 1);
        if (i == 0) {
          break label1153;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80089F2", "0X80089F2", 0, 0, "", "", "", "");
        if (((PushRecommend)???).fromSource <= 20) {
          break label1247;
        }
      }
      label1181:
      label1219:
      label1247:
      for (paramArrayList = "0X800778F";; paramArrayList = "0X8007792")
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramArrayList, paramArrayList, 0, 0, "", "", "", "");
        return;
        if (TextUtils.isEmpty(((MayKnowRecommend)???).remark)) {
          if (TextUtils.isEmpty(((MayKnowRecommend)???).nick))
          {
            paramArrayList = ((MayKnowRecommend)???).uin;
            if (!TextUtils.isEmpty(paramArrayList)) {
              break label1219;
            }
          }
        }
        for (paramArrayList = "你有可能认识的人";; paramArrayList = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435532), new Object[] { paramArrayList }))
        {
          a(paramArrayList, paramLong);
          break;
          paramArrayList = ((MayKnowRecommend)???).nick;
          break label1181;
          paramArrayList = ((MayKnowRecommend)???).remark;
          break label1181;
        }
      }
      break label755;
      j = k;
      break label1279;
      m = 1;
      break label579;
      i += 1;
      break;
      label1279:
      n += 1;
      break label484;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("delete from MayKnowExposure");
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "onReportExplosures , success");
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_report_explosure_time", System.currentTimeMillis());
    }
    try
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return Math.abs(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_get_mayknow_timestamp", 0L) - System.currentTimeMillis()) >= 86400000L;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.d("MayknowRecommendManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public ArrayList b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new zng(this));
  }
  
  public void b(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        return;
      }
      paramMayKnowRecommend = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMayKnowRecommend))
      {
        paramMayKnowRecommend = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMayKnowRecommend);
        if ((paramInt3 == 1) && (paramMayKnowRecommend.startExploseTime != 0L))
        {
          paramMayKnowRecommend.exposeTime = ((int)(SystemClock.uptimeMillis() - paramMayKnowRecommend.startExploseTime + paramMayKnowRecommend.exposeTime));
          paramMayKnowRecommend.exposeCnt += 1;
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "recordStopExpose " + paramMayKnowRecommend.toString() + ";stopExploseTime: " + SystemClock.uptimeMillis());
          }
          paramMayKnowRecommend.startExploseTime = 0L;
          return;
        }
      }
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
    int i = 0;
    MayKnowRecommend localMayKnowRecommend;
    if (i < localArrayList.size())
    {
      localMayKnowRecommend = (MayKnowRecommend)localArrayList.get(i);
      if (!localMayKnowRecommend.uin.equals(paramString)) {}
    }
    for (;;)
    {
      if (localMayKnowRecommend != null)
      {
        localArrayList.remove(localMayKnowRecommend);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localMayKnowRecommend);
      }
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      Iterator localIterator = localArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
      } while (!((PushRecommend)localMayKnowRecommend).uin.equals(paramString));
      for (paramString = localMayKnowRecommend;; paramString = null)
      {
        if (paramString != null)
        {
          localArrayList.remove(paramString);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
        }
        this.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        return;
        i += 1;
        break;
      }
      localMayKnowRecommend = null;
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: ldc 255
    //   2: monitorenter
    //   3: aload_0
    //   4: iconst_0
    //   5: putfield 276	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_b_of_type_Boolean	Z
    //   8: ldc 255
    //   10: monitorexit
    //   11: aload_0
    //   12: getfield 71	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: invokevirtual 384	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   18: invokeinterface 387 1 0
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 59	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   28: invokevirtual 415	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 419	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   36: aload_2
    //   37: invokeinterface 131 1 0
    //   42: ifeq +65 -> 107
    //   45: aload_2
    //   46: invokeinterface 135 1 0
    //   51: checkcast 389	java/util/Map$Entry
    //   54: invokeinterface 399 1 0
    //   59: checkcast 257	com/tencent/mobileqq/data/MayKnowExposure
    //   62: astore_3
    //   63: aload_3
    //   64: getfield 402	com/tencent/mobileqq/data/MayKnowExposure:exposeCnt	I
    //   67: ifle -31 -> 36
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 425	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   75: pop
    //   76: goto -40 -> 36
    //   79: astore_2
    //   80: invokestatic 351	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +13 -> 96
    //   86: ldc 255
    //   88: iconst_2
    //   89: ldc_w 727
    //   92: aload_2
    //   93: invokestatic 729	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: aload_1
    //   97: invokevirtual 427	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   100: return
    //   101: astore_1
    //   102: ldc 255
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    //   107: aload_1
    //   108: invokevirtual 429	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   111: invokestatic 351	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +35 -> 149
    //   117: ldc 255
    //   119: iconst_2
    //   120: new 353	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 354	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 731
    //   130: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: getfield 71	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   137: invokevirtual 361	java/util/concurrent/ConcurrentHashMap:size	()I
    //   140: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_1
    //   150: invokevirtual 427	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   153: return
    //   154: astore_2
    //   155: aload_1
    //   156: invokevirtual 427	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   159: aload_2
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	MayknowRecommendManager
    //   31	66	1	localEntityTransaction	EntityTransaction
    //   101	55	1	localObject1	Object
    //   23	23	2	localIterator	Iterator
    //   79	14	2	localException	Exception
    //   154	6	2	localObject2	Object
    //   62	10	3	localMayKnowExposure	MayKnowExposure
    // Exception table:
    //   from	to	target	type
    //   32	36	79	java/lang/Exception
    //   36	76	79	java/lang/Exception
    //   107	149	79	java/lang/Exception
    //   3	11	101	finally
    //   102	105	101	finally
    //   32	36	154	finally
    //   36	76	154	finally
    //   80	96	154	finally
    //   107	149	154	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager
 * JD-Core Version:    0.7.0.1
 */