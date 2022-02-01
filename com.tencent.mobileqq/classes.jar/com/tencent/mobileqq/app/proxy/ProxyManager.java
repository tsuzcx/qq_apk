package com.tencent.mobileqq.app.proxy;

import abwq;
import abww;
import abwy;
import abwz;
import anlo;
import anus;
import anut;
import anuu;
import anuv;
import anux;
import anuy;
import anuz;
import aplh;
import apsj;
import asln;
import atgm;
import atyl;
import avug;
import azjg;
import bbko;
import bcei;
import beeh;
import bjun;
import bknj;
import bkwm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class ProxyManager
  extends BaseProxyManager
{
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { azjg.class, apsj.class };
  private static final Class[] jdField_b_of_type_ArrayOfJavaLangClass = { anut.class, anuu.class, asln.class, bknj.class, anlo.class, aplh.class, atyl.class, azjg.class, apsj.class };
  private abwq jdField_a_of_type_Abwq;
  private abwy jdField_a_of_type_Abwy;
  private anlo jdField_a_of_type_Anlo;
  private anuv jdField_a_of_type_Anuv;
  private anuy jdField_a_of_type_Anuy;
  private aplh jdField_a_of_type_Aplh;
  private apsj jdField_a_of_type_Apsj;
  private asln jdField_a_of_type_Asln;
  private atgm jdField_a_of_type_Atgm;
  private atyl jdField_a_of_type_Atyl;
  private avug jdField_a_of_type_Avug;
  private azjg jdField_a_of_type_Azjg;
  private bcei jdField_a_of_type_Bcei;
  private beeh jdField_a_of_type_Beeh;
  private bknj jdField_a_of_type_Bknj;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Set<anus> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  private anus[] jdField_a_of_type_ArrayOfAnus;
  private anuv jdField_b_of_type_Anuv;
  
  @Deprecated
  public ProxyManager() {}
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    bkwm.a(paramQQAppInterface);
    bkwm.c(paramQQAppInterface);
    b();
  }
  
  /* Error */
  private boolean a(anus paramanus)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 88	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: ldc 90
    //   14: iconst_1
    //   15: invokestatic 95	bfzq:b	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   18: ifeq +54 -> 72
    //   21: getstatic 53	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_b_of_type_ArrayOfJavaLangClass	[Ljava/lang/Class;
    //   24: astore 6
    //   26: aload 6
    //   28: arraylength
    //   29: istore_3
    //   30: iconst_0
    //   31: istore_2
    //   32: iload_2
    //   33: iload_3
    //   34: if_icmpge +84 -> 118
    //   37: aload 6
    //   39: iload_2
    //   40: aaload
    //   41: astore 7
    //   43: aload_1
    //   44: invokevirtual 101	java/lang/Object:getClass	()Ljava/lang/Class;
    //   47: astore 8
    //   49: aload 8
    //   51: aload 7
    //   53: if_acmpne +12 -> 65
    //   56: iload 5
    //   58: istore 4
    //   60: aload_0
    //   61: monitorexit
    //   62: iload 4
    //   64: ireturn
    //   65: iload_2
    //   66: iconst_1
    //   67: iadd
    //   68: istore_2
    //   69: goto -37 -> 32
    //   72: getstatic 37	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ArrayOfJavaLangClass	[Ljava/lang/Class;
    //   75: astore 6
    //   77: aload 6
    //   79: arraylength
    //   80: istore_3
    //   81: iconst_0
    //   82: istore_2
    //   83: iload_2
    //   84: iload_3
    //   85: if_icmpge +33 -> 118
    //   88: aload 6
    //   90: iload_2
    //   91: aaload
    //   92: astore 7
    //   94: aload_1
    //   95: invokevirtual 101	java/lang/Object:getClass	()Ljava/lang/Class;
    //   98: astore 8
    //   100: iload 5
    //   102: istore 4
    //   104: aload 8
    //   106: aload 7
    //   108: if_acmpeq -48 -> 60
    //   111: iload_2
    //   112: iconst_1
    //   113: iadd
    //   114: istore_2
    //   115: goto -32 -> 83
    //   118: iconst_0
    //   119: istore 4
    //   121: goto -61 -> 60
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	ProxyManager
    //   0	129	1	paramanus	anus
    //   31	84	2	i	int
    //   29	57	3	j	int
    //   58	62	4	bool1	boolean
    //   1	100	5	bool2	boolean
    //   24	65	6	arrayOfClass	Class[]
    //   41	66	7	localClass1	Class
    //   47	58	8	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   5	30	124	finally
    //   43	49	124	finally
    //   72	81	124	finally
    //   94	100	124	finally
  }
  
  private void b()
  {
    this.jdField_a_of_type_Abwy = new abwy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, new abww());
    this.jdField_a_of_type_Anlo = new anlo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_b_of_type_Anuv = new anuu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Anuv = new anut(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Anuy = new anuy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Asln = new asln(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Beeh = new beeh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Atgm = new atgm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bcei = new bcei(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bknj = new bknj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Abwq = new abwq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Azjg = new azjg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Apsj = new apsj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Avug = new avug(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Aplh = new aplh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Atyl = new atyl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, new abww());
    this.jdField_a_of_type_ArrayOfAnus = new anus[] { this.jdField_a_of_type_Abwy, this.jdField_b_of_type_Anuv, this.jdField_a_of_type_Anuv, this.jdField_a_of_type_Asln, this.jdField_a_of_type_Bcei, this.jdField_a_of_type_Bknj, this.jdField_a_of_type_Atgm, this.jdField_a_of_type_Abwq, this.jdField_a_of_type_Azjg, this.jdField_a_of_type_Apsj, this.jdField_a_of_type_Beeh, this.jdField_a_of_type_Avug, this.jdField_a_of_type_Aplh, this.jdField_a_of_type_Atyl };
  }
  
  public abwq a()
  {
    return this.jdField_a_of_type_Abwq;
  }
  
  public abwy a()
  {
    return this.jdField_a_of_type_Abwy;
  }
  
  public anlo a()
  {
    return this.jdField_a_of_type_Anlo;
  }
  
  public anuv a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Anuv.a();
      return this.jdField_b_of_type_Anuv;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Anuv.a();
      return this.jdField_a_of_type_Anuv;
    }
    this.jdField_b_of_type_Anuv.a();
    return this.jdField_b_of_type_Anuv;
  }
  
  public anuy a()
  {
    return this.jdField_a_of_type_Anuy;
  }
  
  @Deprecated
  public anuz a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy();
  }
  
  public aplh a()
  {
    return this.jdField_a_of_type_Aplh;
  }
  
  public apsj a()
  {
    return this.jdField_a_of_type_Apsj;
  }
  
  public asln a()
  {
    return this.jdField_a_of_type_Asln;
  }
  
  public atgm a()
  {
    return this.jdField_a_of_type_Atgm;
  }
  
  public atyl a()
  {
    return this.jdField_a_of_type_Atyl;
  }
  
  public avug a()
  {
    return this.jdField_a_of_type_Avug;
  }
  
  public azjg a()
  {
    return this.jdField_a_of_type_Azjg;
  }
  
  public beeh a()
  {
    return this.jdField_a_of_type_Beeh;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (!this.isDestroyed)
        {
          boolean bool = this.jdField_a_of_type_JavaUtilSet.isEmpty();
          if (!bool) {}
        }
        else
        {
          return;
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        if (localIterator.hasNext())
        {
          anus localanus = (anus)localIterator.next();
          bjun.a("i." + localanus);
          long l = System.currentTimeMillis();
          localanus.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localanus.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
          }
          bjun.a();
        }
        else
        {
          this.jdField_a_of_type_JavaUtilSet.clear();
        }
      }
      finally {}
    }
  }
  
  public void doAddMsgQueue(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    if (QLog.isColorLevel())
    {
      MsgQueueItem localMsgQueueItem = new MsgQueueItem(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
      if ((localMsgQueueItem.item instanceof MessageRecord)) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueueDonotNotify QueueItem.action: " + localMsgQueueItem.action + ",mr=" + localMsgQueueItem.item);
      }
    }
    super.doAddMsgQueue(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
  }
  
  protected void doAfterTransSaveToDatabase()
  {
    super.doAfterTransSaveToDatabase();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e();
  }
  
  protected int getSaveInDBState()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a();
  }
  
  protected void init()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i < this.jdField_a_of_type_ArrayOfAnus.length) && (!this.isDestroyed)) {
          if (a(this.jdField_a_of_type_ArrayOfAnus[i]))
          {
            this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ArrayOfAnus[i]);
          }
          else
          {
            bjun.a("i." + this.jdField_a_of_type_ArrayOfAnus[i]);
            long l = System.currentTimeMillis();
            this.jdField_a_of_type_ArrayOfAnus[i].a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + this.jdField_a_of_type_ArrayOfAnus[i].getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
            }
            bjun.a();
          }
        }
      }
      finally {}
      return;
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    int j = 0;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().onDestroy();
      this.isDestroyed = true;
      ThreadManager.post(new ProxyManager.1(this), 8, null, false);
      int i = j;
      if (this.msgQueue != null) {}
      synchronized (this.msgQueueLock)
      {
        if (this.msgQueue != null) {
          this.msgQueueLock.notify();
        }
        i = j;
        if (i < this.jdField_a_of_type_ArrayOfAnus.length)
        {
          this.jdField_a_of_type_ArrayOfAnus[i].b();
          i += 1;
        }
      }
    }
    finally {}
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
          if ((abwz.a(localMsgQueueItem.frindUin, paramString, localMsgQueueItem.type, paramInt)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || (localMsgQueueItem.action == 0))) {
            localArrayList.add(localMsgQueueItem);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "transSaveToDatabase writeRunnable msgQueue size:", Integer.valueOf(this.msgQueue.size()), " item size:", Integer.valueOf(localArrayList.size()) });
    }
    this.msgQueue.remove(localArrayList);
    transSaveToDatabaseIndeed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).createEntityManager(), localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e();
  }
  
  /* Error */
  protected void transSaveToDatabaseIndeed(com.tencent.mobileqq.persistence.EntityManager paramEntityManager, List<MsgQueueItem> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 252
    //   6: iconst_1
    //   7: ldc_w 424
    //   10: invokestatic 426	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_2
    //   15: invokeinterface 427 1 0
    //   20: ifne -7 -> 13
    //   23: aload_0
    //   24: getfield 65	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_Boolean	Z
    //   27: ifeq +59 -> 86
    //   30: getstatic 428	anux:jdField_a_of_type_Boolean	Z
    //   33: ifeq +466 -> 499
    //   36: aload_0
    //   37: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   40: invokestatic 433	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   43: ifeq +456 -> 499
    //   46: aload_0
    //   47: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getFTSDBManager	()Lanux;
    //   53: invokevirtual 435	anux:a	()Z
    //   56: ifeq +30 -> 86
    //   59: aload_0
    //   60: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getFTSDBManager	()Lanux;
    //   66: invokevirtual 438	anux:a	()Lanvc;
    //   69: astore 17
    //   71: aload 17
    //   73: ifnull +8 -> 81
    //   76: aload 17
    //   78: invokevirtual 441	anvc:b	()V
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 65	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_Boolean	Z
    //   86: aconst_null
    //   87: astore 17
    //   89: invokestatic 446	com/tencent/mobileqq/statistics/StatisticCollector:SQLite3OptimizeReport	()Z
    //   92: istore 10
    //   94: iload 10
    //   96: ifeq +411 -> 507
    //   99: iconst_0
    //   100: invokestatic 450	com/tencent/mobileqq/statistics/StatisticCollector:getSqliteSwitchBySample	(I)Z
    //   103: ifeq +404 -> 507
    //   106: iconst_1
    //   107: istore 7
    //   109: invokestatic 456	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   112: astore 18
    //   114: invokestatic 459	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   117: astore 19
    //   119: aload 18
    //   121: aload 19
    //   123: if_acmpne +390 -> 513
    //   126: iconst_1
    //   127: istore 9
    //   129: iload 9
    //   131: ifeq +36 -> 167
    //   134: invokestatic 250	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +30 -> 167
    //   140: ldc 252
    //   142: iconst_2
    //   143: new 219	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 461
    //   153: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: iload 9
    //   158: invokevirtual 464	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_1
    //   168: invokevirtual 470	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   171: astore 18
    //   173: aload 18
    //   175: astore 17
    //   177: invokestatic 473	java/lang/System:nanoTime	()J
    //   180: lstore 13
    //   182: aload 17
    //   184: invokevirtual 478	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   187: iload 7
    //   189: ifeq +2083 -> 2272
    //   192: invokestatic 473	java/lang/System:nanoTime	()J
    //   195: lload 13
    //   197: lsub
    //   198: ldc2_w 479
    //   201: ldiv
    //   202: lstore 11
    //   204: new 482	java/util/HashMap
    //   207: dup
    //   208: invokespecial 483	java/util/HashMap:<init>	()V
    //   211: astore 19
    //   213: iload 9
    //   215: ifeq +304 -> 519
    //   218: ldc_w 485
    //   221: astore 18
    //   223: aload 19
    //   225: ldc_w 487
    //   228: aload 18
    //   230: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: pop
    //   234: aload 19
    //   236: ldc_w 493
    //   239: ldc_w 495
    //   242: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: aload 19
    //   248: ldc_w 497
    //   251: lload 11
    //   253: invokestatic 502	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   256: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: aload 19
    //   262: ldc_w 504
    //   265: getstatic 509	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   268: invokestatic 512	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   271: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   274: pop
    //   275: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   278: invokestatic 521	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   281: aconst_null
    //   282: ldc_w 523
    //   285: iconst_1
    //   286: ldc2_w 524
    //   289: lconst_0
    //   290: aload 19
    //   292: aconst_null
    //   293: iconst_0
    //   294: invokevirtual 529	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   297: aload_2
    //   298: invokeinterface 530 1 0
    //   303: astore 18
    //   305: iconst_0
    //   306: istore_3
    //   307: iconst_0
    //   308: istore 4
    //   310: aload 18
    //   312: invokeinterface 213 1 0
    //   317: ifeq +1173 -> 1490
    //   320: aload 18
    //   322: invokeinterface 217 1 0
    //   327: checkcast 274	com/tencent/mobileqq/app/proxy/MsgQueueItem
    //   330: astore 19
    //   332: iload 4
    //   334: iconst_1
    //   335: iadd
    //   336: istore 4
    //   338: iload_3
    //   339: istore 6
    //   341: iload_3
    //   342: istore 5
    //   344: aload 19
    //   346: getfield 533	com/tencent/mobileqq/app/proxy/MsgQueueItem:tableName	Ljava/lang/String;
    //   349: astore 20
    //   351: iload_3
    //   352: istore 6
    //   354: iload_3
    //   355: istore 5
    //   357: aload 19
    //   359: getfield 537	com/tencent/mobileqq/app/proxy/MsgQueueItem:listener	Lcom/tencent/mobileqq/app/proxy/ProxyListener;
    //   362: astore 21
    //   364: iload_3
    //   365: istore 6
    //   367: iload_3
    //   368: istore 5
    //   370: invokestatic 250	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +1907 -> 2280
    //   376: iload_3
    //   377: istore 6
    //   379: iload_3
    //   380: istore 5
    //   382: aload 19
    //   384: getfield 280	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   387: instanceof 282
    //   390: ifeq +137 -> 527
    //   393: iload_3
    //   394: iconst_1
    //   395: iadd
    //   396: istore_3
    //   397: iload_3
    //   398: istore 6
    //   400: iload_3
    //   401: istore 5
    //   403: ldc 252
    //   405: iconst_2
    //   406: iconst_4
    //   407: anewarray 97	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: ldc_w 539
    //   415: aastore
    //   416: dup
    //   417: iconst_1
    //   418: aload 19
    //   420: getfield 288	com/tencent/mobileqq/app/proxy/MsgQueueItem:action	I
    //   423: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: aastore
    //   427: dup
    //   428: iconst_2
    //   429: ldc_w 541
    //   432: aastore
    //   433: dup
    //   434: iconst_3
    //   435: aload 19
    //   437: getfield 280	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   440: aastore
    //   441: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   444: aload 19
    //   446: getfield 288	com/tencent/mobileqq/app/proxy/MsgQueueItem:action	I
    //   449: istore 5
    //   451: iload 5
    //   453: tableswitch	default:+43 -> 496, 0:+220->673, 1:+493->946, 2:+754->1207, 3:+467->920, 4:+726->1179, 5:+969->1422, 6:+997->1450
    //   497: impdep2
    //   498: fstore_3
    //   499: aload_0
    //   500: iconst_0
    //   501: putfield 65	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_Boolean	Z
    //   504: goto -418 -> 86
    //   507: iconst_0
    //   508: istore 7
    //   510: goto -401 -> 109
    //   513: iconst_0
    //   514: istore 9
    //   516: goto -387 -> 129
    //   519: ldc_w 543
    //   522: astore 18
    //   524: goto -301 -> 223
    //   527: iload_3
    //   528: istore 6
    //   530: iload_3
    //   531: istore 5
    //   533: aload 19
    //   535: getfield 288	com/tencent/mobileqq/app/proxy/MsgQueueItem:action	I
    //   538: istore 8
    //   540: iload_3
    //   541: istore 6
    //   543: iload_3
    //   544: istore 5
    //   546: aload 19
    //   548: getfield 372	com/tencent/mobileqq/app/proxy/MsgQueueItem:frindUin	Ljava/lang/String;
    //   551: astore 22
    //   553: iload_3
    //   554: istore 6
    //   556: iload_3
    //   557: istore 5
    //   559: aload 19
    //   561: getfield 533	com/tencent/mobileqq/app/proxy/MsgQueueItem:tableName	Ljava/lang/String;
    //   564: astore 23
    //   566: iload_3
    //   567: istore 6
    //   569: iload_3
    //   570: istore 5
    //   572: aload 19
    //   574: getfield 547	com/tencent/mobileqq/app/proxy/MsgQueueItem:value	Landroid/content/ContentValues;
    //   577: ifnull +89 -> 666
    //   580: iload_3
    //   581: istore 6
    //   583: iload_3
    //   584: istore 5
    //   586: aload 19
    //   588: getfield 547	com/tencent/mobileqq/app/proxy/MsgQueueItem:value	Landroid/content/ContentValues;
    //   591: invokevirtual 552	android/content/ContentValues:hashCode	()I
    //   594: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   597: astore_2
    //   598: iload_3
    //   599: istore 6
    //   601: iload_3
    //   602: istore 5
    //   604: ldc 252
    //   606: iconst_2
    //   607: bipush 8
    //   609: anewarray 97	java/lang/Object
    //   612: dup
    //   613: iconst_0
    //   614: ldc_w 539
    //   617: aastore
    //   618: dup
    //   619: iconst_1
    //   620: iload 8
    //   622: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   625: aastore
    //   626: dup
    //   627: iconst_2
    //   628: ldc_w 554
    //   631: aastore
    //   632: dup
    //   633: iconst_3
    //   634: aload 22
    //   636: aastore
    //   637: dup
    //   638: iconst_4
    //   639: ldc_w 556
    //   642: aastore
    //   643: dup
    //   644: iconst_5
    //   645: aload 23
    //   647: aastore
    //   648: dup
    //   649: bipush 6
    //   651: ldc_w 558
    //   654: aastore
    //   655: dup
    //   656: bipush 7
    //   658: aload_2
    //   659: aastore
    //   660: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   663: goto +1617 -> 2280
    //   666: ldc_w 560
    //   669: astore_2
    //   670: goto -72 -> 598
    //   673: invokestatic 473	java/lang/System:nanoTime	()J
    //   676: lstore 11
    //   678: getstatic 428	anux:jdField_a_of_type_Boolean	Z
    //   681: ifeq +41 -> 722
    //   684: aload_0
    //   685: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   688: invokestatic 433	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   691: ifeq +31 -> 722
    //   694: aload_0
    //   695: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   698: invokestatic 562	bgbo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   701: ifeq +21 -> 722
    //   704: aload_0
    //   705: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   708: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getFTSDBManager	()Lanux;
    //   711: invokevirtual 438	anux:a	()Lanvc;
    //   714: aload 19
    //   716: getfield 280	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   719: invokevirtual 565	anvc:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   722: aload_1
    //   723: aload 19
    //   725: getfield 280	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   728: invokevirtual 568	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   731: invokestatic 473	java/lang/System:nanoTime	()J
    //   734: lload 11
    //   736: lsub
    //   737: ldc2_w 479
    //   740: ldiv
    //   741: lstore 15
    //   743: aload 21
    //   745: ifnull +12 -> 757
    //   748: aload 21
    //   750: aload 20
    //   752: invokeinterface 573 2 0
    //   757: getstatic 428	anux:jdField_a_of_type_Boolean	Z
    //   760: ifeq +42 -> 802
    //   763: aload_0
    //   764: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   767: invokestatic 433	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   770: ifeq +32 -> 802
    //   773: aload_0
    //   774: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   777: invokestatic 562	bgbo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   780: ifeq +22 -> 802
    //   783: aload_0
    //   784: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   787: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getFTSDBManager	()Lanux;
    //   790: invokevirtual 438	anux:a	()Lanvc;
    //   793: aload 19
    //   795: getfield 280	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   798: aload_1
    //   799: invokevirtual 576	anvc:a	(Lcom/tencent/mobileqq/persistence/Entity;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   802: lload 15
    //   804: lstore 11
    //   806: iload 10
    //   808: ifeq +1454 -> 2262
    //   811: lload 15
    //   813: lstore 11
    //   815: iconst_4
    //   816: invokestatic 450	com/tencent/mobileqq/statistics/StatisticCollector:getSqliteSwitchBySample	(I)Z
    //   819: ifeq +1443 -> 2262
    //   822: new 482	java/util/HashMap
    //   825: dup
    //   826: invokespecial 483	java/util/HashMap:<init>	()V
    //   829: astore 19
    //   831: iload 9
    //   833: ifeq +1450 -> 2283
    //   836: ldc_w 485
    //   839: astore_2
    //   840: aload 19
    //   842: ldc_w 487
    //   845: aload_2
    //   846: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   849: pop
    //   850: aload 19
    //   852: ldc_w 493
    //   855: ldc_w 578
    //   858: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   861: pop
    //   862: aload 19
    //   864: ldc_w 497
    //   867: lload 15
    //   869: invokestatic 502	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   872: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   875: pop
    //   876: aload 19
    //   878: ldc_w 504
    //   881: getstatic 509	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   884: invokestatic 512	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   887: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   890: pop
    //   891: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   894: invokestatic 521	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   897: aconst_null
    //   898: ldc_w 523
    //   901: iconst_1
    //   902: ldc2_w 524
    //   905: lconst_0
    //   906: aload 19
    //   908: aconst_null
    //   909: iconst_0
    //   910: invokevirtual 529	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   913: lload 15
    //   915: lstore 11
    //   917: goto -421 -> 496
    //   920: aload_1
    //   921: aload 19
    //   923: getfield 280	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   926: invokevirtual 568	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   929: aload 21
    //   931: ifnull -435 -> 496
    //   934: aload 21
    //   936: aload 20
    //   938: invokeinterface 573 2 0
    //   943: goto -447 -> 496
    //   946: getstatic 428	anux:jdField_a_of_type_Boolean	Z
    //   949: ifeq +39 -> 988
    //   952: aload_0
    //   953: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   956: invokestatic 433	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   959: ifeq +29 -> 988
    //   962: aload_0
    //   963: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   966: invokestatic 562	bgbo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   969: ifeq +19 -> 988
    //   972: aload_0
    //   973: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   976: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getFTSDBManager	()Lanux;
    //   979: invokevirtual 438	anux:a	()Lanvc;
    //   982: aload 19
    //   984: aload_1
    //   985: invokevirtual 581	anvc:a	(Lcom/tencent/mobileqq/app/proxy/MsgQueueItem;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   988: invokestatic 473	java/lang/System:nanoTime	()J
    //   991: lstore 15
    //   993: aload_0
    //   994: invokevirtual 585	com/tencent/mobileqq/app/proxy/ProxyManager:getDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   997: astore_2
    //   998: aload_2
    //   999: ifnull +1266 -> 2265
    //   1002: aload_2
    //   1003: aload 20
    //   1005: aload 19
    //   1007: getfield 547	com/tencent/mobileqq/app/proxy/MsgQueueItem:value	Landroid/content/ContentValues;
    //   1010: aload 19
    //   1012: getfield 588	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereClause	Ljava/lang/String;
    //   1015: aload 19
    //   1017: getfield 592	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereArgs	[Ljava/lang/String;
    //   1020: invokevirtual 598	com/tencent/mobileqq/app/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1023: istore 5
    //   1025: invokestatic 473	java/lang/System:nanoTime	()J
    //   1028: lload 15
    //   1030: lsub
    //   1031: ldc2_w 479
    //   1034: ldiv
    //   1035: lstore 11
    //   1037: lload 11
    //   1039: lstore 15
    //   1041: aload 21
    //   1043: ifnull +18 -> 1061
    //   1046: aload 21
    //   1048: aload 20
    //   1050: iload 5
    //   1052: invokeinterface 601 3 0
    //   1057: lload 11
    //   1059: lstore 15
    //   1061: lload 15
    //   1063: lstore 11
    //   1065: iload 10
    //   1067: ifeq +1195 -> 2262
    //   1070: lload 15
    //   1072: lstore 11
    //   1074: iconst_5
    //   1075: invokestatic 450	com/tencent/mobileqq/statistics/StatisticCollector:getSqliteSwitchBySample	(I)Z
    //   1078: ifeq +1184 -> 2262
    //   1081: new 482	java/util/HashMap
    //   1084: dup
    //   1085: invokespecial 483	java/util/HashMap:<init>	()V
    //   1088: astore 19
    //   1090: iload 9
    //   1092: ifeq +1198 -> 2290
    //   1095: ldc_w 485
    //   1098: astore_2
    //   1099: aload 19
    //   1101: ldc_w 487
    //   1104: aload_2
    //   1105: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1108: pop
    //   1109: aload 19
    //   1111: ldc_w 493
    //   1114: ldc_w 602
    //   1117: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1120: pop
    //   1121: aload 19
    //   1123: ldc_w 497
    //   1126: lload 15
    //   1128: invokestatic 502	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1131: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1134: pop
    //   1135: aload 19
    //   1137: ldc_w 504
    //   1140: getstatic 509	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   1143: invokestatic 512	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1146: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1149: pop
    //   1150: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1153: invokestatic 521	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1156: aconst_null
    //   1157: ldc_w 523
    //   1160: iconst_1
    //   1161: ldc2_w 524
    //   1164: lconst_0
    //   1165: aload 19
    //   1167: aconst_null
    //   1168: iconst_0
    //   1169: invokevirtual 529	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1172: lload 15
    //   1174: lstore 11
    //   1176: goto -680 -> 496
    //   1179: aload_1
    //   1180: aload 19
    //   1182: getfield 280	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   1185: invokevirtual 605	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1188: pop
    //   1189: aload 21
    //   1191: ifnull -695 -> 496
    //   1194: aload 21
    //   1196: aload 20
    //   1198: iconst_1
    //   1199: invokeinterface 601 3 0
    //   1204: goto -708 -> 496
    //   1207: getstatic 428	anux:jdField_a_of_type_Boolean	Z
    //   1210: ifeq +39 -> 1249
    //   1213: aload_0
    //   1214: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1217: invokestatic 433	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1220: ifeq +29 -> 1249
    //   1223: aload_0
    //   1224: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1227: invokestatic 562	bgbo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1230: ifeq +19 -> 1249
    //   1233: aload_0
    //   1234: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1237: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getFTSDBManager	()Lanux;
    //   1240: invokevirtual 438	anux:a	()Lanvc;
    //   1243: aload 19
    //   1245: aload_1
    //   1246: invokevirtual 607	anvc:b	(Lcom/tencent/mobileqq/app/proxy/MsgQueueItem;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1249: invokestatic 473	java/lang/System:nanoTime	()J
    //   1252: lstore 11
    //   1254: aload_0
    //   1255: invokevirtual 585	com/tencent/mobileqq/app/proxy/ProxyManager:getDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1258: aload 20
    //   1260: aload 19
    //   1262: getfield 588	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereClause	Ljava/lang/String;
    //   1265: aload 19
    //   1267: getfield 592	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereArgs	[Ljava/lang/String;
    //   1270: invokevirtual 611	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1273: istore 5
    //   1275: invokestatic 473	java/lang/System:nanoTime	()J
    //   1278: lload 11
    //   1280: lsub
    //   1281: ldc2_w 479
    //   1284: ldiv
    //   1285: lstore 15
    //   1287: aload 21
    //   1289: ifnull +14 -> 1303
    //   1292: aload 21
    //   1294: aload 20
    //   1296: iload 5
    //   1298: invokeinterface 614 3 0
    //   1303: lload 15
    //   1305: lstore 11
    //   1307: iload 10
    //   1309: ifeq +953 -> 2262
    //   1312: lload 15
    //   1314: lstore 11
    //   1316: bipush 6
    //   1318: invokestatic 450	com/tencent/mobileqq/statistics/StatisticCollector:getSqliteSwitchBySample	(I)Z
    //   1321: ifeq +941 -> 2262
    //   1324: new 482	java/util/HashMap
    //   1327: dup
    //   1328: invokespecial 483	java/util/HashMap:<init>	()V
    //   1331: astore 19
    //   1333: iload 9
    //   1335: ifeq +962 -> 2297
    //   1338: ldc_w 485
    //   1341: astore_2
    //   1342: aload 19
    //   1344: ldc_w 487
    //   1347: aload_2
    //   1348: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1351: pop
    //   1352: aload 19
    //   1354: ldc_w 493
    //   1357: ldc_w 615
    //   1360: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1363: pop
    //   1364: aload 19
    //   1366: ldc_w 497
    //   1369: lload 15
    //   1371: invokestatic 502	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1374: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1377: pop
    //   1378: aload 19
    //   1380: ldc_w 504
    //   1383: getstatic 509	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   1386: invokestatic 512	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1389: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1392: pop
    //   1393: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1396: invokestatic 521	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1399: aconst_null
    //   1400: ldc_w 523
    //   1403: iconst_1
    //   1404: ldc2_w 524
    //   1407: lconst_0
    //   1408: aload 19
    //   1410: aconst_null
    //   1411: iconst_0
    //   1412: invokevirtual 529	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1415: lload 15
    //   1417: lstore 11
    //   1419: goto -923 -> 496
    //   1422: aload_1
    //   1423: aload 19
    //   1425: getfield 280	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   1428: invokevirtual 617	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1431: pop
    //   1432: aload 21
    //   1434: ifnull -938 -> 496
    //   1437: aload 21
    //   1439: aload 20
    //   1441: iconst_1
    //   1442: invokeinterface 614 3 0
    //   1447: goto -951 -> 496
    //   1450: aload_0
    //   1451: invokevirtual 585	com/tencent/mobileqq/app/proxy/ProxyManager:getDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1454: aload 20
    //   1456: aload 19
    //   1458: getfield 588	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereClause	Ljava/lang/String;
    //   1461: aload 19
    //   1463: getfield 592	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereArgs	[Ljava/lang/String;
    //   1466: invokevirtual 611	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1469: istore 5
    //   1471: aload 21
    //   1473: ifnull +14 -> 1487
    //   1476: aload 21
    //   1478: aload 20
    //   1480: iload 5
    //   1482: invokeinterface 614 3 0
    //   1487: goto -991 -> 496
    //   1490: aload 17
    //   1492: invokevirtual 620	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1495: aload_0
    //   1496: sipush 1000
    //   1499: invokevirtual 624	com/tencent/mobileqq/app/proxy/ProxyManager:notifyEvent	(I)V
    //   1502: aload 17
    //   1504: ifnull -1491 -> 13
    //   1507: aload 17
    //   1509: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1512: invokestatic 473	java/lang/System:nanoTime	()J
    //   1515: lload 13
    //   1517: lsub
    //   1518: ldc2_w 479
    //   1521: ldiv
    //   1522: lstore 11
    //   1524: iload 7
    //   1526: ifeq -1513 -> 13
    //   1529: new 482	java/util/HashMap
    //   1532: dup
    //   1533: invokespecial 483	java/util/HashMap:<init>	()V
    //   1536: astore_2
    //   1537: iload 9
    //   1539: ifeq +129 -> 1668
    //   1542: ldc_w 485
    //   1545: astore_1
    //   1546: aload_2
    //   1547: ldc_w 487
    //   1550: aload_1
    //   1551: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1554: pop
    //   1555: aload_2
    //   1556: ldc_w 493
    //   1559: ldc_w 629
    //   1562: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1565: pop
    //   1566: aload_2
    //   1567: ldc_w 497
    //   1570: lload 11
    //   1572: invokestatic 502	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1575: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1578: pop
    //   1579: aload_2
    //   1580: ldc_w 631
    //   1583: iload 4
    //   1585: invokestatic 634	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1588: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1591: pop
    //   1592: aload_2
    //   1593: ldc_w 636
    //   1596: iload_3
    //   1597: invokestatic 634	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1600: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1603: pop
    //   1604: aload_2
    //   1605: ldc_w 638
    //   1608: lload 11
    //   1610: l2f
    //   1611: iload 4
    //   1613: i2f
    //   1614: fdiv
    //   1615: invokestatic 641	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1618: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1621: pop
    //   1622: aload_2
    //   1623: ldc_w 643
    //   1626: ldc_w 629
    //   1629: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1632: pop
    //   1633: aload_2
    //   1634: ldc_w 504
    //   1637: getstatic 509	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   1640: invokestatic 512	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1643: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1646: pop
    //   1647: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1650: invokestatic 521	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1653: aconst_null
    //   1654: ldc_w 645
    //   1657: iconst_1
    //   1658: lload 11
    //   1660: lconst_0
    //   1661: aload_2
    //   1662: aconst_null
    //   1663: iconst_0
    //   1664: invokevirtual 529	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1667: return
    //   1668: ldc_w 543
    //   1671: astore_1
    //   1672: goto -126 -> 1546
    //   1675: astore_1
    //   1676: ldc2_w 524
    //   1679: lstore 11
    //   1681: iconst_0
    //   1682: istore 4
    //   1684: iconst_0
    //   1685: istore 9
    //   1687: iconst_0
    //   1688: istore_3
    //   1689: aload 17
    //   1691: astore_2
    //   1692: aload_1
    //   1693: invokevirtual 648	java/lang/Exception:printStackTrace	()V
    //   1696: aload_0
    //   1697: sipush 1001
    //   1700: invokevirtual 624	com/tencent/mobileqq/app/proxy/ProxyManager:notifyEvent	(I)V
    //   1703: invokestatic 250	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1706: ifeq +32 -> 1738
    //   1709: ldc 252
    //   1711: iconst_2
    //   1712: new 219	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1719: ldc_w 650
    //   1722: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: aload_1
    //   1726: invokevirtual 653	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1729: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1735: invokestatic 656	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1738: aload_2
    //   1739: ifnull -1726 -> 13
    //   1742: aload_2
    //   1743: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1746: invokestatic 473	java/lang/System:nanoTime	()J
    //   1749: lload 11
    //   1751: lsub
    //   1752: ldc2_w 479
    //   1755: ldiv
    //   1756: lstore 11
    //   1758: iload 7
    //   1760: ifeq -1747 -> 13
    //   1763: new 482	java/util/HashMap
    //   1766: dup
    //   1767: invokespecial 483	java/util/HashMap:<init>	()V
    //   1770: astore_2
    //   1771: iload 9
    //   1773: ifeq +129 -> 1902
    //   1776: ldc_w 485
    //   1779: astore_1
    //   1780: aload_2
    //   1781: ldc_w 487
    //   1784: aload_1
    //   1785: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1788: pop
    //   1789: aload_2
    //   1790: ldc_w 493
    //   1793: ldc_w 629
    //   1796: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1799: pop
    //   1800: aload_2
    //   1801: ldc_w 497
    //   1804: lload 11
    //   1806: invokestatic 502	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1809: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1812: pop
    //   1813: aload_2
    //   1814: ldc_w 631
    //   1817: iload 4
    //   1819: invokestatic 634	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1822: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1825: pop
    //   1826: aload_2
    //   1827: ldc_w 636
    //   1830: iload_3
    //   1831: invokestatic 634	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1834: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1837: pop
    //   1838: aload_2
    //   1839: ldc_w 638
    //   1842: lload 11
    //   1844: l2f
    //   1845: iload 4
    //   1847: i2f
    //   1848: fdiv
    //   1849: invokestatic 641	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1852: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1855: pop
    //   1856: aload_2
    //   1857: ldc_w 643
    //   1860: ldc_w 629
    //   1863: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1866: pop
    //   1867: aload_2
    //   1868: ldc_w 504
    //   1871: getstatic 509	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   1874: invokestatic 512	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1877: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1880: pop
    //   1881: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1884: invokestatic 521	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1887: aconst_null
    //   1888: ldc_w 645
    //   1891: iconst_1
    //   1892: lload 11
    //   1894: lconst_0
    //   1895: aload_2
    //   1896: aconst_null
    //   1897: iconst_0
    //   1898: invokevirtual 529	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1901: return
    //   1902: ldc_w 543
    //   1905: astore_1
    //   1906: goto -126 -> 1780
    //   1909: astore_1
    //   1910: iconst_0
    //   1911: istore_3
    //   1912: iconst_0
    //   1913: istore 4
    //   1915: ldc2_w 524
    //   1918: lstore 13
    //   1920: iconst_0
    //   1921: istore 9
    //   1923: aconst_null
    //   1924: astore 17
    //   1926: aload 17
    //   1928: ifnull +173 -> 2101
    //   1931: aload 17
    //   1933: invokevirtual 627	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1936: invokestatic 473	java/lang/System:nanoTime	()J
    //   1939: lload 13
    //   1941: lsub
    //   1942: ldc2_w 479
    //   1945: ldiv
    //   1946: lstore 11
    //   1948: iload 7
    //   1950: ifeq +151 -> 2101
    //   1953: new 482	java/util/HashMap
    //   1956: dup
    //   1957: invokespecial 483	java/util/HashMap:<init>	()V
    //   1960: astore 17
    //   1962: iload 9
    //   1964: ifeq +139 -> 2103
    //   1967: ldc_w 485
    //   1970: astore_2
    //   1971: aload 17
    //   1973: ldc_w 487
    //   1976: aload_2
    //   1977: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1980: pop
    //   1981: aload 17
    //   1983: ldc_w 493
    //   1986: ldc_w 629
    //   1989: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1992: pop
    //   1993: aload 17
    //   1995: ldc_w 497
    //   1998: lload 11
    //   2000: invokestatic 502	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2003: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2006: pop
    //   2007: aload 17
    //   2009: ldc_w 631
    //   2012: iload 4
    //   2014: invokestatic 634	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2017: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2020: pop
    //   2021: aload 17
    //   2023: ldc_w 636
    //   2026: iload_3
    //   2027: invokestatic 634	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2030: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2033: pop
    //   2034: aload 17
    //   2036: ldc_w 638
    //   2039: lload 11
    //   2041: l2f
    //   2042: iload 4
    //   2044: i2f
    //   2045: fdiv
    //   2046: invokestatic 641	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   2049: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2052: pop
    //   2053: aload 17
    //   2055: ldc_w 643
    //   2058: ldc_w 629
    //   2061: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2064: pop
    //   2065: aload 17
    //   2067: ldc_w 504
    //   2070: getstatic 509	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   2073: invokestatic 512	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2076: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2079: pop
    //   2080: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2083: invokestatic 521	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2086: aconst_null
    //   2087: ldc_w 645
    //   2090: iconst_1
    //   2091: lload 11
    //   2093: lconst_0
    //   2094: aload 17
    //   2096: aconst_null
    //   2097: iconst_0
    //   2098: invokevirtual 529	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2101: aload_1
    //   2102: athrow
    //   2103: ldc_w 543
    //   2106: astore_2
    //   2107: goto -136 -> 1971
    //   2110: astore_1
    //   2111: iconst_0
    //   2112: istore_3
    //   2113: iconst_0
    //   2114: istore 4
    //   2116: ldc2_w 524
    //   2119: lstore 13
    //   2121: aconst_null
    //   2122: astore 17
    //   2124: goto -198 -> 1926
    //   2127: astore_1
    //   2128: iconst_0
    //   2129: istore_3
    //   2130: iconst_0
    //   2131: istore 4
    //   2133: ldc2_w 524
    //   2136: lstore 13
    //   2138: goto -212 -> 1926
    //   2141: astore_1
    //   2142: iconst_0
    //   2143: istore_3
    //   2144: iconst_0
    //   2145: istore 4
    //   2147: goto -221 -> 1926
    //   2150: astore_1
    //   2151: goto -225 -> 1926
    //   2154: astore_1
    //   2155: iload 6
    //   2157: istore_3
    //   2158: goto -232 -> 1926
    //   2161: astore_1
    //   2162: goto -236 -> 1926
    //   2165: astore_1
    //   2166: lload 11
    //   2168: lstore 13
    //   2170: aload_2
    //   2171: astore 17
    //   2173: goto -247 -> 1926
    //   2176: astore_1
    //   2177: iconst_0
    //   2178: istore_3
    //   2179: ldc2_w 524
    //   2182: lstore 11
    //   2184: iconst_0
    //   2185: istore 4
    //   2187: aload 17
    //   2189: astore_2
    //   2190: goto -498 -> 1692
    //   2193: astore_1
    //   2194: iconst_0
    //   2195: istore_3
    //   2196: ldc2_w 524
    //   2199: lstore 11
    //   2201: aload 17
    //   2203: astore_2
    //   2204: iconst_0
    //   2205: istore 4
    //   2207: goto -515 -> 1692
    //   2210: astore_1
    //   2211: iconst_0
    //   2212: istore_3
    //   2213: iconst_0
    //   2214: istore 4
    //   2216: lload 13
    //   2218: lstore 11
    //   2220: aload 17
    //   2222: astore_2
    //   2223: goto -531 -> 1692
    //   2226: astore_1
    //   2227: lload 13
    //   2229: lstore 11
    //   2231: aload 17
    //   2233: astore_2
    //   2234: goto -542 -> 1692
    //   2237: astore_1
    //   2238: lload 13
    //   2240: lstore 11
    //   2242: aload 17
    //   2244: astore_2
    //   2245: iload 5
    //   2247: istore_3
    //   2248: goto -556 -> 1692
    //   2251: astore_1
    //   2252: lload 13
    //   2254: lstore 11
    //   2256: aload 17
    //   2258: astore_2
    //   2259: goto -567 -> 1692
    //   2262: goto -1766 -> 496
    //   2265: lload 11
    //   2267: lstore 15
    //   2269: goto -1208 -> 1061
    //   2272: ldc2_w 524
    //   2275: lstore 11
    //   2277: goto -1980 -> 297
    //   2280: goto -1836 -> 444
    //   2283: ldc_w 543
    //   2286: astore_2
    //   2287: goto -1447 -> 840
    //   2290: ldc_w 543
    //   2293: astore_2
    //   2294: goto -1195 -> 1099
    //   2297: ldc_w 543
    //   2300: astore_2
    //   2301: goto -959 -> 1342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2304	0	this	ProxyManager
    //   0	2304	1	paramEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   0	2304	2	paramList	List<MsgQueueItem>
    //   306	1942	3	i	int
    //   308	1907	4	j	int
    //   342	1904	5	k	int
    //   339	1817	6	m	int
    //   107	1842	7	n	int
    //   538	83	8	i1	int
    //   127	1836	9	bool1	boolean
    //   92	1216	10	bool2	boolean
    //   202	2074	11	l1	long
    //   180	2073	13	l2	long
    //   741	1527	15	l3	long
    //   69	2188	17	localObject1	Object
    //   112	411	18	localObject2	Object
    //   117	1345	19	localObject3	Object
    //   349	1130	20	str1	String
    //   362	1115	21	localProxyListener	ProxyListener
    //   551	84	22	str2	String
    //   564	82	23	str3	String
    // Exception table:
    //   from	to	target	type
    //   109	119	1675	java/lang/Exception
    //   109	119	1909	finally
    //   134	167	2110	finally
    //   167	173	2110	finally
    //   177	182	2127	finally
    //   182	187	2141	finally
    //   192	213	2141	finally
    //   223	297	2141	finally
    //   297	305	2141	finally
    //   310	332	2150	finally
    //   1490	1502	2150	finally
    //   344	351	2154	finally
    //   357	364	2154	finally
    //   370	376	2154	finally
    //   382	393	2154	finally
    //   403	444	2154	finally
    //   533	540	2154	finally
    //   546	553	2154	finally
    //   559	566	2154	finally
    //   572	580	2154	finally
    //   586	598	2154	finally
    //   604	663	2154	finally
    //   444	451	2161	finally
    //   673	722	2161	finally
    //   722	743	2161	finally
    //   748	757	2161	finally
    //   757	802	2161	finally
    //   815	831	2161	finally
    //   840	913	2161	finally
    //   920	929	2161	finally
    //   934	943	2161	finally
    //   946	988	2161	finally
    //   988	998	2161	finally
    //   1002	1037	2161	finally
    //   1046	1057	2161	finally
    //   1074	1090	2161	finally
    //   1099	1172	2161	finally
    //   1179	1189	2161	finally
    //   1194	1204	2161	finally
    //   1207	1249	2161	finally
    //   1249	1287	2161	finally
    //   1292	1303	2161	finally
    //   1316	1333	2161	finally
    //   1342	1415	2161	finally
    //   1422	1432	2161	finally
    //   1437	1447	2161	finally
    //   1450	1471	2161	finally
    //   1476	1487	2161	finally
    //   1692	1738	2165	finally
    //   134	167	2176	java/lang/Exception
    //   167	173	2176	java/lang/Exception
    //   177	182	2193	java/lang/Exception
    //   182	187	2210	java/lang/Exception
    //   192	213	2210	java/lang/Exception
    //   223	297	2210	java/lang/Exception
    //   297	305	2210	java/lang/Exception
    //   310	332	2226	java/lang/Exception
    //   1490	1502	2226	java/lang/Exception
    //   344	351	2237	java/lang/Exception
    //   357	364	2237	java/lang/Exception
    //   370	376	2237	java/lang/Exception
    //   382	393	2237	java/lang/Exception
    //   403	444	2237	java/lang/Exception
    //   533	540	2237	java/lang/Exception
    //   546	553	2237	java/lang/Exception
    //   559	566	2237	java/lang/Exception
    //   572	580	2237	java/lang/Exception
    //   586	598	2237	java/lang/Exception
    //   604	663	2237	java/lang/Exception
    //   444	451	2251	java/lang/Exception
    //   673	722	2251	java/lang/Exception
    //   722	743	2251	java/lang/Exception
    //   748	757	2251	java/lang/Exception
    //   757	802	2251	java/lang/Exception
    //   815	831	2251	java/lang/Exception
    //   840	913	2251	java/lang/Exception
    //   920	929	2251	java/lang/Exception
    //   934	943	2251	java/lang/Exception
    //   946	988	2251	java/lang/Exception
    //   988	998	2251	java/lang/Exception
    //   1002	1037	2251	java/lang/Exception
    //   1046	1057	2251	java/lang/Exception
    //   1074	1090	2251	java/lang/Exception
    //   1099	1172	2251	java/lang/Exception
    //   1179	1189	2251	java/lang/Exception
    //   1194	1204	2251	java/lang/Exception
    //   1207	1249	2251	java/lang/Exception
    //   1249	1287	2251	java/lang/Exception
    //   1292	1303	2251	java/lang/Exception
    //   1316	1333	2251	java/lang/Exception
    //   1342	1415	2251	java/lang/Exception
    //   1422	1432	2251	java/lang/Exception
    //   1437	1447	2251	java/lang/Exception
    //   1450	1471	2251	java/lang/Exception
    //   1476	1487	2251	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyManager
 * JD-Core Version:    0.7.0.1
 */