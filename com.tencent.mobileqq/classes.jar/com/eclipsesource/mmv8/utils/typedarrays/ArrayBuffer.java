package com.eclipsesource.mmv8.utils.typedarrays;

import java.nio.ByteBuffer;

public class ArrayBuffer
{
  private ByteBuffer byteBuffer;
  
  public ArrayBuffer(int paramInt)
  {
    this.byteBuffer = ByteBuffer.allocateDirect(paramInt);
  }
  
  public ArrayBuffer(ByteBuffer paramByteBuffer)
  {
    this.byteBuffer = validateByteBuffer(paramByteBuffer);
  }
  
  public ArrayBuffer(byte[] paramArrayOfByte)
  {
    this.byteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    this.byteBuffer.put(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private ByteBuffer validateByteBuffer(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isDirect()) {
      return paramByteBuffer;
    }
    throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
  }
  
  public byte getByte(int paramInt)
  {
    return this.byteBuffer.get(paramInt);
  }
  
  public ByteBuffer getByteBuffer()
  {
    return this.byteBuffer;
  }
  
  public short getUnsignedByte(int paramInt)
  {
    return (short)(this.byteBuffer.get(paramInt) & 0xFF);
  }
  
  public int limit()
  {
    return this.byteBuffer.limit();
  }
  
  public void put(int paramInt, byte paramByte)
  {
    this.byteBuffer.put(paramInt, paramByte);
  }
  
  public String toString()
  {
    return "[object ArrayBuffer]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.ArrayBuffer
 * JD-Core Version:    0.7.0.1
 */