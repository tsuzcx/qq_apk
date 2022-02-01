package com.tencent.biz.pubaccount.AccountDetail.model.api.impl;

import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.AccountDetail.model.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class PublicAccountDetailDynamicDataManagerServiceImpl
  implements IPublicAccountDetailDynamicDataManagerService
{
  private static final int MAX_CACHE_SIZE = 50;
  private static final String TAG = "AccountDetailDynamicDataManager";
  QQAppInterface app;
  private EntityManager em;
  private MQLruCache<Long, AccountDetailDynamicInfo> mPuin2AccountDetailDynamicInfoCache = new MQLruCache(50);
  
  public AccountDetailDynamicInfo getAccountDetailDynamicInfoFromCache(long paramLong)
  {
    return (AccountDetailDynamicInfo)this.mPuin2AccountDetailDynamicInfoCache.get(Long.valueOf(paramLong));
  }
  
  public AccountDetailDynamicInfo getAccountDetailDynamicInfoFromCache(String paramString)
  {
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      return getAccountDetailDynamicInfoFromCache(l1);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("AccountDetailDynamicDataManager", 2, "getAccountDetailDynamicInfoFromCache puin:" + paramString);
          l1 = l2;
        }
      }
    }
  }
  
  public void getDynamicListForFirstEnterFromDB(QQAppInterface paramQQAppInterface, long paramLong, PublicAccountObserver paramPublicAccountObserver)
  {
    ArrayList localArrayList = getDynamicListFromCache(paramLong);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {
      ThreadManager.post(new PublicAccountDetailDynamicDataManagerServiceImpl.2(this, paramLong, paramQQAppInterface, paramPublicAccountObserver), 8, null, true);
    }
  }
  
  public ArrayList<DynamicInfo> getDynamicListFromCache(long paramLong)
  {
    AccountDetailDynamicInfo localAccountDetailDynamicInfo = getAccountDetailDynamicInfoFromCache(paramLong);
    if (localAccountDetailDynamicInfo == null) {
      return null;
    }
    return localAccountDetailDynamicInfo.a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    try
    {
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        this.app = ((QQAppInterface)paramAppRuntime);
        this.em = this.app.getEntityManagerFactory().createEntityManager();
        return;
      }
      QLog.e("AccountDetailDynamicDataManager", 1, "[onCreate] init error, not in QQAppInterface! appRuntime = " + paramAppRuntime);
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      QLog.e("AccountDetailDynamicDataManager", 1, "[onCreate] init error!", paramAppRuntime);
    }
  }
  
  public void onDestroy()
  {
    this.mPuin2AccountDetailDynamicInfoCache.evictAll();
    this.em.close();
  }
  
  public int updateAccountDetailDynamicInfo(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    updateAccountDetailDynamicInfoCache(paramBoolean1, paramLong1, paramLong2, paramLong3, paramArrayList, paramBoolean2);
    if ((!paramBoolean2) && (paramBoolean1) && (paramArrayOfByte != null) && (paramLong3 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoDB puin:" + paramLong1 + " last_msg_id:" + paramLong2 + " msg_cnt:" + paramLong3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
      }
      ThreadManager.post(new PublicAccountDetailDynamicDataManagerServiceImpl.1(this, paramLong1, paramArrayOfByte), 8, null, true);
    }
    return 0;
  }
  
  public int updateAccountDetailDynamicInfoCache(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    try
    {
      AccountDetailDynamicInfo localAccountDetailDynamicInfo1 = new AccountDetailDynamicInfo();
      localAccountDetailDynamicInfo1.jdField_a_of_type_Long = paramLong1;
      localAccountDetailDynamicInfo1.c = paramLong3;
      localAccountDetailDynamicInfo1.b = paramLong2;
      localAccountDetailDynamicInfo1.jdField_a_of_type_Boolean = paramBoolean1;
      AccountDetailDynamicInfo localAccountDetailDynamicInfo2 = (AccountDetailDynamicInfo)this.mPuin2AccountDetailDynamicInfoCache.get(Long.valueOf(paramLong1));
      if (localAccountDetailDynamicInfo2 != null)
      {
        if (paramLong3 == 0L) {
          localAccountDetailDynamicInfo1.b = localAccountDetailDynamicInfo2.b;
        }
        if (!paramBoolean1) {
          localAccountDetailDynamicInfo1.a(localAccountDetailDynamicInfo2.a());
        }
      }
      localAccountDetailDynamicInfo1.b(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoCache puin:" + paramLong1 + " last_msg_id:" + localAccountDetailDynamicInfo1.b + " msg_cnt:" + paramLong3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
      }
      this.mPuin2AccountDetailDynamicInfoCache.put(Long.valueOf(paramLong1), localAccountDetailDynamicInfo1);
      return 0;
    }
    finally {}
  }
  
  protected boolean updateAccountDetailDynamicInfoDB(long paramLong, byte[] paramArrayOfByte)
  {
    DynamicInfoEntity localDynamicInfoEntity2 = (DynamicInfoEntity)this.em.find(DynamicInfoEntity.class, paramLong);
    DynamicInfoEntity localDynamicInfoEntity1 = localDynamicInfoEntity2;
    if (localDynamicInfoEntity2 == null) {
      localDynamicInfoEntity1 = new DynamicInfoEntity();
    }
    localDynamicInfoEntity1.puin = String.valueOf(paramLong);
    localDynamicInfoEntity1.dynamicInfoData = paramArrayOfByte;
    return updateEntity(localDynamicInfoEntity1);
  }
  
  protected boolean updateEntity(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.em.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.em.update(paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.api.impl.PublicAccountDetailDynamicDataManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */