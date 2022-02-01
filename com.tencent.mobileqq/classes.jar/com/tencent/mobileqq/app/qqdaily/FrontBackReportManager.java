package com.tencent.mobileqq.app.qqdaily;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.InOutQQ;

public class FrontBackReportManager
  implements Handler.Callback, Manager
{
  private static long jdField_a_of_type_Long;
  private static boolean jdField_a_of_type_Boolean;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQDailyHandler.OnReceiveListener jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyHandler$OnReceiveListener;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private List<oidb_cmd0xe27.InOutQQ> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private List<oidb_cmd0xe27.InOutQQ> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = false;
  private boolean d = true;
  
  public FrontBackReportManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManagerV2.getSubThreadLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyHandler$OnReceiveListener = new FrontBackReportManager.1(this);
    a(paramQQAppInterface);
    c();
  }
  
  private static long a()
  {
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = jdField_a_of_type_Long;
    if ((l2 != 0L) && (86400L + l2 > l1)) {
      return l2;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    l1 = localCalendar.getTimeInMillis() / 1000L;
    jdField_a_of_type_Long = l1;
    return l1;
  }
  
  private String a(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0xe27.InOutQQ localInOutQQ = (oidb_cmd0xe27.InOutQQ)paramList.next();
      localStringBuilder.append("data: ");
      localStringBuilder.append(localInOutQQ.enum_biz_id.get());
      localStringBuilder.append(", timestamp: ");
      localStringBuilder.append(localInOutQQ.uint32_timestamp.get());
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private List<FrontBackData> a(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0xe27.InOutQQ localInOutQQ = (oidb_cmd0xe27.InOutQQ)paramList.next();
      FrontBackData localFrontBackData = new FrontBackData();
      localFrontBackData.time = localInOutQQ.uint32_timestamp.get();
      localFrontBackData.type = localInOutQQ.enum_biz_id.get();
      localArrayList.add(localFrontBackData);
    }
    return localArrayList;
  }
  
  private oidb_cmd0xe27.InOutQQ a(FrontBackData paramFrontBackData)
  {
    oidb_cmd0xe27.InOutQQ localInOutQQ = new oidb_cmd0xe27.InOutQQ();
    localInOutQQ.uint32_timestamp.set((int)paramFrontBackData.time);
    localInOutQQ.enum_biz_id.set(paramFrontBackData.type);
    return localInOutQQ;
  }
  
  private void a()
  {
    this.d = false;
    b(2);
  }
  
  public static void a(int paramInt)
  {
    FrontBackReportManager localFrontBackReportManager = (FrontBackReportManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.FRONT_BACK_REPORT_MANAGER);
    if (localFrontBackReportManager != null) {
      localFrontBackReportManager.b(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    int k = 2;
    if ((!bool) && (paramInt1 != 2) && (paramInt1 != 1)) {
      return;
    }
    bool = false;
    int i;
    if ((paramInt1 == 1) && (!this.c) && ((this.d) || (paramInt2 == 2)))
    {
      this.c = true;
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (paramInt1 == 2)
    {
      j = i;
      if (this.c)
      {
        if (paramInt2 == 2) {
          bool = true;
        }
        this.c = bool;
        j = 1;
      }
    }
    if (j == 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    oidb_cmd0xe27.InOutQQ localInOutQQ = new oidb_cmd0xe27.InOutQQ();
    PBEnumField localPBEnumField = localInOutQQ.enum_biz_id;
    paramInt2 = k;
    if (paramInt1 == 1) {
      paramInt2 = 1;
    }
    localPBEnumField.set(paramInt2);
    localInOutQQ.uint32_timestamp.set((int)(System.currentTimeMillis() / 1000L));
    localMessage.obj = localInOutQQ;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  private void a(Message paramMessage)
  {
    if (a(a(this.jdField_b_of_type_JavaUtilList))) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new FrontBackReportManager.2(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGIN");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void a(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      QQDailyHandler localQQDailyHandler = (QQDailyHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQ_DAILY_HANDLER);
      if (localQQDailyHandler != null)
      {
        localQQDailyHandler.a(paramList);
        localQQDailyHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyHandler$OnReceiveListener);
        if (QLog.isColorLevel()) {
          QLog.d("FrontBackReportManager", 2, new Object[] { "report ", Integer.valueOf(paramList.size()), " entities success.\n", a(paramList) });
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  private boolean a(List<FrontBackData> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +232 -> 235
    //   6: aload_1
    //   7: invokeinterface 265 1 0
    //   12: ifeq +223 -> 235
    //   15: aload_1
    //   16: invokeinterface 265 1 0
    //   21: iconst_1
    //   22: if_icmpge +6 -> 28
    //   25: goto +210 -> 235
    //   28: aload_0
    //   29: getfield 313	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   32: ifnonnull +33 -> 65
    //   35: aload_0
    //   36: getfield 36	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   39: invokevirtual 316	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   42: istore_2
    //   43: iload_2
    //   44: ifne +7 -> 51
    //   47: aload_0
    //   48: monitorexit
    //   49: iconst_0
    //   50: ireturn
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 36	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 320	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   59: invokevirtual 326	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   62: putfield 313	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   65: aload_0
    //   66: getfield 313	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: invokevirtual 332	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   72: astore_3
    //   73: aload_3
    //   74: invokevirtual 337	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   77: aload_1
    //   78: invokeinterface 102 1 0
    //   83: astore 4
    //   85: aload 4
    //   87: invokeinterface 108 1 0
    //   92: ifeq +27 -> 119
    //   95: aload 4
    //   97: invokeinterface 112 1 0
    //   102: checkcast 153	com/tencent/mobileqq/app/qqdaily/FrontBackData
    //   105: astore 5
    //   107: aload_0
    //   108: getfield 313	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   111: aload 5
    //   113: invokevirtual 341	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   116: goto -31 -> 85
    //   119: aload_3
    //   120: invokevirtual 344	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   123: aload_3
    //   124: invokevirtual 347	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   127: goto +31 -> 158
    //   130: astore_1
    //   131: goto +93 -> 224
    //   134: astore 4
    //   136: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq -16 -> 123
    //   142: ldc_w 289
    //   145: iconst_2
    //   146: aload 4
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 351	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   155: goto -32 -> 123
    //   158: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +59 -> 220
    //   164: new 95	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   171: astore_3
    //   172: aload_3
    //   173: ldc_w 353
    //   176: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_3
    //   181: aload_1
    //   182: invokeinterface 265 1 0
    //   187: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_3
    //   192: ldc_w 355
    //   195: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_3
    //   200: aload_0
    //   201: aload_1
    //   202: invokespecial 357	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:b	(Ljava/util/List;)Ljava/lang/String;
    //   205: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: ldc_w 289
    //   212: iconst_2
    //   213: aload_3
    //   214: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 360	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: monitorexit
    //   222: iconst_1
    //   223: ireturn
    //   224: aload_3
    //   225: invokevirtual 347	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   228: aload_1
    //   229: athrow
    //   230: astore_1
    //   231: aload_0
    //   232: monitorexit
    //   233: aload_1
    //   234: athrow
    //   235: aload_0
    //   236: monitorexit
    //   237: iconst_0
    //   238: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	FrontBackReportManager
    //   0	239	1	paramList	List<FrontBackData>
    //   42	2	2	bool	boolean
    //   72	153	3	localObject	Object
    //   83	13	4	localIterator	Iterator
    //   134	13	4	localException	Exception
    //   105	7	5	localFrontBackData	FrontBackData
    // Exception table:
    //   from	to	target	type
    //   73	85	130	finally
    //   85	116	130	finally
    //   119	123	130	finally
    //   136	155	130	finally
    //   73	85	134	java/lang/Exception
    //   85	116	134	java/lang/Exception
    //   119	123	134	java/lang/Exception
    //   6	25	230	finally
    //   28	43	230	finally
    //   51	65	230	finally
    //   65	73	230	finally
    //   123	127	230	finally
    //   158	220	230	finally
    //   224	230	230	finally
  }
  
  private String b(List<FrontBackData> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FrontBackData localFrontBackData = (FrontBackData)paramList.next();
      localStringBuilder.append("data: ");
      localStringBuilder.append(localFrontBackData.type);
      localStringBuilder.append(", timestamp: ");
      localStringBuilder.append(localFrontBackData.time);
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private void b()
  {
    this.d = true;
    a(1, 2);
  }
  
  private void b(int paramInt)
  {
    a(paramInt, 1);
  }
  
  private void b(Message paramMessage)
  {
    if ((paramMessage.obj instanceof oidb_cmd0xe27.InOutQQ))
    {
      paramMessage = (oidb_cmd0xe27.InOutQQ)paramMessage.obj;
      this.jdField_a_of_type_JavaUtilList.add(paramMessage);
      this.jdField_b_of_type_JavaUtilList.add(paramMessage);
      e();
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (i > 20) {
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(i - 20, i);
      }
      if (!jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FrontBackReportManager", 2, "[reportFrontBackgroundStatic] sIsAfterSyncMsg is false");
        }
        return;
      }
      a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(5);
  }
  
  private void d()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      Object localObject3 = null;
      int i = 0;
      Object localObject1;
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(FrontBackData.class);
      }
      catch (Exception localException)
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("FrontBackReportManager", 2, localException, new Object[0]);
          localObject1 = localObject3;
        }
      }
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          FrontBackData localFrontBackData = (FrontBackData)((Iterator)localObject3).next();
          if (localFrontBackData.time > a())
          {
            this.jdField_a_of_type_JavaUtilList.add(a(localFrontBackData));
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localFrontBackData);
            i += 1;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("query ");
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          ((StringBuilder)localObject3).append(" items, delete ");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(" items.\n");
          ((StringBuilder)localObject3).append(b((List)localObject1));
          QLog.d("FrontBackReportManager", 2, ((StringBuilder)localObject3).toString());
        }
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_JavaUtilList.size() >= 1)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(4);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      b(paramMessage);
    } else if (paramMessage.what == 4) {
      a(paramMessage);
    } else if (paramMessage.what == 5) {
      d();
    } else if (paramMessage.what == 6) {
      this.jdField_b_of_type_Boolean = true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if (localEntityManager != null) {
      try
      {
        localEntityManager.close();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    ((QQDailyHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQ_DAILY_HANDLER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyHandler$OnReceiveListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.FrontBackReportManager
 * JD-Core Version:    0.7.0.1
 */