package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class ApolloConfigChooser
  implements EGLConfigChooser
{
  private int a;
  private boolean b;
  
  public ApolloConfigChooser(int paramInt)
  {
    this(paramInt, false);
  }
  
  public ApolloConfigChooser(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ApolloConfigChooser], multiValue:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", isOffscreen:");
    localStringBuilder.append(paramBoolean);
    QLog.i("[cmshow]ApolloConfigChooser", 1, localStringBuilder.toString());
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    if ((this.b) && (CmShowWnsUtils.B()))
    {
      i = this.a;
      arrayOfEGLConfig = new EGLConfig[1];
      arrayOfInt = new int[1];
      paramEGL10.eglChooseConfig(paramEGLDisplay, new int[] { 12329, 0, 12352, 4, 12351, 12430, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12321, 8, 12326, 0, 12338, 1, 12339, 1, 12337, i, 12344 }, arrayOfEGLConfig, 1, arrayOfInt);
      if (arrayOfInt[0] == 0) {
        QLog.e("[cmshow]ApolloConfigChooser", 1, "[ApolloConfigChooser], fail to set offscreen config");
      } else {
        return arrayOfEGLConfig[0];
      }
    }
    int i = this.a;
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, new int[] { 12329, 0, 12352, 4, 12351, 12430, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12321, 8, 12326, 0, 12338, 1, 12337, i, 12344 }, arrayOfEGLConfig, 1, arrayOfInt);
    if (arrayOfInt[0] == 0)
    {
      QLog.e("[cmshow]ApolloConfigChooser", 1, "[ApolloConfigChooser], fail to set config");
      return null;
    }
    return arrayOfEGLConfig[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.ApolloConfigChooser
 * JD-Core Version:    0.7.0.1
 */