package com.tencent.luggage.wxa.ao;

public final class g
{
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  public final long h;
  
  public g(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.a(paramInt * 8);
    this.a = paramArrayOfByte.c(16);
    this.b = paramArrayOfByte.c(16);
    this.c = paramArrayOfByte.c(24);
    this.d = paramArrayOfByte.c(24);
    this.e = paramArrayOfByte.c(20);
    this.f = (paramArrayOfByte.c(3) + 1);
    this.g = (paramArrayOfByte.c(5) + 1);
    this.h = ((paramArrayOfByte.c(4) & 0xF) << 32 | paramArrayOfByte.c(32) & 0xFFFFFFFF);
  }
  
  public int a()
  {
    return this.g * this.e;
  }
  
  public long b()
  {
    return this.h * 1000000L / this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.g
 * JD-Core Version:    0.7.0.1
 */