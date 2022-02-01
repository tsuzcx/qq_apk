package com.tencent.ilivesdk.playview.view;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class GLTextureView$ComponentSizeChooser
  extends GLTextureView.BaseConfigChooser
{
  protected int mAlphaSize;
  protected int mBlueSize;
  protected int mDepthSize;
  protected int mGreenSize;
  protected int mRedSize;
  protected int mStencilSize;
  private int[] mValue = new int[1];
  
  public GLTextureView$ComponentSizeChooser(GLTextureView paramGLTextureView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramGLTextureView, new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 });
    this.mRedSize = paramInt1;
    this.mGreenSize = paramInt2;
    this.mBlueSize = paramInt3;
    this.mAlphaSize = paramInt4;
    this.mDepthSize = paramInt5;
    this.mStencilSize = paramInt6;
  }
  
  private int findConfigAttrib(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.mValue)) {
      paramInt2 = this.mValue[0];
    }
    return paramInt2;
  }
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
      int m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
      if ((k >= this.mDepthSize) && (m >= this.mStencilSize))
      {
        k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
        m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
        int n = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
        int i1 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
        if ((k == this.mRedSize) && (m == this.mGreenSize) && (n == this.mBlueSize) && (i1 == this.mAlphaSize)) {
          return localEGLConfig;
        }
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.GLTextureView.ComponentSizeChooser
 * JD-Core Version:    0.7.0.1
 */