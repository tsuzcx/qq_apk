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
  private boolean A = false;
  private int B = -1;
  private boolean C = false;
  private AVPreloadPlayerModule.DefaultPlayerStatusListener D = new AVPreloadPlayerModule.DefaultPlayerStatusListener(this);
  private AVPreloadPlayerModule.PreloadPlayerStatusListener E = new AVPreloadPlayerModule.PreloadPlayerStatusListener(this);
  private int F;
  private boolean G = false;
  private boolean H = false;
  private boolean I = false;
  UserInitStateCallback a = new AVPreloadPlayerModule.1(this);
  @SuppressLint({"HandlerLeak"})
  Handler b = new AVPreloadPlayerModule.2(this);
  boolean c = false;
  boolean d = false;
  private String e = "AVPreloadPlayerModule";
  private AppGeneralInfoService f;
  private AVPlayerBuilderServiceInterface g;
  private ToastInterface h;
  private FrameLayout i;
  private ImageView j;
  private ImageView k;
  private UserEngine l;
  private RoomEngine m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r = true;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private AudQualityServiceInterface w;
  private boolean x = false;
  private boolean y = false;
  private int z = -1;
  
  private void a()
  {
    this.l = BizEngineMgr.getInstance().getUserEngine();
    this.m = getRoomEngine();
    this.h = ((ToastInterface)this.m.getService(ToastInterface.class));
    this.n = true;
    this.f = ((AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class));
    this.w = ((QualityReportServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(QualityReportServiceInterface.class)).getAudQualityReporter();
    int i2 = this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("||");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append("||");
    ((StringBuilder)localObject).append(i2);
    this.e = ((StringBuilder)localObject).toString();
    int i1;
    if (getAudienceRoomPager() != null) {
      i1 = getAudienceRoomPager().getCurrentIndex();
    } else {
      i1 = 0;
    }
    this.F = this.roomBizContext.getEnterRoomInfo().videoType;
    localObject = getLog();
    String str = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate--selfRoomIndex=");
    localStringBuilder.append(i2);
    localStringBuilder.append(";pagerCurrentIndex=");
    localStringBuilder.append(i1);
    localStringBuilder.append(";mVideoType=");
    localStringBuilder.append(this.F);
    ((LogInterface)localObject).i(str, localStringBuilder.toString(), new Object[0]);
  }
  
  private void a(int paramInt)
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.n)
    {
      this.w.reportPlayFail(paramInt);
      return;
    }
    this.w.reportSwitchPlayFail(paramInt);
  }
  
  private void a(AVPreloadPlayerModule.StartPlayType paramStartPlayType)
  {
    if (paramStartPlayType == AVPreloadPlayerModule.StartPlayType.SURFACE_CREATE) {
      this.c = true;
    } else if (paramStartPlayType == AVPreloadPlayerModule.StartPlayType.READY_PLAY) {
      this.d = true;
    }
    paramStartPlayType = getLog();
    String str = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("realStartPlay--surfacePlay=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(";readyPlay=");
    localStringBuilder.append(this.d);
    paramStartPlayType.i(str, localStringBuilder.toString(), new Object[0]);
    if ((this.c) && (this.d)) {
      this.g.startPlay();
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
      this.g.stopPlay();
      this.g.resetPlayer();
      this.b.removeCallbacksAndMessages(null);
      this.g.setPlayerStatusListener(null);
      return;
    }
    paramPlayerParams.url = paramLiveWatchMediaInfo.mUrl;
    paramPlayerParams.url_high = paramLiveWatchMediaInfo.mUrlHigh;
    paramPlayerParams.url_low = paramLiveWatchMediaInfo.mUrlLow;
  }
  
  private void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    Object localObject = getLog();
    String str = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preShowRoomCover  taskId=");
    localStringBuilder.append(paramAVPreloadTaskInterface.r());
    ((LogInterface)localObject).i(str, localStringBuilder.toString(), new Object[0]);
    if (paramAVPreloadTaskInterface.y())
    {
      this.j.setImageBitmap(null);
      this.j.setBackgroundColor(this.context.getResources().getColor(2131165564));
      this.k.setImageBitmap(paramAVPreloadTaskInterface.x());
      this.k.setVisibility(0);
      paramAVPreloadTaskInterface.c(true);
      int i1 = paramAVPreloadTaskInterface.x().getWidth();
      int i2 = paramAVPreloadTaskInterface.x().getHeight();
      localObject = (FrameLayout.LayoutParams)this.k.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = UIUtil.getScreenWidth(this.context);
      if (i1 > 0) {
        ((FrameLayout.LayoutParams)localObject).height = (((FrameLayout.LayoutParams)localObject).width * i2 / i1);
      }
      ((FrameLayout.LayoutParams)localObject).setMargins(0, paramAVPreloadTaskInterface.z(), 0, 0);
    }
    else
    {
      this.j.setImageBitmap(paramAVPreloadTaskInterface.x());
      localObject = this.k;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      paramAVPreloadTaskInterface.c(true);
    }
    paramAVPreloadTaskInterface.f(System.nanoTime() / 1000L);
    paramAVPreloadTaskInterface.g(paramAVPreloadTaskInterface.h() - paramAVPreloadTaskInterface.g());
  }
  
  private void a(LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    getLog().i("AudienceTime", "Player -- start playvideo", new Object[0]);
    if (!this.o) {
      u();
    }
    this.o = true;
    PlayerParams localPlayerParams = new PlayerParams();
    a(localPlayerParams, paramLiveWatchMediaInfo);
    b(localPlayerParams, paramLiveWatchMediaInfo);
    if (TextUtils.isEmpty(localPlayerParams.url))
    {
      getLog().i(this.e, "播放地址 url is null...", new Object[0]);
      return;
    }
    localPlayerParams.videoType = this.F;
    this.g.setParams(localPlayerParams);
    if (paramLiveWatchMediaInfo.isPreload)
    {
      if (this.g.isUseLocalServerPreload())
      {
        i();
        return;
      }
      h();
      return;
    }
    s();
    this.g.setPlayerSurface();
    this.g.preparePlay();
  }
  
  private void a(SwitchRoomInfo paramSwitchRoomInfo)
  {
    if (!TextUtils.isEmpty(paramSwitchRoomInfo.videoUrl))
    {
      Object localObject = getLog();
      String str = this.e;
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
      this.B = paramSwitchRoomInfo.videoLevel;
      this.C = paramSwitchRoomInfo.videoIsOrigin;
      a((LiveWatchMediaInfo)localObject);
    }
    t();
  }
  
  private void b()
  {
    this.j = ((ImageView)getRootView().findViewById(2131435351));
    this.k = ((ImageView)getRootView().findViewById(2131435352));
    if (c()) {
      return;
    }
    Object localObject = this.roomBizContext.getEnterRoomInfo().coverBitmapBytes;
    if (localObject != null)
    {
      getLog().i(this.e, "bitmap_cover != null", new Object[0]);
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      this.j.setImageBitmap((Bitmap)localObject);
    }
    else
    {
      this.j.setImageResource(2130841244);
    }
    this.j.setVisibility(0);
  }
  
  private void b(PlayerParams paramPlayerParams, LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    ServiceFrameInfo localServiceFrameInfo = new ServiceFrameInfo();
    localServiceFrameInfo.level = paramLiveWatchMediaInfo.mLevel;
    ServiceAddressInfo localServiceAddressInfo = new ServiceAddressInfo();
    localServiceAddressInfo.url = paramPlayerParams.url;
    localServiceFrameInfo.addresses.add(localServiceAddressInfo);
    paramPlayerParams.sig = paramLiveWatchMediaInfo.sig;
    paramLiveWatchMediaInfo = this.m;
    if ((paramLiveWatchMediaInfo != null) && (paramLiveWatchMediaInfo.getEnginLogic() != null) && (this.m.getEnginLogic().getLiveInfo() != null))
    {
      paramPlayerParams.anchorUin = this.m.getEnginLogic().getLiveInfo().anchorInfo.uid;
      paramPlayerParams.roomId = this.m.getEnginLogic().getLiveInfo().roomInfo.roomId;
      paramPlayerParams.roomType = this.m.getEnginLogic().getLiveInfo().roomInfo.roomType;
      this.m.getEnginLogic().getLiveInfo().watchMediaInfo.curServiceFrameInfo = localServiceFrameInfo;
    }
  }
  
  private void b(LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    int i1 = this.z;
    if (i1 > 0)
    {
      paramLiveWatchMediaInfo.mLevel = i1;
      boolean bool = this.A;
      paramLiveWatchMediaInfo.isOriginStream = bool;
      paramLiveWatchMediaInfo.firstPlayLevel = i1;
      paramLiveWatchMediaInfo.firstPlayIsOrigin = bool;
    }
  }
  
  private boolean c()
  {
    Object localObject = this.roomBizContext.getEnterRoomInfo().preVideoUrl;
    if ((PreloadUtil.a((String)localObject, this.F)) && (this.isUserVisibleHint))
    {
      localObject = ((AVPreloadServiceInterface)this.l.getService(AVPreloadServiceInterface.class)).j((String)localObject);
      if ((localObject != null) && (((AVPreloadTaskInterface)localObject).x() != null))
      {
        ((AVPreloadTaskInterface)localObject).e(System.nanoTime() / 1000L);
        a((AVPreloadTaskInterface)localObject);
        this.j.setVisibility(0);
        w();
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    getLog().i("AudienceTime", "Player -- initRoomPlayer", new Object[0]);
    this.r = true;
    e();
    this.g = ((AVPlayerBuilderServiceInterface)this.m.getService(AVPlayerBuilderServiceInterface.class));
    this.g.init(this.context.getApplicationContext(), this.i);
    g();
    f();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void e()
  {
    this.i = ((FrameLayout)getRootView().findViewById(2131435353));
    this.i.setOnTouchListener(new AVPreloadPlayerModule.4(this));
  }
  
  private void f()
  {
    int i1 = ((Activity)this.context).getIntent().getIntExtra("video_level", -1);
    boolean bool = ((Activity)this.context).getIntent().getBooleanExtra("video_is_origin", false);
    if (!TextUtils.isEmpty(this.roomBizContext.getEnterRoomInfo().preVideoUrl))
    {
      Object localObject = getLog();
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initRoomPlayer --not first start play--preVideoUrl=");
      localStringBuilder.append(this.roomBizContext.getEnterRoomInfo().preVideoUrl);
      ((LogInterface)localObject).i(str, localStringBuilder.toString(), new Object[0]);
      localObject = new LiveWatchMediaInfo();
      ((LiveWatchMediaInfo)localObject).first_play_url = this.roomBizContext.getEnterRoomInfo().preVideoUrl;
      ((LiveWatchMediaInfo)localObject).mLevel = i1;
      ((LiveWatchMediaInfo)localObject).isOriginStream = bool;
      ((LiveWatchMediaInfo)localObject).isPreload = (this.isUserVisibleHint ^ true);
      this.z = i1;
      this.A = bool;
      a((LiveWatchMediaInfo)localObject);
    }
  }
  
  private void g()
  {
    if (this.l.avInitSuccess())
    {
      this.g.onLoginEvent(3, "");
      return;
    }
    this.l.addUserInitCallback(this.a);
    if (this.l.loginSuccess())
    {
      this.g.onLoginEvent(1, "");
      return;
    }
    getLog().i(this.e, "initRoomPlayer -- 等待登录 ", new Object[0]);
  }
  
  private void h()
  {
    r();
    this.g.setPlayerSurface();
    this.g.preparePlay();
  }
  
  private void i()
  {
    s();
    this.g.preload();
  }
  
  private void j()
  {
    RoomEngine localRoomEngine = this.m;
    if ((localRoomEngine != null) && (localRoomEngine.getEnginLogic() != null) && (this.m.getEnginLogic().getLiveInfo() != null) && (this.m.getEnginLogic().getLiveInfo().watchMediaInfo != null))
    {
      boolean bool;
      if (this.m.getEnginLogic().getLiveInfo().watchMediaInfo.mVideoStatus == LiveVideoStatus.Pause) {
        bool = true;
      } else {
        bool = false;
      }
      this.t = bool;
    }
  }
  
  private void k()
  {
    this.b.removeCallbacksAndMessages(null);
    this.g.setPlayerStatusListener(null);
    this.o = false;
  }
  
  private void l()
  {
    ImageView localImageView = this.j;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    s();
    if (this.g.isPlaying())
    {
      getLog().i(this.e, "onSwitchResumePlay -- resumePlay", new Object[0]);
      this.g.resumePlay();
    }
    else
    {
      getLog().i(this.e, "onSwitchResumePlay -- startPlay", new Object[0]);
      this.g.startPlay();
    }
    this.u = false;
    this.o = true;
    t();
  }
  
  private void m()
  {
    s();
    getLog().i(this.e, "onSwitchPreloadedStartPlay -- startPlay", new Object[0]);
    this.g.startPlay();
    t();
  }
  
  private void n()
  {
    if (this.s)
    {
      getLog().e(this.e, "Player -- onFirstFrameCome but isPageExit", new Object[0]);
      return;
    }
    if (getEvent() != null) {
      getEvent().post(new LiveStateEvent(LiveStateEvent.LiveState.STOP_BUFFER));
    }
    LogInterface localLogInterface = getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Player -- onFirstFrameCome--canPostFirstFrameEvent=");
    localStringBuilder.append(this.r);
    localLogInterface.i("AudienceTime", localStringBuilder.toString(), new Object[0]);
    if (!this.r) {
      return;
    }
    this.q = true;
    v();
    o();
    if (getEvent() != null)
    {
      getEvent().post(new FirstFrameEvent());
      getEvent().post(new PlayerStateEvent(PlayerStateEvent.PlayerState.FIRST_FRAME_READY));
    }
    this.r = false;
  }
  
  private void o()
  {
    ImageView localImageView = this.j;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    localImageView = this.k;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  private void p()
  {
    Object localObject = this.m;
    if ((localObject != null) && (((RoomEngine)localObject).getEnginLogic() != null) && (this.m.getEnginLogic().getLiveInfo() != null))
    {
      localObject = this.m.getEnginLogic().getLiveInfo().watchMediaInfo;
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
  
  private boolean q()
  {
    FloatWindowConfigServiceInterface localFloatWindowConfigServiceInterface = (FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class);
    FloatWindowPermissionInterface localFloatWindowPermissionInterface = (FloatWindowPermissionInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowPermissionInterface.class);
    return ((localFloatWindowConfigServiceInterface.getFloatWindowEnabledAllTime()) || (localFloatWindowConfigServiceInterface.getFloatWindowEnabledOnce())) && (localFloatWindowPermissionInterface.hasFWPermission());
  }
  
  private void r()
  {
    this.g.setPlayerStatusListener(this.E);
  }
  
  private void s()
  {
    this.g.setPlayerStatusListener(this.D);
  }
  
  private void t()
  {
    this.w.reportSwitchStartPlay();
    if (this.G) {
      w();
    }
    if (this.q)
    {
      if (this.n)
      {
        this.w.reportFirstFrame();
        return;
      }
      this.w.reportSwitchFirstFrame();
    }
  }
  
  private void u()
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.n)
    {
      this.w.reportStartPlay();
      return;
    }
    t();
  }
  
  private void v()
  {
    if (!this.isUserVisibleHint) {
      return;
    }
    if (this.n)
    {
      this.w.reportFirstFrame();
      return;
    }
    this.w.reportSwitchFirstFrame();
  }
  
  private void w()
  {
    if (this.n)
    {
      this.w.reportFistPreloadFrame();
      return;
    }
    this.w.reportSwitchFistPreloadFrame();
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStart(paramLifecycleOwner);
    paramLifecycleOwner = getLog();
    String str = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Player -- onActivityStart this = ");
    localStringBuilder.append(this);
    localStringBuilder.append(" isPaused = ");
    localStringBuilder.append(this.g.isPaused());
    localStringBuilder.append(" isNativePageDeactive = ");
    localStringBuilder.append(this.H);
    localStringBuilder.append(" mIsStopByonPause = ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" isNativePageStop = ");
    localStringBuilder.append(this.I);
    localStringBuilder.append(" isPlaying = ");
    localStringBuilder.append(this.g.isPlaying());
    paramLifecycleOwner.i(str, localStringBuilder.toString(), new Object[0]);
    if (this.g == null) {
      return;
    }
    if (!this.isUserVisibleHint) {
      return;
    }
    this.b.removeCallbacksAndMessages(null);
    if (((this.f.isLiteSdk()) && (this.g.isPlaying()) && (!this.I) && (this.H)) || ((this.I) && (this.g.isPaused())))
    {
      getLog().i(this.e, "Player -- litesdk -- onStart", new Object[0]);
      return;
    }
    if (this.p) {
      p();
    } else if (this.g.isPaused()) {
      this.g.resumePlay();
    }
    this.p = false;
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
    paramLifecycleOwner = getLog();
    String str = this.e;
    boolean bool = false;
    paramLifecycleOwner.i(str, "Player -- onActivityStop", new Object[0]);
    if (!this.isUserVisibleHint) {
      return;
    }
    this.p = false;
    paramLifecycleOwner = getLog();
    str = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Player -- onActivityStop mIsStopByonPause = ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" isNativePageStop = ");
    localStringBuilder.append(this.I);
    paramLifecycleOwner.i(str, localStringBuilder.toString(), new Object[0]);
    if ((this.f.isLiteSdk()) && (!this.H))
    {
      getLog().i(this.e, "Player -- litesdk -- onstop not pause", new Object[0]);
      return;
    }
    if (((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface() != null) {
      bool = ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isBackgroundPlay();
    }
    if ((this.g.isPlaying()) && (!bool) && (!q()))
    {
      this.g.pausePlay();
      this.b.removeCallbacksAndMessages(null);
      this.b.sendEmptyMessageDelayed(100, 8000L);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    a();
    b();
    d();
    getEvent().observe(FloatWindowStateEvent.class, new AVPreloadPlayerModule.3(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getLog().i(this.e, "Player -- onDestroy", new Object[0]);
    Object localObject = this.g;
    if ((localObject != null) && (!this.s))
    {
      ((AVPlayerBuilderServiceInterface)localObject).setPlayerStatusListener(null);
      localObject = getLog();
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Player -- onDestroy--isPlaying:");
      localStringBuilder.append(this.g.isPlaying());
      ((LogInterface)localObject).i(str, localStringBuilder.toString(), new Object[0]);
      this.g.uninit();
      this.s = true;
    }
    localObject = this.l;
    if (localObject != null) {
      ((UserEngine)localObject).removeUserInitCallback(this.a);
    }
    localObject = this.b;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.j;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.k;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    this.p = false;
    this.r = true;
    this.v = false;
    this.c = false;
    this.d = false;
    this.H = false;
    this.I = false;
    getLog().i(this.e, "Player -- onDestroy end", new Object[0]);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.n = paramBoolean;
    this.m = getRoomEngine();
    j();
    LiveWatchMediaInfo localLiveWatchMediaInfo = this.m.getEnginLogic().getLiveInfo().watchMediaInfo;
    LogInterface localLogInterface = getLog();
    String str = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initRoomPlayer -- onEnterRoom--isPlayedVideo=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(";forceSwitch=");
    localStringBuilder.append(localLiveWatchMediaInfo.forceSwitch);
    localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
    if ((this.o) && (!localLiveWatchMediaInfo.forceSwitch))
    {
      b(localLiveWatchMediaInfo);
      return;
    }
    getLog().i(this.e, "initRoomPlayer -- onEnterRoom", new Object[0]);
    if (this.u)
    {
      l();
      return;
    }
    if (this.v)
    {
      m();
      return;
    }
    a(localLiveWatchMediaInfo);
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    if (PreloadUtil.a()) {
      this.g.reportPreloadData(this.n ^ true);
    }
  }
  
  public void onExtActive()
  {
    getLog().i(this.e, "Player -- onExtActive", new Object[0]);
    this.H = false;
    onActivityStart(this.mLifecycleOwner);
  }
  
  public void onExtDeActive()
  {
    getLog().i(this.e, "Player -- onExtDeActive", new Object[0]);
    this.H = true;
    onActivityStop(this.mLifecycleOwner);
  }
  
  public void onExtOnStart()
  {
    this.I = false;
  }
  
  public void onExtOnStop()
  {
    this.I = true;
  }
  
  public void onPlayOver()
  {
    super.onPlayOver();
    getLog().i(this.e, "Player -- onPlayOver", new Object[0]);
    if (this.g.isPlaying()) {
      this.g.pausePlay();
    }
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.n = false;
    this.isUserVisibleHint = true;
    Object localObject = (AVPlayerBuilderServiceInterface)this.m.getService(AVPlayerBuilderServiceInterface.class);
    if (this.g != localObject)
    {
      this.g = null;
      this.g = ((AVPlayerBuilderServiceInterface)localObject);
      this.g.init(this.context.getApplicationContext(), this.i);
      g();
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playerservice rebuild -- onSwitchRoom avPlayerService=");
      localStringBuilder.append(this.g);
      Log.d((String)localObject, localStringBuilder.toString());
    }
    if (this.u)
    {
      l();
      return;
    }
    if (this.v)
    {
      m();
      return;
    }
    a(paramSwitchRoomInfo);
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    LogInterface localLogInterface = getLog();
    String str = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Player -- onSwitchScreen--isUserVisibleHint=");
    localStringBuilder.append(this.isUserVisibleHint);
    localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
    super.onSwitchScreen(paramBoolean);
    if (!this.isUserVisibleHint) {
      return;
    }
    this.g.onScreenOrientationChange(paramBoolean);
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if (!paramBoolean)
    {
      AVPlayerBuilderServiceInterface localAVPlayerBuilderServiceInterface = this.g;
      if ((localAVPlayerBuilderServiceInterface != null) && (localAVPlayerBuilderServiceInterface.isPlaying()))
      {
        getLog().i(this.e, "setUserVisibleHint -- pausePlay", new Object[0]);
        this.g.pausePlay();
        k();
        this.u = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule
 * JD-Core Version:    0.7.0.1
 */