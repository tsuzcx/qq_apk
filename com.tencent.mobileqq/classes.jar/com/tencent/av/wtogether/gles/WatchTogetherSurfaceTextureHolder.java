package com.tencent.av.wtogether.gles;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class WatchTogetherSurfaceTextureHolder
{
  private SurfaceTexture a;
  private volatile Thread b;
  private volatile int c;
  private boolean d = false;
  private WatchTogetherSurfaceTextureHolder.OnSurfaceTextureEglFoucusListener e;
  
  public WatchTogetherSurfaceTextureHolder(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    this.a = paramSurfaceTexture;
    this.c = paramInt;
    this.b = Thread.currentThread();
  }
  
  public void a()
  {
    this.a.updateTexImage();
  }
  
  public void a(int paramInt)
  {
    int i;
    if (this.c != paramInt) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.b == null) || ((this.b == Thread.currentThread()) && (i != 0)))
    {
      if ((i != 0) && (Build.VERSION.SDK_INT >= 16))
      {
        if ((this.c != 0) && (!this.d))
        {
          this.a.detachFromGLContext();
          QLog.d("WatchTogetherSurfaceTextureHolder", 1, "attachToGLContext detach");
        }
        this.c = paramInt;
      }
      if ((Build.VERSION.SDK_INT >= 16) && (!this.d))
      {
        this.a.attachToGLContext(paramInt);
        this.b = Thread.currentThread();
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
    this.e = paramOnSurfaceTextureEglFoucusListener;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.a.getTransformMatrix(paramArrayOfFloat);
  }
  
  public void b()
  {
    this.d = true;
  }
  
  public boolean c()
  {
    return ((this.b == null) && (this.c == 0)) || (this.b == Thread.currentThread());
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("detachFromGLContext Thread.currentThread()):=");
    ((StringBuilder)localObject).append(Thread.currentThread());
    QLog.d("WatchTogetherSurfaceTextureHolder", 1, ((StringBuilder)localObject).toString());
    if (this.b != Thread.currentThread()) {
      QLog.d("WatchTogetherSurfaceTextureHolder", 1, "detachFromGLContext error", new Throwable("detachFromGLContext"));
    }
    if ((Build.VERSION.SDK_INT >= 16) && (!this.d))
    {
      this.a.detachFromGLContext();
      localObject = new int[1];
      localObject[0] = this.c;
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    }
    this.c = 0;
    this.b = null;
  }
  
  public void e()
  {
    QLog.d("WatchTogetherSurfaceTextureHolder", 1, "lostEglContext");
    WatchTogetherSurfaceTextureHolder.OnSurfaceTextureEglFoucusListener localOnSurfaceTextureEglFoucusListener = this.e;
    if (localOnSurfaceTextureEglFoucusListener != null) {
      localOnSurfaceTextureEglFoucusListener.a(this.b);
    }
    this.b = null;
  }
  
  public void f()
  {
    QLog.d("WatchTogetherSurfaceTextureHolder", 1, "onResponsePauseMessage");
    WatchTogetherSurfaceTextureHolder.OnSurfaceTextureEglFoucusListener localOnSurfaceTextureEglFoucusListener = this.e;
    if (localOnSurfaceTextureEglFoucusListener != null) {
      localOnSurfaceTextureEglFoucusListener.a();
    }
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.gles.WatchTogetherSurfaceTextureHolder
 * JD-Core Version:    0.7.0.1
 */