package com.tencent.ark;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.view.Surface;

public class ArkPlayerSurfaceHolder
  implements SurfaceTexture.OnFrameAvailableListener
{
  protected static final ArkEnvironmentManager ENV = ;
  public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
  public static final String TAG = "ArkApp.ArkPlayerSurfaceHolder";
  public long mFrameCallback = 0L;
  public int mFrameHeight = 0;
  public long mFrameUserdata = 0L;
  public int mFrameWidth = 0;
  protected EGLContextHolder mOffscreenContext;
  protected String mQueueKey;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  public int mTextureID = 0;
  
  public void DoDispathTask(Runnable paramRunnable)
  {
    if (this.mQueueKey == ArkDispatchQueue.getCurrentQueueKey())
    {
      paramRunnable.run();
      return;
    }
    ArkDispatchQueue.asyncRun(this.mQueueKey, paramRunnable);
  }
  
  public void SetFrameCallback(long paramLong1, long paramLong2)
  {
    this.mFrameCallback = paramLong1;
    this.mFrameUserdata = paramLong2;
  }
  
  public void SetFrameSize(int paramInt1, int paramInt2)
  {
    this.mFrameWidth = paramInt1;
    this.mFrameHeight = paramInt2;
  }
  
  public void deinitialize()
  {
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.release();
      this.mSurfaceTexture = null;
    }
    if ((this.mOffscreenContext != null) && (this.mTextureID != 0))
    {
      this.mOffscreenContext.makeCurrent();
      GLES20.glDeleteTextures(1, new int[] { this.mTextureID }, 0);
    }
    this.mTextureID = 0;
  }
  
  public Surface getSurface()
  {
    if (this.mSurface != null) {
      return this.mSurface;
    }
    if (this.mSurfaceTexture == null) {
      return null;
    }
    this.mSurface = new Surface(this.mSurfaceTexture);
    return this.mSurface;
  }
  
  public boolean initialize()
  {
    if (this.mSurfaceTexture != null) {
      return true;
    }
    this.mQueueKey = ArkDispatchQueue.getCurrentQueueKey();
    if (this.mOffscreenContext == null) {
      this.mOffscreenContext = ArkViewModel.getOffscreenContext();
    }
    if ((this.mOffscreenContext == null) || (!this.mOffscreenContext.makeCurrent()))
    {
      ENV.logE("ArkApp.ArkPlayerSurfaceHolder", "initialize.makeCurrent.fail!!");
      return false;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ENV.logE("ArkApp.ArkPlayerSurfaceHolder", "initialize.glGenTextures.fail!!");
      return false;
    }
    this.mTextureID = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.mTextureID);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    this.mSurfaceTexture = new SurfaceTexture(this.mTextureID);
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    return true;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.mSurfaceTexture == null) || (this.mOffscreenContext == null) || (this.mFrameCallback == 0L)) {
      return;
    }
    DoDispathTask(new ArkPlayerSurfaceHolder.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkPlayerSurfaceHolder
 * JD-Core Version:    0.7.0.1
 */