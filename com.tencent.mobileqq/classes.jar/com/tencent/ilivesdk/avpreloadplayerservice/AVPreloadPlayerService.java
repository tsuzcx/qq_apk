package com.tencent.ilivesdk.avpreloadplayerservice;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.falco.utils.PreloadUtil;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilivesdk.avmediaservice_interface.MediaPlayerInterface;
import com.tencent.ilivesdk.avplayerservice.AVPlayerService;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter.AVPreloadListener;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerParams;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.ilivesdk.avpreloadplayerservice.report.AVPreloadReport;
import com.tencent.ilivesdk.avpreloadplayerservice.report.AVPreloadReport.ReportData;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.TaskReportInfo;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.PlayerParams;
import com.tencent.livesdk.livesdkplayer.LogAdapter;

public class AVPreloadPlayerService
  extends AVPlayerService
  implements ThreadCenter.HandlerKeyable
{
  private static long i;
  AVPlayerPreloadAdapter.AVPreloadListener a = new AVPreloadPlayerService.1(this);
  private LiveSdkPlayerHelper b;
  private PlayerStatusListener c;
  private long d = 0L;
  private int e = 0;
  private AVPreloadReport.ReportData f = new AVPreloadReport.ReportData();
  private long g = 0L;
  private String h = "none";
  private LogAdapter j = new AVPreloadPlayerService.2(this);
  private Runnable k = new AVPreloadPlayerService.4(this);
  
  private long a(Context paramContext)
  {
    long l2 = 0L;
    long l1 = l2;
    long l3;
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      l1 = l2;
      paramContext = new ActivityManager.MemoryInfo();
      l1 = l2;
      ((ActivityManager)localObject).getMemoryInfo(paramContext);
      l1 = l2;
      l3 = l2;
      if (Build.VERSION.SDK_INT >= 16)
      {
        l1 = l2;
        l2 = paramContext.totalMem / 1024L / 1024L;
        l1 = l2;
        localObject = new StringBuilder();
        l1 = l2;
        ((StringBuilder)localObject).append("memoryInfo.totalMem: ");
        l1 = l2;
        ((StringBuilder)localObject).append(paramContext.totalMem);
        l1 = l2;
        Log.i("AVPreloadPlayerService", ((StringBuilder)localObject).toString());
        return l2;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      l3 = l1;
    }
    return l3;
  }
  
  private LiveSdkPlayerHelper.PlayerParams a(PlayerParams paramPlayerParams)
  {
    LiveSdkPlayerHelper.PlayerParams localPlayerParams = new LiveSdkPlayerHelper.PlayerParams();
    if (paramPlayerParams == null) {
      return localPlayerParams;
    }
    localPlayerParams.level = paramPlayerParams.level;
    localPlayerParams.originUrl = paramPlayerParams.url;
    localPlayerParams.url = paramPlayerParams.url;
    localPlayerParams.url_low = paramPlayerParams.url_low;
    localPlayerParams.url_high = paramPlayerParams.url_high;
    localPlayerParams.roomId = paramPlayerParams.roomId;
    localPlayerParams.roomType = paramPlayerParams.roomType;
    localPlayerParams.sig = paramPlayerParams.sig;
    localPlayerParams.anchorUin = paramPlayerParams.anchorUin;
    if (this.adapter == null) {
      return localPlayerParams;
    }
    localPlayerParams.roomId = this.adapter.getRoomId();
    if ((this.adapter.getAccount() != null) && (this.adapter.getAccount().getLoginInfo() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.adapter.getAccount().getLoginInfo().uid);
      localPlayerParams.userId = localStringBuilder.toString();
    }
    localPlayerParams.videoType = paramPlayerParams.videoType;
    return localPlayerParams;
  }
  
  private void a()
  {
    String str2 = this.b.getCurrentParams().url;
    this.f.x = str2.startsWith("http://127.0.0.1");
    this.f.p = (System.currentTimeMillis() - this.d);
    this.f.w = this.b.getCurrentParams().originUrl;
    this.f.e = this.b.getCurrentParams().userId;
    String str1;
    if (this.f.x) {
      str1 = "命中缓存";
    } else {
      str1 = "未命中缓存";
    }
    if (str2.startsWith("rtmp:")) {
      str2 = "rtmp";
    } else {
      str2 = "flv";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(":首帧耗时 ");
    ((StringBuilder)localObject).append(this.f.p);
    localObject = ((StringBuilder)localObject).toString();
    LogInterface localLogInterface = this.adapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    localStringBuilder.append((String)localObject);
    localLogInterface.i("AVPreloadPlayerService", localStringBuilder.toString(), new Object[0]);
  }
  
  private void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (paramAVPreloadTaskInterface != null)
    {
      Object localObject = this.adapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initReportData taskId: ");
      localStringBuilder.append(paramAVPreloadTaskInterface.r());
      ((LogInterface)localObject).i("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
      this.f.j = paramAVPreloadTaskInterface.b();
      localObject = paramAVPreloadTaskInterface.a();
      if (localObject != null)
      {
        this.f.B = (((AVPreloadTaskInterface.TaskReportInfo)localObject).d() / 1024);
        this.f.r = ((AVPreloadTaskInterface.TaskReportInfo)localObject).b();
        this.f.q = ((AVPreloadTaskInterface.TaskReportInfo)localObject).a();
        this.f.D = ((AVPreloadTaskInterface.TaskReportInfo)localObject).c();
      }
      this.f.j = paramAVPreloadTaskInterface.b();
      this.f.k = paramAVPreloadTaskInterface.c();
      this.f.u = paramAVPreloadTaskInterface.k();
      localObject = this.f;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramAVPreloadTaskInterface.r());
      ((AVPreloadReport.ReportData)localObject).E = localStringBuilder.toString();
      this.f.z = paramAVPreloadTaskInterface.n();
      this.f.l = paramAVPreloadTaskInterface.d();
      this.f.C = paramAVPreloadTaskInterface.j();
      this.f.s = paramAVPreloadTaskInterface.l();
      this.f.t = paramAVPreloadTaskInterface.m();
      this.f.o = paramAVPreloadTaskInterface.e();
      this.f.w = paramAVPreloadTaskInterface.s();
      this.f.F = paramAVPreloadTaskInterface.f();
      this.f.G = (paramAVPreloadTaskInterface.i() / 1024L);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = ((LiveSdkPlayerHelper)localObject1).getPlayUrl();
      if ((this.mPreloadAdapter != null) && (!((String)localObject1).startsWith("http://127.0.0.1")) && (paramBoolean)) {
        this.b.getCurrentParams().url = this.mPreloadAdapter.e((String)localObject1);
      }
      Object localObject2 = new StringBuffer("preparePlay()---preparePlay remote url= ");
      ((StringBuffer)localObject2).append((String)localObject1);
      ((StringBuffer)localObject2).append(" local url= ");
      ((StringBuffer)localObject2).append(this.b.getCurrentParams().url);
      this.adapter.getLogger().i("AVPreload|Core", ((StringBuffer)localObject2).toString(), new Object[0]);
      if (this.mPreloadAdapter != null) {
        this.mPreloadAdapter.d((String)localObject1);
      }
      this.d = System.currentTimeMillis();
      localObject2 = this.f;
      ((AVPreloadReport.ReportData)localObject2).w = ((String)localObject1);
      ((AVPreloadReport.ReportData)localObject2).i = this.d;
      this.b.openPlay();
    }
  }
  
  private String b()
  {
    String str = this.b.getCurrentParams().url;
    if (str.startsWith("http://127.0.0.1"))
    {
      localObject1 = this.adapter.getLogger();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("------local url play error url=");
      ((StringBuilder)localObject2).append(str);
      ((LogInterface)localObject1).e("AVPreload|Core", ((StringBuilder)localObject2).toString(), new Object[0]);
    }
    else
    {
      localObject1 = this.adapter.getLogger();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("------remote url play error url=");
      ((StringBuilder)localObject2).append(str);
      ((LogInterface)localObject1).e("AVPreload|Core", ((StringBuilder)localObject2).toString(), new Object[0]);
    }
    Object localObject2 = this.b.getCurrentParams().originUrl;
    Object localObject1 = localObject2;
    if (this.mPreloadAdapter != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).startsWith("http://127.0.0.1"))
      {
        localObject1 = this.mPreloadAdapter.f((String)localObject2);
        localObject2 = this.adapter.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("------play error exchangeRemoteServerPlayUrl url=");
        localStringBuilder.append(str);
        ((LogInterface)localObject2).e("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
      }
    }
    return localObject1;
  }
  
  private void c()
  {
    this.b.getCurrentParams().url = b();
    ThreadCenter.removeUITask(this, this.k);
    if (this.e < 3)
    {
      ThreadCenter.postDelayedUITask(this, this.k, 1000L);
      return;
    }
    this.e = 0;
  }
  
  private String d()
  {
    long l = System.currentTimeMillis();
    if (l - this.g < 60000L) {
      return this.h;
    }
    int m = NetworkUtil.getNetworkType(this.appContext);
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4)
          {
            if (m != 5) {
              this.h = "none";
            } else {
              this.h = "mobile";
            }
          }
          else {
            this.h = "4G";
          }
        }
        else {
          this.h = "3G";
        }
      }
      else {
        this.h = "2G";
      }
    }
    else {
      this.h = "wifi";
    }
    this.g = l;
    return this.h;
  }
  
  public void clearEventOutput() {}
  
  public long getCurrentPositionMs()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public Rect getDisplayViewRect()
  {
    return this.b.getDisplayViewRect();
  }
  
  public long getVideoDurationMs()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.getDurationMs();
    }
    return 0L;
  }
  
  public int getVideoHeight()
  {
    return this.b.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.b.getVideoWidth();
  }
  
  public void init(Context paramContext, FrameLayout paramFrameLayout)
  {
    super.init(paramContext, paramFrameLayout);
    this.b = new LiveSdkPlayerHelper();
    this.b.setIsHoldPlayerLog(this.adapter.isHoldPlayerLog());
    this.b.setLog(this.j);
    this.b.initTPPlayerId(this.adapter.getAppInfo().getTPPlayerGuid(), this.adapter.getAppInfo().getTPPlatform(), this.adapter.getAppInfo().isNeedInitTPPlatform());
    IMediaPlayerMgr localIMediaPlayerMgr;
    if (this.adapter.getMediaPlayerInterface() == null) {
      localIMediaPlayerMgr = null;
    } else {
      localIMediaPlayerMgr = this.adapter.getMediaPlayerInterface().a();
    }
    this.b.init(paramContext, localIMediaPlayerMgr);
    this.b.readyPlay(paramFrameLayout, false);
  }
  
  public boolean isPaused()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.isPaused();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.isPlaying();
    }
    return false;
  }
  
  public boolean isUseLocalServerPreload()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      return PreloadUtil.a(localLiveSdkPlayerHelper.getPlayUrl(), this.b.getCurrentParams().videoType);
    }
    return false;
  }
  
  public void mutePlay(boolean paramBoolean)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.mutePlay(paramBoolean);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onScreenOrientationChange(boolean paramBoolean)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.onScreenOrientationChange(paramBoolean);
    }
  }
  
  public void pausePlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.pausePlay();
    }
  }
  
  public void preload()
  {
    if ((this.b != null) && (this.mPreloadAdapter != null))
    {
      LogInterface localLogInterface = this.adapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload()---preload start url= ");
      localStringBuilder.append(this.b.getPlayUrl());
      localLogInterface.i("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
      this.mPreloadAdapter.a(this.b.getPlayUrl(), this.a);
      this.mPreloadAdapter.a(this.b.getPlayUrl());
    }
  }
  
  public void preparePlay()
  {
    a(true);
  }
  
  public void readyPlay(FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.readyPlay(paramFrameLayout, paramBoolean);
    }
  }
  
  public void reportPreloadData(boolean paramBoolean)
  {
    this.f.m = d();
    if ((this.f.q > 0L) && (this.f.r > 0L))
    {
      localObject = this.f;
      ((AVPreloadReport.ReportData)localObject).v = (((AVPreloadReport.ReportData)localObject).r / this.f.q);
    }
    this.f.l = System.currentTimeMillis();
    this.f.d = this.adapter.getNickName();
    Object localObject = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.adapter.getRoomId());
    ((AVPreloadReport.ReportData)localObject).c = localStringBuilder.toString();
    localObject = this.f;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.adapter.getAnchorUin());
    ((AVPreloadReport.ReportData)localObject).g = localStringBuilder.toString();
    this.f.A = "event_close_room";
    localObject = this.adapter.getAppInfo();
    if (localObject != null)
    {
      this.f.b = ((AppGeneralInfoService)localObject).getVersionName();
      this.f.a = ((AppGeneralInfoService)localObject).getSource();
      this.f.f = ((AppGeneralInfoService)localObject).getGuid();
      this.f.h = ((AppGeneralInfoService)localObject).getApplication().getPackageName();
    }
    if (i == 0L) {
      i = a(this.appContext);
    }
    localObject = this.f;
    ((AVPreloadReport.ReportData)localObject).H = i;
    ((AVPreloadReport.ReportData)localObject).I = paramBoolean;
    localObject = new AVPreloadReport();
    ((AVPreloadReport)localObject).a(this.adapter.getHttp());
    ((AVPreloadReport)localObject).a(this.f);
    ((AVPreloadReport)localObject).a(this.adapter.getLogger());
    ((AVPreloadReport)localObject).b();
  }
  
  public void resetPlayer()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.reset();
    }
  }
  
  public void resumePlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.resumePlay();
    }
  }
  
  public void seekTo(int paramInt)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.seek(paramInt);
    }
  }
  
  public void setParams(PlayerParams paramPlayerParams)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null)
    {
      localLiveSdkPlayerHelper.setParams(a(paramPlayerParams));
      this.b.setOffsetY(paramPlayerParams.offsetY);
    }
    if (this.mPreloadAdapter != null) {
      a(this.mPreloadAdapter.h(paramPlayerParams.getPlayUrl()));
    }
  }
  
  public void setPlayerStatusListener(PlayerStatusListener paramPlayerStatusListener)
  {
    if (this.mStatusListener == paramPlayerStatusListener)
    {
      this.adapter.getLogger().i("AVPreloadPlayerService", "setPlayerStatusListener is same return", new Object[0]);
      return;
    }
    super.setPlayerStatusListener(paramPlayerStatusListener);
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.setPlayerStatusListener(new AVPreloadPlayerService.3(this, paramPlayerStatusListener));
    }
  }
  
  public void setPlayerSurface()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.setPlayerSurface();
    }
  }
  
  public void startPlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.startPlay();
    }
  }
  
  public void stopPlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.b;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.stopPlay();
    }
  }
  
  public void switchResolution(PlayerParams paramPlayerParams, PlayerStatusListener paramPlayerStatusListener)
  {
    stopPlay();
    resetPlayer();
    this.c = paramPlayerStatusListener;
    setParams(paramPlayerParams);
    setPlayerSurface();
    a(false);
  }
  
  public void uninit()
  {
    super.uninit();
    if (this.b != null)
    {
      if (this.mPreloadAdapter != null)
      {
        this.mPreloadAdapter.c(this.b.getPlayUrl());
        this.mPreloadAdapter.b(this.b.getPlayUrl());
        this.mPreloadAdapter.a(this.a);
      }
      this.b.setPlayerStatusListener(null);
      this.b.uninit();
    }
    this.e = 0;
    ThreadCenter.clear(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService
 * JD-Core Version:    0.7.0.1
 */