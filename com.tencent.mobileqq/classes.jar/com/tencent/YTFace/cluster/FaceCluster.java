package com.tencent.YTFace.cluster;

import alco;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bbdx;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.common.app.BaseApplicationImpl;
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
      String str1 = alco.a("YTFaceExtFeature");
      String str2 = alco.a("YTFaceClusterJNI_V820");
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
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 2
    //   8: monitorenter
    //   9: invokestatic 113	alco:a	()Z
    //   12: istore 7
    //   14: iload 7
    //   16: ifne +9 -> 25
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload 5
    //   24: ireturn
    //   25: getstatic 115	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   28: ifeq +11 -> 39
    //   31: getstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   34: istore 5
    //   36: goto -17 -> 19
    //   39: iconst_1
    //   40: putstatic 115	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   43: ldc 117
    //   45: invokestatic 121	alco:b	(Ljava/lang/String;)B
    //   48: istore_0
    //   49: ldc 123
    //   51: invokestatic 121	alco:b	(Ljava/lang/String;)B
    //   54: istore_1
    //   55: ldc 125
    //   57: invokestatic 121	alco:b	(Ljava/lang/String;)B
    //   60: istore_2
    //   61: ldc 34
    //   63: invokestatic 121	alco:b	(Ljava/lang/String;)B
    //   66: istore_3
    //   67: ldc 42
    //   69: invokestatic 121	alco:b	(Ljava/lang/String;)B
    //   72: istore 4
    //   74: iload 6
    //   76: istore 5
    //   78: iload_0
    //   79: ifne +39 -> 118
    //   82: iload 6
    //   84: istore 5
    //   86: iload_1
    //   87: ifne +31 -> 118
    //   90: iload 6
    //   92: istore 5
    //   94: iload_3
    //   95: ifne +23 -> 118
    //   98: iload 6
    //   100: istore 5
    //   102: iload_2
    //   103: ifne +15 -> 118
    //   106: iload 6
    //   108: istore 5
    //   110: iload 4
    //   112: ifne +6 -> 118
    //   115: iconst_1
    //   116: istore 5
    //   118: iload 5
    //   120: putstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   123: ldc 17
    //   125: iconst_1
    //   126: new 74	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   133: ldc 127
    //   135: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_0
    //   139: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: ldc 132
    //   144: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: iload_1
    //   148: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: ldc 134
    //   153: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: iload_2
    //   157: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: ldc 136
    //   162: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload_3
    //   166: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: ldc 138
    //   171: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload 4
    //   176: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: getstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   188: istore 5
    //   190: goto -171 -> 19
    //   193: astore 8
    //   195: ldc 17
    //   197: iconst_1
    //   198: ldc 143
    //   200: aload 8
    //   202: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: iconst_0
    //   206: putstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   209: goto -24 -> 185
    //   212: astore 8
    //   214: ldc 2
    //   216: monitorexit
    //   217: aload 8
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   48	91	0	i	int
    //   54	94	1	j	int
    //   60	97	2	k	int
    //   66	100	3	m	int
    //   72	103	4	n	int
    //   4	185	5	bool1	boolean
    //   1	106	6	bool2	boolean
    //   12	3	7	bool3	boolean
    //   193	8	8	localThrowable	java.lang.Throwable
    //   212	6	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	74	193	java/lang/Throwable
    //   118	185	193	java/lang/Throwable
    //   9	14	212	finally
    //   25	36	212	finally
    //   39	43	212	finally
    //   43	74	212	finally
    //   118	185	212	finally
    //   185	190	212	finally
    //   195	209	212	finally
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
      paramString1 = bbdx.a(paramString1);
      paramString2 = bbdx.a(paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.YTFace.cluster.FaceCluster
 * JD-Core Version:    0.7.0.1
 */