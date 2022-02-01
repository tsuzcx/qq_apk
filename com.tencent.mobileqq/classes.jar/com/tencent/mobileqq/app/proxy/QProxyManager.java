package com.tencent.mobileqq.app.proxy;

import android.util.SparseArray;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import cooperation.qlink.ReliableReportProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QProxyManager
  extends BaseProxyManager
{
  private static final String TAG = "Q.msg.MsgProxy";
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=2)
  public static ArrayList<Class<? extends BaseProxy>> sLazyProxyClassList;
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=2)
  public static ArrayList<Class<? extends BaseProxy>> sLazyProxyNewClassList;
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=2)
  public static ArrayList<Class<? extends IProxyService>> sProxyService = new ArrayList();
  Set<BaseProxy> lazyProxySet = new HashSet();
  SparseArray<BaseProxy> mProxyArray;
  private IProxyService mProxyService;
  
  static
  {
    sProxyService.add(ProxyServiceImpl.class);
    sLazyProxyClassList = new ArrayList();
    sLazyProxyClassList.add(QCallProxy.class);
    sLazyProxyClassList.add(ConfessProxy.class);
    sLazyProxyNewClassList = new ArrayList();
    sLazyProxyNewClassList.add(DataLineMsgIpadProxy.class);
    sLazyProxyNewClassList.add(DataLineMsgPcProxy.class);
    sLazyProxyNewClassList.add(FileManagerProxy.class);
    sLazyProxyNewClassList.add(MultiMsgProxy.class);
    sLazyProxyNewClassList.add(ColorNoteProxy.class);
    sLazyProxyNewClassList.add(QCallProxy.class);
    sLazyProxyNewClassList.add(ConfessProxy.class);
    sLazyProxyNewClassList.add(ReliableReportProxy.class);
  }
  
  @Deprecated
  public QProxyManager() {}
  
  public QProxyManager(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    injectData(paramAppRuntime);
  }
  
  private long doQueueAction(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    switch (paramMsgQueueItem.action)
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return paramLong2;
            return doMessageActionInsert(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramMsgQueueItem, paramString, paramProxyListener);
            paramEntityManager.persistOrReplace(paramMsgQueueItem.item);
          } while (paramProxyListener == null);
          paramProxyListener.onInsertFinish(paramString);
          return paramLong2;
          return doMessageActionUpdate(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramLong2, paramMsgQueueItem, paramString, paramProxyListener);
          paramEntityManager.update(paramMsgQueueItem.item);
        } while (paramProxyListener == null);
        paramProxyListener.onUpdateFinish(paramString, 1);
        return paramLong2;
        return doMessageActionDel(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramMsgQueueItem, paramString, paramProxyListener);
        paramEntityManager.remove(paramMsgQueueItem.item);
      } while (paramProxyListener == null);
      paramProxyListener.onDeleteFinish(paramString, 1);
      return paramLong2;
      i = getDatabase().delete(paramString, paramMsgQueueItem.whereClause, paramMsgQueueItem.whereArgs);
    } while (paramProxyListener == null);
    paramProxyListener.onDeleteFinish(paramString, i);
    return paramLong2;
  }
  
  private void injectData(AppRuntime paramAppRuntime)
  {
    try
    {
      this.mProxyService = ((IProxyService)((Class)sProxyService.get(0)).newInstance());
      this.mProxyArray = this.mProxyService.getBusinessProxy(paramAppRuntime, this);
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      QLog.d("Q.msg.MsgProxy", 1, paramAppRuntime, new Object[0]);
    }
  }
  
  protected long beforeQueueActionInTransSaveToDatabase(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return -1L;
  }
  
  protected void beforeTrans() {}
  
  protected long doMessageActionDel(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    paramLong = System.nanoTime();
    int i = getDatabase().delete(paramString, paramMsgQueueItem.whereClause, paramMsgQueueItem.whereArgs);
    paramLong = (System.nanoTime() - paramLong) / 1000L;
    if (paramProxyListener != null) {
      paramProxyListener.onDeleteFinish(paramString, i);
    }
    return paramLong;
  }
  
  protected long doMessageActionInsert(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    paramLong = System.nanoTime();
    paramEntityManager.persistOrReplace(paramMsgQueueItem.item);
    paramLong = (System.nanoTime() - paramLong) / 1000L;
    if (paramProxyListener != null) {
      paramProxyListener.onInsertFinish(paramString);
    }
    return paramLong;
  }
  
  protected long doMessageActionUpdate(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    paramLong1 = System.nanoTime();
    paramEntityManager = getDatabase();
    if (paramEntityManager != null)
    {
      int i = paramEntityManager.update(paramString, paramMsgQueueItem.value, paramMsgQueueItem.whereClause, paramMsgQueueItem.whereArgs);
      paramLong1 = (System.nanoTime() - paramLong1) / 1000L;
      paramLong2 = paramLong1;
      if (paramProxyListener != null)
      {
        paramProxyListener.onUpdateFinish(paramString, i);
        paramLong2 = paramLong1;
      }
    }
    return paramLong2;
  }
  
  protected void endTrans(EntityTransaction paramEntityTransaction, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramEntityTransaction != null) {
      paramEntityTransaction.end();
    }
  }
  
  Class[] getLazyClassArray()
  {
    if (TripleGraySwitchUtil.b(MobileQQ.sMobileQQ, "KEY_DELAY_LOAD_PROXY", true)) {}
    for (ArrayList localArrayList = sLazyProxyNewClassList;; localArrayList = sLazyProxyClassList)
    {
      Class[] arrayOfClass = new Class[localArrayList.size()];
      localArrayList.toArray(arrayOfClass);
      return arrayOfClass;
    }
  }
  
  public <T extends BaseProxy> T getProxy(int paramInt)
  {
    if ((paramInt >= 0) && (this.mProxyArray != null) && (this.mProxyArray.size() > 0)) {
      try
      {
        BaseProxy localBaseProxy = (BaseProxy)this.mProxyArray.get(paramInt);
        return localBaseProxy;
      }
      catch (Exception localException)
      {
        QLog.e("Q.msg.MsgProxy", 1, "Wrong type cast, confirm the return proxy type", localException);
      }
    }
    return null;
  }
  
  protected void init()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i < this.mProxyArray.size()) && (!this.isDestroyed))
        {
          BaseProxy localBaseProxy = (BaseProxy)this.mProxyArray.valueAt(i);
          if (localBaseProxy == null) {
            break label166;
          }
          if (isLazyProxy(localBaseProxy))
          {
            this.lazyProxySet.add(localBaseProxy);
          }
          else
          {
            TraceUtils.traceBegin("i." + localBaseProxy);
            long l = System.currentTimeMillis();
            localBaseProxy.init();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localBaseProxy.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
            }
            TraceUtils.traceEnd();
          }
        }
      }
      finally {}
      return;
      label166:
      i += 1;
    }
  }
  
  public void init_lazy()
  {
    for (;;)
    {
      try
      {
        if (!this.isDestroyed)
        {
          boolean bool = this.lazyProxySet.isEmpty();
          if (!bool) {}
        }
        else
        {
          return;
        }
        Iterator localIterator = this.lazyProxySet.iterator();
        if (localIterator.hasNext())
        {
          BaseProxy localBaseProxy = (BaseProxy)localIterator.next();
          TraceUtils.traceBegin("i." + localBaseProxy);
          long l = System.currentTimeMillis();
          localBaseProxy.init();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localBaseProxy.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
          }
          TraceUtils.traceEnd();
        }
        else
        {
          this.lazyProxySet.clear();
        }
      }
      finally {}
    }
  }
  
  /* Error */
  boolean isLazyProxy(BaseProxy paramBaseProxy)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 329	com/tencent/mobileqq/app/proxy/QProxyManager:getLazyClassArray	()[Ljava/lang/Class;
    //   9: astore 6
    //   11: iload 5
    //   13: istore 4
    //   15: aload 6
    //   17: ifnull +15 -> 32
    //   20: aload 6
    //   22: arraylength
    //   23: istore_2
    //   24: iload_2
    //   25: ifgt +12 -> 37
    //   28: iload 5
    //   30: istore 4
    //   32: aload_0
    //   33: monitorexit
    //   34: iload 4
    //   36: ireturn
    //   37: aload 6
    //   39: arraylength
    //   40: istore_3
    //   41: iconst_0
    //   42: istore_2
    //   43: iload 5
    //   45: istore 4
    //   47: iload_2
    //   48: iload_3
    //   49: if_icmpge -17 -> 32
    //   52: aload 6
    //   54: iload_2
    //   55: aaload
    //   56: astore 7
    //   58: aload_1
    //   59: invokevirtual 294	java/lang/Object:getClass	()Ljava/lang/Class;
    //   62: astore 8
    //   64: aload 8
    //   66: aload 7
    //   68: if_acmpne +9 -> 77
    //   71: iconst_1
    //   72: istore 4
    //   74: goto -42 -> 32
    //   77: iload_2
    //   78: iconst_1
    //   79: iadd
    //   80: istore_2
    //   81: goto -38 -> 43
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	QProxyManager
    //   0	89	1	paramBaseProxy	BaseProxy
    //   23	58	2	i	int
    //   40	10	3	j	int
    //   13	60	4	bool1	boolean
    //   1	43	5	bool2	boolean
    //   9	44	6	arrayOfClass	Class[]
    //   56	11	7	localClass1	Class
    //   62	3	8	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   5	11	84	finally
    //   20	24	84	finally
    //   37	41	84	finally
    //   58	64	84	finally
  }
  
  public void onDestroy()
  {
    try
    {
      this.isDestroyed = true;
      ThreadManager.post(new QProxyManager.1(this), 8, null, false);
      if (this.msgQueue != null) {}
      synchronized (this.msgQueueLock)
      {
        if (this.msgQueue != null) {
          this.msgQueueLock.notify();
        }
        int i = 0;
        if (i < this.mProxyArray.size())
        {
          ((BaseProxy)this.mProxyArray.valueAt(i)).destroy();
          i += 1;
        }
      }
    }
    finally {}
  }
  
  /* Error */
  protected void transSaveToDatabaseIndeed(EntityManager paramEntityManager, List<MsgQueueItem> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 8
    //   6: iconst_1
    //   7: ldc_w 359
    //   10: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_2
    //   15: invokeinterface 362 1 0
    //   20: ifne -7 -> 13
    //   23: aload_0
    //   24: invokevirtual 364	com/tencent/mobileqq/app/proxy/QProxyManager:beforeTrans	()V
    //   27: aload_0
    //   28: getfield 158	com/tencent/mobileqq/app/proxy/QProxyManager:mProxyService	Lcom/tencent/mobileqq/app/proxy/IProxyService;
    //   31: invokeinterface 367 1 0
    //   36: istore 12
    //   38: iload 12
    //   40: ifeq +322 -> 362
    //   43: aload_0
    //   44: getfield 158	com/tencent/mobileqq/app/proxy/QProxyManager:mProxyService	Lcom/tencent/mobileqq/app/proxy/IProxyService;
    //   47: invokeinterface 370 1 0
    //   52: ifeq +310 -> 362
    //   55: iconst_1
    //   56: istore 11
    //   58: iconst_0
    //   59: istore 10
    //   61: iconst_0
    //   62: istore 9
    //   64: ldc2_w 175
    //   67: lstore 17
    //   69: iconst_0
    //   70: istore 5
    //   72: iconst_0
    //   73: istore 4
    //   75: invokestatic 376	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   78: invokestatic 379	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   81: if_acmpne +287 -> 368
    //   84: iconst_1
    //   85: istore 8
    //   87: iload 8
    //   89: ifeq +52 -> 141
    //   92: iload 8
    //   94: istore 9
    //   96: iload 8
    //   98: istore 10
    //   100: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +38 -> 141
    //   106: iload 8
    //   108: istore 9
    //   110: iload 8
    //   112: istore 10
    //   114: ldc 8
    //   116: iconst_2
    //   117: new 260	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 381
    //   127: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload 8
    //   132: invokevirtual 384	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   135: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: iload 8
    //   143: istore 9
    //   145: iload 8
    //   147: istore 10
    //   149: aload_1
    //   150: invokevirtual 388	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   153: astore 21
    //   155: lload 17
    //   157: lstore 15
    //   159: invokestatic 183	java/lang/System:nanoTime	()J
    //   162: lstore 13
    //   164: lload 13
    //   166: lstore 15
    //   168: lload 13
    //   170: lstore 17
    //   172: aload 21
    //   174: invokevirtual 391	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   177: lload 13
    //   179: lstore 15
    //   181: lload 13
    //   183: lstore 17
    //   185: aload_0
    //   186: lload 13
    //   188: ldc2_w 175
    //   191: iload 12
    //   193: iload 11
    //   195: invokevirtual 393	com/tencent/mobileqq/app/proxy/QProxyManager:beforeQueueActionInTransSaveToDatabase	(JJZZ)J
    //   198: lstore 19
    //   200: lload 13
    //   202: lstore 15
    //   204: lload 13
    //   206: lstore 17
    //   208: aload_2
    //   209: invokeinterface 394 1 0
    //   214: astore_2
    //   215: iconst_0
    //   216: istore_3
    //   217: iconst_0
    //   218: istore 4
    //   220: lload 19
    //   222: lstore 15
    //   224: aload_2
    //   225: invokeinterface 321 1 0
    //   230: ifeq +144 -> 374
    //   233: aload_2
    //   234: invokeinterface 324 1 0
    //   239: checkcast 81	com/tencent/mobileqq/app/proxy/MsgQueueItem
    //   242: astore 22
    //   244: iload 4
    //   246: iconst_1
    //   247: iadd
    //   248: istore 5
    //   250: iload_3
    //   251: istore 6
    //   253: iload_3
    //   254: istore 7
    //   256: aload 22
    //   258: getfield 397	com/tencent/mobileqq/app/proxy/MsgQueueItem:tableName	Ljava/lang/String;
    //   261: astore 23
    //   263: iload_3
    //   264: istore 6
    //   266: iload_3
    //   267: istore 7
    //   269: aload 22
    //   271: getfield 401	com/tencent/mobileqq/app/proxy/MsgQueueItem:listener	Lcom/tencent/mobileqq/app/proxy/ProxyListener;
    //   274: astore 24
    //   276: iload_3
    //   277: istore 4
    //   279: iload_3
    //   280: istore 6
    //   282: iload_3
    //   283: istore 7
    //   285: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +34 -> 322
    //   291: iload_3
    //   292: istore 4
    //   294: iload_3
    //   295: istore 6
    //   297: iload_3
    //   298: istore 7
    //   300: aload_0
    //   301: getfield 158	com/tencent/mobileqq/app/proxy/QProxyManager:mProxyService	Lcom/tencent/mobileqq/app/proxy/IProxyService;
    //   304: aload 22
    //   306: getfield 93	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   309: invokeinterface 404 2 0
    //   314: ifeq +8 -> 322
    //   317: iload_3
    //   318: iconst_1
    //   319: iadd
    //   320: istore 4
    //   322: iload 4
    //   324: istore 6
    //   326: iload 4
    //   328: istore 7
    //   330: aload_0
    //   331: aload_1
    //   332: iload 12
    //   334: iload 8
    //   336: ldc2_w 175
    //   339: lload 15
    //   341: aload 22
    //   343: aload 23
    //   345: aload 24
    //   347: invokespecial 406	com/tencent/mobileqq/app/proxy/QProxyManager:doQueueAction	(Lcom/tencent/mobileqq/persistence/EntityManager;ZZJJLcom/tencent/mobileqq/app/proxy/MsgQueueItem;Ljava/lang/String;Lcom/tencent/mobileqq/app/proxy/ProxyListener;)J
    //   350: lstore 15
    //   352: iload 4
    //   354: istore_3
    //   355: iload 5
    //   357: istore 4
    //   359: goto -135 -> 224
    //   362: iconst_0
    //   363: istore 11
    //   365: goto -307 -> 58
    //   368: iconst_0
    //   369: istore 8
    //   371: goto -284 -> 87
    //   374: aload 21
    //   376: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   379: aload_0
    //   380: sipush 1000
    //   383: invokevirtual 413	com/tencent/mobileqq/app/proxy/QProxyManager:notifyEvent	(I)V
    //   386: aload_0
    //   387: aload 21
    //   389: iload 11
    //   391: iload 8
    //   393: lload 13
    //   395: iload 4
    //   397: iload_3
    //   398: invokevirtual 415	com/tencent/mobileqq/app/proxy/QProxyManager:endTrans	(Lcom/tencent/mobileqq/persistence/EntityTransaction;ZZJII)V
    //   401: return
    //   402: astore_1
    //   403: ldc2_w 175
    //   406: lstore 13
    //   408: aconst_null
    //   409: astore_2
    //   410: iconst_0
    //   411: istore_3
    //   412: iload 9
    //   414: istore 8
    //   416: aload_1
    //   417: invokevirtual 418	java/lang/Exception:printStackTrace	()V
    //   420: aload_0
    //   421: sipush 1001
    //   424: invokevirtual 413	com/tencent/mobileqq/app/proxy/QProxyManager:notifyEvent	(I)V
    //   427: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq +32 -> 462
    //   433: ldc 8
    //   435: iconst_2
    //   436: new 260	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   443: ldc_w 420
    //   446: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_1
    //   450: invokevirtual 423	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   453: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 426	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload_0
    //   463: aload_2
    //   464: iload 11
    //   466: iload 8
    //   468: lload 13
    //   470: iload_3
    //   471: iload 4
    //   473: invokevirtual 415	com/tencent/mobileqq/app/proxy/QProxyManager:endTrans	(Lcom/tencent/mobileqq/persistence/EntityTransaction;ZZJII)V
    //   476: return
    //   477: astore_1
    //   478: ldc2_w 175
    //   481: lstore 13
    //   483: aconst_null
    //   484: astore_2
    //   485: iconst_0
    //   486: istore_3
    //   487: iload 10
    //   489: istore 8
    //   491: iload 5
    //   493: istore 4
    //   495: aload_0
    //   496: aload_2
    //   497: iload 11
    //   499: iload 8
    //   501: lload 13
    //   503: iload_3
    //   504: iload 4
    //   506: invokevirtual 415	com/tencent/mobileqq/app/proxy/QProxyManager:endTrans	(Lcom/tencent/mobileqq/persistence/EntityTransaction;ZZJII)V
    //   509: aload_1
    //   510: athrow
    //   511: astore_1
    //   512: lload 15
    //   514: lstore 13
    //   516: aload 21
    //   518: astore_2
    //   519: iconst_0
    //   520: istore_3
    //   521: iload 5
    //   523: istore 4
    //   525: goto -30 -> 495
    //   528: astore_1
    //   529: iload_3
    //   530: istore 5
    //   532: aload 21
    //   534: astore_2
    //   535: iload 4
    //   537: istore_3
    //   538: iload 5
    //   540: istore 4
    //   542: goto -47 -> 495
    //   545: astore_1
    //   546: iload 6
    //   548: istore 4
    //   550: aload 21
    //   552: astore_2
    //   553: iload 5
    //   555: istore_3
    //   556: goto -61 -> 495
    //   559: astore_1
    //   560: goto -65 -> 495
    //   563: astore_1
    //   564: lload 17
    //   566: lstore 13
    //   568: aload 21
    //   570: astore_2
    //   571: iconst_0
    //   572: istore_3
    //   573: goto -157 -> 416
    //   576: astore_1
    //   577: iload_3
    //   578: istore 5
    //   580: aload 21
    //   582: astore_2
    //   583: iload 4
    //   585: istore_3
    //   586: iload 5
    //   588: istore 4
    //   590: goto -174 -> 416
    //   593: astore_1
    //   594: iload 7
    //   596: istore 4
    //   598: aload 21
    //   600: astore_2
    //   601: iload 5
    //   603: istore_3
    //   604: goto -188 -> 416
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	this	QProxyManager
    //   0	607	1	paramEntityManager	EntityManager
    //   0	607	2	paramList	List<MsgQueueItem>
    //   216	388	3	i	int
    //   73	524	4	j	int
    //   70	532	5	k	int
    //   251	296	6	m	int
    //   254	341	7	n	int
    //   85	415	8	bool1	boolean
    //   62	351	9	bool2	boolean
    //   59	429	10	bool3	boolean
    //   56	442	11	bool4	boolean
    //   36	297	12	bool5	boolean
    //   162	405	13	l1	long
    //   157	356	15	l2	long
    //   67	498	17	l3	long
    //   198	23	19	l4	long
    //   153	446	21	localEntityTransaction	EntityTransaction
    //   242	100	22	localMsgQueueItem	MsgQueueItem
    //   261	83	23	str	String
    //   274	72	24	localProxyListener	ProxyListener
    // Exception table:
    //   from	to	target	type
    //   75	84	402	java/lang/Exception
    //   100	106	402	java/lang/Exception
    //   114	141	402	java/lang/Exception
    //   149	155	402	java/lang/Exception
    //   75	84	477	finally
    //   100	106	477	finally
    //   114	141	477	finally
    //   149	155	477	finally
    //   159	164	511	finally
    //   172	177	511	finally
    //   185	200	511	finally
    //   208	215	511	finally
    //   224	244	528	finally
    //   374	386	528	finally
    //   256	263	545	finally
    //   269	276	545	finally
    //   285	291	545	finally
    //   300	317	545	finally
    //   330	352	545	finally
    //   416	462	559	finally
    //   159	164	563	java/lang/Exception
    //   172	177	563	java/lang/Exception
    //   185	200	563	java/lang/Exception
    //   208	215	563	java/lang/Exception
    //   224	244	576	java/lang/Exception
    //   374	386	576	java/lang/Exception
    //   256	263	593	java/lang/Exception
    //   269	276	593	java/lang/Exception
    //   285	291	593	java/lang/Exception
    //   300	317	593	java/lang/Exception
    //   330	352	593	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.QProxyManager
 * JD-Core Version:    0.7.0.1
 */