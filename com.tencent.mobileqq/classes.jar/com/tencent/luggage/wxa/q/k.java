package com.tencent.luggage.wxa.q;

import android.util.Log;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.p;
import java.util.Arrays;

final class k
{
  public static int a(int paramInt)
  {
    int i = 0;
    while (paramInt > 0)
    {
      i += 1;
      paramInt >>>= 1;
    }
    return i;
  }
  
  private static long a(long paramLong1, long paramLong2)
  {
    double d1 = paramLong1;
    double d2 = paramLong2;
    Double.isNaN(d2);
    return Math.floor(Math.pow(d1, 1.0D / d2));
  }
  
  public static k.d a(m paramm)
  {
    a(1, paramm, false);
    long l1 = paramm.m();
    int i = paramm.g();
    long l2 = paramm.m();
    int j = paramm.o();
    int k = paramm.o();
    int m = paramm.o();
    int i1 = paramm.g();
    int n = (int)Math.pow(2.0D, i1 & 0xF);
    i1 = (int)Math.pow(2.0D, (i1 & 0xF0) >> 4);
    boolean bool;
    if ((paramm.g() & 0x1) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return new k.d(l1, i, l2, j, k, m, n, i1, bool, Arrays.copyOf(paramm.a, paramm.c()));
  }
  
  private static void a(int paramInt, i parami)
  {
    int m = parami.a(6);
    int i = 0;
    while (i < m + 1)
    {
      int j = parami.a(16);
      if (j != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mapping type other than 0 not supported: ");
        localStringBuilder.append(j);
        Log.e("VorbisUtil", localStringBuilder.toString());
      }
      else
      {
        if (parami.a()) {
          j = parami.a(4) + 1;
        } else {
          j = 1;
        }
        if (parami.a())
        {
          int n = parami.a(8);
          k = 0;
          while (k < n + 1)
          {
            int i1 = paramInt - 1;
            parami.b(a(i1));
            parami.b(a(i1));
            k += 1;
          }
        }
        if (parami.a(2) != 0) {
          break label225;
        }
        if (j > 1)
        {
          k = 0;
          while (k < paramInt)
          {
            parami.b(4);
            k += 1;
          }
        }
        int k = 0;
        while (k < j)
        {
          parami.b(8);
          parami.b(8);
          parami.b(8);
          k += 1;
        }
      }
      i += 1;
      continue;
      label225:
      throw new p("to reserved bits must be zero after mapping coupling steps");
    }
  }
  
  public static boolean a(int paramInt, m paramm, boolean paramBoolean)
  {
    if (paramm.b() < 7)
    {
      if (paramBoolean) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("too short header: ");
      localStringBuilder.append(paramm.b());
      throw new p(localStringBuilder.toString());
    }
    if (paramm.g() != paramInt)
    {
      if (paramBoolean) {
        return false;
      }
      paramm = new StringBuilder();
      paramm.append("expected header type ");
      paramm.append(Integer.toHexString(paramInt));
      throw new p(paramm.toString());
    }
    if ((paramm.g() == 118) && (paramm.g() == 111) && (paramm.g() == 114) && (paramm.g() == 98) && (paramm.g() == 105) && (paramm.g() == 115)) {
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    throw new p("expected characters 'vorbis'");
  }
  
  public static k.c[] a(m paramm, int paramInt)
  {
    int j = 0;
    a(5, paramm, false);
    int k = paramm.g();
    i locali = new i(paramm.a);
    locali.b(paramm.d() * 8);
    int i = 0;
    while (i < k + 1)
    {
      d(locali);
      i += 1;
    }
    k = locali.a(6);
    i = j;
    while (i < k + 1) {
      if (locali.a(16) == 0) {
        i += 1;
      } else {
        throw new p("placeholder of time domain transforms not zeroed out");
      }
    }
    c(locali);
    b(locali);
    a(paramInt, locali);
    paramm = a(locali);
    if (locali.a()) {
      return paramm;
    }
    paramm = new p("framing bit after modes not set as expected");
    for (;;)
    {
      throw paramm;
    }
  }
  
  private static k.c[] a(i parami)
  {
    int j = parami.a(6) + 1;
    k.c[] arrayOfc = new k.c[j];
    int i = 0;
    while (i < j)
    {
      arrayOfc[i] = new k.c(parami.a(), parami.a(16), parami.a(16), parami.a(8));
      i += 1;
    }
    return arrayOfc;
  }
  
  public static k.b b(m paramm)
  {
    int i = 0;
    a(3, paramm, false);
    String str = paramm.e((int)paramm.m());
    int j = str.length();
    long l = paramm.m();
    String[] arrayOfString = new String[(int)l];
    j = 11 + j + 4;
    while (i < l)
    {
      arrayOfString[i] = paramm.e((int)paramm.m());
      j = j + 4 + arrayOfString[i].length();
      i += 1;
    }
    if ((paramm.g() & 0x1) != 0) {
      return new k.b(str, arrayOfString, j + 1);
    }
    paramm = new p("framing bit expected to be set");
    for (;;)
    {
      throw paramm;
    }
  }
  
  private static void b(i parami)
  {
    int m = parami.a(6);
    int i = 0;
    while (i < m + 1) {
      if (parami.a(16) <= 2)
      {
        parami.b(24);
        parami.b(24);
        parami.b(24);
        int n = parami.a(6) + 1;
        parami.b(8);
        int[] arrayOfInt = new int[n];
        int j = 0;
        int k;
        while (j < n)
        {
          int i1 = parami.a(3);
          if (parami.a()) {
            k = parami.a(5);
          } else {
            k = 0;
          }
          arrayOfInt[j] = (k * 8 + i1);
          j += 1;
        }
        j = 0;
        while (j < n)
        {
          k = 0;
          while (k < 8)
          {
            if ((arrayOfInt[j] & 1 << k) != 0) {
              parami.b(8);
            }
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
      else
      {
        throw new p("residueType greater than 2 is not decodable");
      }
    }
  }
  
  private static void c(i parami)
  {
    int n = parami.a(6);
    int i = 0;
    while (i < n + 1)
    {
      int j = parami.a(16);
      if (j != 0)
      {
        if (j == 1)
        {
          int i1 = parami.a(5);
          int[] arrayOfInt1 = new int[i1];
          j = 0;
          for (k = -1; j < i1; k = m)
          {
            arrayOfInt1[j] = parami.a(4);
            m = k;
            if (arrayOfInt1[j] > k) {
              m = arrayOfInt1[j];
            }
            j += 1;
          }
          int[] arrayOfInt2 = new int[k + 1];
          j = 0;
          while (j < arrayOfInt2.length)
          {
            arrayOfInt2[j] = (parami.a(3) + 1);
            m = parami.a(2);
            if (m > 0) {
              parami.b(8);
            }
            k = 0;
            while (k < 1 << m)
            {
              parami.b(8);
              k += 1;
            }
            j += 1;
          }
          parami.b(2);
          int i2 = parami.a(4);
          j = 0;
          int m = 0;
          k = 0;
          while (j < i1)
          {
            m += arrayOfInt2[arrayOfInt1[j]];
            while (k < m)
            {
              parami.b(i2);
              k += 1;
            }
            j += 1;
          }
        }
        parami = new StringBuilder();
        parami.append("floor type greater than 1 not decodable: ");
        parami.append(j);
        throw new p(parami.toString());
      }
      parami.b(8);
      parami.b(16);
      parami.b(16);
      parami.b(6);
      parami.b(8);
      int k = parami.a(4);
      j = 0;
      while (j < k + 1)
      {
        parami.b(8);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static k.a d(i parami)
  {
    if (parami.a(24) == 5653314)
    {
      int m = parami.a(16);
      int n = parami.a(24);
      localObject = new long[n];
      boolean bool1 = parami.a();
      long l = 0L;
      int i = 0;
      if (!bool1)
      {
        boolean bool2 = parami.a();
        while (i < localObject.length)
        {
          if (bool2)
          {
            if (parami.a()) {
              localObject[i] = (parami.a(5) + 1);
            } else {
              localObject[i] = 0L;
            }
          }
          else {
            localObject[i] = (parami.a(5) + 1);
          }
          i += 1;
        }
      }
      int j = parami.a(5) + 1;
      i = 0;
      while (i < localObject.length)
      {
        int i1 = parami.a(a(n - i));
        int k = 0;
        while ((k < i1) && (i < localObject.length))
        {
          localObject[i] = j;
          i += 1;
          k += 1;
        }
        j += 1;
      }
      i = parami.a(4);
      if (i <= 2)
      {
        if ((i == 1) || (i == 2))
        {
          parami.b(32);
          parami.b(32);
          j = parami.a(4);
          parami.b(1);
          if (i == 1)
          {
            if (m != 0) {
              l = a(n, m);
            }
          }
          else {
            l = n * m;
          }
          parami.b((int)(l * (j + 1)));
        }
        return new k.a(m, n, (long[])localObject, i, bool1);
      }
      parami = new StringBuilder();
      parami.append("lookup type greater than 2 not decodable: ");
      parami.append(i);
      throw new p(parami.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("expected code book to start with [0x56, 0x43, 0x42] at ");
    ((StringBuilder)localObject).append(parami.b());
    parami = new p(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw parami;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.k
 * JD-Core Version:    0.7.0.1
 */