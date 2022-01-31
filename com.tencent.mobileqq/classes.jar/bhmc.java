public final class bhmc
  implements Cloneable
{
  private long a;
  
  public bhmc(long paramLong)
  {
    this.a = paramLong;
  }
  
  public bhmc(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public bhmc(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = (paramArrayOfByte[(paramInt + 3)] << 24 & 0xFF000000);
    this.a += (paramArrayOfByte[(paramInt + 2)] << 16 & 0xFF0000);
    this.a += (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00);
    this.a += (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public long a()
  {
    return this.a;
  }
  
  public byte[] a()
  {
    return new byte[] { (byte)(int)(this.a & 0xFF), (byte)(int)((this.a & 0xFF00) >> 8), (byte)(int)((this.a & 0xFF0000) >> 16), (byte)(int)((this.a & 0xFF000000) >> 24) };
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof bhmc))) {}
    while (this.a != ((bhmc)paramObject).a()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return (int)this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhmc
 * JD-Core Version:    0.7.0.1
 */