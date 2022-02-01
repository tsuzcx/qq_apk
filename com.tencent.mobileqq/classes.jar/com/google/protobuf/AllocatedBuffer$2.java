package com.google.protobuf;

import java.nio.ByteBuffer;

final class AllocatedBuffer$2
  extends AllocatedBuffer
{
  private int d;
  
  AllocatedBuffer$2(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public AllocatedBuffer a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.c))
    {
      this.d = paramInt;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid position: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public ByteBuffer c()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] d()
  {
    return this.a;
  }
  
  public int e()
  {
    return this.b;
  }
  
  public int f()
  {
    return this.d;
  }
  
  public int g()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AllocatedBuffer.2
 * JD-Core Version:    0.7.0.1
 */