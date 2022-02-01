package com.tencent.jalpha.videoplayer.view;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class GLTextureView$BaseConfigChooser
  implements GLTextureView.EGLConfigChooser
{
  protected int[] mConfigSpec = filterConfigSpec(paramArrayOfInt);
  
  public GLTextureView$BaseConfigChooser(GLTextureView paramGLTextureView, int[] paramArrayOfInt) {}
  
  private int[] filterConfigSpec(int[] paramArrayOfInt)
  {
    if ((GLTextureView.access$1600(this.this$0) != 2) && (GLTextureView.access$1600(this.this$0) != 3)) {
      return paramArrayOfInt;
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 2];
    int j = i - 1;
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, j);
    arrayOfInt[j] = 12352;
    if (GLTextureView.access$1600(this.this$0) == 2) {
      arrayOfInt[i] = 4;
    } else {
      arrayOfInt[i] = 64;
    }
    arrayOfInt[(i + 1)] = 12344;
    return arrayOfInt;
  }
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, (EGLConfig[])null, 0, arrayOfInt))
    {
      int i = arrayOfInt[0];
      if (i > 0)
      {
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
        if (paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, arrayOfEGLConfig, i, arrayOfInt))
        {
          paramEGL10 = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
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
  
  abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.GLTextureView.BaseConfigChooser
 * JD-Core Version:    0.7.0.1
 */