package com.tencent.hippy.qq.update.qarchive.tools.zip;

public final class ZipShort
  implements Cloneable
{
  private static final int BYTE_1_MASK = 65280;
  private static final int BYTE_1_SHIFT = 8;
  private final int value;
  
  public ZipShort(int paramInt)
  {
    this.value = paramInt;
  }
  
  public ZipShort(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public ZipShort(byte[] paramArrayOfByte, int paramInt)
  {
    this.value = getValue(paramArrayOfByte, paramInt);
  }
  
  public static byte[] getBytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((paramInt & 0xFF00) >> 8) };
  }
  
  public static int getValue(byte[] paramArrayOfByte)
  {
    return getValue(paramArrayOfByte, 0);
  }
  
  public static int getValue(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00) + (paramArrayOfByte[paramInt] & 0xFF);
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
      if (!(paramObject instanceof ZipShort)) {
        return false;
      }
      bool1 = bool2;
      if (this.value == ((ZipShort)paramObject).getValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public byte[] getBytes()
  {
    int i = this.value;
    return new byte[] { (byte)(i & 0xFF), (byte)((i & 0xFF00) >> 8) };
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZipShort value: ");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipShort
 * JD-Core Version:    0.7.0.1
 */