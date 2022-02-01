package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class DefaultContextFactory
  implements EGLContextFactory
{
  private int a = 12440;
  private int b;
  
  public DefaultContextFactory(int paramInt)
  {
    this.b = paramInt;
  }
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.a;
    arrayOfInt[1] = this.b;
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (this.b == 0) {
      arrayOfInt = null;
    }
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("display:");
      localStringBuilder.append(paramEGLDisplay);
      localStringBuilder.append(" context: ");
      localStringBuilder.append(paramEGLContext);
      QLog.e("[ApolloGL][DefaultContextFactory]", 1, localStringBuilder.toString());
      EglHelper.a("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.DefaultContextFactory
 * JD-Core Version:    0.7.0.1
 */