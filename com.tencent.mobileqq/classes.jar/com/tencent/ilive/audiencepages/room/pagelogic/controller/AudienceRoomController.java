package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostLoginInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilive.audiencepages.room.events.TurnToPortraitEvent;
import com.tencent.ilive.audiencepages.room.pagelogic.base.BaseController;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.RoomBootBizModules;
import com.tencent.ilive.pages.room.datamodel.RoomState;
import com.tencent.ilive.pages.room.events.FirstFrameEvent;
import com.tencent.ilive.pages.room.events.OverPageExitEvent;
import com.tencent.ilive.pages.room.events.PlayOverEvent;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.ilive.pages.room.events.ShowLiveOverEvent;
import com.tencent.ilive.pages.room.events.ShowLiveOverEvent.Source;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveVideoStatus;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.accountengine.UserEngineLogic;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;

public class AudienceRoomController
  extends BaseController
{
  private final String EnterLoginFail = "进房失败：鉴权失败";
  private final String TAG = "RoomController";
  private long curRoomID = -1L;
  private String curVideoId = "";
  private EnterRoomInfo enterRoomInfo;
  private long enterRoomTime = System.currentTimeMillis();
  private boolean isEnterRoom;
  private boolean isFragmentCreated;
  private boolean isOutEnter = true;
  boolean isPageExit = false;
  private boolean isSwitchEnterRoom;
  private boolean isSwitchFragmentCreated;
  Observer mFirstFrameObserver = new AudienceRoomController.1(this);
  private LiveEngine mLiveEngine;
  private RoomPageActionInterface mRoomPageActionInterface;
  private UserEngine mUserEngine;
  private AudienceRoomController.DefaultUserInitStateCallback mUserInitStateCallback;
  Observer overPageExitEvent = new AudienceRoomController.4(this);
  Observer playOverObserver = new AudienceRoomController.3(this);
  private RoomBizContext roomBizContext;
  Observer roomCloseObserver = new AudienceRoomController.2(this);
  private AudienceRoomController.RoomCtrlCallback roomCtrlCallback;
  private SdkEventInterface sdkEventInterface;
  private String[] supportVideoFormat;
  
  public AudienceRoomController(Intent paramIntent, RoomPageActionInterface paramRoomPageActionInterface)
  {
    this.mRoomPageActionInterface = paramRoomPageActionInterface;
    this.isFragmentCreated = false;
    this.enterRoomInfo = new EnterRoomInfo();
    this.enterRoomInfo.isLiteSdk = paramIntent.getBooleanExtra("lite_sdk", false);
    this.curRoomID = paramIntent.getLongExtra("roomid", -1L);
    this.curVideoId = paramIntent.getStringExtra("video_id");
    this.supportVideoFormat = paramIntent.getStringArrayExtra("support_video_format");
    this.enterRoomInfo.source = paramIntent.getStringExtra("source");
    this.enterRoomInfo.programId = paramIntent.getStringExtra("program_id");
    this.enterRoomInfo.extData = paramIntent.getBundleExtra("biz_ext_data");
    int i = paramIntent.getIntExtra("video_format", 0);
    paramIntent = this.enterRoomInfo;
    if (i == 3) {}
    for (i = VideoType.VIDEO.ordinal();; i = VideoType.LIVE.ordinal())
    {
      paramIntent.videoType = i;
      init();
      this.mLiveEngine = BizEngineMgr.getInstance().getLiveEngine();
      this.mUserEngine = BizEngineMgr.getInstance().getUserEngine();
      return;
    }
  }
  
  private void commonExitPageDestroy()
  {
    if (this.sdkEventInterface != null) {
      this.sdkEventInterface.onDestroyRoom();
    }
    if (this.roomCtrlCallback != null) {
      this.roomCtrlCallback.onExitPage();
    }
    if (getEvent() != null) {
      getEvent().clearObservers();
    }
  }
  
  private void doLogin(UserEngine paramUserEngine, RoomPageActionInterface paramRoomPageActionInterface, boolean paramBoolean)
  {
    paramUserEngine.getEnginLogic().auth(paramUserEngine.getLoginRequest(), new AudienceRoomController.6(this, paramBoolean));
  }
  
  private void doLogin(UserEngine paramUserEngine, boolean paramBoolean)
  {
    if (paramUserEngine.loginSuccess())
    {
      getLog().i("RoomController", "doEnterRoom -- is loginSuccess --enterroom", new Object[0]);
      this.audQualityService.reportLoginSuc();
      if (paramBoolean) {
        enterRoom(true);
      }
      return;
    }
    if (paramUserEngine.isLoginBusy())
    {
      getLog().i("RoomController", "doEnterRoom -- is busy --wait login complete", new Object[0]);
      this.mUserInitStateCallback = new AudienceRoomController.DefaultUserInitStateCallback(this);
      this.mUserInitStateCallback.a = paramBoolean;
      paramUserEngine.addUserInitCallback(this.mUserInitStateCallback);
      return;
    }
    getLog().i("RoomController", "doEnterRoom -- no login --login first", new Object[0]);
    if (paramUserEngine.getLoginRequest() != null)
    {
      doLogin(paramUserEngine, this.mRoomPageActionInterface, paramBoolean);
      return;
    }
    getLog().e("RoomController", "doEnterRoom -- no LoginRequest info", new Object[0]);
    doLoginWithGetHostLoginRequest(paramUserEngine, paramBoolean);
  }
  
  private void doLoginWithGetHostLoginRequest(UserEngine paramUserEngine, boolean paramBoolean)
  {
    HostProxyInterface localHostProxyInterface = (HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class);
    if (localHostProxyInterface != null) {
      localHostProxyInterface.getLoginInterface().onGetLoginRequestInfo(new AudienceRoomController.5(this, paramUserEngine, paramBoolean));
    }
  }
  
  private void enterRoom(boolean paramBoolean)
  {
    if (this.isPageExit)
    {
      getLog().i("RoomController", "start enterRoom but isPageExit return", new Object[0]);
      return;
    }
    this.isOutEnter = paramBoolean;
    getLog().i("RoomController", "start enterRoom isOutEnter=" + paramBoolean, new Object[0]);
    Log.i("AudienceTime", "-- start enterroom --isOutEnter=" + paramBoolean);
    if (paramBoolean) {
      this.audQualityService.reportEnterRoom();
    }
    for (;;)
    {
      this.enterRoomInfo.roomId = this.curRoomID;
      this.enterRoomInfo.videoId = this.curVideoId;
      this.enterRoomInfo.machine = ((AppGeneralInfoService)this.mLiveEngine.getService(AppGeneralInfoService.class)).getDeviceID();
      this.enterRoomInfo.videoFormat = this.supportVideoFormat;
      reportEnterRoomStart();
      getRoomEngine().getEnginLogic().watchEnterRoom(this.enterRoomInfo, new AudienceRoomController.7(this, paramBoolean));
      getRoomEngine().getEnginLogic().setReWatchEnterRoomListener(new AudienceRoomController.8(this));
      return;
      this.audQualityService.reportSwitchEnterRoom();
    }
  }
  
  private void initDataAndEvent()
  {
    this.roomBizContext = ((RoomBootBizModules)getAudienceRoomPager().getCurrentFragment().getBootBizModules()).getRoomBizContext();
    getEvent().observe(FirstFrameEvent.class, this.mFirstFrameObserver);
    getEvent().observe(RoomCloseEvent.class, this.roomCloseObserver);
    getEvent().observe(PlayOverEvent.class, this.playOverObserver);
    getEvent().observe(OverPageExitEvent.class, this.overPageExitEvent);
  }
  
  private void onEnterRoomEvent(boolean paramBoolean)
  {
    if (this.roomCtrlCallback != null) {
      this.roomCtrlCallback.onEnterRoom(paramBoolean);
    }
    try
    {
      if (this.bootBizModules != null) {
        ((RoomBootBizModules)this.bootBizModules).onEnterRoom(paramBoolean);
      }
      return;
    }
    catch (Exception localException)
    {
      getLog().i("RoomController", "enter room ex " + localException.toString(), new Object[0]);
    }
  }
  
  private void onEnterRoomRsp(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.audQualityService.reportEnterRoomSuc();
      this.roomBizContext.mLiveInfo = getRoomEngine().getEnginLogic().getLiveInfo();
      if (this.roomBizContext.mLiveInfo != null) {
        break label53;
      }
    }
    label53:
    do
    {
      return;
      this.audQualityService.reportSwitchEnterRoomSuc();
      break;
      if ((this.roomBizContext.mLiveInfo.watchMediaInfo != null) && ((this.roomBizContext.mLiveInfo.watchMediaInfo.mVideoStatus == LiveVideoStatus.Stop) || (this.roomBizContext.mLiveInfo.watchMediaInfo.mVideoStatus == LiveVideoStatus.Unknown)))
      {
        getEvent().post(new ShowLiveOverEvent("", ShowLiveOverEvent.Source.ENTER_OVER));
        this.roomBizContext.getRoomState().isPlayOver = true;
        exitRoomToServer(5, false);
        if (this.roomCtrlCallback != null) {
          this.roomCtrlCallback.onEnterRoomOver(paramBoolean);
        }
        if (this.bootBizModules != null) {
          ((RoomBootBizModules)this.bootBizModules).onPlayOver();
        }
        if (paramBoolean)
        {
          this.audQualityService.reportEnterOver();
          return;
        }
        this.audQualityService.reportSwitchOver();
        return;
      }
      onEnterRoomEvent(paramBoolean);
      this.enterRoomTime = System.currentTimeMillis();
    } while ((this.enterRoomInfo != null) && (this.enterRoomInfo.isLiteSdk));
    ((DataReportInterface)this.mLiveEngine.getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("room").setModuleDesc("直播间").setActType("in").setActTypeDesc("用户成功进房").setRealTimeUpload(true).send();
  }
  
  private void onExitPageEvent()
  {
    AVPreloadServiceInterface localAVPreloadServiceInterface = (AVPreloadServiceInterface)this.mUserEngine.getService(AVPreloadServiceInterface.class);
    localAVPreloadServiceInterface.b();
    localAVPreloadServiceInterface.a();
    if (((LoginServiceInterface)this.mUserEngine.getService(LoginServiceInterface.class)).getLoginInfo() != null)
    {
      long l = ((LoginServiceInterface)this.mUserEngine.getService(LoginServiceInterface.class)).getLoginInfo().uid;
      ((LogSdkServiceInterface)this.mLiveEngine.getService(LogSdkServiceInterface.class)).upload(String.valueOf(l));
    }
    ((NetworkStateInterface)this.mLiveEngine.getService(NetworkStateInterface.class)).clearEventOutput();
    commonExitPageDestroy();
    ServiceAccessorMgr.getInstance().setRoomAccessor(null);
    this.isPageExit = true;
    if (this.mUserEngine.getCurrentRoomEngine() != null) {
      this.mUserEngine.getCurrentRoomEngine().setUnInit();
    }
  }
  
  private void onExitRoomEvent(boolean paramBoolean)
  {
    RoomBootBizModules localRoomBootBizModules = (RoomBootBizModules)this.bootBizModules;
    if (localRoomBootBizModules != null)
    {
      localRoomBootBizModules.clearEvent();
      localRoomBootBizModules.onExitRoom(paramBoolean);
    }
    if (this.sdkEventInterface != null) {
      this.sdkEventInterface.onExitRoom();
    }
    ((RoomServiceInterface)getRoomEngine().getService(RoomServiceInterface.class)).clearEventOutput();
    ((RoomPushServiceInterface)getRoomEngine().getService(RoomPushServiceInterface.class)).onPause();
    ((ChannelInterface)this.mUserEngine.getService(ChannelInterface.class)).clearEventOutput();
    ((LoginServiceInterface)this.mUserEngine.getService(LoginServiceInterface.class)).clearEventOutput();
  }
  
  private void reportEnterRoomFail(int paramInt)
  {
    paramInt -= 1000;
    if ((paramInt < 1) || (paramInt > 6)) {
      return;
    }
    ((DataReportInterface)this.mLiveEngine.getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("room").setModuleDesc("直播间").setActType("failure_in").setActTypeDesc("用户进房失败").addKeyValue("zt_str1", String.valueOf(paramInt)).setRealTimeUpload(true).send();
  }
  
  private void reportEnterRoomStart()
  {
    ((DataReportInterface)this.mLiveEngine.getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("room_agreement").setModuleDesc("协议").setActType("begin").setActTypeDesc("开始").setRealTimeUpload(true).send();
  }
  
  public void exitRoomToPage(boolean paramBoolean)
  {
    if (!paramBoolean) {
      getLog().i("AudienceTime", "--switch--business--exitRoom--start", new Object[0]);
    }
    if (getRoomEngine() == null)
    {
      getEvent().clearObservers();
      if (paramBoolean)
      {
        this.roomCtrlCallback.onExitPage();
        if (this.mRoomPageActionInterface != null) {
          this.mRoomPageActionInterface.finish();
        }
        this.isPageExit = true;
      }
    }
    do
    {
      return;
      onExitRoomEvent(paramBoolean);
      if (paramBoolean)
      {
        onExitPageEvent();
        if (this.mRoomPageActionInterface != null) {
          this.mRoomPageActionInterface.finish();
        }
      }
    } while (paramBoolean);
    getLog().i("AudienceTime", "--switch--business--exitRoom--end", new Object[0]);
  }
  
  public void exitRoomToServer()
  {
    if (!this.roomBizContext.getRoomState().isPlayOver) {
      exitRoomToServer(1, true);
    }
  }
  
  public void exitRoomToServer(int paramInt, boolean paramBoolean)
  {
    if (getRoomEngine() == null) {}
    while (!this.isEnterRoom) {
      return;
    }
    ReportTask localReportTask;
    if (((this.enterRoomInfo == null) || (!this.enterRoomInfo.isLiteSdk)) && (paramBoolean))
    {
      localReportTask = ((DataReportInterface)this.mLiveEngine.getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("room").setModuleDesc("直播间").setActType("quit").setActTypeDesc("用户成功退房").addKeyValue("timelong", System.currentTimeMillis() - this.enterRoomTime).addKeyValue("zt_int1", paramInt);
      if (!this.roomBizContext.getRoomState().isFloatWindowShow) {
        break label201;
      }
    }
    label201:
    for (paramInt = 2;; paramInt = 1)
    {
      localReportTask.addKeyValue("zt_int2", paramInt).setRealTimeUpload(true).send();
      getRoomEngine().getEnginLogic().exitRoom(new AudienceRoomController.9(this));
      ((RoomPushServiceInterface)getRoomEngine().getService(RoomPushServiceInterface.class)).onPause();
      return;
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public boolean onBackPressed()
  {
    if (this.landscape)
    {
      getEvent().post(new TurnToPortraitEvent());
      return true;
    }
    if ((this.roomBizContext != null) && (!this.roomBizContext.getRoomState().isPlayOver)) {
      exitRoomToServer(5, true);
    }
    exitRoomToPage(true);
    return true;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.sdkEventInterface = ((HostProxyInterface)this.mLiveEngine.getService(HostProxyInterface.class)).getSdkEventInterface();
    if (this.sdkEventInterface != null) {
      this.sdkEventInterface.onCreateRoom();
    }
    initDataAndEvent();
    getLog().i("RoomController", "enterRoom--fragment--onCreate--isEnterRoom=" + this.isEnterRoom, new Object[0]);
    if (this.isEnterRoom) {
      onEnterRoomRsp(this.isOutEnter);
    }
    this.isFragmentCreated = true;
  }
  
  public void onDestroy()
  {
    if (!this.isPageExit) {
      commonExitPageDestroy();
    }
    if (this.mUserInitStateCallback != null) {
      this.mUserEngine.removeUserInitCallback(this.mUserInitStateCallback);
    }
    this.isPageExit = true;
    this.mRoomPageActionInterface = null;
  }
  
  public void onInitAction()
  {
    if ((this.curRoomID <= 0L) && (TextUtils.isEmpty(this.curVideoId)))
    {
      ((ToastInterface)this.mUserEngine.getService(ToastInterface.class)).showToast("房间号错误", 1);
      getLog().e("RoomController", "onInitAction  房间号错误", new Object[0]);
      if (this.mRoomPageActionInterface != null) {
        this.mRoomPageActionInterface.finish();
      }
      return;
    }
    if (this.enterRoomInfo.isLiteSdk)
    {
      enterRoom(true);
      doLogin(this.mUserEngine, false);
      return;
    }
    doLogin(this.mUserEngine, true);
  }
  
  public void onSwitchFragment()
  {
    super.onSwitchFragment();
    if (this.bootBizModules == null) {
      return;
    }
    initDataAndEvent();
    Log.i("AudienceTime", "-onSwitchFragment--isSwitchEnterRoom=" + this.isSwitchEnterRoom);
    getLog().i("RoomController", "onSwitchFragment--isSwitchEnterRoom=" + this.isSwitchEnterRoom, new Object[0]);
    if (this.isSwitchEnterRoom) {
      onEnterRoomRsp(this.isOutEnter);
    }
    this.isSwitchFragmentCreated = true;
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.curRoomID = paramSwitchRoomInfo.roomId;
    this.curVideoId = paramSwitchRoomInfo.videoId;
    this.isSwitchFragmentCreated = false;
    this.isSwitchEnterRoom = false;
    this.enterRoomInfo.videoType = paramSwitchRoomInfo.videoType.ordinal();
    this.enterRoomInfo.extData = paramSwitchRoomInfo.extData;
    enterRoom(false);
  }
  
  public void setRoomCtrlCallback(AudienceRoomController.RoomCtrlCallback paramRoomCtrlCallback)
  {
    this.roomCtrlCallback = paramRoomCtrlCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController
 * JD-Core Version:    0.7.0.1
 */