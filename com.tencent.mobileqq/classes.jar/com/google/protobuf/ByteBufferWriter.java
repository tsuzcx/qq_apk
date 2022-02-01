package com.google.protobuf;

import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

final class ByteBufferWriter
{
  private static final ThreadLocal<SoftReference<byte[]>> a = new ThreadLocal();
  private static final Class<?> b = a("java.io.FileOutputStream");
  private static final long c = a(b);
  
  private static long a(Class<?> paramClass)
  {
    if (paramClass != null) {}
    try
    {
      if (UnsafeUtil.a())
      {
        long l = UnsafeUtil.a(paramClass.getDeclaredField("channel"));
        return l;
      }
    }
    catch (Throwable paramClass)
    {
      label22:
      break label22;
    }
    return -1L;
  }
  
  private static Class<?> a(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  static void a(ByteBuffer paramByteBuffer, OutputStream paramOutputStream)
  {
    int i = paramByteBuffer.position();
    try
    {
      if (paramByteBuffer.hasArray())
      {
        paramOutputStream.write(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
      }
      else if (!b(paramByteBuffer, paramOutputStream))
      {
        byte[] arrayOfByte = a(paramByteBuffer.remaining());
        while (paramByteBuffer.hasRemaining())
        {
          int j = Math.min(paramByteBuffer.remaining(), arrayOfByte.length);
          paramByteBuffer.get(arrayOfByte, 0, j);
          paramOutputStream.write(arrayOfByte, 0, j);
        }
      }
      paramByteBuffer.position(i);
      return;
    }
    finally
    {
      paramByteBuffer.position(i);
    }
    for (;;)
    {
      throw paramOutputStream;
    }
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    a.set(new SoftReference(paramArrayOfByte));
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt2 < paramInt1) && (paramInt2 < paramInt1 * 0.5F);
  }
  
  private static byte[] a()
  {
    SoftReference localSoftReference = (SoftReference)a.get();
    if (localSoftReference == null) {
      return null;
    }
    return (byte[])localSoftReference.get();
  }
  
  private static byte[] a(int paramInt)
  {
    paramInt = Math.max(paramInt, 1024);
    byte[] arrayOfByte2 = a();
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (!a(paramInt, arrayOfByte2.length)) {}
    }
    else
    {
      arrayOfByte2 = new byte[paramInt];
      arrayOfByte1 = arrayOfByte2;
      if (paramInt <= 16384)
      {
        a(arrayOfByte2);
        arrayOfByte1 = arrayOfByte2;
      }
    }
    return arrayOfByte1;
  }
  
  private static boolean b(ByteBuffer paramByteBuffer, OutputStream paramOutputStream)
  {
    if ((c >= 0L) && (b.isInstance(paramOutputStream))) {}
    try
    {
      paramOutputStream = (WritableByteChannel)UnsafeUtil.f(paramOutputStream, c);
    }
    catch (ClassCastException paramOutputStream)
    {
      label32:
      break label32;
    }
    paramOutputStream = null;
    if (paramOutputStream != null)
    {
      paramOutputStream.write(paramByteBuffer);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteBufferWriter
 * JD-Core Version:    0.7.0.1
 */