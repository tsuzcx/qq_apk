package com.tencent.mobileqq.activity.recent.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class RecentDispatchImpl<T extends IRecentBaseDataProcessor>
  implements IRecentDispatch<IRecentBaseDataProcessor>
{
  protected ArrayList<T> a = new ArrayList(8);
  protected ArrayList<Class<? extends IRecentBaseDataProcessor>> b = new ArrayList();
  private AtomicBoolean c = new AtomicBoolean(false);
  
  public void a() {}
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    b();
    Iterator localIterator = this.a.iterator();
    while ((localIterator.hasNext()) && (!((IRecentBaseDataProcessor)localIterator.next()).a(paramBaseQQAppInterface, paramRecentBaseData))) {}
  }
  
  protected void a(@NonNull T paramT)
  {
    try
    {
      this.a.add(paramT);
      Collections.sort(this.a);
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public void a(Class<? extends IRecentBaseDataProcessor> paramClass)
  {
    try
    {
      boolean bool = this.b.contains(paramClass);
      if (bool) {
        return;
      }
      this.b.add(paramClass);
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentDispatchImpl", 2, new Object[] { "prepare call,sPrepared=", Boolean.valueOf(this.c.get()), " class=", getClass().getName() });
      }
      boolean bool = this.c.get();
      if (bool) {
        return;
      }
      a();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        try
        {
          a((IRecentBaseDataProcessor)localClass.newInstance());
        }
        catch (InstantiationException localInstantiationException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RecentDispatchImpl", 2, "InstantiationException=", localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException) {}
        if (QLog.isColorLevel()) {
          QLog.d("RecentDispatchImpl", 2, "IllegalAccessException=", localIllegalAccessException);
        }
      }
      this.c.set(true);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.RecentDispatchImpl
 * JD-Core Version:    0.7.0.1
 */