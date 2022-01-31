package com.tencent.biz.pubaccount.AccountDetail.model;

import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import ksm;
import ksn;
import mqq.manager.Manager;

public class AccountDetailDynamicDataManager
  implements Manager
{
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(50);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  
  public AccountDetailDynamicDataManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static AccountDetailDynamicDataManager a(QQAppInterface paramQQAppInterface)
  {
    return (AccountDetailDynamicDataManager)paramQQAppInterface.getManager(172);
  }
  
  public int a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList, boolean paramBoolean2)
  {
    try
    {
      AccountDetailDynamicInfo localAccountDetailDynamicInfo1 = new AccountDetailDynamicInfo();
      localAccountDetailDynamicInfo1.jdField_a_of_type_Long = paramLong1;
      localAccountDetailDynamicInfo1.c = paramLong3;
      localAccountDetailDynamicInfo1.b = paramLong2;
      localAccountDetailDynamicInfo1.jdField_a_of_type_Boolean = paramBoolean1;
      AccountDetailDynamicInfo localAccountDetailDynamicInfo2 = (AccountDetailDynamicInfo)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(Long.valueOf(paramLong1));
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
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(Long.valueOf(paramLong1), localAccountDetailDynamicInfo1);
      return 0;
    }
    finally {}
  }
  
  public int a(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList, boolean paramBoolean2)
  {
    a(paramBoolean1, paramLong1, paramLong2, paramLong3, paramArrayList, paramBoolean2);
    if ((!paramBoolean2) && (paramBoolean1) && (paramArrayOfByte != null) && (paramLong3 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoDB puin:" + paramLong1 + " last_msg_id:" + paramLong2 + " msg_cnt:" + paramLong3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
      }
      ThreadManager.post(new ksm(this, paramLong1, paramArrayOfByte), 8, null, true);
    }
    return 0;
  }
  
  public AccountDetailDynamicInfo a(long paramLong)
  {
    return (AccountDetailDynamicInfo)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(Long.valueOf(paramLong));
  }
  
  public AccountDetailDynamicInfo a(String paramString)
  {
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      return a(l1);
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
  
  public ArrayList a(long paramLong)
  {
    AccountDetailDynamicInfo localAccountDetailDynamicInfo = a(paramLong);
    if (localAccountDetailDynamicInfo == null) {
      return null;
    }
    return localAccountDetailDynamicInfo.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, PublicAccountObserver paramPublicAccountObserver)
  {
    ArrayList localArrayList = a(paramLong);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {
      ThreadManager.post(new ksn(this, paramLong, paramQQAppInterface, paramPublicAccountObserver), 8, null, true);
    }
  }
  
  public boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    DynamicInfoEntity localDynamicInfoEntity2 = (DynamicInfoEntity)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DynamicInfoEntity.class, paramLong);
    DynamicInfoEntity localDynamicInfoEntity1 = localDynamicInfoEntity2;
    if (localDynamicInfoEntity2 == null) {
      localDynamicInfoEntity1 = new DynamicInfoEntity();
    }
    localDynamicInfoEntity1.puin = String.valueOf(paramLong);
    localDynamicInfoEntity1.dynamicInfoData = paramArrayOfByte;
    return a(localDynamicInfoEntity1);
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager
 * JD-Core Version:    0.7.0.1
 */