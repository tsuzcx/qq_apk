package com.tencent.mobileqq.activity.richmedia.state;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.common.TCTimer;
import com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter.ErrorHandleCallback;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.OnAudioRecordListener;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.mobileqq.shortvideo.util.AudioDataCache;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager.OnSdCardChangedListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class RMVideoStateMgr
  implements AVCodec.AVCodecCallback, TCTimer.TCTimerCallback, ErrorCenter.ErrorHandleCallback, AudioCapture.OnAudioRecordListener, StorageManager.OnSdCardChangedListener
{
  private static RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  public static boolean a = false;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 850, 780, 650, 480 };
  public static boolean c = true;
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
  public AudioCapture.OnAudioRecordListener a;
  public AudioCapture a;
  public CameraProxy a;
  public PreviewContext a;
  public AudioDataCache a;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
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
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = GloableValue.jdField_c_of_type_ArrayOfInt.length / 2;
    int i1 = 0;
    int[] arrayOfInt;
    while (i1 < i2)
    {
      arrayOfInt = GloableValue.jdField_c_of_type_ArrayOfInt;
      int i3 = i1 * 2;
      int i4 = a(arrayOfInt[(i3 + 1)], paramBoolean);
      if ((GloableValue.jdField_c_of_type_ArrayOfInt[i3] == paramInt1) && (i4 == paramInt2)) {
        break label74;
      }
      i1 += 1;
    }
    i1 = -1;
    label74:
    if (i1 >= 0)
    {
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
      if (arrayOfInt[i1] != this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = arrayOfInt[i1];
      }
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString1.trim().length() == 0) {
        return;
      }
      paramString1 = new File(paramString1);
      paramString2 = new File(paramString2);
      if (paramString1.exists())
      {
        if (!paramString2.exists()) {
          return;
        }
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteDirectoryByTime rootDir:");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(", currentDirectory:");
          ((StringBuilder)localObject).append(paramString2);
          QLog.i("RMVideoStateMgr", 2, ((StringBuilder)localObject).toString());
        }
        paramString2 = paramString2.getName();
        paramString1 = paramString1.listFiles();
        if ((paramString1 != null) && (paramString1.length > 0) && (!TextUtils.isEmpty(paramString2)))
        {
          int i1 = 0;
          while (i1 < paramString1.length)
          {
            localObject = paramString1[i1].getName();
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).compareTo(paramString2) < 0)) {
              FileUtils.deleteDirectory(paramString1[i1].getAbsolutePath());
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 != null)
    {
      if (paramString1.trim().length() == 0) {
        return;
      }
      paramString1 = new File(paramString1);
      if (!paramString1.exists()) {
        return;
      }
      File[] arrayOfFile = paramString1.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i1 = 0;
        while (i1 < arrayOfFile.length)
        {
          if ((paramString2 == null) || ("".equals(paramString2)) || (!arrayOfFile[i1].getAbsolutePath().equals(paramString2))) {
            if (arrayOfFile[i1].isDirectory()) {
              a(arrayOfFile[i1].getAbsolutePath(), paramString2, true);
            } else {
              arrayOfFile[i1].delete();
            }
          }
          i1 += 1;
        }
      }
      if (paramBoolean) {
        paramString1.delete();
      }
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    return (HwEnvData.a()) || (paramBoolean);
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearVideoDataFile:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("RMVideoStateMgr", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = GloableValue.a();
    if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).contains("/Android/data/com.tencent.mobileqq/qq/video"))) {
      a((String)localObject, paramString, false);
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = new File(paramString).getParentFile().getAbsolutePath();
    if (!TextUtils.isEmpty(str)) {
      a(str, paramString);
    }
  }
  
  private void o()
  {
    this.o = false;
  }
  
  private native void setBeautyLevelNative(int paramInt);
  
  private native void setResolutionAlignedByteNative(int paramInt);
  
  private native void setVideoClipSpec(int[] paramArrayOfInt);
  
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
    if (paramTCTimerCallback == this)
    {
      a().a(paramTCTimerCallback, paramBoolean, paramInt1, paramInt2);
      return 0;
    }
    return -1;
  }
  
  public RMVideoState a()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    RMVideoInitState localRMVideoInitState = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoInitState;
    if (i1 != 2)
    {
      if (i1 != 3)
      {
        if (i1 != 4) {
          return localRMVideoInitState;
        }
        return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoPreviewState;
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoRecordState;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoIdleState;
  }
  
  public void a()
  {
    if (this.i) {
      GloableValue.a();
    }
    StorageManager.a().a(this);
    a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
      if ((localObject != null) && (!((CameraProxy)localObject).jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause;
    ((RMVideoStateMgr.ForceReleaseLockOnPause)localObject).jdField_b_of_type_Boolean = false;
    ((RMVideoStateMgr.ForceReleaseLockOnPause)localObject).jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    c(paramInt);
    a().a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ((IPtvFilterUtil)QRoute.api(IPtvFilterUtil.class)).setSupportBeautySafety(true);
    if (paramInt1 == 4)
    {
      ((IPtvFilterUtil)QRoute.api(IPtvFilterUtil.class)).setBeautyKindSafety(0);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initVideoParams(): ptvMaxTime=");
        localStringBuilder.append(paramInt2);
        QLog.d("RMVideoStateMgr", 2, localStringBuilder.toString());
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
      boolean bool = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeature(CameraCompatibleConstants.l);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isFoundProductFeature:need640Black=");
        localStringBuilder.append(bool);
        QLog.i("RMVideoStateMgr", 2, localStringBuilder.toString());
      }
      if (bool)
      {
        GloableValue.jdField_c_of_type_Int = 640;
        GloableValue.jdField_d_of_type_Int = 480;
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
        }
      }
      else
      {
        bool = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeature(CameraCompatibleConstants.s);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isFoundProductFeature:need1024Black=");
          localStringBuilder.append(bool);
          QLog.i("RMVideoStateMgr", 2, localStringBuilder.toString());
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
      this.jdField_d_of_type_Int = 4;
      AudioCapture.jdField_a_of_type_Int = 4000;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      
      label3:
      a().f();
      if (paramInt == 0) {
        a(0, HardCodeUtil.a(2131713403), false);
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
    RMViewSTInterface localRMViewSTInterface = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface;
    if (localRMViewSTInterface != null) {
      localRMViewSTInterface.a(paramInt, paramString, paramBoolean);
    }
  }
  
  public void a(RMVideoClipSpec paramRMVideoClipSpec, boolean paramBoolean)
  {
    try
    {
      boolean bool1 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.e);
      boolean bool2 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(CameraCompatibleConstants.f);
      boolean bool3 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(CameraCompatibleConstants.x);
      if (((bool1) || (bool2) || (bool3)) && (FlowCameraConstant.jdField_a_of_type_Int == 1)) {
        paramRMVideoClipSpec.jdField_b_of_type_Int = (-paramRMVideoClipSpec.jdField_b_of_type_Int);
      }
      Object localObject = this.jdField_b_of_type_ArrayOfInt;
      int i2 = paramRMVideoClipSpec.jdField_a_of_type_Int;
      int i1 = 0;
      localObject[0] = i2;
      this.jdField_b_of_type_ArrayOfInt[1] = paramRMVideoClipSpec.jdField_b_of_type_Int;
      this.jdField_b_of_type_ArrayOfInt[2] = paramRMVideoClipSpec.jdField_c_of_type_Int;
      this.jdField_b_of_type_ArrayOfInt[3] = paramRMVideoClipSpec.jdField_d_of_type_Int;
      this.jdField_b_of_type_ArrayOfInt[4] = paramRMVideoClipSpec.jdField_e_of_type_Int;
      this.jdField_b_of_type_ArrayOfInt[5] = paramRMVideoClipSpec.jdField_f_of_type_Int;
      localObject = this.jdField_b_of_type_ArrayOfInt;
      if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
        i1 = 1;
      }
      localObject[6] = i1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setVideoClipSpecdst_width=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.jdField_e_of_type_Int);
        ((StringBuilder)localObject).append("spec.dst_height=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.jdField_f_of_type_Int);
        ((StringBuilder)localObject).append("xoffset=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("y_offset=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append("clip_width=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append("clip_height");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.jdField_d_of_type_Int);
        QLog.i("RMVideoStateMgr", 2, ((StringBuilder)localObject).toString());
      }
      setVideoClipSpec(this.jdField_b_of_type_ArrayOfInt);
    }
    catch (UnsatisfiedLinkError paramRMVideoClipSpec)
    {
      paramRMVideoClipSpec.printStackTrace();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int, paramBoolean);
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
    CameraProxy localCameraProxy = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
    if (localCameraProxy != null) {
      localCameraProxy.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString);
      QLog.d(localStringBuilder.toString(), 2, "[@][deleteCacheFile] [RMFileEventNotify]stopWatching");
    }
    paramString = this.jdField_a_of_type_JavaLangString;
    if (paramString != null) {
      FileUtils.delete(paramString, false);
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
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label7:
      break label7;
    }
    return false;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "initAVCodec");
    }
    try
    {
      l1 = Long.valueOf(paramString).longValue();
    }
    catch (NumberFormatException paramString)
    {
      long l1;
      label27:
      boolean bool2;
      boolean bool1;
      boolean bool3;
      break label27;
    }
    l1 = -1L;
    bool2 = false;
    if (l1 == -1L)
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("initAVCodec mLongUin is invalid. mLongUin=");
        paramContext.append(l1);
        QLog.e("RMVideoStateMgr", 2, paramContext.toString());
      }
      return false;
    }
    bool1 = bool2;
    try
    {
      VideoEnvironment.loadAVCodecSo();
      bool1 = bool2;
      bool2 = GloableValue.a(l1, paramContext, paramInt1, paramInt2);
      bool1 = bool2;
      bool3 = bool2;
      if (QLog.isColorLevel())
      {
        bool1 = bool2;
        paramContext = new StringBuilder();
        bool1 = bool2;
        paramContext.append("GlobalValue.init:success=");
        bool1 = bool2;
        paramContext.append(bool2);
        bool1 = bool2;
        QLog.e("RMVideoStateMgr", 2, paramContext.toString());
        return bool2;
      }
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      QLog.e("RMVideoStateMgr", 1, "GlobalValue.init fail", paramContext);
      bool3 = bool1;
    }
    return bool3;
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
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("rmStateMgr onCreate viewST:");
      paramString.append(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface);
      paramString.append("\n videoStateMgr:");
      paramString.append(jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
      QLog.i("RMVideoStateMgr", 2, paramString.toString());
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioDataCache = new AudioDataCache(GloableValue.a());
      b(1);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = ((RMVideoSwitchCameraPicMgr.ViewBitmapSource)paramContext);
      }
      catch (ClassCastException paramContext)
      {
        paramContext.printStackTrace();
      }
      RecordManager.a().a().addCodecCallback(this);
      RecordManager.a().a().a(this);
      StorageManager.a();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() > 0)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface;
        if (paramContext != null)
        {
          paramContext.h();
          RecordManager.a().a().b();
          RecordManager.a().a();
        }
      }
      RecordManager.a().a().a(this);
      RecordManager.a().a().a();
      if ((this.n) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder == null)) {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
      }
      return true;
    }
    catch (RuntimeException paramContext) {}
    return false;
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
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    Context localContext = VideoEnvironment.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    Toast.makeText(localContext, localStringBuilder.toString(), 0).show();
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
    int i2 = this.jdField_c_of_type_Int;
    int i1 = i2;
    Object localObject;
    if (i2 <= 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      i1 = i2;
      if (localObject != null) {
        i1 = ((PreviewContext)localObject).getFrameIndex();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" checkVideoFrameCount frameCount = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("RMVideoStateMgr", 2, ((StringBuilder)localObject).toString());
    }
    return i1 >= paramInt;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      if (localObject != null)
      {
        ((PreviewContext)localObject).mActivtiyDestory = true;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("rmStateMgr onDestroy viewST:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface);
        ((StringBuilder)localObject).append("\n videoStateMgr:");
        ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
        QLog.i("RMVideoStateMgr", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.h();
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
    if (localObject != null) {
      ((CameraProxy)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = null;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (i1 == 3)
    {
      a().b();
    }
    else if (i1 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "current = G_STATUS_IDLE ,so do not change state...");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_b_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[exitRecordMode]currentState = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" mCurrentSegInvalid=");
      localStringBuilder.append(this.k);
      QLog.e("RMVideoStateMgr", 2, localStringBuilder.toString());
    }
    return this.k;
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
  
  boolean d()
  {
    long l1 = StorageManager.a(StorageManager.a().b);
    if (l1 <= StorageManager.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=");
        localStringBuilder.append(l1);
        localStringBuilder.append("StorageManager.FREESPACE_LIMIT_EXIT=");
        localStringBuilder.append(StorageManager.jdField_a_of_type_Long);
        localStringBuilder.append(" 手机剩余存储空间不足");
        QLog.d("RMVideoStateMgr", 2, localStringBuilder.toString());
      }
      a(0, HardCodeUtil.a(2131713402), false);
      return false;
    }
    return true;
  }
  
  public void e()
  {
    o();
    this.k = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[enterRecordMode]currentState = ");
      localStringBuilder.append(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      localStringBuilder.append(" mCurrentSegInvalid=");
      localStringBuilder.append(this.k);
      QLog.e("RMVideoStateMgr", 2, localStringBuilder.toString());
    }
    a().b();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoInitState.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    if (!this.o) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.o;
        if (!bool) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait(1000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    return true;
  }
  
  public void f()
  {
    this.l = true;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "startHwRecorder");
    }
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (this.jdField_d_of_type_Boolean);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
    }
    this.l = false;
    HWVideoRecorder localHWVideoRecorder = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder;
    if (localHWVideoRecorder != null) {
      localHWVideoRecorder.b();
    }
    this.jdField_e_of_type_Int = 0;
  }
  
  public boolean g()
  {
    return this.p;
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
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    StorageManager.a().a();
    this.j = true;
  }
  
  public boolean h()
  {
    return this.n;
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
  
  public void j()
  {
    RMFileEventNotify localRMFileEventNotify = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMFileEventNotify;
    if ((localRMFileEventNotify != null) && (this.jdField_a_of_type_Double > 0.0D)) {
      localRMFileEventNotify.startWatching();
    }
  }
  
  public void k()
  {
    RMFileEventNotify localRMFileEventNotify = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMFileEventNotify;
    if (localRMFileEventNotify != null) {
      localRMFileEventNotify.stopWatching();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@][initAudioRecord]mIsAudioReady=");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      localStringBuilder.append(" mAI=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
      QLog.d("RMVideoStateMgr", 2, localStringBuilder.toString());
    }
    if (!f())
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
    AudioCapture localAudioCapture = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture;
    if (localAudioCapture != null) {
      localAudioCapture.c();
    }
    localAudioCapture = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture;
    if (localAudioCapture != null)
    {
      localAudioCapture.d();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.b.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioDataCache);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][openAudioRecord]");
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@][closeAudioRecord]mIsAudioReady=");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      localStringBuilder.append(" mAI=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
      QLog.d("RMVideoStateMgr", 2, localStringBuilder.toString());
    }
    if (f())
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
    if (paramInt != 11)
    {
      a().a(paramObject, paramInt, paramVarArgs);
      return;
    }
    if (CameraProxy.CameraPreviewObservable.class.isInstance(paramObject))
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      if (paramObject != null) {
        paramObject.notifyFirstFrame = true;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
 * JD-Core Version:    0.7.0.1
 */