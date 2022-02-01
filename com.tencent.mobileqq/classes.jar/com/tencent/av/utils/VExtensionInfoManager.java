package com.tencent.av.utils;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.concurrent.ConcurrentHashMap;

public class VExtensionInfoManager
{
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private ConcurrentHashMap<String, Entity> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public VExtensionInfoManager(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = paramVideoAppInterface.getEntityManagerFactory(paramVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.createEntityManager();
  }
  
  public ExtensionInfo a(String paramString)
  {
    Object localObject = null;
    ExtensionInfo localExtensionInfo = null;
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return null;
      }
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      localObject = localExtensionInfo;
      if (localConcurrentHashMap != null) {
        localObject = (ExtensionInfo)localConcurrentHashMap.get(paramString);
      }
      if (localObject != null) {
        return localObject;
      }
      localExtensionInfo = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ExtensionInfo.class, paramString);
      localObject = localExtensionInfo;
      if (localExtensionInfo != null)
      {
        localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject = localExtensionInfo;
        if (localConcurrentHashMap != null) {
          try
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localExtensionInfo);
            return localExtensionInfo;
          }
          finally {}
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VExtensionInfoManager
 * JD-Core Version:    0.7.0.1
 */