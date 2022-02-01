package com.tencent.liteav.trtc.impl;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.liteav.basic.util.d;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;

class TRTCCloudImpl$14$2
  implements Runnable
{
  TRTCCloudImpl$14$2(TRTCCloudImpl.14 param14, SurfaceView paramSurfaceView, Surface[] paramArrayOfSurface, d paramd) {}
  
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
    if (this.this$1.val$view != null)
    {
      this.this$1.val$view.showVideoDebugLog(this.this$1.this$0.mDebugType);
      if (this.this$1.this$0.mRoomInfo.debugMargin != null) {
        this.this$1.val$view.setLogMarginRatio(this.this$1.this$0.mRoomInfo.debugMargin.leftMargin, this.this$1.this$0.mRoomInfo.debugMargin.rightMargin, this.this$1.this$0.mRoomInfo.debugMargin.topMargin, this.this$1.this$0.mRoomInfo.debugMargin.bottomMargin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.14.2
 * JD-Core Version:    0.7.0.1
 */