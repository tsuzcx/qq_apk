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
  public static MsgProxyContainer.Callback a;
  private MsgPool jdField_a_of_type_ComTencentImcoreMessageMsgPool;
  private final ConcurrentHashMap<Integer, BaseMsgProxy> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile boolean b = false;
  
  static
  {
    jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback = new MsgProxyContainerDummyCallback();
    InitMsgModule.a();
  }
  
  public MsgProxyContainer(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager);
    this.jdField_a_of_type_ComTencentImcoreMessageMsgPool = paramMsgPool;
    b();
  }
  
  private List<MessageRecord> a(String paramString, int paramInt)
  {
    Lock localLock = this.jdField_a_of_type_ComTencentImcoreMessageMsgPool.a(paramString, paramInt);
    localLock.lock();
    try
    {
      List localList = a(paramInt).f(paramString, paramInt);
      if ((localList != null) && (!localList.isEmpty())) {
        this.jdField_a_of_type_ComTencentImcoreMessageMsgPool.b().put(UinTypeUtil.a(paramString, paramInt), localList);
      }
      return localList;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private void a(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    List localList1 = jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback.a(this);
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
              jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback.a(l1, (MsgProxyContainer.SessionKey)localObject, this);
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
              jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback.b(l1, (MsgProxyContainer.SessionKey)localObject, this);
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
        jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback.a(this);
      }
    }
  }
  
  public static void a(MsgProxyContainer.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback = paramCallback;
  }
  
  private BaseMsgProxy b(int paramInt)
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback.a(paramInt, this);
  }
  
  private void b()
  {
    jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback.b(this);
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      BaseMsgProxy localBaseMsgProxy = (BaseMsgProxy)localIterator.next();
      if (localBaseMsgProxy != null) {
        localBaseMsgProxy.init();
      }
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
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
    Object localObject2 = (BaseMsgProxy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = b(paramInt);
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" onCreateMsgProxy return null");
        QLog.e("Q.msg.BaseMsgProxyContainer", 1, "getMsgProxy: ", new IllegalStateException(((StringBuilder)localObject2).toString()));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject1);
    }
    return localObject1;
  }
  
  public MsgPool a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageMsgPool;
  }
  
  public BaseProxyManager a()
  {
    return this.proxyManager;
  }
  
  public AppRuntime a()
  {
    return this.app;
  }
  
  public void a()
  {
    if (this.b) {
      return;
    }
    try
    {
      if (this.b) {
        return;
      }
      a(40);
      this.b = true;
      return;
    }
    finally {}
  }
  
  public void destroy()
  {
    d();
  }
  
  public void init()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      c();
      a(15);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyContainer
 * JD-Core Version:    0.7.0.1
 */