package com.google.protobuf;

import java.nio.ByteBuffer;

final class BufferAllocator$1
  extends BufferAllocator
{
  public AllocatedBuffer a(int paramInt)
  {
    return AllocatedBuffer.a(new byte[paramInt]);
  }
  
  public AllocatedBuffer b(int paramInt)
  {
    return AllocatedBuffer.a(ByteBuffer.allocateDirect(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.BufferAllocator.1
 * JD-Core Version:    0.7.0.1
 */