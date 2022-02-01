package com.tencent.ilivesdk.avpreloadplayerservice;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.PlayerParams;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.PlayerStatusListener;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;

class AVPreloadPlayerService$3
  implements LiveSdkPlayerHelper.PlayerStatusListener
{
  AVPreloadPlayerService$3(AVPreloadPlayerService paramAVPreloadPlayerService, PlayerStatusListener paramPlayerStatusListener) {}
  
  public void onError(IMediaPlayerMgr paramIMediaPlayerMgr, int paramInt, String paramString)
  {
    paramIMediaPlayerMgr = AVPreloadPlayerService.z(this.b).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------play error errorCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg: ");
    localStringBuilder.append(paramString);
    paramIMediaPlayerMgr.e("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
    AVPreloadPlayerService.A(this.b);
    paramIMediaPlayerMgr = this.a;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onError(paramInt, paramString);
    }
    if (AVPreloadPlayerService.s(this.b) != null)
    {
      AVPreloadPlayerService.s(this.b).onError(paramInt, paramString);
      AVPreloadPlayerService.a(this.b, null);
    }
  }
  
  public void onFirstFrameCome(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.t(this.b).getLogger().i("AVPreload|AVPreloadService", "onFirstFrameCome", new Object[0]);
    AVPreloadPlayerService.u(this.b);
    if (AVPreloadPlayerService.v(this.b) != null) {
      AVPreloadPlayerService.x(this.b).g(AVPreloadPlayerService.w(this.b).getCurrentParams().originUrl);
    }
    paramIMediaPlayerMgr = this.a;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onFirstFrameCome();
    }
  }
  
  public void onNetworkAnomaly()
  {
    AVPreloadPlayerService.D(this.b).getLogger().i("AVPreloadPlayerService", "onNetworkAnomaly 网络异常", new Object[0]);
    PlayerStatusListener localPlayerStatusListener = this.a;
    if (localPlayerStatusListener != null) {
      localPlayerStatusListener.onNetworkAnomaly();
    }
  }
  
  public void onNetworkChanged(int paramInt)
  {
    PlayerStatusListener localPlayerStatusListener = this.a;
    if (localPlayerStatusListener != null) {
      localPlayerStatusListener.onNetworkChanged(paramInt);
    }
  }
  
  public void onPlayCompleted(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.y(this.b).getLogger().i("AVPreloadPlayerService", "onPlayCompleted", new Object[0]);
    paramIMediaPlayerMgr = this.a;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onPlayCompleted();
    }
  }
  
  public void onReadyCompleted(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.r(this.b).getLogger().i("AVPreloadPlayerService", "onReadyCompleted", new Object[0]);
    paramIMediaPlayerMgr = this.a;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onReadyCompleted();
    }
    if (AVPreloadPlayerService.s(this.b) != null)
    {
      AVPreloadPlayerService.s(this.b).onReadyCompleted();
      AVPreloadPlayerService.a(this.b, null);
    }
  }
  
  public void onReadyLayout(ITPPlayerVideoViewBase paramITPPlayerVideoViewBase, int paramInt1, int paramInt2)
  {
    paramITPPlayerVideoViewBase = AVPreloadPlayerService.q(this.b).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoWidth = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" videoHeight=");
    localStringBuilder.append(paramInt2);
    paramITPPlayerVideoViewBase.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
  }
  
  public long onReportRoomId()
  {
    if (AVPreloadPlayerService.E(this.b) != null) {
      return AVPreloadPlayerService.F(this.b).getRoomId();
    }
    return 0L;
  }
  
  public void onStartBuffer(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.B(this.b).getLogger().i("AVPreloadPlayerService", "onStartBuffer", new Object[0]);
    paramIMediaPlayerMgr = this.a;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onStartBuffer();
    }
  }
  
  public void onStopBuffer(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.C(this.b).getLogger().i("AVPreloadPlayerService", "onStopBuffer", new Object[0]);
    paramIMediaPlayerMgr = this.a;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onStopBuffer();
    }
  }
  
  public void onSurfaceCreated()
  {
    PlayerStatusListener localPlayerStatusListener = this.a;
    if (localPlayerStatusListener != null) {
      localPlayerStatusListener.onSurfaceCreated();
    }
  }
  
  public void onSurfaceDestroyed()
  {
    PlayerStatusListener localPlayerStatusListener = this.a;
    if (localPlayerStatusListener != null) {
      localPlayerStatusListener.onSurfaceDestroyed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService.3
 * JD-Core Version:    0.7.0.1
 */