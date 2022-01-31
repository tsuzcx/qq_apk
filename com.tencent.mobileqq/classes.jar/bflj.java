public final class bflj
  implements Cloneable
{
  private int a;
  
  public bflj(int paramInt)
  {
    this.a = paramInt;
  }
  
  public bflj(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public bflj(byte[] paramArrayOfByte, int paramInt)
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
    if ((paramObject == null) || (!(paramObject instanceof bflj))) {}
    while (this.a != ((bflj)paramObject).a()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bflj
 * JD-Core Version:    0.7.0.1
 */