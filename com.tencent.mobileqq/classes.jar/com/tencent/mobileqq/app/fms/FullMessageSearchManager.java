package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import mqq.manager.Manager;

public class FullMessageSearchManager
  extends Observable
  implements Manager
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, SoftReference<FullMessageSearchTask>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public FullMessageSearchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private FullMessageSearchTask a(String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    FullMessageSearchTask localFullMessageSearchTask = null;
    try
    {
      Object localObject = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localObject != null) {
        localFullMessageSearchTask = (FullMessageSearchTask)((SoftReference)localObject).get();
      }
      localObject = localFullMessageSearchTask;
      if (localFullMessageSearchTask == null)
      {
        localObject = new FullMessageSearchTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new FullMessageSearchManager.1(this));
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject));
      }
      return localObject;
    }
    finally {}
  }
  
  public FullMessageSearchResult a(String paramString)
  {
    return a(paramString).b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("stopSearch ");
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilHashMap.size());
      QLog.d("Q.msg.FullMessageSearch", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (SoftReference)localIterator.next();
        if (localObject3 != null)
        {
          localObject3 = (FullMessageSearchTask)((SoftReference)localObject3).get();
          if (localObject3 != null) {
            ((FullMessageSearchTask)localObject3).b(2);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseSearch ");
      localStringBuilder.append(paramString);
      QLog.d("Q.msg.FullMessageSearch", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = null;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      SoftReference localSoftReference = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      paramString = localStringBuilder;
      if (localSoftReference != null) {
        paramString = (FullMessageSearchTask)localSoftReference.get();
      }
      if (paramString != null) {
        paramString.a();
      }
      return;
    }
  }
  
  public FullMessageSearchResult b(String paramString)
  {
    return a(paramString).c();
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.FullMessageSearchManager
 * JD-Core Version:    0.7.0.1
 */