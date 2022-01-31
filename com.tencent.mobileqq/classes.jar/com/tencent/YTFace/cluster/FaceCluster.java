package com.tencent.YTFace.cluster;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.FaceScanNativeSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FaceCluster
{
  public static final int ERROR_INIT_TRACK_ERROR = -1001;
  public static final int ERROR_MODEL_NOT_EXIST = -1000;
  public static final int FACE_DETECT_FORMAT_BITMAP = 1;
  public static final int FACE_DETECT_FORMAT_PIC = 2;
  private static final String TAG = "FaceCluster";
  private static FaceCluster instance;
  private static boolean loadSoSuccess;
  private static boolean soLoaded;
  public static boolean useAssetSo;
  private long nativeFeaturePtr;
  private long nativeTrackPtr;
  
  private FaceCluster()
  {
    try
    {
      String str = FaceScanNativeSoLoader.a("YTFaceExtFeature");
      BaseApplicationImpl.sApplication.getSharedPreferences("StatisticCollector", 4).edit().putString("facefeature_ext_so_md5", str).commit();
      if (QLog.isColorLevel()) {
        QLog.d("FaceCluster", 2, "FaceCluster faceFeatureExtSoMD5 = " + str);
      }
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
    //   9: invokestatic 112	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:a	()Z
    //   12: istore 8
    //   14: iload 8
    //   16: ifne +9 -> 25
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload 6
    //   24: ireturn
    //   25: getstatic 114	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   28: ifeq +11 -> 39
    //   31: getstatic 105	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   34: istore 6
    //   36: goto -17 -> 19
    //   39: iconst_1
    //   40: putstatic 114	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   43: ldc 116
    //   45: invokestatic 120	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	(Ljava/lang/String;)B
    //   48: istore_0
    //   49: ldc 122
    //   51: invokestatic 120	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	(Ljava/lang/String;)B
    //   54: istore_1
    //   55: ldc 124
    //   57: invokestatic 120	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	(Ljava/lang/String;)B
    //   60: istore_2
    //   61: ldc 34
    //   63: invokestatic 120	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	(Ljava/lang/String;)B
    //   66: istore_3
    //   67: ldc 126
    //   69: invokestatic 120	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	(Ljava/lang/String;)B
    //   72: istore 4
    //   74: ldc 128
    //   76: invokestatic 120	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	(Ljava/lang/String;)B
    //   79: istore 5
    //   81: iload 7
    //   83: istore 6
    //   85: iload_0
    //   86: ifne +48 -> 134
    //   89: iload 7
    //   91: istore 6
    //   93: iload_1
    //   94: ifne +40 -> 134
    //   97: iload 7
    //   99: istore 6
    //   101: iload_2
    //   102: ifne +32 -> 134
    //   105: iload 7
    //   107: istore 6
    //   109: iload_3
    //   110: ifne +24 -> 134
    //   113: iload 7
    //   115: istore 6
    //   117: iload 4
    //   119: ifne +15 -> 134
    //   122: iload 7
    //   124: istore 6
    //   126: iload 5
    //   128: ifne +6 -> 134
    //   131: iconst_1
    //   132: istore 6
    //   134: iload 6
    //   136: putstatic 105	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   139: getstatic 105	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   142: istore 6
    //   144: goto -125 -> 19
    //   147: astore 9
    //   149: iconst_0
    //   150: putstatic 105	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   153: goto -14 -> 139
    //   156: astore 9
    //   158: ldc 2
    //   160: monitorexit
    //   161: aload 9
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   48	38	0	i	int
    //   54	40	1	j	int
    //   60	42	2	k	int
    //   66	44	3	m	int
    //   72	46	4	n	int
    //   79	48	5	i1	int
    //   4	139	6	bool1	boolean
    //   1	122	7	bool2	boolean
    //   12	3	8	bool3	boolean
    //   147	1	9	localThrowable	java.lang.Throwable
    //   156	6	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	81	147	java/lang/Throwable
    //   134	139	147	java/lang/Throwable
    //   9	14	156	finally
    //   25	36	156	finally
    //   39	43	156	finally
    //   43	81	156	finally
    //   134	139	156	finally
    //   139	144	156	finally
    //   149	153	156	finally
  }
  
  public static final void printQLog(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public native float[] calcuFaceFeature(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3);
  
  public native float calcuSimilarity(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public native int[] clusterFaces(float[][] paramArrayOfFloat);
  
  public native FaceStatus[] detectFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int faceDetect(Object paramObject, int paramInt, FaceTarget paramFaceTarget);
  
  public native int faceTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceTarget paramFaceTarget, boolean paramBoolean);
  
  public native float[] getFaceFeature(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, boolean paramBoolean);
  
  public native float[] getFaceFeature2(Object paramObject, int paramInt, float[] paramArrayOfFloat);
  
  public int init(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return -1000;
    }
    File localFile1 = new File(paramString1);
    File localFile2 = new File(paramString2);
    File localFile3 = new File(paramString3);
    if ((!localFile1.exists()) || (!localFile2.exists()) || (!localFile3.exists())) {
      return -1000;
    }
    try
    {
      paramString1 = FileUtils.a(paramString1);
      paramString2 = FileUtils.a(paramString2);
      QLog.d("FaceCluster", 1, "init ,ufdmtccArray = " + paramString1 + ",ufatArray = " + paramString2);
      if ((paramString1 != null) && (paramString2 != null))
      {
        initialTrack(paramString1, paramString2);
        return initFaceExtFeature(paramString3);
      }
      QLog.d("FaceCluster", 1, "init error,ufdmtccArray = " + paramString1 + ",ufatArray = " + paramString2);
      return -1001;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.e("FaceCluster", 1, "Exception", paramString1);
      return -1001;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      paramString1.printStackTrace();
      QLog.e("FaceCluster", 1, "UnsatisfiedLinkError", paramString1);
    }
    return -1001;
  }
  
  @Deprecated
  public native int initFaceExtFeature(String paramString);
  
  @Deprecated
  public native boolean initialTrack(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public boolean isLoadSoSuccess()
  {
    return loadSoSuccess;
  }
  
  public native void release();
  
  public native int trackSingleFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, boolean paramBoolean);
  
  public native int trackSingleFace2(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.YTFace.cluster.FaceCluster
 * JD-Core Version:    0.7.0.1
 */