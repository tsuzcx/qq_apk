package com.tencent.biz.pubaccount.weishi_new.event;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class WSSimpleEventBus
{
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<WSSimpleEventReceiver>>> a = new ConcurrentHashMap();
  
  public static WSSimpleEventBus a()
  {
    return WSSimpleEventBus.SingletonHolder.a();
  }
  
  private void a(String paramString, WSSimpleEventReceiver paramWSSimpleEventReceiver)
  {
    Object localObject2 = (ConcurrentHashMap)this.a.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ConcurrentHashMap();
    }
    ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramWSSimpleEventReceiver.hashCode()), new WeakReference(paramWSSimpleEventReceiver));
    this.a.put(paramString, localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("registerReceiver event Name:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(",key：[");
    ((StringBuilder)localObject2).append(paramWSSimpleEventReceiver.getClass().getSimpleName());
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(paramWSSimpleEventReceiver.hashCode());
    ((StringBuilder)localObject2).append("], subscribers size:");
    ((StringBuilder)localObject2).append(((ConcurrentHashMap)localObject1).size());
    WSLog.b("WSSimpleEventBus", 2, ((StringBuilder)localObject2).toString());
  }
  
  private void b(String paramString, WSSimpleEventReceiver paramWSSimpleEventReceiver)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.a.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramWSSimpleEventReceiver.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.a.remove(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unRegisterReceiver event Name:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",key：[");
    localStringBuilder.append(paramWSSimpleEventReceiver.getClass().getSimpleName());
    localStringBuilder.append(":");
    localStringBuilder.append(paramWSSimpleEventReceiver.hashCode());
    localStringBuilder.append("], subscribers size:");
    localStringBuilder.append(localConcurrentHashMap.size());
    WSLog.b("WSSimpleEventBus", 2, localStringBuilder.toString());
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject = (ConcurrentHashMap)this.a.get(paramWSSimpleBaseEvent.getClass().getName());
    if (localObject == null) {
      return;
    }
    localObject = ((ConcurrentHashMap)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((WSSimpleEventReceiver)localWeakReference.get()).a(paramWSSimpleBaseEvent);
      }
    }
  }
  
  public void a(WSSimpleEventReceiver paramWSSimpleEventReceiver)
  {
    if (paramWSSimpleEventReceiver == null) {
      return;
    }
    Iterator localIterator = paramWSSimpleEventReceiver.a().iterator();
    while (localIterator.hasNext()) {
      a(((Class)localIterator.next()).getName(), paramWSSimpleEventReceiver);
    }
  }
  
  public void b(WSSimpleEventReceiver paramWSSimpleEventReceiver)
  {
    if (paramWSSimpleEventReceiver == null) {
      return;
    }
    Iterator localIterator = paramWSSimpleEventReceiver.a().iterator();
    while (localIterator.hasNext()) {
      b(((Class)localIterator.next()).getName(), paramWSSimpleEventReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus
 * JD-Core Version:    0.7.0.1
 */