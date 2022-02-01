package com.tencent.biz.richframework.eventbus;

import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleEventBus
{
  public static String ACTION_DRAFT_SYSTEM_CHANGE = "ACTION_DRAFT_SYSTEM_CHANGE";
  public static String ACTION_PRAISED_UPDATE;
  public static String IPC_SERVICE_MODULE_NAME;
  private static final SimpleEventBus OUR_INSTANCE = new SimpleEventBus();
  private static final String TAG = "SimpleEventBus";
  private WeakReference<NativePlugin.JSContext> mCurrentJsContext;
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<SimpleEventReceiver>>> mEventCenter = new ConcurrentHashMap();
  
  static
  {
    IPC_SERVICE_MODULE_NAME = "SUBSCRIBE_IPC_MODULE";
    ACTION_PRAISED_UPDATE = "ACTION_PRAISED_UPDATE";
  }
  
  private SimpleEventBus()
  {
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      if (i != 0) {
        QIPCServerHelper.getInstance().register(new SimpleEventBus.1(this, "SUBSCRIBE_IPC_MODULE"));
      }
      return;
      i = 0;
    }
  }
  
  public static SimpleEventBus getInstance()
  {
    return OUR_INSTANCE;
  }
  
  private void interceptBaseEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.mCurrentJsContext != null) && (this.mCurrentJsContext.get() != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents))) {
      notifyMiniProgram((PraisedUpdateEvents)paramSimpleBaseEvent);
    }
  }
  
  private void notifyMiniProgram(PraisedUpdateEvents paramPraisedUpdateEvents)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedid", paramPraisedUpdateEvents.mTargetFeedId);
      localJSONObject.put("likestatus", paramPraisedUpdateEvents.mPraisedStatus);
      paramPraisedUpdateEvents = new JSONObject();
      paramPraisedUpdateEvents.put("data", localJSONObject);
      ((NativePlugin.JSContext)this.mCurrentJsContext.get()).callJs("onSubscribeDoLikeUpdateEvent", paramPraisedUpdateEvents);
      QLog.d("SimpleEventBus", 2, "notifyMiniProgram onSubscribeDoLikeUpdateEvent success ");
      return;
    }
    catch (JSONException paramPraisedUpdateEvents)
    {
      paramPraisedUpdateEvents.printStackTrace();
    }
  }
  
  private void registerEachReceiver(String paramString, SimpleEventReceiver paramSimpleEventReceiver)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.mEventCenter.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramSimpleEventReceiver.hashCode()), new WeakReference(paramSimpleEventReceiver));
    this.mEventCenter.put(paramString, localConcurrentHashMap1);
    QLog.d("SimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramSimpleEventReceiver.getClass().getSimpleName() + ":" + paramSimpleEventReceiver.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
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
    QLog.d("SimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramSimpleEventReceiver.getClass().getSimpleName() + ":" + paramSimpleEventReceiver.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
  }
  
  public void dispatchEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    Object localObject = (ConcurrentHashMap)this.mEventCenter.get(paramSimpleBaseEvent.getClass().getName());
    if (localObject == null) {}
    for (;;)
    {
      return;
      interceptBaseEvent(paramSimpleBaseEvent);
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
  
  public void registerCurrentJsContext(NativePlugin.JSContext paramJSContext)
  {
    this.mCurrentJsContext = new WeakReference(paramJSContext);
  }
  
  public void registerReceiver(SimpleEventReceiver paramSimpleEventReceiver)
  {
    Object localObject;
    if (paramSimpleEventReceiver != null)
    {
      localObject = paramSimpleEventReceiver.getEventClass();
      if (localObject != null) {
        break label16;
      }
    }
    for (;;)
    {
      return;
      label16:
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        registerEachReceiver(((Class)((Iterator)localObject).next()).getName(), paramSimpleEventReceiver);
      }
    }
  }
  
  public void unRegisterReceiver(SimpleEventReceiver paramSimpleEventReceiver)
  {
    if ((paramSimpleEventReceiver == null) || (paramSimpleEventReceiver.getEventClass() == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramSimpleEventReceiver.getEventClass().iterator();
      while (localIterator.hasNext()) {
        unRegisterEachReceiver(((Class)localIterator.next()).getName(), paramSimpleEventReceiver);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.eventbus.SimpleEventBus
 * JD-Core Version:    0.7.0.1
 */