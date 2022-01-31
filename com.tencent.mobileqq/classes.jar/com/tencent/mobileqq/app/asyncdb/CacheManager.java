package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.asyncdb.cache.TroopStatisticsCache;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class CacheManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DBDelayManager jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private BaseCache[] jdField_a_of_type_ArrayOfComTencentMobileqqAppAsyncdbBaseCache = new BaseCache[4];
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[0];
  
  public CacheManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager = new DBDelayManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = System.currentTimeMillis();
      BaseCache localBaseCache = a(k);
      if (localBaseCache != null)
      {
        localBaseCache.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "cacheManager init cache:" + localBaseCache.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
        }
        localBaseCache.a(0);
      }
      i += 1;
    }
  }
  
  public BaseCache a(int paramInt)
  {
    BaseCache localBaseCache = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAsyncdbBaseCache[paramInt];
    if (localBaseCache == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAsyncdbBaseCache)
      {
        localBaseCache = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAsyncdbBaseCache[paramInt];
        if (localBaseCache != null) {
          return localBaseCache;
        }
        long l = System.currentTimeMillis();
        switch (paramInt)
        {
        case 2: 
          if ((localBaseCache != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAsyncdbBaseCache[paramInt] == null)) {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAsyncdbBaseCache[paramInt] = localBaseCache;
          }
          if ((QLog.isColorLevel()) && (localBaseCache != null)) {
            QLog.d("Q.db.Cache", 2, "get cache instance:" + localBaseCache.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
          }
          return localBaseCache;
        }
      }
      Object localObject2 = new RoamDateCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager);
      continue;
      localObject2 = new TroopStatisticsCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager);
      continue;
      return localObject2;
    }
  }
  
  public DBDelayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    a(this.jdField_b_of_type_ArrayOfInt);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onDestroy()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAsyncdbBaseCache)
      {
        BaseCache[] arrayOfBaseCache2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAsyncdbBaseCache;
        int j = arrayOfBaseCache2.length;
        i = 0;
        if (i < j)
        {
          BaseCache localBaseCache = arrayOfBaseCache2[i];
          if (localBaseCache != null) {
            localBaseCache.b();
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.onDestroy();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.CacheManager
 * JD-Core Version:    0.7.0.1
 */