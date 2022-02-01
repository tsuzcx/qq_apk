package com.tencent.map.sdk.a;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class pv$b
  extends pv.a
{
  protected int c = 8;
  protected int d = 8;
  protected int e = 8;
  protected int f;
  protected int g;
  protected int h;
  private int[] j = new int[1];
  
  public pv$b(pv parampv, int paramInt1, int paramInt2)
  {
    super(parampv, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, paramInt1, 12325, paramInt2, 12326, 0, 12344 });
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = 0;
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    int k = 0;
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.j)) {
      k = this.j[0];
    }
    return k;
  }
  
  public final EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int m = paramArrayOfEGLConfig.length;
    int k = 0;
    while (k < m)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[k];
      int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((n >= this.g) && (i1 >= this.h))
      {
        n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((n == this.c) && (i1 == this.d) && (i2 == this.e) && (i3 == this.f)) {
          return localEGLConfig;
        }
      }
      k += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pv.b
 * JD-Core Version:    0.7.0.1
 */