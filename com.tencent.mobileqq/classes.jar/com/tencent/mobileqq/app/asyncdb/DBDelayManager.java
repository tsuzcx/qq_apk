package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;

public class DBDelayManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Vector jdField_a_of_type_JavaUtilVector;
  boolean jdField_a_of_type_Boolean = false;
  
  public DBDelayManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(EntityManager paramEntityManager)
  {
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      BaseDBQueueItem localBaseDBQueueItem;
      String str;
      ProxyListener localProxyListener;
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "transSaveToDatabase writeRunable msgQueue size:" + this.jdField_a_of_type_JavaUtilVector.size());
        }
        if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {
          return;
        }
        Object localObject3 = (List)this.jdField_a_of_type_JavaUtilVector.clone();
        this.jdField_a_of_type_JavaUtilVector.clear();
        if (localObject3 == null) {
          break label477;
        }
        localObject2 = null;
        ??? = null;
        try
        {
          localEntityTransaction = paramEntityManager.a();
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localEntityTransaction.a();
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localObject3 = ((List)localObject3).iterator();
        }
        catch (Exception paramEntityManager)
        {
          localObject2 = ???;
          paramEntityManager.printStackTrace();
          localObject2 = ???;
          if (!QLog.isColorLevel()) {
            break label351;
          }
          localObject2 = ???;
          QLog.w("Q.db.Cache", 2, "writeRunable write exception: " + paramEntityManager.getMessage());
          if (??? == null) {
            break label477;
          }
          ((EntityTransaction)???).b();
          return;
          paramEntityManager = finally;
          throw paramEntityManager;
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          paramEntityManager.a(localBaseDBQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
          if (localProxyListener == null) {
            continue;
          }
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localProxyListener.a(str, 1);
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label414;
          }
          localObject2.b();
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (!((Iterator)localObject3).hasNext()) {
          break label456;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localBaseDBQueueItem = (BaseDBQueueItem)((Iterator)localObject3).next();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        str = localBaseDBQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity.getTableName();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener = localBaseDBQueueItem.jdField_a_of_type_ComTencentMobileqqAppAsyncdbProxyListener;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (QLog.isColorLevel())
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          QLog.d("Q.db.Cache", 2, "writeRunable QueueItem.action: " + localBaseDBQueueItem.jdField_a_of_type_Int);
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        switch (localBaseDBQueueItem.jdField_a_of_type_Int)
        {
        case 0: 
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          paramEntityManager.b(localBaseDBQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
          if (localProxyListener == null) {
            continue;
          }
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localProxyListener.a(str);
        }
      }
      label351:
      ??? = localEntityTransaction;
      label414:
      Object localObject2 = localEntityTransaction;
      paramEntityManager.b(localBaseDBQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
      if (localProxyListener != null)
      {
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener.b(str, 1);
        continue;
        label456:
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.c();
        if (localEntityTransaction != null) {
          localEntityTransaction.b();
        }
        label477:
        return;
      }
    }
  }
  
  public Vector a()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void a() {}
  
  public void a(Entity arg1, int paramInt1, int paramInt2, ProxyListener paramProxyListener)
  {
    paramProxyListener = new BaseDBQueueItem(???, paramInt1, paramInt2, paramProxyListener);
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramProxyListener);
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache", 2, "addQueue after destroy");
          }
          b();
          return;
        }
      }
      switch (paramInt2)
      {
      case 2: 
      default: 
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause);
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    b();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "transSaveToDatabase");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    a(localEntityManager);
    localEntityManager.a();
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.DBDelayManager
 * JD-Core Version:    0.7.0.1
 */