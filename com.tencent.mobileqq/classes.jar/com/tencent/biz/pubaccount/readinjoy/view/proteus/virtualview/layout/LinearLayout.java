package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Iterator;
import java.util.List;

public class LinearLayout
  extends Layout
{
  protected int A;
  protected int B;
  public int z = 0;
  
  public LinearLayout(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    Iterator localIterator;
    ViewBase localViewBase;
    if (-2147483648 == paramInt1) {
      if (1 == this.z)
      {
        localIterator = this.a.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.d())
          {
            i = localViewBase.k();
            if (i <= paramInt1) {
              break label393;
            }
            paramInt1 = i;
          }
        }
      }
    }
    label390:
    label393:
    for (;;)
    {
      break;
      this.B = paramInt1;
      paramInt1 = this.q + this.r + (this.e << 1) + paramInt1;
      paramInt2 = Math.min(paramInt2, paramInt1);
      do
      {
        return paramInt2;
        paramInt1 = j;
        if (this.z != 0) {
          break;
        }
        localIterator = this.a.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.d()) {
            paramInt1 = localViewBase.k() + paramInt1;
          }
        }
        this.B = paramInt1;
        paramInt1 = this.q + this.r + (this.e << 1) + paramInt1;
        break;
      } while (1073741824 == paramInt1);
      if (1 == this.z)
      {
        localIterator = this.a.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.d())
          {
            paramInt2 = localViewBase.k();
            if (paramInt2 <= paramInt1) {
              break label390;
            }
            paramInt1 = paramInt2;
          }
        }
      }
      for (;;)
      {
        break;
        this.B = paramInt1;
        paramInt1 = this.q + this.r + (this.e << 1) + paramInt1;
        for (;;)
        {
          return paramInt1;
          paramInt1 = i;
          if (this.z == 0)
          {
            localIterator = this.a.iterator();
            paramInt1 = 0;
            while (localIterator.hasNext())
            {
              localViewBase = (ViewBase)localIterator.next();
              if (!localViewBase.d()) {
                paramInt1 = localViewBase.k() + paramInt1;
              }
            }
            this.B = paramInt1;
            paramInt1 = this.q + this.r + (this.e << 1) + paramInt1;
          }
        }
      }
    }
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (-2147483648 == paramInt1)
    {
      paramInt1 = 0;
      ViewBase localViewBase;
      if (1 == this.z)
      {
        localIterator = this.a.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.d()) {
            paramInt1 = localViewBase.j() + paramInt1;
          }
        }
        this.A = paramInt1;
        paramInt1 = this.o + this.p + (this.e << 1) + paramInt1;
      }
      label100:
      label102:
      while (this.z != 0)
      {
        paramInt2 = Math.min(paramInt2, paramInt1);
        paramInt3 = paramInt2;
        return paramInt3;
      }
      Iterator localIterator = this.a.iterator();
      paramInt1 = 0;
      label124:
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.d())
        {
          paramInt3 = localViewBase.j();
          if (paramInt3 <= paramInt1) {
            break label206;
          }
          paramInt1 = paramInt3;
        }
      }
    }
    label206:
    for (;;)
    {
      break label124;
      this.A = paramInt1;
      paramInt1 = this.o + this.p + (this.e << 1) + paramInt1;
      break;
      if (1073741824 != paramInt1) {
        break label102;
      }
      break label100;
    }
  }
  
  private final void d(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    Iterator localIterator = this.a.iterator();
    ViewBase localViewBase;
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localViewBase = (ViewBase)localIterator.next();
      j = i;
      if (!localViewBase.d())
      {
        LinearLayout.Params localParams = (LinearLayout.Params)localViewBase.b();
        j = i;
        if (1073741824 != n)
        {
          j = i;
          if (-1 == localParams.a) {
            j = 1;
          }
        }
        a(localViewBase, paramInt1, paramInt2);
      }
    }
    b(b(n, k, 0), a(i1, m));
    if (i != 0)
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(a(), 1073741824);
      localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if ((!localViewBase.d()) && (-1 == localViewBase.b().a)) {
          a(localViewBase, paramInt1, paramInt2);
        }
      }
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    Iterator localIterator = this.a.iterator();
    int j = 0;
    int i = 0;
    ViewBase localViewBase;
    int k;
    if (localIterator.hasNext())
    {
      localViewBase = (ViewBase)localIterator.next();
      if (localViewBase.d()) {
        break label262;
      }
      Layout.Params localParams = localViewBase.b();
      k = i;
      if (1073741824 != i2)
      {
        k = i;
        if (-1 == localParams.b) {
          k = 1;
        }
      }
      if (i1 != 0)
      {
        a(localViewBase, View.MeasureSpec.makeMeasureSpec(m - j, 1073741824), paramInt2);
        label124:
        i = localViewBase.j() + j;
      }
    }
    for (j = k;; j = k)
    {
      k = j;
      j = i;
      i = k;
      break;
      a(localViewBase, paramInt1, paramInt2);
      break label124;
      b(b(i1, m, j), a(i2, n));
      if (i != 0)
      {
        paramInt2 = View.MeasureSpec.makeMeasureSpec(b(), 1073741824);
        localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if ((!localViewBase.d()) && (-1 == localViewBase.b().b)) {
            a(localViewBase, paramInt1, paramInt2);
          }
        }
      }
      return;
      label262:
      k = i;
      i = j;
    }
  }
  
  private int l()
  {
    if (this.A <= 0)
    {
      this.A = 0;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ViewBase localViewBase = (ViewBase)localIterator.next();
        int i = this.A;
        this.A = (localViewBase.j() + i);
      }
    }
    return this.A;
  }
  
  private int m()
  {
    if (this.B <= 0)
    {
      this.B = 0;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ViewBase localViewBase = (ViewBase)localIterator.next();
        int i = this.B;
        this.B = (localViewBase.k() + i);
      }
    }
    return this.B;
  }
  
  public LinearLayout.Params a()
  {
    return new LinearLayout.Params();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.A = 0;
    this.B = 0;
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
    for (;;)
    {
      switch (this.z)
      {
      default: 
        return;
        i = paramInt1;
        j = paramInt2;
        if (1073741824 == View.MeasureSpec.getMode(paramInt1))
        {
          j = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt1) * this.c / this.b), 1073741824);
          i = paramInt1;
          continue;
          i = paramInt1;
          j = paramInt2;
          if (1073741824 == View.MeasureSpec.getMode(paramInt2))
          {
            i = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt2) * this.b / this.c), 1073741824);
            j = paramInt2;
          }
        }
        break;
      }
    }
    d(i, j);
    return;
    e(i, j);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator;
    label61:
    ViewBase localViewBase;
    LinearLayout.Params localParams;
    int i;
    int j;
    switch (this.z)
    {
    default: 
      return;
    case 1: 
      if ((this.s & 0x1) != 0)
      {
        paramInt1 = this.o + paramInt1 + this.e;
        localIterator = this.a.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localViewBase = (ViewBase)localIterator.next();
        } while (localViewBase.d());
        localParams = (LinearLayout.Params)localViewBase.b();
        paramInt3 = localViewBase.a();
        i = localViewBase.b();
        j = localParams.c + paramInt1;
        if ((localParams.g & 0x20) == 0) {
          break label222;
        }
        paramInt1 = paramInt4 + paramInt2 - i >> 1;
      }
      for (;;)
      {
        localViewBase.b(j, paramInt1, j + paramInt3, i + paramInt1);
        paramInt1 = localParams.d + paramInt3 + j;
        break label61;
        if ((this.s & 0x4) != 0)
        {
          paramInt1 = paramInt3 - paramInt1 - l() >> 1;
          break;
        }
        paramInt1 = paramInt3 - l() - this.p - this.e;
        break;
        label222:
        if ((localParams.g & 0x10) != 0) {
          paramInt1 = paramInt4 - i - this.r - this.e - localParams.f;
        } else {
          paramInt1 = this.q + paramInt2 + this.e + localParams.e;
        }
      }
    }
    if ((this.s & 0x8) != 0)
    {
      paramInt2 = this.q + paramInt2 + this.e;
      label301:
      localIterator = this.a.iterator();
      label312:
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.d())
        {
          localParams = (LinearLayout.Params)localViewBase.b();
          paramInt4 = localViewBase.a();
          i = localViewBase.b();
          j = localParams.e + paramInt2;
          if ((localParams.g & 0x4) == 0) {
            break label473;
          }
          paramInt2 = paramInt3 + paramInt1 - paramInt4 >> 1;
        }
      }
    }
    for (;;)
    {
      localViewBase.b(paramInt2, j, paramInt4 + paramInt2, j + i);
      paramInt2 = localParams.f + i + j;
      break label312;
      break;
      if ((this.s & 0x20) != 0)
      {
        paramInt2 = paramInt4 + paramInt2 - m() >> 1;
        break label301;
      }
      paramInt2 = paramInt4 - m() - this.r - this.e;
      break label301;
      label473:
      if ((localParams.g & 0x2) != 0) {
        paramInt2 = paramInt3 - this.p - this.e - localParams.d - paramInt4;
      } else {
        paramInt2 = this.o + paramInt1 + this.e + localParams.c;
      }
    }
  }
  
  protected boolean a(int paramInt, String paramString)
  {
    boolean bool = super.a(paramInt, paramString);
    if (!bool) {}
    switch (paramInt)
    {
    default: 
      return bool;
    }
    if (TextUtils.equals("vertical", paramString))
    {
      this.z = 0;
      return bool;
    }
    this.z = 1;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout
 * JD-Core Version:    0.7.0.1
 */