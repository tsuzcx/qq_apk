package com.tencent.mobileqq.app.qqdaily;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private static boolean a;
  private static long h;
  private QQAppInterface b;
  private MqqHandler c;
  private EntityManager d;
  private List<oidb_cmd0xe27.InOutQQ> e;
  private List<oidb_cmd0xe27.InOutQQ> f;
  private boolean g = true;
  private QQDailyHandler.OnReceiveListener i;
  private BroadcastReceiver j;
  private boolean k = false;
  private boolean l = true;
  
  public FrontBackReportManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.c = new CustomHandler(ThreadManagerV2.getSubThreadLooper(), this);
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.i = new FrontBackReportManager.1(this);
    a(paramQQAppInterface);
    c();
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
    this.l = false;
    a(2);
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 1);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    boolean bool = this.g;
    int i1 = 2;
    if ((!bool) && (paramInt1 != 2) && (paramInt1 != 1)) {
      return;
    }
    bool = false;
    int m;
    if ((paramInt1 == 1) && (!this.k) && ((this.l) || (paramInt2 == 2)))
    {
      this.k = true;
      m = 1;
    }
    else
    {
      m = 0;
    }
    int n = m;
    if (paramInt1 == 2)
    {
      n = m;
      if (this.k)
      {
        if (paramInt2 == 2) {
          bool = true;
        }
        this.k = bool;
        n = 1;
      }
    }
    if (n == 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    oidb_cmd0xe27.InOutQQ localInOutQQ = new oidb_cmd0xe27.InOutQQ();
    PBEnumField localPBEnumField = localInOutQQ.enum_biz_id;
    paramInt2 = i1;
    if (paramInt1 == 1) {
      paramInt2 = 1;
    }
    localPBEnumField.set(paramInt2);
    localInOutQQ.uint32_timestamp.set((int)(System.currentTimeMillis() / 1000L));
    localMessage.obj = localInOutQQ;
    this.c.sendMessage(localMessage);
  }
  
  private void a(Message paramMessage)
  {
    if (c(d(this.f))) {
      this.f.clear();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.j = new FrontBackReportManager.2(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGIN");
    paramQQAppInterface.getApp().registerReceiver(this.j, localIntentFilter);
  }
  
  private void a(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      QQDailyHandler localQQDailyHandler = (QQDailyHandler)this.b.getBusinessHandler(BusinessHandlerFactory.QQ_DAILY_HANDLER);
      if (localQQDailyHandler != null)
      {
        localQQDailyHandler.a(paramList);
        localQQDailyHandler.a(this.i);
        if (QLog.isColorLevel()) {
          QLog.d("FrontBackReportManager", 2, new Object[] { "report ", Integer.valueOf(paramList.size()), " entities success.\n", b(paramList) });
        }
      }
    }
  }
  
  private String b(List<oidb_cmd0xe27.InOutQQ> paramList)
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
  
  private void b()
  {
    this.l = true;
    a(1, 2);
  }
  
  private void b(Message paramMessage)
  {
    if ((paramMessage.obj instanceof oidb_cmd0xe27.InOutQQ))
    {
      paramMessage = (oidb_cmd0xe27.InOutQQ)paramMessage.obj;
      this.e.add(paramMessage);
      this.f.add(paramMessage);
      e();
      int m = this.e.size();
      if (m > 20) {
        this.e = this.e.subList(m - 20, m);
      }
      if (!a)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FrontBackReportManager", 2, "[reportFrontBackgroundStatic] sIsAfterSyncMsg is false");
        }
        return;
      }
      a(this.e);
    }
  }
  
  private void c()
  {
    this.c.sendEmptyMessage(5);
  }
  
  /* Error */
  private boolean c(List<FrontBackData> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +230 -> 233
    //   6: aload_1
    //   7: invokeinterface 192 1 0
    //   12: ifeq +221 -> 233
    //   15: aload_1
    //   16: invokeinterface 192 1 0
    //   21: iconst_1
    //   22: if_icmpge +6 -> 28
    //   25: goto +208 -> 233
    //   28: aload_0
    //   29: getfield 304	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:d	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   32: ifnonnull +33 -> 65
    //   35: aload_0
    //   36: getfield 44	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   39: invokevirtual 307	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   42: istore_2
    //   43: iload_2
    //   44: ifne +7 -> 51
    //   47: aload_0
    //   48: monitorexit
    //   49: iconst_0
    //   50: ireturn
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 44	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   59: invokevirtual 317	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   62: putfield 304	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:d	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   65: aload_0
    //   66: getfield 304	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:d	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: invokevirtual 323	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   72: astore_3
    //   73: aload_3
    //   74: invokevirtual 328	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   77: aload_1
    //   78: invokeinterface 243 1 0
    //   83: astore 4
    //   85: aload 4
    //   87: invokeinterface 248 1 0
    //   92: ifeq +27 -> 119
    //   95: aload 4
    //   97: invokeinterface 252 1 0
    //   102: checkcast 86	com/tencent/mobileqq/app/qqdaily/FrontBackData
    //   105: astore 5
    //   107: aload_0
    //   108: getfield 304	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:d	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   111: aload 5
    //   113: invokevirtual 332	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   116: goto -31 -> 85
    //   119: aload_3
    //   120: invokevirtual 335	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   123: aload_3
    //   124: invokevirtual 338	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   127: goto +30 -> 157
    //   130: astore_1
    //   131: goto +91 -> 222
    //   134: astore 4
    //   136: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq -16 -> 123
    //   142: ldc 217
    //   144: iconst_2
    //   145: aload 4
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 341	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   154: goto -31 -> 123
    //   157: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +58 -> 218
    //   163: new 238	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   170: astore_3
    //   171: aload_3
    //   172: ldc_w 343
    //   175: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_3
    //   180: aload_1
    //   181: invokeinterface 192 1 0
    //   186: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_3
    //   191: ldc_w 345
    //   194: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_3
    //   199: aload_0
    //   200: aload_1
    //   201: invokespecial 347	com/tencent/mobileqq/app/qqdaily/FrontBackReportManager:e	(Ljava/util/List;)Ljava/lang/String;
    //   204: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: ldc 217
    //   210: iconst_2
    //   211: aload_3
    //   212: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: monitorexit
    //   220: iconst_1
    //   221: ireturn
    //   222: aload_3
    //   223: invokevirtual 338	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: aload_0
    //   230: monitorexit
    //   231: aload_1
    //   232: athrow
    //   233: aload_0
    //   234: monitorexit
    //   235: iconst_0
    //   236: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	FrontBackReportManager
    //   0	237	1	paramList	List<FrontBackData>
    //   42	2	2	bool	boolean
    //   72	151	3	localObject	Object
    //   83	13	4	localIterator	Iterator
    //   134	12	4	localException	Exception
    //   105	7	5	localFrontBackData	FrontBackData
    // Exception table:
    //   from	to	target	type
    //   73	85	130	finally
    //   85	116	130	finally
    //   119	123	130	finally
    //   136	154	130	finally
    //   73	85	134	java/lang/Exception
    //   85	116	134	java/lang/Exception
    //   119	123	134	java/lang/Exception
    //   6	25	228	finally
    //   28	43	228	finally
    //   51	65	228	finally
    //   65	73	228	finally
    //   123	127	228	finally
    //   157	218	228	finally
    //   222	228	228	finally
  }
  
  private List<FrontBackData> d(List<oidb_cmd0xe27.InOutQQ> paramList)
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
  
  private void d()
  {
    try
    {
      if (this.d == null) {
        this.d = this.b.getEntityManagerFactory().createEntityManager();
      }
      Object localObject3 = null;
      int m = 0;
      Object localObject1;
      try
      {
        localObject1 = this.d.query(FrontBackData.class);
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
          if (localFrontBackData.time > f())
          {
            this.e.add(a(localFrontBackData));
          }
          else
          {
            this.d.remove(localFrontBackData);
            m += 1;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("query ");
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          ((StringBuilder)localObject3).append(" items, delete ");
          ((StringBuilder)localObject3).append(m);
          ((StringBuilder)localObject3).append(" items.\n");
          ((StringBuilder)localObject3).append(e((List)localObject1));
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
  
  private String e(List<FrontBackData> paramList)
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
  
  private void e()
  {
    if (this.f.size() >= 1)
    {
      this.c.removeMessages(4);
      this.c.sendEmptyMessage(4);
    }
  }
  
  private static long f()
  {
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = h;
    if ((l2 != 0L) && (86400L + l2 > l1)) {
      return l2;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    l1 = localCalendar.getTimeInMillis() / 1000L;
    h = l1;
    return l1;
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
      this.g = true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.d;
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
    ((QQDailyHandler)this.b.getBusinessHandler(BusinessHandlerFactory.QQ_DAILY_HANDLER)).b(this.i);
    this.b.getApp().unregisterReceiver(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.FrontBackReportManager
 * JD-Core Version:    0.7.0.1
 */