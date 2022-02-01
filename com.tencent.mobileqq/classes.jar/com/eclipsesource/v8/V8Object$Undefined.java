package com.eclipsesource.v8;

class V8Object$Undefined
  extends V8Object
{
  public V8Object add(String paramString, double paramDouble)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Object add(String paramString, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Object add(String paramString, V8Value paramV8Value)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Object add(String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Object add(String paramString, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Object addUndefined(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void close() {}
  
  public boolean contains(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof V8Object)) && (((V8Object)paramObject).isUndefined());
  }
  
  public V8Array executeArrayFunction(String paramString, V8Array paramV8Array)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean executeBooleanFunction(String paramString, V8Array paramV8Array)
  {
    throw new UnsupportedOperationException();
  }
  
  public double executeDoubleFunction(String paramString, V8Array paramV8Array)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object executeFunction(String paramString, V8Array paramV8Array)
  {
    throw new UnsupportedOperationException();
  }
  
  public int executeIntegerFunction(String paramString, V8Array paramV8Array)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object executeJSFunction(String paramString, Object... paramVarArgs)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Object executeObjectFunction(String paramString, V8Array paramV8Array)
  {
    throw new UnsupportedOperationException();
  }
  
  public String executeStringFunction(String paramString, V8Array paramV8Array)
  {
    throw new UnsupportedOperationException();
  }
  
  public void executeVoidFunction(String paramString, V8Array paramV8Array)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Array getArray(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean getBoolean(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public double getDouble(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public int getInteger(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String[] getKeys()
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Object getObject(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8 getRuntime()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getString(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public int getType(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public int hashCode()
  {
    return 919;
  }
  
  public boolean isReleased()
  {
    return false;
  }
  
  public boolean isUndefined()
  {
    return true;
  }
  
  public V8Object registerJavaMethod(JavaCallback paramJavaCallback, String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Object registerJavaMethod(JavaVoidCallback paramJavaVoidCallback, String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void release() {}
  
  public V8Object setPrototype(V8Object paramV8Object)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return "undefined";
  }
  
  public Undefined twin()
  {
    return (Undefined)super.twin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.V8Object.Undefined
 * JD-Core Version:    0.7.0.1
 */