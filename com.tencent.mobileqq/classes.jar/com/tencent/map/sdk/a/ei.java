package com.tencent.map.sdk.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class ei
{
  private final Map<Type, dp<?>> a;
  
  public ei(Map<Type, dp<?>> paramMap)
  {
    this.a = paramMap;
  }
  
  private <T> en<T> a(Class<? super T> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        paramClass.setAccessible(true);
      }
      paramClass = new ei.5(this, paramClass);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  public final <T> en<T> a(fd<T> paramfd)
  {
    Type localType = paramfd.b;
    Class localClass = paramfd.a;
    paramfd = (dp)this.a.get(localType);
    Object localObject;
    if (paramfd != null) {
      localObject = new ei.1(this, paramfd, localType);
    }
    do
    {
      return localObject;
      paramfd = (dp)this.a.get(localClass);
      if (paramfd != null) {
        return new ei.4(this, paramfd, localType);
      }
      paramfd = a(localClass);
      localObject = paramfd;
    } while (paramfd != null);
    if (Collection.class.isAssignableFrom(localClass)) {
      if (SortedSet.class.isAssignableFrom(localClass)) {
        paramfd = new ei.6(this);
      }
    }
    for (;;)
    {
      localObject = paramfd;
      if (paramfd != null) {
        break;
      }
      return new ei.3(this, localClass, localType);
      if (Set.class.isAssignableFrom(localClass))
      {
        paramfd = new ei.7(this);
      }
      else if (Queue.class.isAssignableFrom(localClass))
      {
        paramfd = new ei.8(this);
      }
      else
      {
        paramfd = new ei.9(this);
        continue;
        if (Map.class.isAssignableFrom(localClass))
        {
          if (SortedMap.class.isAssignableFrom(localClass)) {
            paramfd = new ei.10(this);
          } else if (((localType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(fd.a(((ParameterizedType)localType).getActualTypeArguments()[0]).a))) {
            paramfd = new ei.11(this);
          } else {
            paramfd = new ei.2(this);
          }
        }
        else {
          paramfd = null;
        }
      }
    }
  }
  
  public final String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ei
 * JD-Core Version:    0.7.0.1
 */