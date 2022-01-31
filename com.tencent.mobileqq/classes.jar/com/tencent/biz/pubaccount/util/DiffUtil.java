package com.tencent.biz.pubaccount.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mty;
import mub;
import muc;

public class DiffUtil
{
  private static final Comparator a = new mty();
  
  public static DiffUtil.DiffResult a(DiffUtil.Callback paramCallback)
  {
    return a(paramCallback, true);
  }
  
  public static DiffUtil.DiffResult a(DiffUtil.Callback paramCallback, boolean paramBoolean)
  {
    int i = paramCallback.a();
    int j = paramCallback.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new mub(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      mub localmub2 = (mub)localArrayList2.remove(localArrayList2.size() - 1);
      muc localmuc = a(paramCallback, localmub2.jdField_a_of_type_Int, localmub2.jdField_b_of_type_Int, localmub2.c, localmub2.d, arrayOfInt1, arrayOfInt2, i);
      if (localmuc != null)
      {
        if (localmuc.c > 0) {
          localArrayList1.add(localmuc);
        }
        localmuc.jdField_a_of_type_Int += localmub2.jdField_a_of_type_Int;
        localmuc.jdField_b_of_type_Int += localmub2.c;
        mub localmub1;
        if (localArrayList3.isEmpty())
        {
          localmub1 = new mub();
          label217:
          localmub1.jdField_a_of_type_Int = localmub2.jdField_a_of_type_Int;
          localmub1.c = localmub2.c;
          if (!localmuc.jdField_b_of_type_Boolean) {
            break label362;
          }
          localmub1.jdField_b_of_type_Int = localmuc.jdField_a_of_type_Int;
          localmub1.d = localmuc.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localmub1);
          if (!localmuc.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localmuc.jdField_a_of_type_Boolean) {
            break label420;
          }
          localmub2.jdField_a_of_type_Int = (localmuc.jdField_a_of_type_Int + localmuc.c + 1);
          localmub2.c = (localmuc.jdField_b_of_type_Int + localmuc.c);
        }
        for (;;)
        {
          localArrayList2.add(localmub2);
          break;
          localmub1 = (mub)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localmuc.jdField_a_of_type_Boolean)
          {
            localmub1.jdField_b_of_type_Int = (localmuc.jdField_a_of_type_Int - 1);
            localmub1.d = localmuc.jdField_b_of_type_Int;
            break label265;
          }
          localmub1.jdField_b_of_type_Int = localmuc.jdField_a_of_type_Int;
          localmub1.d = (localmuc.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localmub2.jdField_a_of_type_Int = (localmuc.jdField_a_of_type_Int + localmuc.c);
          localmub2.c = (localmuc.jdField_b_of_type_Int + localmuc.c + 1);
          continue;
          label457:
          localmub2.jdField_a_of_type_Int = (localmuc.jdField_a_of_type_Int + localmuc.c);
          localmub2.c = (localmuc.jdField_b_of_type_Int + localmuc.c);
        }
      }
      localArrayList3.add(localmub2);
    }
    Collections.sort(localArrayList1, a);
    return new DiffUtil.DiffResult(paramCallback, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static muc a(DiffUtil.Callback paramCallback, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    int m = paramInt2 - paramInt1;
    int n = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 < 1) || (paramInt4 - paramInt3 < 1)) {
      return null;
    }
    int i1 = m - n;
    int i2 = (m + n + 1) / 2;
    Arrays.fill(paramArrayOfInt1, paramInt5 - i2 - 1, paramInt5 + i2 + 1, 0);
    Arrays.fill(paramArrayOfInt2, paramInt5 - i2 - 1 + i1, paramInt5 + i2 + 1 + i1, m);
    int i;
    if (i1 % 2 != 0)
    {
      paramInt4 = 1;
      i = 0;
    }
    for (;;)
    {
      if (i > i2) {
        break label664;
      }
      int j = -i;
      boolean bool;
      int k;
      for (;;)
      {
        if (j > i) {
          break label382;
        }
        if ((j == -i) || ((j != i) && (paramArrayOfInt1[(paramInt5 + j - 1)] < paramArrayOfInt1[(paramInt5 + j + 1)]))) {
          paramInt2 = paramArrayOfInt1[(paramInt5 + j + 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2;
          paramInt2 -= j;
          while ((k < m) && (paramInt2 < n) && (paramCallback.a(paramInt1 + k, paramInt3 + paramInt2)))
          {
            k += 1;
            paramInt2 += 1;
          }
          paramInt4 = 0;
          break;
          paramInt2 = paramArrayOfInt1[(paramInt5 + j - 1)] + 1;
        }
        paramArrayOfInt1[(paramInt5 + j)] = k;
        if ((paramInt4 != 0) && (j >= i1 - i + 1) && (j <= i1 + i - 1) && (paramArrayOfInt1[(paramInt5 + j)] >= paramArrayOfInt2[(paramInt5 + j)]))
        {
          paramCallback = new muc();
          paramCallback.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + j)];
          paramCallback.jdField_b_of_type_Int = (paramCallback.jdField_a_of_type_Int - j);
          paramCallback.c = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramCallback.jdField_a_of_type_Boolean = bool;
          paramCallback.jdField_b_of_type_Boolean = false;
          return paramCallback;
        }
        j += 2;
      }
      label382:
      j = -i;
      while (j <= i)
      {
        int i3 = j + i1;
        if ((i3 == i + i1) || ((i3 != -i + i1) && (paramArrayOfInt2[(paramInt5 + i3 - 1)] < paramArrayOfInt2[(paramInt5 + i3 + 1)]))) {
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 - 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2;
          paramInt2 -= i3;
          while ((k > 0) && (paramInt2 > 0) && (paramCallback.a(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramCallback = new muc();
          paramCallback.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + i3)];
          paramCallback.jdField_b_of_type_Int = (paramCallback.jdField_a_of_type_Int - i3);
          paramCallback.c = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramCallback.jdField_a_of_type_Boolean = bool;
          paramCallback.jdField_b_of_type_Boolean = true;
          return paramCallback;
        }
        j += 2;
      }
      i += 1;
    }
    label664:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.DiffUtil
 * JD-Core Version:    0.7.0.1
 */