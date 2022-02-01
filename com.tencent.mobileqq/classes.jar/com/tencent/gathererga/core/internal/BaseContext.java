package com.tencent.gathererga.core.internal;

import com.tencent.gathererga.core.internal.util.GLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseContext
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, WeakReference<Object>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Class<?>, Class<?>> b = new ConcurrentHashMap();
  
  protected abstract Object a(Class<?> paramClass, Object paramObject);
  
  public ConcurrentHashMap<Class<?>, Class<?>> a()
  {
    return this.b;
  }
  
  public <T> T b(Class<T> paramClass)
  {
    String str = paramClass.getName();
    ??? = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramClass.getName());
    if ((??? != null) && (((WeakReference)???).get() != null)) {
      return ((WeakReference)???).get();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
      {
        paramClass = ((WeakReference)localObject2).get();
        return paramClass;
      }
      localObject2 = (Class)this.b.get(paramClass);
      try
      {
        paramClass = a(paramClass, ((Class)localObject2).getConstructor(new Class[0]).newInstance(new Object[0]));
        localObject2 = new WeakReference(paramClass);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject2);
        return paramClass;
      }
      catch (Throwable paramClass)
      {
        label139:
        break label139;
      }
      throw new IllegalStateException(str);
    }
  }
  
  public <T> void b(Class<T> paramClass, Class<?> paramClass1)
  {
    if (this.b.putIfAbsent(paramClass, paramClass1) != null)
    {
      paramClass1 = new StringBuilder();
      paramClass1.append("BaseContext Overrides implementation: ");
      paramClass1.append(paramClass.getName());
      GLog.c(paramClass1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.BaseContext
 * JD-Core Version:    0.7.0.1
 */