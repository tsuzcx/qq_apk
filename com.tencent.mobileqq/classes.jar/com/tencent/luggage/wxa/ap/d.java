package com.tencent.luggage.wxa.ap;

import com.tencent.luggage.wxa.ao.k;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.p;
import java.util.Collections;
import java.util.List;

public final class d
{
  public final List<byte[]> a;
  public final int b;
  
  private d(List<byte[]> paramList, int paramInt)
  {
    this.a = paramList;
    this.b = paramInt;
  }
  
  public static d a(m paramm)
  {
    try
    {
      paramm.d(21);
      n = paramm.g();
      i1 = paramm.g();
      m = paramm.d();
      j = 0;
      i = 0;
    }
    catch (ArrayIndexOutOfBoundsException paramm)
    {
      for (;;)
      {
        int n;
        int i1;
        int m;
        int j;
        int i;
        int i2;
        int k;
        int i3;
        byte[] arrayOfByte;
        paramm = new p("Error parsing HEVC config", paramm);
        for (;;)
        {
          throw paramm;
        }
        j += 1;
        continue;
        k += 1;
        continue;
        if (i == 0) {
          paramm = null;
        }
      }
    }
    if (j < i1)
    {
      paramm.d(1);
      i2 = paramm.h();
      k = 0;
      while (k < i2)
      {
        i3 = paramm.h();
        i += i3 + 4;
        paramm.d(i3);
        k += 1;
      }
    }
    paramm.c(m);
    arrayOfByte = new byte[i];
    k = 0;
    j = 0;
    if (k < i1)
    {
      paramm.d(1);
      i2 = paramm.h();
      m = 0;
      while (m < i2)
      {
        i3 = paramm.h();
        System.arraycopy(k.a, 0, arrayOfByte, j, k.a.length);
        j += k.a.length;
        System.arraycopy(paramm.a, paramm.d(), arrayOfByte, j, i3);
        j += i3;
        paramm.d(i3);
        m += 1;
      }
      paramm = Collections.singletonList(arrayOfByte);
      paramm = new d(paramm, (n & 0x3) + 1);
      return paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.d
 * JD-Core Version:    0.7.0.1
 */