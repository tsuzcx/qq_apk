package com.eclipsesource.mmv8;

import java.util.Map;

public abstract class V8Value
  implements Releasable
{
  public static final int BOOLEAN = 3;
  public static final int BYTE = 9;
  public static final int DOUBLE = 2;
  public static final int FLOAT_32_ARRAY = 16;
  public static final int FLOAT_64_ARRAY = 2;
  public static final int INTEGER = 1;
  public static final int INT_16_ARRAY = 13;
  public static final int INT_32_ARRAY = 1;
  public static final int INT_8_ARRAY = 9;
  public static final int NULL = 0;
  public static final int STRING = 4;
  public static final int UNDEFINED = 99;
  public static final int UNKNOWN = 0;
  public static final int UNSIGNED_INT_16_ARRAY = 14;
  public static final int UNSIGNED_INT_32_ARRAY = 15;
  public static final int UNSIGNED_INT_8_ARRAY = 11;
  public static final int UNSIGNED_INT_8_CLAMPED_ARRAY = 12;
  public static final int V8_ARRAY = 5;
  public static final int V8_ARRAY_BUFFER = 10;
  public static final int V8_FUNCTION = 7;
  public static final int V8_OBJECT = 6;
  public static final int V8_TYPED_ARRAY = 8;
  protected long objectHandle;
  protected boolean released = true;
  protected V8 v8;
  
  protected V8Value() {}
  
  protected V8Value(V8 paramV8)
  {
    if (paramV8 == null)
    {
      this.v8 = ((V8)this);
      return;
    }
    this.v8 = paramV8;
  }
  
  @Deprecated
  public static String getStringRepresentaion(int paramInt)
  {
    return getStringRepresentation(paramInt);
  }
  
  public static String getStringRepresentation(int paramInt)
  {
    if (paramInt != 99)
    {
      switch (paramInt)
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid V8 type: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      case 16: 
        return "Float32Array";
      case 15: 
        return "UInt32Array";
      case 14: 
        return "UInt16Array";
      case 13: 
        return "Int16Array";
      case 12: 
        return "UInt8ClampedArray";
      case 11: 
        return "UInt8Array";
      case 10: 
        return "V8ArrayBuffer";
      case 9: 
        return "Byte";
      case 8: 
        return "V8TypedArray";
      case 7: 
        return "V8Function";
      case 6: 
        return "V8Object";
      case 5: 
        return "V8Array";
      case 4: 
        return "String";
      case 3: 
        return "Boolean";
      case 2: 
        return "Double";
      case 1: 
        return "Integer";
      }
      return "Null";
    }
    return "Undefined";
  }
  
  protected void addObjectReference(long paramLong)
  {
    this.objectHandle = paramLong;
    try
    {
      this.v8.addObjRef(this);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      release();
      throw localRuntimeException;
    }
    catch (Error localError)
    {
      release();
      throw localError;
    }
  }
  
  protected void checkReleased()
  {
    if (!this.released) {
      return;
    }
    throw new IllegalStateException("Object released");
  }
  
  protected abstract V8Value createTwin();
  
  public boolean equals(Object paramObject)
  {
    return strictEquals(paramObject);
  }
  
  protected long getHandle()
  {
    checkReleased();
    return this.objectHandle;
  }
  
  public V8 getRuntime()
  {
    return this.v8;
  }
  
  public int getV8Type()
  {
    if (isUndefined()) {
      return 99;
    }
    this.v8.checkThread();
    this.v8.checkReleased();
    V8 localV8 = this.v8;
    return localV8.getType(localV8.getV8RuntimePtr(), this.objectHandle);
  }
  
  public int hashCode()
  {
    this.v8.checkThread();
    checkReleased();
    V8 localV8 = this.v8;
    return localV8.identityHash(localV8.getV8RuntimePtr(), getHandle());
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    paramLong = this.v8.initNewV8Object(paramLong);
    this.released = false;
    addObjectReference(paramLong);
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  public boolean isUndefined()
  {
    return false;
  }
  
  public boolean isWeak()
  {
    this.v8.checkThread();
    this.v8.checkReleased();
    V8 localV8 = this.v8;
    return localV8.isWeak(localV8.getV8RuntimePtr(), getHandle());
  }
  
  public boolean jsEquals(Object paramObject)
  {
    this.v8.checkThread();
    checkReleased();
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof V8Value)) {
      return false;
    }
    if ((isUndefined()) && (((V8Value)paramObject).isUndefined())) {
      return true;
    }
    paramObject = (V8Value)paramObject;
    if (paramObject.isUndefined()) {
      return false;
    }
    V8 localV8 = this.v8;
    return localV8.equals(localV8.getV8RuntimePtr(), getHandle(), paramObject.getHandle());
  }
  
  public void release()
  {
    this.v8.checkThread();
    if (!this.released) {
      try
      {
        this.v8.releaseObjRef(this);
        V8 localV81;
        return;
      }
      finally
      {
        this.released = true;
        V8 localV82 = this.v8;
        localV82.release(localV82.getV8RuntimePtr(), this.objectHandle);
      }
    }
  }
  
  public V8Value setWeak()
  {
    this.v8.checkThread();
    this.v8.checkReleased();
    this.v8.v8WeakReferences.put(Long.valueOf(getHandle()), this);
    V8 localV8 = this.v8;
    localV8.setWeak(localV8.getV8RuntimePtr(), getHandle());
    return this;
  }
  
  public boolean strictEquals(Object paramObject)
  {
    this.v8.checkThread();
    checkReleased();
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof V8Value)) {
      return false;
    }
    if ((isUndefined()) && (((V8Value)paramObject).isUndefined())) {
      return true;
    }
    paramObject = (V8Value)paramObject;
    if (paramObject.isUndefined()) {
      return false;
    }
    V8 localV8 = this.v8;
    return localV8.strictEquals(localV8.getV8RuntimePtr(), getHandle(), paramObject.getHandle());
  }
  
  public V8Value twin()
  {
    if (isUndefined()) {
      return this;
    }
    this.v8.checkThread();
    this.v8.checkReleased();
    V8Value localV8Value = createTwin();
    this.v8.createTwin(this, localV8Value);
    return localV8Value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8Value
 * JD-Core Version:    0.7.0.1
 */