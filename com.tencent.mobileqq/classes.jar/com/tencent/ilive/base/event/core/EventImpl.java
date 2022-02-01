package com.tencent.ilive.base.event.core;

import android.os.Handler;
import androidx.lifecycle.Observer;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventImpl
{
  Handler handler;
  ConcurrentHashMap<Integer, ConcurrentLinkedQueue<Observer>> observers = new ConcurrentHashMap();
  
  public void clear()
  {
    this.observers.clear();
    this.handler.removeCallbacksAndMessages(null);
  }
  
  ConcurrentLinkedQueue<Observer> getQByHashcode(int paramInt)
  {
    if (this.observers.containsKey(Integer.valueOf(paramInt))) {
      return (ConcurrentLinkedQueue)this.observers.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public void post(Object paramObject)
  {
    if (paramObject != null)
    {
      post(getQByHashcode(paramObject.getClass().hashCode()), paramObject);
      return;
    }
    throw new RuntimeException("post obj is null!");
  }
  
  public void post(Object paramObject, Handler paramHandler)
  {
    if (paramObject != null)
    {
      Object localObject = getQByHashcode(paramObject.getClass().hashCode());
      if ((paramHandler != null) && (localObject != null)) {
        localObject = ((ConcurrentLinkedQueue)localObject).iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        paramHandler.post(new EventImpl.1(this, (Observer)((Iterator)localObject).next(), paramObject));
        continue;
        post((ConcurrentLinkedQueue)localObject, paramObject);
      }
      return;
    }
    paramObject = new RuntimeException("post obj is null!");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  void post(ConcurrentLinkedQueue<Observer> paramConcurrentLinkedQueue, Object paramObject)
  {
    if ((paramConcurrentLinkedQueue != null) && (this.handler != null))
    {
      paramConcurrentLinkedQueue = paramConcurrentLinkedQueue.iterator();
      while (paramConcurrentLinkedQueue.hasNext())
      {
        Observer localObserver = (Observer)paramConcurrentLinkedQueue.next();
        this.handler.post(new EventImpl.2(this, localObserver, paramObject));
      }
    }
  }
  
  public void register(Observer paramObserver)
  {
    if (paramObserver != null)
    {
      Object localObject = paramObserver.getClass().getGenericInterfaces();
      if ((localObject[0] instanceof ParameterizedType))
      {
        int i = ((ParameterizedType)localObject[0]).getActualTypeArguments()[0].hashCode();
        ConcurrentLinkedQueue localConcurrentLinkedQueue = getQByHashcode(i);
        localObject = localConcurrentLinkedQueue;
        if (localConcurrentLinkedQueue == null)
        {
          localObject = new ConcurrentLinkedQueue();
          this.observers.put(Integer.valueOf(i), localObject);
        }
        ((ConcurrentLinkedQueue)localObject).add(paramObserver);
      }
      return;
    }
    throw new RuntimeException("register event null!");
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  public void syncPost(Object paramObject)
  {
    if (paramObject != null)
    {
      Object localObject = getQByHashcode(paramObject.getClass().hashCode());
      if ((localObject != null) && (this.handler != null))
      {
        localObject = ((ConcurrentLinkedQueue)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Observer)((Iterator)localObject).next()).onChanged(paramObject);
        }
      }
      return;
    }
    paramObject = new RuntimeException("syncPost obj is null!");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public void unregister(Observer paramObserver)
  {
    Object localObject;
    int i;
    if (paramObserver != null)
    {
      localObject = paramObserver.getClass().getGenericInterfaces();
      if ((localObject[0] instanceof ParameterizedType))
      {
        i = ((ParameterizedType)localObject[0]).getActualTypeArguments()[0].hashCode();
        localObject = getQByHashcode(i);
        if (localObject == null) {}
      }
    }
    try
    {
      ((ConcurrentLinkedQueue)localObject).remove(paramObserver);
      if (((ConcurrentLinkedQueue)localObject).isEmpty()) {
        this.observers.remove(Integer.valueOf(i));
      }
      return;
    }
    catch (Exception paramObserver) {}
    throw new RuntimeException("remove event null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.base.event.core.EventImpl
 * JD-Core Version:    0.7.0.1
 */