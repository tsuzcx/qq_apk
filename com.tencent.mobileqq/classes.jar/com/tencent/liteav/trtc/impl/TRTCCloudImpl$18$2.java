package com.tencent.liteav.trtc.impl;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.basic.util.e;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;

class TRTCCloudImpl$18$2
  implements Runnable
{
  TRTCCloudImpl$18$2(TRTCCloudImpl.18 param18, SurfaceView paramSurfaceView, Surface[] paramArrayOfSurface, e parame, TextureView paramTextureView) {}
  
  public void run()
  {
    Object localObject = this.val$surfaceView;
    if (localObject != null)
    {
      localObject = ((SurfaceView)localObject).getHolder();
      ((SurfaceHolder)localObject).removeCallback(this.this$1.this$0);
      ((SurfaceHolder)localObject).addCallback(this.this$1.this$0);
      if (((SurfaceHolder)localObject).getSurface().isValid())
      {
        TRTCCloudImpl localTRTCCloudImpl = this.this$1.this$0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startLocalPreview with valid surface ");
        localStringBuilder.append(((SurfaceHolder)localObject).getSurface());
        localStringBuilder.append(" width ");
        localStringBuilder.append(this.val$surfaceView.getWidth());
        localStringBuilder.append(", height ");
        localStringBuilder.append(this.val$surfaceView.getHeight());
        localTRTCCloudImpl.apiLog(localStringBuilder.toString());
        this.val$surface[0] = ((SurfaceHolder)localObject).getSurface();
        this.val$surfaceSize.a = this.val$surfaceView.getWidth();
        this.val$surfaceSize.b = this.val$surfaceView.getHeight();
      }
      else
      {
        this.this$1.this$0.apiLog("startLocalPreview with surfaceView add callback");
      }
    }
    localObject = this.val$textureView;
    if (localObject != null)
    {
      localObject = ((TextureView)localObject).getSurfaceTexture();
      this.val$textureView.setSurfaceTextureListener(TRTCCloudImpl.access$2300(this.this$1.this$0));
      if (localObject != null)
      {
        TRTCCloudImpl.access$002(this.this$1.this$0, new Surface((SurfaceTexture)localObject));
        this.val$surface[0] = TRTCCloudImpl.access$000(this.this$1.this$0);
        this.val$surfaceSize.a = this.val$textureView.getWidth();
        this.val$surfaceSize.b = this.val$textureView.getHeight();
        this.this$1.this$0.apiLog("startLocalPreview with TextureView, SurfaceTexture: %s, width: %d, height: %d", new Object[] { localObject, Integer.valueOf(this.val$surfaceSize.a), Integer.valueOf(this.val$surfaceSize.b) });
      }
      else
      {
        this.this$1.this$0.apiLog("startLocalPreview with textureView add callback");
      }
    }
    if (this.this$1.val$view != null)
    {
      this.this$1.val$view.showVideoDebugLog(this.this$1.this$0.mDebugType);
      if (this.this$1.this$0.mRoomInfo.debugMargin != null) {
        this.this$1.val$view.setLogMarginRatio(this.this$1.this$0.mRoomInfo.debugMargin.leftMargin, this.this$1.this$0.mRoomInfo.debugMargin.rightMargin, this.this$1.this$0.mRoomInfo.debugMargin.topMargin, this.this$1.this$0.mRoomInfo.debugMargin.bottomMargin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.18.2
 * JD-Core Version:    0.7.0.1
 */