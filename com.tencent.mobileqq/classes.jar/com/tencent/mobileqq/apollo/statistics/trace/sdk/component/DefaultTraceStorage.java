package com.tencent.mobileqq.apollo.statistics.trace.sdk.component;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.statistics.trace.data.TraceData;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class DefaultTraceStorage
  implements ITraceStorage
{
  public QQAppInterface a()
  {
    if (ProcessUtil.a())
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        return (QQAppInterface)localAppRuntime;
      }
    }
    return null;
  }
  
  public List<TraceData> a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return null;
    }
    return localQQAppInterface.getEntityManagerFactory().createEntityManager().query(TraceData.class);
  }
  
  public boolean a(List<TraceData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      try
      {
        Object localObject = a();
        if (localObject == null) {
          return false;
        }
        localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
        EntityTransaction localEntityTransaction = ((EntityManager)localObject).getTransaction();
        localEntityTransaction.begin();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          TraceData localTraceData = (TraceData)paramList.next();
          if (localTraceData.getStatus() == 1000) {
            ((EntityManager)localObject).persistOrReplace(localTraceData);
          } else {
            ((EntityManager)localObject).update(localTraceData);
          }
        }
        localEntityTransaction.commit();
        localEntityTransaction.end();
        ((EntityManager)localObject).close();
        return true;
      }
      catch (Throwable paramList)
      {
        QLog.e("[cmshow][TraceReport]", 1, paramList, new Object[0]);
        return true;
      }
    }
    return false;
  }
  
  public boolean b(List<TraceData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      try
      {
        Object localObject = a();
        if (localObject == null) {
          return false;
        }
        localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
        EntityTransaction localEntityTransaction = ((EntityManager)localObject).getTransaction();
        localEntityTransaction.begin();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          ((EntityManager)localObject).remove((TraceData)paramList.next());
        }
        localEntityTransaction.commit();
        localEntityTransaction.end();
        ((EntityManager)localObject).close();
        return true;
      }
      catch (Throwable paramList)
      {
        QLog.e("[cmshow][TraceReport]", 1, paramList, new Object[0]);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.component.DefaultTraceStorage
 * JD-Core Version:    0.7.0.1
 */