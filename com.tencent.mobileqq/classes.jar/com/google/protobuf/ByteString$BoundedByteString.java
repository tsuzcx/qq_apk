package com.google.protobuf;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

final class ByteString$BoundedByteString
  extends ByteString.LiteralByteString
{
  private static final long serialVersionUID = 1L;
  private final int bytesLength;
  private final int bytesOffset;
  
  ByteString$BoundedByteString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    checkRange(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    this.bytesOffset = paramInt1;
    this.bytesLength = paramInt2;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
  }
  
  public byte byteAt(int paramInt)
  {
    checkIndex(paramInt, size());
    return this.bytes[(this.bytesOffset + paramInt)];
  }
  
  protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.bytes, getOffsetIntoBytes() + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  protected int getOffsetIntoBytes()
  {
    return this.bytesOffset;
  }
  
  byte internalByteAt(int paramInt)
  {
    return this.bytes[(this.bytesOffset + paramInt)];
  }
  
  public int size()
  {
    return this.bytesLength;
  }
  
  Object writeReplace()
  {
    return ByteString.wrap(toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.BoundedByteString
 * JD-Core Version:    0.7.0.1
 */