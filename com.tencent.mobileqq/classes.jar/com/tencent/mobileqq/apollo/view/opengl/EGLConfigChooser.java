package com.tencent.mobileqq.apollo.view.opengl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public abstract interface EGLConfigChooser
{
  public abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.EGLConfigChooser
 * JD-Core Version:    0.7.0.1
 */