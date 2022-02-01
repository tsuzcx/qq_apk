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
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;
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
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.e.a;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d.a;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManager.TXAudioRoute;
import com.tencent.liteav.device.TXDeviceManager.TXSystemVolumeType;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.liteav.device.TXDeviceManagerImpl.TXDeviceManagerListener;
import com.tencent.liteav.g.a;
import com.tencent.liteav.o;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.liteav.videoencoder.b.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloud.BGMNotify;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioEffectParam;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrameCallbackFormat;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioRecordingParams;
import com.tencent.trtc.TRTCCloudDef.TRTCLocalRecordingParams;
import com.tencent.trtc.TRTCCloudDef.TRTCNetworkQosParam;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCPublishCDNParam;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCRenderParams;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCSwitchRoomConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCRemoteStatistics;
import com.tencent.trtc.TRTCSubCloud;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TRTCCloudImpl
  extends TRTCCloud
  implements SurfaceHolder.Callback, TXCRenderAndDec.b, com.tencent.liteav.audio.c, com.tencent.liteav.audio.d, com.tencent.liteav.audio.e, com.tencent.liteav.audio.f, com.tencent.liteav.audio.g, com.tencent.liteav.audio.h, com.tencent.liteav.basic.c.b, d.a, o, a.a
{
  private static final int CURRENT_ENCODE_TYPE_H264 = 0;
  private static final int CURRENT_ENCODE_TYPE_H265 = 1;
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
  private static final int START_LOCAL_RECORDING_FAILED = -1;
  private static final int STATE_INTERVAL = 2000;
  private static final String TAG = "TRTCCloudImpl";
  private static TRTCCloudImpl sInstance;
  protected int mAppScene;
  private int mAudioCaptureVolume;
  protected TRTCCloudListener.TRTCAudioFrameListener mAudioFrameListener;
  private int mAudioPlayoutVolume;
  protected int mAudioVolumeEvalInterval;
  private TRTCCloud.BGMNotify mBGMNotify;
  private int mBackground;
  private com.tencent.liteav.basic.c.a mCallback;
  protected com.tencent.liteav.d mCaptureAndEnc;
  private int mCodecType;
  protected com.tencent.liteav.g mConfig;
  protected Context mContext;
  private int mCurrentOrientation;
  protected HashMap<Integer, TRTCCloudImpl> mCurrentPublishClouds;
  protected int mCurrentRole;
  private int mCustomCaptureGLSyncMode;
  private final Object mCustomCaptureLock;
  private boolean mCustomRemoteRender;
  private TRTCCustomTextureUtil mCustomSubStreamVideoUtil;
  private TRTCCustomTextureUtil mCustomVideoUtil;
  protected int mDebugType;
  private TXDeviceManagerImpl mDeviceManager;
  private TXDeviceManagerImpl.TXDeviceManagerListener mDeviceManagerListener;
  private boolean mEnableCustomAudioCapture;
  private boolean mEnableCustomVideoCapture;
  protected boolean mEnableEosMode;
  private boolean mEnableSmallStream;
  private boolean mEnableSoftAEC;
  private boolean mEnableSoftAGC;
  private boolean mEnableSoftANS;
  private View mFloatingWindow;
  private int mFramework;
  private TRTCEncodeTypeDecision mH265Decision;
  private boolean mIsAudioCapturing;
  protected boolean mIsExitOldRoom;
  private AtomicBoolean mIsSDKThreadAlive;
  private boolean mIsVideoCapturing;
  private boolean mKeepAVCaptureWhenEnterRoomFailed;
  private long mLastLogCustomCmdMsgTs;
  private long mLastLogSEIMsgTs;
  private long mLastSendMsgTimeMs;
  protected long mLastStateTimeMs;
  private final Bundle mLatestParamsOfBigEncoder;
  private final Bundle mLatestParamsOfSmallEncoder;
  private Handler mListenerHandler;
  private com.tencent.liteav.basic.util.f mMainHandler;
  protected Object mNativeLock;
  protected long mNativeRtcContext;
  private int mNetType;
  private TRTCCloudImpl.DisplayOrientationDetector mOrientationEventListener;
  private boolean mOverrideFPSFromUser;
  protected int mPerformanceMode;
  private int mPlayoutAudioTunnelId;
  protected int mPriorStreamType;
  private int mPublishAudioTunnelId;
  private int mQosMode;
  private int mQosPreference;
  private long mRecvCustomCmdMsgCountInPeriod;
  protected int mRecvMode;
  private long mRecvSEIMsgCountInPeriod;
  protected HashMap<String, TRTCCloudImpl.RenderListenerAdapter> mRenderListenerMap;
  protected TRTCRoomInfo mRoomInfo;
  protected int mRoomState;
  protected int mRoomType;
  protected com.tencent.liteav.basic.util.f mSDKHandler;
  private int mSendMsgCount;
  private int mSendMsgSize;
  private int mSensorMode;
  private final TRTCCloudDef.TRTCVideoEncParam mSmallEncParam;
  private int mSoftAECLevel;
  private int mSoftAGCLevel;
  private int mSoftANSLevel;
  private TRTCCloudImpl.StatusTask mStatusNotifyTask;
  private Set<Integer> mStreamTypes;
  protected ArrayList<WeakReference<TRTCCloudImpl>> mSubClouds;
  protected com.tencent.liteav.d mSubStreamCaptureAndEnc;
  private Surface mSurfaceFromTextureView;
  protected TRTCCloudListener mTRTCListener;
  protected int mTargetRole;
  private final TextureView.SurfaceTextureListener mTextureViewListener;
  private final TRTCVideoPreprocessListenerAdapter mVideoPreprocessListenerAdapter;
  private int mVideoRenderMirror;
  private TRTCVideoServerConfig mVideoServerConfig;
  private TRTCCloudImpl.VideoSourceType mVideoSourceType;
  private TRTCCloudImpl.VolumeLevelNotifyTask mVolumeLevelNotifyTask;
  final TXAudioEffectManager.TXVoiceReverbType[] reverbTypes;
  final TXAudioEffectManager.TXVoiceChangerType[] voiceChangerTypes;
  
  static
  {
    com.tencent.liteav.basic.util.h.f();
  }
  
  protected TRTCCloudImpl(Context paramContext)
  {
    Object localObject1 = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
    boolean bool2 = false;
    this.reverbTypes = new TXAudioEffectManager.TXVoiceReverbType[] { localObject1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
    this.voiceChangerTypes = new TXAudioEffectManager.TXVoiceChangerType[] { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
    this.mNativeLock = new Object();
    this.mAudioFrameListener = null;
    this.mCustomCaptureLock = new Object();
    this.mCustomSubStreamVideoUtil = null;
    this.mPublishAudioTunnelId = -1;
    this.mPlayoutAudioTunnelId = -1;
    this.mPriorStreamType = 2;
    this.mEnableSmallStream = false;
    this.mVideoRenderMirror = 0;
    this.mCustomRemoteRender = false;
    this.mAudioVolumeEvalInterval = 0;
    this.mSmallEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    this.mQosMode = 1;
    this.mEnableEosMode = false;
    this.mCodecType = 2;
    this.mEnableSoftAEC = true;
    this.mEnableSoftANS = false;
    this.mEnableSoftAGC = false;
    this.mSoftAECLevel = 100;
    this.mSoftANSLevel = 100;
    this.mSoftAGCLevel = 100;
    this.mAudioCaptureVolume = 100;
    this.mAudioPlayoutVolume = 100;
    this.mCustomVideoUtil = null;
    this.mCustomCaptureGLSyncMode = 0;
    this.mEnableCustomAudioCapture = false;
    this.mEnableCustomVideoCapture = false;
    this.mCurrentRole = 20;
    this.mTargetRole = 20;
    this.mVideoPreprocessListenerAdapter = new TRTCVideoPreprocessListenerAdapter();
    this.mPerformanceMode = 0;
    this.mRoomType = 0;
    this.mCurrentOrientation = -1;
    this.mFloatingWindow = null;
    this.mOverrideFPSFromUser = false;
    this.mLatestParamsOfBigEncoder = new Bundle();
    this.mLatestParamsOfSmallEncoder = new Bundle();
    this.mFramework = 1;
    this.mTextureViewListener = new TRTCCloudImpl.1(this);
    this.mKeepAVCaptureWhenEnterRoomFailed = false;
    this.mCallback = new TRTCCloudImpl.2(this);
    this.mDeviceManagerListener = new TRTCCloudImpl.3(this);
    this.mSubClouds = new ArrayList();
    this.mCurrentPublishClouds = new HashMap();
    this.mVolumeLevelNotifyTask = null;
    this.mDebugType = 0;
    this.mStatusNotifyTask = null;
    this.mNetType = -1;
    this.mBackground = -1;
    init(paramContext, null);
    TXCCommonUtil.setAppContext(this.mContext);
    TXCLog.init();
    localObject1 = TRTCAudioServerConfig.loadFromSharedPreferences(paramContext);
    TXCLog.i("TRTCCloudImpl", "audio config from shared preference: %s", new Object[] { localObject1 });
    Object localObject2 = TXCAudioEngine.buildTRAEConfig(paramContext, Boolean.valueOf(((TRTCAudioServerConfig)localObject1).enableOpenSL), ((TRTCAudioServerConfig)localObject1).isLowLatencySampleRateSupported, ((TRTCAudioServerConfig)localObject1).lowLatencySampleRateBlockTime);
    TXCAudioEngine.CreateInstanceWithoutInitDevice(this.mContext, (String)localObject2);
    TXCAudioEngine.getInstance().clean();
    TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.mCallback));
    TXCAudioEngine.getInstance().enableAutoRestartDevice(((TRTCAudioServerConfig)localObject1).enableAutoRestartDevice);
    TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(((TRTCAudioServerConfig)localObject1).maxSelectedPlayStreams);
    localObject2 = TXCAudioEngine.getInstance();
    if (((TRTCAudioServerConfig)localObject1).enableInbandFEC != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((TXCAudioEngine)localObject2).enableInbandFEC(bool1);
    localObject2 = TXCAudioEngine.getInstance();
    boolean bool1 = bool2;
    if (((TRTCAudioServerConfig)localObject1).enableDeviceAbnormalDetection != 0) {
      bool1 = true;
    }
    ((TXCAudioEngine)localObject2).enableDeviceAbnormalDetection(bool1);
    TXCAudioEngineJNI.nativeSetAudioPlayoutTunnelEnabled(true);
    this.mCaptureAndEnc = new com.tencent.liteav.d(paramContext);
    this.mCaptureAndEnc.j(2);
    this.mCaptureAndEnc.a(this.mConfig);
    this.mCaptureAndEnc.j(true);
    this.mCaptureAndEnc.h(true);
    this.mCaptureAndEnc.a(this);
    this.mCaptureAndEnc.a(this);
    this.mCaptureAndEnc.setID("18446744073709551615");
    this.mCaptureAndEnc.i(true);
    this.mDeviceManager.setCaptureAndEnc(this.mCaptureAndEnc);
    this.mDeviceManager.setDeviceManagerListener(this.mDeviceManagerListener);
    TXCKeyPointReportProxy.a(this.mContext);
    apiLog("reset audio volume");
    setAudioCaptureVolume(100);
    setAudioPlayoutVolume(100);
    TXCSoundEffectPlayer.getInstance().setSoundEffectListener(this);
    this.mH265Decision = new TRTCEncodeTypeDecision(this);
  }
  
  protected TRTCCloudImpl(Context paramContext, com.tencent.liteav.basic.util.f paramf)
  {
    this.reverbTypes = new TXAudioEffectManager.TXVoiceReverbType[] { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
    this.voiceChangerTypes = new TXAudioEffectManager.TXVoiceChangerType[] { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
    this.mNativeLock = new Object();
    this.mAudioFrameListener = null;
    this.mCustomCaptureLock = new Object();
    this.mCustomSubStreamVideoUtil = null;
    this.mPublishAudioTunnelId = -1;
    this.mPlayoutAudioTunnelId = -1;
    this.mPriorStreamType = 2;
    this.mEnableSmallStream = false;
    this.mVideoRenderMirror = 0;
    this.mCustomRemoteRender = false;
    this.mAudioVolumeEvalInterval = 0;
    this.mSmallEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    this.mQosMode = 1;
    this.mEnableEosMode = false;
    this.mCodecType = 2;
    this.mEnableSoftAEC = true;
    this.mEnableSoftANS = false;
    this.mEnableSoftAGC = false;
    this.mSoftAECLevel = 100;
    this.mSoftANSLevel = 100;
    this.mSoftAGCLevel = 100;
    this.mAudioCaptureVolume = 100;
    this.mAudioPlayoutVolume = 100;
    this.mCustomVideoUtil = null;
    this.mCustomCaptureGLSyncMode = 0;
    this.mEnableCustomAudioCapture = false;
    this.mEnableCustomVideoCapture = false;
    this.mCurrentRole = 20;
    this.mTargetRole = 20;
    this.mVideoPreprocessListenerAdapter = new TRTCVideoPreprocessListenerAdapter();
    this.mPerformanceMode = 0;
    this.mRoomType = 0;
    this.mCurrentOrientation = -1;
    this.mFloatingWindow = null;
    this.mOverrideFPSFromUser = false;
    this.mLatestParamsOfBigEncoder = new Bundle();
    this.mLatestParamsOfSmallEncoder = new Bundle();
    this.mFramework = 1;
    this.mTextureViewListener = new TRTCCloudImpl.1(this);
    this.mKeepAVCaptureWhenEnterRoomFailed = false;
    this.mCallback = new TRTCCloudImpl.2(this);
    this.mDeviceManagerListener = new TRTCCloudImpl.3(this);
    this.mSubClouds = new ArrayList();
    this.mCurrentPublishClouds = new HashMap();
    this.mVolumeLevelNotifyTask = null;
    this.mDebugType = 0;
    this.mStatusNotifyTask = null;
    this.mNetType = -1;
    this.mBackground = -1;
    init(paramContext, paramf);
    this.mCurrentRole = 21;
    this.mTargetRole = 21;
    this.mH265Decision = new TRTCEncodeTypeDecision(this);
  }
  
  private int GetPublishingCloudState(int paramInt)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt));
    if (localTRTCCloudImpl != null) {
      return localTRTCCloudImpl.mRoomState;
    }
    return 0;
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
    runOnMainThread(new TRTCCloudImpl.187(this, paramString1, paramString2));
  }
  
  private void applyRenderConfig(TXCRenderAndDec paramTXCRenderAndDec)
  {
    com.tencent.liteav.h localh = new com.tencent.liteav.h();
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
  
  private void applyRenderPlayStrategy(TXCRenderAndDec paramTXCRenderAndDec, com.tencent.liteav.h paramh)
  {
    paramh.g = true;
    int i = this.mCurrentRole;
    if (i == 20)
    {
      paramh.a = com.tencent.liteav.basic.b.a.a;
      paramh.c = com.tencent.liteav.basic.b.a.b;
      paramh.b = com.tencent.liteav.basic.b.a.c;
    }
    else if (i == 21)
    {
      paramh.a = com.tencent.liteav.basic.b.a.d;
      paramh.c = com.tencent.liteav.basic.b.a.e;
      paramh.b = com.tencent.liteav.basic.b.a.f;
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
    Object localObject = com.tencent.liteav.basic.util.h.a();
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
    this.mRoomInfo.forEachUser(new TRTCCloudImpl.195(this, localTRTCStatistics, localArrayList));
    localObject = new TRTCCloudDef.TRTCQuality();
    ((TRTCCloudDef.TRTCQuality)localObject).userId = this.mRoomInfo.getUserId();
    ((TRTCCloudDef.TRTCQuality)localObject).quality = TXCStatus.c("18446744073709551615", 12005);
    runOnListenerThread(new TRTCCloudImpl.196(this, localTRTCStatistics, (TRTCCloudDef.TRTCQuality)localObject, localArrayList));
  }
  
  private void checkRenderRotation(int paramInt)
  {
    int m = getDisplayRotation();
    int k = (360 - m - (this.mConfig.m - 1) * 90) % 360;
    int i = paramInt % 2;
    int j = m % 2;
    if (((i == j) && (this.mConfig.m == 1)) || ((i != j) && (this.mConfig.m == 0))) {
      j = 1;
    } else {
      j = 0;
    }
    int n = this.mVideoRenderMirror;
    if (n == 1)
    {
      i = k;
      if (!this.mConfig.n)
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
        if (!this.mConfig.n) {
          break;
        }
        i = k;
      } while (j != 0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("vrotation rotation-change %d-%d-%d ======= renderRotation %d-%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mConfig.m), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.mRoomInfo.localRenderRotation) }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    TXCLog.d("TRTCCloudImpl", localStringBuilder.toString());
    paramInt = this.mRoomInfo.localRenderRotation;
    this.mCaptureAndEnc.g((paramInt + i) % 360);
  }
  
  private void checkVideoEncRotation(int paramInt)
  {
    int i;
    if (this.mConfig.m != 1)
    {
      if (((this.mConfig.T) && (this.mConfig.n)) || ((!this.mConfig.T) && (!this.mConfig.n))) {
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
          if (!this.mConfig.n) {
            j = (i + 180) % 360;
          }
          i = j;
          if (this.mConfig.T) {
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
      if (!this.mConfig.n) {
        j = (i + 180) % 360;
      }
      i = j;
      if (this.mConfig.T) {
        i = (j + 180) % 360;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("vrotation rotation-change %d-%d ======= encRotation %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mConfig.m), Integer.valueOf(i) }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    TXCLog.d("TRTCCloudImpl", localStringBuilder.toString());
    this.mCurrentOrientation = paramInt;
    this.mCaptureAndEnc.a(i);
  }
  
  private void collectCustomCaptureFps()
  {
    TRTCCustomTextureUtil localTRTCCustomTextureUtil = this.mCustomVideoUtil;
    if (localTRTCCustomTextureUtil != null) {
      TXCStatus.a("18446744073709551615", 1001, 2, Double.valueOf(localTRTCCustomTextureUtil.getCurrentFPS()));
    }
    localTRTCCustomTextureUtil = this.mCustomSubStreamVideoUtil;
    if (localTRTCCustomTextureUtil != null) {
      TXCStatus.a("18446744073709551615", 1001, 7, Double.valueOf(localTRTCCustomTextureUtil.getCurrentFPS()));
    }
  }
  
  private static TRTCAudioServerConfig createAudioServerConfigFromNative()
  {
    return new TRTCAudioServerConfig();
  }
  
  private com.tencent.liteav.d createCaptureAndEnc(int paramInt)
  {
    com.tencent.liteav.d locald = new com.tencent.liteav.d(this.mContext);
    locald.j(paramInt);
    locald.a(this.mConfig);
    locald.j(true);
    locald.h(true);
    locald.a(this);
    locald.a(this);
    locald.setID("18446744073709551615");
    locald.i(true);
    return locald;
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
    if ((paramJSONObject != null) && (paramJSONObject.has("enable")))
    {
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
      return;
    }
    apiLog("enableAudioAEC[lack parameter or illegal type]: enable");
  }
  
  private void enableAudioAGC(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("enable")))
    {
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
      return;
    }
    apiLog("enableAudioAGC[lack parameter or illegal type]: enable");
  }
  
  private void enableAudioANS(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("enable")))
    {
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
      return;
    }
    apiLog("enableAudioANS[lack parameter or illegal type]: enable");
  }
  
  private void enableBlackStream(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("enable")))
    {
      boolean bool = paramJSONObject.getBoolean("enable");
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("enableBlackStream ");
      paramJSONObject.append(bool);
      apiLog(paramJSONObject.toString());
      enableNetworkBlackStream(bool);
      paramJSONObject = this.mCaptureAndEnc;
      if (paramJSONObject != null) {
        paramJSONObject.c(bool);
      }
      if (bool) {
        addUpstream(2);
      }
      return;
    }
    apiLog("callExperimentalAPI[lack parameter or illegal type]: enable");
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
    int j = com.tencent.liteav.basic.util.h.g(this.mContext);
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
    int[] arrayOfInt = com.tencent.liteav.basic.util.h.a();
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
    localStringBuilder.append(String.format(Locale.CHINA, "Jitter: %d,%d|%d,%d|%d  p2pDelay: %d  ADROP: %d\n", new Object[] { Integer.valueOf(TXCStatus.c(str, 2007)), Integer.valueOf(TXCStatus.c(str, 6104, i)), Integer.valueOf(TXCStatus.c(str, 6105, i)), Integer.valueOf(TXCStatus.c(str, 6106, i)), Integer.valueOf(TXCStatus.c(str, 2021)), Integer.valueOf(TXCStatus.c(str, 18042)), Integer.valueOf(TXCStatus.c(str, 18015)) }));
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
    localTRTCLocalStatistics.audioCaptureState = translateAudioAbnormalDetectState(TXCStatus.c("18446744073709551615", 14032));
    return localTRTCLocalStatistics;
  }
  
  private com.tencent.liteav.basic.b.b getPixelFormat(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return com.tencent.liteav.basic.b.b.a;
            }
            return com.tencent.liteav.basic.b.b.f;
          }
          return com.tencent.liteav.basic.b.b.e;
        }
        return com.tencent.liteav.basic.b.b.d;
      }
      return com.tencent.liteav.basic.b.b.c;
    }
    return com.tencent.liteav.basic.b.b.b;
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
    paramTXCRenderAndDec.point2PointDelay = TXCStatus.c(str, 18042);
    paramTXCRenderAndDec.streamType = translateStreamType(m);
    paramTXCRenderAndDec.audioTotalBlockTime = TXCStatus.c(str, 18031);
    i = TXCStatus.c(str, 18030);
    j = 0;
    double d1;
    double d2;
    if (i > 0)
    {
      d1 = paramTXCRenderAndDec.audioTotalBlockTime;
      Double.isNaN(d1);
      d2 = i;
      Double.isNaN(d2);
      i = (int)(d1 * 100.0D / d2 + 0.9D);
    }
    else
    {
      i = 0;
    }
    paramTXCRenderAndDec.audioBlockRate = i;
    paramTXCRenderAndDec.videoTotalBlockTime = TXCStatus.c(str, 6006, m);
    k = TXCStatus.c(str, 6012, m);
    i = j;
    if (k > 0)
    {
      d1 = paramTXCRenderAndDec.videoTotalBlockTime;
      Double.isNaN(d1);
      d2 = k;
      Double.isNaN(d2);
      i = (int)(d1 * 100.0D / d2 + 0.9D);
    }
    paramTXCRenderAndDec.videoBlockRate = i;
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
    try
    {
      Object localObject = Thread.currentThread().getStackTrace();
      int i = 0;
      while (i < localObject.length)
      {
        String str = localObject[i].getClassName();
        boolean bool = str.contains("TUIKitImpl");
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("identifyTRTCFrameworkType callName:");
          ((StringBuilder)localObject).append(str);
          TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
          this.mFramework = 6;
          return;
        }
        if (str.contains("WXTRTCCloud"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("identifyTRTCFrameworkType callName:");
          ((StringBuilder)localObject).append(str);
          TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
          this.mFramework = 3;
          return;
        }
        if (str.contains("TRTCCloudPlugin"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("identifyTRTCFrameworkType callName:");
          ((StringBuilder)localObject).append(str);
          TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
          this.mFramework = 7;
          return;
        }
        if ((str.contains("TRTCMeetingImpl")) || (str.contains("TRTCLiveRoomImpl")) || (str.contains("TRTCAudioCallImpl")) || (str.contains("TRTCVideoCallImpl")) || (str.contains("TRTCVoiceRoomImpl")) || (str.contains("TRTCAVCallImpl")))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("identifyTRTCFrameworkType callName:");
          localStringBuilder.append(str);
          TXCLog.i("TRTCCloudImpl", localStringBuilder.toString());
          this.mFramework = 5;
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("identifyTRTCFrameworkType catch exception:");
      ((StringBuilder)localObject).append(localException.getCause());
      TXCLog.e("TRTCCloudImpl", ((StringBuilder)localObject).toString());
    }
  }
  
  private void init(Context paramContext, com.tencent.liteav.basic.util.f arg2)
  {
    this.mCurrentPublishClouds.put(Integer.valueOf(2), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(3), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(7), this);
    this.mCurrentPublishClouds.put(Integer.valueOf(1), this);
    this.mContext = paramContext.getApplicationContext();
    this.mConfig = new com.tencent.liteav.g();
    this.mConfig.l = com.tencent.liteav.basic.b.c.e;
    Object localObject = this.mConfig;
    ((com.tencent.liteav.g)localObject).Y = 90;
    ((com.tencent.liteav.g)localObject).k = 0;
    ((com.tencent.liteav.g)localObject).Q = true;
    ((com.tencent.liteav.g)localObject).i = 15;
    ((com.tencent.liteav.g)localObject).L = false;
    ((com.tencent.liteav.g)localObject).U = false;
    ((com.tencent.liteav.g)localObject).V = false;
    ((com.tencent.liteav.g)localObject).a = 368;
    ((com.tencent.liteav.g)localObject).b = 640;
    ((com.tencent.liteav.g)localObject).c = 750;
    ((com.tencent.liteav.g)localObject).e = 0;
    ((com.tencent.liteav.g)localObject).X = false;
    this.mRoomInfo = new TRTCRoomInfo();
    this.mRoomInfo.bigEncSize.a = 368;
    this.mRoomInfo.bigEncSize.b = 640;
    this.mMainHandler = new com.tencent.liteav.basic.util.f(paramContext.getMainLooper());
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
      this.mSDKHandler = new com.tencent.liteav.basic.util.f(???.getLooper());
    }
    this.mDeviceManager = new TXDeviceManagerImpl(this.mSDKHandler);
    this.mStatusNotifyTask = new TRTCCloudImpl.StatusTask(this);
    this.mLastSendMsgTimeMs = 0L;
    this.mSendMsgCount = 0;
    this.mSendMsgSize = 0;
    this.mSensorMode = 2;
    this.mAppScene = 0;
    this.mQosPreference = 2;
    this.mQosMode = 1;
    this.mOrientationEventListener = new TRTCCloudImpl.DisplayOrientationDetector(this.mContext, this);
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
            break label564;
          }
          j = localObject[1];
          if (localObject.length < 3) {
            break label570;
          }
          k = localObject[2];
          this.mNativeRtcContext = nativeCreateContext(i, j, k);
          apiLog("trtc cloud create");
          this.mRoomState = 0;
          this.mVideoSourceType = TRTCCloudImpl.VideoSourceType.NONE;
          this.mIsAudioCapturing = false;
          this.mIsVideoCapturing = false;
          this.mCurrentRole = 20;
          this.mTargetRole = 20;
          this.mRecvMode = 1;
          this.mLatestParamsOfBigEncoder.putInt("config_gop", this.mConfig.j);
          this.mLatestParamsOfSmallEncoder.putInt("config_gop", this.mConfig.j);
          identifyTRTCFrameworkType();
          this.mVideoServerConfig = TRTCVideoServerConfig.loadFromSharedPreferences(paramContext);
          return;
        }
      }
      int i = 0;
      continue;
      label564:
      int j = 0;
      continue;
      label570:
      int k = 0;
    }
  }
  
  private boolean isNumericRoom(int paramInt)
  {
    return (paramInt != 0) && (paramInt != -1);
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
  
  private native void nativeSendCustomCmdMsg(long paramLong, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeSendJsonCmd(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSendSEIMsg(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeSetAVSyncPlaySources(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSetAllowSwitchToHighPerformanceMode(long paramLong, boolean paramBoolean);
  
  private native void nativeSetAudioEncodeConfiguration(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void nativeSetDataReportDeviceInfo(String paramString1, String paramString2, int paramInt);
  
  private native void nativeSetEncodedDataProcessingListener(long paramLong1, long paramLong2);
  
  private native void nativeSetHeartBeatTimeoutSec(long paramLong, int paramInt);
  
  private native void nativeSetNetEnv(long paramLong, int paramInt);
  
  private native boolean nativeSetSEIPayloadType(long paramLong, int paramInt);
  
  private native void nativeSetVideoEncoderConfiguration(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, int paramInt7, boolean paramBoolean2);
  
  private native void nativeSetVideoQuality(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeStartLocalRecording(long paramLong, TRTCCloudDef.TRTCLocalRecordingParams paramTRTCLocalRecordingParams);
  
  private native void nativeStartPublishCDNStream(long paramLong, TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam);
  
  private native void nativeStartPublishing(long paramLong, String paramString, int paramInt);
  
  private native void nativeStartSpeedTest(long paramLong, int paramInt, String paramString1, String paramString2);
  
  private native void nativeStopLocalRecording(long paramLong);
  
  private native void nativeStopPublishCDNStream(long paramLong);
  
  private native void nativeStopPublishing(long paramLong);
  
  private native void nativeStopSpeedTest(long paramLong);
  
  private native void nativeUpdatePrivateMapKey(long paramLong, String paramString);
  
  private void notifyCaptureStarted(String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.198(this, paramString));
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
      this.mRoomInfo.forEachUser(new TRTCCloudImpl.186(this, paramString, paramInt, paramBundle));
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
    runOnSDKThread(new TRTCCloudImpl.152(this, new WeakReference(this), paramLong, paramString, paramInt3, paramInt2));
  }
  
  private void onAddUpStream(int paramInt1, String paramString, int paramInt2)
  {
    apiOnlineLog("onAddUpStream  streamType:%d, err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString });
    if ((paramInt2 == 7) && (paramInt1 != 0))
    {
      runOnSDKThread(new TRTCCloudImpl.146(this));
      runOnListenerThread(new TRTCCloudImpl.147(this, paramInt1, paramString));
    }
  }
  
  private void onCallExperimentalAPI(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCallExperimentalAPI ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    apiLog(localStringBuilder.toString());
    runOnListenerThread(new TRTCCloudImpl.145(this));
  }
  
  private void onChangeRole(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.176(this, paramInt, paramString));
  }
  
  private void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    apiOnlineLog("onConnectOtherRoom userId:%s err:%d, msg:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    runOnListenerThread(new TRTCCloudImpl.142(this, paramString1, paramInt, paramString2));
  }
  
  private void onConnectionLost()
  {
    TRTCRoomInfo localTRTCRoomInfo = this.mRoomInfo;
    localTRTCRoomInfo.networkStatus = 1;
    notifyEvent(localTRTCRoomInfo.getUserId(), 0, "Network anomaly.");
    apiOnlineLog("onConnectionLost");
    resetFeelingBlockReport();
    runOnListenerThread(new TRTCCloudImpl.161(this));
  }
  
  private void onConnectionRecovery()
  {
    TRTCRoomInfo localTRTCRoomInfo = this.mRoomInfo;
    localTRTCRoomInfo.networkStatus = 3;
    notifyEvent(localTRTCRoomInfo.getUserId(), 0, "Network recovered. Successfully re-enter room");
    apiOnlineLog("onConnectionRecovery");
    resetFeelingBlockReport();
    runOnListenerThread(new TRTCCloudImpl.163(this));
  }
  
  private void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    apiOnlineLog("onDisConnectOtherRoom err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    runOnListenerThread(new TRTCCloudImpl.143(this, paramInt, paramString));
  }
  
  private void onExitRoom(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom err:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString);
    apiOnlineLog(localStringBuilder.toString());
    runOnSDKThread(new TRTCCloudImpl.140(this, paramInt));
  }
  
  private void onKickOut(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onKickOut ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    apiLog(localStringBuilder.toString());
    runOnSDKThread(new TRTCCloudImpl.141(this, paramString, paramInt));
  }
  
  private void onLocalRecordBegin(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.180(this, paramInt, paramString));
  }
  
  private void onLocalRecordComplete(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.181(this, paramInt, paramString));
  }
  
  private void onLocalRecording(long paramLong, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.182(this, paramLong, paramString));
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
    boolean bool2 = true;
    TXCLog.i("TRTCCloudImpl", "on receive audio config: [%s]", new Object[] { paramTRTCAudioServerConfig });
    TRTCAudioServerConfig.saveToSharedPreferences(this.mContext, paramTRTCAudioServerConfig);
    TXCAudioEngine.getInstance().enableAutoRestartDevice(paramTRTCAudioServerConfig.enableAutoRestartDevice);
    TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(paramTRTCAudioServerConfig.maxSelectedPlayStreams);
    TXCAudioEngine localTXCAudioEngine = TXCAudioEngine.getInstance();
    boolean bool1;
    if (paramTRTCAudioServerConfig.enableInbandFEC != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localTXCAudioEngine.enableInbandFEC(bool1);
    localTXCAudioEngine = TXCAudioEngine.getInstance();
    if (paramTRTCAudioServerConfig.enableDeviceAbnormalDetection != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localTXCAudioEngine.enableDeviceAbnormalDetection(bool1);
  }
  
  private void onRecvCustomCmdMsg(String paramString, long paramLong1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt3, long paramLong2)
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
      localStringBuilder.append(paramArrayOfByte);
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
    runOnListenerThread(new TRTCCloudImpl.164(this, paramString, paramInt1, paramInt2, paramArrayOfByte, paramBoolean, paramInt3));
  }
  
  private void onRecvEnterRoomVideoConfig(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.183(this, paramBoolean));
  }
  
  private void onRecvFirstAudio(long paramLong)
  {
    runOnSDKThread(new TRTCCloudImpl.168(this));
  }
  
  private void onRecvFirstVideo(long paramLong, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.169(this, paramLong));
  }
  
  private void onRecvSEIMsg(long paramLong, byte[] paramArrayOfByte)
  {
    runOnListenerThread(new TRTCCloudImpl.165(this, paramLong, paramArrayOfByte));
  }
  
  private void onRecvVideoServerConfig(TRTCVideoServerConfig paramTRTCVideoServerConfig)
  {
    runOnSDKThread(new TRTCCloudImpl.179(this, paramTRTCVideoServerConfig));
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
      runOnListenerThread(new TRTCCloudImpl.148(this, paramInt1, paramString));
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.149(this, paramInt2, paramLong));
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
    runOnSDKThread(new TRTCCloudImpl.137(this, paramLong, paramArrayOfByte));
  }
  
  private void onSendCustomCmdMsgResult(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  private void onSpeedTest(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3)
  {
    runOnListenerThread(new TRTCCloudImpl.166(this, paramString, paramInt1, paramFloat1, paramFloat2, paramInt2, paramInt3));
  }
  
  private void onStartPublishing(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.170(this, paramInt, paramString));
  }
  
  private void onStopPublishing(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.171(this, paramInt, paramString));
  }
  
  private void onStreamPublished(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.172(this, paramInt, paramString));
  }
  
  private void onStreamUnpublished(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.173(this, paramInt, paramString));
  }
  
  private void onSwitchRoom(int paramInt, String paramString)
  {
    apiOnlineLog(String.format("onSwitchRoom err:%d, msg:%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    runOnListenerThread(new TRTCCloudImpl.144(this, paramInt, paramString));
  }
  
  private void onTranscodingUpdated(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.174(this, paramInt, paramString));
  }
  
  private void onTryToReconnect()
  {
    TRTCRoomInfo localTRTCRoomInfo = this.mRoomInfo;
    localTRTCRoomInfo.networkStatus = 2;
    notifyEvent(localTRTCRoomInfo.getUserId(), 0, "Retry enter room.");
    apiOnlineLog("onTryToReconnect");
    resetFeelingBlockReport();
    runOnListenerThread(new TRTCCloudImpl.162(this));
  }
  
  private void onVideoBlockThresholdChanged(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.159(this, paramInt));
  }
  
  private void onWholeMemberEnter(long paramLong, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.153(this, new WeakReference(this), paramString));
  }
  
  private void onWholeMemberExit(long paramLong, String paramString, int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.154(this, new WeakReference(this), paramString, paramInt));
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
  
  private void resetFeelingBlockReport()
  {
    runOnSDKThread(new TRTCCloudImpl.160(this));
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
    com.tencent.liteav.basic.util.f localf = this.mSDKHandler;
    if (localf != null) {
      localf.postDelayed(paramRunnable, paramInt);
    }
  }
  
  private void runOnSDKThreadAndWaitDone(Runnable paramRunnable, long paramLong)
  {
    if (this.mSDKHandler != null)
    {
      if (Looper.myLooper() != this.mSDKHandler.getLooper())
      {
        this.mSDKHandler.a(paramRunnable, paramLong);
        return;
      }
      paramRunnable.run();
    }
  }
  
  private void setAVSyncPlaySources(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setAVSyncPlaySources param is null");
      return;
    }
    if (!paramJSONObject.has("audioSourceUserID"))
    {
      apiLog("setAVSyncPlaySources[lack parameter]: audioSourceUserID");
      return;
    }
    if (!paramJSONObject.has("videoSourceUserID"))
    {
      apiLog("setAVSyncPlaySources[lack parameter]: videoSourceUserID");
      return;
    }
    String str = paramJSONObject.getString("audioSourceUserID");
    if (str == null)
    {
      apiLog("setAVSyncPlaySources[illegal type]: audioSourceUserID");
      return;
    }
    paramJSONObject = paramJSONObject.getString("videoSourceUserID");
    if (paramJSONObject == null)
    {
      apiLog("setAVSyncPlaySources[illegal type]: videoSourceUserID");
      return;
    }
    nativeSetAVSyncPlaySources(this.mNativeRtcContext, str, paramJSONObject);
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
  
  private void setCustomCaptureGLSyncMode(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("callExperimentalAPI[setCustomCaptureGLMode failed, params is null");
      return;
    }
    this.mCustomCaptureGLSyncMode = paramJSONObject.getInt("mode");
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("setCustomCaptureGLMode: mode:");
    paramJSONObject.append(this.mCustomCaptureGLSyncMode);
    apiLog(paramJSONObject.toString());
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
  
  private void setEnableH265Encoder(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setEnableH265Encoder param is null");
      return;
    }
    if (paramJSONObject.has("enable"))
    {
      boolean bool = false;
      int i = paramJSONObject.optInt("enable", 0);
      paramJSONObject = this.mH265Decision;
      if (i != 0) {
        bool = true;
      }
      paramJSONObject.setEnableH265EncodeByPrivateAPI(bool);
      if ((this.mCaptureAndEnc != null) && (this.mAppScene == 1))
      {
        bool = this.mH265Decision.isVideoEncoderCodecUsingH265();
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("enableH265 = ");
        paramJSONObject.append(bool);
        paramJSONObject.append(" ,mRoomState= ");
        paramJSONObject.append(this.mRoomState);
        TXCLog.i("TRTCCloudImpl", paramJSONObject.toString());
        this.mCaptureAndEnc.k(bool);
      }
    }
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
  
  private void setHeartBeatTimeoutSec(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setHeartBeatTimeoutSec param is null");
      return;
    }
    if (!paramJSONObject.has("timeoutSec"))
    {
      apiLog("setHeartBeatTimeoutSec[lack parameter]: timeoutSec");
      return;
    }
    int i = paramJSONObject.optInt("timeoutSec", 0);
    nativeSetHeartBeatTimeoutSec(this.mNativeRtcContext, i);
  }
  
  private void setKeepAVCaptureOption(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setKeepAVCaptureOption param is null");
      return;
    }
    boolean bool = false;
    if (paramJSONObject.optInt("keepWhenEnterRoomFailed", 0) != 0) {
      bool = true;
    }
    this.mKeepAVCaptureWhenEnterRoomFailed = bool;
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("setKeepAVCaptureOption ");
    paramJSONObject.append(this.mKeepAVCaptureWhenEnterRoomFailed);
    apiLog(paramJSONObject.toString());
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
    com.tencent.liteav.g localg = this.mConfig;
    localg.Z = ((JSONArray)localObject1);
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
  
  private void setNetEnv(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setNetEnv param is null");
      return;
    }
    if (!paramJSONObject.has("env"))
    {
      apiLog("setNetEnv[lack parameter]: env");
      return;
    }
    int i = paramJSONObject.optInt("env", 0);
    nativeSetNetEnv(this.mNativeRtcContext, i);
  }
  
  private void setOrientation(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.197(this, paramInt));
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
  
  private void setRemoteViewMirror(String paramString, int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TRTCCloudImpl.40(this, paramString, paramInt1, paramInt2));
  }
  
  private void setStartVideoEncodeCodec()
  {
    if (this.mCaptureAndEnc != null)
    {
      boolean bool = this.mH265Decision.isVideoEncoderStartCodecUsingH265();
      this.mCaptureAndEnc.k(bool);
    }
  }
  
  private void setThreadPriority(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("callExperimentalAPI[setThreadPriority failed, params is null]");
      return;
    }
    paramJSONObject = paramJSONObject.optString("priority", "default");
    int i = -1;
    int j = paramJSONObject.hashCode();
    if (j != 3202466)
    {
      if ((j == 1544803905) && (paramJSONObject.equals("default"))) {
        i = 1;
      }
    }
    else if (paramJSONObject.equals("high")) {
      i = 0;
    }
    if (i != 0) {
      paramJSONObject = com.tencent.liteav.basic.structs.c.b;
    } else {
      paramJSONObject = com.tencent.liteav.basic.structs.c.a;
    }
    this.mCaptureAndEnc.a(paramJSONObject);
  }
  
  private void setVideoEncConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, int paramInt6, boolean paramBoolean2)
  {
    if (GetPublishingCloudState(paramInt1) == 0)
    {
      apiLog("setVideoEncConfig ignore when no in room");
      return;
    }
    if (this.mCodecType != 2)
    {
      setVideoEncoderConfiguration(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1, paramBoolean1, paramInt6, paramBoolean2);
      return;
    }
    setVideoEncoderConfiguration(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, this.mAppScene, paramBoolean1, paramInt6, paramBoolean2);
  }
  
  private void setVideoEncoderConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, int paramInt7, boolean paramBoolean2)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt1));
    if (localTRTCCloudImpl != null) {
      nativeSetVideoEncoderConfiguration(localTRTCCloudImpl.getNetworkContext(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean1, paramInt7, paramBoolean2);
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
          com.tencent.liteav.g localg = this.mConfig;
          if (localJSONObject.optInt("enableRealTime") != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localg.Q = bool;
          this.mConfig.o = localJSONObject.optInt("profile");
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
        this.mConfig.h = true;
        this.mLatestParamsOfBigEncoder.putInt("config_fps", n);
        if (i <= j) {
          bool = true;
        } else {
          bool = false;
        }
        updateBigStreamEncoder(bool, i, j, n, i1, this.mConfig.q, i2, this.mConfig.h);
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
      g.a locala = getSizeByResolution(paramTRTCVideoEncParam.videoResolution, paramTRTCVideoEncParam.videoResolutionMode);
      this.mConfig.h = true;
      boolean bool;
      if (paramTRTCVideoEncParam.videoResolutionMode == 1) {
        bool = true;
      } else {
        bool = false;
      }
      updateBigStreamEncoder(bool, locala.a, locala.b, paramTRTCVideoEncParam.videoFps, paramTRTCVideoEncParam.videoBitrate, paramTRTCVideoEncParam.enableAdjustRes, paramTRTCVideoEncParam.minVideoBitrate, this.mConfig.h);
      apiOnlineLog(String.format("setVideoEncoderParam width:%d, height:%d, fps:%d, bitrate:%d, mode:%d, minBitrate:%d", new Object[] { Integer.valueOf(this.mRoomInfo.bigEncSize.a), Integer.valueOf(this.mRoomInfo.bigEncSize.b), Integer.valueOf(paramTRTCVideoEncParam.videoFps), Integer.valueOf(paramTRTCVideoEncParam.videoBitrate), Integer.valueOf(paramTRTCVideoEncParam.videoResolutionMode), Integer.valueOf(paramTRTCVideoEncParam.minVideoBitrate) }));
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
  
  private void stopLocalAudioInternal()
  {
    if (!this.mIsAudioCapturing)
    {
      apiLog("stopLocalAudio when no capturing audio, ignore!!!");
      return;
    }
    apiOnlineLog("stopLocalAudio");
    TXCEventRecorderProxy.a("18446744073709551615", 3001, 2L, -1L, "", 0);
    this.mIsAudioCapturing = false;
    TXCAudioEngine.getInstance().stopLocalAudio();
    if (!this.mEnableCustomAudioCapture) {
      enableAudioStream(false);
    }
    TXCKeyPointReportProxy.a(40050, 0, 1);
    TXCLog.i("TRTCCloudImpl", "(%d)stopLocalAudioInternal end", new Object[] { Integer.valueOf(hashCode()) });
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
  
  private int translateAudioAbnormalDetectState(int paramInt)
  {
    if ((paramInt & 0x1) != 0) {
      return 1;
    }
    if ((paramInt & 0x2) != 0) {
      return 2;
    }
    if ((paramInt & 0x4) != 0) {
      return 3;
    }
    return 0;
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
  
  private void updateBigStreamEncoder(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, int paramInt5, boolean paramBoolean3)
  {
    com.tencent.liteav.g localg;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mRoomInfo.bigEncSize.a = paramInt1;
      this.mRoomInfo.bigEncSize.b = paramInt2;
      if (this.mVideoSourceType == TRTCCloudImpl.VideoSourceType.SCREEN)
      {
        localg = this.mConfig;
        localg.m = 1;
        localg.a = this.mRoomInfo.bigEncSize.a;
        this.mConfig.b = this.mRoomInfo.bigEncSize.b;
      }
      else if (paramBoolean1)
      {
        localg = this.mConfig;
        localg.m = 1;
        localg.a = this.mRoomInfo.bigEncSize.a;
        this.mConfig.b = this.mRoomInfo.bigEncSize.b;
      }
      else
      {
        localg = this.mConfig;
        localg.m = 0;
        localg.a = this.mRoomInfo.bigEncSize.b;
        this.mConfig.b = this.mRoomInfo.bigEncSize.a;
      }
      this.mConfig.l = com.tencent.liteav.basic.b.c.a;
    }
    if (paramInt3 > 0) {
      if (paramInt3 > 30)
      {
        apiLog("setVideoEncoderParam fps > 30, limit fps to 30");
        this.mConfig.i = 30;
      }
      else
      {
        this.mConfig.i = paramInt3;
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
      localg.j = 3;
      localg.q = false;
      if (this.mOverrideFPSFromUser) {
        localg.i = 10;
      }
    }
    else
    {
      this.mConfig.q = paramBoolean2;
    }
    setVideoEncConfig(2, this.mRoomInfo.bigEncSize.a, this.mRoomInfo.bigEncSize.b, this.mConfig.i, this.mConfig.c, this.mConfig.q, this.mConfig.e, paramBoolean3);
    if ((this.mCodecType == 2) && (this.mConfig.a * this.mConfig.b >= 518400)) {
      this.mConfig.k = 1;
    }
    this.mCaptureAndEnc.e(this.mConfig.i);
    this.mCaptureAndEnc.a(this.mConfig);
  }
  
  private void updateEncType()
  {
    int i = this.mCodecType;
    if ((i != 0) && (i != 1))
    {
      if (this.mAppScene == 1) {
        this.mConfig.k = 1;
      }
    }
    else {
      this.mConfig.k = this.mCodecType;
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
        if (com.tencent.liteav.basic.util.h.g(this.mContext) == 1) {
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
    paramInt1 = this.mConfig.j;
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
    setVideoEncConfig(3, this.mRoomInfo.smallEncSize.a, this.mRoomInfo.smallEncSize.b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, this.mConfig.q, this.mSmallEncParam.minVideoBitrate, false);
  }
  
  public void ConnectOtherRoom(String paramString)
  {
    runOnSDKThread(new TRTCCloudImpl.11(this, paramString));
  }
  
  public void DisconnectOtherRoom()
  {
    runOnSDKThread(new TRTCCloudImpl.12(this));
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
  
  protected void apiLog(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(")trtc_api ");
    localStringBuilder.append(String.format(paramString, paramVarArgs));
    TXCLog.i("TRTCCloudImpl", localStringBuilder.toString());
  }
  
  protected void apiOnlineLog(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(")trtc_api");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0, (String)localObject);
  }
  
  protected void apiOnlineLog(String paramString, Object... paramVarArgs)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(")trtc_api");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(paramString, paramVarArgs));
    localStringBuilder.append(" self:");
    localStringBuilder.append(hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0, (String)localObject);
  }
  
  public void callExperimentalAPI(String paramString)
  {
    if (paramString != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("callExperimentalAPI  ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", roomid = ");
      if (this.mRoomInfo.roomId != -1L) {
        localObject1 = Long.valueOf(this.mRoomInfo.roomId);
      } else {
        localObject1 = this.mRoomInfo.strRoomId;
      }
      ((StringBuilder)localObject2).append(localObject1);
      apiOnlineLog(((StringBuilder)localObject2).toString());
    }
    Object localObject2 = "";
    Object localObject3 = null;
    Object localObject1 = localObject2;
    try
    {
      Object localObject4 = new JSONObject(paramString);
      localObject1 = localObject2;
      if (!((JSONObject)localObject4).has("api"))
      {
        localObject1 = localObject2;
        localObject4 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject4).append("callExperimentalAPI[lack api or illegal type]: ");
        localObject1 = localObject2;
        ((StringBuilder)localObject4).append(paramString);
        localObject1 = localObject2;
        apiLog(((StringBuilder)localObject4).toString());
        return;
      }
      localObject1 = localObject2;
      localObject2 = ((JSONObject)localObject4).getString("api");
      localObject1 = localObject2;
      if (!((JSONObject)localObject4).has("params")) {
        return;
      }
      localObject1 = localObject2;
      localObject4 = ((JSONObject)localObject4).getJSONObject("params");
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    catch (Exception localException)
    {
      label204:
      break label204;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("callExperimentalAPI[failed]: ");
    ((StringBuilder)localObject2).append(paramString);
    apiLog(((StringBuilder)localObject2).toString());
    localObject2 = localObject3;
    if (((String)localObject1).equals("setEncodedDataProcessingListener"))
    {
      setEncodedDataProcessingListener((JSONObject)localObject2);
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.88(this, (String)localObject1, (JSONObject)localObject2, paramString));
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
        runOnMainThread(new TRTCCloudImpl.193(this, localTXCloudVideoView, localCharSequence));
      }
    }
    this.mRoomInfo.forEachUser(new TRTCCloudImpl.194(this));
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
      runOnMainThread(new TRTCCloudImpl.192(this, paramTXCloudVideoView, paramTXCRenderAndDec));
    }
  }
  
  protected void checkUserState(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject1 = this.mTRTCListener;
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramString)))
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
      Object localObject2;
      if (i != 0)
      {
        runOnListenerThread(new TRTCCloudImpl.189(this, (TRTCCloudListener)localObject1, paramString, bool1));
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }));
        ((StringBuilder)localObject2).append(" self:");
        ((StringBuilder)localObject2).append(hashCode());
        Monitor.a(2, ((StringBuilder)localObject2).toString(), "", 0);
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
      if (i != 0)
      {
        localObject2 = this.mRoomInfo.getUser(paramString);
        if ((localObject2 != null) && (((TRTCRoomInfo.UserInfo)localObject2).mainRender.render != null))
        {
          ((TRTCRoomInfo.UserInfo)localObject2).mainRender.render.resetPeriodStatistics();
          ((TRTCRoomInfo.UserInfo)localObject2).mainRender.render.enableReport(bool1);
        }
      }
      if ((i != 0) && ((this.mRoomInfo.hasRecvFirstIFrame(paramLong)) || (j != 0)))
      {
        runOnListenerThread(new TRTCCloudImpl.190(this, (TRTCCloudListener)localObject1, paramString, bool1));
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }));
        ((StringBuilder)localObject2).append(" self:");
        ((StringBuilder)localObject2).append(hashCode());
        Monitor.a(2, ((StringBuilder)localObject2).toString(), "", 0);
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
        localObject2 = this.mRoomInfo.getUser(paramString);
        if ((localObject2 != null) && (((TRTCRoomInfo.UserInfo)localObject2).subRender.render != null))
        {
          ((TRTCRoomInfo.UserInfo)localObject2).subRender.render.resetPeriodStatistics();
          ((TRTCRoomInfo.UserInfo)localObject2).subRender.render.enableReport(bool1);
        }
        runOnListenerThread(new TRTCCloudImpl.191(this, (TRTCCloudListener)localObject1, paramString, bool1));
        appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]subVideo Available[%b]", new Object[] { paramString, Boolean.valueOf(bool1) }));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", new Object[] { paramString, Boolean.valueOf(bool1) }));
        ((StringBuilder)localObject1).append(" self:");
        ((StringBuilder)localObject1).append(hashCode());
        Monitor.a(2, ((StringBuilder)localObject1).toString(), "", 0);
      }
    }
  }
  
  protected void clearRemoteMuteStates()
  {
    this.mRoomInfo.muteRemoteAudio = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
    this.mRoomInfo.muteRemoteVideo = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
    this.mRoomInfo.forEachUser(new TRTCCloudImpl.9(this));
  }
  
  public TRTCCloud createSubCloud()
  {
    TRTCSubCloud localTRTCSubCloud = new TRTCSubCloud(this.mContext, new WeakReference(this), this.mSDKHandler);
    localTRTCSubCloud.setListenerHandler(this.mListenerHandler);
    runOnSDKThread(new TRTCCloudImpl.15(this, localTRTCSubCloud));
    return localTRTCSubCloud;
  }
  
  public void destroy()
  {
    runOnSDKThread(new TRTCCloudImpl.4(this));
  }
  
  public void destroySubCloud(TRTCCloud paramTRTCCloud)
  {
    runOnSDKThread(new TRTCCloudImpl.16(this, paramTRTCCloud));
  }
  
  public void enableAudioEarMonitoring(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.60(this, paramBoolean));
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
    runOnSDKThread(new TRTCCloudImpl.65(this, paramInt));
  }
  
  public void enableCustomAudioCapture(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.92(this, paramBoolean));
  }
  
  public void enableCustomVideoCapture(int paramInt, boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.82(this, paramInt, paramBoolean));
  }
  
  public void enableCustomVideoCapture(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.83(this, paramBoolean));
  }
  
  public int enableEncSmallVideoStream(boolean paramBoolean, TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    runOnSDKThread(new TRTCCloudImpl.47(this, paramBoolean, paramTRTCVideoEncParam));
    return 0;
  }
  
  public void enableMixExternalAudioFrame(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1)
    {
      if (this.mPublishAudioTunnelId < 0) {
        this.mPublishAudioTunnelId = TXCAudioEngineJNI.nativeOpenAudioTunnel(true);
      }
    }
    else
    {
      i = this.mPublishAudioTunnelId;
      if (i >= 0)
      {
        TXCAudioEngineJNI.nativeCloseAudioTunnel(i);
        this.mPublishAudioTunnelId = -1;
      }
    }
    if (paramBoolean2)
    {
      if (this.mPlayoutAudioTunnelId < 0) {
        this.mPlayoutAudioTunnelId = TXCAudioEngineJNI.nativeOpenAudioTunnel(false);
      }
    }
    else
    {
      i = this.mPlayoutAudioTunnelId;
      if (i >= 0)
      {
        TXCAudioEngineJNI.nativeCloseAudioTunnel(i);
        this.mPlayoutAudioTunnelId = -1;
      }
    }
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
    return this.mDeviceManager.enableCameraTorch(paramBoolean);
  }
  
  protected void enableVideoStream(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      addUpStreamType(2);
      if (this.mEnableSmallStream) {
        addUpStreamType(3);
      }
    }
    else
    {
      if (!this.mCaptureAndEnc.j()) {
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
    long l;
    if ((localTRTCParams.sdkAppId != 0) && (!TextUtils.isEmpty(localTRTCParams.userId)) && (!TextUtils.isEmpty(localTRTCParams.userSig)))
    {
      l = localTRTCParams.roomId & 0xFFFFFFFF;
      localObject1 = localTRTCParams.businessInfo;
      if ((l != 0L) && ((localTRTCParams.roomId != -1) || (TextUtils.isEmpty((CharSequence)localObject1))))
      {
        paramTRTCParams = "";
        localObject2 = localObject1;
      }
      else
      {
        if (l == 0L) {
          paramTRTCParams = localTRTCParams.strRoomId;
        } else {
          paramTRTCParams = "";
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
    }
    try
    {
      localObject2 = new JSONObject((String)localObject1);
      localObject1 = new StringBuilder("");
      extractBizInfo((JSONObject)localObject2, "strGroupId", (StringBuilder)localObject1);
      if (localTRTCParams.roomId != -1) {
        break label441;
      }
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    catch (Exception paramTRTCParams)
    {
      for (;;)
      {
        label282:
        int i;
        continue;
        localObject1 = paramTRTCParams;
      }
    }
    if (((JSONObject)localObject2).length() != 0)
    {
      paramTRTCParams = ((JSONObject)localObject2).toString();
    }
    else
    {
      paramTRTCParams = "";
      break label282;
      paramTRTCParams = new StringBuilder();
      paramTRTCParams.append("enter room, room id error, busInfo ");
      paramTRTCParams.append(localTRTCParams.businessInfo);
      apiLog(paramTRTCParams.toString());
      localObject1 = "";
      paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject1;
      break label282;
      localObject2 = localObject1;
      localObject1 = paramTRTCParams;
      paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject2;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      onEnterRoom(-3318, "room id invalid.");
      return;
    }
    Object localObject2 = paramTRTCParams;
    paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject1;
    TXCKeyPointReportProxy.a(30001);
    i = localTRTCParams.role;
    runOnSDKThread(new TRTCCloudImpl.7(this, localTRTCParams, paramTRTCParams, l, System.currentTimeMillis(), paramInt, (String)localObject2, i, this));
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
    runOnSDKThreadAndWaitDone(new TRTCCloudImpl.8(this), TimeUnit.SECONDS.toMillis(2L));
  }
  
  protected void exitRoomInternal(boolean paramBoolean, String paramString)
  {
    this.mH265Decision.setEnableH265EncodeByServer(false);
    this.mH265Decision.setEnableH265EncodeByPrivateAPI(false);
    paramString = String.format(Locale.ENGLISH, "exitRoom %s, self: %d, reason: %s", new Object[] { Long.valueOf(this.mRoomInfo.getRoomId()), Integer.valueOf(hashCode()), paramString });
    apiOnlineLog(paramString);
    Monitor.a(1, paramString, "", 0);
    if ((this.mRoomState == 0) && (!this.mKeepAVCaptureWhenEnterRoomFailed))
    {
      clearRemoteMuteStates();
      Monitor.a();
      apiLog("exitRoom ignore when no in room.");
      return;
    }
    this.mRoomState = 0;
    this.mCaptureAndEnc.g();
    TXCSoundEffectPlayer.getInstance().stopAllEffect();
    stopCollectStatus();
    startVolumeLevelCal(false);
    this.mRoomInfo.forEachUser(new TRTCCloudImpl.10(this));
    TXCAudioEngine.getInstance();
    TXCAudioEngine.setPlayoutDataListener(null);
    enableVideoStream(false);
    enableAudioStream(false);
    if (paramBoolean) {
      nativeExitRoom(this.mNativeRtcContext);
    }
    enableAudioEarMonitoring(false);
    stopLocalAudioInternal();
    stopBGM();
    TXCKeyPointReportProxy.a(31004);
    stopLocalPreview();
    stopScreenCapture();
    TXCKeyPointReportProxy.b(31004, 0);
    paramString = this.mConfig;
    paramString.B = null;
    paramString.D = 10;
    this.mRoomInfo.clear();
    this.mRenderListenerMap.clear();
    this.mVideoSourceType = TRTCCloudImpl.VideoSourceType.NONE;
    this.mEnableSmallStream = false;
    this.mEnableEosMode = false;
    this.mCodecType = 2;
    this.mRoomType = 0;
    this.mEnableSoftAEC = true;
    this.mEnableSoftANS = false;
    this.mEnableSoftAGC = false;
    this.mCaptureAndEnc.a(false);
    TXCAudioEngine.getInstance().muteLocalAudio(false);
    TXCAudioEngine.getInstance().clean();
    enableCustomAudioCapture(false);
    enableMixExternalAudioFrame(false, false);
    enableCustomVideoCapture(0, false);
    enableCustomVideoCapture(2, false);
    this.mCaptureAndEnc.a(null, 0);
    stopAudioRecording();
    stopLocalRecording();
    TXCSoundEffectPlayer.getInstance().clearCache();
    Monitor.a();
    TXCLog.i("TRTCCloudImpl", "(%d) exitRoomInternal end", new Object[] { Integer.valueOf(hashCode()) });
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
  
  public void flushBigVideoEncParamsIntoNetwork()
  {
    setVideoEncConfig(2, this.mRoomInfo.bigEncSize.a, this.mRoomInfo.bigEncSize.b, this.mConfig.i, this.mConfig.c, this.mConfig.q, this.mConfig.e, this.mConfig.h);
  }
  
  public void flushSmallVideoEncParamsIntoNetwork()
  {
    if (this.mEnableSmallStream)
    {
      setVideoEncConfig(3, this.mRoomInfo.smallEncSize.a, this.mRoomInfo.smallEncSize.b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, this.mConfig.q, this.mSmallEncParam.minVideoBitrate, this.mConfig.h);
      return;
    }
    setVideoEncoderConfiguration(3, 0, 0, 0, 0, 0, this.mConfig.q, 0, false);
  }
  
  public long generateCustomPTS()
  {
    return TXCTimeUtil.generatePtsMS();
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
  
  public TXDeviceManager getDeviceManager()
  {
    return this.mDeviceManager;
  }
  
  public long getNetworkContext()
  {
    return this.mNativeRtcContext;
  }
  
  protected int getNetworkQuality(int paramInt1, int paramInt2)
  {
    if (!com.tencent.liteav.basic.util.h.d(this.mContext)) {
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
    int[] arrayOfInt = com.tencent.liteav.basic.util.h.a();
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
    return this.mCaptureAndEnc.q();
  }
  
  public boolean isCameraFocusPositionInPreviewSupported()
  {
    return this.mCaptureAndEnc.p();
  }
  
  public boolean isCameraTorchSupported()
  {
    return this.mCaptureAndEnc.o();
  }
  
  public boolean isCameraZoomSupported()
  {
    return this.mCaptureAndEnc.n();
  }
  
  public boolean isPublishingInCloud(TRTCCloudImpl paramTRTCCloudImpl, int paramInt)
  {
    synchronized (this.mCurrentPublishClouds)
    {
      return (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(paramInt)) == paramTRTCCloudImpl;
    }
  }
  
  public void makeStreamsEffectiveAfterNetworkInited()
  {
    Iterator localIterator = this.mStreamTypes.iterator();
    while (localIterator.hasNext()) {
      addUpStreamType(((Integer)localIterator.next()).intValue());
    }
    if (this.mRoomInfo.muteLocalVideo) {
      muteUpstream(2, this.mRoomInfo.muteLocalVideo);
    }
    if (this.mRoomInfo.muteLocalAudio) {
      muteUpstream(1, this.mRoomInfo.muteLocalAudio);
    }
  }
  
  public void mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame)
  {
    if (paramTRTCAudioFrame == null) {
      return;
    }
    int i = this.mPublishAudioTunnelId;
    if (i >= 0) {
      TXCAudioEngineJNI.nativeWriteDataToTunnel(i, paramTRTCAudioFrame.sampleRate, paramTRTCAudioFrame.channel, 16, paramTRTCAudioFrame.data);
    }
    i = this.mPlayoutAudioTunnelId;
    if (i >= 0) {
      TXCAudioEngineJNI.nativeWriteDataToTunnel(i, paramTRTCAudioFrame.sampleRate, paramTRTCAudioFrame.channel, 16, paramTRTCAudioFrame.data);
    }
  }
  
  public void muteAllRemoteAudio(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.58(this, paramBoolean));
  }
  
  public void muteAllRemoteVideoStreams(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.36(this, paramBoolean));
  }
  
  public void muteLocalAudio(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.55(this, paramBoolean));
  }
  
  public void muteLocalAudio(boolean paramBoolean, TRTCCloudImpl paramTRTCCloudImpl)
  {
    runOnSDKThread(new TRTCCloudImpl.56(this, paramBoolean, paramTRTCCloudImpl));
  }
  
  public void muteLocalVideo(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.32(this, paramBoolean));
  }
  
  public void muteLocalVideo(boolean paramBoolean, TRTCCloudImpl paramTRTCCloudImpl)
  {
    runOnSDKThread(new TRTCCloudImpl.34(this, paramBoolean, paramTRTCCloudImpl));
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.57(this, paramString, paramBoolean));
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
    runOnSDKThread(new TRTCCloudImpl.35(this, paramString, paramBoolean));
  }
  
  protected native int nativeAddUpstream(long paramLong, int paramInt);
  
  protected native long nativeCreateContext(int paramInt1, int paramInt2, int paramInt3);
  
  protected native void nativeDestroyContext(long paramLong);
  
  protected native int nativeEnterRoom(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5, int paramInt6, String paramString6, String paramString7, int paramInt7, int paramInt8, int paramInt9);
  
  protected native int nativeExitRoom(long paramLong);
  
  protected native void nativeFlushC2SVideoCodecConfig(long paramLong, int paramInt1, int paramInt2);
  
  protected native void nativeInit(long paramLong, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  protected native void nativeSetMixTranscodingConfig(long paramLong, TRTCTranscodingConfigInner paramTRTCTranscodingConfigInner);
  
  protected native int nativeSetPriorRemoteVideoStreamType(long paramLong, int paramInt);
  
  public native void nativeSwitchRoom(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3);
  
  public void notifyCurrentEncodeType(boolean paramBoolean)
  {
    runOnListenerThread(new TRTCCloudImpl.157(this, paramBoolean));
  }
  
  protected void notifyEvent(String paramString, int paramInt, Bundle paramBundle)
  {
    runOnSDKThread(new TRTCCloudImpl.188(this, paramString, paramBundle, paramInt));
  }
  
  protected void onAVMemberEnter(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TRTCCloudImpl.150(this, new WeakReference(this), paramString, paramLong, paramInt1, paramInt2));
  }
  
  protected void onAVMemberExit(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TRTCCloudImpl.151(this, new WeakReference(this), paramString, paramLong, paramInt2));
    notifyEvent(this.mRoomInfo.getUserId(), 0, String.format("[%s]leave room", new Object[] { paramString }));
  }
  
  public void onAudioJitterBufferError(String paramString1, int paramInt, String paramString2) {}
  
  public void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    runOnSDKThread(new TRTCCloudImpl.132(this, paramInt, paramString2, paramString1));
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
      runOnListenerThread(new TRTCCloudImpl.131(this, paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString));
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
    runOnSDKThread(new TRTCCloudImpl.155(this, paramInt1, paramInt2, paramInt3));
  }
  
  public void onBackgroudPushStop() {}
  
  protected void onCancelTranscoding(int paramInt, String paramString)
  {
    runOnListenerThread(new TRTCCloudImpl.175(this, paramInt, paramString));
  }
  
  public void onEffectPlayFinish(int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.105(this, paramInt));
  }
  
  public void onEffectPlayStart(int paramInt1, int paramInt2)
  {
    runOnListenerThread(new TRTCCloudImpl.106(this, paramInt1, paramInt2));
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
    localStringBuilder.append("onEnterRoom err:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString);
    apiOnlineLog(localStringBuilder.toString());
    if (paramInt == 0) {
      TXCEventRecorderProxy.a("18446744073709551615", 5003, 1L, -1L, "", 0);
    } else {
      TXCEventRecorderProxy.a("18446744073709551615", 5003, 0L, -1L, "", 0);
    }
    runOnSDKThread(new TRTCCloudImpl.138(this, paramInt, paramString));
    runOnListenerThread(new TRTCCloudImpl.139(this, paramInt));
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
    runOnSDKThread(new TRTCCloudImpl.158(this, paramInt));
  }
  
  public void onMixedAllData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
    localTRTCAudioFrame.data = paramArrayOfByte;
    localTRTCAudioFrame.timestamp = 0L;
    localTRTCAudioFrame.sampleRate = paramInt1;
    localTRTCAudioFrame.channel = paramInt2;
    runOnListenerThread(new TRTCCloudImpl.133(this, localTRTCAudioFrame));
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    runOnSDKThread(new TRTCCloudImpl.129(this, paramBundle, paramInt));
  }
  
  public void onPlayEnd(int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.135(this, paramInt));
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    runOnListenerThread(new TRTCCloudImpl.136(this, paramLong1, paramLong2));
  }
  
  public void onPlayStart()
  {
    runOnListenerThread(new TRTCCloudImpl.134(this));
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
        if (paramTXSVideoFrame.eglContext != null)
        {
          localTRTCVideoFrame.buffer = ByteBuffer.allocateDirect(paramTXSVideoFrame.width * paramTXSVideoFrame.height * 4);
          TXCOpenGlUtils.a(e.a.a, paramTXSVideoFrame.width, paramTXSVideoFrame.height, localTRTCVideoFrame.buffer);
        }
        else
        {
          if (paramTXSVideoFrame.buffer == null) {
            paramTXSVideoFrame.loadYUVBufferFromGL();
          }
          localTRTCVideoFrame.buffer = paramTXSVideoFrame.buffer;
        }
      }
      else if (localTRTCVideoFrame.bufferType == 2)
      {
        if (paramTXSVideoFrame.eglContext != null)
        {
          localTRTCVideoFrame.data = new byte[paramTXSVideoFrame.width * paramTXSVideoFrame.height * 4];
          TXCOpenGlUtils.a(e.a.a, paramTXSVideoFrame.width, paramTXSVideoFrame.height, localTRTCVideoFrame.data);
        }
        else
        {
          localTRTCVideoFrame.data = paramTXSVideoFrame.data;
          if (localTRTCVideoFrame.data == null)
          {
            localTRTCVideoFrame.data = new byte[paramTXSVideoFrame.width * paramTXSVideoFrame.height * 3 / 2];
            paramTXSVideoFrame.loadYUVArray(localTRTCVideoFrame.data);
          }
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
    runOnSDKThread(new TRTCCloudImpl.130(this, paramString, paramInt));
  }
  
  public void onScreenCapturePaused()
  {
    runOnListenerThread(new TRTCCloudImpl.63(this));
  }
  
  public void onScreenCaptureResumed()
  {
    runOnListenerThread(new TRTCCloudImpl.62(this));
  }
  
  public void onScreenCaptureStarted()
  {
    runOnListenerThread(new TRTCCloudImpl.61(this));
  }
  
  public void onScreenCaptureStopped(int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.64(this, paramInt));
  }
  
  protected void onSendFirstLocalAudioFrame()
  {
    runOnListenerThread(new TRTCCloudImpl.178(this));
  }
  
  protected void onSendFirstLocalVideoFrame(int paramInt)
  {
    runOnListenerThread(new TRTCCloudImpl.177(this, paramInt));
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
    runOnSDKThread(new TRTCCloudImpl.167(this, paramInt, paramBoolean));
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
    runOnSDKThread(new TRTCCloudImpl.156(this, paramInt8, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7));
  }
  
  public void pauseAudioEffect(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.112(this, paramInt));
  }
  
  public void pauseBGM()
  {
    runOnSDKThread(new TRTCCloudImpl.96(this));
  }
  
  public void pauseScreenCapture()
  {
    runOnSDKThread(new TRTCCloudImpl.30(this));
  }
  
  public void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam paramTRTCAudioEffectParam)
  {
    runOnSDKThread(new TRTCCloudImpl.107(this, paramTRTCAudioEffectParam));
  }
  
  public void playBGM(String paramString, TRTCCloud.BGMNotify paramBGMNotify)
  {
    runOnSDKThread(new TRTCCloudImpl.94(this, paramBGMNotify, paramString));
  }
  
  public void resumeAudioEffect(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.113(this, paramInt));
  }
  
  public void resumeBGM()
  {
    runOnSDKThread(new TRTCCloudImpl.97(this));
  }
  
  public void resumeScreenCapture()
  {
    runOnSDKThread(new TRTCCloudImpl.31(this));
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
    runOnSDKThread(new TRTCCloudImpl.72(this, paramString));
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
    runOnSDKThread(new TRTCCloudImpl.93(this, locala));
  }
  
  public boolean sendCustomCmdMsg(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayOfByte == null) {
      return false;
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
          this.mSendMsgSize = (j + paramArrayOfByte.length);
          break label173;
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
    label173:
    if (bool) {
      runOnSDKThread(new TRTCCloudImpl.123(this, paramInt, paramArrayOfByte, paramBoolean1, paramBoolean2));
    }
    return bool;
  }
  
  public void sendCustomVideoData(int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    if (paramTRTCVideoFrame == null)
    {
      apiLog("sendCustomVideoData parameter is null");
      return;
    }
    if ((paramTRTCVideoFrame.pixelFormat != 1) && (paramTRTCVideoFrame.pixelFormat != 4) && (paramTRTCVideoFrame.pixelFormat != 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendCustomVideoData parameter error unsupported pixel format ");
      ((StringBuilder)localObject).append(paramTRTCVideoFrame.pixelFormat);
      apiLog(((StringBuilder)localObject).toString());
      return;
    }
    if ((paramTRTCVideoFrame.bufferType != 2) && (paramTRTCVideoFrame.texture == null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendCustomVideoData parameter error unsupported buffer type ");
      ((StringBuilder)localObject).append(paramTRTCVideoFrame.bufferType);
      apiLog(((StringBuilder)localObject).toString());
      return;
    }
    if ((paramInt == 0) && ((this.mVideoSourceType != TRTCCloudImpl.VideoSourceType.CUSTOM) || (this.mRoomInfo.muteLocalVideo))) {
      return;
    }
    Object localObject = this.mCustomCaptureLock;
    if (paramInt == 2) {}
    try
    {
      if (this.mSubStreamCaptureAndEnc == null) {
        this.mSubStreamCaptureAndEnc = createCaptureAndEnc(7);
      }
      if (this.mCustomSubStreamVideoUtil == null) {
        this.mCustomSubStreamVideoUtil = new TRTCCustomTextureUtil(this.mSubStreamCaptureAndEnc, this.mCustomCaptureGLSyncMode);
      }
      if (this.mCustomSubStreamVideoUtil != null)
      {
        this.mCustomSubStreamVideoUtil.sendCustomTexture(paramTRTCVideoFrame);
        break label258;
        if (this.mCustomVideoUtil == null) {
          this.mCustomVideoUtil = new TRTCCustomTextureUtil(this.mCaptureAndEnc, this.mCustomCaptureGLSyncMode);
        }
        if (this.mCustomVideoUtil != null) {
          this.mCustomVideoUtil.sendCustomTexture(paramTRTCVideoFrame);
        }
      }
      label258:
      return;
    }
    finally {}
  }
  
  public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    sendCustomVideoData(0, paramTRTCVideoFrame);
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
      runOnSDKThread(new TRTCCloudImpl.124(this, paramArrayOfByte, paramInt));
    }
    return bool;
  }
  
  public void setAllAudioEffectsVolume(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.111(this, paramInt));
  }
  
  public void setAudioCaptureVolume(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.mAudioCaptureVolume = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioCaptureVolume:  volume=");
    localStringBuilder.append(this.mAudioCaptureVolume);
    apiLog(localStringBuilder.toString());
    TXAudioEffectManagerImpl.getInstance().setVoiceCaptureVolume(i);
  }
  
  public void setAudioEffectVolume(int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TRTCCloudImpl.108(this, paramInt1, paramInt2));
  }
  
  public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener)
  {
    runOnSDKThread(new TRTCCloudImpl.125(this, paramTRTCAudioFrameListener));
  }
  
  public void setAudioPlayoutVolume(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.mAudioPlayoutVolume = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioPlayoutVolume:  volume=");
    localStringBuilder.append(this.mAudioPlayoutVolume);
    apiLog(localStringBuilder.toString());
    TXAudioEffectManagerImpl.getInstance().setAudioPlayoutVolume(i);
  }
  
  public void setAudioQuality(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.51(this, paramInt));
  }
  
  public void setAudioRoute(int paramInt)
  {
    TXDeviceManager.TXAudioRoute localTXAudioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        localTXAudioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece;
      }
    }
    else {
      localTXAudioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
    }
    this.mDeviceManager.setAudioRoute(localTXAudioRoute);
  }
  
  public void setBGMPlayoutVolume(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.101(this, paramInt));
  }
  
  public int setBGMPosition(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.98(this, paramInt));
    return 0;
  }
  
  public void setBGMPublishVolume(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.102(this, paramInt));
  }
  
  public void setBGMVolume(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.100(this, paramInt));
  }
  
  public void setBeautyStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    runOnSDKThread(new TRTCCloudImpl.69(this, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public int setCapturedRawAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat paramTRTCAudioFrameCallbackFormat)
  {
    apiLog(String.format("setCaptureAudioFrameCallbackFormat sample_rate: %d, channel: %d, samplesPerCall %d", new Object[] { Integer.valueOf(paramTRTCAudioFrameCallbackFormat.sampleRate), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.channel), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.samplesPerCall) }));
    if (TXCAudioEngine.getInstance().IsDataCallbackFormatInvalid(paramTRTCAudioFrameCallbackFormat.sampleRate, paramTRTCAudioFrameCallbackFormat.channel, paramTRTCAudioFrameCallbackFormat.samplesPerCall)) {
      return -1;
    }
    runOnSDKThread(new TRTCCloudImpl.126(this, paramTRTCAudioFrameCallbackFormat));
    return 0;
  }
  
  public void setChinLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.79(this, paramInt));
  }
  
  public void setDebugViewMargin(String paramString, TRTCCloud.TRTCViewMargin paramTRTCViewMargin)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.115(this, paramString, paramTRTCViewMargin));
  }
  
  public void setDefaultStreamRecvMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    runOnSDKThread(new TRTCCloudImpl.13(this, paramBoolean1, paramBoolean2));
  }
  
  public void setEncodedDataProcessingListener(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("listener")))
    {
      long l1 = 0L;
      try
      {
        long l2 = paramJSONObject.getLong("listener");
        l1 = l2;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("setEncodedDataProcessingListener:");
      paramJSONObject.append(Long.toHexString(l1));
      apiLog(paramJSONObject.toString());
      nativeSetEncodedDataProcessingListener(this.mNativeRtcContext, l1);
      return;
    }
    apiLog("setEncodedDataProcessingListener [lack parameter or illegal type]: listener");
  }
  
  public void setEyeScaleLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.75(this, paramInt));
  }
  
  public void setFaceShortLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.78(this, paramInt));
  }
  
  public void setFaceSlimLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.76(this, paramInt));
  }
  
  public void setFaceVLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.77(this, paramInt));
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    runOnSDKThread(new TRTCCloudImpl.70(this, paramBitmap));
  }
  
  public void setFilterConcentration(float paramFloat)
  {
    runOnSDKThread(new TRTCCloudImpl.71(this, paramFloat));
  }
  
  public void setFocusPosition(int paramInt1, int paramInt2)
  {
    this.mDeviceManager.setCameraFocusPosition(paramInt1, paramInt2);
  }
  
  public void setGSensorMode(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.46(this, paramInt));
  }
  
  @TargetApi(18)
  public boolean setGreenScreenFile(String paramString)
  {
    runOnSDKThread(new TRTCCloudImpl.74(this, paramString));
    return true;
  }
  
  public void setListener(TRTCCloudListener paramTRTCCloudListener)
  {
    runOnSDKThread(new TRTCCloudImpl.5(this, paramTRTCCloudListener));
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
    runOnSDKThread(new TRTCCloudImpl.6(this));
  }
  
  public int setLocalProcessedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat paramTRTCAudioFrameCallbackFormat)
  {
    apiLog(String.format("setLocalProcessedAudioFrameCallbackFormat sample_rate: %d, channel: %d, samplesPerCall %d", new Object[] { Integer.valueOf(paramTRTCAudioFrameCallbackFormat.sampleRate), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.channel), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.samplesPerCall) }));
    if (TXCAudioEngine.getInstance().IsDataCallbackFormatInvalid(paramTRTCAudioFrameCallbackFormat.sampleRate, paramTRTCAudioFrameCallbackFormat.channel, paramTRTCAudioFrameCallbackFormat.samplesPerCall)) {
      return -1;
    }
    runOnSDKThread(new TRTCCloudImpl.127(this, paramTRTCAudioFrameCallbackFormat));
    return 0;
  }
  
  public void setLocalRenderParams(TRTCCloudDef.TRTCRenderParams paramTRTCRenderParams)
  {
    setLocalViewFillMode(paramTRTCRenderParams.fillMode);
    setLocalViewRotation(paramTRTCRenderParams.rotation);
    setLocalViewMirror(paramTRTCRenderParams.mirrorType);
  }
  
  public void setLocalSurface(Surface paramSurface)
  {
    runOnSDKThread(new TRTCCloudImpl.86(this, paramSurface));
  }
  
  public void setLocalSurfaceSize(int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TRTCCloudImpl.87(this, paramInt1, paramInt2));
  }
  
  public int setLocalVideoProcessListener(int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoFrameListener paramTRTCVideoFrameListener)
  {
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2))
    {
      paramTRTCVideoFrameListener = new StringBuilder();
      paramTRTCVideoFrameListener.append("setLocalVideoRenderListener unsupported pixelFormat : ");
      paramTRTCVideoFrameListener.append(paramInt1);
      apiLog(paramTRTCVideoFrameListener.toString());
      return -1327;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 3))
    {
      paramTRTCVideoFrameListener = new StringBuilder();
      paramTRTCVideoFrameListener.append("setLocalVideoRenderListener unsupported bufferType : ");
      paramTRTCVideoFrameListener.append(paramInt2);
      apiLog(paramTRTCVideoFrameListener.toString());
      return -1328;
    }
    runOnSDKThread(new TRTCCloudImpl.90(this, paramInt1, paramInt2, paramTRTCVideoFrameListener));
    return 0;
  }
  
  public int setLocalVideoRenderListener(int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2) && (paramInt1 != 5))
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
    runOnSDKThread(new TRTCCloudImpl.89(this, paramInt1, paramInt2, paramTRTCVideoRenderListener));
    return 0;
  }
  
  public void setLocalViewFillMode(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.41(this, paramInt));
  }
  
  public void setLocalViewMirror(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.49(this, paramInt));
  }
  
  public void setLocalViewRotation(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.43(this, paramInt));
  }
  
  public void setMicVolumeOnMixing(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.99(this, paramInt));
  }
  
  public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    runOnSDKThread(new TRTCCloudImpl.122(this, paramTRTCTranscodingConfig));
  }
  
  public int setMixedPlayAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat paramTRTCAudioFrameCallbackFormat)
  {
    apiLog(String.format("setMixedPlayAudioFrameCallbackFormat sample_rate: %d, channel: %d, samplesPerCall %d", new Object[] { Integer.valueOf(paramTRTCAudioFrameCallbackFormat.sampleRate), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.channel), Integer.valueOf(paramTRTCAudioFrameCallbackFormat.samplesPerCall) }));
    if (TXCAudioEngine.getInstance().IsDataCallbackFormatInvalid(paramTRTCAudioFrameCallbackFormat.sampleRate, paramTRTCAudioFrameCallbackFormat.channel, paramTRTCAudioFrameCallbackFormat.samplesPerCall)) {
      return -1;
    }
    runOnSDKThread(new TRTCCloudImpl.128(this, paramTRTCAudioFrameCallbackFormat));
    return 0;
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.73(this, paramBoolean));
  }
  
  public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam paramTRTCNetworkQosParam)
  {
    runOnSDKThread(new TRTCCloudImpl.39(this, paramTRTCNetworkQosParam));
  }
  
  public void setNoseSlimLevel(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.80(this, paramInt));
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
    int i = paramJSONObject.getInt("mode");
    if (i == 1)
    {
      this.mPerformanceMode = 1;
      this.mCaptureAndEnc.b().enableSharpnessEnhancement(false);
      paramJSONObject = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
      if (paramJSONObject != null) {
        nativeSetAllowSwitchToHighPerformanceMode(paramJSONObject.getNetworkContext(), true);
      }
    }
    else if (i == 2)
    {
      paramJSONObject = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
      if (paramJSONObject != null) {
        nativeSetAllowSwitchToHighPerformanceMode(paramJSONObject.getNetworkContext(), false);
      }
    }
    else
    {
      this.mPerformanceMode = 0;
      paramJSONObject = (TRTCCloudImpl)this.mCurrentPublishClouds.get(Integer.valueOf(2));
      if (paramJSONObject != null) {
        nativeSetAllowSwitchToHighPerformanceMode(paramJSONObject.getNetworkContext(), true);
      }
    }
  }
  
  public int setPriorRemoteVideoStreamType(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.48(this, paramInt));
    return 0;
  }
  
  public void setRemoteAudioVolume(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.59(this, paramInt, paramString));
  }
  
  public void setRemoteRenderParams(String paramString, int paramInt, TRTCCloudDef.TRTCRenderParams paramTRTCRenderParams)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2)
      {
        paramString = new StringBuilder();
        paramString.append("setRemoteRenderParams unsupported streamType:");
        paramString.append(paramInt);
        TXCLog.e("TRTCCloudImpl", paramString.toString());
        return;
      }
      setRemoteSubStreamViewFillMode(paramString, paramTRTCRenderParams.fillMode);
      setRemoteSubStreamViewRotation(paramString, paramTRTCRenderParams.rotation);
      setRemoteViewMirror(paramString, paramInt, paramTRTCRenderParams.mirrorType);
      return;
    }
    setRemoteViewFillMode(paramString, paramTRTCRenderParams.fillMode);
    setRemoteViewRotation(paramString, paramTRTCRenderParams.rotation);
    setRemoteViewMirror(paramString, paramInt, paramTRTCRenderParams.mirrorType);
  }
  
  public void setRemoteSubStreamViewFillMode(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.24(this, paramString, paramInt));
  }
  
  public void setRemoteSubStreamViewRotation(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.25(this, paramString, paramInt));
  }
  
  public void setRemoteSurface(String paramString, int paramInt, Surface paramSurface)
  {
    runOnSDKThread(new TRTCCloudImpl.84(this, paramString, paramSurface, paramInt));
  }
  
  public void setRemoteSurfaceSize(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    runOnSDKThread(new TRTCCloudImpl.85(this, paramString, paramInt2, paramInt3, paramInt1));
  }
  
  public int setRemoteVideoRenderListener(String paramString, int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    if ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 2) && (paramInt1 != 5))
    {
      paramString = new StringBuilder();
      paramString.append("setRemoteVideoRenderListener unsupported pixelFormat : ");
      paramString.append(paramInt1);
      apiLog(paramString.toString());
      return -1327;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 3))
    {
      paramString = new StringBuilder();
      paramString.append("setRemoteVideoRenderListener unsupported bufferType : ");
      paramString.append(paramInt2);
      apiLog(paramString.toString());
      return -1328;
    }
    runOnSDKThread(new TRTCCloudImpl.91(this, paramString, paramInt1, paramInt2, paramTRTCVideoRenderListener));
    return 0;
  }
  
  public int setRemoteVideoStreamType(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.54(this, paramString, paramInt));
    return 0;
  }
  
  public void setRemoteViewFillMode(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.42(this, paramString, paramInt));
  }
  
  public void setRemoteViewRotation(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.44(this, paramString, paramInt));
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
      runOnMainThread(new TRTCCloudImpl.184(this, paramTXCloudVideoView, paramRenderInfo, locale, paramString, paramTRTCViewMargin));
    }
  }
  
  public void setReverbType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 7))
    {
      runOnSDKThread(new TRTCCloudImpl.103(this, paramInt));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reverbType not support :");
    localStringBuilder.append(paramInt);
    TXCLog.e("TRTCCloudImpl", localStringBuilder.toString());
  }
  
  protected void setRoomType(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      apiLog("setRoomType param is null");
      return;
    }
    if (!paramJSONObject.has("type"))
    {
      apiLog("setRoomType[lack parameter]: type");
      return;
    }
    this.mRoomType = paramJSONObject.optInt("type", 0);
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
  
  public void setSubStreamEncoderParam(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    runOnSDKThread(new TRTCCloudImpl.38(this, paramTRTCVideoEncParam));
  }
  
  public void setSystemVolumeType(int paramInt)
  {
    TXDeviceManager.TXSystemVolumeType localTXSystemVolumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          localTXSystemVolumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP;
        }
      }
      else {
        localTXSystemVolumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia;
      }
    }
    else {
      localTXSystemVolumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
    }
    this.mDeviceManager.setSystemVolumeType(localTXSystemVolumeType);
  }
  
  public void setVideoEncoderMirror(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCCloudImpl.50(this, paramBoolean));
  }
  
  public void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    runOnSDKThread(new TRTCCloudImpl.37(this, paramTRTCVideoEncParam));
  }
  
  public void setVideoEncoderRotation(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.45(this, paramInt));
  }
  
  public void setVideoMuteImage(Bitmap paramBitmap, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.33(this, paramBitmap, paramInt));
  }
  
  public boolean setVoiceChangerType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 11))
    {
      runOnSDKThread(new TRTCCloudImpl.104(this, paramInt));
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
    runOnSDKThread(new TRTCCloudImpl.81(this, paramInt, paramBitmap, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public void setZoom(int paramInt)
  {
    this.mDeviceManager.setCameraZoomRatio(paramInt);
  }
  
  public void showDebugView(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.114(this, paramInt));
  }
  
  public void snapshotVideo(String paramString, int paramInt, TRTCCloudListener.TRTCSnapshotListener paramTRTCSnapshotListener)
  {
    apiLog(String.format("snapshotVideo user:%s streamType:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    runOnSDKThread(new TRTCCloudImpl.27(this, paramString, paramTRTCSnapshotListener, paramInt));
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
    TXCAudioEngine.getInstance().setAudioDumpingListener(new TRTCCloudImpl.66(this));
    return TXCAudioEngine.getInstance().startLocalAudioDumping(48000, 16, paramTRTCAudioRecordingParams.filePath);
  }
  
  protected void startCollectStatus()
  {
    com.tencent.liteav.basic.util.f localf = this.mSDKHandler;
    if (localf != null) {
      localf.postDelayed(this.mStatusNotifyTask, 1000L);
    }
  }
  
  public void startLocalAudio()
  {
    runOnSDKThread(new TRTCCloudImpl.52(this));
  }
  
  public void startLocalAudio(int paramInt)
  {
    setAudioQuality(paramInt);
    startLocalAudio();
  }
  
  public void startLocalPreview(boolean paramBoolean, TXCloudVideoView paramTXCloudVideoView)
  {
    this.mDeviceManager.setFrontCamera(paramBoolean);
    runOnSDKThread(new TRTCCloudImpl.18(this, paramBoolean, paramTXCloudVideoView));
  }
  
  public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams paramTRTCLocalRecordingParams)
  {
    if (paramTRTCLocalRecordingParams == null)
    {
      apiLog("startLocalRecording params is null!");
      onLocalRecordBegin(-1, "");
      return;
    }
    StringBuilder localStringBuilder;
    if ((paramTRTCLocalRecordingParams.recordType != 0) && (paramTRTCLocalRecordingParams.recordType != 1) && (paramTRTCLocalRecordingParams.recordType != 2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startLocalRecording recordType invalid: ");
      localStringBuilder.append(paramTRTCLocalRecordingParams.recordType);
      apiLog(localStringBuilder.toString());
      onLocalRecordBegin(-1, paramTRTCLocalRecordingParams.filePath);
      return;
    }
    if (((paramTRTCLocalRecordingParams.interval < 1000) || (paramTRTCLocalRecordingParams.interval > 10000)) && (paramTRTCLocalRecordingParams.interval != -1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startLocalRecording interval invalid: ");
      localStringBuilder.append(paramTRTCLocalRecordingParams.interval);
      apiLog(localStringBuilder.toString());
      onLocalRecordBegin(-1, paramTRTCLocalRecordingParams.filePath);
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.67(this, paramTRTCLocalRecordingParams));
  }
  
  public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam)
  {
    if (paramTRTCPublishCDNParam == null)
    {
      apiLog("startPublishCDNStream param is null");
      return;
    }
    runOnSDKThread(new TRTCCloudImpl.118(this, paramTRTCPublishCDNParam));
  }
  
  public void startPublishing(String paramString, int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.121(this, paramString, paramInt));
  }
  
  public void startRemoteSubStreamView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    runOnSDKThread(new TRTCCloudImpl.22(this, paramString, paramTXCloudVideoView));
  }
  
  public void startRemoteView(String paramString, int paramInt, TXCloudVideoView paramTXCloudVideoView)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2)
      {
        paramString = new StringBuilder();
        paramString.append("startRemoteView unsupported streamType:");
        paramString.append(paramInt);
        TXCLog.e("TRTCCloudImpl", paramString.toString());
        return;
      }
      startRemoteSubStreamView(paramString, paramTXCloudVideoView);
      return;
    }
    startRemoteView(paramString, paramTXCloudVideoView);
    setRemoteVideoStreamType(paramString, paramInt);
  }
  
  public void startRemoteView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    runOnSDKThread(new TRTCCloudImpl.20(this, paramString, paramTXCloudVideoView));
  }
  
  public void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams paramTRTCScreenShareParams)
  {
    runOnSDKThread(new TRTCCloudImpl.28(this, paramTRTCVideoEncParam, paramTRTCScreenShareParams));
  }
  
  public void startSpeedTest(int paramInt, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      runOnSDKThread(new TRTCCloudImpl.116(this, paramInt, paramString1, paramString2));
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
      if (this.mVolumeLevelNotifyTask == null) {
        this.mVolumeLevelNotifyTask = new TRTCCloudImpl.VolumeLevelNotifyTask(this);
      }
      localVolumeLevelNotifyTask = this.mVolumeLevelNotifyTask;
      if (localVolumeLevelNotifyTask != null) {
        this.mSDKHandler.removeCallbacks(localVolumeLevelNotifyTask);
      }
      this.mSDKHandler.postDelayed(this.mVolumeLevelNotifyTask, this.mAudioVolumeEvalInterval);
      return;
    }
    TRTCCloudImpl.VolumeLevelNotifyTask localVolumeLevelNotifyTask = this.mVolumeLevelNotifyTask;
    if (localVolumeLevelNotifyTask != null) {
      this.mSDKHandler.removeCallbacks(localVolumeLevelNotifyTask);
    }
    this.mAudioVolumeEvalInterval = 0;
  }
  
  public void stopAllAudioEffects()
  {
    runOnSDKThread(new TRTCCloudImpl.110(this));
  }
  
  public void stopAllRemoteView()
  {
    runOnSDKThread(new TRTCCloudImpl.26(this));
  }
  
  public void stopAudioEffect(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.109(this, paramInt));
  }
  
  public void stopAudioRecording()
  {
    TXCAudioEngine.getInstance().stopLocalAudioDumping();
  }
  
  public void stopBGM()
  {
    runOnSDKThread(new TRTCCloudImpl.95(this));
  }
  
  protected void stopCollectStatus()
  {
    com.tencent.liteav.basic.util.f localf = this.mSDKHandler;
    if (localf != null) {
      localf.removeCallbacks(this.mStatusNotifyTask);
    }
  }
  
  public void stopLocalAudio()
  {
    runOnSDKThread(new TRTCCloudImpl.53(this));
  }
  
  public void stopLocalPreview()
  {
    runOnSDKThread(new TRTCCloudImpl.19(this));
  }
  
  public void stopLocalRecording()
  {
    runOnSDKThread(new TRTCCloudImpl.68(this));
  }
  
  public void stopPublishCDNStream()
  {
    runOnSDKThread(new TRTCCloudImpl.120(this));
  }
  
  public void stopPublishing()
  {
    runOnSDKThread(new TRTCCloudImpl.119(this));
  }
  
  protected void stopRemoteRender(TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if (paramUserInfo == null) {
      return;
    }
    apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", new Object[] { paramUserInfo.userID, Long.valueOf(paramUserInfo.tinyID), Integer.valueOf(paramUserInfo.streamType) }));
    com.tencent.liteav.audio.a.a().a(String.valueOf(paramUserInfo.tinyID), hashCode());
    TXCloudVideoView localTXCloudVideoView1 = paramUserInfo.mainRender.view;
    TXCloudVideoView localTXCloudVideoView2 = paramUserInfo.subRender.view;
    if (paramUserInfo.mainRender.render != null)
    {
      paramUserInfo.mainRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.b.b.a);
      paramUserInfo.mainRender.render.stop();
      if ((localTXCloudVideoView1 == null) && (paramUserInfo.mainRender.render.getVideoRender() != null)) {
        paramUserInfo.mainRender.render.getVideoRender().d();
      }
    }
    if (paramUserInfo.subRender.render != null)
    {
      paramUserInfo.subRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.b.b.a);
      paramUserInfo.subRender.render.stop();
      if ((localTXCloudVideoView2 == null) && (paramUserInfo.subRender.render.getVideoRender() != null)) {
        paramUserInfo.subRender.render.getVideoRender().d();
      }
    }
    paramUserInfo.mainRender.stop();
    paramUserInfo.subRender.stop();
    runOnMainThread(new TRTCCloudImpl.185(this, localTXCloudVideoView1, localTXCloudVideoView2));
  }
  
  public void stopRemoteSubStreamView(String paramString)
  {
    runOnSDKThread(new TRTCCloudImpl.23(this, paramString));
  }
  
  public void stopRemoteView(String paramString)
  {
    runOnSDKThread(new TRTCCloudImpl.21(this, paramString));
  }
  
  public void stopRemoteView(String paramString, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2)
      {
        paramString = new StringBuilder();
        paramString.append("stopRemoteView unsupported streamType:");
        paramString.append(paramInt);
        TXCLog.e("TRTCCloudImpl", paramString.toString());
        return;
      }
      stopRemoteSubStreamView(paramString);
      return;
    }
    stopRemoteView(paramString);
  }
  
  public void stopScreenCapture()
  {
    runOnSDKThread(new TRTCCloudImpl.29(this));
  }
  
  public void stopSpeedTest()
  {
    runOnSDKThread(new TRTCCloudImpl.117(this));
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
    TXDeviceManagerImpl localTXDeviceManagerImpl = this.mDeviceManager;
    localTXDeviceManagerImpl.switchCamera(localTXDeviceManagerImpl.isFrontCamera() ^ true);
  }
  
  public void switchRole(int paramInt)
  {
    runOnSDKThread(new TRTCCloudImpl.14(this, paramInt));
  }
  
  public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig paramTRTCSwitchRoomConfig)
  {
    runOnSDKThread(new TRTCCloudImpl.17(this, paramTRTCSwitchRoomConfig));
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
    apiLog(String.format("update appScene[%d] for video enc[%d] source scene[%d]", new Object[] { Integer.valueOf(this.mAppScene), Integer.valueOf(this.mConfig.k), Integer.valueOf(paramInt) }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl
 * JD-Core Version:    0.7.0.1
 */