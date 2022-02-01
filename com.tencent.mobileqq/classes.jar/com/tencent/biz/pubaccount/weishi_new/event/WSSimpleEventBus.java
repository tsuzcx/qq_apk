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
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.a.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramWSSimpleEventReceiver.hashCode()), new WeakReference(paramWSSimpleEventReceiver));
    this.a.put(paramString, localConcurrentHashMap1);
    WSLog.b("WSSimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramWSSimpleEventReceiver.getClass().getSimpleName() + ":" + paramWSSimpleEventReceiver.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
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
    WSLog.b("WSSimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramWSSimpleEventReceiver.getClass().getSimpleName() + ":" + paramWSSimpleEventReceiver.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject = (ConcurrentHashMap)this.a.get(paramWSSimpleBaseEvent.getClass().getName());
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((WSSimpleEventReceiver)localWeakReference.get()).a(paramWSSimpleBaseEvent);
        }
      }
    }
  }
  
  public void a(WSSimpleEventReceiver paramWSSimpleEventReceiver)
  {
    if (paramWSSimpleEventReceiver == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramWSSimpleEventReceiver.a().iterator();
      while (localIterator.hasNext()) {
        a(((Class)localIterator.next()).getName(), paramWSSimpleEventReceiver);
      }
    }
  }
  
  public void b(WSSimpleEventReceiver paramWSSimpleEventReceiver)
  {
    if (paramWSSimpleEventReceiver == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramWSSimpleEventReceiver.a().iterator();
      while (localIterator.hasNext()) {
        b(((Class)localIterator.next()).getName(), paramWSSimpleEventReceiver);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus
 * JD-Core Version:    0.7.0.1
 */