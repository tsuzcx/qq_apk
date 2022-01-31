package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import android.util.Log;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FrameLayout
  extends Layout
{
  private List b;
  
  public FrameLayout(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i;
    if (-2147483648 == paramInt1)
    {
      Iterator localIterator = this.a.iterator();
      paramInt1 = 0;
      while (localIterator.hasNext())
      {
        ViewBase localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.d())
        {
          i = localViewBase.j();
          if (i <= paramInt1) {
            break label125;
          }
          paramInt1 = i;
        }
      }
    }
    label125:
    for (;;)
    {
      break;
      i = Math.min(paramInt2, this.o + this.p + (this.e << 1) + paramInt1);
      do
      {
        return i;
        i = paramInt2;
      } while (1073741824 == paramInt1);
      Log.e("FrameLayout_TMTEST", "getRealWidth error mode:" + paramInt1);
      return paramInt2;
    }
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    Iterator localIterator;
    ViewBase localViewBase;
    if (-2147483648 == paramInt1)
    {
      localIterator = this.a.iterator();
      paramInt1 = 0;
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.d())
        {
          int i = localViewBase.k();
          if (i <= paramInt1) {
            break label177;
          }
          paramInt1 = i;
        }
      }
    }
    label174:
    label177:
    for (;;)
    {
      break;
      paramInt2 = Math.min(paramInt2, this.q + this.r + (this.e << 1) + paramInt1);
      do
      {
        return paramInt2;
      } while (1073741824 == paramInt1);
      localIterator = this.a.iterator();
      paramInt1 = 0;
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.d())
        {
          paramInt2 = localViewBase.k();
          if (paramInt2 <= paramInt1) {
            break label174;
          }
          paramInt1 = paramInt2;
        }
      }
      for (;;)
      {
        break;
        return paramInt1 + (this.q + this.r + (this.e << 1));
      }
    }
  }
  
  public FrameLayout.Params a()
  {
    return new FrameLayout.Params();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j = paramInt2;
    if (this.n > 0) {
      switch (this.n)
      {
      default: 
        j = paramInt2;
        i = paramInt1;
      }
    }
    int k;
    int m;
    Iterator localIterator;
    for (;;)
    {
      paramInt1 = View.MeasureSpec.getSize(i);
      paramInt2 = View.MeasureSpec.getSize(j);
      k = View.MeasureSpec.getMode(i);
      m = View.MeasureSpec.getMode(j);
      this.jdField_b_of_type_JavaUtilList.clear();
      localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ViewBase localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.d())
        {
          Layout.Params localParams = localViewBase.b();
          if (((1073741824 != m) && (-1 == localParams.b)) || ((1073741824 != k) && (-1 == localParams.a))) {
            this.jdField_b_of_type_JavaUtilList.add(localViewBase);
          }
          a(localViewBase, i, j);
        }
      }
      i = paramInt1;
      j = paramInt2;
      if (1073741824 == View.MeasureSpec.getMode(paramInt1))
      {
        j = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt1) * this.c / this.jdField_b_of_type_Float), 1073741824);
        i = paramInt1;
        continue;
        i = paramInt1;
        j = paramInt2;
        if (1073741824 == View.MeasureSpec.getMode(paramInt2))
        {
          i = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt2) * this.jdField_b_of_type_Float / this.c), 1073741824);
          j = paramInt2;
        }
      }
    }
    b(a(k, paramInt1), b(m, paramInt2));
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        a((ViewBase)localIterator.next(), View.MeasureSpec.makeMeasureSpec(this.t, 1073741824), View.MeasureSpec.makeMeasureSpec(this.u, 1073741824));
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.d())
      {
        int k = localViewBase.a();
        int m = localViewBase.b();
        FrameLayout.Params localParams = (FrameLayout.Params)localViewBase.b();
        int i;
        label86:
        int j;
        if ((localParams.g & 0x4) != 0)
        {
          i = paramInt3 + paramInt1 - k >> 1;
          if ((localParams.g & 0x20) == 0) {
            break label188;
          }
          j = paramInt4 + paramInt2 - m >> 1;
        }
        for (;;)
        {
          localViewBase.b(i, j, k + i, m + j);
          break;
          if ((localParams.g & 0x2) != 0)
          {
            i = paramInt3 - this.p - localParams.d - k - this.e;
            break label86;
          }
          i = this.o + paramInt1 + localParams.c + this.e;
          break label86;
          label188:
          if ((localParams.g & 0x10) != 0)
          {
            j = paramInt4 - m - this.r - localParams.f - this.e;
          }
          else
          {
            j = this.q;
            j = localParams.e + (j + paramInt2) + this.e;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.FrameLayout
 * JD-Core Version:    0.7.0.1
 */