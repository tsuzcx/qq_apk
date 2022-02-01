package com.tencent.mobileqq.app.proxy;

import acmx;
import acne;
import acng;
import acnh;
import aooh;
import aoxs;
import aoxt;
import aoxu;
import aoxv;
import aoxx;
import aoxy;
import aoxz;
import aoyc;
import aqol;
import aqvm;
import atpt;
import aukt;
import avea;
import axai;
import bapo;
import bcrg;
import bdld;
import bflk;
import bhkf;
import blfz;
import blyr;
import bmhv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class ProxyManager
  extends BaseProxyManager
{
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { bapo.class, aqvm.class };
  private static final Class[] jdField_b_of_type_ArrayOfJavaLangClass = { aoxt.class, aoxu.class, atpt.class, blyr.class, aooh.class, aqol.class, avea.class, bapo.class, aqvm.class };
  private acmx jdField_a_of_type_Acmx;
  private acng jdField_a_of_type_Acng;
  private aooh jdField_a_of_type_Aooh;
  private aoxv jdField_a_of_type_Aoxv;
  private aoxy jdField_a_of_type_Aoxy;
  private aqol jdField_a_of_type_Aqol;
  private aqvm jdField_a_of_type_Aqvm;
  private atpt jdField_a_of_type_Atpt;
  private aukt jdField_a_of_type_Aukt;
  private avea jdField_a_of_type_Avea;
  private axai jdField_a_of_type_Axai;
  private bapo jdField_a_of_type_Bapo;
  private bdld jdField_a_of_type_Bdld;
  private bflk jdField_a_of_type_Bflk;
  private blyr jdField_a_of_type_Blyr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Set<aoxs> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  private aoxs[] jdField_a_of_type_ArrayOfAoxs;
  private aoxv jdField_b_of_type_Aoxv;
  
  @Deprecated
  public ProxyManager() {}
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    bmhv.a(paramQQAppInterface);
    bmhv.c(paramQQAppInterface);
    b();
  }
  
  private long a(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
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
            return b(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramMsgQueueItem, paramString, paramProxyListener);
            paramEntityManager.persistOrReplace(paramMsgQueueItem.item);
          } while (paramProxyListener == null);
          paramProxyListener.onInsertFinish(paramString);
          return paramLong2;
          return b(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramLong2, paramMsgQueueItem, paramString, paramProxyListener);
          paramEntityManager.update(paramMsgQueueItem.item);
        } while (paramProxyListener == null);
        paramProxyListener.onUpdateFinish(paramString, 1);
        return paramLong2;
        return a(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramMsgQueueItem, paramString, paramProxyListener);
        paramEntityManager.remove(paramMsgQueueItem.item);
      } while (paramProxyListener == null);
      paramProxyListener.onDeleteFinish(paramString, 1);
      return paramLong2;
      i = getDatabase().delete(paramString, paramMsgQueueItem.whereClause, paramMsgQueueItem.whereArgs);
    } while (paramProxyListener == null);
    paramProxyListener.onDeleteFinish(paramString, i);
    return paramLong2;
  }
  
  private long a(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    if ((aoxx.jdField_a_of_type_Boolean) && (bhkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (bhkf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a().b(paramMsgQueueItem, paramEntityManager);
    }
    long l = System.nanoTime();
    int i = getDatabase().delete(paramString, paramMsgQueueItem.whereClause, paramMsgQueueItem.whereArgs);
    l = (System.nanoTime() - l) / 1000L;
    if (paramProxyListener != null) {
      paramProxyListener.onDeleteFinish(paramString, i);
    }
    if ((paramBoolean1) && (StatisticCollector.getSqliteSwitchBySample(6)))
    {
      paramMsgQueueItem = new HashMap();
      if (!paramBoolean2) {
        break label193;
      }
    }
    label193:
    for (paramEntityManager = "1";; paramEntityManager = "0")
    {
      paramMsgQueueItem.put("param_IsMainThread", paramEntityManager);
      paramMsgQueueItem.put("param_OptType", "delete");
      paramMsgQueueItem.put("param_OptTotalCost", String.valueOf(l));
      paramMsgQueueItem.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong, 0L, paramMsgQueueItem, null, false);
      return l;
    }
  }
  
  private void a(EntityTransaction paramEntityTransaction, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, int paramInt2)
  {
    HashMap localHashMap;
    if (paramEntityTransaction != null)
    {
      paramEntityTransaction.end();
      paramLong = (System.nanoTime() - paramLong) / 1000L;
      if (paramBoolean1)
      {
        localHashMap = new HashMap();
        if (!paramBoolean2) {
          break label161;
        }
      }
    }
    label161:
    for (paramEntityTransaction = "1";; paramEntityTransaction = "0")
    {
      localHashMap.put("param_IsMainThread", paramEntityTransaction);
      localHashMap.put("param_OptType", "trans");
      localHashMap.put("param_OptTotalCost", String.valueOf(paramLong));
      localHashMap.put("param_OptCount", String.valueOf(paramInt1));
      localHashMap.put("param_OptMsgCount", String.valueOf(paramInt2));
      localHashMap.put("param_OptOneCost", String.valueOf((float)paramLong / paramInt1));
      localHashMap.put("param_OptScene", "trans");
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, paramLong, 0L, localHashMap, null, false);
      return;
    }
  }
  
  /* Error */
  private boolean a(aoxs paramaoxs)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 72	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 259	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: ldc_w 261
    //   15: iconst_1
    //   16: invokestatic 266	bhii:b	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   19: ifeq +54 -> 73
    //   22: getstatic 53	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_b_of_type_ArrayOfJavaLangClass	[Ljava/lang/Class;
    //   25: astore 6
    //   27: aload 6
    //   29: arraylength
    //   30: istore_3
    //   31: iconst_0
    //   32: istore_2
    //   33: iload_2
    //   34: iload_3
    //   35: if_icmpge +84 -> 119
    //   38: aload 6
    //   40: iload_2
    //   41: aaload
    //   42: astore 7
    //   44: aload_1
    //   45: invokevirtual 272	java/lang/Object:getClass	()Ljava/lang/Class;
    //   48: astore 8
    //   50: aload 8
    //   52: aload 7
    //   54: if_acmpne +12 -> 66
    //   57: iload 5
    //   59: istore 4
    //   61: aload_0
    //   62: monitorexit
    //   63: iload 4
    //   65: ireturn
    //   66: iload_2
    //   67: iconst_1
    //   68: iadd
    //   69: istore_2
    //   70: goto -37 -> 33
    //   73: getstatic 37	com/tencent/mobileqq/app/proxy/ProxyManager:jdField_a_of_type_ArrayOfJavaLangClass	[Ljava/lang/Class;
    //   76: astore 6
    //   78: aload 6
    //   80: arraylength
    //   81: istore_3
    //   82: iconst_0
    //   83: istore_2
    //   84: iload_2
    //   85: iload_3
    //   86: if_icmpge +33 -> 119
    //   89: aload 6
    //   91: iload_2
    //   92: aaload
    //   93: astore 7
    //   95: aload_1
    //   96: invokevirtual 272	java/lang/Object:getClass	()Ljava/lang/Class;
    //   99: astore 8
    //   101: iload 5
    //   103: istore 4
    //   105: aload 8
    //   107: aload 7
    //   109: if_acmpeq -48 -> 61
    //   112: iload_2
    //   113: iconst_1
    //   114: iadd
    //   115: istore_2
    //   116: goto -32 -> 84
    //   119: iconst_0
    //   120: istore 4
    //   122: goto -61 -> 61
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	ProxyManager
    //   0	130	1	paramaoxs	aoxs
    //   32	84	2	i	int
    //   30	57	3	j	int
    //   59	62	4	bool1	boolean
    //   1	101	5	bool2	boolean
    //   25	65	6	arrayOfClass	Class[]
    //   42	66	7	localClass1	Class
    //   48	58	8	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   5	31	125	finally
    //   44	50	125	finally
    //   73	82	125	finally
    //   95	101	125	finally
  }
  
  private long b(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    if ((aoxx.jdField_a_of_type_Boolean) && (bhkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (bhkf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a().a(paramMsgQueueItem, paramEntityManager);
    }
    long l = System.nanoTime();
    paramEntityManager = getDatabase();
    if (paramEntityManager != null)
    {
      int i = paramEntityManager.update(paramString, paramMsgQueueItem.value, paramMsgQueueItem.whereClause, paramMsgQueueItem.whereArgs);
      l = (System.nanoTime() - l) / 1000L;
      paramLong2 = l;
      if (paramProxyListener != null)
      {
        paramProxyListener.onUpdateFinish(paramString, i);
        paramLong2 = l;
      }
    }
    if ((paramBoolean1) && (StatisticCollector.getSqliteSwitchBySample(5)))
    {
      paramMsgQueueItem = new HashMap();
      if (!paramBoolean2) {
        break label212;
      }
    }
    label212:
    for (paramEntityManager = "1";; paramEntityManager = "0")
    {
      paramMsgQueueItem.put("param_IsMainThread", paramEntityManager);
      paramMsgQueueItem.put("param_OptType", "update");
      paramMsgQueueItem.put("param_OptTotalCost", String.valueOf(paramLong2));
      paramMsgQueueItem.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong1, 0L, paramMsgQueueItem, null, false);
      return paramLong2;
    }
  }
  
  private long b(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    long l = System.nanoTime();
    if ((aoxx.jdField_a_of_type_Boolean) && (bhkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (bhkf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a().a(paramMsgQueueItem.item);
    }
    paramEntityManager.persistOrReplace(paramMsgQueueItem.item);
    l = (System.nanoTime() - l) / 1000L;
    if (paramProxyListener != null) {
      paramProxyListener.onInsertFinish(paramString);
    }
    if ((aoxx.jdField_a_of_type_Boolean) && (bhkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (bhkf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a().a(paramMsgQueueItem.item, paramEntityManager);
    }
    if ((paramBoolean1) && (StatisticCollector.getSqliteSwitchBySample(4)))
    {
      paramMsgQueueItem = new HashMap();
      if (!paramBoolean2) {
        break label226;
      }
    }
    label226:
    for (paramEntityManager = "1";; paramEntityManager = "0")
    {
      paramMsgQueueItem.put("param_IsMainThread", paramEntityManager);
      paramMsgQueueItem.put("param_OptType", "insert");
      paramMsgQueueItem.put("param_OptTotalCost", String.valueOf(l));
      paramMsgQueueItem.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong, 0L, paramMsgQueueItem, null, false);
      return l;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Acng = new acng(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, new acne());
    this.jdField_a_of_type_Aooh = new aooh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_b_of_type_Aoxv = new aoxu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Aoxv = new aoxt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Aoxy = new aoxy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Atpt = new atpt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bflk = new bflk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Aukt = new aukt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bdld = new bdld(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Blyr = new blyr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Acmx = new acmx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bapo = new bapo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Aqvm = new aqvm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Axai = new axai(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Aqol = new aqol(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Avea = new avea(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, new acne());
    this.jdField_a_of_type_ArrayOfAoxs = new aoxs[] { this.jdField_a_of_type_Acng, this.jdField_b_of_type_Aoxv, this.jdField_a_of_type_Aoxv, this.jdField_a_of_type_Atpt, this.jdField_a_of_type_Bdld, this.jdField_a_of_type_Blyr, this.jdField_a_of_type_Aukt, this.jdField_a_of_type_Acmx, this.jdField_a_of_type_Bapo, this.jdField_a_of_type_Aqvm, this.jdField_a_of_type_Bflk, this.jdField_a_of_type_Axai, this.jdField_a_of_type_Aqol, this.jdField_a_of_type_Avea };
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((!aoxx.jdField_a_of_type_Boolean) || (!bhkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label61;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a())
      {
        aoyc localaoyc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a();
        if (localaoyc != null) {
          localaoyc.b();
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
    return;
    label61:
    this.jdField_a_of_type_Boolean = false;
  }
  
  public acmx a()
  {
    return this.jdField_a_of_type_Acmx;
  }
  
  public acng a()
  {
    return this.jdField_a_of_type_Acng;
  }
  
  public aooh a()
  {
    return this.jdField_a_of_type_Aooh;
  }
  
  public aoxv a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Aoxv.a();
      return this.jdField_b_of_type_Aoxv;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Aoxv.a();
      return this.jdField_a_of_type_Aoxv;
    }
    this.jdField_b_of_type_Aoxv.a();
    return this.jdField_b_of_type_Aoxv;
  }
  
  public aoxy a()
  {
    return this.jdField_a_of_type_Aoxy;
  }
  
  @Deprecated
  public aoxz a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy();
  }
  
  public aqol a()
  {
    return this.jdField_a_of_type_Aqol;
  }
  
  public aqvm a()
  {
    return this.jdField_a_of_type_Aqvm;
  }
  
  public atpt a()
  {
    return this.jdField_a_of_type_Atpt;
  }
  
  public aukt a()
  {
    return this.jdField_a_of_type_Aukt;
  }
  
  public avea a()
  {
    return this.jdField_a_of_type_Avea;
  }
  
  public axai a()
  {
    return this.jdField_a_of_type_Axai;
  }
  
  public bapo a()
  {
    return this.jdField_a_of_type_Bapo;
  }
  
  public bflk a()
  {
    return this.jdField_a_of_type_Bflk;
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
          aoxs localaoxs = (aoxs)localIterator.next();
          blfz.a("i." + localaoxs);
          long l = System.currentTimeMillis();
          localaoxs.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localaoxs.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
          }
          blfz.a();
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
        if ((i < this.jdField_a_of_type_ArrayOfAoxs.length) && (!this.isDestroyed)) {
          if (a(this.jdField_a_of_type_ArrayOfAoxs[i]))
          {
            this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ArrayOfAoxs[i]);
          }
          else
          {
            blfz.a("i." + this.jdField_a_of_type_ArrayOfAoxs[i]);
            long l = System.currentTimeMillis();
            this.jdField_a_of_type_ArrayOfAoxs[i].a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + this.jdField_a_of_type_ArrayOfAoxs[i].getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
            }
            blfz.a();
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
        if (i < this.jdField_a_of_type_ArrayOfAoxs.length)
        {
          this.jdField_a_of_type_ArrayOfAoxs[i].b();
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
          if ((acnh.a(localMsgQueueItem.frindUin, paramString, localMsgQueueItem.type, paramInt)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || (localMsgQueueItem.action == 0))) {
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
  protected void transSaveToDatabaseIndeed(EntityManager paramEntityManager, List<MsgQueueItem> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: ldc_w 439
    //   7: iconst_1
    //   8: ldc_w 591
    //   11: invokestatic 593	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: return
    //   15: aload_2
    //   16: invokeinterface 594 1 0
    //   21: ifne -7 -> 14
    //   24: aload_0
    //   25: invokespecial 596	com/tencent/mobileqq/app/proxy/ProxyManager:c	()V
    //   28: invokestatic 599	com/tencent/mobileqq/statistics/StatisticCollector:SQLite3OptimizeReport	()Z
    //   31: istore 14
    //   33: iload 14
    //   35: ifeq +1086 -> 1121
    //   38: iconst_0
    //   39: invokestatic 181	com/tencent/mobileqq/statistics/StatisticCollector:getSqliteSwitchBySample	(I)Z
    //   42: ifeq +1079 -> 1121
    //   45: iconst_1
    //   46: istore 13
    //   48: iconst_0
    //   49: istore 7
    //   51: iconst_0
    //   52: istore 4
    //   54: iconst_0
    //   55: istore 10
    //   57: iconst_0
    //   58: istore 11
    //   60: iconst_0
    //   61: istore_3
    //   62: invokestatic 605	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   65: astore 20
    //   67: invokestatic 608	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   70: astore 21
    //   72: aload 20
    //   74: aload 21
    //   76: if_acmpne +1051 -> 1127
    //   79: iconst_1
    //   80: istore 12
    //   82: iload 12
    //   84: ifeq +37 -> 121
    //   87: invokestatic 437	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +31 -> 121
    //   93: ldc_w 439
    //   96: iconst_2
    //   97: new 410	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 411	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 610
    //   107: invokevirtual 417	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 12
    //   112: invokevirtual 613	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   115: invokevirtual 424	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 453	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_1
    //   122: invokevirtual 617	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   125: astore 20
    //   127: invokestatic 173	java/lang/System:nanoTime	()J
    //   130: lstore 16
    //   132: iload 10
    //   134: istore 5
    //   136: iload 4
    //   138: istore 8
    //   140: iload 11
    //   142: istore 6
    //   144: iload 7
    //   146: istore 9
    //   148: aload 20
    //   150: invokevirtual 620	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   153: iload 13
    //   155: ifeq +958 -> 1113
    //   158: iload 10
    //   160: istore 5
    //   162: iload 4
    //   164: istore 8
    //   166: iload 11
    //   168: istore 6
    //   170: iload 7
    //   172: istore 9
    //   174: invokestatic 173	java/lang/System:nanoTime	()J
    //   177: lload 16
    //   179: lsub
    //   180: ldc2_w 174
    //   183: ldiv
    //   184: lstore 18
    //   186: iload 10
    //   188: istore 5
    //   190: iload 4
    //   192: istore 8
    //   194: iload 11
    //   196: istore 6
    //   198: iload 7
    //   200: istore 9
    //   202: new 183	java/util/HashMap
    //   205: dup
    //   206: invokespecial 184	java/util/HashMap:<init>	()V
    //   209: astore 22
    //   211: iload 12
    //   213: ifeq +920 -> 1133
    //   216: ldc 186
    //   218: astore 21
    //   220: iload 10
    //   222: istore 5
    //   224: iload 4
    //   226: istore 8
    //   228: iload 11
    //   230: istore 6
    //   232: iload 7
    //   234: istore 9
    //   236: aload 22
    //   238: ldc 188
    //   240: aload 21
    //   242: invokevirtual 192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: iload 10
    //   248: istore 5
    //   250: iload 4
    //   252: istore 8
    //   254: iload 11
    //   256: istore 6
    //   258: iload 7
    //   260: istore 9
    //   262: aload 22
    //   264: ldc 194
    //   266: ldc_w 622
    //   269: invokevirtual 192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   272: pop
    //   273: iload 10
    //   275: istore 5
    //   277: iload 4
    //   279: istore 8
    //   281: iload 11
    //   283: istore 6
    //   285: iload 7
    //   287: istore 9
    //   289: aload 22
    //   291: ldc 197
    //   293: lload 18
    //   295: invokestatic 203	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   298: invokevirtual 192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   301: pop
    //   302: iload 10
    //   304: istore 5
    //   306: iload 4
    //   308: istore 8
    //   310: iload 11
    //   312: istore 6
    //   314: iload 7
    //   316: istore 9
    //   318: aload 22
    //   320: ldc 205
    //   322: getstatic 210	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   325: invokestatic 213	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   328: invokevirtual 192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   331: pop
    //   332: iload 10
    //   334: istore 5
    //   336: iload 4
    //   338: istore 8
    //   340: iload 11
    //   342: istore 6
    //   344: iload 7
    //   346: istore 9
    //   348: invokestatic 219	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   351: invokestatic 223	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   354: aconst_null
    //   355: ldc 225
    //   357: iconst_1
    //   358: ldc2_w 623
    //   361: lconst_0
    //   362: aload 22
    //   364: aconst_null
    //   365: iconst_0
    //   366: invokevirtual 229	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   369: iload 10
    //   371: istore 5
    //   373: iload 4
    //   375: istore 8
    //   377: iload 11
    //   379: istore 6
    //   381: iload 7
    //   383: istore 9
    //   385: aload_2
    //   386: invokeinterface 625 1 0
    //   391: astore 21
    //   393: iconst_0
    //   394: istore 4
    //   396: aload 21
    //   398: invokeinterface 404 1 0
    //   403: ifeq +479 -> 882
    //   406: aload 21
    //   408: invokeinterface 408 1 0
    //   413: checkcast 84	com/tencent/mobileqq/app/proxy/MsgQueueItem
    //   416: astore 22
    //   418: iload 4
    //   420: iconst_1
    //   421: iadd
    //   422: istore 4
    //   424: iload_3
    //   425: istore 5
    //   427: iload 4
    //   429: istore 8
    //   431: iload_3
    //   432: istore 6
    //   434: iload 4
    //   436: istore 9
    //   438: aload 22
    //   440: getfield 628	com/tencent/mobileqq/app/proxy/MsgQueueItem:tableName	Ljava/lang/String;
    //   443: astore 23
    //   445: iload_3
    //   446: istore 5
    //   448: iload 4
    //   450: istore 8
    //   452: iload_3
    //   453: istore 6
    //   455: iload 4
    //   457: istore 9
    //   459: aload 22
    //   461: getfield 632	com/tencent/mobileqq/app/proxy/MsgQueueItem:listener	Lcom/tencent/mobileqq/app/proxy/ProxyListener;
    //   464: astore 24
    //   466: iload_3
    //   467: istore 7
    //   469: iload_3
    //   470: istore 5
    //   472: iload 4
    //   474: istore 8
    //   476: iload_3
    //   477: istore 6
    //   479: iload 4
    //   481: istore 9
    //   483: invokestatic 437	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +81 -> 567
    //   489: iload_3
    //   490: istore 5
    //   492: iload 4
    //   494: istore 8
    //   496: iload_3
    //   497: istore 6
    //   499: iload 4
    //   501: istore 9
    //   503: aload 22
    //   505: getfield 95	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   508: instanceof 463
    //   511: istore 15
    //   513: iload 15
    //   515: ifeq +96 -> 611
    //   518: iload_3
    //   519: iconst_1
    //   520: iadd
    //   521: istore_3
    //   522: ldc_w 439
    //   525: iconst_2
    //   526: iconst_4
    //   527: anewarray 268	java/lang/Object
    //   530: dup
    //   531: iconst_0
    //   532: ldc_w 634
    //   535: aastore
    //   536: dup
    //   537: iconst_1
    //   538: aload 22
    //   540: getfield 88	com/tencent/mobileqq/app/proxy/MsgQueueItem:action	I
    //   543: invokestatic 562	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: dup
    //   548: iconst_2
    //   549: ldc_w 636
    //   552: aastore
    //   553: dup
    //   554: iconst_3
    //   555: aload 22
    //   557: getfield 95	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   560: aastore
    //   561: invokestatic 568	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   564: iload_3
    //   565: istore 7
    //   567: iload 7
    //   569: istore 5
    //   571: iload 4
    //   573: istore 8
    //   575: iload 7
    //   577: istore 6
    //   579: iload 4
    //   581: istore 9
    //   583: aload_0
    //   584: aload_1
    //   585: iload 14
    //   587: iload 12
    //   589: ldc2_w 623
    //   592: lload 18
    //   594: aload 22
    //   596: aload 23
    //   598: aload 24
    //   600: invokespecial 638	com/tencent/mobileqq/app/proxy/ProxyManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;ZZJJLcom/tencent/mobileqq/app/proxy/MsgQueueItem;Ljava/lang/String;Lcom/tencent/mobileqq/app/proxy/ProxyListener;)J
    //   603: lstore 18
    //   605: iload 7
    //   607: istore_3
    //   608: goto -212 -> 396
    //   611: iload_3
    //   612: istore 5
    //   614: iload 4
    //   616: istore 8
    //   618: iload_3
    //   619: istore 6
    //   621: iload 4
    //   623: istore 9
    //   625: aload 22
    //   627: getfield 88	com/tencent/mobileqq/app/proxy/MsgQueueItem:action	I
    //   630: istore 7
    //   632: iload_3
    //   633: istore 5
    //   635: iload 4
    //   637: istore 8
    //   639: iload_3
    //   640: istore 6
    //   642: iload 4
    //   644: istore 9
    //   646: aload 22
    //   648: getfield 541	com/tencent/mobileqq/app/proxy/MsgQueueItem:frindUin	Ljava/lang/String;
    //   651: astore 25
    //   653: iload_3
    //   654: istore 5
    //   656: iload 4
    //   658: istore 8
    //   660: iload_3
    //   661: istore 6
    //   663: iload 4
    //   665: istore 9
    //   667: aload 22
    //   669: getfield 628	com/tencent/mobileqq/app/proxy/MsgQueueItem:tableName	Ljava/lang/String;
    //   672: astore 26
    //   674: iload_3
    //   675: istore 5
    //   677: iload 4
    //   679: istore 8
    //   681: iload_3
    //   682: istore 6
    //   684: iload 4
    //   686: istore 9
    //   688: aload 22
    //   690: getfield 278	com/tencent/mobileqq/app/proxy/MsgQueueItem:value	Landroid/content/ContentValues;
    //   693: ifnull +182 -> 875
    //   696: iload_3
    //   697: istore 5
    //   699: iload 4
    //   701: istore 8
    //   703: iload_3
    //   704: istore 6
    //   706: iload 4
    //   708: istore 9
    //   710: aload 22
    //   712: getfield 278	com/tencent/mobileqq/app/proxy/MsgQueueItem:value	Landroid/content/ContentValues;
    //   715: invokevirtual 643	android/content/ContentValues:hashCode	()I
    //   718: invokestatic 562	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   721: astore_2
    //   722: iload_3
    //   723: istore 5
    //   725: iload 4
    //   727: istore 8
    //   729: iload_3
    //   730: istore 6
    //   732: iload 4
    //   734: istore 9
    //   736: ldc_w 439
    //   739: iconst_2
    //   740: bipush 8
    //   742: anewarray 268	java/lang/Object
    //   745: dup
    //   746: iconst_0
    //   747: ldc_w 634
    //   750: aastore
    //   751: dup
    //   752: iconst_1
    //   753: iload 7
    //   755: invokestatic 562	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   758: aastore
    //   759: dup
    //   760: iconst_2
    //   761: ldc_w 645
    //   764: aastore
    //   765: dup
    //   766: iconst_3
    //   767: aload 25
    //   769: aastore
    //   770: dup
    //   771: iconst_4
    //   772: ldc_w 647
    //   775: aastore
    //   776: dup
    //   777: iconst_5
    //   778: aload 26
    //   780: aastore
    //   781: dup
    //   782: bipush 6
    //   784: ldc_w 649
    //   787: aastore
    //   788: dup
    //   789: bipush 7
    //   791: aload_2
    //   792: aastore
    //   793: invokestatic 568	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   796: iload_3
    //   797: istore 7
    //   799: goto -232 -> 567
    //   802: astore_2
    //   803: iload 5
    //   805: istore 4
    //   807: iload 8
    //   809: istore_3
    //   810: aload 20
    //   812: astore_1
    //   813: aload_2
    //   814: invokevirtual 652	java/lang/Exception:printStackTrace	()V
    //   817: aload_0
    //   818: sipush 1001
    //   821: invokevirtual 656	com/tencent/mobileqq/app/proxy/ProxyManager:notifyEvent	(I)V
    //   824: invokestatic 437	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   827: ifeq +33 -> 860
    //   830: ldc_w 439
    //   833: iconst_2
    //   834: new 410	java/lang/StringBuilder
    //   837: dup
    //   838: invokespecial 411	java/lang/StringBuilder:<init>	()V
    //   841: ldc_w 658
    //   844: invokevirtual 417	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload_2
    //   848: invokevirtual 661	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   851: invokevirtual 417	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: invokevirtual 424	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: invokestatic 664	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   860: aload_0
    //   861: aload_1
    //   862: iload 13
    //   864: iload 12
    //   866: lload 16
    //   868: iload_3
    //   869: iload 4
    //   871: invokespecial 666	com/tencent/mobileqq/app/proxy/ProxyManager:a	(Lcom/tencent/mobileqq/persistence/EntityTransaction;ZZJII)V
    //   874: return
    //   875: ldc_w 668
    //   878: astore_2
    //   879: goto -157 -> 722
    //   882: aload 20
    //   884: invokevirtual 671	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   887: aload_0
    //   888: sipush 1000
    //   891: invokevirtual 656	com/tencent/mobileqq/app/proxy/ProxyManager:notifyEvent	(I)V
    //   894: aload_0
    //   895: aload 20
    //   897: iload 13
    //   899: iload 12
    //   901: lload 16
    //   903: iload 4
    //   905: iload_3
    //   906: invokespecial 666	com/tencent/mobileqq/app/proxy/ProxyManager:a	(Lcom/tencent/mobileqq/persistence/EntityTransaction;ZZJII)V
    //   909: return
    //   910: astore_2
    //   911: iconst_0
    //   912: istore 4
    //   914: ldc2_w 623
    //   917: lstore 16
    //   919: iconst_0
    //   920: istore 12
    //   922: aconst_null
    //   923: astore_1
    //   924: iconst_0
    //   925: istore_3
    //   926: aload_0
    //   927: aload_1
    //   928: iload 13
    //   930: iload 12
    //   932: lload 16
    //   934: iload_3
    //   935: iload 4
    //   937: invokespecial 666	com/tencent/mobileqq/app/proxy/ProxyManager:a	(Lcom/tencent/mobileqq/persistence/EntityTransaction;ZZJII)V
    //   940: aload_2
    //   941: athrow
    //   942: astore_2
    //   943: iconst_0
    //   944: istore 4
    //   946: ldc2_w 623
    //   949: lstore 16
    //   951: aconst_null
    //   952: astore_1
    //   953: iconst_0
    //   954: istore_3
    //   955: goto -29 -> 926
    //   958: astore_2
    //   959: iconst_0
    //   960: istore 4
    //   962: iconst_0
    //   963: istore_3
    //   964: ldc2_w 623
    //   967: lstore 16
    //   969: aload 20
    //   971: astore_1
    //   972: goto -46 -> 926
    //   975: astore_2
    //   976: iload 6
    //   978: istore 4
    //   980: iload 9
    //   982: istore_3
    //   983: aload 20
    //   985: astore_1
    //   986: goto -60 -> 926
    //   989: astore_2
    //   990: iload_3
    //   991: istore 5
    //   993: iload 4
    //   995: istore_3
    //   996: aload 20
    //   998: astore_1
    //   999: iload 5
    //   1001: istore 4
    //   1003: goto -77 -> 926
    //   1006: astore_2
    //   1007: iload_3
    //   1008: istore 5
    //   1010: iload 4
    //   1012: istore_3
    //   1013: aload 20
    //   1015: astore_1
    //   1016: iload 5
    //   1018: istore 4
    //   1020: goto -94 -> 926
    //   1023: astore_2
    //   1024: goto -98 -> 926
    //   1027: astore_2
    //   1028: iconst_0
    //   1029: istore 4
    //   1031: ldc2_w 623
    //   1034: lstore 16
    //   1036: iconst_0
    //   1037: istore 12
    //   1039: aconst_null
    //   1040: astore_1
    //   1041: iconst_0
    //   1042: istore_3
    //   1043: goto -230 -> 813
    //   1046: astore_2
    //   1047: iconst_0
    //   1048: istore 4
    //   1050: ldc2_w 623
    //   1053: lstore 16
    //   1055: aconst_null
    //   1056: astore_1
    //   1057: iconst_0
    //   1058: istore_3
    //   1059: goto -246 -> 813
    //   1062: astore_2
    //   1063: iconst_0
    //   1064: istore 4
    //   1066: iconst_0
    //   1067: istore_3
    //   1068: ldc2_w 623
    //   1071: lstore 16
    //   1073: aload 20
    //   1075: astore_1
    //   1076: goto -263 -> 813
    //   1079: astore_2
    //   1080: iload_3
    //   1081: istore 5
    //   1083: iload 4
    //   1085: istore_3
    //   1086: aload 20
    //   1088: astore_1
    //   1089: iload 5
    //   1091: istore 4
    //   1093: goto -280 -> 813
    //   1096: astore_2
    //   1097: iload_3
    //   1098: istore 5
    //   1100: iload 4
    //   1102: istore_3
    //   1103: aload 20
    //   1105: astore_1
    //   1106: iload 5
    //   1108: istore 4
    //   1110: goto -297 -> 813
    //   1113: ldc2_w 623
    //   1116: lstore 18
    //   1118: goto -749 -> 369
    //   1121: iconst_0
    //   1122: istore 13
    //   1124: goto -1076 -> 48
    //   1127: iconst_0
    //   1128: istore 12
    //   1130: goto -1048 -> 82
    //   1133: ldc 231
    //   1135: astore 21
    //   1137: goto -917 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1140	0	this	ProxyManager
    //   0	1140	1	paramEntityManager	EntityManager
    //   0	1140	2	paramList	List<MsgQueueItem>
    //   61	1042	3	i	int
    //   52	1057	4	j	int
    //   134	973	5	k	int
    //   142	835	6	m	int
    //   49	749	7	n	int
    //   138	670	8	i1	int
    //   146	835	9	i2	int
    //   55	315	10	i3	int
    //   58	320	11	i4	int
    //   80	1049	12	bool1	boolean
    //   46	1077	13	bool2	boolean
    //   31	555	14	bool3	boolean
    //   511	3	15	bool4	boolean
    //   130	942	16	l1	long
    //   184	933	18	l2	long
    //   65	1039	20	localObject1	Object
    //   70	1066	21	localObject2	Object
    //   209	502	22	localObject3	Object
    //   443	154	23	str1	String
    //   464	135	24	localProxyListener	ProxyListener
    //   651	117	25	str2	String
    //   672	107	26	str3	String
    // Exception table:
    //   from	to	target	type
    //   148	153	802	java/lang/Exception
    //   174	186	802	java/lang/Exception
    //   202	211	802	java/lang/Exception
    //   236	246	802	java/lang/Exception
    //   262	273	802	java/lang/Exception
    //   289	302	802	java/lang/Exception
    //   318	332	802	java/lang/Exception
    //   348	369	802	java/lang/Exception
    //   385	393	802	java/lang/Exception
    //   438	445	802	java/lang/Exception
    //   459	466	802	java/lang/Exception
    //   483	489	802	java/lang/Exception
    //   503	513	802	java/lang/Exception
    //   583	605	802	java/lang/Exception
    //   625	632	802	java/lang/Exception
    //   646	653	802	java/lang/Exception
    //   667	674	802	java/lang/Exception
    //   688	696	802	java/lang/Exception
    //   710	722	802	java/lang/Exception
    //   736	796	802	java/lang/Exception
    //   62	72	910	finally
    //   87	121	942	finally
    //   121	127	942	finally
    //   127	132	958	finally
    //   148	153	975	finally
    //   174	186	975	finally
    //   202	211	975	finally
    //   236	246	975	finally
    //   262	273	975	finally
    //   289	302	975	finally
    //   318	332	975	finally
    //   348	369	975	finally
    //   385	393	975	finally
    //   438	445	975	finally
    //   459	466	975	finally
    //   483	489	975	finally
    //   503	513	975	finally
    //   583	605	975	finally
    //   625	632	975	finally
    //   646	653	975	finally
    //   667	674	975	finally
    //   688	696	975	finally
    //   710	722	975	finally
    //   736	796	975	finally
    //   396	418	989	finally
    //   882	894	989	finally
    //   522	564	1006	finally
    //   813	860	1023	finally
    //   62	72	1027	java/lang/Exception
    //   87	121	1046	java/lang/Exception
    //   121	127	1046	java/lang/Exception
    //   127	132	1062	java/lang/Exception
    //   396	418	1079	java/lang/Exception
    //   882	894	1079	java/lang/Exception
    //   522	564	1096	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyManager
 * JD-Core Version:    0.7.0.1
 */