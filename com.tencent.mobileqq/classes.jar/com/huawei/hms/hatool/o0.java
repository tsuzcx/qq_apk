package com.huawei.hms.hatool;

public class o0
{
  public byte[] a = null;
  public int b = 0;
  
  public o0(int paramInt)
  {
    this.a = new byte[paramInt];
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    byte[] arrayOfByte1 = this.a;
    int i = arrayOfByte1.length;
    int j = this.b;
    if (i - j >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, j, paramInt);
    }
    else
    {
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramInt << 1];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, this.b, paramInt);
      this.a = arrayOfByte2;
    }
    this.b += paramInt;
  }
  
  public byte[] a()
  {
    int i = this.b;
    if (i <= 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.a, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.o0
 * JD-Core Version:    0.7.0.1
 */