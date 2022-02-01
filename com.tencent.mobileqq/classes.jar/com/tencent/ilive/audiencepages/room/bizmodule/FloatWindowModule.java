package com.tencent.ilive.audiencepages.room.bizmodule;

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
import com.tencent.falco.base.floatwindow.utils.DisplayUtils;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.activitylife.AppStatusListener;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
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
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.lang.reflect.Method;

public abstract class FloatWindowModule
  extends RoomBizModule
  implements ThreadCenter.HandlerKeyable
{
  private static final int BACK_TO_ROOM_TIME_OUT = 5000;
  private static final int FROM_ACTIVITY_DESTROY = 7;
  private static final int FROM_ANCHOR_CLOSE = 6;
  private static final int FROM_FLOAT_WINDOW_CLICK = 8;
  private static final int FROM_FLOAT_WINDOW_CLOSE_CLICK = 9;
  private static final int FROM_KICK_OUT = 5;
  private static final int FROM_RESUME = 3;
  private static final int FROM_SWITCH_BACKGROUND = 4;
  private static final int ILLEGAL_ROOM_ID = -1;
  private static final String TAG = "FloatWindowModule";
  private AppStatusListener appStatusListener;
  private AVPlayerBuilderServiceInterface avPlayerService;
  private FloatWindowComponent floatWindowComponent;
  private FloatWindowConfigServiceInterface floatWindowConfigService;
  private boolean isActivityResumed = false;
  private boolean isAppInBackground = false;
  private boolean isFloatWindowShow = false;
  private boolean isPlayOver = false;
  private boolean isShowInBackground = false;
  private Runnable mLaunchFailNotice = new FloatWindowModule.3(this);
  private Runnable mLaunchFailNoticeForXiaomi = new FloatWindowModule.2(this);
  private int mVideoType;
  private NetworkStateInterface networkService;
  private LinearLayout noticeLayout;
  private TextView noticeText;
  private OnNetworkListener onNetworkListener = new FloatWindowModule.1(this);
  protected RoomEngine roomEngine;
  private ImageView typeImage;
  private FrameLayout videoView;
  
  public static boolean canBackgroundStart(Context paramContext)
  {
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    try
    {
      int i = ((Integer)localAppOpsManager.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(10021), Integer.valueOf(Process.myUid()), paramContext.getPackageName() })).intValue();
      return i == 0;
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
    switch (paramInt)
    {
    case 7: 
    case 8: 
    default: 
      return FloatWindowModule.FWCloseType.TYPE_OTHER;
    case 5: 
      return FloatWindowModule.FWCloseType.TYPE_KICK_OUT;
    case 9: 
      return FloatWindowModule.FWCloseType.TYPE_BTN_CLOSE;
    }
    return FloatWindowModule.FWCloseType.TYPE_ANCHOR_CLOSE;
  }
  
  private int getLayoutResId()
  {
    if (isLandscape()) {
      return 2131559357;
    }
    return 2131559356;
  }
  
  private void handlePlayStatusActivityStart()
  {
    getLog().i("FloatWindowModule", "handlePlayStatusActivityStart, isFloatWindowShow=" + this.isFloatWindowShow, new Object[0]);
    if (this.isFloatWindowShow)
    {
      this.floatWindowComponent.dismiss(3);
      this.isFloatWindowShow = false;
    }
  }
  
  private void handlePlayStatusOnActivityStop()
  {
    int i = 1;
    if ((!this.isUserVisibleHint) || (this.isPlayOver) || (!this.avPlayerService.isPlaying())) {
      return;
    }
    boolean bool1 = isConfigNeedShowFloatPlayer();
    boolean bool2 = this.floatWindowConfigService.getFloatWindowEnabledOnce();
    boolean bool3 = this.floatWindowConfigService.getFloatWindowEnabledAllTime();
    if (bool1) {
      if (!bool3) {}
    }
    for (;;)
    {
      getLog().i("FloatWindowModule", "handlePlayStatusOnActivityStop isAppInBackground=" + this.isAppInBackground + " isShowInBackground=" + this.isShowInBackground, new Object[0]);
      if (i == 0) {
        break;
      }
      showFloatWindow();
      return;
      if (!bool2) {
        i = 0;
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
    if (this.floatWindowComponent == null) {
      return;
    }
    this.floatWindowComponent.init(this.context);
  }
  
  private void initFloatCallback()
  {
    if (this.floatWindowComponent == null) {
      return;
    }
    this.floatWindowComponent.setHandleCallback(new FloatWindowModule.9(this));
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
    FrameLayout localFrameLayout = (FrameLayout)paramView.findViewById(2131367090);
    this.avPlayerService.readyPlay(localFrameLayout, true);
    paramView.setOnClickListener(new FloatWindowModule.10(this));
    ((ImageView)paramView.findViewById(2131369749)).setOnClickListener(new FloatWindowModule.11(this));
    this.noticeLayout = ((LinearLayout)paramView.findViewById(2131367143));
    this.typeImage = ((ImageView)paramView.findViewById(2131369852));
    this.noticeText = ((TextView)paramView.findViewById(2131380465));
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
    if ((TextUtils.isEmpty(paramString)) || (this.typeImage == null) || (this.noticeLayout == null) || (this.noticeText == null) || (!this.floatWindowComponent.isCalledShow())) {
      return;
    }
    this.noticeLayout.setVisibility(0);
    this.typeImage.setImageResource(2130840597);
    this.noticeText.setText(paramString);
    delayHideNotice();
  }
  
  private void popNotice(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.typeImage == null) || (this.noticeLayout == null) || (this.noticeText == null) || (!this.floatWindowComponent.isCalledShow())) {
      return;
    }
    this.noticeLayout.setVisibility(0);
    this.typeImage.setImageResource(2130840598);
    this.noticeText.setText(paramString);
    delayHideNotice();
  }
  
  private void reportFloatCloseEvent(FloatWindowModule.FWCloseType paramFWCloseType)
  {
    ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("narrow_window").setModuleDesc("观看端小窗").setActType("close").setActTypeDesc("消失").addKeyValue("zt_str1", String.valueOf(paramFWCloseType.type)).addKeyValue("timelong", SystemClock.uptimeMillis() - this.floatWindowComponent.getShowTime()).addKeyValue("zt_str6", this.mVideoType).send();
  }
  
  private void reportFloatDragEvent(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int m = DisplayUtils.rejectedNavHeight(this.context) / 3;
    int n = UIUtil.getScreenWidth(this.context) / 2;
    int j = 0;
    int i = 1;
    int k;
    if (j < 3)
    {
      k = 0;
      label45:
      if (k >= 2) {
        break label221;
      }
      if (new RectF(k * n, j * m, (k + 1) * n, (j + 1) * m).contains(arrayOfInt[0], arrayOfInt[1])) {
        i = k + 1 + j * 2;
      }
    }
    label221:
    for (;;)
    {
      j += 1;
      break;
      k += 1;
      break label45;
      ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("narrow_window").setModuleDesc("观看端小窗").setActType("drag").setActTypeDesc("拖动").addKeyValue("zt_str1", String.valueOf(i)).addKeyValue("zt_str6", this.mVideoType).send();
      return;
    }
  }
  
  private void reportFloatErrorEvent(int paramInt)
  {
    ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("narrow_window_warn").setModuleDesc("观看端小窗").setActType("view").setActTypeDesc("曝光").addKeyValue("zt_str1", String.valueOf(paramInt)).addKeyValue("zt_str6", this.mVideoType).send();
  }
  
  private void reportFloatShowEvent()
  {
    int j = 1;
    ReportTask localReportTask;
    if (isLinkMic())
    {
      i = 1;
      localReportTask = ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("narrow_window").setModuleDesc("观看端小窗").setActType("view").setActTypeDesc("曝光").addKeyValue("zt_str1", String.valueOf(i));
      if (!isLandscape()) {
        break label132;
      }
    }
    label132:
    for (int i = j;; i = 0)
    {
      localReportTask.addKeyValue("zt_int5", i).addKeyValue("zt_str6", this.mVideoType).send();
      return;
      i = 0;
      break;
    }
  }
  
  private void reportZoomResumeEvent()
  {
    ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("narrow_window").setModuleDesc("观看端小窗").setActType("click").setActTypeDesc("点击").addKeyValue("zt_str6", this.mVideoType).send();
  }
  
  private void showFloatWindow()
  {
    if (this.floatWindowComponent != null)
    {
      this.isFloatWindowShow = true;
      getLog().i("FloatWindowModule", "isFloatWindowShow = true, FloatWindowModule = " + hashCode(), new Object[0]);
      if ((!this.isAppInBackground) || (this.isShowInBackground)) {}
    }
    else
    {
      return;
    }
    this.floatWindowComponent.show(getLayoutResId());
  }
  
  private void showIfNotCorrectStatus()
  {
    if ((!this.isActivityResumed) && (!this.isPlayOver) && (this.isFloatWindowShow) && (!this.isShowInBackground) && (!this.isAppInBackground) && (this.floatWindowComponent != null) && (!this.floatWindowComponent.isReallyShow()))
    {
      getLog().i("FloatWindowModule", "showIfNotCorrectStatus", new Object[0]);
      this.floatWindowComponent.show(getLayoutResId());
    }
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
    if (this.avPlayerService == null) {
      return;
    }
    this.avPlayerService.readyPlay(this.videoView, false);
    boolean bool = ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isBackgroundPlay();
    if (((this.isAppInBackground) && (bool)) || (paramInt == 3) || (paramInt == 8)) {}
    for (;;)
    {
      getLog().i("FloatWindowModule", "changeRenderContainerAndPlay", new Object[0]);
      return;
      this.avPlayerService.pausePlay();
    }
  }
  
  protected abstract boolean isLinkMic();
  
  protected void jumpAudienceRoomActivity()
  {
    Intent localIntent = getAudienceRoomPager().getIntent();
    localIntent.putExtra("open_from_float_window", true);
    this.context.startActivity(localIntent);
    if (isXiaomi())
    {
      if (!canBackgroundStart(this.context)) {
        ThreadCenter.postUITask(this, this.mLaunchFailNoticeForXiaomi);
      }
      return;
    }
    ThreadCenter.postDelayedUITask(this, this.mLaunchFailNotice, 5000L);
  }
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityDestroy(paramLifecycleOwner);
    if (!this.isUserVisibleHint) {}
    while (this.floatWindowComponent == null) {
      return;
    }
    this.floatWindowComponent.dismiss(7);
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
    if (getAudienceRoomPager().getIntent().getBooleanExtra("open_from_float_window", false))
    {
      getAudienceRoomPager().getIntent().removeExtra("open_from_float_window");
      reportZoomResumeEvent();
    }
    mutePlayer(false);
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStart(paramLifecycleOwner);
    if (!this.isUserVisibleHint) {
      return;
    }
    handlePlayStatusActivityStart();
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
    if (!this.isUserVisibleHint) {
      return;
    }
    handlePlayStatusOnActivityStop();
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.roomEngine = getRoomEngine();
    this.avPlayerService = ((AVPlayerBuilderServiceInterface)this.roomEngine.getService(AVPlayerBuilderServiceInterface.class));
    this.networkService = ((NetworkStateInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NetworkStateInterface.class));
    this.floatWindowConfigService = ((FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class));
    this.videoView = ((FrameLayout)getRootView().findViewById(2131368725));
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
    onActivityStart(this.mLifecycleOwner);
  }
  
  public void onExtDeActive()
  {
    super.onExtDeActive();
    onActivityStop(this.mLifecycleOwner);
  }
  
  public void onInitComponentEvent()
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
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if (!paramBoolean)
    {
      ThreadCenter.removeUITask(this, this.mLaunchFailNoticeForXiaomi);
      ThreadCenter.removeUITask(this, this.mLaunchFailNotice);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule
 * JD-Core Version:    0.7.0.1
 */