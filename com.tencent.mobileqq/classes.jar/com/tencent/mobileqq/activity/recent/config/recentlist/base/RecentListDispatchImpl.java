package com.tencent.mobileqq.activity.recent.config.recentlist.base;

import com.tencent.mobileqq.activity.recent.config.IDispatch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentListDispatchImpl<T extends IRecentListBaseProcessor>
  implements IDispatch<IRecentListBaseProcessor>
{
  protected static final Object a;
  private static final String jdField_a_of_type_JavaLangString = RecentListDispatchImpl.class.getSimpleName();
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
    for (;;)
    {
      Class localClass;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "prepare call,sPrepared=", Boolean.valueOf(this.jdField_a_of_type_Boolean), " class=", getClass().getName() });
        }
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        Iterator localIterator = this.b.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localClass = (Class)localIterator.next();
      }
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.add((IRecentListBaseProcessor)localClass.newInstance());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "IllegalAccessException=", localIllegalAccessException);
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      catch (InstantiationException localInstantiationException) {}
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "InstantiationException=", localInstantiationException);
      }
    }
    this.b.clear();
    this.b = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void a(Class<? extends IRecentListBaseProcessor> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/mobileqq/activity/recent/config/recentlist/base/RecentListDispatchImpl:b	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 107	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 38	com/tencent/mobileqq/activity/recent/config/recentlist/base/RecentListDispatchImpl:b	Ljava/util/ArrayList;
    //   22: aload_1
    //   23: invokevirtual 93	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   26: pop
    //   27: goto -12 -> 15
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	RecentListDispatchImpl
    //   0	35	1	paramClass	Class<? extends IRecentListBaseProcessor>
    //   10	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	30	finally
    //   18	27	30	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListDispatchImpl
 * JD-Core Version:    0.7.0.1
 */