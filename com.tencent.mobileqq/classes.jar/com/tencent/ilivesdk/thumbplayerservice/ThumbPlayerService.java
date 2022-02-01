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
import com.tencent.ilivesdk.avplayerservice.AVPlayerService;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerParams;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.livesdk.livesdkplayer.AVCatonReportManager;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.PlayerParams;

public class ThumbPlayerService
  extends AVPlayerService
{
  private static final String TAG = "ThumbPlayerService";
  private LiveSdkPlayerHelper playerHelper;
  private PlayerStatusListener switchResolutionListener;
  
  private LiveSdkPlayerHelper.PlayerParams transferData(PlayerParams paramPlayerParams)
  {
    LiveSdkPlayerHelper.PlayerParams localPlayerParams = new LiveSdkPlayerHelper.PlayerParams();
    if (paramPlayerParams == null) {}
    do
    {
      return localPlayerParams;
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
    } while (this.adapter == null);
    localPlayerParams.roomId = this.adapter.getRoomId();
    if ((this.adapter.getAccount() != null) && (this.adapter.getAccount().getLoginInfo() != null)) {
      localPlayerParams.userId = ("" + this.adapter.getAccount().getLoginInfo().uid);
    }
    localPlayerParams.videoType = paramPlayerParams.videoType;
    return localPlayerParams;
  }
  
  public void clearEventOutput() {}
  
  public long getCurrentPositionMs()
  {
    if (this.playerHelper != null) {
      return this.playerHelper.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public Rect getDisplayViewRect()
  {
    return this.playerHelper.getDisplayViewRect();
  }
  
  public long getVideoDurationMs()
  {
    if (this.playerHelper != null) {
      return this.playerHelper.getDurationMs();
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
    this.playerHelper.setLog(new ThumbPlayerService.1(this));
    this.playerHelper.initTPPlayerId(this.adapter.getAppInfo().getTPPlayerGuid(), this.adapter.getAppInfo().getTPPlatform(), this.adapter.getAppInfo().isNeedInitTPPlatform());
    this.playerHelper.init(paramContext);
    this.playerHelper.readyPlay(paramFrameLayout, false);
    AVCatonReportManager.a().a(new AVCatonReport4PlayerTransfer((AVCatonReport)AVReportManager.get(AVReportManager.ReportType.Caton_Report)));
  }
  
  public boolean isPaused()
  {
    if (this.playerHelper != null) {
      return this.playerHelper.isPaused();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    if (this.playerHelper != null) {
      return this.playerHelper.isPlaying();
    }
    return false;
  }
  
  public void mutePlay(boolean paramBoolean)
  {
    if (this.playerHelper != null) {
      this.playerHelper.mutePlay(paramBoolean);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onScreenOrientationChange(boolean paramBoolean)
  {
    if (this.playerHelper != null) {
      this.playerHelper.onScreenOrientationChange(paramBoolean);
    }
  }
  
  public void pausePlay()
  {
    if (this.playerHelper != null) {
      this.playerHelper.pausePlay();
    }
  }
  
  public void preload() {}
  
  public void preparePlay()
  {
    if (this.playerHelper != null) {
      this.playerHelper.openPlay();
    }
  }
  
  public void readyPlay(FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    if (this.playerHelper != null) {
      this.playerHelper.readyPlay(paramFrameLayout, paramBoolean);
    }
  }
  
  public void resetPlayer()
  {
    if (this.playerHelper != null) {
      this.playerHelper.reset();
    }
  }
  
  public void resumePlay()
  {
    if (this.playerHelper != null) {
      this.playerHelper.resumePlay();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.playerHelper != null) {
      this.playerHelper.seek(paramInt);
    }
  }
  
  public void setParams(PlayerParams paramPlayerParams)
  {
    if (this.playerHelper != null)
    {
      this.playerHelper.setParams(transferData(paramPlayerParams));
      this.playerHelper.setOffsetY(paramPlayerParams.offsetY);
    }
  }
  
  public void setPlayerStatusListener(PlayerStatusListener paramPlayerStatusListener)
  {
    super.setPlayerStatusListener(paramPlayerStatusListener);
    if (this.playerHelper != null) {
      this.playerHelper.setPlayerStatusListener(new ThumbPlayerService.2(this, paramPlayerStatusListener));
    }
  }
  
  public void setPlayerSurface()
  {
    this.playerHelper.setPlayerSurface();
  }
  
  public void startPlay()
  {
    if (this.playerHelper != null) {
      this.playerHelper.startPlay();
    }
  }
  
  public void stopPlay()
  {
    if (this.playerHelper != null) {
      this.playerHelper.stopPlay();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.thumbplayerservice.ThumbPlayerService
 * JD-Core Version:    0.7.0.1
 */