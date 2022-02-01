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
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("render, surface[");
        localStringBuilder.append(paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        localStringBuilder.append("]");
        QLog.i("SurfaceTag", 4, localStringBuilder.toString(), localThrowable);
      }
    }
    if (paramCameraFrame.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramCameraFrame.jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_Boolean)
      {
        Matrix.setIdentityM(this.b, 0);
        Matrix.scaleM(this.b, 0, -1.0F, -1.0F, 1.0F);
      }
      else
      {
        Matrix.setIdentityM(this.b, 0);
        Matrix.scaleM(this.b, 0, 1.0F, -1.0F, 1.0F);
      }
    }
    int i = paramCameraFrame.b;
    int j = paramCameraFrame.jdField_a_of_type_Int;
    GLES20.glBindFramebuffer(36160, paramGLTexture.jdField_a_of_type_Int);
    GLES20.glViewport(0, 0, i, j);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    TextureRender localTextureRender = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
    if (localTextureRender != null) {
      localTextureRender.drawTexture(36197, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, this.b);
    }
    GLES20.glBindFramebuffer(36160, 0);
    try
    {
      if (Build.VERSION.SDK_INT >= 19) {
        paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture.releaseTexImage();
      }
    }
    catch (Throwable paramCameraFrame)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("SurfaceTag", 4, "render", paramCameraFrame);
      }
    }
    if (paramFilterProcessRender.a != null) {
      paramFilterProcessRender.a.b("preRender");
    }
    return paramGLTexture;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_a_of_type_Int = GlUtil.createTexture(36197);
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localSurfaceTexture != null)
    {
      try
      {
        localSurfaceTexture.detachFromGLContext();
      }
      catch (Throwable localThrowable1)
      {
        QLog.i("SurfaceTag", 2, "genTexture1", localThrowable1);
      }
      try
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.attachToGLContext(this.jdField_a_of_type_Int);
      }
      catch (Throwable localThrowable2)
      {
        QLog.i("SurfaceTag", 2, "genTexture2", localThrowable2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "genTexture");
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
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localSurfaceTexture != null) {
      try
      {
        localSurfaceTexture.detachFromGLContext();
      }
      catch (Throwable localThrowable)
      {
        QLog.i("SurfaceTag", 2, "delTexture", localThrowable);
      }
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.jdField_a_of_type_Int;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "delTexture");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.SurfacePreRender
 * JD-Core Version:    0.7.0.1
 */