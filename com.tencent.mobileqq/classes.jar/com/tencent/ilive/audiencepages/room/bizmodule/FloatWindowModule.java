package com.tencent.ilive.audiencepages.room.bizmodule;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.base.floatwindow.permission.FWPermission;
import com.tencent.falco.base.floatwindow.utils.DisplayUtils;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.activitylife.AppStatusListener;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.network.OnNetworkListener;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.audiencepages.room.events.KickedOutEvent;
import com.tencent.ilive.audiencepages.room.events.PlayerCatonEvent;
import com.tencent.ilive.audiencepages.room.events.ShowAnchorStateEvent;
import com.tencent.ilive.base.component.ComponentFactory;
import com.tencent.ilive.base.component.ComponentFactory.ComponentsBuilder;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.events.PlayOverEvent;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.FloatRoomManager.RelateRoomControl;
import com.tencent.livesdk.liveengine.FloatRoomManager.RoomEventInterceptor;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.lang.reflect.Method;

public abstract class FloatWindowModule
  extends RoomBizModule
  implements ThreadCenter.HandlerKeyable
{
  private static final int BACK_TO_ROOM_TIME_OUT = 5000;
  private static final int ILLEGAL_ROOM_ID = -1;
  private static final String TAG = "FloatWindowModule";
  private AppStatusListener appStatusListener;
  private AVPlayerBuilderServiceInterface avPlayerService;
  protected FloatWindowComponent floatWindowComponent;
  private FloatWindowConfigServiceInterface floatWindowConfigService;
  private boolean isActivityResumed = false;
  private boolean isAppInBackground = false;
  private boolean isExitRoomForbidShow = false;
  private boolean isFloatWindowShow = false;
  private boolean isNativePageDeactive = false;
  private boolean isPlayOver = false;
  private boolean isShowInBackground = false;
  private Runnable mLaunchFailNotice = new FloatWindowModule.3(this);
  private Runnable mLaunchFailNoticeForXiaomi = new FloatWindowModule.2(this);
  private SwitchRoomInfo mSwitchRoomInfo;
  private int mVideoType;
  private NetworkStateInterface networkService;
  private LinearLayout noticeLayout;
  private TextView noticeText;
  private OnNetworkListener onNetworkListener = new FloatWindowModule.1(this);
  private boolean requestPermission;
  protected FloatRoomManager.RelateRoomControl roomControl;
  protected RoomEngine roomEngine;
  private FloatRoomManager.RoomEventInterceptor roomEventInterceptor;
  private ImageView typeImage;
  private FrameLayout videoView;
  
  public static boolean canBackgroundStart(Context paramContext)
  {
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    boolean bool = false;
    try
    {
      int i = ((Integer)localAppOpsManager.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(10021), Integer.valueOf(Process.myUid()), paramContext.getPackageName() })).intValue();
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      Log.e("FloatWindowModule", "not support", paramContext);
    }
    return false;
  }
  
  private void delayHideNotice()
  {
    ThreadCenter.postDelayedUITask(this, new FloatWindowModule.12(this), 5000L);
  }
  
  private FloatWindowModule.FWCloseType getCloseReportType(int paramInt)
  {
    if (paramInt != 5)
    {
      if (paramInt != 6)
      {
        if (paramInt != 9) {
          return FloatWindowModule.FWCloseType.TYPE_OTHER;
        }
        return FloatWindowModule.FWCloseType.TYPE_BTN_CLOSE;
      }
      return FloatWindowModule.FWCloseType.TYPE_ANCHOR_CLOSE;
    }
    return FloatWindowModule.FWCloseType.TYPE_KICK_OUT;
  }
  
  private int getLayoutResId()
  {
    if (isLandscape()) {
      return 2131559232;
    }
    return 2131559231;
  }
  
  private void handlePlayStatusActivityStart()
  {
    LogInterface localLogInterface = getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handlePlayStatusActivityStart, isFloatWindowShow=");
    localStringBuilder.append(this.isFloatWindowShow);
    localLogInterface.i("FloatWindowModule", localStringBuilder.toString(), new Object[0]);
    if (this.isFloatWindowShow)
    {
      this.floatWindowComponent.dismiss(3);
      this.isFloatWindowShow = false;
    }
  }
  
  private void handlePlayStatusOnActivityStop()
  {
    if ((this.isUserVisibleHint) && (!this.isPlayOver) && (this.avPlayerService.isPlaying()))
    {
      if (this.isNativePageDeactive) {
        return;
      }
      if (!FWPermission.hasPermission(this.context))
      {
        getLog().i("FloatWindowModule", "handlePlayStatusOnActivityStop with out float window permission", new Object[0]);
        return;
      }
      if (this.isExitRoomForbidShow) {
        return;
      }
      boolean bool1 = isConfigNeedShowFloatPlayer();
      boolean bool2 = this.floatWindowConfigService.getFloatWindowEnabledOnce();
      boolean bool3 = this.floatWindowConfigService.getFloatWindowEnabledAllTime();
      int i = 1;
      if ((!bool1) || ((!bool3) && (!bool2))) {
        i = 0;
      }
      LogInterface localLogInterface = getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlePlayStatusOnActivityStop isAppInBackground=");
      localStringBuilder.append(this.isAppInBackground);
      localStringBuilder.append(" isShowInBackground=");
      localStringBuilder.append(this.isShowInBackground);
      localLogInterface.i("FloatWindowModule", localStringBuilder.toString(), new Object[0]);
      if (i != 0)
      {
        showFloatWindow();
        if (outRoomFloatWindow()) {
          BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager().c();
        }
      }
    }
  }
  
  private void initAppForegroundListener()
  {
    this.appStatusListener = new FloatWindowModule.8(this);
    ((ActivityLifeService)BizEngineMgr.getInstance().getLiveEngine().getService(ActivityLifeService.class)).addAppStatusListener(this.appStatusListener);
  }
  
  private void initFloatAdapter()
  {
    FloatWindowComponent localFloatWindowComponent = this.floatWindowComponent;
    if (localFloatWindowComponent == null) {
      return;
    }
    localFloatWindowComponent.init(this.context);
  }
  
  private void initFloatCallback()
  {
    FloatWindowComponent localFloatWindowComponent = this.floatWindowComponent;
    if (localFloatWindowComponent == null) {
      return;
    }
    localFloatWindowComponent.setHandleCallback(new FloatWindowModule.9(this));
  }
  
  private void initFloatPlayer()
  {
    if (!isConfigNeedShowFloatPlayer())
    {
      this.floatWindowComponent = null;
      return;
    }
    this.floatWindowComponent = ((FloatWindowComponent)getComponentFactory().getComponent(FloatWindowComponent.class).build());
    initFloatAdapter();
    initFloatCallback();
  }
  
  private void initFloatWindowViewOnInvoke(View paramView)
  {
    Object localObject = (FrameLayout)paramView.findViewById(2131366930);
    this.avPlayerService.readyPlay((FrameLayout)localObject, true);
    localObject = paramView.findViewById(2131366931);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new FloatWindowModule.10(this));
    }
    ((ImageView)paramView.findViewById(2131369440)).setOnClickListener(new FloatWindowModule.11(this));
    this.noticeLayout = ((LinearLayout)paramView.findViewById(2131366980));
    this.typeImage = ((ImageView)paramView.findViewById(2131369538));
    this.noticeText = ((TextView)paramView.findViewById(2131379776));
    this.noticeLayout.setVisibility(8);
  }
  
  private void initKickedOutEventListener()
  {
    getEvent().observe(KickedOutEvent.class, new FloatWindowModule.5(this));
  }
  
  private void initPlayCatonEventListener()
  {
    getEvent().observe(PlayerCatonEvent.class, new FloatWindowModule.7(this));
  }
  
  private void initPlayOverEventListener()
  {
    getEvent().observe(PlayOverEvent.class, new FloatWindowModule.6(this));
  }
  
  private void initShowAnchorStateEventListener()
  {
    getEvent().observe(ShowAnchorStateEvent.class, new FloatWindowModule.4(this));
  }
  
  private boolean isConfigNeedShowFloatPlayer()
  {
    Object localObject = (HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class);
    if (localObject == null) {
      return false;
    }
    localObject = ((HostProxyInterface)localObject).getSdkInfoInterface();
    if (localObject == null) {
      return false;
    }
    return ((SdkInfoInterface)localObject).isFloatWindowEnabled();
  }
  
  private boolean isLandscape()
  {
    AVPlayerBuilderServiceInterface localAVPlayerBuilderServiceInterface = (AVPlayerBuilderServiceInterface)this.roomEngine.getService(AVPlayerBuilderServiceInterface.class);
    return localAVPlayerBuilderServiceInterface.getVideoHeight() < localAVPlayerBuilderServiceInterface.getVideoWidth();
  }
  
  private boolean isXiaomi()
  {
    return Build.MANUFACTURER.equalsIgnoreCase("xiaomi");
  }
  
  private void mutePlayer(boolean paramBoolean)
  {
    if ((this.avPlayerService.isPlaying()) && (!this.avPlayerService.isPaused())) {
      this.avPlayerService.mutePlay(paramBoolean);
    }
  }
  
  private void popLoading(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.typeImage != null) && (this.noticeLayout != null) && (this.noticeText != null))
    {
      if (!this.floatWindowComponent.isCalledShow()) {
        return;
      }
      this.noticeLayout.setVisibility(0);
      this.typeImage.setImageResource(2130840470);
      this.noticeText.setText(paramString);
      delayHideNotice();
    }
  }
  
  private void popNotice(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.typeImage != null) && (this.noticeLayout != null) && (this.noticeText != null))
    {
      if (!this.floatWindowComponent.isCalledShow()) {
        return;
      }
      this.noticeLayout.setVisibility(0);
      this.typeImage.setImageResource(2130840471);
      this.noticeText.setText(paramString);
      delayHideNotice();
    }
  }
  
  private void reportFloatCloseEvent(FloatWindowModule.FWCloseType paramFWCloseType)
  {
    ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("narrow_window").setModuleDesc("观看端小窗").setActType("close").setActTypeDesc("消失").addKeyValue("zt_str1", String.valueOf(paramFWCloseType.type)).addKeyValue("timelong", SystemClock.uptimeMillis() - this.floatWindowComponent.getShowTime()).addKeyValue("zt_str6", this.mVideoType).send();
  }
  
  private void reportFloatDragEvent(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int n = DisplayUtils.rejectedNavHeight(this.context) / 3;
    int i1 = UIUtil.getScreenWidth(this.context) / 2;
    int i = 0;
    int m;
    for (int j = 1; i < 3; j = m)
    {
      int k = 0;
      float f1;
      float f2;
      do
      {
        m = j;
        if (k >= 2) {
          break;
        }
        f1 = k * i1;
        f2 = i * n;
        m = k + 1;
        k = m;
      } while (!new RectF(f1, f2, m * i1, (i + 1) * n).contains(arrayOfInt[0], arrayOfInt[1]));
      m = i * 2 + m;
      i += 1;
    }
    ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("narrow_window").setModuleDesc("观看端小窗").setActType("drag").setActTypeDesc("拖动").addKeyValue("zt_str1", String.valueOf(j)).addKeyValue("zt_str6", this.mVideoType).send();
  }
  
  private void reportFloatErrorEvent(int paramInt)
  {
    ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("narrow_window_warn").setModuleDesc("观看端小窗").setActType("view").setActTypeDesc("曝光").addKeyValue("zt_str1", String.valueOf(paramInt)).addKeyValue("zt_str6", this.mVideoType).send();
  }
  
  private void reportFloatShowEvent()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void reportPermissionResult()
  {
    if (this.requestPermission) {
      requestPermissionResult(((FloatWindowPermissionInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowPermissionInterface.class)).hasFWPermission());
    }
    this.requestPermission = false;
  }
  
  private void reportZoomResumeEvent()
  {
    ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("narrow_window").setModuleDesc("观看端小窗").setActType("click").setActTypeDesc("点击").addKeyValue("zt_str6", this.mVideoType).send();
  }
  
  private void requestPermissionResult(boolean paramBoolean)
  {
    Object localObject = (HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class);
    if (localObject == null) {
      return;
    }
    localObject = ((HostProxyInterface)localObject).getSdkInfoInterface();
    if (localObject == null) {
      return;
    }
    ((SdkInfoInterface)localObject).floatWindowPermissionRequestResult(paramBoolean);
  }
  
  private void showFloatWindow()
  {
    if (this.floatWindowComponent != null)
    {
      this.isFloatWindowShow = true;
      LogInterface localLogInterface = getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFloatWindowShow = true, FloatWindowModule = ");
      localStringBuilder.append(hashCode());
      localLogInterface.i("FloatWindowModule", localStringBuilder.toString(), new Object[0]);
      if ((this.isAppInBackground) && (!this.isShowInBackground)) {
        return;
      }
      this.floatWindowComponent.show(getLayoutResId());
    }
  }
  
  private void showIfNotCorrectStatus()
  {
    if ((!this.isActivityResumed) && (!this.isPlayOver) && (this.isFloatWindowShow) && (!this.isShowInBackground) && (!this.isAppInBackground))
    {
      FloatWindowComponent localFloatWindowComponent = this.floatWindowComponent;
      if ((localFloatWindowComponent != null) && (!localFloatWindowComponent.isReallyShow()))
      {
        getLog().i("FloatWindowModule", "showIfNotCorrectStatus", new Object[0]);
        this.floatWindowComponent.show(getLayoutResId());
      }
    }
  }
  
  private void takeOverRoomEvent()
  {
    this.roomEventInterceptor = new FloatWindowModule.13(this);
    BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager().a(this.roomEventInterceptor);
  }
  
  private void unInit()
  {
    this.networkService.removeListener(this.onNetworkListener);
    ThreadCenter.removeUITask(this, this.mLaunchFailNoticeForXiaomi);
    ThreadCenter.removeUITask(this, this.mLaunchFailNotice);
    if (this.appStatusListener != null) {
      ((ActivityLifeService)BizEngineMgr.getInstance().getLiveEngine().getService(ActivityLifeService.class)).removeAppStatusListener(this.appStatusListener);
    }
  }
  
  public void changeRenderContainerAndPlay(int paramInt)
  {
    AVPlayerBuilderServiceInterface localAVPlayerBuilderServiceInterface = this.avPlayerService;
    if (localAVPlayerBuilderServiceInterface == null) {
      return;
    }
    localAVPlayerBuilderServiceInterface.readyPlay(this.videoView, false);
    boolean bool = ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isBackgroundPlay();
    if (((!this.isAppInBackground) || (!bool)) && (paramInt != 3) && (paramInt != 8)) {
      this.avPlayerService.pausePlay();
    }
    getLog().i("FloatWindowModule", "changeRenderContainerAndPlay", new Object[0]);
  }
  
  protected abstract boolean isLinkMic();
  
  protected void jumpAudienceRoomActivity(Runnable paramRunnable)
  {
    if (this.context == null) {
      return;
    }
    Intent localIntent = getAudienceRoomPager().getIntent();
    localIntent.putExtra("open_from_float_window", true);
    this.context.startActivity(localIntent);
    paramRunnable.run();
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityPause(paramLifecycleOwner);
    this.isActivityResumed = false;
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    this.isActivityResumed = true;
    this.floatWindowConfigService.setFloatWindowEnabledOnce(false);
    this.isShowInBackground = ((HostProxyInterface)getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isFloatWindowShowWhenAppInBackground();
    boolean bool;
    if (getAudienceRoomPager() != null) {
      bool = getAudienceRoomPager().getIntent().getBooleanExtra("open_from_float_window", false);
    } else {
      bool = false;
    }
    if (bool)
    {
      getAudienceRoomPager().getIntent().removeExtra("open_from_float_window");
      reportZoomResumeEvent();
    }
    mutePlayer(false);
    reportPermissionResult();
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.roomEngine = getRoomEngine();
    this.avPlayerService = ((AVPlayerBuilderServiceInterface)this.roomEngine.getService(AVPlayerBuilderServiceInterface.class));
    this.networkService = ((NetworkStateInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NetworkStateInterface.class));
    this.floatWindowConfigService = ((FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class));
    this.videoView = ((FrameLayout)getRootView().findViewById(2131368457));
    initFloatPlayer();
    this.mVideoType = this.roomBizContext.getEnterRoomInfo().videoType;
    if (this.mVideoType == VideoType.VIDEO.ordinal())
    {
      this.mVideoType = VideoType.VIDEO.ordinal();
      return;
    }
    this.mVideoType = VideoType.LIVE.ordinal();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unInit();
    FloatWindowComponent localFloatWindowComponent = this.floatWindowComponent;
    if ((localFloatWindowComponent != null) && (localFloatWindowComponent.isCalledShow()))
    {
      this.floatWindowComponent.dismiss(7);
      BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager().e();
    }
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.roomEngine = getRoomEngine();
    this.networkService.addListener(this.onNetworkListener);
  }
  
  public void onExtActive()
  {
    super.onExtActive();
    this.isNativePageDeactive = false;
    onActivityStart(this.mLifecycleOwner);
  }
  
  public void onExtDeActive()
  {
    super.onExtDeActive();
    this.isNativePageDeactive = true;
    onActivityStop(this.mLifecycleOwner);
  }
  
  protected void onInitComponentEvent()
  {
    super.onInitComponentEvent();
    initShowAnchorStateEventListener();
    initKickedOutEventListener();
    initPlayOverEventListener();
    initPlayCatonEventListener();
    initAppForegroundListener();
  }
  
  public void onPlayOver()
  {
    this.isPlayOver = true;
  }
  
  public void onRealActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    super.onRealActivityStart(paramLifecycleOwner);
    if (!this.isUserVisibleHint) {
      return;
    }
    handlePlayStatusActivityStart();
  }
  
  public void onRealActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onRealActivityStop(paramLifecycleOwner);
    if (!this.isUserVisibleHint) {
      return;
    }
    handlePlayStatusOnActivityStop();
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.mSwitchRoomInfo = paramSwitchRoomInfo;
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if (!paramBoolean)
    {
      ThreadCenter.removeUITask(this, this.mLaunchFailNoticeForXiaomi);
      ThreadCenter.removeUITask(this, this.mLaunchFailNotice);
    }
    if (paramBoolean) {
      takeOverRoomEvent();
    }
  }
  
  protected boolean outRoomFloatWindow()
  {
    return ((Activity)this.context).isFinishing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule
 * JD-Core Version:    0.7.0.1
 */