package com.tencent.biz.pubaccount.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import msr;
import msu;
import msv;

public class DiffUtil
{
  private static final Comparator a = new msr();
  
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
    localArrayList2.add(new msu(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      msu localmsu2 = (msu)localArrayList2.remove(localArrayList2.size() - 1);
      msv localmsv = a(paramCallback, localmsu2.jdField_a_of_type_Int, localmsu2.jdField_b_of_type_Int, localmsu2.c, localmsu2.d, arrayOfInt1, arrayOfInt2, i);
      if (localmsv != null)
      {
        if (localmsv.c > 0) {
          localArrayList1.add(localmsv);
        }
        localmsv.jdField_a_of_type_Int += localmsu2.jdField_a_of_type_Int;
        localmsv.jdField_b_of_type_Int += localmsu2.c;
        msu localmsu1;
        if (localArrayList3.isEmpty())
        {
          localmsu1 = new msu();
          label217:
          localmsu1.jdField_a_of_type_Int = localmsu2.jdField_a_of_type_Int;
          localmsu1.c = localmsu2.c;
          if (!localmsv.jdField_b_of_type_Boolean) {
            break label362;
          }
          localmsu1.jdField_b_of_type_Int = localmsv.jdField_a_of_type_Int;
          localmsu1.d = localmsv.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localmsu1);
          if (!localmsv.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localmsv.jdField_a_of_type_Boolean) {
            break label420;
          }
          localmsu2.jdField_a_of_type_Int = (localmsv.jdField_a_of_type_Int + localmsv.c + 1);
          localmsu2.c = (localmsv.jdField_b_of_type_Int + localmsv.c);
        }
        for (;;)
        {
          localArrayList2.add(localmsu2);
          break;
          localmsu1 = (msu)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localmsv.jdField_a_of_type_Boolean)
          {
            localmsu1.jdField_b_of_type_Int = (localmsv.jdField_a_of_type_Int - 1);
            localmsu1.d = localmsv.jdField_b_of_type_Int;
            break label265;
          }
          localmsu1.jdField_b_of_type_Int = localmsv.jdField_a_of_type_Int;
          localmsu1.d = (localmsv.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localmsu2.jdField_a_of_type_Int = (localmsv.jdField_a_of_type_Int + localmsv.c);
          localmsu2.c = (localmsv.jdField_b_of_type_Int + localmsv.c + 1);
          continue;
          label457:
          localmsu2.jdField_a_of_type_Int = (localmsv.jdField_a_of_type_Int + localmsv.c);
          localmsu2.c = (localmsv.jdField_b_of_type_Int + localmsv.c);
        }
      }
      localArrayList3.add(localmsu2);
    }
    Collections.sort(localArrayList1, a);
    return new DiffUtil.DiffResult(paramCallback, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static msv a(DiffUtil.Callback paramCallback, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
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
          paramCallback = new msv();
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
          paramCallback = new msv();
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