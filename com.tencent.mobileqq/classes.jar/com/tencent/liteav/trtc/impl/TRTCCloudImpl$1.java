package com.tencent.liteav.trtc.impl;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.d;

class TRTCCloudImpl$1
  implements TextureView.SurfaceTextureListener
{
  TRTCCloudImpl$1(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startLocalPreview surfaceCreated ");
    localStringBuilder.append(paramSurfaceTexture);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    TRTCCloudImpl.access$002(this.this$0, new Surface(paramSurfaceTexture));
    this.this$0.mCaptureAndEnc.a(TRTCCloudImpl.access$000(this.this$0));
    this.this$0.mCaptureAndEnc.a(paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.this$0.apiLog("startLocalPreview surfaceDestroyed %s", new Object[] { paramSurfaceTexture });
    this.this$0.mCaptureAndEnc.a(null);
    if (TRTCCloudImpl.access$000(this.this$0) != null)
    {
      TRTCCloudImpl.access$000(this.this$0).release();
      TRTCCloudImpl.access$002(this.this$0, null);
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.this$0.apiLog("startLocalPreview surfaceChanged %s width: %d, height: %d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.this$0.mCaptureAndEnc.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.1
 * JD-Core Version:    0.7.0.1
 */