package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Int32Array
  extends TypedArray
{
  public Int32Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
  }
  
  public Int32Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public int get(int paramInt)
  {
    return this.buffer.asIntBuffer().get(paramInt);
  }
  
  public int getType()
  {
    return 1;
  }
  
  public int length()
  {
    return this.buffer.asIntBuffer().limit();
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    this.buffer.asIntBuffer().put(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.Int32Array
 * JD-Core Version:    0.7.0.1
 */