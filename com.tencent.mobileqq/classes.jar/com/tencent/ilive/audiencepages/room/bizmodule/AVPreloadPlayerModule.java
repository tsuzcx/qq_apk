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
import com.tencent.falco.utils.PreloadUtil;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent.PlayerState;
import com.tencent.ilive.base.event.ModuleEvent;
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
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
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
  private boolean q = false;
  private boolean r = false;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine = BizEngineMgr.getInstance().getUserEngine();
    this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine = getRoomEngine();
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiToastToastInterface = ((ToastInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(ToastInterface.class));
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService = ((AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class));
    this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface = ((QualityReportServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(QualityReportServiceInterface.class)).getAudQualityReporter();
    int i2 = this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("||");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append("||");
    ((StringBuilder)localObject).append(i2);
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    int i1;
    if (getAudienceRoomPager() != null) {
      i1 = getAudienceRoomPager().getCurrentIndex();
    } else {
      i1 = 0;
    }
    this.jdField_c_of_type_Int = this.roomBizContext.getEnterRoomInfo().videoType;
    localObject = getLog();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate--selfRoomIndex=");
    localStringBuilder.append(i2);
    localStringBuilder.append(";pagerCurrentIndex=");
    localStringBuilder.append(i1);
    localStringBuilder.append(";mVideoType=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    ((LogInterface)localObject).i(str, localStringBuilder.toString(), new Object[0]);
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
    } else if (paramStartPlayType == AVPreloadPlayerModule.StartPlayType.READY_PLAY) {
      this.jdField_b_of_type_Boolean = true;
    }
    paramStartPlayType = getLog();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("realStartPlay--surfacePlay=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(";readyPlay=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    paramStartPlayType.i(str, localStringBuilder.toString(), new Object[0]);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.startPlay();
    }
  }
  
  private void a(PlayerParams paramPlayerParams, LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    if (!TextUtils.isEmpty(paramLiveWatchMediaInfo.first_play_url))
    {
      paramPlayerParams.url = paramLiveWatchMediaInfo.first_play_url;
      paramPlayerParams.url_high = paramLiveWatchMediaInfo.first_play_url;
      paramPlayerParams.url_low = paramLiveWatchMediaInfo.first_play_url;
      return;
    }
    if (paramLiveWatchMediaInfo.forceSwitch)
    {
      paramPlayerParams.url = paramLiveWatchMediaInfo.mUrl;
      paramPlayerParams.url_high = paramLiveWatchMediaInfo.mUrlHigh;
      paramPlayerParams.url_low = paramLiveWatchMediaInfo.mUrlLow;
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.stopPlay();
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.resetPlayer();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerStatusListener(null);
      return;
    }
    paramPlayerParams.url = paramLiveWatchMediaInfo.mUrl;
    paramPlayerParams.url_high = paramLiveWatchMediaInfo.mUrlHigh;
    paramPlayerParams.url_low = paramLiveWatchMediaInfo.mUrlLow;
  }
  
  private void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    Object localObject = getLog();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preShowRoomCover  taskId=");
    localStringBuilder.append(paramAVPreloadTaskInterface.j());
    ((LogInterface)localObject).i(str, localStringBuilder.toString(), new Object[0]);
    if (paramAVPreloadTaskInterface.b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(this.context.getResources().getColor(2131165327));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramAVPreloadTaskInterface.a());
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramAVPreloadTaskInterface.c(true);
      int i1 = paramAVPreloadTaskInterface.a().getWidth();
      int i2 = paramAVPreloadTaskInterface.a().getHeight();
      localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = UIUtil.getScreenWidth(this.context);
      if (i1 > 0) {
        ((FrameLayout.LayoutParams)localObject).height = (((FrameLayout.LayoutParams)localObject).width * i2 / i1);
      }
      ((FrameLayout.LayoutParams)localObject).setMargins(0, paramAVPreloadTaskInterface.g(), 0, 0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramAVPreloadTaskInterface.a());
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      paramAVPreloadTaskInterface.c(true);
    }
    paramAVPreloadTaskInterface.f(System.nanoTime() / 1000L);
    paramAVPreloadTaskInterface.g(paramAVPreloadTaskInterface.g() - paramAVPreloadTaskInterface.f());
  }
  
  private void a(LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    getLog().i("AudienceTime", "Player -- start playvideo", new Object[0]);
    if (!this.d) {
      s();
    }
    this.d = true;
    PlayerParams localPlayerParams = new PlayerParams();
    a(localPlayerParams, paramLiveWatchMediaInfo);
    b(localPlayerParams, paramLiveWatchMediaInfo);
    if (TextUtils.isEmpty(localPlayerParams.url))
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "播放地址 url is null...", new Object[0]);
      return;
    }
    localPlayerParams.videoType = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setParams(localPlayerParams);
    if (paramLiveWatchMediaInfo.isPreload)
    {
      if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload())
      {
        h();
        return;
      }
      g();
      return;
    }
    q();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerSurface();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.preparePlay();
  }
  
  private void a(SwitchRoomInfo paramSwitchRoomInfo)
  {
    if (!TextUtils.isEmpty(paramSwitchRoomInfo.videoUrl))
    {
      Object localObject = getLog();
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchRoom -- start play--pre videoUrl=");
      localStringBuilder.append(paramSwitchRoomInfo.videoUrl);
      localStringBuilder.append(";roomId=");
      localStringBuilder.append(paramSwitchRoomInfo.roomId);
      ((LogInterface)localObject).i(str, localStringBuilder.toString(), new Object[0]);
      localObject = new LiveWatchMediaInfo();
      ((LiveWatchMediaInfo)localObject).first_play_url = paramSwitchRoomInfo.videoUrl;
      ((LiveWatchMediaInfo)localObject).mLevel = paramSwitchRoomInfo.videoLevel;
      ((LiveWatchMediaInfo)localObject).isOriginStream = paramSwitchRoomInfo.videoIsOrigin;
      ((LiveWatchMediaInfo)localObject).firstPlayLevel = paramSwitchRoomInfo.videoLevel;
      ((LiveWatchMediaInfo)localObject).firstPlayIsOrigin = paramSwitchRoomInfo.videoIsOrigin;
      this.jdField_b_of_type_Int = paramSwitchRoomInfo.videoLevel;
      this.o = paramSwitchRoomInfo.videoIsOrigin;
      a((LiveWatchMediaInfo)localObject);
    }
    r();
  }
  
  private boolean a()
  {
    Object localObject = this.roomBizContext.getEnterRoomInfo().preVideoUrl;
    if ((PreloadUtil.a((String)localObject, this.jdField_c_of_type_Int)) && (this.isUserVisibleHint))
    {
      localObject = ((AVPreloadServiceInterface)this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.getService(AVPreloadServiceInterface.class)).a((String)localObject);
      if ((localObject != null) && (((AVPreloadTaskInterface)localObject).a() != null))
      {
        ((AVPreloadTaskInterface)localObject).e(System.nanoTime() / 1000L);
        a((AVPreloadTaskInterface)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        u();
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getRootView().findViewById(2131368455));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)getRootView().findViewById(2131368456));
    if (a()) {
      return;
    }
    Object localObject = this.roomBizContext.getEnterRoomInfo().coverBitmapBytes;
    if (localObject != null)
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "bitmap_cover != null", new Object[0]);
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840482);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void b(PlayerParams paramPlayerParams, LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    ServiceFrameInfo localServiceFrameInfo = new ServiceFrameInfo();
    localServiceFrameInfo.level = paramLiveWatchMediaInfo.mLevel;
    ServiceAddressInfo localServiceAddressInfo = new ServiceAddressInfo();
    localServiceAddressInfo.url = paramPlayerParams.url;
    localServiceFrameInfo.addresses.add(localServiceAddressInfo);
    paramPlayerParams.sig = paramLiveWatchMediaInfo.sig;
    paramLiveWatchMediaInfo = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine;
    if ((paramLiveWatchMediaInfo != null) && (paramLiveWatchMediaInfo.getEnginLogic() != null) && (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo() != null))
    {
      paramPlayerParams.anchorUin = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().anchorInfo.uid;
      paramPlayerParams.roomId = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().roomInfo.roomId;
      paramPlayerParams.roomType = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().roomInfo.roomType;
      this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().watchMediaInfo.curServiceFrameInfo = localServiceFrameInfo;
    }
  }
  
  private void b(LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    int i1 = this.jdField_a_of_type_Int;
    if (i1 > 0)
    {
      paramLiveWatchMediaInfo.mLevel = i1;
      boolean bool = this.n;
      paramLiveWatchMediaInfo.isOriginStream = bool;
      paramLiveWatchMediaInfo.firstPlayLevel = i1;
      paramLiveWatchMediaInfo.firstPlayIsOrigin = bool;
    }
  }
  
  private boolean b()
  {
    FloatWindowConfigServiceInterface localFloatWindowConfigServiceInterface = (FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class);
    FloatWindowPermissionInterface localFloatWindowPermissionInterface = (FloatWindowPermissionInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowPermissionInterface.class);
    return ((localFloatWindowConfigServiceInterface.getFloatWindowEnabledAllTime()) || (localFloatWindowConfigServiceInterface.getFloatWindowEnabledOnce())) && (localFloatWindowPermissionInterface.hasFWPermission());
  }
  
  private void c()
  {
    getLog().i("AudienceTime", "Player -- initRoomPlayer", new Object[0]);
    this.g = true;
    d();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface = ((AVPlayerBuilderServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(AVPlayerBuilderServiceInterface.class));
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.init(this.context.getApplicationContext(), this.jdField_a_of_type_AndroidWidgetFrameLayout);
    f();
    e();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)getRootView().findViewById(2131368457));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(new AVPreloadPlayerModule.4(this));
  }
  
  private void e()
  {
    int i1 = ((Activity)this.context).getIntent().getIntExtra("video_level", -1);
    boolean bool = ((Activity)this.context).getIntent().getBooleanExtra("video_is_origin", false);
    if (!TextUtils.isEmpty(this.roomBizContext.getEnterRoomInfo().preVideoUrl))
    {
      Object localObject = getLog();
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initRoomPlayer --not first start play--preVideoUrl=");
      localStringBuilder.append(this.roomBizContext.getEnterRoomInfo().preVideoUrl);
      ((LogInterface)localObject).i(str, localStringBuilder.toString(), new Object[0]);
      localObject = new LiveWatchMediaInfo();
      ((LiveWatchMediaInfo)localObject).first_play_url = this.roomBizContext.getEnterRoomInfo().preVideoUrl;
      ((LiveWatchMediaInfo)localObject).mLevel = i1;
      ((LiveWatchMediaInfo)localObject).isOriginStream = bool;
      ((LiveWatchMediaInfo)localObject).isPreload = (this.isUserVisibleHint ^ true);
      this.jdField_a_of_type_Int = i1;
      this.n = bool;
      a((LiveWatchMediaInfo)localObject);
    }
  }
  
  private void f()
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
  
  private void g()
  {
    p();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerSurface();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.preparePlay();
  }
  
  private void h()
  {
    q();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.preload();
  }
  
  private void i()
  {
    RoomEngine localRoomEngine = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine;
    if ((localRoomEngine != null) && (localRoomEngine.getEnginLogic() != null) && (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo() != null) && (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().watchMediaInfo != null))
    {
      boolean bool;
      if (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().watchMediaInfo.mVideoStatus == LiveVideoStatus.Pause) {
        bool = true;
      } else {
        bool = false;
      }
      this.i = bool;
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerStatusListener(null);
    this.d = false;
  }
  
  private void k()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    q();
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying())
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "onSwitchResumePlay -- resumePlay", new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.resumePlay();
    }
    else
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "onSwitchResumePlay -- startPlay", new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.startPlay();
    }
    this.j = false;
    this.d = true;
    r();
  }
  
  private void l()
  {
    q();
    getLog().i(this.jdField_a_of_type_JavaLangString, "onSwitchPreloadedStartPlay -- startPlay", new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.startPlay();
    r();
  }
  
  private void m()
  {
    if (this.h)
    {
      getLog().e(this.jdField_a_of_type_JavaLangString, "Player -- onFirstFrameCome but isPageExit", new Object[0]);
      return;
    }
    if (getEvent() != null) {
      getEvent().post(new LiveStateEvent(LiveStateEvent.LiveState.STOP_BUFFER));
    }
    LogInterface localLogInterface = getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Player -- onFirstFrameCome--canPostFirstFrameEvent=");
    localStringBuilder.append(this.g);
    localLogInterface.i("AudienceTime", localStringBuilder.toString(), new Object[0]);
    if (!this.g) {
      return;
    }
    this.f = true;
    t();
    n();
    if (getEvent() != null)
    {
      getEvent().post(new FirstFrameEvent());
      getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.FIRST_FRAME_READY));
    }
    this.g = false;
  }
  
  private void n()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine;
    if ((localObject != null) && (((RoomEngine)localObject).getEnginLogic() != null) && (this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().watchMediaInfo;
    }
    else if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null))
    {
      localObject = new LiveWatchMediaInfo();
      ((LiveWatchMediaInfo)localObject).first_play_url = this.roomBizContext.getEnterRoomInfo().preVideoUrl;
    }
    else
    {
      localObject = null;
    }
    if (localObject != null) {
      a((LiveWatchMediaInfo)localObject);
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerStatusListener(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomBizmoduleAVPreloadPlayerModule$PreloadPlayerStatusListener);
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.setPlayerStatusListener(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomBizmoduleAVPreloadPlayerModule$DefaultPlayerStatusListener);
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportSwitchStartPlay();
    if (this.p) {
      u();
    }
    if (this.f)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportFirstFrame();
        return;
      }
      this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportSwitchFirstFrame();
    }
  }
  
  private void s()
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportStartPlay();
      return;
    }
    r();
  }
  
  private void t()
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
  
  private void u()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportFistPreloadFrame();
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkQualityreportservice_interfaceAudQualityServiceInterface.reportSwitchFistPreloadFrame();
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStart(paramLifecycleOwner);
    paramLifecycleOwner = getLog();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Player -- onActivityStart this = ");
    localStringBuilder.append(this);
    localStringBuilder.append(" isPaused = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPaused());
    localStringBuilder.append(" isNativePageDeactive = ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" mIsStopByonPause = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" isNativePageStop = ");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" isPlaying = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying());
    paramLifecycleOwner.i(str, localStringBuilder.toString(), new Object[0]);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface == null) {
      return;
    }
    if (!this.isUserVisibleHint) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (((this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.isLiteSdk()) && (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying()) && (!this.r) && (this.q)) || ((this.r) && (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPaused())))
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- litesdk -- onStart", new Object[0]);
      return;
    }
    if (this.e) {
      o();
    } else if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPaused()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.resumePlay();
    }
    this.e = false;
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
    paramLifecycleOwner = getLog();
    String str = this.jdField_a_of_type_JavaLangString;
    boolean bool = false;
    paramLifecycleOwner.i(str, "Player -- onActivityStop", new Object[0]);
    if (!this.isUserVisibleHint) {
      return;
    }
    this.e = false;
    paramLifecycleOwner = getLog();
    str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Player -- onActivityStop mIsStopByonPause = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" isNativePageStop = ");
    localStringBuilder.append(this.r);
    paramLifecycleOwner.i(str, localStringBuilder.toString(), new Object[0]);
    if ((this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.isLiteSdk()) && (!this.q))
    {
      getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- litesdk -- onstop not pause", new Object[0]);
      return;
    }
    if (((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface() != null) {
      bool = ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isBackgroundPlay();
    }
    if ((this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying()) && (!bool) && (!b()))
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.pausePlay();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 8000L);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    a();
    b();
    c();
    getEvent().observe(FloatWindowStateEvent.class, new AVPreloadPlayerModule.3(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onDestroy", new Object[0]);
    Object localObject = this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface;
    if ((localObject != null) && (!this.h))
    {
      ((AVPlayerBuilderServiceInterface)localObject).setPlayerStatusListener(null);
      localObject = getLog();
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Player -- onDestroy--isPlaying:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying());
      ((LogInterface)localObject).i(str, localStringBuilder.toString(), new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.uninit();
      this.h = true;
    }
    localObject = this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine;
    if (localObject != null) {
      ((UserEngine)localObject).removeUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    this.e = false;
    this.g = true;
    this.k = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.q = false;
    this.r = false;
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onDestroy end", new Object[0]);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine = getRoomEngine();
    i();
    LiveWatchMediaInfo localLiveWatchMediaInfo = this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getEnginLogic().getLiveInfo().watchMediaInfo;
    LogInterface localLogInterface = getLog();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initRoomPlayer -- onEnterRoom--isPlayedVideo=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(";forceSwitch=");
    localStringBuilder.append(localLiveWatchMediaInfo.forceSwitch);
    localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
    if ((this.d) && (!localLiveWatchMediaInfo.forceSwitch))
    {
      b(localLiveWatchMediaInfo);
      return;
    }
    getLog().i(this.jdField_a_of_type_JavaLangString, "initRoomPlayer -- onEnterRoom", new Object[0]);
    if (this.j)
    {
      k();
      return;
    }
    if (this.k)
    {
      l();
      return;
    }
    a(localLiveWatchMediaInfo);
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    if (PreloadUtil.a()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.reportPreloadData(this.jdField_c_of_type_Boolean ^ true);
    }
  }
  
  public void onExtActive()
  {
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onExtActive", new Object[0]);
    this.q = false;
    onActivityStart(this.mLifecycleOwner);
  }
  
  public void onExtDeActive()
  {
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onExtDeActive", new Object[0]);
    this.q = true;
    onActivityStop(this.mLifecycleOwner);
  }
  
  public void onExtOnStart()
  {
    this.r = false;
  }
  
  public void onExtOnStop()
  {
    this.r = true;
  }
  
  public void onPlayOver()
  {
    super.onPlayOver();
    getLog().i(this.jdField_a_of_type_JavaLangString, "Player -- onPlayOver", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isPlaying()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.pausePlay();
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.jdField_c_of_type_Boolean = false;
    this.isUserVisibleHint = true;
    Object localObject = (AVPlayerBuilderServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(AVPlayerBuilderServiceInterface.class);
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface != localObject)
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface = null;
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface = ((AVPlayerBuilderServiceInterface)localObject);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.init(this.context.getApplicationContext(), this.jdField_a_of_type_AndroidWidgetFrameLayout);
      f();
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playerservice rebuild -- onSwitchRoom avPlayerService=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface);
      Log.d((String)localObject, localStringBuilder.toString());
    }
    if (this.j)
    {
      k();
      return;
    }
    if (this.k)
    {
      l();
      return;
    }
    a(paramSwitchRoomInfo);
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    LogInterface localLogInterface = getLog();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Player -- onSwitchScreen--isUserVisibleHint=");
    localStringBuilder.append(this.isUserVisibleHint);
    localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
    super.onSwitchScreen(paramBoolean);
    if (!this.isUserVisibleHint) {
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.onScreenOrientationChange(paramBoolean);
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if (!paramBoolean)
    {
      AVPlayerBuilderServiceInterface localAVPlayerBuilderServiceInterface = this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface;
      if ((localAVPlayerBuilderServiceInterface != null) && (localAVPlayerBuilderServiceInterface.isPlaying()))
      {
        getLog().i(this.jdField_a_of_type_JavaLangString, "setUserVisibleHint -- pausePlay", new Object[0]);
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.pausePlay();
        j();
        this.j = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule
 * JD-Core Version:    0.7.0.1
 */