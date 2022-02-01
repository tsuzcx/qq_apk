package com.tencent.liteav.trtc.impl;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.renderer.e;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class TRTCRoomInfo$RenderInfo
  implements SurfaceHolder.Callback
{
  public boolean muteAudio = false;
  public boolean muteVideo = false;
  public TXCRenderAndDec render = null;
  public long tinyID;
  public TXCloudVideoView view = null;
  
  public void stop()
  {
    try
    {
      if ((this.view != null) && (this.view.getSurfaceView() != null) && (this.view.getSurfaceView().getHolder() != null))
      {
        this.view.getSurfaceView().getHolder().removeCallback(this);
        return;
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("TRTCRoomInfo", "remove callback failed.", localException);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trtc_api startRemoteView surfaceChanged ");
    localStringBuilder.append(paramSurfaceHolder.getSurface());
    localStringBuilder.append(" width ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", height ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.tinyID);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.render);
    TXCLog.i("RenderInfo", localStringBuilder.toString());
    paramSurfaceHolder = this.render;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder = paramSurfaceHolder.getVideoRender();
    } else {
      paramSurfaceHolder = null;
    }
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.c(paramInt2, paramInt3);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("trtc_api startRemoteView surfaceCreated ");
    ((StringBuilder)localObject).append(paramSurfaceHolder.getSurface());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.tinyID);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.render);
    TXCLog.i("RenderInfo", ((StringBuilder)localObject).toString());
    if (paramSurfaceHolder.getSurface().isValid())
    {
      localObject = this.render;
      if (localObject != null) {
        localObject = ((TXCRenderAndDec)localObject).getVideoRender();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        ((e)localObject).a(paramSurfaceHolder.getSurface());
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trtc_api startRemoteView surfaceDestroyed ");
    localStringBuilder.append(paramSurfaceHolder.getSurface());
    localStringBuilder.append(", ");
    localStringBuilder.append(this.tinyID);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.render);
    TXCLog.i("RenderInfo", localStringBuilder.toString());
    paramSurfaceHolder = this.render;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder = paramSurfaceHolder.getVideoRender();
    } else {
      paramSurfaceHolder = null;
    }
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.a((Surface)null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo
 * JD-Core Version:    0.7.0.1
 */