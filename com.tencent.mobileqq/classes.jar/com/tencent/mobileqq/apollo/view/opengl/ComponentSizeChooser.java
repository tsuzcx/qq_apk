package com.tencent.mobileqq.apollo.view.opengl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class ComponentSizeChooser
  extends BaseConfigChooser
{
  protected int b;
  private int[] b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  
  public ComponentSizeChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super(paramInt1, new int[] { 12324, paramInt2, 12323, paramInt3, 12322, paramInt4, 12321, paramInt5, 12325, paramInt6, 12326, paramInt7, 12344 });
    this.jdField_b_of_type_ArrayOfInt = new int[1];
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.jdField_b_of_type_ArrayOfInt)) {
      paramInt2 = this.jdField_b_of_type_ArrayOfInt[0];
    }
    return paramInt2;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
      if ((k >= this.f) && (m >= this.g))
      {
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
        if ((k == this.jdField_b_of_type_Int) && (m == this.c) && (n == this.d) && (i1 == this.e)) {
          return localEGLConfig;
        }
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.ComponentSizeChooser
 * JD-Core Version:    0.7.0.1
 */