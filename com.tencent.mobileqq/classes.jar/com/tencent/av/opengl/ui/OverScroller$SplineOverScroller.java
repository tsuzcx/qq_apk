package com.tencent.av.opengl.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;

class OverScroller$SplineOverScroller
{
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static final float[] jdField_b_of_type_ArrayOfFloat;
  private static float jdField_d_of_type_Float;
  private static float jdField_e_of_type_Float = (float)(Math.log(0.78D) / Math.log(0.9D));
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float = ViewConfiguration.getScrollFriction();
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  private int jdField_e_of_type_Int;
  private int f;
  private int g;
  private int h;
  private int i = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[101];
    jdField_b_of_type_ArrayOfFloat = new float[101];
    float f1 = 0.0F;
    int j = 0;
    float f2 = 0.0F;
    if (j < 100)
    {
      float f5 = j / 100.0F;
      float f3 = 1.0F;
      for (;;)
      {
        float f4 = (f3 - f1) / 2.0F + f1;
        float f6 = 1.0F - f4;
        float f7 = f4 * 3.0F * f6;
        float f8 = f4 * f4 * f4;
        float f9 = (f6 * 0.175F + f4 * 0.35F) * f7 + f8;
        if (Math.abs(f9 - f5) < 1.E-005D)
        {
          jdField_a_of_type_ArrayOfFloat[j] = (f7 * (f6 * 0.5F + f4) + f8);
          f3 = 1.0F;
          for (;;)
          {
            f4 = (f3 - f2) / 2.0F + f2;
            f6 = 1.0F - f4;
            f7 = f4 * 3.0F * f6;
            f8 = f4 * f4 * f4;
            f9 = (f6 * 0.5F + f4) * f7 + f8;
            if (Math.abs(f9 - f5) < 1.E-005D)
            {
              jdField_b_of_type_ArrayOfFloat[j] = (f7 * (f6 * 0.175F + f4 * 0.35F) + f8);
              j += 1;
              break;
            }
            if (f9 > f5) {
              f3 = f4;
            } else {
              f2 = f4;
            }
          }
        }
        if (f9 > f5) {
          f3 = f4;
        } else {
          f1 = f4;
        }
      }
    }
    float[] arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    jdField_b_of_type_ArrayOfFloat[100] = 1.0F;
    arrayOfFloat[100] = 1.0F;
  }
  
  private double a(int paramInt)
  {
    return Math.log(Math.abs(paramInt) * 0.35F / (this.jdField_c_of_type_Float * jdField_d_of_type_Float));
  }
  
  private static float a(int paramInt)
  {
    if (paramInt > 0) {
      return -2000.0F;
    }
    return 2000.0F;
  }
  
  private int a(int paramInt)
  {
    double d1 = a(paramInt);
    double d2 = jdField_e_of_type_Float;
    Double.isNaN(d2);
    return (int)(Math.exp(d1 / (d2 - 1.0D)) * 1000.0D);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = 1;
    if ((paramInt1 > paramInt2) && (paramInt1 < paramInt3))
    {
      Log.e("OverScroller", "startAfterEdge called from a valid position");
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    int j;
    if (paramInt1 > paramInt3) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (j != 0) {
      k = paramInt3;
    } else {
      k = paramInt2;
    }
    int n = paramInt1 - k;
    if (n * paramInt4 < 0) {
      m = 0;
    }
    if (m != 0)
    {
      e(paramInt1, k, paramInt4);
      return;
    }
    if (b(paramInt4) > Math.abs(n))
    {
      if (j == 0) {
        paramInt2 = paramInt1;
      }
      if (j != 0) {
        paramInt3 = paramInt1;
      }
      a(paramInt1, paramInt4, paramInt2, paramInt3, this.h);
      return;
    }
    c(paramInt1, k, paramInt4);
  }
  
  static void a(Context paramContext)
  {
    jdField_d_of_type_Float = paramContext.getResources().getDisplayMetrics().density * 160.0F * 386.0878F * 0.84F;
  }
  
  private double b(int paramInt)
  {
    double d2 = a(paramInt);
    float f1 = jdField_e_of_type_Float;
    double d3 = f1;
    Double.isNaN(d3);
    double d1 = this.jdField_c_of_type_Float * jdField_d_of_type_Float;
    double d4 = f1;
    Double.isNaN(d4);
    d2 = Math.exp(d4 / (d3 - 1.0D) * d2);
    Double.isNaN(d1);
    return d1 * d2;
  }
  
  private void b()
  {
    int j = this.jdField_d_of_type_Int;
    float f2 = j * j / (Math.abs(this.jdField_b_of_type_Float) * 2.0F);
    float f3 = Math.signum(this.jdField_d_of_type_Int);
    j = this.h;
    float f1 = f2;
    if (f2 > j)
    {
      f1 = -f3;
      int k = this.jdField_d_of_type_Int;
      this.jdField_b_of_type_Float = (f1 * k * k / (j * 2.0F));
      f1 = j;
    }
    this.h = ((int)f1);
    this.i = 2;
    j = this.jdField_a_of_type_Int;
    if (this.jdField_d_of_type_Int <= 0) {
      f1 = -f1;
    }
    this.jdField_c_of_type_Int = (j + (int)f1);
    this.jdField_e_of_type_Int = (-(int)(this.jdField_d_of_type_Int * 1000.0F / this.jdField_b_of_type_Float));
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    float f3 = Math.abs((paramInt3 - paramInt1) / (paramInt2 - paramInt1));
    paramInt1 = (int)(f3 * 100.0F);
    if (paramInt1 < 100)
    {
      float f4 = paramInt1 / 100.0F;
      paramInt2 = paramInt1 + 1;
      float f5 = paramInt2 / 100.0F;
      float[] arrayOfFloat = jdField_b_of_type_ArrayOfFloat;
      float f1 = arrayOfFloat[paramInt1];
      float f2 = arrayOfFloat[paramInt2];
      f3 = (f3 - f4) / (f5 - f4);
      this.jdField_e_of_type_Int = ((int)(this.jdField_e_of_type_Int * (f1 + f3 * (f2 - f1))));
    }
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = false;
    this.i = 1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    paramInt1 -= paramInt2;
    this.jdField_b_of_type_Float = a(paramInt1);
    this.jdField_d_of_type_Int = (-paramInt1);
    this.h = Math.abs(paramInt1);
    double d1 = paramInt1;
    Double.isNaN(d1);
    double d2 = this.jdField_b_of_type_Float;
    Double.isNaN(d2);
    this.jdField_e_of_type_Int = ((int)(Math.sqrt(d1 * -2.0D / d2) * 1000.0D));
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3)
  {
    float f2 = -paramInt3;
    float f1 = this.jdField_b_of_type_Float;
    f2 /= f1;
    double d1 = paramInt3 * paramInt3 / 2.0F / Math.abs(f1) + Math.abs(paramInt2 - paramInt1);
    Double.isNaN(d1);
    double d2 = Math.abs(this.jdField_b_of_type_Float);
    Double.isNaN(d2);
    f1 = (float)Math.sqrt(d1 * 2.0D / d2);
    this.jdField_a_of_type_Long -= (int)((f1 - f2) * 1000.0F);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = ((int)(-this.jdField_b_of_type_Float * f1));
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    if (paramInt3 == 0) {
      j = paramInt1 - paramInt2;
    } else {
      j = paramInt3;
    }
    this.jdField_b_of_type_Float = a(j);
    d(paramInt1, paramInt2, paramInt3);
    b();
  }
  
  void a()
  {
    this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(float paramFloat)
  {
    int j = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = (j + Math.round(paramFloat * (this.jdField_c_of_type_Int - j)));
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = (paramInt1 + paramInt2);
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_e_of_type_Int = paramInt3;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_d_of_type_Int = 0;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.h = paramInt5;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt2;
    float f1 = paramInt2;
    this.jdField_a_of_type_Float = f1;
    this.f = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt1;
    if ((paramInt1 <= paramInt4) && (paramInt1 >= paramInt3))
    {
      this.i = 0;
      double d1 = 0.0D;
      if (paramInt2 != 0)
      {
        paramInt5 = a(paramInt2);
        this.f = paramInt5;
        this.jdField_e_of_type_Int = paramInt5;
        d1 = b(paramInt2);
      }
      double d2 = Math.signum(f1);
      Double.isNaN(d2);
      this.g = ((int)(d1 * d2));
      this.jdField_c_of_type_Int = (paramInt1 + this.g);
      paramInt1 = this.jdField_c_of_type_Int;
      if (paramInt1 < paramInt3)
      {
        b(this.jdField_a_of_type_Int, paramInt1, paramInt3);
        this.jdField_c_of_type_Int = paramInt3;
      }
      paramInt1 = this.jdField_c_of_type_Int;
      if (paramInt1 > paramInt4)
      {
        b(this.jdField_a_of_type_Int, paramInt1, paramInt4);
        this.jdField_c_of_type_Int = paramInt4;
      }
      return;
    }
    a(paramInt1, paramInt3, paramInt4, paramInt2);
  }
  
  boolean a()
  {
    int j = this.i;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j == 2)
        {
          this.jdField_a_of_type_Long += this.jdField_e_of_type_Int;
          c(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, 0);
        }
      }
      else {
        return false;
      }
    }
    else
    {
      if (this.jdField_e_of_type_Int >= this.f) {
        break label118;
      }
      this.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_Float);
      this.jdField_b_of_type_Float = a(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_Long += this.jdField_e_of_type_Int;
      b();
    }
    b();
    return true;
    label118:
    return false;
  }
  
  boolean b()
  {
    long l = AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long;
    int j = this.jdField_e_of_type_Int;
    if (l > j) {
      return false;
    }
    double d1 = 0.0D;
    int k = this.i;
    float f1;
    float f2;
    float f3;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k == 2)
        {
          f1 = (float)l / 1000.0F;
          j = this.jdField_d_of_type_Int;
          f2 = j;
          f3 = this.jdField_b_of_type_Float;
          this.jdField_a_of_type_Float = (f2 + f3 * f1);
          d1 = j * f1 + f3 * f1 * f1 / 2.0F;
        }
      }
      else
      {
        f1 = (float)l / j;
        f2 = f1 * f1;
        f3 = Math.signum(this.jdField_d_of_type_Int);
        j = this.h;
        d1 = j * f3 * (3.0F * f2 - 2.0F * f1 * f2);
        this.jdField_a_of_type_Float = (f3 * j * 6.0F * (-f1 + f2));
      }
    }
    else
    {
      f3 = (float)l / this.f;
      j = (int)(f3 * 100.0F);
      f1 = 1.0F;
      f2 = 0.0F;
      if (j < 100)
      {
        f1 = j / 100.0F;
        k = j + 1;
        f2 = k / 100.0F;
        float[] arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
        float f4 = arrayOfFloat[j];
        f2 = (arrayOfFloat[k] - f4) / (f2 - f1);
        f1 = f4 + (f3 - f1) * f2;
      }
      j = this.g;
      d1 = f1 * j;
      this.jdField_a_of_type_Float = (f2 * j / this.f * 1000.0F);
    }
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int + (int)Math.round(d1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.OverScroller.SplineOverScroller
 * JD-Core Version:    0.7.0.1
 */