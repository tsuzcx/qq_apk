package com.tencent.biz.pubaccount.readinjoy.viewmodels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable<T>
{
  private T jdField_a_of_type_JavaLangObject;
  private List<Observer<T>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public Observable(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((Observer)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void a(Observer<T> paramObserver)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramObserver);
      }
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
  }
  
  public void b(Observer<T> paramObserver)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramObserver);
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viewmodels.Observable
 * JD-Core Version:    0.7.0.1
 */