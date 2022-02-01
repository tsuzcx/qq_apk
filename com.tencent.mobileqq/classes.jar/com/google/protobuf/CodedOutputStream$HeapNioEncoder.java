package com.google.protobuf;

import java.nio.ByteBuffer;

final class CodedOutputStream$HeapNioEncoder
  extends CodedOutputStream.ArrayEncoder
{
  private final ByteBuffer b;
  private int c;
  
  public void b()
  {
    this.b.position(this.c + f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedOutputStream.HeapNioEncoder
 * JD-Core Version:    0.7.0.1
 */