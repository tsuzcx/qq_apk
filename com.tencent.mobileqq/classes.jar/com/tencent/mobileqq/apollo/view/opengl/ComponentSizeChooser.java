package com.tencent.mobileqq.apollo.view.opengl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class ComponentSizeChooser
  extends BaseConfigChooser
{
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  private int[] i = new int[1];
  
  public ComponentSizeChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super(paramInt1, new int[] { 12324, paramInt2, 12323, paramInt3, 12322, paramInt4, 12321, paramInt5, 12325, paramInt6, 12326, paramInt7, 12344 });
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
    this.h = paramInt7;
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.i)) {
      return this.i[0];
    }
    return paramInt2;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int k = paramArrayOfEGLConfig.length;
    int j = 0;
    while (j < k)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[j];
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
      int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
      if ((m >= this.g) && (n >= this.h))
      {
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
        n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
        int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
        if ((m == this.c) && (n == this.d) && (i1 == this.e) && (i2 == this.f)) {
          return localEGLConfig;
        }
      }
      j += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.ComponentSizeChooser
 * JD-Core Version:    0.7.0.1
 */