package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8ArrayBuffer;
import java.nio.ByteBuffer;

public class ArrayBuffer
{
  private V8ArrayBuffer arrayBuffer;
  
  public ArrayBuffer(V8 paramV8, ByteBuffer paramByteBuffer)
  {
    paramV8 = new V8ArrayBuffer(paramV8, paramByteBuffer);
    try
    {
      this.arrayBuffer = ((V8ArrayBuffer)paramV8.twin().setWeak());
      return;
    }
    finally
    {
      paramV8.close();
    }
  }
  
  ArrayBuffer(V8ArrayBuffer paramV8ArrayBuffer)
  {
    this.arrayBuffer = ((V8ArrayBuffer)paramV8ArrayBuffer.twin().setWeak());
  }
  
  public V8ArrayBuffer getV8ArrayBuffer()
  {
    return this.arrayBuffer.twin();
  }
  
  public boolean isAvailable()
  {
    return this.arrayBuffer.isReleased() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.utils.ArrayBuffer
 * JD-Core Version:    0.7.0.1
 */