package com.tencent.luggage.wxa.gp;

import com.tencent.luggage.wxa.gw.b;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;

public class l
  implements j
{
  private int a = 0;
  private int b = 0;
  private String c;
  
  public boolean a()
  {
    if (SilkResampleJni.clearResample(this.c) == -1)
    {
      b.a("MicroMsg.Mix.SilkResampleAlgorithm", "clearResample result is -1");
      return false;
    }
    b.b("MicroMsg.Mix.SilkResampleAlgorithm", "release");
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
    b.b("MicroMsg.Mix.SilkResampleAlgorithm", "initResample, fileName:%s, sSample:%d, dSample:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (SilkResampleJni.initResample(paramString, paramInt1, paramInt2) == -1)
    {
      b.a("MicroMsg.Mix.SilkResampleAlgorithm", "initResample result is -1, fileName:%s", new Object[] { paramString });
      return false;
    }
    return true;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a.a(paramArrayOfByte, paramArrayOfByte.length);
    int i = paramArrayOfByte.length;
    int k = this.b;
    int m = this.a;
    int j = i * k / m;
    i = j;
    if (k % m != 0) {
      i = j + 1;
    }
    short[] arrayOfShort = new short[i];
    if (SilkResampleJni.resamplePcm(this.c, this.a, this.b, paramArrayOfByte, paramArrayOfByte.length, arrayOfShort) == -1)
    {
      b.a("MicroMsg.Mix.SilkResampleAlgorithm", "resamplePcm result is -1, fileName:%s", new Object[] { this.c });
      return null;
    }
    return a.a(arrayOfShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gp.l
 * JD-Core Version:    0.7.0.1
 */