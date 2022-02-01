package com.tencent.mobileqq.activity.richmedia.state;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.common.TCTimer;
import com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter.ErrorHandleCallback;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.OnAudioRecordListener;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.ParamCache;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.FilterPreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.mobileqq.shortvideo.util.AudioDataCache;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager.OnSdCardChangedListener;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class RMVideoStateMgr
  implements AVCodec.AVCodecCallback, TCTimer.TCTimerCallback, ErrorCenter.ErrorHandleCallback, AudioCapture.OnAudioRecordListener, StorageManager.OnSdCardChangedListener
{
  private static RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  public static boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 850, 780, 650, 480 };
  public static boolean c;
  public double a;
  public int a;
  public long a;
  public Context a;
  public Handler a;
  public RMFileEventNotify a;
  public RMVideoClipSpec a;
  final RMVideoIdleState jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoIdleState = new RMVideoIdleState();
  final RMVideoInitState jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoInitState = new RMVideoInitState();
  final RMVideoPreviewState jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoPreviewState = new RMVideoPreviewState();
  final RMVideoRecordState jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoRecordState = new RMVideoRecordState();
  public RMVideoStateMgr.ForceReleaseLockOnPause a;
  public final RMVideoSwitchCameraPicMgr a;
  public final RMVideoThumbGenMgr a;
  public RMViewSTInterface a;
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder;
  public AudioCapture.OnAudioRecordListener a;
  public AudioCapture a;
  public CameraProxy a;
  public PreviewContext a;
  public AudioDataCache a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private WeakReference<HWEncodeListener> jdField_a_of_type_JavaLangRefWeakReference;
  public AtomicBoolean a;
  public AtomicInteger a;
  public int b;
  public String b;
  public AtomicInteger b;
  public boolean b;
  private int[] b;
  public int c;
  private int d;
  public boolean d;
  private int e;
  public boolean e;
  private int f;
  public boolean f;
  public boolean g = false;
  public boolean h = false;
  public boolean i = true;
  private boolean j = false;
  private boolean k = false;
  private volatile boolean l;
  private boolean m = false;
  private boolean n = false;
  private volatile boolean o = false;
  private boolean p = true;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_c_of_type_Boolean = true;
  }
  
  private RMVideoStateMgr()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr = new RMVideoThumbGenMgr();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr = new RMVideoSwitchCameraPicMgr();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMFileEventNotify = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioDataCache = null;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = 480;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause = new RMVideoStateMgr.ForceReleaseLockOnPause();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec = new RMVideoClipSpec();
    this.jdField_b_of_type_ArrayOfInt = new int[8];
  }
  
  public static RMVideoStateMgr a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = new RMVideoStateMgr();
      }
      RMVideoStateMgr localRMVideoStateMgr = jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      return localRMVideoStateMgr;
    }
    finally {}
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1);
      paramString2 = new File(paramString2);
      if ((paramString1.exists()) && (paramString2.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "deleteDirectoryByTime rootDir:" + paramString1 + ", currentDirectory:" + paramString2);
        }
        paramString2 = paramString2.getName();
        paramString1 = paramString1.listFiles();
        if ((paramString1 != null) && (paramString1.length > 0) && (!TextUtils.isEmpty(paramString2)))
        {
          int i1 = 0;
          while (i1 < paramString1.length)
          {
            String str = paramString1[i1].getName();
            if ((!TextUtils.isEmpty(str)) && (str.compareTo(paramString2) < 0)) {
              FileUtils.a(paramString1[i1].getAbsolutePath());
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    do
    {
      do
      {
        return;
        paramString1 = new File(paramString1);
      } while (!paramString1.exists());
      File[] arrayOfFile = paramString1.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i1 = 0;
        if (i1 < arrayOfFile.length)
        {
          if ((paramString2 != null) && (!"".equals(paramString2)) && (arrayOfFile[i1].getAbsolutePath().equals(paramString2))) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (arrayOfFile[i1].isDirectory()) {
              a(arrayOfFile[i1].getAbsolutePath(), paramString2, true);
            } else {
              arrayOfFile[i1].delete();
            }
          }
        }
      }
    } while (!paramBoolean);
    paramString1.delete();
  }
  
  public static boolean a(boolean paramBoolean)
  {
    return (HwEnvData.a()) || (paramBoolean);
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = GloableValue.jdField_c_of_type_ArrayOfInt.length / 2;
    int i1 = 0;
    if (i1 < i2)
    {
      int i3 = a(GloableValue.jdField_c_of_type_ArrayOfInt[(i1 * 2 + 1)], paramBoolean);
      if ((GloableValue.jdField_c_of_type_ArrayOfInt[(i1 * 2)] != paramInt1) || (i3 != paramInt2)) {}
    }
    for (;;)
    {
      if ((i1 >= 0) && (jdField_a_of_type_ArrayOfInt[i1] != this.jdField_b_of_type_Int)) {
        this.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i1];
      }
      return;
      i1 += 1;
      break;
      i1 = -1;
    }
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "clearVideoDataFile:" + paramString);
    }
    String str = GloableValue.a();
    if ((str != null) && (!"".equals(str)) && (str.contains("/Android/data/com.tencent.mobileqq/qq/video"))) {
      a(str, paramString, false);
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      str = new File(paramString).getParentFile().getAbsolutePath();
    } while (TextUtils.isEmpty(str));
    a(str, paramString);
  }
  
  private boolean j()
  {
    int i3 = 1;
    this.n = true;
    if (Build.VERSION.SDK_INT < 18) {
      this.n = false;
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (!MediaCodecDPC.a())
      {
        this.n = false;
        i1 = 2;
      }
      int i2 = i3;
      if (this.jdField_f_of_type_Int != 10000)
      {
        i2 = i3;
        if (this.jdField_f_of_type_Int != 10002)
        {
          if (this.jdField_f_of_type_Int != 10007) {
            break label222;
          }
          i2 = i3;
        }
      }
      if (i2 == 0)
      {
        this.n = false;
        i1 = 3;
      }
      if (!this.m)
      {
        this.n = false;
        i1 = 4;
      }
      if (BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("sp_mc_crash_times", 0) >= 2)
      {
        this.n = false;
        i1 = 5;
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", Integer.toString(i1));
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "actMediaCodecSupport", this.n, 0L, 0L, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "mediacodec isMediaCodecSupport:" + this.n + ", code:" + i1);
        }
        return this.n;
        label222:
        i2 = 0;
        break;
      }
    }
  }
  
  private void o()
  {
    this.o = false;
  }
  
  private native void setBeautyLevelNative(int paramInt);
  
  private native void setResolutionAlignedByteNative(int paramInt);
  
  private native void setVideoClipSpec(int[] paramArrayOfInt);
  
  public float a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int <= 0)) {
      return 1.333333F;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int * 1.0F / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (a(paramBoolean))
    {
      int i2 = paramInt % 16;
      i1 = paramInt;
      if (i2 > 0) {
        i1 = paramInt + (16 - i2);
      }
    }
    return i1;
  }
  
  public int a(TCTimer.TCTimerCallback paramTCTimerCallback, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i1 = -1;
    if (paramTCTimerCallback == this)
    {
      a().a(paramTCTimerCallback, paramBoolean, paramInt1, paramInt2);
      i1 = 0;
    }
    return i1;
  }
  
  public RMVideoState a()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    RMVideoInitState localRMVideoInitState = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoInitState;
    switch (i1)
    {
    default: 
      return localRMVideoInitState;
    case 2: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoIdleState;
    case 3: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoRecordState;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoPreviewState;
  }
  
  public void a()
  {
    if (this.i) {
      GloableValue.a();
    }
    StorageManager.a().a(this);
    a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    c(paramInt);
    a().a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    PtvFilterUtils.b(true);
    boolean bool;
    if (paramInt1 == 4)
    {
      PtvFilterUtils.a(0);
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "initVideoParams(): ptvMaxTime=" + paramInt2);
      }
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      CodecParam.initFixTimestampSwitch();
      CodecParam.RECORD_MAX_TIME = paramInt2 * 1000;
      CodecParam.mMaxrate = 450000;
      CodecParam.mMinrate = 100000;
      CodecParam.mQmax = 38;
      CodecParam.mQmin = 3;
      CodecParam.mMaxQdiff = 5;
      CodecParam.VIDEO_FPS = 18;
      bool = CameraCompatibleList.a(CameraCompatibleList.l);
      if (QLog.isColorLevel()) {
        QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + bool);
      }
      if (!bool) {
        break label177;
      }
      GloableValue.jdField_c_of_type_Int = 640;
      GloableValue.jdField_d_of_type_Int = 480;
      if (QLog.isColorLevel()) {
        QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = 4;
      AudioCapture.jdField_a_of_type_Int = 4000;
      return;
      label177:
      bool = CameraCompatibleList.a(CameraCompatibleList.s);
      if (QLog.isColorLevel()) {
        QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + bool);
      }
      if (bool)
      {
        GloableValue.jdField_c_of_type_Int = 1024;
        GloableValue.jdField_d_of_type_Int = 768;
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
        }
      }
      else
      {
        GloableValue.jdField_c_of_type_Int = 640;
        GloableValue.jdField_d_of_type_Int = 480;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    k();
    int i1 = 0;
    while (i1 < paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.removeLatestVideo();
      if (paramBoolean) {
        AVCodec.get().removeLastCapture();
      }
      i1 += 1;
    }
    this.jdField_a_of_type_Double = paramInt1;
    RecordManager.a().a().b(paramInt1);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0) < 3) {
      j();
    }
  }
  
  @TargetApi(17)
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong, FilterPreviewContext paramFilterPreviewContext)
  {
    if (!this.n) {
      throw new RuntimeException("HWRecorder is not supported.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder == null) {
      throw new RuntimeException("hwVideoRecorder == null");
    }
    HWEncodeListener localHWEncodeListener;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localHWEncodeListener = (HWEncodeListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    while ((this.l) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig != null)) {
      switch (this.jdField_e_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_e_of_type_Int);
        localHWEncodeListener = null;
        break;
      case 0: 
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig, localHWEncodeListener);
        this.jdField_e_of_type_Int = 1;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        paramFilterPreviewContext.b();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RMVideoStateMgr", 2, "frameAvailableForHwRecorder:: hwRecordingEnabled = " + this.l + " ; hwEncodeConfig = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig);
  }
  
  public void a(int paramInt1, RMVideoClipSpec paramRMVideoClipSpec, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
    case 2: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = paramInt2;
      paramRMVideoClipSpec.jdField_b_of_type_Int = 0;
      return;
    }
    paramRMVideoClipSpec.jdField_a_of_type_Int = (paramRMVideoClipSpec.jdField_e_of_type_Int - paramRMVideoClipSpec.jdField_d_of_type_Int - paramInt2);
    paramRMVideoClipSpec.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      
      label3:
      a().f();
      if (paramInt == 0)
      {
        a(0, HardCodeUtil.a(2131713435), false);
        if (1 == FlowCameraMqqAction.jdField_a_of_type_Int) {
          QzoneVideoBeaconReport.reportVideoEvent(GloableValue.jdField_a_of_type_Long + "", "qzone_video_record", "1", null);
        }
      }
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      break label3;
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.a(paramInt, paramString, paramBoolean);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_f_of_type_Int = paramInt;
    if (paramBoolean) {}
    this.m = false;
    j();
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "mediacodec set businessType:" + this.jdField_f_of_type_Int + ", isSoload:" + paramBoolean + ", isDeviceSupport:" + false + ", isSurpportFilter:" + this.m);
    }
  }
  
  public void a(RMVideoClipSpec paramRMVideoClipSpec, boolean paramBoolean)
  {
    for (int i1 = 1;; i1 = 0)
    {
      try
      {
        boolean bool1 = CameraCompatibleList.d(CameraCompatibleList.e);
        boolean bool2 = CameraCompatibleList.b(CameraCompatibleList.f);
        boolean bool3 = CameraCompatibleList.b(CameraCompatibleList.x);
        if (((bool1) || (bool2) || (bool3)) && (FlowCameraConstant.jdField_a_of_type_Int == 1)) {
          paramRMVideoClipSpec.jdField_b_of_type_Int = (-paramRMVideoClipSpec.jdField_b_of_type_Int);
        }
        this.jdField_b_of_type_ArrayOfInt[0] = paramRMVideoClipSpec.jdField_a_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[1] = paramRMVideoClipSpec.jdField_b_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[2] = paramRMVideoClipSpec.jdField_c_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[3] = paramRMVideoClipSpec.jdField_d_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[4] = paramRMVideoClipSpec.jdField_e_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[5] = paramRMVideoClipSpec.jdField_f_of_type_Int;
        int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
          continue;
        }
        arrayOfInt[6] = i1;
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "setVideoClipSpecdst_width=" + paramRMVideoClipSpec.jdField_e_of_type_Int + "spec.dst_height=" + paramRMVideoClipSpec.jdField_f_of_type_Int + "xoffset=" + paramRMVideoClipSpec.jdField_a_of_type_Int + "y_offset=" + paramRMVideoClipSpec.jdField_b_of_type_Int + "clip_width=" + paramRMVideoClipSpec.jdField_c_of_type_Int + "clip_height" + paramRMVideoClipSpec.jdField_d_of_type_Int);
        }
        setVideoClipSpec(this.jdField_b_of_type_ArrayOfInt);
      }
      catch (UnsatisfiedLinkError paramRMVideoClipSpec)
      {
        for (;;)
        {
          paramRMVideoClipSpec.printStackTrace();
        }
      }
      b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int, paramBoolean);
      return;
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = paramEncodeConfig;
  }
  
  public void a(HWEncodeListener paramHWEncodeListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHWEncodeListener);
  }
  
  public void a(CameraProxy paramCameraProxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = paramCameraProxy;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      paramCameraProxy.a(this);
    }
  }
  
  public void a(PreviewContext paramPreviewContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    k();
    if (QLog.isColorLevel()) {
      QLog.d("" + paramString, 2, "[@][deleteCacheFile] [RMFileEventNotify]stopWatching");
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      FileUtils.a(this.jdField_a_of_type_JavaLangString, false);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4;
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      setResolutionAlignedByteNative(paramInt);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return false;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "initAVCodec");
    }
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      if (l1 == -1L)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("RMVideoStateMgr", 2, "initAVCodec mLongUin is invalid. mLongUin=" + l1);
          bool1 = bool2;
        }
        return bool1;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1 = -1L;
        continue;
        bool2 = bool1;
        try
        {
          VideoEnvironment.loadAVCodecSo();
          bool2 = bool1;
          boolean bool3 = GloableValue.a(l1, paramContext, paramInt1, paramInt2);
          bool1 = bool3;
          bool2 = bool3;
          if (QLog.isColorLevel())
          {
            bool2 = bool3;
            QLog.e("RMVideoStateMgr", 2, "GlobalValue.init:success=" + bool3);
            return bool3;
          }
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          QLog.e("RMVideoStateMgr", 1, "GlobalValue.init fail", paramContext);
        }
      }
    }
    return bool2;
  }
  
  public boolean a(Context paramContext, String paramString, RMViewSTInterface paramRMViewSTInterface)
  {
    c(1);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    GloableValue.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    GloableValue.jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
    this.j = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Double = 0.0D;
    this.h = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface = paramRMViewSTInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.p = true;
    if (!a(paramContext, paramString, GloableValue.jdField_c_of_type_ArrayOfInt[4], GloableValue.jdField_c_of_type_ArrayOfInt[5]))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "initDirs failed");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "rmStateMgr onCreate viewST:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface + "\n videoStateMgr:" + jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioDataCache = new AudioDataCache(GloableValue.a());
      b(1);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = ((RMVideoSwitchCameraPicMgr.ViewBitmapSource)paramContext);
        RecordManager.a().a().addCodecCallback(this);
        RecordManager.a().a().a(this);
        StorageManager.a();
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.t();
          RecordManager.a().a().b();
          RecordManager.a().a();
        }
        RecordManager.a().a().a(this);
        RecordManager.a().a().a();
        if ((this.n) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder == null)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
        }
        return true;
      }
      catch (ClassCastException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      return false;
    }
    catch (RuntimeException paramContext) {}
  }
  
  public int b()
  {
    return CodecParam.RECORD_MAX_TIME * 10 / 1000;
  }
  
  public void b()
  {
    GloableValue.b();
    a().f();
    StorageManager.a().a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    try
    {
      setBeautyLevelNative(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void b(int paramInt1, RMVideoClipSpec paramRMVideoClipSpec, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = paramInt2;
      paramRMVideoClipSpec.jdField_b_of_type_Int = (paramRMVideoClipSpec.jdField_f_of_type_Int - paramRMVideoClipSpec.jdField_c_of_type_Int);
      return;
    case 2: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = paramInt2;
      paramRMVideoClipSpec.jdField_b_of_type_Int = 0;
      return;
    case 4: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = (paramRMVideoClipSpec.jdField_e_of_type_Int - paramRMVideoClipSpec.jdField_d_of_type_Int - paramInt2);
      paramRMVideoClipSpec.jdField_b_of_type_Int = (paramRMVideoClipSpec.jdField_f_of_type_Int - paramRMVideoClipSpec.jdField_c_of_type_Int);
      return;
    case 5: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = (paramRMVideoClipSpec.jdField_e_of_type_Int - paramRMVideoClipSpec.jdField_d_of_type_Int - paramInt2);
      paramRMVideoClipSpec.jdField_b_of_type_Int = 0;
      return;
    }
    paramRMVideoClipSpec.jdField_a_of_type_Int = 0;
    paramRMVideoClipSpec.jdField_b_of_type_Int = (-(paramRMVideoClipSpec.jdField_f_of_type_Int - paramRMVideoClipSpec.jdField_c_of_type_Int) / 2);
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    Toast.makeText(VideoEnvironment.getContext(), "" + paramString, 0).show();
  }
  
  public void b(boolean paramBoolean)
  {
    c(1);
    a().a(paramBoolean);
    a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean)) {
      a().f();
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3;
  }
  
  public boolean b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "mediacodec from:" + paramInt + ", isMediaCodecSupport:" + this.n);
    }
    return this.n;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mActivtiyDestory = true;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      if (QLog.isColorLevel()) {
        QLog.i("RMVideoStateMgr", 2, "rmStateMgr onDestroy viewST:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface + "\n videoStateMgr:" + jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.t();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoInitState.f();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoInitState.g();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoIdleState.f();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoIdleState.g();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
      k();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMFileEventNotify = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture$OnAudioRecordListener = null;
      h();
      this.jdField_f_of_type_Int = 0;
      this.m = false;
      this.n = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = null;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public boolean c(int paramInt)
  {
    int i2 = this.jdField_c_of_type_Int;
    int i1 = i2;
    if (i2 <= 0)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, " checkVideoFrameCount frameCount = " + i1);
    }
    return i1 >= paramInt;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Double = 0.0D;
    RecordManager.a().a().c();
    if (RecordManager.a().a().a.getState() == Thread.State.TERMINATED)
    {
      RecordManager.a().a();
      RecordManager.a().a().a(this);
      RecordManager.a().a().a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy == null) {}
    do
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize))) {
        return false;
      }
    } while (!CameraCompatibleList.e(CameraCompatibleList.C));
    return false;
  }
  
  public void e()
  {
    o();
    this.k = false;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "[enterRecordMode]currentState = " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " mCurrentSegInvalid=" + this.k);
    }
    a().b();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoInitState.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (i1 == 3) {
      a().b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "[exitRecordMode]currentState = " + i1 + " mCurrentSegInvalid=" + this.k);
      }
      return this.k;
      if (i1 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "current = G_STATUS_IDLE ,so do not change state...");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public void f()
  {
    this.l = true;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "startHwRecorder");
    }
  }
  
  boolean f()
  {
    long l1 = StorageManager.a(StorageManager.a().b);
    if (l1 <= StorageManager.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l1 + "StorageManager.FREESPACE_LIMIT_EXIT=" + StorageManager.jdField_a_of_type_Long + " 手机剩余存储空间不足");
      }
      a(0, HardCodeUtil.a(2131713434), false);
      return false;
    }
    return true;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
    }
    this.l = false;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
    }
    this.jdField_e_of_type_Int = 0;
  }
  
  public boolean g()
  {
    if (!this.o) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.o;
        if (!bool) {}
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    return true;
  }
  
  public void h()
  {
    if (this.j) {
      return;
    }
    RecordManager.a().a().b();
    RecordManager.a().a().a(null);
    RecordManager.a().a().removeCodecCallback(this);
    RecordManager.a().a().recycle();
    RecordManager.a().a().a();
    RecordManager.a().a();
    try
    {
      GloableValue.c();
      StorageManager.a().a();
      this.j = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public boolean h()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (this.jdField_d_of_type_Boolean);
  }
  
  public void i()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.o = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public boolean i()
  {
    return this.p;
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMFileEventNotify != null) && (this.jdField_a_of_type_Double > 0.0D)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMFileEventNotify.startWatching();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMFileEventNotify != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMFileEventNotify.stopWatching();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]mIsAudioReady=" + this.jdField_d_of_type_Boolean + " mAI=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (!h())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = new AudioCapture(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]");
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.d();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.b.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioDataCache);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][openAudioRecord]");
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]mIsAudioReady=" + this.jdField_d_of_type_Boolean + " mAI=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (h())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture$OnAudioRecordListener);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.g();
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]");
      }
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      a().a(paramObject, paramInt, paramVarArgs);
    }
    do
    {
      return;
    } while ((!CameraProxy.CameraPreviewObservable.class.isInstance(paramObject)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void onAVCodecEvent(AVCodec.AVCodecCallback arg1, MessageStruct paramMessageStruct)
  {
    a().a(???, paramMessageStruct);
    if (paramMessageStruct.mId == 33554451)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK");
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK ,notifyAll");
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
 * JD-Core Version:    0.7.0.1
 */