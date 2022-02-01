package com.tencent.avgame.business.observer;

import android.os.Looper;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObserverCenter
{
  private static ObserverCenter a;
  private static int f = 0;
  private static int g = -1;
  private final List<BusinessObserver> b = new ArrayList(4);
  private final List<BusinessObserver> c = new ArrayList(4);
  private final WrapperHandler d = new WrapperHandler(Looper.getMainLooper());
  private final WrapperHandler e = new WrapperHandler(ThreadManager.getSubThreadHandler());
  
  public static ObserverCenter a()
  {
    if (a == null) {
      try
      {
        a = new ObserverCenter();
      }
      finally {}
    }
    return a;
  }
  
  private void a(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2, boolean paramBoolean3, BusinessObserver paramBusinessObserver, WrapperHandler paramWrapperHandler)
  {
    paramObject = new ObserverCenter.1(this, paramBusinessObserver, paramInt, paramWrapperHandler, paramBoolean1, paramObject);
    if (paramBoolean2)
    {
      paramWrapperHandler.a(paramObject, paramBoolean3);
      return;
    }
    paramWrapperHandler.b(paramObject, paramBoolean3);
  }
  
  private void a(Class<? extends BusinessObserver> paramClass, List<BusinessObserver> paramList1, List<BusinessObserver> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return;
      }
      try
      {
        Iterator localIterator = paramList1.iterator();
        while (localIterator.hasNext())
        {
          BusinessObserver localBusinessObserver = (BusinessObserver)localIterator.next();
          if ((paramClass != null) && (paramClass.isAssignableFrom(localBusinessObserver.getClass()))) {
            paramList2.add(localBusinessObserver);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public List<BusinessObserver> a(int paramInt)
  {
    if (paramInt == 1) {
      return this.b;
    }
    if (paramInt == 2) {
      return this.c;
    }
    return null;
  }
  
  public List<BusinessObserver> a(Class<? extends BusinessObserver> paramClass, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBusinessObserver, cls[");
      ((StringBuilder)localObject).append(paramClass);
      ((StringBuilder)localObject).append("], flag[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("ObserverCenter", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    if (paramClass == null) {
      return null;
    }
    if (paramInt == 1)
    {
      localObject = new ArrayList();
      a(paramClass, this.b, (List)localObject);
      return localObject;
    }
    if (paramInt == 0) {
      return null;
    }
    if (paramInt == 2)
    {
      localObject = new ArrayList();
      a(paramClass, this.c, (List)localObject);
    }
    return localObject;
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    a(paramBusinessObserver, true);
  }
  
  public void a(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    if (paramBoolean) {
      ??? = this.c;
    }
    try
    {
      synchronized (this.b)
      {
        if (!???.contains(paramBusinessObserver)) {
          ???.add(paramBusinessObserver);
        }
        return;
      }
      return;
    }
    catch (Throwable paramBusinessObserver)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ObserverCenter", 4, "addObserver", paramBusinessObserver);
      }
    }
  }
  
  public final void a(Class<? extends BusinessObserver> paramClass, int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramClass, paramInt, paramBoolean, paramObject, false, false);
  }
  
  public void a(Class<? extends BusinessObserver> paramClass, int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2, boolean paramBoolean3)
  {
    List localList = a(paramClass, 1);
    Iterator localIterator;
    BusinessObserver localBusinessObserver;
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localBusinessObserver = (BusinessObserver)localIterator.next();
          if ((paramClass != null) && (paramClass.isAssignableFrom(localBusinessObserver.getClass()))) {
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, paramBoolean3, localBusinessObserver, this.d);
          }
        }
      }
      finally {}
    }
    localList = a(paramClass, 2);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localBusinessObserver = (BusinessObserver)localIterator.next();
          if ((paramClass != null) && (paramClass.isAssignableFrom(localBusinessObserver.getClass()))) {
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, paramBoolean3, localBusinessObserver, this.e);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void b()
  {
    this.b.clear();
    this.c.clear();
    if (QLog.isColorLevel()) {
      QLog.i("ObserverCenter", 2, "clear");
    }
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    try
    {
      synchronized (this.c)
      {
        this.c.remove(paramBusinessObserver);
        synchronized (this.b)
        {
          this.b.remove(paramBusinessObserver);
          return;
        }
      }
      return;
    }
    catch (Throwable paramBusinessObserver)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ObserverCenter", 4, "addObserver", paramBusinessObserver);
      }
    }
  }
  
  public final void b(Class<? extends BusinessObserver> paramClass, int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramClass, paramInt, paramBoolean, paramObject, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.observer.ObserverCenter
 * JD-Core Version:    0.7.0.1
 */