package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.data.EqqConfig;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class EqqDetailDataManager
  implements Manager
{
  private EqqConfig jdField_a_of_type_ComTencentMobileqqDataEqqConfig = null;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ConcurrentHashMap<String, EqqDetail> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public EqqDetailDataManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public EqqDetail a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    EqqDetail localEqqDetail = null;
    if (bool) {
      return null;
    }
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localEqqDetail = (EqqDetail)localConcurrentHashMap.get(paramString);
    }
    return localEqqDetail;
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig;
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(EqqConfig.class);
      if ((localObject != null) && (((List)localObject).size() >= 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig = ((EqqConfig)((List)localObject).get(0));
        return this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig.getData();
      }
      return "";
    }
    return ((EqqConfig)localObject).getData();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.eqq", 2, "initEqqDetailCache() begin");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    int i = 0;
    localObject = ((EntityManager)localObject).query(EqqDetail.class, false, "followType=?", new String[] { "0" }, null, null, null, null);
    if (localObject != null) {
      i = ((List)localObject).size();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(i);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EqqDetail localEqqDetail = (EqqDetail)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEqqDetail.uin, localEqqDetail);
      }
    }
    a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initEqqDetailCache() end: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      QLog.d("Q.contacttab.eqq", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {
      return;
    }
    a(paramEqqDetail);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (paramEqqDetail.followType == 0) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEqqDetail.uin, paramEqqDetail);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig = new EqqConfig(paramString);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig);
  }
  
  protected boolean a(Entity paramEntity)
  {
    int i = paramEntity.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  public void b(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramEqqDetail);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(paramEqqDetail.uin);
    }
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.EqqDetailDataManager
 * JD-Core Version:    0.7.0.1
 */