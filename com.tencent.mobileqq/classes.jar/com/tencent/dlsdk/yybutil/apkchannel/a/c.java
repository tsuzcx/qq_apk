package com.tencent.dlsdk.yybutil.apkchannel.a;

public final class c
  implements Cloneable
{
  private int a;
  
  public c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public c(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public c(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00);
    this.a += (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public byte[] a()
  {
    int i = this.a;
    return new byte[] { (byte)(i & 0xFF), (byte)((i & 0xFF00) >> 8) };
  }
  
  public int b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof c)) {
        return false;
      }
      if (this.a == ((c)paramObject).b()) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.a.c
 * JD-Core Version:    0.7.0.1
 */