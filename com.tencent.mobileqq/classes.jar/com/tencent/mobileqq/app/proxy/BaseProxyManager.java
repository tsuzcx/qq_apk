package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.imcore.proxy.msg.MsgProxyUtilsProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class BaseProxyManager
  implements Manager
{
  private static final int STATE_NOT_SAVE = -1;
  private static final int STATE_SAVE_DELAY = 0;
  private static final int STATE_SAVE_IMMEDIATELY = 1;
  private static final String TAG = "Q.msg.MsgProxy";
  private static final int WRITE_THREAD_TIME_INTERVAL_MAX = 10000;
  private static final int WRITE_THREAD_TIME_INTERVAL_MIN = 2000;
  private static int checkAppMemoryCount = 0;
  private static int mWriteThreadInterval = 10000;
  protected AppRuntime app;
  protected SQLiteDatabase db;
  private DBDelayManager dbDelayManager;
  volatile boolean isDestroyed;
  boolean isSaveDBAtOnceFlag = false;
  private ArrayList<ProxyObserver> listenerArray = new ArrayList();
  protected Vector<MsgQueueItem> msgQueue;
  protected final Object msgQueueLock = new Object();
  public Object transSaveLock = new Object();
  private Thread writeThread;
  private long writeThreadStartTime;
  
  @Deprecated
  BaseProxyManager() {}
  
  public BaseProxyManager(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.dbDelayManager = this.app.getCacheManagerInner().getDBDelayManager();
    this.msgQueue = new Vector();
    doOnCreate();
  }
  
  private void checkAppMemory()
  {
    checkAppMemoryCount += 1;
    if (checkAppMemoryCount % 6 == 5)
    {
      long l1 = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
      long l2 = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
      double d = (float)l1 / (float)l2;
      if (d > 0.8D)
      {
        mWriteThreadInterval /= 2;
        mWriteThreadInterval = Math.max(mWriteThreadInterval, 2000);
        return;
      }
      if (d < 0.5D)
      {
        mWriteThreadInterval += 2000;
        mWriteThreadInterval = Math.min(mWriteThreadInterval, 10000);
      }
    }
  }
  
  public void addMsgQueue(String arg1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    paramContentValues = new MsgQueueItem(???, paramInt1, paramString2, paramContentValues, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
    try
    {
      synchronized (this.msgQueueLock)
      {
        this.msgQueue.add(paramContentValues);
      }
    }
    catch (OutOfMemoryError paramContentValues)
    {
      label46:
      break label46;
    }
    if (QLog.isColorLevel())
    {
      paramContentValues = new StringBuilder();
      paramContentValues.append("addMsgQueue oom, ");
      paramContentValues.append(paramString2);
      QLog.d("Q.msg.MsgProxy", 2, paramContentValues.toString());
    }
    if (this.isDestroyed)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
      }
      saveNotify();
      return;
    }
    if (this.app.isBackgroundPause)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
      }
      saveNotify();
    }
    return;
    throw paramString2;
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
      return;
    }
    if (this.app.isBackgroundPause)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
      }
      saveNotify();
    }
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
    try
    {
      synchronized (this.msgQueueLock)
      {
        this.msgQueue.add(paramEntity);
      }
    }
    catch (OutOfMemoryError paramEntity)
    {
      label42:
      break label42;
    }
    if (QLog.isColorLevel())
    {
      paramEntity = new StringBuilder();
      paramEntity.append("addMsgQueue oom, ");
      paramEntity.append(paramString2);
      QLog.d("Q.msg.MsgProxy", 2, paramEntity.toString());
    }
    return;
    throw paramString2;
  }
  
  protected void doAfterTransSaveToDatabase() {}
  
  protected void doOnCreate()
  {
    this.writeThread = new Thread(new BaseProxyManager.1(this));
    this.isDestroyed = false;
  }
  
  SQLiteDatabase getDatabase()
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
  
  boolean isSaveDBAtOnce()
  {
    if (!this.isSaveDBAtOnceFlag)
    {
      int i = getSaveInDBState();
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        if (System.currentTimeMillis() - this.writeThreadStartTime > 30000L)
        {
          this.isSaveDBAtOnceFlag = true;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("isSaveDBAtOnce timeout30s isSaveDBAtOnceFlag:");
            localStringBuilder.append(this.isSaveDBAtOnceFlag);
            QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
          }
        }
        return false;
      }
      if (i == 1)
      {
        this.isSaveDBAtOnceFlag = true;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSaveDBAtOnce unActionLoginB isSaveDBAtOnceFlag:");
          localStringBuilder.append(this.isSaveDBAtOnceFlag);
          QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
        }
      }
    }
    return true;
  }
  
  protected void notifyEvent(int paramInt)
  {
    if (this.listenerArray.isEmpty()) {
      return;
    }
    Iterator localIterator = this.listenerArray.iterator();
    while (localIterator.hasNext()) {
      ((ProxyObserver)localIterator.next()).notifyEvent(paramInt);
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
    Thread localThread = this.writeThread;
    if ((localThread != null) && (localThread.getState() == Thread.State.NEW))
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
    Object localObject = this.app;
    localObject = ((AppRuntime)localObject).getEntityManagerFactory(((AppRuntime)localObject).getAccount()).createEntityManager();
    transSaveToDatabase((EntityManager)localObject);
    ((EntityManager)localObject).close();
  }
  
  public void transSaveToDatabase(EntityManager paramEntityManager)
  {
    synchronized (this.transSaveLock)
    {
      synchronized (this.msgQueueLock)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("transSaveToDatabase writeRunnable msgQueue size:");
          ((StringBuilder)localObject3).append(this.msgQueue.size());
          QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject3).toString());
        }
        if (this.msgQueue.isEmpty()) {
          return;
        }
        Object localObject3 = this.msgQueue;
        this.msgQueue = new Vector();
        transSaveToDatabaseIndeed(paramEntityManager, (List)localObject3);
        doAfterTransSaveToDatabase();
        return;
      }
    }
  }
  
  public void transSaveToDatabase(String paramString, int paramInt)
  {
    synchronized (this.transSaveLock)
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.msgQueueLock)
      {
        if (this.msgQueue.isEmpty()) {
          return;
        }
        Iterator localIterator = this.msgQueue.iterator();
        while (localIterator.hasNext())
        {
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
          if ((MsgProxyUtilsProxy.isSaveConversation(localMsgQueueItem.frindUin, paramString, localMsgQueueItem.type, paramInt)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || (localMsgQueueItem.action == 0))) {
            localArrayList.add(localMsgQueueItem);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, new Object[] { "transSaveToDatabase writeRunnable msgQueue size:", Integer.valueOf(this.msgQueue.size()), " item size:", Integer.valueOf(localArrayList.size()) });
        }
        this.msgQueue.remove(localArrayList);
        transSaveToDatabaseIndeed(this.app.getEntityManagerFactory(this.app.getAccount()).createEntityManager(), localArrayList);
        doAfterTransSaveToDatabase();
        return;
      }
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  /* Error */
  protected void transSaveToDatabaseIndeed(EntityManager paramEntityManager, List<MsgQueueItem> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 377 1 0
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: aconst_null
    //   11: astore 8
    //   13: aconst_null
    //   14: astore 7
    //   16: aload 7
    //   18: astore 6
    //   20: aload 8
    //   22: astore 5
    //   24: invokestatic 383	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   27: invokestatic 386	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   30: if_acmpne +772 -> 802
    //   33: iconst_1
    //   34: istore 4
    //   36: goto +3 -> 39
    //   39: iload 4
    //   41: ifeq +86 -> 127
    //   44: aload 7
    //   46: astore 6
    //   48: aload 8
    //   50: astore 5
    //   52: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +72 -> 127
    //   58: aload 7
    //   60: astore 6
    //   62: aload 8
    //   64: astore 5
    //   66: new 154	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   73: astore 9
    //   75: aload 7
    //   77: astore 6
    //   79: aload 8
    //   81: astore 5
    //   83: aload 9
    //   85: ldc_w 388
    //   88: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 7
    //   94: astore 6
    //   96: aload 8
    //   98: astore 5
    //   100: aload 9
    //   102: iload 4
    //   104: invokevirtual 244	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 7
    //   110: astore 6
    //   112: aload 8
    //   114: astore 5
    //   116: ldc 17
    //   118: iconst_2
    //   119: aload 9
    //   121: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload 7
    //   129: astore 6
    //   131: aload 8
    //   133: astore 5
    //   135: aload_1
    //   136: invokevirtual 392	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   139: astore 7
    //   141: aload 7
    //   143: astore 6
    //   145: aload 7
    //   147: astore 5
    //   149: aload 7
    //   151: invokevirtual 397	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   154: aload 7
    //   156: astore 6
    //   158: aload 7
    //   160: astore 5
    //   162: aload_2
    //   163: invokeinterface 398 1 0
    //   168: astore_2
    //   169: aload 7
    //   171: astore 6
    //   173: aload 7
    //   175: astore 5
    //   177: aload_2
    //   178: invokeinterface 260 1 0
    //   183: ifeq +465 -> 648
    //   186: aload 7
    //   188: astore 6
    //   190: aload 7
    //   192: astore 5
    //   194: aload_2
    //   195: invokeinterface 263 1 0
    //   200: checkcast 140	com/tencent/mobileqq/app/proxy/MsgQueueItem
    //   203: astore 8
    //   205: aload 7
    //   207: astore 6
    //   209: aload 7
    //   211: astore 5
    //   213: aload 8
    //   215: getfield 401	com/tencent/mobileqq/app/proxy/MsgQueueItem:tableName	Ljava/lang/String;
    //   218: astore 9
    //   220: aload 7
    //   222: astore 6
    //   224: aload 7
    //   226: astore 5
    //   228: aload 8
    //   230: getfield 405	com/tencent/mobileqq/app/proxy/MsgQueueItem:listener	Lcom/tencent/mobileqq/app/proxy/ProxyListener;
    //   233: astore 10
    //   235: aload 7
    //   237: astore 6
    //   239: aload 7
    //   241: astore 5
    //   243: aload 8
    //   245: getfield 358	com/tencent/mobileqq/app/proxy/MsgQueueItem:action	I
    //   248: tableswitch	default:+560 -> 808, 0:+358->606, 1:+282->530, 2:+228->476, 3:+186->434, 4:+142->390, 5:+98->346, 6:+44->292
    //   293: iconst_4
    //   294: astore 6
    //   296: aload 7
    //   298: astore 5
    //   300: aload_0
    //   301: invokevirtual 407	com/tencent/mobileqq/app/proxy/BaseProxyManager:getDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   304: aload 9
    //   306: aload 8
    //   308: getfield 410	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereClause	Ljava/lang/String;
    //   311: aload 8
    //   313: getfield 414	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereArgs	[Ljava/lang/String;
    //   316: invokevirtual 420	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   319: istore_3
    //   320: aload 10
    //   322: ifnull -153 -> 169
    //   325: aload 7
    //   327: astore 6
    //   329: aload 7
    //   331: astore 5
    //   333: aload 10
    //   335: aload 9
    //   337: iload_3
    //   338: invokeinterface 425 3 0
    //   343: goto -174 -> 169
    //   346: aload 7
    //   348: astore 6
    //   350: aload 7
    //   352: astore 5
    //   354: aload_1
    //   355: aload 8
    //   357: getfield 429	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   360: invokevirtual 432	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   363: pop
    //   364: aload 10
    //   366: ifnull -197 -> 169
    //   369: aload 7
    //   371: astore 6
    //   373: aload 7
    //   375: astore 5
    //   377: aload 10
    //   379: aload 9
    //   381: iconst_1
    //   382: invokeinterface 425 3 0
    //   387: goto -218 -> 169
    //   390: aload 7
    //   392: astore 6
    //   394: aload 7
    //   396: astore 5
    //   398: aload_1
    //   399: aload 8
    //   401: getfield 429	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   404: invokevirtual 435	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   407: pop
    //   408: aload 10
    //   410: ifnull -241 -> 169
    //   413: aload 7
    //   415: astore 6
    //   417: aload 7
    //   419: astore 5
    //   421: aload 10
    //   423: aload 9
    //   425: iconst_1
    //   426: invokeinterface 438 3 0
    //   431: goto -262 -> 169
    //   434: aload 7
    //   436: astore 6
    //   438: aload 7
    //   440: astore 5
    //   442: aload_1
    //   443: aload 8
    //   445: getfield 429	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   448: invokevirtual 442	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   451: aload 10
    //   453: ifnull -284 -> 169
    //   456: aload 7
    //   458: astore 6
    //   460: aload 7
    //   462: astore 5
    //   464: aload 10
    //   466: aload 9
    //   468: invokeinterface 445 2 0
    //   473: goto -304 -> 169
    //   476: aload 7
    //   478: astore 6
    //   480: aload 7
    //   482: astore 5
    //   484: aload_0
    //   485: invokevirtual 407	com/tencent/mobileqq/app/proxy/BaseProxyManager:getDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   488: aload 9
    //   490: aload 8
    //   492: getfield 410	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereClause	Ljava/lang/String;
    //   495: aload 8
    //   497: getfield 414	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereArgs	[Ljava/lang/String;
    //   500: invokevirtual 420	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   503: istore_3
    //   504: aload 10
    //   506: ifnull -337 -> 169
    //   509: aload 7
    //   511: astore 6
    //   513: aload 7
    //   515: astore 5
    //   517: aload 10
    //   519: aload 9
    //   521: iload_3
    //   522: invokeinterface 425 3 0
    //   527: goto -358 -> 169
    //   530: aload 7
    //   532: astore 6
    //   534: aload 7
    //   536: astore 5
    //   538: aload_0
    //   539: invokevirtual 407	com/tencent/mobileqq/app/proxy/BaseProxyManager:getDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   542: astore 11
    //   544: aload 11
    //   546: ifnull -377 -> 169
    //   549: aload 7
    //   551: astore 6
    //   553: aload 7
    //   555: astore 5
    //   557: aload 11
    //   559: aload 9
    //   561: aload 8
    //   563: getfield 449	com/tencent/mobileqq/app/proxy/MsgQueueItem:value	Landroid/content/ContentValues;
    //   566: aload 8
    //   568: getfield 410	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereClause	Ljava/lang/String;
    //   571: aload 8
    //   573: getfield 414	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereArgs	[Ljava/lang/String;
    //   576: invokevirtual 452	com/tencent/mobileqq/app/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   579: istore_3
    //   580: aload 10
    //   582: ifnull -413 -> 169
    //   585: aload 7
    //   587: astore 6
    //   589: aload 7
    //   591: astore 5
    //   593: aload 10
    //   595: aload 9
    //   597: iload_3
    //   598: invokeinterface 438 3 0
    //   603: goto -434 -> 169
    //   606: aload 7
    //   608: astore 6
    //   610: aload 7
    //   612: astore 5
    //   614: aload_1
    //   615: aload 8
    //   617: getfield 429	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   620: invokevirtual 442	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   623: aload 10
    //   625: ifnull -456 -> 169
    //   628: aload 7
    //   630: astore 6
    //   632: aload 7
    //   634: astore 5
    //   636: aload 10
    //   638: aload 9
    //   640: invokeinterface 445 2 0
    //   645: goto -476 -> 169
    //   648: aload 7
    //   650: astore 6
    //   652: aload 7
    //   654: astore 5
    //   656: aload 7
    //   658: invokevirtual 455	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   661: aload 7
    //   663: astore 6
    //   665: aload 7
    //   667: astore 5
    //   669: aload_0
    //   670: sipush 1000
    //   673: invokevirtual 269	com/tencent/mobileqq/app/proxy/BaseProxyManager:notifyEvent	(I)V
    //   676: aload 7
    //   678: ifnull +105 -> 783
    //   681: aload 7
    //   683: astore 5
    //   685: goto +93 -> 778
    //   688: astore_1
    //   689: goto +95 -> 784
    //   692: astore_1
    //   693: aload 5
    //   695: astore 6
    //   697: aload_1
    //   698: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   701: aload 5
    //   703: astore 6
    //   705: aload_0
    //   706: sipush 1001
    //   709: invokevirtual 269	com/tencent/mobileqq/app/proxy/BaseProxyManager:notifyEvent	(I)V
    //   712: aload 5
    //   714: astore 6
    //   716: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq +54 -> 773
    //   722: aload 5
    //   724: astore 6
    //   726: new 154	java/lang/StringBuilder
    //   729: dup
    //   730: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   733: astore_2
    //   734: aload 5
    //   736: astore 6
    //   738: aload_2
    //   739: ldc_w 460
    //   742: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload 5
    //   748: astore 6
    //   750: aload_2
    //   751: aload_1
    //   752: invokevirtual 463	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   755: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 5
    //   761: astore 6
    //   763: ldc 17
    //   765: iconst_2
    //   766: aload_2
    //   767: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: invokestatic 466	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   773: aload 5
    //   775: ifnull +8 -> 783
    //   778: aload 5
    //   780: invokevirtual 469	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   783: return
    //   784: aload 6
    //   786: ifnull +8 -> 794
    //   789: aload 6
    //   791: invokevirtual 469	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   794: goto +5 -> 799
    //   797: aload_1
    //   798: athrow
    //   799: goto -2 -> 797
    //   802: iconst_0
    //   803: istore 4
    //   805: goto -766 -> 39
    //   808: goto -639 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	811	0	this	BaseProxyManager
    //   0	811	1	paramEntityManager	EntityManager
    //   0	811	2	paramList	List<MsgQueueItem>
    //   319	279	3	i	int
    //   34	770	4	bool	boolean
    //   22	757	5	localObject1	Object
    //   18	772	6	localObject2	Object
    //   14	668	7	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   11	605	8	localMsgQueueItem	MsgQueueItem
    //   73	566	9	localObject3	Object
    //   233	404	10	localProxyListener	ProxyListener
    //   542	16	11	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   24	33	688	finally
    //   52	58	688	finally
    //   66	75	688	finally
    //   83	92	688	finally
    //   100	108	688	finally
    //   116	127	688	finally
    //   135	141	688	finally
    //   149	154	688	finally
    //   162	169	688	finally
    //   177	186	688	finally
    //   194	205	688	finally
    //   213	220	688	finally
    //   228	235	688	finally
    //   243	292	688	finally
    //   300	320	688	finally
    //   333	343	688	finally
    //   354	364	688	finally
    //   377	387	688	finally
    //   398	408	688	finally
    //   421	431	688	finally
    //   442	451	688	finally
    //   464	473	688	finally
    //   484	504	688	finally
    //   517	527	688	finally
    //   538	544	688	finally
    //   557	580	688	finally
    //   593	603	688	finally
    //   614	623	688	finally
    //   636	645	688	finally
    //   656	661	688	finally
    //   669	676	688	finally
    //   697	701	688	finally
    //   705	712	688	finally
    //   716	722	688	finally
    //   726	734	688	finally
    //   738	746	688	finally
    //   750	759	688	finally
    //   763	773	688	finally
    //   24	33	692	java/lang/Exception
    //   52	58	692	java/lang/Exception
    //   66	75	692	java/lang/Exception
    //   83	92	692	java/lang/Exception
    //   100	108	692	java/lang/Exception
    //   116	127	692	java/lang/Exception
    //   135	141	692	java/lang/Exception
    //   149	154	692	java/lang/Exception
    //   162	169	692	java/lang/Exception
    //   177	186	692	java/lang/Exception
    //   194	205	692	java/lang/Exception
    //   213	220	692	java/lang/Exception
    //   228	235	692	java/lang/Exception
    //   243	292	692	java/lang/Exception
    //   300	320	692	java/lang/Exception
    //   333	343	692	java/lang/Exception
    //   354	364	692	java/lang/Exception
    //   377	387	692	java/lang/Exception
    //   398	408	692	java/lang/Exception
    //   421	431	692	java/lang/Exception
    //   442	451	692	java/lang/Exception
    //   464	473	692	java/lang/Exception
    //   484	504	692	java/lang/Exception
    //   517	527	692	java/lang/Exception
    //   538	544	692	java/lang/Exception
    //   557	580	692	java/lang/Exception
    //   593	603	692	java/lang/Exception
    //   614	623	692	java/lang/Exception
    //   636	645	692	java/lang/Exception
    //   656	661	692	java/lang/Exception
    //   669	676	692	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.BaseProxyManager
 * JD-Core Version:    0.7.0.1
 */