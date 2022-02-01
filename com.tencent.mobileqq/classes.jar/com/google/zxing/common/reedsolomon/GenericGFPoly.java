package com.google.zxing.common.reedsolomon;

final class GenericGFPoly
{
  private final GenericGF a;
  private final int[] b;
  
  GenericGFPoly(GenericGF paramGenericGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length != 0)
    {
      this.a = paramGenericGF;
      int j = paramArrayOfInt.length;
      int i = 1;
      if ((j > 1) && (paramArrayOfInt[0] == 0))
      {
        while ((i < j) && (paramArrayOfInt[i] == 0)) {
          i += 1;
        }
        if (i == j)
        {
          this.b = paramGenericGF.a().b;
          return;
        }
        this.b = new int[j - i];
        paramGenericGF = this.b;
        System.arraycopy(paramArrayOfInt, i, paramGenericGF, 0, paramGenericGF.length);
        return;
      }
      this.b = paramArrayOfInt;
      return;
    }
    paramGenericGF = new IllegalArgumentException();
    for (;;)
    {
      throw paramGenericGF;
    }
  }
  
  int a(int paramInt)
  {
    int[] arrayOfInt = this.b;
    return arrayOfInt[(arrayOfInt.length - 1 - paramInt)];
  }
  
  GenericGFPoly a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == 0) {
        return this.a.a();
      }
      int i = this.b.length;
      localObject = new int[paramInt1 + i];
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localObject[paramInt1] = this.a.c(this.b[paramInt1], paramInt2);
        paramInt1 += 1;
      }
      return new GenericGFPoly(this.a, (int[])localObject);
    }
    Object localObject = new IllegalArgumentException();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  GenericGFPoly a(GenericGFPoly paramGenericGFPoly)
  {
    if (this.a.equals(paramGenericGFPoly.a))
    {
      if (c()) {
        return paramGenericGFPoly;
      }
      if (paramGenericGFPoly.c()) {
        return this;
      }
      int[] arrayOfInt1 = this.b;
      int[] arrayOfInt3 = paramGenericGFPoly.b;
      int[] arrayOfInt2 = arrayOfInt1;
      paramGenericGFPoly = arrayOfInt3;
      if (arrayOfInt1.length > arrayOfInt3.length)
      {
        arrayOfInt2 = arrayOfInt3;
        paramGenericGFPoly = arrayOfInt1;
      }
      arrayOfInt1 = new int[paramGenericGFPoly.length];
      int j = paramGenericGFPoly.length - arrayOfInt2.length;
      System.arraycopy(paramGenericGFPoly, 0, arrayOfInt1, 0, j);
      int i = j;
      while (i < paramGenericGFPoly.length)
      {
        arrayOfInt1[i] = GenericGF.b(arrayOfInt2[(i - j)], paramGenericGFPoly[i]);
        i += 1;
      }
      return new GenericGFPoly(this.a, arrayOfInt1);
    }
    paramGenericGFPoly = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    for (;;)
    {
      throw paramGenericGFPoly;
    }
  }
  
  int[] a()
  {
    return this.b;
  }
  
  int b()
  {
    return this.b.length - 1;
  }
  
  GenericGFPoly b(GenericGFPoly paramGenericGFPoly)
  {
    if (this.a.equals(paramGenericGFPoly.a))
    {
      if ((!c()) && (!paramGenericGFPoly.c()))
      {
        int[] arrayOfInt1 = this.b;
        int k = arrayOfInt1.length;
        paramGenericGFPoly = paramGenericGFPoly.b;
        int m = paramGenericGFPoly.length;
        int[] arrayOfInt2 = new int[k + m - 1];
        int i = 0;
        while (i < k)
        {
          int n = arrayOfInt1[i];
          int j = 0;
          while (j < m)
          {
            int i1 = i + j;
            arrayOfInt2[i1] = GenericGF.b(arrayOfInt2[i1], this.a.c(n, paramGenericGFPoly[j]));
            j += 1;
          }
          i += 1;
        }
        return new GenericGFPoly(this.a, arrayOfInt2);
      }
      return this.a.a();
    }
    paramGenericGFPoly = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    for (;;)
    {
      throw paramGenericGFPoly;
    }
  }
  
  boolean c()
  {
    int[] arrayOfInt = this.b;
    boolean bool = false;
    if (arrayOfInt[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  GenericGFPoly[] c(GenericGFPoly paramGenericGFPoly)
  {
    if (this.a.equals(paramGenericGFPoly.a))
    {
      if (!paramGenericGFPoly.c())
      {
        GenericGFPoly localGenericGFPoly2 = this.a.a();
        int i = paramGenericGFPoly.a(paramGenericGFPoly.b());
        i = this.a.c(i);
        GenericGFPoly localGenericGFPoly3;
        for (GenericGFPoly localGenericGFPoly1 = this; (localGenericGFPoly1.b() >= paramGenericGFPoly.b()) && (!localGenericGFPoly1.c()); localGenericGFPoly1 = localGenericGFPoly1.a(localGenericGFPoly3))
        {
          int j = localGenericGFPoly1.b() - paramGenericGFPoly.b();
          int k = this.a.c(localGenericGFPoly1.a(localGenericGFPoly1.b()), i);
          localGenericGFPoly3 = paramGenericGFPoly.a(j, k);
          localGenericGFPoly2 = localGenericGFPoly2.a(this.a.a(j, k));
        }
        return new GenericGFPoly[] { localGenericGFPoly2, localGenericGFPoly1 };
      }
      throw new IllegalArgumentException("Divide by 0");
    }
    paramGenericGFPoly = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    for (;;)
    {
      throw paramGenericGFPoly;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(b() * 8);
    int i = b();
    while (i >= 0)
    {
      int k = a(i);
      if (k != 0)
      {
        int j;
        if (k < 0)
        {
          localStringBuilder.append(" - ");
          j = -k;
        }
        else
        {
          j = k;
          if (localStringBuilder.length() > 0)
          {
            localStringBuilder.append(" + ");
            j = k;
          }
        }
        if ((i == 0) || (j != 1))
        {
          j = this.a.b(j);
          if (j == 0)
          {
            localStringBuilder.append('1');
          }
          else if (j == 1)
          {
            localStringBuilder.append('a');
          }
          else
          {
            localStringBuilder.append("a^");
            localStringBuilder.append(j);
          }
        }
        if (i != 0) {
          if (i == 1)
          {
            localStringBuilder.append('x');
          }
          else
          {
            localStringBuilder.append("x^");
            localStringBuilder.append(i);
          }
        }
      }
      i -= 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.GenericGFPoly
 * JD-Core Version:    0.7.0.1
 */