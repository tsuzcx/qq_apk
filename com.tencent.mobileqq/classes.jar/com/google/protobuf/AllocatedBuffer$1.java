package com.google.protobuf;

import java.nio.ByteBuffer;

final class AllocatedBuffer$1
  extends AllocatedBuffer
{
  AllocatedBuffer$1(ByteBuffer paramByteBuffer) {}
  
  public AllocatedBuffer a(int paramInt)
  {
    this.a.position(paramInt);
    return this;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return this.a.hasArray();
  }
  
  public ByteBuffer c()
  {
    return this.a;
  }
  
  public byte[] d()
  {
    return this.a.array();
  }
  
  public int e()
  {
    return this.a.arrayOffset();
  }
  
  public int f()
  {
    return this.a.position();
  }
  
  public int g()
  {
    return this.a.limit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AllocatedBuffer.1
 * JD-Core Version:    0.7.0.1
 */