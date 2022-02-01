package com.tencent.av.config;

public class ByteBuffer
{
  private byte[] a = null;
  private int b = 0;
  private int c = 0;
  
  public ByteBuffer()
  {
    int i = 0;
    while (i < 512)
    {
      this.a[i] = 0;
      i += 1;
    }
    this.b = 0;
    this.c = 0;
  }
  
  public void a(byte paramByte)
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    arrayOfByte[i] = paramByte;
    this.b = (i + 1);
    this.c += 1;
  }
  
  public void a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    byte[] arrayOfByte = this.a;
    paramInt = this.b;
    System.arraycopy(new byte[] { m, k, j, i }, 0, arrayOfByte, paramInt, 4);
    this.b += 4;
    this.c += 4;
  }
  
  public byte[] a()
  {
    int i = this.c;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.a, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.ByteBuffer
 * JD-Core Version:    0.7.0.1
 */