package com.tencent.liteav.trtc.impl;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.renderer.e;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import java.util.Locale;

class TRTCCloudImpl$184
  implements Runnable
{
  TRTCCloudImpl$184(TRTCCloudImpl paramTRTCCloudImpl, TXCloudVideoView paramTXCloudVideoView, TRTCRoomInfo.RenderInfo paramRenderInfo, e parame, String paramString, TRTCCloud.TRTCViewMargin paramTRTCViewMargin) {}
  
  public void run()
  {
    Object localObject1 = this.val$view.getSurfaceView();
    if (localObject1 != null)
    {
      ((SurfaceView)localObject1).setVisibility(0);
      localObject2 = ((SurfaceView)localObject1).getHolder();
      ((SurfaceHolder)localObject2).removeCallback(this.val$renderInfo);
      ((SurfaceHolder)localObject2).addCallback(this.val$renderInfo);
      if (((SurfaceHolder)localObject2).getSurface().isValid())
      {
        this.this$0.apiLog(String.format(Locale.ENGLISH, "startRemoteView with valid surface %s, width: %d, height: %d", new Object[] { ((SurfaceHolder)localObject2).getSurface(), Integer.valueOf(((SurfaceView)localObject1).getWidth()), Integer.valueOf(((SurfaceView)localObject1).getHeight()) }));
        this.val$videoRender.a(((SurfaceHolder)localObject2).getSurface());
        this.val$videoRender.d(((SurfaceView)localObject1).getWidth(), ((SurfaceView)localObject1).getHeight());
        return;
      }
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startRemoteView with surfaceView add callback ");
      ((StringBuilder)localObject2).append(this.val$renderInfo);
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      return;
    }
    localObject1 = new TextureView(this.val$view.getContext());
    this.val$view.addVideoView((TextureView)localObject1);
    this.val$view.setVisibility(0);
    this.val$view.setUserId(this.val$userId);
    this.val$view.showVideoDebugLog(this.this$0.mDebugType);
    Object localObject2 = this.val$debugMargin;
    if (localObject2 != null) {
      this.val$view.setLogMarginRatio(((TRTCCloud.TRTCViewMargin)localObject2).leftMargin, this.val$debugMargin.rightMargin, this.val$debugMargin.topMargin, this.val$debugMargin.bottomMargin);
    }
    this.val$videoRender.a((TextureView)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.184
 * JD-Core Version:    0.7.0.1
 */