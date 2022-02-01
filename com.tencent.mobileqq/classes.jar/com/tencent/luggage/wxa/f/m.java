package com.tencent.luggage.wxa.f;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.sm.i;
import com.tencent.luggage.wxa.sn.a;

class m
  extends l
{
  final i a;
  
  m(Context paramContext, ViewGroup paramViewGroup, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    this.a = new i(paramContext, paramSurfaceTexture, paramInt1, paramInt2);
    boolean bool = com.tencent.luggage.wxa.sq.c.b(paramContext);
    this.a.a(new m.1(this, 1, bool), bool);
    paramContext = this.a.getHolder();
    paramContext.setType(3);
    paramContext.addCallback(new m.2(this));
  }
  
  void a()
  {
    i locali = this.a;
    if (locali != null) {
      locali.a();
    }
  }
  
  void a(int paramInt) {}
  
  void a(l.a parama)
  {
    i locali = this.a;
    if (locali != null) {
      locali.a(new m.3(this, parama));
    }
  }
  
  void a(a parama)
  {
    i locali = this.a;
    if (locali != null) {
      locali.a(parama);
    }
  }
  
  com.tencent.luggage.wxa.sm.c b()
  {
    i locali = this.a;
    if (locali != null) {
      return locali.getFrameDataCallback();
    }
    return null;
  }
  
  EGLContext c()
  {
    i locali = this.a;
    if (locali != null) {
      return locali.getEGLContext();
    }
    return null;
  }
  
  void d()
  {
    i locali = this.a;
    if (locali != null) {
      locali.b();
    }
  }
  
  Surface e()
  {
    return f().getSurface();
  }
  
  SurfaceHolder f()
  {
    return this.a.getHolder();
  }
  
  View g()
  {
    return this.a;
  }
  
  Class h()
  {
    return SurfaceHolder.class;
  }
  
  boolean i()
  {
    return (l() != 0) && (m() != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.m
 * JD-Core Version:    0.7.0.1
 */