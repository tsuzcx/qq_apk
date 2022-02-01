package com.tencent.mobileqq.apollo.view.opengl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public abstract class BaseConfigChooser
  implements EGLConfigChooser
{
  protected int a;
  protected int[] b = a(paramArrayOfInt);
  
  public BaseConfigChooser(int paramInt, int[] paramArrayOfInt)
  {
    this.a = paramInt;
  }
  
  private int[] a(int[] paramArrayOfInt)
  {
    int i = this.a;
    if ((i != 2) && (i != 3)) {
      return paramArrayOfInt;
    }
    i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 2];
    int j = i - 1;
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, j);
    arrayOfInt[j] = 12352;
    if (this.a == 2) {
      arrayOfInt[i] = 4;
    } else {
      arrayOfInt[i] = 64;
    }
    arrayOfInt[(i + 1)] = 12344;
    return arrayOfInt;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (paramEGL10.eglChooseConfig(paramEGLDisplay, this.b, null, 0, arrayOfInt))
    {
      int i = arrayOfInt[0];
      if (i > 0)
      {
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
        if (paramEGL10.eglChooseConfig(paramEGLDisplay, this.b, arrayOfEGLConfig, i, arrayOfInt))
        {
          paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
          if (paramEGL10 != null) {
            return paramEGL10;
          }
          throw new IllegalArgumentException("No config chosen");
        }
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      }
      throw new IllegalArgumentException("No configs match configSpec");
    }
    throw new IllegalArgumentException("eglChooseConfig failed");
  }
  
  abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.BaseConfigChooser
 * JD-Core Version:    0.7.0.1
 */