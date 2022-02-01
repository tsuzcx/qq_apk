package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class Int16Array
  extends TypedArray
{
  public Int16Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
  }
  
  public Int16Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public short get(int paramInt)
  {
    return this.buffer.asShortBuffer().get(paramInt);
  }
  
  public int getType()
  {
    return 13;
  }
  
  public int length()
  {
    return this.buffer.asShortBuffer().limit();
  }
  
  public void put(int paramInt, short paramShort)
  {
    this.buffer.asShortBuffer().put(paramInt, paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.Int16Array
 * JD-Core Version:    0.7.0.1
 */