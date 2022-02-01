package com.tencent.falco.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

public final class IOUtil
{
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        paramCloseable.printStackTrace();
      }
    }
  }
  
  public static void close(Closeable... paramVarArgs)
  {
    if (paramVarArgs != null) {
      try
      {
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          paramVarArgs[i].close();
          i += 1;
        }
        return;
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  public static byte[] createZeroBytes(int paramInt)
  {
    if (paramInt > 0)
    {
      byte[] arrayOfByte = new byte[paramInt];
      Arrays.fill(arrayOfByte, (byte)0);
      return arrayOfByte;
    }
    throw new IllegalArgumentException("length must be gt 0");
  }
  
  public static boolean endWiths(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramInt >= paramArrayOfByte2.length))
    {
      int i = Math.min(paramArrayOfByte1.length, paramInt);
      int j = paramArrayOfByte2.length;
      paramInt = 1;
      while (paramInt < j + 1)
      {
        if (paramArrayOfByte1[(i - paramInt)] != paramArrayOfByte2[(j - paramInt)]) {
          return false;
        }
        paramInt += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean endWiths(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte1.length >= paramArrayOfByte2.length))
    {
      int j = paramArrayOfByte1.length;
      int k = paramArrayOfByte2.length;
      int i = 1;
      while (i < k + 1)
      {
        if (paramArrayOfByte1[(j - i)] != paramArrayOfByte2[(k - i)]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static long exhaust(InputStream paramInputStream)
  {
    byte[] arrayOfByte;
    if (paramInputStream != null) {
      arrayOfByte = new byte[512];
    }
    for (;;)
    {
      int j;
      int i;
      Object localObject;
      try
      {
        j = paramInputStream.read(arrayOfByte);
        if (j != -1) {
          break label60;
        }
        i = -1;
        break label62;
      }
      finally {}
      long l2 = localObject;
      long l1;
      if (i != -1)
      {
        localObject += i;
        i = paramInputStream.read(arrayOfByte);
        continue;
        l2 = 0L;
      }
      else
      {
        return l2;
        label60:
        i = 0;
        label62:
        l1 = i;
        i = j;
      }
    }
  }
  
  public static ReadableByteChannel getChannel(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      return Channels.newChannel(paramInputStream);
    }
    return null;
  }
  
  public static WritableByteChannel getChannel(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {
      return Channels.newChannel(paramOutputStream);
    }
    return null;
  }
  
  public static int indexOf(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      int j = paramArrayOfByte1.length;
      int k = paramArrayOfByte2.length;
      if ((paramInt < j) && (j - paramInt >= k))
      {
        while (paramInt <= j - k)
        {
          int i = 0;
          while ((i < k) && (paramArrayOfByte1[(paramInt + i)] == paramArrayOfByte2[i])) {
            i += 1;
          }
          if (i == k) {
            return paramInt;
          }
          paramInt += 1;
        }
        return -1;
      }
      return -1;
    }
    paramArrayOfByte1 = new NullPointerException("source or target array is null!");
    for (;;)
    {
      throw paramArrayOfByte1;
    }
  }
  
  public static byte[] numberToBytes(long paramLong, int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i;
    if (paramBoolean) {
      i = paramInt - 1;
    } else {
      i = 0;
    }
    int j = -1;
    if (paramBoolean) {
      paramInt = -1;
    }
    if (!paramBoolean) {
      j = 1;
    }
    while (i != paramInt)
    {
      arrayOfByte[i] = ((byte)(int)(0xFF & paramLong));
      paramLong >>>= 8;
      i += j;
    }
    return arrayOfByte;
  }
  
  public static int parseInteger(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return (int)parseNumber(paramArrayOfByte, 4, paramBoolean);
  }
  
  public static long parseNumber(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0) && (paramArrayOfByte.length - paramInt1 > 0))
    {
      int i = Math.min(paramInt2, paramArrayOfByte.length - paramInt1);
      long l1 = 0L;
      long l2;
      if (paramBoolean)
      {
        paramInt2 = 0;
        for (;;)
        {
          l2 = l1;
          if (paramInt2 >= i) {
            break;
          }
          l1 = l1 << 8 | paramArrayOfByte[(paramInt2 + paramInt1)] & 0xFF;
          paramInt2 += 1;
        }
      }
      paramInt2 = i - 1;
      for (;;)
      {
        l2 = l1;
        if (paramInt2 < 0) {
          break;
        }
        l1 = l1 << 8 | paramArrayOfByte[(paramInt2 + paramInt1)] & 0xFF;
        paramInt2 -= 1;
      }
      return l2;
    }
    paramArrayOfByte = new IllegalArgumentException("byte array is null or empty!");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static long parseNumber(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      int i = Math.min(paramInt, paramArrayOfByte.length);
      long l1 = 0L;
      long l2;
      if (paramBoolean)
      {
        paramInt = 0;
        for (;;)
        {
          l2 = l1;
          if (paramInt >= i) {
            break;
          }
          l1 = l1 << 8 | paramArrayOfByte[paramInt] & 0xFF;
          paramInt += 1;
        }
      }
      paramInt = i - 1;
      for (;;)
      {
        l2 = l1;
        if (paramInt < 0) {
          break;
        }
        l1 = l1 << 8 | paramArrayOfByte[paramInt] & 0xFF;
        paramInt -= 1;
      }
      return l2;
    }
    paramArrayOfByte = new IllegalArgumentException("byte array is null or empty!");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static int parseShort(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return (int)parseNumber(paramArrayOfByte, 2, paramBoolean);
  }
  
  public static byte[] readBytes(InputStream paramInputStream, int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt];
    while (i < paramInt) {
      try
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j > 0) {
          i += j;
        }
      }
      finally {}
    }
    return arrayOfByte;
  }
  
  public static byte[] readCLenData(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    if (i <= 0) {
      return null;
    }
    return readBytes(paramInputStream, i);
  }
  
  public static String readCString(InputStream paramInputStream, String paramString)
  {
    int i = paramInputStream.read();
    if (i <= 0) {
      return null;
    }
    return readString(paramInputStream, i, paramString);
  }
  
  public static double readDouble(InputStream paramInputStream)
  {
    return readDouble(paramInputStream, true);
  }
  
  public static double readDouble(InputStream paramInputStream, boolean paramBoolean)
  {
    return Double.longBitsToDouble(readNumber(paramInputStream, 8, paramBoolean));
  }
  
  public static float readFloat(InputStream paramInputStream)
  {
    return readFloat(paramInputStream, true);
  }
  
  public static float readFloat(InputStream paramInputStream, boolean paramBoolean)
  {
    return Float.intBitsToFloat((int)readInt(paramInputStream, paramBoolean));
  }
  
  public static long readInt(InputStream paramInputStream)
  {
    return readNumber(paramInputStream, 4, true);
  }
  
  public static long readInt(InputStream paramInputStream, boolean paramBoolean)
  {
    return readNumber(paramInputStream, 4, paramBoolean);
  }
  
  public static String readLeft(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[512];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 512);
        if (i < 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramInputStream = localByteArrayOutputStream.toString();
      localByteArrayOutputStream.close();
      return paramInputStream;
    }
    finally
    {
      localByteArrayOutputStream.close();
    }
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static String readLeft(InputStream paramInputStream, String paramString)
  {
    if (paramInputStream == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[512];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 512);
        if (i < 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramInputStream = localByteArrayOutputStream.toString(paramString);
      localByteArrayOutputStream.close();
      return paramInputStream;
    }
    finally
    {
      localByteArrayOutputStream.close();
    }
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static byte[] readLeftBytes(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 1024);
        if (i < 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramInputStream = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramInputStream;
    }
    finally
    {
      localByteArrayOutputStream.close();
    }
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static long readNumber(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    if ((paramInt > 0) && (paramInt <= 8))
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.markSupported()) {
        paramInputStream.mark(paramInt);
      }
      int j = 0;
      int i = paramInputStream.read(arrayOfByte, 0, paramInt);
      if (i <= 0) {
        return -1L;
      }
      if (paramBoolean) {
        paramInt = j;
      } else {
        paramInt = i - 1;
      }
      j = -1;
      if (!paramBoolean) {
        i = -1;
      }
      if (paramBoolean) {
        j = 1;
      }
      long l = 0L;
      while (paramInt != i)
      {
        l = l << 8 | arrayOfByte[paramInt] & 0xFF;
        paramInt += j;
      }
      return l;
    }
    paramInputStream = new IllegalArgumentException("length must between 1 and 8.");
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static int readShort(InputStream paramInputStream)
  {
    return (int)readNumber(paramInputStream, 2, true);
  }
  
  public static int readShort(InputStream paramInputStream, boolean paramBoolean)
  {
    return (int)readNumber(paramInputStream, 2, paramBoolean);
  }
  
  public static String readString(InputStream paramInputStream, int paramInt)
  {
    int i = Math.min(paramInt, 1024);
    byte[] arrayOfByte = new byte[i];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    for (;;)
    {
      if (paramInt > 0) {}
      try
      {
        int j = paramInputStream.read(arrayOfByte, 0, i);
        if (j != -1)
        {
          localByteArrayOutputStream.write(arrayOfByte, 0, j);
          paramInt -= j;
        }
        else
        {
          paramInputStream = localByteArrayOutputStream.toString();
          localByteArrayOutputStream.close();
          return paramInputStream;
        }
      }
      finally
      {
        localByteArrayOutputStream.close();
      }
    }
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static String readString(InputStream paramInputStream, int paramInt, String paramString)
  {
    int i = Math.min(paramInt, 1024);
    byte[] arrayOfByte = new byte[i];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    while (paramInt > 0)
    {
      int j = paramInputStream.read(arrayOfByte, 0, i);
      if (j == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, j);
      paramInt -= j;
    }
    paramInputStream = localByteArrayOutputStream.toString(paramString);
    localByteArrayOutputStream.close();
    return paramInputStream;
  }
  
  public static byte[] readWLenData(InputStream paramInputStream, boolean paramBoolean)
  {
    int i = readShort(paramInputStream, paramBoolean);
    if (i <= 0) {
      return null;
    }
    return readBytes(paramInputStream, i);
  }
  
  public static String readWString(InputStream paramInputStream, boolean paramBoolean, String paramString)
  {
    int i = readShort(paramInputStream, paramBoolean);
    if (i <= 0) {
      return null;
    }
    return readString(paramInputStream, i, paramString);
  }
  
  public static void skip(InputStream paramInputStream, int paramInt)
  {
    if ((paramInputStream != null) && (paramInt > 0))
    {
      byte[] arrayOfByte = new byte[512];
      int i;
      do
      {
        i = paramInputStream.read(arrayOfByte, 0, Math.min(arrayOfByte.length, paramInt));
        if (i < 0) {
          return;
        }
        i = paramInt - i;
        paramInt = i;
      } while (i > 0);
    }
  }
  
  public static boolean startWiths(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte1.length >= paramArrayOfByte2.length))
    {
      int i = 0;
      while (i < paramArrayOfByte2.length)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static void writeCLenData(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      paramOutputStream.write(0);
      return;
    }
    paramOutputStream.write(paramArrayOfByte.length);
    paramOutputStream.write(paramArrayOfByte);
  }
  
  public static void writeCString(OutputStream paramOutputStream, String paramString)
  {
    writeCString(paramOutputStream, paramString, "utf-8");
  }
  
  public static void writeCString(OutputStream paramOutputStream, String paramString, int paramInt)
  {
    paramString = paramString.getBytes();
    paramOutputStream.write(paramString.length);
    paramInt -= 1;
    if (paramInt > 0)
    {
      if (paramInt <= paramString.length)
      {
        paramOutputStream.write(paramString, 0, paramInt);
      }
      else
      {
        paramOutputStream.write(paramString);
        paramString = new byte[paramInt - paramString.length];
        Arrays.fill(paramString, (byte)0);
        paramOutputStream.write(paramString);
      }
      paramOutputStream.flush();
    }
  }
  
  public static void writeCString(OutputStream paramOutputStream, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "utf-8";
      }
      writeCLenData(paramOutputStream, paramString1.getBytes(str));
      return;
    }
    paramOutputStream.write(0);
  }
  
  public static void writeCString(OutputStream paramOutputStream, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1.getBytes(paramString2);
    paramOutputStream.write(paramString1.length);
    paramInt -= 1;
    if (paramInt > 0)
    {
      if (paramInt <= paramString1.length)
      {
        paramOutputStream.write(paramString1, 0, paramInt);
      }
      else
      {
        paramOutputStream.write(paramString1);
        paramString1 = new byte[paramInt - paramString1.length];
        Arrays.fill(paramString1, (byte)0);
        paramOutputStream.write(paramString1);
      }
      paramOutputStream.flush();
    }
  }
  
  public static void writeDouble(OutputStream paramOutputStream, double paramDouble)
  {
    writeDouble(paramOutputStream, paramDouble, true);
  }
  
  public static void writeDouble(OutputStream paramOutputStream, double paramDouble, boolean paramBoolean)
  {
    writeNumber(paramOutputStream, Double.doubleToLongBits(paramDouble), 8, paramBoolean);
  }
  
  public static void writeFloat(OutputStream paramOutputStream, float paramFloat)
  {
    writeFloat(paramOutputStream, paramFloat, true);
  }
  
  public static void writeFloat(OutputStream paramOutputStream, float paramFloat, boolean paramBoolean)
  {
    writeInt(paramOutputStream, Float.floatToIntBits(paramFloat), paramBoolean);
  }
  
  public static void writeInt(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write(new byte[] { (byte)(int)(paramLong >> 24 & 0xFF), (byte)(int)(paramLong >> 16 & 0xFF), (byte)(int)(paramLong >> 8 & 0xFF), (byte)(int)(paramLong & 0xFF) });
    paramOutputStream.flush();
  }
  
  public static void writeInt(OutputStream paramOutputStream, long paramLong, boolean paramBoolean)
  {
    writeNumber(paramOutputStream, paramLong, 4, paramBoolean);
  }
  
  public static void writeNumber(OutputStream paramOutputStream, long paramLong, int paramInt, boolean paramBoolean)
  {
    if ((paramInt > 0) && (paramInt <= 8))
    {
      paramOutputStream.write(numberToBytes(paramLong, paramInt, paramBoolean));
      paramOutputStream.flush();
      return;
    }
    throw new IllegalArgumentException("length must between 1 and 8.");
  }
  
  public static void writeShort(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(new byte[] { (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) });
    paramOutputStream.flush();
  }
  
  public static void writeShort(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
  {
    writeNumber(paramOutputStream, paramInt, 2, paramBoolean);
  }
  
  public static void writeWLenData(OutputStream paramOutputStream, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
    {
      writeShort(paramOutputStream, 0, paramBoolean);
      return;
    }
    writeShort(paramOutputStream, paramArrayOfByte.length, paramBoolean);
    paramOutputStream.write(paramArrayOfByte);
  }
  
  public static void writeWString(OutputStream paramOutputStream, String paramString)
  {
    paramString = paramString.getBytes();
    writeShort(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString);
    paramOutputStream.flush();
  }
  
  public static void writeWString(OutputStream paramOutputStream, String paramString, int paramInt)
  {
    paramString = paramString.getBytes();
    writeShort(paramOutputStream, paramString.length);
    paramInt -= 2;
    if (paramInt > 0)
    {
      if (paramInt <= paramString.length)
      {
        paramOutputStream.write(paramString, 0, paramInt);
      }
      else
      {
        paramOutputStream.write(paramString);
        paramString = new byte[paramInt - paramString.length];
        Arrays.fill(paramString, (byte)0);
        paramOutputStream.write(paramString);
      }
      paramOutputStream.flush();
    }
  }
  
  public static void writeWString(OutputStream paramOutputStream, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1.getBytes(paramString2);
    writeShort(paramOutputStream, paramString1.length);
    paramInt -= 2;
    if (paramInt > 0)
    {
      if (paramInt <= paramString1.length)
      {
        paramOutputStream.write(paramString1, 0, paramInt);
      }
      else
      {
        paramOutputStream.write(paramString1);
        paramString1 = new byte[paramInt - paramString1.length];
        Arrays.fill(paramString1, (byte)0);
        paramOutputStream.write(paramString1);
      }
      paramOutputStream.flush();
    }
  }
  
  public static void writeWString(OutputStream paramOutputStream, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "utf-8";
      }
      writeWLenData(paramOutputStream, paramString1.getBytes(str), paramBoolean);
      return;
    }
    writeShort(paramOutputStream, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.IOUtil
 * JD-Core Version:    0.7.0.1
 */