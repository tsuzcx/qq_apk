package com.eclipsesource.v8;

public class V8TypedArray
  extends V8Array
{
  private V8TypedArray(V8 paramV8)
  {
    super(paramV8);
  }
  
  public V8TypedArray(V8 paramV8, V8ArrayBuffer paramV8ArrayBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramV8, new V8TypedArray.V8ArrayData(paramV8ArrayBuffer, paramInt2, paramInt3, paramInt1));
  }
  
  private void checkArrayProperties(V8TypedArray.V8ArrayData paramV8ArrayData)
  {
    checkOffset(paramV8ArrayData);
    checkSize(paramV8ArrayData);
  }
  
  private void checkOffset(V8TypedArray.V8ArrayData paramV8ArrayData)
  {
    if (V8TypedArray.V8ArrayData.access$200(paramV8ArrayData) % getStructureSize(V8TypedArray.V8ArrayData.access$000(paramV8ArrayData)) == 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RangeError: Start offset of Int32Array must be a multiple of ");
    localStringBuilder.append(getStructureSize(V8TypedArray.V8ArrayData.access$000(paramV8ArrayData)));
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void checkSize(V8TypedArray.V8ArrayData paramV8ArrayData)
  {
    if (V8TypedArray.V8ArrayData.access$300(paramV8ArrayData) >= 0)
    {
      if (V8TypedArray.V8ArrayData.access$300(paramV8ArrayData) * getStructureSize(V8TypedArray.V8ArrayData.access$000(paramV8ArrayData)) + V8TypedArray.V8ArrayData.access$200(paramV8ArrayData) <= V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).limit()) {
        return;
      }
      throw new IllegalStateException("RangeError: Invalid typed array length");
    }
    throw new IllegalStateException("RangeError: Invalid typed array length");
  }
  
  private long createTypedArray(long paramLong, V8TypedArray.V8ArrayData paramV8ArrayData)
  {
    int i = V8TypedArray.V8ArrayData.access$000(paramV8ArrayData);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 9)
        {
          switch (i)
          {
          default: 
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Cannot create a typed array of type ");
            localStringBuilder.append(V8Value.getStringRepresentation(V8TypedArray.V8ArrayData.access$000(paramV8ArrayData)));
            throw new IllegalArgumentException(localStringBuilder.toString());
          case 16: 
            return this.v8.initNewV8Float32Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
          case 15: 
            return this.v8.initNewV8UInt32Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
          case 14: 
            return this.v8.initNewV8UInt16Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
          case 13: 
            return this.v8.initNewV8Int16Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
          case 12: 
            return this.v8.initNewV8UInt8ClampedArray(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
          }
          return this.v8.initNewV8UInt8Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
        }
        return this.v8.initNewV8Int8Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
      }
      return this.v8.initNewV8Float64Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
    }
    return this.v8.initNewV8Int32Array(paramLong, V8TypedArray.V8ArrayData.access$100(paramV8ArrayData).objectHandle, V8TypedArray.V8ArrayData.access$200(paramV8ArrayData), V8TypedArray.V8ArrayData.access$300(paramV8ArrayData));
  }
  
  public static int getStructureSize(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        if (paramInt == 9) {}
      }
      switch (paramInt)
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create a typed array of type ");
        localStringBuilder.append(V8Value.getStringRepresentation(paramInt));
        throw new IllegalArgumentException(localStringBuilder.toString());
      case 13: 
      case 14: 
        return 2;
      case 11: 
      case 12: 
        return 1;
        return 8;
      }
    }
    return 4;
  }
  
  protected V8Value createTwin()
  {
    this.v8.checkThread();
    checkReleased();
    return new V8TypedArray(this.v8);
  }
  
  public Object get(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    int i = getType();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 9)
        {
          switch (i)
          {
          default: 
            return null;
          case 16: 
            return Float.valueOf(((Number)super.get(paramInt)).floatValue());
          case 15: 
            return Long.valueOf(0xFFFFFFFF & ((Number)super.get(paramInt)).longValue());
          case 14: 
            return Integer.valueOf(((Integer)super.get(paramInt)).intValue() & 0xFFFF);
          case 13: 
            return Short.valueOf(((Number)super.get(paramInt)).shortValue());
          case 12: 
            return Short.valueOf((short)(((Number)super.get(paramInt)).byteValue() & 0xFF));
          }
          return Short.valueOf((short)(((Number)super.get(paramInt)).shortValue() & 0xFF));
        }
        return Byte.valueOf(((Number)super.get(paramInt)).byteValue());
      }
      return super.get(paramInt);
    }
    return super.get(paramInt);
  }
  
  public V8ArrayBuffer getBuffer()
  {
    return (V8ArrayBuffer)get("buffer");
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    this.v8.checkThread();
    if (paramObject == null)
    {
      super.initialize(paramLong, paramObject);
      return;
    }
    paramObject = (V8TypedArray.V8ArrayData)paramObject;
    checkArrayProperties(paramObject);
    paramLong = createTypedArray(paramLong, paramObject);
    this.released = false;
    addObjectReference(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.V8TypedArray
 * JD-Core Version:    0.7.0.1
 */