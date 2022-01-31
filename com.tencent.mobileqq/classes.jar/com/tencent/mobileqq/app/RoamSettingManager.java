package com.tencent.mobileqq.app;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import ztc;
import ztd;
import zte;

public class RoamSettingManager
  implements Manager
{
  public QQHashMap a;
  RoamSetting a;
  public EntityManager a;
  public Lock a;
  public boolean a;
  public QQHashMap b;
  
  public RoamSettingManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new QQHashMap(1003, 0, 60);
    this.b = new QQHashMap(1004, 0, 60);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    a();
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = Integer.parseInt(paramString);
      if ((i == -2) || (i == -1) || (i == 1) || (i == 2) || (i == 3) || (i == 4)) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("RoamSettingManager", 1, paramString + "");
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RoamSetting.class, "setting_revision"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = null;
      return 0;
    }
    try
    {
      i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "parse revision.value exception, revision.value=" + this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
        }
        int i = 0;
      }
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    RoamSetting localRoamSetting2 = a(paramString);
    RoamSetting localRoamSetting1 = localRoamSetting2;
    if (localRoamSetting2 == null)
    {
      localRoamSetting1 = localRoamSetting2;
      if (!TextUtils.isEmpty(paramString))
      {
        localRoamSetting1 = new RoamSetting(paramString, Integer.toString(paramInt));
        a(localRoamSetting1);
      }
    }
    return RoamSetting.getIntValue(localRoamSetting1, paramInt);
  }
  
  /* Error */
  public RoamSetting a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 48	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 138 1 0
    //   15: aload_1
    //   16: invokestatic 142	com/tencent/mobileqq/utils/RoamSettingController:a	(Ljava/lang/String;)I
    //   19: istore_2
    //   20: iload_2
    //   21: iconst_1
    //   22: if_icmpne +106 -> 128
    //   25: aload_0
    //   26: getfield 43	com/tencent/mobileqq/app/RoamSettingManager:b	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   29: aload_1
    //   30: invokevirtual 146	com/tencent/commonsdk/cache/QQHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 88	com/tencent/mobileqq/data/RoamSetting
    //   36: astore_3
    //   37: aload_3
    //   38: astore 4
    //   40: aload_3
    //   41: ifnonnull +75 -> 116
    //   44: aload_3
    //   45: astore 4
    //   47: aload_0
    //   48: getfield 20	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_Boolean	Z
    //   51: ifne +65 -> 116
    //   54: aload_0
    //   55: getfield 34	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: ldc 88
    //   60: aload_1
    //   61: invokevirtual 95	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   64: checkcast 88	com/tencent/mobileqq/data/RoamSetting
    //   67: astore_1
    //   68: aload_1
    //   69: astore 4
    //   71: aload_1
    //   72: ifnull +44 -> 116
    //   75: aload_1
    //   76: astore 4
    //   78: aload_1
    //   79: getfield 149	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   82: ifnull +34 -> 116
    //   85: aload_1
    //   86: astore 4
    //   88: aload_1
    //   89: getfield 99	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   92: ifnull +24 -> 116
    //   95: iload_2
    //   96: iconst_1
    //   97: if_icmpne +46 -> 143
    //   100: aload_0
    //   101: getfield 43	com/tencent/mobileqq/app/RoamSettingManager:b	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   104: aload_1
    //   105: getfield 149	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   108: aload_1
    //   109: invokevirtual 153	com/tencent/commonsdk/cache/QQHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: aload_1
    //   114: astore 4
    //   116: aload_0
    //   117: getfield 48	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   120: invokeinterface 156 1 0
    //   125: aload 4
    //   127: areturn
    //   128: aload_0
    //   129: getfield 41	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   132: aload_1
    //   133: invokevirtual 146	com/tencent/commonsdk/cache/QQHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 88	com/tencent/mobileqq/data/RoamSetting
    //   139: astore_3
    //   140: goto -103 -> 37
    //   143: aload_0
    //   144: getfield 41	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   147: aload_1
    //   148: getfield 149	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   151: aload_1
    //   152: invokevirtual 153	com/tencent/commonsdk/cache/QQHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: aload_1
    //   157: astore 4
    //   159: goto -43 -> 116
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 48	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   167: invokeinterface 156 1 0
    //   172: aload_1
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	RoamSettingManager
    //   0	174	1	paramString	String
    //   19	79	2	i	int
    //   36	104	3	localRoamSetting	RoamSetting
    //   38	120	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	20	162	finally
    //   25	37	162	finally
    //   47	68	162	finally
    //   78	85	162	finally
    //   88	95	162	finally
    //   100	113	162	finally
    //   128	140	162	finally
    //   143	156	162	finally
  }
  
  public RoamSetting a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    RoamSetting localRoamSetting = a(paramString1);
    if (localRoamSetting == null)
    {
      localRoamSetting = new RoamSetting(paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        if (RoamSettingController.a(paramString1) == 1)
        {
          if (a(paramString2))
          {
            this.b.put(localRoamSetting.path, localRoamSetting);
            return localRoamSetting;
            if (paramString2.equals(localRoamSetting.value)) {
              return null;
            }
            localRoamSetting.value = paramString2;
            break;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("RoamSettingManager", 2, "isTroopRoamSettingLegal false. path:" + paramString1 + ", value:" + paramString2);
          continue;
        }
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(localRoamSetting.path, localRoamSetting);
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ztc(this), 8, null, false);
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting != null)
    {
      localObject = Integer.toString(paramInt);
      if (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value = ((String)localObject);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting);
      return;
      localObject = new RoamSetting();
      ((RoamSetting)localObject).path = "setting_revision";
      ((RoamSetting)localObject).value = Integer.toString(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)localObject);
    }
  }
  
  public void a(RoamSetting paramRoamSetting)
  {
    if ((paramRoamSetting == null) || (paramRoamSetting.path == null) || (paramRoamSetting.value == null)) {
      return;
    }
    int j = RoamSettingController.a(paramRoamSetting.path);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    if (j == 1) {}
    for (;;)
    {
      try
      {
        if (a(paramRoamSetting.value))
        {
          this.b.put(paramRoamSetting.path, paramRoamSetting);
          i = 1;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if ((j == 1) && (i == 0)) {
            break;
          }
          if (Looper.myLooper() == Looper.getMainLooper()) {
            break label182;
          }
          a(paramRoamSetting);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label199;
        }
        QLog.e("RoamSettingManager", 2, "isTroopRoamSettingLegal false. path:" + paramRoamSetting.path + ", value:" + paramRoamSetting.value);
        i = 0;
        continue;
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(paramRoamSetting.path, paramRoamSetting);
        i = 1;
        continue;
        ThreadManagerV2.excute(new ztd(this, paramRoamSetting), 32, null, false);
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label182:
      return;
      label199:
      int i = 0;
    }
  }
  
  public void a(String paramString)
  {
    RoamSetting localRoamSetting = a(paramString);
    if ((localRoamSetting == null) || (localRoamSetting.path == null) || (localRoamSetting.value == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (RoamSettingController.a(paramString) == 1) {
        this.b.remove(localRoamSetting.path);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
          break;
        }
        ThreadManager.post(new zte(this, localRoamSetting), 5, null, false);
        return;
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.remove(localRoamSetting.path);
      }
      b(localRoamSetting);
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(List paramList)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.a();
      if (paramList != null)
      {
        int i = 0;
        for (;;)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          if (i >= paramList.size()) {
            break;
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          a((Entity)paramList.get(i));
          i += 1;
        }
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.c();
      return;
    }
    catch (Exception paramList)
    {
      localObject2 = localObject1;
      paramList.printStackTrace();
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        QLog.w("RoamSettingManager", 2, "insert write exception: " + paramList.getMessage());
      }
      return;
    }
    finally
    {
      if (localObject2 != null) {
        localObject2.b();
      }
    }
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())
    {
      if (paramEntity.getStatus() != 1000) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean b(Entity paramEntity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
    }
    return false;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RoamSettingManager
 * JD-Core Version:    0.7.0.1
 */