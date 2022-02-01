package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ClassesInfoCache$MethodReference
{
  final int mCallType;
  final Method mMethod;
  
  ClassesInfoCache$MethodReference(int paramInt, Method paramMethod)
  {
    this.mCallType = paramInt;
    this.mMethod = paramMethod;
    this.mMethod.setAccessible(true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (MethodReference)paramObject;
      return (this.mCallType == paramObject.mCallType) && (this.mMethod.getName().equals(paramObject.mMethod.getName()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.mCallType * 31 + this.mMethod.getName().hashCode();
  }
  
  void invokeCallback(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, Object paramObject)
  {
    try
    {
      int i = this.mCallType;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          this.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner, paramEvent });
          return;
        }
        this.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner });
        return;
      }
      this.mMethod.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramLifecycleOwner)
    {
      throw new RuntimeException(paramLifecycleOwner);
    }
    catch (InvocationTargetException paramLifecycleOwner)
    {
      throw new RuntimeException("Failed to call observer method", paramLifecycleOwner.getCause());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.ClassesInfoCache.MethodReference
 * JD-Core Version:    0.7.0.1
 */