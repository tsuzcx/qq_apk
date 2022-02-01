package com.tencent.ilive.base.event;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Config;
import com.tencent.ilive.base.event.core.EventImpl;
import java.util.HashMap;
import java.util.Map;

public class EventManger
{
  private static EventManger sInstance = null;
  private Map<LifecycleOwner, EventImpl> eventMap = new HashMap();
  
  public static EventManger getInstance()
  {
    if (sInstance == null) {
      sInstance = new EventManger();
    }
    return sInstance;
  }
  
  public static void init()
  {
    LiveEventBus.config().autoClear(true).lifecycleObserverAlwaysActive(true);
  }
  
  public Map<LifecycleOwner, EventImpl> getEventMap()
  {
    return this.eventMap;
  }
  
  public void observe(LifecycleOwner paramLifecycleOwner, Observer paramObserver)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner)) {
      if (paramLifecycleOwner.getLifecycle() == null) {
        Log.e("EventManager", "lifecycleOwner.getLifecycle() == null");
      }
    }
    do
    {
      return;
      paramLifecycleOwner.getLifecycle().addObserver(new EventLifecycleObserver(paramLifecycleOwner, this));
      EventImpl localEventImpl = new EventImpl();
      localEventImpl.setHandler(new Handler(Looper.getMainLooper()));
      this.eventMap.put(paramLifecycleOwner, localEventImpl);
      paramLifecycleOwner = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    } while (paramLifecycleOwner == null);
    paramLifecycleOwner.register(paramObserver);
  }
  
  public void post(LifecycleOwner paramLifecycleOwner, Object paramObject)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner)) {}
    do
    {
      return;
      paramLifecycleOwner = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    } while (paramLifecycleOwner == null);
    paramLifecycleOwner.post(paramObject);
  }
  
  public void removeObserver(LifecycleOwner paramLifecycleOwner, Observer paramObserver)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner)) {}
    do
    {
      return;
      paramLifecycleOwner = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    } while (paramLifecycleOwner == null);
    paramLifecycleOwner.unregister(paramObserver);
  }
  
  public void removeObservers(LifecycleOwner paramLifecycleOwner)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner)) {}
    do
    {
      return;
      paramLifecycleOwner = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    } while (paramLifecycleOwner == null);
    paramLifecycleOwner.clear();
  }
  
  public void syncPost(LifecycleOwner paramLifecycleOwner, Object paramObject)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner)) {}
    do
    {
      return;
      paramLifecycleOwner = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    } while (paramLifecycleOwner == null);
    paramLifecycleOwner.syncPost(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.event.EventManger
 * JD-Core Version:    0.7.0.1
 */