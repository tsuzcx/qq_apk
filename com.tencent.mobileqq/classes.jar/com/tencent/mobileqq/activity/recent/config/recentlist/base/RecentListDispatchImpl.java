package com.tencent.mobileqq.activity.recent.config.recentlist.base;

import com.tencent.mobileqq.activity.recent.config.IDispatch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentListDispatchImpl<T extends IRecentListBaseProcessor>
  implements IDispatch<IRecentListBaseProcessor>
{
  protected static final Object a = new Object();
  private static final String c = "RecentListDispatchImpl";
  protected ArrayList<T> b = new ArrayList();
  private ArrayList<Class<? extends IRecentListBaseProcessor>> d = new ArrayList();
  private boolean e;
  
  public void a()
  {
    synchronized (a)
    {
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, new Object[] { "prepare call,sPrepared=", Boolean.valueOf(this.e), " class=", getClass().getName() });
      }
      if (this.e) {
        return;
      }
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        try
        {
          this.b.add((IRecentListBaseProcessor)localClass.newInstance());
        }
        catch (InstantiationException localInstantiationException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(c, 2, "InstantiationException=", localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException) {}
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "IllegalAccessException=", localIllegalAccessException);
        }
      }
      this.d.clear();
      this.d = null;
      this.e = true;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(Class<? extends IRecentListBaseProcessor> paramClass)
  {
    try
    {
      boolean bool = this.d.contains(paramClass);
      if (bool) {
        return;
      }
      this.d.add(paramClass);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListDispatchImpl
 * JD-Core Version:    0.7.0.1
 */