package com.google.protobuf;

import java.util.Arrays;

final class ByteString$ArraysByteArrayCopier
  implements ByteString.ByteArrayCopier
{
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2 + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.ArraysByteArrayCopier
 * JD-Core Version:    0.7.0.1
 */