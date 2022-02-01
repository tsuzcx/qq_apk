import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class anje
  implements anji
{
  public QQAppInterface a()
  {
    if (BaseApplicationImpl.sProcessId == 1)
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
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    Object localObject;
    EntityTransaction localEntityTransaction;
    TraceData localTraceData;
    try
    {
      localObject = a();
      if (localObject == null) {
        return false;
      }
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      localEntityTransaction = ((EntityManager)localObject).getTransaction();
      localEntityTransaction.begin();
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localTraceData = (TraceData)paramList.next();
          if (localTraceData.getStatus() == 1000)
          {
            ((EntityManager)localObject).persistOrReplace(localTraceData);
            continue;
            return true;
          }
        }
      }
    }
    catch (Throwable paramList)
    {
      QLog.e("TraceReport", 1, paramList, new Object[0]);
    }
    for (;;)
    {
      ((EntityManager)localObject).update(localTraceData);
      break;
      localEntityTransaction.commit();
      localEntityTransaction.end();
      ((EntityManager)localObject).close();
    }
  }
  
  public boolean b(List<TraceData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    Object localObject;
    EntityTransaction localEntityTransaction;
    try
    {
      localObject = a();
      if (localObject == null) {
        return false;
      }
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      localEntityTransaction = ((EntityManager)localObject).getTransaction();
      localEntityTransaction.begin();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ((EntityManager)localObject).remove((TraceData)paramList.next());
        continue;
        return true;
      }
    }
    catch (Throwable paramList)
    {
      QLog.e("TraceReport", 1, paramList, new Object[0]);
    }
    for (;;)
    {
      localEntityTransaction.commit();
      localEntityTransaction.end();
      ((EntityManager)localObject).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anje
 * JD-Core Version:    0.7.0.1
 */