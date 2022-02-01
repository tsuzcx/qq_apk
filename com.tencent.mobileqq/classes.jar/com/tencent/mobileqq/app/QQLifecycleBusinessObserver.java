package com.tencent.mobileqq.app;

import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

public class QQLifecycleBusinessObserver
  implements BusinessObserver
{
  public static final int ON_INIT = 0;
  public static final int ON_REMOVE = -1;
  public static final String TAG = "QQLifecycleBusinessObserver";
  private BusinessObserver businessObserver;
  public AtomicInteger lifeState = new AtomicInteger(0);
  
  public QQLifecycleBusinessObserver(@NotNull BusinessObserver paramBusinessObserver)
  {
    this.businessObserver = paramBusinessObserver;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (QQLifecycleBusinessObserver)paramObject;
      return this.businessObserver.equals(paramObject.businessObserver);
    }
    return false;
  }
  
  public Class<?> getBusinessObserverClass()
  {
    return this.businessObserver.getClass();
  }
  
  public int hashCode()
  {
    return this.businessObserver.hashCode();
  }
  
  public void markObserverRemove()
  {
    this.lifeState.set(-1);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.lifeState.compareAndSet(-1, -1)) {
      return;
    }
    this.businessObserver.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQLifecycleBusinessObserver
 * JD-Core Version:    0.7.0.1
 */