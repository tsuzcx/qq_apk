package com.tencent.av.opengl.ui;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OverScroller
{
  private int jdField_a_of_type_Int;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final OverScroller.SplineOverScroller jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller;
  private final boolean jdField_a_of_type_Boolean;
  private final OverScroller.SplineOverScroller b;
  
  public OverScroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller = new OverScroller.SplineOverScroller();
    this.b = new OverScroller.SplineOverScroller();
    OverScroller.SplineOverScroller.a(paramContext);
  }
  
  public final int a()
  {
    return OverScroller.SplineOverScroller.a(this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller.a();
    this.b.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller.a(paramInt1, paramInt3, paramInt5);
    this.b.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = OverScroller.SplineOverScroller.a(this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller);
      float f2 = OverScroller.SplineOverScroller.a(this.b);
      float f3 = paramInt3;
      if (Math.signum(f3) == Math.signum(f1))
      {
        float f4 = paramInt4;
        if (Math.signum(f4) == Math.signum(f2))
        {
          paramInt3 = (int)(f3 + f1);
          paramInt4 = (int)(f4 + f2);
        }
      }
    }
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
    this.b.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
  }
  
  public final void a(boolean paramBoolean)
  {
    OverScroller.SplineOverScroller.a(this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller, OverScroller.SplineOverScroller.a(this.b, paramBoolean));
  }
  
  public final boolean a()
  {
    return (OverScroller.SplineOverScroller.a(this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller)) && (OverScroller.SplineOverScroller.a(this.b));
  }
  
  public final int b()
  {
    return OverScroller.SplineOverScroller.b(this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller);
  }
  
  public boolean b()
  {
    if (a()) {
      return false;
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      if ((!OverScroller.SplineOverScroller.a(this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller)) && (!this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller.b()) && (!this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller.a())) {
        this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller.a();
      }
      if ((!OverScroller.SplineOverScroller.a(this.b)) && (!this.b.b()) && (!this.b.a()))
      {
        this.b.a();
        return true;
      }
    }
    else
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - OverScroller.SplineOverScroller.a(this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller);
      i = OverScroller.SplineOverScroller.c(this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller);
      if (l < i)
      {
        float f = (float)l / i;
        Interpolator localInterpolator = this.jdField_a_of_type_AndroidViewAnimationInterpolator;
        if (localInterpolator == null) {
          f = Scroller.a(f);
        } else {
          f = localInterpolator.getInterpolation(f);
        }
        this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller$SplineOverScroller.a(f);
        this.b.a(f);
        return true;
      }
      a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.OverScroller
 * JD-Core Version:    0.7.0.1
 */