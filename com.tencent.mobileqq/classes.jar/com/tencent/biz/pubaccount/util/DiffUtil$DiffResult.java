package com.tencent.biz.pubaccount.util;

import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mxt;
import mxu;
import mxw;

public class DiffUtil$DiffResult
{
  private final int jdField_a_of_type_Int;
  private final DiffUtil.Callback jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback;
  private final List jdField_a_of_type_JavaUtilList;
  private final boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private final int[] jdField_b_of_type_ArrayOfInt;
  
  DiffUtil$DiffResult(DiffUtil.Callback paramCallback, List paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
    this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt2;
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback = paramCallback;
    this.jdField_a_of_type_Int = paramCallback.a();
    this.jdField_b_of_type_Int = paramCallback.b();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
    b();
  }
  
  private static mxu a(List paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      mxu localmxu2 = (mxu)paramList.get(i);
      if ((localmxu2.jdField_a_of_type_Int == paramInt) && (localmxu2.jdField_a_of_type_Boolean == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localmxu1 = localmxu2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localmxu1 = (mxu)paramList.get(paramInt);
        int j = localmxu1.jdField_b_of_type_Int;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localmxu1.jdField_b_of_type_Int = (i + j);
          paramInt += 1;
          break;
        }
      }
      i -= 1;
    }
    mxu localmxu1 = null;
    label123:
    return localmxu1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (mxw localmxw = null;; localmxw = (mxw)this.jdField_a_of_type_JavaUtilList.get(0))
    {
      if ((localmxw == null) || (localmxw.jdField_a_of_type_Int != 0) || (localmxw.jdField_b_of_type_Int != 0))
      {
        localmxw = new mxw();
        localmxw.jdField_a_of_type_Int = 0;
        localmxw.jdField_b_of_type_Int = 0;
        localmxw.jdField_a_of_type_Boolean = false;
        localmxw.c = 0;
        localmxw.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(0, localmxw);
      }
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ArrayOfInt[(paramInt1 - 1)] != 0) {
      return;
    }
    a(paramInt1, paramInt2, paramInt3, false);
  }
  
  private void a(List paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramListUpdateCallback.a(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] & 0x1F;
    Object localObject;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramListUpdateCallback.a(paramInt1, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        mxu localmxu = (mxu)((Iterator)localObject).next();
        localmxu.jdField_b_of_type_Int += 1;
        continue;
        int j = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        localObject = a(paramList, j, true);
        if (localObject != null) {
          paramListUpdateCallback.c(((mxu)localObject).jdField_b_of_type_Int, paramInt1);
        }
        if (i == 4) {
          paramListUpdateCallback.a(paramInt1, 1, this.jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback.a(j, paramInt3 + paramInt2));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new mxu(paramInt3 + paramInt2, paramInt1, false));
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int m = 8;
    int j;
    int k;
    int i;
    if (paramBoolean)
    {
      j = paramInt2 - 1;
      k = paramInt2 - 1;
      i = paramInt1;
      paramInt2 = j;
      j = k;
      k = i;
      i = paramInt2;
      paramInt2 = k;
    }
    for (;;)
    {
      if (paramInt3 < 0) {
        break label289;
      }
      mxw localmxw = (mxw)this.jdField_a_of_type_JavaUtilList.get(paramInt3);
      k = localmxw.jdField_a_of_type_Int;
      int n = localmxw.c;
      int i1 = localmxw.jdField_b_of_type_Int;
      int i2 = localmxw.c;
      if (paramBoolean)
      {
        paramInt2 -= 1;
        for (;;)
        {
          if (paramInt2 < k + n) {
            break label269;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback.a(paramInt2, j))
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback.b(paramInt2, j)) {}
            for (paramInt1 = 8;; paramInt1 = 4)
            {
              this.jdField_b_of_type_ArrayOfInt[j] = (paramInt2 << 5 | 0x10);
              this.jdField_a_of_type_ArrayOfInt[paramInt2] = (paramInt1 | j << 5);
              return true;
              j = paramInt1 - 1;
              i = paramInt1 - 1;
              break;
            }
          }
          paramInt2 -= 1;
        }
      }
      paramInt2 = i - 1;
      while (paramInt2 >= i1 + i2)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback.a(j, paramInt2))
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback.b(j, paramInt2)) {}
          for (paramInt3 = m;; paramInt3 = 4)
          {
            this.jdField_a_of_type_ArrayOfInt[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
            this.jdField_b_of_type_ArrayOfInt[paramInt2] = (paramInt1 - 1 << 5 | paramInt3);
            return true;
          }
        }
        paramInt2 -= 1;
      }
      label269:
      paramInt2 = localmxw.jdField_a_of_type_Int;
      i = localmxw.jdField_b_of_type_Int;
      paramInt3 -= 1;
    }
    label289:
    return false;
  }
  
  private void b()
  {
    int j = this.jdField_a_of_type_Int;
    int i = this.jdField_b_of_type_Int;
    int k = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (k >= 0)
    {
      mxw localmxw = (mxw)this.jdField_a_of_type_JavaUtilList.get(k);
      int i2 = localmxw.jdField_a_of_type_Int;
      int i3 = localmxw.c;
      int n = localmxw.jdField_b_of_type_Int;
      int i1 = localmxw.c;
      int m;
      if (this.jdField_a_of_type_Boolean)
      {
        for (;;)
        {
          m = i;
          if (j <= i2 + i3) {
            break;
          }
          a(j, i, k);
          j -= 1;
        }
        while (m > n + i1)
        {
          b(j, m, k);
          m -= 1;
        }
      }
      i = 0;
      if (i < localmxw.c)
      {
        m = localmxw.jdField_a_of_type_Int + i;
        n = localmxw.jdField_b_of_type_Int + i;
        if (this.jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback.b(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.jdField_a_of_type_ArrayOfInt[m] = (n << 5 | j);
          this.jdField_b_of_type_ArrayOfInt[n] = (j | m << 5);
          i += 1;
          break;
        }
      }
      j = localmxw.jdField_a_of_type_Int;
      i = localmxw.jdField_b_of_type_Int;
      k -= 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_ArrayOfInt[(paramInt2 - 1)] != 0) {
      return;
    }
    a(paramInt1, paramInt2, paramInt3, true);
  }
  
  private void b(List paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramListUpdateCallback.b(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] & 0x1F;
    Object localObject;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramListUpdateCallback.b(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        mxu localmxu = (mxu)((Iterator)localObject).next();
        localmxu.jdField_b_of_type_Int -= 1;
        continue;
        int j = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        localObject = a(paramList, j, false);
        if (localObject != null)
        {
          paramListUpdateCallback.c(paramInt1 + paramInt2, ((mxu)localObject).jdField_b_of_type_Int - 1);
          if (i == 4) {
            paramListUpdateCallback.a(((mxu)localObject).jdField_b_of_type_Int - 1, 1, this.jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback.a(paramInt3 + paramInt2, j));
          }
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new mxu(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
    }
  }
  
  public void a(RecyclerView.Adapter paramAdapter)
  {
    a(new mxt(this, paramAdapter));
  }
  
  public void a(ListUpdateCallback paramListUpdateCallback)
  {
    ArrayList localArrayList;
    int j;
    int k;
    int i;
    if ((paramListUpdateCallback instanceof BatchingListUpdateCallback))
    {
      paramListUpdateCallback = (BatchingListUpdateCallback)paramListUpdateCallback;
      localArrayList = new ArrayList();
      j = this.jdField_a_of_type_Int;
      k = this.jdField_b_of_type_Int;
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label234;
      }
      mxw localmxw = (mxw)this.jdField_a_of_type_JavaUtilList.get(i);
      int m = localmxw.c;
      int n = localmxw.jdField_a_of_type_Int + m;
      int i1 = localmxw.jdField_b_of_type_Int + m;
      if (n < j) {
        b(localArrayList, paramListUpdateCallback, n, j - n, n);
      }
      if (i1 < k) {
        a(localArrayList, paramListUpdateCallback, n, k - i1, i1);
      }
      j = m - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if ((this.jdField_a_of_type_ArrayOfInt[(localmxw.jdField_a_of_type_Int + j)] & 0x1F) == 2) {
            paramListUpdateCallback.a(localmxw.jdField_a_of_type_Int + j, 1, this.jdField_a_of_type_ComTencentBizPubaccountUtilDiffUtil$Callback.a(localmxw.jdField_a_of_type_Int + j, localmxw.jdField_b_of_type_Int + j));
          }
          j -= 1;
          continue;
          paramListUpdateCallback = new BatchingListUpdateCallback(paramListUpdateCallback);
          break;
        }
      }
      j = localmxw.jdField_a_of_type_Int;
      k = localmxw.jdField_b_of_type_Int;
      i -= 1;
    }
    label234:
    paramListUpdateCallback.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.DiffUtil.DiffResult
 * JD-Core Version:    0.7.0.1
 */