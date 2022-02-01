package com.tencent.mobileqq.ar.model;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRecognition.RecognitionResult;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerCallBack;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMarkerTrackInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderTrackInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.GeneralARResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingCardResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimARResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderableInfo;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager.ARSensorTrackCallback;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.DrawView2.FaceData;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.ARCloudControlCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyResult;
import com.tencent.mobileqq.ar.arengine.ARCloudPreOcrResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult;
import com.tencent.mobileqq.ar.arengine.ARCloudSceneRecogResult;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.arengine.AREngineCallbackFromUI;
import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.mobileqq.ar.arengine.ARLocalControl.ARLocalRecogCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalRecogResultBase;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.ARMarkerResourceCallback;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.ar.keying.KeyingParams;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class QQARSession
  extends AbstractSession
  implements Camera.PreviewCallback, ARRenderManagerCallBack, SensorTrackManager.ARSensorTrackCallback, ARCloudControl.ARCloudControlCallback, AREngineCallbackFromUI, ARLocalControl.ARLocalRecogCallback, ARMarkerResourceManager.ARMarkerResourceCallback
{
  public static boolean g = false;
  private static QQARSession q;
  private static boolean r = true;
  private ArConfigInfo A = null;
  private AREngineCallback B = null;
  private boolean C = false;
  private long D = 0L;
  private long E = 0L;
  private boolean F = false;
  private long G = 0L;
  private long H = 0L;
  private int I = 5;
  private int J = 5;
  private int K = 5;
  private int L = 5;
  private int M = 5;
  private int N = 5;
  private SensorTrackManager O = null;
  private boolean P = true;
  private ARNativeBridge Q = null;
  private UniformGLRenderManager R = null;
  private ARCloudControl S = null;
  private ARMarkerResourceManager T = null;
  private ArrayList<ArCloudConfigInfo> U = null;
  private HandlerThread V = null;
  private Handler W = null;
  private Object X = new Object();
  private int Y = 0;
  private int Z = 0;
  private long aA = 0L;
  private long aB = 0L;
  private int aC = 0;
  private long aD = 0L;
  private long aE = 0L;
  private boolean aF;
  private boolean aG;
  private boolean aH = true;
  private boolean aI = true;
  private boolean aJ = true;
  private long aK;
  private boolean aL;
  private String aM = "0";
  private ARTransferDoorLogicManager aN;
  private long aO = 0L;
  private int aP = 0;
  private long aQ = 0L;
  private long aR = 0L;
  private volatile int aS = 0;
  private int aa = 0;
  private int ab = 0;
  private int ac = 17;
  private Runnable ad = null;
  private ArrayList<Runnable> ae = null;
  private ARLocalMarkerRecogResult af = null;
  private ARLocalMarkerRecogResult ag = null;
  private ARLocalFaceRecogResult ah = null;
  private ARLocalFaceRecogResult ai = null;
  private ARCloudRecogResult aj = null;
  private boolean ak = false;
  private boolean al = false;
  private ARMIGObjectClassifyResult am = null;
  private boolean an = false;
  private volatile boolean ao = false;
  private long ap = 0L;
  private ArCloudConfigInfo aq = null;
  private ArCloudConfigInfo ar = null;
  private long as = 0L;
  private long at = 0L;
  private long au = 0L;
  private long av = 0L;
  private boolean aw = false;
  private long ax = 0L;
  private long ay = 0L;
  private int az = 0;
  public ARLocalControl h = null;
  public ArCloudConfigInfo i = null;
  public boolean j = true;
  public boolean k = false;
  public long l = 4096L;
  ARScanStarFaceConfigInfo m = null;
  boolean n = false;
  ArCloudConfigInfo o;
  int p;
  private final boolean s = true;
  private final long t = 1L;
  private final long u = 2179L;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private volatile boolean y;
  private ARCommonConfigInfo z = null;
  
  public QQARSession()
  {
    this.b = 1;
    r = false;
    CameraProxy.a().b(this);
  }
  
  private boolean H()
  {
    QLog.i("AREngine_QQARSession", 2, "startRenderManager.");
    UniformGLRenderManager localUniformGLRenderManager = this.R;
    if (localUniformGLRenderManager != null)
    {
      localUniformGLRenderManager.a(0, this.Q);
      this.R.a(8, this.aN);
      return true;
    }
    return false;
  }
  
  private boolean I()
  {
    QLog.i("AREngine_QQARSession", 2, "startLocalRecog.");
    ARLocalControl localARLocalControl = this.h;
    boolean bool = false;
    if (localARLocalControl != null)
    {
      if (!localARLocalControl.a(this.e, this.G, this.aa, this.ab, this.A, this.U, this.m, this)) {
        return false;
      }
      bool = this.h.a();
    }
    return bool;
  }
  
  private boolean J()
  {
    QLog.i("AREngine_QQARSession", 2, "startCloudRecog.");
    ARCloudControl localARCloudControl = this.S;
    if (localARCloudControl != null)
    {
      localARCloudControl.a(this.aa, this.ab, this.ac);
      this.S.c();
      return true;
    }
    return false;
  }
  
  private boolean K()
  {
    QLog.i("AREngine_QQARSession", 2, "stopLocalRecog.");
    ARLocalControl localARLocalControl = this.h;
    if (localARLocalControl != null) {
      localARLocalControl.b();
    }
    return true;
  }
  
  private boolean L()
  {
    QLog.i("AREngine_QQARSession", 2, "stopCloudRecog.");
    ARCloudControl localARCloudControl = this.S;
    if (localARCloudControl != null) {
      localARCloudControl.f();
    }
    return true;
  }
  
  private void M()
  {
    QLog.d("AREngine_QQARSession", 1, "pauseCloudRecog.");
    ARCloudControl localARCloudControl = this.S;
    if (localARCloudControl != null) {
      localARCloudControl.e();
    }
  }
  
  private void N()
  {
    QLog.d("AREngine_QQARSession", 1, "resumeCloudRecog.");
    if (this.aC == 0) {
      this.aD = 0L;
    }
    this.aj = null;
    this.ak = false;
    ARCloudControl localARCloudControl = this.S;
    if (localARCloudControl != null) {
      localARCloudControl.d();
    }
  }
  
  private void O()
  {
    ??? = this.O;
    if (??? != null)
    {
      ((SensorTrackManager)???).f();
      this.O = null;
    }
    ??? = this.h;
    if (??? != null)
    {
      ((ARLocalControl)???).c();
      this.h = null;
    }
    ??? = this.S;
    if (??? != null)
    {
      ((ARCloudControl)???).g();
      this.S = null;
    }
    ??? = this.T;
    if (??? != null)
    {
      ((ARMarkerResourceManager)???).d();
      this.T = null;
    }
    if (this.R != null) {
      this.R = null;
    }
    this.Q = null;
    this.k = false;
    this.aS = 0;
    synchronized (this.X)
    {
      if (this.V != null)
      {
        if (this.W != null) {
          this.W.removeCallbacksAndMessages(null);
        }
        this.W = null;
        if (Build.VERSION.SDK_INT >= 18) {
          this.V.quitSafely();
        }
        this.V = null;
        this.ae = null;
      }
      return;
    }
  }
  
  private void P()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudMarkerRecogResultComplete.");
    if (!ARRecognition.b(this.z.recognitions, 1L)) {
      a(1L);
    }
    R();
    this.aF = false;
  }
  
  private void Q()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudFaceRecogResultComplete.");
    if (ARRecognition.b(this.z.recognitions, 1L)) {
      b(1L);
    }
    R();
    this.aG = false;
  }
  
  private void R()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudRecogResult end.");
    N();
  }
  
  private void S()
  {
    QLog.i("AREngine_QQARSession", 1, "stopSensorTrack.");
    this.aw = false;
    SensorTrackManager localSensorTrackManager = this.O;
    if (localSensorTrackManager != null) {
      localSensorTrackManager.e();
    }
  }
  
  private boolean T()
  {
    return false;
  }
  
  private void U()
  {
    if (this.aS != 1) {
      return;
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((ARLocalControl)localObject).d();
    }
    localObject = this.aN;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).e();
    }
  }
  
  private void V()
  {
    synchronized (this.X)
    {
      if ((this.W != null) && (this.ae != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeAllTask. task count = ");
        localStringBuilder.append(this.ae.size());
        QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
        int i1 = 0;
        while (i1 < this.ae.size())
        {
          this.W.removeCallbacks((Runnable)this.ae.get(i1));
          i1 += 1;
        }
        this.ae.clear();
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static ARRenderResourceInfo a(ArCloudConfigInfo paramArCloudConfigInfo, boolean paramBoolean, long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramArCloudConfigInfo == null) {
      return null;
    }
    Object localObject1;
    Object localObject3;
    if (paramArCloudConfigInfo.e == 0)
    {
      localObject1 = ARResouceDir.b(paramArCloudConfigInfo);
      localObject2 = ARResouceDir.c(paramArCloudConfigInfo);
      localObject3 = ARResouceDir.d(paramArCloudConfigInfo);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists()) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (new File((String)localObject2).exists()))
      {
        ArCloudConfigInfo.ARVideoLayout localARVideoLayout = ARVideoUtil.b(paramArCloudConfigInfo.k.g);
        paramArCloudConfigInfo = new GeneralARResourceInfo(paramArCloudConfigInfo.j.a, paramArCloudConfigInfo.e, paramArCloudConfigInfo.d, (String)localObject2, (String)localObject1, (String)localObject3, localARVideoLayout, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.c = paramLong;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getARRenderResourceInfo. key = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.a);
        ((StringBuilder)localObject1).append(", arType = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.b);
        ((StringBuilder)localObject1).append(", trackMode = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.d);
        ((StringBuilder)localObject1).append(", resPath = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.j);
        ((StringBuilder)localObject1).append(", luaPath = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.i);
        ((StringBuilder)localObject1).append(", musicPath = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.k);
        ((StringBuilder)localObject1).append(", recogType = ");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
        return paramArCloudConfigInfo;
      }
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
      return null;
    }
    int i1 = paramArCloudConfigInfo.e;
    boolean bool1 = false;
    int i2;
    if ((i1 != 2) && (paramArCloudConfigInfo.e != 3))
    {
      if (paramArCloudConfigInfo.e == 4)
      {
        localObject1 = new ARTarget(paramArCloudConfigInfo);
        i2 = ARVideoUtil.a((ARTarget)localObject1);
        i1 = i2;
        if (i2 == 0) {
          i1 = 2147483647;
        }
        localObject1 = ARVideoUtil.b((ARTarget)localObject1);
        i2 = ((Integer)((Pair)localObject1).first).intValue();
        localObject3 = (KeyingParams)((Pair)localObject1).second;
        if (!paramArCloudConfigInfo.d())
        {
          if (((paramBoolean) && ((paramLong == 2L) || (paramLong == 2048L))) || ((paramLong == 1L) && (paramArCloudConfigInfo.d == 2))) {
            localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.i.get(0)).d, UniformGLRenderManagerImpl.b, UniformGLRenderManagerImpl.c, paramArCloudConfigInfo.j());
          } else {
            localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.i.get(0)).d, UniformGLRenderManagerImpl.b, UniformGLRenderManagerImpl.c);
          }
        }
        else {
          localObject1 = null;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((ArVideoResourceInfo)paramArCloudConfigInfo.i.get(0)).b);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(((ArVideoResourceInfo)paramArCloudConfigInfo.i.get(0)).i);
        localObject2 = AROnlineVideoUtil.b(((StringBuilder)localObject2).toString());
        long l1;
        if (localObject2 != null)
        {
          l1 = ((Long)((Pair)localObject2).first).longValue();
          localObject2 = (String)((Pair)localObject2).second;
        }
        else
        {
          localObject2 = "";
          l1 = 0L;
        }
        paramBoolean = ARVideoUtil.a();
        paramArCloudConfigInfo = new OnlineVideoARRenderableInfo(paramArCloudConfigInfo.j.a, paramArCloudConfigInfo.e, paramArCloudConfigInfo.d, i2, (KeyingParams)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject1, (String)localObject2, l1, paramBoolean, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.c = paramLong;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getARRenderResourceInfo. key = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.a);
        ((StringBuilder)localObject1).append(", arType = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.b);
        ((StringBuilder)localObject1).append(", trackMode = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.d);
        ((StringBuilder)localObject1).append(", renderType = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.i);
        ((StringBuilder)localObject1).append(", keyingParams = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.n);
        ((StringBuilder)localObject1).append(", videoUrl = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.j);
        ((StringBuilder)localObject1).append(", videoSize = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.k);
        ((StringBuilder)localObject1).append(", layout = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.o);
        ((StringBuilder)localObject1).append(", isSoftDecode = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.l);
        ((StringBuilder)localObject1).append(", videoPlayCount = ");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(", recogType = ");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
        return paramArCloudConfigInfo;
      }
      if (paramArCloudConfigInfo.e == 5)
      {
        if (ARVideoUtil.a())
        {
          localObject1 = paramArCloudConfigInfo.i.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
            if ((localObject2 != null) && ((((ArVideoResourceInfo)localObject2).h == 2) || (((ArVideoResourceInfo)localObject2).h == 3)))
            {
              QLog.i("AREngine_QQARSession", 1, "getMultiFragmentAnimARResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
              return null;
            }
          }
        }
        paramArCloudConfigInfo = new MultiFragmentAnimARResourceInfo(paramArCloudConfigInfo.f, paramArCloudConfigInfo.e, paramArCloudConfigInfo.d, paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.c = paramLong;
        return paramArCloudConfigInfo;
      }
      if (paramArCloudConfigInfo.e == 100)
      {
        localObject1 = ARResouceDir.a(paramArCloudConfigInfo);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists()))
        {
          paramArCloudConfigInfo = new Interactive3DResourceInfo(paramArCloudConfigInfo.j.a, paramArCloudConfigInfo.e, 1, "", (String)localObject1, "", paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getARRenderResourceInfo. key = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.a);
          ((StringBuilder)localObject1).append(", resType = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.b);
          ((StringBuilder)localObject1).append(", resPath = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.k);
          ((StringBuilder)localObject1).append(", luaPath = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.j);
          ((StringBuilder)localObject1).append(", musicPath = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.l);
          QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
          return paramArCloudConfigInfo;
        }
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
      }
      if (paramArCloudConfigInfo.e == 7)
      {
        localObject1 = ARResouceDir.c(paramArCloudConfigInfo);
        localObject2 = ARResouceDir.b(paramArCloudConfigInfo);
        return new GreetingCardResourceInfo(paramArCloudConfigInfo.f, paramArCloudConfigInfo.e, paramArCloudConfigInfo.d, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2);
      }
      if (paramArCloudConfigInfo.e == 8)
      {
        localObject1 = ARResouceDir.b(paramArCloudConfigInfo);
        localObject2 = ARResouceDir.a(paramArCloudConfigInfo.r.h);
        localObject3 = paramArCloudConfigInfo.r.j;
        boolean bool2 = paramArCloudConfigInfo.r.a;
        paramBoolean = bool1;
        if (paramArCloudConfigInfo.r.c == 1) {
          paramBoolean = true;
        }
        i1 = paramArCloudConfigInfo.r.e;
        i2 = paramArCloudConfigInfo.r.d;
        return new ARTransferResourceInfo(paramArCloudConfigInfo.f, paramArCloudConfigInfo.e, paramArCloudConfigInfo.d, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2, (ArrayList)localObject3, Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean), i1, i2);
      }
      return null;
    }
    if (!VersionUtils.d())
    {
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. NOT IceScreamSandwich.");
      return null;
    }
    if (ARVideoUtil.a())
    {
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
      return null;
    }
    Object localObject2 = ARResouceDir.e(paramArCloudConfigInfo);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (new File((String)localObject2).exists()))
    {
      localObject1 = new ARTarget(paramArCloudConfigInfo);
      i2 = ARVideoUtil.a((ARTarget)localObject1);
      i1 = i2;
      if (i2 == 0) {
        i1 = 2147483647;
      }
      localObject1 = ARVideoUtil.b((ARTarget)localObject1);
      i2 = ((Integer)((Pair)localObject1).first).intValue();
      localObject3 = (KeyingParams)((Pair)localObject1).second;
      if (!paramArCloudConfigInfo.d())
      {
        if (((paramBoolean) && ((paramLong == 2L) || (paramLong == 2048L))) || ((paramLong == 1L) && (paramArCloudConfigInfo.d == 2))) {
          localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.i.get(0)).d, UniformGLRenderManagerImpl.b, UniformGLRenderManagerImpl.c, paramArCloudConfigInfo.j());
        } else {
          localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.i.get(0)).d, UniformGLRenderManagerImpl.b, UniformGLRenderManagerImpl.c);
        }
      }
      else {
        localObject1 = null;
      }
      paramArCloudConfigInfo = new NormalVideoARResourceInfo(paramArCloudConfigInfo.j.a, paramArCloudConfigInfo.e, paramArCloudConfigInfo.d, i2, (KeyingParams)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject1, (String)localObject2, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.c = paramLong;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getARRenderResourceInfo. key = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.a);
      ((StringBuilder)localObject1).append(", arType = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.b);
      ((StringBuilder)localObject1).append(", trackMode = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.d);
      ((StringBuilder)localObject1).append(", renderType = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.i);
      ((StringBuilder)localObject1).append(", keyingParams = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.l);
      ((StringBuilder)localObject1).append(", videoPath = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.j);
      ((StringBuilder)localObject1).append(", layout = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.m);
      ((StringBuilder)localObject1).append(", videoPlayCount = ");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", recogType = ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
      return paramArCloudConfigInfo;
    }
    QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. video path empty or file not exist.");
    return null;
  }
  
  private void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity)
  {
    if ((this.v) && (this.a == 2))
    {
      AREngineCallback localAREngineCallback = this.B;
      if (localAREngineCallback != null) {
        localAREngineCallback.a(paramARCloudLBSLocationCheckResult, paramArLBSActivity);
      }
    }
  }
  
  private void a(ARCloudMarkerRecogResult paramARCloudMarkerRecogResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult start.");
    this.ak = true;
    this.ad = new QQARSession.10(this);
    if (!this.T.a(paramARCloudMarkerRecogResult, this, false, this.aM))
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end. download preprocess failed.");
      this.ak = false;
      P();
      return;
    }
    a(this.ad, 30000L);
  }
  
  private void a(ARCloudObjectClassifyResult paramARCloudObjectClassifyResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult start.");
    this.ad = new QQARSession.11(this);
    if (!this.T.a(paramARCloudObjectClassifyResult, this, false, this.aM))
    {
      QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult end. download preprocess failed.");
      B();
      return;
    }
    QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult post task for handle timeout");
    a(this.ad, 30000L);
  }
  
  private void a(ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult start.");
    this.h.a(paramARCloudRecogRspFaceResult);
    b(4L);
    this.aG = true;
    QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult end.");
  }
  
  private void a(ARCloudSceneRecogResult paramARCloudSceneRecogResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult start.");
    this.ad = new QQARSession.13(this);
    if (!this.T.a(paramARCloudSceneRecogResult, this, false, this.aM))
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult end. download preprocess failed.");
      D();
      return;
    }
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
    a(this.ad, 30000L);
  }
  
  private void a(ARLocalFaceRecogResult paramARLocalFaceRecogResult1, ARLocalFaceRecogResult paramARLocalFaceRecogResult2)
  {
    if ((QLog.isColorLevel()) && (ARLocalFaceRecog.a))
    {
      paramARLocalFaceRecogResult2 = new StringBuilder();
      paramARLocalFaceRecogResult2.append("ARFaceTest processLocalFaceRecogResult. curLocalFaceRecogResult = ");
      paramARLocalFaceRecogResult2.append(paramARLocalFaceRecogResult1);
      QLog.d("AREngine_QQARSession", 2, paramARLocalFaceRecogResult2.toString());
    }
    paramARLocalFaceRecogResult2 = this.R;
    if (paramARLocalFaceRecogResult2 != null) {
      paramARLocalFaceRecogResult2.b(paramARLocalFaceRecogResult1.a);
    }
    paramARLocalFaceRecogResult2 = this.R;
    if (paramARLocalFaceRecogResult2 != null) {
      paramARLocalFaceRecogResult2.b();
    }
    a(null, paramARLocalFaceRecogResult1);
  }
  
  private void a(ARLocalGestureCircleRecogResult paramARLocalGestureCircleRecogResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processLocalGestureCircleRecogResult");
    ARTransferDoorLogicManager localARTransferDoorLogicManager = this.aN;
    if (localARTransferDoorLogicManager != null) {
      localARTransferDoorLogicManager.a(paramARLocalGestureCircleRecogResult, this.aa, this.ab, this.Y, this.Z);
    }
  }
  
  private void a(ARLocalMarkerRecogResult paramARLocalMarkerRecogResult1, ARLocalMarkerRecogResult paramARLocalMarkerRecogResult2)
  {
    if (paramARLocalMarkerRecogResult1.b != 2)
    {
      if (paramARLocalMarkerRecogResult1.i.f())
      {
        paramARLocalMarkerRecogResult2 = this.R;
        if (paramARLocalMarkerRecogResult2 != null) {
          paramARLocalMarkerRecogResult2.b(paramARLocalMarkerRecogResult1.a);
        }
        paramARLocalMarkerRecogResult2 = this.R;
        if (paramARLocalMarkerRecogResult2 != null) {
          paramARLocalMarkerRecogResult2.b();
        }
        this.au = 0L;
        this.av = 0L;
        if (paramARLocalMarkerRecogResult1.b == 0) {
          a(1L, paramARLocalMarkerRecogResult1.i, paramARLocalMarkerRecogResult1.d, paramARLocalMarkerRecogResult1.e, paramARLocalMarkerRecogResult1.f, paramARLocalMarkerRecogResult1.g);
        }
        a(new ARRenderMarkerTrackInfo(paramARLocalMarkerRecogResult1.d, paramARLocalMarkerRecogResult1.e, paramARLocalMarkerRecogResult1.f, paramARLocalMarkerRecogResult1.g, paramARLocalMarkerRecogResult1.h, this.h.a(this.Y, this.Z)));
        this.aF = true;
      }
    }
    else
    {
      if ((paramARLocalMarkerRecogResult2 != null) && (paramARLocalMarkerRecogResult2.b != 2)) {
        this.au = System.currentTimeMillis();
      }
      this.av = System.currentTimeMillis();
      if (this.au > 0L)
      {
        if (z())
        {
          paramARLocalMarkerRecogResult2 = new float[16];
          a(new ARRenderMarkerTrackInfo(paramARLocalMarkerRecogResult1.d, 0.0F, 0.0F, 0.0F, paramARLocalMarkerRecogResult2, this.h.a(this.Y, this.Z)));
        }
        if (this.av - this.au > 1500L)
        {
          this.au = 0L;
          ARVideoRecordUIControllerImpl.a().b(1);
          x();
        }
      }
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (q() != null) {
      q().c(paramRunnable);
    }
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    if (q() != null) {
      q().c(paramRunnable, paramLong);
    }
  }
  
  private boolean a(long paramLong, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Object localObject1 = a(paramArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startModelRender. recogType = ");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(", key = ");
    ((StringBuilder)localObject2).append(((ARRenderResourceInfo)localObject1).a);
    ((StringBuilder)localObject2).append(", resType = ");
    ((StringBuilder)localObject2).append(((ARRenderResourceInfo)localObject1).b);
    QLog.d("AREngine_QQARSession", 1, ((StringBuilder)localObject2).toString());
    if (this.R != null)
    {
      this.ap = paramLong;
      this.aq = paramArCloudConfigInfo;
      localObject2 = a(this.ar, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
      if ((localObject2 != null) && (((ARRenderResourceInfo)localObject2).a.equalsIgnoreCase(((ARRenderResourceInfo)localObject1).a))) {
        return true;
      }
      if ((localObject2 != null) && (!((ARRenderResourceInfo)localObject2).a.equalsIgnoreCase(((ARRenderResourceInfo)localObject1).a)))
      {
        this.R.j();
        this.R.a((ARRenderResourceInfo)localObject1);
      }
      else
      {
        this.R.a((ARRenderResourceInfo)localObject1);
      }
      localObject1 = this.R;
      if (localObject1 != null) {
        ((UniformGLRenderManager)localObject1).b();
      }
      CameraProxy.a().b();
      if ((this.v) && (this.a == 2) && (this.B != null))
      {
        if ((!paramArCloudConfigInfo.a()) && (paramArCloudConfigInfo.f())) {
          ARVideoRecordUIControllerImpl.a().a(3);
        }
        paramArCloudConfigInfo = new ARTarget(paramArCloudConfigInfo);
        this.B.a(paramLong, true, paramArCloudConfigInfo);
      }
      this.ar = this.aq;
      if (this.az == 0)
      {
        this.aB = System.currentTimeMillis();
        this.az = ((int)(this.aB - this.aA));
      }
      if ((this.aC == 0) && (this.aj != null))
      {
        this.aE = System.currentTimeMillis();
        this.aC = ((int)(this.aE - this.aD));
      }
    }
    return true;
  }
  
  private void b(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult start.");
    if (paramARMIGObjectClassifyResult.b() == -1)
    {
      C();
      return;
    }
    if (paramARMIGObjectClassifyResult.b() == 1)
    {
      c(paramARMIGObjectClassifyResult);
      return;
    }
    Object localObject = this.am;
    int i1;
    if ((localObject != null) && (paramARMIGObjectClassifyResult.a((ARMIGObjectClassifyResult)localObject))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    localObject = this.S;
    if ((localObject != null) && (i1 != 0))
    {
      ((ARCloudControl)localObject).b(true);
      QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal setCompareSameSceneFlag.");
      return;
    }
    c(paramARMIGObjectClassifyResult);
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (q() != null) {
      q().d(paramRunnable);
    }
  }
  
  private void c(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal start.");
    if (paramARMIGObjectClassifyResult.b() == 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "1", "", "", "");
      if (this.am != null) {
        e(false);
      }
      this.ad = new QQARSession.12(this);
      if (!this.T.a(paramARMIGObjectClassifyResult, this, false, this.aM))
      {
        QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult end. download preprocess failed.");
        C();
        return;
      }
      QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult post task for handle timeout");
      a(this.ad, 30000L);
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "0", "", "", "");
    ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult localARMigObjectClassifyExternalRenderResult = paramARMIGObjectClassifyResult.h();
    if (localARMigObjectClassifyExternalRenderResult != null)
    {
      this.am = paramARMIGObjectClassifyResult;
      a(null, localARMigObjectClassifyExternalRenderResult);
      N();
    }
    if ((localARMigObjectClassifyExternalRenderResult == null) || (!localARMigObjectClassifyExternalRenderResult.b)) {
      C();
    }
  }
  
  private void c(Runnable paramRunnable)
  {
    synchronized (this.X)
    {
      if (this.W != null)
      {
        this.W.post(paramRunnable);
        this.ae.add(paramRunnable);
      }
      return;
    }
  }
  
  private void c(Runnable paramRunnable, long paramLong)
  {
    synchronized (this.X)
    {
      if (this.W != null)
      {
        this.W.postDelayed(paramRunnable, paramLong);
        this.ae.add(paramRunnable);
      }
      return;
    }
  }
  
  private void d(Runnable paramRunnable)
  {
    int i1;
    label127:
    synchronized (this.X)
    {
      if ((this.W != null) && (this.ae != null))
      {
        i1 = 0;
        if (i1 < this.ae.size())
        {
          if (!paramRunnable.equals(this.ae.get(i1))) {
            break label127;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeTask. task = ");
          localStringBuilder.append(this.ae.get(i1));
          QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
          this.ae.remove(i1);
          this.W.removeCallbacks(paramRunnable);
        }
      }
      return;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.v) && (this.a == 2))
    {
      AREngineCallback localAREngineCallback = this.B;
      if (localAREngineCallback != null) {
        localAREngineCallback.b(paramBoolean);
      }
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a = 2;
    }
    else
    {
      this.a = 5;
      this.w = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start end. mCurEngineState = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onStartComplete. retCode = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    localObject = this.B;
    if (localObject != null) {
      ((AREngineCallback)localObject).a(paramInt);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    this.am = null;
    ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult.a.c = paramBoolean;
    a(null, ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult.a);
  }
  
  private void e(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.aK;
    long l1;
    if (l2 >= 1000L) {
      l1 = 0L;
    } else {
      l1 = 1000L - l2;
    }
    QLog.i("AREngine_QQARSession", 1, String.format("onARObjectClassifyDownloadComplete result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
    a(new QQARSession.16(this, paramBoolean, paramArCloudConfigInfo), l1);
    this.o = null;
  }
  
  private void f(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.aK;
    long l1;
    if (l2 >= 1000L) {
      l1 = 0L;
    } else {
      l1 = 1000L - l2;
    }
    QLog.i("AREngine_QQARSession", 1, String.format("onARSceneRecogDownloadCompleteInteral result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
    a(new QQARSession.18(this, paramBoolean, paramArCloudConfigInfo), l1);
    this.o = null;
  }
  
  private boolean f(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startSensorTrack. isForExternalTrack = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    this.aw = paramBoolean;
    localObject = this.O;
    if (localObject != null) {
      ((SensorTrackManager)localObject).b();
    }
    return true;
  }
  
  public static QQARSession p()
  {
    if (q == null) {
      q = new QQARSession();
    }
    return q;
  }
  
  public static QQARSession q()
  {
    return q;
  }
  
  public static void r()
  {
    q = null;
    r = true;
  }
  
  public static boolean s()
  {
    return r;
  }
  
  public static void t()
  {
    if (q() != null) {
      q().V();
    }
  }
  
  public boolean A()
  {
    QLog.i("AREngine_QQARSession", 1, "stopInternal.");
    this.n = true;
    S();
    K();
    L();
    this.af = null;
    this.ag = null;
    this.ah = null;
    this.ai = null;
    this.aj = null;
    this.ak = false;
    this.ap = 0L;
    this.aq = null;
    this.ar = null;
    this.as = 0L;
    this.at = 0L;
    this.au = 0L;
    this.av = 0L;
    this.aw = false;
    this.n = false;
    this.ax = 0L;
    this.ay = 0L;
    return true;
  }
  
  public void B()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudObjectClassifyResultComplete.");
    if (ARRecognition.b(this.z.recognitions, 1L)) {
      b(1L);
    }
    R();
  }
  
  public void C()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessMigCloudObjectClassifyResultComplete.");
    if (ARRecognition.b(this.z.recognitions, 1L))
    {
      b(1L);
      this.an = false;
    }
    this.am = null;
    R();
  }
  
  public void D()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudSceneRecogResultComplete.");
    if (ARRecognition.b(this.z.recognitions, 1L)) {
      b(1L);
    }
    R();
  }
  
  public void E()
  {
    QLog.d("AREngine_QQARSession", 1, "engine notifyRenderReady ");
    ArCloudConfigInfo localArCloudConfigInfo = this.o;
    if (localArCloudConfigInfo == null) {
      return;
    }
    if ((localArCloudConfigInfo.m != null) && (this.o.m.b) && (this.o.m.a) && (!TextUtils.isEmpty(this.o.m.c)))
    {
      int i1 = this.p;
      if (i1 == 1)
      {
        d(true, this.o);
        return;
      }
      if (i1 == 2) {
        e(true, this.o);
      }
    }
  }
  
  public ArrayList<String> F()
  {
    ARCloudControl localARCloudControl = this.S;
    if (localARCloudControl != null) {
      return localARCloudControl.j();
    }
    return null;
  }
  
  public void G()
  {
    QLog.d("AREngine_QQARSession", 1, String.format("CloseAREngineRecoglizeFunction  ", new Object[0]));
    a(new QQARSession.27(this));
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ARCommonConfigInfo paramARCommonConfigInfo, ArConfigInfo paramArConfigInfo, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, AREngineCallback paramAREngineCallback, Activity paramActivity, ARTransferDoorLogicManager paramARTransferDoorLogicManager, UniformGLRenderManager paramUniformGLRenderManager)
  {
    QLog.d("AREngine_QQARSession", 1, String.format("initAR isEnableARCloudFromSettings=%s isEnableARCloudFromH5=%s isTestMode=%s commonConfig=%s markerConfig=%s faceConfig=%s arEngineCallback=%s mIsArInited=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean4), paramARCommonConfigInfo, paramArConfigInfo, paramARScanStarFaceConfigInfo, paramAREngineCallback, Boolean.valueOf(this.w) }));
    if (this.w) {
      return 0;
    }
    if (paramARCommonConfigInfo == null)
    {
      this.w = false;
      QLog.i("AREngine_QQARSession", 1, "initAR fail! commonConfig is null.");
      if (paramAREngineCallback != null) {
        paramAREngineCallback.a(3);
      }
      return 3;
    }
    g = paramBoolean4;
    this.z = paramARCommonConfigInfo;
    this.A = paramArConfigInfo;
    this.m = paramARScanStarFaceConfigInfo;
    this.B = paramAREngineCallback;
    this.C = paramARCommonConfigInfo.isEnableARCloud();
    this.D = ARRecognition.b(paramARCommonConfigInfo.recognitions);
    this.E = ARRecognition.a(paramARCommonConfigInfo.recognitions);
    this.F = this.C;
    if (!paramBoolean2) {
      this.F = false;
    }
    if (paramBoolean1) {
      this.F = true;
    }
    if (paramBoolean3)
    {
      this.k = true;
      this.F = false;
      this.G = 4096L;
    }
    else
    {
      this.G = (this.D & 1L);
    }
    this.H = (this.E & 0x883);
    if (this.z.recognitions != null)
    {
      int i2;
      for (int i1 = 0; i1 < this.z.recognitions.size(); i1 = i2 + 1)
      {
        long l1 = 1 << (int)((ARRecognition)this.z.recognitions.get(i1)).a;
        i2 = i1;
        if ((this.G & l1) == 0L)
        {
          i2 = i1;
          if ((this.H & l1) == 0L)
          {
            this.z.recognitions.remove(i1);
            i2 = i1 - 1;
          }
        }
      }
    }
    this.I = ARRecognition.a(this.z.recognitions, 1L);
    this.J = ARRecognition.a(this.z.recognitions, 2L);
    this.K = ARRecognition.a(this.z.recognitions, 4L);
    this.L = ARRecognition.a(this.z.recognitions, 64L);
    this.M = ARRecognition.a(this.z.recognitions, 128L);
    this.N = ARRecognition.a(this.z.recognitions, 2048L);
    paramARCommonConfigInfo = new StringBuilder();
    paramARCommonConfigInfo.append("initAR mIsEnableARCloudFromConfig=");
    paramARCommonConfigInfo.append(this.C);
    paramARCommonConfigInfo.append(" mLocalRecogTypeFromConfig=");
    paramARCommonConfigInfo.append(this.D);
    paramARCommonConfigInfo.append(" mCloudRecogTypeFromConfig=");
    paramARCommonConfigInfo.append(this.E);
    paramARCommonConfigInfo.append(" mIsEnableARCloudFromClientSupport=");
    paramARCommonConfigInfo.append(true);
    paramARCommonConfigInfo.append(" mLocalRecogTypeFromClientSupport=");
    paramARCommonConfigInfo.append(1L);
    paramARCommonConfigInfo.append(" mCloudRecogTypeFromClientSupport=");
    paramARCommonConfigInfo.append(2179L);
    paramARCommonConfigInfo.append(" mIsEnableARCloud=");
    paramARCommonConfigInfo.append(this.F);
    paramARCommonConfigInfo.append(" mLocalRecogType=");
    paramARCommonConfigInfo.append(this.G);
    paramARCommonConfigInfo.append(" mCloudRecogType=");
    paramARCommonConfigInfo.append(this.H);
    paramARCommonConfigInfo.append(" mMarkerRecogPriority=");
    paramARCommonConfigInfo.append(this.I);
    paramARCommonConfigInfo.append(" mObjectClassifyPriority=");
    paramARCommonConfigInfo.append(this.J);
    paramARCommonConfigInfo.append(" mFaceRecogPriority=");
    paramARCommonConfigInfo.append(this.K);
    paramARCommonConfigInfo.append(" mPreOcrRecogPriority=");
    paramARCommonConfigInfo.append(this.L);
    paramARCommonConfigInfo.append(" mSceneRecogPriority=");
    paramARCommonConfigInfo.append(this.N);
    QLog.i("AREngine_QQARSession", 1, paramARCommonConfigInfo.toString());
    paramARCommonConfigInfo = new StringBuilder();
    paramARCommonConfigInfo.append("Build.MODEL = ");
    paramARCommonConfigInfo.append(Build.MODEL);
    QLog.i("AREngine_QQARSession", 1, paramARCommonConfigInfo.toString());
    this.R = paramUniformGLRenderManager;
    this.aN = paramARTransferDoorLogicManager;
    this.T = new ARMarkerResourceManager(this.f, this.e);
    paramARCommonConfigInfo = this.z;
    if ((paramARCommonConfigInfo != null) && (paramARCommonConfigInfo.aRCloudCacheExpireTime > 0L)) {
      this.T.a(this.z.aRCloudCacheExpireTime * 60L * 1000L, g);
    } else {
      this.T.a(86400000L, g);
    }
    this.U = this.T.b();
    if ((this.G != 0L) && (this.h == null)) {
      this.h = new ARLocalControl();
    }
    if ((this.F) && (this.S == null))
    {
      this.S = new ARCloudControl();
      if (!this.S.a(this, this.f, paramActivity, 900000000, 900000000, 0, this.z))
      {
        QLog.i("AREngine_QQARSession", 1, "initAR fail! ARCloud init ar so fail.");
        this.S = null;
        this.w = false;
        if (paramAREngineCallback != null)
        {
          paramAREngineCallback.a(8);
          return 8;
        }
        return 8;
      }
    }
    this.w = true;
    this.a = 0;
    return 0;
  }
  
  public void a()
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderReadyStatus ready");
    a(new QQARSession.20(this));
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong) {}
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onARMarkerAllDownloadProgress. progress = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    if ((this.v) && (this.a == 2))
    {
      localObject = this.B;
      if (localObject != null) {
        ((AREngineCallback)localObject).a(2, paramInt);
      }
    }
  }
  
  public void a(int paramInt, ARCloudRecogResult paramARCloudRecogResult)
  {
    if (this.k)
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete mIsForbiddenLocalMarkAndCloudRecg:do nothing but return ");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onARCloudUploadImgComplete. retCode = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", recogResult = ");
    ((StringBuilder)localObject).append(paramARCloudRecogResult);
    ((StringBuilder)localObject).append(":time is:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - this.aO);
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    this.aO = System.currentTimeMillis();
    if ((paramInt == 0) && (this.aJ))
    {
      this.aJ = false;
      ReportController.b(null, "dc00898", "", "", "0X80085AE", "0X80085AE", 0, 0, "", "", "", "");
    }
    if ((this.aj == null) || (this.am != null))
    {
      localObject = this.af;
      if ((localObject == null) || (((ARLocalMarkerRecogResult)localObject).b == 2))
      {
        localObject = this.ah;
        if (((localObject == null) || (((ARLocalFaceRecogResult)localObject).c.size() <= 0)) && (!z())) {
          break label334;
        }
      }
    }
    if ((this.aj != null) && (this.am == null))
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurCloudRecogResult != null.");
    }
    else
    {
      paramARCloudRecogResult = this.af;
      if ((paramARCloudRecogResult != null) && (paramARCloudRecogResult.b != 2))
      {
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalMarkerRecogResult.state != ARConstants.AR_TRACK_STATE_LOST.");
      }
      else
      {
        paramARCloudRecogResult = this.ah;
        if ((paramARCloudRecogResult != null) && (paramARCloudRecogResult.c.size() > 0)) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalFaceRecogResult.faceDatas.size() > 0.");
        } else if (z()) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. isModelRenderStarted().");
        }
      }
    }
    paramARCloudRecogResult = this.S;
    if (paramARCloudRecogResult != null) {
      paramARCloudRecogResult.a(true);
    }
    return;
    label334:
    if ((this.aj == null) && (this.am != null)) {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult sucess");
    } else if ((this.aj != null) && (this.am != null)) {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult error happen");
    }
    int i1;
    boolean bool1;
    if ((paramInt == 0) && (paramARCloudRecogResult != null))
    {
      if ((!ARCloudMarkerRecogResult.a(paramARCloudRecogResult.d)) && (!ARCloudObjectClassifyResult.a(paramARCloudRecogResult.e)) && (!ARMIGObjectClassifyResult.a(paramARCloudRecogResult.j)) && (!ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.f)) && (!ARCloudSceneRecogResult.a(paramARCloudRecogResult.k))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      boolean bool2 = ARCloudPreOcrResult.a(paramARCloudRecogResult.h);
      paramInt = i1;
      if (bool2)
      {
        paramInt = i1;
        if (i1 != 0)
        {
          paramInt = i1;
          if (ARRecognition.a(paramARCloudRecogResult, this.z.recognitions, 64L))
          {
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard other recog result as OCR preRecog has high priority");
            paramInt = 0;
          }
        }
      }
      i1 = paramInt;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onARCloudUploadImgComplete result:  marker{success: ");
        localStringBuilder.append(ARCloudMarkerRecogResult.a(paramARCloudRecogResult.d));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.I);
        localStringBuilder.append("}");
        localStringBuilder.append("  object{success: ");
        localStringBuilder.append(ARCloudObjectClassifyResult.a(paramARCloudRecogResult.e));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.J);
        localStringBuilder.append("}");
        localStringBuilder.append("  face{success: ");
        localStringBuilder.append(ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.f));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.K);
        localStringBuilder.append("}");
        localStringBuilder.append("  pre ocr{success: ");
        localStringBuilder.append(ARCloudPreOcrResult.a(paramARCloudRecogResult.h));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.L);
        localStringBuilder.append("}");
        localStringBuilder.append(" \n mig-object{success: ");
        localStringBuilder.append(ARMIGObjectClassifyResult.a(paramARCloudRecogResult.j));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.M);
        localStringBuilder.append("}name:");
        if (paramARCloudRecogResult.j != null) {
          localObject = paramARCloudRecogResult.j.toString();
        } else {
          localObject = "";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("  scene{success: ");
        localStringBuilder.append(ARCloudSceneRecogResult.a(paramARCloudRecogResult.k));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.N);
        localStringBuilder.append("}");
        QLog.i("AREngine_QQARSession", 2, localStringBuilder.toString());
        i1 = paramInt;
        bool1 = bool2;
      }
    }
    else
    {
      i1 = 0;
      bool1 = false;
    }
    if ((i1 != 0) && (!this.aL))
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete first recognize success.");
      this.aL = true;
    }
    if ((bool1) && (i1 == 0))
    {
      this.al = true;
      a(new QQARSession.5(this));
    }
    else if ((!bool1) && (this.al))
    {
      this.al = false;
      a(new QQARSession.6(this));
    }
    if (i1 == 0)
    {
      if (this.am != null)
      {
        e(true);
        if ((this.v) && (this.a == 2) && (!this.ao)) {
          C();
        }
      }
      if ((!ARRecognition.b(this.z.recognitions, 1L)) && ((this.G & 1L) != 0L))
      {
        M();
        b(1L);
      }
      paramARCloudRecogResult = this.S;
      if (paramARCloudRecogResult != null) {
        paramARCloudRecogResult.a(true);
      }
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. cloud recog failed.");
      return;
    }
    if (i1 != 0)
    {
      localObject = ARCloudRecogResult.b(this.z.recognitions, paramARCloudRecogResult);
      if ((ARCloudRecogResult.a(this.z.recognitions, paramARCloudRecogResult)) && (((ARCloudLBSLocationCheckResult)localObject).a != 1))
      {
        a(new QQARSession.7(this, (ARCloudLBSLocationCheckResult)localObject, ARCloudRecogResult.c(this.z.recognitions, paramARCloudRecogResult)));
        paramARCloudRecogResult = this.S;
        if (paramARCloudRecogResult != null) {
          paramARCloudRecogResult.a(true);
        }
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. lbs location failed.");
        return;
      }
    }
    M();
    this.as = 0L;
    this.at = 0L;
    a(new QQARSession.8(this, paramARCloudRecogResult));
    paramARCloudRecogResult = this.S;
    if (paramARCloudRecogResult != null) {
      paramARCloudRecogResult.a(true);
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pauseLocalRecog. recogType = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    localObject = this.h;
    if (localObject != null) {
      ((ARLocalControl)localObject).a(paramLong);
    }
  }
  
  public void a(long paramLong, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    b(new QQARSession.2(this, paramLong, paramArCloudConfigInfo), 500L);
  }
  
  public void a(long paramLong, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    if (this.aS == 1)
    {
      if (paramARLocalRecogResultBase.j != 4096L) {
        return;
      }
      a((ARLocalGestureCircleRecogResult)paramARLocalRecogResultBase);
      return;
    }
    ARLocalRecogResult localARLocalRecogResult = new ARLocalRecogResult();
    if ((1L & paramLong) != 0L) {
      localARLocalRecogResult.b = ((ARLocalMarkerRecogResult)paramARLocalRecogResultBase);
    }
    if ((paramLong & 0x4) != 0L) {
      localARLocalRecogResult.c = ((ARLocalFaceRecogResult)paramARLocalRecogResultBase);
    }
    a(localARLocalRecogResult, null);
  }
  
  public void a(Context arg1, AppInterface paramAppInterface)
  {
    super.a(???, paramAppInterface);
    System.currentTimeMillis();
    QLog.d("AREngine_QQARSession", 1, String.format("init context=%s appInterface=%s mIsInited=%s", new Object[] { ???, paramAppInterface, Boolean.valueOf(this.v) }));
    if (this.v) {
      return;
    }
    this.O = new SensorTrackManager();
    synchronized (this.X)
    {
      if (this.V == null)
      {
        this.V = ThreadManager.newFreeHandlerThread("AREngineThread", 0);
        this.V.start();
        this.W = new Handler(this.V.getLooper());
        this.ae = new ArrayList();
      }
      this.v = true;
      return;
    }
  }
  
  public void a(ARRenderMarkerTrackInfo paramARRenderMarkerTrackInfo)
  {
    a(paramARRenderMarkerTrackInfo, null);
  }
  
  public void a(ARRenderTrackInfo paramARRenderTrackInfo, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    if ((paramARLocalRecogResultBase != null) && (paramARLocalRecogResultBase.j == 4L))
    {
      if ((this.v) && (this.a == 2))
      {
        paramARRenderTrackInfo = this.B;
        if (paramARRenderTrackInfo != null) {
          paramARRenderTrackInfo.a(paramARLocalRecogResultBase.j, 0, null, paramARLocalRecogResultBase);
        }
      }
    }
    else if ((paramARLocalRecogResultBase != null) && (paramARLocalRecogResultBase.j == 128L))
    {
      if ((this.v) && (this.a == 2))
      {
        paramARRenderTrackInfo = this.B;
        if (paramARRenderTrackInfo != null) {
          paramARRenderTrackInfo.a(paramARLocalRecogResultBase.j, 0, null, paramARLocalRecogResultBase);
        }
      }
    }
    else if (this.aq != null)
    {
      paramARLocalRecogResultBase = this.R;
      if (paramARLocalRecogResultBase != null) {
        paramARLocalRecogResultBase.b();
      }
      if ((this.aq.g()) && (this.aw))
      {
        if ((this.v) && (this.a == 2))
        {
          paramARLocalRecogResultBase = this.B;
          if (paramARLocalRecogResultBase != null) {
            paramARLocalRecogResultBase.a(this.ap, this.aq.d, paramARRenderTrackInfo, null);
          }
        }
      }
      else
      {
        paramARLocalRecogResultBase = this.R;
        if (paramARLocalRecogResultBase != null) {
          paramARLocalRecogResultBase.a(paramARRenderTrackInfo);
        }
      }
    }
    else
    {
      paramARLocalRecogResultBase = this.R;
      if (paramARLocalRecogResultBase != null) {
        paramARLocalRecogResultBase.a(paramARRenderTrackInfo);
      }
    }
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCommonCallbackFromManager, resourceInfo=");
      localStringBuilder.append(paramArCloudConfigInfo);
      localStringBuilder.append(", action=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", result=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ,data=");
      localStringBuilder.append(paramObject);
      QLog.d("AREngine_QQARSession", 2, localStringBuilder.toString());
    }
    a(new QQARSession.26(this, paramArCloudConfigInfo, paramInt1, paramInt2, paramObject));
  }
  
  public void a(ARLocalRecogResult paramARLocalRecogResult, ARCloudRecogResult paramARCloudRecogResult)
  {
    try
    {
      if ((!this.v) || (this.a != 2)) {
        break label1847;
      }
      if (paramARLocalRecogResult != null)
      {
        if (paramARLocalRecogResult.b != null) {
          this.af = paramARLocalRecogResult.b;
        }
        if (paramARLocalRecogResult.c != null) {
          this.ah = paramARLocalRecogResult.c;
        }
      }
      if (paramARCloudRecogResult != null) {
        this.aj = paramARCloudRecogResult;
      }
      if ((this.G == 0L) || (this.H == 0L)) {
        break label1596;
      }
      if ((paramARLocalRecogResult != null) && (paramARLocalRecogResult.b != null))
      {
        i1 = paramARLocalRecogResult.b.b;
        if (i1 == 0)
        {
          try
          {
            ReportController.b(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, paramARLocalRecogResult.b.i.f, "1", "", "");
          }
          catch (Exception paramARCloudRecogResult)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("0X80081DE. error = ");
            ((StringBuilder)localObject).append(paramARCloudRecogResult.getMessage());
            QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
          }
          if (ARRecognition.b(this.z.recognitions, 1L)) {
            M();
          }
          paramARCloudRecogResult = paramARLocalRecogResult.b.i;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("localRecogResult. isNeedInternalRender = ");
          ((StringBuilder)localObject).append(paramARCloudRecogResult.f());
          ((StringBuilder)localObject).append(", isNeedExternalRender = ");
          ((StringBuilder)localObject).append(paramARCloudRecogResult.g());
          ((StringBuilder)localObject).append(", isNeedWaitUserOperation = ");
          ((StringBuilder)localObject).append(paramARCloudRecogResult.h());
          QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
          if ((this.v) && (this.a == 2) && (this.B != null)) {
            this.B.a(1L, new ARTarget(paramARCloudRecogResult));
          }
          if (!paramARCloudRecogResult.d())
          {
            if (paramARCloudRecogResult.f())
            {
              a(1L);
              a(1L, paramARCloudRecogResult, paramARLocalRecogResult.b.d, paramARLocalRecogResult.b.e, paramARLocalRecogResult.b.f, paramARLocalRecogResult.b.g);
              if (paramARCloudRecogResult.j()) {
                f(false);
              }
            }
            else if ((!paramARCloudRecogResult.h()) && (!paramARCloudRecogResult.g()))
            {
              P();
            }
            else if (paramARCloudRecogResult.g())
            {
              a(1L);
              if (paramARCloudRecogResult.j()) {
                f(true);
              }
            }
          }
          else if ((!paramARCloudRecogResult.f()) && ((paramARCloudRecogResult.h()) || (paramARCloudRecogResult.g())) && (paramARCloudRecogResult.g()))
          {
            a(1L);
            if (paramARCloudRecogResult.j()) {
              f(true);
            }
          }
        }
        if ((paramARLocalRecogResult.b.b != 2) && (!paramARLocalRecogResult.b.i.d())) {
          break label1774;
        }
        a(paramARLocalRecogResult.b, this.ag);
        if (paramARLocalRecogResult.b.b != 2)
        {
          this.as = 0L;
          this.at = 0L;
          break label1774;
        }
        if ((this.aj != null) && (this.ak))
        {
          this.as = 0L;
          this.at = 0L;
          break label1774;
        }
        if (this.as == 0L) {
          this.as = System.currentTimeMillis();
        }
        this.at = System.currentTimeMillis();
        if ((this.as <= 0L) || (this.at - this.as <= 1500L)) {
          break label1774;
        }
        this.as = -1L;
        P();
        break label1774;
      }
      if ((paramARLocalRecogResult == null) || (paramARLocalRecogResult.c == null)) {
        break label1067;
      }
      a(this.ah, this.ai);
      i1 = this.ah.c.size();
      if (i1 <= 0) {
        break label1861;
      }
      paramARCloudRecogResult = this.ah.c.iterator();
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (!paramARCloudRecogResult.hasNext()) {
          break;
        }
        if (!((DrawView2.FaceData)paramARCloudRecogResult.next()).r) {
          bool1 = true;
        }
      }
    }
    finally
    {
      for (;;)
      {
        int i1;
        Object localObject;
        boolean bool1;
        long l1;
        label1067:
        label1847:
        for (;;)
        {
          label1596:
          label1774:
          throw paramARLocalRecogResult;
        }
        label1861:
        boolean bool2 = false;
        continue;
        label1867:
        if (l1 != 0L) {}
      }
    }
    if ((QLog.isColorLevel()) && (ARLocalFaceRecog.a))
    {
      paramARCloudRecogResult = new StringBuilder();
      paramARCloudRecogResult.append("[ScanStarFace]onARRecogComplete faceDataSize = ");
      paramARCloudRecogResult.append(i1);
      paramARCloudRecogResult.append(",hasRealFace = ");
      paramARCloudRecogResult.append(bool2);
      QLog.d("AREngine_QQARSession", 2, paramARCloudRecogResult.toString());
    }
    if (bool2)
    {
      try
      {
        ReportController.b(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, String.valueOf(((DrawView2.FaceData)paramARLocalRecogResult.c.c.get(0)).f), "3", "", "");
      }
      catch (Exception paramARCloudRecogResult)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0X80081DE. error = ");
        ((StringBuilder)localObject).append(paramARCloudRecogResult.getMessage());
        QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
      }
      this.ax = 0L;
      this.ay = 0L;
    }
    else
    {
      l1 = 3000L;
      if (ARLocalFaceRecog.a()) {
        l1 = 4500L;
      }
      if (this.ax == 0L) {
        this.ax = System.currentTimeMillis();
      }
      this.ay = System.currentTimeMillis();
      if ((this.ax > 0L) && (this.ay - this.ax > l1))
      {
        if (QLog.isColorLevel())
        {
          paramARCloudRecogResult = new StringBuilder();
          paramARCloudRecogResult.append("[ScanStarFace]onARRecogComplete stop Local Face Recog,lost all faces more than ");
          paramARCloudRecogResult.append(l1);
          QLog.d("AREngine_QQARSession", 2, paramARCloudRecogResult.toString());
        }
        a(4L);
        this.ax = -1L;
        this.ah.b = true;
        a(this.ah, this.ai);
        this.ah = null;
        this.ai = null;
        Q();
        break label1774;
        if (paramARCloudRecogResult != null)
        {
          localObject = ARRecognition.a(this.z.recognitions, paramARCloudRecogResult);
          l1 = ((ARRecognition.RecognitionResult)localObject).a;
          bool1 = ((ARRecognition.RecognitionResult)localObject).b;
          bool2 = ARRecognition.b(this.z.recognitions, l1);
          if ((this.am == null) || (l1 == 128L)) {
            break label1867;
          }
          e(false);
          if (!this.an) {
            break label1867;
          }
          b(1L);
          this.an = false;
          break label1867;
          if (l1 == 4L)
          {
            if (bool2)
            {
              a(paramARCloudRecogResult.f);
            }
            else if (ARRecognition.a(this.z.recognitions, 8L, 1L))
            {
              a(paramARCloudRecogResult.f);
            }
            else if ((this.af == null) || (this.af.b == 2))
            {
              a(1L);
              a(paramARCloudRecogResult.f);
            }
          }
          else if (l1 == 2L)
          {
            if (bool2)
            {
              a(paramARCloudRecogResult.e);
            }
            else if (ARRecognition.a(this.z.recognitions, 2L, 1L))
            {
              a(paramARCloudRecogResult.e);
            }
            else if ((this.af == null) || (this.af.b == 2))
            {
              a(1L);
              a(paramARCloudRecogResult.e);
            }
          }
          else if (l1 == 128L)
          {
            if (bool2)
            {
              b(paramARCloudRecogResult.j);
            }
            else
            {
              if (this.ao)
              {
                if (this.am != null) {
                  e(false);
                }
                if (this.an) {
                  this.an = false;
                }
                return;
              }
              if (ARRecognition.a(this.z.recognitions, 128L, 1L))
              {
                b(paramARCloudRecogResult.j);
              }
              else if ((this.af == null) || (this.af.b == 2))
              {
                a(1L);
                this.an = true;
                b(paramARCloudRecogResult.j);
              }
            }
          }
          else if (l1 == 1L)
          {
            if (bool2)
            {
              a(paramARCloudRecogResult.d);
            }
            else
            {
              if (bool1) {
                b(1L);
              }
              a(paramARCloudRecogResult.d);
            }
          }
          else if (l1 == 2048L) {
            if (bool2)
            {
              a(paramARCloudRecogResult.k);
            }
            else if (ARRecognition.a(this.z.recognitions, 2048L, 1L))
            {
              a(paramARCloudRecogResult.k);
            }
            else if ((this.af == null) || (this.af.b == 2))
            {
              a(1L);
              a(paramARCloudRecogResult.k);
              break label1774;
              l1 = this.G;
              if (l1 != 0L)
              {
                if (paramARLocalRecogResult == null) {
                  return;
                }
                if (paramARLocalRecogResult.b != null) {
                  a(paramARLocalRecogResult.b, this.ag);
                } else if (paramARLocalRecogResult.c != null) {
                  a(paramARLocalRecogResult.c, this.ai);
                }
              }
              else
              {
                l1 = this.H;
                if (l1 != 0L)
                {
                  if (paramARCloudRecogResult == null) {
                    return;
                  }
                  if (ARCloudObjectClassifyResult.a(paramARCloudRecogResult.e)) {
                    a(paramARCloudRecogResult.e);
                  } else if (ARMIGObjectClassifyResult.a(paramARCloudRecogResult.j)) {
                    b(paramARCloudRecogResult.j);
                  } else if (ARCloudMarkerRecogResult.a(paramARCloudRecogResult.d)) {
                    P();
                  } else if (ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.f)) {
                    Q();
                  } else if (ARCloudSceneRecogResult.a(paramARCloudRecogResult.k)) {
                    a(paramARCloudRecogResult.k);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (paramARLocalRecogResult != null) {
      if (paramARLocalRecogResult.b != null)
      {
        this.ag = paramARLocalRecogResult.b;
        if ((paramARLocalRecogResult.b.i != null) && (!paramARLocalRecogResult.b.i.d()))
        {
          this.af = null;
          this.ag = null;
        }
      }
      else if (paramARLocalRecogResult.c != null)
      {
        this.ai = paramARLocalRecogResult.c;
      }
    }
    return;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onMultiARAnimationInteraction.");
    a(new QQARSession.25(this, paramArVideoResourceInfo, paramARRenderMangerInnerCallback));
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRenderManagerCallback. onARAnimationStart. key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", remainPlayCount = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    a(new QQARSession.21(this, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onARCloudSelectImageComplete. result = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
      if (this.aD == 0L) {
        this.aD = System.currentTimeMillis();
      }
      if (this.aQ > 0L)
      {
        long l1 = System.currentTimeMillis() - this.aQ;
        if (l1 > 0L) {
          this.aR += l1;
        }
        this.aQ = 0L;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    paramArCloudConfigInfo = new StringBuilder();
    paramArCloudConfigInfo.append("onARMarkerResourceDownloadComplete. result = ");
    paramArCloudConfigInfo.append(paramBoolean);
    paramArCloudConfigInfo.append(" type  ");
    paramArCloudConfigInfo.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, paramArCloudConfigInfo.toString());
    if ((this.v) && (this.a != 2)) {}
  }
  
  public void a(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadComplete result=%s config=%s", new Object[] { Boolean.valueOf(paramBoolean), paramArCloudConfigInfo }));
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.m != null) && (paramArCloudConfigInfo.m.b) && (paramArCloudConfigInfo.m.a) && (!TextUtils.isEmpty(paramArCloudConfigInfo.m.c)) && (!paramArCloudConfigInfo.f()))
    {
      this.B.a(0, paramArCloudConfigInfo.m.c);
      this.p = 1;
      this.o = paramArCloudConfigInfo;
      return;
    }
    d(paramBoolean, paramArCloudConfigInfo);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    UniformGLRenderManager localUniformGLRenderManager = this.R;
    if (localUniformGLRenderManager != null) {
      localUniformGLRenderManager.a(0, paramArrayOfFloat);
    }
  }
  
  public boolean a(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    ARMIGObjectClassifyResult localARMIGObjectClassifyResult = this.am;
    if (localARMIGObjectClassifyResult != null) {
      return localARMIGObjectClassifyResult.a(paramARMIGObjectClassifyResult) ^ true;
    }
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (this.a == 2)
    {
      onPreviewFrame(paramArrayOfByte, null);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.aQ == 0L) {
      this.aQ = System.currentTimeMillis();
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.v) && (this.a == 2))
    {
      AREngineCallback localAREngineCallback = this.B;
      if (localAREngineCallback != null) {
        localAREngineCallback.a(2, paramInt);
      }
    }
  }
  
  public void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeLocalRecog. recogType = ");
    localStringBuilder.append(paramLong);
    QLog.d("AREngine_QQARSession", 1, localStringBuilder.toString());
    if (this.h != null)
    {
      if ((1L & paramLong) != 0L)
      {
        this.af = null;
        this.ag = null;
        this.as = 0L;
        this.at = 0L;
        this.au = 0L;
        this.av = 0L;
      }
      if ((0x4 & paramLong) != 0L)
      {
        this.ah = null;
        this.ai = null;
        this.ax = 0L;
        this.ay = 0L;
      }
      this.h.d(paramLong);
    }
  }
  
  public void b(Runnable paramRunnable, long paramLong)
  {
    if ((this.w) && (this.a == 2)) {
      a(paramRunnable, paramLong);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRenderManagerCallback. onARAnimationComplete. key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", remainPlayCount = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    a(new QQARSession.22(this, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onARCloudPretreatComplete. result = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    if ((paramBoolean) && (this.aI))
    {
      this.aI = false;
      ReportController.b(null, "dc00898", "", "", "0X80085AD", "0X80085AD", 0, 0, "", "", "", "");
    }
  }
  
  public void b(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.m != null) && (paramArCloudConfigInfo.m.b) && (paramArCloudConfigInfo.m.a) && (!TextUtils.isEmpty(paramArCloudConfigInfo.m.c)) && (!paramArCloudConfigInfo.f()))
    {
      this.B.a(0, paramArCloudConfigInfo.m.c);
      this.o = paramArCloudConfigInfo;
      this.p = 2;
      return;
    }
    e(paramBoolean, paramArCloudConfigInfo);
  }
  
  public void c()
  {
    QLog.i("AREngine_QQARSession", 1, "onARCloudUploadStart.");
    this.aP += 1;
  }
  
  public void c(int paramInt)
  {
    if ((this.v) && (this.a == 2))
    {
      AREngineCallback localAREngineCallback = this.B;
      if (localAREngineCallback != null) {
        localAREngineCallback.a(2, paramInt);
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRenderManagerCallback. onARAnimationPlayInterrupt. key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", remainPlayCount = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    a(new QQARSession.23(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    ARCloudRecogResult localARCloudRecogResult = this.aj;
    if ((localARCloudRecogResult != null) && (localARCloudRecogResult.j != null)) {
      a(new QQARSession.9(this, paramBoolean));
    }
  }
  
  public void c(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.m != null) && (paramArCloudConfigInfo.m.b) && (paramArCloudConfigInfo.m.a) && (!TextUtils.isEmpty(paramArCloudConfigInfo.m.c)) && (!paramArCloudConfigInfo.f()))
    {
      this.B.a(0, paramArCloudConfigInfo.m.c);
      this.o = paramArCloudConfigInfo;
      this.p = 2;
      return;
    }
    f(paramBoolean, paramArCloudConfigInfo);
  }
  
  public void d(int paramInt)
  {
    QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus on workMode=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 1) && (this.aS != paramInt)) {
      a(new QQARSession.28(this));
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRenderManagerCallback. onARAnimationPlayError. key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", remainPlayCount = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    a(new QQARSession.24(this, paramInt));
  }
  
  public void d(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.aK;
    long l1;
    if (l2 >= 1000L) {
      l1 = 0L;
    } else {
      l1 = 1000L - l2;
    }
    QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadCompleteInternal result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
    a(new QQARSession.14(this, paramBoolean, paramArCloudConfigInfo), l1);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public long e()
  {
    return this.z.mARCloudUploadDelayTime;
  }
  
  public long f()
  {
    if ((this.e instanceof ScanTorchActivity)) {
      return ((ScanTorchActivity)this.e).getTimeActivityVisible();
    }
    return 0L;
  }
  
  public void g()
  {
    QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadStart.");
    this.aK = System.currentTimeMillis();
    if ((this.v) && (this.a == 2))
    {
      AREngineCallback localAREngineCallback = this.B;
      if (localAREngineCallback != null) {
        localAREngineCallback.a(0, 4);
      }
    }
  }
  
  public void h()
  {
    QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadStart.");
    this.aK = System.currentTimeMillis();
    a(new QQARSession.15(this));
  }
  
  public void i()
  {
    QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadStart.");
    this.aK = System.currentTimeMillis();
    a(new QQARSession.17(this));
  }
  
  public int j()
  {
    a(new QQARSession.1(this));
    return 0;
  }
  
  public void k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARengine status resume now start. + mCurrentSessionStatus:=");
    localStringBuilder.append(this.a);
    QLog.d("AREngine_QQARSession", 1, localStringBuilder.toString());
    if ((this.v) && (this.a != 0) && (this.a != 4) && (this.a != 5))
    {
      if (this.a == 2) {
        return;
      }
      this.R.a(this);
      f(this.aw);
      this.af = null;
      this.ag = null;
      this.ah = null;
      this.ai = null;
      this.aj = null;
      this.ak = false;
      this.ao = false;
      this.am = null;
      this.an = false;
      this.ap = 0L;
      this.aq = null;
      this.ar = null;
      this.as = 0L;
      this.at = 0L;
      this.au = 0L;
      this.av = 0L;
      this.aw = false;
      this.n = false;
      this.ax = 0L;
      this.ay = 0L;
      if ((!this.k) && (this.aS != 1))
      {
        N();
        if (!ARRecognition.b(this.z.recognitions, 1L))
        {
          a(5L);
        }
        else
        {
          a(4L);
          b(1L);
        }
        this.y = true;
        this.a = 2;
        QLog.d("AREngine_QQARSession", 1, "ARengine status resume now end.");
        return;
      }
      b(4096L);
      this.h.a(true, this.aa, this.ab);
      this.y = true;
      this.a = 2;
    }
  }
  
  public void m()
  {
    QLog.i("AREngine_QQARSession", 1, "ARengine status  pause. now ");
    if (this.v)
    {
      if (this.a != 2) {
        return;
      }
      S();
      x();
      M();
      Object localObject = this.h;
      boolean bool;
      if ((localObject != null) && (!((ARLocalControl)localObject).b(4L))) {
        bool = true;
      } else {
        bool = false;
      }
      a(5L);
      if (bool)
      {
        localObject = this.B;
        if (localObject != null) {
          ((AREngineCallback)localObject).a(bool);
        }
      }
      this.ao = true;
      if (this.am != null) {
        e(true);
      }
      this.aG = false;
      U();
      if ((this.h != null) && (this.aS == 1))
      {
        a(4096L);
        this.h.a(false, this.aa, this.ab);
      }
      localObject = this.T;
      if (localObject != null) {
        ((ARMarkerResourceManager)localObject).c();
      }
      this.y = false;
      this.a = 3;
      this.R.a(null);
    }
  }
  
  public void n()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop start. mCurEngineState = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    if (this.a == 5) {
      return;
    }
    this.a = 4;
    this.n = false;
    localObject = this.ad;
    if (localObject != null)
    {
      b((Runnable)localObject);
      this.ad = null;
    }
    t();
    a(new QQARSession.3(this));
  }
  
  public void o()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uninit start. mIsInited = ");
    localStringBuilder.append(this.v);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    if (!this.v) {
      return;
    }
    CameraProxy.a().c(this);
    a(new QQARSession.4(this));
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.v) && (this.R != null)) {
      if ((this.w) && (this.a == 2))
      {
        paramCamera = this.R;
        paramCamera.a(paramCamera.k() + 1L);
        paramCamera = this.h;
        if ((paramCamera != null) && ((!paramCamera.b(1L)) || (!this.h.b(4L)) || (!this.h.b(4096L))) && (!T()))
        {
          if ((this.aS == 0) || ((this.aS == 1) && (this.aN.i() == 0) && (this.aN.f()))) {
            this.h.a(this.R.k(), paramArrayOfByte);
          }
          if (this.k)
          {
            paramCamera = this.R;
            paramCamera.b(paramCamera.k());
            paramCamera = this.R;
            if (paramCamera != null) {
              paramCamera.b();
            }
          }
          else
          {
            if (!this.h.b(1L))
            {
              paramCamera = this.af;
              if ((paramCamera != null) && (paramCamera.b == 2)) {}
            }
            else if (!this.h.b(4L))
            {
              paramCamera = this.ah;
              if ((paramCamera != null) && (paramCamera.c.size() == 0)) {}
            }
            else
            {
              if ((this.h.b(4L)) || (!this.h.c(4L))) {
                break label345;
              }
            }
            paramCamera = this.R;
            paramCamera.b(paramCamera.k());
            paramCamera = this.R;
            if (paramCamera != null) {
              paramCamera.b();
            }
          }
        }
        else
        {
          paramCamera = this.R;
          paramCamera.b(paramCamera.k());
          paramCamera = this.R;
          if (paramCamera != null) {
            paramCamera.b();
          }
        }
        label345:
        paramCamera = this.S;
        if (paramCamera != null) {
          paramCamera.a(paramArrayOfByte);
        }
      }
      else
      {
        paramArrayOfByte = this.R;
        paramArrayOfByte.a(paramArrayOfByte.k() + 1L);
        paramArrayOfByte = this.R;
        paramArrayOfByte.b(paramArrayOfByte.k());
        paramArrayOfByte = this.R;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.b();
        }
      }
    }
  }
  
  public boolean u()
  {
    return this.v;
  }
  
  public boolean v()
  {
    return this.w;
  }
  
  public int w()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start startInternal. mCurEngineState = ");
    localStringBuilder.append(this.a);
    QLog.d("AREngine_QQARSession", 1, localStringBuilder.toString());
    if ((this.a == 0) && (CameraProxy.a().g()))
    {
      this.az = 0;
      this.aA = System.currentTimeMillis();
      this.aB = 0L;
      this.aC = 0;
      this.aD = 0L;
      this.aE = 0L;
      this.aa = CameraProxy.a().h();
      this.ab = CameraProxy.a().i();
      this.ac = CameraProxy.a().j();
      this.Z = UniformGLRenderManagerImpl.c;
      this.Y = UniformGLRenderManagerImpl.b;
      this.Q = new ARNativeBridge();
      if (!this.Q.isLoadSoSuccess())
      {
        QLog.d("AREngine_QQARSession", 1, "startAR internal fail");
        this.Q = null;
        this.w = false;
        e(6);
        return 6;
      }
      H();
      this.O.a(this.e, this);
      if ((this.h != null) && (!I()))
      {
        e(7);
        return 7;
      }
      if (!ARRecognition.b(this.z.recognitions, 1L))
      {
        a(5L);
      }
      else
      {
        a(4L);
        b(1L);
      }
      if ((this.S != null) && (!J()))
      {
        e(3);
        return 3;
      }
      this.a = 2;
      this.R.a(this);
      e(0);
      return 0;
    }
    return -1;
  }
  
  public void x()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRender.");
    Object localObject = this.R;
    if ((localObject != null) && (this.aq != null))
    {
      ((UniformGLRenderManager)localObject).j();
      if (CameraProxy.a().g()) {
        CameraProxy.a().a(this.Y, this.Z);
      }
      if ((this.v) && (this.B != null) && ((this.a == 2) || (this.a == 4)))
      {
        localObject = new ARTarget(this.aq);
        this.B.a(this.ap, false, (ARTarget)localObject);
      }
    }
    this.ap = 0L;
    this.aq = null;
    this.ar = null;
  }
  
  public void y()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRenderOnly.");
    if ((this.v) && (this.a == 2))
    {
      UniformGLRenderManager localUniformGLRenderManager = this.R;
      if (localUniformGLRenderManager != null) {
        localUniformGLRenderManager.j();
      }
    }
  }
  
  public boolean z()
  {
    return this.aq != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession
 * JD-Core Version:    0.7.0.1
 */