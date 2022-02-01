package com.tencent.luggage.wxa.gl;

public final class g
{
  public static int a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0);
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 3)];
    int j = paramArrayOfByte[(paramInt + 2)];
    int k = paramArrayOfByte[(paramInt + 1)];
    return (paramArrayOfByte[paramInt] & 0xFF) << 0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gl.g
 * JD-Core Version:    0.7.0.1
 */