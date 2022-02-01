package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.accountdetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
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
  
  public Object getAccountDetailDynamicInfoFromCache(long paramLong)
  {
    return this.mPuin2AccountDetailDynamicInfoCache.get(Long.valueOf(paramLong));
  }
  
  public Object getAccountDetailDynamicInfoFromCache(String paramString)
  {
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label8:
      StringBuilder localStringBuilder;
      break label8;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAccountDetailDynamicInfoFromCache puin:");
      localStringBuilder.append(paramString);
      QLog.d("AccountDetailDynamicDataManager", 2, localStringBuilder.toString());
    }
    l = 0L;
    return getAccountDetailDynamicInfoFromCache(l);
  }
  
  public void getDynamicListForFirstEnterFromDB(AppInterface paramAppInterface, long paramLong, IPublicAccountObserver paramIPublicAccountObserver)
  {
    ArrayList localArrayList = (ArrayList)getDynamicListFromCache(paramLong);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {
      ThreadManager.post(new PublicAccountDetailDynamicDataManagerServiceImpl.2(this, paramLong, paramAppInterface, paramIPublicAccountObserver), 8, null, true);
    }
  }
  
  public Object getDynamicListFromCache(long paramLong)
  {
    AccountDetailDynamicInfo localAccountDetailDynamicInfo = (AccountDetailDynamicInfo)getAccountDetailDynamicInfoFromCache(paramLong);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onCreate] init error, not in QQAppInterface! appRuntime = ");
      localStringBuilder.append(paramAppRuntime);
      QLog.e("AccountDetailDynamicDataManager", 1, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("updateAccountDetailDynamicInfoDB puin:");
        paramArrayList.append(paramLong1);
        paramArrayList.append(" last_msg_id:");
        paramArrayList.append(paramLong2);
        paramArrayList.append(" msg_cnt:");
        paramArrayList.append(paramLong3);
        paramArrayList.append(" isFirstEnter:");
        paramArrayList.append(paramBoolean1);
        paramArrayList.append(" isFromDB:");
        paramArrayList.append(paramBoolean2);
        QLog.d("AccountDetailDynamicDataManager", 2, paramArrayList.toString());
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
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("updateAccountDetailDynamicInfoCache puin:");
        paramArrayList.append(paramLong1);
        paramArrayList.append(" last_msg_id:");
        paramArrayList.append(localAccountDetailDynamicInfo1.b);
        paramArrayList.append(" msg_cnt:");
        paramArrayList.append(paramLong3);
        paramArrayList.append(" isFirstEnter:");
        paramArrayList.append(paramBoolean1);
        paramArrayList.append(" isFromDB:");
        paramArrayList.append(paramBoolean2);
        QLog.d("AccountDetailDynamicDataManager", 2, paramArrayList.toString());
      }
      this.mPuin2AccountDetailDynamicInfoCache.put(Long.valueOf(paramLong1), localAccountDetailDynamicInfo1);
      return 0;
    }
    finally {}
  }
  
  protected boolean updateAccountDetailDynamicInfoDB(long paramLong, byte[] paramArrayOfByte)
  {
    PublicAccountDynamicInfoEntityImpl localPublicAccountDynamicInfoEntityImpl2 = (PublicAccountDynamicInfoEntityImpl)this.em.find(PublicAccountDynamicInfoEntityImpl.class, paramLong);
    PublicAccountDynamicInfoEntityImpl localPublicAccountDynamicInfoEntityImpl1 = localPublicAccountDynamicInfoEntityImpl2;
    if (localPublicAccountDynamicInfoEntityImpl2 == null) {
      localPublicAccountDynamicInfoEntityImpl1 = new PublicAccountDynamicInfoEntityImpl();
    }
    localPublicAccountDynamicInfoEntityImpl1.puin = String.valueOf(paramLong);
    localPublicAccountDynamicInfoEntityImpl1.dynamicInfoData = paramArrayOfByte;
    return updateEntity(localPublicAccountDynamicInfoEntityImpl1);
  }
  
  protected boolean updateEntity(Entity paramEntity)
  {
    int i = paramEntity.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      this.em.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.em.update(paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailDynamicDataManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */