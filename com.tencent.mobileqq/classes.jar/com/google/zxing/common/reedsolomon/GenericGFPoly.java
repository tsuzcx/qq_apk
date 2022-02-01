package com.google.zxing.common.reedsolomon;

final class GenericGFPoly
{
  private final GenericGF jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  GenericGFPoly(GenericGF paramGenericGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length != 0)
    {
      this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF = paramGenericGF;
      int j = paramArrayOfInt.length;
      int i = 1;
      if ((j > 1) && (paramArrayOfInt[0] == 0))
      {
        while ((i < j) && (paramArrayOfInt[i] == 0)) {
          i += 1;
        }
        if (i == j)
        {
          this.jdField_a_of_type_ArrayOfInt = paramGenericGF.a().jdField_a_of_type_ArrayOfInt;
          return;
        }
        this.jdField_a_of_type_ArrayOfInt = new int[j - i];
        paramGenericGF = this.jdField_a_of_type_ArrayOfInt;
        System.arraycopy(paramArrayOfInt, i, paramGenericGF, 0, paramGenericGF.length);
        return;
      }
      this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
      return;
    }
    paramGenericGF = new IllegalArgumentException();
    for (;;)
    {
      throw paramGenericGF;
    }
  }
  
  int a()
  {
    return this.jdField_a_of_type_ArrayOfInt.length - 1;
  }
  
  int a(int paramInt)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    return arrayOfInt[(arrayOfInt.length - 1 - paramInt)];
  }
  
  GenericGFPoly a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == 0) {
        return this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
      }
      int i = this.jdField_a_of_type_ArrayOfInt.length;
      localObject = new int[paramInt1 + i];
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localObject[paramInt1] = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(this.jdField_a_of_type_ArrayOfInt[paramInt1], paramInt2);
        paramInt1 += 1;
      }
      return new GenericGFPoly(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, (int[])localObject);
    }
    Object localObject = new IllegalArgumentException();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  GenericGFPoly a(GenericGFPoly paramGenericGFPoly)
  {
    if (this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramGenericGFPoly.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF))
    {
      if (a()) {
        return paramGenericGFPoly;
      }
      if (paramGenericGFPoly.a()) {
        return this;
      }
      int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
      int[] arrayOfInt3 = paramGenericGFPoly.jdField_a_of_type_ArrayOfInt;
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
        arrayOfInt1[i] = GenericGF.a(arrayOfInt2[(i - j)], paramGenericGFPoly[i]);
        i += 1;
      }
      return new GenericGFPoly(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt1);
    }
    paramGenericGFPoly = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    for (;;)
    {
      throw paramGenericGFPoly;
    }
  }
  
  boolean a()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    boolean bool = false;
    if (arrayOfInt[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  GenericGFPoly[] a(GenericGFPoly paramGenericGFPoly)
  {
    if (this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramGenericGFPoly.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF))
    {
      if (!paramGenericGFPoly.a())
      {
        GenericGFPoly localGenericGFPoly2 = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
        int i = paramGenericGFPoly.a(paramGenericGFPoly.a());
        i = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.c(i);
        GenericGFPoly localGenericGFPoly3;
        for (GenericGFPoly localGenericGFPoly1 = this; (localGenericGFPoly1.a() >= paramGenericGFPoly.a()) && (!localGenericGFPoly1.a()); localGenericGFPoly1 = localGenericGFPoly1.a(localGenericGFPoly3))
        {
          int j = localGenericGFPoly1.a() - paramGenericGFPoly.a();
          int k = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(localGenericGFPoly1.a(localGenericGFPoly1.a()), i);
          localGenericGFPoly3 = paramGenericGFPoly.a(j, k);
          localGenericGFPoly2 = localGenericGFPoly2.a(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a(j, k));
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
  
  GenericGFPoly b(GenericGFPoly paramGenericGFPoly)
  {
    if (this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramGenericGFPoly.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF))
    {
      if ((!a()) && (!paramGenericGFPoly.a()))
      {
        int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
        int k = arrayOfInt1.length;
        paramGenericGFPoly = paramGenericGFPoly.jdField_a_of_type_ArrayOfInt;
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
            arrayOfInt2[i1] = GenericGF.a(arrayOfInt2[i1], this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(n, paramGenericGFPoly[j]));
            j += 1;
          }
          i += 1;
        }
        return new GenericGFPoly(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt2);
      }
      return this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    }
    paramGenericGFPoly = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    for (;;)
    {
      throw paramGenericGFPoly;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(a() * 8);
    int i = a();
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
          j = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.GenericGFPoly
 * JD-Core Version:    0.7.0.1
 */