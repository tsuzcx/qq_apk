package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class DBDelayManager
  implements Manager
{
  private static final String TAG = "Q.db.Cache";
  private AppRuntime app;
  Vector<BaseDBQueueItem> baseQueue;
  boolean isDestroyed = false;
  
  public DBDelayManager(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.baseQueue = new Vector();
    this.isDestroyed = false;
  }
  
  /* Error */
  private void transSaveToDatabase(EntityManager paramEntityManager)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/mobileqq/app/asyncdb/DBDelayManager:baseQueue	Ljava/util/Vector;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +44 -> 54
    //   13: new 44	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 47
    //   26: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: aload_0
    //   33: getfield 31	com/tencent/mobileqq/app/asyncdb/DBDelayManager:baseQueue	Ljava/util/Vector;
    //   36: invokevirtual 55	java/util/Vector:size	()I
    //   39: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: ldc 10
    //   45: iconst_2
    //   46: aload 4
    //   48: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_0
    //   55: getfield 31	com/tencent/mobileqq/app/asyncdb/DBDelayManager:baseQueue	Ljava/util/Vector;
    //   58: invokevirtual 69	java/util/Vector:isEmpty	()Z
    //   61: ifeq +6 -> 67
    //   64: aload_3
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: getfield 31	com/tencent/mobileqq/app/asyncdb/DBDelayManager:baseQueue	Ljava/util/Vector;
    //   71: invokevirtual 73	java/util/Vector:clone	()Ljava/lang/Object;
    //   74: checkcast 75	java/util/List
    //   77: astore 6
    //   79: aload_0
    //   80: getfield 31	com/tencent/mobileqq/app/asyncdb/DBDelayManager:baseQueue	Ljava/util/Vector;
    //   83: invokevirtual 78	java/util/Vector:clear	()V
    //   86: aload_3
    //   87: monitorexit
    //   88: aload 6
    //   90: ifnull +378 -> 468
    //   93: aconst_null
    //   94: astore_3
    //   95: aconst_null
    //   96: astore 4
    //   98: aload_1
    //   99: invokevirtual 84	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   102: astore 5
    //   104: aload 5
    //   106: astore 4
    //   108: aload 5
    //   110: astore_3
    //   111: aload 5
    //   113: invokevirtual 89	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   116: aload 5
    //   118: astore 4
    //   120: aload 5
    //   122: astore_3
    //   123: aload 6
    //   125: invokeinterface 93 1 0
    //   130: astore 6
    //   132: aload 5
    //   134: astore 4
    //   136: aload 5
    //   138: astore_3
    //   139: aload 6
    //   141: invokeinterface 98 1 0
    //   146: ifeq +207 -> 353
    //   149: aload 5
    //   151: astore 4
    //   153: aload 5
    //   155: astore_3
    //   156: aload 6
    //   158: invokeinterface 101 1 0
    //   163: checkcast 103	com/tencent/mobileqq/app/asyncdb/BaseDBQueueItem
    //   166: astore 7
    //   168: aload 5
    //   170: astore 4
    //   172: aload 5
    //   174: astore_3
    //   175: aload 7
    //   177: getfield 107	com/tencent/mobileqq/app/asyncdb/BaseDBQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   180: invokevirtual 112	com/tencent/mobileqq/persistence/Entity:getTableName	()Ljava/lang/String;
    //   183: astore 8
    //   185: aload 5
    //   187: astore 4
    //   189: aload 5
    //   191: astore_3
    //   192: aload 7
    //   194: getfield 116	com/tencent/mobileqq/app/asyncdb/BaseDBQueueItem:listener	Lcom/tencent/mobileqq/app/proxy/ProxyListener;
    //   197: astore 9
    //   199: aload 5
    //   201: astore 4
    //   203: aload 5
    //   205: astore_3
    //   206: aload 7
    //   208: getfield 120	com/tencent/mobileqq/app/asyncdb/BaseDBQueueItem:action	I
    //   211: istore_2
    //   212: iload_2
    //   213: ifeq +100 -> 313
    //   216: iload_2
    //   217: iconst_1
    //   218: if_icmpeq +53 -> 271
    //   221: iload_2
    //   222: iconst_2
    //   223: if_icmpeq +6 -> 229
    //   226: goto -94 -> 132
    //   229: aload 5
    //   231: astore 4
    //   233: aload 5
    //   235: astore_3
    //   236: aload_1
    //   237: aload 7
    //   239: getfield 107	com/tencent/mobileqq/app/asyncdb/BaseDBQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   242: invokevirtual 124	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   245: pop
    //   246: aload 9
    //   248: ifnull -116 -> 132
    //   251: aload 5
    //   253: astore 4
    //   255: aload 5
    //   257: astore_3
    //   258: aload 9
    //   260: aload 8
    //   262: iconst_1
    //   263: invokeinterface 130 3 0
    //   268: goto -136 -> 132
    //   271: aload 5
    //   273: astore 4
    //   275: aload 5
    //   277: astore_3
    //   278: aload_1
    //   279: aload 7
    //   281: getfield 107	com/tencent/mobileqq/app/asyncdb/BaseDBQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   284: invokevirtual 133	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   287: pop
    //   288: aload 9
    //   290: ifnull -158 -> 132
    //   293: aload 5
    //   295: astore 4
    //   297: aload 5
    //   299: astore_3
    //   300: aload 9
    //   302: aload 8
    //   304: iconst_1
    //   305: invokeinterface 136 3 0
    //   310: goto -178 -> 132
    //   313: aload 5
    //   315: astore 4
    //   317: aload 5
    //   319: astore_3
    //   320: aload_1
    //   321: aload 7
    //   323: getfield 107	com/tencent/mobileqq/app/asyncdb/BaseDBQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   326: invokevirtual 140	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   329: aload 9
    //   331: ifnull -199 -> 132
    //   334: aload 5
    //   336: astore 4
    //   338: aload 5
    //   340: astore_3
    //   341: aload 9
    //   343: aload 8
    //   345: invokeinterface 144 2 0
    //   350: goto -218 -> 132
    //   353: aload 5
    //   355: astore 4
    //   357: aload 5
    //   359: astore_3
    //   360: aload 5
    //   362: invokevirtual 147	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   365: aload 5
    //   367: ifnull +101 -> 468
    //   370: aload 5
    //   372: astore_3
    //   373: goto +78 -> 451
    //   376: astore_1
    //   377: goto +79 -> 456
    //   380: astore_1
    //   381: aload_3
    //   382: astore 4
    //   384: aload_1
    //   385: invokevirtual 150	java/lang/Exception:printStackTrace	()V
    //   388: aload_3
    //   389: astore 4
    //   391: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +53 -> 447
    //   397: aload_3
    //   398: astore 4
    //   400: new 44	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   407: astore 5
    //   409: aload_3
    //   410: astore 4
    //   412: aload 5
    //   414: ldc 152
    //   416: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_3
    //   421: astore 4
    //   423: aload 5
    //   425: aload_1
    //   426: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   429: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload_3
    //   434: astore 4
    //   436: ldc 10
    //   438: iconst_2
    //   439: aload 5
    //   441: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 158	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_3
    //   448: ifnull +20 -> 468
    //   451: aload_3
    //   452: invokevirtual 161	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   455: return
    //   456: aload 4
    //   458: ifnull +8 -> 466
    //   461: aload 4
    //   463: invokevirtual 161	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   466: aload_1
    //   467: athrow
    //   468: return
    //   469: astore_1
    //   470: aload_3
    //   471: monitorexit
    //   472: goto +5 -> 477
    //   475: aload_1
    //   476: athrow
    //   477: goto -2 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	this	DBDelayManager
    //   0	480	1	paramEntityManager	EntityManager
    //   211	13	2	i	int
    //   4	467	3	localObject1	Object
    //   20	442	4	localObject2	Object
    //   102	338	5	localObject3	Object
    //   77	80	6	localObject4	Object
    //   166	156	7	localBaseDBQueueItem	BaseDBQueueItem
    //   183	161	8	str	String
    //   197	145	9	localProxyListener	ProxyListener
    // Exception table:
    //   from	to	target	type
    //   98	104	376	finally
    //   111	116	376	finally
    //   123	132	376	finally
    //   139	149	376	finally
    //   156	168	376	finally
    //   175	185	376	finally
    //   192	199	376	finally
    //   206	212	376	finally
    //   236	246	376	finally
    //   258	268	376	finally
    //   278	288	376	finally
    //   300	310	376	finally
    //   320	329	376	finally
    //   341	350	376	finally
    //   360	365	376	finally
    //   384	388	376	finally
    //   391	397	376	finally
    //   400	409	376	finally
    //   412	420	376	finally
    //   423	433	376	finally
    //   436	447	376	finally
    //   98	104	380	java/lang/Exception
    //   111	116	380	java/lang/Exception
    //   123	132	380	java/lang/Exception
    //   139	149	380	java/lang/Exception
    //   156	168	380	java/lang/Exception
    //   175	185	380	java/lang/Exception
    //   192	199	380	java/lang/Exception
    //   206	212	380	java/lang/Exception
    //   236	246	380	java/lang/Exception
    //   258	268	380	java/lang/Exception
    //   278	288	380	java/lang/Exception
    //   300	310	380	java/lang/Exception
    //   320	329	380	java/lang/Exception
    //   341	350	380	java/lang/Exception
    //   360	365	380	java/lang/Exception
    //   7	54	469	finally
    //   54	66	469	finally
    //   67	88	469	finally
    //   470	472	469	finally
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
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
        }
        saveNotify();
        return;
      }
      if (this.app.isBackgroundPause)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
        }
        saveNotify();
      }
      return;
    }
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
    this.app.getProxyManagerInner().saveNotify();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.DBDelayManager
 * JD-Core Version:    0.7.0.1
 */