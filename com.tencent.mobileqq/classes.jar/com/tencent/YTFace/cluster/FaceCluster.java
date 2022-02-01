package com.tencent.YTFace.cluster;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.FaceScanNativeSoLoader;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.old.AEOldResInfo;
import dov.com.qq.im.ae.download.old.AEOldResUtil;
import java.io.File;

public class FaceCluster
{
  public static final int ERROR_INIT_TRACK_ERROR = -1001;
  public static final int ERROR_MODEL_NOT_EXIST = -1000;
  public static final int FACE_DETECT_FORMAT_BITMAP = 1;
  public static final int FACE_DETECT_FORMAT_PIC = 2;
  private static final String TAG = "FaceCluster";
  private static FaceCluster instance = null;
  private static boolean loadSoSuccess = false;
  private static boolean soLoaded = false;
  public static boolean useAssetSo = false;
  private long nativeFeaturePtr;
  private long nativeTrackPtr;
  
  private FaceCluster()
  {
    try
    {
      String str1 = FaceScanNativeSoLoader.a("YTFaceExtFeature");
      String str2 = FaceScanNativeSoLoader.a("YTFaceClusterJNI_V852");
      BaseApplicationImpl.sApplication.getSharedPreferences("StatisticCollector", 4).edit().putString("facefeature_ext_so_md5", str1).commit();
      QLog.d("FaceCluster", 1, "FaceCluster faceFeatureExtSoMD5 = " + str1 + " faceJniSoMD5 =  " + str2);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FaceCluster", 1, "FaceCluster exception", localException);
    }
  }
  
  public static FaceCluster getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new FaceCluster();
      }
      if (!loadSoSuccess) {
        loadNativeLibrary();
      }
      FaceCluster localFaceCluster = instance;
      return localFaceCluster;
    }
    finally {}
  }
  
  /* Error */
  public static boolean loadNativeLibrary()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: ldc 2
    //   8: monitorenter
    //   9: invokestatic 118	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:a	()Z
    //   12: istore 8
    //   14: iload 8
    //   16: ifne +9 -> 25
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload 6
    //   24: ireturn
    //   25: getstatic 34	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   28: ifeq +11 -> 39
    //   31: getstatic 32	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   34: istore 6
    //   36: goto -17 -> 19
    //   39: iconst_1
    //   40: putstatic 34	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   43: invokestatic 121	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:c	()Ljava/lang/String;
    //   46: invokestatic 125	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	(Ljava/lang/String;)B
    //   49: istore_0
    //   50: invokestatic 127	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:d	()Ljava/lang/String;
    //   53: invokestatic 125	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	(Ljava/lang/String;)B
    //   56: istore_1
    //   57: ldc 129
    //   59: invokestatic 135	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   62: ldc 137
    //   64: invokestatic 139	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:c	(Ljava/lang/String;)B
    //   67: istore_2
    //   68: invokestatic 142	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:e	()Ljava/lang/String;
    //   71: invokestatic 125	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	(Ljava/lang/String;)B
    //   74: istore_3
    //   75: ldc 44
    //   77: invokestatic 139	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:c	(Ljava/lang/String;)B
    //   80: istore 4
    //   82: ldc 52
    //   84: invokestatic 139	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:c	(Ljava/lang/String;)B
    //   87: istore 5
    //   89: iload 7
    //   91: istore 6
    //   93: iload_1
    //   94: ifne +48 -> 142
    //   97: iload 7
    //   99: istore 6
    //   101: iload_2
    //   102: ifne +40 -> 142
    //   105: iload 7
    //   107: istore 6
    //   109: iload 4
    //   111: ifne +31 -> 142
    //   114: iload 7
    //   116: istore 6
    //   118: iload_3
    //   119: ifne +23 -> 142
    //   122: iload 7
    //   124: istore 6
    //   126: iload 5
    //   128: ifne +14 -> 142
    //   131: iload 7
    //   133: istore 6
    //   135: iload_0
    //   136: ifne +6 -> 142
    //   139: iconst_1
    //   140: istore 6
    //   142: iload 6
    //   144: putstatic 32	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   147: ldc 17
    //   149: iconst_1
    //   150: new 84	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   157: ldc 144
    //   159: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload_0
    //   163: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: ldc 149
    //   168: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload_1
    //   172: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: ldc 151
    //   177: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload_2
    //   181: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 153
    //   186: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload_3
    //   190: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: ldc 155
    //   195: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload 4
    //   200: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: ldc 157
    //   205: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: iload 5
    //   210: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: getstatic 32	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   222: istore 6
    //   224: goto -205 -> 19
    //   227: astore 9
    //   229: ldc 17
    //   231: iconst_1
    //   232: ldc 161
    //   234: aload 9
    //   236: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: iconst_0
    //   240: putstatic 32	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   243: goto -24 -> 219
    //   246: astore 9
    //   248: ldc 2
    //   250: monitorexit
    //   251: aload 9
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	114	0	i	int
    //   56	116	1	j	int
    //   67	114	2	k	int
    //   74	116	3	m	int
    //   80	119	4	n	int
    //   87	122	5	i1	int
    //   4	219	6	bool1	boolean
    //   1	131	7	bool2	boolean
    //   12	3	8	bool3	boolean
    //   227	8	9	localThrowable	java.lang.Throwable
    //   246	6	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	89	227	java/lang/Throwable
    //   142	219	227	java/lang/Throwable
    //   9	14	246	finally
    //   25	36	246	finally
    //   39	43	246	finally
    //   43	89	246	finally
    //   142	219	246	finally
    //   219	224	246	finally
    //   229	243	246	finally
  }
  
  public static final void printQLog(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public native float[] calcuFaceFeature(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3);
  
  public native float calcuSimilarity(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public boolean checkFaceTrackModelExistOrNot()
  {
    boolean bool1 = true;
    String str = AEOldResUtil.b(AEOldResInfo.b);
    if (!FileUtil.a(str))
    {
      boolean bool2 = false;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("FaceCluster", 2, "checkFaceTrackModelExistOrNot false,path = " + str);
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceCluster", 2, "checkFaceTrackModelExistOrNot result = " + bool1);
    }
    return bool1;
  }
  
  public native int[] clusterFaces(float[][] paramArrayOfFloat);
  
  public FaceStatus[] detectFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public native int faceDetect(Object paramObject, int paramInt, FaceTarget paramFaceTarget);
  
  public int faceTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceTarget paramFaceTarget, boolean paramBoolean)
  {
    return -1;
  }
  
  public native float[] getFaceFeature(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, boolean paramBoolean);
  
  public native float[] getFaceFeature2(Object paramObject, int paramInt, float[] paramArrayOfFloat);
  
  public int init(String paramString1, String paramString2, String paramString3)
  {
    int j = -1000;
    if (QLog.isColorLevel()) {
      QLog.d("FaceCluster", 2, "init start,face_feature_model_path = " + paramString3);
    }
    int i;
    if (TextUtils.isEmpty(paramString3))
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("FaceCluster", 2, "init return1");
        i = j;
      }
    }
    do
    {
      for (;;)
      {
        return i;
        paramString1 = new File(paramString3);
        if ((!checkFaceTrackModelExistOrNot()) || (!paramString1.exists()))
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("FaceCluster", 2, "init return2");
            return -1000;
          }
        }
        else
        {
          try
          {
            j = initTrackPro(AEOldResUtil.b(AEOldResInfo.b));
            QLog.d("FaceCluster", 1, "init initTrackPro ret = " + j);
            if (j != 0)
            {
              i = j;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("FaceCluster", 2, "init return3");
              return j;
            }
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            QLog.e("FaceCluster", 1, "Exception", paramString1);
            if (QLog.isColorLevel()) {
              QLog.d("FaceCluster", 2, "init return4");
            }
            return -1001;
          }
          catch (UnsatisfiedLinkError paramString1)
          {
            paramString1.printStackTrace();
            QLog.e("FaceCluster", 1, "UnsatisfiedLinkError", paramString1);
            if (QLog.isColorLevel()) {
              QLog.d("FaceCluster", 2, "init return4");
            }
            return -1001;
          }
        }
      }
      j = initFaceExtFeature(paramString3);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("FaceCluster", 2, "init finish result = " + j);
    return j;
  }
  
  @Deprecated
  public native int initFaceExtFeature(String paramString);
  
  public native int initTrackPro(String paramString);
  
  public boolean isLoadSoSuccess()
  {
    return loadSoSuccess;
  }
  
  public native void release();
  
  public void releaseFaceStatusArray(FaceStatus[] paramArrayOfFaceStatus) {}
  
  public native FaceStatus[] trackFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public int trackSingleFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, boolean paramBoolean)
  {
    return -1;
  }
  
  public int trackSingleFace2(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, int paramInt3)
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.YTFace.cluster.FaceCluster
 * JD-Core Version:    0.7.0.1
 */