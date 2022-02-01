package com.tencent.ilive.audiencepages.room.bizmodule;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent.PlayerState;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.commonpages.room.VerticalViewPager;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.events.FirstFrameEvent;
import com.tencent.ilive.pages.room.events.LiveStateEvent;
import com.tencent.ilive.pages.room.events.LiveStateEvent.LiveState;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerParams;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveVideoStatus;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.ilivesdk.roomservice_interface.model.streaminfo.ServiceAddressInfo;
import com.tencent.ilivesdk.roomservice_interface.model.streaminfo.ServiceFrameInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.accountengine.UserInitStateCallback;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.util.ArrayList;

public class AVPlayerModule
  extends RoomBizModule
{
  private static final int MAX_PAUSE_TIME_LIMIT = 8000;
  private static final int STOP_PLAYER_MESSAGE = 100;
  private String TAG = "AVPlayerModule";
  private AppGeneralInfoService appGeneralInfoService;
  private AudQualityServiceInterface audQualityService;
  private AVPlayerBuilderServiceInterface avPlayerService;
  private boolean canPostFirstFrameEvent = true;
  private boolean isExitRoomPause = false;
  private boolean isFloatWindowShow = false;
  private boolean isOutEnterRoom;
  private boolean isOutSwitchVideoOrigin = false;
  private boolean isOuterVideoOrigin = false;
  private boolean isPageExit = false;
  private boolean isPauseOnEnterRoom = false;
  private boolean isPlayedVideo;
  private boolean isPreloadNoStart = false;
  private boolean isSurfaceCreated = false;
  @SuppressLint({"HandlerLeak"})
  Handler mHandler = new AVPlayerModule.2(this);
  private boolean mHasFirstFrame;
  private boolean mIsStopByonPause;
  private ToastInterface mToastInterface;
  private int outSwitchVideoLevel = -1;
  private int outerVideoLevel = -1;
  boolean readyPlay = false;
  private RoomEngine roomEngine;
  boolean surfacePlay = false;
  private UserEngine userEngine;
  UserInitStateCallback userInitStateCallback = new AVPlayerModule.1(this);
  private ImageView videoBgView;
  private FrameLayout videoView;
  
  private void destroyRoomEngine()
  {
    if (this.roomEngine != null)
    {
      this.roomEngine.unint();
      this.roomEngine = null;
    }
  }
  
  private void initLoginListen()
  {
    if (this.userEngine.avInitSuccess())
    {
      this.avPlayerService.onLoginEvent(3, "");
      return;
    }
    this.userEngine.addUserInitCallback(this.userInitStateCallback);
    if (this.userEngine.loginSuccess())
    {
      this.avPlayerService.onLoginEvent(1, "");
      return;
    }
    getLog().i(this.TAG, "initRoomPlayer -- 等待登录 ", new Object[0]);
  }
  
  private void initPlayerStatus()
  {
    this.avPlayerService.setPlayerStatusListener(new AVPlayerModule.DefaultPlayerStatusListener(this));
  }
  
  private void initPreloadPlayerStatus()
  {
    this.avPlayerService.setPlayerStatusListener(new AVPlayerModule.PreloadPlayerStatusListener(this));
  }
  
  private void initRoomCover()
  {
    this.videoBgView = ((ImageView)getRootView().findViewById(2131368723));
    Object localObject = this.roomBizContext.getEnterRoomInfo().coverBitmapBytes;
    if (localObject != null)
    {
      getLog().i(this.TAG, "bitmap_cover != null", new Object[0]);
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      this.videoBgView.setImageBitmap((Bitmap)localObject);
    }
    for (;;)
    {
      this.videoBgView.setVisibility(0);
      return;
      this.videoBgView.setImageResource(2130840609);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void initRoomPlayer()
  {
    getLog().i("AudienceTime", "Player -- initRoomPlayer", new Object[0]);
    this.canPostFirstFrameEvent = true;
    this.videoView = ((FrameLayout)getRootView().findViewById(2131368725));
    this.videoView.setOnTouchListener(new AVPlayerModule.4(this));
    this.avPlayerService = ((AVPlayerBuilderServiceInterface)this.roomEngine.getService(AVPlayerBuilderServiceInterface.class));
    this.avPlayerService.init(this.context.getApplicationContext(), this.videoView);
    initLoginListen();
    int i = ((Activity)this.context).getIntent().getIntExtra("video_level", -1);
    boolean bool2 = ((Activity)this.context).getIntent().getBooleanExtra("video_is_origin", false);
    LiveWatchMediaInfo localLiveWatchMediaInfo;
    if (!TextUtils.isEmpty(this.roomBizContext.getEnterRoomInfo().preVideoUrl))
    {
      getLog().i(this.TAG, "initRoomPlayer --not first start play--preVideoUrl=" + this.roomBizContext.getEnterRoomInfo().preVideoUrl, new Object[0]);
      localLiveWatchMediaInfo = new LiveWatchMediaInfo();
      localLiveWatchMediaInfo.first_play_url = this.roomBizContext.getEnterRoomInfo().preVideoUrl;
      localLiveWatchMediaInfo.mLevel = i;
      localLiveWatchMediaInfo.isOriginStream = bool2;
      if (this.isUserVisibleHint) {
        break label262;
      }
    }
    label262:
    for (boolean bool1 = true;; bool1 = false)
    {
      localLiveWatchMediaInfo.isPreload = bool1;
      this.outerVideoLevel = i;
      this.isOuterVideoOrigin = bool2;
      playVideo(localLiveWatchMediaInfo);
      return;
    }
  }
  
  private boolean isFloatWindowCanShow()
  {
    FloatWindowConfigServiceInterface localFloatWindowConfigServiceInterface = (FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class);
    FloatWindowPermissionInterface localFloatWindowPermissionInterface = (FloatWindowPermissionInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowPermissionInterface.class);
    return ((localFloatWindowConfigServiceInterface.getFloatWindowEnabledAllTime()) || (localFloatWindowConfigServiceInterface.getFloatWindowEnabledOnce())) && (localFloatWindowPermissionInterface.hasFWPermission());
  }
  
  private void onExitPause()
  {
    this.isExitRoomPause = true;
    this.mHandler.removeCallbacksAndMessages(null);
    this.avPlayerService.setPlayerStatusListener(null);
    this.isPlayedVideo = false;
  }
  
  private void onFirstFrameRsp()
  {
    if (this.isPageExit) {
      getLog().e(this.TAG, "Player -- onFirstFrameCome but isPageExit", new Object[0]);
    }
    do
    {
      return;
      if (getEvent() != null) {
        getEvent().post(new LiveStateEvent(LiveStateEvent.LiveState.STOP_BUFFER));
      }
      getLog().i("AudienceTime", "Player -- onFirstFrameCome--canPostFirstFrameEvent=" + this.canPostFirstFrameEvent, new Object[0]);
    } while (!this.canPostFirstFrameEvent);
    this.mHasFirstFrame = true;
    reportFirstFrameReady();
    reportQualityFirstFrame();
    if (this.videoBgView != null) {
      this.videoBgView.setVisibility(8);
    }
    if (getEvent() != null)
    {
      getEvent().post(new FirstFrameEvent());
      getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.FIRST_FRAME_READY));
    }
    this.canPostFirstFrameEvent = false;
  }
  
  private void onSwitchPreloadedStartPlay()
  {
    initPlayerStatus();
    getLog().i(this.TAG, "onSwitchPreloadedStartPlay -- startPlay", new Object[0]);
    this.avPlayerService.startPlay();
    reportSwitchStartPlay();
  }
  
  private void onSwitchResumePlay()
  {
    if (this.videoBgView != null) {
      this.videoBgView.setVisibility(8);
    }
    initPlayerStatus();
    if (this.avPlayerService.isPlaying())
    {
      getLog().i(this.TAG, "onSwitchResumePlay -- resumePlay", new Object[0]);
      this.avPlayerService.resumePlay();
    }
    for (;;)
    {
      this.isExitRoomPause = false;
      this.isPlayedVideo = true;
      reportSwitchStartPlay();
      return;
      getLog().i(this.TAG, "onSwitchResumePlay -- startPlay", new Object[0]);
      this.avPlayerService.startPlay();
    }
  }
  
  private void playVideo(LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    getLog().i("AudienceTime", "Player -- start playvideo", new Object[0]);
    PlayerParams localPlayerParams = new PlayerParams();
    if (!this.isPlayedVideo) {
      reportQualityStartPlay();
    }
    this.isPlayedVideo = true;
    if (!TextUtils.isEmpty(paramLiveWatchMediaInfo.first_play_url))
    {
      localPlayerParams.url = paramLiveWatchMediaInfo.first_play_url;
      localPlayerParams.url_high = paramLiveWatchMediaInfo.first_play_url;
      localPlayerParams.url_low = paramLiveWatchMediaInfo.first_play_url;
    }
    for (;;)
    {
      if (this.roomBizContext.getEnterRoomInfo() != null) {
        localPlayerParams.videoType = this.roomBizContext.getEnterRoomInfo().videoType;
      }
      ServiceFrameInfo localServiceFrameInfo = new ServiceFrameInfo();
      localServiceFrameInfo.level = paramLiveWatchMediaInfo.mLevel;
      ServiceAddressInfo localServiceAddressInfo = new ServiceAddressInfo();
      localServiceAddressInfo.url = localPlayerParams.url;
      localServiceFrameInfo.addresses.add(localServiceAddressInfo);
      localPlayerParams.sig = paramLiveWatchMediaInfo.sig;
      if ((this.roomEngine != null) && (this.roomEngine.getEnginLogic() != null) && (this.roomEngine.getEnginLogic().getLiveInfo() != null))
      {
        localPlayerParams.anchorUin = this.roomEngine.getEnginLogic().getLiveInfo().anchorInfo.uid;
        localPlayerParams.roomId = this.roomEngine.getEnginLogic().getLiveInfo().roomInfo.roomId;
        localPlayerParams.roomType = this.roomEngine.getEnginLogic().getLiveInfo().roomInfo.roomType;
        this.roomEngine.getEnginLogic().getLiveInfo().watchMediaInfo.curServiceFrameInfo = localServiceFrameInfo;
      }
      if (!TextUtils.isEmpty(localPlayerParams.url)) {
        break;
      }
      getLog().i(this.TAG, "播放地址 url is null...", new Object[0]);
      return;
      if (paramLiveWatchMediaInfo.forceSwitch)
      {
        localPlayerParams.url = paramLiveWatchMediaInfo.mUrl;
        localPlayerParams.url_high = paramLiveWatchMediaInfo.mUrlHigh;
        localPlayerParams.url_low = paramLiveWatchMediaInfo.mUrlLow;
        this.avPlayerService.stopPlay();
        this.avPlayerService.resetPlayer();
        this.mHandler.removeCallbacksAndMessages(null);
        this.avPlayerService.setPlayerStatusListener(null);
      }
      else
      {
        localPlayerParams.url = paramLiveWatchMediaInfo.mUrl;
        localPlayerParams.url_high = paramLiveWatchMediaInfo.mUrlHigh;
        localPlayerParams.url_low = paramLiveWatchMediaInfo.mUrlLow;
      }
    }
    this.avPlayerService.setParams(localPlayerParams);
    if (paramLiveWatchMediaInfo.isPreload) {
      initPreloadPlayerStatus();
    }
    for (;;)
    {
      this.avPlayerService.setPlayerSurface();
      this.avPlayerService.preparePlay();
      return;
      initPlayerStatus();
    }
  }
  
  private void realStartPlay(AVPlayerModule.StartPlayType paramStartPlayType)
  {
    if (paramStartPlayType == AVPlayerModule.StartPlayType.SURFACE_CREATE) {
      this.surfacePlay = true;
    }
    for (;;)
    {
      getLog().i(this.TAG, "realStartPlay--surfacePlay=" + this.surfacePlay + ";readyPlay=" + this.readyPlay, new Object[0]);
      if ((this.surfacePlay) && (this.readyPlay)) {
        this.avPlayerService.startPlay();
      }
      return;
      if (paramStartPlayType == AVPlayerModule.StartPlayType.READY_PLAY) {
        this.readyPlay = true;
      }
    }
  }
  
  private void reportFirstFrameReady()
  {
    ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("broadcast").setModuleDesc("音视频播放").setActType("success").setActTypeDesc("成功").setRealTimeUpload(true).send();
  }
  
  private void reportQualityFirstFrame()
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.isOutEnterRoom)
    {
      this.audQualityService.reportFirstFrame();
      return;
    }
    this.audQualityService.reportSwitchFirstFrame();
  }
  
  private void reportQualityPlayError(int paramInt)
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.isOutEnterRoom)
    {
      this.audQualityService.reportPlayFail(paramInt);
      return;
    }
    this.audQualityService.reportSwitchPlayFail(paramInt);
  }
  
  private void reportQualityStartPlay()
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.isOutEnterRoom)
    {
      this.audQualityService.reportStartPlay();
      return;
    }
    reportSwitchStartPlay();
  }
  
  private void reportSwitchStartPlay()
  {
    this.audQualityService.reportSwitchStartPlay();
    if (this.mHasFirstFrame)
    {
      if (this.isOutEnterRoom) {
        this.audQualityService.reportFirstFrame();
      }
    }
    else {
      return;
    }
    this.audQualityService.reportSwitchFirstFrame();
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    Object localObject = null;
    super.onActivityStart(paramLifecycleOwner);
    getLog().i(this.TAG, "Player -- onActivityStart", new Object[0]);
    if (this.avPlayerService == null) {}
    while (!this.isUserVisibleHint) {
      return;
    }
    this.mHandler.removeCallbacksAndMessages(null);
    if ((this.appGeneralInfoService.isLiteSdk()) && (this.avPlayerService.isPlaying()))
    {
      getLog().i(this.TAG, "Player -- litesdk -- onStart", new Object[0]);
      return;
    }
    if (this.mIsStopByonPause) {
      if ((this.roomEngine != null) && (this.roomEngine.getEnginLogic() != null) && (this.roomEngine.getEnginLogic().getLiveInfo() != null))
      {
        paramLifecycleOwner = this.roomEngine.getEnginLogic().getLiveInfo().watchMediaInfo;
        if (paramLifecycleOwner != null) {
          playVideo(paramLifecycleOwner);
        }
      }
    }
    for (;;)
    {
      this.mIsStopByonPause = false;
      return;
      paramLifecycleOwner = localObject;
      if (this.roomBizContext == null) {
        break;
      }
      paramLifecycleOwner = localObject;
      if (this.roomBizContext.getEnterRoomInfo() == null) {
        break;
      }
      paramLifecycleOwner = new LiveWatchMediaInfo();
      paramLifecycleOwner.first_play_url = this.roomBizContext.getEnterRoomInfo().preVideoUrl;
      break;
      if (this.avPlayerService.isPaused()) {
        this.avPlayerService.resumePlay();
      }
    }
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
    getLog().i(this.TAG, "Player -- onActivityStop", new Object[0]);
    if (!this.isUserVisibleHint) {}
    for (;;)
    {
      return;
      this.mIsStopByonPause = false;
      if (this.appGeneralInfoService.isLiteSdk())
      {
        getLog().i(this.TAG, "Player -- litesdk -- onstop not pause", new Object[0]);
        return;
      }
      if (((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface() != null) {}
      for (boolean bool = ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isBackgroundPlay(); (this.avPlayerService.isPlaying()) && (!bool) && (!isFloatWindowCanShow()); bool = false)
      {
        this.avPlayerService.pausePlay();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.sendEmptyMessageDelayed(100, 8000L);
        return;
      }
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.userEngine = BizEngineMgr.getInstance().getUserEngine();
    this.roomEngine = getRoomEngine();
    this.mToastInterface = ((ToastInterface)this.roomEngine.getService(ToastInterface.class));
    this.isOutEnterRoom = true;
    this.appGeneralInfoService = ((AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class));
    this.audQualityService = ((QualityReportServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(QualityReportServiceInterface.class)).getAudQualityReporter();
    int i = this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    this.TAG = (this.TAG + "||" + hashCode() + "||" + i);
    int j = getAudienceRoomPager().getViewPager().getCurrentItem();
    getLog().i(this.TAG, "onCreate--selfRoomIndex=" + i + ";pagerCurrentIndex=" + j, new Object[0]);
    initRoomCover();
    initRoomPlayer();
    getEvent().observe(FloatWindowStateEvent.class, new AVPlayerModule.3(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getLog().i(this.TAG, "Player -- onDestroy", new Object[0]);
    if ((this.avPlayerService != null) && (!this.isPageExit))
    {
      this.avPlayerService.setPlayerStatusListener(null);
      getLog().i(this.TAG, "Player -- onDestroy--isPlaying:" + this.avPlayerService.isPlaying(), new Object[0]);
      this.avPlayerService.uninit();
      this.isPageExit = true;
    }
    if (this.userEngine != null) {
      this.userEngine.removeUserInitCallback(this.userInitStateCallback);
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    this.mIsStopByonPause = false;
    this.canPostFirstFrameEvent = true;
    this.isPreloadNoStart = false;
    this.surfacePlay = false;
    this.readyPlay = false;
    destroyRoomEngine();
    getEvent().clearObservers();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.isOutEnterRoom = paramBoolean;
    this.roomEngine = getRoomEngine();
    if ((this.roomEngine != null) && (this.roomEngine.getService(RoomServiceInterface.class) != null) && (((RoomServiceInterface)this.roomEngine.getService(RoomServiceInterface.class)).getLiveInfo() != null) && (((RoomServiceInterface)this.roomEngine.getService(RoomServiceInterface.class)).getLiveInfo().watchMediaInfo != null)) {
      if (((RoomServiceInterface)this.roomEngine.getService(RoomServiceInterface.class)).getLiveInfo().watchMediaInfo.mVideoStatus != LiveVideoStatus.Pause) {
        break label241;
      }
    }
    LiveWatchMediaInfo localLiveWatchMediaInfo;
    label241:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.isPauseOnEnterRoom = paramBoolean;
      localLiveWatchMediaInfo = this.roomEngine.getEnginLogic().getLiveInfo().watchMediaInfo;
      getLog().i(this.TAG, "initRoomPlayer -- onEnterRoom--isPlayedVideo=" + this.isPlayedVideo + ";forceSwitch=" + localLiveWatchMediaInfo.forceSwitch, new Object[0]);
      if ((!this.isPlayedVideo) || (localLiveWatchMediaInfo.forceSwitch)) {
        break;
      }
      if (this.outerVideoLevel > 0)
      {
        localLiveWatchMediaInfo.mLevel = this.outerVideoLevel;
        localLiveWatchMediaInfo.isOriginStream = this.isOuterVideoOrigin;
        localLiveWatchMediaInfo.firstPlayLevel = this.outerVideoLevel;
        localLiveWatchMediaInfo.firstPlayIsOrigin = this.isOuterVideoOrigin;
      }
      return;
    }
    getLog().i(this.TAG, "initRoomPlayer -- onEnterRoom", new Object[0]);
    if (this.isExitRoomPause)
    {
      onSwitchResumePlay();
      return;
    }
    if (this.isPreloadNoStart)
    {
      onSwitchPreloadedStartPlay();
      return;
    }
    playVideo(localLiveWatchMediaInfo);
  }
  
  public void onExtActive()
  {
    getLog().i(this.TAG, "Player -- onExtActive", new Object[0]);
    onActivityStart(this.mLifecycleOwner);
  }
  
  public void onExtDeActive()
  {
    getLog().i(this.TAG, "Player -- onExtDeActive", new Object[0]);
    onActivityStop(this.mLifecycleOwner);
  }
  
  public void onPlayOver()
  {
    super.onPlayOver();
    getLog().i(this.TAG, "Player -- onPlayOver", new Object[0]);
    if (this.avPlayerService.isPlaying()) {
      this.avPlayerService.pausePlay();
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.isOutEnterRoom = false;
    if (this.isExitRoomPause) {
      onSwitchResumePlay();
    }
    do
    {
      return;
      if (this.isPreloadNoStart)
      {
        onSwitchPreloadedStartPlay();
        return;
      }
    } while (TextUtils.isEmpty(paramSwitchRoomInfo.videoUrl));
    getLog().i(this.TAG, "onSwitchRoom -- start play--pre videoUrl=" + paramSwitchRoomInfo.videoUrl + ";roomId=" + paramSwitchRoomInfo.roomId, new Object[0]);
    LiveWatchMediaInfo localLiveWatchMediaInfo = new LiveWatchMediaInfo();
    localLiveWatchMediaInfo.first_play_url = paramSwitchRoomInfo.videoUrl;
    localLiveWatchMediaInfo.mLevel = paramSwitchRoomInfo.videoLevel;
    localLiveWatchMediaInfo.isOriginStream = paramSwitchRoomInfo.videoIsOrigin;
    localLiveWatchMediaInfo.firstPlayLevel = paramSwitchRoomInfo.videoLevel;
    localLiveWatchMediaInfo.firstPlayIsOrigin = paramSwitchRoomInfo.videoIsOrigin;
    this.outSwitchVideoLevel = paramSwitchRoomInfo.videoLevel;
    this.isOutSwitchVideoOrigin = paramSwitchRoomInfo.videoIsOrigin;
    playVideo(localLiveWatchMediaInfo);
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    getLog().i(this.TAG, "Player -- onSwitchScreen--isUserVisibleHint=" + this.isUserVisibleHint, new Object[0]);
    super.onSwitchScreen(paramBoolean);
    if (!this.isUserVisibleHint) {
      return;
    }
    this.avPlayerService.onScreenOrientationChange(paramBoolean);
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if ((!paramBoolean) && (this.avPlayerService != null) && (this.avPlayerService.isPlaying()))
    {
      getLog().i(this.TAG, "setUserVisibleHint -- pausePlay", new Object[0]);
      this.avPlayerService.pausePlay();
      onExitPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule
 * JD-Core Version:    0.7.0.1
 */