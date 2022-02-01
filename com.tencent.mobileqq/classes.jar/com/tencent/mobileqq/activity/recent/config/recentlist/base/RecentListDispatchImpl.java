package com.tencent.mobileqq.activity.recent.config.recentlist.base;

import com.tencent.mobileqq.activity.recent.config.IDispatch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentListDispatchImpl<T extends IRecentListBaseProcessor>
  implements IDispatch<IRecentListBaseProcessor>
{
  protected static final Object a;
  private static final String jdField_a_of_type_JavaLangString = "RecentListDispatchImpl";
  protected ArrayList<T> a;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList<Class<? extends IRecentListBaseProcessor>> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public RecentListDispatchImpl()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "prepare call,sPrepared=", Boolean.valueOf(this.jdField_a_of_type_Boolean), " class=", getClass().getName() });
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        try
        {
          this.jdField_a_of_type_JavaUtilArrayList.add((IRecentListBaseProcessor)localClass.newInstance());
        }
        catch (InstantiationException localInstantiationException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "InstantiationException=", localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException) {}
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "IllegalAccessException=", localIllegalAccessException);
        }
      }
      this.b.clear();
      this.b = null;
      this.jdField_a_of_type_Boolean = true;
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
      boolean bool = this.b.contains(paramClass);
      if (bool) {
        return;
      }
      this.b.add(paramClass);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListDispatchImpl
 * JD-Core Version:    0.7.0.1
 */