package com.tencent.biz.richframework.eventbus;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleEventBus
{
  public static String ACTION_DRAFT_SYSTEM_CHANGE = "ACTION_DRAFT_SYSTEM_CHANGE";
  public static String ACTION_PRAISED_UPDATE;
  public static String IPC_SERVICE_MODULE_NAME;
  private static final SimpleEventBus OUR_INSTANCE = new SimpleEventBus();
  private static final String TAG = "SimpleEventBus";
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<SimpleEventReceiver>>> mEventCenter = new ConcurrentHashMap();
  private SimpleEventBusReceiver mSimpleEventBusReceiver;
  
  static
  {
    IPC_SERVICE_MODULE_NAME = "SUBSCRIBE_IPC_MODULE";
    ACTION_PRAISED_UPDATE = "ACTION_PRAISED_UPDATE";
  }
  
  private SimpleEventBus()
  {
    initBroadCastReceiver();
  }
  
  public static SimpleEventBus getInstance()
  {
    return OUR_INSTANCE;
  }
  
  private void initBroadCastReceiver()
  {
    if ((RFApplication.getApplication() != null) && (this.mSimpleEventBusReceiver == null))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("SimpleEventBusReceiver_DISPATCH_SIMPLE_BUS_EVENT");
      this.mSimpleEventBusReceiver = new SimpleEventBusReceiver();
      if (RFApplication.getApplication() != null)
      {
        RFApplication.getApplication().registerReceiver(this.mSimpleEventBusReceiver, localIntentFilter);
        return;
      }
      if (!RFApplication.isDebug()) {
        return;
      }
      throw new RuntimeException("please invoke RFApplication at your application onCreate Method");
    }
  }
  
  private void registerEachReceiver(String paramString, SimpleEventReceiver paramSimpleEventReceiver)
  {
    Object localObject2 = (ConcurrentHashMap)this.mEventCenter.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ConcurrentHashMap();
    }
    ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramSimpleEventReceiver.hashCode()), new WeakReference(paramSimpleEventReceiver));
    this.mEventCenter.put(paramString, localObject1);
    int i = RFLog.CLR;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("registerReceiver event Name:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(",key：[");
    ((StringBuilder)localObject2).append(paramSimpleEventReceiver.getClass().getSimpleName());
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(paramSimpleEventReceiver.hashCode());
    ((StringBuilder)localObject2).append("], subscribers size:");
    ((StringBuilder)localObject2).append(((ConcurrentHashMap)localObject1).size());
    RFLog.d("SimpleEventBus", i, ((StringBuilder)localObject2).toString());
  }
  
  private void unRegisterEachReceiver(String paramString, SimpleEventReceiver paramSimpleEventReceiver)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mEventCenter.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramSimpleEventReceiver.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.mEventCenter.remove(paramString);
    }
    int i = RFLog.CLR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unRegisterReceiver event Name:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",key：[");
    localStringBuilder.append(paramSimpleEventReceiver.getClass().getSimpleName());
    localStringBuilder.append(":");
    localStringBuilder.append(paramSimpleEventReceiver.hashCode());
    localStringBuilder.append("], subscribers size:");
    localStringBuilder.append(localConcurrentHashMap.size());
    RFLog.d("SimpleEventBus", i, localStringBuilder.toString());
  }
  
  public void dispatchEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    dispatchEvent(paramSimpleBaseEvent, false);
  }
  
  public void dispatchEvent(SimpleBaseEvent paramSimpleBaseEvent, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("SimpleEventBusReceiver_DISPATCH_SIMPLE_BUS_EVENT");
      ((Intent)localObject).putExtra("intent_key_dispatch_event", paramSimpleBaseEvent);
      if (RFApplication.getApplication() != null) {
        RFApplication.getApplication().sendBroadcast((Intent)localObject);
      }
    }
    else
    {
      localObject = (ConcurrentHashMap)this.mEventCenter.get(paramSimpleBaseEvent.getClass().getName());
      if (localObject == null) {
        return;
      }
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((SimpleEventReceiver)localWeakReference.get()).onReceiveEvent(paramSimpleBaseEvent);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if ((RFApplication.getApplication() != null) && (this.mSimpleEventBusReceiver != null)) {
      RFApplication.getApplication().unregisterReceiver(this.mSimpleEventBusReceiver);
    }
  }
  
  public void registerReceiver(SimpleEventReceiver paramSimpleEventReceiver)
  {
    if (paramSimpleEventReceiver != null)
    {
      Object localObject = paramSimpleEventReceiver.getEventClass();
      if (localObject == null) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        registerEachReceiver(((Class)((Iterator)localObject).next()).getName(), paramSimpleEventReceiver);
      }
    }
  }
  
  public void unRegisterReceiver(SimpleEventReceiver paramSimpleEventReceiver)
  {
    if (paramSimpleEventReceiver != null)
    {
      if (paramSimpleEventReceiver.getEventClass() == null) {
        return;
      }
      Iterator localIterator = paramSimpleEventReceiver.getEventClass().iterator();
      while (localIterator.hasNext()) {
        unRegisterEachReceiver(((Class)localIterator.next()).getName(), paramSimpleEventReceiver);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.eventbus.SimpleEventBus
 * JD-Core Version:    0.7.0.1
 */