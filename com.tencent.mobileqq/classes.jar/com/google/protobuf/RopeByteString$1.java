package com.google.protobuf;

import java.util.NoSuchElementException;

class RopeByteString$1
  extends ByteString.AbstractByteIterator
{
  final RopeByteString.PieceIterator a = new RopeByteString.PieceIterator(this.c, null);
  ByteString.ByteIterator b = c();
  
  RopeByteString$1(RopeByteString paramRopeByteString) {}
  
  private ByteString.ByteIterator c()
  {
    if (this.a.hasNext()) {
      return this.a.a().iterator();
    }
    return null;
  }
  
  public byte a()
  {
    ByteString.ByteIterator localByteIterator = this.b;
    if (localByteIterator != null)
    {
      byte b1 = localByteIterator.a();
      if (!this.b.hasNext()) {
        this.b = c();
      }
      return b1;
    }
    throw new NoSuchElementException();
  }
  
  public boolean hasNext()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RopeByteString.1
 * JD-Core Version:    0.7.0.1
 */