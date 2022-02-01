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
  private static boolean jdField_a_of_type_Boolean = false;
  private final int jdField_a_of_type_Int = 25;
  private long jdField_a_of_type_Long = 0L;
  private FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = null;
  private ARLocalMarkerRecog.ARLocalMarkerRecogCallback jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ARLocalMarkerRecogCallback = null;
  private ARLocalMarkerRecog.ProcessWorker jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker = null;
  private AROption jdField_a_of_type_ComYoutuArsdkAROption;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ArCloudConfigInfo> jdField_a_of_type_JavaUtilArrayList = null;
  private Map<String, ArCloudConfigInfo> jdField_a_of_type_JavaUtilMap = null;
  private float[] jdField_a_of_type_ArrayOfFloat = null;
  private final int jdField_b_of_type_Int = 800;
  private long jdField_b_of_type_Long = 0L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList<ARLocalMarkerRecog.MarkerState> jdField_b_of_type_JavaUtilArrayList = null;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 2;
  private boolean jdField_g_of_type_Boolean = false;
  private int h = 0;
  private int i = 0;
  private int j = -1;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private int q = 0;
  private final int r = 5000;
  
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
    this.jdField_a_of_type_JavaUtilMap.put(???.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, ???);
    synchronized (this.jdField_d_of_type_JavaLangObject)
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
  private boolean d()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 75	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:jdField_f_of_type_Boolean	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +40 -> 48
    //   11: iload_1
    //   12: iconst_1
    //   13: iadd
    //   14: istore_2
    //   15: iload_2
    //   16: bipush 20
    //   18: if_icmpge +30 -> 48
    //   21: ldc2_w 233
    //   24: invokestatic 240	java/lang/Thread:sleep	(J)V
    //   27: iload_2
    //   28: istore_1
    //   29: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq -30 -> 2
    //   35: ldc 157
    //   37: iconst_2
    //   38: ldc 245
    //   40: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: iload_2
    //   44: istore_1
    //   45: goto -43 -> 2
    //   48: aload_0
    //   49: getfield 97	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:jdField_d_of_type_JavaLangObject	Ljava/lang/Object;
    //   52: astore 4
    //   54: aload 4
    //   56: monitorenter
    //   57: ldc 157
    //   59: iconst_1
    //   60: ldc 249
    //   62: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: invokestatic 252	com/youtu/arsdk/ARShell:nativeStop	()Z
    //   68: pop
    //   69: ldc 157
    //   71: iconst_1
    //   72: ldc 254
    //   74: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: ldc 157
    //   79: iconst_1
    //   80: ldc_w 256
    //   83: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: invokestatic 259	com/youtu/arsdk/ARShell:nativeDestroy	()Z
    //   89: pop
    //   90: ldc 157
    //   92: iconst_1
    //   93: ldc_w 261
    //   96: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload 4
    //   101: monitorexit
    //   102: iconst_1
    //   103: ireturn
    //   104: astore 5
    //   106: aload 4
    //   108: monitorexit
    //   109: aload 5
    //   111: athrow
    //   112: astore 4
    //   114: aload 4
    //   116: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   119: iconst_1
    //   120: ireturn
    //   121: astore 4
    //   123: goto -96 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	ARLocalMarkerRecog
    //   1	44	1	i1	int
    //   14	30	2	i2	int
    //   6	2	3	bool	boolean
    //   112	3	4	localException1	Exception
    //   121	1	4	localException2	Exception
    //   104	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   57	102	104	finally
    //   106	109	104	finally
    //   2	7	112	java/lang/Exception
    //   29	43	112	java/lang/Exception
    //   48	57	112	java/lang/Exception
    //   109	112	112	java/lang/Exception
    //   21	27	121	java/lang/Exception
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dataReport. mDataReportRecogQuality = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", mDataReportLoadedFeatureTimeLen = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", mDataReportLoadedFeatureCnt = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mDataReportFirstRecogSuccessTimeLen = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", mDataReportFirstRecogSuccessStartTime = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mDataReportFirstRecogSuccessEndTime = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", mDataReportFirstRecogSuccessFrameCnt = ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", mDataReportFirstRecogSuccessFeatureId = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("YOUTU_AR_PERF:, init sdk cost  = ");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append(", addFeature(1 marker) cost  = ");
    int i1 = this.m;
    if (i1 == 0) {
      i1 = 0;
    } else {
      i1 = this.l / i1;
    }
    localStringBuilder.append(i1);
    localStringBuilder.append(", recog cost = ");
    i1 = this.p;
    long l1;
    if (i1 == 0) {
      l1 = 0L;
    } else {
      l1 = this.jdField_c_of_type_Long / i1;
    }
    localStringBuilder.append(l1);
    localStringBuilder.append(", track cost = ");
    i1 = this.q;
    if (i1 == 0) {
      l1 = 0L;
    } else {
      l1 = this.jdField_d_of_type_Long / i1;
    }
    localStringBuilder.append(l1);
    localStringBuilder.append(", recog suc from start  = ");
    localStringBuilder.append(this.n);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    ARReport.a().a(this.l, this.m, this.n, this.o, this.k, this.jdField_a_of_type_JavaLangString);
    this.q = 0;
    this.p = 0;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (this.jdField_c_of_type_Boolean))
    {
      if (this.jdField_g_of_type_Boolean) {
        return;
      }
      ARLocalMarkerRecog.ProcessWorker localProcessWorker = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker;
      if (localProcessWorker != null) {
        localProcessWorker.a(paramLong, paramArrayOfByte);
      }
    }
  }
  
  public boolean a()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "start start.");
    if (this.jdField_c_of_type_Boolean) {
      return true;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_g_of_type_Int = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker == null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker = new ARLocalMarkerRecog.ProcessWorker(this);
    }
    this.n = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = 0L;
    this.o = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start end. mIsStarted = ");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    return true;
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
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    boolean bool1 = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = paramArConfigInfo;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ARLocalMarkerRecogCallback = paramARLocalMarkerRecogCallback;
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.o = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_f_of_type_Long = 0L;
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
        boolean bool2 = c();
        if (!bool2) {
          d();
        }
        bool1 = bool2;
      }
    }
    catch (UnsatisfiedLinkError paramArConfigInfo)
    {
      paramArConfigInfo.printStackTrace();
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm failed. loadNativeLibrary failed. UnsatisfiedLinkError.");
    }
    this.jdField_b_of_type_Boolean = bool1;
    paramArConfigInfo = new StringBuilder();
    paramArConfigInfo.append("init end. mIsInited = ");
    paramArConfigInfo.append(this.jdField_b_of_type_Boolean);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, paramArConfigInfo.toString());
    ARReport.a().d(System.currentTimeMillis() - l1, this.jdField_b_of_type_Boolean);
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(String paramString1, String paramString2, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    if (!paramArCloudConfigInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase("2.0"))
    {
      paramString1 = new StringBuilder();
      paramString1.append("addNewMarkerDynamically failed. sdk version error. sdk version = ");
      paramString1.append(paramArCloudConfigInfo.jdField_a_of_type_JavaLangString);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, paramString1.toString());
      return false;
    }
    Object localObject = this.jdField_c_of_type_JavaLangObject;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          if (((ARLocalMarkerRecog.MarkerState)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString1))
          {
            ((ARLocalMarkerRecog.MarkerState)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_JavaLangString = paramString2;
            ((ARLocalMarkerRecog.MarkerState)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
            return true;
          }
        }
        else
        {
          ARLocalMarkerRecog.MarkerState localMarkerState = new ARLocalMarkerRecog.MarkerState(null);
          localMarkerState.jdField_a_of_type_JavaLangString = paramString1;
          localMarkerState.jdField_b_of_type_JavaLangString = paramString2;
          localMarkerState.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
          localMarkerState.jdField_a_of_type_Boolean = false;
          localMarkerState.jdField_b_of_type_Boolean = false;
          this.jdField_b_of_type_JavaUtilArrayList.add(localMarkerState);
          this.jdField_f_of_type_Long = System.currentTimeMillis();
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
    if (!this.jdField_b_of_type_Boolean) {
      return null;
    }
    if ((this.jdField_e_of_type_Int == paramInt1) && (this.jdField_f_of_type_Int == paramInt2)) {
      return this.jdField_a_of_type_ArrayOfFloat;
    }
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
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
    paramInt1 = this.jdField_e_of_type_Int;
    float f1 = paramInt1;
    paramInt2 = this.jdField_f_of_type_Int;
    f1 = f1 * 1.0F / paramInt2;
    int i1 = this.jdField_d_of_type_Int;
    float f2 = i1;
    int i2 = this.jdField_c_of_type_Int;
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
    this.jdField_a_of_type_ArrayOfFloat = arrayOfFloat;
    arrayOfFloat = new float[16];
    if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g)) {
      Matrix.setRotateM(arrayOfFloat, 0, 90.0F, 0.0F, 0.0F, 1.0F);
    } else {
      Matrix.setRotateM(arrayOfFloat, 0, 270.0F, 0.0F, 0.0F, 1.0F);
    }
    localObject = this.jdField_a_of_type_ArrayOfFloat;
    Matrix.multiplyMM((float[])localObject, 0, arrayOfFloat, 0, (float[])localObject, 0);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pause. mIsPause = ");
    localStringBuilder.append(this.jdField_g_of_type_Boolean);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    this.jdField_g_of_type_Boolean = true;
    this.jdField_g_of_type_Int = 2;
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resume. mIsPause = ");
    localStringBuilder.append(this.jdField_g_of_type_Boolean);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    this.n = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = 0L;
    this.o = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_g_of_type_Boolean = false;
  }
  
  boolean c()
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
    this.jdField_a_of_type_ComYoutuArsdkAROption = new AROption();
    ??? = this.jdField_a_of_type_ComYoutuArsdkAROption;
    ((AROption)???).width = this.jdField_c_of_type_Int;
    ((AROption)???).height = this.jdField_d_of_type_Int;
    ((AROption)???).cameraParamPath = "";
    ((AROption)???).cachePath = "";
    if (ARDeviceInfo.a() == 0)
    {
      ??? = this.jdField_a_of_type_ComYoutuArsdkAROption;
      ((AROption)???).recognizeQuality = 3;
      ((AROption)???).trackQuality = 1;
      ((AROption)???).performanceQuality = 3;
    }
    else
    {
      ??? = this.jdField_a_of_type_ComYoutuArsdkAROption;
      ((AROption)???).recognizeQuality = 3;
      ((AROption)???).trackQuality = 1;
      ((AROption)???).performanceQuality = 2;
    }
    label933:
    StringBuilder localStringBuilder;
    synchronized (this.jdField_d_of_type_JavaLangObject)
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
      ((StringBuilder)???).append(this.jdField_a_of_type_ComYoutuArsdkAROption.width);
      ((StringBuilder)???).append(", height = ");
      ((StringBuilder)???).append(this.jdField_a_of_type_ComYoutuArsdkAROption.height);
      ((StringBuilder)???).append(", cameraParamPath = ");
      ((StringBuilder)???).append(this.jdField_a_of_type_ComYoutuArsdkAROption.cameraParamPath);
      ((StringBuilder)???).append(", recognizeQuality = ");
      ((StringBuilder)???).append(this.jdField_a_of_type_ComYoutuArsdkAROption.recognizeQuality);
      ((StringBuilder)???).append(", trackQuality = ");
      ((StringBuilder)???).append(this.jdField_a_of_type_ComYoutuArsdkAROption.trackQuality);
      ((StringBuilder)???).append(", performanceQuality = ");
      ((StringBuilder)???).append(this.jdField_a_of_type_ComYoutuArsdkAROption.performanceQuality);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
      i1 = ARShell.nativeInitialize(this.jdField_a_of_type_ComYoutuArsdkAROption);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("YouTuNative. nativeInitialize end. ret = ");
      ((StringBuilder)???).append(i1);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart start.");
      ARShell.nativeStart();
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart end.");
      this.jdField_e_of_type_Long = (System.currentTimeMillis() - l1);
      ??? = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
      int i7 = 0;
      int i3;
      int i6;
      if ((??? != null) && (((ArConfigInfo)???).mArCloudConfigInfos != null))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("add marker for local. marker count = ");
        ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.size());
        QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
        i5 = 0;
        i3 = 0;
        for (i4 = 0;; i4 = i2)
        {
          i1 = i3;
          i2 = i4;
          if (i5 >= this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.size()) {
            break;
          }
          ??? = (ArCloudConfigInfo)this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.get(i5);
          ??? = new StringBuilder();
          ((StringBuilder)???).append("add marker for local. resource info = ");
          ((StringBuilder)???).append(((ArCloudConfigInfo)???).toString());
          QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
          i1 = i3;
          i2 = i4;
          if (((ArCloudConfigInfo)???).jdField_a_of_type_JavaLangString.equalsIgnoreCase("2.0"))
          {
            i1 = i3;
            i2 = i4;
            if (((ArCloudConfigInfo)???).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null) {
              if (((ArCloudConfigInfo)???).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString == null)
              {
                i1 = i3;
                i2 = i4;
              }
              else
              {
                String str1 = ((ArCloudConfigInfo)???).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString;
                ??? = ((ArCloudConfigInfo)???).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c;
                ??? = new StringBuilder();
                ((StringBuilder)???).append("YouTuNative. nativeAddMarker start. markerName = ");
                ((StringBuilder)???).append(str1);
                ((StringBuilder)???).append(", markerFilePath = ");
                ((StringBuilder)???).append((String)???);
                QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
                try
                {
                  synchronized (this.jdField_d_of_type_JavaLangObject)
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
                this.jdField_a_of_type_JavaUtilMap.put(localObject2.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, localObject2);
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
      if (!QQARSession.jdField_a_of_type_Boolean)
      {
        i4 = i1;
        i5 = i2;
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("add marker for cloud. marker count = ");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaUtilArrayList.size());
          QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)localObject3).toString());
          i3 = i7;
          for (;;)
          {
            i4 = i1;
            i5 = i2;
            if (i3 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            localObject3 = (ArCloudConfigInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
            i4 = i1;
            i5 = i2;
            if (localObject3 != null)
            {
              i4 = i1;
              i5 = i2;
              if (((ArCloudConfigInfo)localObject3).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("add marker for cloud. resource info = ");
                ((StringBuilder)???).append(((ArCloudConfigInfo)localObject3).toString());
                QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
                i4 = i1;
                i5 = i2;
                if (((ArCloudConfigInfo)localObject3).jdField_a_of_type_JavaLangString.equalsIgnoreCase("2.0"))
                {
                  ??? = ((ArCloudConfigInfo)localObject3).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString;
                  String str2 = ((ArCloudConfigInfo)localObject3).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c;
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("YouTuNative. nativeAddMarker start. markerName = ");
                  ((StringBuilder)???).append((String)???);
                  ((StringBuilder)???).append(", markerFilePath = ");
                  ((StringBuilder)???).append(str2);
                  QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)???).toString());
                  synchronized (this.jdField_d_of_type_JavaLangObject)
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
                      this.jdField_a_of_type_JavaUtilMap.put(((ArCloudConfigInfo)localObject3).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, localObject3);
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
      if (this.m == 0) {
        this.m = i4;
      }
      long l2 = System.currentTimeMillis();
      if (this.l == 0) {
        this.l = ((int)(l2 - l1));
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
  
  public void d()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "stop start.");
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_g_of_type_Int = 2;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker;
    if (localObject != null)
    {
      ((ARLocalMarkerRecog.ProcessWorker)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = null;
    a();
    this.jdField_c_of_type_Boolean = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop end. mIsStarted = ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, ((StringBuilder)localObject).toString());
  }
  
  public void e()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "uninit start.");
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ARLocalMarkerRecogCallback = null;
    d();
    this.jdField_b_of_type_Boolean = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uninit end. mIsInited = ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog
 * JD-Core Version:    0.7.0.1
 */