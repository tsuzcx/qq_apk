package com.tencent.luggage.wxa.gs;

import com.tencent.luggage.wxa.gm.e;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public abstract class f
  implements g
{
  protected short[][] a = (short[][])Array.newInstance(Short.TYPE, new int[] { 1, 1 });
  protected int b = 1;
  protected int c = 1;
  protected short[] d = new short[1];
  protected int e = 1;
  protected int f = 32767;
  protected int g = -32768;
  protected com.tencent.luggage.wxa.gm.b h;
  
  private byte[] a(byte[][] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      byte[] arrayOfByte1 = paramArrayOfByte[0];
      if (arrayOfByte1 != null)
      {
        if (arrayOfByte1.length == 0) {
          return null;
        }
        Object localObject;
        if (paramArrayOfByte.length == 1)
        {
          localObject = a();
          if (localObject != null)
          {
            paramArrayOfByte = (byte[][])localObject;
            if (localObject.length == arrayOfByte1.length) {}
          }
          else
          {
            paramArrayOfByte = new byte[arrayOfByte1.length];
          }
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, arrayOfByte1.length);
          return paramArrayOfByte;
        }
        int i = 0;
        while (i < paramArrayOfByte.length)
        {
          if (paramArrayOfByte[i].length != arrayOfByte1.length)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("column of the road of audio + ");
            paramArrayOfByte.append(i);
            paramArrayOfByte.append(" is different.");
            com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.BaseAudioMixAlgorithm", paramArrayOfByte.toString());
            return null;
          }
          i += 1;
        }
        int k = paramArrayOfByte.length;
        int m = arrayOfByte1.length / 2;
        if ((k != this.b) || (m != this.c))
        {
          this.a = ((short[][])Array.newInstance(Short.TYPE, new int[] { k, m }));
          this.b = k;
          this.c = m;
        }
        i = 0;
        while (i < k)
        {
          Arrays.fill(this.a[i], 0, m - 1, (short)0);
          int j = 0;
          while (j < m)
          {
            localObject = this.a[i];
            byte[] arrayOfByte2 = paramArrayOfByte[i];
            int n = j * 2;
            localObject[j] = ((short)(arrayOfByte2[n] & 0xFF | (paramArrayOfByte[i][(n + 1)] & 0xFF) << 8));
            j += 1;
          }
          i += 1;
        }
        if (this.e != m)
        {
          this.e = m;
          this.d = new short[m];
        }
        Arrays.fill(this.d, 0, m - 1, (short)0);
        return a(k, m, arrayOfByte1.length);
      }
    }
    return null;
  }
  
  protected short a(int paramInt)
  {
    int i = this.f;
    if (paramInt > i) {
      return (short)i;
    }
    i = this.g;
    if (paramInt < i) {
      return (short)i;
    }
    return (short)paramInt;
  }
  
  public boolean a(com.tencent.luggage.wxa.gm.b paramb, List<e> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject = new byte[paramList.size()][];
      int i = 0;
      while (i < paramList.size())
      {
        localObject[i] = ((e)paramList.get(i)).f;
        i += 1;
      }
      this.h = paramb;
      localObject = a((byte[][])localObject);
      if (localObject == null)
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.BaseAudioMixAlgorithm", "mixed data is invalid");
        return false;
      }
      paramb.d = ((byte[])localObject);
      paramb.b = ((e)paramList.get(0)).c;
      paramb.a = ((e)paramList.get(0)).b;
      return true;
    }
    com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.BaseAudioMixAlgorithm", "process list is invalid");
    return false;
  }
  
  protected byte[] a()
  {
    com.tencent.luggage.wxa.gm.b localb = this.h;
    if (localb != null) {
      return localb.d;
    }
    return null;
  }
  
  protected byte[] a(int paramInt1, int paramInt2)
  {
    Object localObject2 = a();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length == paramInt1) {}
    }
    else
    {
      localObject1 = new byte[paramInt1];
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      int i = paramInt1 * 2;
      localObject2 = this.d;
      localObject1[i] = ((byte)(localObject2[paramInt1] & 0xFF));
      localObject1[(i + 1)] = ((byte)((localObject2[paramInt1] & 0xFF00) >> 8));
      paramInt1 += 1;
    }
    return localObject1;
  }
  
  protected abstract byte[] a(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.f
 * JD-Core Version:    0.7.0.1
 */