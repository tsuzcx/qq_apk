package com.tencent.YTFace.cluster;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import apgp;
import bnkt;
import bnky;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

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
      String str1 = apgp.a("YTFaceExtFeature");
      String str2 = apgp.a("YTFaceClusterJNI_V841");
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
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 7
    //   6: ldc 2
    //   8: monitorenter
    //   9: invokestatic 113	apgp:a	()Z
    //   12: istore 9
    //   14: iload 9
    //   16: ifne +9 -> 25
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload 7
    //   24: ireturn
    //   25: getstatic 115	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   28: ifeq +11 -> 39
    //   31: getstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   34: istore 7
    //   36: goto -17 -> 19
    //   39: iconst_1
    //   40: putstatic 115	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   43: invokestatic 118	apgp:c	()Ljava/lang/String;
    //   46: invokestatic 122	apgp:b	(Ljava/lang/String;)B
    //   49: istore_0
    //   50: invokestatic 125	apgp:e	()Ljava/lang/String;
    //   53: invokestatic 122	apgp:b	(Ljava/lang/String;)B
    //   56: istore_1
    //   57: invokestatic 127	apgp:d	()Ljava/lang/String;
    //   60: invokestatic 122	apgp:b	(Ljava/lang/String;)B
    //   63: istore_2
    //   64: ldc 129
    //   66: invokestatic 131	apgp:c	(Ljava/lang/String;)B
    //   69: istore_3
    //   70: invokestatic 134	apgp:f	()Ljava/lang/String;
    //   73: invokestatic 122	apgp:b	(Ljava/lang/String;)B
    //   76: istore 4
    //   78: ldc 34
    //   80: invokestatic 131	apgp:c	(Ljava/lang/String;)B
    //   83: istore 5
    //   85: ldc 42
    //   87: invokestatic 131	apgp:c	(Ljava/lang/String;)B
    //   90: istore 6
    //   92: iload 8
    //   94: istore 7
    //   96: iload_2
    //   97: ifne +49 -> 146
    //   100: iload 8
    //   102: istore 7
    //   104: iload_3
    //   105: ifne +41 -> 146
    //   108: iload 8
    //   110: istore 7
    //   112: iload 5
    //   114: ifne +32 -> 146
    //   117: iload 8
    //   119: istore 7
    //   121: iload 4
    //   123: ifne +23 -> 146
    //   126: iload 8
    //   128: istore 7
    //   130: iload 6
    //   132: ifne +14 -> 146
    //   135: iload 8
    //   137: istore 7
    //   139: iload_0
    //   140: ifne +6 -> 146
    //   143: iconst_1
    //   144: istore 7
    //   146: iload 7
    //   148: putstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   151: ldc 17
    //   153: iconst_1
    //   154: new 74	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   161: ldc 136
    //   163: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload_2
    //   167: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc 141
    //   172: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload_0
    //   176: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: ldc 143
    //   181: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: iload_1
    //   185: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: ldc 145
    //   190: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: iload_3
    //   194: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc 147
    //   199: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload 4
    //   204: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: ldc 149
    //   209: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload 5
    //   214: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: ldc 151
    //   219: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload 6
    //   224: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: getstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   236: istore 7
    //   238: goto -219 -> 19
    //   241: astore 10
    //   243: ldc 17
    //   245: iconst_1
    //   246: ldc 155
    //   248: aload 10
    //   250: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: iconst_0
    //   254: putstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   257: goto -24 -> 233
    //   260: astore 10
    //   262: ldc 2
    //   264: monitorexit
    //   265: aload 10
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	127	0	i	int
    //   56	129	1	j	int
    //   63	104	2	k	int
    //   69	125	3	m	int
    //   76	127	4	n	int
    //   83	130	5	i1	int
    //   90	133	6	i2	int
    //   4	233	7	bool1	boolean
    //   1	135	8	bool2	boolean
    //   12	3	9	bool3	boolean
    //   241	8	10	localThrowable	java.lang.Throwable
    //   260	6	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	92	241	java/lang/Throwable
    //   146	233	241	java/lang/Throwable
    //   9	14	260	finally
    //   25	36	260	finally
    //   39	43	260	finally
    //   43	92	260	finally
    //   146	233	260	finally
    //   233	238	260	finally
    //   243	257	260	finally
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
    Object localObject1 = new FaceDetectInitializer().getModelInfos();
    boolean bool;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ModelInfo)((Iterator)localObject1).next();
          localObject2 = bnky.a(bnkt.b) + ((ModelInfo)localObject2).fileName;
          if (!FileUtil.isFileExists((String)localObject2)) {
            if (QLog.isColorLevel())
            {
              QLog.d("FaceCluster", 2, "checkFaceTrackModelExistOrNot false,path = " + (String)localObject2);
              bool = false;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceCluster", 2, "checkFaceTrackModelExistOrNot result = " + bool);
      }
      return bool;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public native int[] clusterFaces(float[][] paramArrayOfFloat);
  
  public native FaceStatus[] detectFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int faceDetect(Object paramObject, int paramInt, FaceTarget paramFaceTarget);
  
  public native int faceTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceTarget paramFaceTarget, boolean paramBoolean);
  
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
            j = initTrackPro(bnky.a(bnkt.b));
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
  
  public void releaseFaceStatusArray(FaceStatus[] paramArrayOfFaceStatus)
  {
    if ((paramArrayOfFaceStatus != null) && (paramArrayOfFaceStatus.length > 0))
    {
      int j = paramArrayOfFaceStatus.length;
      int i = 0;
      while (i < j)
      {
        FaceStatus localFaceStatus = paramArrayOfFaceStatus[i];
        if (localFaceStatus.nativeFaceAlignmentPtr != 0L) {
          releaseNativeFaceStatus(localFaceStatus);
        }
        i += 1;
      }
    }
  }
  
  public native int releaseNativeFaceStatus(FaceStatus paramFaceStatus);
  
  public native int trackSingleFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, boolean paramBoolean);
  
  public native int trackSingleFace2(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.YTFace.cluster.FaceCluster
 * JD-Core Version:    0.7.0.1
 */