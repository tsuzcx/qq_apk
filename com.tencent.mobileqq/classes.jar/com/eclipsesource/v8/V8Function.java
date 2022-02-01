package com.eclipsesource.v8;

public class V8Function
  extends V8Object
{
  protected V8Function(V8 paramV8)
  {
    this(paramV8, null);
  }
  
  public V8Function(V8 paramV8, JavaCallback paramJavaCallback)
  {
    super(paramV8, paramJavaCallback);
  }
  
  public Object call(V8Object paramV8Object, V8Array paramV8Array)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Object);
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Object == null) {
      paramV8Object = this.v8;
    }
    long l1;
    if (paramV8Array == null) {
      l1 = 0L;
    } else {
      l1 = paramV8Array.getHandle();
    }
    long l2;
    if (paramV8Object.isUndefined()) {
      l2 = this.v8.getHandle();
    } else {
      l2 = paramV8Object.getHandle();
    }
    return this.v8.executeFunction(this.v8.getV8RuntimePtr(), l2, this.objectHandle, l1);
  }
  
  protected V8Value createTwin()
  {
    return new V8Function(this.v8);
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    if (paramObject == null)
    {
      super.initialize(paramLong, null);
      return;
    }
    paramObject = (JavaCallback)paramObject;
    long[] arrayOfLong = this.v8.initNewV8Function(paramLong);
    this.v8.createAndRegisterMethodDescriptor(paramObject, arrayOfLong[1]);
    this.released = false;
    addObjectReference(arrayOfLong[0]);
  }
  
  public String toString()
  {
    if ((!this.released) && (!this.v8.isReleased())) {
      return super.toString();
    }
    return "[Function released]";
  }
  
  public V8Function twin()
  {
    return (V8Function)super.twin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.V8Function
 * JD-Core Version:    0.7.0.1
 */