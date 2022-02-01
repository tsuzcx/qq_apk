package com.tencent.ilive.audiencepages.room.bizmodule;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat.Builder;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.activitylife.AppStatusListener;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostAppResInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.notification.NotificationChannelConstant;
import com.tencent.falco.base.libapi.notification.NotificationIdConstant;
import com.tencent.falco.base.libapi.notification.NotificationInterface;
import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;
import com.tencent.ilive.audiencepages.room.events.PlayLittleWindowEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.events.PlayOverEvent;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;

public class AudioFocusListenerModule
  extends RoomBizModule
{
  private static final String PAGE_DESC = "直播间";
  private static final String PAGE_NAME = "room_page";
  private static final String TAG = "AudioFocusListener";
  private static long sBackgroundTime;
  private static long sForegroundTime;
  private AppGeneralInfoService appGeneralInfoService;
  private AppStatusListener appStatusListener;
  private boolean isAppBackground;
  private boolean isFloatWindowShow;
  private boolean isGetAudioFocus;
  private boolean isLittleWindowResume = false;
  private boolean isNativePageDeactive = false;
  private boolean isNeedBackgroundPlay;
  private AudioManager mAudioManager;
  private AVPlayerServiceInterface mAvPlayer;
  private Context mContext;
  private DataReportInterface mDataReportInterface;
  private FloatWindowConfigServiceInterface mFloatWindowConfigInterface;
  private FloatWindowPermissionInterface mFloatWindowPermissionInterface;
  private HostProxyInterface mHostProxyInterface;
  private LiveAnchorInfo mLiveAnchorInfo;
  private NotificationInterface mNotificationInterface;
  private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
  
  private NotificationCompat.Builder createNotificationBuilder()
  {
    Object localObject = new Intent(this.mContext, AudienceRoomActivity.class);
    PendingIntent localPendingIntent = PendingIntent.getActivity(this.mContext, 0, (Intent)localObject, 268435456);
    if ((this.mHostProxyInterface.getHostAppResInterface() != null) && (this.mHostProxyInterface.getHostAppResInterface().getBackgroundPlayNotificationBuilder() != null)) {
      return this.mHostProxyInterface.getHostAppResInterface().getBackgroundPlayNotificationBuilder().setAutoCancel(true).setContentIntent(localPendingIntent);
    }
    int i;
    if ((this.mHostProxyInterface.getHostAppResInterface() != null) && (this.mHostProxyInterface.getHostAppResInterface().getHostAppIconId() != 0)) {
      i = this.mHostProxyInterface.getHostAppResInterface().getHostAppIconId();
    } else {
      i = 2131167394;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【");
    if ((this.mHostProxyInterface.getHostAppResInterface() != null) && (!TextUtils.isEmpty(this.mHostProxyInterface.getHostAppResInterface().getHostAppName()))) {
      localObject = this.mHostProxyInterface.getHostAppResInterface().getHostAppName();
    } else {
      localObject = " ";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("】");
    localStringBuilder.append("直播正在后台播放音频");
    NotificationCompat.Builder localBuilder = this.mNotificationInterface.getNotificationBuilder(this.mContext, NotificationChannelConstant.BACKGROUND_AUDIO).setSmallIcon(i);
    localObject = this.mLiveAnchorInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((LiveAnchorInfo)localObject).nickName)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.mLiveAnchorInfo.nickName);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = " 主播正在直播中";
    }
    return localBuilder.setContentTitle((CharSequence)localObject).setContentText(localStringBuilder).setAutoCancel(true).setContentIntent(localPendingIntent).setPriority(0);
  }
  
  private boolean isFloatWindowCanShow()
  {
    boolean bool1 = this.mHostProxyInterface.getSdkInfoInterface().isFloatWindowEnabled();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (!this.mFloatWindowConfigInterface.getFloatWindowEnabledAllTime())
    {
      bool1 = bool2;
      if (!this.mFloatWindowConfigInterface.getFloatWindowEnabledOnce()) {}
    }
    else
    {
      bool1 = bool2;
      if (this.mFloatWindowPermissionInterface.hasFWPermission()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int requestAudioFocus()
  {
    this.onAudioFocusChangeListener = new AudioFocusListenerModule.5(this);
    return this.mAudioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 2);
  }
  
  protected void audioFocusGain() {}
  
  protected void audioFocusLoss() {}
  
  protected boolean isGetAudioFocus()
  {
    return this.isGetAudioFocus;
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    this.isAppBackground = false;
    paramLifecycleOwner = getLog();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Player -- onActivityStart  isUserVisibleHint = ");
    ((StringBuilder)localObject).append(this.isUserVisibleHint);
    ((StringBuilder)localObject).append(" isNativePageDeactive = ");
    ((StringBuilder)localObject).append(this.isNativePageDeactive);
    ((StringBuilder)localObject).append(" isGetAudioFocus = ");
    ((StringBuilder)localObject).append(this.isGetAudioFocus);
    paramLifecycleOwner.i("AudioFocusListener", ((StringBuilder)localObject).toString(), new Object[0]);
    if (this.isUserVisibleHint)
    {
      if (this.isNativePageDeactive) {
        return;
      }
      paramLifecycleOwner = this.mAudioManager;
      if ((paramLifecycleOwner != null) && (!this.isGetAudioFocus))
      {
        localObject = this.onAudioFocusChangeListener;
        if (localObject != null) {
          paramLifecycleOwner.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)localObject);
        }
        requestAudioFocus();
        this.isGetAudioFocus = true;
        if ((this.roomBizContext.getEnterRoomInfo().videoType == VideoType.VIDEO.ordinal()) && (this.mAvPlayer.isPaused()) && (!this.isLittleWindowResume)) {
          return;
        }
        this.mAvPlayer.resumePlay();
        this.isLittleWindowResume = false;
      }
    }
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    if ((!this.isAppBackground) && (!isFloatWindowCanShow()) && (this.mHostProxyInterface.getSdkInfoInterface().stopPlayingWhenRoomActivityStop()))
    {
      this.mAvPlayer.pausePlay();
      this.isGetAudioFocus = false;
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.mContext = paramContext;
    this.mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.mAvPlayer = ((AVPlayerServiceInterface)getRoomEngine().getService(AVPlayerBuilderServiceInterface.class));
    this.mNotificationInterface = ((NotificationInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NotificationInterface.class));
    this.mHostProxyInterface = ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class));
    this.mDataReportInterface = ((DataReportInterface)BizEngineMgr.getInstance().getLiveEngine().getService(DataReportInterface.class));
    this.mFloatWindowConfigInterface = ((FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class));
    this.mFloatWindowPermissionInterface = ((FloatWindowPermissionInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowPermissionInterface.class));
    this.appGeneralInfoService = ((AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class));
    if (this.mHostProxyInterface.getSdkInfoInterface() != null) {
      this.isNeedBackgroundPlay = this.mHostProxyInterface.getSdkInfoInterface().isBackgroundPlay();
    }
    if (this.isNeedBackgroundPlay)
    {
      this.mNotificationInterface = ((NotificationInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NotificationInterface.class));
      if (Build.VERSION.SDK_INT >= 26) {
        this.mNotificationInterface.createNotificationChannel(NotificationChannelConstant.BACKGROUND_AUDIO);
      }
      getEvent().observe(PlayOverEvent.class, new AudioFocusListenerModule.1(this));
    }
    getEvent().observe(PlayLittleWindowEvent.class, new AudioFocusListenerModule.2(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = this.onAudioFocusChangeListener;
    if (localOnAudioFocusChangeListener != null) {
      this.mAudioManager.abandonAudioFocus(localOnAudioFocusChangeListener);
    }
    this.mNotificationInterface.cancel(NotificationIdConstant.BACKGROUND_AUDIO.getValue());
    ((ActivityLifeService)BizEngineMgr.getInstance().getLiveEngine().getService(ActivityLifeService.class)).removeAppStatusListener(this.appStatusListener);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    if (this.isNeedBackgroundPlay)
    {
      this.mLiveAnchorInfo = this.roomBizContext.getAnchorInfo();
      this.mNotificationInterface.cancel(NotificationIdConstant.BACKGROUND_AUDIO.getValue());
    }
  }
  
  public void onExtActive()
  {
    getLog().i("AudioFocusListener", "Player -- onExtActive", new Object[0]);
    this.isNativePageDeactive = false;
    this.isAppBackground = false;
    onActivityStart(this.mLifecycleOwner);
  }
  
  public void onExtDeActive()
  {
    getLog().i("AudioFocusListener", "Player -- onExtDeActive", new Object[0]);
    this.isNativePageDeactive = true;
    onActivityStop(this.mLifecycleOwner);
  }
  
  protected void onInitComponentEvent()
  {
    super.onInitComponentEvent();
    getEvent().observe(FloatWindowStateEvent.class, new AudioFocusListenerModule.3(this));
    this.appStatusListener = new AudioFocusListenerModule.4(this);
    ((ActivityLifeService)BizEngineMgr.getInstance().getLiveEngine().getService(ActivityLifeService.class)).addAppStatusListener(this.appStatusListener);
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    paramSwitchRoomInfo = this.mAudioManager;
    if ((paramSwitchRoomInfo != null) && (!this.isGetAudioFocus))
    {
      AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = this.onAudioFocusChangeListener;
      if (localOnAudioFocusChangeListener != null) {
        paramSwitchRoomInfo.abandonAudioFocus(localOnAudioFocusChangeListener);
      }
      requestAudioFocus();
      this.isGetAudioFocus = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule
 * JD-Core Version:    0.7.0.1
 */