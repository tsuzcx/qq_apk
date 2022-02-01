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
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (MethodReference)paramObject;
    } while ((this.mCallType == paramObject.mCallType) && (this.mMethod.getName().equals(paramObject.mMethod.getName())));
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
      switch (this.mCallType)
      {
      case 2: 
        this.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner, paramEvent });
        return;
      }
    }
    catch (InvocationTargetException paramLifecycleOwner)
    {
      throw new RuntimeException("Failed to call observer method", paramLifecycleOwner.getCause());
      this.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner });
      return;
    }
    catch (IllegalAccessException paramLifecycleOwner)
    {
      throw new RuntimeException(paramLifecycleOwner);
    }
    this.mMethod.invoke(paramObject, new Object[0]);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.arch.lifecycle.ClassesInfoCache.MethodReference
 * JD-Core Version:    0.7.0.1
 */