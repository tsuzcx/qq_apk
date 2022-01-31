package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class DataProvider
{
  public static final String a;
  public Object a;
  protected List a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DataProvider.class.getName();
  }
  
  public DataProvider()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  protected abstract void a();
  
  public void a(@NonNull DataProvider.DataUpdateListener paramDataUpdateListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramDataUpdateListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramDataUpdateListener);
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((DataProvider.DataUpdateListener)localIterator.next()).a(paramBoolean, paramObject);
    }
  }
  
  public void b()
  {
    a();
  }
  
  public void b(@NonNull DataProvider.DataUpdateListener paramDataUpdateListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramDataUpdateListener)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramDataUpdateListener);
    }
  }
  
  public void c()
  {
    SLog.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void d()
  {
    SLog.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DataProvider
 * JD-Core Version:    0.7.0.1
 */