package com.eclipsesource.mmv8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class V8ContextWrapper
  implements InvocationHandler
{
  private static final String TAG = "V8ContextWrapper";
  private final MultiContextV8 multiContextV8;
  private final V8Context proxy;
  private final V8ContextWrapper.V8ContextImpl v8ContextImpl;
  private final long v8ContextPtr;
  
  V8ContextWrapper(MultiContextV8 paramMultiContextV8, long paramLong)
  {
    this.multiContextV8 = paramMultiContextV8;
    this.v8ContextPtr = paramLong;
    enterContext();
    this.v8ContextImpl = new V8ContextWrapper.V8ContextImpl(this, paramLong);
    this.proxy = ((V8Context)Proxy.newProxyInstance(V8ContextWrapper.class.getClassLoader(), new Class[] { V8Context.class }, this));
  }
  
  private void enterContext()
  {
    this.multiContextV8.enterContext(this);
  }
  
  public V8Context context()
  {
    return this.proxy;
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
      paramObject = (V8ContextWrapper)paramObject;
      return this.v8ContextPtr == paramObject.v8ContextPtr;
    }
    return false;
  }
  
  protected long getPtr()
  {
    return this.v8ContextPtr;
  }
  
  public int hashCode()
  {
    long l = this.v8ContextPtr;
    return (int)(l ^ l >>> 32);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (!paramMethod.getName().equals("isReleased"))
    {
      this.v8ContextImpl.checkReleased();
      enterContext();
    }
    try
    {
      paramObject = paramMethod.invoke(this.v8ContextImpl, paramArrayOfObject);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw paramObject.getCause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8ContextWrapper
 * JD-Core Version:    0.7.0.1
 */