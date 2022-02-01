package com.huawei.hms.stats;

public class ax
{
  private byte[] a = null;
  private int b = 1024;
  private int c = 0;
  
  public ax()
  {
    this.a = new byte[this.b];
  }
  
  public ax(int paramInt)
  {
    this.b = paramInt;
    this.a = new byte[paramInt];
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (this.a.length - this.c >= paramInt) {
      System.arraycopy(paramArrayOfByte, 0, this.a, this.c, paramInt);
    }
    for (;;)
    {
      this.c += paramInt;
      return;
      byte[] arrayOfByte = new byte[this.a.length + paramInt << 1];
      System.arraycopy(this.a, 0, arrayOfByte, 0, this.c);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.c, paramInt);
      this.a = arrayOfByte;
    }
  }
  
  public byte[] b()
  {
    if (this.c <= 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[this.c];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.c);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.ax
 * JD-Core Version:    0.7.0.1
 */