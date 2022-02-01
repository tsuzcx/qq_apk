package com.tencent.ilive.audiencepages.room.bizmodule;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.falco.utils.UIUtil;
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
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.messageservice_interface.MessageServiceInterface;
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

public class AVPreloadPlayerModule
  extends RoomBizModule
{
  private int jdField_a_of_type_Int = -1;
  @SuppressLint({"HandlerLeak"})
  Handler jdField_a_of_type_AndroidOsHandler = new AVPreloadPlayerModule.2(this);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AppGeneralInfoService jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService;
  private ToastInterface jdField_a_of_type_ComTencentFalcoBaseLibapiToastToastInterface;
  private AVPreloadPlayerModule.DefaultPlayerStatusListener jdField_a_of_type_ComTencentIliveAudiencepagesRoomBizmoduleAVPreloadPlayerModule$DefaultPlayerStatusListener = new AVPreloadPlayerModule.DefaultPlayerStatusListener(this);
  private AVPreloadPlayerModule.PreloadPlayerStatusListener jdField_a_of_type_ComTencentIliveAudiencepagesRoomBizmoduleAVPreloadPlayerModule$PreloadPlayerStatusListener = new AVPreloadPlayerModule.PreloadPlayerStatusListener(this);
  private AVPlayerBuilderServiceInterface jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface;
  private MessageServiceInterface jdField_a_of_type_ComTencentIlivesdkMessageservice_interfaceMessageServiceInterface;
  private AudQualityServiceInterface jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface;
  private UserEngine jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine;
  UserInitStateCallback jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback = new AVPreloadPlayerModule.1(this);
  private RoomEngine jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine;
  private String jdField_a_of_type_JavaLangString = "AVPreloadPlayerModule";
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g = true;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getRootView().findViewById(2131368723));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)getRootView().findViewById(2131368724));
    Object localObject = this.roomBizContext.getEnterRoomInfo().preVideoUrl;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.isUserVisibleHint))
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "initRoomCover prevideo step 0", new Object[0]);
      localObject = ((AVPreloadServiceInterface)this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.getService(AVPreloadServiceInterface.class)).a((String)localObject);
      if ((localObject != null) && (((AVPreloadTaskInterface)localObject).a() != null))
      {
        getLog().i(this.jdField_a_of_type_JavaLangString, "initRoomCover prevideo step 1:" + ((AVPreloadTaskInterface)localObject).b(), new Object[0]);
        ((AVPreloadTaskInterface)localObject).e(System.nanoTime() / 1000L);
        a((AVPreloadTaskInterface)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        o();
        getLog().i(this.jdField_a_of_type_JavaLangString, "initRoomCover prevideo step 2", new Object[0]);
        return;
      }
    }
    localObject = this.roomBizContext.getEnterRoomInfo().coverBitmapBytes;
    if (localObject != null)
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "bitmap_cover != null", new Object[0]);
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840609);
    }
  }
  
  private void a(int paramInt)
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportPlayFail(paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportSwitchPlayFail(paramInt);
  }
  
  private void a(AVPreloadPlayerModule.StartPlayType paramStartPlayType)
  {
    if (paramStartPlayType == AVPreloadPlayerModule.StartPlayType.SURFACE_CREATE) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "realStartPlay--surfacePlay=" + this.jdField_a_of_type_Boolean + ";readyPlay=" + this.jdField_b_of_type_Boolean, new Object[0]);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.startPlay();
      }
      return;
      if (paramStartPlayType == AVPreloadPlayerModule.StartPlayType.READY_PLAY) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  private void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    getLog().i(this.jdField_a_of_type_JavaLangString, "preShowRoomCover  taskId=" + paramAVPreloadTaskInterface.j(), new Object[0]);
    if (paramAVPreloadTaskInterface.b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(this.context.getResources().getColor(2131165357));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramAVPreloadTaskInterface.a());
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramAVPreloadTaskInterface.c(true);
      int i1 = paramAVPreloadTaskInterface.a().getWidth();
      int i2 = paramAVPreloadTaskInterface.a().getHeight();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = UIUtil.getScreenWidth(this.context);
      if (i1 > 0) {
        localLayoutParams.height = (i2 * localLayoutParams.width / i1);
      }
      localLayoutParams.setMargins(0, paramAVPreloadTaskInterface.g(), 0, 0);
    }
    for (;;)
    {
      paramAVPreloadTaskInterface.f(System.nanoTime() / 1000L);
      paramAVPreloadTaskInterface.g(paramAVPreloadTaskInterface.g() - paramAVPreloadTaskInterface.f());
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramAVPreloadTaskInterface.a());
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramAVPreloadTaskInterface.c(true);
    }
  }
  
  private void a(LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    getLog().i("AudienceTime", "Player -- start playvideo", new Object[0]);
    PlayerParams localPlayerParams = new PlayerParams();
    if (!this.d) {
      m();
    }
    this.d = true;
    if (!TextUtils.isEmpty(paramLiveWatchMediaInfo.first_play_url))
    {
      localPlayerParams.url = paramLiveWatchMediaInfo.first_play_url;
      localPlayerParams.url_high = paramLiveWatchMediaInfo.first_play_url;
      localPlayerParams.url_low = paramLiveWatchMediaInfo.first_play_url;
    }
    for (;;)
    {
      ServiceFrameInfo localServiceFrameInfo = new ServiceFrameInfo();
      localServiceFrameInfo.level = paramLiveWatchMediaInfo.mLevel;
      ServiceAddressInfo localServiceAddressInfo = new ServiceAddressInfo();
      localServiceAddressInfo.url = localPlayerParams.url;
      localServiceFrameInfo.addresses.add(localServiceAddressInfo);
      localPlayerParams.sig = paramLiveWatchMediaInfo.sig;
      if ((this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine != null) && (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic() != null) && (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo() != null))
      {
        localPlayerParams.anchorUin = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().anchorInfo.uid;
        localPlayerParams.roomId = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().roomInfo.roomId;
        localPlayerParams.roomType = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().roomInfo.roomType;
        this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().watchMediaInfo.curServiceFrameInfo = localServiceFrameInfo;
      }
      if (!TextUtils.isEmpty(localPlayerParams.url)) {
        break;
      }
      getLog().i(this.jdField_a_of_type_JavaLangString, "播放地址 url is null...", new Object[0]);
      return;
      if (paramLiveWatchMediaInfo.forceSwitch)
      {
        localPlayerParams.url = paramLiveWatchMediaInfo.mUrl;
        localPlayerParams.url_high = paramLiveWatchMediaInfo.mUrlHigh;
        localPlayerParams.url_low = paramLiveWatchMediaInfo.mUrlLow;
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.stopPlay();
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.resetPlayer();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerStatusListener(null);
      }
      else
      {
        localPlayerParams.url = paramLiveWatchMediaInfo.mUrl;
        localPlayerParams.url_high = paramLiveWatchMediaInfo.mUrlHigh;
        localPlayerParams.url_low = paramLiveWatchMediaInfo.mUrlLow;
      }
    }
    localPlayerParams.videoType = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setParams(localPlayerParams);
    if (paramLiveWatchMediaInfo.isPreload)
    {
      if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload())
      {
        e();
        return;
      }
      d();
      return;
    }
    k();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerSurface();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.preparePlay();
  }
  
  private void a(SwitchRoomInfo paramSwitchRoomInfo)
  {
    if (!TextUtils.isEmpty(paramSwitchRoomInfo.videoUrl))
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "onSwitchRoom -- start play--pre videoUrl=" + paramSwitchRoomInfo.videoUrl + ";roomId=" + paramSwitchRoomInfo.roomId, new Object[0]);
      LiveWatchMediaInfo localLiveWatchMediaInfo = new LiveWatchMediaInfo();
      localLiveWatchMediaInfo.first_play_url = paramSwitchRoomInfo.videoUrl;
      localLiveWatchMediaInfo.mLevel = paramSwitchRoomInfo.videoLevel;
      localLiveWatchMediaInfo.isOriginStream = paramSwitchRoomInfo.videoIsOrigin;
      localLiveWatchMediaInfo.firstPlayLevel = paramSwitchRoomInfo.videoLevel;
      localLiveWatchMediaInfo.firstPlayIsOrigin = paramSwitchRoomInfo.videoIsOrigin;
      this.jdField_b_of_type_Int = paramSwitchRoomInfo.videoLevel;
      this.o = paramSwitchRoomInfo.videoIsOrigin;
      a(localLiveWatchMediaInfo);
    }
    l();
  }
  
  private boolean a()
  {
    FloatWindowConfigServiceInterface localFloatWindowConfigServiceInterface = (FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class);
    FloatWindowPermissionInterface localFloatWindowPermissionInterface = (FloatWindowPermissionInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowPermissionInterface.class);
    return ((localFloatWindowConfigServiceInterface.getFloatWindowEnabledAllTime()) || (localFloatWindowConfigServiceInterface.getFloatWindowEnabledOnce())) && (localFloatWindowPermissionInterface.hasFWPermission());
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b()
  {
    getLog().i("AudienceTime", "Player -- initRoomPlayer", new Object[0]);
    this.g = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)getRootView().findViewById(2131368725));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(new AVPreloadPlayerModule.4(this));
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface = ((AVPlayerBuilderServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(AVPlayerBuilderServiceInterface.class));
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.init(this.context.getApplicationContext(), this.jdField_a_of_type_AndroidWidgetFrameLayout);
    c();
    int i1 = ((Activity)this.context).getIntent().getIntExtra("video_level", -1);
    boolean bool2 = ((Activity)this.context).getIntent().getBooleanExtra("video_is_origin", false);
    LiveWatchMediaInfo localLiveWatchMediaInfo;
    if (!TextUtils.isEmpty(this.roomBizContext.getEnterRoomInfo().preVideoUrl))
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "initRoomPlayer --not first start play--preVideoUrl=" + this.roomBizContext.getEnterRoomInfo().preVideoUrl, new Object[0]);
      localLiveWatchMediaInfo = new LiveWatchMediaInfo();
      localLiveWatchMediaInfo.first_play_url = this.roomBizContext.getEnterRoomInfo().preVideoUrl;
      localLiveWatchMediaInfo.mLevel = i1;
      localLiveWatchMediaInfo.isOriginStream = bool2;
      if (this.isUserVisibleHint) {
        break label263;
      }
    }
    label263:
    for (boolean bool1 = true;; bool1 = false)
    {
      localLiveWatchMediaInfo.isPreload = bool1;
      this.jdField_a_of_type_Int = i1;
      this.n = bool2;
      a(localLiveWatchMediaInfo);
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.avInitSuccess())
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.onLoginEvent(3, "");
      return;
    }
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.addUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.loginSuccess())
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.onLoginEvent(1, "");
      return;
    }
    getLog().i(this.jdField_a_of_type_JavaLangString, "initRoomPlayer -- 等待登录 ", new Object[0]);
  }
  
  private void d()
  {
    j();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerSurface();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.preparePlay();
  }
  
  private void e()
  {
    k();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.preload();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerStatusListener(null);
    this.d = false;
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    k();
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying())
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "onSwitchResumePlay -- resumePlay", new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.resumePlay();
    }
    for (;;)
    {
      this.j = false;
      this.d = true;
      l();
      return;
      getLog().i(this.jdField_a_of_type_JavaLangString, "onSwitchResumePlay -- startPlay", new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.startPlay();
    }
  }
  
  private void h()
  {
    k();
    getLog().i(this.jdField_a_of_type_JavaLangString, "onSwitchPreloadedStartPlay -- startPlay", new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.startPlay();
    l();
  }
  
  private void i()
  {
    if (this.h) {
      getLog().e(this.jdField_a_of_type_JavaLangString, "Player -- onFirstFrameCome but isPageExit", new Object[0]);
    }
    do
    {
      return;
      if (getEvent() != null) {
        getEvent().post(new LiveStateEvent(LiveStateEvent.LiveState.STOP_BUFFER));
      }
      getLog().i("AudienceTime", "Player -- onFirstFrameCome--canPostFirstFrameEvent=" + this.g, new Object[0]);
    } while (!this.g);
    this.f = true;
    n();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (getEvent() != null)
    {
      getEvent().post(new FirstFrameEvent());
      getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.FIRST_FRAME_READY));
    }
    this.g = false;
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerStatusListener(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomBizmoduleAVPreloadPlayerModule$PreloadPlayerStatusListener);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerStatusListener(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomBizmoduleAVPreloadPlayerModule$DefaultPlayerStatusListener);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportSwitchStartPlay();
    if (this.p) {
      o();
    }
    if (this.f)
    {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportFirstFrame();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportSwitchFirstFrame();
  }
  
  private void m()
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportStartPlay();
      return;
    }
    l();
  }
  
  private void n()
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportFirstFrame();
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportSwitchFirstFrame();
  }
  
  private void o()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportFistPreloadFrame();
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportSwitchFistPreloadFrame();
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine != null)
    {
      this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.unint();
      this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine = null;
    }
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    Object localObject = null;
    super.onActivityStart(paramLifecycleOwner);
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onActivityStart", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface == null) {}
    while (!this.isUserVisibleHint) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if ((this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.isLiteSdk()) && (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying()))
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- litesdk -- onStart", new Object[0]);
      return;
    }
    if (this.e) {
      if ((this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine != null) && (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic() != null) && (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo() != null))
      {
        paramLifecycleOwner = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().watchMediaInfo;
        if (paramLifecycleOwner != null) {
          a(paramLifecycleOwner);
        }
      }
    }
    for (;;)
    {
      this.e = false;
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
      if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPaused()) {
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.resumePlay();
      }
    }
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onActivityStop", new Object[0]);
    if (!this.isUserVisibleHint) {}
    for (;;)
    {
      return;
      this.e = false;
      if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.isLiteSdk())
      {
        getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- litesdk -- onstop not pause", new Object[0]);
        return;
      }
      if (((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface() != null) {}
      for (boolean bool = ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isBackgroundPlay(); (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying()) && (!bool) && (!a()); bool = false)
      {
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.pausePlay();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 8000L);
        return;
      }
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine = BizEngineMgr.getInstance().getUserEngine();
    this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine = getRoomEngine();
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiToastToastInterface = ((ToastInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(ToastInterface.class));
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService = ((AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class));
    this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface = ((QualityReportServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(QualityReportServiceInterface.class)).getAudQualityReporter();
    int i1 = this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "||" + hashCode() + "||" + i1);
    int i2 = getAudienceRoomPager().getViewPager().getCurrentItem();
    this.jdField_c_of_type_Int = this.roomBizContext.getEnterRoomInfo().videoType;
    getLog().i(this.jdField_a_of_type_JavaLangString, "onCreate--selfRoomIndex=" + i1 + ";pagerCurrentIndex=" + i2 + ";mVideoType=" + this.jdField_c_of_type_Int, new Object[0]);
    a();
    b();
    getEvent().observe(FloatWindowStateEvent.class, new AVPreloadPlayerModule.3(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onDestroy", new Object[0]);
    if ((this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface != null) && (!this.h))
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerStatusListener(null);
      getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onDestroy--isPlaying:" + this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying(), new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.uninit();
      this.h = true;
    }
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine != null) {
      this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.removeUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(null);
    }
    this.e = false;
    this.g = true;
    this.k = false;
    this.jdField_a_of_type_ComTencentIlivesdkMessageservice_interfaceMessageServiceInterface = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    p();
    getEvent().clearObservers();
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onDestroy end", new Object[0]);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine = getRoomEngine();
    this.jdField_a_of_type_ComTencentIlivesdkMessageservice_interfaceMessageServiceInterface = ((MessageServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(MessageServiceInterface.class));
    if ((this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine != null) && (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(RoomServiceInterface.class) != null) && (((RoomServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(RoomServiceInterface.class)).getLiveInfo() != null) && (((RoomServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(RoomServiceInterface.class)).getLiveInfo().watchMediaInfo != null)) {
      if (((RoomServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(RoomServiceInterface.class)).getLiveInfo().watchMediaInfo.mVideoStatus != LiveVideoStatus.Pause) {
        break label258;
      }
    }
    LiveWatchMediaInfo localLiveWatchMediaInfo;
    label258:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.i = paramBoolean;
      localLiveWatchMediaInfo = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().watchMediaInfo;
      getLog().i(this.jdField_a_of_type_JavaLangString, "initRoomPlayer -- onEnterRoom--isPlayedVideo=" + this.d + ";forceSwitch=" + localLiveWatchMediaInfo.forceSwitch, new Object[0]);
      if ((!this.d) || (localLiveWatchMediaInfo.forceSwitch)) {
        break;
      }
      if (this.jdField_a_of_type_Int > 0)
      {
        localLiveWatchMediaInfo.mLevel = this.jdField_a_of_type_Int;
        localLiveWatchMediaInfo.isOriginStream = this.n;
        localLiveWatchMediaInfo.firstPlayLevel = this.jdField_a_of_type_Int;
        localLiveWatchMediaInfo.firstPlayIsOrigin = this.n;
      }
      return;
    }
    getLog().i(this.jdField_a_of_type_JavaLangString, "initRoomPlayer -- onEnterRoom", new Object[0]);
    if (this.j)
    {
      g();
      return;
    }
    if (this.k)
    {
      h();
      return;
    }
    a(localLiveWatchMediaInfo);
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    AVPlayerBuilderServiceInterface localAVPlayerBuilderServiceInterface = this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface;
    if (!this.jdField_c_of_type_Boolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAVPlayerBuilderServiceInterface.reportPreloadData(paramBoolean);
      return;
    }
  }
  
  public void onExtActive()
  {
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onExtActive", new Object[0]);
    onActivityStart(this.mLifecycleOwner);
  }
  
  public void onExtDeActive()
  {
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onExtDeActive", new Object[0]);
    onActivityStop(this.mLifecycleOwner);
  }
  
  public void onPlayOver()
  {
    super.onPlayOver();
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onPlayOver", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.pausePlay();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.jdField_c_of_type_Boolean = false;
    this.isUserVisibleHint = true;
    AVPlayerBuilderServiceInterface localAVPlayerBuilderServiceInterface = (AVPlayerBuilderServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(AVPlayerBuilderServiceInterface.class);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface != localAVPlayerBuilderServiceInterface)
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface = null;
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface = localAVPlayerBuilderServiceInterface;
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.init(this.context.getApplicationContext(), this.jdField_a_of_type_AndroidWidgetFrameLayout);
      c();
      Log.d(this.jdField_a_of_type_JavaLangString, "playerservice rebuild -- onSwitchRoom avPlayerService=" + this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface);
    }
    if (this.j)
    {
      g();
      return;
    }
    if (this.k)
    {
      h();
      return;
    }
    a(paramSwitchRoomInfo);
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onSwitchScreen--isUserVisibleHint=" + this.isUserVisibleHint, new Object[0]);
    super.onSwitchScreen(paramBoolean);
    if (!this.isUserVisibleHint) {
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.onScreenOrientationChange(paramBoolean);
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface != null) && (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying()))
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "setUserVisibleHint -- pausePlay", new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.pausePlay();
      f();
      this.j = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule
 * JD-Core Version:    0.7.0.1
 */