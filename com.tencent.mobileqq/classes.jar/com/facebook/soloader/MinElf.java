package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class MinElf
{
  public static final int DT_NEEDED = 1;
  public static final int DT_NULL = 0;
  public static final int DT_STRTAB = 5;
  public static final int ELF_MAGIC = 1179403647;
  public static final int PN_XNUM = 65535;
  public static final int PT_DYNAMIC = 2;
  public static final int PT_LOAD = 1;
  
  public static String[] extract_DT_NEEDED(File paramFile)
    throws IOException
  {
    paramFile = new FileInputStream(paramFile);
    try
    {
      String[] arrayOfString = extract_DT_NEEDED(paramFile.getChannel());
      return arrayOfString;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static String[] extract_DT_NEEDED(FileChannel paramFileChannel)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (getu32(paramFileChannel, localByteBuffer, 0L) != 1179403647L) {
      throw new ElfError("file is not ELF");
    }
    int i;
    long l1;
    label92:
    long l2;
    label108:
    label122:
    long l6;
    if (getu8(paramFileChannel, localByteBuffer, 4L) == 1)
    {
      i = 1;
      if (getu8(paramFileChannel, localByteBuffer, 5L) == 2) {
        localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      }
      if (i == 0) {
        break label259;
      }
      l1 = getu32(paramFileChannel, localByteBuffer, 28L);
      if (i == 0) {
        break label273;
      }
      l2 = getu16(paramFileChannel, localByteBuffer, 44L);
      if (i == 0) {
        break label288;
      }
      j = getu16(paramFileChannel, localByteBuffer, 42L);
      l4 = l2;
      if (l2 == 65535L)
      {
        if (i == 0) {
          break label301;
        }
        l2 = getu32(paramFileChannel, localByteBuffer, 32L);
        label150:
        if (i == 0) {
          break label315;
        }
        l2 = getu32(paramFileChannel, localByteBuffer, 28L + l2);
        label168:
        l4 = l2;
      }
      l6 = 0L;
      l5 = l1;
    }
    for (long l3 = 0L;; l3 += 1L)
    {
      l2 = l6;
      if (l3 < l4)
      {
        if (i == 0) {
          break label332;
        }
        l2 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        label210:
        if (l2 != 2L) {
          break label364;
        }
        if (i == 0) {
          break label347;
        }
      }
      label259:
      label273:
      label288:
      label301:
      label315:
      label332:
      label347:
      for (l2 = getu32(paramFileChannel, localByteBuffer, 4L + l5);; l2 = get64(paramFileChannel, localByteBuffer, 8L + l5))
      {
        if (l2 != 0L) {
          break label380;
        }
        throw new ElfError("ELF file does not contain dynamic linking information");
        i = 0;
        break;
        l1 = get64(paramFileChannel, localByteBuffer, 32L);
        break label92;
        l2 = getu16(paramFileChannel, localByteBuffer, 56L);
        break label108;
        j = getu16(paramFileChannel, localByteBuffer, 54L);
        break label122;
        l2 = get64(paramFileChannel, localByteBuffer, 40L);
        break label150;
        l2 = getu32(paramFileChannel, localByteBuffer, 44L + l2);
        break label168;
        l2 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        break label210;
      }
      label364:
      l5 += j;
    }
    label380:
    int m = 0;
    long l5 = l2;
    long l7 = 0L;
    if (i != 0) {
      l6 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
    }
    while (l6 == 1L) {
      if (m == 2147483647)
      {
        throw new ElfError("malformed DT_NEEDED section");
        l6 = get64(paramFileChannel, localByteBuffer, 0L + l5);
      }
      else
      {
        k = m + 1;
        l3 = l7;
        label454:
        if (i == 0) {
          break label558;
        }
      }
    }
    label558:
    for (l7 = 8L;; l7 = 16L)
    {
      l5 += l7;
      m = k;
      l7 = l3;
      if (l6 != 0L) {
        break;
      }
      if (l3 != 0L) {
        break label566;
      }
      throw new ElfError("Dynamic section string-table not found");
      k = m;
      l3 = l7;
      if (l6 != 5L) {
        break label454;
      }
      if (i != 0) {}
      for (l3 = getu32(paramFileChannel, localByteBuffer, 4L + l5);; l3 = get64(paramFileChannel, localByteBuffer, 8L + l5))
      {
        k = m;
        break;
      }
    }
    label566:
    l7 = 0L;
    m = 0;
    l5 = l1;
    for (;;)
    {
      l1 = l7;
      if (m < l4)
      {
        if (i == 0) {
          break label712;
        }
        l1 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        if (l1 != 1L) {
          break label778;
        }
        if (i == 0) {
          break label727;
        }
        l1 = getu32(paramFileChannel, localByteBuffer, 8L + l5);
        label630:
        if (i == 0) {
          break label744;
        }
        l6 = getu32(paramFileChannel, localByteBuffer, 20L + l5);
        label648:
        if ((l1 > l3) || (l3 >= l1 + l6)) {
          break label778;
        }
        if (i == 0) {
          break label761;
        }
      }
      label712:
      label727:
      label744:
      label761:
      for (l4 = getu32(paramFileChannel, localByteBuffer, 4L + l5);; l4 = get64(paramFileChannel, localByteBuffer, 8L + l5))
      {
        l1 = l4 + (l3 - l1);
        if (l1 != 0L) {
          break label794;
        }
        throw new ElfError("did not find file offset of DT_STRTAB table");
        l1 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        break;
        l1 = get64(paramFileChannel, localByteBuffer, 16L + l5);
        break label630;
        l6 = get64(paramFileChannel, localByteBuffer, 40L + l5);
        break label648;
      }
      label778:
      l5 += j;
      m += 1;
    }
    label794:
    String[] arrayOfString = new String[k];
    int j = 0;
    if (i != 0)
    {
      l3 = getu32(paramFileChannel, localByteBuffer, 0L + l2);
      k = j;
      if (l3 != 1L) {
        break label912;
      }
      if (i == 0) {
        break label891;
      }
    }
    label891:
    for (long l4 = getu32(paramFileChannel, localByteBuffer, 4L + l2);; l4 = get64(paramFileChannel, localByteBuffer, 8L + l2))
    {
      arrayOfString[j] = getSz(paramFileChannel, localByteBuffer, l1 + l4);
      if (j != 2147483647) {
        break label908;
      }
      throw new ElfError("malformed DT_NEEDED section");
      l3 = get64(paramFileChannel, localByteBuffer, 0L + l2);
      break;
    }
    label908:
    int k = j + 1;
    label912:
    if (i != 0) {}
    for (l4 = 8L;; l4 = 16L)
    {
      l2 += l4;
      j = k;
      if (l3 != 0L) {
        break;
      }
      if (k == arrayOfString.length) {
        break label962;
      }
      throw new ElfError("malformed DT_NEEDED section");
    }
    label962:
    return arrayOfString;
  }
  
  private static long get64(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 8, paramLong);
    return paramByteBuffer.getLong();
  }
  
  private static String getSz(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = getu8(paramFileChannel, paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong += 1L;
    }
    return localStringBuilder.toString();
  }
  
  private static int getu16(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 2, paramLong);
    return paramByteBuffer.getShort() & 0xFFFF;
  }
  
  private static long getu32(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 4, paramLong);
    return paramByteBuffer.getInt() & 0xFFFFFFFF;
  }
  
  private static short getu8(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 1, paramLong);
    return (short)(paramByteBuffer.get() & 0xFF);
  }
  
  private static void read(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
    throws IOException
  {
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    for (;;)
    {
      if (paramByteBuffer.remaining() > 0)
      {
        paramInt = paramFileChannel.read(paramByteBuffer, paramLong);
        if (paramInt != -1) {}
      }
      else
      {
        if (paramByteBuffer.remaining() <= 0) {
          break;
        }
        throw new ElfError("ELF file truncated");
      }
      paramLong += paramInt;
    }
    paramByteBuffer.position(0);
  }
  
  private static class ElfError
    extends RuntimeException
  {
    ElfError(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.soloader.MinElf
 * JD-Core Version:    0.7.0.1
 */