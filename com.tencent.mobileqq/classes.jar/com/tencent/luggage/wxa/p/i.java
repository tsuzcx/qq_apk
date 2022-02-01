package com.tencent.luggage.wxa.p;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.l.e;

final class i
{
  private static final int[] a = { x.f("isom"), x.f("iso2"), x.f("iso3"), x.f("iso4"), x.f("iso5"), x.f("iso6"), x.f("avc1"), x.f("hvc1"), x.f("hev1"), x.f("mp41"), x.f("mp42"), x.f("3g2a"), x.f("3g2b"), x.f("3gr6"), x.f("3gs6"), x.f("3ge6"), x.f("3gg6"), x.f("M4V "), x.f("M4A "), x.f("f4v "), x.f("kddi"), x.f("M4VP"), x.f("qt  "), x.f("MSNV") };
  
  private static boolean a(int paramInt)
  {
    if (paramInt >>> 8 == x.f("3gp")) {
      return true;
    }
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(e parame)
  {
    return a(parame, true);
  }
  
  private static boolean a(e parame, boolean paramBoolean)
  {
    long l2 = parame.d();
    long l1;
    if (l2 != -1L)
    {
      l1 = l2;
      if (l2 <= 4096L) {}
    }
    else
    {
      l1 = 4096L;
    }
    int n = (int)l1;
    m localm = new m(64);
    boolean bool3 = false;
    int j = 0;
    int i = 0;
    while (j < n)
    {
      localm.a(8);
      parame.c(localm.a, 0, 8);
      l2 = localm.l();
      int i1 = localm.n();
      int k = 16;
      if (l2 == 1L)
      {
        parame.c(localm.a, 8, 8);
        localm.b(16);
        l1 = localm.v();
      }
      else
      {
        l1 = l2;
        if (l2 == 0L)
        {
          long l3 = parame.d();
          l1 = l2;
          if (l3 != -1L)
          {
            l1 = parame.c();
            l1 = 8 + (l3 - l1);
          }
        }
        k = 8;
      }
      l2 = k;
      if (l1 < l2) {
        return false;
      }
      j += k;
      if (i1 != a.B) {
        if ((i1 != a.K) && (i1 != a.M))
        {
          if (j + l1 - l2 < n)
          {
            int i2 = (int)(l1 - l2);
            int m = j + i2;
            if (i1 == a.a)
            {
              if (i2 < 8) {
                return false;
              }
              localm.a(i2);
              parame.c(localm.a, 0, i2);
              i1 = i2 / 4;
              k = 0;
              for (;;)
              {
                j = i;
                if (k >= i1) {
                  break;
                }
                if (k == 1)
                {
                  localm.d(4);
                }
                else if (a(localm.n()))
                {
                  j = 1;
                  break;
                }
                k += 1;
              }
              k = j;
              if (j == 0) {
                return false;
              }
            }
            else
            {
              k = i;
              if (i2 != 0)
              {
                parame.c(i2);
                k = i;
              }
            }
            j = m;
            i = k;
          }
        }
        else
        {
          bool1 = true;
          break label421;
        }
      }
    }
    boolean bool1 = false;
    label421:
    boolean bool2 = bool3;
    if (i != 0)
    {
      bool2 = bool3;
      if (paramBoolean == bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static boolean b(e parame)
  {
    return a(parame, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.i
 * JD-Core Version:    0.7.0.1
 */