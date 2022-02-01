package com.tencent.av.wtogether.gles;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class WatchTogetherSurfaceTextureHolder
{
  private volatile int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private WatchTogetherSurfaceTextureHolder.OnSurfaceTextureEglFoucusListener jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder$OnSurfaceTextureEglFoucusListener;
  private volatile Thread jdField_a_of_type_JavaLangThread;
  private boolean jdField_a_of_type_Boolean = false;
  
  public WatchTogetherSurfaceTextureHolder(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
  }
  
  public void a(int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_Int != paramInt) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.jdField_a_of_type_JavaLangThread == null) || ((this.jdField_a_of_type_JavaLangThread == Thread.currentThread()) && (i != 0)))
    {
      if ((i != 0) && (Build.VERSION.SDK_INT >= 16))
      {
        if ((this.jdField_a_of_type_Int != 0) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.detachFromGLContext();
          QLog.d("WatchTogetherSurfaceTextureHolder", 1, "attachToGLContext detach");
        }
        this.jdField_a_of_type_Int = paramInt;
      }
      if ((Build.VERSION.SDK_INT >= 16) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.attachToGLContext(paramInt);
        this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
        QLog.d("WatchTogetherSurfaceTextureHolder", 1, "attachToGLContext real attch");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attachToGLContext textureId ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",Thread.currentThread()):=");
      localStringBuilder.append(Thread.currentThread());
      QLog.d("WatchTogetherSurfaceTextureHolder", 1, localStringBuilder.toString());
    }
  }
  
  public void a(WatchTogetherSurfaceTextureHolder.OnSurfaceTextureEglFoucusListener paramOnSurfaceTextureEglFoucusListener)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder$OnSurfaceTextureEglFoucusListener = paramOnSurfaceTextureEglFoucusListener;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramArrayOfFloat);
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_JavaLangThread == null) && (this.jdField_a_of_type_Int == 0)) || (this.jdField_a_of_type_JavaLangThread == Thread.currentThread());
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("detachFromGLContext Thread.currentThread()):=");
    ((StringBuilder)localObject).append(Thread.currentThread());
    QLog.d("WatchTogetherSurfaceTextureHolder", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_JavaLangThread != Thread.currentThread()) {
      QLog.d("WatchTogetherSurfaceTextureHolder", 1, "detachFromGLContext error", new Throwable("detachFromGLContext"));
    }
    if ((Build.VERSION.SDK_INT >= 16) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.detachFromGLContext();
      localObject = new int[1];
      localObject[0] = this.jdField_a_of_type_Int;
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangThread = null;
  }
  
  public void d()
  {
    QLog.d("WatchTogetherSurfaceTextureHolder", 1, "lostEglContext");
    WatchTogetherSurfaceTextureHolder.OnSurfaceTextureEglFoucusListener localOnSurfaceTextureEglFoucusListener = this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder$OnSurfaceTextureEglFoucusListener;
    if (localOnSurfaceTextureEglFoucusListener != null) {
      localOnSurfaceTextureEglFoucusListener.a(this.jdField_a_of_type_JavaLangThread);
    }
    this.jdField_a_of_type_JavaLangThread = null;
  }
  
  public void e()
  {
    QLog.d("WatchTogetherSurfaceTextureHolder", 1, "onResponsePauseMessage");
    WatchTogetherSurfaceTextureHolder.OnSurfaceTextureEglFoucusListener localOnSurfaceTextureEglFoucusListener = this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder$OnSurfaceTextureEglFoucusListener;
    if (localOnSurfaceTextureEglFoucusListener != null) {
      localOnSurfaceTextureEglFoucusListener.a();
    }
    this.jdField_a_of_type_JavaLangThread = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.gles.WatchTogetherSurfaceTextureHolder
 * JD-Core Version:    0.7.0.1
 */