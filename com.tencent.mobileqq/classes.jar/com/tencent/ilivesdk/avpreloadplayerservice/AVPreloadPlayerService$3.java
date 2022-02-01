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
    paramIMediaPlayerMgr = AVPreloadPlayerService.r(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------play error errorCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg: ");
    localStringBuilder.append(paramString);
    paramIMediaPlayerMgr.e("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
    AVPreloadPlayerService.b(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService);
    paramIMediaPlayerMgr = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onError(paramInt, paramString);
    }
    if (AVPreloadPlayerService.c(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService) != null)
    {
      AVPreloadPlayerService.c(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).onError(paramInt, paramString);
      AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService, null);
    }
  }
  
  public void onFirstFrameCome(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.p(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreload|AVPreloadService", "onFirstFrameCome", new Object[0]);
    AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService);
    if (AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService) != null) {
      AVPreloadPlayerService.b(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).e(AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getCurrentParams().originUrl);
    }
    paramIMediaPlayerMgr = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onFirstFrameCome();
    }
  }
  
  public void onNetworkAnomaly()
  {
    AVPreloadPlayerService.u(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onNetworkAnomaly 网络异常", new Object[0]);
    PlayerStatusListener localPlayerStatusListener = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (localPlayerStatusListener != null) {
      localPlayerStatusListener.onNetworkAnomaly();
    }
  }
  
  public void onNetworkChanged(int paramInt)
  {
    PlayerStatusListener localPlayerStatusListener = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (localPlayerStatusListener != null) {
      localPlayerStatusListener.onNetworkChanged(paramInt);
    }
  }
  
  public void onPlayCompleted(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.q(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onPlayCompleted", new Object[0]);
    paramIMediaPlayerMgr = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onPlayCompleted();
    }
  }
  
  public void onReadyCompleted(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.o(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onReadyCompleted", new Object[0]);
    paramIMediaPlayerMgr = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onReadyCompleted();
    }
    if (AVPreloadPlayerService.c(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService) != null)
    {
      AVPreloadPlayerService.c(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).onReadyCompleted();
      AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService, null);
    }
  }
  
  public void onReadyLayout(ITPPlayerVideoViewBase paramITPPlayerVideoViewBase, int paramInt1, int paramInt2)
  {
    paramITPPlayerVideoViewBase = AVPreloadPlayerService.n(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoWidth = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" videoHeight=");
    localStringBuilder.append(paramInt2);
    paramITPPlayerVideoViewBase.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
  }
  
  public long onReportRoomId()
  {
    if (AVPreloadPlayerService.v(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService) != null) {
      return AVPreloadPlayerService.w(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getRoomId();
    }
    return 0L;
  }
  
  public void onStartBuffer(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.s(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onStartBuffer", new Object[0]);
    paramIMediaPlayerMgr = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onStartBuffer();
    }
  }
  
  public void onStopBuffer(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.t(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onStopBuffer", new Object[0]);
    paramIMediaPlayerMgr = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (paramIMediaPlayerMgr != null) {
      paramIMediaPlayerMgr.onStopBuffer();
    }
  }
  
  public void onSurfaceCreated()
  {
    PlayerStatusListener localPlayerStatusListener = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (localPlayerStatusListener != null) {
      localPlayerStatusListener.onSurfaceCreated();
    }
  }
  
  public void onSurfaceDestroyed()
  {
    PlayerStatusListener localPlayerStatusListener = this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
    if (localPlayerStatusListener != null) {
      localPlayerStatusListener.onSurfaceDestroyed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService.3
 * JD-Core Version:    0.7.0.1
 */