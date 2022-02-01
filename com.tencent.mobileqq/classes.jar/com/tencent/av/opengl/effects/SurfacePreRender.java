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
  public final SurfaceTexture a;
  private final float[] b;
  private final float[] c;
  private int d = 0;
  private TextureRender e;
  private boolean f = true;
  
  public SurfacePreRender(SurfaceTexture paramSurfaceTexture)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "SurfacePreRender");
    }
    this.a = paramSurfaceTexture;
    CameraFrame.a("SurfaceMode");
    this.b = new float[16];
    Matrix.setIdentityM(this.b, 0);
    this.f = true;
    this.c = new float[16];
    Matrix.setIdentityM(this.c, 0);
    Matrix.scaleM(this.c, 0, -1.0F, -1.0F, 1.0F);
  }
  
  public GLTexture a(FilterProcessRender paramFilterProcessRender, CameraFrame paramCameraFrame, GLTexture paramGLTexture)
  {
    if (paramFilterProcessRender.j != null) {
      paramFilterProcessRender.j.a("preRender");
    }
    try
    {
      paramCameraFrame.a(this.b);
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("render, surface[");
        localStringBuilder.append(paramCameraFrame.n);
        localStringBuilder.append("]");
        QLog.i("SurfaceTag", 4, localStringBuilder.toString(), localThrowable);
      }
    }
    if (paramCameraFrame.g != this.f)
    {
      this.f = paramCameraFrame.g;
      if (this.f)
      {
        Matrix.setIdentityM(this.c, 0);
        Matrix.scaleM(this.c, 0, -1.0F, -1.0F, 1.0F);
      }
      else
      {
        Matrix.setIdentityM(this.c, 0);
        Matrix.scaleM(this.c, 0, 1.0F, -1.0F, 1.0F);
      }
    }
    int i = paramCameraFrame.c;
    int j = paramCameraFrame.b;
    GLES20.glBindFramebuffer(36160, paramGLTexture.a);
    GLES20.glViewport(0, 0, i, j);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    TextureRender localTextureRender = this.e;
    if (localTextureRender != null) {
      localTextureRender.drawTexture(36197, this.d, this.b, this.c);
    }
    GLES20.glBindFramebuffer(36160, 0);
    try
    {
      if (Build.VERSION.SDK_INT >= 19) {
        paramCameraFrame.n.releaseTexImage();
      }
    }
    catch (Throwable paramCameraFrame)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("SurfaceTag", 4, "render", paramCameraFrame);
      }
    }
    if (paramFilterProcessRender.j != null) {
      paramFilterProcessRender.j.b("preRender");
    }
    return paramGLTexture;
  }
  
  public void a()
  {
    this.e = new TextureRender();
    this.d = GlUtil.createTexture(36197);
    SurfaceTexture localSurfaceTexture = this.a;
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
        this.a.attachToGLContext(this.d);
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
    return (paramCameraFrame != null) && (paramCameraFrame.n != null) && (paramCameraFrame.n == this.a);
  }
  
  public void b() {}
  
  public void c()
  {
    SurfaceTexture localSurfaceTexture = this.a;
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
    arrayOfInt[0] = this.d;
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