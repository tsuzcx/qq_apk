package com.tencent.mobileqq.app.proxy;

import android.util.SparseArray;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
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
    default: 
      break;
    case 6: 
      int i = getDatabase().delete(paramString, paramMsgQueueItem.whereClause, paramMsgQueueItem.whereArgs);
      if (paramProxyListener != null) {
        paramProxyListener.onDeleteFinish(paramString, i);
      }
      break;
    case 5: 
      paramEntityManager.remove(paramMsgQueueItem.item);
      if (paramProxyListener != null) {
        paramProxyListener.onDeleteFinish(paramString, 1);
      }
      break;
    case 4: 
      paramEntityManager.update(paramMsgQueueItem.item);
      if (paramProxyListener != null) {
        paramProxyListener.onUpdateFinish(paramString, 1);
      }
      break;
    case 3: 
      paramEntityManager.persistOrReplace(paramMsgQueueItem.item);
      if (paramProxyListener != null) {
        paramProxyListener.onInsertFinish(paramString);
      }
      break;
    case 2: 
      return doMessageActionDel(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramMsgQueueItem, paramString, paramProxyListener);
    case 1: 
      return doMessageActionUpdate(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramLong2, paramMsgQueueItem, paramString, paramProxyListener);
    case 0: 
      return doMessageActionInsert(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramMsgQueueItem, paramString, paramProxyListener);
    }
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
    ArrayList localArrayList;
    if (TripleGraySwitchUtil.b(MobileQQ.sMobileQQ, "KEY_DELAY_LOAD_PROXY", true)) {
      localArrayList = sLazyProxyNewClassList;
    } else {
      localArrayList = sLazyProxyClassList;
    }
    Class[] arrayOfClass = new Class[localArrayList.size()];
    localArrayList.toArray(arrayOfClass);
    return arrayOfClass;
  }
  
  public <T extends BaseProxy> T getProxy(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.mProxyArray;
      if ((localObject != null) && (((SparseArray)localObject).size() > 0)) {
        try
        {
          localObject = (BaseProxy)this.mProxyArray.get(paramInt);
          return localObject;
        }
        catch (Exception localException)
        {
          QLog.e("Q.msg.MsgProxy", 1, "Wrong type cast, confirm the return proxy type", localException);
        }
      }
    }
    return null;
  }
  
  protected void init()
  {
    int i = 0;
    try
    {
      while ((i < this.mProxyArray.size()) && (!this.isDestroyed))
      {
        BaseProxy localBaseProxy = (BaseProxy)this.mProxyArray.valueAt(i);
        if (localBaseProxy != null) {
          if (isLazyProxy(localBaseProxy))
          {
            this.lazyProxySet.add(localBaseProxy);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("i.");
            localStringBuilder.append(localBaseProxy);
            TraceUtils.traceBegin(localStringBuilder.toString());
            long l = System.currentTimeMillis();
            localBaseProxy.init();
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("ProxyInit , proxy=");
              localStringBuilder.append(localBaseProxy.getClass().getName());
              localStringBuilder.append("cost=");
              localStringBuilder.append(System.currentTimeMillis() - l);
              QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
            }
            TraceUtils.traceEnd();
          }
        }
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void init_lazy()
  {
    try
    {
      if ((!this.isDestroyed) && (!this.lazyProxySet.isEmpty()))
      {
        Iterator localIterator = this.lazyProxySet.iterator();
        while (localIterator.hasNext())
        {
          BaseProxy localBaseProxy = (BaseProxy)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("i.");
          localStringBuilder.append(localBaseProxy);
          TraceUtils.traceBegin(localStringBuilder.toString());
          long l = System.currentTimeMillis();
          localBaseProxy.init();
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("ProxyInit , proxy=");
            localStringBuilder.append(localBaseProxy.getClass().getName());
            localStringBuilder.append("cost=");
            localStringBuilder.append(System.currentTimeMillis() - l);
            QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
          }
          TraceUtils.traceEnd();
        }
        this.lazyProxySet.clear();
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  boolean isLazyProxy(BaseProxy paramBaseProxy)
  {
    try
    {
      Class[] arrayOfClass = getLazyClassArray();
      if ((arrayOfClass != null) && (arrayOfClass.length > 0))
      {
        int j = arrayOfClass.length;
        int i = 0;
        while (i < j)
        {
          Class localClass1 = arrayOfClass[i];
          Class localClass2 = paramBaseProxy.getClass();
          if (localClass2 == localClass1) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramBaseProxy;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.isDestroyed = true;
      ??? = new QProxyManager.1(this);
      int j = 0;
      ThreadManager.post((Runnable)???, 8, null, false);
      int i = j;
      if (this.msgQueue != null) {
        synchronized (this.msgQueueLock)
        {
          if (this.msgQueue != null) {
            this.msgQueueLock.notify();
          }
          i = j;
        }
      }
      while (i < this.mProxyArray.size())
      {
        ((BaseProxy)this.mProxyArray.valueAt(i)).destroy();
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  protected void transSaveToDatabaseIndeed(EntityManager paramEntityManager, List<MsgQueueItem> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 8
    //   6: iconst_1
    //   7: ldc_w 357
    //   10: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_2
    //   15: invokeinterface 360 1 0
    //   20: ifeq +4 -> 24
    //   23: return
    //   24: aload_0
    //   25: invokevirtual 362	com/tencent/mobileqq/app/proxy/QProxyManager:beforeTrans	()V
    //   28: aload_0
    //   29: getfield 156	com/tencent/mobileqq/app/proxy/QProxyManager:mProxyService	Lcom/tencent/mobileqq/app/proxy/IProxyService;
    //   32: invokeinterface 365 1 0
    //   37: istore 8
    //   39: iconst_0
    //   40: istore 4
    //   42: iconst_0
    //   43: istore 5
    //   45: iconst_0
    //   46: istore_3
    //   47: iload 8
    //   49: ifeq +21 -> 70
    //   52: aload_0
    //   53: getfield 156	com/tencent/mobileqq/app/proxy/QProxyManager:mProxyService	Lcom/tencent/mobileqq/app/proxy/IProxyService;
    //   56: invokeinterface 368 1 0
    //   61: ifeq +9 -> 70
    //   64: iconst_1
    //   65: istore 7
    //   67: goto +6 -> 73
    //   70: iconst_0
    //   71: istore 7
    //   73: invokestatic 374	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   76: astore 14
    //   78: invokestatic 377	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   81: astore 15
    //   83: aload 14
    //   85: aload 15
    //   87: if_acmpne +9 -> 96
    //   90: iconst_1
    //   91: istore 6
    //   93: goto +6 -> 99
    //   96: iconst_0
    //   97: istore 6
    //   99: iload 6
    //   101: ifeq +57 -> 158
    //   104: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +51 -> 158
    //   110: new 258	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   117: astore 14
    //   119: aload 14
    //   121: ldc_w 379
    //   124: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 14
    //   130: iload 6
    //   132: invokevirtual 382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: ldc 8
    //   138: iconst_2
    //   139: aload 14
    //   141: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 303	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: goto +11 -> 158
    //   150: astore_1
    //   151: goto +308 -> 459
    //   154: astore_2
    //   155: goto +324 -> 479
    //   158: aload_1
    //   159: invokevirtual 386	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   162: astore 14
    //   164: invokestatic 181	java/lang/System:nanoTime	()J
    //   167: lstore 10
    //   169: aload 14
    //   171: invokevirtual 389	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   174: aload_0
    //   175: lload 10
    //   177: ldc2_w 173
    //   180: iload 8
    //   182: iload 7
    //   184: invokevirtual 391	com/tencent/mobileqq/app/proxy/QProxyManager:beforeQueueActionInTransSaveToDatabase	(JJZZ)J
    //   187: lstore 12
    //   189: aload_2
    //   190: invokeinterface 392 1 0
    //   195: astore_2
    //   196: iconst_0
    //   197: istore 5
    //   199: iload_3
    //   200: istore 4
    //   202: iload 5
    //   204: istore_3
    //   205: aload_2
    //   206: invokeinterface 319 1 0
    //   211: ifeq +156 -> 367
    //   214: aload_2
    //   215: invokeinterface 322 1 0
    //   220: checkcast 79	com/tencent/mobileqq/app/proxy/MsgQueueItem
    //   223: astore 15
    //   225: iload_3
    //   226: iconst_1
    //   227: iadd
    //   228: istore_3
    //   229: aload 15
    //   231: getfield 395	com/tencent/mobileqq/app/proxy/MsgQueueItem:tableName	Ljava/lang/String;
    //   234: astore 16
    //   236: aload 15
    //   238: getfield 399	com/tencent/mobileqq/app/proxy/MsgQueueItem:listener	Lcom/tencent/mobileqq/app/proxy/ProxyListener;
    //   241: astore 17
    //   243: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: istore 9
    //   248: iload 4
    //   250: istore 5
    //   252: iload 9
    //   254: ifeq +48 -> 302
    //   257: aload_0
    //   258: getfield 156	com/tencent/mobileqq/app/proxy/QProxyManager:mProxyService	Lcom/tencent/mobileqq/app/proxy/IProxyService;
    //   261: aload 15
    //   263: getfield 110	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   266: invokeinterface 402 2 0
    //   271: istore 9
    //   273: iload 4
    //   275: istore 5
    //   277: iload 9
    //   279: ifeq +23 -> 302
    //   282: iload 4
    //   284: iconst_1
    //   285: iadd
    //   286: istore 5
    //   288: goto +14 -> 302
    //   291: astore_1
    //   292: goto +62 -> 354
    //   295: astore_2
    //   296: aload 14
    //   298: astore_1
    //   299: goto +189 -> 488
    //   302: aload_0
    //   303: aload_1
    //   304: iload 8
    //   306: iload 6
    //   308: ldc2_w 173
    //   311: lload 12
    //   313: aload 15
    //   315: aload 16
    //   317: aload 17
    //   319: invokespecial 404	com/tencent/mobileqq/app/proxy/QProxyManager:doQueueAction	(Lcom/tencent/mobileqq/persistence/EntityManager;ZZJJLcom/tencent/mobileqq/app/proxy/MsgQueueItem;Ljava/lang/String;Lcom/tencent/mobileqq/app/proxy/ProxyListener;)J
    //   322: lstore 12
    //   324: iload 5
    //   326: istore 4
    //   328: goto -123 -> 205
    //   331: astore_1
    //   332: aload 14
    //   334: astore_2
    //   335: iload 5
    //   337: istore 4
    //   339: goto +227 -> 566
    //   342: astore_2
    //   343: aload 14
    //   345: astore_1
    //   346: iload 5
    //   348: istore 4
    //   350: goto +138 -> 488
    //   353: astore_1
    //   354: aload 14
    //   356: astore_2
    //   357: goto +209 -> 566
    //   360: astore_2
    //   361: aload 14
    //   363: astore_1
    //   364: goto +124 -> 488
    //   367: aload 14
    //   369: invokevirtual 407	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   372: aload_0
    //   373: sipush 1000
    //   376: invokevirtual 411	com/tencent/mobileqq/app/proxy/QProxyManager:notifyEvent	(I)V
    //   379: aload 14
    //   381: astore_1
    //   382: goto +162 -> 544
    //   385: astore_1
    //   386: goto +8 -> 394
    //   389: astore_2
    //   390: goto +11 -> 401
    //   393: astore_1
    //   394: aload 14
    //   396: astore_2
    //   397: goto +169 -> 566
    //   400: astore_2
    //   401: aload 14
    //   403: astore_1
    //   404: goto +84 -> 488
    //   407: astore_1
    //   408: goto +13 -> 421
    //   411: astore_2
    //   412: goto +27 -> 439
    //   415: astore_1
    //   416: ldc2_w 173
    //   419: lstore 10
    //   421: aload 14
    //   423: astore_2
    //   424: iconst_0
    //   425: istore_3
    //   426: iload 5
    //   428: istore 4
    //   430: goto +136 -> 566
    //   433: astore_2
    //   434: ldc2_w 173
    //   437: lstore 10
    //   439: aload 14
    //   441: astore_1
    //   442: iconst_0
    //   443: istore_3
    //   444: goto +44 -> 488
    //   447: astore_1
    //   448: goto +11 -> 459
    //   451: astore_2
    //   452: goto +27 -> 479
    //   455: astore_1
    //   456: iconst_0
    //   457: istore 6
    //   459: ldc2_w 173
    //   462: lstore 10
    //   464: iconst_0
    //   465: istore_3
    //   466: aconst_null
    //   467: astore_2
    //   468: iload 5
    //   470: istore 4
    //   472: goto +94 -> 566
    //   475: astore_2
    //   476: iconst_0
    //   477: istore 6
    //   479: iconst_0
    //   480: istore_3
    //   481: ldc2_w 173
    //   484: lstore 10
    //   486: aconst_null
    //   487: astore_1
    //   488: aload_2
    //   489: invokevirtual 414	java/lang/Exception:printStackTrace	()V
    //   492: aload_0
    //   493: sipush 1001
    //   496: invokevirtual 411	com/tencent/mobileqq/app/proxy/QProxyManager:notifyEvent	(I)V
    //   499: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   502: ifeq +42 -> 544
    //   505: new 258	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   512: astore 14
    //   514: aload 14
    //   516: ldc_w 416
    //   519: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 14
    //   525: aload_2
    //   526: invokevirtual 419	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   529: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: ldc 8
    //   535: iconst_2
    //   536: aload 14
    //   538: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 422	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: aload_0
    //   545: aload_1
    //   546: iload 7
    //   548: iload 6
    //   550: lload 10
    //   552: iload_3
    //   553: iload 4
    //   555: invokevirtual 424	com/tencent/mobileqq/app/proxy/QProxyManager:endTrans	(Lcom/tencent/mobileqq/persistence/EntityTransaction;ZZJII)V
    //   558: return
    //   559: astore 14
    //   561: aload_1
    //   562: astore_2
    //   563: aload 14
    //   565: astore_1
    //   566: aload_0
    //   567: aload_2
    //   568: iload 7
    //   570: iload 6
    //   572: lload 10
    //   574: iload_3
    //   575: iload 4
    //   577: invokevirtual 424	com/tencent/mobileqq/app/proxy/QProxyManager:endTrans	(Lcom/tencent/mobileqq/persistence/EntityTransaction;ZZJII)V
    //   580: goto +5 -> 585
    //   583: aload_1
    //   584: athrow
    //   585: goto -2 -> 583
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	QProxyManager
    //   0	588	1	paramEntityManager	EntityManager
    //   0	588	2	paramList	List<MsgQueueItem>
    //   46	529	3	i	int
    //   40	536	4	j	int
    //   43	426	5	k	int
    //   91	480	6	bool1	boolean
    //   65	504	7	bool2	boolean
    //   37	268	8	bool3	boolean
    //   246	32	9	bool4	boolean
    //   167	406	10	l1	long
    //   187	136	12	l2	long
    //   76	461	14	localObject1	Object
    //   559	5	14	localObject2	Object
    //   81	233	15	localObject3	Object
    //   234	82	16	str	String
    //   241	77	17	localProxyListener	ProxyListener
    // Exception table:
    //   from	to	target	type
    //   104	147	150	finally
    //   104	147	154	java/lang/Exception
    //   257	273	291	finally
    //   257	273	295	java/lang/Exception
    //   302	324	331	finally
    //   302	324	342	java/lang/Exception
    //   229	248	353	finally
    //   229	248	360	java/lang/Exception
    //   367	379	385	finally
    //   367	379	389	java/lang/Exception
    //   205	225	393	finally
    //   205	225	400	java/lang/Exception
    //   169	196	407	finally
    //   169	196	411	java/lang/Exception
    //   164	169	415	finally
    //   164	169	433	java/lang/Exception
    //   158	164	447	finally
    //   158	164	451	java/lang/Exception
    //   73	83	455	finally
    //   73	83	475	java/lang/Exception
    //   488	544	559	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.QProxyManager
 * JD-Core Version:    0.7.0.1
 */