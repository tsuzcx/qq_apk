package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;

class f$c
  extends t
{
  int r;
  int s;
  float t = 1.5F;
  
  public f$c()
  {
    super(null, null);
  }
  
  void a(float paramFloat)
  {
    this.t = paramFloat;
    a(this.r, this.t / this.e);
    a(this.s, this.t / this.f);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    a(this.t);
  }
  
  public boolean a()
  {
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(2);
    if ((this.a != 0) && (b())) {
      this.g = true;
    } else {
      this.g = false;
    }
    c();
    return this.g;
  }
  
  public boolean b()
  {
    if (super.b())
    {
      this.r = GLES20.glGetUniformLocation(this.a, "texelWidthOffset");
      this.s = GLES20.glGetUniformLocation(this.a, "texelHeightOffset");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.f.c
 * JD-Core Version:    0.7.0.1
 */