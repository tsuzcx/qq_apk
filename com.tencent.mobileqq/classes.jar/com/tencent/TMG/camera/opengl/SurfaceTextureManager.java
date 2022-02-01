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
    int j = Build.VERSION.SDK_INT;
    int i = 1;
    if (j < 9) {
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
        if (paramContext.reqGlEsVersion >= 131072) {
          i = 2;
        }
        return i;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SurfaceTextureManager init, isSupported = ");
    ((StringBuilder)localObject).append(this.isSupported);
    QLog.i("SurfaceTextureManager", 0, ((StringBuilder)localObject).toString());
    if (this.isSupported)
    {
      if (Build.VERSION.SDK_INT >= 17) {
        this.eglContext = new EGL14Context();
      } else {
        this.eglContext = new EGL10Context();
      }
      this.eglContext.bind();
      localObject = this.mTextureId;
      GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
      this.mSurfaceTexture = new SurfaceTexture(this.mTextureId[0]);
      this.isInited = true;
    }
  }
  
  public void uninit()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SurfaceTextureManager uninit, isInited = ");
    ((StringBuilder)localObject).append(this.isInited);
    QLog.i("SurfaceTextureManager", 0, ((StringBuilder)localObject).toString());
    if (this.isInited)
    {
      localObject = this.mSurfaceTexture;
      if (localObject != null)
      {
        ((SurfaceTexture)localObject).release();
        this.mSurfaceTexture = null;
      }
      localObject = this.mTextureId;
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
      this.eglContext.unbind();
    }
    this.isInited = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.opengl.SurfaceTextureManager
 * JD-Core Version:    0.7.0.1
 */