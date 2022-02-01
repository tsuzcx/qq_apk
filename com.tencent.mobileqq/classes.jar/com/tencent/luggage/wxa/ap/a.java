package com.tencent.luggage.wxa.ap;

import com.tencent.luggage.wxa.ao.d;
import com.tencent.luggage.wxa.ao.k;
import com.tencent.luggage.wxa.ao.k.b;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.p;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public final List<byte[]> a;
  public final int b;
  public final int c;
  public final int d;
  public final float e;
  
  private a(List<byte[]> paramList, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.a = paramList;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramFloat;
  }
  
  public static a a(m paramm)
  {
    try
    {
      paramm.d(4);
      k = (paramm.g() & 0x3) + 1;
      if (k == 3) {
        break label165;
      }
      localArrayList = new ArrayList();
      j = paramm.g() & 0x1F;
      i = 0;
      while (i < j)
      {
        localArrayList.add(b(paramm));
        i += 1;
      }
      int m = paramm.g();
      i = 0;
      while (i < m)
      {
        localArrayList.add(b(paramm));
        i += 1;
      }
      if (j <= 0) {
        break label193;
      }
      paramm = (byte[])localArrayList.get(0);
      paramm = k.a((byte[])localArrayList.get(0), k, paramm.length);
      i = paramm.b;
      j = paramm.c;
      f = paramm.d;
    }
    catch (ArrayIndexOutOfBoundsException paramm)
    {
      for (;;)
      {
        int k;
        ArrayList localArrayList;
        label165:
        paramm = new p("Error parsing AVC config", paramm);
        for (;;)
        {
          throw paramm;
        }
        label193:
        int i = -1;
        int j = -1;
        float f = 1.0F;
      }
    }
    return new a(localArrayList, k, i, j, f);
    throw new IllegalStateException();
  }
  
  private static byte[] b(m paramm)
  {
    int i = paramm.h();
    int j = paramm.d();
    paramm.d(i);
    return d.a(paramm.a, j, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.a
 * JD-Core Version:    0.7.0.1
 */