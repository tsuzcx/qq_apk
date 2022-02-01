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
  private static int jdField_a_of_type_Int = 0;
  private static ObserverCenter jdField_a_of_type_ComTencentAvgameBusinessObserverObserverCenter;
  private static int jdField_b_of_type_Int = -1;
  private final WrapperHandler jdField_a_of_type_ComTencentAvgameBusinessObserverWrapperHandler = new WrapperHandler(Looper.getMainLooper());
  private final List<BusinessObserver> jdField_a_of_type_JavaUtilList = new ArrayList(4);
  private final WrapperHandler jdField_b_of_type_ComTencentAvgameBusinessObserverWrapperHandler = new WrapperHandler(ThreadManager.getSubThreadHandler());
  private final List<BusinessObserver> jdField_b_of_type_JavaUtilList = new ArrayList(4);
  
  public static ObserverCenter a()
  {
    if (jdField_a_of_type_ComTencentAvgameBusinessObserverObserverCenter == null) {
      try
      {
        jdField_a_of_type_ComTencentAvgameBusinessObserverObserverCenter = new ObserverCenter();
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvgameBusinessObserverObserverCenter;
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
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (paramInt == 2) {
      return this.jdField_b_of_type_JavaUtilList;
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
      a(paramClass, this.jdField_a_of_type_JavaUtilList, (List)localObject);
      return localObject;
    }
    if (paramInt == 0) {
      return null;
    }
    if (paramInt == 2)
    {
      localObject = new ArrayList();
      a(paramClass, this.jdField_b_of_type_JavaUtilList, (List)localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.i("ObserverCenter", 2, "clear");
    }
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
      ??? = this.jdField_b_of_type_JavaUtilList;
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
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
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, paramBoolean3, localBusinessObserver, this.jdField_a_of_type_ComTencentAvgameBusinessObserverWrapperHandler);
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
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, paramBoolean3, localBusinessObserver, this.jdField_b_of_type_ComTencentAvgameBusinessObserverWrapperHandler);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    try
    {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramBusinessObserver);
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
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