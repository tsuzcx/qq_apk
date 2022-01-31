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
    return new byte[] { (byte)(int)(this.a & 0xFF), (byte)(int)((this.a & 0xFF00) >> 8), (byte)(int)((this.a & 0xFF0000) >> 16), (byte)(int)((this.a & 0xFF000000) >> 24) };
  }
  
  public long b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof b))) {}
    while (this.a != ((b)paramObject).b()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return (int)this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.a.b
 * JD-Core Version:    0.7.0.1
 */