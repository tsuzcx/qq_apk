package com.tencent.ilive.audiencepages.room.pagelogic.controller;

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
import com.tencent.falco.base.libapi.hostproxy.ILiveErrCodeTrans;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.falco.utils.PreloadUtil;
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
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.FloatRoomManager.RoomControl;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEnginLogic.ReWatchEnterRoomListener;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;

public class AudienceRoomController
  extends BaseController
  implements FloatRoomManager.RoomControl
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
  RoomEnginLogic.ReWatchEnterRoomListener mReWatchEnterRoomListener = new AudienceRoomController.5(this);
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
    paramRoomPageActionInterface = this.enterRoomInfo;
    if (i == 3) {
      paramIntent = VideoType.VIDEO;
    } else {
      paramIntent = VideoType.LIVE;
    }
    paramRoomPageActionInterface.videoType = paramIntent.ordinal();
    init();
    this.mLiveEngine = BizEngineMgr.getInstance().getLiveEngine();
    this.mUserEngine = BizEngineMgr.getInstance().getUserEngine();
    this.mLiveEngine.getFloatRoomManager().a(this);
  }
  
  private int calInterceptResult()
  {
    RoomBizContext localRoomBizContext = this.roomBizContext;
    if ((localRoomBizContext != null) && (!localRoomBizContext.getRoomState().isPlayOver)) {
      return this.mLiveEngine.getFloatRoomManager().a();
    }
    return -1;
  }
  
  private void clearOutput()
  {
    ((RoomServiceInterface)getRoomEngine().getService(RoomServiceInterface.class)).clearEventOutput();
    ((RoomPushServiceInterface)getRoomEngine().getService(RoomPushServiceInterface.class)).onPause();
    ((ChannelInterface)this.mUserEngine.getService(ChannelInterface.class)).clearEventOutput();
    if (!this.mUserEngine.loginSuccess()) {
      this.mUserEngine.resetLoginState();
    }
    ((LoginServiceInterface)this.mUserEngine.getService(LoginServiceInterface.class)).clearEventOutput();
  }
  
  private void commonExitPageDestroy()
  {
    Object localObject = this.sdkEventInterface;
    if (localObject != null) {
      ((SdkEventInterface)localObject).onDestroyRoom();
    }
    localObject = this.roomCtrlCallback;
    if (localObject != null) {
      ((AudienceRoomController.RoomCtrlCallback)localObject).onExitPage();
    }
  }
  
  private void dealOverRoom()
  {
    getEvent().post(new ShowLiveOverEvent("", ShowLiveOverEvent.Source.ENTER_OVER));
    this.roomBizContext.getRoomState().isPlayOver = true;
    exitRoomToServer(5, false);
    AudienceRoomController.RoomCtrlCallback localRoomCtrlCallback = this.roomCtrlCallback;
    if (localRoomCtrlCallback != null) {
      localRoomCtrlCallback.onEnterRoomOver(this.isOutEnter);
    }
    if (this.bootBizModules != null) {
      ((RoomBootBizModules)this.bootBizModules).onPlayOver();
    }
    if (this.isOutEnter)
    {
      this.audQualityService.reportEnterOver();
      return;
    }
    this.audQualityService.reportSwitchOver();
  }
  
  private void doLogin(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mUserEngine.loginSuccess())
    {
      getLog().i("RoomController", "doEnterRoom -- is loginSuccess --enterroom", new Object[0]);
      this.audQualityService.reportLoginSuc();
      if (paramBoolean1) {
        enterRoom(paramBoolean2);
      }
    }
    else
    {
      if (this.mUserEngine.isLoginBusy())
      {
        getLog().i("RoomController", "doEnterRoom -- is busy --wait login complete", new Object[0]);
        this.mUserInitStateCallback = new AudienceRoomController.DefaultUserInitStateCallback(this);
        AudienceRoomController.DefaultUserInitStateCallback localDefaultUserInitStateCallback = this.mUserInitStateCallback;
        localDefaultUserInitStateCallback.a = paramBoolean1;
        localDefaultUserInitStateCallback.b = paramBoolean2;
        this.mUserEngine.addUserInitCallback(localDefaultUserInitStateCallback);
        return;
      }
      getLog().i("RoomController", "doEnterRoom -- no login --login first", new Object[0]);
      if (this.mUserEngine.getLoginRequest() != null)
      {
        doLoginWithRequest(paramBoolean1, paramBoolean2);
        return;
      }
      getLog().e("RoomController", "doEnterRoom -- no LoginRequest info", new Object[0]);
      doLoginWithGetHostLoginRequest(paramBoolean1, paramBoolean2);
    }
  }
  
  private void doLoginWithGetHostLoginRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    HostProxyInterface localHostProxyInterface = (HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class);
    if (localHostProxyInterface != null) {
      localHostProxyInterface.getLoginInterface().onGetLoginRequestInfo(new AudienceRoomController.7(this, paramBoolean1, paramBoolean2));
    }
  }
  
  private void doLoginWithRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mUserEngine.getEnginLogic().auth(this.mUserEngine.getLoginRequest(), new AudienceRoomController.6(this, paramBoolean1, paramBoolean2));
  }
  
  private void enterRoom(boolean paramBoolean)
  {
    if (this.isPageExit)
    {
      getLog().i("RoomController", "start enterRoom but isPageExit return", new Object[0]);
      return;
    }
    this.isOutEnter = paramBoolean;
    Object localObject = getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start enterRoom isOutEnter=");
    localStringBuilder.append(paramBoolean);
    ((LogInterface)localObject).i("RoomController", localStringBuilder.toString(), new Object[0]);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-- start enterroom --isOutEnter=");
    ((StringBuilder)localObject).append(paramBoolean);
    Log.i("AudienceTime", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      this.audQualityService.reportEnterRoom();
    } else {
      this.audQualityService.reportSwitchEnterRoom();
    }
    localObject = this.enterRoomInfo;
    ((EnterRoomInfo)localObject).roomId = this.curRoomID;
    ((EnterRoomInfo)localObject).videoId = this.curVideoId;
    ((EnterRoomInfo)localObject).machine = ((AppGeneralInfoService)this.mLiveEngine.getService(AppGeneralInfoService.class)).getDeviceID();
    this.enterRoomInfo.videoFormat = this.supportVideoFormat;
    reportEnterRoomStart();
    localObject = this.sdkEventInterface;
    if (localObject != null) {
      ((SdkEventInterface)localObject).onStartEnterRoom(this.curRoomID);
    }
    getRoomEngine().getEnginLogic().watchEnterRoom(this.enterRoomInfo, new AudienceRoomController.8(this));
    getRoomEngine().getEnginLogic().setReWatchEnterRoomListener(this.mReWatchEnterRoomListener);
  }
  
  private void exitRoomToServer(int paramInt, boolean paramBoolean)
  {
    if (getRoomEngine() == null) {
      return;
    }
    if (this.isEnterRoom)
    {
      reportQuitRoom(paramInt, paramBoolean);
      quitRoom();
      ((RoomPushServiceInterface)getRoomEngine().getService(RoomPushServiceInterface.class)).onPause();
    }
  }
  
  private void initDataAndEvent()
  {
    if (getAudienceRoomPager().getCurrentFragment() != null) {
      this.roomBizContext = ((RoomBootBizModules)getAudienceRoomPager().getCurrentFragment().getBootBizModules()).getRoomBizContext();
    }
    getEvent().observe(FirstFrameEvent.class, this.mFirstFrameObserver);
    getEvent().observe(RoomCloseEvent.class, this.roomCloseObserver);
    getEvent().observe(PlayOverEvent.class, this.playOverObserver);
    getEvent().observe(OverPageExitEvent.class, this.overPageExitEvent);
  }
  
  private void notifyExitRoomEvent(boolean paramBoolean)
  {
    Object localObject = (RoomBootBizModules)this.bootBizModules;
    if (localObject != null)
    {
      ((RoomBootBizModules)localObject).clearEvent();
      ((RoomBootBizModules)localObject).onExitRoom(paramBoolean);
    }
    localObject = this.sdkEventInterface;
    if (localObject != null) {
      ((SdkEventInterface)localObject).onExitRoom();
    }
  }
  
  private void onEnterRoomEvent(boolean paramBoolean)
  {
    AudienceRoomController.RoomCtrlCallback localRoomCtrlCallback = this.roomCtrlCallback;
    if (localRoomCtrlCallback != null) {
      localRoomCtrlCallback.onEnterRoom(paramBoolean);
    }
    try
    {
      if (this.bootBizModules != null)
      {
        ((RoomBootBizModules)this.bootBizModules).onEnterRoom(paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      LogInterface localLogInterface = getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enter room ex ");
      localStringBuilder.append(localException.toString());
      localLogInterface.i("RoomController", localStringBuilder.toString(), new Object[0]);
    }
  }
  
  private void onEnterRoomRsp(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.audQualityService.reportEnterRoomSuc();
    } else {
      this.audQualityService.reportSwitchEnterRoomSuc();
    }
    this.roomBizContext.mLiveInfo = getRoomEngine().getEnginLogic().getLiveInfo();
    if (this.roomBizContext.mLiveInfo == null) {
      return;
    }
    if ((this.roomBizContext.mLiveInfo.watchMediaInfo != null) && ((this.roomBizContext.mLiveInfo.watchMediaInfo.mVideoStatus == LiveVideoStatus.Stop) || (this.roomBizContext.mLiveInfo.watchMediaInfo.mVideoStatus == LiveVideoStatus.Unknown)))
    {
      dealOverRoom();
      return;
    }
    onEnterRoomEvent(paramBoolean);
    reportInRoom();
  }
  
  private void onExitPageEvent()
  {
    if (PreloadUtil.a())
    {
      AVPreloadServiceInterface localAVPreloadServiceInterface = (AVPreloadServiceInterface)this.mUserEngine.getService(AVPreloadServiceInterface.class);
      localAVPreloadServiceInterface.c();
      localAVPreloadServiceInterface.b();
    }
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
  
  private void onReWatchFail(long paramLong, int paramInt, String paramString)
  {
    EnterRoomInfo localEnterRoomInfo = this.enterRoomInfo;
    if ((localEnterRoomInfo != null) && (!localEnterRoomInfo.isLiteSdk)) {
      showErrExitDialog(paramString, this.mRoomPageActionInterface);
    }
    paramString = this.sdkEventInterface;
    if (paramString != null) {
      paramString.onEnterRoom(paramLong, paramInt);
    }
    reportEnterRoomFail(paramInt);
  }
  
  private void onReWatchSuccess(long paramLong)
  {
    SdkEventInterface localSdkEventInterface = this.sdkEventInterface;
    if (localSdkEventInterface != null) {
      localSdkEventInterface.onEnterRoom(paramLong, 0);
    }
    getLog().i("RoomController", "re-login enter room success", new Object[0]);
  }
  
  private void onWatchEnterRoomFail(int paramInt, String paramString)
  {
    Object localObject = getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom--onFail--failCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";errMsg=");
    localStringBuilder.append(paramString);
    ((LogInterface)localObject).e("RoomController", localStringBuilder.toString(), new Object[0]);
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (!paramString.startsWith("wns_Error:")) {}
    }
    else
    {
      localObject = "进房失败，请稍后重试";
    }
    if (!this.isPageExit)
    {
      paramString = this.enterRoomInfo;
      if ((paramString != null) && (!paramString.isLiteSdk)) {
        showErrExitDialog((String)localObject, this.mRoomPageActionInterface);
      }
    }
    reportEnterRoomFail(paramInt);
    reportByFail(paramInt);
    paramString = this.sdkEventInterface;
    if (paramString != null) {
      paramString.onEnterRoom(this.curRoomID, paramInt);
    }
    uploadLogByFail();
  }
  
  private void onWatchEnterRoomSuccess()
  {
    if (this.isPageExit)
    {
      getLog().i("RoomController", "enterRoom onSuccess isPageExit return", new Object[0]);
      return;
    }
    StringBuilder localStringBuilder;
    if (this.isOutEnter)
    {
      Log.i("AudienceTime", "-- enterroom onSuccess--");
      localObject = getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterRoom--onSuccess--isFragmentCreated=");
      localStringBuilder.append(this.isFragmentCreated);
      ((LogInterface)localObject).i("RoomController", localStringBuilder.toString(), new Object[0]);
      if (this.isFragmentCreated) {
        onEnterRoomRsp(true);
      }
      this.isEnterRoom = true;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-switch- enterroom onSuccess--isFragmentCreated=");
      ((StringBuilder)localObject).append(this.isFragmentCreated);
      Log.i("AudienceTime", ((StringBuilder)localObject).toString());
      localObject = getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("swich enterRoom--onSuccess--isFragmentCreated=");
      localStringBuilder.append(this.isFragmentCreated);
      ((LogInterface)localObject).i("RoomController", localStringBuilder.toString(), new Object[0]);
      if (this.isSwitchFragmentCreated) {
        onEnterRoomRsp(false);
      }
      this.isSwitchEnterRoom = true;
    }
    getRoomEngine().enterRoomSuccess();
    Object localObject = this.sdkEventInterface;
    if (localObject != null) {
      ((SdkEventInterface)localObject).onEnterRoom(this.curRoomID, 0);
    }
  }
  
  private void quitRoom()
  {
    getRoomEngine().getEnginLogic().exitRoom(new AudienceRoomController.9(this));
  }
  
  private void reportByFail(int paramInt)
  {
    if (this.isOutEnter)
    {
      this.audQualityService.reportEnterRoomFail(paramInt);
      return;
    }
    this.audQualityService.reportSwitchEnterRoomFail(paramInt);
  }
  
  private void reportEnterRoomFail(int paramInt)
  {
    paramInt = ILiveErrCodeTrans.b(paramInt);
    if (paramInt == 7) {
      return;
    }
    ((DataReportInterface)this.mLiveEngine.getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("room").setModuleDesc("直播间").setActType("failure_in").setActTypeDesc("用户进房失败").addKeyValue("zt_str1", String.valueOf(paramInt)).setRealTimeUpload(true).send();
  }
  
  private void reportEnterRoomStart()
  {
    ((DataReportInterface)this.mLiveEngine.getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("room_agreement").setModuleDesc("协议").setActType("begin").setActTypeDesc("开始").setRealTimeUpload(true).send();
  }
  
  private void reportInRoom()
  {
    this.enterRoomTime = System.currentTimeMillis();
    EnterRoomInfo localEnterRoomInfo = this.enterRoomInfo;
    if ((localEnterRoomInfo == null) || (!localEnterRoomInfo.isLiteSdk)) {
      ((DataReportInterface)this.mLiveEngine.getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("room").setModuleDesc("直播间").setActType("in").setActTypeDesc("用户成功进房").setRealTimeUpload(true).send();
    }
  }
  
  private void reportQuitRoom(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.enterRoomInfo;
    if (((localObject == null) || (!((EnterRoomInfo)localObject).isLiteSdk)) && (paramBoolean))
    {
      localObject = this.roomBizContext;
      int i;
      if ((localObject != null) && (((RoomBizContext)localObject).getRoomState() != null) && (this.roomBizContext.getRoomState().isFloatWindowShow)) {
        i = 2;
      } else {
        i = 1;
      }
      ((DataReportInterface)this.mLiveEngine.getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("room").setModuleDesc("直播间").setActType("quit").setActTypeDesc("用户成功退房").addKeyValue("timelong", System.currentTimeMillis() - this.enterRoomTime).addKeyValue("zt_int1", paramInt).addKeyValue("zt_int2", i).setRealTimeUpload(true).send();
    }
  }
  
  private void uploadLogByFail()
  {
    LoginInfo localLoginInfo = ((LoginServiceInterface)this.mUserEngine.getService(LoginServiceInterface.class)).getLoginInfo();
    if (localLoginInfo != null)
    {
      long l = localLoginInfo.uid;
      ((LogSdkServiceInterface)this.mLiveEngine.getService(LogSdkServiceInterface.class)).setUid(String.valueOf(l));
      ((LogSdkServiceInterface)this.mLiveEngine.getService(LogSdkServiceInterface.class)).upload(String.valueOf(l));
    }
  }
  
  public void closeRoom()
  {
    if (getRoomEngine() == null)
    {
      this.roomCtrlCallback.onExitPage();
      localRoomPageActionInterface = this.mRoomPageActionInterface;
      if (localRoomPageActionInterface != null) {
        localRoomPageActionInterface.finish();
      }
      this.isPageExit = true;
      return;
    }
    notifyExitRoomEvent(true);
    clearOutput();
    RoomPageActionInterface localRoomPageActionInterface = this.mRoomPageActionInterface;
    if (localRoomPageActionInterface != null) {
      localRoomPageActionInterface.finish();
    }
  }
  
  public void exitFloatRoom()
  {
    exitRoomToServer(3, true);
    clearOutput();
    onRoomDestroy();
    onExitPageEvent();
  }
  
  public void exitLiveBizRoom()
  {
    exitLiveBizRoomById(3);
  }
  
  public void exitLiveBizRoomById(int paramInt)
  {
    exitRoomToServer(paramInt, true);
    exitLiveBizRoomLocal();
  }
  
  public void exitLiveBizRoomLocal()
  {
    closeRoom();
    onRoomDestroy();
    onExitPageEvent();
  }
  
  public void exitRoomToServer()
  {
    if (!this.roomBizContext.getRoomState().isPlayOver) {
      exitRoomToServer(1, true);
    }
  }
  
  public void onBackPressed()
  {
    if (this.landscape)
    {
      getEvent().post(new TurnToPortraitEvent());
      return;
    }
    int i = calInterceptResult();
    if (i == 0) {
      return;
    }
    if (i == 1)
    {
      onlyClosePage();
      return;
    }
    exitLiveBizRoom();
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.sdkEventInterface = ((HostProxyInterface)this.mLiveEngine.getService(HostProxyInterface.class)).getSdkEventInterface();
    paramContext = this.sdkEventInterface;
    if (paramContext != null) {
      paramContext.onCreateRoom();
    }
    initDataAndEvent();
    paramContext = getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom--fragment--onCreate--isEnterRoom=");
    localStringBuilder.append(this.isEnterRoom);
    paramContext.i("RoomController", localStringBuilder.toString(), new Object[0]);
    if (this.isEnterRoom) {
      onEnterRoomRsp(this.isOutEnter);
    }
    this.isFragmentCreated = true;
  }
  
  public void onDestroy() {}
  
  public void onInitAction()
  {
    if ((this.curRoomID <= 0L) && (TextUtils.isEmpty(this.curVideoId)))
    {
      ((ToastInterface)this.mUserEngine.getService(ToastInterface.class)).showToast("房间号错误", 1);
      getLog().e("RoomController", "onInitAction  房间号错误", new Object[0]);
      RoomPageActionInterface localRoomPageActionInterface = this.mRoomPageActionInterface;
      if (localRoomPageActionInterface != null) {
        localRoomPageActionInterface.finish();
      }
      return;
    }
    if (this.enterRoomInfo.isLiteSdk)
    {
      enterRoom(true);
      doLogin(false, true);
      return;
    }
    doLogin(true, true);
  }
  
  public void onRoomDestroy()
  {
    if (!this.isPageExit) {
      commonExitPageDestroy();
    }
    AudienceRoomController.DefaultUserInitStateCallback localDefaultUserInitStateCallback = this.mUserInitStateCallback;
    if (localDefaultUserInitStateCallback != null) {
      this.mUserEngine.removeUserInitCallback(localDefaultUserInitStateCallback);
    }
    this.isPageExit = true;
    this.mRoomPageActionInterface = null;
  }
  
  public void onSwitchFragment()
  {
    super.onSwitchFragment();
    if (this.bootBizModules == null) {
      return;
    }
    initDataAndEvent();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-onSwitchFragment--isSwitchEnterRoom=");
    ((StringBuilder)localObject).append(this.isSwitchEnterRoom);
    Log.i("AudienceTime", ((StringBuilder)localObject).toString());
    localObject = getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSwitchFragment--isSwitchEnterRoom=");
    localStringBuilder.append(this.isSwitchEnterRoom);
    ((LogInterface)localObject).i("RoomController", localStringBuilder.toString(), new Object[0]);
    if (this.isSwitchEnterRoom) {
      onEnterRoomRsp(this.isOutEnter);
    }
    this.isSwitchFragmentCreated = true;
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.curRoomID = paramSwitchRoomInfo.roomId;
    this.curVideoId = paramSwitchRoomInfo.videoId;
    this.isSwitchFragmentCreated = paramSwitchRoomInfo.isSwitchFragmentCreated;
    this.isSwitchEnterRoom = false;
    this.enterRoomInfo.videoType = paramSwitchRoomInfo.videoType.ordinal();
    this.enterRoomInfo.extData = paramSwitchRoomInfo.extData;
    if (this.mUserEngine.loginSuccess())
    {
      enterRoom(false);
      return;
    }
    doLogin(true, false);
  }
  
  public void onlyClosePage()
  {
    if (getRoomEngine() == null)
    {
      this.roomCtrlCallback.onExitPage();
      localRoomPageActionInterface = this.mRoomPageActionInterface;
      if (localRoomPageActionInterface != null) {
        localRoomPageActionInterface.finish();
      }
      this.isPageExit = true;
      return;
    }
    notifyExitRoomEvent(true);
    RoomPageActionInterface localRoomPageActionInterface = this.mRoomPageActionInterface;
    if (localRoomPageActionInterface != null) {
      localRoomPageActionInterface.finish();
    }
  }
  
  public void setRoomCtrlCallback(AudienceRoomController.RoomCtrlCallback paramRoomCtrlCallback)
  {
    this.roomCtrlCallback = paramRoomCtrlCallback;
  }
  
  public void switchRoom()
  {
    getLog().i("AudienceTime", "--switch--business--exitRoom--start", new Object[0]);
    if (getRoomEngine() == null) {
      return;
    }
    notifyExitRoomEvent(false);
    clearOutput();
    getLog().i("AudienceTime", "--switch--business--exitRoom--end", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController
 * JD-Core Version:    0.7.0.1
 */