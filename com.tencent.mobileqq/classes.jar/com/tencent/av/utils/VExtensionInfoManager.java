package com.tencent.av.utils;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.concurrent.ConcurrentHashMap;

public class VExtensionInfoManager
{
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public VExtensionInfoManager(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = paramVideoAppInterface.getEntityManagerFactory(paramVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.createEntityManager();
  }
  
  public ExtensionInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    ??? = localObject2;
    if (paramString != null)
    {
      if (!"".equals(paramString)) {
        break label24;
      }
      ??? = localObject2;
    }
    label24:
    do
    {
      do
      {
        return ???;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
          localObject2 = (ExtensionInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        }
        ??? = localObject2;
      } while (localObject2 != null);
      localObject2 = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class, paramString);
      ??? = localObject2;
    } while (localObject2 == null);
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.VExtensionInfoManager
 * JD-Core Version:    0.7.0.1
 */