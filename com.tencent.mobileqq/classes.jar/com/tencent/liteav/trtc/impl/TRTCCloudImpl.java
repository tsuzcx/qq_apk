package com.tencent.liteav.trtc.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.TXCRenderAndDec.b;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceChangerType;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceReverbType;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXCSoundEffectPlayer;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d.a;
import com.tencent.liteav.g;
import com.tencent.liteav.g.a;
import com.tencent.liteav.h;
import com.tencent.liteav.o;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.liteav.videoencoder.b.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloud.BGMNotify;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioEffectParam;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioRecordingParams;
import com.tencent.trtc.TRTCCloudDef.TRTCNetworkQosParam;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCPublishCDNParam;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCRemoteStatistics;
import com.tencent.trtc.TRTCSubCloud;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class TRTCCloudImpl
  extends TRTCCloud
  implements SurfaceHolder.Callback, TXCRenderAndDec.b, com.tencent.liteav.audio.b, com.tencent.liteav.audio.c, com.tencent.liteav.audio.d, com.tencent.liteav.audio.e, com.tencent.liteav.audio.f, com.tencent.liteav.basic.b.b, d.a, o, a.a
{
  private static final int DEFAULT_FPS_FOR_SCREEN_CAPTURE = 10;
  private static final int DEFAULT_GOP_FOR_SCREEN_CAPTURE = 3;
  private static final String KEY_CONFIG_ADJUST_RESOLUTION = "config_adjust_resolution";
  private static final String KEY_CONFIG_FPS = "config_fps";
  private static final String KEY_CONFIG_GOP = "config_gop";
  private static final int MIN_VOLUME_EVALUATION_INTERVAL_MS = 100;
  private static final int RECV_MODE_AUTO_AUDIO_ONLY = 2;
  private static final int RECV_MODE_AUTO_AUDIO_VIDEO = 1;
  private static final int RECV_MODE_AUTO_VIDEO_ONLY = 3;
  private static final int RECV_MODE_MANUAL = 4;
  private static final int RECV_MODE_UNKNOWN = 0;
  protected static final int ROOM_STATE_ENTRING = 1;
  private static final int ROOM_STATE_IN = 2;
  protected static final int ROOM_STATE_OUT = 0;
  private static final int STATE_INTERVAL = 2000;
  private static final String TAG = "TRTCCloudImpl";
  private static TRTCCloudImpl sInstance;
  protected int mAppScene;
  private int mAudioCaptureVolume = 100;
  protected TRTCCloudListener.TRTCAudioFrameListener mAudioFrameListener = null;
  private int mAudioPlayoutVolume = 100;
  protected int mAudioVolumeEvalInterval = 0;
  private TRTCCloud.BGMNotify mBGMNotify;
  private int mBackground = -1;
  private com.tencent.liteav.basic.b.a mCallback = new TRTCCloudImpl.1(this);
  protected com.tencent.liteav.d mCaptureAndEnc;
  private long mCaptureFrameCount = 0L;
  private int mCodecType = 2;
  protected g mConfig;
  protected Context mContext;
  private int mCurrentOrientation = -1;
  protected HashMap<Integer, TRTCCloudImpl> mCurrentPublishClouds = new HashMap();
  protected int mCurrentRole = 20;
  private boolean mCustomRemoteRender = false;
  private TRTCCustomTextureUtil mCustomVideoUtil = null;
  protected int mDebugType = 0;
  private Display mDisplay;
  private boolean mEnableCustomAudioCapture = false;
  protected boolean mEnableEosMode = false;
  private boolean mEnableHighQualityEncode = false;
  private boolean mEnableHighQualityEncodeFromServer = false;
  private boolean mEnableSmallStream = false;
  private boolean mEnableSoftAEC = true;
  private boolean mEnableSoftAGC = false;
  private boolean mEnableSoftANS = false;
  private View mFloatingWindow = null;
  private int mFramework = 1;
  private boolean mIsAudioCapturing;
  protected boolean mIsExitOldRoom;
  private AtomicBoolean mIsSDKThreadAlive;
  private long mLastCaptureCalculateTS = 0L;
  private long mLastCaptureFrameCount = 0L;
  private long mLastLogCustomCmdMsgTs;
  private long mLastLogSEIMsgTs;
  private long mLastSendMsgTimeMs;
  protected long mLastStateTimeMs;
  private final Bundle mLatestParamsOfBigEncoder = new Bundle();
  private final Bundle mLatestParamsOfSmallEncoder = new Bundle();
  private Handler mListenerHandler;
  private com.tencent.liteav.basic.util.e mMainHandler;
  protected Object mNativeLock = new Object();
  protected long mNativeRtcContext;
  private int mNetType = -1;
  private TRTCCloudImpl.DisplayOrientationDetector mOrientationEventListener;
  private boolean mOverrideFPSFromUser = false;
  protected int mPerformanceMode = 0;
  protected int mPriorStreamType = 2;
  private int mQosMode = 1;
  private int mQosPreference;
  private long mRecvCustomCmdMsgCountInPeriod;
  protected int mRecvMode;
  private long mRecvSEIMsgCountInPeriod;
  protected HashMap<String, TRTCCloudImpl.RenderListenerAdapter> mRenderListenerMap;
  protected TRTCRoomInfo mRoomInfo;
  protected int mRoomState;
  protected Handler mSDKHandler;
  private int mSendMsgCount;
  private int mSendMsgSize;
  private int mSensorMode;
  private final TRTCCloudDef.TRTCVideoEncParam mSmallEncParam = new TRTCCloudDef.TRTCVideoEncParam();
  private int mSoftAECLevel = 100;
  private int mSoftAGCLevel = 100;
  private int mSoftANSLevel = 100;
  private TRTCCloudImpl.StatusTask mStatusNotifyTask = null;
  private Set<Integer> mStreamTypes;
  protected ArrayList<WeakReference<TRTCCloudImpl>> mSubClouds = new ArrayList();
  protected TRTCCloudListener mTRTCListener;
  protected int mTargetRole = 20;
  private int mVideoRenderMirror = 0;
  private TRTCVideoServerConfig mVideoServerConfig;
  private TRTCCloudImpl.VideoSourceType mVideoSourceType;
  private TRTCCloudImpl.VolumeLevelNotifyTask mVolumeLevelNotifyTask = null;
  final TXAudioEffectManager.TXVoiceReverbType[] reverbTypes = { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
  final TXAudioEffectManager.TXVoiceChangerType[] voiceChangerTypes = { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
  
  static
  {
    com.tencent.liteav.basic.util.f.f();
  }
  
  protected TRTCCloudImpl(Context paramContext)
  {
    init(paramContext, null);
    TXCCommonUtil.setAppContext(this.mContext);
    TXCLog.init();
    TRTCAudioServerConfig localTRTCAudioServerConfig = TRTCAudioServerConfig.loadFromSharedPreferences(paramContext);
    TXCLog.i("TRTCCloudImpl", "audio config from shared preference: %s", new Object[] { localTRTCAudioServerConfig });
    String str = TXCAudioEngine.buildTRAEConfig(paramContext, Boolean.valueOf(localTRTCAudioServerConfig.enableOpenSL), localTRTCAudioServerConfig.isLowLatencySampleRateSupported, localTRTCAudioServerConfig.lowLatencySampleRateBlockTime);
    TXCAudioEngine.CreateInstanceWithoutInitDevice(this.mContext, str);
    TXCAudioEngine.getInstance().clean();
    TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.mCallback));
    TXCAudioEngine.getInstance().enableAutoRestartDevice(localTRTCAudioServerConfig.enableAutoRestartDevice);
    TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(localTRTCAudioServerConfig.maxSelectedPlayStreams);
    TXCAudioEngineJNI.nativeSetAudioPlayoutTunnelEnabled(true);
    this.mCaptureAndEnc = new com.tencent.liteav.d(paramContext);
    this.mCaptureAndEnc.j(2);
    this.mCaptureAndEnc.a(this.mConfig);
    this.mCaptureAndEnc.i(true);
    this.mCaptureAndEnc.g(true);
    this.mCaptureAndEnc.a(this);
    this.mCaptureAndEnc.a(this);
    this.mCaptureAndEnc.setID("18446744073709551615");
    this.mCaptureAndEnc.h(true);
    TXCKeyPointReportProxy.a(this.mContext);
    apiLog("reset audio volume");
    setAudioCaptureVolume(100);
    setAudioPlayoutVolume(100);
    TXCSoundEffectPlayer.getInstance().setSoundEffectListener(this);
  }
  
  protected TRTCCloudImpl(Context paramContext, Handler paramHandler)
  {
    init(paramContext, paramHandler);
    this.mCurrentRole = 21;
    this.mTargetRole = 21;
  }
  
  private void addRemoteStatistics(TXCRenderAndDec paramTXCRenderAndDec, TRTCRoomInfo.UserInfo paramUserInfo, TRTCStatistics paramTRTCStatistics, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    paramTXCRenderAndDec = getRemoteStatistics(paramTXCRenderAndDec, paramUserInfo);
    paramTRTCStatistics.remoteArray.add(paramTXCRenderAndDec);
    paramTRTCStatistics.downLoss = TXCStatus.c(String.valueOf(paramUserInfo.tinyID), 16002);
    TRTCCloudDef.TRTCQuality localTRTCQuality = new TRTCCloudDef.TRTCQuality();
    localTRTCQuality.userId = paramUserInfo.userID;
    localTRTCQuality.quality = getNetworkQuality(paramTRTCStatistics.rtt, paramTXCRenderAndDec.finalLoss);
    paramArrayList.add(localTRTCQuality);
  }
  
  private void addUpStreamType(int paramInt)
  {
    if (!this.mStreamTypes.contains(Integer.valueOf(paramInt))) {
      this.mStreamTypes.add(Integer.valueOf(paramInt));
    }
    addUpstream(paramInt);
  }
  
  private void addUpstream(int paramInt)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      nativeAddUpstream(localTRTCCloudImpl.getNetworkContext(), paramInt);
    }
  }
  
  private void appendDashboardLog(String paramString1, int paramInt, String paramString2)
  {
    appendDashboardLog(paramString1, paramInt, paramString2, "");
  }
  
  private void appendDashboardLog(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString2);
    apiLog(localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && ((this.mRoomInfo.userId == null) || (!paramString1.equalsIgnoreCase(this.mRoomInfo.userId))))
    {
      paramString1 = this.mRoomInfo.getUser(paramString1);
      if (paramString1 != null)
      {
        if (paramInt == 7) {
          paramString1 = paramString1.subRender.view;
        } else {
          paramString1 = paramString1.mainRender.view;
        }
      }
      else {
        paramString1 = null;
      }
    }
    else
    {
      paramString1 = this.mRoomInfo.localView;
    }
    runOnMainThread(new TRTCCloudImpl.166(this, paramString1, paramString2));
  }
  
  private void applyRenderConfig(TXCRenderAndDec paramTXCRenderAndDec)
  {
    h localh = new h();
    localh.h = false;
    if (this.mAppScene == 1) {
      localh.h = true;
    }
    int j = TXCStatus.c("18446744073709551615", 17020);
    int i = j;
    if (j == 0) {
      i = 600;
    }
    localh.d = i;
    localh.r = this.mRoomInfo.decProperties;
    applyRenderPlayStrategy(paramTXCRenderAndDec, localh);
  }
  
  private void applyRenderPlayStrategy(TXCRenderAndDec paramTXCRenderAndDec, h paramh)
  {
    paramh.g = true;
    int i = this.mCurrentRole;
    if (i == 20)
    {
      paramh.a = com.tencent.liteav.basic.a.a.a;
      paramh.c = com.tencent.liteav.basic.a.a.b;
      paramh.b = com.tencent.liteav.basic.a.a.c;
    }
    else if (i == 21)
    {
      paramh.a = com.tencent.liteav.basic.a.a.d;
      paramh.c = com.tencent.liteav.basic.a.a.e;
      paramh.b = com.tencent.liteav.basic.a.a.f;
    }
    paramTXCRenderAndDec.setConfig(paramh);
  }
  
  private void checkRTCState()
  {
    long l = System.currentTimeMillis();
    if (l < this.mLastStateTimeMs + 2000L) {
      return;
    }
    this.mLastStateTimeMs = l;
    Object localObject = com.tencent.liteav.basic.util.f.a();
    ArrayList localArrayList = new ArrayList();
    TRTCStatistics localTRTCStatistics = new TRTCStatistics();
    localTRTCStatistics.appCpu = (localObject[0] / 10);
    localTRTCStatistics.systemCpu = (localObject[1] / 10);
    localTRTCStatistics.rtt = TXCStatus.c("18446744073709551615", 12002);
    localTRTCStatistics.sendBytes = TXCStatus.a("18446744073709551615", 12004);
    localTRTCStatistics.receiveBytes = TXCStatus.a("18446744073709551615", 16004);
    localTRTCStatistics.upLoss = TXCStatus.c("18446744073709551615", 12003);
    localTRTCStatistics.localArray = new ArrayList();
    localTRTCStatistics.remoteArray = new ArrayList();
    localObject = getLocalStatistics(2);
    localTRTCStatistics.localArray.add(localObject);
    if (this.mEnableSmallStream)
    {
      localObject = getLocalStatistics(3);
      localTRTCStatistics.localArray.add(localObject);
    }
    this.mRoomInfo.forEachUser(new TRTCCloudImpl.174(this, localTRTCStatistics, localArrayList));
    localObject = new TRTCCloudDef.TRTCQuality();
    ((TRTCCloudDef.TRTCQuality)localObject).userId = this.mRoomInfo.getUserId();
    ((TRTCCloudDef.TRTCQuality)localObject).quality = TXCStatus.c("18446744073709551615", 12005);
    runOnListenerThread(new TRTCCloudImpl.175(this, localTRTCStatistics, (TRTCCloudDef.TRTCQuality)localObject, localArrayList));
  }
  
  private void checkRenderRotation(int paramInt)
  {
    int m = getDisplayRotation();
    int k = (360 - m - (this.mConfig.l - 1) * 90) % 360;
    int i = paramInt % 2;
    int j = m % 2;
    if (((i == j) && (this.mConfig.l == 1)) || ((i != j) && (this.mConfig.l == 0))) {
      j = 1;
    } else {
      j = 0;
    }
    int n = this.mVideoRenderMirror;
    if (n == 1)
    {
      i = k;
      if (!this.mConfig.m)
      {
        i = k;
        if (j == 0) {}
      }
    }
    else
    {
      do
      {
        i = k + 180;
        break;
        i = k;
        if (n != 2) {
          break;
        }
        i = k;
        if (!this.mConfig.m) {
          break;
        }
        i = k;
      } while (j != 0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("vrotation rotation-change %d-%d-%d ======= renderRotation %d-%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mConfig.l), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.mRoomInfo.localRenderRotation) }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    TXCLog.d("TRTCCloudImpl", localStringBuilder.toString());
    paramInt = this.mRoomInfo.localRenderRotation;
    this.mCaptureAndEnc.g((paramInt + i) % 360);
  }
  
  private void checkVideoEncRotation(int paramInt)
  {
    int i;
    if (this.mConfig.l != 1)
    {
      if (((this.mConfig.S) && (this.mConfig.m)) || ((!this.mConfig.S) && (!this.mConfig.m))) {
        i = 90;
      } else {
        i = 270;
      }
    }
    else {
      i = 0;
    }
    int j;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            i = 0;
          } else {
            i = (i + 180) % 360;
          }
        }
        else
        {
          i = (i + 270) % 360;
          j = i;
          if (!this.mConfig.m) {
            j = (i + 180) % 360;
          }
          i = j;
          if (this.mConfig.S) {
            i = (j + 180) % 360;
          }
        }
      }
      else {
        i = (i + 0) % 360;
      }
    }
    else
    {
      i = (i + 90) % 360;
      j = i;
      if (!this.mConfig.m) {
        j = (i + 180) % 360;
      }
      i = j;
      if (this.mConfig.S) {
        i = (j + 180) % 360;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("vrotation rotation-change %d-%d ======= encRotation %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mConfig.l), Integer.valueOf(i) }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    TXCLog.d("TRTCCloudImpl", localStringBuilder.toString());
    this.mCurrentOrientation = paramInt;
    this.mCaptureAndEnc.a(i);
  }
  
  private void collectCustomCaptureFps()
  {
    if (this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.CUSTOM)
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.mLastCaptureCalculateTS;
      if (l2 >= 1000L)
      {
        long l3 = this.mCaptureFrameCount;
        double d1 = l3 - this.mLastCaptureFrameCount;
        Double.isNaN(d1);
        double d2 = l2;
        Double.isNaN(d2);
        d1 = d1 * 1000.0D / d2;
        this.mLastCaptureFrameCount = l3;
        this.mLastCaptureCalculateTS = l1;
        TXCStatus.a("18446744073709551615", 1001, 2, Double.valueOf(d1));
      }
    }
  }
  
  private static TRTCAudioServerConfig createAudioServerConfigFromNative()
  {
    return new TRTCAudioServerConfig();
  }
  
  private TXCRenderAndDec createRender(long paramLong, int paramInt)
  {
    TXCRenderAndDec localTXCRenderAndDec = new TXCRenderAndDec(this.mContext);
    localTXCRenderAndDec.setID(String.valueOf(paramLong));
    localTXCRenderAndDec.setVideoRender(new com.tencent.liteav.renderer.a());
    localTXCRenderAndDec.setStreamType(paramInt);
    localTXCRenderAndDec.setNotifyListener(this);
    localTXCRenderAndDec.setRenderAndDecDelegate(this);
    boolean bool = false;
    localTXCRenderAndDec.setRenderMode(0);
    if (this.mPerformanceMode != 1) {
      bool = true;
    }
    localTXCRenderAndDec.enableDecoderChange(bool);
    localTXCRenderAndDec.enableRestartDecoder(this.mRoomInfo.enableRestartDecoder);
    localTXCRenderAndDec.enableLimitDecCache(this.mVideoServerConfig.enableHWVUI);
    applyRenderConfig(localTXCRenderAndDec);
    return localTXCRenderAndDec;
  }
  
  private TRTCRoomInfo.UserInfo createUserInfo(String paramString)
  {
    paramString = new TRTCRoomInfo.UserInfo(0L, paramString, 0, 0);
    paramString.mainRender.muteVideo = this.mRoomInfo.muteRemoteVideo;
    paramString.mainRender.muteAudio = this.mRoomInfo.muteRemoteAudio;
    return paramString;
  }
  
  private static TRTCVideoServerConfig createVideoServerConfigFromNative()
  {
    return new TRTCVideoServerConfig();
  }
  
  public static void destroySharedInstance()
  {
    try
    {
      if (sInstance != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("trtc_api destroy instance self:");
        localStringBuilder.append(sInstance.hashCode());
        TXCLog.i("TRTCCloudImpl", localStringBuilder.toString());
        sInstance.destroy();
        sInstance = null;
      }
      return;
    }
    finally {}
  }
  
  private void enableAudioAEC(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable"))) {
      apiLog("enableAudioAEC[lack parameter or illegal type]: enable");
    }
    if (paramJSONObject.getInt("enable") == 0) {
      this.mEnableSoftAEC = false;
    } else {
      this.mEnableSoftAEC = true;
    }
    if (paramJSONObject.has("level")) {
      this.mSoftAECLevel = paramJSONObject.getInt("level");
    } else {
      this.mSoftAECLevel = 100;
    }
    TXCAudioEngine.getInstance().enableSoftAEC(this.mEnableSoftAEC, this.mSoftAECLevel);
  }
  
  private void enableAudioAGC(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable"))) {
      apiLog("enableAudioAGC[lack parameter or illegal type]: enable");
    }
    if (paramJSONObject.getInt("enable") == 0) {
      this.mEnableSoftAGC = false;
    } else {
      this.mEnableSoftAGC = true;
    }
    if (paramJSONObject.has("level")) {
      this.mSoftAGCLevel = paramJSONObject.getInt("level");
    } else {
      this.mSoftAGCLevel = 100;
    }
    TXCAudioEngine.getInstance().enableSoftAGC(this.mEnableSoftAGC, this.mSoftAGCLevel);
  }
  
  private void enableAudioANS(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (!paramJSONObject.has("enable"))) {
      apiLog("enableAudioANS[lack parameter or illegal type]: enable");
    }
    if (paramJSONObject.getInt("enable") == 0) {
      this.mEnableSoftANS = false;
    } else {
      this.mEnableSoftANS = true;
    }
    if (paramJSONObject.has("level")) {
      this.mSoftANSLevel = paramJSONObject.getInt("level");
    } else {
      this.mSoftANSLevel = 100;
    }
    TXCAudioEngine.getInstance().enableSoftANS(this.mEnableSoftANS, this.mSoftANSLevel);
  }
  
  private void forceCallbackMixedPlayAudioFrame(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("forceCallbackMixedPlayAudioFrame param is null");
      return;
    }
    if (!paramJSONObject.has("enable"))
    {
      apiLog("forceCallbackMixedPlayAudioFrame[lack parameter]: enable");
      return;
    }
    boolean bool = false;
    int i = paramJSONObject.optInt("enable", 0);
    paramJSONObject = TXCAudioEngine.getInstance();
    if (i != 0) {
      bool = true;
    }
    paramJSONObject.forceCallbackMixedPlayAudioFrame(bool);
  }
  
  private int getDisplayRotation()
  {
    int j = this.mDisplay.getRotation();
    int i = 0;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return 0;
          }
          return 270;
        }
        return 180;
      }
      i = 90;
    }
    return i;
  }
  
  private CharSequence getDownloadStreamInfo(TXCRenderAndDec paramTXCRenderAndDec, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    String str = String.valueOf(paramUserInfo.tinyID);
    int[] arrayOfInt = com.tencent.liteav.basic.util.f.a();
    int i = paramTXCRenderAndDec.getStreamType();
    long l = TXCStatus.a(str, 17014, i);
    int j = TXCStatus.c(str, 5003, i);
    if (i == 3) {
      paramTXCRenderAndDec = "S";
    } else if (i == 7) {
      paramTXCRenderAndDec = "Sub";
    } else if (i == 1) {
      paramTXCRenderAndDec = "A";
    } else {
      paramTXCRenderAndDec = "B";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("REMOTE: [%s]%s RTT:%dms\n", new Object[] { paramUserInfo.userID, paramTXCRenderAndDec, Integer.valueOf(TXCStatus.c("18446744073709551615", 12002)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "RECV:%dkbps LOSS:%d-%d-%d%%|%d-%d-%d%%|%d%%\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 17001, i) + TXCStatus.c(str, 18001)), Integer.valueOf(TXCStatus.c(str, 17010, i)), Integer.valueOf(TXCStatus.c(str, 17005, i)), Integer.valueOf(TXCStatus.c(str, 17011, i)), Integer.valueOf(TXCStatus.c(str, 18013)), Integer.valueOf(TXCStatus.c(str, 18007)), Integer.valueOf(TXCStatus.c(str, 18014)), Integer.valueOf(TXCStatus.c(str, 16002)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "BIT:%d|%dkbps RES:%dx%d FPS:%d-%d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 17002, i)), Integer.valueOf(TXCStatus.c(str, 18002)), Integer.valueOf(j >> 16), Integer.valueOf(j & 0xFFFF), Integer.valueOf((int)TXCStatus.d(str, 6002, i)), Integer.valueOf((int)TXCStatus.d(str, 17003, i)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "FEC:%d-%d-%d%%|%d-%d-%d%%    ARQ:%d-%d|%d-%d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 17007, i)), Integer.valueOf(TXCStatus.c(str, 17005, i)), Integer.valueOf(TXCStatus.c(str, 17006, i)), Integer.valueOf(TXCStatus.c(str, 18009)), Integer.valueOf(TXCStatus.c(str, 18007)), Integer.valueOf(TXCStatus.c(str, 18008)), Integer.valueOf(TXCStatus.c(str, 17009, i)), Integer.valueOf(TXCStatus.c(str, 17008, i)), Integer.valueOf(TXCStatus.c(str, 18012)), Integer.valueOf(TXCStatus.c(str, 18010)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "CPU:%d%%|%d%%  RPS:%d  LFR:%d  DERR:%d\n", new Object[] { Integer.valueOf(arrayOfInt[0] / 10), Integer.valueOf(arrayOfInt[1] / 10), Integer.valueOf(TXCStatus.c(str, 17012, i)), Integer.valueOf(TXCStatus.c(str, 17013, i)), Long.valueOf(l) }));
    localStringBuilder.append(String.format(Locale.CHINA, "Jitter: %d,%d|%d,%d|%d   ADROP: %d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 2007)), Integer.valueOf(TXCStatus.c(str, 6010, i)), Integer.valueOf(TXCStatus.c(str, 6011, i)), Integer.valueOf(TXCStatus.c(str, 6012, i)), Integer.valueOf(TXCStatus.c(str, 2021)), Integer.valueOf(TXCStatus.c(str, 18015)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "QUALITY: %d   LEN: %d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 18023)), Integer.valueOf(TXCStatus.c(str, 18016)) }));
    paramTXCRenderAndDec = localStringBuilder.toString();
    paramUserInfo = new SpannableString(paramTXCRenderAndDec);
    i = paramTXCRenderAndDec.lastIndexOf("DECERR:");
    if ((-1 != i) && (l > 0L)) {
      paramUserInfo.setSpan(new ForegroundColorSpan(-65536), i + 7, paramTXCRenderAndDec.length(), 33);
    }
    return paramUserInfo;
  }
  
  private Pair<Integer, String> getEncoderTypeAndMsg(Bundle paramBundle)
  {
    int i = paramBundle.getInt("EVT_PARAM1", 0);
    if ((i != b.a.a.a()) && (i != b.a.b.a()))
    {
      if ((i != b.a.c.a()) && (i != b.a.d.a()))
      {
        paramBundle = "";
      }
      else
      {
        paramBundle = String.format(Locale.getDefault(), "Current encode type is %s encoder", new Object[] { "H265" });
        i = 1;
      }
    }
    else
    {
      paramBundle = String.format(Locale.getDefault(), "Current encode type is %s encoder", new Object[] { "H264" });
      i = 0;
    }
    return new Pair(Integer.valueOf(i), paramBundle);
  }
  
  private TRTCStatistics.TRTCLocalStatistics getLocalStatistics(int paramInt)
  {
    int i = TXCStatus.c("18446744073709551615", 4003, paramInt);
    TRTCStatistics.TRTCLocalStatistics localTRTCLocalStatistics = new TRTCStatistics.TRTCLocalStatistics();
    localTRTCLocalStatistics.width = (i >> 16);
    localTRTCLocalStatistics.height = (i & 0xFFFF);
    localTRTCLocalStatistics.frameRate = ((int)(TXCStatus.d("18446744073709551615", 4001, paramInt) + 0.5D));
    localTRTCLocalStatistics.videoBitrate = TXCStatus.c("18446744073709551615", 13002, paramInt);
    localTRTCLocalStatistics.audioSampleRate = TXCStatus.c("18446744073709551615", 14003);
    localTRTCLocalStatistics.audioBitrate = TXCStatus.c("18446744073709551615", 14002);
    localTRTCLocalStatistics.streamType = translateStreamType(paramInt);
    return localTRTCLocalStatistics;
  }
  
  private com.tencent.liteav.basic.a.b getPixelFormat(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return com.tencent.liteav.basic.a.b.a;
          }
          return com.tencent.liteav.basic.a.b.e;
        }
        return com.tencent.liteav.basic.a.b.d;
      }
      return com.tencent.liteav.basic.a.b.c;
    }
    return com.tencent.liteav.basic.a.b.b;
  }
  
  private String getQosValue(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "ERR";
        }
        return "DOWN";
      }
      return "UP";
    }
    return "HOLD";
  }
  
  private TRTCStatistics.TRTCRemoteStatistics getRemoteStatistics(TXCRenderAndDec paramTXCRenderAndDec, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    String str = String.valueOf(paramUserInfo.tinyID);
    int m = paramTXCRenderAndDec.getStreamType();
    int n = TXCStatus.c(str, 5003, m);
    int j = TXCStatus.c(str, 17011, m);
    int k = TXCStatus.c(str, 18014);
    paramTXCRenderAndDec = new TRTCStatistics.TRTCRemoteStatistics();
    paramTXCRenderAndDec.userId = paramUserInfo.userID;
    int i = j;
    if (k > j) {
      i = k;
    }
    paramTXCRenderAndDec.finalLoss = i;
    paramTXCRenderAndDec.width = (n >> 16);
    paramTXCRenderAndDec.height = (0xFFFF & n);
    paramTXCRenderAndDec.frameRate = ((int)(TXCStatus.d(str, 6002, m) + 0.5D));
    paramTXCRenderAndDec.videoBitrate = TXCStatus.c(str, 17002, m);
    paramTXCRenderAndDec.audioSampleRate = TXCStatus.c(str, 18003);
    paramTXCRenderAndDec.audioBitrate = TXCStatus.c(str, 18002);
    paramTXCRenderAndDec.jitterBufferDelay = TXCStatus.c(str, 2007);
    paramTXCRenderAndDec.streamType = translateStreamType(m);
    return paramTXCRenderAndDec;
  }
  
  private g.a getSizeByResolution(int paramInt1, int paramInt2)
  {
    int k = 720;
    int m = 960;
    int i = k;
    int j = m;
    switch (paramInt1)
    {
    case 108: 
    default: 
    case 114: 
    case 112: 
    case 110: 
    case 106: 
    case 104: 
    case 102: 
    case 100: 
    case 62: 
      for (i = 368;; i = 480)
      {
        j = 640;
        break label385;
        j = 1920;
        i = 1088;
        break label385;
        j = 1280;
        i = k;
        break label385;
        i = 544;
        j = m;
        break label385;
        i = 272;
        break label344;
        j = 336;
        i = 192;
        break label385;
        i = 144;
        break;
        i = 96;
        break label332;
      }
    case 60: 
      i = 368;
      break;
    case 58: 
      j = 400;
      i = 304;
      break;
    case 56: 
      j = 320;
      i = 240;
      break;
    case 54: 
      j = 288;
      i = 224;
      break;
    case 52: 
      i = 192;
      j = 256;
      break;
    case 50: 
      i = 128;
      j = 176;
      break;
    case 7: 
      i = 480;
      j = 480;
      break;
    case 5: 
      i = 272;
      j = 272;
      break;
    case 3: 
      i = 160;
      j = 160;
      break;
    case 1: 
      label332:
      label344:
      i = 128;
      j = 128;
    }
    label385:
    g.a locala = new g.a();
    if (paramInt2 == 1)
    {
      locala.a = i;
      locala.b = j;
      return locala;
    }
    locala.a = j;
    locala.b = i;
    return locala;
  }
  
  private void hideFloatingWindow()
  {
    View localView = this.mFloatingWindow;
    if (localView == null) {
      return;
    }
    ((WindowManager)localView.getContext().getSystemService("window")).removeViewImmediate(this.mFloatingWindow);
    this.mFloatingWindow = null;
  }
  
  private void identifyTRTCFrameworkType()
  {
    for (;;)
    {
      int i;
      try
      {
        localObject = Thread.currentThread().getStackTrace();
        i = 0;
        if (i < localObject.length)
        {
          String str = localObject[i].getClassName();
          boolean bool = str.contains("TRTCMeetingImpl");
          if ((!bool) && (!str.contains("TRTCLiveRoomImpl")) && (!str.contains("TRTCAudioCallImpl")) && (!str.contains("TRTCVideoCallImpl")) && (!str.contains("TRTCVoiceRoomImpl")) && (!str.contains("TRTCAVCallImpl")))
          {
            if (!str.contains("WXTRTCCloud")) {
              break label222;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("identifyTRTCFrameworkType callName:");
            ((StringBuilder)localObject).append(str);
            TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
            this.mFramework = 3;
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("identifyTRTCFrameworkType callName:");
          ((StringBuilder)localObject).append(str);
          TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
          this.mFramework = 5;
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("identifyTRTCFrameworkType catch exception:");
        ((StringBuilder)localObject).append(localException.getCause());
        TXCLog.e("TRTCCloudImpl", ((StringBuilder)localObject).toString());
      }
      return;
      label222:
      i += 1;
    }
  }
  
  private void init(Context paramContext, Handler arg2)
  {
    this.mCurrentPublishClouds.put(Integer.valueOf(2), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(3), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(7), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(1), this);
    this.mContext = paramContext.getApplicationContext();
    this.mConfig = new g();
    this.mConfig.k = com.tencent.liteav.basic.a.c.e;
    Object localObject = this.mConfig;
    ((g)localObject).X = 90;
    ((g)localObject).j = 0;
    ((g)localObject).P = true;
    ((g)localObject).h = 15;
    ((g)localObject).K = false;
    ((g)localObject).T = false;
    ((g)localObject).U = false;
    ((g)localObject).a = 368;
    ((g)localObject).b = 640;
    ((g)localObject).c = 750;
    ((g)localObject).e = 0;
    ((g)localObject).W = false;
    this.mRoomInfo = new TRTCRoomInfo();
    this.mRoomInfo.bigEncSize.a = 368;
    this.mRoomInfo.bigEncSize.b = 640;
    this.mMainHandler = new com.tencent.liteav.basic.util.e(paramContext.getMainLooper());
    this.mListenerHandler = new Handler(paramContext.getMainLooper());
    this.mIsSDKThreadAlive = new AtomicBoolean(true);
    if (??? != null)
    {
      this.mSDKHandler = ???;
    }
    else
    {
      ??? = new HandlerThread("TRTCCloudApi");
      ???.start();
      this.mSDKHandler = new Handler(???.getLooper());
    }
    this.mStatusNotifyTask = new TRTCCloudImpl.StatusTask(this);
    this.mLastSendMsgTimeMs = 0L;
    this.mSendMsgCount = 0;
    this.mSendMsgSize = 0;
    this.mSensorMode = 2;
    this.mAppScene = 0;
    this.mQosPreference = 2;
    this.mQosMode = 1;
    this.mOrientationEventListener = new TRTCCloudImpl.DisplayOrientationDetector(this.mContext, this);
    this.mDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.mRenderListenerMap = new HashMap();
    this.mStreamTypes = new HashSet();
    for (;;)
    {
      synchronized (this.mNativeLock)
      {
        localObject = TXCCommonUtil.getSDKVersion();
        if (localObject.length >= 1)
        {
          i = localObject[0];
          if (localObject.length < 2) {
            break label563;
          }
          j = localObject[1];
          if (localObject.length < 3) {
            break label569;
          }
          k = localObject[2];
          this.mNativeRtcContext = nativeCreateContext(i, j, k);
          apiLog("trtc cloud create");
          this.mRoomState = 0;
          this.mVideoSourceType = TRTCCloudImpl.VideoSourceType.NONE;
          this.mIsAudioCapturing = false;
          this.mCurrentRole = 20;
          this.mTargetRole = 20;
          this.mRecvMode = 1;
          this.mLatestParamsOfBigEncoder.putInt("config_gop", this.mConfig.i);
          this.mLatestParamsOfSmallEncoder.putInt("config_gop", this.mConfig.i);
          identifyTRTCFrameworkType();
          this.mVideoServerConfig = TRTCVideoServerConfig.loadFromSharedPreferences(paramContext);
          return;
        }
      }
      int i = 0;
      continue;
      label563:
      int j = 0;
      continue;
      label569:
      int k = 0;
    }
  }
  
  private void muteUpstream(int paramInt, boolean paramBoolean)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      nativeMuteUpstream(localTRTCCloudImpl.getNetworkContext(), paramInt, paramBoolean);
    }
  }
  
  private native int nativeCancelDownStream(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);
  
  private native void nativeChangeRole(long paramLong, int paramInt);
  
  private native int nativeConnectOtherRoom(long paramLong, String paramString);
  
  private native int nativeDisconnectOtherRoom(long paramLong);
  
  private native void nativeEnableBlackStream(long paramLong, boolean paramBoolean);
  
  private native void nativeEnableSmallStream(long paramLong, boolean paramBoolean);
  
  private native void nativeMuteUpstream(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void nativePushVideo(long paramLong1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
  
  private native void nativeReenterRoom(long paramLong, int paramInt);
  
  private native int nativeRemoveUpstream(long paramLong, int paramInt);
  
  private native int nativeRequestDownStream(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);
  
  private native void nativeRequestKeyFrame(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeSendCustomCmdMsg(long paramLong, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeSendJsonCmd(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSendSEIMsg(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeSetAudioEncodeConfiguration(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void nativeSetDataReportDeviceInfo(String paramString1, String paramString2, int paramInt);
  
  private native boolean nativeSetSEIPayloadType(long paramLong, int paramInt);
  
  private native void nativeSetVideoEncoderConfiguration(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7);
  
  private native void nativeSetVideoQuality(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeStartPublishCDNStream(long paramLong, TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam);
  
  private native void nativeStartPublishing(long paramLong, String paramString, int paramInt);
  
  private native void nativeStartSpeedTest(long paramLong, int paramInt, String paramString1, String paramString2);
  
  private native void nativeStopPublishCDNStream(long paramLong);
  
  private native void nativeStopPublishing(long paramLong);
  
  private native void nativeStopSpeedTest(long paramLong);
  
  private native void nativeUpdatePrivateMapKey(long paramLong, String paramString);
  
  private void notifyCaptureStarted(String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.177(this, paramString));
    apiLog(paramString);
  }
  
  private void notifyEvent(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", System.currentTimeMillis());
    localBundle.putString("EVT_MSG", paramString2);
    notifyEvent(paramString1, paramInt, localBundle);
  }
  
  private void notifyEventByUserId(String paramString, int paramInt, Bundle paramBundle)
  {
    if (paramString != null)
    {
      if (paramBundle == null) {
        return;
      }
      this.mRoomInfo.forEachUser(new TRTCCloudImpl.165(this, paramString, paramInt, paramBundle));
    }
  }
  
  private void notifyLogByUserId(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putLong("EVT_ID", paramInt2);
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      localBundle.putString("EVT_MSG", paramString2);
      localBundle.putInt("EVT_STREAM_TYPE", paramInt1);
      notifyEventByUserId(paramString1, paramInt2, localBundle);
    }
  }
  
  private void onAVMemberChange(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    runOnSDKThread(new TRTCCloudImpl.136(this, new WeakReference(this), paramLong, paramString, paramInt3, paramInt2));
  }
  
  private void onCallExperimentalAPI(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCallExperimentalAPI ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    apiLog(localStringBuilder.toString());
    runOnListenerThread(new TRTCCloudImpl.131(this));
  }
  
  private void onChangeRole(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.158(this, paramInt, paramString));
  }
  
  private void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConnectOtherRoom ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString2);
    apiLog(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("onConnectOtherRoom userId:%s err:%d, msg:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    runOnListenerThread(new TRTCCloudImpl.129(this, paramString1, paramInt, paramString2));
  }
  
  private void onConnectionLost()
  {
    Object localObject = this.mRoomInfo;
    ((TRTCRoomInfo)localObject).networkStatus = 1;
    notifyEvent(((TRTCRoomInfo)localObject).getUserId(), 0, "Network anomaly.");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onConnectionLost self:");
    ((StringBuilder)localObject).append(hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    runOnListenerThread(new TRTCCloudImpl.143(this));
  }
  
  private void onConnectionRecovery()
  {
    Object localObject = this.mRoomInfo;
    ((TRTCRoomInfo)localObject).networkStatus = 3;
    notifyEvent(((TRTCRoomInfo)localObject).getUserId(), 0, "Network recovered. Successfully re-enter room");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onConnectionRecovery self:");
    ((StringBuilder)localObject).append(hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    runOnListenerThread(new TRTCCloudImpl.145(this));
  }
  
  private void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDisConnectOtherRoom ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    apiLog(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("onDisConnectOtherRoom err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    runOnListenerThread(new TRTCCloudImpl.130(this, paramInt, paramString));
  }
  
  private void onExitRoom(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    apiLog(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("onExitRoom err:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    runOnSDKThread(new TRTCCloudImpl.127(this, paramInt));
  }
  
  private void onKickOut(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onKickOut ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    apiLog(localStringBuilder.toString());
    runOnSDKThread(new TRTCCloudImpl.128(this, paramString, paramInt));
  }
  
  private void onNotify(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" event ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString);
    apiLog(((StringBuilder)localObject).toString());
    localObject = String.valueOf(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putLong("EVT_ID", paramInt2);
    localBundle.putLong("EVT_TIME", System.currentTimeMillis());
    localBundle.putString("EVT_MSG", paramString);
    localBundle.putInt("EVT_STREAM_TYPE", paramInt1);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramLong != 0L) && (!((String)localObject).equalsIgnoreCase("18446744073709551615")) && (!((String)localObject).equalsIgnoreCase(this.mRoomInfo.getTinyId())))
    {
      notifyLogByUserId(String.valueOf(paramLong), paramInt1, paramInt2, paramString);
      return;
    }
    notifyEvent(this.mRoomInfo.getUserId(), paramInt2, localBundle);
  }
  
  private void onRecvAudioServerConfig(TRTCAudioServerConfig paramTRTCAudioServerConfig)
  {
    TXCLog.i("TRTCCloudImpl", "on receive audio config: [%s]", new Object[] { paramTRTCAudioServerConfig });
    TRTCAudioServerConfig.saveToSharedPreferences(this.mContext, paramTRTCAudioServerConfig);
    TXCAudioEngine.getInstance().enableAutoRestartDevice(paramTRTCAudioServerConfig.enableAutoRestartDevice);
    TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(paramTRTCAudioServerConfig.maxSelectedPlayStreams);
  }
  
  private void onRecvCustomCmdMsg(String paramString1, long paramLong1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, int paramInt3, long paramLong2)
  {
    long l = System.currentTimeMillis();
    this.mRecvCustomCmdMsgCountInPeriod += 1L;
    if (l - this.mLastLogCustomCmdMsgTs > 10000L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvMsg. tinyId=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", streamId = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", msg = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", recvTime = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", recvCustomMsgCountInPeriod = ");
      localStringBuilder.append(this.mRecvCustomCmdMsgCountInPeriod);
      localStringBuilder.append(" self:");
      localStringBuilder.append(hashCode());
      TXCLog.i("TRTCCloudImpl", localStringBuilder.toString());
      this.mLastLogCustomCmdMsgTs = l;
      this.mRecvCustomCmdMsgCountInPeriod = 0L;
    }
    runOnListenerThread(new TRTCCloudImpl.146(this, paramString1, paramInt1, paramInt2, paramString2, paramBoolean, paramInt3));
  }
  
  private void onRecvEnterRoomVideoConfig(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.162(this, paramBoolean));
  }
  
  private void onRecvFirstAudio(long paramLong)
  {
    runOnSDKThread(new TRTCCloudImpl.150(this));
  }
  
  private void onRecvFirstVideo(long paramLong, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.151(this, paramLong));
  }
  
  private void onRecvSEIMsg(long paramLong, byte[] paramArrayOfByte)
  {
    runOnListenerThread(new TRTCCloudImpl.147(this, paramLong, paramArrayOfByte));
  }
  
  private void onRecvVideoServerConfig(TRTCVideoServerConfig paramTRTCVideoServerConfig)
  {
    runOnSDKThread(new TRTCCloudImpl.161(this, paramTRTCVideoServerConfig));
  }
  
  private void onRequestAccIP(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRequestAccIP err:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" isAcc:");
    ((StringBuilder)localObject).append(paramBoolean);
    apiLog(((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      if (paramBoolean) {
        paramString = "connect ACC";
      } else {
        paramString = "connect PROXY";
      }
      localObject = new Bundle();
      ((Bundle)localObject).putLong("EVT_ID", paramInt);
      ((Bundle)localObject).putLong("EVT_TIME", System.currentTimeMillis());
      ((Bundle)localObject).putString("EVT_MSG", paramString);
      ((Bundle)localObject).putInt("EVT_STREAM_TYPE", 2);
      notifyEvent(this.mRoomInfo.getUserId(), paramInt, (Bundle)localObject);
    }
  }
  
  private void onRequestDownStream(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      runOnListenerThread(new TRTCCloudImpl.132(this, paramInt1, paramString));
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.133(this, paramInt2, paramLong));
  }
  
  private void onRequestToken(int paramInt, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRequestToken ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    apiLog(localStringBuilder.toString());
    runOnSDKThread(new TRTCCloudImpl.124(this, paramLong, paramArrayOfByte));
  }
  
  private void onSendCustomCmdMsgResult(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  private void onSpeedTest(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3)
  {
    runOnListenerThread(new TRTCCloudImpl.148(this, paramString, paramInt1, paramFloat1, paramFloat2, paramInt2, paramInt3));
  }
  
  private void onStartPublishing(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.152(this, paramInt, paramString));
  }
  
  private void onStopPublishing(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.153(this, paramInt, paramString));
  }
  
  private void onStreamPublished(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.154(this, paramInt, paramString));
  }
  
  private void onStreamUnpublished(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.155(this, paramInt, paramString));
  }
  
  private void onTranscodingUpdated(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.156(this, paramInt, paramString));
  }
  
  private void onTryToReconnect()
  {
    Object localObject = this.mRoomInfo;
    ((TRTCRoomInfo)localObject).networkStatus = 2;
    notifyEvent(((TRTCRoomInfo)localObject).getUserId(), 0, "Retry enter room.");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTryToReconnect self:");
    ((StringBuilder)localObject).append(hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    runOnListenerThread(new TRTCCloudImpl.144(this));
  }
  
  private void onVideoBlockThresholdChanged(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.142(this, paramInt));
  }
  
  private void onWholeMemberEnter(long paramLong, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.137(this, new WeakReference(this), paramString));
  }
  
  private void onWholeMemberExit(long paramLong, String paramString, int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.138(this, new WeakReference(this), paramString, paramInt));
  }
  
  private void pushVideoFrame(TXSNALPacket paramTXSNALPacket)
  {
    synchronized (this.mCurrentPublishClouds)
    {
      TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramTXSNALPacket.streamType));
      if (localTRTCCloudImpl != null)
      {
        long l = localTRTCCloudImpl.getNetworkContext();
        int i;
        if (paramTXSNALPacket.codecId == 1) {
          i = 14;
        } else {
          i = 1;
        }
        nativePushVideo(l, paramTXSNALPacket.streamType, i, paramTXSNALPacket.nalType, paramTXSNALPacket.nalData, paramTXSNALPacket.gopIndex, paramTXSNALPacket.gopFrameIndex, paramTXSNALPacket.refFremeIndex, paramTXSNALPacket.pts, paramTXSNALPacket.dts);
      }
      return;
    }
  }
  
  private void removeUpStreamType(int paramInt)
  {
    if (this.mStreamTypes.contains(Integer.valueOf(paramInt))) {
      this.mStreamTypes.remove(Integer.valueOf(paramInt));
    }
    removeUpstream(paramInt);
  }
  
  private void removeUpstream(int paramInt)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      nativeRemoveUpstream(localTRTCCloudImpl.getNetworkContext(), paramInt);
    }
  }
  
  private void runOnListenerThread(Runnable paramRunnable, int paramInt)
  {
    Handler localHandler = this.mListenerHandler;
    if (localHandler == null)
    {
      this.mMainHandler.postDelayed(paramRunnable, paramInt);
      return;
    }
    localHandler.postDelayed(paramRunnable, paramInt);
  }
  
  private void runOnMainThreadAndWaitDone(Runnable paramRunnable)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.mMainHandler.a(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  private void runOnSDKThread(Runnable paramRunnable, int paramInt)
  {
    Handler localHandler = this.mSDKHandler;
    if (localHandler != null) {
      localHandler.postDelayed(paramRunnable, paramInt);
    }
  }
  
  private void setAudioEncodeConfiguration()
  {
    setQoSParams();
  }
  
  private void setAudioSampleRate(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("sampleRate")))
    {
      int i = paramJSONObject.getInt("sampleRate");
      if ((!this.mEnableCustomAudioCapture) && (!this.mIsAudioCapturing))
      {
        if ((16000 != i) && (48000 != i))
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("muteRemoteAudioInSpeaker[illegal sampleRate]: ");
          paramJSONObject.append(i);
          apiLog(paramJSONObject.toString());
          return;
        }
        TXCAudioEngine.getInstance().setEncoderSampleRate(i);
        return;
      }
      apiLog("setAudioSampleRate[illegal state]");
      return;
    }
    apiLog("setAudioSampleRate[lack parameter or illegal type]: sampleRate");
  }
  
  private void setCustomRenderMode(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setCustomRenderMode param is null");
      return;
    }
    if (!paramJSONObject.has("mode"))
    {
      apiLog("setCustomRenderMode[lack parameter]: mode");
      return;
    }
    boolean bool = false;
    int i = paramJSONObject.optInt("mode", 0);
    paramJSONObject = this.mRoomInfo;
    if (i == 1) {
      bool = true;
    }
    paramJSONObject.enableCustomPreprocessor = bool;
    this.mCaptureAndEnc.a(this.mRoomInfo.enableCustomPreprocessor);
  }
  
  private void setFramework(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setFramework[lack parameter]");
      return;
    }
    if (!paramJSONObject.has("framework"))
    {
      apiLog("setFramework[lack parameter]: framework");
      return;
    }
    this.mFramework = paramJSONObject.getInt("framework");
  }
  
  private void setLocalAudioMuteMode(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (!paramJSONObject.has("mode"))) {
      apiLog("setLocalAudioMuteMode[lack parameter or illegal type]: mode");
    }
    if (paramJSONObject.getInt("mode") == 0) {
      this.mEnableEosMode = false;
    } else {
      this.mEnableEosMode = true;
    }
    TXCAudioEngine.getInstance().enableCaptureEOSMode(this.mEnableEosMode);
  }
  
  private void setMediaCodecConfig(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setMediaCodecConfig param is null");
      return;
    }
    boolean bool1 = paramJSONObject.has("encProperties");
    Object localObject2 = null;
    if (bool1) {
      localObject1 = paramJSONObject.getJSONArray("encProperties");
    } else {
      localObject1 = null;
    }
    g localg = this.mConfig;
    localg.Y = ((JSONArray)localObject1);
    this.mCaptureAndEnc.a(localg);
    Object localObject1 = localObject2;
    if (paramJSONObject.has("decProperties")) {
      localObject1 = paramJSONObject.getJSONArray("decProperties");
    }
    this.mRoomInfo.decProperties = ((JSONArray)localObject1);
    boolean bool2 = paramJSONObject.has("restartDecoder");
    bool1 = false;
    int i;
    if (bool2) {
      i = paramJSONObject.getInt("restartDecoder");
    } else {
      i = 0;
    }
    paramJSONObject = this.mRoomInfo;
    if (i != 0) {
      bool1 = true;
    }
    paramJSONObject.enableRestartDecoder = bool1;
  }
  
  private void setOrientation(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.176(this, paramInt));
  }
  
  private void setQoSParams()
  {
    TXCAudioEncoderConfig localTXCAudioEncoderConfig = TXCAudioEngine.getInstance().getAudioEncoderConfig();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setQoSParams:");
    ((StringBuilder)localObject).append(localTXCAudioEncoderConfig.sampleRate);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(localTXCAudioEncoderConfig.channels);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(localTXCAudioEncoderConfig.minBitrate);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(localTXCAudioEncoderConfig.maxBitrate);
    TXCLog.i("", ((StringBuilder)localObject).toString());
    localObject = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(1));
    if (localObject != null) {
      nativeSetAudioEncodeConfiguration(((TRTCCloudImpl)localObject).getNetworkContext(), localTXCAudioEncoderConfig.minBitrate, localTXCAudioEncoderConfig.maxBitrate, localTXCAudioEncoderConfig.sampleRate, localTXCAudioEncoderConfig.channels);
    }
  }
  
  private void setVideoEncConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6)
  {
    if (this.mRoomState == 0)
    {
      apiLog("setVideoEncConfig ignore when no in room");
      return;
    }
    if (this.mCodecType != 2)
    {
      setVideoEncoderConfiguration(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1, paramBoolean, paramInt6);
      return;
    }
    setVideoEncoderConfiguration(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, this.mAppScene, paramBoolean, paramInt6);
  }
  
  private void setVideoEncoderConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt1));
    if (localTRTCCloudImpl != null) {
      nativeSetVideoEncoderConfiguration(localTRTCCloudImpl.getNetworkContext(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean, paramInt7);
    }
  }
  
  private void setVideoEncoderParamEx(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("callExperimentalAPI[lack parameter or illegal type]: codecType");
      return;
    }
    int i = paramJSONObject.optInt("codecType", -1);
    boolean bool;
    if (i != -1)
    {
      this.mCodecType = i;
      if (this.mCodecType == 0)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("softwareCodecParams");
        if (localJSONObject != null)
        {
          g localg = this.mConfig;
          if (localJSONObject.optInt("enableRealTime") != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localg.P = bool;
          this.mConfig.n = localJSONObject.optInt("profile");
        }
      }
    }
    int j = paramJSONObject.optInt("videoWidth", 0);
    int m = paramJSONObject.optInt("videoHeight", 0);
    int n = paramJSONObject.optInt("videoFps", 0);
    int i1 = paramJSONObject.optInt("videoBitrate", 0);
    int i2 = paramJSONObject.optInt("minVideoBitrate", 0);
    int i3 = paramJSONObject.optInt("rcMethod", 0);
    if ((j > 0) && (m > 0))
    {
      int k = j;
      i = m;
      if (j > 1920)
      {
        i = m * 1920 / 1920;
        k = 1920;
      }
      m = k;
      j = i;
      if (i > 1920)
      {
        m = k * 1920 / 1920;
        j = 1920;
      }
      k = m;
      i = j;
      if (m < 90)
      {
        i = j * 90 / 90;
        k = 90;
      }
      m = k;
      j = i;
      if (i < 90)
      {
        m = k * 90 / 90;
        j = 90;
      }
      i = (m + 15) / 16 * 16;
      j = (j + 15) / 16 * 16;
      k = paramJSONObject.optInt("streamType", 0);
      if (k == 0)
      {
        this.mLatestParamsOfBigEncoder.putInt("config_fps", n);
        if (i <= j) {
          bool = true;
        } else {
          bool = false;
        }
        updateBigStreamEncoder(bool, i, j, n, i1, this.mConfig.p, i2);
        this.mCaptureAndEnc.n(i3);
      }
      else if (k == 1)
      {
        this.mLatestParamsOfSmallEncoder.putInt("config_fps", n);
        updateSmallStreamEncoder(i, j, n, i1, i2);
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("vsize setVideoEncoderParamEx->width:");
      paramJSONObject.append(this.mRoomInfo.bigEncSize.a);
      paramJSONObject.append(", height:");
      paramJSONObject.append(this.mRoomInfo.bigEncSize.b);
      paramJSONObject.append(", fps:");
      paramJSONObject.append(n);
      paramJSONObject.append(", bitrate:");
      paramJSONObject.append(i1);
      paramJSONObject.append(", stream:");
      paramJSONObject.append(k);
      apiLog(paramJSONObject.toString());
      updateOrientation();
    }
  }
  
  private void setVideoEncoderParamInternal(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    if (paramTRTCVideoEncParam != null)
    {
      this.mLatestParamsOfBigEncoder.putInt("config_fps", paramTRTCVideoEncParam.videoFps);
      this.mLatestParamsOfBigEncoder.putBoolean("config_adjust_resolution", paramTRTCVideoEncParam.enableAdjustRes);
      Object localObject = getSizeByResolution(paramTRTCVideoEncParam.videoResolution, paramTRTCVideoEncParam.videoResolutionMode);
      boolean bool;
      if (paramTRTCVideoEncParam.videoResolutionMode == 1) {
        bool = true;
      } else {
        bool = false;
      }
      updateBigStreamEncoder(bool, ((g.a)localObject).a, ((g.a)localObject).b, paramTRTCVideoEncParam.videoFps, paramTRTCVideoEncParam.videoBitrate, paramTRTCVideoEncParam.enableAdjustRes, paramTRTCVideoEncParam.minVideoBitrate);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("vsize setVideoEncoderParam->width:");
      ((StringBuilder)localObject).append(this.mRoomInfo.bigEncSize.a);
      ((StringBuilder)localObject).append(", height:");
      ((StringBuilder)localObject).append(this.mRoomInfo.bigEncSize.b);
      ((StringBuilder)localObject).append(", fps:");
      ((StringBuilder)localObject).append(paramTRTCVideoEncParam.videoFps);
      ((StringBuilder)localObject).append(", bitrate:");
      ((StringBuilder)localObject).append(paramTRTCVideoEncParam.videoBitrate);
      ((StringBuilder)localObject).append(", mode:");
      ((StringBuilder)localObject).append(paramTRTCVideoEncParam.videoResolutionMode);
      ((StringBuilder)localObject).append(" minVideoBitrate:");
      ((StringBuilder)localObject).append(paramTRTCVideoEncParam.minVideoBitrate);
      apiLog(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.format("setVideoEncoderParam width:%d, height:%d, fps:%d, bitrate:%d, mode:%d, minBitrate:%d", new Object[] { Integer.valueOf(this.mRoomInfo.bigEncSize.a), Integer.valueOf(this.mRoomInfo.bigEncSize.b), Integer.valueOf(paramTRTCVideoEncParam.videoFps), Integer.valueOf(paramTRTCVideoEncParam.videoBitrate), Integer.valueOf(paramTRTCVideoEncParam.videoResolutionMode), Integer.valueOf(paramTRTCVideoEncParam.minVideoBitrate) }));
      ((StringBuilder)localObject).append(" self:");
      ((StringBuilder)localObject).append(hashCode());
      Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
      updateOrientation();
      TXCEventRecorderProxy.a("18446744073709551615", 4007, this.mRoomInfo.bigEncSize.a, this.mRoomInfo.bigEncSize.b, "", 2);
      TXCEventRecorderProxy.a("18446744073709551615", 4008, paramTRTCVideoEncParam.videoFps, -1L, "", 2);
      TXCEventRecorderProxy.a("18446744073709551615", 4009, paramTRTCVideoEncParam.videoBitrate, -1L, "", 2);
      return;
    }
    apiLog("setVideoEncoderParam param is null");
  }
  
  private void setVideoQuality(int paramInt1, int paramInt2)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (localTRTCCloudImpl != null) {
      nativeSetVideoQuality(localTRTCCloudImpl.getNetworkContext(), paramInt1, paramInt2);
    }
  }
  
  public static TRTCCloud sharedInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new TRTCCloudImpl(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private void showFloatingWindow(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(paramView.getContext())))
    {
      TXCLog.e("TRTCCloudImpl", "can't show floating window for no drawing overlay permission");
      return;
    }
    this.mFloatingWindow = paramView;
    WindowManager localWindowManager = (WindowManager)paramView.getContext().getSystemService("window");
    int i = 2005;
    if (Build.VERSION.SDK_INT >= 26) {
      i = 2038;
    } else if (Build.VERSION.SDK_INT > 24) {
      i = 2002;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(i);
    localLayoutParams.flags = 8;
    localLayoutParams.flags |= 0x40000;
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.format = -3;
    localWindowManager.addView(paramView, localLayoutParams);
  }
  
  private void startRemoteRender(TXCRenderAndDec paramTXCRenderAndDec, int paramInt)
  {
    paramTXCRenderAndDec.stopVideo();
    paramTXCRenderAndDec.setStreamType(paramInt);
    paramTXCRenderAndDec.startVideo();
  }
  
  private void stopRemoteMainRender(TRTCRoomInfo.UserInfo paramUserInfo, Boolean paramBoolean)
  {
    if (paramUserInfo == null) {
      return;
    }
    apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", new Object[] { paramUserInfo.userID, Long.valueOf(paramUserInfo.tinyID), Integer.valueOf(paramUserInfo.streamType) }));
    nativeCancelDownStream(this.mNativeRtcContext, paramUserInfo.tinyID, 2, paramBoolean.booleanValue());
    nativeCancelDownStream(this.mNativeRtcContext, paramUserInfo.tinyID, 3, paramBoolean.booleanValue());
    if (paramUserInfo.mainRender.render != null) {
      paramUserInfo.mainRender.render.stopVideo();
    }
  }
  
  private void stopRemoteSubRender(TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if (paramUserInfo == null) {
      return;
    }
    apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", new Object[] { paramUserInfo.userID, Long.valueOf(paramUserInfo.tinyID), Integer.valueOf(7) }));
    nativeCancelDownStream(this.mNativeRtcContext, paramUserInfo.tinyID, 7, false);
    if (paramUserInfo.subRender.render != null) {
      paramUserInfo.subRender.render.stopVideo();
    }
  }
  
  private int translateStreamType(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 7) {
          return 0;
        }
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private void updateBigStreamEncoder(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, int paramInt5)
  {
    g localg;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mRoomInfo.bigEncSize.a = paramInt1;
      this.mRoomInfo.bigEncSize.b = paramInt2;
      if (this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
      {
        localg = this.mConfig;
        localg.l = 1;
        localg.a = this.mRoomInfo.bigEncSize.a;
        this.mConfig.b = this.mRoomInfo.bigEncSize.b;
      }
      else if (paramBoolean1)
      {
        localg = this.mConfig;
        localg.l = 1;
        localg.a = this.mRoomInfo.bigEncSize.a;
        this.mConfig.b = this.mRoomInfo.bigEncSize.b;
      }
      else
      {
        localg = this.mConfig;
        localg.l = 0;
        localg.a = this.mRoomInfo.bigEncSize.b;
        this.mConfig.b = this.mRoomInfo.bigEncSize.a;
      }
      this.mConfig.k = com.tencent.liteav.basic.a.c.a;
    }
    if (paramInt3 > 0) {
      if (paramInt3 > 30)
      {
        apiLog("setVideoEncoderParam fps > 30, limit fps to 30");
        this.mConfig.h = 30;
      }
      else
      {
        this.mConfig.h = paramInt3;
      }
    }
    if (paramInt4 > 0) {
      this.mConfig.c = paramInt4;
    }
    if (paramInt5 >= 0) {
      this.mConfig.e = paramInt5;
    }
    if (this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
    {
      localg = this.mConfig;
      localg.i = 3;
      localg.p = false;
      if (this.mOverrideFPSFromUser) {
        localg.h = 10;
      }
    }
    else
    {
      this.mConfig.p = paramBoolean2;
    }
    setVideoEncConfig(2, this.mRoomInfo.bigEncSize.a, this.mRoomInfo.bigEncSize.b, this.mConfig.h, this.mConfig.c, this.mConfig.p, this.mConfig.e);
    if ((this.mCodecType == 2) && (this.mConfig.a * this.mConfig.b >= 518400)) {
      this.mConfig.j = 1;
    }
    this.mCaptureAndEnc.e(this.mConfig.h);
    this.mCaptureAndEnc.a(this.mConfig);
  }
  
  private void updateEncType()
  {
    int i = this.mCodecType;
    if ((i != 0) && (i != 1))
    {
      if (this.mAppScene == 1) {
        this.mConfig.j = 1;
      }
    }
    else {
      this.mConfig.j = this.mCodecType;
    }
  }
  
  private void updateOrientation()
  {
    if (this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.CUSTOM)
    {
      if (this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN) {
        return;
      }
      if (this.mCurrentOrientation == -1) {
        if (this.mDisplay.getRotation() == 1) {
          this.mCurrentOrientation = 0;
        } else {
          this.mCurrentOrientation = 1;
        }
      }
      setOrientation(this.mCurrentOrientation);
    }
  }
  
  private void updateSmallStreamEncoder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mRoomInfo.smallEncSize.a = paramInt1;
      this.mRoomInfo.smallEncSize.b = paramInt2;
    }
    if (paramInt3 > 0) {
      if (paramInt3 > 20)
      {
        apiLog("setVideoSmallEncoderParam fps > 20, limit fps to 20");
        this.mSmallEncParam.videoFps = 20;
      }
      else
      {
        this.mSmallEncParam.videoFps = paramInt3;
      }
    }
    if (paramInt4 > 0) {
      this.mSmallEncParam.videoBitrate = paramInt4;
    }
    if (paramInt5 >= 0) {
      this.mSmallEncParam.minVideoBitrate = paramInt5;
    }
    paramInt1 = this.mConfig.i;
    if (this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
    {
      TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam = this.mSmallEncParam;
      localTRTCVideoEncParam.enableAdjustRes = false;
      if (this.mOverrideFPSFromUser) {
        localTRTCVideoEncParam.videoFps = 10;
      }
      paramInt1 = 3;
    }
    this.mCaptureAndEnc.a(this.mEnableSmallStream, this.mRoomInfo.smallEncSize.a, this.mRoomInfo.smallEncSize.b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, paramInt1);
    setVideoEncConfig(3, this.mRoomInfo.smallEncSize.a, this.mRoomInfo.smallEncSize.b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, this.mConfig.p, this.mSmallEncParam.minVideoBitrate);
  }
  
  public void ConnectOtherRoom(String paramString)
  {
    runOnSDKThread(new TRTCCloudImpl.8(this, paramString));
  }
  
  public void DisconnectOtherRoom()
  {
    runOnSDKThread(new TRTCCloudImpl.9(this));
  }
  
  protected void apiLog(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(")trtc_api ");
    localStringBuilder.append(paramString);
    TXCLog.i("TRTCCloudImpl", localStringBuilder.toString());
  }
  
  public void callExperimentalAPI(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callExperimentalAPI  ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", roomid = ");
      if (this.mRoomInfo.roomId != -1L) {
        localObject = Long.valueOf(this.mRoomInfo.roomId);
      } else {
        localObject = this.mRoomInfo.strRoomId;
      }
      localStringBuilder.append(localObject);
      apiLog(localStringBuilder.toString());
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.format("callExperimentalAPI:%s", new Object[] { paramString }));
      ((StringBuilder)localObject).append(" self:");
      ((StringBuilder)localObject).append(hashCode());
      Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    }
    runOnSDKThread(new TRTCCloudImpl.80(this, paramString));
  }
  
  protected void checkDashBoard()
  {
    if (this.mDebugType != 0)
    {
      TXCloudVideoView localTXCloudVideoView = this.mRoomInfo.localView;
      if (localTXCloudVideoView != null)
      {
        CharSequence localCharSequence = getUploadStreamInfo();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[STATUS]");
        localStringBuilder.append(localCharSequence.toString().replace("\n", ""));
        localStringBuilder.append(" self:");
        localStringBuilder.append(hashCode());
        TXCLog.i("TRTCCloudImpl", localStringBuilder.toString());
        runOnMainThread(new TRTCCloudImpl.172(this, localTXCloudVideoView, localCharSequence));
      }
    }
    this.mRoomInfo.forEachUser(new TRTCCloudImpl.173(this));
  }
  
  protected void checkRemoteDashBoard(TXCloudVideoView paramTXCloudVideoView, TXCRenderAndDec paramTXCRenderAndDec, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if ((paramTXCloudVideoView != null) && (paramTXCRenderAndDec != null) && (paramTXCRenderAndDec.isRendering()))
    {
      paramTXCRenderAndDec = getDownloadStreamInfo(paramTXCRenderAndDec, paramUserInfo);
      paramUserInfo = new StringBuilder();
      paramUserInfo.append("[STATUS]");
      paramUserInfo.append(paramTXCRenderAndDec.toString().replace("\n", ""));
      paramUserInfo.append(" self:");
      paramUserInfo.append(hashCode());
      TXCLog.i("TRTCCloudImpl", paramUserInfo.toString());
      runOnMainThread(new TRTCCloudImpl.171(this, paramTXCloudVideoView, paramTXCRenderAndDec));
    }
  }
  
  protected void checkUserState(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = this.mTRTCListener;
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      boolean bool1;
      if ((TRTCRoomInfo.hasAudio(paramInt1)) && (!TRTCRoomInfo.isMuteAudio(paramInt1))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((TRTCRoomInfo.hasAudio(paramInt2)) && (!TRTCRoomInfo.isMuteAudio(paramInt2))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      int i;
      if (bool2 != bool1) {
        i = 1;
      } else {
        i = 0;
      }
      StringBuilder localStringBuilder;
      if (i != 0)
      {
        runOnListenerThread(new TRTCCloudImpl.168(this, (TRTCCloudListener)localObject, paramString, bool1));
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }));
        localStringBuilder.append(" self:");
        localStringBuilder.append(hashCode());
        Monitor.a(2, localStringBuilder.toString(), "", 0);
      }
      if (((TRTCRoomInfo.hasMainVideo(paramInt1)) || (TRTCRoomInfo.hasSmallVideo(paramInt1))) && (!TRTCRoomInfo.isMuteMainVideo(paramInt1))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (((TRTCRoomInfo.hasMainVideo(paramInt2)) || (TRTCRoomInfo.hasSmallVideo(paramInt2))) && (!TRTCRoomInfo.isMuteMainVideo(paramInt2))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (bool2 != bool1) {
        i = 1;
      } else {
        i = 0;
      }
      int j = this.mRecvMode;
      if ((j != 3) && (j != 1)) {
        j = 1;
      } else {
        j = 0;
      }
      if ((i != 0) && ((this.mRoomInfo.hasRecvFirstIFrame(paramLong)) || (j != 0)))
      {
        runOnListenerThread(new TRTCCloudImpl.169(this, (TRTCCloudListener)localObject, paramString, bool1));
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }));
        localStringBuilder.append(" self:");
        localStringBuilder.append(hashCode());
        Monitor.a(2, localStringBuilder.toString(), "", 0);
      }
      if ((TRTCRoomInfo.hasSubVideo(paramInt1)) && (!TRTCRoomInfo.isMuteSubVideo(paramInt1))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((TRTCRoomInfo.hasSubVideo(paramInt2)) && (!TRTCRoomInfo.isMuteSubVideo(paramInt2))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (bool2 != bool1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        runOnListenerThread(new TRTCCloudImpl.170(this, (TRTCCloudListener)localObject, paramString, bool1));
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]subVideo Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }));
        ((StringBuilder)localObject).append(" self:");
        ((StringBuilder)localObject).append(hashCode());
        Monitor.a(2, ((StringBuilder)localObject).toString(), "", 0);
      }
    }
  }
  
  public TRTCCloud createSubCloud()
  {
    TRTCSubCloud localTRTCSubCloud = new TRTCSubCloud(this.mContext, new WeakReference(this), this.mSDKHandler);
    localTRTCSubCloud.setListenerHandler(this.mListenerHandler);
    runOnSDKThread(new TRTCCloudImpl.12(this, localTRTCSubCloud));
    return localTRTCSubCloud;
  }
  
  public void destroy()
  {
    runOnSDKThread(new TRTCCloudImpl.2(this));
  }
  
  public void destroySubCloud(TRTCCloud paramTRTCCloud)
  {
    runOnSDKThread(new TRTCCloudImpl.13(this, paramTRTCCloud));
  }
  
  public void enableAudioEarMonitoring(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.56(this, paramBoolean));
  }
  
  protected void enableAudioStream(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      addUpStreamType(1);
      return;
    }
    removeUpStreamType(1);
  }
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.61(this, paramInt));
  }
  
  public void enableCustomAudioCapture(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.83(this, paramBoolean));
  }
  
  public void enableCustomVideoCapture(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.79(this, paramBoolean));
  }
  
  public int enableEncSmallVideoStream(boolean paramBoolean, TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    runOnSDKThread(new TRTCCloudImpl.41(this, paramBoolean, paramTRTCVideoEncParam));
    return 0;
  }
  
  public void enableNetworkBlackStream(boolean paramBoolean)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (localTRTCCloudImpl != null) {
      nativeEnableBlackStream(localTRTCCloudImpl.getNetworkContext(), paramBoolean);
    }
  }
  
  public void enableNetworkSmallStream(boolean paramBoolean)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
    if (localTRTCCloudImpl != null) {
      nativeEnableSmallStream(localTRTCCloudImpl.getNetworkContext(), paramBoolean);
    }
  }
  
  public boolean enableTorch(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableTorch ");
    localStringBuilder.append(paramBoolean);
    apiLog(localStringBuilder.toString());
    return this.mCaptureAndEnc.e(paramBoolean);
  }
  
  protected void enableVideoStream(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.mRoomInfo.muteLocalVideo)
      {
        addUpStreamType(2);
        if (this.mEnableSmallStream) {
          addUpStreamType(3);
        }
      }
    }
    else
    {
      if (!this.mCaptureAndEnc.i()) {
        removeUpStreamType(2);
      }
      removeUpStreamType(3);
    }
  }
  
  public void enterRoom(TRTCCloudDef.TRTCParams paramTRTCParams, int paramInt)
  {
    if (paramTRTCParams == null)
    {
      apiLog("enter room, param nil!");
      onEnterRoom(-3316, "enter room param null");
      return;
    }
    TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams(paramTRTCParams);
    long l1;
    String str2;
    if ((localTRTCParams.sdkAppId != 0) && (!TextUtils.isEmpty(localTRTCParams.userId)) && (!TextUtils.isEmpty(localTRTCParams.userSig)))
    {
      l1 = localTRTCParams.roomId & 0xFFFFFFFF;
      if (l1 == 0L)
      {
        paramTRTCParams = new StringBuilder();
        paramTRTCParams.append("enter room, room id ");
        paramTRTCParams.append(l1);
        paramTRTCParams.append(" error");
        apiLog(paramTRTCParams.toString());
        onEnterRoom(-3318, "room id invalid.");
        return;
      }
      paramTRTCParams = localTRTCParams.businessInfo;
      i = localTRTCParams.roomId;
      str2 = "";
      if ((i != -1) || (TextUtils.isEmpty(paramTRTCParams))) {}
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramTRTCParams);
      paramTRTCParams = new StringBuilder("");
      extractBizInfo(localJSONObject, "strGroupId", paramTRTCParams);
      String str3 = paramTRTCParams.toString();
      str1 = str3;
      paramTRTCParams = str2;
      if (localJSONObject.length() == 0) {
        break label270;
      }
      paramTRTCParams = localJSONObject.toString();
      str1 = str3;
    }
    catch (Exception paramTRTCParams)
    {
      String str1;
      label228:
      long l2;
      break label228;
    }
    paramTRTCParams = new StringBuilder();
    paramTRTCParams.append("enter room, room id error, busInfo ");
    paramTRTCParams.append(localTRTCParams.businessInfo);
    apiLog(paramTRTCParams.toString());
    str1 = "";
    paramTRTCParams = str2;
    label270:
    if (TextUtils.isEmpty(str1))
    {
      onEnterRoom(-3318, "room id invalid.");
      return;
    }
    break label297;
    str1 = "";
    label297:
    TXCKeyPointReportProxy.a(30001);
    int i = localTRTCParams.role;
    l2 = System.currentTimeMillis();
    this.mEnableHighQualityEncodeFromServer = false;
    runOnSDKThread(new TRTCCloudImpl.5(this, localTRTCParams, str1, l1, l2, paramInt, paramTRTCParams, i, this));
    return;
    paramTRTCParams = new StringBuilder();
    paramTRTCParams.append("enterRoom param invalid:");
    paramTRTCParams.append(localTRTCParams);
    apiLog(paramTRTCParams.toString());
    if (localTRTCParams.sdkAppId == 0) {
      onEnterRoom(-3317, "enter room sdkAppId invalid.");
    }
    if (TextUtils.isEmpty(localTRTCParams.userSig)) {
      onEnterRoom(-3320, "enter room userSig invalid.");
    }
    if (TextUtils.isEmpty(localTRTCParams.userId)) {
      onEnterRoom(-3319, "enter room userId invalid.");
    }
  }
  
  public void exitRoom()
  {
    runOnSDKThread(new TRTCCloudImpl.6(this));
  }
  
  protected void exitRoomInternal(boolean paramBoolean, String paramString)
  {
    this.mEnableHighQualityEncodeFromServer = false;
    paramString = String.format(Locale.ENGLISH, "exitRoom %s, self: %d, reason: %s", new Object[] { Long.valueOf(this.mRoomInfo.getRoomId()), Integer.valueOf(hashCode()), paramString });
    apiLog(paramString);
    Monitor.a(1, paramString, "", 0);
    if (this.mRoomState == 0)
    {
      Monitor.a();
      apiLog("exitRoom ignore when no in room.");
      return;
    }
    this.mRoomState = 0;
    this.mCaptureAndEnc.f();
    TXCSoundEffectPlayer.getInstance().stopAllEffect();
    stopCollectStatus();
    startVolumeLevelCal(false);
    this.mRoomInfo.forEachUser(new TRTCCloudImpl.7(this));
    TXCAudioEngine.getInstance();
    TXCAudioEngine.setPlayoutDataListener(null);
    enableVideoStream(false);
    enableAudioStream(false);
    if (paramBoolean) {
      nativeExitRoom(this.mNativeRtcContext);
    }
    enableAudioEarMonitoring(false);
    stopLocalAudio();
    stopBGM();
    TXCKeyPointReportProxy.a(31004);
    stopLocalPreview();
    stopScreenCapture();
    TXCKeyPointReportProxy.b(31004, 0);
    paramString = this.mConfig;
    paramString.A = null;
    paramString.C = 10;
    this.mRoomInfo.clear();
    this.mRenderListenerMap.clear();
    this.mVideoSourceType = TRTCCloudImpl.VideoSourceType.NONE;
    this.mEnableSmallStream = false;
    this.mEnableEosMode = false;
    this.mCodecType = 2;
    this.mEnableSoftAEC = true;
    this.mEnableSoftANS = false;
    this.mEnableSoftAGC = false;
    this.mCaptureAndEnc.a(false);
    TXCAudioEngine.getInstance().muteLocalAudio(false);
    TXCAudioEngine.getInstance().clean();
    enableCustomAudioCapture(false);
    this.mEnableCustomAudioCapture = false;
    try
    {
      if (this.mCustomVideoUtil != null)
      {
        this.mCustomVideoUtil.release();
        this.mCustomVideoUtil = null;
      }
      this.mCaptureAndEnc.a(null, 0);
      stopAudioRecording();
      TXCSoundEffectPlayer.getInstance().clearCache();
      Monitor.a();
      return;
    }
    finally {}
  }
  
  void extractBizInfo(JSONObject paramJSONObject, String paramString, StringBuilder paramStringBuilder)
  {
    if (paramString.equals("strGroupId"))
    {
      paramStringBuilder.append(paramJSONObject.optString("strGroupId").toString());
      paramJSONObject.remove("strGroupId");
      paramJSONObject.remove("Role");
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("extractBizInfo: key");
    paramJSONObject.append(paramString);
    paramJSONObject.append(" value:");
    paramJSONObject.append(paramStringBuilder.toString());
    apiLog(paramJSONObject.toString());
  }
  
  public void finalize()
  {
    super.finalize();
    try
    {
      destroy();
      return;
    }
    catch (Exception|Error localException) {}
  }
  
  public int getAudioCaptureVolume()
  {
    return this.mAudioCaptureVolume;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    return TXAudioEffectManagerImpl.getAutoCacheHolder();
  }
  
  public int getAudioPlayoutVolume()
  {
    return this.mAudioPlayoutVolume;
  }
  
  public int getBGMDuration(String paramString)
  {
    return TXCLiveBGMPlayer.getInstance().getBGMDuration(paramString);
  }
  
  public TXBeautyManager getBeautyManager()
  {
    if (this.mCaptureAndEnc == null) {
      this.mCaptureAndEnc = new com.tencent.liteav.d(this.mContext);
    }
    return this.mCaptureAndEnc.b();
  }
  
  public long getNetworkContext()
  {
    return this.mNativeRtcContext;
  }
  
  protected int getNetworkQuality(int paramInt1, int paramInt2)
  {
    if (!com.tencent.liteav.basic.util.f.d(this.mContext)) {
      return 6;
    }
    if ((paramInt2 <= 50) && (paramInt1 <= 500))
    {
      if ((paramInt2 <= 30) && (paramInt1 <= 350))
      {
        if ((paramInt2 <= 20) && (paramInt1 <= 200))
        {
          if ((paramInt2 <= 10) && (paramInt1 <= 100))
          {
            if ((paramInt2 < 0) && (paramInt1 < 0)) {
              return 0;
            }
            return 1;
          }
          return 2;
        }
        return 3;
      }
      return 4;
    }
    return 5;
  }
  
  protected CharSequence getUploadStreamInfo()
  {
    int[] arrayOfInt = com.tencent.liteav.basic.util.f.a();
    int i = TXCStatus.c("18446744073709551615", 4003, 2);
    String str = TXCStatus.b("18446744073709551615", 10001);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("LOCAL: [%s] RTT:%dms\n", new Object[] { this.mRoomInfo.getUserId(), Integer.valueOf(TXCStatus.c("18446744073709551615", 12002)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "SEND:% 5dkbps LOSS:%d-%d-%d-%d|%d-%d-%d-%d|%d%%\n", new Object[] { Integer.valueOf(TXCStatus.c("18446744073709551615", 12001)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13011, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13012, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13013, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13010, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14011)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14012)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14013)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14010)), Integer.valueOf(TXCStatus.c("18446744073709551615", 12003)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "BIT:%d|%d|%dkbps RES:%dx%d FPS:%d-%d\n", new Object[] { Integer.valueOf(TXCStatus.c("18446744073709551615", 13002, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13002, 3)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14002)), Integer.valueOf(i >> 16), Integer.valueOf(i & 0xFFFF), Integer.valueOf((int)TXCStatus.d("18446744073709551615", 4001, 2)), Integer.valueOf((int)TXCStatus.d("18446744073709551615", 13014, 2)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "FEC:%d%%|%d%%  ARQ:%d|%dkbps  RPS:%d\n", new Object[] { Integer.valueOf(TXCStatus.c("18446744073709551615", 13004, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14006)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13008, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14008)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13007, 2)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "CPU:%d%%|%d%%    QOS:%s|%dkbps|%d-%d\n", new Object[] { Integer.valueOf(arrayOfInt[0] / 10), Integer.valueOf(arrayOfInt[1] / 10), getQosValue(TXCStatus.c("18446744073709551615", 15009, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15002, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15010, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15005, 2)) }));
    localStringBuilder.append(String.format(Locale.CHINA, "SVR:%s", new Object[] { str }));
    return localStringBuilder.toString();
  }
  
  public boolean isCameraAutoFocusFaceModeSupported()
  {
    return this.mCaptureAndEnc.p();
  }
  
  public boolean isCameraFocusPositionInPreviewSupported()
  {
    return this.mCaptureAndEnc.o();
  }
  
  public boolean isCameraTorchSupported()
  {
    return this.mCaptureAndEnc.n();
  }
  
  public boolean isCameraZoomSupported()
  {
    return this.mCaptureAndEnc.m();
  }
  
  public boolean isPublishingInCloud(TRTCCloudImpl paramTRTCCloudImpl, int paramInt)
  {
    synchronized (this.mCurrentPublishClouds)
    {
      return (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt)) == paramTRTCCloudImpl;
    }
  }
  
  public void muteAllRemoteAudio(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.53(this, paramBoolean));
  }
  
  public void muteAllRemoteVideoStreams(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.32(this, paramBoolean));
  }
  
  public void muteLocalAudio(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.50(this, paramBoolean));
  }
  
  public void muteLocalAudio(boolean paramBoolean, TRTCCloudImpl paramTRTCCloudImpl)
  {
    runOnSDKThread(new TRTCCloudImpl.51(this, paramBoolean, paramTRTCCloudImpl));
  }
  
  public void muteLocalVideo(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.28(this, paramBoolean));
  }
  
  public void muteLocalVideo(boolean paramBoolean, TRTCCloudImpl paramTRTCCloudImpl)
  {
    runOnSDKThread(new TRTCCloudImpl.30(this, paramBoolean, paramTRTCCloudImpl));
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.52(this, paramString, paramBoolean));
  }
  
  protected void muteRemoteAudioInSpeaker(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("muteRemoteAudioInSpeaker[lack parameter]");
      return;
    }
    if (!paramJSONObject.has("userID"))
    {
      apiLog("muteRemoteAudioInSpeaker[lack parameter]: userID");
      return;
    }
    Object localObject = paramJSONObject.getString("userID");
    if (localObject == null)
    {
      apiLog("muteRemoteAudioInSpeaker[illegal type]: userID");
      return;
    }
    if (!paramJSONObject.has("mute"))
    {
      apiLog("muteRemoteAudioInSpeaker[lack parameter]: mute");
      return;
    }
    int i = paramJSONObject.getInt("mute");
    paramJSONObject = this.mRoomInfo.getUser((String)localObject);
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramJSONObject == null)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("muteRemoteAudioInSpeaker ");
      paramJSONObject.append((String)localObject);
      paramJSONObject.append(" no exist, create one.");
      apiLog(paramJSONObject.toString());
      paramJSONObject = createUserInfo((String)localObject);
      if (i == 1) {
        bool1 = true;
      }
      paramJSONObject.muteAudioInSpeaker = bool1;
      this.mRoomInfo.addUserInfo((String)localObject, paramJSONObject);
      return;
    }
    if (paramJSONObject != null)
    {
      localObject = TXCAudioEngine.getInstance();
      long l = paramJSONObject.tinyID;
      bool1 = bool2;
      if (i == 1) {
        bool1 = true;
      }
      ((TXCAudioEngine)localObject).muteRemoteAudioInSpeaker(String.valueOf(l), bool1);
      return;
    }
    apiLog("muteRemoteAudioInSpeaker[illegal type]: userID");
  }
  
  public void muteRemoteVideoStream(String paramString, boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.31(this, paramString, paramBoolean));
  }
  
  protected native int nativeAddUpstream(long paramLong, int paramInt);
  
  protected native long nativeCreateContext(int paramInt1, int paramInt2, int paramInt3);
  
  protected native void nativeDestroyContext(long paramLong);
  
  protected native int nativeEnterRoom(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5, int paramInt6, String paramString6, String paramString7, int paramInt7);
  
  protected native int nativeExitRoom(long paramLong);
  
  protected native void nativeFlushC2SVideoCodecConfig(long paramLong, int paramInt);
  
  protected native void nativeInit(long paramLong, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  protected native void nativeSetMixTranscodingConfig(long paramLong, TRTCTranscodingConfigInner paramTRTCTranscodingConfigInner);
  
  protected native int nativeSetPriorRemoteVideoStreamType(long paramLong, int paramInt);
  
  protected void notifyEvent(String paramString, int paramInt, Bundle paramBundle)
  {
    runOnSDKThread(new TRTCCloudImpl.167(this, paramString, paramBundle, paramInt));
  }
  
  protected void onAVMemberEnter(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TRTCCloudImpl.134(this, new WeakReference(this), paramString, paramLong, paramInt1, paramInt2));
  }
  
  protected void onAVMemberExit(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TRTCCloudImpl.135(this, new WeakReference(this), paramString, paramLong, paramInt2));
    notifyEvent(this.mRoomInfo.getUserId(), 0, String.format("[%s]leave room", new Object[] { paramString }));
  }
  
  public void onAudioJitterBufferError(String paramString1, int paramInt, String paramString2) {}
  
  public void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    runOnSDKThread(new TRTCCloudImpl.120(this, paramInt, paramString2, paramString1));
  }
  
  public void onAudioPlayPcmData(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramString == null)
    {
      paramString = this.mAudioFrameListener;
      if (paramString != null)
      {
        TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        localTRTCAudioFrame.data = paramArrayOfByte;
        localTRTCAudioFrame.timestamp = paramLong;
        localTRTCAudioFrame.sampleRate = paramInt1;
        localTRTCAudioFrame.channel = paramInt2;
        paramString.onMixedPlayAudioFrame(localTRTCAudioFrame);
      }
    }
    else
    {
      runOnListenerThread(new TRTCCloudImpl.119(this, paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString));
    }
  }
  
  public void onAudioQosChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    onAudioQosChanged(this, paramInt1, paramInt2, paramInt3);
  }
  
  public void onAudioQosChanged(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!isPublishingInCloud(paramTRTCCloudImpl, 1)) {
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.139(this, paramInt1, paramInt2, paramInt3));
  }
  
  public void onBackgroudPushStop() {}
  
  protected void onCancelTranscoding(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.157(this, paramInt, paramString));
  }
  
  public void onEffectPlayFinish(int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.96(this, paramInt));
  }
  
  public void onEffectPlayStart(int paramInt1, int paramInt2)
  {
    runOnListenerThread(new TRTCCloudImpl.97(this, paramInt1, paramInt2));
  }
  
  public void onEncVideo(TXSNALPacket paramTXSNALPacket)
  {
    if (paramTXSNALPacket == null) {
      return;
    }
    synchronized (this.mNativeLock)
    {
      pushVideoFrame(paramTXSNALPacket);
      return;
    }
  }
  
  public void onEncVideoFormat(MediaFormat paramMediaFormat) {}
  
  protected void onEnterRoom(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    apiLog(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("onEnterRoom err:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    if (paramInt == 0) {
      TXCEventRecorderProxy.a("18446744073709551615", 5003, 1L, -1L, "", 0);
    } else {
      TXCEventRecorderProxy.a("18446744073709551615", 5003, 0L, -1L, "", 0);
    }
    runOnSDKThread(new TRTCCloudImpl.125(this, paramInt, paramString));
    runOnListenerThread(new TRTCCloudImpl.126(this, paramInt));
  }
  
  public void onIdrFpsChanged(int paramInt)
  {
    onIdrFpsChanged(this, paramInt);
  }
  
  public void onIdrFpsChanged(TRTCCloudImpl paramTRTCCloudImpl, int paramInt)
  {
    if (!isPublishingInCloud(paramTRTCCloudImpl, 2)) {
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.141(this, paramInt));
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    runOnSDKThread(new TRTCCloudImpl.117(this, paramBundle, paramInt));
  }
  
  public void onPlayEnd(int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.122(this, paramInt));
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    runOnListenerThread(new TRTCCloudImpl.123(this, paramLong1, paramLong2));
  }
  
  public void onPlayStart()
  {
    runOnListenerThread(new TRTCCloudImpl.121(this));
  }
  
  public void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onRecordError(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", "18446744073709551615");
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordError code = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    TXCLog.e("TRTCCloudImpl", localStringBuilder.toString());
    if (paramInt == -1)
    {
      localBundle.putInt("EVT_ID", -1302);
      onNotifyEvent(-1302, localBundle);
    }
    if (paramInt == -6)
    {
      localBundle.putInt("EVT_ID", 2027);
      onNotifyEvent(2027, localBundle);
    }
    if (paramInt == -7)
    {
      localBundle.putInt("EVT_ID", 2029);
      onNotifyEvent(2029, localBundle);
    }
  }
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    TRTCCloudListener.TRTCAudioFrameListener localTRTCAudioFrameListener = this.mAudioFrameListener;
    if (localTRTCAudioFrameListener != null)
    {
      TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
      localTRTCAudioFrame.data = paramArrayOfByte;
      localTRTCAudioFrame.timestamp = paramLong;
      localTRTCAudioFrame.sampleRate = paramInt1;
      localTRTCAudioFrame.channel = paramInt2;
      localTRTCAudioFrameListener.onLocalProcessedAudioFrame(localTRTCAudioFrame);
    }
  }
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    TRTCCloudListener.TRTCAudioFrameListener localTRTCAudioFrameListener = this.mAudioFrameListener;
    if (localTRTCAudioFrameListener != null)
    {
      TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
      localTRTCAudioFrame.data = paramArrayOfByte;
      localTRTCAudioFrame.timestamp = paramLong;
      localTRTCAudioFrame.sampleRate = paramInt1;
      localTRTCAudioFrame.channel = paramInt2;
      localTRTCAudioFrameListener.onCapturedRawAudioFrame(localTRTCAudioFrame);
    }
  }
  
  public void onRenderVideoFrame(String paramString, int paramInt, TXSVideoFrame paramTXSVideoFrame)
  {
    if (paramTXSVideoFrame == null) {
      return;
    }
    TRTCCloudDef.TRTCVideoFrame localTRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
    localTRTCVideoFrame.width = paramTXSVideoFrame.width;
    localTRTCVideoFrame.height = paramTXSVideoFrame.height;
    localTRTCVideoFrame.rotation = paramTXSVideoFrame.rotation;
    localTRTCVideoFrame.timestamp = paramTXSVideoFrame.pts;
    int i = translateStreamType(paramInt);
    Object localObject2 = null;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equalsIgnoreCase("18446744073709551615")) && (!paramString.equalsIgnoreCase(this.mRoomInfo.getTinyId()))) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    Object localObject1;
    if (paramInt != 0)
    {
      localObject1 = this.mRoomInfo.getUserId();
      localTRTCVideoFrame.pixelFormat = this.mRoomInfo.localPixelFormat;
      localTRTCVideoFrame.bufferType = this.mRoomInfo.localBufferType;
      paramString = this.mRoomInfo.localListener;
    }
    else
    {
      Iterator localIterator = this.mRenderListenerMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        TRTCCloudImpl.RenderListenerAdapter localRenderListenerAdapter = (TRTCCloudImpl.RenderListenerAdapter)((Map.Entry)localObject1).getValue();
        if ((localRenderListenerAdapter != null) && (paramString.equalsIgnoreCase(((TRTCCloudImpl.RenderListenerAdapter)((Map.Entry)localObject1).getValue()).strTinyID)))
        {
          localTRTCVideoFrame.pixelFormat = localRenderListenerAdapter.pixelFormat;
          localTRTCVideoFrame.bufferType = localRenderListenerAdapter.bufferType;
          paramString = localRenderListenerAdapter.listener;
          localObject1 = (String)((Map.Entry)localObject1).getKey();
          break label271;
        }
      }
      localObject1 = "";
      paramString = localObject2;
    }
    label271:
    if (paramString != null)
    {
      if (localTRTCVideoFrame.bufferType == 1)
      {
        if (paramTXSVideoFrame.buffer == null) {
          paramTXSVideoFrame.loadYUVBufferFromGL();
        }
        localTRTCVideoFrame.buffer = paramTXSVideoFrame.buffer;
      }
      else if (localTRTCVideoFrame.bufferType == 2)
      {
        localTRTCVideoFrame.data = paramTXSVideoFrame.data;
        if (localTRTCVideoFrame.data == null)
        {
          localTRTCVideoFrame.data = new byte[paramTXSVideoFrame.width * paramTXSVideoFrame.height * 3 / 2];
          paramTXSVideoFrame.loadYUVArray(localTRTCVideoFrame.data);
        }
      }
      else if (localTRTCVideoFrame.bufferType == 3)
      {
        if (paramTXSVideoFrame.eglContext == null) {
          return;
        }
        localTRTCVideoFrame.texture = new TRTCCloudDef.TRTCTexture();
        localTRTCVideoFrame.texture.textureId = paramTXSVideoFrame.textureId;
        if ((paramTXSVideoFrame.eglContext instanceof javax.microedition.khronos.egl.EGLContext)) {
          localTRTCVideoFrame.texture.eglContext10 = ((javax.microedition.khronos.egl.EGLContext)paramTXSVideoFrame.eglContext);
        } else if ((paramTXSVideoFrame.eglContext instanceof android.opengl.EGLContext)) {
          localTRTCVideoFrame.texture.eglContext14 = ((android.opengl.EGLContext)paramTXSVideoFrame.eglContext);
        }
      }
      paramString.onRenderVideoFrame((String)localObject1, i, localTRTCVideoFrame);
      if ((this.mRoomInfo.enableCustomPreprocessor) && (paramInt != 0))
      {
        if (localTRTCVideoFrame.bufferType == 2)
        {
          paramTXSVideoFrame.data = localTRTCVideoFrame.data;
          return;
        }
        if (localTRTCVideoFrame.bufferType == 3) {
          paramTXSVideoFrame.textureId = localTRTCVideoFrame.texture.textureId;
        }
      }
    }
  }
  
  public void onRequestKeyFrame(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.118(this, paramString, paramInt));
  }
  
  public void onScreenCapturePaused()
  {
    runOnListenerThread(new TRTCCloudImpl.59(this));
  }
  
  public void onScreenCaptureResumed()
  {
    runOnListenerThread(new TRTCCloudImpl.58(this));
  }
  
  public void onScreenCaptureStarted()
  {
    runOnListenerThread(new TRTCCloudImpl.57(this));
  }
  
  public void onScreenCaptureStopped(int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.60(this, paramInt));
  }
  
  protected void onSendFirstLocalAudioFrame()
  {
    runOnListenerThread(new TRTCCloudImpl.160(this));
  }
  
  protected void onSendFirstLocalVideoFrame(int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.159(this, paramInt));
  }
  
  public void onVideoConfigChanged(int paramInt, boolean paramBoolean)
  {
    onVideoConfigChanged(this, paramInt, paramBoolean);
  }
  
  public void onVideoConfigChanged(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, boolean paramBoolean)
  {
    if (!isPublishingInCloud(paramTRTCCloudImpl, paramInt)) {
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.149(this, paramInt, paramBoolean));
  }
  
  public void onVideoQosChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    onVideoQosChanged(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void onVideoQosChanged(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!isPublishingInCloud(paramTRTCCloudImpl, paramInt1)) {
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.140(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8));
  }
  
  public void pauseAudioEffect(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.103(this, paramInt));
  }
  
  public void pauseBGM()
  {
    runOnSDKThread(new TRTCCloudImpl.87(this));
  }
  
  public void pauseScreenCapture()
  {
    runOnSDKThread(new TRTCCloudImpl.26(this));
  }
  
  public void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam paramTRTCAudioEffectParam)
  {
    runOnSDKThread(new TRTCCloudImpl.98(this, paramTRTCAudioEffectParam));
  }
  
  public void playBGM(String paramString, TRTCCloud.BGMNotify paramBGMNotify)
  {
    runOnSDKThread(new TRTCCloudImpl.85(this, paramBGMNotify, paramString));
  }
  
  public void resumeAudioEffect(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.104(this, paramInt));
  }
  
  public void resumeBGM()
  {
    runOnSDKThread(new TRTCCloudImpl.88(this));
  }
  
  public void resumeScreenCapture()
  {
    runOnSDKThread(new TRTCCloudImpl.27(this));
  }
  
  protected void runOnListenerThread(Runnable paramRunnable)
  {
    Handler localHandler = this.mListenerHandler;
    if (localHandler == null)
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        this.mMainHandler.post(paramRunnable);
        return;
      }
      paramRunnable.run();
      return;
    }
    if (Looper.myLooper() != localHandler.getLooper())
    {
      localHandler.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected void runOnMainThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.mMainHandler.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected void runOnSDKThread(Runnable paramRunnable)
  {
    if ((this.mSDKHandler != null) && (this.mIsSDKThreadAlive.get()))
    {
      if (Looper.myLooper() != this.mSDKHandler.getLooper()) {
        try
        {
          this.mSDKHandler.post(paramRunnable);
          return;
        }
        catch (Exception paramRunnable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("(");
          localStringBuilder.append(hashCode());
          localStringBuilder.append(")trtc_api run on sdk fail. alive:");
          localStringBuilder.append(this.mIsSDKThreadAlive.get());
          TXCLog.e("TRTCCloudImpl", localStringBuilder.toString(), paramRunnable);
          return;
        }
      }
      paramRunnable.run();
      return;
    }
    paramRunnable = new StringBuilder();
    paramRunnable.append("(");
    paramRunnable.append(hashCode());
    paramRunnable.append(")trtc_api sdk thread is dead, ignore task.");
    TXCLog.e("TRTCCloudImpl", paramRunnable.toString());
  }
  
  public void selectMotionTmpl(String paramString)
  {
    runOnSDKThread(new TRTCCloudImpl.69(this, paramString));
  }
  
  public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame)
  {
    if (paramTRTCAudioFrame == null)
    {
      apiLog("sendCustomAudioData parameter is null");
      return;
    }
    com.tencent.liteav.basic.structs.a locala = new com.tencent.liteav.basic.structs.a();
    locala.f = new byte[paramTRTCAudioFrame.data.length];
    System.arraycopy(paramTRTCAudioFrame.data, 0, locala.f, 0, paramTRTCAudioFrame.data.length);
    locala.a = paramTRTCAudioFrame.sampleRate;
    locala.b = paramTRTCAudioFrame.channel;
    locala.c = 16;
    if (0L == paramTRTCAudioFrame.timestamp) {
      locala.e = TXCTimeUtil.generatePtsMS();
    } else {
      locala.e = paramTRTCAudioFrame.timestamp;
    }
    runOnSDKThread(new TRTCCloudImpl.84(this, locala));
  }
  
  public boolean sendCustomCmdMsg(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      TXCLog.e("TRTCCloudImpl", "invalid message data", paramArrayOfByte);
      paramArrayOfByte = null;
    }
    if (this.mCurrentRole == 21)
    {
      apiLog("ignore send custom cmd msg for audience");
      return false;
    }
    long l1 = System.currentTimeMillis();
    if (this.mLastSendMsgTimeMs == 0L) {
      this.mLastSendMsgTimeMs = l1;
    }
    long l2 = this.mLastSendMsgTimeMs;
    boolean bool = true;
    if (l1 - l2 < 1000L)
    {
      int i = this.mSendMsgCount;
      if (i < 30)
      {
        int j = this.mSendMsgSize;
        if (j < 8192)
        {
          this.mSendMsgCount = (i + 1);
          this.mSendMsgSize = (j + paramArrayOfByte.length());
          break label204;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send msg too more self:");
      localStringBuilder.append(hashCode());
      TXCLog.e("TRTCCloudImpl", localStringBuilder.toString());
      bool = false;
    }
    else
    {
      this.mLastSendMsgTimeMs = l1;
      this.mSendMsgCount = 1;
      this.mSendMsgSize = paramArrayOfByte.length();
    }
    label204:
    if (bool) {
      runOnSDKThread(new TRTCCloudImpl.114(this, paramInt, paramArrayOfByte, paramBoolean1, paramBoolean2));
    }
    return bool;
  }
  
  public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    if (paramTRTCVideoFrame == null)
    {
      apiLog("sendCustomVideoData parameter is null");
      return;
    }
    StringBuilder localStringBuilder;
    if ((paramTRTCVideoFrame.pixelFormat != 1) && (paramTRTCVideoFrame.pixelFormat != 4) && (paramTRTCVideoFrame.pixelFormat != 2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendCustomVideoData parameter error unsupported pixel format ");
      localStringBuilder.append(paramTRTCVideoFrame.pixelFormat);
      apiLog(localStringBuilder.toString());
      return;
    }
    if ((paramTRTCVideoFrame.bufferType != 2) && (paramTRTCVideoFrame.texture == null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendCustomVideoData parameter error unsupported buffer type ");
      localStringBuilder.append(paramTRTCVideoFrame.bufferType);
      apiLog(localStringBuilder.toString());
      return;
    }
    if ((this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.CUSTOM) && (this.mRoomState == 2))
    {
      if (this.mRoomInfo.muteLocalVideo) {
        return;
      }
      try
      {
        if (this.mCustomVideoUtil == null) {
          this.mCustomVideoUtil = new TRTCCustomTextureUtil(this.mCaptureAndEnc);
        }
        if (this.mCustomVideoUtil != null) {
          this.mCustomVideoUtil.sendCustomTexture(paramTRTCVideoFrame);
        }
        if (this.mLastCaptureCalculateTS == 0L)
        {
          this.mLastCaptureCalculateTS = System.currentTimeMillis();
          this.mLastCaptureFrameCount = 0L;
          this.mCaptureFrameCount = 0L;
          return;
        }
        this.mCaptureFrameCount += 1L;
        return;
      }
      finally {}
    }
  }
  
  protected void sendJsonCmd(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("jsonParam")) && ((paramJSONObject.get("jsonParam") instanceof JSONObject)))
    {
      paramJSONObject = paramJSONObject.getJSONObject("jsonParam").toString();
      nativeSendJsonCmd(this.mNativeRtcContext, paramJSONObject, paramString);
      return;
    }
    apiLog("callExperimentalAPI[lack parameter or illegal type]: sendJsonCMD");
  }
  
  public boolean sendSEIMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    if (this.mCurrentRole == 21)
    {
      apiLog("ignore send sei msg for audience");
      return false;
    }
    long l1 = System.currentTimeMillis();
    if (this.mLastSendMsgTimeMs == 0L) {
      this.mLastSendMsgTimeMs = l1;
    }
    long l2 = this.mLastSendMsgTimeMs;
    boolean bool = true;
    if (l1 - l2 < 1000L)
    {
      int i = this.mSendMsgCount;
      if (i < 30)
      {
        int j = this.mSendMsgSize;
        if (j < 8192)
        {
          this.mSendMsgCount = (i + 1);
          this.mSendMsgSize = (j + paramArrayOfByte.length);
          break label170;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send msg too more self:");
      localStringBuilder.append(hashCode());
      TXCLog.e("TRTCCloudImpl", localStringBuilder.toString());
      bool = false;
    }
    else
    {
      this.mLastSendMsgTimeMs = l1;
      this.mSendMsgCount = 1;
      this.mSendMsgSize = paramArrayOfByte.length;
    }
    label170:
    if (bool) {
      runOnSDKThread(new TRTCCloudImpl.115(this, paramArrayOfByte, paramInt));
    }
    return bool;
  }
  
  public void setAllAudioEffectsVolume(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.102(this, paramInt));
  }
  
  public void setAudioCaptureVolume(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i > 100) {
      paramInt = 100;
    }
    this.mAudioCaptureVolume = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioCaptureVolume:  volume=");
    localStringBuilder.append(this.mAudioCaptureVolume);
    apiLog(localStringBuilder.toString());
    TXAudioEffectManagerImpl.getInstance().setVoiceCaptureVolume(paramInt);
  }
  
  public void setAudioEffectVolume(int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TRTCCloudImpl.99(this, paramInt1, paramInt2));
  }
  
  public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener)
  {
    runOnSDKThread(new TRTCCloudImpl.116(this, paramTRTCAudioFrameListener, this));
  }
  
  public void setAudioPlayoutVolume(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i > 100) {
      paramInt = 100;
    }
    this.mAudioPlayoutVolume = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioPlayoutVolume:  volume=");
    localStringBuilder.append(this.mAudioPlayoutVolume);
    apiLog(localStringBuilder.toString());
    TXAudioEffectManagerImpl.getInstance().setAudioPlayoutVolume(paramInt);
  }
  
  public void setAudioQuality(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.45(this, paramInt));
  }
  
  public void setAudioRoute(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.49(this, paramInt));
  }
  
  public void setBGMPlayoutVolume(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.92(this, paramInt));
  }
  
  public int setBGMPosition(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.89(this, paramInt));
    return 0;
  }
  
  public void setBGMPublishVolume(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.93(this, paramInt));
  }
  
  public void setBGMVolume(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.91(this, paramInt));
  }
  
  public void setBeautyStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    runOnSDKThread(new TRTCCloudImpl.66(this, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void setChinLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.76(this, paramInt));
  }
  
  public void setDebugViewMargin(String paramString, TRTCCloud.TRTCViewMargin paramTRTCViewMargin)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.106(this, paramString, paramTRTCViewMargin));
  }
  
  public void setDefaultStreamRecvMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    runOnSDKThread(new TRTCCloudImpl.10(this, paramBoolean1, paramBoolean2));
  }
  
  public void setEyeScaleLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.72(this, paramInt));
  }
  
  public void setFaceShortLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.75(this, paramInt));
  }
  
  public void setFaceSlimLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.73(this, paramInt));
  }
  
  public void setFaceVLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.74(this, paramInt));
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    runOnSDKThread(new TRTCCloudImpl.67(this, paramBitmap));
  }
  
  public void setFilterConcentration(float paramFloat)
  {
    runOnSDKThread(new TRTCCloudImpl.68(this, paramFloat));
  }
  
  public void setFocusPosition(int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TRTCCloudImpl.65(this, paramInt1, paramInt2));
  }
  
  public void setGSensorMode(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.40(this, paramInt));
  }
  
  @TargetApi(18)
  public boolean setGreenScreenFile(String paramString)
  {
    runOnSDKThread(new TRTCCloudImpl.71(this, paramString));
    return true;
  }
  
  public void setListener(TRTCCloudListener paramTRTCCloudListener)
  {
    runOnSDKThread(new TRTCCloudImpl.3(this, paramTRTCCloudListener));
  }
  
  public void setListenerHandler(Handler paramHandler)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setListenerHandler ");
    localStringBuilder.append(paramHandler);
    apiLog(localStringBuilder.toString());
    if (paramHandler == null) {
      this.mListenerHandler = new Handler(Looper.getMainLooper());
    } else {
      this.mListenerHandler = paramHandler;
    }
    runOnSDKThread(new TRTCCloudImpl.4(this));
  }
  
  public int setLocalVideoRenderListener(int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2))
    {
      paramTRTCVideoRenderListener = new StringBuilder();
      paramTRTCVideoRenderListener.append("setLocalVideoRenderListener unsupported pixelFormat : ");
      paramTRTCVideoRenderListener.append(paramInt1);
      apiLog(paramTRTCVideoRenderListener.toString());
      return -1327;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 3))
    {
      paramTRTCVideoRenderListener = new StringBuilder();
      paramTRTCVideoRenderListener.append("setLocalVideoRenderListener unsupported bufferType : ");
      paramTRTCVideoRenderListener.append(paramInt2);
      apiLog(paramTRTCVideoRenderListener.toString());
      return -1328;
    }
    runOnSDKThread(new TRTCCloudImpl.81(this, paramInt1, paramInt2, paramTRTCVideoRenderListener));
    return 0;
  }
  
  public void setLocalViewFillMode(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.35(this, paramInt));
  }
  
  public void setLocalViewMirror(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.43(this, paramInt));
  }
  
  public void setLocalViewRotation(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.37(this, paramInt));
  }
  
  public void setMicVolumeOnMixing(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.90(this, paramInt));
  }
  
  public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    runOnSDKThread(new TRTCCloudImpl.113(this, paramTRTCTranscodingConfig));
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.70(this, paramBoolean));
  }
  
  public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam paramTRTCNetworkQosParam)
  {
    runOnSDKThread(new TRTCCloudImpl.34(this, paramTRTCNetworkQosParam));
  }
  
  public void setNoseSlimLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.77(this, paramInt));
  }
  
  protected void setPerformanceMode(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setPerformanceMode[lack parameter]");
      return;
    }
    if (!paramJSONObject.has("mode"))
    {
      apiLog("setPerformanceMode[lack parameter]: mode");
      return;
    }
    if (paramJSONObject.getInt("mode") == 1)
    {
      this.mPerformanceMode = 1;
      this.mCaptureAndEnc.b().enableSharpnessEnhancement(false);
      return;
    }
    this.mPerformanceMode = 0;
  }
  
  public int setPriorRemoteVideoStreamType(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.42(this, paramInt));
    return 0;
  }
  
  public void setRemoteAudioVolume(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.54(this, paramInt, paramString));
  }
  
  public void setRemoteSubStreamViewFillMode(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.20(this, paramString, paramInt));
  }
  
  public void setRemoteSubStreamViewRotation(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.21(this, paramString, paramInt));
  }
  
  public int setRemoteVideoRenderListener(String paramString, int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2))
    {
      paramString = new StringBuilder();
      paramString.append("setLocalVideoRenderListener unsupported pixelFormat : ");
      paramString.append(paramInt1);
      apiLog(paramString.toString());
      return -1327;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 3))
    {
      paramString = new StringBuilder();
      paramString.append("setLocalVideoRenderListener unsupported bufferType : ");
      paramString.append(paramInt2);
      apiLog(paramString.toString());
      return -1328;
    }
    runOnSDKThread(new TRTCCloudImpl.82(this, paramString, paramInt1, paramInt2, paramTRTCVideoRenderListener));
    return 0;
  }
  
  public int setRemoteVideoStreamType(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.48(this, paramString, paramInt));
    return 0;
  }
  
  public void setRemoteViewFillMode(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.36(this, paramString, paramInt));
  }
  
  public void setRemoteViewRotation(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.38(this, paramString, paramInt));
  }
  
  protected void setRenderView(String paramString, TRTCRoomInfo.RenderInfo paramRenderInfo, TXCloudVideoView paramTXCloudVideoView, TRTCCloud.TRTCViewMargin paramTRTCViewMargin)
  {
    if ((paramRenderInfo != null) && (paramRenderInfo.render != null))
    {
      if (paramRenderInfo.render.getVideoRender() == null) {
        return;
      }
      com.tencent.liteav.renderer.e locale = paramRenderInfo.render.getVideoRender();
      if (paramTXCloudVideoView == null)
      {
        locale.c(null);
        return;
      }
      runOnMainThread(new TRTCCloudImpl.163(this, paramTXCloudVideoView, paramRenderInfo, locale, paramString, paramTRTCViewMargin));
    }
  }
  
  public void setReverbType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 7))
    {
      runOnSDKThread(new TRTCCloudImpl.94(this, paramInt));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reverbType not support :");
    localStringBuilder.append(paramInt);
    TXCLog.e("TRTCCloudImpl", localStringBuilder.toString());
  }
  
  protected void setSEIPayloadType(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("payloadType")))
    {
      int i = paramJSONObject.getInt("payloadType");
      if ((i != 5) && (i != 243))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("callExperimentalAPI[invalid param]: payloadType[");
        paramJSONObject.append(i);
        paramJSONObject.append("]");
        apiLog(paramJSONObject.toString());
        return;
      }
      if (nativeSetSEIPayloadType(this.mNativeRtcContext, i))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("callExperimentalAPI[succeeded]: setSEIPayloadType (");
        paramJSONObject.append(i);
        paramJSONObject.append(")");
        apiLog(paramJSONObject.toString());
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("callExperimentalAPI[failed]: setSEIPayloadType (");
      paramJSONObject.append(i);
      paramJSONObject.append(")");
      apiLog(paramJSONObject.toString());
      return;
    }
    apiLog("callExperimentalAPI[lack parameter or illegal type]: payloadType");
  }
  
  public void setSystemVolumeType(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.55(this, paramInt));
  }
  
  public void setVideoEncoderMirror(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.44(this, paramBoolean));
  }
  
  public void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    runOnSDKThread(new TRTCCloudImpl.33(this, paramTRTCVideoEncParam));
  }
  
  public void setVideoEncoderRotation(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.39(this, paramInt));
  }
  
  public void setVideoMuteImage(Bitmap paramBitmap, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.29(this, paramBitmap, paramInt));
  }
  
  public boolean setVoiceChangerType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 11))
    {
      runOnSDKThread(new TRTCCloudImpl.95(this, paramInt));
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("voiceChangerType not support :");
    localStringBuilder.append(paramInt);
    TXCLog.e("TRTCCloudImpl", localStringBuilder.toString());
    return false;
  }
  
  public void setWatermark(Bitmap paramBitmap, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    runOnSDKThread(new TRTCCloudImpl.78(this, paramInt, paramBitmap, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public void setZoom(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.64(this, paramInt));
  }
  
  public void showDebugView(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.105(this, paramInt));
  }
  
  public void snapshotVideo(String paramString, int paramInt, TRTCCloudListener.TRTCSnapshotListener paramTRTCSnapshotListener)
  {
    apiLog(String.format("snapshotVideo user:%s streamType:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    runOnSDKThread(new TRTCCloudImpl.23(this, paramString, paramTRTCSnapshotListener, paramInt));
  }
  
  public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams paramTRTCAudioRecordingParams)
  {
    if (TextUtils.isEmpty(paramTRTCAudioRecordingParams.filePath))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startLocalAudioRecord error:");
      localStringBuilder.append(paramTRTCAudioRecordingParams.filePath);
      apiLog(localStringBuilder.toString());
      return -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startLocalAudioRecord:");
    localStringBuilder.append(paramTRTCAudioRecordingParams.filePath);
    apiLog(localStringBuilder.toString());
    TXCAudioEngine.getInstance().setAudioDumpingListener(new TRTCCloudImpl.62(this));
    return TXCAudioEngine.getInstance().startLocalAudioDumping(48000, 16, paramTRTCAudioRecordingParams.filePath);
  }
  
  protected void startCollectStatus()
  {
    Handler localHandler = this.mSDKHandler;
    if (localHandler != null) {
      localHandler.postDelayed(this.mStatusNotifyTask, 1000L);
    }
  }
  
  public void startLocalAudio()
  {
    runOnSDKThread(new TRTCCloudImpl.46(this));
  }
  
  public void startLocalPreview(boolean paramBoolean, TXCloudVideoView paramTXCloudVideoView)
  {
    runOnSDKThread(new TRTCCloudImpl.14(this, paramBoolean, paramTXCloudVideoView));
  }
  
  public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam)
  {
    if (paramTRTCPublishCDNParam == null)
    {
      apiLog("startPublishCDNStream param is null");
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.109(this, paramTRTCPublishCDNParam));
  }
  
  public void startPublishing(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.112(this, paramString, paramInt));
  }
  
  public void startRemoteSubStreamView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    runOnSDKThread(new TRTCCloudImpl.18(this, paramString, paramTXCloudVideoView));
  }
  
  public void startRemoteView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    runOnSDKThread(new TRTCCloudImpl.16(this, paramString, paramTXCloudVideoView));
  }
  
  public void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams paramTRTCScreenShareParams)
  {
    runOnSDKThread(new TRTCCloudImpl.24(this, paramTRTCVideoEncParam, paramTRTCScreenShareParams));
  }
  
  public void startSpeedTest(int paramInt, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      runOnSDKThread(new TRTCCloudImpl.107(this, paramInt, paramString1, paramString2));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startSpeedTest failed with invalid params. userId = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", userSig = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    TXCLog.e("TRTCCloudImpl", localStringBuilder.toString());
  }
  
  protected void startVolumeLevelCal(boolean paramBoolean)
  {
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(paramBoolean, this.mAudioVolumeEvalInterval);
    if (paramBoolean)
    {
      if (this.mVolumeLevelNotifyTask == null)
      {
        this.mVolumeLevelNotifyTask = new TRTCCloudImpl.VolumeLevelNotifyTask(this);
        this.mSDKHandler.postDelayed(this.mVolumeLevelNotifyTask, this.mAudioVolumeEvalInterval);
      }
    }
    else
    {
      this.mVolumeLevelNotifyTask = null;
      this.mAudioVolumeEvalInterval = 0;
    }
  }
  
  public void stopAllAudioEffects()
  {
    runOnSDKThread(new TRTCCloudImpl.101(this));
  }
  
  public void stopAllRemoteView()
  {
    runOnSDKThread(new TRTCCloudImpl.22(this));
  }
  
  public void stopAudioEffect(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.100(this, paramInt));
  }
  
  public void stopAudioRecording()
  {
    TXCAudioEngine.getInstance().stopLocalAudioDumping();
  }
  
  public void stopBGM()
  {
    runOnSDKThread(new TRTCCloudImpl.86(this));
  }
  
  protected void stopCollectStatus()
  {
    Handler localHandler = this.mSDKHandler;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.mStatusNotifyTask);
    }
  }
  
  public void stopLocalAudio()
  {
    runOnSDKThread(new TRTCCloudImpl.47(this));
  }
  
  public void stopLocalPreview()
  {
    runOnSDKThread(new TRTCCloudImpl.15(this));
  }
  
  public void stopPublishCDNStream()
  {
    runOnSDKThread(new TRTCCloudImpl.111(this));
  }
  
  public void stopPublishing()
  {
    runOnSDKThread(new TRTCCloudImpl.110(this));
  }
  
  protected void stopRemoteRender(TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if (paramUserInfo == null) {
      return;
    }
    apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", new Object[] { paramUserInfo.userID, Long.valueOf(paramUserInfo.tinyID), Integer.valueOf(paramUserInfo.streamType) }));
    TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(paramUserInfo.tinyID));
    TXCloudVideoView localTXCloudVideoView1 = paramUserInfo.mainRender.view;
    TXCloudVideoView localTXCloudVideoView2 = paramUserInfo.subRender.view;
    if (paramUserInfo.mainRender.render != null)
    {
      paramUserInfo.mainRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.a);
      paramUserInfo.mainRender.render.stop();
      if ((localTXCloudVideoView1 == null) && (paramUserInfo.mainRender.render.getVideoRender() != null)) {
        paramUserInfo.mainRender.render.getVideoRender().e();
      }
    }
    if (paramUserInfo.subRender.render != null)
    {
      paramUserInfo.subRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.a);
      paramUserInfo.subRender.render.stop();
      if ((localTXCloudVideoView2 == null) && (paramUserInfo.subRender.render.getVideoRender() != null)) {
        paramUserInfo.subRender.render.getVideoRender().e();
      }
    }
    paramUserInfo.mainRender.stop();
    paramUserInfo.subRender.stop();
    runOnMainThread(new TRTCCloudImpl.164(this, localTXCloudVideoView1, localTXCloudVideoView2));
  }
  
  public void stopRemoteSubStreamView(String paramString)
  {
    runOnSDKThread(new TRTCCloudImpl.19(this, paramString));
  }
  
  public void stopRemoteView(String paramString)
  {
    runOnSDKThread(new TRTCCloudImpl.17(this, paramString));
  }
  
  public void stopScreenCapture()
  {
    runOnSDKThread(new TRTCCloudImpl.25(this));
  }
  
  public void stopSpeedTest()
  {
    runOnSDKThread(new TRTCCloudImpl.108(this));
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startLocalPreview surfaceChanged ");
    localStringBuilder.append(paramSurfaceHolder.getSurface());
    localStringBuilder.append(" width ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", height ");
    localStringBuilder.append(paramInt3);
    apiLog(localStringBuilder.toString());
    this.mCaptureAndEnc.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder.getSurface().isValid())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startLocalPreview surfaceCreated ");
      localStringBuilder.append(paramSurfaceHolder.getSurface());
      apiLog(localStringBuilder.toString());
      this.mCaptureAndEnc.a(paramSurfaceHolder.getSurface());
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startLocalPreview surfaceDestroyed ");
    localStringBuilder.append(paramSurfaceHolder.getSurface());
    apiLog(localStringBuilder.toString());
    this.mCaptureAndEnc.a(null);
  }
  
  public void switchCamera()
  {
    runOnSDKThread(new TRTCCloudImpl.63(this));
  }
  
  public void switchRole(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.11(this, paramInt));
  }
  
  protected void updateAppScene(int paramInt)
  {
    this.mAppScene = paramInt;
    int i = this.mAppScene;
    if ((i != 0) && (i != 1)) {
      this.mAppScene = 0;
    }
    if (this.mConfig.a * this.mConfig.b >= 518400) {
      this.mAppScene = 1;
    }
    updateEncType();
    apiLog(String.format("update appScene[%d] for video enc[%d] source scene[%d]", new Object[] { Integer.valueOf(this.mAppScene), Integer.valueOf(this.mConfig.j), Integer.valueOf(paramInt) }));
  }
  
  protected void updatePrivateMapKey(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("callExperimentalAPI[update private map key fail, params is null");
      return;
    }
    paramJSONObject = paramJSONObject.getString("privateMapKey");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      nativeUpdatePrivateMapKey(this.mNativeRtcContext, paramJSONObject);
      return;
    }
    apiLog("callExperimentalAPI[update private map key fail, key is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl
 * JD-Core Version:    0.7.0.1
 */