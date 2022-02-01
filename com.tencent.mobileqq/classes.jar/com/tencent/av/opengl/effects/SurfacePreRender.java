package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.av.utils.PerfRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(16)
public class SurfacePreRender
  implements PreRender
{
  private int jdField_a_of_type_Int = 0;
  public final SurfaceTexture a;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private boolean jdField_a_of_type_Boolean = true;
  private final float[] jdField_a_of_type_ArrayOfFloat;
  private final float[] b;
  
  public SurfacePreRender(SurfaceTexture paramSurfaceTexture)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "SurfacePreRender");
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    CameraFrame.a("SurfaceMode");
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    this.jdField_a_of_type_Boolean = true;
    this.b = new float[16];
    Matrix.setIdentityM(this.b, 0);
    Matrix.scaleM(this.b, 0, -1.0F, -1.0F, 1.0F);
  }
  
  public GLTexture a(FilterProcessRender paramFilterProcessRender, CameraFrame paramCameraFrame, GLTexture paramGLTexture)
  {
    if (paramFilterProcessRender.a != null) {
      paramFilterProcessRender.a.a("preRender");
    }
    try
    {
      paramCameraFrame.a(this.jdField_a_of_type_ArrayOfFloat);
      if (paramCameraFrame.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = paramCameraFrame.jdField_a_of_type_Boolean;
        if (this.jdField_a_of_type_Boolean)
        {
          Matrix.setIdentityM(this.b, 0);
          Matrix.scaleM(this.b, 0, -1.0F, -1.0F, 1.0F);
        }
      }
      else
      {
        int i = paramCameraFrame.b;
        int j = paramCameraFrame.jdField_a_of_type_Int;
        GLES20.glBindFramebuffer(36160, paramGLTexture.jdField_a_of_type_Int);
        GLES20.glViewport(0, 0, i, j);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, this.b);
        }
        GLES20.glBindFramebuffer(36160, 0);
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          if (Build.VERSION.SDK_INT >= 19) {
            paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture.releaseTexImage();
          }
          if (paramFilterProcessRender.a != null) {
            paramFilterProcessRender.a.b("preRender");
          }
          return paramGLTexture;
          localThrowable = localThrowable;
          if (QLog.isDevelopLevel()) {
            QLog.i("SurfaceTag", 4, "render, surface[" + paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture + "]", localThrowable);
          }
        }
        Matrix.setIdentityM(this.b, 0);
        Matrix.scaleM(this.b, 0, 1.0F, -1.0F, 1.0F);
      }
      catch (Throwable paramCameraFrame)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("SurfaceTag", 4, "render", paramCameraFrame);
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_a_of_type_Int = GlUtil.createTexture(36197);
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.detachFromGLContext();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.attachToGLContext(this.jdField_a_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.i("SurfaceTag", 2, "genTexture");
          }
          return;
          localThrowable1 = localThrowable1;
          QLog.i("SurfaceTag", 2, "genTexture1", localThrowable1);
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.i("SurfaceTag", 2, "genTexture2", localThrowable2);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public boolean a(CameraFrame paramCameraFrame)
  {
    return (paramCameraFrame != null) && (paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) && (paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture == this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.detachFromGLContext();
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.jdField_a_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      if (QLog.isColorLevel()) {
        QLog.i("SurfaceTag", 2, "delTexture");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("SurfaceTag", 2, "delTexture", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.SurfacePreRender
 * JD-Core Version:    0.7.0.1
 */