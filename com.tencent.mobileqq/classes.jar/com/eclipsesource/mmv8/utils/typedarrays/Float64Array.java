package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class Float64Array
  extends TypedArray
{
  public Float64Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
  }
  
  public Float64Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public double get(int paramInt)
  {
    return this.buffer.asDoubleBuffer().get(paramInt);
  }
  
  public int getType()
  {
    return 2;
  }
  
  public int length()
  {
    return this.buffer.asDoubleBuffer().limit();
  }
  
  public void put(int paramInt, double paramDouble)
  {
    this.buffer.asDoubleBuffer().put(paramInt, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.Float64Array
 * JD-Core Version:    0.7.0.1
 */