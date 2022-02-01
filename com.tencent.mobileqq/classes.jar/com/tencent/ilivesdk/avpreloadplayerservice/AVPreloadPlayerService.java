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
  private static long c;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  AVPlayerPreloadAdapter.AVPreloadListener jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfaceAVPlayerPreloadAdapter$AVPreloadListener = new AVPreloadPlayerService.1(this);
  private PlayerStatusListener jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener;
  private AVPreloadReport.ReportData jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData = new AVPreloadReport.ReportData();
  private LiveSdkPlayerHelper jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
  private LogAdapter jdField_a_of_type_ComTencentLivesdkLivesdkplayerLogAdapter = new AVPreloadPlayerService.2(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVPreloadPlayerService.4(this);
  private String jdField_a_of_type_JavaLangString = "none";
  private long b;
  
  public AVPreloadPlayerService()
  {
    this.jdField_b_of_type_Long = 0L;
  }
  
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
  
  private String a()
  {
    String str = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().url;
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
    Object localObject2 = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().originUrl;
    Object localObject1 = localObject2;
    if (this.mPreloadAdapter != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).startsWith("http://127.0.0.1"))
      {
        localObject1 = this.mPreloadAdapter.b((String)localObject2);
        localObject2 = this.adapter.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("------play error exchangeRemoteServerPlayUrl url=");
        localStringBuilder.append(str);
        ((LogInterface)localObject2).e("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
      }
    }
    return localObject1;
  }
  
  private void a()
  {
    String str2 = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().url;
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Boolean = str2.startsWith("http://127.0.0.1");
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_f_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().originUrl;
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().userId;
    String str1;
    if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Boolean) {
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
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_f_of_type_Long);
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
      localStringBuilder.append(paramAVPreloadTaskInterface.j());
      ((LogInterface)localObject).i("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Long = paramAVPreloadTaskInterface.a();
      localObject = paramAVPreloadTaskInterface.a();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_Long = (((AVPreloadTaskInterface.TaskReportInfo)localObject).a() / 1024);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_Long = ((AVPreloadTaskInterface.TaskReportInfo)localObject).b();
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_Long = ((AVPreloadTaskInterface.TaskReportInfo)localObject).a();
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Boolean = ((AVPreloadTaskInterface.TaskReportInfo)localObject).a();
      }
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Long = paramAVPreloadTaskInterface.a();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Long = paramAVPreloadTaskInterface.b();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Int = paramAVPreloadTaskInterface.a();
      localObject = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramAVPreloadTaskInterface.j());
      ((AVPreloadReport.ReportData)localObject).jdField_l_of_type_JavaLangString = localStringBuilder.toString();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Int = paramAVPreloadTaskInterface.d();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Long = paramAVPreloadTaskInterface.c();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_k_of_type_Long = paramAVPreloadTaskInterface.i();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Int = paramAVPreloadTaskInterface.b();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Int = paramAVPreloadTaskInterface.c();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_e_of_type_Long = paramAVPreloadTaskInterface.d();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_JavaLangString = paramAVPreloadTaskInterface.b();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_l_of_type_Long = paramAVPreloadTaskInterface.e();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.m = (paramAVPreloadTaskInterface.h() / 1024L);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localObject1 != null)
    {
      localObject1 = ((LiveSdkPlayerHelper)localObject1).getPlayUrl();
      if ((this.mPreloadAdapter != null) && (!((String)localObject1).startsWith("http://127.0.0.1")) && (paramBoolean)) {
        this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().url = this.mPreloadAdapter.a((String)localObject1);
      }
      Object localObject2 = new StringBuffer("preparePlay()---preparePlay remote url= ");
      ((StringBuffer)localObject2).append((String)localObject1);
      ((StringBuffer)localObject2).append(" local url= ");
      ((StringBuffer)localObject2).append(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().url);
      this.adapter.getLogger().i("AVPreload|Core", ((StringBuffer)localObject2).toString(), new Object[0]);
      if (this.mPreloadAdapter != null) {
        this.mPreloadAdapter.d((String)localObject1);
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject2 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData;
      ((AVPreloadReport.ReportData)localObject2).jdField_j_of_type_JavaLangString = ((String)localObject1);
      ((AVPreloadReport.ReportData)localObject2).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.openPlay();
    }
  }
  
  private String b()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long < 60000L) {
      return this.jdField_a_of_type_JavaLangString;
    }
    int i = NetworkUtil.getNetworkType(this.appContext);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              this.jdField_a_of_type_JavaLangString = "none";
            } else {
              this.jdField_a_of_type_JavaLangString = "mobile";
            }
          }
          else {
            this.jdField_a_of_type_JavaLangString = "4G";
          }
        }
        else {
          this.jdField_a_of_type_JavaLangString = "3G";
        }
      }
      else {
        this.jdField_a_of_type_JavaLangString = "2G";
      }
    }
    else {
      this.jdField_a_of_type_JavaLangString = "wifi";
    }
    this.jdField_b_of_type_Long = l;
    return this.jdField_a_of_type_JavaLangString;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().url = a();
    ThreadCenter.removeUITask(this, this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Int < 3)
    {
      ThreadCenter.postDelayedUITask(this, this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void clearEventOutput() {}
  
  public long getCurrentPositionMs()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public Rect getDisplayViewRect()
  {
    return this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getDisplayViewRect();
  }
  
  public long getVideoDurationMs()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.getDurationMs();
    }
    return 0L;
  }
  
  public int getVideoHeight()
  {
    return this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getVideoWidth();
  }
  
  public void init(Context paramContext, FrameLayout paramFrameLayout)
  {
    super.init(paramContext, paramFrameLayout);
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper = new LiveSdkPlayerHelper();
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setIsHoldPlayerLog(this.adapter.isHoldPlayerLog());
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setLog(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLogAdapter);
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.initTPPlayerId(this.adapter.getAppInfo().getTPPlayerGuid(), this.adapter.getAppInfo().getTPPlatform(), this.adapter.getAppInfo().isNeedInitTPPlatform());
    IMediaPlayerMgr localIMediaPlayerMgr;
    if (this.adapter.getMediaPlayerInterface() == null) {
      localIMediaPlayerMgr = null;
    } else {
      localIMediaPlayerMgr = this.adapter.getMediaPlayerInterface().a();
    }
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.init(paramContext, localIMediaPlayerMgr);
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.readyPlay(paramFrameLayout, false);
  }
  
  public boolean isPaused()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.isPaused();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      return localLiveSdkPlayerHelper.isPlaying();
    }
    return false;
  }
  
  public boolean isUseLocalServerPreload()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      return PreloadUtil.a(localLiveSdkPlayerHelper.getPlayUrl(), this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().videoType);
    }
    return false;
  }
  
  public void mutePlay(boolean paramBoolean)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
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
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.onScreenOrientationChange(paramBoolean);
    }
  }
  
  public void pausePlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.pausePlay();
    }
  }
  
  public void preload()
  {
    if ((this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) && (this.mPreloadAdapter != null))
    {
      LogInterface localLogInterface = this.adapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload()---preload start url= ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl());
      localLogInterface.i("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
      this.mPreloadAdapter.a(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl(), this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfaceAVPlayerPreloadAdapter$AVPreloadListener);
      this.mPreloadAdapter.a(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl());
    }
  }
  
  public void preparePlay()
  {
    a(true);
  }
  
  public void readyPlay(FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.readyPlay(paramFrameLayout, paramBoolean);
    }
  }
  
  public void reportPreloadData(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_i_of_type_JavaLangString = b();
    if ((this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_Long > 0L))
    {
      localObject = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData;
      ((AVPreloadReport.ReportData)localObject).jdField_i_of_type_Long = (((AVPreloadReport.ReportData)localObject).jdField_h_of_type_Long / this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_JavaLangString = this.adapter.getNickName();
    Object localObject = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.adapter.getRoomId());
    ((AVPreloadReport.ReportData)localObject).jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    localObject = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.adapter.getAnchorUin());
    ((AVPreloadReport.ReportData)localObject).jdField_g_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_k_of_type_JavaLangString = "event_close_room";
    localObject = this.adapter.getAppInfo();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_JavaLangString = ((AppGeneralInfoService)localObject).getVersionName();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_JavaLangString = ((AppGeneralInfoService)localObject).getSource();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_f_of_type_JavaLangString = ((AppGeneralInfoService)localObject).getGuid();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_JavaLangString = ((AppGeneralInfoService)localObject).getApplication().getPackageName();
    }
    if (jdField_c_of_type_Long == 0L) {
      jdField_c_of_type_Long = a(this.appContext);
    }
    localObject = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData;
    ((AVPreloadReport.ReportData)localObject).n = jdField_c_of_type_Long;
    ((AVPreloadReport.ReportData)localObject).jdField_d_of_type_Boolean = paramBoolean;
    localObject = new AVPreloadReport();
    ((AVPreloadReport)localObject).a(this.adapter.getHttp());
    ((AVPreloadReport)localObject).a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData);
    ((AVPreloadReport)localObject).a(this.adapter.getLogger());
    ((AVPreloadReport)localObject).b();
  }
  
  public void resetPlayer()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.reset();
    }
  }
  
  public void resumePlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.resumePlay();
    }
  }
  
  public void seekTo(int paramInt)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.seek(paramInt);
    }
  }
  
  public void setParams(PlayerParams paramPlayerParams)
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null)
    {
      localLiveSdkPlayerHelper.setParams(a(paramPlayerParams));
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setOffsetY(paramPlayerParams.offsetY);
    }
    if (this.mPreloadAdapter != null) {
      a(this.mPreloadAdapter.a(paramPlayerParams.getPlayUrl()));
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
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.setPlayerStatusListener(new AVPreloadPlayerService.3(this, paramPlayerStatusListener));
    }
  }
  
  public void setPlayerSurface()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.setPlayerSurface();
    }
  }
  
  public void startPlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.startPlay();
    }
  }
  
  public void stopPlay()
  {
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper;
    if (localLiveSdkPlayerHelper != null) {
      localLiveSdkPlayerHelper.stopPlay();
    }
  }
  
  public void switchResolution(PlayerParams paramPlayerParams, PlayerStatusListener paramPlayerStatusListener)
  {
    stopPlay();
    resetPlayer();
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfacePlayerStatusListener = paramPlayerStatusListener;
    setParams(paramPlayerParams);
    setPlayerSurface();
    a(false);
  }
  
  public void uninit()
  {
    super.uninit();
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null)
    {
      if (this.mPreloadAdapter != null)
      {
        this.mPreloadAdapter.c(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl());
        this.mPreloadAdapter.b(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl());
        this.mPreloadAdapter.a(this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfaceAVPlayerPreloadAdapter$AVPreloadListener);
      }
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setPlayerStatusListener(null);
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.uninit();
    }
    this.jdField_a_of_type_Int = 0;
    ThreadCenter.clear(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService
 * JD-Core Version:    0.7.0.1
 */