package com.tencent.dlsdk.yybutil.apkchannel.v2;

import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ApkSignatureSchemeV2Verifier
{
  static long a(ByteBuffer paramByteBuffer, long paramLong)
  {
    long l = c.a(paramByteBuffer);
    if (l < paramLong)
    {
      if (c.b(paramByteBuffer) + l == paramLong) {
        return l;
      }
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
    }
    paramByteBuffer = new StringBuilder("ZIP Central Directory offset out of range: ");
    paramByteBuffer.append(l);
    paramByteBuffer.append(". ZIP End of Central Directory offset: ");
    paramByteBuffer.append(paramLong);
    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramByteBuffer.toString());
  }
  
  static b<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile)
  {
    paramRandomAccessFile = c.a(paramRandomAccessFile);
    if (paramRandomAccessFile != null) {
      return paramRandomAccessFile;
    }
    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
  }
  
  static b<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    if (paramLong >= 32L)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(24);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      paramRandomAccessFile.seek(paramLong - localByteBuffer.capacity());
      paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
      if ((localByteBuffer.getLong(8) == 2334950737559900225L) && (localByteBuffer.getLong(16) == 3617552046287187010L))
      {
        long l1 = localByteBuffer.getLong(0);
        if ((l1 >= localByteBuffer.capacity()) && (l1 <= 2147483639L))
        {
          int i = (int)(8L + l1);
          paramLong -= i;
          if (paramLong >= 0L)
          {
            localByteBuffer = ByteBuffer.allocate(i);
            localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            paramRandomAccessFile.seek(paramLong);
            paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
            long l2 = localByteBuffer.getLong(0);
            if (l2 == l1) {
              return b.a(localByteBuffer, Long.valueOf(paramLong));
            }
            paramRandomAccessFile = new StringBuilder("APK Signing Block sizes in header and footer do not match: ");
            paramRandomAccessFile.append(l2);
            paramRandomAccessFile.append(" vs ");
            paramRandomAccessFile.append(l1);
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramRandomAccessFile.toString());
          }
          paramRandomAccessFile = new StringBuilder("APK Signing Block offset out of range: ");
          paramRandomAccessFile.append(paramLong);
          throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramRandomAccessFile.toString());
        }
        paramRandomAccessFile = new StringBuilder("APK Signing Block size out of range: ");
        paramRandomAccessFile.append(l1);
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramRandomAccessFile.toString());
      }
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
    }
    paramRandomAccessFile = new StringBuilder("APK too small for APK Signing Block. ZIP Central Directory offset: ");
    paramRandomAccessFile.append(paramLong);
    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramRandomAccessFile.toString());
  }
  
  static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = paramByteBuffer.limit();
      int j = paramByteBuffer.position();
      paramInt += j;
      if ((paramInt >= j) && (paramInt <= i))
      {
        paramByteBuffer.limit(paramInt);
        try
        {
          ByteBuffer localByteBuffer = paramByteBuffer.slice();
          localByteBuffer.order(paramByteBuffer.order());
          paramByteBuffer.position(paramInt);
          return localByteBuffer;
        }
        finally
        {
          paramByteBuffer.limit(i);
        }
      }
      throw new BufferUnderflowException();
    }
    paramByteBuffer = new StringBuilder("size: ");
    paramByteBuffer.append(paramInt);
    throw new IllegalArgumentException(paramByteBuffer.toString());
  }
  
  static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= paramInt1)
      {
        int i = paramByteBuffer.capacity();
        if (paramInt2 <= paramByteBuffer.capacity())
        {
          i = paramByteBuffer.limit();
          int j = paramByteBuffer.position();
          try
          {
            paramByteBuffer.position(0);
            paramByteBuffer.limit(paramInt2);
            paramByteBuffer.position(paramInt1);
            ByteBuffer localByteBuffer = paramByteBuffer.slice();
            localByteBuffer.order(paramByteBuffer.order());
            return localByteBuffer;
          }
          finally
          {
            paramByteBuffer.position(0);
            paramByteBuffer.limit(i);
            paramByteBuffer.position(j);
          }
        }
        paramByteBuffer = new StringBuilder("end > capacity: ");
        paramByteBuffer.append(paramInt2);
        paramByteBuffer.append(" > ");
        paramByteBuffer.append(i);
        throw new IllegalArgumentException(paramByteBuffer.toString());
      }
      paramByteBuffer = new StringBuilder("end < start: ");
      paramByteBuffer.append(paramInt2);
      paramByteBuffer.append(" < ");
      paramByteBuffer.append(paramInt1);
      throw new IllegalArgumentException(paramByteBuffer.toString());
    }
    paramByteBuffer = new StringBuilder("start: ");
    paramByteBuffer.append(paramInt1);
    throw new IllegalArgumentException(paramByteBuffer.toString());
  }
  
  static void a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
      return;
    }
    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
  }
  
  static ByteBuffer b(ByteBuffer paramByteBuffer, int paramInt)
  {
    a(paramByteBuffer);
    paramByteBuffer = a(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() >= 8)
      {
        long l = paramByteBuffer.getLong();
        if ((l >= 4L) && (l <= 2147483647L))
        {
          int j = (int)l;
          int k = paramByteBuffer.position();
          if (j <= paramByteBuffer.remaining())
          {
            if (paramByteBuffer.getInt() == paramInt) {
              return a(paramByteBuffer, j - 4);
            }
            paramByteBuffer.position(k + j);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder("APK Signing Block entry #");
            localStringBuilder.append(i);
            localStringBuilder.append(" size out of range: ");
            localStringBuilder.append(j);
            localStringBuilder.append(", available: ");
            localStringBuilder.append(paramByteBuffer.remaining());
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(localStringBuilder.toString());
          }
        }
        else
        {
          paramByteBuffer = new StringBuilder("APK Signing Block entry #");
          paramByteBuffer.append(i);
          paramByteBuffer.append(" size out of range: ");
          paramByteBuffer.append(l);
          throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramByteBuffer.toString());
        }
      }
      else
      {
        paramByteBuffer = new StringBuilder("Insufficient data to read size of APK Signing Block entry #");
        paramByteBuffer.append(i);
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramByteBuffer.toString());
      }
    }
    paramByteBuffer = new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("No Channel block in APK Signing Block");
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.v2.ApkSignatureSchemeV2Verifier
 * JD-Core Version:    0.7.0.1
 */