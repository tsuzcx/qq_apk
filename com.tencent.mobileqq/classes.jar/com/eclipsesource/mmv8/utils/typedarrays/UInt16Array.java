package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class UInt16Array
  extends TypedArray
{
  public UInt16Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
  }
  
  public UInt16Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public int get(int paramInt)
  {
    return this.buffer.asShortBuffer().get(paramInt) & 0xFFFF;
  }
  
  public int getType()
  {
    return 14;
  }
  
  public int length()
  {
    return this.buffer.asShortBuffer().limit();
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    this.buffer.asShortBuffer().put(paramInt1, (short)(paramInt2 & 0xFFFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.UInt16Array
 * JD-Core Version:    0.7.0.1
 */