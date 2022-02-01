package com.tencent.imcore.message.basic;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassGeneratorImpl<T>
  implements ClassGenerator<T>
{
  private List<Class<? extends T>> a = new ArrayList();
  private List<T> b = new ArrayList();
  
  private T b(Class<? extends T> paramClass)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject.getClass().equals(paramClass)) {
        return localObject;
      }
    }
    return null;
  }
  
  private T c(Class<? extends T> paramClass)
  {
    try
    {
      paramClass = paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      QLog.e("ClassGeneratorImpl", 1, paramClass, new Object[0]);
    }
    return null;
  }
  
  public List<T> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Class)localIterator.next();
        Object localObject3 = b((Class)localObject2);
        if (localObject3 != null)
        {
          localArrayList.add(localObject3);
        }
        else
        {
          localObject2 = c((Class)localObject2);
          if (localObject2 != null)
          {
            this.b.add(localObject2);
            localArrayList.add(localObject2);
          }
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void a(Class<? extends T> paramClass)
  {
    if (paramClass != null) {}
    try
    {
      if (!this.a.contains(paramClass)) {
        this.a.add(paramClass);
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.basic.ClassGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */