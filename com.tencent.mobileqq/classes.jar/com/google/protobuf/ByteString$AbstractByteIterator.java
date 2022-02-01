package com.google.protobuf;

abstract class ByteString$AbstractByteIterator
  implements ByteString.ByteIterator
{
  public final Byte b()
  {
    return Byte.valueOf(a());
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.AbstractByteIterator
 * JD-Core Version:    0.7.0.1
 */