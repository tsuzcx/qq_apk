package com.tencent.luggage.wxa.ae;

import android.util.Log;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.l.l;

public final class g
{
  private static int a(m paramm)
  {
    int i = 0;
    int k;
    int j;
    do
    {
      if (paramm.b() == 0) {
        return -1;
      }
      k = paramm.g();
      j = i + k;
      i = j;
    } while (k == 255);
    return j;
  }
  
  public static void a(long paramLong, m paramm, l[] paramArrayOfl)
  {
    while (paramm.b() > 1)
    {
      int i = a(paramm);
      int j = a(paramm);
      if ((j != -1) && (j <= paramm.b()))
      {
        if (a(i, j, paramm))
        {
          paramm.d(8);
          i = paramm.g();
          paramm.d(1);
          int k = (i & 0x1F) * 3;
          int m = paramm.d();
          int n = paramArrayOfl.length;
          i = 0;
          while (i < n)
          {
            l locall = paramArrayOfl[i];
            paramm.c(m);
            locall.a(paramm, k);
            locall.a(paramLong, 1, k, 0, null);
            i += 1;
          }
          paramm.d(j - (k + 10));
        }
        else
        {
          paramm.d(j);
        }
      }
      else
      {
        Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
        paramm.c(paramm.c());
      }
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 4)
    {
      if (paramInt2 < 8) {
        return false;
      }
      paramInt1 = paramm.d();
      paramInt2 = paramm.g();
      int i = paramm.h();
      int j = paramm.n();
      int k = paramm.g();
      paramm.c(paramInt1);
      bool1 = bool2;
      if (paramInt2 == 181)
      {
        bool1 = bool2;
        if (i == 49)
        {
          bool1 = bool2;
          if (j == 1195456820)
          {
            bool1 = bool2;
            if (k == 3) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ae.g
 * JD-Core Version:    0.7.0.1
 */