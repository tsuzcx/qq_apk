package com.tencent.biz.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class FbTable
  extends Table
{
  protected int a;
  protected int b;
  
  public static FbTable a(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, new FbTable());
  }
  
  public static FbTable a(ByteBuffer paramByteBuffer, FbTable paramFbTable)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (paramByteBuffer.capacity() < paramByteBuffer.position() + 4) {
      return null;
    }
    return paramFbTable.a(paramByteBuffer.getInt(paramByteBuffer.position()) + paramByteBuffer.position(), paramByteBuffer);
  }
  
  private int c(int paramInt)
  {
    paramInt = (paramInt + 2) * 2;
    if (paramInt < this.b) {
      return this.e.getShort(this.a + paramInt);
    }
    return 0;
  }
  
  public long a(int paramInt, long paramLong)
  {
    paramInt = c(paramInt);
    if (paramInt != 0) {
      paramLong = this.e.getLong(paramInt + this.d);
    }
    return paramLong;
  }
  
  public FbArray a(int paramInt, FbArray paramFbArray)
  {
    paramInt = c(paramInt);
    if (paramInt != 0) {
      return paramFbArray.a(d(paramInt + this.d), this.e);
    }
    return null;
  }
  
  public FbTable a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if (paramInt >= 0)
    {
      if (paramByteBuffer.capacity() < paramInt + 4) {
        return null;
      }
      this.d = paramInt;
      this.e = paramByteBuffer;
      this.a = (this.d - this.e.getInt(this.d));
      if (!a(this.a, 2)) {
        return null;
      }
      this.b = this.e.getShort(this.a);
      if (!a(this.a, this.b)) {
        return null;
      }
      return this;
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    paramInt = c(paramInt);
    if (paramInt != 0) {
      return e(paramInt + this.d);
    }
    return null;
  }
  
  public FbArray b(int paramInt)
  {
    return a(paramInt, new FbArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.flatbuffers.FbTable
 * JD-Core Version:    0.7.0.1
 */