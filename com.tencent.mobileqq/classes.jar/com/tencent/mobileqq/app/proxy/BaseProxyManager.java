package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.MsgProxyUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;

public class BaseProxyManager
  implements Manager
{
  private static final int STATE_NOT_SAVE = -1;
  private static final int STATE_SAVE_DELAY = 0;
  private static final int STATE_SAVE_IMMEDIATELY = 1;
  private static final String TAG = "Q.msg.MsgProxy";
  private static int WRITE_THREAD_TIME_INTERVAL_MAX = 10000;
  private static int WRITE_THREAD_TIME_INTERVAL_MIN;
  private static int checkAppMemoryCount;
  private static int mWriteThreadInterval = 10000;
  private IMCoreAppRuntime app;
  protected SQLiteDatabase db;
  private DBDelayManager dbDelayManager;
  volatile boolean isDestroyed;
  private boolean isSaveDBAtOnceFlag;
  private ArrayList<ProxyObserver> listenerArray = new ArrayList();
  protected Vector<MsgQueueItem> msgQueue;
  protected final Object msgQueueLock = new Object();
  public Object transSaveLock = new Object();
  private Thread writeThread;
  private long writeThreadStartTime;
  
  static
  {
    WRITE_THREAD_TIME_INTERVAL_MIN = 2000;
  }
  
  @Deprecated
  BaseProxyManager() {}
  
  public BaseProxyManager(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    this.app = paramIMCoreAppRuntime;
    this.dbDelayManager = this.app.getCacheManager().getDBDelayManager();
    this.msgQueue = new Vector();
    doOnCreate();
  }
  
  private void checkAppMemory()
  {
    checkAppMemoryCount += 1;
    float f;
    if (checkAppMemoryCount % 6 == 5)
    {
      long l1 = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
      long l2 = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
      f = (float)l1 / (float)l2;
      if (f <= 0.8D) {
        break label86;
      }
      mWriteThreadInterval /= 2;
      mWriteThreadInterval = Math.max(mWriteThreadInterval, WRITE_THREAD_TIME_INTERVAL_MIN);
    }
    label86:
    while (f >= 0.5D) {
      return;
    }
    mWriteThreadInterval += 2000;
    mWriteThreadInterval = Math.min(mWriteThreadInterval, WRITE_THREAD_TIME_INTERVAL_MAX);
  }
  
  private boolean isSaveDBAtOnce()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    int i;
    if (!this.isSaveDBAtOnceFlag)
    {
      i = getSaveInDBState();
      if (i != 0) {
        break label78;
      }
      if (System.currentTimeMillis() - this.writeThreadStartTime > 30000L)
      {
        this.isSaveDBAtOnceFlag = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "isSaveDBAtOnce timeout30s isSaveDBAtOnceFlag:" + this.isSaveDBAtOnceFlag);
        }
      }
      bool1 = false;
    }
    label78:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (i != 1);
      this.isSaveDBAtOnceFlag = true;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MsgProxy", 2, "isSaveDBAtOnce unActionLoginB isSaveDBAtOnceFlag:" + this.isSaveDBAtOnceFlag);
    return true;
  }
  
  public void addMsgQueue(String arg1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    paramContentValues = new MsgQueueItem(???, paramInt1, paramString2, paramContentValues, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
    do
    {
      synchronized (this.msgQueueLock)
      {
        try
        {
          this.msgQueue.add(paramContentValues);
          if (this.isDestroyed)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
            }
            saveNotify();
            return;
          }
        }
        catch (OutOfMemoryError paramContentValues)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue oom, " + paramString2);
            }
          }
        }
      }
    } while (!this.app.isBackground_Pause);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
    }
    saveNotify();
  }
  
  public void addMsgQueue(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    doAddMsgQueue(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    if (this.isDestroyed)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
      }
      saveNotify();
    }
    while (!this.app.isBackground_Pause) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
    }
    saveNotify();
  }
  
  public void addMsgQueue(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    addMsgQueue(paramString1, paramInt1, paramString2, null, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
  }
  
  public void addMsgQueueAndNotify(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    doAddMsgQueue(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    saveNotify();
  }
  
  public void addMsgQueueDonotNotify(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    doAddMsgQueue(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    if (this.isDestroyed)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
      }
      saveNotify();
    }
  }
  
  public void addProxyObserver(ProxyObserver paramProxyObserver)
  {
    if (!this.listenerArray.contains(paramProxyObserver)) {
      this.listenerArray.add(paramProxyObserver);
    }
  }
  
  public void clearMsgQueue()
  {
    synchronized (this.msgQueueLock)
    {
      this.msgQueue.clear();
      return;
    }
  }
  
  public void doAddMsgQueue(String arg1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    paramEntity = new MsgQueueItem(???, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    synchronized (this.msgQueueLock)
    {
      try
      {
        this.msgQueue.add(paramEntity);
        return;
      }
      catch (OutOfMemoryError paramEntity)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue oom, " + paramString2);
          }
        }
      }
    }
  }
  
  protected void doAfterTransSaveToDatabase() {}
  
  protected void doOnCreate()
  {
    this.writeThread = new Thread(new BaseProxyManager.1(this));
    this.isDestroyed = false;
  }
  
  protected SQLiteDatabase getDatabase()
  {
    if (this.db == null) {
      this.db = this.app.getWritableDatabase();
    }
    return this.db;
  }
  
  public Object getMsgQueueLock()
  {
    return this.msgQueueLock;
  }
  
  public Vector<MsgQueueItem> getQueue()
  {
    return this.msgQueue;
  }
  
  protected int getSaveInDBState()
  {
    return 1;
  }
  
  protected void init() {}
  
  protected void notifyEvent(int paramInt)
  {
    if (this.listenerArray.isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.listenerArray.iterator();
      while (localIterator.hasNext()) {
        ((ProxyObserver)localIterator.next()).notifyEvent(paramInt);
      }
    }
  }
  
  public void notifyRefreshTroopMember()
  {
    notifyEvent(2000);
  }
  
  public void onDestroy() {}
  
  public void removeProxyObserver(ProxyObserver paramProxyObserver)
  {
    if (this.listenerArray.contains(paramProxyObserver)) {
      this.listenerArray.remove(paramProxyObserver);
    }
  }
  
  public void saveNotify()
  {
    if (this.isDestroyed)
    {
      transSaveToDatabase();
      this.dbDelayManager.transSaveToDatabase();
      return;
    }
    synchronized (this.msgQueueLock)
    {
      this.msgQueueLock.notify();
      return;
    }
  }
  
  public void start()
  {
    if ((this.writeThread != null) && (this.writeThread.getState() == Thread.State.NEW))
    {
      init();
      this.writeThread.setName("QQ_DB");
      this.writeThread.start();
    }
  }
  
  public void transSaveToDatabase()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "transSaveToDatabase");
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory(this.app.getAccount()).createEntityManager();
    transSaveToDatabase(localEntityManager);
    localEntityManager.close();
  }
  
  /* Error */
  public void transSaveToDatabase(EntityManager paramEntityManager)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/tencent/mobileqq/app/proxy/BaseProxyManager:transSaveLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 58	com/tencent/mobileqq/app/proxy/BaseProxyManager:msgQueueLock	Ljava/lang/Object;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +35 -> 52
    //   20: ldc 17
    //   22: iconst_2
    //   23: new 159	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 334
    //   33: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 88	com/tencent/mobileqq/app/proxy/BaseProxyManager:msgQueue	Ljava/util/Vector;
    //   40: invokevirtual 337	java/util/Vector:size	()I
    //   43: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 88	com/tencent/mobileqq/app/proxy/BaseProxyManager:msgQueue	Ljava/util/Vector;
    //   56: invokevirtual 341	java/util/Vector:isEmpty	()Z
    //   59: ifeq +8 -> 67
    //   62: aload_3
    //   63: monitorexit
    //   64: aload_2
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: getfield 88	com/tencent/mobileqq/app/proxy/BaseProxyManager:msgQueue	Ljava/util/Vector;
    //   71: astore 4
    //   73: aload_0
    //   74: new 85	java/util/Vector
    //   77: dup
    //   78: invokespecial 86	java/util/Vector:<init>	()V
    //   81: putfield 88	com/tencent/mobileqq/app/proxy/BaseProxyManager:msgQueue	Ljava/util/Vector;
    //   84: aload_3
    //   85: monitorexit
    //   86: aload_0
    //   87: aload_1
    //   88: aload 4
    //   90: invokevirtual 345	com/tencent/mobileqq/app/proxy/BaseProxyManager:transSaveToDatabaseIndeed	(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/List;)V
    //   93: aload_0
    //   94: invokevirtual 347	com/tencent/mobileqq/app/proxy/BaseProxyManager:doAfterTransSaveToDatabase	()V
    //   97: aload_2
    //   98: monitorexit
    //   99: return
    //   100: astore_1
    //   101: aload_2
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: aload_3
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	BaseProxyManager
    //   0	110	1	paramEntityManager	EntityManager
    //   4	98	2	localObject1	Object
    //   71	18	4	localVector	Vector
    // Exception table:
    //   from	to	target	type
    //   7	14	100	finally
    //   64	66	100	finally
    //   86	99	100	finally
    //   101	103	100	finally
    //   108	110	100	finally
    //   14	52	105	finally
    //   52	64	105	finally
    //   67	86	105	finally
    //   106	108	105	finally
  }
  
  public void transSaveToDatabase(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    synchronized (this.transSaveLock)
    {
      localArrayList = new ArrayList();
      synchronized (this.msgQueueLock)
      {
        if (this.msgQueue.isEmpty()) {
          return;
        }
        Iterator localIterator = this.msgQueue.iterator();
        while (localIterator.hasNext())
        {
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
          if ((IMCoreProxyRoute.MsgProxyUtils.isSaveConversation(localMsgQueueItem.frindUin, paramString, localMsgQueueItem.type, paramInt)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || (localMsgQueueItem.action == 0))) {
            localArrayList.add(localMsgQueueItem);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "transSaveToDatabase writeRunnable msgQueue size:", Integer.valueOf(this.msgQueue.size()), " item size:", Integer.valueOf(localArrayList.size()) });
    }
    this.msgQueue.remove(localArrayList);
    transSaveToDatabaseIndeed(this.app.getEntityManagerFactory(this.app.getAccount()).createEntityManager(), localArrayList);
    doAfterTransSaveToDatabase();
  }
  
  protected void transSaveToDatabaseIndeed(EntityManager paramEntityManager, List<MsgQueueItem> paramList)
  {
    boolean bool = true;
    if (paramList.isEmpty()) {
      return;
    }
    MsgQueueItem localMsgQueueItem = null;
    EntityTransaction localEntityTransaction2 = null;
    EntityTransaction localEntityTransaction1 = localEntityTransaction2;
    Object localObject = localMsgQueueItem;
    for (;;)
    {
      String str;
      ProxyListener localProxyListener;
      try
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          if (bool)
          {
            localEntityTransaction1 = localEntityTransaction2;
            localObject = localMsgQueueItem;
            if (QLog.isColorLevel())
            {
              localEntityTransaction1 = localEntityTransaction2;
              localObject = localMsgQueueItem;
              QLog.d("Q.msg.MsgProxy", 2, "transSaveToDatabase: isMainThread = " + bool);
            }
          }
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localMsgQueueItem;
          localEntityTransaction2 = paramEntityManager.getTransaction();
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          localEntityTransaction2.begin();
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          paramList = paramList.iterator();
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          if (!paramList.hasNext()) {
            break label701;
          }
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          localMsgQueueItem = (MsgQueueItem)paramList.next();
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          str = localMsgQueueItem.tableName;
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          localProxyListener = localMsgQueueItem.listener;
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          switch (localMsgQueueItem.action)
          {
          case 0: 
            localEntityTransaction1 = localEntityTransaction2;
            localObject = localEntityTransaction2;
            paramEntityManager.persistOrReplace(localMsgQueueItem.item);
            if (localProxyListener == null) {
              continue;
            }
            localEntityTransaction1 = localEntityTransaction2;
            localObject = localEntityTransaction2;
            localProxyListener.onInsertFinish(str);
            continue;
          }
        }
      }
      catch (Exception paramEntityManager)
      {
        localObject = localEntityTransaction1;
        paramEntityManager.printStackTrace();
        localObject = localEntityTransaction1;
        notifyEvent(1001);
        localObject = localEntityTransaction1;
        if (QLog.isColorLevel())
        {
          localObject = localEntityTransaction1;
          QLog.w("Q.msg.MsgProxy", 2, "writeRunable write exception: " + paramEntityManager.getMessage());
        }
        if (localEntityTransaction1 == null) {
          break;
        }
        localEntityTransaction1.end();
        return;
        bool = false;
        continue;
        localEntityTransaction1 = localEntityTransaction2;
        localObject = localEntityTransaction2;
        paramEntityManager.persistOrReplace(localMsgQueueItem.item);
        if (localProxyListener == null) {
          continue;
        }
        localEntityTransaction1 = localEntityTransaction2;
        localObject = localEntityTransaction2;
        localProxyListener.onInsertFinish(str);
        continue;
      }
      finally
      {
        if (localObject != null) {
          ((EntityTransaction)localObject).end();
        }
      }
      localEntityTransaction1 = localEntityTransaction2;
      localObject = localEntityTransaction2;
      SQLiteDatabase localSQLiteDatabase = getDatabase();
      if (localSQLiteDatabase != null)
      {
        localEntityTransaction1 = localEntityTransaction2;
        localObject = localEntityTransaction2;
        int i = localSQLiteDatabase.update(str, localMsgQueueItem.value, localMsgQueueItem.whereClause, localMsgQueueItem.whereArgs);
        if (localProxyListener != null)
        {
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          localProxyListener.onUpdateFinish(str, i);
          continue;
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          paramEntityManager.update(localMsgQueueItem.item);
          if (localProxyListener != null)
          {
            localEntityTransaction1 = localEntityTransaction2;
            localObject = localEntityTransaction2;
            localProxyListener.onUpdateFinish(str, 1);
            continue;
            localEntityTransaction1 = localEntityTransaction2;
            localObject = localEntityTransaction2;
            i = getDatabase().delete(str, localMsgQueueItem.whereClause, localMsgQueueItem.whereArgs);
            if (localProxyListener != null)
            {
              localEntityTransaction1 = localEntityTransaction2;
              localObject = localEntityTransaction2;
              localProxyListener.onDeleteFinish(str, i);
              continue;
              localEntityTransaction1 = localEntityTransaction2;
              localObject = localEntityTransaction2;
              paramEntityManager.remove(localMsgQueueItem.item);
              if (localProxyListener != null)
              {
                localEntityTransaction1 = localEntityTransaction2;
                localObject = localEntityTransaction2;
                localProxyListener.onDeleteFinish(str, 1);
                continue;
                localEntityTransaction1 = localEntityTransaction2;
                localObject = localEntityTransaction2;
                i = getDatabase().delete(str, localMsgQueueItem.whereClause, localMsgQueueItem.whereArgs);
                if (localProxyListener != null)
                {
                  localEntityTransaction1 = localEntityTransaction2;
                  localObject = localEntityTransaction2;
                  localProxyListener.onDeleteFinish(str, i);
                  continue;
                  label701:
                  localEntityTransaction1 = localEntityTransaction2;
                  localObject = localEntityTransaction2;
                  localEntityTransaction2.commit();
                  localEntityTransaction1 = localEntityTransaction2;
                  localObject = localEntityTransaction2;
                  notifyEvent(1000);
                  if (localEntityTransaction2 == null) {
                    break;
                  }
                  localEntityTransaction2.end();
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.BaseProxyManager
 * JD-Core Version:    0.7.0.1
 */