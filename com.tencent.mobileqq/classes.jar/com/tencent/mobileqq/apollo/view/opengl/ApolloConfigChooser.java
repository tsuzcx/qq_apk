package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class ApolloConfigChooser
  implements EGLConfigChooser
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
  public ApolloConfigChooser(int paramInt)
  {
    this(paramInt, false);
  }
  
  public ApolloConfigChooser(int paramInt, boolean paramBoolean)
  {
    QLog.i("ApolloConfigChooser", 1, "[ApolloConfigChooser], multiValue:" + paramInt + ", isOffscreen:" + paramBoolean);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int i;
    EGLConfig[] arrayOfEGLConfig;
    int[] arrayOfInt;
    if ((this.jdField_a_of_type_Boolean) && (CmShowWnsUtils.r()))
    {
      i = this.jdField_a_of_type_Int;
      arrayOfEGLConfig = new EGLConfig[1];
      arrayOfInt = new int[1];
      paramEGL10.eglChooseConfig(paramEGLDisplay, new int[] { 12329, 0, 12352, 4, 12351, 12430, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12321, 8, 12326, 0, 12338, 1, 12339, 1, 12337, i, 12344 }, arrayOfEGLConfig, 1, arrayOfInt);
      if (arrayOfInt[0] == 0) {
        QLog.e("ApolloConfigChooser", 1, "[ApolloConfigChooser], fail to set offscreen config");
      }
    }
    else
    {
      i = this.jdField_a_of_type_Int;
      arrayOfEGLConfig = new EGLConfig[1];
      arrayOfInt = new int[1];
      paramEGL10.eglChooseConfig(paramEGLDisplay, new int[] { 12329, 0, 12352, 4, 12351, 12430, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12321, 8, 12326, 0, 12338, 1, 12337, i, 12344 }, arrayOfEGLConfig, 1, arrayOfInt);
      if (arrayOfInt[0] != 0) {
        break label408;
      }
      QLog.e("ApolloConfigChooser", 1, "[ApolloConfigChooser], fail to set config");
      return null;
    }
    return arrayOfEGLConfig[0];
    label408:
    return arrayOfEGLConfig[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.ApolloConfigChooser
 * JD-Core Version:    0.7.0.1
 */