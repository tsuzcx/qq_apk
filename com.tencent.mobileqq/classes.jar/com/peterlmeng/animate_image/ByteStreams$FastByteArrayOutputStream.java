package com.peterlmeng.animate_image;

import java.io.ByteArrayOutputStream;

final class ByteStreams$FastByteArrayOutputStream
  extends ByteArrayOutputStream
{
  void writeTo(byte[] paramArrayOfByte, int paramInt)
  {
    System.arraycopy(this.buf, 0, paramArrayOfByte, paramInt, this.count);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.ByteStreams.FastByteArrayOutputStream
 * JD-Core Version:    0.7.0.1
 */