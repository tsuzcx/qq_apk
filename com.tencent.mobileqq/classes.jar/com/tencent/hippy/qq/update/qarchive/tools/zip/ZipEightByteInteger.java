package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.math.BigInteger;

public final class ZipEightByteInteger
{
  private static final int BYTE_1 = 1;
  private static final int BYTE_1_MASK = 65280;
  private static final int BYTE_1_SHIFT = 8;
  private static final int BYTE_2 = 2;
  private static final int BYTE_2_MASK = 16711680;
  private static final int BYTE_2_SHIFT = 16;
  private static final int BYTE_3 = 3;
  private static final long BYTE_3_MASK = 4278190080L;
  private static final int BYTE_3_SHIFT = 24;
  private static final int BYTE_4 = 4;
  private static final long BYTE_4_MASK = 1095216660480L;
  private static final int BYTE_4_SHIFT = 32;
  private static final int BYTE_5 = 5;
  private static final long BYTE_5_MASK = 280375465082880L;
  private static final int BYTE_5_SHIFT = 40;
  private static final int BYTE_6 = 6;
  private static final long BYTE_6_MASK = 71776119061217280L;
  private static final int BYTE_6_SHIFT = 48;
  private static final int BYTE_7 = 7;
  private static final long BYTE_7_MASK = 9151314442816847872L;
  private static final int BYTE_7_SHIFT = 56;
  private static final byte LEFTMOST_BIT = -128;
  private static final int LEFTMOST_BIT_SHIFT = 63;
  public static final ZipEightByteInteger ZERO = new ZipEightByteInteger(0L);
  private final BigInteger value;
  
  public ZipEightByteInteger(long paramLong)
  {
    this(BigInteger.valueOf(paramLong));
  }
  
  public ZipEightByteInteger(BigInteger paramBigInteger)
  {
    this.value = paramBigInteger;
  }
  
  public ZipEightByteInteger(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public ZipEightByteInteger(byte[] paramArrayOfByte, int paramInt)
  {
    this.value = getValue(paramArrayOfByte, paramInt);
  }
  
  public static byte[] getBytes(long paramLong)
  {
    return getBytes(BigInteger.valueOf(paramLong));
  }
  
  public static byte[] getBytes(BigInteger paramBigInteger)
  {
    byte[] arrayOfByte = new byte[8];
    long l = paramBigInteger.longValue();
    arrayOfByte[0] = ((byte)(int)(0xFF & l));
    arrayOfByte[1] = ((byte)(int)((0xFF00 & l) >> 8));
    arrayOfByte[2] = ((byte)(int)((0xFF0000 & l) >> 16));
    arrayOfByte[3] = ((byte)(int)((0xFF000000 & l) >> 24));
    arrayOfByte[4] = ((byte)(int)((0x0 & l) >> 32));
    arrayOfByte[5] = ((byte)(int)((0x0 & l) >> 40));
    arrayOfByte[6] = ((byte)(int)((0x0 & l) >> 48));
    arrayOfByte[7] = ((byte)(int)((l & 0x0) >> 56));
    if (paramBigInteger.testBit(63)) {
      arrayOfByte[7] = ((byte)(arrayOfByte[7] | 0xFFFFFF80));
    }
    return arrayOfByte;
  }
  
  public static long getLongValue(byte[] paramArrayOfByte)
  {
    return getLongValue(paramArrayOfByte, 0);
  }
  
  public static long getLongValue(byte[] paramArrayOfByte, int paramInt)
  {
    return getValue(paramArrayOfByte, paramInt).longValue();
  }
  
  public static BigInteger getValue(byte[] paramArrayOfByte)
  {
    return getValue(paramArrayOfByte, 0);
  }
  
  public static BigInteger getValue(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 7;
    BigInteger localBigInteger2 = BigInteger.valueOf((paramArrayOfByte[i] << 56 & 0x0) + (paramArrayOfByte[(paramInt + 6)] << 48 & 0x0) + (paramArrayOfByte[(paramInt + 5)] << 40 & 0x0) + (paramArrayOfByte[(paramInt + 4)] << 32 & 0x0) + (paramArrayOfByte[(paramInt + 3)] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 2)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00) + (paramArrayOfByte[paramInt] & 0xFF));
    BigInteger localBigInteger1 = localBigInteger2;
    if ((paramArrayOfByte[i] & 0xFFFFFF80) == -128) {
      localBigInteger1 = localBigInteger2.setBit(63);
    }
    return localBigInteger1;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof ZipEightByteInteger))) {
      return this.value.equals(((ZipEightByteInteger)paramObject).getValue());
    }
    return false;
  }
  
  public byte[] getBytes()
  {
    return getBytes(this.value);
  }
  
  public long getLongValue()
  {
    return this.value.longValue();
  }
  
  public BigInteger getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return this.value.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZipEightByteInteger value: ");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEightByteInteger
 * JD-Core Version:    0.7.0.1
 */