package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import dov.com.qq.im.ae.current.SessionWrap;
import org.jetbrains.annotations.NotNull;

public class AECameraConfig
{
  private boolean A;
  private SessionWrap B;
  private String C;
  private Size D;
  private Float E;
  private Integer F;
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private int i = -1;
  private int j;
  private boolean k;
  private int l;
  private final int m;
  private int n;
  private boolean o;
  private boolean p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private AECaptureMode w;
  private AECaptureMode[] x;
  private boolean y;
  private AECameraConfig.LogicPartsGenerator z;
  
  private AECameraConfig(AECameraConfig.Builder paramBuilder)
  {
    this.k = AECameraConfig.Builder.a(paramBuilder);
    this.l = AECameraConfig.Builder.b(paramBuilder);
    this.q = AECameraConfig.Builder.c(paramBuilder);
    this.r = AECameraConfig.Builder.d(paramBuilder);
    this.s = AECameraConfig.Builder.e(paramBuilder);
    this.u = AECameraConfig.Builder.f(paramBuilder);
    this.x = AECameraConfig.Builder.g(paramBuilder);
    this.w = AECameraConfig.Builder.h(paramBuilder);
    this.v = AECameraConfig.Builder.i(paramBuilder);
    this.A = AECameraConfig.Builder.j(paramBuilder);
    this.B = AECameraConfig.Builder.k(paramBuilder);
    this.C = AECameraConfig.Builder.l(paramBuilder);
    this.y = AECameraConfig.Builder.m(paramBuilder);
    this.D = AECameraConfig.Builder.n(paramBuilder);
    this.E = AECameraConfig.Builder.o(paramBuilder);
    this.F = AECameraConfig.Builder.p(paramBuilder);
    this.o = AECameraConfig.Builder.q(paramBuilder);
    this.p = AECameraConfig.Builder.r(paramBuilder);
    this.n = AECameraConfig.Builder.s(paramBuilder);
    this.t = AECameraConfig.Builder.t(paramBuilder);
    this.m = AECameraConfig.Builder.u(paramBuilder);
    this.j = AECameraConfig.Builder.v(paramBuilder);
    this.b = AECameraConfig.Builder.w(paramBuilder);
    this.d = AECameraConfig.Builder.x(paramBuilder);
    this.g = AECameraConfig.Builder.y(paramBuilder);
    this.a = AECameraConfig.Builder.z(paramBuilder);
    this.h = AECameraConfig.Builder.A(paramBuilder);
    this.f = paramBuilder.b;
    this.e = paramBuilder.d;
    this.i = paramBuilder.a;
    this.c = paramBuilder.c;
    if (AECameraConfig.Builder.B(paramBuilder) == null)
    {
      this.z = D();
      return;
    }
    this.z = AECameraConfig.Builder.B(paramBuilder);
  }
  
  @NotNull
  private AECameraConfig.LogicPartsGenerator D()
  {
    return new AECameraConfig.1(this);
  }
  
  public boolean A()
  {
    return this.A;
  }
  
  public SessionWrap B()
  {
    return this.B;
  }
  
  public int C()
  {
    return this.i;
  }
  
  public int a()
  {
    return this.t;
  }
  
  public int b()
  {
    return this.j;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public boolean e()
  {
    return this.a;
  }
  
  public boolean f()
  {
    return this.b;
  }
  
  public boolean g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return this.d;
  }
  
  public boolean i()
  {
    return this.g;
  }
  
  public int j()
  {
    return this.m;
  }
  
  public Integer k()
  {
    if (this.F == null)
    {
      int i2 = CameraHelper.a();
      int i1 = i2;
      if (this.q == 0)
      {
        i1 = i2;
        if (i2 == 0) {
          i1 = 1;
        }
      }
      i2 = this.q;
      if (i2 != 0) {
        i1 = i2;
      }
      this.F = Integer.valueOf(SVParamManager.a().c(i1) * 1000);
    }
    return this.F;
  }
  
  public Float l()
  {
    if (this.E == null)
    {
      int i2 = this.q;
      int i1 = i2;
      if (i2 == 0) {
        i1 = CameraHelper.a();
      }
      this.E = Float.valueOf(SVParamManager.a().b(i1));
    }
    return this.E;
  }
  
  public String m()
  {
    return this.C;
  }
  
  public Size n()
  {
    if (this.D == null)
    {
      int i2 = this.q;
      int i1 = i2;
      if (i2 == 0) {
        i1 = CameraHelper.a();
      }
      this.D = SVParamManager.a().a(i1);
    }
    return this.D;
  }
  
  public int o()
  {
    return this.n;
  }
  
  public boolean p()
  {
    return this.o;
  }
  
  public int q()
  {
    return this.l;
  }
  
  public boolean r()
  {
    return this.p;
  }
  
  public int s()
  {
    return this.q;
  }
  
  public int t()
  {
    return this.r;
  }
  
  public int u()
  {
    return this.s;
  }
  
  public Integer v()
  {
    return Integer.valueOf(this.u);
  }
  
  public int w()
  {
    return this.v;
  }
  
  public AECaptureMode x()
  {
    return this.w;
  }
  
  public AECaptureMode[] y()
  {
    return this.x;
  }
  
  public boolean z()
  {
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECameraConfig
 * JD-Core Version:    0.7.0.1
 */