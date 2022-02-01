package com.tencent.imcore.message;

import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;

public class MsgProxyContainer
  extends BaseProxy
{
  public static MsgProxyContainer.Callback a = new MsgProxyContainerDummyCallback();
  private MsgPool b;
  private volatile boolean c = false;
  private volatile boolean d = false;
  private final ConcurrentHashMap<Integer, BaseMsgProxy> e = new ConcurrentHashMap();
  
  static
  {
    InitMsgModule.a();
  }
  
  public MsgProxyContainer(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager);
    this.b = paramMsgPool;
    e();
  }
  
  private List<MessageRecord> a(String paramString, int paramInt)
  {
    Lock localLock = this.b.a(paramString, paramInt);
    localLock.lock();
    try
    {
      List localList = a(paramInt).k(paramString, paramInt);
      if ((localList != null) && (!localList.isEmpty())) {
        this.b.b().put(UinTypeUtil.a(paramString, paramInt), localList);
      }
      return localList;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public static void a(MsgProxyContainer.Callback paramCallback)
  {
    a = paramCallback;
  }
  
  private void b(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    List localList1 = a.a(this);
    if (localList1 == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init listRecent=");
      ((StringBuilder)localObject).append(localList1.size());
      QLog.d("Q.msg.BaseMsgProxyContainer", 2, ((StringBuilder)localObject).toString());
    }
    long l2 = System.currentTimeMillis();
    int i1 = 0;
    int i = 0;
    int k = 0;
    for (;;)
    {
      int m = i;
      int j = i;
      try
      {
        if (i1 < localList1.size()) {
          if (i1 >= paramInt)
          {
            j = i;
          }
          else
          {
            m = i;
            localObject = (MsgProxyContainer.SessionKey)localList1.get(i1);
            m = i;
            if (((MsgProxyContainer.SessionKey)localObject).a() != 6000)
            {
              m = i;
              a.a(l1, (MsgProxyContainer.SessionKey)localObject, this);
              m = i;
              List localList2 = a(((MsgProxyContainer.SessionKey)localObject).a, ((MsgProxyContainer.SessionKey)localObject).a());
              j = i;
              int n = k;
              if (localList2 != null)
              {
                m = i;
                j = i + localList2.size();
                n = k + 1;
              }
              m = j;
              QLog.d("Q.msg.BaseMsgProxyContainer", 1, new Object[] { "INIT cost: ", Long.valueOf(System.currentTimeMillis() - l2), " msgSize: ", Integer.valueOf(j), " convSize:", Integer.valueOf(n) });
              m = j;
              a.b(l1, (MsgProxyContainer.SessionKey)localObject, this);
              k = n;
              i = j;
            }
            i1 += 1;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("Q.msg.BaseMsgProxyContainer", 1, "initLocked: ", localException);
        j = m;
        l2 = System.currentTimeMillis();
        MsgAutoMonitorUtil localMsgAutoMonitorUtil = MsgAutoMonitorUtil.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append("");
        localMsgAutoMonitorUtil.printKeyAndValue("MSG_ProxyInitTime", ((StringBuilder)localObject).toString());
        localMsgAutoMonitorUtil = MsgAutoMonitorUtil.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("");
        localMsgAutoMonitorUtil.printKeyAndValue("MSG_InitMsgNum", ((StringBuilder)localObject).toString());
        a.b(this);
      }
    }
  }
  
  private BaseMsgProxy c(int paramInt)
  {
    return a.a(paramInt, this);
  }
  
  private void e()
  {
    a.c(this);
  }
  
  private void f()
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      BaseMsgProxy localBaseMsgProxy = (BaseMsgProxy)localIterator.next();
      if (localBaseMsgProxy != null) {
        localBaseMsgProxy.init();
      }
    }
  }
  
  private void g()
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      BaseMsgProxy localBaseMsgProxy = (BaseMsgProxy)localIterator.next();
      if (localBaseMsgProxy != null) {
        localBaseMsgProxy.destroy();
      }
    }
  }
  
  public BaseMsgProxy a(int paramInt)
  {
    Object localObject2 = (BaseMsgProxy)this.e.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = c(paramInt);
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" onCreateMsgProxy return null");
        QLog.e("Q.msg.BaseMsgProxyContainer", 1, "getMsgProxy: ", new IllegalStateException(((StringBuilder)localObject2).toString()));
      }
      this.e.put(Integer.valueOf(paramInt), localObject1);
    }
    return localObject1;
  }
  
  public void a()
  {
    if (this.d) {
      return;
    }
    try
    {
      if (this.d) {
        return;
      }
      b(40);
      this.d = true;
      return;
    }
    finally {}
  }
  
  public AppRuntime b()
  {
    return this.app;
  }
  
  public BaseProxyManager c()
  {
    return this.proxyManager;
  }
  
  public MsgPool d()
  {
    return this.b;
  }
  
  public void destroy()
  {
    g();
  }
  
  public void init()
  {
    if (this.c) {
      return;
    }
    try
    {
      if (this.c) {
        return;
      }
      f();
      b(15);
      this.c = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyContainer
 * JD-Core Version:    0.7.0.1
 */