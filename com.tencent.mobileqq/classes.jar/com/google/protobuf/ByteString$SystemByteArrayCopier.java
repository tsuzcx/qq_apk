package com.google.protobuf;

final class ByteString$SystemByteArrayCopier
  implements ByteString.ByteArrayCopier
{
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.SystemByteArrayCopier
 * JD-Core Version:    0.7.0.1
 */