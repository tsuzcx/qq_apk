package com.tencent.hippy.qq.update.qarchive.tools.zip;

public final class ZipLong
  implements Cloneable
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
  public static final ZipLong CFH_SIG = new ZipLong(33639248L);
  public static final ZipLong DD_SIG = new ZipLong(134695760L);
  public static final ZipLong LFH_SIG = new ZipLong(67324752L);
  static final ZipLong ZIP64_MAGIC = new ZipLong(4294967295L);
  private final long value;
  
  public ZipLong(long paramLong)
  {
    this.value = paramLong;
  }
  
  public ZipLong(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public ZipLong(byte[] paramArrayOfByte, int paramInt)
  {
    this.value = getValue(paramArrayOfByte, paramInt);
  }
  
  public static byte[] getBytes(long paramLong)
  {
    return new byte[] { (byte)(int)(0xFF & paramLong), (byte)(int)((0xFF00 & paramLong) >> 8), (byte)(int)((0xFF0000 & paramLong) >> 16), (byte)(int)((paramLong & 0xFF000000) >> 24) };
  }
  
  public static long getValue(byte[] paramArrayOfByte)
  {
    return getValue(paramArrayOfByte, 0);
  }
  
  public static long getValue(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 2)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00) + (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof ZipLong)) {
        return false;
      }
      bool1 = bool2;
      if (this.value == ((ZipLong)paramObject).getValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public byte[] getBytes()
  {
    return getBytes(this.value);
  }
  
  public long getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return (int)this.value;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZipLong value: ");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipLong
 * JD-Core Version:    0.7.0.1
 */