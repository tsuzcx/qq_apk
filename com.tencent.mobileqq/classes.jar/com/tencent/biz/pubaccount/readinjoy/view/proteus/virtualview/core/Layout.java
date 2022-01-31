package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Layout
  extends ViewBase
{
  public List a;
  
  public Layout(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1073741824;
    int j = 0;
    int k = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2);
    switch (k)
    {
    default: 
      paramInt2 = 0;
      paramInt1 = j;
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
      if (paramInt3 >= 0)
      {
        paramInt1 = paramInt3;
        paramInt2 = i;
      }
      else if (paramInt3 == -1)
      {
        paramInt2 = i;
      }
      else
      {
        if (paramInt3 != -2) {
          break;
        }
        paramInt2 = -2147483648;
        continue;
        if (paramInt3 >= 0)
        {
          paramInt1 = paramInt3;
          paramInt2 = i;
        }
        else if (paramInt3 == -1)
        {
          paramInt2 = -2147483648;
        }
        else
        {
          if (paramInt3 != -2) {
            break;
          }
          paramInt2 = -2147483648;
          continue;
          if (paramInt3 >= 0)
          {
            paramInt1 = paramInt3;
            paramInt2 = i;
          }
          else if (paramInt3 == -1)
          {
            paramInt2 = 0;
          }
          else
          {
            if (paramInt3 != -2) {
              break;
            }
            paramInt2 = 0;
          }
        }
      }
    }
  }
  
  public Layout.Params a()
  {
    return new Layout.Params();
  }
  
  public ViewBase a(String paramString)
  {
    ViewBase localViewBase2 = super.a(paramString);
    ViewBase localViewBase1 = localViewBase2;
    if (localViewBase2 == null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localViewBase1 = localViewBase2;
      while (localIterator.hasNext())
      {
        localViewBase2 = ((ViewBase)localIterator.next()).a(paramString);
        localViewBase1 = localViewBase2;
        if (localViewBase2 != null) {
          localViewBase1 = localViewBase2;
        }
      }
    }
    return localViewBase1;
  }
  
  public final List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    if (this.e > 0)
    {
      if (this.c == null)
      {
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.STROKE);
      }
      this.c.setColor(this.f);
      this.c.setStrokeWidth(this.e);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    super.a(paramCanvas);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (localViewBase.f()) {
        localViewBase.a(paramCanvas);
      }
    }
  }
  
  public void a(ViewBase paramViewBase)
  {
    if (paramViewBase != null)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramViewBase);
      paramViewBase.a = this;
    }
  }
  
  public void a(ViewBase paramViewBase, int paramInt1, int paramInt2)
  {
    Layout.Params localParams = paramViewBase.b();
    paramViewBase.c(a(paramInt1, this.o + this.p + (this.e << 1) + localParams.c + localParams.d, localParams.a), a(paramInt2, this.q + this.r + (this.e << 1) + localParams.e + localParams.f, localParams.b));
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    ViewBase localViewBase;
    if (i >= 0)
    {
      localViewBase = (ViewBase)this.jdField_a_of_type_JavaUtilList.get(i);
      int j = localViewBase.d();
      int k = localViewBase.e();
      int m = localViewBase.a();
      int n = localViewBase.b();
      if ((paramInt1 < j) || (paramInt1 >= j + m) || (paramInt2 < k) || (paramInt2 > k + n)) {}
    }
    for (boolean bool1 = localViewBase.a(paramInt1, paramInt2);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.a(paramInt1, paramInt2);
      }
      return bool2;
      i -= 1;
      break;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    ViewBase localViewBase;
    if (i >= 0)
    {
      localViewBase = (ViewBase)this.jdField_a_of_type_JavaUtilList.get(i);
      int j = localViewBase.d();
      int k = localViewBase.e();
      int m = localViewBase.a();
      int n = localViewBase.b();
      if ((paramInt1 < j) || (paramInt1 >= j + m) || (paramInt2 < k) || (paramInt2 > k + n)) {}
    }
    for (boolean bool1 = localViewBase.a(paramInt1, paramInt2, paramBoolean);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.a(paramInt1, paramInt2, paramBoolean);
      }
      return bool2;
      i -= 1;
      break;
    }
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool2 = super.a(paramInt, paramString);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = false;
    }
    return bool1;
  }
  
  public void b(Canvas paramCanvas)
  {
    super.b(paramCanvas);
    if (this.e > 0)
    {
      if (this.c == null)
      {
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.STROKE);
      }
      this.c.setColor(this.f);
      this.c.setStrokeWidth(this.e);
      VirtualViewUtils.a(paramCanvas, this.c, this.t, this.u, this.e, this.h, this.i, this.j, this.k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout
 * JD-Core Version:    0.7.0.1
 */