package com.google.protobuf;

import java.nio.ByteBuffer;

abstract class BinaryReader
  implements Reader
{
  public static BinaryReader a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if (paramByteBuffer.hasArray()) {
      return new BinaryReader.SafeHeapReader(paramByteBuffer, paramBoolean);
    }
    throw new IllegalArgumentException("Direct buffers not yet supported");
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.BinaryReader
 * JD-Core Version:    0.7.0.1
 */