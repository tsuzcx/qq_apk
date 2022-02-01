package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class DataProvider<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<DataProvider.DataUpdateListener<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DataProvider.class.getName();
  }
  
  public DataProvider()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  public DATA a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(@NonNull DataProvider.DataUpdateListener<DATA> paramDataUpdateListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramDataUpdateListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramDataUpdateListener);
    }
  }
  
  protected abstract void a(BasicLocation paramBasicLocation);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((DataProvider.DataUpdateListener)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    SLog.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull DataProvider.DataUpdateListener<DATA> paramDataUpdateListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramDataUpdateListener)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramDataUpdateListener);
    }
  }
  
  public void b(BasicLocation paramBasicLocation)
  {
    a(paramBasicLocation);
  }
  
  public void c()
  {
    SLog.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DataProvider
 * JD-Core Version:    0.7.0.1
 */