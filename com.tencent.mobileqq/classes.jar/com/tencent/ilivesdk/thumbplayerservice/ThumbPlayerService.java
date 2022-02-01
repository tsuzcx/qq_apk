package com.tencent.ilivesdk.thumbplayerservice;

import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;
import com.tencent.av.report.AVReportManager;
import com.tencent.av.report.AVReportManager.ReportType;
import com.tencent.av.report.impl.AVCatonReport;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.avmediaservice_interface.MediaPlayerInterface;
import com.tencent.ilivesdk.avplayerservice.AVPlayerService;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerParams;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.livesdk.livesdkplayer.AVCatonReportManager;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.PlayerParams;
import com.tencent.livesdk.livesdkplayer.LogAdapter;

public class ThumbPlayerService
  extends AVPlayerService
{
  private static final String TAG = "ThumbPlayerService";
  private LogAdapter logAdapter = new ThumbPlayerService.1(this);
  private LiveSdkPlayerHelper playerHelper;
  private PlayerStatusListener switchResolutionListener;
  
  private LiveSdkPlayerHelper.PlayerParams transferData(PlayerParams paramPlayerParams)
  {
    LiveSdkPlayerHelper.PlayerParams localPlayerParams = new LiveSdkPlayerHelper.PlayerParams();
    if (paramPlayerParams == null) {
      return localPlayerParams;
    }
    localPlayerParams.level = paramPlayerParams.level;
    localPlayerParams.originUrl = paramPlayerParams.url;
    localPlayerParams.url = paramPlayerParams.url;
    localPlayerParams.url_low = paramPlayerParams.url_low;
    localPlayerParams.url_high = paramPlayerParams.url_high;
    localPlayerParams.roomId = paramPlayerParams.roomId;
    localPlayerParams.roomType = paramPlayerParams.roomType;
    localPlayerParams.sig = paramPlayerParams.sig;
    localPlayerParams.anchorUin = paramPlayerParams.anchorUin;
    localPlayerParams.videoType = paramPlayerParams.videoType;
    if (this.adapter == null) {
      return localPlayerParams;
    }
    localPlayerParams.roomId = this.adapter.getRoomId();
    if ((this.adapter.getAccount() != null) && (this.adapter.getAccount().getLoginInfo() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.adapter.getAccount().getLoginInfo().uid);
      localPlayerParams.userId = localStringBuilder.toString();
    }
    localPlayerParams.videoType = paramPlayerParams.videoType;
    return localPlayerParams;
  }
  
  public void clearEventOutput() {}
  
  public long getCurrentPositionMs()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public Rect getDisplayViewRect()
  {
    return this.playerHelper.getDisplayViewRect();
  }
  
  public long getVideoDurationMs()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.getDurationMs();
    }
    return 0L;
  }
  
  public int getVideoHeight()
  {
    return this.playerHelper.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.playerHelper.getVideoWidth();
  }
  
  public void init(Context paramContext, FrameLayout paramFrameLayout)
  {
    super.init(paramContext, paramFrameLayout);
    this.playerHelper = new LiveSdkPlayerHelper();
    this.playerHelper.setIsHoldPlayerLog(this.adapter.isHoldPlayerLog());
    this.playerHelper.setLog(this.logAdapter);
    this.playerHelper.initTPPlayerId(this.adapter.getAppInfo().getTPPlayerGuid(), this.adapter.getAppInfo().getTPPlatform(), this.adapter.getAppInfo().isNeedInitTPPlatform());
    Object localObject1 = this.adapter.getMediaPlayerInterface();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = this.adapter.getMediaPlayerInterface().a();
    } else {
      localObject1 = null;
    }
    this.playerHelper.init(paramContext, (IMediaPlayerMgr)localObject1);
    this.playerHelper.readyPlay(paramFrameLayout, false);
    paramFrameLayout = new AVCatonReport4PlayerTransfer((AVCatonReport)AVReportManager.get(AVReportManager.ReportType.Caton_Report));
    paramContext = localObject2;
    if (this.adapter.getMediaPlayerInterface() != null) {
      paramContext = this.adapter.getMediaPlayerInterface().a();
    }
    localObject1 = AVCatonReportManager.a();
    if (paramContext != null) {
      paramFrameLayout = paramContext;
    }
    ((AVCatonReportManager)localObject1).a(paramFrameLayout);
  }
  
  public boolean isPaused()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.isPaused();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.isPlaying();
    }
    return false;
  }
  
  public void mutePlay(boolean paramBoolean)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.mutePlay(paramBoolean);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onScreenOrientationChange(boolean paramBoolean)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.onScreenOrientationChange(paramBoolean);
    }
  }
  
  public void pausePlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.pausePlay();
    }
  }
  
  public void preload() {}
  
  public void preparePlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.openPlay();
    }
  }
  
  public void readyPlay(FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.readyPlay(paramFrameLayout, paramBoolean);
    }
  }
  
  public void resetPlayer()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.reset();
    }
  }
  
  public void resumePlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.resumePlay();
    }
  }
  
  public void seekTo(int paramInt)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.seek(paramInt);
    }
  }
  
  public void setParams(PlayerParams paramPlayerParams)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null)
    {
      localLiveSdkPlayerHelper.setParams(transferData(paramPlayerParams));
      this.playerHelper.setOffsetY(paramPlayerParams.offsetY);
    }
  }
  
  public void setPlayerStatusListener(PlayerStatusListener paramPlayerStatusListener)
  {
    super.setPlayerStatusListener(paramPlayerStatusListener);
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.setPlayerStatusListener(new ThumbPlayerService.2(this, paramPlayerStatusListener));
    }
  }
  
  public void setPlayerSurface()
  {
    this.playerHelper.setPlayerSurface();
  }
  
  public void startPlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.startPlay();
    }
  }
  
  public void stopPlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.playerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.stopPlay();
    }
  }
  
  public void switchResolution(PlayerParams paramPlayerParams, PlayerStatusListener paramPlayerStatusListener)
  {
    stopPlay();
    resetPlayer();
    this.switchResolutionListener = paramPlayerStatusListener;
    setParams(paramPlayerParams);
    setPlayerSurface();
    preparePlay();
  }
  
  public void uninit()
  {
    super.uninit();
    this.playerHelper.setPlayerStatusListener(null);
    this.playerHelper.uninit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.thumbplayerservice.ThumbPlayerService
 * JD-Core Version:    0.7.0.1
 */