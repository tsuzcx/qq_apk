public final class bhmd
  implements Cloneable
{
  private int a;
  
  public bhmd(int paramInt)
  {
    this.a = paramInt;
  }
  
  public bhmd(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public bhmd(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00);
    this.a += (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public byte[] a()
  {
    return new byte[] { (byte)(this.a & 0xFF), (byte)((this.a & 0xFF00) >> 8) };
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof bhmd))) {}
    while (this.a != ((bhmd)paramObject).a()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhmd
 * JD-Core Version:    0.7.0.1
 */