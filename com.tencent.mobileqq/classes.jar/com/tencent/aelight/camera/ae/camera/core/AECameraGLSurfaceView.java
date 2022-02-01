package com.tencent.aelight.camera.ae.camera.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.camera.AECaptureParam;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.CapturePhotoListener;
import com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase;
import com.tencent.aelight.camera.ae.camera.filter.NonAEFilterProcess;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.AEEditMaterialSelectedListener;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.IDebugInfoCallback;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager;
import com.tencent.aelight.camera.ae.camera.util.AEOrientationEventListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.gif.AEExpressionRecognizer;
import com.tencent.aelight.camera.ae.gif.AEExpressionRecognizer.RecommendTextCallback;
import com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment;
import com.tencent.aelight.camera.ae.perf.AEFpsManager;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.ae.perf.IAEFpsManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoVoiceRecognizer;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.richmedia.capture.audio.AudioChangerManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.mobileqq.videocodec.audio.AudioCapture.AudioCaptureListener;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.initializer.VoiceChangerInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.SensorUtil2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;
import org.libpag.VideoDecoder;
import org.light.DeviceCameraConfig;
import org.light.device.LightDeviceUtils;
import org.light.utils.MustRunOnGLThread;

@TargetApi(17)
public class AECameraGLSurfaceView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, SensorEventListener, GLSurfaceView.Renderer, AEFilterProcessTex.CapturePhotoListener, AudioCapture.AudioCaptureListener, HWEncodeListener
{
  private static final long GIF_SKIP_FRAME_INTERVAL = 83L;
  private static final int GIF_WANTED_SIZE = 640;
  private static final int MAX_PREVIEW_WIDTH = 720;
  private static final int RECORDING_OFF = 0;
  private static final int RECORDING_ON = 1;
  private static final String TAG = "AECameraGLSurfaceView";
  private static volatile boolean isSdkInited = false;
  private int activityOrientation = 0;
  private AECaptureParam aeCaptureParam;
  private AEBottomListScrollView.AEEditMaterialSelectedListener aeEditMaterialSelectedListener;
  private AEExpressionRecognizer aeExpressionRecognizer;
  private AECameraGLSurfaceView.AEGLSurfaceListener aeGLSurfaceListener;
  protected AudioCapture audioCapture;
  private boolean beautyEnable = true;
  protected AECameraGLSurfaceView.CaptureListener captureListener;
  public AEVideoStoryDashboardPart.IDebugInfoCallback debugInfoCallback;
  private int drawFrameCount = 0;
  protected AECameraGLSurfaceView.AEEffectListener effectListener;
  private EGLContext eglContext;
  private EncodeConfig encodeConfig;
  private boolean faceEffectEnable = true;
  private boolean filterEnable = true;
  private boolean firstFrameActionDone;
  private IAEFpsManager fpsReporter = new AEFpsManager();
  private int gifPreviewHeight;
  private int gifPreviewWidth;
  private long gifRecordFrameIndex = 0L;
  private long gifRecordStartTimestamp = 0L;
  private HWVideoRecorder hwVideoRecorder;
  private boolean isDynamicResolutionMode;
  protected boolean isFirstFrame = true;
  private boolean isGIFMode = false;
  private boolean isInit = false;
  private boolean isNeedVoiceEncode = false;
  private boolean isPaused = true;
  private boolean lastDetected = false;
  private boolean logTillHaveFrame = true;
  private AECameraGLSurfaceView.AEKitInitListener mAEKitInitListener;
  private Sensor mAccelerometer;
  protected AudioChangerManager mAudioChangeCapture;
  private AECaptureController mController;
  private String mCustomMaterialPath = null;
  private FilterProcessBase mFilterProcess;
  private volatile boolean mHaveFrame = false;
  private final int mIdentityHashCode;
  private volatile boolean mIsTryLocationPermission = false;
  private VideoMaterial mLastVideoMaterial = null;
  private Runnable mOnFrameDrawCallback;
  private AEOrientationEventListener mOrientationEventListener;
  private volatile boolean mPendingReqLocationPermission = false;
  private int mRecordingStatus;
  private float[] mSensorRotationMatrix = new float[16];
  protected int mSurfaceHeight = 480;
  protected int mSurfaceWidth = 320;
  private PointF mTouchStartPoint = new PointF(0.0F, 0.0F);
  private boolean needFace = false;
  private int notDetectedTimes = 0;
  private boolean onFrameAvailableLogged = false;
  private int orientation = 90;
  protected boolean pauseFilterChainWhenCapture = true;
  private boolean preExtractFrame;
  protected AEExpressionRecognizer.RecommendTextCallback recommendTextCallback;
  private volatile boolean recordingEnabled;
  protected int selectedCamera = 2;
  SensorManager sensorManager;
  private volatile SensorUtil2 sensorUtil;
  private boolean sharpFaceEnable = true;
  private int smoothLevel = 0;
  protected AEFilterManager.MaterialInnerEffectListener stickerInnerLutFilterListener;
  private boolean useVideoOrientation = true;
  private AEVideoCaptureResult videoCaptureResult;
  private int videoHeight;
  private int videoWidth;
  private ShortVideoVoiceRecognizer voiceRecognizer = new ShortVideoVoiceRecognizer();
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    initEGL();
    this.mIdentityHashCode = System.identityHashCode(this);
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AELaunchRecorder.a().a("glSurfaceViewConstruct-begin");
    initEGL();
    this.mIdentityHashCode = System.identityHashCode(this);
    AELaunchRecorder.a().a("glSurfaceViewConstruct-end");
  }
  
  private void addAEInitQueue(Runnable paramRunnable)
  {
    if (isAEKitAvailable()) {
      ((AEFilterProcessTex)this.mFilterProcess).a(paramRunnable);
    }
  }
  
  private boolean checkLocationPermissionGranted()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    return getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
  }
  
  private void checkShowTips()
  {
    FilterProcessBase localFilterProcessBase = this.mFilterProcess;
    if ((localFilterProcessBase != null) && (((AEFilterProcessTex)localFilterProcessBase).a()))
    {
      ((AEFilterProcessTex)this.mFilterProcess).b();
      ((AEFilterProcessTex)this.mFilterProcess).c();
    }
  }
  
  private void collectDebugResolutionInfo(int paramInt1, int paramInt2) {}
  
  private void createFilterProcess()
  {
    if (this.mFilterProcess != null) {
      return;
    }
    AEQLog.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    if ((AEKitForQQ.a()) && (FeatureManager.loadBasicFeatures()))
    {
      this.mFilterProcess = new AEFilterProcessTex(this.mIdentityHashCode);
      ((AEFilterProcessTex)this.mFilterProcess).a(new AECameraGLSurfaceView.6(this));
      if (!TextUtils.isEmpty(this.mCustomMaterialPath)) {
        setCustomMaterial(this.mCustomMaterialPath);
      }
      AEQLog.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
    }
    else
    {
      this.mFilterProcess = new NonAEFilterProcess();
      AEQLog.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
    }
    if (!FeatureManager.Features.VOICE_CHANGER.init()) {
      AEQLog.d("AECameraGLSurfaceView", "Voice so load failed.");
    }
    if (AECommonUtil.a()) {
      VideoDecoder.SetMaxHardwareDecoderCount(0);
    }
  }
  
  private void destroyFilterProcess()
  {
    Object localObject = this.mFilterProcess;
    if (localObject != null)
    {
      ((FilterProcessBase)localObject).h();
      this.mFilterProcess = null;
      localObject = this.aeGLSurfaceListener;
      if (localObject != null) {
        ((AECameraGLSurfaceView.AEGLSurfaceListener)localObject).onPreviewSurfaceTextureRelease();
      }
    }
    AEFilterManagerHolder.setFilterProcess(null);
  }
  
  private void drawToMediaCodec(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    long l = SystemClock.elapsedRealtimeNanos();
    if ((isAEKitAvailable()) && (isRecordingGIF()))
    {
      drawToMediaCodecGif(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l);
      return;
    }
    frameToMediaCodecVideo(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l);
  }
  
  private void drawToMediaCodecGif(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    Object localObject = this.mFilterProcess;
    if (localObject == null) {
      return;
    }
    localObject = (AEFilterProcessTex)localObject;
    if (this.gifRecordStartTimestamp == 0L)
    {
      QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
      this.gifRecordStartTimestamp = paramLong;
      AEGIFChunkPreviewFragment.a = new ArrayList();
    }
    paramInt2 = ((AEFilterProcessTex)localObject).a(paramInt2);
    long l1 = (paramLong - this.gifRecordStartTimestamp) / 1000000L;
    long l2 = this.gifRecordFrameIndex;
    if (l1 > 83L * l2)
    {
      QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(l2) });
      this.gifRecordFrameIndex += 1L;
      if (((AEFilterProcessTex)localObject).a() != null)
      {
        localObject = ((AEFilterProcessTex)localObject).a();
        AEGIFChunkPreviewFragment.a.add(localObject);
      }
      double d = paramLong;
      Double.isNaN(d);
      frameToMediaCodecVideo(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (d / 1.5D));
    }
  }
  
  private void finishCapturePhoto(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    AECameraGLSurfaceView.CaptureListener localCaptureListener = this.captureListener;
    if (localCaptureListener != null) {
      localCaptureListener.onPhotoCaptured(paramAEPhotoCaptureResult);
    }
  }
  
  private float getDist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private int[] getPreviewSize(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    if (this.isGIFMode)
    {
      arrayOfInt = CaptureUtil.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, 1.0F);
      return CaptureUtil.a(640, arrayOfInt[0], arrayOfInt[1]);
    }
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt2 > 720)
    {
      i = (int)(720.0F / paramInt1 * paramInt2);
      j = 720;
    }
    arrayOfInt[0] = j;
    arrayOfInt[1] = i;
    return arrayOfInt;
  }
  
  private void initEGL()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new AECameraGLSurfaceView.3(this));
    setPreserveEGLContextOnPause(false);
    setRenderer(this);
    setRenderMode(0);
    preAction();
  }
  
  private void initFilterProcess()
  {
    AELaunchRecorder.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.mFilterProcess == null)
    {
      Log.d("AECameraGLSurfaceView", "initFilterProcess: mFilterProcess==null, createFilterProcess");
      createFilterProcess();
    }
    initOrientationEventListener();
    Object localObject = this.mFilterProcess;
    if ((localObject instanceof AEFilterProcessTex))
    {
      AEFilterManagerHolder.setFilterProcess((AEFilterProcessTex)localObject);
      localObject = this.mAEKitInitListener;
      if (localObject != null) {
        ((AECameraGLSurfaceView.AEKitInitListener)localObject).onAEKitInited();
      }
      ((AEFilterProcessTex)this.mFilterProcess).a(this.stickerInnerLutFilterListener);
      ((AEFilterProcessTex)this.mFilterProcess).a(new AECameraGLSurfaceView.7(this));
      ((AEFilterProcessTex)this.mFilterProcess).a(new AECameraGLSurfaceView.8(this));
    }
    localObject = this.mFilterProcess.a();
    ((SurfaceTexture)localObject).setOnFrameAvailableListener(this);
    AECameraGLSurfaceView.AEGLSurfaceListener localAEGLSurfaceListener = this.aeGLSurfaceListener;
    if (localAEGLSurfaceListener != null) {
      localAEGLSurfaceListener.onPreviewSurfaceTextureCreate((SurfaceTexture)localObject);
    }
    AELaunchRecorder.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void initOrientationEventListener()
  {
    this.mOrientationEventListener = new AECameraGLSurfaceView.15(this, getContext());
    if (this.mOrientationEventListener.canDetectOrientation()) {
      this.mOrientationEventListener.enable();
    }
  }
  
  public static void initSdk()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[initSdk] + BEGIN, isSdkInited = ");
      localStringBuilder.append(isSdkInited);
      AEQLog.b("AECameraGLSurfaceView", localStringBuilder.toString());
      long l = System.currentTimeMillis();
      if (!isSdkInited)
      {
        AEQLog.b("AECameraGLSurfaceView", "[initSdk] do init");
        isSdkInited = true;
        AELaunchRecorder.a().a("glSurfaceViewStaticInit-begin");
        boolean bool = AEKitForQQ.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initSdk] , AEKitForQQ.init result = ");
        localStringBuilder.append(bool);
        AEQLog.b("AECameraGLSurfaceView", localStringBuilder.toString());
        if (bool) {
          VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.getPtvTemplateSDKPref());
        }
        AELaunchRecorder.a().a("glSurfaceViewStaticInit-end");
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[initSdk] + END, time cost = ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      AEQLog.b("AECameraGLSurfaceView", localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  private void initVideoSize(int paramInt1, int paramInt2)
  {
    float f = this.mSurfaceHeight * 1.0F / this.mSurfaceWidth;
    int i = (int)(this.aeCaptureParam.c() * f);
    if (DovSVParamManager.a().c()) {
      i = this.aeCaptureParam.b();
    }
    if (this.isDynamicResolutionMode)
    {
      arrayOfInt = CaptureUtil.a(i, paramInt1, paramInt2);
      arrayOfInt = CaptureUtil.a(arrayOfInt[0], arrayOfInt[1], this.aeCaptureParam.d(), this.aeCaptureParam.e(), 1.0F);
      this.videoWidth = arrayOfInt[0];
      this.videoHeight = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = CaptureUtil.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, this.aeCaptureParam.a());
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
    arrayOfInt = CaptureUtil.a(i, this.videoWidth, this.videoHeight);
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
  }
  
  private boolean isAEKitAvailable()
  {
    if (AEResUtil.a())
    {
      FilterProcessBase localFilterProcessBase = this.mFilterProcess;
      if ((localFilterProcessBase != null) && ((localFilterProcessBase instanceof AEFilterProcessTex))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isFromARCake()
  {
    if ((getContext() instanceof Activity)) {
      return AECameraEntryManager.l(((Activity)getContext()).getIntent());
    }
    return false;
  }
  
  private boolean isFromCircle()
  {
    if ((getContext() instanceof Activity)) {
      return AECameraEntryManager.k(((Activity)getContext()).getIntent());
    }
    return false;
  }
  
  private boolean isFrontCamera()
  {
    return this.selectedCamera == 1;
  }
  
  private boolean isRecordingGIF()
  {
    return (this.isGIFMode) && (this.recordingEnabled) && (this.encodeConfig != null);
  }
  
  @Nullable
  private static String lightSdkAssetError2String(int paramInt)
  {
    if (paramInt != -800)
    {
      if (paramInt != -700)
      {
        if (paramInt != -600)
        {
          if (paramInt != -500)
          {
            if (paramInt != -400)
            {
              if (paramInt != -300)
              {
                if (paramInt != -200)
                {
                  if (paramInt != -100)
                  {
                    if (paramInt != 0) {
                      paramInt = 2131689752;
                    } else {
                      paramInt = 0;
                    }
                  }
                  else {
                    paramInt = 2131689744;
                  }
                }
                else {
                  paramInt = 2131689746;
                }
              }
              else {
                paramInt = 2131689745;
              }
            }
            else {
              paramInt = 2131689751;
            }
          }
          else {
            paramInt = 2131689750;
          }
        }
        else {
          paramInt = 2131689747;
        }
      }
      else {
        paramInt = 2131689749;
      }
    }
    else {
      paramInt = 2131689748;
    }
    if (paramInt != 0) {
      return HardCodeUtil.a(paramInt);
    }
    return null;
  }
  
  private void notifyDetectChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    AECameraGLSurfaceView.AEEffectListener localAEEffectListener = this.effectListener;
    if (localAEEffectListener != null) {
      localAEEffectListener.onDetectStateChange(paramBoolean1, paramBoolean2);
    }
  }
  
  private void preAction()
  {
    AEQLog.b("AECameraGLSurfaceView", "preAction");
    if (!isSdkInited) {
      initSdk();
    }
    try
    {
      this.sensorUtil = new SensorUtil2();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void preInflateInCircleCamera()
  {
    if ((!this.firstFrameActionDone) && (isFromCircle()))
    {
      AECameraGLSurfaceView.AEGLSurfaceListener localAEGLSurfaceListener = this.aeGLSurfaceListener;
      if (localAEGLSurfaceListener != null) {
        localAEGLSurfaceListener.onFirstFrameDone();
      }
    }
  }
  
  @MustRunOnGLThread
  private void prepareWMData(Map<String, String> paramMap)
  {
    Object localObject1 = this.mFilterProcess;
    if (!(localObject1 instanceof AEFilterProcessTex)) {
      return;
    }
    AEFilterManager localAEFilterManager = ((AEFilterProcessTex)localObject1).a();
    if (localAEFilterManager == null) {
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("prepareWMData: watermarkDict=");
    ((StringBuilder)localObject1).append(paramMap);
    AEQLog.b("AECameraGLSurfaceView", ((StringBuilder)localObject1).toString());
    localAEFilterManager.wmAddInfoDict(paramMap);
    String str2 = (String)paramMap.get("City");
    Object localObject2 = (String)paramMap.get("Road");
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = str2;
    if (str2 == null) {
      localObject1 = "";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[prepareWMData] location : ");
    ((StringBuilder)localObject2).append((String)localObject1);
    AEQLog.b("AECameraGLSurfaceView", ((StringBuilder)localObject2).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localAEFilterManager.wmSetLocation((String)localObject1);
    }
    localObject1 = (String)paramMap.get("WeatherType");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localAEFilterManager.wmSetWeatherCode(Integer.parseInt((String)localObject1));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        AEQLog.a("AECameraGLSurfaceView", localNumberFormatException);
      }
    }
    String str1 = (String)paramMap.get("Weather");
    if (str1 != null) {
      localAEFilterManager.wmSetWeatherStr(str1);
    }
    paramMap = (String)paramMap.get("TempCurr");
    if (paramMap != null) {
      localAEFilterManager.wmSetTemperature(paramMap.replace(HardCodeUtil.a(2131716358), ""));
    }
  }
  
  private void recordGifFrames(int paramInt)
  {
    if ((isRecordingGIF()) && (this.gifRecordStartTimestamp > 0L))
    {
      Object localObject = (AEFilterProcessTex)this.mFilterProcess;
      if (this.aeExpressionRecognizer == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.aeExpressionRecognizer = new AEExpressionRecognizer();
        this.aeExpressionRecognizer.a();
      }
      long l = (SystemClock.elapsedRealtimeNanos() - this.gifRecordStartTimestamp) / 1000000L;
      int i = this.aeExpressionRecognizer.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recording gif, aeExpressionRecognizer.getFrameCount() == ");
      localStringBuilder.append(i);
      QLog.d("AECameraGLSurfaceView", 4, localStringBuilder.toString());
      if ((i < 3) && ((float)l > (i + 0.5F) * 1000.0F) && (((AEFilterProcessTex)localObject).c()))
      {
        localObject = ((AEFilterProcessTex)localObject).a();
        this.aeExpressionRecognizer.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), this.gifPreviewWidth, this.gifPreviewHeight);
      }
    }
  }
  
  private void recoverAudioCapture()
  {
    VideoMaterial localVideoMaterial = this.mLastVideoMaterial;
    if ((localVideoMaterial != null) && (localVideoMaterial.isAudio2textMaterial())) {
      this.voiceRecognizer.a(getContext(), this.audioCapture);
    }
  }
  
  @MainThread
  private void reqLocationPermissionAndReqWMDict()
  {
    AEQLog.b("AECameraGLSurfaceView", "reqLocationPermissionAndReqWMDict");
    new LocationPermissionHelper((Activity)getContext(), new AECameraGLSurfaceView.20(this)).a();
  }
  
  private void requestWMDict()
  {
    WatermarkDataManager.a().a(new AECameraGLSurfaceView.21(this));
  }
  
  private void setTipsHandler(AEFilterProcessTex paramAEFilterProcessTex)
  {
    AECameraGLSurfaceView.AEEffectListener localAEEffectListener = this.effectListener;
    if (localAEEffectListener != null) {
      localAEEffectListener.onSetFilterProcess(paramAEFilterProcessTex);
    }
  }
  
  private void showToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.16(this, paramString));
  }
  
  private short[] toShortArray(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length >> 1;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      int m = paramArrayOfByte[k];
      arrayOfShort[i] = ((short)(paramArrayOfByte[(k + 1)] << 8 | m & 0xFF));
      i += 1;
    }
    return arrayOfShort;
  }
  
  private void updateTipsView()
  {
    if (!isAEKitAvailable()) {
      return;
    }
    AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)this.mFilterProcess;
    if ((localAEFilterProcessTex.b()) && (!localAEFilterProcessTex.c()) && (!this.lastDetected))
    {
      this.notDetectedTimes += 1;
      if (this.notDetectedTimes >= 4)
      {
        notifyDetectChange(localAEFilterProcessTex.b(), localAEFilterProcessTex.c());
        this.notDetectedTimes = 0;
      }
    }
    if ((!this.lastDetected) && (localAEFilterProcessTex.c())) {
      notifyDetectChange(localAEFilterProcessTex.b(), localAEFilterProcessTex.c());
    }
    if (!localAEFilterProcessTex.b()) {
      notifyDetectChange(localAEFilterProcessTex.b(), localAEFilterProcessTex.c());
    }
    if ((this.lastDetected) && (localAEFilterProcessTex.c())) {
      notifyDetectChange(localAEFilterProcessTex.b(), true);
    }
    this.lastDetected = localAEFilterProcessTex.c();
  }
  
  public boolean captureByCameraProxy()
  {
    if (!isAEKitAvailable()) {
      return true;
    }
    return ((AEFilterProcessTex)this.mFilterProcess).f() ^ true;
  }
  
  public void capturePhotoByAEKit(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.23(this), paramInt);
  }
  
  protected void finishCaptureVideo(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (this.captureListener != null) {
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.9(this, paramAEVideoCaptureResult));
    }
    ReportUtil.b();
    int j = this.selectedCamera;
    int i = 1;
    if (j != 1) {
      i = 2;
    }
    CaptureReportUtil.c(i);
  }
  
  void frameToMediaCodecVideo(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.recordingEnabled)
    {
      EncodeConfig localEncodeConfig = this.encodeConfig;
      if (localEncodeConfig != null)
      {
        int i = this.mRecordingStatus;
        if (i != 0)
        {
          if (i != 1)
          {
            paramArrayOfFloat1 = new StringBuilder();
            paramArrayOfFloat1.append("unknown status ");
            paramArrayOfFloat1.append(this.mRecordingStatus);
            throw new RuntimeException(paramArrayOfFloat1.toString());
          }
        }
        else
        {
          localEncodeConfig.a(EGL14.eglGetCurrentContext());
          this.hwVideoRecorder.a();
          this.hwVideoRecorder.a(this.encodeConfig, this);
          this.mRecordingStatus = 1;
        }
        this.hwVideoRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        return;
      }
    }
    paramInt1 = this.mRecordingStatus;
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1)
      {
        this.hwVideoRecorder.b();
        onMediaCodecStopRecord();
        this.mRecordingStatus = 0;
        return;
      }
      paramArrayOfFloat1 = new StringBuilder();
      paramArrayOfFloat1.append("unknown status ");
      paramArrayOfFloat1.append(this.mRecordingStatus);
      throw new RuntimeException(paramArrayOfFloat1.toString());
    }
  }
  
  public String getCaptureDir()
  {
    AECaptureParam localAECaptureParam = this.aeCaptureParam;
    if (localAECaptureParam != null) {
      return localAECaptureParam.a;
    }
    return null;
  }
  
  public int getEffectOrientation()
  {
    return this.orientation;
  }
  
  public MediaFormat getMediaFormat()
  {
    HWVideoRecorder localHWVideoRecorder = this.hwVideoRecorder;
    if (localHWVideoRecorder != null) {
      return localHWVideoRecorder.a();
    }
    return null;
  }
  
  public int getSelectedCamera()
  {
    return this.selectedCamera;
  }
  
  public int getSmoothLevel()
  {
    return this.smoothLevel;
  }
  
  public int getSurfaceHeight()
  {
    return this.mSurfaceHeight;
  }
  
  public int getSurfaceWidth()
  {
    return this.mSurfaceWidth;
  }
  
  public boolean hasTapEffect()
  {
    FilterProcessBase localFilterProcessBase = this.mFilterProcess;
    return ((localFilterProcessBase instanceof AEFilterProcessTex)) && (((AEFilterProcessTex)localFilterProcessBase).a() != null) && (((AEFilterProcessTex)this.mFilterProcess).a().currentMaterialNeedTouchTriggerEvent());
  }
  
  public void init(AECaptureParam paramAECaptureParam, AudioCapture paramAudioCapture)
  {
    if (this.aeCaptureParam == null)
    {
      if (paramAECaptureParam != null)
      {
        this.aeCaptureParam = paramAECaptureParam;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setCaptureParam : ");
          localStringBuilder.append(paramAECaptureParam);
          QLog.d("AECameraGLSurfaceView", 2, localStringBuilder.toString());
        }
        this.hwVideoRecorder = new HWVideoRecorder();
        this.audioCapture = paramAudioCapture;
        this.mAudioChangeCapture = new AudioChangerManager(this.aeCaptureParam.a, CodecParam.mAudioSampleRate, this);
        if (this.isNeedVoiceEncode)
        {
          paramAECaptureParam = new StringBuilder();
          paramAECaptureParam.append(this.aeCaptureParam.a);
          paramAECaptureParam.append(File.separator);
          paramAECaptureParam.append(System.currentTimeMillis());
          paramAECaptureParam.append(".aac");
          paramAECaptureParam = paramAECaptureParam.toString();
          this.audioCapture.a(true, paramAECaptureParam);
        }
        this.sensorManager = ((SensorManager)getContext().getSystemService("sensor"));
        this.mAccelerometer = this.sensorManager.getDefaultSensor(1);
        this.fpsReporter.f();
        this.isInit = true;
        return;
      }
      throw new IllegalArgumentException("param captureParam is null");
    }
    throw new RuntimeException("init is already called");
  }
  
  public boolean isBeautyEnable()
  {
    return this.beautyEnable;
  }
  
  public boolean isFaceEffectEnable()
  {
    return this.faceEffectEnable;
  }
  
  public boolean isFilterEnable()
  {
    return this.filterEnable;
  }
  
  public boolean isRecording()
  {
    return this.recordingEnabled;
  }
  
  public boolean isSharpFaceEnable()
  {
    return this.sharpFaceEnable;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onAttachedToWindow()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onAttachedToWindow]");
    localStringBuilder.append(toString());
    AEQLog.b("AECameraGLSurfaceView", localStringBuilder.toString());
    super.onAttachedToWindow();
    AEQLog.b("AECameraGLSurfaceView", "[onAttachedToWindow] end");
  }
  
  public void onAudioCaptured(String paramString)
  {
    if ((!this.isNeedVoiceEncode) && (!this.mAudioChangeCapture.a()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAudioCaptured---filePath=");
      ((StringBuilder)localObject).append(paramString);
      AEQLog.d("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
      localObject = this.videoCaptureResult;
      ((AEVideoCaptureResult)localObject).audioDataFilePath = paramString;
      if (((AEVideoCaptureResult)localObject).videoMp4FilePath != null) {
        finishCaptureVideo(this.videoCaptureResult);
      }
    }
  }
  
  public void onAudioChangeCaptured(String paramString)
  {
    if (this.mAudioChangeCapture.a())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAudioChangeCaptured---filePath=");
      ((StringBuilder)localObject).append(paramString);
      AEQLog.d("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
      localObject = this.videoCaptureResult;
      ((AEVideoCaptureResult)localObject).audioDataFilePath = paramString;
      if (((AEVideoCaptureResult)localObject).videoMp4FilePath != null) {
        finishCaptureVideo(this.videoCaptureResult);
      }
    }
  }
  
  public void onAudioError(int paramInt)
  {
    if ((this.isNeedVoiceEncode) && (!this.mAudioChangeCapture.a()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAudioError---errorCode=");
      ((StringBuilder)localObject).append(paramInt);
      AEQLog.d("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
      localObject = this.videoCaptureResult;
      ((AEVideoCaptureResult)localObject).audioDataFilePath = "";
      if (((AEVideoCaptureResult)localObject).videoMp4FilePath != null) {
        finishCaptureVideo(this.videoCaptureResult);
      }
    }
  }
  
  public void onAudioFrames(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = toShortArray(paramArrayOfByte);
    double d1 = 0.0D;
    int i = 0;
    while (i < localObject.length)
    {
      d2 = localObject[i] * localObject[i];
      Double.isNaN(d2);
      d1 += d2;
      i += 1;
    }
    double d2 = localObject.length;
    Double.isNaN(d2);
    d1 = Math.log10(d1 / d2);
    localObject = this.mFilterProcess;
    if ((localObject instanceof AEFilterProcessTex)) {
      ((AEFilterProcessTex)localObject).b((float)(d1 * 10.0D));
    }
    this.mAudioChangeCapture.a(paramArrayOfByte, paramInt1, paramInt2);
    this.voiceRecognizer.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void onAudioInit()
  {
    if (this.audioCapture != null) {
      queueEvent(new AECameraGLSurfaceView.10(this));
    }
  }
  
  public void onAudioUnInit() {}
  
  public void onCameraPreviewSizeChanged(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCameraPreviewSizeChanged---cameraWidth=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", cameraHeight=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", mSurfaceWidth=");
    ((StringBuilder)localObject).append(this.mSurfaceWidth);
    ((StringBuilder)localObject).append(", mSurfaceHeight=");
    ((StringBuilder)localObject).append(this.mSurfaceHeight);
    AEQLog.b("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
    int i = this.mSurfaceWidth;
    double d1 = i;
    int j = this.mSurfaceHeight;
    double d2 = j;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    this.videoWidth = paramInt1;
    d2 = this.videoWidth;
    Double.isNaN(d2);
    this.videoHeight = ((int)(d2 / d1));
    if (this.isGIFMode)
    {
      localObject = CaptureUtil.a(paramInt1, paramInt2, i, j, 1.0F);
      localObject = CaptureUtil.a(640, localObject[0], localObject[1]);
      j = localObject[0];
      i = localObject[1];
      this.gifPreviewWidth = j;
      this.gifPreviewHeight = i;
      this.videoWidth = this.gifPreviewWidth;
      this.videoHeight = this.gifPreviewHeight;
    }
    else
    {
      initVideoSize(paramInt1, paramInt2);
      j = paramInt1;
      i = paramInt2;
    }
    if (this.mFilterProcess != null)
    {
      int m = i;
      int k = j;
      if (j > 720)
      {
        m = (int)(720.0F / j * i);
        k = 720;
      }
      this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, paramInt1, paramInt2, k, m);
      this.aeGLSurfaceListener.onPreviewSizeChanged(k, m, this.mSurfaceWidth, this.mSurfaceHeight);
      this.mFilterProcess.a(this.videoWidth, this.videoHeight);
    }
    collectDebugResolutionInfo(paramInt1, paramInt2);
  }
  
  public void onCameraPreviewStarted()
  {
    this.fpsReporter.b();
    this.isFirstFrame = true;
  }
  
  public void onCaptureError(int paramInt) {}
  
  public void onChangeCamera(int paramInt)
  {
    this.selectedCamera = paramInt;
    FilterProcessBase localFilterProcessBase = this.mFilterProcess;
    if (localFilterProcessBase != null) {
      localFilterProcessBase.b(false);
    }
    this.fpsReporter.a(isFrontCamera());
  }
  
  public void onDestroy()
  {
    AEQLog.d("AECameraGLSurfaceView", "[onDestroy]");
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("### onDestroy, hashCode=");
      ((StringBuilder)localObject).append(this.mIdentityHashCode);
      ((StringBuilder)localObject).append(" ###");
      AEQLog.a("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
    }
    this.mIsTryLocationPermission = false;
    Object localObject = this.voiceRecognizer;
    if (localObject != null) {
      ((ShortVideoVoiceRecognizer)localObject).a();
    }
    localObject = this.mFilterProcess;
    if (localObject != null) {
      ((FilterProcessBase)localObject).b(true);
    }
    this.fpsReporter.g();
    localObject = this.hwVideoRecorder;
    if (localObject != null) {
      ((HWVideoRecorder)localObject).c();
    }
    queueEvent(new AECameraGLSurfaceView.5(this));
    AEQLog.d("AECameraGLSurfaceView", "[onDestroy] end");
  }
  
  protected void onDetachedFromWindow()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onDetachedFromWindow]");
    localStringBuilder.append(toString());
    AEQLog.d("AECameraGLSurfaceView", localStringBuilder.toString());
    super.onDetachedFromWindow();
    AEQLog.d("AECameraGLSurfaceView", "[onDetachedFromWindow] end");
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.isPaused)
    {
      preInflateInCircleCamera();
      return;
    }
    boolean bool = this.mHaveFrame;
    if (this.logTillHaveFrame)
    {
      this.drawFrameCount += 1;
      if (bool)
      {
        paramGL10 = "onDrawFrameReal-begin";
      }
      else
      {
        paramGL10 = new StringBuilder();
        paramGL10.append("onDrawFrameFake-begin");
        paramGL10.append(this.drawFrameCount);
        paramGL10 = paramGL10.toString();
      }
      AELaunchRecorder.a().a(paramGL10);
    }
    if (this.mFilterProcess == null) {
      return;
    }
    if (this.logTillHaveFrame) {
      AELaunchRecorder.a().a("FilterProcessInitFilters-begin");
    }
    this.mFilterProcess.g();
    if (this.logTillHaveFrame) {
      AELaunchRecorder.a().a("FilterProcessInitFilters-end");
    }
    paramGL10 = this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, this.isGIFMode);
    if (isAEKitAvailable())
    {
      AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)this.mFilterProcess;
      AECameraGLSurfaceView.AEGLSurfaceListener localAEGLSurfaceListener = this.aeGLSurfaceListener;
      if (localAEGLSurfaceListener != null) {
        localAEGLSurfaceListener.onDrawFrameWithEffect(this.selectedCamera, localAEFilterProcessTex.a());
      }
      recordGifFrames(paramGL10[1]);
    }
    if ((this.preExtractFrame) && (!this.isGIFMode)) {
      this.mFilterProcess.c(paramGL10[1]);
    }
    drawToMediaCodec(paramGL10[1], null, null);
    if (this.mOnFrameDrawCallback != null) {
      queueEvent(new AECameraGLSurfaceView.14(this));
    }
    this.fpsReporter.d();
    if (!this.firstFrameActionDone)
    {
      this.firstFrameActionDone = true;
      AEBaseReportParam.a().h();
      AEBaseDataReporter.a().ae();
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a(this.debugInfoCallback, 5000L);
      }
      paramGL10 = this.aeGLSurfaceListener;
      if (paramGL10 != null) {
        paramGL10.onFirstFrameDone();
      }
    }
    if (this.logTillHaveFrame)
    {
      if (bool)
      {
        paramGL10 = "onDrawFrameReal-end";
      }
      else
      {
        paramGL10 = new StringBuilder();
        paramGL10.append("onDrawFrameFake-end");
        paramGL10.append(this.drawFrameCount);
        paramGL10 = paramGL10.toString();
      }
      AELaunchRecorder.a().a(paramGL10);
      if (bool) {
        this.logTillHaveFrame = false;
      }
    }
    if ((bool) && (this.isFirstFrame))
    {
      this.isFirstFrame = false;
      paramGL10 = this.captureListener;
      if (paramGL10 != null) {
        paramGL10.reportFirstFrameShown();
      }
      this.fpsReporter.c();
      AELaunchRecorder.a().c();
    }
  }
  
  public void onEncodeAudioCaptured(String paramString)
  {
    if ((this.isNeedVoiceEncode) && (!this.mAudioChangeCapture.a()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEncodeAudioCaptured---filePath=");
      ((StringBuilder)localObject).append(paramString);
      AEQLog.d("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
      localObject = this.videoCaptureResult;
      ((AEVideoCaptureResult)localObject).audioDataFilePath = paramString;
      if (((AEVideoCaptureResult)localObject).videoMp4FilePath != null) {
        finishCaptureVideo(this.videoCaptureResult);
      }
    }
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.videoCaptureResult.errorCode = paramInt;
    if (this.captureListener != null) {
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.13(this));
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEncodeFinish filePath = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AECameraGLSurfaceView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.videoCaptureResult;
    ((AEVideoCaptureResult)localObject).videoMp4FilePath = paramString;
    if (this.audioCapture != null)
    {
      if (((AEVideoCaptureResult)localObject).audioDataFilePath != null)
      {
        finishCaptureVideo(this.videoCaptureResult);
        return;
      }
      if (this.mAudioChangeCapture.a())
      {
        this.mAudioChangeCapture.b();
        this.audioCapture.g();
      }
      this.audioCapture.g();
      return;
    }
    paramString = new StringBuilder();
    paramString.append(this.aeCaptureParam.a);
    paramString.append("/noaudio");
    paramString = paramString.toString();
    FileUtils.createFileIfNotExits(paramString);
    localObject = this.videoCaptureResult;
    ((AEVideoCaptureResult)localObject).audioDataFilePath = paramString;
    finishCaptureVideo((AEVideoCaptureResult)localObject);
  }
  
  public void onEncodeFrame()
  {
    AEVideoCaptureResult localAEVideoCaptureResult = this.videoCaptureResult;
    localAEVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void onEncodeStart()
  {
    this.videoCaptureResult.videoFrameCount = 0;
    if (this.audioCapture != null)
    {
      if (this.mAudioChangeCapture.a()) {
        this.mAudioChangeCapture.a();
      }
      this.audioCapture.a();
    }
    if (this.captureListener != null) {
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.12(this));
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.mHaveFrame = true;
    if (!this.onFrameAvailableLogged)
    {
      this.onFrameAvailableLogged = true;
      AELaunchRecorder.a().a("onFrameAvailable");
    }
    if (this.sensorUtil != null) {
      this.sensorUtil.getRotation(this.mSensorRotationMatrix);
    }
    queueEvent(new AECameraGLSurfaceView.1(this));
    requestRender();
  }
  
  protected void onMediaCodecStopRecord()
  {
    if (this.isGIFMode)
    {
      this.gifRecordStartTimestamp = 0L;
      this.gifRecordFrameIndex = 0L;
      QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord");
      if (this.aeExpressionRecognizer != null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.aeExpressionRecognizer.a(this.recommendTextCallback);
        this.aeExpressionRecognizer.b();
        this.aeExpressionRecognizer.c();
      }
    }
  }
  
  public void onPause()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onPause] hashCode=");
    ((StringBuilder)localObject).append(this.mIdentityHashCode);
    ((StringBuilder)localObject).append(" ###");
    AEQLog.d("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
    queueEvent(new AECameraGLSurfaceView.4(this));
    this.sensorManager.unregisterListener(this);
    this.isPaused = true;
    localObject = this.mOrientationEventListener;
    if (localObject != null) {
      ((AEOrientationEventListener)localObject).disable();
    }
    if (this.sensorUtil != null) {
      this.sensorUtil.stop();
    }
    super.onPause();
    AEQLog.d("AECameraGLSurfaceView", "[onPause] end");
  }
  
  public void onPhotoCaptured(Bitmap paramBitmap)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.11(this, paramBitmap), 64, null, false);
  }
  
  public void onResume()
  {
    super.onResume();
    this.isPaused = false;
    if (this.sensorUtil != null) {
      this.sensorUtil.start();
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("### onResume, hashCode=");
      ((StringBuilder)localObject).append(this.mIdentityHashCode);
      ((StringBuilder)localObject).append(" ###");
      AEQLog.a("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
    }
    this.recordingEnabled = false;
    Object localObject = this.mOrientationEventListener;
    if ((localObject != null) && (((AEOrientationEventListener)localObject).canDetectOrientation())) {
      this.mOrientationEventListener.enable();
    }
    if (this.mPendingReqLocationPermission)
    {
      this.mPendingReqLocationPermission = false;
      this.mIsTryLocationPermission = true;
      reqLocationPermissionAndReqWMDict();
    }
    this.sensorManager.registerListener(this, this.mAccelerometer, 3);
  }
  
  protected void onSelectFaceEffect(VideoMaterial paramVideoMaterial)
  {
    if (!isFaceEffectEnable()) {
      return;
    }
    AECameraGLSurfaceView.AEEffectListener localAEEffectListener = this.effectListener;
    if (localAEEffectListener != null) {
      localAEEffectListener.onSelectFaceEffect(paramVideoMaterial);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    FilterProcessBase localFilterProcessBase = this.mFilterProcess;
    if ((localFilterProcessBase instanceof AEFilterProcessTex)) {
      ((AEFilterProcessTex)localFilterProcessBase).a(paramSensorEvent);
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10 = new StringBuilder();
    paramGL10.append("[onSurfaceChanged] + BEGIN, width = ");
    paramGL10.append(paramInt1);
    paramGL10.append(", height = ");
    paramGL10.append(paramInt2);
    AEQLog.b("AECameraGLSurfaceView", paramGL10.toString());
    AELaunchRecorder.a().a("onSurfaceChanged-begin");
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    if (this.mFilterProcess != null)
    {
      paramGL10 = getPreviewSize(paramInt1, paramInt2);
      this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, 0, 0, paramGL10[0], paramGL10[1]);
    }
    int i = this.smoothLevel;
    if (i != 0) {
      setBeautyLevel(i);
    }
    AELaunchRecorder.a().a("onSurfaceChanged-end");
    paramGL10 = new StringBuilder();
    paramGL10.append("[onSurfaceChanged] + END, width = ");
    paramGL10.append(paramInt1);
    paramGL10.append(", height = ");
    paramGL10.append(paramInt2);
    AEQLog.b("AECameraGLSurfaceView", paramGL10.toString());
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AEQLog.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    AELaunchRecorder.a().a("onSurfaceCreated-begin");
    initFilterProcess();
    AELaunchRecorder.a().a("onSurfaceCreated-end");
    AEQLog.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if (isAEKitAvailable())
    {
      Object localObject = this.mController;
      if ((localObject != null) && (!((AECaptureController)localObject).c()))
      {
        localObject = (AEFilterProcessTex)this.mFilterProcess;
        if (((AEFilterProcessTex)localObject).d())
        {
          float f1 = paramMotionEvent.getX();
          float f2 = paramMotionEvent.getY();
          int i = LightDeviceUtils.getScreenWidth(AEModule.getContext());
          int j = paramMotionEvent.getAction();
          if (j != 0)
          {
            if (j != 1)
            {
              if (j != 2) {
                return true;
              }
              if (getDist(this.mTouchStartPoint.x, this.mTouchStartPoint.y, f1, f2) > i * 0.05F)
              {
                queueEvent(new AECameraGLSurfaceView.27(this, (AEFilterProcessTex)localObject, f1, f2, i));
                return true;
              }
            }
            else
            {
              queueEvent(new AECameraGLSurfaceView.28(this, (AEFilterProcessTex)localObject, f1, f2, i));
              return true;
            }
          }
          else
          {
            paramMotionEvent = this.mTouchStartPoint;
            paramMotionEvent.x = f1;
            paramMotionEvent.y = f2;
            queueEvent(new AECameraGLSurfaceView.26(this, (AEFilterProcessTex)localObject, f1, f2, i));
          }
          return true;
        }
        if ((isFromARCake()) && (((AEFilterProcessTex)localObject).e()))
        {
          ((AEFilterProcessTex)localObject).a(paramMotionEvent, getWidth(), getHeight());
          return true;
        }
        return super.onTouchEvent(paramMotionEvent);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void resetMaterialWhenRecord()
  {
    if (!isAEKitAvailable()) {
      return;
    }
    if (this.mFilterProcess != null) {
      queueEvent(new AECameraGLSurfaceView.22(this));
    }
  }
  
  public void setAECaptureController(AECaptureController paramAECaptureController)
  {
    this.mController = paramAECaptureController;
  }
  
  public void setAEKitInitListener(AECameraGLSurfaceView.AEKitInitListener paramAEKitInitListener)
  {
    this.mAEKitInitListener = paramAEKitInitListener;
  }
  
  public void setAeEditMaterialSelectedListener(AEBottomListScrollView.AEEditMaterialSelectedListener paramAEEditMaterialSelectedListener)
  {
    this.aeEditMaterialSelectedListener = paramAEEditMaterialSelectedListener;
  }
  
  public void setAeGLSurfaceListener(AECameraGLSurfaceView.AEGLSurfaceListener paramAEGLSurfaceListener)
  {
    this.aeGLSurfaceListener = paramAEGLSurfaceListener;
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.beautyEnable = paramBoolean;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if ((isAEKitAvailable()) && (isBeautyEnable()))
    {
      this.smoothLevel = paramInt;
      queueEvent(new AECameraGLSurfaceView.24(this, paramInt));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setBeautyLevel] level = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", isAEKitAvailable is false");
    AEQLog.b("AECameraGLSurfaceView", localStringBuilder.toString());
  }
  
  public void setBundlePath(String paramString1, String paramString2)
  {
    if ((this.mFilterProcess instanceof AEFilterProcessTex)) {
      queueEvent(new AECameraGLSurfaceView.2(this, paramString1, paramString2));
    }
  }
  
  public void setCaptureListener(AECameraGLSurfaceView.CaptureListener paramCaptureListener)
  {
    this.captureListener = paramCaptureListener;
  }
  
  public void setCaptureRequest(AECameraGLSurfaceView.ExtractFrameRequest paramExtractFrameRequest)
  {
    FilterProcessBase localFilterProcessBase = this.mFilterProcess;
    if (localFilterProcessBase != null) {
      localFilterProcessBase.a(paramExtractFrameRequest);
    }
  }
  
  public void setCustomMaterial(@Nullable String paramString)
  {
    this.mCustomMaterialPath = paramString;
    FilterProcessBase localFilterProcessBase = this.mFilterProcess;
    if (localFilterProcessBase != null) {
      queueEvent(new AECameraGLSurfaceView.19(this, (AEFilterProcessTex)localFilterProcessBase, paramString));
    }
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.isDynamicResolutionMode = paramBoolean;
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.faceEffectEnable = paramBoolean;
  }
  
  public void setFaceEffectListener(AECameraGLSurfaceView.AEEffectListener paramAEEffectListener)
  {
    this.effectListener = paramAEEffectListener;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if (isAEKitAvailable())
    {
      if (!isFilterEnable()) {
        return;
      }
      AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)this.mFilterProcess;
      if (paramFilterCategoryItem == null) {
        return;
      }
      Object localObject = paramFilterCategoryItem.a();
      if (localObject == null) {
        return;
      }
      paramFilterCategoryItem = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
      if (!TextUtils.isEmpty(((FilterDesc)localObject).resRootPath)) {
        paramFilterCategoryItem = ((FilterDesc)localObject).resRootPath;
      }
      paramFilterCategoryItem = ((FilterDesc)localObject).getResFold(paramFilterCategoryItem);
      localObject = QQPtColorFilter.getColorFilterInfo(paramFilterCategoryItem);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFilterCategoryItem);
        localStringBuilder.append(((QQPtColorFilterInfo)localObject).getColorPng());
        paramFilterCategoryItem = localStringBuilder.toString();
        if (new File(paramFilterCategoryItem).exists()) {
          localAEFilterProcessTex.c(paramFilterCategoryItem);
        }
      }
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.filterEnable = paramBoolean;
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.fpsReporter.b(paramBoolean);
    this.isGIFMode = paramBoolean;
  }
  
  public void setIsVoiceNeedEncode(boolean paramBoolean)
  {
    this.isNeedVoiceEncode = paramBoolean;
  }
  
  public void setMaterial(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setMaterial] in set materialPath:");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.b("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
    localObject = this.effectListener;
    if (localObject != null)
    {
      ((AECameraGLSurfaceView.AEEffectListener)localObject).onHidePagTip();
      this.effectListener.onHideNormalTip();
    }
    ThreadManager.excute(new AECameraGLSurfaceView.18(this, new AECameraGLSurfaceView.17(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (!paramAEMaterialMetaData.equals(AEMaterialMetaData.a)))
    {
      setMaterial(paramAEMaterialMetaData.a());
      return;
    }
    setMaterial(null);
  }
  
  public void setPauseFilterChainWhenCapture(boolean paramBoolean)
  {
    this.pauseFilterChainWhenCapture = paramBoolean;
    FilterProcessBase localFilterProcessBase = this.mFilterProcess;
    if ((localFilterProcessBase != null) && ((localFilterProcessBase instanceof AEFilterProcessTex))) {
      ((AEFilterProcessTex)localFilterProcessBase).a(paramBoolean);
    }
  }
  
  public void setPreExtractFrame(boolean paramBoolean)
  {
    this.preExtractFrame = paramBoolean;
  }
  
  public void setRecommendTextCallback(AEExpressionRecognizer.RecommendTextCallback paramRecommendTextCallback)
  {
    this.recommendTextCallback = paramRecommendTextCallback;
  }
  
  public void setSharpFaceEnable(boolean paramBoolean)
  {
    this.sharpFaceEnable = paramBoolean;
  }
  
  public void setSharpFaceLevel(int paramInt)
  {
    if (isAEKitAvailable())
    {
      if (!isSharpFaceEnable()) {
        return;
      }
      queueEvent(new AECameraGLSurfaceView.25(this, paramInt));
    }
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.MaterialInnerEffectListener paramMaterialInnerEffectListener)
  {
    this.stickerInnerLutFilterListener = paramMaterialInnerEffectListener;
    FilterProcessBase localFilterProcessBase = this.mFilterProcess;
    if ((localFilterProcessBase != null) && ((localFilterProcessBase instanceof AEFilterProcessTex))) {
      ((AEFilterProcessTex)localFilterProcessBase).a(paramMaterialInnerEffectListener);
    }
  }
  
  public void setTapEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    queueEvent(new AECameraGLSurfaceView.TapRunnable(this, paramInt, paramFloat1 / this.mSurfaceWidth, paramFloat2 / this.mSurfaceHeight));
  }
  
  public void setUseVideoOrientation(boolean paramBoolean)
  {
    this.useVideoOrientation = paramBoolean;
  }
  
  public void startCaptureVideo()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startCaptureVideo---recordingEnabled=");
    ((StringBuilder)localObject).append(this.recordingEnabled);
    AEQLog.b("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
    this.fpsReporter.e();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.aeCaptureParam.a);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".mp4");
    localObject = ((StringBuilder)localObject).toString();
    int i;
    if ((this.useVideoOrientation) && (!this.isGIFMode)) {
      i = CaptureUtil.b(this.orientation);
    } else {
      i = 0;
    }
    this.encodeConfig = new EncodeConfig((String)localObject, this.videoWidth, this.videoHeight, this.aeCaptureParam.a(), this.aeCaptureParam.f(), false, i);
    this.encodeConfig.i = this.aeCaptureParam.h();
    this.encodeConfig.j = this.aeCaptureParam.i();
    this.videoCaptureResult = new AEVideoCaptureResult();
    this.videoCaptureResult.startTimeMs = System.currentTimeMillis();
    localObject = this.videoCaptureResult;
    ((AEVideoCaptureResult)localObject).orientation = this.orientation;
    ((AEVideoCaptureResult)localObject).type = 0;
    this.recordingEnabled = true;
    CaptureUtil.a(false, false);
  }
  
  public void stopCaptureVideo()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopCaptureVideo---recordingEnabled=");
    ((StringBuilder)localObject).append(this.recordingEnabled);
    ((StringBuilder)localObject).append(", recordingStatus=");
    ((StringBuilder)localObject).append(this.mRecordingStatus);
    ((StringBuilder)localObject).append(", isPaused=");
    ((StringBuilder)localObject).append(this.isPaused);
    AEQLog.b("AECameraGLSurfaceView", ((StringBuilder)localObject).toString());
    if (this.recordingEnabled)
    {
      this.recordingEnabled = false;
      if (this.mRecordingStatus == 0)
      {
        localObject = this.captureListener;
        if (localObject != null) {
          ((AECameraGLSurfaceView.CaptureListener)localObject).onCaptureError(102);
        }
      }
      else if (this.isPaused)
      {
        drawToMediaCodec(0, null, null);
      }
    }
  }
  
  public void switchSegment(boolean paramBoolean)
  {
    if (isAEKitAvailable()) {
      ((AEFilterProcessTex)this.mFilterProcess).c(paramBoolean);
    }
  }
  
  public void switchSegmentFollowFace(boolean paramBoolean)
  {
    if (isAEKitAvailable()) {
      ((AEFilterProcessTex)this.mFilterProcess).d(paramBoolean);
    }
  }
  
  public void updateCameraHorizontalViewAngle(float paramFloat)
  {
    if ((this.mFilterProcess instanceof AEFilterProcessTex))
    {
      DeviceCameraConfig localDeviceCameraConfig = new DeviceCameraConfig();
      localDeviceCameraConfig.cameraHorizontalFov = paramFloat;
      ((AEFilterProcessTex)this.mFilterProcess).a(localDeviceCameraConfig);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */