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
  private static long jdField_a_of_type_Long = 0L;
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
    long l = System.currentTimeMillis() / 1000L;
    if ((jdField_a_of_type_Long != 0L) && (86400L + jdField_a_of_type_Long > l)) {
      return jdField_a_of_type_Long;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    l = localCalendar.getTimeInMillis() / 1000L;
    jdField_a_of_type_Long = l;
    return l;
  }
  
  private String a(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0xe27.InOutQQ localInOutQQ = (oidb_cmd0xe27.InOutQQ)paramList.next();
      localStringBuilder.append("data: ").append(localInOutQQ.enum_biz_id.get()).append(", timestamp: ").append(localInOutQQ.uint32_timestamp.get()).append("\n");
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
    boolean bool = false;
    int j = 1;
    if ((!this.jdField_b_of_type_Boolean) && (paramInt1 != 2) && (paramInt1 != 1)) {
      return;
    }
    if ((paramInt1 == 1) && (!this.c) && ((this.d) || (paramInt2 == 2))) {
      this.c = true;
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt1 == 2) && (this.c))
      {
        if (paramInt2 == 2) {
          bool = true;
        }
        this.c = bool;
      }
      for (paramInt2 = 1; paramInt2 != 0; paramInt2 = i)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        oidb_cmd0xe27.InOutQQ localInOutQQ = new oidb_cmd0xe27.InOutQQ();
        PBEnumField localPBEnumField = localInOutQQ.enum_biz_id;
        if (paramInt1 == 1) {}
        for (paramInt1 = j;; paramInt1 = 2)
        {
          localPBEnumField.set(paramInt1);
          localInOutQQ.uint32_timestamp.set((int)(System.currentTimeMillis() / 1000L));
          localMessage.obj = localInOutQQ;
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
          return;
        }
      }
      break;
    }
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
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      QQDailyHandler localQQDailyHandler;
      do
      {
        return;
        localQQDailyHandler = (QQDailyHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQ_DAILY_HANDLER);
      } while (localQQDailyHandler == null);
      localQQDailyHandler.a(paramList);
      localQQDailyHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyHandler$OnReceiveListener);
    } while (!QLog.isColorLevel());
    QLog.d("FrontBackReportManager", 2, new Object[] { "report ", Integer.valueOf(paramList.size()), " entities success.\n", a(paramList) });
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  private boolean a(List<FrontBackData> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: iload 4
    //   7: istore_3
    //   8: aload_1
    //   9: ifnull +30 -> 39
    //   12: iload 4
    //   14: istore_3
    //   15: aload_1
    //   16: invokeinterface 265 1 0
    //   21: ifeq +18 -> 39
    //   24: aload_1
    //   25: invokeinterface 265 1 0
    //   30: istore_2
    //   31: iload_2
    //   32: iconst_1
    //   33: if_icmpge +10 -> 43
    //   36: iload 4
    //   38: istore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_3
    //   42: ireturn
    //   43: aload_0
    //   44: getfield 313	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   47: ifnonnull +30 -> 77
    //   50: iload 4
    //   52: istore_3
    //   53: aload_0
    //   54: getfield 38	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 316	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   60: ifeq -21 -> 39
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 38	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: invokevirtual 320	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   71: invokevirtual 326	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   74: putfield 313	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   77: aload_0
    //   78: getfield 313	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   81: invokevirtual 332	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   84: astore 5
    //   86: aload 5
    //   88: invokevirtual 337	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   91: aload_1
    //   92: invokeinterface 102 1 0
    //   97: astore 6
    //   99: aload 6
    //   101: invokeinterface 108 1 0
    //   106: ifeq +110 -> 216
    //   109: aload 6
    //   111: invokeinterface 112 1 0
    //   116: checkcast 153	com/tencent/mobileqq/app/qqdaily/FrontBackData
    //   119: astore 7
    //   121: aload_0
    //   122: getfield 313	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   125: aload 7
    //   127: invokevirtual 341	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   130: goto -31 -> 99
    //   133: astore 6
    //   135: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +16 -> 154
    //   141: ldc_w 289
    //   144: iconst_2
    //   145: aload 6
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   154: aload 5
    //   156: invokevirtual 348	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   159: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +49 -> 211
    //   165: ldc_w 289
    //   168: iconst_2
    //   169: new 95	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 350
    //   179: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: invokeinterface 265 1 0
    //   188: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc_w 352
    //   194: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: aload_1
    //   199: invokespecial 354	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:b	(Ljava/util/List;)Ljava/lang/String;
    //   202: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: iconst_1
    //   212: istore_3
    //   213: goto -174 -> 39
    //   216: aload 5
    //   218: invokevirtual 360	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   221: aload 5
    //   223: invokevirtual 348	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   226: goto -67 -> 159
    //   229: astore_1
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    //   234: astore_1
    //   235: aload 5
    //   237: invokevirtual 348	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   240: aload_1
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	FrontBackReportManager
    //   0	242	1	paramList	List<FrontBackData>
    //   30	4	2	i	int
    //   7	206	3	bool1	boolean
    //   1	50	4	bool2	boolean
    //   84	152	5	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   97	13	6	localIterator	Iterator
    //   133	13	6	localException	Exception
    //   119	7	7	localFrontBackData	FrontBackData
    // Exception table:
    //   from	to	target	type
    //   86	99	133	java/lang/Exception
    //   99	130	133	java/lang/Exception
    //   216	221	133	java/lang/Exception
    //   15	31	229	finally
    //   43	50	229	finally
    //   53	77	229	finally
    //   77	86	229	finally
    //   154	159	229	finally
    //   159	211	229	finally
    //   221	226	229	finally
    //   235	242	229	finally
    //   86	99	234	finally
    //   99	130	234	finally
    //   135	154	234	finally
    //   216	221	234	finally
  }
  
  private String b(List<FrontBackData> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FrontBackData localFrontBackData = (FrontBackData)paramList.next();
      localStringBuilder.append("data: ").append(localFrontBackData.type).append(", timestamp: ").append(localFrontBackData.time).append("\n");
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
      if (jdField_a_of_type_Boolean) {
        break label101;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FrontBackReportManager", 2, "[reportFrontBackgroundStatic] sIsAfterSyncMsg is false");
      }
    }
    return;
    label101:
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void c()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(5);
  }
  
  private void d()
  {
    int i = 0;
    Iterator localIterator;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      localIterator = null;
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(FrontBackData.class);
        if (localObject != null)
        {
          int j = ((List)localObject).size();
          if (j != 0) {}
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = localIterator;
          if (QLog.isColorLevel())
          {
            QLog.e("FrontBackReportManager", 2, localException, new Object[0]);
            localObject = localIterator;
          }
        }
      }
      localIterator = localList.iterator();
    }
    finally {}
    for (;;)
    {
      if (localIterator.hasNext())
      {
        FrontBackData localFrontBackData = (FrontBackData)localIterator.next();
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
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FrontBackReportManager", 2, "query " + localList.size() + " items, delete " + i + " items.\n" + b(localList));
        break;
      }
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
    }
    for (;;)
    {
      return false;
      if (paramMessage.what == 4) {
        a(paramMessage);
      } else if (paramMessage.what == 5) {
        d();
      } else if (paramMessage.what == 6) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
      ((QQDailyHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQ_DAILY_HANDLER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyHandler$OnReceiveListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.FrontBackReportManager
 * JD-Core Version:    0.7.0.1
 */