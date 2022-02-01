package com.tencent.ilivesdk.avpreloadplayerservice;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.falco.utils.PreloadUtil;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
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
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper;
import com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.PlayerParams;

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
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVPreloadPlayerService.4(this);
  private String jdField_a_of_type_JavaLangString = "none";
  private long b;
  
  static
  {
    jdField_c_of_type_Long = 0L;
  }
  
  public AVPreloadPlayerService()
  {
    this.jdField_b_of_type_Long = 0L;
  }
  
  /* Error */
  private long a(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 66
    //   3: invokevirtual 72	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 74	android/app/ActivityManager
    //   9: astore_1
    //   10: new 76	android/app/ActivityManager$MemoryInfo
    //   13: dup
    //   14: invokespecial 77	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   17: astore 4
    //   19: aload_1
    //   20: aload 4
    //   22: invokevirtual 81	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   25: getstatic 86	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 16
    //   30: if_icmplt +61 -> 91
    //   33: aload 4
    //   35: getfield 89	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   38: ldc2_w 90
    //   41: ldiv
    //   42: ldc2_w 90
    //   45: ldiv
    //   46: lstore_2
    //   47: ldc 93
    //   49: new 95	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   56: ldc 98
    //   58: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload 4
    //   63: getfield 89	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   66: invokevirtual 105	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 115	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   75: pop
    //   76: lload_2
    //   77: lreturn
    //   78: astore_1
    //   79: lconst_0
    //   80: lstore_2
    //   81: aload_1
    //   82: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   85: lload_2
    //   86: lreturn
    //   87: astore_1
    //   88: goto -7 -> 81
    //   91: lconst_0
    //   92: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	AVPreloadPlayerService
    //   0	93	1	paramContext	Context
    //   46	40	2	l	long
    //   17	45	4	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    // Exception table:
    //   from	to	target	type
    //   0	47	78	java/lang/Exception
    //   47	76	87	java/lang/Exception
  }
  
  private LiveSdkPlayerHelper.PlayerParams a(PlayerParams paramPlayerParams)
  {
    LiveSdkPlayerHelper.PlayerParams localPlayerParams = new LiveSdkPlayerHelper.PlayerParams();
    if (paramPlayerParams == null) {}
    do
    {
      return localPlayerParams;
      localPlayerParams.level = paramPlayerParams.level;
      localPlayerParams.originUrl = paramPlayerParams.url;
      localPlayerParams.url = paramPlayerParams.url;
      localPlayerParams.url_low = paramPlayerParams.url_low;
      localPlayerParams.url_high = paramPlayerParams.url_high;
      localPlayerParams.roomId = paramPlayerParams.roomId;
      localPlayerParams.roomType = paramPlayerParams.roomType;
      localPlayerParams.sig = paramPlayerParams.sig;
      localPlayerParams.anchorUin = paramPlayerParams.anchorUin;
    } while (this.adapter == null);
    localPlayerParams.roomId = this.adapter.getRoomId();
    if ((this.adapter.getAccount() != null) && (this.adapter.getAccount().getLoginInfo() != null)) {
      localPlayerParams.userId = ("" + this.adapter.getAccount().getLoginInfo().uid);
    }
    localPlayerParams.videoType = paramPlayerParams.videoType;
    return localPlayerParams;
  }
  
  private String a()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long < 60000L) {
      return this.jdField_a_of_type_JavaLangString;
    }
    switch (NetworkUtil.getNetworkType(this.appContext))
    {
    default: 
      this.jdField_a_of_type_JavaLangString = "none";
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = l;
      return this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaLangString = "wifi";
      continue;
      this.jdField_a_of_type_JavaLangString = "4G";
      continue;
      this.jdField_a_of_type_JavaLangString = "3G";
      continue;
      this.jdField_a_of_type_JavaLangString = "2G";
      continue;
      this.jdField_a_of_type_JavaLangString = "mobile";
    }
  }
  
  private void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (paramAVPreloadTaskInterface != null)
    {
      this.adapter.getLogger().i("AVPreload|Core", "initReportData taskId: " + paramAVPreloadTaskInterface.j(), new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Long = paramAVPreloadTaskInterface.a();
      AVPreloadTaskInterface.TaskReportInfo localTaskReportInfo = paramAVPreloadTaskInterface.a();
      if (localTaskReportInfo != null)
      {
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_Long = (localTaskReportInfo.a() / 1024);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_Long = localTaskReportInfo.b();
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_Long = localTaskReportInfo.a();
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Boolean = localTaskReportInfo.a();
      }
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Long = paramAVPreloadTaskInterface.a();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Long = paramAVPreloadTaskInterface.b();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Int = paramAVPreloadTaskInterface.a();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_l_of_type_JavaLangString = ("" + paramAVPreloadTaskInterface.j());
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Int = paramAVPreloadTaskInterface.d();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Long = paramAVPreloadTaskInterface.c();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_k_of_type_Long = paramAVPreloadTaskInterface.i();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Int = paramAVPreloadTaskInterface.b();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Int = paramAVPreloadTaskInterface.c();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.e = paramAVPreloadTaskInterface.d();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_JavaLangString = paramAVPreloadTaskInterface.b();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_l_of_type_Long = paramAVPreloadTaskInterface.e();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.m = (paramAVPreloadTaskInterface.h() / 1024L);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null)
    {
      String str = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl();
      if ((!str.startsWith("http://127.0.0.1")) && (paramBoolean)) {
        this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().url = this.mPreloadAdapter.a(str);
      }
      StringBuffer localStringBuffer = new StringBuffer("preparePlay()---preparePlay remote url= ");
      localStringBuffer.append(str);
      localStringBuffer.append(" local url= ");
      localStringBuffer.append(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().url);
      this.adapter.getLogger().i("AVPreload|Core", localStringBuffer.toString(), new Object[0]);
      this.mPreloadAdapter.d(str);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_JavaLangString = str;
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.openPlay();
    }
  }
  
  public void clearEventOutput() {}
  
  public long getCurrentPositionMs()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      return this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public Rect getDisplayViewRect()
  {
    return this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getDisplayViewRect();
  }
  
  public long getVideoDurationMs()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      return this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getDurationMs();
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
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setLog(new AVPreloadPlayerService.2(this));
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.initTPPlayerId(this.adapter.getAppInfo().getTPPlayerGuid(), this.adapter.getAppInfo().getTPPlatform(), this.adapter.getAppInfo().isNeedInitTPPlatform());
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.init(paramContext);
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.readyPlay(paramFrameLayout, false);
  }
  
  public boolean isPaused()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      return this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.isPaused();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      return this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.isPlaying();
    }
    return false;
  }
  
  public boolean isUseLocalServerPreload()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      return PreloadUtil.a(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl(), this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getCurrentParams().videoType);
    }
    return false;
  }
  
  public void mutePlay(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.mutePlay(paramBoolean);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mPreloadAdapter != null)
    {
      this.mPreloadAdapter.b(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl());
      this.mPreloadAdapter.a(this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfaceAVPlayerPreloadAdapter$AVPreloadListener);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onScreenOrientationChange(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.onScreenOrientationChange(paramBoolean);
    }
  }
  
  public void pausePlay()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.pausePlay();
    }
  }
  
  public void preload()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null)
    {
      this.adapter.getLogger().i("AVPreload|Core", "preload()---preload start url= " + this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl(), new Object[0]);
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
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.readyPlay(paramFrameLayout, paramBoolean);
    }
  }
  
  public void reportPreloadData(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_i_of_type_JavaLangString = a();
    if ((this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_Long > 0L)) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_i_of_type_Long = (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_Long / this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_JavaLangString = this.adapter.getNickName();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_JavaLangString = ("" + this.adapter.getRoomId());
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_JavaLangString = ("" + this.adapter.getAnchorUin());
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_k_of_type_JavaLangString = "event_close_room";
    Object localObject = this.adapter.getAppInfo();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_JavaLangString = ((AppGeneralInfoService)localObject).getVersionName();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_JavaLangString = ((AppGeneralInfoService)localObject).getSource();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.f = ((AppGeneralInfoService)localObject).getGuid();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_JavaLangString = ((AppGeneralInfoService)localObject).getApplication().getPackageName();
    }
    if (jdField_c_of_type_Long == 0L) {
      jdField_c_of_type_Long = a(this.appContext);
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.n = jdField_c_of_type_Long;
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Boolean = paramBoolean;
    localObject = new AVPreloadReport();
    ((AVPreloadReport)localObject).a(this.adapter.getHttp());
    ((AVPreloadReport)localObject).a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData);
    ((AVPreloadReport)localObject).a(this.adapter.getLogger());
    ((AVPreloadReport)localObject).b();
  }
  
  public void resetPlayer()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.reset();
    }
  }
  
  public void resumePlay()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.resumePlay();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.seek(paramInt);
    }
  }
  
  public void setParams(PlayerParams paramPlayerParams)
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null)
    {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setParams(a(paramPlayerParams));
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setOffsetY(paramPlayerParams.offsetY);
    }
    a(this.mPreloadAdapter.a(paramPlayerParams.getPlayUrl()));
  }
  
  public void setPlayerStatusListener(PlayerStatusListener paramPlayerStatusListener)
  {
    if (this.mStatusListener == paramPlayerStatusListener) {
      this.adapter.getLogger().i("AVPreloadPlayerService", "setPlayerStatusListener is same return", new Object[0]);
    }
    do
    {
      return;
      super.setPlayerStatusListener(paramPlayerStatusListener);
    } while (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper == null);
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setPlayerStatusListener(new AVPreloadPlayerService.3(this, paramPlayerStatusListener));
  }
  
  public void setPlayerSurface()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setPlayerSurface();
    }
  }
  
  public void startPlay()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.startPlay();
    }
  }
  
  public void stopPlay()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.stopPlay();
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
      if (this.mPreloadAdapter != null) {
        this.mPreloadAdapter.c(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.getPlayUrl());
      }
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.setPlayerStatusListener(null);
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerLiveSdkPlayerHelper.uninit();
    }
    this.jdField_a_of_type_Int = 0;
    ThreadCenter.clear(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService
 * JD-Core Version:    0.7.0.1
 */