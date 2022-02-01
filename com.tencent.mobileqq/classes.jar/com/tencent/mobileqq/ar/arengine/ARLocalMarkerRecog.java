package com.tencent.mobileqq.ar.arengine;

import android.opengl.Matrix;
import apod;
import apov;
import apow;
import appv;
import apse;
import bdax;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
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
  private final int jdField_a_of_type_Int = 25;
  private long jdField_a_of_type_Long;
  private apov jdField_a_of_type_Apov;
  private FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
  private ARLocalMarkerRecog.ProcessWorker jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker;
  private AROption jdField_a_of_type_ComYoutuArsdkAROption;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ArCloudConfigInfo> jdField_a_of_type_JavaUtilArrayList;
  private Map<String, ArCloudConfigInfo> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private final int jdField_b_of_type_Int = 800;
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList<apow> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private int g = 2;
  private int h;
  private int i;
  private int j = -1;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private final int r = 5000;
  
  private boolean b(String paramString1, String paramString2, ArCloudConfigInfo arg3)
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically. markerName = " + paramString1 + ", markerFilePath = " + paramString2);
    ARPatternInfo localARPatternInfo = new ARPatternInfo();
    int i1 = 0;
    while (i1 < ARShell.getMarkerCount())
    {
      localARPatternInfo.name = "";
      ARShell.getMarkerInfo(i1, localARPatternInfo);
      if (localARPatternInfo.name.equals(paramString1))
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
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker start. markerName = " + paramString1);
      i1 = ARShell.nativeAddMarker(paramString1, paramString2);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker end. ret = " + i1);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically successfully.");
      return true;
    }
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 94	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:jdField_e_of_type_Boolean	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +49 -> 57
    //   11: iload_1
    //   12: iconst_1
    //   13: iadd
    //   14: istore_2
    //   15: iload_2
    //   16: bipush 20
    //   18: if_icmpge +39 -> 57
    //   21: ldc2_w 201
    //   24: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   27: iload_2
    //   28: istore_1
    //   29: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq -30 -> 2
    //   35: ldc 104
    //   37: iconst_2
    //   38: ldc 213
    //   40: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: iload_2
    //   44: istore_1
    //   45: goto -43 -> 2
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   55: iconst_1
    //   56: ireturn
    //   57: aload_0
    //   58: getfield 58	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:jdField_d_of_type_JavaLangObject	Ljava/lang/Object;
    //   61: astore 4
    //   63: aload 4
    //   65: monitorenter
    //   66: ldc 104
    //   68: iconst_1
    //   69: ldc 220
    //   71: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: invokestatic 223	com/youtu/arsdk/ARShell:nativeStop	()Z
    //   77: pop
    //   78: ldc 104
    //   80: iconst_1
    //   81: ldc 225
    //   83: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: ldc 104
    //   88: iconst_1
    //   89: ldc 227
    //   91: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: invokestatic 230	com/youtu/arsdk/ARShell:nativeDestroy	()Z
    //   97: pop
    //   98: ldc 104
    //   100: iconst_1
    //   101: ldc 232
    //   103: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload 4
    //   108: monitorexit
    //   109: iconst_1
    //   110: ireturn
    //   111: astore 5
    //   113: aload 4
    //   115: monitorexit
    //   116: aload 5
    //   118: athrow
    //   119: astore 4
    //   121: goto -94 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	ARLocalMarkerRecog
    //   1	44	1	i1	int
    //   14	30	2	i2	int
    //   6	2	3	bool	boolean
    //   48	3	4	localException1	Exception
    //   119	1	4	localException2	Exception
    //   111	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	48	java/lang/Exception
    //   29	43	48	java/lang/Exception
    //   57	66	48	java/lang/Exception
    //   116	119	48	java/lang/Exception
    //   66	109	111	finally
    //   113	116	111	finally
    //   21	27	119	java/lang/Exception
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "dataReport. mDataReportRecogQuality = " + this.k + ", mDataReportLoadedFeatureTimeLen = " + this.l + ", mDataReportLoadedFeatureCnt = " + this.m + ", mDataReportFirstRecogSuccessTimeLen = " + this.n + ", mDataReportFirstRecogSuccessStartTime = " + this.jdField_a_of_type_Long + ", mDataReportFirstRecogSuccessEndTime = " + this.jdField_b_of_type_Long + ", mDataReportFirstRecogSuccessFrameCnt = " + this.o + ", mDataReportFirstRecogSuccessFeatureId = " + this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder().append("YOUTU_AR_PERF:, init sdk cost  = ").append(this.jdField_e_of_type_Long).append(", addFeature(1 marker) cost  = ");
    int i1;
    if (this.m == 0)
    {
      i1 = 0;
      localStringBuilder = localStringBuilder.append(i1).append(", recog cost = ");
      if (this.p != 0) {
        break label295;
      }
      l1 = 0L;
      label175:
      localStringBuilder = localStringBuilder.append(l1).append(", track cost = ");
      if (this.q != 0) {
        break label309;
      }
    }
    label295:
    label309:
    for (long l1 = 0L;; l1 = this.jdField_d_of_type_Long / this.q)
    {
      QLog.i("AREngine_ARLocalMarkerRecog", 1, l1 + ", recog suc from start  = " + this.n);
      appv.a().a(this.l, this.m, this.n, this.o, this.k, this.jdField_a_of_type_JavaLangString);
      this.q = 0;
      this.p = 0;
      this.jdField_d_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      return;
      i1 = this.l / this.m;
      break;
      l1 = this.jdField_c_of_type_Long / this.p;
      break label175;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!this.jdField_b_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker.a(paramLong, paramArrayOfByte);
  }
  
  public boolean a()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "start start.");
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.g = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker == null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker = new ARLocalMarkerRecog.ProcessWorker(this);
    }
    this.n = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = 0L;
    this.o = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "start end. mIsStarted = " + this.jdField_b_of_type_Boolean);
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2, ArConfigInfo paramArConfigInfo, ArrayList<ArCloudConfigInfo> paramArrayList, apov paramapov)
  {
    boolean bool1 = false;
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "init start. imageWidth = " + paramInt1 + ", imageHeight = " + paramInt2);
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = paramArConfigInfo;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Apov = paramapov;
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
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
        appv.a().e(System.currentTimeMillis() - l2, false);
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool1;
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "init end. mIsInited = " + this.jdField_a_of_type_Boolean);
        appv.a().d(System.currentTimeMillis() - l1, this.jdField_a_of_type_Boolean);
        return this.jdField_a_of_type_Boolean;
        appv.a().e(System.currentTimeMillis() - l2, true);
        boolean bool2 = c();
        if (!bool2) {
          d();
        }
        bool1 = bool2;
      }
    }
    catch (UnsatisfiedLinkError paramArConfigInfo)
    {
      for (;;)
      {
        paramArConfigInfo.printStackTrace();
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm failed. loadNativeLibrary failed. UnsatisfiedLinkError.");
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    if (!paramArCloudConfigInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase("2.0"))
    {
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically failed. sdk version error. sdk version = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString);
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
          if (((apow)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString1))
          {
            ((apow)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_JavaLangString = paramString2;
            ((apow)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
            return true;
          }
        }
        else
        {
          apow localapow = new apow(null);
          localapow.jdField_a_of_type_JavaLangString = paramString1;
          localapow.jdField_b_of_type_JavaLangString = paramString2;
          localapow.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
          localapow.jdField_a_of_type_Boolean = false;
          localapow.jdField_b_of_type_Boolean = false;
          this.jdField_b_of_type_JavaUtilArrayList.add(localapow);
          this.jdField_f_of_type_Long = System.currentTimeMillis();
          return true;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public float[] a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    if ((this.jdField_e_of_type_Int == paramInt1) && (this.jdField_f_of_type_Int == paramInt2)) {
      return this.jdField_a_of_type_ArrayOfFloat;
    }
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    float[] arrayOfFloat = new float[16];
    ARShell.getProjectionMatrix(25.0F, 800.0F, arrayOfFloat, false);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. getProjectionMatrix. proMatrix[0] = " + arrayOfFloat[0] + ", proMatrix[1] = " + arrayOfFloat[1] + ", proMatrix[2] = " + arrayOfFloat[2] + ", proMatrix[3] = " + arrayOfFloat[3] + ", proMatrix[4] = " + arrayOfFloat[4] + ", proMatrix[5] = " + arrayOfFloat[5] + ", proMatrix[6] = " + arrayOfFloat[6] + ", proMatrix[7] = " + arrayOfFloat[7] + ", proMatrix[8] = " + arrayOfFloat[8] + ", proMatrix[9] = " + arrayOfFloat[9] + ", proMatrix[10] = " + arrayOfFloat[10] + ", proMatrix[11] = " + arrayOfFloat[11] + ", proMatrix[12] = " + arrayOfFloat[12] + ", proMatrix[13] = " + arrayOfFloat[13] + ", proMatrix[14] = " + arrayOfFloat[14] + ", proMatrix[15] = " + arrayOfFloat[15]);
    float f1 = this.jdField_e_of_type_Int * 1.0F / this.jdField_f_of_type_Int;
    float f2 = this.jdField_d_of_type_Int * 1.0F / this.jdField_c_of_type_Int;
    if (f1 > f2)
    {
      f1 = this.jdField_c_of_type_Int * this.jdField_e_of_type_Int * 1.0F / this.jdField_d_of_type_Int / this.jdField_f_of_type_Int * 1.0F;
      arrayOfFloat[0] *= f1;
      arrayOfFloat[8] = (f1 * arrayOfFloat[8]);
      this.jdField_a_of_type_ArrayOfFloat = arrayOfFloat;
      arrayOfFloat = new float[16];
      if (!bdax.d(bdax.g)) {
        break label490;
      }
      Matrix.setRotateM(arrayOfFloat, 0, 90.0F, 0.0F, 0.0F, 1.0F);
    }
    for (;;)
    {
      Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, arrayOfFloat, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
      return this.jdField_a_of_type_ArrayOfFloat;
      if (f1 >= f2) {
        break;
      }
      f1 = this.jdField_d_of_type_Int * this.jdField_f_of_type_Int * 1.0F / this.jdField_c_of_type_Int / this.jdField_e_of_type_Int * 1.0F;
      arrayOfFloat[5] *= f1;
      arrayOfFloat[9] = (f1 * arrayOfFloat[9]);
      break;
      label490:
      Matrix.setRotateM(arrayOfFloat, 0, 270.0F, 0.0F, 0.0F, 1.0F);
    }
  }
  
  public void b()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "pause. mIsPause = " + this.jdField_f_of_type_Boolean);
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_f_of_type_Boolean = true;
    this.g = 2;
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void c()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "resume. mIsPause = " + this.jdField_f_of_type_Boolean);
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    this.n = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = 0L;
    this.o = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_f_of_type_Boolean = false;
  }
  
  boolean c()
  {
    int i7 = 0;
    long l1 = System.currentTimeMillis();
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm. start = " + l1);
    int i1 = YTCommonInterface.initAuthForQQ(BaseApplicationImpl.getApplication().getApplicationContext());
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm. initAuth ret = " + i1);
    this.jdField_a_of_type_ComYoutuArsdkAROption = new AROption();
    this.jdField_a_of_type_ComYoutuArsdkAROption.width = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComYoutuArsdkAROption.height = this.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComYoutuArsdkAROption.cameraParamPath = "";
    this.jdField_a_of_type_ComYoutuArsdkAROption.cachePath = "";
    if (apod.a() == 0)
    {
      this.jdField_a_of_type_ComYoutuArsdkAROption.recognizeQuality = 3;
      this.jdField_a_of_type_ComYoutuArsdkAROption.trackQuality = 1;
      this.jdField_a_of_type_ComYoutuArsdkAROption.performanceQuality = 3;
    }
    int i3;
    label622:
    String str3;
    int i6;
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. ARSDKVersion = " + ARShell.getSDKVersion());
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeCreate start.");
        ARShell.nativeCreate(BaseApplicationImpl.getApplication().getApplicationContext());
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeCreate end.");
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeInitialize start. width = " + this.jdField_a_of_type_ComYoutuArsdkAROption.width + ", height = " + this.jdField_a_of_type_ComYoutuArsdkAROption.height + ", cameraParamPath = " + this.jdField_a_of_type_ComYoutuArsdkAROption.cameraParamPath + ", recognizeQuality = " + this.jdField_a_of_type_ComYoutuArsdkAROption.recognizeQuality + ", trackQuality = " + this.jdField_a_of_type_ComYoutuArsdkAROption.trackQuality + ", performanceQuality = " + this.jdField_a_of_type_ComYoutuArsdkAROption.performanceQuality);
        i1 = ARShell.nativeInitialize(this.jdField_a_of_type_ComYoutuArsdkAROption);
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeInitialize end. ret = " + i1);
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart start.");
        ARShell.nativeStart();
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart end.");
        this.jdField_e_of_type_Long = (System.currentTimeMillis() - l1);
        if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos == null)) {
          break;
        }
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for local. marker count = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.size());
        i5 = 0;
        i4 = 0;
        i3 = 0;
        i1 = i4;
        i2 = i3;
        if (i5 >= this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.size()) {
          break label817;
        }
        ArCloudConfigInfo localArCloudConfigInfo1 = (ArCloudConfigInfo)this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.get(i5);
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for local. resource info = " + localArCloudConfigInfo1.toString());
        i1 = i4;
        i2 = i3;
        if (localArCloudConfigInfo1.jdField_a_of_type_JavaLangString.equalsIgnoreCase("2.0"))
        {
          i1 = i4;
          i2 = i3;
          if (localArCloudConfigInfo1.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
          {
            if (localArCloudConfigInfo1.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString != null) {
              break label622;
            }
            i2 = i3;
            i1 = i4;
          }
        }
        i5 += 1;
        i4 = i1;
        i3 = i2;
        continue;
        this.jdField_a_of_type_ComYoutuArsdkAROption.recognizeQuality = 3;
        this.jdField_a_of_type_ComYoutuArsdkAROption.trackQuality = 1;
        this.jdField_a_of_type_ComYoutuArsdkAROption.performanceQuality = 2;
      }
      String str1 = localObject2.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString;
      str3 = localObject2.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c;
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker start. markerName = " + str1 + ", markerFilePath = " + str3);
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        try
        {
          i6 = ARShell.nativeAddMarker(str1, str3);
          QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker end. ret = " + i6);
          i1 = i4;
          i2 = i3;
          if (i6 == 0)
          {
            i1 = i4 + 1;
            i2 = i3 + 1;
            this.jdField_a_of_type_JavaUtilMap.put(localObject2.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, localObject2);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "nativeAddMarker = " + localException.getMessage());
            i6 = 0;
          }
        }
      }
    }
    i1 = 0;
    int i2 = 0;
    label817:
    int i4 = i1;
    int i5 = i2;
    if (!apse.jdField_a_of_type_Boolean)
    {
      i4 = i1;
      i5 = i2;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for cloud. marker count = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        i3 = i7;
        for (;;)
        {
          i4 = i1;
          i5 = i2;
          if (i3 < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ArCloudConfigInfo localArCloudConfigInfo2 = (ArCloudConfigInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
            i5 = i1;
            i4 = i2;
            String str2;
            if (localArCloudConfigInfo2 != null)
            {
              i5 = i1;
              i4 = i2;
              if (localArCloudConfigInfo2.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo != null)
              {
                QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for cloud. resource info = " + localArCloudConfigInfo2.toString());
                i5 = i1;
                i4 = i2;
                if (localArCloudConfigInfo2.jdField_a_of_type_JavaLangString.equalsIgnoreCase("2.0"))
                {
                  str2 = localArCloudConfigInfo2.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString;
                  str3 = localArCloudConfigInfo2.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c;
                  QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker start. markerName = " + str2 + ", markerFilePath = " + str3);
                }
              }
            }
            synchronized (this.jdField_d_of_type_JavaLangObject)
            {
              i6 = ARShell.nativeAddMarker(str2, str3);
              QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker end. ret = " + i6);
              i5 = i1;
              i4 = i2;
              if (i6 == 0)
              {
                i4 = i2 + 1;
                i5 = i1 + 1;
                this.jdField_a_of_type_JavaUtilMap.put(localArCloudConfigInfo2.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, localArCloudConfigInfo2);
              }
              i3 += 1;
              i1 = i5;
              i2 = i4;
            }
          }
        }
      }
    }
    if (this.m == 0) {
      this.m = i5;
    }
    long l2 = System.currentTimeMillis();
    if (this.l == 0) {
      this.l = ((int)(l2 - l1));
    }
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm successfully. timelen = " + (l2 - l1) + ", starttime = " + l1 + ", endtime = " + l2 + ", featureCount = " + i4);
    return true;
  }
  
  public void d()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "stop start.");
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.g = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker.a();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = null;
    a();
    this.jdField_b_of_type_Boolean = false;
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "stop end. mIsStarted = " + this.jdField_b_of_type_Boolean);
  }
  
  public void e()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "uninit start.");
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Apov = null;
    d();
    this.jdField_a_of_type_Boolean = false;
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "uninit end. mIsInited = " + this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog
 * JD-Core Version:    0.7.0.1
 */