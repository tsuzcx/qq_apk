package com.tencent.luggage.wxa.a;

class e
{
  private static final float[] b = { 1.0F, 10.0F, 100.0F, 1000.0F, 10000.0F, 100000.0F, 1000000.0F, 10000000.0F, 1.0E+008F, 1.0E+009F, 1.0E+010F, 1.0E+011F, 1.0E+012F, 1.0E+013F, 1.0E+014F, 1.0E+015F, 1.0E+016F, 1.0E+017F, 1.0E+018F, 1.0E+019F, 1.0E+020F, 1.0E+021F, 1.0E+022F, 1.0E+023F, 1.0E+024F, 1.0E+025F, 1.0E+026F, 1.0E+027F, 9.999999E+027F, 1.0E+029F, 1.0E+030F, 1.0E+031F, 1.0E+032F, 1.0E+033F, 1.0E+034F, 1.0E+035F, 1.0E+036F, 1.0E+037F, 1.0E+038F };
  private static final float[] c = { 1.0F, 0.1F, 0.01F, 0.001F, 1.0E-004F, 1.0E-005F, 1.0E-006F, 1.0E-007F, 1.0E-008F, 1.0E-009F, 1.0E-010F, 1.0E-011F, 1.0E-012F, 1.0E-013F, 1.0E-014F, 1.0E-015F, 1.0E-016F, 1.0E-017F, 1.0E-018F, 1.0E-019F, 1.0E-020F, 1.0E-021F, 1.0E-022F, 1.0E-023F, 1.0E-024F, 1.0E-025F, 1.0E-026F, 1.0E-027F, 1.0E-028F, 1.0E-029F, 1.0E-030F, 1.0E-031F, 1.0E-032F, 1.0E-033F, 1.0E-034F, 1.0E-035F, 1.0E-036F, 1.0E-037F, 9.999999E-039F };
  private int a;
  
  float a(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    paramInt1 = this.a;
    if (paramInt1 >= paramInt2) {
      return (0.0F / 0.0F);
    }
    paramInt1 = paramString.charAt(paramInt1);
    if (paramInt1 != 43)
    {
      if (paramInt1 != 45)
      {
        k = 0;
        break label62;
      }
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = 0;
    }
    this.a += 1;
    int k = paramInt1;
    label62:
    int i2 = this.a;
    long l1 = 0L;
    int i = 0;
    paramInt1 = 0;
    int n = 0;
    int i1 = 0;
    int m = 0;
    for (;;)
    {
      j = this.a;
      if (j >= paramInt2) {
        break;
      }
      int i3 = paramString.charAt(j);
      if (i3 == 48)
      {
        if (i == 0) {
          n += 1;
        } else {
          paramInt1 += 1;
        }
      }
      else if ((i3 >= 49) && (i3 <= 57))
      {
        j = paramInt1;
        while (j > 0)
        {
          if (l1 > 922337203685477580L) {
            return (0.0F / 0.0F);
          }
          l1 *= 10L;
          j -= 1;
        }
        if (l1 > 922337203685477580L) {
          return (0.0F / 0.0F);
        }
        long l2 = l1 * 10L + (i3 - 48);
        i = i + paramInt1 + 1;
        paramInt1 = j;
        l1 = l2;
        if (l2 < 0L) {
          return (0.0F / 0.0F);
        }
      }
      else
      {
        if ((i3 != 46) || (i1 != 0)) {
          break;
        }
        m = this.a - i2;
        i1 = 1;
      }
      this.a += 1;
    }
    if ((i1 != 0) && (this.a == m + 1)) {
      return (0.0F / 0.0F);
    }
    int j = i;
    if (i == 0)
    {
      if (n == 0) {
        return (0.0F / 0.0F);
      }
      j = 1;
    }
    i = paramInt1;
    if (i1 != 0) {
      i = m - n - j;
    }
    m = this.a;
    paramInt1 = i;
    if (m < paramInt2)
    {
      m = paramString.charAt(m);
      if (m != 69)
      {
        paramInt1 = i;
        if (m != 101) {}
      }
      else
      {
        this.a += 1;
        paramInt1 = this.a;
        if (paramInt1 == paramInt2) {
          return (0.0F / 0.0F);
        }
        paramInt1 = paramString.charAt(paramInt1);
        if (paramInt1 != 43)
        {
          if (paramInt1 != 45)
          {
            switch (paramInt1)
            {
            default: 
              this.a -= 1;
            }
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              m = 0;
              n = paramInt1;
              break;
            }
          }
          paramInt1 = 1;
        }
        else
        {
          paramInt1 = 0;
        }
        this.a += 1;
        n = 0;
        m = paramInt1;
        paramInt1 = i;
        if (n == 0)
        {
          n = this.a;
          paramInt1 = 0;
          for (;;)
          {
            i1 = this.a;
            if (i1 >= paramInt2) {
              break;
            }
            i1 = paramString.charAt(i1);
            if ((i1 < 48) || (i1 > 57)) {
              break;
            }
            if (paramInt1 > 922337203685477580L) {
              return (0.0F / 0.0F);
            }
            paramInt1 = paramInt1 * 10 + (i1 - 48);
            this.a += 1;
          }
          if (this.a == n) {
            return (0.0F / 0.0F);
          }
          if (m != 0) {
            paramInt1 = i - paramInt1;
          } else {
            paramInt1 = i + paramInt1;
          }
        }
      }
    }
    paramInt2 = j + paramInt1;
    if (paramInt2 <= 39)
    {
      if (paramInt2 < -44) {
        return (0.0F / 0.0F);
      }
      float f1 = (float)l1;
      float f2 = f1;
      if (l1 != 0L)
      {
        if (paramInt1 > 0) {}
        float f3;
        for (f2 = b[paramInt1];; f2 = f3)
        {
          f2 = f1 * f2;
          break;
          f2 = f1;
          if (paramInt1 >= 0) {
            break;
          }
          f2 = f1;
          paramInt2 = paramInt1;
          if (paramInt1 < -38)
          {
            double d = f1;
            Double.isNaN(d);
            f2 = (float)(d * 1.0E-020D);
            paramInt2 = paramInt1 + 20;
          }
          f3 = c[(-paramInt2)];
          f1 = f2;
        }
      }
      f1 = f2;
      if (k != 0) {
        f1 = -f2;
      }
      return f1;
    }
    return (0.0F / 0.0F);
  }
  
  int a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.e
 * JD-Core Version:    0.7.0.1
 */