package com.tencent.TMG.camera.opengl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import com.tencent.TMG.utils.QLog;

public class SurfaceTextureManager
{
  private static final String TAG = "SurfaceTextureManager";
  EGLContext eglContext = null;
  boolean isInited = false;
  boolean isSupported = true;
  SurfaceTexture mSurfaceTexture = null;
  int[] mTextureId = new int[1];
  
  public SurfaceTextureManager(Context paramContext)
  {
    if ((1 == getGLVersion(paramContext)) || (Build.VERSION.SDK_INT < 11)) {
      this.isSupported = false;
    }
  }
  
  private int getGLVersion(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return 1;
    }
    if (paramContext == null)
    {
      QLog.e("SurfaceTextureManager", 0, "context is null");
      return 1;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getDeviceConfigurationInfo();
      if (paramContext != null)
      {
        if (paramContext.reqGlEsVersion >= 131072) {}
        for (int i = 2;; i = 1) {
          return i;
        }
      }
      QLog.e("SurfaceTextureManager", 0, "getDeviceConfigurationInfo Error");
    }
    QLog.e("SurfaceTextureManager", 0, "getSystemService Error");
    return 1;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.mSurfaceTexture;
  }
  
  public void init()
  {
    QLog.i("SurfaceTextureManager", 0, "SurfaceTextureManager init, isSupported = " + this.isSupported);
    if (this.isSupported) {
      if (Build.VERSION.SDK_INT < 17) {
        break label99;
      }
    }
    label99:
    for (this.eglContext = new EGL14Context();; this.eglContext = new EGL10Context())
    {
      this.eglContext.bind();
      GLES20.glGenTextures(this.mTextureId.length, this.mTextureId, 0);
      this.mSurfaceTexture = new SurfaceTexture(this.mTextureId[0]);
      this.isInited = true;
      return;
    }
  }
  
  public void uninit()
  {
    QLog.i("SurfaceTextureManager", 0, "SurfaceTextureManager uninit, isInited = " + this.isInited);
    if (this.isInited)
    {
      if (this.mSurfaceTexture != null)
      {
        this.mSurfaceTexture.release();
        this.mSurfaceTexture = null;
      }
      GLES20.glDeleteTextures(this.mTextureId.length, this.mTextureId, 0);
      this.eglContext.unbind();
    }
    this.isInited = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.camera.opengl.SurfaceTextureManager
 * JD-Core Version:    0.7.0.1
 */