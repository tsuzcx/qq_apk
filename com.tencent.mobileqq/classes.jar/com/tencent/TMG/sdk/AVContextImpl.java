package com.tencent.TMG.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.SurfaceHolder;
import com.tencent.TMG.channel.AVAppChannel;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.channel.KSAppChannel;
import com.tencent.TMG.mediacodec.AndroidCodec;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.utils.PhoneStatusTools;
import com.tencent.TMG.utils.QLog;
import com.tencent.TMG.utils.SoUtil;
import com.tencent.xplatform.MainThreadHelp;
import java.io.File;

class AVContextImpl
  extends AVContext
{
  private static final String TAG = "SdkJni";
  private static int sExtractSoError = 0;
  private static boolean sLoadLibrary = false;
  private Handler handler = new Handler();
  private boolean isUpdateTips = false;
  private Context mAppContext = null;
  private AVAudioCtrl mAudioCtrl = null;
  private AVAudioEffectCtrl mAudioEffectCtrl = null;
  private int mNativeEntity = 0;
  private AVVideoCtrl mVideoCtrl = null;
  private AVRoomMulti room = null;
  private Runnable tipsUpdate = new AVContextImpl.2(this);
  
  private static void configUpdate()
  {
    QLog.i("SdkJni", 0, "configUpdate");
    int i = AndroidCodec.checkSupportMediaCodecFeature();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Rson] check hardware feature: ");
    ((StringBuilder)localObject).append(i);
    QLog.i("SdkJni", 0, ((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder;
    if (i > 0)
    {
      if ((i & 0x1) == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append("HW_AVC_DEC=1;");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append("HW_AVC_DEC=0;");
        localObject = ((StringBuilder)localObject).toString();
      }
      if ((i & 0x2) == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("HW_AVC_ENC=1;");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("HW_AVC_ENC=0;");
        localObject = localStringBuilder.toString();
      }
      if ((i & 0x4) == 4)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("HW_HEVC_DEC=1;");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("HW_HEVC_DEC=0;");
        localObject = localStringBuilder.toString();
      }
      if ((i & 0x8) == 8)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("HW_HEVC_ENC=1;");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("HW_HEVC_ENC=0;");
        localObject = localStringBuilder.toString();
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append("HW_AVC_ENC=0;");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("HW_AVC_DEC=0;");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("HW_HEVC_DEC=0;");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("HW_HEVC_ENC=0;");
      localObject = localStringBuilder.toString();
    }
    nativeUpdateConfig((String)localObject);
  }
  
  public static int getSoExtractError()
  {
    return sExtractSoError;
  }
  
  public static String getVersion()
  {
    if (sLoadLibrary) {
      return nativeGetVersion();
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  private void initDeviceInfos(Context paramContext)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("PRODUCT=");
    ((StringBuilder)localObject1).append(Build.PRODUCT);
    ((StringBuilder)localObject1).append(";");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("CPU_ABI=");
    ((StringBuilder)localObject2).append(Build.CPU_ABI);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("TAGS=");
    ((StringBuilder)localObject2).append(Build.TAGS);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("VERSION_CODES_BASE=1;");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("MODEL=");
    ((StringBuilder)localObject2).append(Build.MODEL);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("SDK=");
    ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("VERSION_RELEASE=");
    ((StringBuilder)localObject2).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("DEVICE=");
    ((StringBuilder)localObject2).append(Build.DEVICE);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("DISPLAY=");
    ((StringBuilder)localObject2).append(Build.DISPLAY);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("BRAND=");
    ((StringBuilder)localObject2).append(Build.BRAND);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("BOARD=");
    ((StringBuilder)localObject2).append(Build.BOARD);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("FINGERPRINT=");
    ((StringBuilder)localObject2).append(Build.FINGERPRINT);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("ID=");
    ((StringBuilder)localObject2).append(Build.ID);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("MANUFACTURER=");
    ((StringBuilder)localObject2).append(Build.MANUFACTURER);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("USER=");
    ((StringBuilder)localObject2).append(Build.USER);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("PROCESSORS=");
    ((StringBuilder)localObject2).append(Runtime.getRuntime().availableProcessors());
    ((StringBuilder)localObject2).append(";");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = paramContext.getApplicationInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("DATADIR=");
    localStringBuilder.append(((ApplicationInfo)localObject1).dataDir);
    localStringBuilder.append(";");
    localObject2 = localStringBuilder.toString();
    if (Build.VERSION.SDK_INT >= 9)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("LIBDIR=");
      localStringBuilder.append(((ApplicationInfo)localObject1).nativeLibraryDir);
      localStringBuilder.append(";");
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("LIBDIR=");
      localStringBuilder.append(((ApplicationInfo)localObject1).dataDir);
      localStringBuilder.append("/lib;");
      localObject1 = localStringBuilder.toString();
    }
    localObject2 = localObject1;
    if (SoUtil.customLibPath != null)
    {
      localObject2 = localObject1;
      if (!SoUtil.customLibPath.equalsIgnoreCase(""))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("CSTLIBDIR=");
        ((StringBuilder)localObject2).append(SoUtil.customLibPath);
        ((StringBuilder)localObject2).append(";");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    AndroidCodec.setDeviceInfos(paramContext);
    int i = AndroidCodec.checkSupportMediaCodecFeature();
    paramContext = new StringBuilder();
    paramContext.append("[Rson] check hardware feature: ");
    paramContext.append(i);
    Log.i("SdkJni", paramContext.toString());
    if (i > 0)
    {
      if ((i & 0x1) == 1)
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject2);
        paramContext.append("HW_AVC_DEC=1;");
        paramContext = paramContext.toString();
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject2);
        paramContext.append("HW_AVC_DEC=0;");
        paramContext = paramContext.toString();
      }
      if ((i & 0x2) == 2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext);
        ((StringBuilder)localObject1).append("HW_AVC_ENC=1;");
        paramContext = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext);
        ((StringBuilder)localObject1).append("HW_AVC_ENC=0;");
        paramContext = ((StringBuilder)localObject1).toString();
      }
      if ((i & 0x4) == 4)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext);
        ((StringBuilder)localObject1).append("HW_HEVC_DEC=1;");
        paramContext = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext);
        ((StringBuilder)localObject1).append("HW_HEVC_DEC=0;");
        paramContext = ((StringBuilder)localObject1).toString();
      }
      if ((i & 0x8) == 8)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext);
        ((StringBuilder)localObject1).append("HW_HEVC_ENC=1;");
        paramContext = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext);
        ((StringBuilder)localObject1).append("HW_HEVC_ENC=0;");
        paramContext = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append((String)localObject2);
      paramContext.append("HW_AVC_ENC=0;");
      paramContext = paramContext.toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append("HW_AVC_DEC=0;");
      paramContext = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append("HW_HEVC_DEC=0;");
      paramContext = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append("HW_HEVC_ENC=0;");
      paramContext = ((StringBuilder)localObject1).toString();
    }
    nativeSetAndroidAppPath(paramContext);
  }
  
  private void initLogSetting(Context paramContext)
  {
    String str = getVersion();
    if (str == null)
    {
      Log.e("SdkJni", "getVersion() null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avsdk version");
    localStringBuilder.append(str);
    Log.e("SdkJni", localStringBuilder.toString());
    int i = str.lastIndexOf('.');
    if (-1 == i)
    {
      Log.e("SdkJni", "fullSDKVersion error");
      return;
    }
    AVLoggerClient.initLogSetting(paramContext, str.substring(0, i));
  }
  
  private static boolean loadSdkLibrary()
  {
    sLoadLibrary = AVSDKLibLoader.loadSdkLibrary();
    return sLoadLibrary;
  }
  
  private native int nativeCreate(Context paramContext);
  
  private native void nativeDestroy(int paramInt);
  
  private native void nativeEnterRoom(int paramInt, Context paramContext, AVRoomMulti.EventListener paramEventListener, AVRoomMulti.EnterParam paramEnterParam);
  
  private native int nativeExitRoom(int paramInt);
  
  private native AVCloudSpearEngineCtrl nativeGetCloudSpearEngineCtrl(int paramInt);
  
  private native AVCustomSpearEngineCtrl nativeGetCustomSpearEngineCtrl(int paramInt);
  
  private static native String nativeGetParam(int paramInt, String paramString);
  
  private native AVRoomMulti nativeGetRoom(int paramInt, AVRoomMulti paramAVRoomMulti);
  
  private static native String nativeGetVersion();
  
  private native void nativeInitNetType(int paramInt1, int paramInt2);
  
  private native void nativeInternalEnterRoom(int paramInt, Context paramContext, AVRoomMulti.EventListener paramEventListener, AVRoomMulti.EnterParam paramEnterParam);
  
  private native void nativeSetAndroidAppPath(String paramString);
  
  private static native void nativeSetAppVersion(String paramString);
  
  private native int nativeSetEffectTime(int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeSetLocalConfigDirectory(String paramString);
  
  private static native int nativeSetParam(int paramInt, String paramString1, String paramString2);
  
  private native void nativeSetRenderMgr(int paramInt1, int paramInt2);
  
  private native void nativeSetSurfaceHolder(int paramInt, SurfaceHolder paramSurfaceHolder);
  
  private native void nativeSetTwoSecondReportPath(String paramString);
  
  private native void nativeStart(int paramInt, AVContext.StartParam paramStartParam, AVCallback paramAVCallback);
  
  private native int nativeStop(int paramInt);
  
  private native void nativeSwitchRoom(int paramInt1, int paramInt2);
  
  private native void nativeSwitchRoomWithChangingInfo(int paramInt, AVRoomMulti.ChangeRoomInfo paramChangeRoomInfo);
  
  private native void nativeTestThreadKey();
  
  private static native void nativeUpdateConfig(String paramString);
  
  private void startTipsTimer()
  {
    if (!this.isUpdateTips)
    {
      this.isUpdateTips = true;
      this.handler.postDelayed(this.tipsUpdate, 30000L);
    }
  }
  
  private void stopTipsTimer()
  {
    this.isUpdateTips = false;
    this.handler.removeCallbacks(this.tipsUpdate);
  }
  
  public int codecTranslate(String paramString1, String paramString2, int paramInt)
  {
    return nativeCodecTranslate(this.mNativeEntity, paramString1, paramString2, paramInt);
  }
  
  public boolean create(Context paramContext, boolean paramBoolean)
  {
    Looper localLooper1 = Looper.myLooper();
    Looper localLooper2 = Looper.getMainLooper();
    boolean bool = false;
    if (localLooper1 != localLooper2)
    {
      Log.e("SdkJni", "create context not in main thread");
      return false;
    }
    if (paramBoolean)
    {
      SoUtil.setAppContext(paramContext.getApplicationContext());
      SoUtil.setCopySoInfo(paramBoolean);
      sExtractSoError = SoUtil.extractAVModulesFromAssets();
    }
    if (sExtractSoError != 0)
    {
      paramContext = new StringBuilder();
      paramContext.append("create context , sExtractSoError = ");
      paramContext.append(sExtractSoError);
      Log.e("SdkJni", paramContext.toString());
      return false;
    }
    if (loadSdkLibrary())
    {
      this.mAppContext = paramContext.getApplicationContext();
      initLogSetting(paramContext);
      this.mNativeEntity = nativeCreate(this.mAppContext);
    }
    paramBoolean = bool;
    if (this.mNativeEntity != 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public void destroy()
  {
    Object localObject = this.mAudioCtrl;
    if (localObject != null)
    {
      ((AVAudioCtrl)localObject).uninit();
      this.mAudioCtrl = null;
    }
    localObject = this.mVideoCtrl;
    if (localObject != null)
    {
      ((AVVideoCtrl)localObject).unInit();
      this.mVideoCtrl = null;
    }
    localObject = this.mAudioEffectCtrl;
    if (localObject != null)
    {
      ((AVAudioEffectCtrl)localObject).uninit();
      this.mAudioEffectCtrl = null;
    }
    nativeDestroy(this.mNativeEntity);
    this.mNativeEntity = 0;
    if (SoUtil.getCopySoInfo()) {
      SoUtil.releaseAppContext();
    }
    this.mAppContext = null;
  }
  
  public void enterRoom(AVRoomMulti.EventListener paramEventListener, AVRoomMulti.EnterParam paramEnterParam)
  {
    Context localContext = this.mAppContext;
    if (localContext != null) {
      nativeInitNetType(this.mNativeEntity, PhoneStatusTools.getNetWorkType(localContext));
    }
    Log.d("SdkJni", "enterRoom");
    if (paramEnterParam == null) {
      MainThreadHelp.postRunnable(new AVContextImpl.1(this, paramEventListener));
    }
    if ((paramEnterParam instanceof InternalEnterParam))
    {
      QLog.i("SdkJni", 0, "InternalEnterRoom run.");
      nativeInternalEnterRoom(this.mNativeEntity, this.mAppContext, paramEventListener, paramEnterParam);
    }
    else
    {
      QLog.i("SdkJni", 0, "ExternalEnterRoom run.");
      nativeEnterRoom(this.mNativeEntity, this.mAppContext, paramEventListener, paramEnterParam);
    }
    startTipsTimer();
    paramEventListener = getVideoCtrl();
    if (paramEventListener != null) {
      paramEventListener.resetTime();
    }
  }
  
  public int exitRoom()
  {
    stopTipsTimer();
    Object localObject = getVideoCtrl();
    if (localObject != null)
    {
      int i = ((AVVideoCtrl)localObject).getFilterTime();
      int j = ((AVVideoCtrl)localObject).getPendantTime();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("geteffectTime");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(j);
      QLog.d("SdkJni", 0, ((StringBuilder)localObject).toString());
      nativeSetEffectTime(this.mNativeEntity, i, j);
    }
    return nativeExitRoom(this.mNativeEntity);
  }
  
  public AVAudioCtrl getAudioCtrl()
  {
    if (this.mAudioCtrl == null) {
      this.mAudioCtrl = new AVAudioCtrl();
    }
    this.mAudioCtrl.init(this.mAppContext, this.mNativeEntity);
    return this.mAudioCtrl;
  }
  
  public AVAudioEffectCtrl getAudioEffectCtrl()
  {
    if (this.mAudioEffectCtrl == null) {
      this.mAudioEffectCtrl = new AVAudioEffectCtrl();
    }
    this.mAudioEffectCtrl.init(this.mAppContext, this.mNativeEntity);
    return this.mAudioEffectCtrl;
  }
  
  public AVCloudSpearEngineCtrl getCloudSpearEngineCtrl()
  {
    return nativeGetCloudSpearEngineCtrl(this.mNativeEntity);
  }
  
  public AVCustomSpearEngineCtrl getCustomSpearEngineCtrl()
  {
    return nativeGetCustomSpearEngineCtrl(this.mNativeEntity);
  }
  
  public String getParam(String paramString)
  {
    return nativeGetParam(this.mNativeEntity, paramString);
  }
  
  public AVRoomMulti getRoom()
  {
    return nativeGetRoom(this.mNativeEntity, this.room);
  }
  
  public AVVideoCtrl getVideoCtrl()
  {
    if (this.mVideoCtrl == null) {
      this.mVideoCtrl = new AVVideoCtrl();
    }
    this.mVideoCtrl.init(this.mNativeEntity);
    return this.mVideoCtrl;
  }
  
  native int nativeCodecTranslate(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  native int nativeStartPreservingEncData(int paramInt, String paramString1, String paramString2);
  
  native int nativeStopPreservingEncData(int paramInt);
  
  public void setAppVersion(String paramString)
  {
    nativeSetAppVersion(paramString);
  }
  
  public int setParam(String paramString1, String paramString2)
  {
    return nativeSetParam(this.mNativeEntity, paramString1, paramString2);
  }
  
  public int setRenderMgr(GraphicRendererMgr paramGraphicRendererMgr)
  {
    if (getRoom() == null)
    {
      QLog.e("SdkJni", 0, "AV_ERR_ROOM_NOT_EXIST");
      return 1201;
    }
    if (paramGraphicRendererMgr == null) {
      return 1;
    }
    nativeSetRenderMgr(this.mNativeEntity, paramGraphicRendererMgr.getRecvDecoderFrameFunctionptr());
    return 0;
  }
  
  public int setRenderMgrAndHolder(GraphicRendererMgr paramGraphicRendererMgr, SurfaceHolder paramSurfaceHolder)
  {
    if (paramGraphicRendererMgr == null) {
      return 1;
    }
    nativeSetRenderMgr(this.mNativeEntity, paramGraphicRendererMgr.getRecvDecoderFrameFunctionptr());
    nativeSetSurfaceHolder(this.mNativeEntity, paramSurfaceHolder);
    return 0;
  }
  
  public int setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    if (getRoom() == null)
    {
      QLog.e("SdkJni", 0, "AV_ERR_ROOM_NOT_EXIST");
      return 1201;
    }
    nativeSetSurfaceHolder(this.mNativeEntity, paramSurfaceHolder);
    return 0;
  }
  
  public void start(AVContext.StartParam paramStartParam, AVCallback paramAVCallback)
  {
    int i = AVChannelManager.getIMChannelType();
    if (i == 1)
    {
      AVChannelManager.setAppChannel(new KSAppChannel());
      AVChannelManager.getAppChannel().loginWithParam(paramStartParam);
    }
    else if (i == 0)
    {
      AVChannelManager.setAppChannel(null);
    }
    initDeviceInfos(this.mAppContext);
    nativeSetTwoSecondReportPath(AVLoggerClient.getLogDir());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mAppContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/");
    nativeSetLocalConfigDirectory(localStringBuilder.toString());
    paramAVCallback = new AVContextImpl.AVStartCallback(this, paramStartParam, paramAVCallback);
    nativeStart(this.mNativeEntity, paramStartParam, paramAVCallback);
  }
  
  public void start(AVContext.StartParam paramStartParam, AVSDKLogSetting paramAVSDKLogSetting, AVCallback paramAVCallback)
  {
    int i = AVChannelManager.getIMChannelType();
    if (i == 1)
    {
      AVChannelManager.setAppChannel(new KSAppChannel());
      AVChannelManager.getAppChannel().loginWithParam(paramStartParam);
    }
    else if (i == 0)
    {
      AVChannelManager.setAppChannel(null);
    }
    if (paramAVSDKLogSetting != null) {
      AVLoggerClient.setLogSetting(paramAVSDKLogSetting);
    }
    initDeviceInfos(this.mAppContext);
    nativeSetTwoSecondReportPath(AVLoggerClient.getLogDir());
    paramAVSDKLogSetting = new StringBuilder();
    paramAVSDKLogSetting.append(this.mAppContext.getFilesDir().getAbsolutePath());
    paramAVSDKLogSetting.append("/");
    nativeSetLocalConfigDirectory(paramAVSDKLogSetting.toString());
    paramAVSDKLogSetting = new AVContextImpl.AVStartCallback(this, paramStartParam, paramAVCallback);
    nativeStart(this.mNativeEntity, paramStartParam, paramAVSDKLogSetting);
  }
  
  public int startPreservingEncData(String paramString1, String paramString2)
  {
    return nativeStartPreservingEncData(this.mNativeEntity, paramString1, paramString2);
  }
  
  public int stop()
  {
    return nativeStop(this.mNativeEntity);
  }
  
  public int stopPreservingEncData()
  {
    return nativeStopPreservingEncData(this.mNativeEntity);
  }
  
  public void switchRoom(int paramInt)
  {
    nativeSwitchRoom(this.mNativeEntity, paramInt);
  }
  
  public void switchRoom(AVRoomMulti.ChangeRoomInfo paramChangeRoomInfo)
  {
    nativeSwitchRoomWithChangingInfo(this.mNativeEntity, paramChangeRoomInfo);
  }
  
  public void testThreadKey()
  {
    nativeTestThreadKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVContextImpl
 * JD-Core Version:    0.7.0.1
 */