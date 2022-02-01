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
    QLog.i("SdkJni", 0, "[Rson] check hardware feature: " + i);
    String str;
    if (i > 0) {
      if ((i & 0x1) == 1)
      {
        str = "" + "HW_AVC_DEC=1;";
        if ((i & 0x2) != 2) {
          break label181;
        }
        str = str + "HW_AVC_ENC=1;";
        label96:
        if ((i & 0x4) != 4) {
          break label204;
        }
        str = str + "HW_HEVC_DEC=1;";
        label123:
        if ((i & 0x8) != 8) {
          break label227;
        }
        str = str + "HW_HEVC_ENC=1;";
      }
    }
    for (;;)
    {
      nativeUpdateConfig(str);
      return;
      str = "" + "HW_AVC_DEC=0;";
      break;
      label181:
      str = str + "HW_AVC_ENC=0;";
      break label96;
      label204:
      str = str + "HW_HEVC_DEC=0;";
      break label123;
      label227:
      str = str + "HW_HEVC_ENC=0;";
      continue;
      str = "" + "HW_AVC_ENC=0;";
      str = str + "HW_AVC_DEC=0;";
      str = str + "HW_HEVC_DEC=0;";
      str = str + "HW_HEVC_ENC=0;";
    }
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
    Object localObject1 = "PRODUCT=" + Build.PRODUCT + ";";
    localObject1 = (String)localObject1 + "CPU_ABI=" + Build.CPU_ABI + ";";
    localObject1 = (String)localObject1 + "TAGS=" + Build.TAGS + ";";
    localObject1 = (String)localObject1 + "VERSION_CODES_BASE=1;";
    localObject1 = (String)localObject1 + "MODEL=" + Build.MODEL + ";";
    localObject1 = (String)localObject1 + "SDK=" + Build.VERSION.SDK_INT + ";";
    localObject1 = (String)localObject1 + "VERSION_RELEASE=" + Build.VERSION.RELEASE + ";";
    localObject1 = (String)localObject1 + "DEVICE=" + Build.DEVICE + ";";
    localObject1 = (String)localObject1 + "DISPLAY=" + Build.DISPLAY + ";";
    localObject1 = (String)localObject1 + "BRAND=" + Build.BRAND + ";";
    localObject1 = (String)localObject1 + "BOARD=" + Build.BOARD + ";";
    localObject1 = (String)localObject1 + "FINGERPRINT=" + Build.FINGERPRINT + ";";
    localObject1 = (String)localObject1 + "ID=" + Build.ID + ";";
    localObject1 = (String)localObject1 + "MANUFACTURER=" + Build.MANUFACTURER + ";";
    localObject1 = (String)localObject1 + "USER=" + Build.USER + ";";
    Object localObject2 = (String)localObject1 + "PROCESSORS=" + Runtime.getRuntime().availableProcessors() + ";";
    localObject1 = paramContext.getApplicationInfo();
    localObject2 = (String)localObject2 + "DATADIR=" + ((ApplicationInfo)localObject1).dataDir + ";";
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).nativeLibraryDir + ";";
      localObject2 = localObject1;
      if (SoUtil.customLibPath != null)
      {
        localObject2 = localObject1;
        if (!SoUtil.customLibPath.equalsIgnoreCase("")) {
          localObject2 = (String)localObject1 + "CSTLIBDIR=" + SoUtil.customLibPath + ";";
        }
      }
      AndroidCodec.setDeviceInfos(paramContext);
      int i = AndroidCodec.checkSupportMediaCodecFeature();
      Log.i("SdkJni", "[Rson] check hardware feature: " + i);
      if (i <= 0) {
        break label905;
      }
      if ((i & 0x1) != 1) {
        break label812;
      }
      paramContext = (String)localObject2 + "HW_AVC_DEC=1;";
      label686:
      if ((i & 0x2) != 2) {
        break label836;
      }
      paramContext = paramContext + "HW_AVC_ENC=1;";
      label713:
      if ((i & 0x4) != 4) {
        break label859;
      }
      paramContext = paramContext + "HW_HEVC_DEC=1;";
      label740:
      if ((i & 0x8) != 8) {
        break label882;
      }
      paramContext = paramContext + "HW_HEVC_ENC=1;";
    }
    for (;;)
    {
      nativeSetAndroidAppPath(paramContext);
      return;
      localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).dataDir + "/lib;";
      break;
      label812:
      paramContext = (String)localObject2 + "HW_AVC_DEC=0;";
      break label686;
      label836:
      paramContext = paramContext + "HW_AVC_ENC=0;";
      break label713;
      label859:
      paramContext = paramContext + "HW_HEVC_DEC=0;";
      break label740;
      label882:
      paramContext = paramContext + "HW_HEVC_ENC=0;";
      continue;
      label905:
      paramContext = (String)localObject2 + "HW_AVC_ENC=0;";
      paramContext = paramContext + "HW_AVC_DEC=0;";
      paramContext = paramContext + "HW_HEVC_DEC=0;";
      paramContext = paramContext + "HW_HEVC_ENC=0;";
    }
  }
  
  private void initLogSetting(Context paramContext)
  {
    String str = getVersion();
    if (str == null)
    {
      Log.e("SdkJni", "getVersion() null");
      return;
    }
    Log.e("SdkJni", "avsdk version" + str);
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
    if (Looper.myLooper() != Looper.getMainLooper()) {
      Log.e("SdkJni", "create context not in main thread");
    }
    do
    {
      return false;
      if (paramBoolean)
      {
        SoUtil.setAppContext(paramContext.getApplicationContext());
        SoUtil.setCopySoInfo(paramBoolean);
        sExtractSoError = SoUtil.extractAVModulesFromAssets();
      }
      if (sExtractSoError != 0)
      {
        Log.e("SdkJni", "create context , sExtractSoError = " + sExtractSoError);
        return false;
      }
      if (loadSdkLibrary())
      {
        this.mAppContext = paramContext.getApplicationContext();
        initLogSetting(paramContext);
        this.mNativeEntity = nativeCreate(this.mAppContext);
      }
    } while (this.mNativeEntity == 0);
    return true;
  }
  
  public void destroy()
  {
    if (this.mAudioCtrl != null)
    {
      this.mAudioCtrl.uninit();
      this.mAudioCtrl = null;
    }
    if (this.mVideoCtrl != null)
    {
      this.mVideoCtrl.unInit();
      this.mVideoCtrl = null;
    }
    if (this.mAudioEffectCtrl != null)
    {
      this.mAudioEffectCtrl.uninit();
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
    if (this.mAppContext != null) {
      nativeInitNetType(this.mNativeEntity, PhoneStatusTools.getNetWorkType(this.mAppContext));
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
    for (;;)
    {
      startTipsTimer();
      paramEventListener = getVideoCtrl();
      if (paramEventListener != null) {
        paramEventListener.resetTime();
      }
      return;
      QLog.i("SdkJni", 0, "ExternalEnterRoom run.");
      nativeEnterRoom(this.mNativeEntity, this.mAppContext, paramEventListener, paramEnterParam);
    }
  }
  
  public int exitRoom()
  {
    stopTipsTimer();
    AVVideoCtrl localAVVideoCtrl = getVideoCtrl();
    if (localAVVideoCtrl != null)
    {
      int i = localAVVideoCtrl.getFilterTime();
      int j = localAVVideoCtrl.getPendantTime();
      QLog.d("SdkJni", 0, "geteffectTime" + i + j);
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
    for (;;)
    {
      initDeviceInfos(this.mAppContext);
      nativeSetTwoSecondReportPath(AVLoggerClient.getLogDir());
      nativeSetLocalConfigDirectory(this.mAppContext.getFilesDir().getAbsolutePath() + "/");
      paramAVCallback = new AVContextImpl.AVStartCallback(this, paramStartParam, paramAVCallback);
      nativeStart(this.mNativeEntity, paramStartParam, paramAVCallback);
      return;
      if (i == 0) {
        AVChannelManager.setAppChannel(null);
      }
    }
  }
  
  public void start(AVContext.StartParam paramStartParam, AVSDKLogSetting paramAVSDKLogSetting, AVCallback paramAVCallback)
  {
    int i = AVChannelManager.getIMChannelType();
    if (i == 1)
    {
      AVChannelManager.setAppChannel(new KSAppChannel());
      AVChannelManager.getAppChannel().loginWithParam(paramStartParam);
    }
    for (;;)
    {
      if (paramAVSDKLogSetting != null) {
        AVLoggerClient.setLogSetting(paramAVSDKLogSetting);
      }
      initDeviceInfos(this.mAppContext);
      nativeSetTwoSecondReportPath(AVLoggerClient.getLogDir());
      nativeSetLocalConfigDirectory(this.mAppContext.getFilesDir().getAbsolutePath() + "/");
      paramAVSDKLogSetting = new AVContextImpl.AVStartCallback(this, paramStartParam, paramAVCallback);
      nativeStart(this.mNativeEntity, paramStartParam, paramAVSDKLogSetting);
      return;
      if (i == 0) {
        AVChannelManager.setAppChannel(null);
      }
    }
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