package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
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
  private static final String TAG = "Q.db.Cache";
  private IMCoreAppRuntime app;
  Vector<BaseDBQueueItem> baseQueue;
  boolean isDestroyed = false;
  
  public DBDelayManager(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    this.app = paramIMCoreAppRuntime;
    this.baseQueue = new Vector();
    this.isDestroyed = false;
  }
  
  private void transSaveToDatabase(EntityManager paramEntityManager)
  {
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      BaseDBQueueItem localBaseDBQueueItem;
      String str;
      ProxyListener localProxyListener;
      synchronized (this.baseQueue)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "transSaveToDatabase writeRunable msgQueue size:" + this.baseQueue.size());
        }
        if (this.baseQueue.isEmpty()) {
          return;
        }
        Object localObject3 = (List)this.baseQueue.clone();
        this.baseQueue.clear();
        if (localObject3 == null) {
          break label477;
        }
        localObject2 = null;
        ??? = null;
        try
        {
          localEntityTransaction = paramEntityManager.getTransaction();
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localEntityTransaction.begin();
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
          ((EntityTransaction)???).end();
          return;
          paramEntityManager = finally;
          throw paramEntityManager;
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          paramEntityManager.update(localBaseDBQueueItem.item);
          if (localProxyListener == null) {
            continue;
          }
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localProxyListener.onUpdateFinish(str, 1);
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label414;
          }
          localObject2.end();
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
        str = localBaseDBQueueItem.item.getTableName();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener = localBaseDBQueueItem.listener;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (QLog.isColorLevel())
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          QLog.d("Q.db.Cache", 2, "writeRunable QueueItem.action: " + localBaseDBQueueItem.action);
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        switch (localBaseDBQueueItem.action)
        {
        case 0: 
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          paramEntityManager.persistOrReplace(localBaseDBQueueItem.item);
          if (localProxyListener == null) {
            continue;
          }
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localProxyListener.onInsertFinish(str);
        }
      }
      label351:
      ??? = localEntityTransaction;
      label414:
      Object localObject2 = localEntityTransaction;
      paramEntityManager.remove(localBaseDBQueueItem.item);
      if (localProxyListener != null)
      {
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener.onDeleteFinish(str, 1);
        continue;
        label456:
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.commit();
        if (localEntityTransaction != null) {
          localEntityTransaction.end();
        }
        label477:
        return;
      }
    }
  }
  
  public void addQueue(Entity paramEntity, int paramInt)
  {
    addQueue(paramEntity, paramInt, 0, null);
  }
  
  public void addQueue(Entity paramEntity, int paramInt1, int paramInt2)
  {
    addQueue(paramEntity, paramInt1, paramInt2, null);
  }
  
  public void addQueue(Entity arg1, int paramInt1, int paramInt2, ProxyListener paramProxyListener)
  {
    paramProxyListener = new BaseDBQueueItem(???, paramInt1, paramInt2, paramProxyListener);
    do
    {
      synchronized (this.baseQueue)
      {
        this.baseQueue.add(paramProxyListener);
        if (this.isDestroyed)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache", 2, "addQueue after destroy");
          }
          saveNotify();
          return;
        }
      }
      switch (paramInt2)
      {
      case 2: 
      default: 
        return;
      }
    } while (!this.app.isBackgroundPause);
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    saveNotify();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    saveNotify();
  }
  
  public void addQueue(Entity paramEntity, int paramInt, ProxyListener paramProxyListener)
  {
    addQueue(paramEntity, paramInt, 0, paramProxyListener);
  }
  
  public void clearQueue()
  {
    synchronized (this.baseQueue)
    {
      this.baseQueue.clear();
      return;
    }
  }
  
  public Vector<BaseDBQueueItem> getQueue()
  {
    return this.baseQueue;
  }
  
  public void onDestroy()
  {
    try
    {
      this.isDestroyed = true;
      transSaveToDatabase();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void saveNotify()
  {
    this.app.getProxyManager().saveNotify();
  }
  
  public void start() {}
  
  public void transSaveToDatabase()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "transSaveToDatabase");
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    transSaveToDatabase(localEntityManager);
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.DBDelayManager
 * JD-Core Version:    0.7.0.1
 */