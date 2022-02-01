package com.google.zxing.common.reedsolomon;

final class GenericGFPoly
{
  private final GenericGF jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  GenericGFPoly(GenericGF paramGenericGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF = paramGenericGF;
    int j = paramArrayOfInt.length;
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
      System.arraycopy(paramArrayOfInt, i, this.jdField_a_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
      return;
    }
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  int a()
  {
    return this.jdField_a_of_type_ArrayOfInt.length - 1;
  }
  
  int a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1 - paramInt)];
  }
  
  GenericGFPoly a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    }
    int i = this.jdField_a_of_type_ArrayOfInt.length;
    int[] arrayOfInt = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      arrayOfInt[paramInt1] = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(this.jdField_a_of_type_ArrayOfInt[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return new GenericGFPoly(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt);
  }
  
  GenericGFPoly a(GenericGFPoly paramGenericGFPoly)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramGenericGFPoly.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (a()) {
      return paramGenericGFPoly;
    }
    if (paramGenericGFPoly.a()) {
      return this;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt = paramGenericGFPoly.jdField_a_of_type_ArrayOfInt;
    if (localObject.length > arrayOfInt.length) {
      paramGenericGFPoly = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramGenericGFPoly.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = GenericGF.a(paramGenericGFPoly[(i - j)], localObject[i]);
        i += 1;
      }
      return new GenericGFPoly(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt);
      paramGenericGFPoly = (GenericGFPoly)localObject;
      localObject = arrayOfInt;
    }
  }
  
  boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ArrayOfInt[0] == 0) {
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
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramGenericGFPoly.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramGenericGFPoly.a()) {
      throw new IllegalArgumentException("Divide by 0");
    }
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
  
  GenericGFPoly b(GenericGFPoly paramGenericGFPoly)
  {
    if (!this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.equals(paramGenericGFPoly.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((a()) || (paramGenericGFPoly.a())) {
      return this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.a();
    }
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
        arrayOfInt2[(i + j)] = GenericGF.a(arrayOfInt2[(i + j)], this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(n, paramGenericGFPoly[j]));
        j += 1;
      }
      i += 1;
    }
    return new GenericGFPoly(this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF, arrayOfInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(a() * 8);
    int i = a();
    if (i >= 0)
    {
      int k = a(i);
      int j;
      if (k != 0)
      {
        if (k >= 0) {
          break label104;
        }
        localStringBuilder.append(" - ");
        j = -k;
        label50:
        if ((i == 0) || (j != 1))
        {
          j = this.jdField_a_of_type_ComGoogleZxingCommonReedsolomonGenericGF.b(j);
          if (j != 0) {
            break label127;
          }
          localStringBuilder.append('1');
        }
        label80:
        if (i != 0)
        {
          if (i != 1) {
            break label161;
          }
          localStringBuilder.append('x');
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label104:
        j = k;
        if (localStringBuilder.length() <= 0) {
          break label50;
        }
        localStringBuilder.append(" + ");
        j = k;
        break label50;
        label127:
        if (j == 1)
        {
          localStringBuilder.append('a');
          break label80;
        }
        localStringBuilder.append("a^");
        localStringBuilder.append(j);
        break label80;
        label161:
        localStringBuilder.append("x^");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.GenericGFPoly
 * JD-Core Version:    0.7.0.1
 */