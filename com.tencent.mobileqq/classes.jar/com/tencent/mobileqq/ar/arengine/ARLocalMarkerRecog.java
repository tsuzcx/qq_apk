package com.tencent.mobileqq.ar.arengine;

import android.opengl.Matrix;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ytcommon.util.YTCommonInterface;
import com.youtu.arsdk.AROption;
import com.youtu.arsdk.ARPatternInfo;
import com.youtu.arsdk.ARShell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ARLocalMarkerRecog
{
  private static boolean m = false;
  private ARLocalMarkerRecog.ARLocalMarkerRecogCallback A = null;
  private Object B = new Object();
  private Object C = new Object();
  private ArrayList<ARLocalMarkerRecog.MarkerState> D = null;
  private int E = 0;
  private int F = 0;
  private int G = 0;
  private int H = 0;
  private long I = 0L;
  private long J = 0L;
  private int K = 0;
  private String L = "";
  private int M = 0;
  private int N = 0;
  private long O = 0L;
  private long P = 0L;
  private long Q = 0L;
  private long R;
  private final int S = 5000;
  Object a = new Object();
  private final int b = 25;
  private final int c = 800;
  private ARLocalMarkerRecog.ProcessWorker d = null;
  private int e = 0;
  private int f = 0;
  private FramePerformanceMonitor g;
  private AROption h;
  private Object i = new Object();
  private int j = 0;
  private int k = 0;
  private float[] l = null;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private ArConfigInfo t = null;
  private ArrayList<ArCloudConfigInfo> u = null;
  private Map<String, ArCloudConfigInfo> v = null;
  private int w = 2;
  private int x = 0;
  private int y = 0;
  private int z = -1;
  
  private boolean b(String paramString1, String paramString2, ArCloudConfigInfo arg3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addNewMarkerDynamically. markerName = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", markerFilePath = ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)localObject).toString());
    localObject = new ARPatternInfo();
    int i1 = 0;
    while (i1 < ARShell.getMarkerCount())
    {
      ((ARPatternInfo)localObject).name = "";
      ARShell.getMarkerInfo(i1, (ARPatternInfo)localObject);
      if (((ARPatternInfo)localObject).name.equals(paramString1))
      {
        QLog.i("ARCloudEngine", 1, "addNewMarkerDynamically. marker already exist.");
        return true;
      }
      i1 += 1;
    }
    this.v.put(???.j.a, ???);
    synchronized (this.C)
    {
      QLog.i("ARCloudEngine", 1, "addNewMarkerDynamically start.");
      System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("YouTuNative. nativeAddMarker start. markerName = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)localObject).toString());
      i1 = ARShell.nativeAddMarker(paramString1, paramString2);
      paramString1 = new StringBuilder();
      paramString1.append("YouTuNative. nativeAddMarker end. ret = ");
      paramString1.append(i1);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, paramString1.toString());
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically successfully.");
      return true;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  /* Error */
  private boolean i()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 100	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:r	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +41 -> 49
    //   11: iload_1
    //   12: iconst_1
    //   13: iadd
    //   14: istore_2
    //   15: iload_2
    //   16: bipush 20
    //   18: if_icmpge +31 -> 49
    //   21: ldc2_w 256
    //   24: invokestatic 263	java/lang/Thread:sleep	(J)V
    //   27: iload_2
    //   28: istore_1
    //   29: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq -30 -> 2
    //   35: ldc 176
    //   37: iconst_2
    //   38: ldc_w 268
    //   41: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: iload_2
    //   45: istore_1
    //   46: goto -44 -> 2
    //   49: aload_0
    //   50: getfield 122	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:C	Ljava/lang/Object;
    //   53: astore 4
    //   55: aload 4
    //   57: monitorenter
    //   58: ldc 176
    //   60: iconst_1
    //   61: ldc_w 272
    //   64: invokestatic 185	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: invokestatic 275	com/youtu/arsdk/ARShell:nativeStop	()Z
    //   70: pop
    //   71: ldc 176
    //   73: iconst_1
    //   74: ldc_w 277
    //   77: invokestatic 185	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: ldc 176
    //   82: iconst_1
    //   83: ldc_w 279
    //   86: invokestatic 185	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: invokestatic 282	com/youtu/arsdk/ARShell:nativeDestroy	()Z
    //   92: pop
    //   93: ldc 176
    //   95: iconst_1
    //   96: ldc_w 284
    //   99: invokestatic 185	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload 4
    //   104: monitorexit
    //   105: iconst_1
    //   106: ireturn
    //   107: astore 5
    //   109: aload 4
    //   111: monitorexit
    //   112: aload 5
    //   114: athrow
    //   115: astore 4
    //   117: aload 4
    //   119: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore 4
    //   126: goto -99 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	ARLocalMarkerRecog
    //   1	45	1	i1	int
    //   14	31	2	i2	int
    //   6	2	3	bool	boolean
    //   115	3	4	localException1	Exception
    //   124	1	4	localException2	Exception
    //   107	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   58	105	107	finally
    //   109	112	107	finally
    //   2	7	115	java/lang/Exception
    //   29	44	115	java/lang/Exception
    //   49	58	115	java/lang/Exception
    //   112	115	115	java/lang/Exception
    //   21	27	124	java/lang/Exception
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dataReport. mDataReportRecogQuality = ");
    localStringBuilder.append(this.E);
    localStringBuilder.append(", mDataReportLoadedFeatureTimeLen = ");
    localStringBuilder.append(this.F);
    localStringBuilder.append(", mDataReportLoadedFeatureCnt = ");
    localStringBuilder.append(this.G);
    localStringBuilder.append(", mDataReportFirstRecogSuccessTimeLen = ");
    localStringBuilder.append(this.H);
    localStringBuilder.append(", mDataReportFirstRecogSuccessStartTime = ");
    localStringBuilder.append(this.I);
    localStringBuilder.append(", mDataReportFirstRecogSuccessEndTime = ");
    localStringBuilder.append(this.J);
    localStringBuilder.append(", mDataReportFirstRecogSuccessFrameCnt = ");
    localStringBuilder.append(this.K);
    localStringBuilder.append(", mDataReportFirstRecogSuccessFeatureId = ");
    localStringBuilder.append(this.L);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("YOUTU_AR_PERF:, init sdk cost  = ");
    localStringBuilder.append(this.Q);
    localStringBuilder.append(", addFeature(1 marker) cost  = ");
    int i1 = this.G;
    if (i1 == 0) {
      i1 = 0;
    } else {
      i1 = this.F / i1;
    }
    localStringBuilder.append(i1);
    localStringBuilder.append(", recog cost = ");
    i1 = this.M;
    long l1;
    if (i1 == 0) {
      l1 = 0L;
    } else {
      l1 = this.O / i1;
    }
    localStringBuilder.append(l1);
    localStringBuilder.append(", track cost = ");
    i1 = this.N;
    if (i1 == 0) {
      l1 = 0L;
    } else {
      l1 = this.P / i1;
    }
    localStringBuilder.append(l1);
    localStringBuilder.append(", recog suc from start  = ");
    localStringBuilder.append(this.H);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    ARReport.a().a(this.F, this.G, this.H, this.K, this.E, this.L);
    this.N = 0;
    this.M = 0;
    this.P = 0L;
    this.O = 0L;
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (this.o))
    {
      if (this.s) {
        return;
      }
      ARLocalMarkerRecog.ProcessWorker localProcessWorker = this.d;
      if (localProcessWorker != null) {
        localProcessWorker.a(paramLong, paramArrayOfByte);
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, ArConfigInfo paramArConfigInfo, ArrayList<ArCloudConfigInfo> paramArrayList, ARLocalMarkerRecog.ARLocalMarkerRecogCallback paramARLocalMarkerRecogCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init start. imageWidth = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", imageHeight = ");
    localStringBuilder.append(paramInt2);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    long l1 = System.currentTimeMillis();
    if (this.n) {
      return true;
    }
    boolean bool1 = false;
    this.j = 0;
    this.k = 0;
    this.e = paramInt1;
    this.f = paramInt2;
    this.t = paramArConfigInfo;
    this.u = paramArrayList;
    this.D = new ArrayList();
    this.v = new HashMap();
    this.A = paramARLocalMarkerRecogCallback;
    this.g = null;
    this.n = false;
    this.o = false;
    this.p = false;
    this.q = false;
    this.r = false;
    this.E = 0;
    this.F = 0;
    this.G = 0;
    this.H = 0;
    this.I = 0L;
    this.J = 0L;
    this.K = 0;
    this.L = "";
    this.R = 0L;
    try
    {
      long l2 = System.currentTimeMillis();
      if (!ARShell.loadNativeLibrary())
      {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm failed. loadNativeLibrary failed.");
        ARReport.a().e(System.currentTimeMillis() - l2, false);
      }
      else
      {
        ARReport.a().e(System.currentTimeMillis() - l2, true);
        boolean bool2 = h();
        if (!bool2) {
          i();
        }
        bool1 = bool2;
      }
    }
    catch (UnsatisfiedLinkError paramArConfigInfo)
    {
      paramArConfigInfo.printStackTrace();
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm failed. loadNativeLibrary failed. UnsatisfiedLinkError.");
    }
    this.n = bool1;
    paramArConfigInfo = new StringBuilder();
    paramArConfigInfo.append("init end. mIsInited = ");
    paramArConfigInfo.append(this.n);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, paramArConfigInfo.toString());
    ARReport.a().d(System.currentTimeMillis() - l1, this.n);
    return this.n;
  }
  
  public boolean a(String paramString1, String paramString2, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (!this.o) {
      return false;
    }
    if (!paramArCloudConfigInfo.b.equalsIgnoreCase("2.0"))
    {
      paramString1 = new StringBuilder();
      paramString1.append("addNewMarkerDynamically failed. sdk version error. sdk version = ");
      paramString1.append(paramArCloudConfigInfo.b);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, paramString1.toString());
      return false;
    }
    Object localObject = this.B;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.D.size())
        {
          if (((ARLocalMarkerRecog.MarkerState)this.D.get(i1)).a.equals(paramString1))
          {
            ((ARLocalMarkerRecog.MarkerState)this.D.get(i1)).b = paramString2;
            ((ARLocalMarkerRecog.MarkerState)this.D.get(i1)).c = paramArCloudConfigInfo;
            return true;
          }
        }
        else
        {
          ARLocalMarkerRecog.MarkerState localMarkerState = new ARLocalMarkerRecog.MarkerState(null);
          localMarkerState.a = paramString1;
          localMarkerState.b = paramString2;
          localMarkerState.c = paramArCloudConfigInfo;
          localMarkerState.d = false;
          localMarkerState.e = false;
          this.D.add(localMarkerState);
          this.R = System.currentTimeMillis();
          return true;
        }
      }
      finally
      {
        continue;
        throw paramString1;
        continue;
        i1 += 1;
      }
    }
  }
  
  public float[] a(int paramInt1, int paramInt2)
  {
    if (!this.n) {
      return null;
    }
    if ((this.j == paramInt1) && (this.k == paramInt2)) {
      return this.l;
    }
    this.j = paramInt1;
    this.k = paramInt2;
    float[] arrayOfFloat = new float[16];
    ARShell.getProjectionMatrix(25.0F, 800.0F, arrayOfFloat, false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("YouTuNative. getProjectionMatrix. proMatrix[0] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[0]);
    ((StringBuilder)localObject).append(", proMatrix[1] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[1]);
    ((StringBuilder)localObject).append(", proMatrix[2] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[2]);
    ((StringBuilder)localObject).append(", proMatrix[3] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[3]);
    ((StringBuilder)localObject).append(", proMatrix[4] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[4]);
    ((StringBuilder)localObject).append(", proMatrix[5] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[5]);
    ((StringBuilder)localObject).append(", proMatrix[6] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[6]);
    ((StringBuilder)localObject).append(", proMatrix[7] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[7]);
    ((StringBuilder)localObject).append(", proMatrix[8] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[8]);
    ((StringBuilder)localObject).append(", proMatrix[9] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[9]);
    ((StringBuilder)localObject).append(", proMatrix[10] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[10]);
    ((StringBuilder)localObject).append(", proMatrix[11] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[11]);
    ((StringBuilder)localObject).append(", proMatrix[12] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[12]);
    ((StringBuilder)localObject).append(", proMatrix[13] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[13]);
    ((StringBuilder)localObject).append(", proMatrix[14] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[14]);
    ((StringBuilder)localObject).append(", proMatrix[15] = ");
    ((StringBuilder)localObject).append(arrayOfFloat[15]);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)localObject).toString());
    paramInt1 = this.j;
    float f1 = paramInt1;
    paramInt2 = this.k;
    f1 = f1 * 1.0F / paramInt2;
    int i1 = this.f;
    float f2 = i1;
    int i2 = this.e;
    f2 = f2 * 1.0F / i2;
    if (f1 > f2)
    {
      f1 = i2 * paramInt1 * 1.0F / i1 / paramInt2 * 1.0F;
      arrayOfFloat[0] *= f1;
      arrayOfFloat[8] *= f1;
    }
    else if (f1 < f2)
    {
      f1 = i1 * paramInt2 * 1.0F / i2 / paramInt1 * 1.0F;
      arrayOfFloat[5] *= f1;
      arrayOfFloat[9] *= f1;
    }
    this.l = arrayOfFloat;
    arrayOfFloat = new float[16];
    if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g)) {
      Matrix.setRotateM(arrayOfFloat, 0, 90.0F, 0.0F, 0.0F, 1.0F);
    } else {
      Matrix.setRotateM(arrayOfFloat, 0, 270.0F, 0.0F, 0.0F, 1.0F);
    }
    localObject = this.l;
    Matrix.multiplyMM((float[])localObject, 0, arrayOfFloat, 0, (float[])localObject, 0);
    return this.l;
  }
  
  public boolean b()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "start start.");
    if (this.o) {
      return true;
    }
    this.D.clear();
    this.w = 2;
    if (this.d == null) {
      this.d = new ARLocalMarkerRecog.ProcessWorker(this);
    }
    this.H = 0;
    this.I = System.currentTimeMillis();
    this.J = 0L;
    this.K = 0;
    this.L = "";
    this.o = true;
    this.s = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start end. mIsStarted = ");
    localStringBuilder.append(this.o);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    return true;
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pause. mIsPause = ");
    localStringBuilder.append(this.s);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    if (this.s) {
      return;
    }
    this.s = true;
    this.w = 2;
  }
  
  public boolean d()
  {
    return this.s;
  }
  
  public void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resume. mIsPause = ");
    localStringBuilder.append(this.s);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    if (!this.s) {
      return;
    }
    this.H = 0;
    this.I = System.currentTimeMillis();
    this.J = 0L;
    this.K = 0;
    this.L = "";
    this.s = false;
  }
  
  public void f()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "stop start.");
    if (!this.o) {
      return;
    }
    this.D.clear();
    this.w = 2;
    Object localObject = this.d;
    if (localObject != null)
    {
      ((ARLocalMarkerRecog.ProcessWorker)localObject).a();
      this.d = null;
    }
    this.g = null;
    a();
    this.o = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop end. mIsStarted = ");
    ((StringBuilder)localObject).append(this.o);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)localObject).toString());
  }
  
  public void g()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "uninit start.");
    if (!this.n) {
      return;
    }
    this.A = null;
    i();
    this.n = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uninit end. mIsInited = ");
    localStringBuilder.append(this.n);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
  }
  
  boolean h()
  {
    long l1 = System.currentTimeMillis();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("YouTuNative. initAlgorithm. start = ");
    ((StringBuilder)???).append(l1);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
    int i1 = YTCommonInterface.initAuthForQQ(BaseApplicationImpl.getApplication().getApplicationContext());
    ??? = new StringBuilder();
    ((StringBuilder)???).append("YouTuNative. initAlgorithm. initAuth ret = ");
    ((StringBuilder)???).append(i1);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
    this.h = new AROption();
    ??? = this.h;
    ((AROption)???).width = this.e;
    ((AROption)???).height = this.f;
    ((AROption)???).cameraParamPath = "";
    ((AROption)???).cachePath = "";
    if (ARDeviceInfo.a() == 0)
    {
      ??? = this.h;
      ((AROption)???).recognizeQuality = 3;
      ((AROption)???).trackQuality = 1;
      ((AROption)???).performanceQuality = 3;
    }
    else
    {
      ??? = this.h;
      ((AROption)???).recognizeQuality = 3;
      ((AROption)???).trackQuality = 1;
      ((AROption)???).performanceQuality = 2;
    }
    label933:
    StringBuilder localStringBuilder;
    synchronized (this.C)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("YouTuNative. ARSDKVersion = ");
      ((StringBuilder)???).append(ARShell.getSDKVersion());
      QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeCreate start.");
      ARShell.nativeCreate(BaseApplicationImpl.getApplication().getApplicationContext());
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeCreate end.");
      ??? = new StringBuilder();
      ((StringBuilder)???).append("YouTuNative. nativeInitialize start. width = ");
      ((StringBuilder)???).append(this.h.width);
      ((StringBuilder)???).append(", height = ");
      ((StringBuilder)???).append(this.h.height);
      ((StringBuilder)???).append(", cameraParamPath = ");
      ((StringBuilder)???).append(this.h.cameraParamPath);
      ((StringBuilder)???).append(", recognizeQuality = ");
      ((StringBuilder)???).append(this.h.recognizeQuality);
      ((StringBuilder)???).append(", trackQuality = ");
      ((StringBuilder)???).append(this.h.trackQuality);
      ((StringBuilder)???).append(", performanceQuality = ");
      ((StringBuilder)???).append(this.h.performanceQuality);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
      i1 = ARShell.nativeInitialize(this.h);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("YouTuNative. nativeInitialize end. ret = ");
      ((StringBuilder)???).append(i1);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart start.");
      ARShell.nativeStart();
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart end.");
      this.Q = (System.currentTimeMillis() - l1);
      ??? = this.t;
      int i7 = 0;
      int i3;
      int i6;
      if ((??? != null) && (((ArConfigInfo)???).mArCloudConfigInfos != null))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("add marker for local. marker count = ");
        ((StringBuilder)???).append(this.t.mArCloudConfigInfos.size());
        QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
        i5 = 0;
        i3 = 0;
        for (i4 = 0;; i4 = i2)
        {
          i1 = i3;
          i2 = i4;
          if (i5 >= this.t.mArCloudConfigInfos.size()) {
            break;
          }
          ??? = (ArCloudConfigInfo)this.t.mArCloudConfigInfos.get(i5);
          ??? = new StringBuilder();
          ((StringBuilder)???).append("add marker for local. resource info = ");
          ((StringBuilder)???).append(((ArCloudConfigInfo)???).toString());
          QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
          i1 = i3;
          i2 = i4;
          if (((ArCloudConfigInfo)???).b.equalsIgnoreCase("2.0"))
          {
            i1 = i3;
            i2 = i4;
            if (((ArCloudConfigInfo)???).j != null) {
              if (((ArCloudConfigInfo)???).j.a == null)
              {
                i1 = i3;
                i2 = i4;
              }
              else
              {
                String str1 = ((ArCloudConfigInfo)???).j.a;
                ??? = ((ArCloudConfigInfo)???).j.d;
                ??? = new StringBuilder();
                ((StringBuilder)???).append("YouTuNative. nativeAddMarker start. markerName = ");
                ((StringBuilder)???).append(str1);
                ((StringBuilder)???).append(", markerFilePath = ");
                ((StringBuilder)???).append((String)???);
                QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
                try
                {
                  synchronized (this.C)
                  {
                    i6 = ARShell.nativeAddMarker(str1, (String)???);
                  }
                  i2 = i4 + 1;
                }
                catch (Exception localException)
                {
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("nativeAddMarker = ");
                  ((StringBuilder)???).append(localException.getMessage());
                  QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
                  i6 = 0;
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("YouTuNative. nativeAddMarker end. ret = ");
                  ((StringBuilder)???).append(i6);
                  QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
                  i1 = i3;
                  i2 = i4;
                  if (i6 != 0) {
                    break label933;
                  }
                }
                i1 = i3 + 1;
                this.v.put(localObject2.j.a, localObject2);
                break label933;
                throw localObject2;
              }
            }
          }
          i5 += 1;
          i3 = i1;
        }
      }
      i1 = 0;
      int i2 = 0;
      int i4 = i1;
      int i5 = i2;
      if (!QQARSession.g)
      {
        i4 = i1;
        i5 = i2;
        if (this.u != null)
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("add marker for cloud. marker count = ");
          ((StringBuilder)localObject3).append(this.u.size());
          QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)localObject3).toString());
          i3 = i7;
          for (;;)
          {
            i4 = i1;
            i5 = i2;
            if (i3 >= this.u.size()) {
              break;
            }
            localObject3 = (ArCloudConfigInfo)this.u.get(i3);
            i4 = i1;
            i5 = i2;
            if (localObject3 != null)
            {
              i4 = i1;
              i5 = i2;
              if (((ArCloudConfigInfo)localObject3).j != null)
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("add marker for cloud. resource info = ");
                ((StringBuilder)???).append(((ArCloudConfigInfo)localObject3).toString());
                QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
                i4 = i1;
                i5 = i2;
                if (((ArCloudConfigInfo)localObject3).b.equalsIgnoreCase("2.0"))
                {
                  ??? = ((ArCloudConfigInfo)localObject3).j.a;
                  String str2 = ((ArCloudConfigInfo)localObject3).j.d;
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("YouTuNative. nativeAddMarker start. markerName = ");
                  ((StringBuilder)???).append((String)???);
                  ((StringBuilder)???).append(", markerFilePath = ");
                  ((StringBuilder)???).append(str2);
                  QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
                  synchronized (this.C)
                  {
                    i6 = ARShell.nativeAddMarker((String)???, str2);
                    ??? = new StringBuilder();
                    ((StringBuilder)???).append("YouTuNative. nativeAddMarker end. ret = ");
                    ((StringBuilder)???).append(i6);
                    QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
                    i4 = i1;
                    i5 = i2;
                    if (i6 == 0)
                    {
                      i4 = i1 + 1;
                      i5 = i2 + 1;
                      this.v.put(((ArCloudConfigInfo)localObject3).j.a, localObject3);
                    }
                  }
                }
              }
            }
            i3 += 1;
            i1 = i4;
            i2 = i5;
          }
        }
      }
      if (this.G == 0) {
        this.G = i4;
      }
      long l2 = System.currentTimeMillis();
      if (this.F == 0) {
        this.F = ((int)(l2 - l1));
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("YouTuNative. initAlgorithm successfully. timelen = ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(", starttime = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", endtime = ");
      localStringBuilder.append(l2);
      localStringBuilder.append(", featureCount = ");
      localStringBuilder.append(i5);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
      return true;
    }
    for (;;)
    {
      throw localObject6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog
 * JD-Core Version:    0.7.0.1
 */