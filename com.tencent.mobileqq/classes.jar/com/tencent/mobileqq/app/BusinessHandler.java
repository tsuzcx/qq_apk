package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public abstract class BusinessHandler
  extends BaseBusinessHandler
{
  public static final int BG_OBSERVERS = 2;
  public static final int DEFAULT_OBSERVER = 0;
  private static final String TAG = "BusinessHandler";
  public static final int UI_OBSERVERS = 1;
  private static MqqHandler bgHandler = ThreadManager.getSubThreadHandler();
  private static MqqHandler uiHandler = new MqqHandler(Looper.getMainLooper());
  
  protected BusinessHandler(AppInterface paramAppInterface)
  {
    this.appRuntime = paramAppInterface;
  }
  
  private void dispatchMessage(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2, BusinessObserver paramBusinessObserver, MqqHandler paramMqqHandler)
  {
    paramObject = new BusinessHandler.1(this, paramBusinessObserver, paramInt, paramBoolean1, paramObject);
    if (paramBoolean2)
    {
      paramMqqHandler.postAtFrontOfQueue(paramObject);
      return;
    }
    paramMqqHandler.post(paramObject);
  }
  
  public Set<String> getCommandList()
  {
    return null;
  }
  
  public List<BusinessObserver> getObservers(int paramInt)
  {
    return this.appRuntime.getBusinessObserver(paramInt);
  }
  
  public Set<String> getPushCommandList()
  {
    return null;
  }
  
  public Set<String> getPushPBCommandList()
  {
    return null;
  }
  
  protected boolean isAssignableFrom(BusinessObserver paramBusinessObserver)
  {
    Class localClass = observerClass();
    if (localClass == null) {
      return false;
    }
    if ((paramBusinessObserver instanceof QQLifecycleBusinessObserver)) {
      return localClass.isAssignableFrom(((QQLifecycleBusinessObserver)paramBusinessObserver).getBusinessObserverClass());
    }
    return localClass.isAssignableFrom(paramBusinessObserver.getClass());
  }
  
  public final void notifyUI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramInt, paramBoolean, paramObject, false);
  }
  
  public void notifyUI(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    List localList = getObservers(0);
    Iterator localIterator;
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (BusinessObserver)localIterator.next();
          boolean bool = isAssignableFrom((BusinessObserver)localObject);
          if (bool)
          {
            try
            {
              long l = System.currentTimeMillis();
              ((BusinessObserver)localObject).onUpdate(paramInt, paramBoolean1, paramObject);
              l = System.currentTimeMillis() - l;
              if ((l <= 100L) || (!QLog.isColorLevel())) {
                continue;
              }
              localObject = new Exception("run too long!");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("defaultObserver onUpdate cost:");
              localStringBuilder.append(l);
              QLog.d("BusinessHandler", 2, localStringBuilder.toString(), (Throwable)localObject);
            }
            catch (Exception localException) {}
            if (QLog.isColorLevel()) {
              QLog.e("BusinessHandler", 2, "onUpdate fail", localException);
            }
          }
        }
      }
      finally {}
    }
    localList = getObservers(1);
    BusinessObserver localBusinessObserver;
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localBusinessObserver = (BusinessObserver)localIterator.next();
          if (isAssignableFrom(localBusinessObserver)) {
            dispatchMessage(paramInt, paramBoolean1, paramObject, paramBoolean2, localBusinessObserver, uiHandler);
          }
        }
      }
      finally {}
    }
    localList = getObservers(2);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localBusinessObserver = (BusinessObserver)localIterator.next();
          if (isAssignableFrom(localBusinessObserver)) {
            dispatchMessage(paramInt, paramBoolean1, paramObject, paramBoolean2, localBusinessObserver, bgHandler);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void notifyUI(ToServiceMsg arg1, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (???.extraData.containsKey(SEQ_KEY))
    {
      long l = ???.extraData.getLong(SEQ_KEY);
      synchronized (this.uiObserverMap)
      {
        ??? = (BusinessObserver)this.uiObserverMap.remove(Long.valueOf(l));
        MqqHandler localMqqHandler = uiHandler;
        ??? = (ToServiceMsg)???;
        if (??? == null) {
          synchronized (this.bgObserverMap)
          {
            ??? = (BusinessObserver)this.bgObserverMap.remove(Long.valueOf(l));
            localMqqHandler = bgHandler;
          }
        }
        if (??? != null)
        {
          dispatchMessage(paramInt, paramBoolean, paramObject, false, ???, localMqqHandler);
          return;
        }
      }
    }
    notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  protected abstract Class<? extends BusinessObserver> observerClass();
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessHandler
 * JD-Core Version:    0.7.0.1
 */