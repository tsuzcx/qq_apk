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
  private static RMVideoStateMgr K;
  private static final int[] O = { 850, 780, 650, 480 };
  public static boolean a = false;
  public static boolean l = true;
  public boolean A = true;
  public AudioDataCache B = null;
  public String C;
  public int D = 480;
  public int E = 0;
  public RMVideoStateMgr.ForceReleaseLockOnPause F = new RMVideoStateMgr.ForceReleaseLockOnPause();
  public AtomicInteger G = new AtomicInteger(1);
  public AtomicBoolean H = new AtomicBoolean(false);
  public Handler I = new Handler(Looper.getMainLooper());
  public RMVideoClipSpec J = new RMVideoClipSpec();
  private boolean L = false;
  private boolean M = false;
  private int N = 1;
  private HWVideoRecorder P;
  private volatile boolean Q;
  private int R;
  private int S = 0;
  private boolean T = false;
  private boolean U = false;
  private int[] V = new int[8];
  private volatile boolean W = false;
  private Object X = new Object();
  private boolean Y = true;
  public boolean b = false;
  public long c = 0L;
  public AtomicInteger d = new AtomicInteger(0);
  public final RMVideoThumbGenMgr e = new RMVideoThumbGenMgr();
  public final RMVideoSwitchCameraPicMgr f = new RMVideoSwitchCameraPicMgr();
  public RMFileEventNotify g = null;
  final RMVideoInitState h = new RMVideoInitState();
  final RMVideoIdleState i = new RMVideoIdleState();
  final RMVideoRecordState j = new RMVideoRecordState();
  final RMVideoPreviewState k = new RMVideoPreviewState();
  public CameraProxy m;
  public double n;
  public PreviewContext o;
  public AudioCapture p;
  public boolean q = false;
  public boolean r = false;
  public String s;
  public AudioCapture.OnAudioRecordListener t;
  public Context u;
  public RMViewSTInterface v;
  public int w = 0;
  public boolean x = true;
  public boolean y = false;
  public boolean z = false;
  
  public static RMVideoStateMgr a()
  {
    try
    {
      if (K == null) {
        K = new RMVideoStateMgr();
      }
      RMVideoStateMgr localRMVideoStateMgr = K;
      return localRMVideoStateMgr;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = GloableValue.j.length / 2;
    int i1 = 0;
    int[] arrayOfInt;
    while (i1 < i2)
    {
      arrayOfInt = GloableValue.j;
      int i3 = i1 * 2;
      int i4 = a(arrayOfInt[(i3 + 1)], paramBoolean);
      if ((GloableValue.j[i3] == paramInt1) && (i4 == paramInt2)) {
        break label74;
      }
      i1 += 1;
    }
    i1 = -1;
    label74:
    if (i1 >= 0)
    {
      arrayOfInt = O;
      if (arrayOfInt[i1] != this.D) {
        this.D = arrayOfInt[i1];
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
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearVideoDataFile:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("RMVideoStateMgr", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = GloableValue.c();
    if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).contains("/Android/data/com.tencent.mobileqq/qq/video"))) {
      a((String)localObject, paramString, false);
    }
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
  
  private void e(int paramInt)
  {
    this.G.getAndSet(paramInt);
  }
  
  public static boolean e(boolean paramBoolean)
  {
    return (HwEnvData.a()) || (paramBoolean);
  }
  
  private native void setBeautyLevelNative(int paramInt);
  
  private native void setResolutionAlignedByteNative(int paramInt);
  
  private native void setVideoClipSpec(int[] paramArrayOfInt);
  
  private void y()
  {
    this.W = false;
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (e(paramBoolean))
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
      d().a(paramTCTimerCallback, paramBoolean, paramInt1, paramInt2);
      return 0;
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    e(paramInt);
    d().a();
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
        GloableValue.f = 640;
        GloableValue.g = 480;
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
          GloableValue.f = 1024;
          GloableValue.g = 768;
          if (QLog.isColorLevel()) {
            QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
          }
        }
        else
        {
          GloableValue.f = 640;
          GloableValue.g = 480;
        }
      }
      this.N = 4;
      AudioCapture.b = 4000;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      
      label3:
      d().g();
      if (paramInt == 0) {
        a(0, HardCodeUtil.a(2131910956), false);
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
    RMViewSTInterface localRMViewSTInterface = this.v;
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
      boolean bool3 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(CameraCompatibleConstants.y);
      if (((bool1) || (bool2) || (bool3)) && (FlowCameraConstant.b == 1)) {
        paramRMVideoClipSpec.b = (-paramRMVideoClipSpec.b);
      }
      Object localObject = this.V;
      int i2 = paramRMVideoClipSpec.a;
      int i1 = 0;
      localObject[0] = i2;
      this.V[1] = paramRMVideoClipSpec.b;
      this.V[2] = paramRMVideoClipSpec.c;
      this.V[3] = paramRMVideoClipSpec.d;
      this.V[4] = paramRMVideoClipSpec.e;
      this.V[5] = paramRMVideoClipSpec.f;
      localObject = this.V;
      if (FlowCameraConstant.b == 1) {
        i1 = 1;
      }
      localObject[6] = i1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setVideoClipSpecdst_width=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.e);
        ((StringBuilder)localObject).append("spec.dst_height=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.f);
        ((StringBuilder)localObject).append("xoffset=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.a);
        ((StringBuilder)localObject).append("y_offset=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.b);
        ((StringBuilder)localObject).append("clip_width=");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.c);
        ((StringBuilder)localObject).append("clip_height");
        ((StringBuilder)localObject).append(paramRMVideoClipSpec.d);
        QLog.i("RMVideoStateMgr", 2, ((StringBuilder)localObject).toString());
      }
      setVideoClipSpec(this.V);
    }
    catch (UnsatisfiedLinkError paramRMVideoClipSpec)
    {
      paramRMVideoClipSpec.printStackTrace();
    }
    a(this.J.e, this.J.f, paramBoolean);
  }
  
  public void a(CameraProxy paramCameraProxy)
  {
    this.m = paramCameraProxy;
    if (this.m != null) {
      paramCameraProxy.a(this);
    }
  }
  
  public void a(PreviewContext paramPreviewContext)
  {
    CameraProxy localCameraProxy = this.m;
    if (localCameraProxy != null) {
      localCameraProxy.a = this.N;
    }
    this.o = paramPreviewContext;
    this.o.notifyFirstFrame = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.I.post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    r();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString);
      QLog.d(localStringBuilder.toString(), 2, "[@][deleteCacheFile] [RMFileEventNotify]stopWatching");
    }
    paramString = this.s;
    if (paramString != null) {
      FileUtils.delete(paramString, false);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.M = paramBoolean;
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
      label28:
      boolean bool2;
      boolean bool1;
      boolean bool3;
      break label28;
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
    e(1);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    GloableValue.d = localDisplayMetrics.widthPixels;
    GloableValue.e = localDisplayMetrics.heightPixels;
    this.L = false;
    this.u = paramContext;
    this.n = 0.0D;
    this.z = false;
    this.o = null;
    this.q = false;
    this.r = false;
    this.p = null;
    this.v = paramRMViewSTInterface;
    this.H.set(false);
    this.Y = true;
    if (!a(paramContext, paramString, GloableValue.j[4], GloableValue.j[5]))
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
      paramString.append(this.v);
      paramString.append("\n videoStateMgr:");
      paramString.append(K);
      QLog.i("RMVideoStateMgr", 2, paramString.toString());
    }
    try
    {
      this.B = new AudioDataCache(GloableValue.c());
      b(1);
      try
      {
        this.f.a = ((RMVideoSwitchCameraPicMgr.ViewBitmapSource)paramContext);
      }
      catch (ClassCastException paramContext)
      {
        paramContext.printStackTrace();
      }
      RecordManager.a().b().addCodecCallback(this);
      RecordManager.a().c().a(this);
      StorageManager.a();
      if (this.d.getAndIncrement() > 0)
      {
        paramContext = this.v;
        if (paramContext != null)
        {
          paramContext.h();
          RecordManager.a().d().c();
          RecordManager.a().e();
        }
      }
      RecordManager.a().d().a(this);
      RecordManager.a().d().b();
      if ((this.U) && (this.P == null)) {
        this.P = new HWVideoRecorder();
      }
      return true;
    }
    catch (RuntimeException paramContext) {}
    return false;
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
    e(1);
    d().a(paramBoolean);
    d().a();
    if ((this.F.b) && (this.F.a)) {
      d().g();
    }
  }
  
  public boolean b()
  {
    return this.G.get() == 4;
  }
  
  public void c(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public boolean c()
  {
    return this.G.get() == 3;
  }
  
  public boolean c(int paramInt)
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
  
  public RMVideoState d()
  {
    int i1 = this.G.get();
    RMVideoInitState localRMVideoInitState = this.h;
    if (i1 != 2)
    {
      if (i1 != 3)
      {
        if (i1 != 4) {
          return localRMVideoInitState;
        }
        return this.k;
      }
      return this.j;
    }
    return this.i;
  }
  
  public void d(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  public boolean d(int paramInt)
  {
    int i2 = this.E;
    int i1 = i2;
    Object localObject;
    if (i2 <= 0)
    {
      localObject = this.o;
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
  
  public void e()
  {
    if (this.A) {
      GloableValue.a();
    }
    StorageManager.a().a(this);
    d().a();
    if (this.o != null)
    {
      localObject = this.m;
      if ((localObject != null) && (!((CameraProxy)localObject).b)) {
        this.o.notifyFirstFrame = true;
      }
    }
    Object localObject = this.F;
    ((RMVideoStateMgr.ForceReleaseLockOnPause)localObject).b = false;
    ((RMVideoStateMgr.ForceReleaseLockOnPause)localObject).a = false;
  }
  
  public void f()
  {
    GloableValue.b();
    d().g();
    StorageManager.a().a(null);
    this.F.a = true;
  }
  
  public void f(boolean paramBoolean)
  {
    this.h.f = paramBoolean;
  }
  
  public void g()
  {
    if (this.d.decrementAndGet() == 0)
    {
      localObject = this.o;
      if (localObject != null)
      {
        ((PreviewContext)localObject).mActivtiyDestory = true;
        this.o = null;
      }
      this.u = null;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("rmStateMgr onDestroy viewST:");
        ((StringBuilder)localObject).append(this.v);
        ((StringBuilder)localObject).append("\n videoStateMgr:");
        ((StringBuilder)localObject).append(K);
        QLog.i("RMVideoStateMgr", 2, ((StringBuilder)localObject).toString());
      }
      this.v.h();
      this.v = null;
      this.h.g();
      this.h.h();
      this.i.g();
      this.i.h();
      this.p = null;
      r();
      this.g = null;
      this.f.a = null;
      this.t = null;
      l();
      this.S = 0;
      this.T = false;
      this.U = false;
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((CameraProxy)localObject).q = null;
    }
    this.m = null;
  }
  
  public void h()
  {
    this.n = 0.0D;
    RecordManager.a().d().d();
    if (RecordManager.a().d().a.getState() == Thread.State.TERMINATED)
    {
      RecordManager.a().e();
      RecordManager.a().d().a(this);
      RecordManager.a().d().b();
    }
  }
  
  public void i()
  {
    y();
    this.M = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[enterRecordMode]currentState = ");
      localStringBuilder.append(this.G.get());
      localStringBuilder.append(" mCurrentSegInvalid=");
      localStringBuilder.append(this.M);
      QLog.e("RMVideoStateMgr", 2, localStringBuilder.toString());
    }
    d().b();
  }
  
  public void j()
  {
    this.Q = true;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "startHwRecorder");
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
    }
    this.Q = false;
    HWVideoRecorder localHWVideoRecorder = this.P;
    if (localHWVideoRecorder != null) {
      localHWVideoRecorder.b();
    }
    this.R = 0;
  }
  
  public void l()
  {
    if (this.L) {
      return;
    }
    RecordManager.a().d().c();
    RecordManager.a().d().a(null);
    RecordManager.a().b().removeCodecCallback(this);
    RecordManager.a().b().recycle();
    RecordManager.a().c().b();
    RecordManager.a().e();
    try
    {
      GloableValue.d();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    StorageManager.a().b();
    this.L = true;
  }
  
  public boolean m()
  {
    int i1 = this.G.get();
    if (i1 == 3)
    {
      d().b();
    }
    else if (i1 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "current = G_STATUS_IDLE ,so do not change state...");
      }
      this.F.b = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[exitRecordMode]currentState = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" mCurrentSegInvalid=");
      localStringBuilder.append(this.M);
      QLog.e("RMVideoStateMgr", 2, localStringBuilder.toString());
    }
    return this.M;
  }
  
  boolean n()
  {
    long l1 = StorageManager.a(StorageManager.a().e);
    if (l1 <= StorageManager.a)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=");
        localStringBuilder.append(l1);
        localStringBuilder.append("StorageManager.FREESPACE_LIMIT_EXIT=");
        localStringBuilder.append(StorageManager.a);
        localStringBuilder.append(" 手机剩余存储空间不足");
        QLog.d("RMVideoStateMgr", 2, localStringBuilder.toString());
      }
      a(0, HardCodeUtil.a(2131910955), false);
      return false;
    }
    return true;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 11)
    {
      d().a(paramObject, paramInt, paramVarArgs);
      return;
    }
    if (CameraProxy.CameraPreviewObservable.class.isInstance(paramObject))
    {
      paramObject = this.o;
      if (paramObject != null) {
        paramObject.notifyFirstFrame = true;
      }
    }
  }
  
  public boolean o()
  {
    if (!this.W) {
      synchronized (this.X)
      {
        boolean bool = this.W;
        if (!bool) {
          try
          {
            this.X.wait(1000L);
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
  
  public void onAVCodecEvent(AVCodec.AVCodecCallback arg1, MessageStruct paramMessageStruct)
  {
    d().a(???, paramMessageStruct);
    if (paramMessageStruct.mId == 33554451)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK");
      }
      synchronized (this.H)
      {
        this.H.set(true);
        this.H.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK ,notifyAll");
        }
        return;
      }
    }
  }
  
  public void p()
  {
    synchronized (this.X)
    {
      this.W = true;
      this.X.notifyAll();
      return;
    }
  }
  
  public void q()
  {
    RMFileEventNotify localRMFileEventNotify = this.g;
    if ((localRMFileEventNotify != null) && (this.n > 0.0D)) {
      localRMFileEventNotify.startWatching();
    }
  }
  
  public void r()
  {
    RMFileEventNotify localRMFileEventNotify = this.g;
    if (localRMFileEventNotify != null) {
      localRMFileEventNotify.stopWatching();
    }
  }
  
  public void s()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@][initAudioRecord]mIsAudioReady=");
      localStringBuilder.append(this.q);
      localStringBuilder.append(" mAI=");
      localStringBuilder.append(this.p);
      QLog.d("RMVideoStateMgr", 2, localStringBuilder.toString());
    }
    if (!v())
    {
      this.p = new AudioCapture(this.u);
      this.p.a(this);
      this.p.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]");
    }
  }
  
  public void t()
  {
    AudioCapture localAudioCapture = this.p;
    if (localAudioCapture != null) {
      localAudioCapture.e();
    }
    localAudioCapture = this.p;
    if (localAudioCapture != null)
    {
      localAudioCapture.f();
      this.p.v.getAndSet(this.B);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][openAudioRecord]");
    }
  }
  
  public void u()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@][closeAudioRecord]mIsAudioReady=");
      localStringBuilder.append(this.q);
      localStringBuilder.append(" mAI=");
      localStringBuilder.append(this.p);
      QLog.d("RMVideoStateMgr", 2, localStringBuilder.toString());
    }
    if (v())
    {
      this.p.b(this.t);
      this.p.i();
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]");
      }
    }
    this.q = false;
    this.p = null;
    this.r = false;
  }
  
  public boolean v()
  {
    return (this.p != null) && (this.q);
  }
  
  public boolean w()
  {
    return this.Y;
  }
  
  public boolean x()
  {
    return this.U;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
 * JD-Core Version:    0.7.0.1
 */