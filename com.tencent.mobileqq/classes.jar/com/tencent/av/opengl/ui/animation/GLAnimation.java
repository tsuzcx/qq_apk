package com.tencent.av.opengl.ui.animation;

import com.tencent.av.opengl.ui.GLView;
import java.util.List;

public class GLAnimation
{
  private float A = 0.0F;
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private GLView jdField_a_of_type_ComTencentAvOpenglUiGLView;
  private GLAnimation.AnimationListenerGL jdField_a_of_type_ComTencentAvOpenglUiAnimationGLAnimation$AnimationListenerGL;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 1000;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.0F;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 0.0F;
  private boolean jdField_d_of_type_Boolean = false;
  private float jdField_e_of_type_Float = 0.0F;
  private boolean jdField_e_of_type_Boolean = false;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 0.0F;
  private float j = 1.0F;
  private float k = 1.0F;
  private float l = 0.0F;
  private float m = 1.0F;
  private float n = 1.0F;
  private float o = 1.0F;
  private float p = 1.0F;
  private float q = 0.0F;
  private float r = 0.0F;
  private float s = 0.0F;
  private float t = 0.0F;
  private float u = 0.0F;
  private float v = 0.0F;
  private float w = 0.0F;
  private float x = 0.0F;
  private float y = 0.0F;
  private float z = 0.0F;
  
  public float a()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_d_of_type_Boolean = true;
    this.m = paramFloat1;
    this.q = paramFloat1;
    this.n = paramFloat2;
    this.r = paramFloat2;
    this.o = paramFloat3;
    this.p = paramFloat4;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat1;
    this.jdField_d_of_type_Float = paramFloat2;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.i = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.jdField_e_of_type_Float = paramFloat5;
    this.h = paramFloat6;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(GLView paramGLView)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView = paramGLView;
  }
  
  public void a(GLAnimation.AnimationListenerGL paramAnimationListenerGL)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiAnimationGLAnimation$AnimationListenerGL = paramAnimationListenerGL;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b();
    }
    else
    {
      if (this.jdField_a_of_type_Long == -1L) {
        this.jdField_a_of_type_Long = paramLong;
      }
      long l1 = paramLong - this.jdField_a_of_type_Long;
      if (l1 == 0L) {
        return false;
      }
      int i1 = this.jdField_b_of_type_Int;
      paramLong = l1;
      if (l1 >= i1)
      {
        paramLong = i1;
        this.jdField_a_of_type_Boolean = true;
        b();
      }
      i1 = this.jdField_a_of_type_Int;
      float f1 = 1.0F;
      float f2;
      if (i1 == 0)
      {
        f1 = (float)paramLong * 1.0F / this.jdField_b_of_type_Int;
      }
      else if (i1 == 1)
      {
        f1 = (float)paramLong;
        i1 = this.jdField_b_of_type_Int;
        f1 = 1.0F * f1 * f1 / i1 / i1;
      }
      else if (i1 == 2)
      {
        l1 = this.jdField_b_of_type_Int;
        if (paramLong == 0L)
        {
          f1 = 0.0F;
        }
        else
        {
          f1 = (float)paramLong;
          f2 = (float)l1;
          f1 = f1 * 1.0F * f1 / f2 / f2 * (f2 * 2.0F / f1 - 1.0F);
        }
      }
      if (this.jdField_b_of_type_Boolean)
      {
        f2 = this.jdField_a_of_type_Float;
        this.jdField_c_of_type_Float = (f2 + (this.jdField_b_of_type_Float - f2) * f1);
        f2 = this.jdField_d_of_type_Float;
        this.f = (f2 + (this.jdField_e_of_type_Float - f2) * f1);
        f2 = this.g;
        this.i = (f2 + (this.h - f2) * f1);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        f2 = this.m;
        this.q = (f2 + (this.o - f2) * f1);
        f2 = this.n;
        this.r = (f2 + (this.p - f2) * f1);
      }
      if (this.jdField_e_of_type_Boolean)
      {
        f2 = this.s;
        this.y = (f2 + (this.t - f2) * f1);
        f2 = this.u;
        this.z = (f2 + (this.v - f2) * f1);
        f2 = this.w;
        this.A = (f2 + (this.x - f2) * f1);
      }
      if (this.jdField_c_of_type_Boolean)
      {
        f2 = this.j;
        this.l = (f2 + f1 * (this.k - f2));
      }
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public float b()
  {
    return this.f;
  }
  
  public void b()
  {
    ??? = this.jdField_a_of_type_ComTencentAvOpenglUiGLView;
    if (??? != null) {
      synchronized (((GLView)???).a())
      {
        this.jdField_a_of_type_ComTencentAvOpenglUiGLView.a().remove(this);
      }
    }
    ??? = this.jdField_a_of_type_ComTencentAvOpenglUiAnimationGLAnimation$AnimationListenerGL;
    if (??? != null)
    {
      ((GLAnimation.AnimationListenerGL)???).a();
      this.jdField_a_of_type_ComTencentAvOpenglUiAnimationGLAnimation$AnimationListenerGL = null;
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_e_of_type_Boolean = true;
    this.s = paramFloat1;
    this.y = paramFloat1;
    this.t = paramFloat2;
    this.u = paramFloat3;
    this.z = paramFloat3;
    this.v = paramFloat4;
    this.w = paramFloat5;
    this.A = paramFloat5;
    this.x = paramFloat6;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = Math.abs(paramInt);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public float c()
  {
    return this.i;
  }
  
  public boolean c()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public float d()
  {
    return this.q;
  }
  
  public float e()
  {
    return this.r;
  }
  
  public float f()
  {
    return this.y;
  }
  
  public float g()
  {
    return this.z;
  }
  
  public float h()
  {
    return this.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.animation.GLAnimation
 * JD-Core Version:    0.7.0.1
 */