package com.tencent.mobileqq.ar.ARRecord;

import android.view.Surface;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglCore;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglSurfaceBase;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoEncoderWindowSurface
{
  private EglSurfaceBase jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = (EGL10)EGLContext.getEGL();
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentContext();
  private EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentDisplay();
  private EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentSurface(12377);
  
  public VideoEncoderWindowSurface(EglCore paramEglCore, Surface paramSurface)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase = new EglSurfaceBase(paramEglCore);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.a(paramSurface);
  }
  
  public void a()
  {
    EGL10 localEGL10 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
    EGLDisplay localEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
    EGLSurface localEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.a(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.a();
  }
  
  public void d()
  {
    EglSurfaceBase localEglSurfaceBase = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase;
    if (localEglSurfaceBase != null)
    {
      localEglSurfaceBase.a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoderWindowSurface
 * JD-Core Version:    0.7.0.1
 */