package com.tencent.dlsdk.yybutil.apkchannel.a;

public final class b
  implements Cloneable
{
  private long a;
  
  public b(long paramLong)
  {
    this.a = paramLong;
  }
  
  public byte[] a()
  {
    long l = this.a;
    return new byte[] { (byte)(int)(0xFF & l), (byte)(int)((0xFF00 & l) >> 8), (byte)(int)((0xFF0000 & l) >> 16), (byte)(int)((l & 0xFF000000) >> 24) };
  }
  
  public long b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof b)) {
        return false;
      }
      if (this.a == ((b)paramObject).b()) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.a.b
 * JD-Core Version:    0.7.0.1
 */