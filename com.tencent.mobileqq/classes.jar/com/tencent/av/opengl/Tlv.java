package com.tencent.av.opengl;

public class Tlv
{
  private short a;
  private short b;
  private byte[] c;
  
  public Tlv(short paramShort1, short paramShort2, byte[] paramArrayOfByte)
  {
    this.a = paramShort1;
    this.b = paramShort2;
    this.c = paramArrayOfByte;
  }
  
  public short a()
  {
    return this.a;
  }
  
  public short b()
  {
    return this.b;
  }
  
  public byte[] c()
  {
    return this.c;
  }
  
  public int d()
  {
    return b() + 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.Tlv
 * JD-Core Version:    0.7.0.1
 */