package com.tencent.commonsdk.soload;

import java.nio.ByteOrder;

public final class HeapBufferIterator
  extends BufferIterator
{
  private final byte[] buffer;
  private final int byteCount;
  private final int offset;
  private final ByteOrder order;
  private int position;
  
  HeapBufferIterator(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ByteOrder paramByteOrder)
  {
    this.buffer = paramArrayOfByte;
    this.offset = paramInt1;
    this.byteCount = paramInt2;
    this.order = paramByteOrder;
  }
  
  public static HeapBufferIterator iterator(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ByteOrder paramByteOrder)
  {
    return new HeapBufferIterator(paramArrayOfByte, paramInt1, paramInt2, paramByteOrder);
  }
  
  public int readInt()
  {
    int i = Memory.peekInt(this.buffer, this.offset + this.position, this.order);
    this.position += 4;
    return i;
  }
  
  public short readShort()
  {
    short s = Memory.peekShort(this.buffer, this.offset + this.position, this.order);
    this.position += 2;
    return s;
  }
  
  public void seek(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void skip(int paramInt)
  {
    this.position += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.HeapBufferIterator
 * JD-Core Version:    0.7.0.1
 */