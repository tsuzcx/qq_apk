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
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMsgProxyContainer", 2, "init listRecent=" + localList1.size());
    }
    long l2 = System.currentTimeMillis();
    int i = 0;
    int j = 0;
    int i1 = 0;
    for (;;)
    {
      int m = i;
      try
      {
        k = localList1.size();
        m = i;
        if (i1 < k)
        {
          if (i1 < paramInt) {
            break label176;
          }
          m = i;
        }
      }
      catch (Exception localException)
      {
        label102:
        MsgProxyContainer.SessionKey localSessionKey;
        List localList2;
        int n;
        break label102;
      }
      l2 = System.currentTimeMillis();
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_ProxyInitTime", l2 - l1 + "");
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_InitMsgNum", m + "");
      jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback.a(this);
      return;
      label176:
      m = i;
      localSessionKey = (MsgProxyContainer.SessionKey)localList1.get(i1);
      m = i;
      if (localSessionKey.a() == 6000)
      {
        k = i;
        i = j;
        j = k;
      }
      else
      {
        m = i;
        jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback.a(l1, localSessionKey, this);
        m = i;
        localList2 = a(localSessionKey.a, localSessionKey.a());
        n = j;
        k = i;
        if (localList2 != null)
        {
          m = i;
          k = i + localList2.size();
          n = j + 1;
        }
        m = k;
        QLog.d("Q.msg.BaseMsgProxyContainer", 1, new Object[] { "INIT cost: ", Long.valueOf(System.currentTimeMillis() - l2), " msgSize: ", Integer.valueOf(k), " convSize:", Integer.valueOf(n) });
        m = k;
        jdField_a_of_type_ComTencentImcoreMessageMsgProxyContainer$Callback.b(l1, localSessionKey, this);
        i = n;
        j = k;
      }
      i1 += 1;
      int k = j;
      j = i;
      i = k;
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
    BaseMsgProxy localBaseMsgProxy2 = (BaseMsgProxy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    BaseMsgProxy localBaseMsgProxy1 = localBaseMsgProxy2;
    if (localBaseMsgProxy2 == null)
    {
      localBaseMsgProxy1 = b(paramInt);
      if (localBaseMsgProxy1 == null) {
        QLog.e("Q.msg.BaseMsgProxyContainer", 1, "getMsgProxy: ", new IllegalStateException(paramInt + " onCreateMsgProxy return null"));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localBaseMsgProxy1);
    }
    return localBaseMsgProxy1;
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
    }
    finally {}
    a(40);
    this.b = true;
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
    }
    finally {}
    c();
    a(15);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyContainer
 * JD-Core Version:    0.7.0.1
 */