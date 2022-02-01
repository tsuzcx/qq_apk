package com.tencent.luggage.wxa.gp;

import com.tencent.luggage.wxa.gw.b;
import java.util.Arrays;

public class k
  implements j
{
  private int a = 0;
  private int b = 0;
  private short[] c;
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    b.b("MicroMsg.Mix.LinearResampleAlgorithm", "linear resample algorithm  sSample:%d, dSample:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.a = paramInt1;
    this.b = paramInt2;
    return true;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a.a(paramArrayOfByte, paramArrayOfByte.length);
    int k = paramArrayOfByte.length - 1;
    int m = (int)(paramArrayOfByte.length * (this.b / this.a));
    short[] arrayOfShort = this.c;
    if ((arrayOfShort == null) || (arrayOfShort.length != m)) {
      this.c = new short[m];
    }
    arrayOfShort = this.c;
    int i = 0;
    Arrays.fill(arrayOfShort, 0, m, (short)0);
    while (i < m)
    {
      float f = i * this.a / this.b;
      int n = (int)f;
      f -= n;
      int j;
      if (n == k) {
        j = k;
      } else {
        j = n + 1;
      }
      this.c[i] = ((short)(int)((1.0F - f) * paramArrayOfByte[n] + f * paramArrayOfByte[j]));
      i += 1;
    }
    return a.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gp.k
 * JD-Core Version:    0.7.0.1
 */