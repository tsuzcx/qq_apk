package com.google.protobuf;

import java.util.NoSuchElementException;

class ByteString$1
  extends ByteString.AbstractByteIterator
{
  private int b = 0;
  private final int c = this.a.size();
  
  ByteString$1(ByteString paramByteString) {}
  
  public byte a()
  {
    int i = this.b;
    if (i < this.c)
    {
      this.b = (i + 1);
      return this.a.internalByteAt(i);
    }
    throw new NoSuchElementException();
  }
  
  public boolean hasNext()
  {
    return this.b < this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.1
 * JD-Core Version:    0.7.0.1
 */