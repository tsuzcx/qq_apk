package com.tencent.ilivesdk.avpreloadplayerservice;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.ilivesdk.avpreloadplayerservice.report.AVPreloadReport.ReportData;
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
    AVPreloadPlayerService.s(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().e("AVPreload|Core", "------play error errorCode: " + paramInt + " msg: " + paramString, new Object[0]);
    String str2 = AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getCurrentParams().url;
    if (str2.startsWith("http://127.0.0.1"))
    {
      AVPreloadPlayerService.t(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().e("AVPreload|Core", "------local url play error url=" + str2, new Object[0]);
      String str1 = AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getCurrentParams().originUrl;
      paramIMediaPlayerMgr = str1;
      if (str1.startsWith("http://127.0.0.1"))
      {
        paramIMediaPlayerMgr = AVPreloadPlayerService.b(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).b(str1);
        AVPreloadPlayerService.v(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().e("AVPreload|Core", "------play error exchangeRemoteServerPlayUrl url=" + str2, new Object[0]);
      }
      AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getCurrentParams().url = paramIMediaPlayerMgr;
      ThreadCenter.removeUITask(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService, AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService));
      if (AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService) >= 3) {
        break label308;
      }
      ThreadCenter.postDelayedUITask(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService, AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService), 1000L);
    }
    label308:
    do
    {
      return;
      AVPreloadPlayerService.u(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().e("AVPreload|Core", "------remote url play error url=" + str2, new Object[0]);
      break;
      AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService, 0);
      if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onError(paramInt, paramString);
      }
    } while (AVPreloadPlayerService.c(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService) == null);
    AVPreloadPlayerService.c(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).onError(paramInt, paramString);
    AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService, null);
  }
  
  public void onFirstFrameCome(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.p(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreload|AVPreloadService", "onFirstFrameCome", new Object[0]);
    String str1 = AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getCurrentParams().url;
    AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).a = str1.startsWith("http://127.0.0.1");
    AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).f = (System.currentTimeMillis() - AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService));
    AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).j = AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getCurrentParams().originUrl;
    AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).e = AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getCurrentParams().userId;
    if (AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).a)
    {
      paramIMediaPlayerMgr = "命中缓存";
      if (!str1.startsWith("rtmp:")) {
        break label272;
      }
    }
    label272:
    for (str1 = "rtmp";; str1 = "flv")
    {
      String str2 = ":首帧耗时 " + AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).f;
      AVPreloadPlayerService.q(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", paramIMediaPlayerMgr + str1 + str2, new Object[0]);
      AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).e(AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getCurrentParams().originUrl);
      if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onFirstFrameCome();
      }
      return;
      paramIMediaPlayerMgr = "未命中缓存";
      break;
    }
  }
  
  public void onNetworkAnomaly()
  {
    AVPreloadPlayerService.y(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onNetworkAnomaly 网络异常", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onNetworkAnomaly();
    }
  }
  
  public void onNetworkChanged(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onNetworkChanged(paramInt);
    }
  }
  
  public void onPlayCompleted(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.r(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onPlayCompleted", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onPlayCompleted();
    }
  }
  
  public void onReadyCompleted(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.o(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onReadyCompleted", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onReadyCompleted();
    }
    if (AVPreloadPlayerService.c(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService) != null)
    {
      AVPreloadPlayerService.c(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).onReadyCompleted();
      AVPreloadPlayerService.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService, null);
    }
  }
  
  public void onReadyLayout(ITPPlayerVideoViewBase paramITPPlayerVideoViewBase, int paramInt1, int paramInt2)
  {
    AVPreloadPlayerService.n(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "videoWidth = " + paramInt1 + " videoHeight=" + paramInt2, new Object[0]);
  }
  
  public long onReportRoomId()
  {
    if (AVPreloadPlayerService.z(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService) != null) {
      return AVPreloadPlayerService.A(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getRoomId();
    }
    return 0L;
  }
  
  public void onStartBuffer(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.w(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onStartBuffer", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onStartBuffer();
    }
  }
  
  public void onStopBuffer(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    AVPreloadPlayerService.x(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceAVPreloadPlayerService).getLogger().i("AVPreloadPlayerService", "onStopBuffer", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onStopBuffer();
    }
  }
  
  public void onSurfaceCreated()
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onSurfaceCreated();
    }
  }
  
  public void onSurfaceDestroyed()
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener.onSurfaceDestroyed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService.3
 * JD-Core Version:    0.7.0.1
 */