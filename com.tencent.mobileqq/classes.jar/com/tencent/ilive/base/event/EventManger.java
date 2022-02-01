package com.tencent.ilive.base.event;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ilive.base.event.core.EventImpl;
import java.util.HashMap;
import java.util.Map;

public class EventManger
{
  private static EventManger sInstance;
  private Map<LifecycleOwner, EventImpl> eventMap = new HashMap();
  
  public static EventManger getInstance()
  {
    if (sInstance == null) {
      sInstance = new EventManger();
    }
    return sInstance;
  }
  
  public Map<LifecycleOwner, EventImpl> getEventMap()
  {
    return this.eventMap;
  }
  
  public void observe(LifecycleOwner paramLifecycleOwner, Observer paramObserver)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner))
    {
      paramLifecycleOwner.getLifecycle();
      EventImpl localEventImpl = new EventImpl();
      localEventImpl.setHandler(new Handler(Looper.getMainLooper()));
      this.eventMap.put(paramLifecycleOwner, localEventImpl);
    }
    paramLifecycleOwner = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.register(paramObserver);
    }
  }
  
  public void post(LifecycleOwner paramLifecycleOwner, Object paramObject)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner)) {
      return;
    }
    paramLifecycleOwner = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.post(paramObject);
    }
  }
  
  public void removeObserver(LifecycleOwner paramLifecycleOwner, Observer paramObserver)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner)) {
      return;
    }
    paramLifecycleOwner = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.unregister(paramObserver);
    }
  }
  
  public void removeObservers(LifecycleOwner paramLifecycleOwner)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner)) {
      return;
    }
    EventImpl localEventImpl = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    if (localEventImpl != null) {
      localEventImpl.clear();
    }
    getEventMap().remove(paramLifecycleOwner);
  }
  
  public void syncPost(LifecycleOwner paramLifecycleOwner, Object paramObject)
  {
    if (!this.eventMap.containsKey(paramLifecycleOwner)) {
      return;
    }
    paramLifecycleOwner = (EventImpl)this.eventMap.get(paramLifecycleOwner);
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.syncPost(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.event.EventManger
 * JD-Core Version:    0.7.0.1
 */