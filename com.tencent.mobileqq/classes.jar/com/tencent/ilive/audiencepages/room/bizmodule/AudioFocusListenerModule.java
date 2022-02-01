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
    StringBuilder localStringBuilder;
    label186:
    NotificationCompat.Builder localBuilder;
    if ((this.mHostProxyInterface.getHostAppResInterface() != null) && (this.mHostProxyInterface.getHostAppResInterface().getHostAppIconId() != 0))
    {
      i = this.mHostProxyInterface.getHostAppResInterface().getHostAppIconId();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("【");
      if ((this.mHostProxyInterface.getHostAppResInterface() == null) || (TextUtils.isEmpty(this.mHostProxyInterface.getHostAppResInterface().getHostAppName()))) {
        break label284;
      }
      localObject = this.mHostProxyInterface.getHostAppResInterface().getHostAppName();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("】");
      localStringBuilder.append("直播正在后台播放音频");
      localBuilder = this.mNotificationInterface.getNotificationBuilder(this.mContext, NotificationChannelConstant.BACKGROUND_AUDIO).setSmallIcon(i);
      if ((this.mLiveAnchorInfo != null) && (!TextUtils.isEmpty(this.mLiveAnchorInfo.nickName))) {
        break label290;
      }
    }
    label284:
    label290:
    for (localObject = " 主播正在直播中";; localObject = " " + this.mLiveAnchorInfo.nickName)
    {
      return localBuilder.setContentTitle((CharSequence)localObject).setContentText(localStringBuilder).setAutoCancel(true).setContentIntent(localPendingIntent).setPriority(0);
      i = 2131167374;
      break;
      localObject = " ";
      break label186;
    }
  }
  
  private boolean isFloatWindowCanShow()
  {
    if (!this.mHostProxyInterface.getSdkInfoInterface().isFloatWindowEnabled()) {}
    while (((!this.mFloatWindowConfigInterface.getFloatWindowEnabledAllTime()) && (!this.mFloatWindowConfigInterface.getFloatWindowEnabledOnce())) || (!this.mFloatWindowPermissionInterface.hasFWPermission())) {
      return false;
    }
    return true;
  }
  
  private int requestAudioFocus()
  {
    this.onAudioFocusChangeListener = new AudioFocusListenerModule.5(this);
    return this.mAudioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 1);
  }
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner)
  {
    if (this.onAudioFocusChangeListener != null) {
      this.mAudioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
    }
    this.mNotificationInterface.cancel(NotificationIdConstant.BACKGROUND_AUDIO.getValue());
    ((ActivityLifeService)BizEngineMgr.getInstance().getLiveEngine().getService(ActivityLifeService.class)).removeAppStatusListener(this.appStatusListener);
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    if (!this.isUserVisibleHint) {}
    do
    {
      do
      {
        return;
      } while ((this.mAudioManager == null) || (this.isGetAudioFocus));
      if (this.onAudioFocusChangeListener != null) {
        this.mAudioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
      }
      requestAudioFocus();
      this.isGetAudioFocus = true;
    } while ((this.roomBizContext.getEnterRoomInfo().videoType == VideoType.VIDEO.ordinal()) && (this.mAvPlayer.isPaused()) && (!this.isLittleWindowResume));
    this.mAvPlayer.resumePlay();
    this.isLittleWindowResume = false;
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
    onActivityStart(this.mLifecycleOwner);
  }
  
  public void onExtDeActive()
  {
    getLog().i("AudioFocusListener", "Player -- onExtDeActive", new Object[0]);
    onActivityStop(this.mLifecycleOwner);
  }
  
  public void onInitComponentEvent()
  {
    super.onInitComponentEvent();
    getEvent().observe(FloatWindowStateEvent.class, new AudioFocusListenerModule.3(this));
    this.appStatusListener = new AudioFocusListenerModule.4(this);
    ((ActivityLifeService)BizEngineMgr.getInstance().getLiveEngine().getService(ActivityLifeService.class)).addAppStatusListener(this.appStatusListener);
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    if ((this.mAudioManager != null) && (!this.isGetAudioFocus))
    {
      if (this.onAudioFocusChangeListener != null) {
        this.mAudioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
      }
      requestAudioFocus();
      this.isGetAudioFocus = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule
 * JD-Core Version:    0.7.0.1
 */