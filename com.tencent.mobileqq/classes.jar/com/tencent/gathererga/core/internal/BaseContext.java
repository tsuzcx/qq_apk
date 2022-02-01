package com.tencent.gathererga.core.internal;

import com.tencent.gathererga.core.internal.util.GLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseContext
{
  private Object a = new Object();
  private ConcurrentHashMap<String, WeakReference<Object>> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Class<?>, Class<?>> c = new ConcurrentHashMap();
  
  protected abstract Object a(Class<?> paramClass, Object paramObject);
  
  public <T> T b(Class<T> paramClass)
  {
    String str = paramClass.getName();
    ??? = (WeakReference)this.b.get(paramClass.getName());
    if ((??? != null) && (((WeakReference)???).get() != null)) {
      return ((WeakReference)???).get();
    }
    synchronized (this.a)
    {
      Object localObject2 = (WeakReference)this.b.get(str);
      if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
      {
        paramClass = ((WeakReference)localObject2).get();
        return paramClass;
      }
      localObject2 = (Class)this.c.get(paramClass);
      try
      {
        paramClass = a(paramClass, ((Class)localObject2).getConstructor(new Class[0]).newInstance(new Object[0]));
        localObject2 = new WeakReference(paramClass);
        this.b.put(str, localObject2);
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
  
  public ConcurrentHashMap<Class<?>, Class<?>> b()
  {
    return this.c;
  }
  
  public <T> void b(Class<T> paramClass, Class<?> paramClass1)
  {
    if (this.c.putIfAbsent(paramClass, paramClass1) != null)
    {
      paramClass1 = new StringBuilder();
      paramClass1.append("BaseContext Overrides implementation: ");
      paramClass1.append(paramClass.getName());
      GLog.c(paramClass1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.BaseContext
 * JD-Core Version:    0.7.0.1
 */