package com.eclipsesource.mmv8.utils.typedarrays;

import com.eclipsesource.mmv8.V8TypedArray;
import java.nio.ByteBuffer;

public abstract class TypedArray
{
  protected ByteBuffer buffer;
  
  protected TypedArray(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isDirect())
    {
      if (paramByteBuffer.limit() % V8TypedArray.getStructureSize(getType()) == 0)
      {
        this.buffer = paramByteBuffer;
        return;
      }
      throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }
    throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
  }
  
  public ByteBuffer getByteBuffer()
  {
    return this.buffer;
  }
  
  public abstract int getType();
  
  public abstract int length();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.TypedArray
 * JD-Core Version:    0.7.0.1
 */