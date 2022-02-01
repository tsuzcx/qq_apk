package com.tencent.av.opengl.ui.animation;

import com.tencent.av.opengl.ui.GLView;
import java.util.List;

public class GLAnimation
{
  private boolean A = false;
  private float B = 0.0F;
  private float C = 0.0F;
  private float D = 0.0F;
  private float E = 0.0F;
  private float F = 0.0F;
  private float G = 0.0F;
  private float H = 0.0F;
  private float I = 0.0F;
  private float J = 0.0F;
  private GLAnimation.AnimationListenerGL K;
  private int a = 0;
  private boolean b = false;
  private int c = 1000;
  private long d = 0L;
  private GLView e;
  private boolean f = false;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 0.0F;
  private float j = 0.0F;
  private float k = 0.0F;
  private float l = 0.0F;
  private float m = 0.0F;
  private float n = 0.0F;
  private float o = 0.0F;
  private boolean p = false;
  private float q = 1.0F;
  private float r = 1.0F;
  private float s = 0.0F;
  private boolean t = false;
  private float u = 1.0F;
  private float v = 1.0F;
  private float w = 1.0F;
  private float x = 1.0F;
  private float y = 0.0F;
  private float z = 0.0F;
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.t = true;
    this.u = paramFloat1;
    this.y = paramFloat1;
    this.v = paramFloat2;
    this.z = paramFloat2;
    this.w = paramFloat3;
    this.x = paramFloat4;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.f = true;
    this.g = paramFloat1;
    this.i = paramFloat1;
    this.j = paramFloat2;
    this.l = paramFloat2;
    this.m = paramFloat3;
    this.o = paramFloat3;
    this.h = paramFloat4;
    this.k = paramFloat5;
    this.n = paramFloat6;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(GLView paramGLView)
  {
    this.e = paramGLView;
  }
  
  public void a(GLAnimation.AnimationListenerGL paramAnimationListenerGL)
  {
    this.K = paramAnimationListenerGL;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public boolean a(long paramLong)
  {
    if (this.b)
    {
      m();
    }
    else
    {
      if (this.d == -1L) {
        this.d = paramLong;
      }
      long l1 = paramLong - this.d;
      if (l1 == 0L) {
        return false;
      }
      int i1 = this.c;
      paramLong = l1;
      if (l1 >= i1)
      {
        paramLong = i1;
        this.b = true;
        m();
      }
      i1 = this.a;
      float f1 = 1.0F;
      float f2;
      if (i1 == 0)
      {
        f1 = (float)paramLong * 1.0F / this.c;
      }
      else if (i1 == 1)
      {
        f1 = (float)paramLong;
        i1 = this.c;
        f1 = 1.0F * f1 * f1 / i1 / i1;
      }
      else if (i1 == 2)
      {
        l1 = this.c;
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
      if (this.f)
      {
        f2 = this.g;
        this.i = (f2 + (this.h - f2) * f1);
        f2 = this.j;
        this.l = (f2 + (this.k - f2) * f1);
        f2 = this.m;
        this.o = (f2 + (this.n - f2) * f1);
      }
      if (this.t)
      {
        f2 = this.u;
        this.y = (f2 + (this.w - f2) * f1);
        f2 = this.v;
        this.z = (f2 + (this.x - f2) * f1);
      }
      if (this.A)
      {
        f2 = this.B;
        this.H = (f2 + (this.C - f2) * f1);
        f2 = this.D;
        this.I = (f2 + (this.E - f2) * f1);
        f2 = this.F;
        this.J = (f2 + (this.G - f2) * f1);
      }
      if (this.p)
      {
        f2 = this.q;
        this.s = (f2 + f1 * (this.r - f2));
      }
    }
    return this.b;
  }
  
  public float b()
  {
    return this.i;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.A = true;
    this.B = paramFloat1;
    this.H = paramFloat1;
    this.C = paramFloat2;
    this.D = paramFloat3;
    this.I = paramFloat3;
    this.E = paramFloat4;
    this.F = paramFloat5;
    this.J = paramFloat5;
    this.G = paramFloat6;
  }
  
  public void b(int paramInt)
  {
    this.c = Math.abs(paramInt);
    if (this.c == 0) {
      this.c = 1;
    }
  }
  
  public float c()
  {
    return this.l;
  }
  
  public float d()
  {
    return this.o;
  }
  
  public boolean e()
  {
    return this.t;
  }
  
  public float f()
  {
    return this.y;
  }
  
  public float g()
  {
    return this.z;
  }
  
  public boolean h()
  {
    return this.A;
  }
  
  public float i()
  {
    return this.H;
  }
  
  public float j()
  {
    return this.I;
  }
  
  public float k()
  {
    return this.J;
  }
  
  public void l()
  {
    this.d = -1L;
  }
  
  public void m()
  {
    ??? = this.e;
    if (??? != null) {
      synchronized (((GLView)???).a())
      {
        this.e.a().remove(this);
      }
    }
    ??? = this.K;
    if (??? != null)
    {
      ((GLAnimation.AnimationListenerGL)???).a();
      this.K = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.animation.GLAnimation
 * JD-Core Version:    0.7.0.1
 */